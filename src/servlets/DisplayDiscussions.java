package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayDiscussions extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		List<String> myList= new ArrayList<String>();
		
		myList.add("WordPress c tro b1en");
		myList.add("Les serveurs DHCP");
		myList.add("I <3 JS");
		
		request.setAttribute("listDiscussion", myList);
		request.setAttribute("title", request.getParameter("title"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/displayDiscussions.jsp").forward(request, response);
	}
}

