import java.io.*;

class MyReader extends FileReader {
    File file;

    MyReader(File file) throws Exception {
        super(file);
        this.file = file;
    }

    MyReader(String filename) throws Exception {
        super(filename);
        file = new File(filename);
    }

    public String readContent() throws Exception {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(this)) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line).append("\n");
            }
        }
        return data.toString();
    }

    public static void main(String[] args) throws Exception {
        MyReader reader = new MyReader("Welcome.txt");
        System.out.println(reader.readContent());

        File file = new File("Welcome.txt");
        MyReader reader2 = new MyReader(file);
        System.out.println(reader2.readContent());
    }
}