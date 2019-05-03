package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Topic;
import beans.User;
import managers.DiscussionDbManager;
import managers.StatusDbManager;
import managers.TopicDbManager;
import utils.UserUtils;

public class DisplayDiscussions extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		if (request.getParameter("topic_id") != null) {
			String visibility;
			List<Discussion> discussions;
			DiscussionDbManager manager = new DiscussionDbManager();
			int topicId = Integer.valueOf(request.getParameter("topic_id"));
			User user = UserUtils.getUser(request);
						
			if (user != null && user.isAdmin()) {
				discussions = manager.dbLoadFromTopic(topicId);
				visibility = "visible";
			} else {
				discussions = manager.dbLoadPublic();
				visibility = "hidden";
			}
	
			Topic topic = new TopicDbManager().dbLoad(topicId);
			
			if (topic != null) {
				request.setAttribute("title", topic.getName());
				request.setAttribute("linkVisibility", visibility);
				request.setAttribute(Discussion.ATTR_NAME, discussions);
				request.setAttribute("topicId", topicId);

				this.getServletContext().getRequestDispatcher("/WEB-INF/displayDiscussions.jsp").forward(request, response);
			}
			
			if (request.getParameter("validate") != null) {
				Discussion discussion = manager.dbLoad(Integer.valueOf((String) request.getParameter("discussion_id")));
				
				discussion.setStatus(new StatusDbManager().dbLoadOpen());
				manager.dbUpdate(discussion);
			}
		} 
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
	}
}

