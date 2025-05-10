class Solution {
    public long solution(int price, int money, int count) {   
        long cost = (long)count * (count + 1) / 2 * price - money;
        
        return cost < 0 ? 0 : cost;
    }
}