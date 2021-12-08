package Stack.questions;

import java.util.*;

class ReverseWords{
    public static void main(String[] args) {
        
        String s = "  hello world  ";
        String reversedString = reverse_words(s);

        System.out.println(reversedString);
    }

    public static String reverse_words(String s){

        Stack<String> stack = new Stack<String>();

        String word = "";
        int i = 0;

        // Iterating in string
        while(i < s.length()){
            char curr_char = s.charAt(i);
            // if there are spaces at start or list or at middle of words
            if(curr_char == ' ' && word.isEmpty()){
                i++;
            }
            // After getting first space we get word append it in stack
            else if(curr_char == ' '){
                stack.push(word);
                word = "";
                i++;
            }

            else{
                word += curr_char;
                i++;
            }
        }
        // Adding last word in stack
        if(!word.isEmpty()){
            stack.push(word);
        }

        String result = "";
        // popping one by one words and add in string
        while(!stack.isEmpty()){
            if(stack.size() == 1){
                result += stack.pop();
            }else{
                result += stack.pop() + " ";
            }      
        }

        return result;
    }   
}