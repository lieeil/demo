package com.lien.drools.model;

import lombok.Data;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/10/16 下午5:33
 */
@Data
public class Product {

    public static final String DIAMOND = "DIAMOND"; // 钻石

    public static final String GOLD = "GOLD"; // 黄金

    private String type;

    private int discount;

}
