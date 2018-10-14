package com.lien;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author li
 * @date 2018/10/4 上午9:23
 */
public class TestAviator {


    @Test
    public void testCalculate(){
       Long result = (Long) AviatorEvaluator.execute("1+2+39");
       System.out.println(result);
    }

    @Test
    public void testStringEnv(){
        Map<String,Object> env = new HashMap<>();
        env.put("yourName", "test");
        String result = (String) AviatorEvaluator.execute("'hello ' + yourName", env);
        System.out.println(result);
    }

    @Test
    public void testFunction(){
        System.out.println(AviatorEvaluator.execute("string.contains(\"test\",string.substring('hello',1,2))"));
    }

}
