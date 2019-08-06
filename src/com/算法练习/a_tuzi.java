package com.算法练习;

/*【程序1】
题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
幼仔对数=前月成兔对数
成兔对数=前月成兔对数+前月幼仔对数
总体对数=本月成兔对数+本月幼仔对数
nums(n-1)+nums(n-2);斐波那契数列
*/

import java.util.Scanner;

public class a_tuzi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月数:");
        int n = scanner.nextInt();
        System.out.println("第"+n+"个月的兔子总数是："+nums(n));

    }
    public static int nums(int n){
        if (n<3){
            return 1;
        }
        else {
            return nums(n-1)+nums(n-2);
        }
    }


}
