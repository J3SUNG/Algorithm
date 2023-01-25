import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[8][7];
		int n = sc.nextInt();
		String s = sc.next();
		String ans = "";
		char c;
		int bit;
		boolean chk;
		
		arr[0][0] = 0B000000;
		arr[1][0] = 0B001111;
		arr[2][0] = 0B010011;
		arr[3][0] = 0B011100;
		arr[4][0] = 0B100110;
		arr[5][0] = 0B101001;
		arr[6][0] = 0B110101;
		arr[7][0] = 0B111010;
		
		for(int i=0; i<8; ++i) {
			for(int j=1; j<=6; ++j) {
				arr[i][j] = (arr[i][0] ^ (1 << j - 1));
			}
		}
		
		for(int i=0; i<n; ++i) {
			bit = 0;
			for(int j=0; j<6; ++j) {
				if(s.charAt(i*6 + j) - '0' == 1) {
					bit = bit | (1 << 5-j);
				}
			}
			chk = false;
			for(int j=0; j<8; ++j) {
				if(chk) {
					break;
				}
				for(int k=0; k<=6; ++k) {
					if(arr[j][k] == bit) {
						c = (char) ('A' + j);
						ans += c;
						chk = true;
						break;
					}
				}
			}
			if(!chk) {
				System.out.printf("%d%n", i+1);
				return;
			}
		}
		System.out.printf("%s%n", ans);
	}
}