import java.util.ArrayList;
import java.util.List;

public class DelimiterMatching {
    static List<Long> list;

    public static void main(String[] args) {
        list = new ArrayList<>();

        System.out.println("PRETEST");
        String test1 = "[][]{}{}()()";
        System.out.println("Test 1: " + test1 + " Result: " + delimiterMatch(test1));

        String test2 = "[({()()))))()})";
        System.out.println("Test 2: " + test2 + " Result: " + delimiterMatch(test2));

        String test3 = "[()(]]";
        System.out.println("Test 3: " + test3 + " Result: " + delimiterMatch(test3));

        String test4 = "";
        System.out.println("Test 4: " + test4 + " Result: " + delimiterMatch(test4));

        String test5 = "(";
        System.out.println("Test 5: " + test5 + " Result: " + delimiterMatch(test5));

        //Creates 10 tests of guaranteed matches
        System.out.println("\nGUARANTEED MATCH");
        for(int i = 1; i <= 100000000; i *= 10){
            String s = "(".repeat(i/2);
            s += ")".repeat(i/2);
            test(s, i);
        }

        //Creates 10 tests of non-matching strings
        System.out.println("\nNON-MATCH");
        for(int i = 1; i <= 100000000; i *= 10){
        String s = "(".repeat(i);
            test(s, i);
        }
    }


    public static boolean delimiterMatch(String str){
        //PSEUDOCODE:
        //take in string
        //if we have an open bracket, add it to the stack
        //if we have a closed character, pop the top of the stack and compare the 
        //character
        //  if the character is not the closed version of the character, return
        //  false
        //  otherwise continue
        //if at the end the top = 0, return true, else return false

        long start = System.currentTimeMillis();

        Stack stack = new Stack(str.length());

        //for all characters
        for(int i = 0; i < str.length(); i++){
            //push all open characters
            if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '['){
                stack.push(str.charAt(i));
            }else{
                //if it's empty we can't pop anything to compare
                if(stack.isEmpty()){
                    long end = System.currentTimeMillis();
                    list.add(end - start);
                    return false;
                }

                //take char at top of stack
                char popChar = stack.pop();

                //If we pop an open bracket and our current char isn't the opposite, return false
                if(str.charAt(i) == '}' && popChar != '{'){
                    long end = System.currentTimeMillis();
                    list.add(end - start);
                    return false;
                }else if(str.charAt(i) == ')' && popChar != '('){
                    long end = System.currentTimeMillis();
                    list.add(end - start);
                    return false;
                }else if(str.charAt(i) == ']' && popChar != '['){
                    long end = System.currentTimeMillis();
                    list.add(end - start);
                    return false;
                }
            }
        }

        long end = System.currentTimeMillis();
        list.add(end - start);
        //if stack is empty it must match
        return stack.isEmpty();
    }

    //helper test function
    public static void test(String s, int n){
        System.out.println("Test " + list.size() + " (size " + n + "): " + delimiterMatch(s) + " time: " + list.get(list.size() - 1));
    }
}