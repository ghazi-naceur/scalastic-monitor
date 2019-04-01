package com.scalastic.monitor.repo

import java.util.UUID

import com.scalastic.monitor.client.ElasticsearchClient
import org.elasticsearch.action.index.{IndexRequest, IndexResponse}
import org.elasticsearch.action.update.{UpdateRequest, UpdateResponse}
import org.elasticsearch.client.{RequestOptions, RestHighLevelClient}
import org.elasticsearch.common.xcontent.XContentFactory

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ElasticsearchQueryBuilber {

  val client: RestHighLevelClient = ElasticsearchClient.client

  def insert(es_index: String, es_type: String, entity: Map[String, _]): IndexResponse = {
    val request = new IndexRequest(es_index, es_type, UUID.randomUUID().toString)
    val builder = XContentFactory.jsonBuilder
    builder.startObject
    for ((k, v) <- entity) {
      builder.field(k, v)
    }
    builder.endObject
    request.source(builder)
    client.index(request, RequestOptions.DEFAULT)
  }

  def update(es_index: String, es_type: String, id: String, map: Map[String, _]): UpdateResponse = {
    val updateRequest = new UpdateRequest(es_index, es_type, id)
    val builder = XContentFactory.jsonBuilder
    builder.startObject
    for ((k, v) <- map) {
      builder.field(k, v)
    }
    builder.endObject
    updateRequest.doc(builder)
    client.update(updateRequest, RequestOptions.DEFAULT)
  }
}
