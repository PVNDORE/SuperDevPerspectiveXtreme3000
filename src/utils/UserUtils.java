package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import beans.User;
import managers.UserDbManager;

public class UserUtils 
{
	public static User getUser(HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();

		for (int i = 0; i < cookies.length; i++) 
		{
			if (cookies[i].getName() == User.COOKIE) 
			{
				return new UserDbManager().dbLoad(Integer.valueOf(cookies[i].getValue()));
			}
		}
		return null;
	}
}
