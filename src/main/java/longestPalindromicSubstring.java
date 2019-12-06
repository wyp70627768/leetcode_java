/*
5. Longest Palindromic Substring
Medium

4869

434

Favorite

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class longestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxL = Math.max(len1, len2);
            if (maxL > right - left) {
                left = i - (maxL - 1)/2;
                right = i + maxL/2;
            }
        }
        return s.substring(left, right + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }
}
