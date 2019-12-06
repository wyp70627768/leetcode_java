import java.util.HashMap;

/*
10. Regular Expression Matching
Hard

3329

611

Favorite

Share
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */
public class regularExpressionMatching {
    public static boolean isMatch1(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s.length() == 0 && p.length() == 0)
            return true;
        return dfs(s, 0, p, 0, new HashMap<point, Boolean>());
    }
    private static boolean dfs(String s, int i, String p, int j, HashMap<point, Boolean> memo) {
        if (i == s.length())
            return isEmpty(p.substring(j));
        if (j == p.length())
            return false;
        point coor = new point(i, j);
        if (memo.containsKey(coor))
            return memo.get(coor);
        boolean matched;
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            matched = ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(s, i + 1, p, j, memo)) || dfs(s, i, p, j + 2, memo);
        } else {
            matched = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dfs(s, i + 1, p, j + 1, memo);
        }
        memo.put(coor, matched);
        return matched;
    }
    private static boolean isEmpty(String strs) {
        if (strs.length()%2 == 1)
            return false;
        for (int i = 0; i < strs.length()/2; i++) {
            if (strs.charAt(i*2 + 1) != '*')
                return false;
        }
        return true;
    }

    public static boolean isMatch2(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    private static boolean isMatchHelper(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited) {
        if (pIndex == p.length())
            return sIndex == s.length();
        if (sIndex == s.length())
            return isEmpty(p.substring(pIndex));
        if (visited[sIndex][pIndex])
            return memo[sIndex][pIndex];

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited) || ((s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') && isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited));
        } else {
            match = (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') && isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    public static boolean isMatch3(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[i][j] |= dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }



    public static void main(String[] args) {
        String s1 = "aa";
        String p1 = "a";
        String s2 = "aa";
        String p2 = "a*";
        String s3 = "ab";
        String p3 = ".*";
        String s4 = "aab";
        String p4 = "c*a*b";
        String s5 = "mississippi";
        String p5 = "mis*is*p*.";

        System.out.println(isMatch1(s1, p1));
        System.out.println(isMatch1(s2, p2));
        System.out.println(isMatch1(s3, p3));
        System.out.println(isMatch1(s4, p4));
        System.out.println(isMatch1(s5, p5));
        System.out.println(isMatch2(s1, p1));
        System.out.println(isMatch2(s2, p2));
        System.out.println(isMatch2(s3, p3));
        System.out.println(isMatch2(s4, p4));
        System.out.println(isMatch2(s5, p5));
        System.out.println(isMatch3(s1, p1));
        System.out.println(isMatch3(s2, p2));
        System.out.println(isMatch3(s3, p3));
        System.out.println(isMatch3(s4, p4));
        System.out.println(isMatch3(s5, p5));
    }
}
