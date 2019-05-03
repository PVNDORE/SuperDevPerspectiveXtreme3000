package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Post;
import beans.Status;
import beans.User;
import managers.DiscussionDbManager;
import managers.PostDbManager;
import managers.StatusDbManager;
import utils.UserUtils;

public class CreateDiscussion extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/createDiscussion.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Discussion myDiscussion = new Discussion();
		DiscussionDbManager manager = new DiscussionDbManager();

		myDiscussion.setTitle(request.getParameter("title"));
		myDiscussion.setTopicId(Integer.valueOf(request.getParameter("topic_id")));
		myDiscussion.setStatus(new StatusDbManager().dbLoadPending());
		
		manager.dbCreate(myDiscussion);
		
		request.setAttribute(Post.ATTR_NAME, new PostDbManager().dbLoadFromDiscussion(myDiscussion.getId()));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp?discussion_id=" + myDiscussion.getId()).forward(request, response);
	}
}
