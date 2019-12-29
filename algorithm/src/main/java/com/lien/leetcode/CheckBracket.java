package com.lien.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description: 判断括号是否合法<br>
 *
 * @author li
 * @date 2019/12/29 下午4:47
 */
public class CheckBracket {

    public static final char LEFT_BRACKET = '(';
    public static final char RIGHT_BRACKET = ')';
    public static final char LEFT_BRACE_BRACKET = '{';
    public static final char RIGHT_BRACE_BRACKET = '}';
    public static final char LEFT_SQUIRE_BRACKET = '[';
    public static final char RIGHT_SQUIRE_BRACKET = ']';


    private Map<Character, Character> bracketMap = new HashMap<>();

    public CheckBracket(){
        bracketMap.put(RIGHT_BRACKET, LEFT_BRACKET);
        bracketMap.put(RIGHT_BRACE_BRACKET, LEFT_BRACE_BRACKET);
        bracketMap.put(RIGHT_SQUIRE_BRACKET, LEFT_SQUIRE_BRACKET);
    }

    public boolean checkBracket(String str){
        if(str == null || str.trim().equals("")){
            return false;
        }
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars){
            if(bracketMap.containsValue(c)){
                stack.push(c);
            }else if(bracketMap.containsKey(c)){
                if(stack.size() > 0){
                    Character peek = stack.pop();
                    if(bracketMap.get(c).equals(peek)){
                        continue;
                    }
                }else {
                    return false;
                }

            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        CheckBracket bracket = new CheckBracket();
        String s = "[](哈哈哈哈){o{}]}";
        System.out.println(bracket.checkBracket(s));

    }
}
