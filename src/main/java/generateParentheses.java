import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses
Medium

3688

214

Favorite

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class generateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n <= 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, ans);
        return ans;
    }

    private static void dfs(int n, int left, int right, StringBuilder sb, List<String> ans) {
        if (left == n && right == n) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append('(');
            dfs(n, left + 1, right, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            dfs(n, left, right + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}
