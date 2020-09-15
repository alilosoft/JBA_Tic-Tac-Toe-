import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int count = 0;
        for (int el : arr) {
            if (el == n) {
                count++;
            }
        }
        System.out.println(count);
    }
}