package bClass;

import java.io.IOException;

public class Calculator {
	
	private static final int CR = 0x0d;
	private static final int LF = 0x0a;
	private static final int Space = 0x20;
	private static final int Tab = 0x09;
	
	private int readOperator() throws IOException {
//		int code = System.in.read();
//		while(code==Space||code==Tab||code==CR||code==LF) {
//			code=System.in.read();
//			}
//		int code = System.in.read();
		int code = System.in.read();
		while(!(code=='*'||code=='/'||code=='+'||code=='-')) {
			code=System.in.read();
			}
			System.in.read();
			System.in.read();
		return code;// 이렇게 짤 수도 있다는 것이다.ㅌ`
	}
	 private int readInt() throws IOException {
	      int number = 0; // try 밖으로 빼준 이유는 {} 방 밖으로 빼주어 여러 방에 공통으로 사용할 수 있게 함을 위해다.
	    
	          int code = System.in.read();
	          while (code >= '0' && code <= '9') {
	             number = number * 10 + (code - '0');
	             code = System.in.read();
	          }
	             if(code==CR) {
	            	 code=System.in.read();
	            	 return number;
	             }
	             else if(code==9||code==32){
	 	            return number; // read라는 함수에 throw 해버리는 것이다.
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
				
				while(code!='q') {
					int result=compute(code);
					System.out.println(result);
					System.out.println("Do you want quit?: q");
					code = readOperator();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				//예러가 났을 때 끝내지말고 처음부터 다시할 수 있도록
			}
		
		}
	
	
	
	public static void main(String[] args) throws IOException {
		Calculator calculator = new Calculator();
		calculator.rum();
	}
}
