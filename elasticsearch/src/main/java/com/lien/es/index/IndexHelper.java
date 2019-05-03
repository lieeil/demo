package com.lien.es.index;

import com.lien.es.consts.EsConsts;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-types.html
 */
public class IndexHelper {

    private RestHighLevelClient client;

    public IndexHelper(RestHighLevelClient client){
        this.client = client;
    }

    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(EsConsts.INDEX_NAME);
        buildSetting(request);
        buildIndexMapping(request);
        client.indices().create(request);
    }

    public void buildSetting(CreateIndexRequest request){
        request.settings(Settings.builder().put("index.number_of_shards",1)
        .put("index.number_of_replicas",0));
    }

    public void buildIndexMapping(CreateIndexRequest request){
        Map<String, Object> jsonMap = new HashMap<>();

        Map<String, Object> number = new HashMap<>();
        number.put("type", "text");
        Map<String, Object> price = new HashMap<>();
        price.put("type", "float" );
        Map<String, Object> title = new HashMap<>();
        title.put("type", "text");
        Map<String, Object> province = new HashMap<>();
        province.put("type", "text");
        Map<String, Object> publishTime = new HashMap<>();
        publishTime.put("type", "date");

        Map<String, Object> properties = new HashMap<>();
        properties.put("number", number);
        properties.put("price", price);
        properties.put("title", title);
        properties.put("province", province);
        properties.put("publishTime", publishTime);

        Map<String, Object> book = new HashMap<>();
        book.put("properties", properties);
        jsonMap.put("books", book);
        request.mapping(EsConsts.TYPE, jsonMap);
    }

    public void deleteIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices(EsConsts.INDEX_NAME);
        if(client.indices().exists(getIndexRequest)) {
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(EsConsts.INDEX_NAME);
            client.indices().delete(deleteIndexRequest);
        }
    }
}
