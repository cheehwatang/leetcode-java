package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns.
// With the worst case being that we check every position in the 'maze'.
//
// Space Complexity : O(m + n),
// where 'm' is the number of rows, and 'n' is the number of columns.
// The queue grows linearly with the rows and columns of the matrix,
// as we are constantly removing nodes from the queue at each step,
// with the max queue size being the distance from the center to the edge of the 'maze'.
//
// If we use a 2D boolean array for the visited nodes, then the space complexity is O(m * n).

public class NearestExitFromEntranceInMaze {
    // Approach:
    // A classic breadth first search problem, we use slowly expanding from the starting node.
    // We can imagine every position in the 'maze' as a node with the 'maze' being a directional graph,
    // since we cannot visit the same node twice to find the shortest path to the exit.
    // As such, we take one step at a time to all directions to a new valid position.
    // Note to check for invalid moves, either that direction is out of bound or towards a wall.
    // If that direction leads to a border space, it means it is the exit.
    // With breadth first search, we use Queue store the nodes for the next step.
    //
    // To mark the visited node, we can either use an additional 2D boolean array to record,
    // or mark the visited node as a wall '+' in 'maze', latter which is implemented here.

    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;

        // For breadth first search, offer the first node ('entrance').
        // Note that we immediately mark the node as visited when putting into the queue as to
        // prevent other nodes from visiting it. Otherwise, we will be trapped in an infinite loop.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        // As simple 2D array to keep track of the directions to take.
        // We can use 4 separate operation, but it is more efficient to use a for-loop to go through the four directions.
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            // We take a step before checking the directions for the nodes that we are at (in the queue).
            steps++;

            // Make sure to use a variable to keep track of the queue.size(),
            // because the queue size continuously changes as we check for the other nodes,
            // which can lead to infinite loops or undue termination of the for-loop.
            int n = queue.size();

            // Check every node at the current step.
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();
                // For each node, check every direction.
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    // Check if this direction out of bound.
                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    // Check if this direction is the wall.
                    if (maze[x][y] == '+') continue;

                    // If this direction is empty, not visited and is at the boundary, we have arrived at the exit.
                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;

                    // Otherwise, we change this direction as visited and put into the queue to check at the next step.
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }

        }
        // If all the possible nodes and directions checked but no exits found, return -1.
        return -1;
    }
}
