# Article-Summarizer
Set Up:
1. Copy this link - https://github.com/myang97/Article-Summarizer.git
2. Open up Android Studio
3. Go to Files -> New -> Project from Version Control -> Github
4. Sign in with your Github Account/Create Master Password
5. Paste the link copied from step 1 onto the "Git Repository URL"
6. Click "Clone" and update all errors if need be
7. On the left side of Android Studio, make sure that the option is on "Project" and not on "Android"
8. Once under the "Project" option, select the folder you named the Article-Summarizer project
9. app -> src -> main -> java -> MainActivity is the java file I created
10. app -> src -> main -> res -> layout -> activity_main.xml is the xml file I created
11. The APK for this project is in the Github repository: app -> build -> outputs -> apk

Instructions for App:
-Input the URL that the app will summarize
-Input the amount of sentences the app will summarize the URL link's content into
-Push the Summarize button to obtain a working link to the article and textview of the summary of the article
-Push reset to empty all of the textviews and edittexts

App Abilities/Bonuses:
-Uses an online API, Intellexer, to do the summarizations (http://esapi.intellexer.com/Home/Help).
-Bonus from the API: summarizes the content with an amount of sentences set as a constant, I edited the API call so that the user can decide how many sentences the API summarizes the content down to.
-Created a SharedPreference in order to save and restore the data whenever the orientation of the app changes or when the back button on the android is pushed

Future Changes:
-Add tags after obtaining the article
-Add information regarding the author and date published


![](/Screenshots/Reset and Initial Screen.jpg?raw=true =20X10)
![](/Screenshots/URL Link and Summary Screen.jpg?raw=true =20X10)

