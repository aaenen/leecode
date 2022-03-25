package com.sword;

import java.util.Scanner;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */

/**
 * 很显然这是要用递归解决
 */
public class MovingCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split("");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        int k = Integer.parseInt(strings[2]);
        System.out.println(movingCount(m, n, k));
    }

    private static int movingCount(int m, int n, int k) {
        //判断是否被访问过
        boolean[][] isVisited = new boolean[m][n];
        return dfs(0, 0, m, n, k, isVisited);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean isVisited[][]) {
        //递归最重要的就是判断边界，然后就是无条件相信递归
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || isVisited[i][j]) {
            return 0;
        }
        isVisited[i][j] = true;
        //每走一次就+1
        return dfs(i + 1, j, m, n, k, isVisited) + dfs(i, j + 1, m, n, k, isVisited) + 1;
    }
}
