package com.scalastic.monitor.entities

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class Person(firstName: String, lastName: String, age: Int, occupation: String) {
  def toMap(): Map[String, _] = {
    Map[String, Any]("firstName" -> firstName, "lastName" -> lastName, "age" -> age, "occupation" -> occupation)
  }
}
