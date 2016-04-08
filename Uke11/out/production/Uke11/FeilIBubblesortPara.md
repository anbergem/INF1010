##BubblesortPara

Vi fikk feil i sorteringen. Grunnen til det var at når vi skulle *merge*'e og kalle på `sorterHele()` hadde vi en liten feil i denne metoden. 
```java
public void sortHele() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                swap(i, i + 1, array);
                //printArray(array);
            }
        }
        // Her kalte vi på sort() som var en tom metode.
        if (!testSort(array, 0, array.length)) sortHele();
    }
```