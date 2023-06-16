import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int bag = Integer.parseInt(st.nextToken());
		int ansTime = Integer.MAX_VALUE;
		int ansHeight = Integer.MIN_VALUE;
		int num;
		int numAsc = 0;
		int numDes = 0;
		int time = 0;
		int[] numArr = new int[257];
		int[] cumSumAsc = new int[257];
		int[] cumSumDes = new int[257];
		
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j) {
				num = Integer.parseInt(st.nextToken());
				++numArr[num]; 
			}
		}
		
		for(int i=1; i<=256; ++i) {
			numAsc += numArr[i-1];
			cumSumAsc[i] += cumSumAsc[i-1] + numAsc;
		}
		for(int i=256-1; i>=0;--i) {
			numDes += numArr[i+1];
			cumSumDes[i] += cumSumDes[i+1] + numDes;
		}
		
		
		for(int i=0; i<=256; ++i) {
			if(bag + cumSumDes[i] - cumSumAsc[i] < 0 ) {
				continue;
			}
			time = cumSumAsc[i] + (cumSumDes[i] * 2);
			if(ansTime > time) {
				ansTime = time;
				ansHeight = i;
			} else if(ansTime == time) {
				ansHeight = Math.max(ansHeight, i);
			}
		}
		
		System.out.println(ansTime + " " + ansHeight);
	}
}
