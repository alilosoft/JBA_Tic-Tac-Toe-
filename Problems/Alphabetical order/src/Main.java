import java.util.Scanner;

// I have challenged my self to implement string comparison!
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");
        boolean ordered = true;
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1]) > 0) {
                ordered = false;
                break;
            }
        }
        System.out.println(ordered);
    }

    // compare two strings
    static int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            if (s1.length() < s2.length()) {
                return -1;
            } else {
                return 1;
            }
        }
        int i = 0;
        while (i < s1.length() - 1 && s1.charAt(i) == s2.charAt(i)) {
            i++; // ignore identical chars
        }
        return compare(s1.charAt(i), s2.charAt(i));
    }

    // compare two chars
    static int compare(char c1, char c2) {
        if (c1 < c2) {
            return -1;
        } else {
            if (c1 > c2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
