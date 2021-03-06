package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Discussion;
import beans.Post;
import beans.Status;
import beans.Topic;
import beans.User;
import managers.TopicDbManager;
import managers.UserDbManager;
import utils.UserUtils;

public class SignIn extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexionInscription.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
				User myUser = new User(request.getParameter("pseudo"), request.getParameter("email"), request.getParameter("password"), false);
				new UserDbManager().dbCreate(myUser);
				
				Cookie myCookie = new Cookie(User.COOKIE, String.valueOf(myUser.getId()));

				response.addCookie(myCookie);
				new UserDbManager().dbCreate(myUser);
				
				List<Topic> topics = new TopicDbManager().queryAll();
				
				request.setAttribute(Topic.ATTR_NAME, topics);
				this.getServletContext().getRequestDispatcher("/WEB-INF/displayTopics.jsp").forward(request, response);
			}
}
