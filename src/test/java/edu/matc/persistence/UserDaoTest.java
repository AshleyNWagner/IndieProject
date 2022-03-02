package edu.matc.persistence;

import edu.matc.entity.Story;
import edu.matc.entity.User;

import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ClientInfoStatus;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for accessing User data.
 */

class UserDaoTest {
    GenericDao userDao;
    GenericDao storyDao;

    /**
     * Instantiate DAOs and reset database.
     */
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        storyDao = new GenericDao(Story.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify getById method works.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("anwagner", retrievedUser.getUserName());
    }

    /**
     * Verify getAll method works.
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(4, users.size());
    }

    /**
     * Verify insert method works.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Dennis", "Dennis", "DoubleDennis", "password5", "dennis@gmail.com");
        int newUserId = userDao.insert(newUser);

        Story newStory = new Story("New Book", "This is a new story.", newUser);
        int newStoryId = storyDao.insert(newStory);

        newUser.addStory(newStory);

        assertNotEquals(0, newUserId);
        assertNotEquals(0, newStoryId);

        User insertedUser = (User)userDao.getById(newUserId);

        assertEquals(newUser, insertedUser);
        assertEquals(insertedUser, newStory.getUser());
    }

    /**
     * Verify saveOrUpdate method works.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newUserName = "newUserName";

        User userToUpdate = (User)userDao.getById(1);
        userToUpdate.setUserName(newUserName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)userDao.getById(1);

        assertEquals(userToUpdate, retrievedUser);

    }

    /**
     * Verify delete method works.
     */
    @Test
    void deleteSuccess() {
        User user = (User)userDao.getById(1);
        userDao.delete(user);

        assertNull(userDao.getById(1));
    }

    /**
     * Verify getPropertyByLike method works.
     */
    @Test
    void getPropertyByLikeSuccess() {
        List<User> users = (List<User>)userDao.getByPropertyLike("userName", "er");
        assertEquals(3, users.size());
    }

    /**
     * Verify getPropertyByEqual method works.
     */
    @Test
    void getPropertyByEqualSuccess() {
        List<User> users = (List<User>)userDao.getByPropertyEqual("userName", "anwagner");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }


}
