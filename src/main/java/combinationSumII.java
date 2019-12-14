import java.util.ArrayList;
import java.util.Arrays;

/*
40. Combination Sum II
Medium

1217

52

Favorite

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class combinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                return;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, i, path);
            path.remove(path.size() - 1);
        }
    }
}
