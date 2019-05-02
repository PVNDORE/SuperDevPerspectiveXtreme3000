package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class UserUtils 
{
	public String getUser(HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) 
		{
			if (cookies[i].getName() == "userConnected") 
			{
				return (String)cookies[i].getValue();
			}
		}
		return "";
	}
}
