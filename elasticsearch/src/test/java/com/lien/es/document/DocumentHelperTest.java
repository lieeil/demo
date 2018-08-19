package com.lien.es.document;


import com.lien.es.client.rest.RestClientHelper;
import com.lien.es.entity.Book;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DocumentHelperTest {
    public static String[] provinces = {"北京","河北","河南","上海","天津","辽宁","吉林","黑龙江","湖南","湖北"};

    @Test
    public void putDataTest() throws IOException {
        RestHighLevelClient client = RestClientHelper.getClient();
        DocumentHelper documentHelper = new DocumentHelper(client);
        List<Book> bookList = generateBooks(1000);
        for(int i = 0; i < bookList.size(); i++){
            documentHelper.putData(bookList.get(i));
        }
    }



    public List<Book> generateBooks(int size){
        List<Book> bookList = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            Book book = new Book();
            Random random = new Random(i);
            book.setPrice(random.nextDouble());
            book.setProvince(provinces[random.nextInt(provinces.length)]);
            book.setNumber(i+"");
            book.setTitle(i+"");
            book.setPublishTime(new Date(random.nextLong()));
            bookList.add(book);
        }
        return bookList;
    }


}