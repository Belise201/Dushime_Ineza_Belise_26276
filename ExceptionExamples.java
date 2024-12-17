import java.io.*;
import java.sql.*;

public class ExceptionExamples {
    public static void main(String[] args) {
        System.out.println("=== Checked Exceptions ===");
        ioExceptionExample();
        fileNotFoundExceptionExample();
        eofExceptionExample();
        sqlExceptionExample();
        classNotFoundExceptionExample();

        System.out.println("\n=== Unchecked Exceptions ===");
        arithmeticExceptionExample();
        nullPointerExceptionExample();
        arrayIndexOutOfBoundsExceptionExample();
        classCastExceptionExample();
        illegalArgumentExceptionExample();
        numberFormatExceptionExample();
    }

    // CHECKED EXCEPTIONS

    // 1. IOException
    public static void ioExceptionExample() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"));
            reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException Example: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    public static void fileNotFoundExceptionExample() {
        try {
            FileInputStream file = new FileInputStream("non_existent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException Example: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void eofExceptionExample() {
        try (DataInputStream input = new DataInputStream(new FileInputStream("example.txt"))) {
            while (true) {
                System.out.println(input.readUTF());
            }
        } catch (EOFException e) {
            System.out.println("EOFException Example: Reached end of file.");
        } catch (IOException e) {
            System.out.println("IOException Example: " + e.getMessage());
        }
    }

    // 4. SQLException
    public static void sqlExceptionExample() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentDB", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException Example: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void classNotFoundExceptionExample() {
        try {
            Class.forName("com.nonexistent.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException Example: " + e.getMessage());
        }
    }

    // UNCHECKED EXCEPTIONS

    // 6. ArithmeticException
    public static void arithmeticExceptionExample() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException Example: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    public static void nullPointerExceptionExample() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException Example: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    public static void arrayIndexOutOfBoundsExceptionExample() {
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException Example: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    public static void classCastExceptionExample() {
        try {
            Object obj = new Integer(10);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException Example: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException
    public static void illegalArgumentExceptionExample() {
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException Example: " + e.getMessage());
        }
    }

    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
    }

    // 11. NumberFormatException
    public static void numberFormatExceptionExample() {
        try {
            int number = Integer.parseInt("invalid123");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException Example: " + e.getMessage());
        }
    }
}
