import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.next();
        double area = 0;
        switch (shape) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                // triangle area calc: https://www.mathsisfun.com/geometry/herons-formula.html
                double s = (a + b + c) / 2;
                area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                break;
            case "rectangle":
                double h = scanner.nextDouble();
                double w = scanner.nextDouble();
                area = h * w;
                break;
            case "circle":
                double r = scanner.nextDouble();
                area = 3.14 * r * r;
                break;
            default:
                System.out.println("NOT SUPPORTED");
                break;
        }
        System.out.println(area);
    }
}