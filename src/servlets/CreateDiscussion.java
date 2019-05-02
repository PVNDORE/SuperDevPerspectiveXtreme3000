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
import utils.UserUtils;

public class CreateDiscussion extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Discussion myDiscussion = new Discussion();
		
		// set title
		myDiscussion.setTitle(request.getParameter("title"));
		
		// set status
		Status myStatus = new Status();
		myStatus.setName("Création");
		myDiscussion.setStatut(myStatus);
		
		request.setAttribute("discussion", myDiscussion);
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
	}
}
