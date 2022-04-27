package edu.matc.controller;

import edu.matc.entity.Branch;
import edu.matc.entity.Story;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.AppenderRef;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "addBranch",
        urlPatterns = {"/addBranch"}
)
public class AddBranch extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao branchDao = new GenericDao(Branch.class);
        GenericDao storyDao = new GenericDao(Story.class);
        HttpSession session = request.getSession();
        Story story = (Story) session.getAttribute("currentStory");
        Branch precedingBranch = (Branch) session.getAttribute("precedingBranch");

        Branch branch = new Branch(
                request.getParameter("branchText"),
                request.getParameter("branchDescription"),
                story);

        int newBranchId = branchDao.insert(branch);

        logger.debug("new branch id: " + newBranchId);

        if (precedingBranch != null) {
            precedingBranch.addChoiceId(Integer.toString(newBranchId));
            branchDao.saveOrUpdate(precedingBranch);
            logger.debug("preceding branch id: " + precedingBranch.getId());
        }


        Branch insertedBranch = (Branch) branchDao.getById(newBranchId);

        story.addBranch(insertedBranch);

        storyDao.saveOrUpdate(story);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/chooseProgression.jsp");
        dispatcher.forward(request, response);

    }
}
