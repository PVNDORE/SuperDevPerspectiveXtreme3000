
<!DOCTYPE html ">
<html>
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
  <h1>DevPerspective</h1>
</div>
<div id="wrapper">
  <div id="content-wrapper">
    <div id="content">
      <h4>${title} <a href="createDiscussion" class="bouton1">+</a></h4>
      <c:forEach var="item" items="${discussion}">
      	<dl>
        	<a href="displayPosts?discussion_id=${item.id}" ><c:out value="${item.title}" /></a>
     	</dl>
	  </c:forEach>
    </div>
  </div>
  </div>
<div id="footer">
  <p>Copyright &copy; 1850 &ndash; 2019 Sixpence. All rights reserved. </p>
  <p> Design by <a href="http://www.nikhedonia.com/" title="SimplyGold">Marc Bariller</a></p>
</div>
</body>
</html>

