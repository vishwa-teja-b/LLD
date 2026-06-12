// EX - DOCUMENT MANAGEMENT SYSTEM

import java.util.ArrayList;
import java.util.List;

abstract class Document{
    protected String text;

    Document(String text){

    }

    Document(){}

    public abstract void open();
    public abstract void save();
}

class TextDocument extends Document{

    TextDocument(String text){
        super(text);
    }

    @Override
    public void open() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'open'");
        System.out.println("OPENING FILE.........");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'save'");
        System.out.println("SAVING FILE...........");
    }
}

class ReadOnlyDocument extends Document{

    ReadOnlyDocument(String text){
        super(text);
    }

    @Override
    public void open() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'open'");
        System.out.println("OPENING DOCUMENT IN READ-ONLY MODE.........");
    }


    // INHERITANCE IS NARROWED
    @Override
    public void save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("CANNOT SAVE A READ-ONLY FILE....");
    }
}


// CLIENT

public class LSPViolated{
    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();

        documents.add(new TextDocument("file1"));
        documents.add(new ReadOnlyDocument("file2"));
        documents.add(new TextDocument("file3"));


        // ALSO VIOLATES OCP
        for(Document doc : documents){
            if(doc instanceof TextDocument) doc.save();
            else System.out.println("CANNOT SAVE " + doc.text+" BECAUSE THE FILE IS READ-ONLY.");
        }
    }
}