import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = fill(i, j, n);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    static String fill(int i, int j, int n) {
        if (i == j) { // main diagonal
            return "*";
        }
        if (i == n - j - 1) { // secondary diagonal
            return "*";
        }
        if (i == n / 2) { // middle row
            return "*";
        }
        if (j == n / 2) { // middle column
            return "*";
        }
        return ".";
    }
}