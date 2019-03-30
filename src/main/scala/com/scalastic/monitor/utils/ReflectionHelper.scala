package com.scalastic.monitor.utils

import play.api.libs.json.{Json, Writes}

import scala.reflect.runtime.currentMirror
import scala.reflect.runtime.universe._

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ReflectionHelper {
  def toMap(entity: Any): Map[String, Any] = {
    val r = currentMirror.reflect(entity)
    r.symbol.typeSignature.members.toStream
      .collect { case s: TermSymbol if !s.isMethod => r.reflectField(s) }
      .map(r => r.symbol.name.toString.trim -> r.get)
      .toMap
  }

  implicit val convertToJson: Writes[Any] = Writes[Any](a => a match {
    case v: String => Json.toJson(v)
    case v: Int => Json.toJson(v)
    case v: Any => Json.toJson(v.toString)
    // or, if you don't care about the value
    case _ => throw new RuntimeException("unserializeable type")
  })
}
