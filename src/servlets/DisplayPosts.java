package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Post;
import managers.PostDbManager;
import managers.DiscussionDbManager;;

public class DisplayPosts extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		int idDiscussion = Integer.parseInt(request.getParameter("id"));
		
		List<Post> posts= new PostDbManager().dbLoadFromDiscussion(idDiscussion);
		
		request.setAttribute(Post.ATTR_NAME, posts);
		request.setAttribute("title", new DiscussionDbManager().dbLoad(idDiscussion).getTitle());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayPosts.jsp").forward(request, response);
	}
}
