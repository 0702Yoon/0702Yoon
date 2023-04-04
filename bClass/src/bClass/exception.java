package bClass;

import java.io.IOException;

public class exception {
	
	private static final int CarrigeReturn = 0x0d;
	
	private int readOperator() throws IOException {
		int code= System.in.read();
		System.in.read();
		System.in.read();
		return code;
	}
	private int readInt()throws IOException {
		
			int number= 0;
			int code= System.in.read();
			while(code>='0'&&code<='9') {
				number = number*10 +(code-'0');
				code= System.in.read();
			}	
			if(code==CarrigeReturn) {
				code=System.in.read();
				return number; 
			}
			else if(code>='*'&&code<='/') {
				System.in.read();
				System.in.read();
				return cal(code);
			}
			else {
				throw new IOException();
			}

			
	}
	private int cal(int a) throws IOException {
		int result = 0;
		try {
			int number1 = readInt();
			int number2= readInt();
			
			if(a=='+') {
			 result=number1+number2;
			
			}
			else if(a=='-') {
				 result=number1-number2;
			}
			else if(a=='*') {
				 result=number1*number2;
			}
			else if(a=='/') {
				 result=number1/number2;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return  result;
	}
	
	public void rum(){

			try {
				int result =0;
				int code = readOperator();
				System.out.println(cal(code));
				
			} catch (IOException e) {
				e.printStackTrace();
				//예러가 났을 때 끝내지말고 처음부터 다시할 수 있도록
			}
		
		}
	
	
	
	public static void main(String[] args) throws IOException {
		while(true) {
		exception calculator = new exception();
		calculator.rum();
		System.out.println("Did you again?");
		int check=System.in.read();
		System.in.read();
		System.in.read();
		if(check=='x') {
			break;
		}
		}
	}
}
