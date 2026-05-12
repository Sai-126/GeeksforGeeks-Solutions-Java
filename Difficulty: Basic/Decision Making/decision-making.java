import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading the two integers n and m
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            // Logic for comparison
            if (n < m) {
                System.out.println("less");
            } else if (n == m) {
                System.out.println("equal");
            } else {
                System.out.println("greater");
            }
        }
    }
}