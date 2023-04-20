package 线程;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class test03 {

    public static void main(String[] args) {

        int count = 0;
        T t = new T();
        count = t.check(0);
        System.out.println("八皇后解法有：" + count + " 种");

    }
}


class T {

    int[] arr = new int[8];
    int count = 0;

    public int check(int index) {  // 从0行开始

        if (index == 8) { // 退出条件：index能增加到8

            // 可输出数组看看
            for (int i = 0; i < 8; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            count++;

        } else {  // 递归
            for (int i = 0; i < 8; i++) {  // 8 列
                arr[index] = i;  // index行，i列
                if (judge(index)) {  // 如果该行皇后放置成功，则可以递归进入下一行进行放置，直至到达退出条件
                    check(index + 1);
                }
            }
        }

        return count;
    }

    // 判断该皇后是否与之前的皇后冲突
    public boolean judge(int index) {

        for (int i = 0; i < index; i++) {
            if (arr[index] == arr[i] || Math.abs(index - i) == Math.abs(arr[index] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}