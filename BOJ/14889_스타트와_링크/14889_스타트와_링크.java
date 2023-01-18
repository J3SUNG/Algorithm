package com.ssafy.ws.step;

import java.util.Scanner;

public class test {
  public static int[][] arr;
  public static int n;
  public static int ans = Integer.MAX_VALUE;
  public static void dfs(int bit, int index, int cnt) {	  
    if(n / 2 == cnt){
      int a = 0;
      int b = 0;
      for(int i=0; i<n; ++i){
        for(int j=i+1; j<n; ++j){
          if(((1<<i & bit) == 0) && ((1<<j & bit) == 0)){
            a += arr[i][j];
            a += arr[j][i];
          } else if(((1<<i & bit) != 0) && ((1<<j & bit) != 0)) {
            b += arr[i][j];
            b += arr[j][i];
          }
        }
      }
      ans = Math.min(ans, Math.abs(a-b));
      return;
    }
    for(int i=index; i<n; ++i){
      dfs((bit | 1<<i), index+1, cnt+1);
    }
  }

  public static void main(String args[]) throws Exception
  {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];
    for(int i=0; i<n; ++i){
      for(int j=0; j<n; ++j){
        arr[i][j] = sc.nextInt();
      }
    }
    dfs(1, 1, 1);

    System.out.printf("%d%n", ans);
  }
}