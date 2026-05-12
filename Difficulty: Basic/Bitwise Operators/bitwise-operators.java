import java.util.Scanner;

class Solution {
    
    static void solve() {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int d = a ^ a;
        int e = c ^ b;
        int f = a & b;
        int g = c | (a ^ a);

        e = ~e;

        System.out.println(d + " " + e + " " + f + " " + g);
    }
}