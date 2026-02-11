import java.util.*;

public class FlipMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] a = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        char ch = sc.next().charAt(0);
        if (ch == 'H') {
            int top = 0;
            int bottom = r - 1;

            while (top < bottom) {
                int[] temp = a[top];
                a[top] = a[bottom];
                a[bottom] = temp;

                top++;
                bottom--;
            }
        }
        if (ch == 'V') {
            for (int i = 0; i < r; i++) {
                int left = 0;
                int right = c - 1;

                while (left < right) {
                    int temp = a[i][left];
                    a[i][left] = a[i][right];
                    a[i][right] = temp;

                    left++;
                    right--;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
