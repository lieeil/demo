package com.lien.nio.buffer;

import java.nio.*;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/11/23 上午9:43
 */
public class CapacityTest {

    public static void main(String[] args){
        byte[] byteArray = new byte[]{1,2,3};
        short[] shortArray = new short[]{1,2,3,4};
        int[] intArray = new int[]{1,23,4,5};
        long[] longArray = new long[]{1,2,3,4,5,6};
        float[] floatArray = new float[]{1,2,3,4,5,6,7};
        double[] doubleArray = new double[]{1,2,3,4,5,6,7,8};
        char[] charArray = new char[]{'a','b','c','d'};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        ShortBuffer shortBuffer = ShortBuffer.wrap(shortArray);
        IntBuffer intBuffer = IntBuffer.wrap(intArray);
        LongBuffer longBuffer = LongBuffer.wrap(longArray);
        FloatBuffer floatBuffer = FloatBuffer.wrap(floatArray);
        DoubleBuffer doubleBuffer = DoubleBuffer.wrap(doubleArray);
        CharBuffer charBuffer = CharBuffer.wrap(charArray);

        System.out.println("byteBuffer=" + byteBuffer.getClass().getName());
        System.out.println("shortBuffer=" + shortBuffer.getClass().getName());
        System.out.println("intBuffer=" + intBuffer.getClass().getName());
        System.out.println("longBuffer=" + longBuffer.getClass().getName());
        System.out.println("floatBuffer=" + floatBuffer.getClass().getName());
        System.out.println("doubleBuffer=" + doubleBuffer.getClass().getName());
        System.out.println("charBuffer=" + charBuffer.getClass().getName());

        System.out.println();

        System.out.println("byteBuffer.capacity=" + byteBuffer.capacity());
        System.out.println("shortBuffer.capacity=" + shortBuffer.capacity());
        System.out.println("intBuffer.capacity=" + intBuffer.capacity());
        System.out.println("longBuffer.capacity=" + longBuffer.capacity());
        System.out.println("floatBuffer.capacity=" + floatBuffer.capacity());
        System.out.println("doubleBuffer.capacity=" + doubleBuffer.capacity());
        System.out.println("charBuffer.capacity=" + charBuffer.capacity());

        System.out.println();

        System.out.println("byteBuffer.limit=" + byteBuffer.limit());
        System.out.println("shortBuffer.limit=" + shortBuffer.limit());
        System.out.println("intBuffer.limit=" + intBuffer.limit());
        System.out.println("longBuffer.limit=" + longBuffer.limit());
        System.out.println("floatBuffer.limit=" + floatBuffer.limit());
        System.out.println("doubleBuffer.limit=" + doubleBuffer.limit());
        System.out.println("charBuffer.limit=" + charBuffer.limit());
    }

}
