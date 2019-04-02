package com.scalastic.monitor.client

import java.net.InetAddress

import com.scalastic.monitor.config.PropertiesLoader
import org.apache.http.HttpHost
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.client.{RestClient, RestHighLevelClient}
import org.elasticsearch.common.transport.TransportAddress
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.transport.client.PreBuiltTransportClient


/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ElasticsearchClient {
  val host: String = PropertiesLoader.HOST
  val port: Int = PropertiesLoader.PORT
  val client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port)))
  def transportClient: TransportClient = {
    val settings = Settings.builder()
      .put("cluster.name", "elasticsearch").build()
    new PreBuiltTransportClient(settings)
      .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port))
  }
}