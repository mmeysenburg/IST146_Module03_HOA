# IST146_Module03_HOA

In this module's HOA, you will add some functionality to the BookStore class example. 

To complete this HOA, look for the "TODO" comments and complete the indicated methods in the `BookStore.java` file.

## Instructions

1. Log on to your replit account. 
2. Click the "+ New repl" button to create a new repl. 
3. Click on the "Import from GitHub" tab. 
4. Type or paste the following URL into the "Paste any repository URL" text field: github.com/mmeysenburg/IST146_Module03_HOA
5. Click on the "Import from github" button.
6. Click the "Done" button in the ".replit" dialog that appears.
7. THIS IS DIFFERENT: in the terminal area, execute this command: `mv replit .replit`. Executing this will set the classpath to allow
the program to read a JSON file.
8. Select the "BookStore.java" file. Search for the keyword "TODO", and write the specified code.
9. At any time you can run the code from the user's perspective, or, from a developer's point of view, execute the unit tests that have been provided.
    * To run the code, click the "Run" button.
    * To execute the unit tests, enter the following command in the "Console" tab: bash test.sh
10. Once you have completed the code correctly, the unit tests should pass, and running the code should produce results that make sense.
11. When you are finished, submit your BookStore.java file via the HOA 3 Canvas assignment.


## Files in the repository

* `jars`: Directory containing extra files needed to parse JSON files
* `Book.java`: Class encapsulating a single Book in the BookStore
* `BookStore.java`: Class encapsulating the BookStore; this is the only file you should modify
* `BookStoreTest.java`: JUnit4 unit tests for the `BookStore` class. These tests are executed when you enter the `bash test.sh`
command.
* `LICENSE`: GNU General Public License v3.0 for these materials.
* `Main.java`: Main program to run the code from a user's perspective. This file's `main()` method is invoked when you click the "Run" button.
* `replit`: File with code to enable the Run button in this project.
* `README.md`: This README file.
* `test.sh`: Bash script to execute the JUnit4 unit tests in `BookStoreTest.java`.

