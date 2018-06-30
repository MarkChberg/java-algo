package basic1;

public class SimpleSort {

    public static void main(String[] args) {
        int[] test = new int[] {4, 3, 7, 3, 0, 9};
//        bubbleSort(test);
//        print(test);
//        selectSort(test);
//        print(test);
//        System.out.println(findPosition(test, 5));

        int[] ints = insertSort(test);
        print(ints);

    }

    public static void print(int[] source) {
        for (int i : source) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void exchange(int[] source, int i, int j) {
        source[i] = source[i] ^ source[j];
        source[j] = source[i] ^ source[j];
        source[i] = source[i] ^ source[j];
    }

    public static void bubbleSort(int[] source) {
        for(int i = 0; i < source.length - 1; i++) {
            for(int j = source.length - 1; j > i; j--) {
                if (source[j] < source[j - 1]) {
                    exchange(source, j, j - 1);
                }
            }
        }
    }


    public static void selectSort(int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            int compare = source[i];
            for (int j = i + 1; j < source.length - 1; j++) {
                if (source[j] < compare) {
                    exchange(source, i, j);
                }
            }
        }
    }

    public static int[] insertSort(int[] source) {
        int[] result = new int[source.length];
        result[0] = source[0];
        for(int i = 1; i < source.length; i++) {
            int compare = source[i];
            int position = findPosition(result, compare, i);
            insertArray(result, position, source[i]);
        }
        return result;
    }

    private static void insertArray(int[] result, int position, int num) {
        int addition = num;
        for(int i = position; i < result.length; i++) {
            addition = addition ^ result[i];
            result[i] = addition ^ result[i];
            addition = addition ^ result[i];
        }
    }

    public static int findPosition(int[] source, int number, int length) {
        int i = 0;
        while(i < length) {
            if (number > source[i]) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

}
