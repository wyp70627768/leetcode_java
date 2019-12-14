import java.util.ArrayList;
import java.util.Arrays;

/*
47. Permutations II
Medium

1412

48

Favorite

Share
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class permutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        dfs(nums, ans, new boolean[nums.length], new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int[] nums, List<List<Integer>> ans, boolean[] visited, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, ans, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
