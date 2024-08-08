class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols;  // Total number of cells to visit
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
        int[][] res = new int[n][2];  // Result array to store the coordinates

        int step = 0;  // Number of steps to take in the current direction
        int dir = 0;   // Direction index
        int r = rStart, c = cStart;  // Current position
        res[0][0] = r;
        res[0][1] = c;
        int index = 1;  // Index in the result array

        while (index < n) {
            if (dir == 0 || dir == 2) {  // Increase step size after moving right or left
                step++;
            }

            for (int count = 0; count < step; count++) {
                r += direction[dir][0];
                c += direction[dir][1];

                if (r >= 0 && r < rows && c >= 0 && c < cols) {  // Only add valid positions
                    res[index][0] = r;
                    res[index][1] = c;
                    index++;
                }
            }

            dir = (dir + 1) % 4;  // Change direction
        }

        return res;
    }
}


// Time and Space Complexity 

// Time--> O(max(rows, cols))^2
// Space --> O(1)