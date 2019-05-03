package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import managers.DiscussionDbManager;

public class DisplayDiscussions extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		List<Discussion> discussions = new DiscussionDbManager().dbLoadFromTopic(0);
		
		request.setAttribute(Discussion.ATTR_NAME, discussions);
		request.setAttribute("title", request.getParameter("title"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayDiscussions.jsp").forward(request, response);
	}
}

