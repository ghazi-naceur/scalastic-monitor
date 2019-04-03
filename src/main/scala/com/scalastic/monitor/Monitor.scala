package com.scalastic.monitor

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.scalastic.monitor.config.PropertiesLoader
import com.scalastic.monitor.config.PropertiesLoader.{CITY_INDEX, PERSON_INDEX, PERSON_TYPE}
import com.scalastic.monitor.entities.{City, Person}
import com.scalastic.monitor.repo.ElasticsearchQueryBuilber
import com.scalastic.monitor.requests.HttpRequests

import scala.concurrent.Await
import scala.concurrent.duration.Duration

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
    val indices = HttpRequests.getRequest("http://localhost:9200/_cat/indices?v")
    println(indices)
  }

}
