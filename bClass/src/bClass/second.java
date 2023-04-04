package bClass;
import java.util.Scanner;

public class second {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr1 = new String[100];
		int i=0, numbernum=0;
		while(true) {
			String a=sc.next();
			if(a.charAt(0)==61) {
				break;
			}
			else {
				arr1[i]=a;
				numbernum++;
			}
			i++;
		}
		int size=numbernum;
		int f=(size-1)/2; // 연산자 배열 크기
		String[] arr2 = new String[numbernum];
		for(int j=0;j<numbernum;j++) {
			arr2[j]=arr1[j];
		}
		
		String[] arr3 = new String[f];
		
		float[] arr4 = new float[f+1];
		int o=0,n=0;
		for(int j=0;j<numbernum;j++) {
			char oi=arr2[j].charAt(0);
			if(oi<48) {
				arr3[o]=arr2[j];
				o++;
			}
			else {
				arr4[n]=Integer.parseInt(arr2[j]);
				n++;
			}
		}
		float result=0;
		for(int j=f-1;j>-1;j--) {
			if(arr3[j].equals("+")) {
				arr4[j]=arr4[j]+arr4[j+1];
			}
			else if(arr3[j].equals("-")) {
				arr4[j]=arr4[j]-arr4[j+1];
			}
			else if(arr3[j].equals("*")) {
				arr4[j]=arr4[j]*arr4[j+1];
			}
			else if(arr3[j].equals("/")) {
				arr4[j]=arr4[j]/arr4[j+1];
			}
		}
		result=arr4[0];
		System.out.println(result);
	}
}
