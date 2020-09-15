import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int prod = 0;
        int current = scanner.nextInt();
        for (int i = 1; i < size; i++) {
            int n = scanner.nextInt();
            if (current * n > prod) {
                prod = current * n;
            }
            current = n;
        }
        System.out.println(prod);
    }
}