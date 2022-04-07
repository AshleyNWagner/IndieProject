package edu.matc.controller;

import edu.matc.entity.Story;
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
import java.util.StringTokenizer;

@WebServlet(
        name = "createStory",
        urlPatterns = {"/createStory"}
)
public class CreateStory extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        int id;
        GenericDao storyDao = new GenericDao(Story.class);
        User user = null;

        String tagString = request.getParameter("tags");
        StringTokenizer tokenizer = new StringTokenizer(tagString, ", ");

        Story story = new Story(request.getParameter("title"),
                request.getParameter("description")),

//        https://www.baeldung.com/java-stringtokenizer

      // TODO store user info in login servlet
      //
    }

}
