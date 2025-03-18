class Solution {
  public int dfs(int hp, boolean[] visit, int[][] dungeons) {
    int maxCount = 0;

    for (int i = 0; i < dungeons.length; ++i) {
      if (!visit[i] && hp >= dungeons[i][0]) {
        visit[i] = true;
        maxCount = Math.max(maxCount, dfs(hp - dungeons[i][1], visit, dungeons) + 1);
        visit[i] = false;
      }
    }

    return maxCount;
  }

  public int solution(int k, int[][] dungeons) {
    int maxDungeons = 0;
    boolean[] visit = new boolean[dungeons.length];

    for (int i = 0; i < dungeons.length; ++i) {
      if (k >= dungeons[i][0]) {
        visit[i] = true;
        maxDungeons = Math.max(maxDungeons, dfs(k - dungeons[i][1], visit, dungeons) + 1);
        visit[i] = false;
      }
    }

    return maxDungeons;
  }
}
