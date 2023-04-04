package bClass;

import java.io.IOException;

public class CalToAsci {
	
	private static final int CR = 0x0d;
	private static final int LF = 0x0a;
	private static final int Space = 0x20;
	private static final int Tab = 0x09;
	
	private int readOperator() throws IOException {
		int code = System.in.read();
		if(code=='.') {
			return code;
		}
		while(!(code=='*'||code=='/'||code=='+'||code=='-')) {
			code=System.in.read();
			}
		int token=System.in.read();
		if(token==CR) {
			System.in.read();
		}
		return code;
	}
	 private int readInt() throws IOException {
	      int number = 0; 
	          int code = System.in.read();
	          while(!(code>0x30&&code<0x40)) {
	        	  code=System.in.read();
	          }
	          while (code >= '0' && code <= '9') {
	             number = number * 10 + (code - '0');
	             code = System.in.read();
	          }
	             if(code==CR) {
	            	 code=System.in.read();
	            	 return number;
	             }
	             else if(code==9||code==32){
	 	            return number; 
	 	          }
	             else {
	            	 throw new IOException();
	             }
	   }
	 
	  private void quit() {
		   System.exit(0);
		}
	 
	private int compute(int code) throws IOException  {
		int result = 0;
		int number1=readInt();
		int number2= readInt();
	
		if(code=='+') {
			result=number1+number2;
		
		}
		else if(code=='-') {
			result=number1-number2;
		}
		else if(code=='*') {
			result=number1*number2;
		}
		else if(code=='/') {
			result=number1/number2;
		}
		else {
			throw new IOException(); // throw하면 바로 아래의 catch문에서 받는다.
		}
		
		return result;
	}
	
	
	public void rum(){


			try {
				int code = readOperator();
				
				while(code!='.') {
					int result=compute(code);
					int digit=result;
					int length=0;
					while(digit!=0) {
						length++;
						digit/=10;
					}
					int[] ascii=new int[length];
						 for(int i=0;i<length;i++) {
							 ascii[i]=(int) ((result/(Math.pow(10,i)))%10+30);
						 }
					for(int i=length-1;i>-1;i--){
						System.out.println(ascii[i]);
					}
					System.out.println("Do you want quit?: .");
					code = readOperator();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				//예러가 났을 때 끝내지말고 처음부터 다시할 수 있도록
			}
		
		}
	
	
	
	public static void main(String[] args) throws IOException {
		CalToAsci calculator = new CalToAsci();
		calculator.rum();
	}
}
