package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the graph.
// We traverse the graph from 'node1' and 'node2' once, with the worst-case of traversing the whole graph.
// Additionally, we check every node for their distance to 'node1' and 'node2'.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the graph.
// We created two arrays of size 'n' to record the distance of each node from 'node1' and 'node2' respectively.

public class FindClosestNodeToGivenTwoNodes_DFS {

    // Approach:
    // Traverse the graph from 'node1' and 'node2' to get the distance of each connected node,
    // respectively in separate integer array.
    // Then, find and return the node that is with the minimum max distance from 'node1' and 'node2'.

    // Main method to find the closest meeting node for 'node1' and 'node2'.
    public int closestMeetingNode(int[] edges, int node1, int node2) {

        // The function for the depth-first search to get the distance of each node from 'node1' and 'node2'
        // is extracted out for its reusability and better readability with named function.
        // Note: An alternative to Integer Array is to use HashMap.
        int[] distanceArray1 = getDistanceArray(edges, node1);
        int[] distanceArray2 = getDistanceArray(edges, node2);

        // Minimum distance from the maximum distance between 'node1' and 'node2'
        // is set to Integer.MAX_VALUE as we are finding the minimum.
        int minDistance = Integer.MAX_VALUE;

        // If 'node1' and 'node2' do not have the same connected nodes, the default value is returned, which is -1.
        // If any connected nodes are found, then result will not be -1.
        int result = -1;

        // Once we have the distance array for both 'node1' and 'node2',
        // check each node to see if they have the same connected node.
        for (int i = 0; i < edges.length; i++) {
            // If the node is not connected to either or both 'node1' and 'node2', continue to the next node.
            if (distanceArray1[i] == -1 || distanceArray2[i] == -1) continue;

            // Get the maximum distance of the connected both from 'node1' and 'node2'.
            // If the distance is less than the minimum distance found so far,
            // set the result to the current node and the minimum distance to the current distance.
            int distance = Math.max(distanceArray1[i], distanceArray2[i]);
            if (distance < minDistance) {
                result = i;
                minDistance = distance;
            }
        }
        // Return the index of the closest meeting node.
        // If there are no meeting node found, -1 is returned instead.
        return result;
    }

    // Method to get the array for the distance of each node from the input node.
    // If the node is not connected to the input node, -1 is used.
    private int[] getDistanceArray(int[] edges, int node) {
        // Create a distance array with the values set to -1, indicating that the node is not visited.
        int[] distanceArray = new int[edges.length];
        Arrays.fill(distanceArray, -1);

        // Traverse the graph from the input node, and record the distance from the node.
        // If the node already has a distance recorded (not -1),
        // it means that the node is visited and there is a cycle in the graph.
        // Thus, stop the traversal when a cycle is found or when we have reached the last node in the path.
        int distance = 0;
        while (node != -1 && distanceArray[node] == -1) {
            distanceArray[node] = distance++;
            node = edges[node];
        }
        // Return the distance array.
        return distanceArray;
    }
}