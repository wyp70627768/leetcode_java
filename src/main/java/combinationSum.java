import java.util.ArrayList;
import java.util.Arrays;

/*
39. Combination Sum
Medium

2728

85

Favorite

Share
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        dfs(candidates, target, ans, 0, new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, int index, List<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                return;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, i, path);
            path.remove(path.size() - 1);
        }
    }
}
