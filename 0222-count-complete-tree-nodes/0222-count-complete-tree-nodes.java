class Solution {
     //function to find depth of tree on left side
    int leftDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            node=node.left;
            depth++;
        }
        return depth;
    }
    
    //function to find depth of tree on right side
    int rightDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            node=node.right;
            depth++;
        }
        return depth;
    }
    
    //main function
    public int countNodes(TreeNode root) {
        
        int left=leftDepth(root);
        int right=rightDepth(root);
        
        //if both the leftmost and right most depth are equal that means
		//its perfect tree so no. of nodes would be 2^h-1
        if(left==right){
            return (int)Math.pow(2,left)-1;
        }
        //otherwise it will call count function for left and right subtrees
		//and add 1 for root node
        return 1+countNodes(root.left)+countNodes(root.right);
        
    }
}