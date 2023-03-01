import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int ans = 0;
    static int n;
    static int start;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> al;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
         
        for(int t=1; t<=10; ++t) {
            st = new StringTokenizer(br.readLine());
            al = new ArrayList<>();
            visit = new int[101];
            for(int i=0; i<101; ++i) {
                ArrayList<Integer> temp = new ArrayList<>();
                al.add(temp);
            }
             
            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n/2; ++i) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                 
                al.get(a).add(b);
            }
             
            q.add(start);
            visit[start] = 1;
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int i=0; i<al.get(cur).size(); ++i) {
                    int nextLoc = al.get(cur).get(i);
                    if(visit[nextLoc] > 0) {
                        continue;
                    }
                    visit[nextLoc] = visit[cur] + 1;
                    q.add(nextLoc);
                }
            }
             
            int maxNum = 0;
            for(int i=1; i<visit.length; ++i) {
                if(visit[i] >= maxNum) {
                    maxNum = visit[i];
                    ans = i;
                }
            }
            bw.write("#" + t + " " + ans + "\n");
        }
        bw.close();
    }
}