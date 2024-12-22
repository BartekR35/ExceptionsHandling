//Creating a class which implements Exception
public class ExceptionsHandling extends Exception {

    //Constructor
    public ExceptionsHandling(String message) {
        super(message);
    }
}

//Main class to execute
class Main {
    public static void main(String[] args) {
        try {
            //Simulation of the condition
            throw new ExceptionsHandling("Custom exception triggered.");
        } catch (ExceptionsHandling e) {
            //Print message for a user
            System.out.println("The custom exception occurred: " + e.getMessage());

            //Print string representation for the exception
            System.out.println(e.toString());
        }
    }
}