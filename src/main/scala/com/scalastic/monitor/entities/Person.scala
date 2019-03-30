package com.scalastic.monitor.entities

import play.api.libs.json.{Format, Json}

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class Person(firstName: String, lastName: String, age: Int, occupation: String) {
}

object Person {
  implicit val format: Format[Person] = Json.format[Person]
}
