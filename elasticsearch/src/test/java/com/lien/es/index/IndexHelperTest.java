package com.lien.es.index;

import com.lien.es.client.rest.RestClientHelper;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;


public class IndexHelperTest {

    @Test
    public void createIndex() throws IOException {
        RestHighLevelClient client = RestClientHelper.getClient();
        IndexHelper indexHelper = new IndexHelper(client);
        indexHelper.deleteIndex();
        indexHelper.createIndex();
    }
}