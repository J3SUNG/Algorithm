class Solution {
    public boolean solution(String s) {
        int len = s.length();
        
        if(len != 4 && len != 6) return false;
        
        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        
        return true;
    }
}