package com.lien.nio.buffer;

import java.nio.CharBuffer;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/11/23 上午9:56
 */
public class LimitTest {

    public static void main(String[] args){
        char[] charArray = new char[] { 'a', 'b', 'c', 'd', 'e' };
        CharBuffer buffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()=" + buffer.capacity() + " limit()=" +
                buffer.limit());
        buffer.limit(3);
        System.out.println();
        System.out.println("B capacity()=" + buffer.capacity() + " limit()=" +
                buffer.limit());
        buffer.put(0, 'o');// 0
        buffer.put(1, 'p');// 1
        buffer.put(2, 'q');// 2
        buffer.put(3, 'r');// 3--此位置是第一个不可读不可写的索引
        buffer.put(4, 's');// 4
        buffer.put(5, 't');// 5
        buffer.put(6, 'u');// 6
    }

}
