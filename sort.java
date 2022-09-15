package pyramid_sort;

public class sort {

    private static int heapSize;

    // Печать массива.
    static void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Своего рода диспетчер в этой сортировке.
    // Вызывает метод составления кучи и меняет первый элемент с текущим последним.
    public static void sort_array(int[] array) {
        make_heap(array);
        while (heapSize > 1) {
            swap(array, 0, heapSize - 1);
            heapSize--;
            heap_check(array, 0);
        }
    }

    // Перебор элементов для проверки соответствия куче и построения кучи.
    private static void make_heap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heap_check(a, i);
        }
    }
    
    // Проверка тройки элементов на соответствие условию двоичной кучи.
    private static void heap_check(int[] a, int ind) {

        // Определение индексов родительского и дочерних элементов.
        int left = 2 * ind + 1;
        int rigth = 2 * ind + 2;
        int max = ind;

        // Перезапись индекса наибольшего элемента, который затем будет подставлен на место родительского.  
        // Сортировка по возрастанию. Для убывания меняются знаки.
        if (left < heapSize && a[max] < a[left]) {
            max = left;
        }
        if (rigth < heapSize && a[max] < a[rigth]) {
            max = rigth;
        }
        if (ind != max) {
            swap(a, ind, max);
            heap_check(a, max);
        }
    }

    // Перестановка элементов.
    private static void swap(int[] a, int i, int j)  {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        int[] array = {9, 7, 5, 1, 3, 6, 2, 8, 4};
        System.out.println("Исходный массив:");
        print_array(array);
        sort_array(array);
        System.out.println("Отсортированный массив:");
        print_array(array);
    }
}