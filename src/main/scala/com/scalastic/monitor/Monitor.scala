package com.scalastic.monitor

import com.scalastic.monitor.config.PropertiesLoader
import com.scalastic.monitor.config.PropertiesLoader.PERSON_INDEX
import com.scalastic.monitor.entities.Person
import com.scalastic.monitor.repo.ElasticsearchQueryBuilber

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
    //    val map = Map[String, Any]("lastName" -> "Uchiha", "occupation" -> "Shinobi")
    //    val response2 = ElasticsearchQueryBuilber.update(PERSON_INDEX, PERSON_TYPE, "87f74b38-115a-475a-a3c5-ccfdaa1a8a2c", map)
    //    println(response2.toString)
    //    println(response2.status())

    //    3- getById :
    //    val personMap = ElasticsearchQueryBuilber.getById(PERSON_INDEX, PERSON_TYPE, "00479fd3-c542-4148-af63-069948e92c32")
    //    val person3 = Person.toPerson(personMap)
    //    println(person3.toString)

    //    4- getAll :
    //    val list = ElasticsearchQueryBuilber.getAll(PERSON_INDEX)
    //    list.foreach(map => {
    //      println(Person.toPerson(map).toString)
    //    })

    //    5- delete :
//    val response = ElasticsearchQueryBuilber.delete(PERSON_INDEX, PropertiesLoader.PERSON_TYPE, "00479fd3-c542-4148-af63-069948e92c32")
//    println(response.toString)
//    println(response.status())

    //    6- findAll :
    val list = ElasticsearchQueryBuilber.findAll(PERSON_INDEX)
    list.foreach(map => {
      println(Person.toPerson(map).toString)
    })
  }

}
