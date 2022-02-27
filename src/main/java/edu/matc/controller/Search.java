package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that executes search from the nav.
 */
@WebServlet(
        name = "search",
        urlPatterns = {"/search"}
)
public class Search extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);

        HttpSession session = request.getSession();

        session.setAttribute("searchTerm", request.getParameter("searchTerm"));

        request.setAttribute("users", userDao.getByPropertyLike("userName", request.getParameter("searchTerm")));

        RequestDispatcher dispatcher = request.getRequestDispatcher(("/searchResults.jsp"));
        dispatcher.forward(request, response);
    }

}
