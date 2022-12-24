package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n * k),
// where 'm' is the number of rows in 'board', 'n' is the number of columns in 'board', and 'k' is the length of 'word'.
// This is because that we traverse the whole matrix.
// At each position in the 'board', where check a maximum of length 'k' of 'word'.
//
// Space Complexity : O(m * n),
// where 'm' is the number of rows in 'board', and 'n' is the number of columns in 'board'.
// This is due to the boolean table we use to track the visited positions/nodes.
// If we use either bitmasking or changing the 'board' to record the visited nodes,
// then the space complexity will be the recursive call stack, which has a maximum height of 'k', the length of 'word'.

public class WordSearch {

    // Approach:
    // For every position on the 'board',
    // perform depth first search (DFS) and backtracking to check if 'word' is in the 'board',
    // with the help of a boolean matrix to keep track of the visited positions.

    // Main method to traverse through 'board' and initiate DFS.
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // As we are using backtracking, we can just use a single boolean matrix to keep track of the visited nodes.
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                // If the recursive DFS method successfully traverse the 'word' in the 'board',
                // then return true.
                if (dfs(board, chars, row, column, 0, visited)) return true;
            }
        }
        // If we search the whole 'board' but did not find the 'word', then return false.
        return false;
    }

    // Depth First Search (DFS) recursive method.
    private boolean dfs(char[][] board, char[] chars, int row, int column, int position, boolean[][] visited) {
        // If we have successfully found all the letters in 'word', then return true.
        if (position == chars.length) return true;

        // If the 'row' and 'column' is out of bound, or is already visited previously, return false.
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column]) return false;
        // If the character is different and does not match, return false.
        if (board[row][column] != chars[position]) return false;

        // Before checking all four directions for the next letter, set the current position as visited,
        // so we do not accidentally revisit the same position twice.
        visited[row][column] = true;

        // Check all four directions.
        boolean isPathExist = dfs(board, chars, row + 1, column, position + 1, visited) ||
                dfs(board, chars, row - 1, column, position + 1, visited) ||
                dfs(board, chars, row, column + 1, position + 1, visited) ||
                dfs(board, chars, row, column - 1, position + 1, visited);
        // For backtracking, we set the visited position back to false.
        visited[row][column] = false;
        // Return if any of the recursive calls successfully return true.
        return isPathExist;
    }
}
