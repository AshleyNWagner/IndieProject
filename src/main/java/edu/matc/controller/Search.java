package edu.matc.controller;

import edu.matc.entity.Story;
//import edu.matc.entity.StoryTag;
import edu.matc.entity.Tag;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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
        GenericDao storyDao = new GenericDao(Story.class);
        GenericDao tagDao = new GenericDao(Tag.class);
        Set<Story> searchedStoriesByTag = new HashSet<>();
        Set<Story> searchedStoriesByUser = new HashSet<>();
        Set<Story> currentUserStories;
        Set<Story> currentTagStories;


        request.setAttribute("searchTerm", request.getParameter("searchTerm"));

        List<Story> searchedStoriesByTitle = storyDao.getByPropertyLike("title", request.getParameter("searchTerm"));
        List<Tag> tags =  tagDao.getByPropertyLike("tag", request.getParameter("searchTerm"));
        List<User> users =  userDao.getByPropertyLike("userName", request.getParameter("searchTerm"));

        for(User user : users) {
            currentUserStories = user.getStories();
            for (Story storyByUser : currentUserStories) {
                searchedStoriesByUser.add(storyByUser);
            }
        }

        for(Tag tag : tags) {
            currentTagStories = tag.getStories();
            for (Story storyByTag : currentTagStories) {
                searchedStoriesByTag.add(storyByTag);
            }
;        }

        request.setAttribute("searchedStoriesByUser", searchedStoriesByUser);
        request.setAttribute("searchedStoriesByTitle", searchedStoriesByTitle);
        request.setAttribute("searchedStoriesByTag", searchedStoriesByTag);

        RequestDispatcher dispatcher = request.getRequestDispatcher(("/searchResults.jsp"));
        dispatcher.forward(request, response);
    }


}
