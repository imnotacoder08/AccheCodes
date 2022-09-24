class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root != null) dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }
    
    private void dfs(TreeNode node, int target, int currentSum, List<Integer> currentList) {
        currentSum += node.val;
        currentList.add(node.val);
        if(node.left == null && node.right == null && currentSum == target) result.add(currentList);
        if(node.left != null) dfs(node.left, target, currentSum, new ArrayList<>(currentList));
        if(node.right != null) dfs(node.right, target, currentSum, new ArrayList<>(currentList));
    }
}