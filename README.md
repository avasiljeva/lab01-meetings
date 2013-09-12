*******************************************
*** LAB 1 - Meetings Data Processing    ***
*******************************************
This is a sample project for LAB 1 in "Web Programming 2013" course.

Official lab description:
http://ante.lv/web-programming-2013/lab01-meetings-data

This instruction is a subset of more detailed instruction available at
http://ante.lv/web-programming-2013/lab-01-project-install
and contains only instructions needed to run the program.

**********************
*** Preconditions  ***
**********************
1) Project "lab01-meetings" is checked out from SVN or Git
2) JDK, Eclipse, Maven, MySQL, Redis, Ant (optionally) are installed

**************************
*** Preparation steps  ***
**************************

1) [If you are using Eclipse to work with Maven project for the first time]  
(Close Eclipse) Set M2_REPO Eclipse classpath variable by executing a command
	mvn -Declipse.workspace=<path-to-eclipse-workspace> eclipse:add-maven-repo
from project root (Open Eclipse).

2) Create project settings for Eclipse by executing a command
	mvn eclipse:eclipse 
from project root (Internet connection is required for the first time) and refresh or import project in Eclipse.

3) If there are errors in the project in Eclipse, check that classpath variable M2_REPO is set:
Window -> Preferences... -> Java -> Build Path -> Classpath Variables
If variable doesn't exist, set it to your local Maven repository location, e.g.
C:/Documents and Settings/<username>/.m2/repository

4) Create database and DB user by executing SQL commands from
\lab01-meetings\src\main\resources\init.sql

5) If you are using remote or very specific database server, open configuration file 
\lab01-meetings\src\main\resources\META-INF\persistence.xml
and modify "hibernate.connection.url" property value.

***************************
*** Executing a program ***
***************************
To execute a users data importing program run main class - lv.lu.newsfeed.UsersImportTool.
Click on the class -> Run As -> Java Application
After that 'user' table with five records should appear in MySQL database.

Note: 
When executing a program you may notice warnings in a console:
log4j:WARN No appenders could be found for logger (org.hibernate.cfg.annotations.Version).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.

That's because log4j is not configured in a system.
You can see that file \lab01-meetings\src\main\resources\log4j.properties is empty.
You task is to configure it properly.

There are also another set of console programs for creating and checking friendships in Redis database:
lv.lu.meetings.RandomFriendshipCreatingTool and lv.lu.meetings.FriendsChecker

One of your tasks is to implement lv.lu.meetings.VenueImportTool properly.

***********************
*** Run JUnit tests ***
***********************
In /src/test/java/ folder find a class lv.lu.meetings.MeetingsTestSuite.
Click on class -> Run As -> JUnit Test

The major part of tests will fail. Expected result [Runs: 8/11, Errors: 9, Failures: 0]
One of your tasks is to make them all pass successfully.

******************
*** Developing ***
******************
Now you are ready to start development.

For sure you will decide to place a project in your own Subversion or Git repository.
To delete SVN folders from the project execute Ant task:
	ant clean-svn
	
At that moment you will lose connection and synchronization with current repository!	
	
******************
*** Submission ***
******************
Preferred submission form is via version control system.

If you have problems with version control system, you have another possibility - submit a project as archived file.
To create a ready to submit artefact execute Ant task:
	ant submit
and send a file /lab01-meetings/target/lab01-meetings.zip to Alina's GMAIL.COM e-mail.

****************************
*** Problems & Questions ***
****************************
If you experience any problem or observe any strangeness or have any question,
please don't delay it, write on e-mail or ask during a lecture!

*********************
*** GOOD LUCK !!! ***
*********************
