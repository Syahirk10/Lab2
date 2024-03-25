import java.io.*;

// MyFileHandler class extends FileReader to handle file reading and writing operations
class MyFileHandler extends FileReader {
    File file; // File object to represent the file being read or written
    char[] content = new char[1000]; // Array to store content read from the file

    // Constructor taking a File object
    MyFileHandler(File file) throws Exception {
        super(file); // Call the constructor of the superclass (FileReader)
        this.file = file; // Initialize the file attribute
    }

    // Constructor taking a file path as a String
    MyFileHandler(String filename) throws Exception {
        super(filename); // Call the constructor of the superclass (FileReader)
        file = new File(filename); // Create a File object from the filename
    }

    // Method to check if the file exists
    public boolean fileExists() {
        return file.exists();
    }

    // Method to read content from the file and return it as a String
    public String readContent() throws Exception {
        StringBuilder sb = new StringBuilder(); // StringBuilder to store the content of the file
        try (BufferedReader br = new BufferedReader(this)) { // BufferedReader to read lines from the file
            String line;
            while ((line = br.readLine()) != null) { // Read lines until end of file
                sb.append(line); // Append the line to the StringBuilder
            }
        }
        return sb.toString(); // Return the content as a String
    }

    // Method to write content to the file
    public void writeContent(String content) throws IOException {
        BufferedWriter writer = null; // BufferedWriter to write content to the file
        try {
            writer = new BufferedWriter(new FileWriter(file)); // Create a BufferedWriter for the file
            writer.write(content); // Write the content to the file
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close(); // Close the BufferedWriter
                } catch (IOException e) {
                    System.err.println("Error closing BufferedWriter: " + e.getMessage());
                }
            }
        }
    }
    
    

    // Main method for testing the MyFileHandler class
    public static void main(String[] args) throws Exception {
        // Create a MyFileHandler object for the file "Welcome.txt"
        MyFileHandler fileHandler = new MyFileHandler("FileHandler.txt");

        // Checking if the file exists
        if (fileHandler.fileExists()) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file does not exist.");
        }
        
        // Reading content from the file
        System.out.println("Content read from file:");
        System.out.println(fileHandler.readContent());
        
        // Writing content to the file
        String contentToWrite = "Hello, this is some content to write to the file.";
        fileHandler.writeContent(contentToWrite);

        // Create a new MyFileHandler object for the same file to demonstrate reading after writing
        MyFileHandler readFile = new MyFileHandler("FileHandler.txt");
        
        // Reading content from the file again
        System.out.println("Content read from file:");
        System.out.println(readFile.readContent());
    }
}
