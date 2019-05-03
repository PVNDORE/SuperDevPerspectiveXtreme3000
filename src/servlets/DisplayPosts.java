package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Post;
import managers.PostDbManager;
import managers.DiscussionDbManager;;

public class DisplayPosts extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		int discussionId;
		
		if (request.getParameter("discussion_id") != null) {
			discussionId = Integer.parseInt(request.getParameter("discussion_id"));
		} else if (request.getAttribute(Post.ATTR_NAME) != null) {
			discussionId = ((Post) request.getAttribute(Post.ATTR_NAME)).getDiscussionId();
		} else {
			return;
		}
		
		List<Post> posts= new PostDbManager().dbLoadFromDiscussion(discussionId);
		Discussion discussion = new DiscussionDbManager().dbLoad(discussionId);
		
		if (discussion != null) {
			request.setAttribute(Post.ATTR_NAME, posts);
			request.setAttribute("title", discussion.getTitle());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
		}
	}
}
