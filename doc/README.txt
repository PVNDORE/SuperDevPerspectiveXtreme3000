Groupe : Jeremy Coley - Marc Barilier - Mattéo Moisant - Jeremy Diot
For making the app works, export the database from doc folder, update the DbFactory file (the default constructor to match with your own configuration).
The entry point is /displayTopics (as the other pages require related id fields, it's redirecting into 404 error page) or /logInSignIn.