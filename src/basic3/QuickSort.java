package basic3;

public class QuickSort {

    public static void main(String[] args) {
        int[] source = {4, 5, 1, 7, 10, 1, 3};
//        int partition = partition(source, 0, source.length - 1);
//        System.out.println(partition);
        quickSort(source, 0, source.length - 1);
        for (int i : source) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 快速排序，利用
    public static void quickSort(int[] arr, int left, int right) {
        if(right - left <= 0) {
            return;
        }
        int partition = partition(arr, left, right);
        // left sort;
        quickSort(arr, left, partition - 1);
        // right sort;
        quickSort(arr, partition + 1, right);
    }


    // 根据position划分数组，position为数组最后一个元素
    public static int partition(int[] source, int left, int right) {
        int leftPtr = left - 1;
        int rightPtr = right;
        int position = source[right];

        while(true) {
            while(leftPtr < right && source[++leftPtr] < position);
            while(rightPtr > left && source[--rightPtr] > position);
            // exchange
            if (leftPtr < rightPtr) {
                int temp = source[leftPtr];
                source[leftPtr] = source[rightPtr];
                source[rightPtr] = temp;
            } else {
                break;
            }
        }
        int temp = source[right];
        source[right] = source[leftPtr];
        source[leftPtr] = temp;
        return leftPtr;
    }
}
