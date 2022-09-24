class Solution {
    int count=0;
    List<Integer> temp=new ArrayList<Integer>();
    public int pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum);
        return count;
    }
    void helper(TreeNode root,int targetSum){
        if(root!=null){
            temp.add(root.val);
          helper(root.left,targetSum); 
          helper(root.right,targetSum);
            long sum=0;
            for(int i=temp.size()-1;i>=0;i--){
                sum+=temp.get(i);    
                if(sum==targetSum){
                     count++;
                }
            }
            temp.remove(temp.size()-1);
        }
    }
}