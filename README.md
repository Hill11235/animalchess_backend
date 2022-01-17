## CS5001 Assignment 2

I have introduced some additional methods not outlined in the specification. Most of these are self explanatory getter and setters.
The largest deviation has been the inclusion of the Piece based method validSquare(). This method is used to check whether a given Square is a valid move for each type of Piece given the rules on how it's allowed to move. As a consequence, this method has an override in each subclass except for Lion.

I have also included some additional unit tests in the additionaltests subdirectory. These are to cover these introduced methods and to troubleshoot the dropPiece() method which I initally had trouble implementing. I have included the necessary hamcrest and junit jar files:
* If using an IDE add JUnit to the build path.
* Otherwise to compile `javac -cp <...>/junit.jar:<...>/hamcrest.jar:<path_to_src>:. *.java` where <...> is path to directory of classes to be tested.
* To run unit tests `java -cp <...>/junit.jar:<...>/hamcrest.jar:<path_to_src>:.
org.junit.runner.JUnitCore <junit_classes>`
