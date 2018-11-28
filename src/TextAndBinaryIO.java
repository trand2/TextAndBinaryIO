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
    
    private static void exercise1_CC() throws IOException {
        Scanner scan = new Scanner(new File("data.txt"));
        PrintWriter output = new PrintWriter(new File("data-e.txt"));

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] words = line.split(" ");
            StringBuilder newLine = new StringBuilder();
            for (String thisWord : words) {
                StringBuilder newWord = new StringBuilder();
                for (int j = 0; j < thisWord.length(); j++) {
                    char letter = thisWord.charAt(j);
                    letter += 20;
                    newWord.append(letter);
                }
                newLine.append(newWord).append(" ");
            }
            output.println(newLine);
        }
        scan.close();
        output.close();
    }

    public static void exercise2() {
        Scanner scan = new Scanner(new File("data.txt"));
        PrintWriter output = new PrintWriter(new File("data.json"));
        output.println("[");
        while(scan.hasNextLine()){
            output.println("\t{");
            output.println("\t\t\"id\": " + Integer.parseInt(scan.next()) + ",");
            scan.nextLine();
            output.println("\t\t\"name\": \"" + scan.nextLine() + "\",");
            output.println("\t\t\"address\": \"" + scan.nextLine() + "\",");
            output.println("\t\t\"pay\": " + Double.parseDouble(scan.next()) + ",");
            output.println("\t\t\"hours\": " + Integer.parseInt(scan.next()));
            if(scan.hasNextLine()){
                scan.nextLine();
                output.println("\t},");
            }else{
                output.println("\t}");
            }
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
        exercise1_CC();
        exercise2();
        exercise3();
        exercise4();

    }
}
