/*
14. Longest Common Prefix
Easy

1791

1565

Favorite

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class longestCommonPrefix {
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == prefix.length() || prefix.charAt(i) != strs[j].charAt(i))
                    return prefix.substring(0, i);
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix1(strs1));
        System.out.println(longestCommonPrefix1(strs2));
        System.out.println(longestCommonPrefix2(strs1));
        System.out.println(longestCommonPrefix2(strs2));
    }
}