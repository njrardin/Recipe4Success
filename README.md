# Recipe4Success
Desktop Application of Recipe4Success
IT326 Software Development Project
Hello, friends!

## Project Information

This application, temporarily codenamed "Recipe4Success," is a recipe and meal plan management application which will allow users to enter or download recipes, edit their steps and ingredients, tag them with useful categories, and place them in comprehensive meal plans. These meal plans can then be used to generate grocery lists and allow users to always know exactly what they plan to eat, when they plan to eat it, and what ingredients they need to buy to make the recipe's in their recipe book.

### Development Mission

This project is currently being developed as a part of our IT326 course at Illinois State University with the mission of receiving an A in the course, but is being developed with the intention of being a useful application in its own right past the class that inspired it. Our mission is to create an app that is useful to anyone, but especially students with busy lives and a desire to save time planning and making their tasty meals.

### Team Members

Nate Rardin, Josh Nepomuceno, Shu Liao, Alex Smith, and Zach Plattner

### Repository Branch Info

> *"Branch early and branch often"* - some person


main - the main production branch of the application. 
**Do not commit directly to this branch.**

development - the branch used to develop between full iterations of the project. **Do not commit directly to this branch.**

all other branches - should branch once per feature and have one branch per new feature. Only work on the feature listed in its associated branch.

---

## System Enviornment Information:

Recipe4Success is a desktop app being built using Java with a GUI provided through the Java Swing package included in the JDK. Testing is being done via Unit Tests with Junit conducted through the Maven tool. Furthermore, Maven is being used for library/dependency management and packaging.

### Software Versions

Java: 17.0.2
Maven: 3.8.5

### Download/Set-up guides:

#### For Java

1) Download JDK version 17.0.2: 
    - Download: https://www.oracle.com/java/technologies/downloads/

2) Make sure your IDE has all system path info set correctly

    - For VScode: Follow this guide 
        - https://code.visualstudio.com/docs/languages/java

### For Maven

1) Read this guide. **ONLY** do the installation steps, but be sure to read the whole guide for understanding.

    - Maven in 5 min: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

2) Download any necessary Maven tools for your IDE
   
    - For VScode: Read this guide: 
        - https://code.visualstudio.com/docs/java/java-build

3) Test that your Maven installation works

    - Run `mvn -v` on the commandline to verify installation

    - Create a temporary directory and test that Maven and the Java Extension Pack tools work correctly. This is where you should generate a project using `maven-archetype-quickstart` and try `mvn package` in its root directory as instructed in the above guides. If packaging causes no errors & the sample unit test AppTest.java works, you did it correctly. (Reference Maven documentation and VSCode documentation to sort out errors).

    - Finally, run `mvn package` in the `recipe4success` root directory of this repository. If everything was setup correctly, it should package with no errors.

### Directory Structure

The top level directory of the repository consists of the .gitignore, README.md, and the main project directory "recipe4success."

In the main project directory, 
- `src\main\java\it326\r4s` contains all of the source files
- `test\java\it326\r4s` contains the test files which are handled by Maven
- `pom.xml` contains all the build information