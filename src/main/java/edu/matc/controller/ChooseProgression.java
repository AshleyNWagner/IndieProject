package edu.matc.controller;

import edu.matc.entity.Branch;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The type Choose progression.
 */
@WebServlet(
        name = "chooseProgression",
        urlPatterns = {"/chooseProgression"}
)
public class ChooseProgression extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao branchDao = new GenericDao(Branch.class);
        HttpSession session = request.getSession();

        String precedingBranchDescription = request.getParameter("branch");
        List<Branch> branchList =  branchDao.getByPropertyEqual("branchDescription", precedingBranchDescription);
        Branch precedingBranch = branchList.get(0);


        session.setAttribute("precedingBranch", precedingBranch);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/addBranch.jsp");
        dispatcher.forward(request, response);
    }
}
