import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] giftLogMap = new int[friends.length][friends.length];
        int[] giftValue = new int[friends.length];
        int[] nextGift = new int[friends.length];
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < friends.length; ++i) {
            hashMap.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; ++i) {
            String[] gift = gifts[i].split(" ");
            int from = hashMap.get(gift[0]);
            int to = hashMap.get(gift[1]);
            ++giftLogMap[from][to];
            ++giftValue[from];
            --giftValue[to];
        }

        for (int i = 0; i < friends.length; ++i) {
            for (int j = i + 1; j < friends.length; ++j) {
                if (giftLogMap[i][j] < giftLogMap[j][i]) {
                    ++nextGift[j];
                } else if (giftLogMap[i][j] > giftLogMap[j][i]) {
                    ++nextGift[i];
                } else if (giftValue[i] < giftValue[j]) {
                    ++nextGift[j];
                } else if (giftValue[i] > giftValue[j]) {
                    ++nextGift[i];
                }
            }
        }

        for (int i = 0; i < friends.length; ++i) {
            answer = Math.max(answer, nextGift[i]);
        }

        return answer;
    }
}