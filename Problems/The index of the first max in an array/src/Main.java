import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = scanner.nextInt();
        int index = 0;
        for (int i = 1; i < n; i++) {
            int el = scanner.nextInt();
            if (el > max) {
                max = el;
                index = i;
            }
        }
        System.out.println(index);
    }
}