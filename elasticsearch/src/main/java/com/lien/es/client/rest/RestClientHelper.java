package com.lien.es.client.rest;

import com.lien.es.consts.EsConsts;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class RestClientHelper {

   private static RestHighLevelClient client;


    private RestClientHelper(){
        client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(EsConsts.HOST_NAME, EsConsts.PORT, "http")));
    }

    public static RestHighLevelClient getClient(){
        if(client == null){
            synchronized (RestClientHelper.class){
                if(client == null){
                    RestClientHelper restClientHelper = new RestClientHelper();
                }
            }
        }
        return client;
    }

}
