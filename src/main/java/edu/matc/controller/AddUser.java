package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;
import java.io.IOException;

/**
 * Servlet that adds a new user to the database.
 */
@WebServlet(
        name = "addUser",
        urlPatterns = {"/addUser"}
)
public class AddUser extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        GenericDao userDao = new GenericDao(User.class);
        User user = new User(request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("userName"),
                request.getParameter("password"),
                request.getParameter("email"));

        id = userDao.insert(user);

        if (id != 0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

    }


}
