package controllers

import javax.inject._
import models.{Category, CategoryRepository, Color, ColorRepository, Product, ProductRepository, SizeRepository}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class ProductController @Inject()(productsRepo: ProductRepository, categoryRepo: CategoryRepository, colorRepo: ColorRepository, sizeRepo: SizeRepository,  cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

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

  def getProducts: Action[AnyContent] = Action.async { implicit request =>
    val produkty = productsRepo.list()
    println("LISTA:")
    println(produkty)
    produkty.map( products =>
      for(p <- products) {
        val kategorie = productsRepo.getCategoryName(p.category)
        kategorie.onComplete( c =>  c.map(cc => println(p.name + ": " + cc(0).name)).getOrElse(println(p.name + ": NULL"  )))
      }
    )
    produkty.map( products => Ok(views.html.products(products)))
  }
//wyświetla liste dla usuniecia
  def getProductsRm: Action[AnyContent] = Action.async { implicit request =>
    val produkty = productsRepo.list()
//    println(produkty)
    produkty.map( products => Ok(views.html.products_rm(products)))
  }

  //wyświetla liste dla aktualizacji
  def getProductsUpdate: Action[AnyContent] = Action.async { implicit request =>
    val produkty = productsRepo.list()
    //    println(produkty)
    produkty.map( products => Ok(views.html.products_updt(products)))
  }
  def getProduct(id: Long): Action[AnyContent] = Action.async { implicit request =>
    val produkt = productsRepo.getByIdOption(id)
    produkt.map(product => product match {
      case Some(p) => Ok(views.html.product(p))
      case None => Redirect(controllers.routes.ProductController.getProducts)
    })
  }

  def delProduct(id: Long): Action[AnyContent] = Action {
    productsRepo.delete(id)
    Redirect(controllers.routes.ProductController.getProductsRm)
  }

  def updateProduct(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    var color:Seq[Color] = Seq[Color]()
    val colors = colorRepo.list().onComplete{
      case Success(c) => color = c
      case Failure(_) => print("fail")
    }
    val produkt = productsRepo.getById(id)
    produkt.map(product => {
      val prodForm = updateProductForm.fill(UpdateProductForm(product.id, product.category, product.color, product.name, product.description,product.price))
      //  id, product.name, product.description, product.category)
      //updateProductForm.fill(prodForm)
      Ok(views.html.productupdate(prodForm, categ))
    })
  }

  def updateProductHandle = Action.async { implicit request =>
    var categ:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => categ = cat
      case Failure(_) => print("fail")
    }

    updateProductForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.productupdate(errorForm, categ))
        )
      },
      product => {
        productsRepo.update(product.id, Product(product.id, product.category, product.color,  product.name, product.description, product.price)).map { _ =>
          Redirect(controllers.routes.ProductController.getProductsUpdate).flashing("success" -> "Zaktualizowano dane o produkcie.")
        }
      }

    )

  }


def addProduct: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
    val colors = colorRepo.list()
    val categories = categoryRepo.list()
    categories.flatMap(
          cat  =>  colors.map(cl => Ok(views.html.productadd(productForm, cat, cl)))
    )

  }

  def addProductHandle = Action.async { implicit request =>
    var categ:Seq[Category] = Seq[Category]()

    val categories = categoryRepo.list().onComplete{
      case Success(cat) =>  categ = cat
      case Failure(_) => println("err addProductHandle)")
    }
    var c:Seq[Color] = Seq[Color]()

    val colors = colorRepo.list().onComplete{
      case Success(cl) => c = cl
      case Failure(_) => println("err addProductHandle")
    }

    productForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          BadRequest(views.html.productadd(errorForm, categ, c))
        )
      },

      product => {

          productsRepo.create(product.category, product.color, product.name, product.description, product.price).map { _ =>

          Redirect(controllers.routes.ProductController.getProducts).flashing("success" -> "Produkt zostal dodany")
        }
       }
    )
  }
}

case class CreateProductForm( category: Int, color: Int, name: String, description: String, price: Int)
case class UpdateProductForm(id: Long,category: Int, color: Int, name: String, description: String, price: Int)