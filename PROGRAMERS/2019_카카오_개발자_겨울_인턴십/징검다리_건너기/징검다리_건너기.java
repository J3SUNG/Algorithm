import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 987654321;
        int right = -1;
        int mid;
        
        for(int i=0; i<stones.length; ++i){
            left = Math.min(left, stones[i]);
            right = Math.max(right, stones[i]);
        }

        while(left <= right){
            mid = (left+right) / 2;
            int count = 0;

            for(int i=0; i<stones.length; ++i){
                if(count<k){
                    if(stones[i] <= mid){
                        ++count;
                    } else {
                        count = 0;
                    }
                } else {
                    break;
                }
            }

            if(count >= k){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}