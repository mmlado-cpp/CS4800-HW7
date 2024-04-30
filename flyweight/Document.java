import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public Document() {
    }

    public Document(String fileName) {
        try {
            readFromFile(fileName);
        } catch (Exception e) {
            System.out.println("Could not create a new document.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void write(char character, String properties) {
        characters.add(new Character(character, properties));
    }

    private void readFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineVals = line.split(" ");
                char character = lineVals[0].charAt(0);
                String properties = lineVals[1];
                characters.add(new Character(character, properties));
            }
        }
    }
    
    public void save(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Character c : characters) {
                String lineToWrite = String.format("%c %s\n", c.getCh(), c.getProperties().serialize());
                writer.write(lineToWrite);
            }
        }
    }

    public void print(){
        for (Character character : this.characters){
            System.out.println(character);
        }
    }

    
}