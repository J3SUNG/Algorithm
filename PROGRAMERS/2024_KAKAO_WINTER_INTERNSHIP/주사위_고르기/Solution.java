class Solution {
  static int[] answer;
  static int[][] d;
  static int[] aDice;
  static int[] bDice;
  static int[] aValue;
  static int[] bValue;
  static int resultWin;
  static int resultDraw;

  public int[] solution(int[][] dice) {
    d = dice;
    answer = new int[d.length / 2];
    aDice = new int[d.length / 2];
    bDice = new int[d.length / 2];
    resultWin = 0;
    resultDraw = 0;

    for (int i = 0; i < d.length; ++i) {
      aDice[0] = i;
      getDice(i, 1);
    }
    return answer;
  }

  public static void getDice(int index, int size) {
    if (size == d.length / 2) {
      calcValue();
      return;
    }

    for (int i = index + 1; i < d.length; ++i) {
      aDice[size] = i;
      getDice(i, size + 1);
    }
  }

  public static void calcValue() {
    int num = 0;
    int aIndex = 0;
    int bIndex = 0;
    aValue = new int[501];
    bValue = new int[501];

    for (int i = 0; i < d.length; ++i) {
      if (aIndex < d.length / 2 && aDice[aIndex] == i) {
        ++aIndex;
        continue;
      }
      bDice[bIndex] = i;
      ++bIndex;
    }

    for (int i = 0; i < 6; ++i) {
      ++aValue[d[aDice[0]][i]];
      ++bValue[d[bDice[0]][i]];
    }
    sumDiceValue(1, true);
    sumDiceValue(1, false);

    int aWin = 0;
    int draw = 0;
    for (int i = 0; i < 501; ++i) {
      num += aWin * aValue[i];
      draw += aValue[i] * bValue[i];
      aWin += bValue[i];
    }

    if (resultWin < num) {
      resultWin = num;
      resultDraw = draw;
      for (int i = 0; i < d.length / 2; ++i) {
        answer[i] = aDice[i] + 1;
      }
    } else if (resultWin == num && resultDraw < draw) {
      resultWin = num;
      resultDraw = draw;
      for (int i = 0; i < d.length / 2; ++i) {
        answer[i] = aDice[i] + 1;
      }
    }
  }

  public static void sumDiceValue(int cnt, boolean isA) {
    if (cnt == d.length / 2) {
      return;
    }
    if (isA) {
      for (int i = 500; i >= 0; --i) {
        if (aValue[i] > 0) {
          for (int j = 0; j < 6; ++j) {
            aValue[i + d[aDice[cnt]][j]] += aValue[i];
          }
          aValue[i] = 0;
        }
      }
    } else {
      for (int i = 500; i >= 0; --i) {
        if (bValue[i] > 0) {
          for (int j = 0; j < 6; ++j) {
            bValue[i + d[bDice[cnt]][j]] += bValue[i];
          }
          bValue[i] = 0;
        }
      }
    }
    sumDiceValue(cnt + 1, isA);
  }
}