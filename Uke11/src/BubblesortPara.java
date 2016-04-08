import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Bergem on 08/04/16.
 */
public class BubblesortPara {

    CyclicBarrier barrier;

    int [] array;

    int numThreads;

    public static void main(String[] args) {
        new BubblesortPara().run();
    }

    /* Initierer */
    public BubblesortPara() {
        // For å trekke et tilfeldig tall.
        // 1234 for å trekke de samme tallene hver gang
        Random random = new Random(1234);

        int n = 10000;
        numThreads = 10;

        // Antall tråder + main-tråden
        barrier = new CyclicBarrier(numThreads+1);

        array = new int[n];
        //array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < array.length; i++) {
            // Trekk tilfeldig tall
            array[i] = random.nextInt(n);
        }
    }

    /* Lager trådene, for så å vente til alle trådene er ferdig.
    * Dermed sorterer main-tråden hele arrayet, som allerede
    * er delvis sortert */
    public void run() {
        // elements per thread
        int ept = array.length/numThreads;

        for (int i = 0; i < numThreads-1; i++) {
            new Thread(new Arbeider(i, ept*i, ept*(i+1))).start();
        }
        new Thread(new Arbeider(numThreads-1, ept*(numThreads-1), array.length)).start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        sortHele();

        //printArray(array);
        testHeleSort(array);

    }

    /* Bytter om to elementer */
    public void swap(int a, int b, int [] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /* Sjekker om en del av et array er sortert */
    public boolean testSort(int [] array, int start, int stop) {
        boolean riktig = true;

        for (int i = start; i < stop-1; i++) {
            if (array[i] > array[i+1]) {
                riktig = false;
            }
        }
        if (riktig) {
            return true;
        }
        return false;
    }

    /* Tester om hele arrayet er sortert */
    public boolean testHeleSort(int[] array) {
        boolean riktig = true;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                riktig = false;
                System.out.printf("Feil i sortering: array[%d] = %d > array[%d] = %d\n",
                        i, array[i], i+1, array[i+1]);
            }
        }
        if (riktig) {
            System.out.println("Arrayen er riktig sortert!");
            return true;
        }
        return false;
    }

    /* Skriver ut et array med et fint format */
    public void printArray(int[] array) {
        System.out.printf("array: [");
        for (int i : array) {
            System.out.printf(" %d", i);
        }
        System.out.printf(" ]\n");
    }

    /* Sorterer hele etter Bubblesort med rekursjon*/
    public void sortHele() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(i, i + 1, array);
                //printArray(array);
            }
        }
        if (!testSort(array, 0, array.length)) sortHele();
    }

    /* Tråd-klasse for å sortere parallellt */
    class Arbeider implements Runnable {

        /* Start og stop for å vite hvilken del av arrayen
        *  Tråden skal sortere */
        int id, start, stop;

        public Arbeider(int id, int start, int stop) {
            this.id = id;
            this.start = start;
            this.stop = stop;
        }

        /* Obligatorisk metode for Runnable, kaller bare på sort()
         * og dermed sier ifra til barrieren at den er ferdig,
         * og venter der til alle de andre også er ferdig */
        @Override
        public void run() {
            sort();

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        /* Sorterer etter Bubblesort med bruk av rekursjon */
        void sort() {
            for (int i = start; i < stop - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    //printArray(array);
                }
            }
            if (!testSort(array, start, stop)) sort();
        }
    }
}
