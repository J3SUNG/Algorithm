import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        int T;
        int width = 0; //511
        int[] length = new int[9]; 
        int[] square = new int[3]; 
        String S;
        boolean chk = false;
         
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        S=sc.nextLine();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            chk = false;
                
            for(int i=0; i<9; ++i){
                S=sc.nextLine();
                if(chk){ 
                    continue;   
                }
                width = 0;
                if(i%3==0){
                    square[0] = 0;
                    square[1] = 0;
                    square[2] = 0;
                }
                if(i%9==0){
                    length[0] = 0;   
                    length[1] = 0;
                    length[2] = 0;
                    length[3] = 0;
                    length[4] = 0;
                    length[5] = 0;
                    length[6] = 0;
                    length[7] = 0;
                    length[8] = 0;
                }
                for(int j=0; j<9; ++j){
                    if((length[j] & (1 << (int)S.charAt(j*2)  - '0')) == 0){
                        length[j] = length[j] | (1 << (int)(S.charAt(j*2) - '0'));   
                    } else {
                        chk = true;
                        break;
                    }
                    if((width & (1 << (int)(S.charAt(j*2) - '0'))) == 0){
                        width = width | (1 << (int)(S.charAt(j*2) - '0'));
                    } else {
                        chk = true;
                        break;
                    }
                    if((square[j/3] & (1 << (int)(S.charAt(j*2) - '0'))) == 0){
                        square[j/3] = square[j/3] | (1 << (int)(S.charAt(j*2) - '0'));
                    } else {
                        chk = true;
                        break;
                    }
                }
            }
            if(chk){
                System.out.println("#" + test_case +" 0");   
            } else {
                System.out.println("#" + test_case +" 1");
            }
        }
    }
}