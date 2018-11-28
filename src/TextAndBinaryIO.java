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

    private static void exercise3() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(new File("data.txt"));
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data.ser"));
        ArrayList<Employee> employees = new ArrayList<>();
        while(scan.hasNextLine()){
            int i = Integer.parseInt(scan.next());
            scan.nextLine();
            String n = scan.nextLine();
            String a = scan.nextLine();
            double p = Double.parseDouble(scan.next());
            int h = Integer.parseInt(scan.next());
            Employee emp = new Employee(i,n,a,p,h);
            employees.add(emp);

        }
        output.writeObject(employees);

        scan.close();
        output.close();

        //read back from data.ser
        ObjectInputStream serializedInput = new ObjectInputStream(new FileInputStream("data.ser"));
        ArrayList<Employee> newEmployees = (ArrayList<Employee>) serializedInput.readObject();
        for(int i = 0; i < newEmployees.size(); i++){
            System.out.print(newEmployees.get(i).print());
        }
        serializedInput.close();
    }

    public static void exercise4() {

    }

    public static void main (String args[]) throws IOException, ClassNotFoundException {
        exercise1();
        exercise1_CC();
        exercise2();
        exercise3();
        exercise4();

    }
    
    static class Employee implements Serializable{
        int id;
        String name;
        String address;
        double pay;
        int hours;
        Employee(int i, String n, String a, double p, int h){
            id = i;
            name = n;
            address = a;
            pay = p;
            hours = h;
        }

        String print(){
            return id + "\n" + name + "\n" + address + "\n" + pay + " " + hours + "\n";
        }
    }
}
