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
import managers.PostDbManager;
import utils.UserUtils;

public class CreatePost extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			Post myPost = new Post();
				
			// set content
			myPost.setContent(request.getParameter("content"));
				
			// set author
			User myUser = new User();
			UserUtils myUserUtils = new UserUtils();
			myUser.setPseudo(myUserUtils.getUser(request));
				
			myPost.setAuthor(myUser);
				
			// set date
			myPost.setDatePublished(new Date());
			myPost.setDiscussionId(Integer.valueOf(request.getParameter("discussion_id")));
			
			PostDbManager manager = new PostDbManager();
			
			manager.dbCreate(myPost);
			
			request.setAttribute(Post.ATTR_NAME, manager.dbLoadFromDiscussion(myPost.getDiscussionId()));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
		}
}
