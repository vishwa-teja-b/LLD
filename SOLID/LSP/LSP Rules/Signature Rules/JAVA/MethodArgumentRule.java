// package LSP Rules.Signature Rules;

/**
 * 1. Method Argument Rule 
        ○ The overridden method in the subclass must accept the same argument types as 
        the parent, or wider (a “broader” type up the inheritance chain). 
        ○ Example: If the parent method takes a String, the child override must also take 
        String (or a supertype, e.g., Object), never an unrelated type like Integer. 
 */


        /*
            METHOD ARGUMENT RULE : 
            subtype argument types must be identical or broader
            java enforces this by ensuring identical method types/signatures during overrides. 
        */

class Parent{
    void method1(String object){
        System.out.println("PARENT METHOD RUNNING..........");
    }
}

class Child extends Parent{
    @Override
    void method1(String object){
        System.out.println("CHILD METHOD RUNNING..........");
    }

    // method overloading... the overriden method is used , this overloaded method is never used, it is used only if the client directly deals with the concrete child class

    // void method1(Object object){
    //     System.out.println("CHILD METHOD IS RUNNING..........");
    // }
}

/**
 *  CLIENT ------------------>  PARENT
 *         -
 *           -
 *             -
 *                -
 *                  -
 *                    - >CHILD     
 */
class Client{
    Parent object;

    Client(Parent object){
        this.object = object;
    }

    void print(String s){
        object.method1(s);
    }
}

public class MethodArgumentRule {
    public static void main(String[] args) {
        Parent parent = new Parent();

        Child child = new Child();

        Client client = new Client(child);
        client.print("hello");
        
    }
}
