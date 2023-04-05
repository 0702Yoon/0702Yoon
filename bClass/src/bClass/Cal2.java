package bClass;

import java.io.IOException;

public class Cal2 {
   
   private static final int CarrigeReturn = 0x0d;
   
   
   private int readOperator() throws IOException {
      int code= System.in.read();
      System.in.read();
      System.in.read();
      return code;
   }
    private int readInt() {
         int number = 0; // try 밖으로 빼준 이유는 {} 방 밖으로 빼주어 여러 방에 공통으로 사용할 수 있게 함을 위해다.
         try {
             int code = System.in.read();
             while (code >= '0' && code <= '9') {
                number = number * 10 + (code - '0');
                
                code = System.in.read();
             }
             
             if (code == CarrigeReturn) {
                code = System.in.read();
                return number;
             } else {
                throw new IOException(); // read라는 함수에 throw 해버리는 것이다.
             }
             
         } catch (IOException e) {
          e.printStackTrace();
          }
         return number;
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
      System.out.println("github대비 연습");
   }
}