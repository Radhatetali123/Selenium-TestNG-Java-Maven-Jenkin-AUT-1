# 1. Create a project called Selenium_TestNG_Java_Maven_Jenkins_AUT in intellij
Then search for dependencies and add in pom.xml

# 2.Goto Intellij IDEA preferences ,search (command+,)
   Search for plugins.
   Install the plugin "Create TestNG XML" and Apply the changes.
   Click OK on the confirmation dialog

# 3. Download the jar files 
Add them in intellij via File ->Project Structure->Modules.
Click the Dependencies Tab.
Click the plus +.
Add all the extracted jars from the zip you downloaded including those inside and outside the lib folder.
Select them all and Apply
If Issue persist Intellij > File ->Invalidate Caches/Restart And Build your project

# 4.Information about project
In this project we are using  websites for singup
and different testcases for valid and invalid logins
like adding an new user to the website
also create multiple users ,updating and deleting the users from the website
here we are using the json file to read the data


# 5.Create the json files in a seperate folder called resources
 Here we use the .json file to get the data instead of using data provider
 If we are using any other plugins then we can download the dependencies 
 For download depencendies we can search here: "https://mvnrepository.com/".
 
# 5.Execution
Right-click on the java file, and select run as given file
Other way is to open Terminal / command prompt and write command
Run once
mvn clean install

# Maven commands
mvn clean install --it cleans the maven project by deleting the target directory

        Execute below multiple time    
        mvn clean compile test

mvn compile  --compile the source code of the project.
mvn install --build the maven project and install the package files.

# 6  Build step --If Issue persist Intellij > File ->Invalidate Caches/Restart And Build your project
Menu Build> Build Project

#7 Here we are using two websites for sing up
 url 1 :"https://www.saucedemo.com/"
 url 2: "https://login.mailchimp.com/signup/"

# 8 Chrome driver setup path 
Chrome driver link :"C:\\software\\chromedriver_win32 (3)\\chromedriver.exe"
 Project link to understand:
"C:\software\seleniumproject\Selenium_TestNG_Java_Maven_Jenkins_AUT"

# 9  Websites to understand about the selenium project 
https://www.tutorialspoint.com/selenium/selenium_webdriver.htm

