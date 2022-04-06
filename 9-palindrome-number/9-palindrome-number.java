class Solution {
    public boolean isPalindrome(int x) {
        // first approach
        /**if(x<0)
        *    return false;
        *  int temp=x;
        *  int rem=0,rev=0;
        *  while(x!=0){  
        *   rem=x%10;
        *   rev=(rev*10)+rem;
        *   x=x/10;
        *  }   
        * return temp==rev;
        */
        // second approach
        String str=String.valueOf(x);
        int len=str.length();
        for(int i=0;i<len/2;i++){
            if(str.charAt(i)!=str.charAt(len-1-i))
                return false;
        }
        
        return true;
    }
}