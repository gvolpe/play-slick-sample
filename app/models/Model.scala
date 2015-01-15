package models

import play.api.libs.json.Json

object Model {

  case class Car(company: String, model: String, id: Option[Long] = None)
  case class User(name: String, id: Option[Long] = None)

  object Implicits {

    implicit val carFormat = Json.format[Car]
    implicit val userFormat = Json.format[User]

  }

}
