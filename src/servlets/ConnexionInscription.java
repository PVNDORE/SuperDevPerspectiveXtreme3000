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

public class ConnexionInscription extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexionInscription.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				Discussion myDiscussion = new Discussion();
								
				request.setAttribute("discussion", myDiscussion);
				this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
			}
}
