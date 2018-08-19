package com.lien.es.document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lien.es.consts.EsConsts;
import com.lien.es.entity.Book;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.3/java-rest-high-document-index.html
 */
public class DocumentHelper {

    private RestHighLevelClient client;

    public DocumentHelper(RestHighLevelClient client){
        this.client = client;
    }

    public void putData(Book book) throws IOException {
        IndexRequest indexRequest = new IndexRequest(EsConsts.INDEX_NAME, EsConsts.TYPE, book.getNumber());
        ObjectMapper mapper = new ObjectMapper();
        byte[] json = mapper.writeValueAsBytes(book);
        client.index(indexRequest);
    }
}
