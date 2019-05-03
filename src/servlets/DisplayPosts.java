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
import managers.StatusDbManager;
import utils.UserUtils;
import managers.DiscussionDbManager;;

public class DisplayPosts extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Integer discussionId = null;
		
		if (request.getParameter("discussion_id") != null) {
			discussionId = Integer.parseInt(request.getParameter("discussion_id"));
		} else if (request.getAttribute(Post.ATTR_NAME) != null) {
			discussionId = ((Post) request.getAttribute(Post.ATTR_NAME)).getDiscussionId();
		}
		
		if (discussionId != null) {
			String visibility;
			List<Post> posts= new PostDbManager().dbLoadFromDiscussion(discussionId);
			Discussion discussion = new DiscussionDbManager().dbLoad(discussionId);
			
			if (discussion != null) {
				if (discussion.getStatus().getName().equals(StatusDbManager.OPEN) && UserUtils.getUser(request) != null) {
					visibility = "visible";
				} else {
					visibility = "hidden";
				}
				
				request.setAttribute("formVisibility", visibility);
				request.setAttribute(Post.ATTR_NAME, posts);
				request.setAttribute("title", discussion.getTitle());
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
	}
}
