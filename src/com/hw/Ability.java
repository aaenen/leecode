package com.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用数组代表每个人的能力，一个比赛活动要求参赛团队的最低能力值为N，每个团队可以由1人或2人组成，
 * 且一个人只能参加1个团队，请计算最多可以派出多少只符合要求的团队
 * 第一行数组代表总人数 第二行数组代表每个人的能力，第三行数值为团队要求的最低能力值
 * 5
 * 3 1 5 7 9
 * 8
 */
public class Ability {
    public static void main(String[] args) {
        //获取字符串
        Scanner sc = new Scanner(System.in);
        //使用nextLine()方法时，不将空格看做是两个字符串的间隔，而是看作字符串的一部分，返回时，它作为String类型一并返回
        //
        int n = Integer.parseInt(sc.nextLine());
        //把字符串中的空格去了，就可以当成数字保存在数组中
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int base = Integer.parseInt(sc.nextLine());
        System.out.println(team(nums,base));
    }
    private static int team(int[] nums,int low){
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        //将nums里的数据进行排序
        Arrays.sort(nums);
        //数组中有大于最低能力值的人可以单独拎出来一人成队
        for(int num : nums){
            if (num > low) {
                count++;
            }
        }
        //双向遍历，i==j时停止，nums[i] + nums[j] >= low时，count++，返回count
        int i = 0, j = nums.length - count- 1;
        while(i < j){
            if (nums[i] + nums[j] >= low) {
                count++;
                i++;
                j--;
            }
            else {
                i++;
            }
        }
        return count;
    }
}
