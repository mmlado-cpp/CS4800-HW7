import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Document doc = new Document();
        String var1 = "arial-red-12";
        String var2 = "calibri-blue-14";
        String var3 = "verdana-black-16";
        String var4 = "arial-blue-12";
        
        doc.write('H', var1);
        doc.write('e', var2);
        doc.write('l', var3);
        doc.write('l', var4);
        doc.write('o', var1);
        doc.write('W', var2);
        doc.write('o', var3);
        doc.write('r', var4);
        doc.write('l', var1);
        doc.write('d', var2);
        doc.write('C', var3);
        doc.write('S', var4);
        doc.write('5', var1);
        doc.write('8', var2);
        doc.write('0', var3);
        doc.write('0', var4);
        doc.write('0', var1);
        doc.write('0', var2);

        doc.save("file1.txt");

        Document savedFile = new Document("file1.txt");
        savedFile.print();
    }
}