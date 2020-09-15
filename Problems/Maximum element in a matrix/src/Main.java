import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        int iMax = 0;
        int jMax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int el = scanner.nextInt();
                if (el > max) {
                    max = el;
                    iMax = i;
                    jMax = j;
                }
            }
        }
        System.out.println(iMax + " " + jMax);
    }
}
// check this: https://hyperskill.org/learn/step/1937#solutions-539337
