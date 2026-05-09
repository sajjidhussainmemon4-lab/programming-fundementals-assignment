

### Task 1: Product-wise sum (without HashMap)

**Explanation:**
For this first task, we need to find the total sum for each product without using any advanced tools like a HashMap. To do this, I used parallel arrays for my sample data. Then, I created two empty arrays: one to keep track of the unique products we find, and another to keep their total sums. I used a `for` loop to go through the data, and an inner `for` loop to check if we already added the product to our unique list. If we did, I just add to the sum. If we didn't, I add the new product to the list.

**Java Code:**
```java
public class ProductSumNoMap {
    public static void main(String[] args) {
        // Sample data using basic arrays
        String[] products = {"Laptop", "Mouse", "Laptop", "Keyboard", "Mouse"};
        int[] amounts = {1000, 20, 1500, 50, 30};
        
        // Arrays to store our results
        String[] uniqueProducts = new String[10]; // assuming we won't have more than 10 unique items
        int[] totalSums = new int[10];
        int uniqueCount = 0; // keeps track of how many unique products we found
        
        for (int i = 0; i < products.length; i++) {
            String currentProduct = products[i];
            int currentAmount = amounts[i];
            
            boolean found = false;
            
            // Check if we already have this product in our unique array
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueProducts[j].equals(currentProduct)) {
                    totalSums[j] = totalSums[j] + currentAmount;
                    found = true;
                    break; // stop looking once we find it
                }
            }
            
            // If it is a new product we haven't seen before
            if (found == false) {
                uniqueProducts[uniqueCount] = currentProduct;
                totalSums[uniqueCount] = currentAmount;
                uniqueCount++; // increase the count of unique products
            }
        }
        
        // Print the results
        System.out.println("--- Product-wise Sum (No HashMap) ---");
        for (int k = 0; k < uniqueCount; k++) {
            System.out.println(uniqueProducts[k] + " Total: " + totalSums[k]);
        }
    }
}
```

**Expected Console Output:**
```text
--- Product-wise Sum (No HashMap) ---
Laptop Total: 2500
Mouse Total: 50
Keyboard Total: 50
```

---

### Task 2: ID-wise sum (without HashMap)

**Explanation:**
This is very similar to the first task, but instead of words (Strings), we are grouping the data by ID numbers (integers). I used the exact same logic with the `found` boolean variable to check for duplicates. The only big difference is that I used `==` to compare the IDs instead of `.equals()` because IDs are primitive `int` types.

**Java Code:**
```java
public class IdSumNoMap {
    public static void main(String[] args) {
        // Sample data for IDs and their amounts
        int[] ids = {101, 102, 101, 103, 102};
        int[] amounts = {500, 200, 300, 150, 100};
        
        // Arrays for results
        int[] uniqueIds = new int[10];
        int[] totalSums = new int[10];
        int uniqueCount = 0;
        
        for (int i = 0; i < ids.length; i++) {
            int currentId = ids[i];
            int currentAmount = amounts[i];
            
            boolean found = false;
            
            // Loop to see if the ID is already saved
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueIds[j] == currentId) {
                    totalSums[j] = totalSums[j] + currentAmount;
                    found = true;
                    break;
                }
            }
            
            // If the ID was not found, add it as a new entry
            if (found == false) {
                uniqueIds[uniqueCount] = currentId;
                totalSums[uniqueCount] = currentAmount;
                uniqueCount++;
            }
        }
        
        // Print the final sums
        System.out.println("--- ID-wise Sum (No HashMap) ---");
        for (int k = 0; k < uniqueCount; k++) {
            System.out.println("ID " + uniqueIds[k] + " Total: " + totalSums[k]);
        }
    }
}
```

**Expected Console Output:**
```text
--- ID-wise Sum (No HashMap) ---
ID 101 Total: 800
ID 102 Total: 300
ID 103 Total: 150
```

---

### Task 3: Product-wise sum (using HashMap)

**Explanation:**
Now we are allowed to use a HashMap. This makes the code much shorter and easier to read! A HashMap stores things in "key-value" pairs. For this part, the key is the product name (String) and the value is the total amount (Integer). I only need one `for` loop now. If the map already contains the product, I get the old sum and add the new amount to it. If it doesn't, I just add the new product and its amount to the map.

**Java Code:**
```java
import java.util.HashMap;

public class ProductSumWithMap {
    public static void main(String[] args) {
        String[] products = {"Desk", "Chair", "Desk", "Lamp", "Chair"};
        int[] amounts = {200, 80, 200, 45, 20};
        
        // Create a HashMap to store the product and its sum
        HashMap<String, Integer> productMap = new HashMap<String, Integer>();
        
        for (int i = 0; i < products.length; i++) {
            String currentProduct = products[i];
            int currentAmount = amounts[i];
            
            // Check if the product is already in our map
            if (productMap.containsKey(currentProduct)) {
                int oldSum = productMap.get(currentProduct);
                int newSum = oldSum + currentAmount;
                productMap.put(currentProduct, newSum); // update with new sum
            } else {
                // First time seeing this product
                productMap.put(currentProduct, currentAmount);
            }
        }
        
        // Print the results directly from the map
        System.out.println("--- Product-wise Sum (With HashMap) ---");
        for (String key : productMap.keySet()) {
            System.out.println(key + " Total: " + productMap.get(key));
        }
    }
}
```

**Expected Console Output:**
```text
--- Product-wise Sum (With HashMap) ---
Desk Total: 400
Chair Total: 100
Lamp Total: 45
```
*(Note: HashMaps do not guarantee the order, so the print order might be slightly different when you run it!)*

---

### Task 4: ID-wise sum (using HashMap)

**Explanation:**
For the final task, I used a HashMap again, but this time both the key and the value are Integers. The key is the ID number and the value is the sum. The logic is exactly the same as task 3. We check if the ID is in the map, update the math if it is, and add it if it isn't. 

**Java Code:**
```java
import java.util.HashMap;

public class IdSumWithMap {
    public static void main(String[] args) {
        int[] ids = {55, 66, 55, 77, 66};
        int[] amounts = {10, 25, 10, 5, 5};
        
        // Map where Key is ID (Integer) and Value is Total Amount (Integer)
        HashMap<Integer, Integer> idMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < ids.length; i++) {
            int currentId = ids[i];
            int currentAmount = amounts[i];
            
            if (idMap.containsKey(currentId)) {
                int oldSum = idMap.get(currentId);
                idMap.put(currentId, oldSum + currentAmount);
            } else {
                idMap.put(currentId, currentAmount);
            }
        }
        
        System.out.println("--- ID-wise Sum (With HashMap) ---");
        for (Integer idKey : idMap.keySet()) {
            System.out.println("ID " + idKey + " Total: " + idMap.get(idKey));
        }
    }
}
```

**Expected Console Output:**
```text
--- ID-wise Sum (With HashMap) ---
ID 66 Total: 30
ID 55 Total: 20
ID 77 Total: 5
```

---

### What I Learned From This Task
In this task, I learned how to group data together based on a common value, like a product name or an ID number. Doing it without a HashMap was a bit tricky because I had to keep track of the unique items and their sums using separate arrays, and I had to use a nested loop to search for duplicates. I also learned that if I use normal arrays, I have to guess the size (like `new String[10]`), which could cause an error if there is more data than I expected. 

Using a HashMap was much easier and cleaner! I didn't need a second loop or extra variables to keep count, and the HashMap automatically grows as needed. It really showed me why learning different data structures is helpful for solving problems.
