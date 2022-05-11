package edu.matc.controller;

import edu.matc.entity.Branch;
import edu.matc.entity.Story;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "readStory",
        urlPatterns = {"/readStory"}
)
public class ReadStory extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao<Branch> branchDao = new GenericDao<>(Branch.class);
        GenericDao<Story> storyDao = new GenericDao<>(Story.class);
        List<Branch> storyBranches;
        Story currentRead = null;
        Branch selectedBranch = null;
        Map<String, String> choiceMap = new HashMap<>();



        if (request.getParameter("searchResultsSubmit") != null) {
            String storyId = request.getParameter("searchResultsSubmit");
            currentRead = storyDao.getById(Integer.parseInt(storyId));
            session.setAttribute("currentRead", currentRead);
        } else if (request.getParameter("indexSubmit") != null) {
            String storyId = request.getParameter("indexSubmit");
            currentRead = storyDao.getById(Integer.parseInt(storyId));
            session.setAttribute("currentRead", currentRead);
        }


        currentRead = (Story) session.getAttribute("currentRead");
        storyBranches = (List<Branch>) currentRead.getBranches();


        if (request.getParameter("branchChoiceSubmit") == null) {
            selectedBranch = storyBranches.get(0);
        } else {
            selectedBranch = branchDao.getById(Integer.parseInt(request.getParameter("branchChoiceSubmit")));
        }

        List<String> choiceIds = new ArrayList<>(Arrays.asList(selectedBranch.getChoiceIds().split("&")));

        if (!choiceIds.get(0).equals("")) {
            for (String choiceId : choiceIds) {
                Branch branchChoice = branchDao.getById(Integer.parseInt(choiceId));
                choiceMap.put(choiceId, branchChoice.getBranchDescription());
            }
        }
//        else {
//            request.getRequestDispatcher("endStory.jsp").forward(request, response);
//        }

        request.setAttribute("selectedBranch", selectedBranch);
        request.setAttribute("choiceIdMap", choiceMap);



        RequestDispatcher dispatcher = request.getRequestDispatcher("/readStory.jsp");
        dispatcher.forward(request, response);

    }
}

