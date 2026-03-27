import java.util.Scanner;

public class learn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            String binaryString = convertToBinaryString(number);
            System.out.println(number + " = " + binaryString);
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        scanner.close();
        
        System.out.println("\n--- RUNNING TEST CASES ---");
        // For 32, note that the true mathematical binary representation is 100000.
        System.out.println("32 = " + convertToBinaryString(32)); 
        System.out.println("27 = " + convertToBinaryString(27));
        System.out.println("26 = " + convertToBinaryString(26));
    }
    
    // Function that takes an integer, calculates its binary representation,
    // stores these bits in a string and returns that string.
    public static String convertToBinaryString(int num) {
        if (num == 0) {
            return "0";
        }
        
        String binaryStr = "";
        int temp = Math.abs(num);
        
        while (temp > 0) {
            int bit = temp % 2;
            binaryStr = bit + binaryStr; // Store bit at the beginning
            temp = temp / 2;
        }
        
        if (num < 0) {
            binaryStr = "-" + binaryStr; // Add negative sign if needed
        }
        
        return binaryStr;
    }
}
