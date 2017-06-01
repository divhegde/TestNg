# Appium Sample Tests for AWS Device Farm Sample App
This is a collection of example Appium TestNG tests written for the AWS Device Farm [Android](https://github.com/awslabs/aws-device-farm-sample-app-for-android) sample app. Please use these tests as a reference for your own AWS Device Farm Appium TestNG tests.

**This test suite uses the [Appium page model](http://appium.io/slate/en/tutorial/android?java#page-object-pattern) in order to separate the tests from the logic.**

# Android
## Getting Started
1. Follow the **[official Appium getting started guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium)** and install the Appium server and dependencies. 

	**AWS Device Farm supports Appium version 1.4.10. Using a different version locally may cause unexpected results when running Appium tests on AWS Device Farm.**
2. In order to use 1.4.10, download Appium through NPM with this command: 
	```
	npm install -g appium@1.4.10
	```
3. Verify that you have Appium installed with this command: 
	```
	appium -v
	```
   You should get "1.4.10" as the output

## Creating a new Java Appium Test Project Using Maven
1. Create a new Maven project using a Java IDE. **The example in this tutorial is for [IntelliJ IDEA Community Edition](http://www.jetbrains.com/idea/download/)**.

2. Set up your POM file using the official AWS Device Farm documentation for [TestNG](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html)
	- You will need the following dependencies in your POM file
		
        ```
	    <dependencies>
    	    <dependency>
        	    <groupId>org.testng</groupId>
            	<artifactId>testng</artifactId>
	            <version>6.8.8</version>
    	        <scope>test</scope>
        	</dependency>
	        <dependency>
    	        <groupId>io.appium</groupId>
        	    <artifactId>java-client</artifactId>
            	<version>3.1.0</version>
	        </dependency>
    	</dependencies>
        ```
	
### Running Your Tests Locally
First, make sure that you have followed all the steps in the [Appium getting started guide](http://appium.io/slate/en/tutorial/android.html?java#getting-started-with-appium). 

Use the script [start-appium-android.sh](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/start-appium-android.sh) to run the Appium server locally. Once the server has started, run the TestNG tests within your IDE.

For example, if your package name is **com.appium.example**, your main activity name is **.Activities.MainActivity**, and the absolute filepath to your APK is **~/Desktop/appium/app.apk**, you would run the following command.

```
appium --pre-launch --app-pkg com.appium.example --app-activity .Activities.MainActivity --platform-name Android --app ~/Desktop/appium/app.apk
```

### Running Your Tests on AWS Device Farm
#### Step 1: Verify the Project Set-up
First Read the [Device Farm documentation](http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-calabash.html). Ensure that all the steps are completed and that your project and POM file are set up correctly. 

#### Step 2: Go into your Maven Appium Directory
Go into your Appium Maven project directory in the terminal or command prompt.

#### Step 3: Package the Test Content
Run the following Maven command to package the test content.
```
mvn clean package -DskipTests=true
```
#### Step 4: Locate the zip-with-dependencies.zip file
Once the Maven command above is finished it will produce a "zip-with-dependencies.zip" file in your target folder. You will upload this file when [creating a run](http://docs.aws.amazon.com/devicefarm/latest/developerguide/how-to-create-test-run.html) on AWS Device Farm.

## Tips and Tricks
#### Driver Configuration
Remember to set up your Appium driver correctly. AWS Device Farm takes care of the configuration for you, and you don't need to set any of the DesiredCapabilities when creating the driver. Refer to **[this example](https://github.com/awslabs/aws-device-farm-appium-tests-for-sample-app/blob/master/src/test/java/Tests/AbstractBaseTests/TestBase.java#L75)**.
