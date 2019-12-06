/*
6. ZigZag Conversion
Medium

1285

3850

Favorite

Share
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
public class zigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder[] pattern = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            pattern[i] = new StringBuilder();
        }
        int index = 0, step = 1;
        for (char ch: s.toCharArray()) {
            pattern[index].append(ch);
            if (index == 0) {
                step = 1;
            }
            if (index == numRows - 1) {
                step = -1;
            }
            index += step;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(pattern[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        System.out.println(convert(s1, 3));
        System.out.println(convert(s1, 4));
    }
}
