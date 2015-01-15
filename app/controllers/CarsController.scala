package controllers

import models._
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.libs.json.Json._
import play.api.mvc._

object CarsController extends Controller{

  import models.Model.Implicits._

  def findCars = DBAction { implicit rs =>
    Ok(toJson(Table.carTable.list))
  }
  
}
