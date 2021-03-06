package com.scalastic.monitor

import com.scalastic.monitor.mail.Mailer
//import com.scalastic.monitor.mail.{MailAgent, MailerService, MyMailerClient}
import com.scalastic.monitor.requests.ElasticMonitor

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Monitor {

  def main(args: Array[String]): Unit = {

    //    1- insert :
    //        val person = Person("Isaac", "Netero", 125, "Hunter")
    //        val response = ElasticsearchQueryBuilber.insert(PERSON_INDEX, PERSON_TYPE, person.toMap())
    //        println(response.toString)
    //        println(response.status())

    //    2- update :
    //        val map = Map[String, Any]("lastName" -> "Uchiha", "occupation" -> "Shinobi")
    //        val response2 = ElasticsearchQueryBuilber.update(PERSON_INDEX, PERSON_TYPE, "00e22677-e988-4964-a39c-1fdf786c2436", map)
    //        println(response2.toString)
    //        println(response2.status())

    //    3- getById :
    //        val personMap = ElasticsearchQueryBuilber.getById(PERSON_INDEX, PERSON_TYPE, "00e22677-e988-4964-a39c-1fdf786c2436")
    //        val person3 = Person.toPerson(personMap)
    //        println(person3.toString)

    //    4- getAll :
    //        val list = ElasticsearchQueryBuilber.getAll(PERSON_INDEX)
    //        list.foreach(map => {
    //          println(Person.toPerson(map).toString)
    //        })

    //    5- delete :
    //        val response = ElasticsearchQueryBuilber.delete(PERSON_INDEX, PropertiesLoader.PERSON_TYPE, "00e22677-e988-4964-a39c-1fdf786c2436")
    //        println(response.toString)
    //        println(response.status())

    //    6- findAll : 9300
    //        val list = ElasticsearchQueryBuilber.findAll(PERSON_INDEX)
    //        list.foreach(map => {
    //          println(Person.toPerson(map).toString)
    //        })

    // 7- search : 9200
    //        val map = Map[String, Any]("lastName" -> "Netero", "occupation" -> "Hunter")
    //        val persons = ElasticsearchQueryBuilber.search(PERSON_INDEX, map)
    //        persons.foreach(map => {
    //          println(Person.toPerson(map).toString)
    //        })
    // 8- getEntitiesFromIndexUsingMatchQuery :
    //          val persons = ElasticsearchQueryBuilber.getEntitiesFromIndexUsingMatchQuery(PERSON_INDEX, "lastName", "Netero")
    //          persons.foreach(map => {
    //            println(Person.toPerson(map).toString)
    //          })
    // 9- getEntitiesFromIndexUsingTermQuery : 1st attempt
    //      val persons = ElasticsearchQueryBuilber.getEntitiesFromIndexUsingTermQuery(PERSON_INDEX, "lastName", "Netero")
    //      persons.foreach(map => {
    //        println(Person.toPerson(map).toString)
    //      })
    // => This operation with "text" mapping (lastName) will return an empty result

    // 10- getEntitiesFromIndexUsingTermQuery : 2nd attempt
    //    val city = City("Konoha", "some prefecture", "Hidden leaf", 5000)
    //    ElasticsearchQueryBuilber.insert(PropertiesLoader.CITY_INDEX, PropertiesLoader.CITY_TYPE, city.toMap())
    //    ElasticsearchQueryBuilber.insert(PropertiesLoader.CITY_INDEX, PropertiesLoader.CITY_TYPE, city.toMap())
    //    ElasticsearchQueryBuilber.insert(PropertiesLoader.CITY_INDEX, PropertiesLoader.CITY_TYPE, city.toMap())
    // a :
    //      val cities = ElasticsearchQueryBuilber.getEntitiesFromIndexUsingTermQuery(CITY_INDEX, "name", "Konoha")
    //      cities.foreach(map => {
    //        println(City.toCity(map).toString)
    //      })
    // => This operation with "keyword" mapping (name) will return a result
    // b :
    //      val cities = ElasticsearchQueryBuilber.getEntitiesFromIndexUsingTermQuery(CITY_INDEX, "country", "Hidden leaf")
    //      cities.foreach(map => {
    //        println(City.toCity(map).toString)
    //      })
    // => This operation with "text" mapping (country) will return an empty result

    // 11- getDocumentsFromIndexUsingPrefixQuery :
    //      val cities = ElasticsearchQueryBuilber.getDocumentsFromIndexUsingPrefixQuery(CITY_INDEX, "country", "som")
    //      cities.foreach(map => {
    //        println(City.toCity(map).toString)
    //      })
    // To search with text and keyword fields, prefixQuery would be a good solution
    //      val cities2 = ElasticsearchQueryBuilber.getDocumentsFromIndexUsingPrefixQuery(CITY_INDEX, "prefecture", "som")
    //      cities2.foreach(map => {
    //        println(City.toCity(map).toString)
    //      })

    // 12- Get http :
    //    val indices = HttpRequests.getRequest("http://localhost:9200/_cat/indices?v")
    //    println(indices)

    // 13- Get indices :
    //    val indices = ElasticMonitor.getIndices("localhost")
    //    println(indices)

    // 14- Count docs :
    //    val countDocs = ElasticMonitor.countDocs("localhost", "persons")
    //    println(countDocs)

    // 15- Show mapping :
    //    val mapping = ElasticMonitor.showMapping("localhost", "persons")
    //    println(mapping)

    // 16- Search first page :
    //    val search = ElasticMonitor.searchFirstPage("localhost", "persons")
    //    println(search)

    // 17- Get nodes :
    //    val nodes = ElasticMonitor.getEsNodes("localhost")
    //    println(nodes)

    // 18- Get cluster health :
    //    val clusterHealth = ElasticMonitor.getClusterHealth("localhost")
    //    println(clusterHealth)

    // 19- Get alias :
    //    val alias = ElasticMonitor.getAlias("localhost", "persons")
    //    println(alias)

    // 20- Get thread pool :
    //    val threadPool = ElasticMonitor.getThreadPool("localhost")
    //    println(threadPool)

    // 21- Get master node :
    //    val master = ElasticMonitor.getMasterNode("localhost")
    //    println(master)

    // 22- Get Hard drive memory allocation :
    //    val hdMemory = ElasticMonitor.getHardDriveMemoryAllocation("localhost")
    //    println(hdMemory)

    // 23- Get pending tasks :
    //    val pendingTasks = ElasticMonitor.getPendingTasks("localhost")
    //    println(pendingTasks)

    // 24- Get segments :
    //    val segments = ElasticMonitor.getSegments("localhost", "persons")
    //    println(segments)

    // 25- Get segments details :
    //    val segments = ElasticMonitor.getSegmentsDetails("localhost", "persons")
    //    println(segments)

    // 26- Get node attrs :
    //    val nodeAttrs = ElasticMonitor.getNodeAttrs("localhost")
    //    println(nodeAttrs)

    // 27- Get templates :
    //    val templates = ElasticMonitor.getTemplates("localhost")
    //    println(templates)

    // 28- Get tasks :
    //    val tasks = ElasticMonitor.getTasks("localhost")
    //    println(tasks)

    // 29- Get shards :
    //    val shards = ElasticMonitor.getShards("localhost", "persons")
    //    println(shards)

    // 30- Get plugins :
    //    val plugins = ElasticMonitor.getPlugins("localhost")
    //    println(plugins)

    // 31- Send mail :
    val address = "account@gmail.com"
    val password = "password"
    val subject = "Elasticsearch Cluster Statistics"
    val indices = ElasticMonitor.getIndices("localhost")
    val hdMemory = ElasticMonitor.getHardDriveMemoryAllocation("localhost")
    val text = indices + "\n" + hdMemory
    Mailer.sendMail(address, password, subject, text)
  }

}
