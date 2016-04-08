/**
 * Created by Bergem on 08/04/16.
 */
public class DobbelForLøkke {

    public static void main(String[] args) {

        int r = 3;
        int k = 5;

        int[][] array = {
                            {1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15},
                        };

        System.out.printf("array: [");
        for (int[] array1 : array) {
            for (int i : array1) {
                System.out.printf(" %d", i);
            }
        }
        System.out.printf(" ]\n");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < k; j++) {
                System.out.printf(" %d, %d, %d\n", i, j, array[i][j]);
            }
        }

    }
}

class ForStortBrettUnntak extends Exception {
    ForStortBrettUnntak() {
        super("Hei du, du har gjort en feil.");
    }
}
