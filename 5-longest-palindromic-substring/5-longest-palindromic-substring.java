class Solution {
    public String expand(String s,int l,int h){
        while(l>=0 && h<s.length() && s.charAt(l)==s.charAt(h)){
            l--;
            h++;
        }
        return s.substring(l+1,h);
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==0){
            return s;
        }
        String max_str="",cur;
        for(int i=0;i<n;i++){
            cur=expand(s,i,i);
            if(cur.length()>max_str.length()){
                max_str=cur;
            }
            cur=expand(s,i,i+1);
            if(cur.length()>max_str.length()){
                max_str=cur;
            }
        }
        return max_str;
    }
}