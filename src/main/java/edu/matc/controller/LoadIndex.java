package edu.matc.controller;

import edu.matc.entity.Story;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//https://stackoverflow.com/questions/15839854/how-load-servlet-on-index-jsp
//https://stackoverflow.com/questions/31579716/load-on-start-up-throwing-404?rq=1

@WebServlet(
        name = "loadIndex",
        urlPatterns = {"/loadIndex"}
)
public class LoadIndex extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao storyDao = new GenericDao(Story.class);
        List<Story> recentStories = storyDao.getAll();

        request.setAttribute("recentStories", recentStories);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
}
