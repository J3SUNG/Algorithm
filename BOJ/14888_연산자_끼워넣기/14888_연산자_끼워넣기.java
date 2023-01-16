import java.util.Scanner;

public class Main{
  static int n;
  static int minAns = 987654321;
  static int maxAns = -987654321;
  static int[] arr;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    arr = new int[n];
    int[] ope = new int[4];

    for(int i=0; i<n; ++i){
      arr[i] = sc.nextInt();
    }

    for(int i=0; i<4; ++i){
        ope[i] = sc.nextInt();
    }
    
    for(int i=0; i<4; ++i){
      dfs(i, 0, arr[0], ope);  
    }

    System.out.printf("%d%n%d",maxAns, minAns);
  }

  public static void dfs(int index, int cnt, int val, int[] ope){
    --ope[index];
    ++cnt;
    if(ope[index] < 0){
	  ++ope[index];  	
      return;
    }
    switch(index){
      case 0:
        val += arr[cnt];
        break;
      case 1:
        val -= arr[cnt];
        break;
      case 2:
        val *= arr[cnt];
        break;
      case 3:
        val /= arr[cnt];
        break;
    }
    if(cnt == n - 1){
    	
      maxAns = Math.max(maxAns, val);
      minAns = Math.min(minAns, val);
      ++ope[index];
      return;
    }
    for(int i=0; i<4; ++i){
      dfs(i, cnt, val, ope);  
    }
    ++ope[index];
    return;
  }
}