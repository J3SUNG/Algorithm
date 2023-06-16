import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = 0;
		String str = br.readLine();
		String temp = "";
		String[] ope = new String[50];
		String[] num = new String[50];
		int opeCnt = 0;
		int numCnt = 0;
		int loc = 987654321;
		
		for(int i=0; i<str.length(); ++i) {
			if(str.charAt(i) == '+') {
				ope[opeCnt] = "+";
				++opeCnt;
				if(!temp.equals("")) {
					num[numCnt] = temp;
					++numCnt;
					temp = "";
				}
			} else if(str.charAt(i) == '-') {
				ope[opeCnt] = "-";
				++opeCnt;
				if(!temp.equals("")) {
					num[numCnt] = temp;
					++numCnt;
					temp = "";
				}
			} else {
				temp += str.charAt(i);
			}
		}
		num[numCnt] = temp;
		++numCnt;
		
		for(int i=0; i<opeCnt; ++i) {
			if(ope[i].equals("-")) {
				loc = i + 1;
				break;
			}
		}
		ans = Integer.parseInt(num[0]);
		for(int i=1; i<numCnt; ++i) {
			if(loc <= i) {
				ans -= Integer.parseInt(num[i]);
			} else {
				ans += Integer.parseInt(num[i]);				
			}
		}
		
		bw.write(ans + "\n");
		bw.close();
	}
}
