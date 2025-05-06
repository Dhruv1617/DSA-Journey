/*
LeetCode #13: Roman to Integer
https://leetcode.com/problems/roman-to-integer/

Easy | String

Time Complexity: O(n), where n is the length of the input string.
Space Complexity: O(1), since we use a fixed-size array for symbol values.

Approach:
- Map each Roman symbol to its integer value using a fixed-size array.
- Traverse the string from right to left.
- Add the value if it’s greater than or equal to the previous, otherwise subtract.
- This approach naturally handles the subtraction rule in Roman numerals.
*/
class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0, prev = 0;
        for(int i = s.length()-1;i>=0;i--){
            int current = values[s.charAt(i)];
            if(current>=prev){
                result+=current;
            }else{
                result-=current;
            }
            prev = current;
        }
        return result;

        
    }
}
