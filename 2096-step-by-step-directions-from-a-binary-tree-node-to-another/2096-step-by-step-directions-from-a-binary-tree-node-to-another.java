class Solution {
    
    String result = "";
    
    TreeNode lowestCommonAncestor(TreeNode root, int s, int e){
        if(root == null){
            return null;
        }
        
        if(root.val == s || root.val == e){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, s, e);
        TreeNode right = lowestCommonAncestor(root.right, s, e);
        
        if(left != null && right != null){
            return root;
        }
        
        return left == null ? right : left;
    }
    
    void findStartFromLCA(TreeNode lca, int s, StringBuilder curr){
        if(lca == null){
            return;
        }
        
        if(lca.val == s){
            result += curr;
            return;
        }
        
        findStartFromLCA(lca.left, s, curr.append("U"));
        curr.deleteCharAt(curr.length() - 1);
        findStartFromLCA(lca.right, s, curr.append("U"));
        curr.deleteCharAt(curr.length() - 1);
    }
    
    void findDestFromLCA(TreeNode lca, int d, StringBuilder curr){
        if(lca == null){
            return;
        }
        
        if(lca.val == d){
            result += curr;
            return;
        }
        
        findDestFromLCA(lca.left, d, curr.append("L"));
        curr.deleteCharAt(curr.length() - 1);
        findDestFromLCA(lca.right, d, curr.append("R"));
        curr.deleteCharAt(curr.length() - 1);
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
        
        findStartFromLCA(lca, startValue, new StringBuilder());
        findDestFromLCA(lca, destValue, new StringBuilder());
        return result;
    }
}