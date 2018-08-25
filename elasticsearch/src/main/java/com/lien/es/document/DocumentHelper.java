package com.lien.es.document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lien.es.consts.EsConsts;
import com.lien.es.entity.Book;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;

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
        IndexRequest indexRequest = createIndexRequest(book);
        client.index(indexRequest);
    }

    private IndexRequest createIndexRequest(Book book) throws JsonProcessingException {
        IndexRequest indexRequest = new IndexRequest(EsConsts.INDEX_NAME, EsConsts.TYPE, book.getNumber());
        ObjectMapper mapper = new ObjectMapper();
        byte[] json = mapper.writeValueAsBytes(book);
        indexRequest.source(json, XContentType.JSON);
        return indexRequest;
    }


    public void updateData(Book book) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(EsConsts.INDEX_NAME, EsConsts.TYPE, book.getNumber());
        updateRequest.doc(createIndexRequest(book));
        GetResult getResult =
                client.update(updateRequest).getGetResult();
    }

    public Book getData(String id) throws IOException {
        GetRequest getRequest = new GetRequest(EsConsts.INDEX_NAME, EsConsts.TYPE, id);
        GetResponse getResponse = client.get(getRequest);
        byte[] sourceAsBytes = getResponse.getSourceAsBytes();
        ObjectMapper mapper = new ObjectMapper();
        Book book = mapper.readValue(sourceAsBytes, Book.class);
        return book;
    }


    public void close() throws IOException {
        this.client.close();
    }
}
