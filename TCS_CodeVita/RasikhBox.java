package TCS_CodeVita;
// Rasikh wishes to engage with a box represented as an m × n matrix, which contains several stones marked by '*' at specified initial positions. Seeking guidance on how to rotate the box and determine the resulting arrangement of the stones, he approaches his uncle for instructions regarding the direction of rotation. His uncle, somewhat irritated by the interruption, provides Rasikh with random rotation instructions. The task is to determine the final configuration of the box, taking into account that after initial stage or after each rotation, gravity causes the stones to shift accordingly.

import java.util.Scanner;

// The box is rotated in 90° angle in the direction as provided in the input.
public class RasikhBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // Number of rows
        int n = sc.nextInt(); // Number of columns

        char[][] box = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                box[i][j] = row.charAt(j);
            }
        }

        int k = sc.nextInt();
        while (k-- > 0) {
            String direction = sc.next();
            applyGravity(box);
            box = rotateBox(box, direction);
            applyGravity(box);
        }

    }

    private static char[][] rotateBox(char[][] box, String direction) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox;

        if (direction.equals("right")) {
            rotatedBox = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedBox[j][m - 1 - i] = box[i][j];
                }
            }
        } else {
            rotatedBox = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedBox[n - 1 - j][i] = box[i][j];
                }
            }
        }

        return rotatedBox;
    }

    private static void applyGravity(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (box[i][j] == '*') {
                    if (i != emptyRow) {
                        box[emptyRow][j] = '*';
                        box[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
    }
}
