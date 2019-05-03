
<!DOCTYPE html>
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
       <div>
            <form method="post" action="createDiscussion">
                <fieldset>
                    <legend>Titre de votre discussion</legend>
    
                    <label for="title">Titre<span class="requis"></span></label>
                    <input type="text" id="title" name="title" size="20" maxlength="20" />
                    <br />
               </fieldset>
               <input type="hidden" name="topic_id" value="<%= request.getParameter("topic_id") %>" />
               <input type="submit" value="Creer votre discussion" class="bouton1" />
            </form>
        </div>
	</div>
	</div>
	</div>
<div id="footer">
  <p>Copyright &copy; 1850 &ndash; 2019 Sixpence. All rights reserved. </p>
  <p> Design by <a href="https://fr.linkedin.com/in/marc-bariller" title="SimplyGold">Marc Bariller</a></p>
</div>
</body>
</html>