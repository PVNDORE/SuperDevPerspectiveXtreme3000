import beans.*;
import javafx.geometry.Pos;
import managers.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Launcher {
    public static void main(String[] args) {


        DiscussionDbManager discussionDbManager = new DiscussionDbManager();
        PostDbManager postDbManager = new PostDbManager();
        StatusDbManager statusDbManager = new StatusDbManager();
        TopicDbManager topicDbManager = new TopicDbManager();
        UserDbManager userDbManager = new UserDbManager();

        //User user = new User("testPseudo", "testMail", "testPassword", true);

        Discussion d = discussionDbManager.dbLoad(2);
        Status s = statusDbManager.dbLoad(2);
//        s.setName("hihihi");
//        statusDbManager.dbUpdate(s);
//        d.setTitle("aaaa");
//        d.setStatut(s);
//        d.setTopicId(3);
//        discussionDbManager.dbUpdate(d);
        Post p = postDbManager.dbLoad(1);
        User u = userDbManager.dbLoad(1);
//        u.setPseudo("aaa");
//        u.setPassword("aaa");
//        u.setEmail("aaa");
//        u.setAdmin(true);
//
//        userDbManager.dbUpdate(u);
//        p.setContent("aaa");
//        p.setAuthor(u);
//        p.setDiscussionId(2);
//        postDbManager.dbUpdate(p);
        Topic t = topicDbManager.dbLoad(1);
//        t.setName("ddd");
//        topicDbManager.dbUpdate(t);
//        //Status status1 = new Status("resolu");
//        userDbManager.dbDelete(u);
//        postDbManager.dbDelete(p);
//        discussionDbManager.dbDelete(d);
//        topicDbManager.dbDelete(t);
//        statusDbManager.dbDelete(s);

        List<Topic> topics = topicDbManager.queryAll();
        List<Discussion> discussions1 = discussionDbManager.dbLoadFromTopic(2);
        List<Discussion> discussions2 = discussionDbManager.dbLoadPending();
        List<Discussion> discussions3 = discussionDbManager.dbLoadPublic();
        List<Post> posts = postDbManager.dbLoadFromDiscussion(4);
        User u2 = userDbManager.dbLoadFromAuth("testMail", "testPassword");

        System.err.println("");
        //Topic topic = new Topic("testTopic", null);
    }

}
