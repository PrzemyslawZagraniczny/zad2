package controllers

import javax.inject._
import models.{Category, CategoryRepository, Product, ProductRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

import controllers.ProductController

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class SearchController @Inject()(productsRepo: ProductRepository, categoryRepo: CategoryRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {
  val productForm: Form[CreateProductForm] = Form {
    mapping(
      "category" -> number,
      "color" -> number,
      "name" -> nonEmptyText,
      "description" -> nonEmptyText,
      "price" -> number,
    )(CreateProductForm.apply)(CreateProductForm.unapply)
  }

  val updateProductForm: Form[UpdateProductForm] = Form {
    mapping(
    "id" -> longNumber,
    "category" -> number,
    "color" -> number,
    "name" -> nonEmptyText,
    "description" -> nonEmptyText,
    "price" -> number,
    )(UpdateProductForm.apply)(UpdateProductForm.unapply)
  }

//  def filterProductsSnd(products:Seq[Product]): Action[AnyContent] = Action.async { implicit request =>
//    val cats = categoryRepo.list()
//    cats.map(kat => {}
//
//    )
//  }
  def filterProducts: Action[AnyContent] = Action.async { implicit request =>
    val produkty = productsRepo.innerJoinCat()
//    produkty.map(products =>
//      Redirect(controllers.routes.SearchController.filterProductsSnd(products))
//    )

    produkty.map( products => Ok(views.html.search_products(products)))

  }
}
