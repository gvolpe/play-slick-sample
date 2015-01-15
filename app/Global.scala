import models.Model.User
import models.Table
import play.api.db.slick.Session
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import play.api.{Application, GlobalSettings}
import play.api.Play.current

object Global extends GlobalSettings {

  override def onStart(app: Application): Unit = {
    InitialData.insertUsers
  }

}

object InitialData {

  def insertUsers: Unit = {

    DB.withSession { implicit s: Session =>
      Seq(
        User("Pepe"),
        User("Juan"),
        User("Jose"),
        User("Gabi"),
        User("Tato")
      ).foreach(Table.userTable.insert)
    }

  }

}
