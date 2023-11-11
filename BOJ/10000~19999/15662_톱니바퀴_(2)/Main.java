import java.util.Scanner;

public class Main {
  static int[] arr;

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    arr = new int[n];
    int num;
    int cycle;
    int index, d, d2;
    int tmp;
    int l, r;
    int ans = 0;

    for (int i = 0; i < n; ++i) {
      num = sc.nextInt();
      for (int j = 0; j < 8; ++j) {
        if (num % 10 == 1) {
          arr[i] += (1 << j);
        }
        num /= 10;
      }
    }

    cycle = sc.nextInt();
    for (int i = 0; i < cycle; ++i) {
      index = sc.nextInt() - 1;
      d = sc.nextInt();
      r = (arr[index] & 0B100000) >> 5;
      l = (arr[index] & 0B10) >> 1;
      rotation(index, d);

      d2 = d;
      for (int j = index + 1; j < n; ++j) {
        if ((((arr[j] & 0B10) >> 1) ^ r) == 0) {
          break;
        }
        r = (arr[j] & 0B100000) >> 5;
        d2 *= -1;
        rotation(j, d2);
      }

      d2 = d;
      for (int j = index - 1; j >= 0; --j) {
        if ((((arr[j] & 0B100000) >> 5) ^ l) == 0) {
          break;
        }
        l = (arr[j] & 0B10) >> 1;
        d2 *= -1;
        rotation(j, d2);
      }
    }
    for (int i = 0; i < n; ++i) {
      if ((arr[i] & 0B10000000) != 0) {
        ++ans;
      }
    }
    System.out.println(ans);
  }

  public static void rotation(int index, int d) {
    int tmp;
    if (d == -1) {
      tmp = arr[index] >> 7;
      arr[index] = arr[index] << 1;
      arr[index] = arr[index] & 0B11111111;
      arr[index] = arr[index] | tmp;
    } else {
      tmp = arr[index] & 1;
      arr[index] = arr[index] >> 1;
      arr[index] = arr[index] | (tmp << 7);
    }
  }
}