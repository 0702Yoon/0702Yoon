package bClass;

import java.util.Scanner;

public class Prefixxx {
	private static void fill() {
		 Scanner sc = new Scanner(System.in);
	       char[] array1= new char[100];
	       int numbernum=0;
	       int i=0;
	       int sum=0;
	       while(true) {
	    	   char a=sc.next().charAt(0);
	    	   array1[i]=a;
	    	   if(a=='=') {
	    		   break;
	    	   }
	    	   else {
	    		numbernum++;   
	    	   }
	    	   i++;
	       }
	       char[] array2 = new char[numbernum];
	       int[] array3 = new int[numbernum];
	       for(int j=0;j<numbernum;j++) {
	    	   array2[j]=array1[j];
	       }
	}
	
	
		public static void main(String[] args) {
		

	}

}
