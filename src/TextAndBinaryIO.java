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
        Scanner scan = new Scanner(new File("data.txt"));
        PrintWriter output = new PrintWriter(new File("data.json"));
        output.println("[");
        while(scan.hasNextLine()){
            output.println("\t{");
            output.println("\t\t\"id\": \"" + scan.nextLine() + "\",");
            output.println("\t\t\"name\": \"" + scan.nextLine() + "\",");
            output.println("\t\t\"address\": \"" + scan.nextLine() + "\",");
            String payHours = scan.nextLine();
            String[] payHoursArr = payHours.split(" ");
            output.println("\t\t\"pay\": " + payHoursArr[0] + ",");
            output.println("\t\t\"hours\": " + payHoursArr[1]);

            output.println("\t},");
        }
        output.println("]");
        scan.close();
        output.close();
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
