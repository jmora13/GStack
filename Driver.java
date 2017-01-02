import java.util.Scanner;


public class Driver {
    
    public static void main (String[] args) {
        
        //creates GStack objects
        GStack<Integer> stack1 = new GStack<Integer>();
        GStack<Integer> stack2 = new GStack<Integer>();
        GStack<Integer> sum_stack = new GStack<Integer>();
        
        int column_result = 0;
    
        Scanner input = new Scanner (System.in);
    
        /*read  the first number and  
     push the digits  (left to right ) on to stack1*/
        
        System.out.println("First number:");
        String firstNum;
        firstNum = input.next();
        int num1 = 0;
        try {
            num1 = Integer.valueOf((String) firstNum);
            stack1.push(num1);
        } catch (StackException e1) {
            e1.printStackTrace();
        }
        
        /*  read the  second number
     push the digits on to stack2
      */
        System.out.println("Second number:");
        String secondNum;
        secondNum = input.next();
        int num2 = 0;
        try {
            num2 = Integer.valueOf((String) secondNum);
            stack2.push(num2);
        } catch (StackException e1) {           
            e1.printStackTrace();
        }
        
        
    while(!stack1.isEmpty() || !stack2.isEmpty()){
        
        int a = 0;
        int b = 0;
        /*  while at least one stack is not empty
               if stack1 is not empty
                    pop a value from stack1*/
        if (!stack1.isEmpty()){
            try {
               a = Integer.valueOf((int) stack1.pop());
            } catch (StackException e) {
                e.printStackTrace();
            }
            /*if stack2 is not empty
                     pop a value from stack2*/
        } if (!stack2.isEmpty()){
            try {
                b = Integer.valueOf((int) stack2.pop());
            } catch (StackException e) {
                e.printStackTrace();
            }
        }
        //  column_result += sum of popped values
        column_result += (a+b);
        
        try {
            sum_stack.push(column_result);
        } catch (StackException e) {
            e.printStackTrace();
        }
        
        /*if  column_result > 9
                     column_result =  ten’s digit (the carry)*/
        if(column_result > 9){
            column_result = Integer.parseInt((""+column_result).substring(0,1));
        } else {
            column_result = 0;
        }
    }
    
   /* if column_result  is not zero
              push column result on sum_stack*/
    if(column_result != 0){
        try {
            sum_stack.push(column_result);
        } catch (StackException e) {
            e.printStackTrace();
        }
    }
    
    
    /* while sum_stack is not empty
               pop sum_stack
               display popped value*/
    while(sum_stack != null ){
            try {
				System.out.println(sum_stack.pop());
			} catch (StackException e) {
				e.printStackTrace();
			}
    	}
    }
}
