import java.util.Random;

/**
 * Created by Bergem on 08/04/16.
 */
public class Bubblesort {

    private int [] array;

    public static void main(String[] args) {
        new Bubblesort();
    }

    public Bubblesort() {
        Random random = new Random(1234);

        int n = 10;
        array = new int[n];
        //array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n);
        }

        printArray(array);

        sort(array);
        //swap(0, 1, array);
        //testSort(array);
    }

    /* Sorterer elementer etter Bubblesort */
    public void sort(int [] array) {
//        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    printArray(array);
                }
            }
//        }
        // Enten dobbel for-løkke, eller rekursjon.
            if (!testSort(array)) sort(array);
    }

    /* Bytter om to indekser i et array */
    public void swap(int a, int b, int [] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /* Tester om et array er riktig sortert */
    public boolean testSort(int [] array) {
        boolean riktig = true;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                riktig = false;
                //System.out.printf("Feil i sortering: array[%d] = %d > array[%d] = %d\n",
                        //i, array[i], i+1, array[i+1]);
            }
        }
        if (riktig) {
            System.out.println("Arrayen er riktig sortert!");
            return true;
        }
        return false;
    }

    /* Skriver ut en fin utskrift av et array */
    public void printArray(int [] array) {
        System.out.printf("array: [");
        for (int i : array) {
            System.out.printf(" %d", i);
        }
        System.out.printf(" ]\n");
    }


}
