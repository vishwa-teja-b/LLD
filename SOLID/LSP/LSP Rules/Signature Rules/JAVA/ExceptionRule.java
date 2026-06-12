// package LSP Rules.Signature Rules.JAVA;

/**
 *  EXCEPTION RULE : 
 * A CHILD / SUBCLASS SHOULD THROW SAME OR NARROW EXCEPTIONS THAN THE PARENT.
 * JAVA ENFORCES THIS ONLY FOR CHECKED EXCEPTIONS
 */


/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent of the two “…OutOfBounds” above
*/

class Parent{
    public void m1() throws RuntimeException{
        throw new RuntimeException("ERROR IN PARENT METHOD.");
    }
}

class Child extends Parent{
    @Override
    public void m1() throws NullPointerException{
        throw new NullPointerException("Error in child");
        // throw new Exception("CHILD ERROR");
    }
}

class Client{
    private Parent p;

    public Client(Parent p){
        this.p = p;
    }

    public void execute(){
        try{
            p.m1();
        }
        catch(RuntimeException e){
            System.out.println("RUNTIME EXCEPTION OCCURRED : "+ e.getMessage());
        }
    }
}

public class ExceptionRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        Client client = new Client(child);
        client.execute();
    }
}
