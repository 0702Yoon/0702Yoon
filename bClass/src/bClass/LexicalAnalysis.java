package bClass;

import java.io.IOException;

public class LexicalAnalysis {
	
	private static final int CR = 0x0d;
	
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
	             else if(code!=CR){
	 	            return number; 
	 	          }
	             else {
	            	 throw new IOException();
	             }
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
	
	public void run(){


			try {
				int code = readOperator();
				
				while(code!='.') {
					int result=compute(code);
					System.out.println(result);
					System.out.println("Do you want quit?: .");
					code = readOperator();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				//예러가 났을 때 끝내지말고 처음부터 다시할 수 있도록
			}
		
		}
	
	
	
	public static void main(String[] args) throws IOException {
		LexicalAnalysis calculator = new LexicalAnalysis();
		calculator.run();
	}
}
