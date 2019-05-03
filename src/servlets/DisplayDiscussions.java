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
import managers.DiscussionDbManager;
import managers.TopicDbManager;

public class DisplayDiscussions extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		if (request.getParameter("topic_id") != null) {
			int topicId = Integer.valueOf(request.getParameter("topic_id"));
			List<Discussion> discussions = new DiscussionDbManager().dbLoadFromTopic(topicId);
			Topic topic = new TopicDbManager().dbLoad(topicId);
			
			if (topic != null) {
				request.setAttribute("title", topic.getName());
				request.setAttribute(Discussion.ATTR_NAME, discussions);

				this.getServletContext().getRequestDispatcher("/WEB-INF/displayDiscussions.jsp").forward(request, response);
			}
		} 
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
	}
}

