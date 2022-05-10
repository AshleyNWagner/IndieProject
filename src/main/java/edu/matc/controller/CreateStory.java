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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "createStory",
        urlPatterns = {"/createStory"}
)
public class CreateStory extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao storyDao = new GenericDao(Story.class);
        GenericDao tagDao = new GenericDao(Tag.class);
        GenericDao userDao = new GenericDao(User.class);

        // TODO change this
        User user = new User("firstName", "lastName", "userName", "email");

//        if (session.getAttribute("currentUser") == null) {
//            response.sendRedirect("/logIn");
//        } else {
//            user = (User) session.getAttribute("currentUser");
//        }

        int userId = userDao.insert(user);
        User insertedUser = (User) userDao.getById(userId);
        Story story = new Story(request.getParameter("title"), request.getParameter("description"), insertedUser);
        insertedUser.addStory(story);

        String tagString = request.getParameter("tags");
        List<String> tagDescriptions = new ArrayList<>(Arrays.asList(tagString.split(",\\s+")));
       // List<String> tagDescriptions = new ArrayList<>(Arrays.asList(tagString.split("\\s+|,\\s+")));
//        https://www.geeksforgeeks.org/initializing-hashset-java/
//        https://www.regextester.com/115759

        for (String tagDescription : tagDescriptions) {
            Tag tag = new Tag(tagDescription);
            int tagId = tagDao.insert(tag);
            Tag insertedTag = (Tag) tagDao.getById(tagId);
            story.addTag(insertedTag);
        }

        int storyId = storyDao.insert(story);
        Story insertedStory = (Story) storyDao.getById(storyId);

        storyDao.saveOrUpdate(insertedStory);

        session.setAttribute("currentStory", insertedStory);
      // TODO store user info in login servlet and use instead of placeholder
      // TODO Add page in between that asks if continuing or creating new, link in nav
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addBranch.jsp");
        dispatcher.forward(request, response);

    }

}
