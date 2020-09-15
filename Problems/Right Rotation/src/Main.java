import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrInput = scanner.nextLine();
        String[] origin = arrInput.split(" ");
        int rotation = scanner.nextInt();
        String[] shifted = new String[origin.length];
        for (int i = 0; i < origin.length; i++) {
            int shiftedI = (i + rotation) % origin.length;
            shifted[shiftedI] = origin[i];
        }
        System.out.println(String.join(" ", shifted));
    }
}