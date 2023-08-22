import java.util.*;

class Solution {
  static int bit;

  public int[] solution(long[] numbers) {
    int[] answer = {};

    for (int i = 0; i < numbers.length; ++i) {
      bit = 1;
      System.out.println(intToBinary(numbers[i]));
      System.out.println(bit);
    }
    return answer;
  }

  public int binaryToInteger(String binary) {
    char[] numbers = binary.toCharArray();
    int result = 0;
    for (int i = numbers.length - 1; i >= 0; i--)
      if (numbers[i] == '1')
        result += Math.pow(2, (numbers.length - i - 1));
    return result;
  }
}
