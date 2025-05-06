/*
LeetCode #451: Sort Characters By Frequency
https://leetcode.com/problems/sort-characters-by-frequency/

Medium | String, HashMap, Sorting

Time Complexity: O(n log n), where n is the number of unique characters.
Space Complexity: O(n)

Approach:
- Use a HashMap to count the frequency of each character.
- Sort characters by their frequency in descending order.
- Build the final string by repeating characters based on frequency.
*/

class Solution {
    public String frequencySort(String s) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> charList = new ArrayList<>(freqMap.keySet());

        charList.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder result = new StringBuilder();
        for (char c : charList) {
            int freq = freqMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
