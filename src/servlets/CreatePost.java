package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import beans.User;
import utils.UserUtils;

public class CreatePost extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		Post myPost = new Post();
		
		// set content
		myPost.setContent(request.getParameter("content"));
		
		// set author
		User myUser = new User();
		UserUtils myUserUtils = new UserUtils();
		myUser.setPseudo(myUserUtils.getUser(request));
		
		myPost.setAuthor(myUser);
		
		// set date
		Date date = new Date();
		myPost.setDatePublished(date); 
		
		request.setAttribute("post", myPost);
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
	}
}
