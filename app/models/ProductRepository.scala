package models


import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile
import slick.lifted.{TableQuery, Tag}
import slick.model.Table

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
//import slick.driver.SQLiteDriver.api._


@Singleton
class ProductRepository @Inject() (dbConfigProvider: DatabaseConfigProvider) (implicit ec: ExecutionContext) {
  val dbConfig  = dbConfigProvider.get{JdbcProfile}

  import dbConfig._
  import profile.api._

  class ProductTable (tag: Tag) extends Table[Product](tag: "Product") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("Name")
    def desc = column[String]("Description")
//    def categoryFK = foreignKeys("cat_fk", category, cat)(_.id)
    def * = (id, name, desc) <> ((Product.apply _).tupled, Product.unapply )

  }

  private val product = TableQuery[ProductTable];

  def create( sName: String, sDesc: String ): Future [Seq[Product]] = db.run {
    ( product.map( p => ( p.name, p.desc) )
        returning product.map(_.id)
        into { case  ((name, description), id) => Product(id, name, description)}
      ) *= (name, description)
  }

  def list(): Future [Seq[Product]] = db.run {
    product.result
  }
}
