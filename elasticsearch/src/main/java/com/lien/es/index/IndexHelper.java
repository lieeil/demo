package com.lien.es.index;

import com.lien.es.consts.EsConsts;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
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
        request.settings(Settings.builder().put("index.number_of_shards",3)
        .put("index.number_of_replicas",2));
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
        title.put("type", "text");
        Map<String, Object> publishTime = new HashMap<>();
        title.put("type", "date");

        Map<String, Object> properties = new HashMap<>();
        properties.put("number", number);
        properties.put("price", price);
        properties.put("title", title);
        properties.put("province", province);
        properties.put("publishTime", publishTime);

        Map<String, Object> book = new HashMap<>();
        book.put("properties", properties);
        jsonMap.put("book", book);
        request.mapping(EsConsts.TYPE, jsonMap);
    }
}
