import java.util.*;

public class Main {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);

        int[] box1 = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }

        int[] box2 = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }
        // output
        switch (compareArrays(box1, box2)) {
            case 3:
                System.out.println("Box 1 > Box 2");
                break;
            case -3:
                System.out.println("Box 1 < Box 2");
                break;
            default:
                System.out.println("Incompatible");
                break;
        }
    }

    // sort an arrays to make comparison easier!
    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * Compare given arrays and return an int
     * = +length if arr1 > arr2
     * = -length if arr1 < arr2
     * < length if incompatible
     * This solution is inspired by: https://hyperskill.org/learn/step/10613#solutions-540853
     */
    static int compareArrays(int[] arr1, int[] arr2) {
        sortArray(arr1);
        sortArray(arr2);
        int compatibleElements = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                compatibleElements++;
            }
            if (arr1[i] < arr2[i]) {
                compatibleElements--;
            }
        }
        return compatibleElements;
    }
}