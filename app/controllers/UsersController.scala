package controllers

import models.Model.User
import models._
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.libs.json.Json._
import play.api.mvc._

object UsersController extends Controller{

  import models.Model.Implicits._

  def findUsers = DBAction { implicit rs =>
    Ok(toJson(Table.userTable.list))
  }

  def addUser = DBAction(parse.json) { implicit rs =>
    rs.request.body.validate[User].map { user =>
      Table.userTable.insert(user)
      Ok(toJson(user))
    }.getOrElse(BadRequest("invalid user json"))
  }

}
