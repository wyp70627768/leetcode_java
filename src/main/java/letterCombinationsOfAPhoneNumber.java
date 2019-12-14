import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
17. Letter Combinations of a Phone Number
Medium

2855

351

Favorite

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class letterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return ans;
        }
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, ans);
        return ans;
    }

    public void helper(HashMap<Character, char[]> map, String digits, StringBuilder sb, List<String> ans) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        for (char c: map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
