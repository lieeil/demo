package com.lien.algorithm.boolm_filter;

import java.util.BitSet;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-04-24 12:10
 */
public class BloomFilter {

    private static final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19};

    private BitSet bitSet = new BitSet(256 << 22); // 2的8次方，左移22次，2的30次方，10亿

    private Hash[] hashList = new Hash[primes.length];

    public BloomFilter(){
        for (int i = 0; i < primes.length; i++) {
            hashList[i] = new Hash(primes[i]);
        }
    }

    public void add(String value){
        for(Hash f : hashList){
            bitSet.set(f.hash(value), true);
        }
    }


    public boolean contains(String value){
        if(value == null){
            return false;
        }
        boolean ret = true;
        for(Hash f : hashList){
            ret = ret && bitSet.get(f.hash(value));
        }
        return ret;
    }

    public static class Hash{

        private int prime;

        public Hash(int prime){
            this.prime = prime;
        }

        public int hash(String key){
            int hash, i;
            for(hash = key.length(), i = 0; i < key.length(); i++){
                hash += key.charAt(i);
            }
            return (hash % prime);
        }
    }

    public static void main(String[] args){
        BloomFilter bloomFilter = new BloomFilter();
        System.out.println(bloomFilter.contains("1861099"));
        bloomFilter.add("1861099");

        //维护1亿个在线用户
        for (int i = 1 ; i < 100000000 ; i ++){
            bloomFilter.add(String.valueOf(i));
        }

        long begin = System.currentTimeMillis();
        System.out.println(begin);
        System.out.println(bloomFilter.contains("18610996810"));
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("判断18610996810是否在线使用了:" + (begin - end));
    }
}
