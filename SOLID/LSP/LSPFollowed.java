import java.util.ArrayList;
import java.util.List;

abstract class ReadableDocument{
    protected String text;

    public abstract void read();
}

abstract class WriteableDocument extends ReadableDocument{
    public abstract void save();
}

class ReadOnlyDocument extends ReadableDocument{

    @Override
    public void read() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'read'");
        System.out.println("READING FILE IN READ-ONLY DOCUMENT..........");
    }
}

class TextDocument extends WriteableDocument{

    @Override
    public void save() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'save'");
        System.out.println("SAVING FILE IN TEXT DOCUMENT.....");
    }

    @Override
    public void read() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'read'");
        System.out.println("READING FILE IN TEXT DOCUMENT");
    } 
}

public class LSPFollowed {
    public static void main(String[] args) {
        List<ReadableDocument> readableDocs = new ArrayList<>();
        List<WriteableDocument> writeableDocs = new ArrayList<>();

        readableDocs.add(new ReadOnlyDocument());
        readableDocs.add(new ReadOnlyDocument());

        writeableDocs.add(new TextDocument());
        writeableDocs.add(new TextDocument());

        for(ReadableDocument doc : readableDocs){
            System.out.println("READING READ ONLY DOC..........");
            doc.read();
        }

        System.out.println();
        System.out.println();
        // System.out.println();


        for(WriteableDocument doc : writeableDocs){
            System.out.println("READING and SAVING doc..........");
            doc.read();
            doc.save();
        }
    }    
}
