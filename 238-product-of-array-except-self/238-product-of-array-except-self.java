class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] answer = new int [nums.length];
        int mulWithZero = 1;
        int mulWithoutZero = 1;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)  mulWithoutZero *= nums[i];
            else count++;
                  
        }
        
        for(int i = 0; i < nums.length; i++){              
            switch(count){  
              case 0:   answer[i] = mulWithoutZero / nums[i];
               break;  
            
              case 1: if (nums[i] == 0)
                        answer[i] = mulWithoutZero;
                    else
                        answer[i] = 0;
               break;    
            
              default: answer[i] = 0;
           }  
        }
        return answer;
    }
}