package com.scalastic.monitor

import com.scalastic.monitor.config.PropertiesLoader.{PERSON_INDEX, PERSON_TYPE}
import com.scalastic.monitor.entities.Person
import com.scalastic.monitor.repo.ElasticsearchQueryBuilber

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Monitor {

  def main(args: Array[String]): Unit = {
    //    val person = Person("Isaac", "Netero", 125, "Hunter")
    //    val response = ElasticsearchQueryBuilber.insert(PERSON_INDEX, PERSON_TYPE, person.toMap())
    //    println(response.toString)
    //    println(response.status())

    //    val map = Map[String, Any]("lastName" -> "Uchiha", "occupation" -> "Shinobi")
    //    val response2 = ElasticsearchQueryBuilber.update(PERSON_INDEX, PERSON_TYPE, "87f74b38-115a-475a-a3c5-ccfdaa1a8a2c", map)
    //    println(response2.toString)
    //    println(response2.status())

    val personMap = ElasticsearchQueryBuilber.getById(PERSON_INDEX, PERSON_TYPE, "00479fd3-c542-4148-af63-069948e92c32")
    val person3 = Person.toPerson(personMap)
    println(person3.toString)
  }

}
