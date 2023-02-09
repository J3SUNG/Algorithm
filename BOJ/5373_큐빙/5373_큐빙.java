import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ts = Integer.parseInt(st.nextToken());
		char[][][] cube = new char[6][3][3]; // 위/하양 w, 아래/노랑 y, 앞/빨강 r, 뒤/주황 o, 왼/초록 g, 오/파랑 b
		while(ts>0) {
			--ts;
			Init(cube);
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; ++i) {
				String s = st.nextToken();
				MoveCube(cube, s);
			}
			PrintCube(cube);
		}
	}
	public static void MoveCube(char[][][] cube, String s) {
		Turn(cube, s);
		switch(s.charAt(0)) {
			case 'U':
				int[] uarr = {3, 4, 1, 5};
				int[] uchk = {0, 0, 0, 0};
				int[] uloc = {2, 0, 0, 0};
				SideCheck(cube, uarr, uchk, uloc, s);
				if(s.charAt(1) == '+') {
					Swap(cube, 5,0,0, 5,0,2);
					Swap(cube, 3,2,0, 3,2,2);
				} else {
					Swap(cube, 3,2,0, 3,2,2);
					Swap(cube, 4,0,0, 4,0,2);
				}
				break;
			case 'D':
				int[] darr = {1, 4, 3, 5};
				int[] dchk = {0, 0, 0, 0};
				int[] dloc = {2, 2, 0, 2};
				SideCheck(cube, darr, dchk, dloc, s);
				if(s.charAt(1) == '+') {
					Swap(cube, 4,2,0, 4,2,2);
					Swap(cube, 3,0,0, 3,0,2);
				} else {
					Swap(cube, 3,0,0, 3,0,2);
					Swap(cube, 5,2,0, 5,2,2);
				}
				break;
			case 'F':
				int[] farr = {0, 4, 2, 5};
				int[] fchk = {0, 1, 0, 1};
				int[] floc = {2, 2, 0, 0};
				SideCheck(cube, farr, fchk, floc, s);
				if(s.charAt(1) == '+') {
					Swap(cube, 0,2,0, 0,2,2);
					Swap(cube, 2,0,0, 2,0,2);
				} else {
					Swap(cube, 4,0,2, 4,2,2);
					Swap(cube, 5,0,0, 5,2,0);
				}
				break;
			case 'B':
				int[] barr = {5, 2, 4, 0};
				int[] bchk = {1, 0, 1, 0};
				int[] bloc = {2, 2, 0, 0};
				SideCheck(cube, barr, bchk, bloc, s);
				if(s.charAt(1) == '+') {
					Swap(cube, 4,0,0, 4,2,0);
					Swap(cube, 5,0,2, 5,2,2);
				} else {
					Swap(cube, 0,0,0, 0,0,2);
					Swap(cube, 2,2,0, 2,2,2);
				}
				break;
			case 'L':
				int[] larr = {1, 0, 3 ,2};
				int[] lchk = {1, 1, 1, 1};
				int[] lloc = {0, 0, 0, 0};
				SideCheck(cube, larr, lchk, lloc, s);
				break;
			case 'R':
				int[] rarr = {0, 1, 2 ,3};
				int[] rchk = {1, 1, 1, 1};
				int[] rloc = {2, 2, 2, 2};
				SideCheck(cube, rarr, rchk, rloc, s);
				break;
		}
	}
	public static void SideCheck(char[][][] cube, int[] arr, int[] chk, int[] loc, String s){
		if(s.charAt(1) == '+'){
			for(int i=0; i<3; ++i){
				SideTurn(cube, arr[i], arr[i+1], chk[i], chk[i+1], loc[i], loc[i+1]);
			}
		} else if(s.charAt(1) == '-'){
			for(int i=3; i>0; --i){
				SideTurn(cube, arr[i], arr[i-1], chk[i], chk[i-1], loc[i], loc[i-1]);
			}
		}
	}
	public static void SideTurn(char[][][] cube, int a, int b, int chk1, int chk2, int d1, int d2){
		int ay = (chk1 == 0 ? 0 : 1);
		int ax = (chk1 == 0 ? 1 : 0);
		int by = (chk2 == 0 ? 0 : 1);
		int bx = (chk2 == 0 ? 1 : 0);
		Swap(cube, a,(0*ay)+(d1*ax),(0*ax)+(d1*ay), b,(0*by)+(d2*bx),(0*bx)+(d2*by));
		Swap(cube, a,(1*ay)+(d1*ax),(1*ax)+(d1*ay), b,(1*by)+(d2*bx),(1*bx)+(d2*by));
		Swap(cube, a,(2*ay)+(d1*ax),(2*ax)+(d1*ay), b,(2*by)+(d2*bx),(2*bx)+(d2*by));
	}
	public static void Turn(char[][][] cube, String s){
		int index = 0;
		switch(s.charAt(0)){
			case 'U':
				index = 0;
				break;
			case 'F':
				index = 1;
				break;
			case 'D':
				index = 2;
				break;
			case 'B':
				index = 3;
				break;
			case 'L':
				index = 4;
				break;
			case 'R':
				index = 5;
				break;
		}
		if(s.charAt(1) == '+'){
			Swap(cube, index,0,0, index,2,0);
			Swap(cube, index,2,0, index,2,2);
			Swap(cube, index,2,2, index,0,2);
			Swap(cube, index,0,1, index,1,0);
			Swap(cube, index,1,0, index,2,1);
			Swap(cube, index,2,1, index,1,2);
		} else {
			Swap(cube, index,0,0, index,2,0);
			Swap(cube, index,0,2, index,0,0);
			Swap(cube, index,2,2, index,0,2);
			Swap(cube, index,0,1, index,1,0);
			Swap(cube, index,1,2, index,0,1);
			Swap(cube, index,2,1, index,1,2);
		}
	}
	public static void Swap(char[][][] cube, int a1, int b1, int c1, int a2, int b2, int c2) {
		char temp;
		temp = cube[a1][b1][c1];
		cube[a1][b1][c1] = cube[a2][b2][c2];
		cube[a2][b2][c2] = temp;
	}
	public static void PrintCube(char[][][] cube) {
        for(int j=0; j<3; ++j) {
            for(int k=0; k<3; ++k) {
                System.out.printf("%c", cube[0][j][k]);
            }
            System.out.println();
        }
	}
	public static void Init(char[][][] cube) {
		for(int i=0; i<6; ++i) {
			for(int j=0; j<3; ++j) {
				for(int k=0; k<3; ++k) {
					switch(i) {
						case 0:
							cube[i][j][k] = 'w';
							break;
						case 1:
							cube[i][j][k] = 'r';
							break;
						case 2:
							cube[i][j][k] = 'y';
							break;
						case 3:
							cube[i][j][k] = 'o';
							break;
						case 4:
							cube[i][j][k] = 'g';
							break;
						case 5:
							cube[i][j][k] = 'b';
							break;
					}
				}
			}
		}		
	}
}