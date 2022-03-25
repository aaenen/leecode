package com.sword;

/**
 * 矩阵中的路径
 * 给定一个m x n 二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true ；否则，返回false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'D', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCE";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        char[] wordToChar = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //首先找到第一个字母对应的
                if (board[i][j] == wordToChar[0]) {
                    if (dfs(board, i, j, isVisited, wordToChar, 0)) return true;
                }
            }
        }
        return false;
    }

    /**
     * create by: aaenen
     * description: TODO
     * create time: 2022/3/15 18:28
     *
     * @return true/null
     * @Param: 传入要遍历的数组/数组的第i行/数组的第j列/该元素是否被访问过/需要遍历的单词/需要遍历的单词数组下标
     */
    private static boolean dfs(char[][] board, int i, int j, boolean[][] isVisited, char[] wordToChar, int index) {
        if (index == wordToChar.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != wordToChar[index]) {
            return false;
        }
        //在遍历到当前 board[i][j] 的时候，首先应将该位置的 visited[i][j] 设置为 true，表明访问过；
        isVisited[i][j] = true;
        boolean res = dfs(board, i + 1, j, isVisited, wordToChar, index + 1)
                || dfs(board, i - 1, j, isVisited, wordToChar, index + 1)
                || dfs(board, i, j + 1, isVisited, wordToChar, index + 1)
                || dfs(board, i, j - 1, isVisited, wordToChar, index + 1);
        //在 dfs 的过程当中，如果某条路已经不通了，那么那么需要回溯，也就是将 visited[i][j] 位置的布尔值重新赋值为 fasle；
        isVisited[i][j] = false;
        return res;
    }
}
