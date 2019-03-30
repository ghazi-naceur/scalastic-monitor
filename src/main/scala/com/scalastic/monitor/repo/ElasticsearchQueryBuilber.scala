package com.scalastic.monitor.repo

import java.util.UUID

import com.scalastic.monitor.client.ElasticsearchClient
import com.scalastic.monitor.entities.Person
import org.elasticsearch.action.index.{IndexRequest, IndexResponse}
import org.elasticsearch.client.{RequestOptions, RestHighLevelClient}
import org.elasticsearch.common.xcontent.XContentType
import play.api.libs.json.Json

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ElasticsearchQueryBuilber {

  val client: RestHighLevelClient = ElasticsearchClient.client

  def insert(index: String, es_type: String, entity: Person): IndexResponse = {
    val request = new IndexRequest(index, es_type, UUID.randomUUID().toString)
    val jsonString = Json.stringify(Json.toJson(entity))
    request.source(jsonString, XContentType.JSON)
    client.index(request, RequestOptions.DEFAULT)
  }
}
