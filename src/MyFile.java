import java.io.*;

public class MyFile {
    public static void main(String[] args) {
        // File path
        String filePath = "Welcome.txt";
        
        // Text to insert
        String textToInsert = "Software Engineering Department";

        try {
            File file = new File(filePath);

            // Check if the file exists
            if (file.exists()) {
                // If the file exists, append it with the given text
                FileWriter fw = new FileWriter(filePath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(textToInsert);
                bw.newLine();
                bw.close();
                System.out.println("Text appended to the file successfully.");
            } else {
                // If the file doesn't exist, create a new file called "WelcomeAgain.txt" and write the text into it
                String newFilePath = "WelcomeAgain.txt";
                FileWriter fw = new FileWriter(newFilePath);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Welcome To UTeM");
                bw.newLine();
                bw.close();
                System.out.println("Text written to a new file successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}