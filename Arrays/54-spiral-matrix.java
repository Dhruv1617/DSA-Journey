/*
LeetCode #54: Spiral Matrix
https://leetcode.com/problems/spiral-matrix/

Medium | Matrix, Simulation

Time: O(m * n)
Space: O(1) (excluding output list)

Approach:
- Simulate the spiral traversal using four boundary pointers: top, bottom, left, right.
- Move in the order: left to right, top to bottom, right to left, and bottom to top.
- After traversing each side, update the corresponding boundary.
- Stop when all boundaries cross each other.
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, right = m-1;
        int top = 0, bottom = n-1;
        while(top<=bottom && left<=right){
            for(int i = left; i<=right;i++){
                arr.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom;i++){
                arr.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left;i--){
                    arr.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top;i--){
                    arr.add(matrix[i][left]);
                }
                left++;
            }
            
        }
        return arr;
    }
    
}
