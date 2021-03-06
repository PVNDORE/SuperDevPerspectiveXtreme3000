<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="managers.TopicDbManager"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>DevPerspective</title>
<meta http-equiv="content-language" content="en-us" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="author" content="Author Name Goes Here" />
<meta name="design" content="Sadhana Ganapathiraju" />
<meta name="copyright" content="Copyright Goes Here" />
<meta name="description" content="Description Goes Here" />
<meta name="keywords" content="And, Finally, Keywords Go Here." />
<link rel="start" title="Home" href="http://www.sixpence.com/" />
<link rel="stylesheet" type="text/css" media="screen" href="inc/css/screen.css" />
<!--[if lt ie 7]><link rel="stylesheet" type="text/css" media="screen" href="ie-win.css" /><![endif]-->
</head>
<body id="babout">
<div id="header">
  <div style="display:inline-block;"><a href="displayTopics"><h1>DevPerspective</h1></a></div>
  <div style="display:inline-block;"><a href="logInSignIn" class="bouton1">Log in / Sign in</a></div>
</div>
<div id="wrapper">
  <div id="content-wrapper">
    <div id="content">
	    <h4><a href="displayTopics" ><c:out value="Topics" /></a> : <a href="displayDiscussions?topic_id=${param.topic_id}" ><c:out value="Discussion" /></a> : ${title} </h4>
	      <c:forEach var="post" items="${post}">
	      	<dl>
	      		<dt><c:out value="${post.author.pseudo}" />
	      			<br> <c:out value="${post.datePublished}" /></dt>
	        	<dd><c:out value="${post.content}" /></dd>
	     	</dl>
		</c:forEach>
		<div>
            <form method="post" action="createPost" style="visibility:${formVisibility}">
                <fieldset>
                    <legend>Contenu de votre post</legend>
    
                    <label for="content"><span class="requis"></span></label>
                    <textarea id="content" name="content" style="width:98%;height:100px;"></textarea>
                    <br />
               </fieldset>
               <input type="hidden" name="discussion_id" value="<%= request.getParameter("discussion_id") %>" />
               <input type="submit" value="Creer votre post" class="bouton1" />
            </form>
        </div>
	</div>
</div>
</div>
<div id="footer">
  <p>Copyright &copy; 1850 &ndash; 2019 DevPerspective. All rights reserved. </p>
  <p> Design by <a href="https://fr.linkedin.com/in/marc-bariller" title="SimplyGold">Marc Bariller</a></p>
</div>
</body>
</html>
