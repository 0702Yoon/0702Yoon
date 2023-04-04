package bClass;

import java.util.Scanner;

public class Prefix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       char[] array1= new char[100];
      
       int numbernum=0;
       int i=0;
       while(true) {
    	   char a=sc.next().charAt(0);
    	   
    	   if(a==61) {
    		   break;
    	   }
    	   else {
    		  array1[i]=a;
    		numbernum++;   
    	   }
    	   i++;
       }
       char[] array2 = new char[numbernum];
       int[] array3 = new int[numbernum-2];
       for(int j=0;j<numbernum;j++) {
    	   array2[j]=array1[j];
       }
       array3[0]=-48;
       int z=0;
       while(true) {
    	   if(array2[0]==48) {
    		   break;
    	   }
    	   
    	   for(int j=numbernum-2;j>0;j--) {
    		   if(array2[j]>47&&array2[j+1]>47&&array2[j]<58&&array2[j+1]<58) {
    			   array3[0]=array2[j+1]-48;
    			   if(array2[j-1]==42) {
    				   z++;
    				   array3[z]=array3[z-1]*(array2[j]-48);
    				   array2[j-1]=48;
    				   array2[j]=30;
    				   array2[j+1]=30;
    				   j=numbernum-2;
    				   
    			   }
    			   else if(array2[j-1]==43) {
    				   z++;
    				   array3[z]=array3[z-1]+(array2[j]-48);
    				   array2[j-1]=48;
    				   array2[j]=30;
    				   array2[j+1]=30;
    				   j=numbernum-2;
    			   }
    			   else if(array2[j-1]==45) {
    				   z++;
    				   array3[z]=array3[z-1]-(array2[j]-48);
    				   array2[j-1]=48;
    				   array2[j]=30;
    				   array2[j+1]=30;
    				   j=numbernum-2;
    			   }
    			   else if(array2[j-1]==47) {
    				   z++;
    				   array3[z]=(array2[j]-48)/array3[z-1];
    				   array2[j-1]=48;
    				   array2[j]=30;
    				   array2[j+1]=30;
    				   j=numbernum-2;
    			   }
    		   }
    	   }
       }
       System.out.println(array3[z]);
    
    }
}