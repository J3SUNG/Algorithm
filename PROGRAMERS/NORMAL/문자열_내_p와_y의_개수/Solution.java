class Solution {
    boolean solution(String s) {
        int num = 0;
        
        s = s.toLowerCase();
        
        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i) == 'p') ++num;
            if(s.charAt(i) == 'y') --num;
        }

        return num == 0;
    }
}