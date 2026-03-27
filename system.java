public class system {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = {10, 20, 30, 40, 50};
        
        // Print the elements of the array
        java.lang.System.out.println("Array elements:");
        for (int i = 0; i < numbers.length; i++) {
            java.lang.System.out.println("Element at index " + i + ": " + numbers[i]);
        }
        
        // Calculate the sum of the array elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        java.lang.System.out.println("Sum of array elements: " + sum);
    }
}
