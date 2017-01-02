import java.util.*;

//Jose Mora
//Project 4

public class GStack<T> {
    
    private ArrayList<T> stack = new ArrayList<T>();
    private T top;
    int counter;
    public GStack(){   // creates an empty stack
        stack = new ArrayList();
    }

 // Determines whether the stack is empty.
    // Precondition: None.
    // Postcondition: Returns true if the stack is empty;
    // otherwise returns false.
    public boolean isEmpty() {
        return (stack == null);
    }

 // Removes all the items from the stack.
    // Precondition: None.
    // Postcondition: Stack is empty.

    public void popAll() {
        if(stack == null) {
            throw new EmptyStackException();
        }
        while(!stack.isEmpty()) {
            for(int i = 0; i < stack.size(); i++) {
                stack.remove(i);
            }
        }
    }

    // Adds an item to the top of a stack.
    // Precondition: newItem is the item to be added.
    // Postcondition: If insertion is successful, newItem
    // is on the top of the stack.
    // Exception: Some implementations may throw 
    // StackException when newItem cannot be placed on
    // the stack.
    public void push(T newItem) throws StackException{
        stack.add(newItem);
        counter++;
        if(!stack.add(newItem)){
            throw new StackException("Item cannot be added.");
        }
    }

    // Removes the top of a stack.
    // Precondition: None.
    // Postcondition: If the stack is not empty, the item  that was added most recently
    // is removed from the stack and returned.
    // Exception: Throws StackException if the stack is empty 
    public T pop() throws StackException {
        T answer = stack.remove(0);
        counter--;
        if (stack.isEmpty()) {
            throw new StackException("Stack is empty.");
        }
        return answer;
    }

    // Retrieves the top of a stack.
    // Precondition: None.
    // Postcondition: If the stack is not empty, the item that was added most recently is returned. 
    // The stack is unchanged. 
    // Exception: Throws StackException if the stack is empty.
    public T peek() throws StackException {
        if (!stack.isEmpty()){
            return top;
        } else  {
            throw new StackException("Stack is empty.");
        }
    
    }
    public int size() {
    	return counter;
    }

    @Override
    public String toString(){
        String output = "+";
        for (int j = stack.size(); j > 0; j--){
            output += " " + stack.get(j);
        }
        return output;  
    }
    
    
}
