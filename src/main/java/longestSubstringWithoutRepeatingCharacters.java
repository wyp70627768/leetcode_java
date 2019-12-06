import static java.lang.System.out;

/*
3. Longest Substring Without Repeating Characters
Medium

7056

418

Favorite

Share
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class longestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] index = new int[128];
        int ans = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = Math.max(j, index[s.charAt(i)]);
            ans = Math.max(ans, i - j + 1);
            index[s.charAt(i)] = i + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        out.println(lengthOfLongestSubstring(s1));
        out.println(lengthOfLongestSubstring(s2));
        out.println(lengthOfLongestSubstring(s3));
    }
}
