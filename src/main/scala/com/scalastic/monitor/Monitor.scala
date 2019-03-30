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
    val person = new Person("Isaac", "Netero", 125, "Hunter")
    val response = ElasticsearchQueryBuilber.insert(PERSON_INDEX, PERSON_TYPE, person)
    println(response.toString)
    println(response.status())
  }

}
