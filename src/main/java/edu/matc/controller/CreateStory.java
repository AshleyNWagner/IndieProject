package edu.matc.controller;

import edu.matc.entity.Story;
import edu.matc.entity.Tag;
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
import java.util.*;

@WebServlet(
        name = "createStory",
        urlPatterns = {"/createStory"}
)
public class CreateStory extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao storyDao = new GenericDao(Story.class);
        GenericDao tagDao = new GenericDao(Tag.class);
        GenericDao userDao = new GenericDao(User.class);
        User user = new User("Fake", "Person", "fakeperson", "fakeperson@gmai.com");
        int userId = userDao.insert(user);

        String tagString = request.getParameter("tags");
        List<String> tagDescriptions = new ArrayList<>(Arrays.asList(tagString.split("\\s+|,\\s+")));


//        https://www.geeksforgeeks.org/initializing-hashset-java/
//        https://www.regextester.com/115759

        User insertedUser = (User) userDao.getById(userId);

        request.setAttribute("user", insertedUser);

        Story story = new Story(request.getParameter("title"),
                request.getParameter("description"), insertedUser);

        for (String tagDescription : tagDescriptions) {
            Tag tag = new Tag(tagDescription);
            int tagId = tagDao.insert(tag);
            story.addTag(tag);
        }

        int storyId = storyDao.insert(story);

      // TODO store user info in login servlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/addBranch.jsp");
        dispatcher.forward(request, response);

    }

}
