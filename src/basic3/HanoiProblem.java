package basic3;

public class HanoiProblem {


    public static void main(String[] args) {
        hanoi(8, 'a', 'b', 'c');
    }

    public static void hanoi(int topN, char from, char inter, char to) {
        if (topN == 1) { // 此处到1并非是底层的代数，而是表示只有一个的这种情况
            System.out.println("第1层从" + from + "到" + to);
        } else {
            // 将会变的值用参数替代
            hanoi(topN - 1, from, to, inter); // 将上层以to为基准移动到inter
            System.out.println("第" + (topN) + "层从" + from + "移到" + to); // 将底层移动到c
            hanoi(topN - 1, inter, from, to);
        }
    }
}
