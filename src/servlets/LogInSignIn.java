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
import managers.UserDbManager;
import utils.UserUtils;

public class LogInSignIn extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/logInSignIn.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				User myUser = new User();
				
				UserDbManager myUserDbManager = new UserDbManager();
				myUser = myUserDbManager.dbLoadFromAuth(request.getParameter("email"), request.getParameter("password"));
				
				Cookie myCookie = new Cookie("userConnected", myUser.getPseudo());
				response.addCookie(myCookie);
								
				request.setAttribute("user", myUser);
				this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
			}
}
