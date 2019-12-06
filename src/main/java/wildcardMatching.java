/*
44. Wildcard Matching
Hard

1445

83

Favorite

Share
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
 */
public class wildcardMatching {
    public static boolean isMatch(String s, String p) {
        if (s == null && p == null)
            return true;
        if (s == null || p == null)
            return false;
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];

        return dfs(s, 0, p, 0, memo, visited);
    }
    private static boolean dfs(String s, int i, String p, int j, boolean[][] memo, boolean[][] visited) {
        if (i == s.length()) {
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (j == p.length()) {
            return i == s.length();
        }
        if (visited[i][j] == true)
            return memo[i][j];
        boolean matched;
        if (p.charAt(j) == '*') {
            matched = dfs(s, i + 1, p, j, memo, visited) || dfs(s, i, p, j + 1, memo, visited);
        } else {
            matched = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && dfs(s, i + 1, p, j + 1, memo, visited);
        }
        visited[i][j] = true;
        memo[i][j] = matched;
        return matched;
    }
    public static void main(String[] args) {
        String s1 = "aa";
        String p1 = "*";
        String s2 = "cb";
        String p2 = "?a";
        String s3 = "adceb";
        String p3 = "*a*b";
        String s4 = "acdcb";
        String p4 = "a*c?b";
        String s5 = "aa";
        String p5 = "a";
        System.out.println(isMatch(s1, p1));
        System.out.println(isMatch(s2, p2));
        System.out.println(isMatch(s3, p3));
        System.out.println(isMatch(s4, p4));
        System.out.println(isMatch(s5, p5));

    }
}
