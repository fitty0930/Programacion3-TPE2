package ProgramacionIII.tp2;

public class OrderArray {
    private int[] arr;
    private int[] helper;

    public OrderArray(int[] arr) {
        this.arr = arr;
    }

    public int[] selectSort() {
        int[] aux = {};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        aux = arr;
        return aux;
    }

    public int[] bubbleSort() {
        int[] aux = {};
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        aux = arr;
        return aux;
    }

    public int[] mergeSort() {
        this.helper = new int[arr.length];
        int size = arr.length;

        doMergeSort(0, size - 1);

        // COPIA Y DEVOLUCION
        int[] aux = arr;
        return aux;
    }

    private void doMergeSort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            // ordenar la mitad izquierda del array
            doMergeSort(low, middle);
            // ordenar la mitad derecha del array
            doMergeSort(middle + 1, high);
            // combiner ambas mitades ordenadas
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // copiar ambas partes al array helper
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        // copiar de manera ordenada al array original los valores de la
        // mitad izquierda o de la derecha
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                arr[k] = helper[i];
                i++;
            } else {
                arr[k] = helper[j];
                j++;
            }
            k++;
        }
        // si quedaron elementos copiarlos al array original
        while (i <= middle) {
            arr[k] = helper[i];
            k++;
            i++;
        }
        while (j <= high) {
            arr[k] = helper[j];
            k++;
            j++;
        }
    }

    public int[] quickSort(int izq, int der){
        int pivote=arr[izq]; // tomamos primer elemento como pivote
        int i=izq;         // i realiza la búsqueda de izquierda a derecha
        int j=der;         // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i < j){                          // mientras no se crucen las búsquedas
            while(arr[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
            while(arr[j] > pivote) j--;           // busca elemento menor que pivote
            if (i < j) {                        // si no se han cruzado
                aux= arr[i];                      // los intercambia
                arr[i]=arr[j];
                arr[j]=aux;
            }
        }

        arr[izq]=arr[j];      // se coloca el pivote en su lugar de forma que tendremos
        arr[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

        if(izq < j-1)
            quickSort(izq,j-1);          // ordenamos subarray izquierdo
        if(j+1 < der)
            quickSort(j+1,der);          // ordenamos subarray derecho
        // COPIA Y DEVOLUCION
        int[] auxiliar = arr;
        return auxiliar;
    }
}
