class Solution {
    public boolean isValid(String s) {
            Stack<String> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
                switch(s.substring(i,i+1)){
                        case "(": 
                                st.push("(");
                                break;
                        case ")": 
                                if(st.size()==0)return false;
                                if( st.peek()!="(")return false;
                                st.pop();
                                break;
                        case "{": 
                                st.push("{");
                                break;
                        case "}": 
                                if(st.size()==0)return false;
                                if( st.peek()!="{")return false;
                                st.pop();
                                break;
                        case "[": 
                                st.push("[");
                                break;
                        case "]": 
                                if(st.size()==0)return false;
                                if(st.peek()!="[")return false;
                                st.pop();
                                break;
                }
        }
                if(st.size()==0)return true;
                else return false;
    }
}