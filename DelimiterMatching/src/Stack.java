import java.util.EmptyStackException;

public class Stack {
    private final char[] arr;
    private int pointer;
    public Stack(int size){
        arr = new char[size];
        pointer = -1;
    }

    //add to top of stack and increment pointer
    public boolean push(char c){
        if(pointer >= arr.length - 1){
            throw new StackOverflowError();
        }else{
            pointer++;
            arr[pointer] = c;
            return true;
        }
    }

    //remove from top of stack and decrement pointer
    public char pop(){
        if(pointer < 0){
            throw new EmptyStackException();
        }else{
            return arr[pointer--];
        }
    }

    //return if stack is empty
    public boolean isEmpty(){
        return pointer < 0;
    }
}
