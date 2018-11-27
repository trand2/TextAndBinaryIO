import java.io.*;

public class TextAndBinaryIO {

    public static void exercise1() throws IOException {
        FileReader fileReader = new FileReader("data.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("data-e.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        int c = fileReader.read();

        while (c != -1) {
            c += 20;
            dataOutputStream.writeChar(c);
            c = fileReader.read();
        }
    }

    public static void exercise2() {

    }

    public static void exercise3() {

    }

    public static void exercise4() {

    }

    public static void main (String args[]) throws IOException {
        exercise1();
        exercise2();
        exercise3();
        exercise4();

    }
}
