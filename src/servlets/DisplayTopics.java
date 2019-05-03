package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;
import managers.TopicDbManager;

public class DisplayTopics extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{	
		List<Topic> topics = new TopicDbManager().queryAll();
		
		request.setAttribute(Topic.ATTR_NAME, topics);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayTopics.jsp").forward(request, response);
	}
}
