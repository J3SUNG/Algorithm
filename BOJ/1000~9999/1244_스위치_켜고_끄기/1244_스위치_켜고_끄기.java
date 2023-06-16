import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] arr = new boolean[n + 1];
		for(int i=1; i<=n; ++i) {
			int num = sc.nextInt();
			if(num == 0) {
				arr[i] = false;
			} else {
				arr[i] = true;
			}
		}
		int m = sc.nextInt();
		for(int i=0; i<m; ++i) {
			int s = sc.nextInt();
			int index = sc.nextInt();
			
			if(s == 1) {
				for(int j=index; j<=n; j+=index) {
					arr[j] = !arr[j];
				}
			} else {
				arr[index] = !arr[index];
				for(int j=1; j<=n; ++j) {
					if(index-j <= 0 || index+j > n) {
						break;
					}
					if(arr[index+j] == arr[index-j]) {
						arr[index+j] = !arr[index+j];
						arr[index-j] = !arr[index-j];
					} else {
						break;
					}
				}
			}
		}
		for(int i=1; i<arr.length; ++i) {
			System.out.printf("%d ", arr[i] ? 1 : 0 );
			if((i % 20) == 0) {
				System.out.println();
			}
		}
	}
}