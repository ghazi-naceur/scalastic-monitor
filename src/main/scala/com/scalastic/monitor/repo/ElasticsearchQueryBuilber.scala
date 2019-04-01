package com.scalastic.monitor.repo

import java.util.UUID

import com.scalastic.monitor.client.ElasticsearchClient
import org.elasticsearch.action.delete.{DeleteRequest, DeleteResponse}
import org.elasticsearch.action.get.GetRequest
import org.elasticsearch.action.index.{IndexRequest, IndexResponse}
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.update.{UpdateRequest, UpdateResponse}
import org.elasticsearch.client.{RequestOptions, RestHighLevelClient}
import org.elasticsearch.common.xcontent.XContentFactory
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.SearchHit
import org.elasticsearch.search.builder.SearchSourceBuilder

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

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

  def update(es_index: String, es_type: String, es_id: String, map: Map[String, _]): UpdateResponse = {
    val updateRequest = new UpdateRequest(es_index, es_type, es_id)
    val builder = XContentFactory.jsonBuilder
    builder.startObject
    for ((k, v) <- map) {
      builder.field(k, v)
    }
    builder.endObject
    updateRequest.doc(builder)
    client.update(updateRequest, RequestOptions.DEFAULT)
  }

  def getById(es_index: String, es_type: String, es_id: String): Map[String, AnyRef] = {
    val getRequest = new GetRequest(es_index, es_type, es_id)
    val response = client.get(getRequest, RequestOptions.DEFAULT)
    // asScala : to have a mutable map
    // map(kv => (kv._1,kv._2)).toMap : to get an immutable map
    response.getSource.asScala.map(kv => (kv._1, kv._2)).toMap
  }

  // TODO implement scan & scroll
  def getAll(es_index: String): List[Map[String, AnyRef]] = {
    var result = ListBuffer[Map[String, AnyRef]]()
    val searchSourceBuilder = new SearchSourceBuilder
    val builder = searchSourceBuilder.query(QueryBuilders.matchAllQuery())
    val searchRequest = new SearchRequest(es_index)
    searchRequest.source(builder)
    val response = client.search(searchRequest, RequestOptions.DEFAULT)
    response.getHits
    for (hit: SearchHit <- response.getHits.getHits) {
      result += hit.getSourceAsMap.asScala.map(kv => (kv._1, kv._2)).toMap
    }
    result.toList
  }

  def delete(es_index: String, es_type: String, id: String): DeleteResponse = {
    val deleteRequest = new DeleteRequest(es_index, es_type, id)
    client.delete(deleteRequest, RequestOptions.DEFAULT)
  }
}
