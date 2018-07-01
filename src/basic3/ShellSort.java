package basic3;

public class ShellSort {

    public static void main(String[] args) {
        int[] source = new int[]{0, 1, 8, 9, 2, 4, 7, 5};
        shellSort(source);
        for (int i : source) {
            System.out.print(i + " ");
        }
    }

    public static void exchange(int[] arr, int i, int j) { // test: 当i = j时候会产生隐形的bug
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int addition = arr[i];
            int j = i;
            while(j > 0 && addition < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j --;
            }
            arr[j] = addition;
        }
    }

    public static void shellSort(int[] arr) {
        int h = 1;
        while(h < arr.length) {
            h = h * 3 + 1;
        }
        h = (h - 1) / 3;
        while(h >= 1) {
            for (int i = 0; i < arr.length; i += h) {
                int addition = arr[i];
                int j = i;
                while(j > 0 && addition < arr[j - h]) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = addition;
            }
            h = (h - 1) / 3;
        }
    }
}
