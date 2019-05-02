package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayDiscussions extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{			
		request.setAttribute("title", request.getParameter("title"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayDiscussions.jsp").forward(request, response);
	}
}

