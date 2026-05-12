import java.util.Scanner;

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a > 100) {
            System.out.println("Big");
        } else {
            System.out.println("Small");
        }
    }
}