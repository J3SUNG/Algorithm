import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] day = new int[n+1];
		int[] pay = new int[n+1];
		int[] DP = new int[n+1];
		for(int i=0; i<n; ++i) {
			day[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; ++i) {
			if(i+day[i] <= n) {
				DP[i+day[i]] = Math.max(DP[i+day[i]], DP[i] +pay[i]);							
			}
			DP[i+1] = Math.max(DP[i+1], DP[i]);
		}
		
		System.out.println(DP[n]);
	}

}