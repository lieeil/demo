package com.lien;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-04-11 19:39
 */
public class Main {

    public static void main(String[] args){
        DecimalFormat df = new DecimalFormat(".##");
        df.setRoundingMode(RoundingMode.HALF_UP);
//        System.out.println(df.format(23.994));
//        System.out.println(df.format(23.984));
//        System.out.println("****");
//        System.out.println(df.format(new BigDecimal(23.995)));
//        System.out.println(df.format(new BigDecimal(23.985)));
//        System.out.println("****");
//        System.out.println(df.format(23.995));
        System.out.println(df.format(23.895));
//        System.out.println("****");
//        System.out.println(df.format(23.999));
//        System.out.println(df.format(23.989));
    }
}
