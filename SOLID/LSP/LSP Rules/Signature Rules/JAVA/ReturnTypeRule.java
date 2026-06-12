// package LSP Rules.Signature Rules.JAVA;


/***
 * RETURN TYPE RULE : 
 * the overriden method in the subclass should have return type identical to parent or narrower ones, which the original return type can hold
 * 
 */
class Animal{}

class Dog extends Animal{}

class Parent{
    Animal getAnimal(){
        System.out.println("RETURNING ANIMAL REFERENCE IN PARENT CLASS....");
        return new Animal();
    }
}

class Child extends Parent{
    @Override
    Dog getAnimal(){
        System.out.println("RETURNING DOG REFERENCE IN CHILD CLASS....");
        return new Dog();
    }
}

class Client{
    Parent object;

    Client(Parent object){
        this.object = object;
    }

    public void getAnimal(){
        object.getAnimal();
    }
}

public class ReturnTypeRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        Client client = new Client(child);
        client.getAnimal();
    }
}
