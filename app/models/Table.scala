package models

import models.Model.{Car, User}
import play.api.db.slick.Config.driver.simple._

object Table {

  val carTable = TableQuery[CarTable]

  class CarTable(tag: Tag) extends Table[Car](tag, "CAR") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def company = column[String]("company", O.NotNull)
    def model = column[String]("model", O.NotNull)

    def * = (company, model, id.?) <> (Car.tupled, Car.unapply _)

  }

  val userTable = TableQuery[UserTable]

  class UserTable(tag: Tag) extends Table[User](tag, "USER") {

    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name", O.NotNull)

    def * = (name, id.?) <> (User.tupled, User.unapply _)

  }

}
