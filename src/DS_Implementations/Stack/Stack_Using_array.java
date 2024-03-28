package DS_Implementations.Stack;

import java.util.Arrays;
import java.util.Scanner;

public class Stack_Using_array {
      public static class Stack_{
            int size = 10;  //initial size of stack
            static int index = -1;
            static int[] array;
//            constructor for default stack size;
            Stack_(){
                  array = new int[size];
            }

//            constructor for stack size;
            Stack_(int val){
                  array = new int[val];
            }

            private static void push(int data){
                  if(index == 10){
                        System.out.println("Stack Overflow...");
                  }else{
                        index += 1;
                        array[index] = data;

                  }

            }

            private static void pop(){
                  if(index == -1){
                        System.out.println("Stack Underflow...");
                  }else{
                        int val = array[index];
                        array[index] = 0;
                        index -= 1;
                        System.out.println("Poped : "+val);

                  }

            }
            private static void isEmpty(){
                  if(index == -1){
                        System.out.println("Stack is Empty");
                  }else{
                        System.out.println("Stack is Not Empty");
                  }

            }
            private static void peek(){
                  if(index == -1){
                        System.out.println("Stack Underflow...");
                  }else {
                        int top = array[index];
                        System.out.println ("Peek Element : " + top);
                  }
            }
            private static void display_stack(){
                  System.out.println("Stack : "+ Arrays.toString(array));
            }

      }


      public static void main(String[] args){
            Scanner scan = new Scanner (System.in);

            Stack_ stk = new Stack_ ();
            stk.push(10);
            stk.push(20);
            stk.push(30);
            stk.push(40);
            stk.push(50);

            stk.display_stack();

            stk.pop();
            stk.pop();
            stk.display_stack ();

            stk.peek();
            stk.isEmpty();


      }
}














