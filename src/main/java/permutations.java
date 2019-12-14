import java.util.ArrayList;

/*
46. Permutations
Medium

2752

89

Favorite

Share
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return ans;
        dfs(nums, ans, new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, ArrayList<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))
                continue;
            path.add(nums[i]);
            dfs(nums, ans, path);
            path.remove(path.size() - 1);
        }
    }
}
