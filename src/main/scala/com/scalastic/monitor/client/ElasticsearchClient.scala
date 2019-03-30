package com.scalastic.monitor.client

import com.scalastic.monitor.config.PropertiesLoader
import org.apache.http.HttpHost
import org.elasticsearch.client.{RestClient, RestHighLevelClient}

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ElasticsearchClient {
  val host: String = PropertiesLoader.HOST
  val port: Int = PropertiesLoader.PORT
  val client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port)))
}
