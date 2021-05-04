package controllers

import javax.inject._
import models.{Category, CategoryRepository, Product, ProductRepository}
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
class CategoryController @Inject()(catsRepo: CategoryRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val categoryForm: Form[CreateCategoryForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "desc" -> nonEmptyText,
     )(CreateCategoryForm.apply)(CreateCategoryForm.unapply)
  }

  val updateCategoryForm: Form[UpdateCategoryForm] = Form {
    mapping(
      "id" -> longNumber,
      "name" -> nonEmptyText,
      "desc" -> nonEmptyText,
    )(UpdateCategoryForm.apply)(UpdateCategoryForm.unapply)
  }

  def index = Action {
    Ok(views.html.index())
  }

  def getCats: Action[AnyContent] = Action.async { implicit request =>
    val cats = catsRepo.list()
    println(cats)
    cats.map( cats => Ok(views.html.cats(cats)))
  }
////wyświetla liste dla usuniecia
//  def getProductsRm: Action[AnyContent] = Action.async { implicit request =>
//    val produkty = productsRepo.list()
////    println(produkty)
//    produkty.map( products => Ok(views.html.products_rm(products)))
//  }
//
//  //wyświetla liste dla aktualizacji
//  def getProductsUpdate: Action[AnyContent] = Action.async { implicit request =>
//    val produkty = productsRepo.list()
//    //    println(produkty)
//    produkty.map( products => Ok(views.html.products_updt(products)))
//  }
  def getCat(id: Int): Action[AnyContent] = Action.async { implicit request =>
    val kat = catsRepo.getByIdOption(id)
    kat.map(cat => cat match {
      case Some(c) => Ok(views.html.cat(c))
      case None => Redirect(controllers.routes.CategoryController.getCats)
    })
  }

//  def delProduct(id: Long): Action[AnyContent] = Action {
//    categoryRepo.delete(id)
//    Redirect(controllers.routes.HomeController.getProductsRm)
//  }

//  def updateProduct(id: Long): Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
//    var categ:Seq[Category] = Seq[Category]()
//    val categories = categoryRepo.list().onComplete{
//      case Success(cat) => categ = cat
//      case Failure(_) => print("fail")
//    }
//
//    val produkt = categoryRepo.category
//    produkt.map(product => {
//      val prodForm = UpdateCategoryForm.fill(UpdateCategoryForm(product.id,  product.name, product))
//      //  id, product.name, product.description, product.category)
//      //UpdateCategoryForm.fill(prodForm)
//      Ok(views.html.productupdate(prodForm, categ))
//    })
//  }
//
//  def updateProductHandle = Action.async { implicit request =>
//    var categ:Seq[Category] = Seq[Category]()
//    val categories = categoryRepo.list().onComplete{
//      case Success(cat) => categ = cat
//      case Failure(_) => print("fail")
//    }
//
//    UpdateCategoryForm.bindFromRequest.fold(
//      errorForm => {
//        Future.successful(
//          BadRequest(views.html.productupdate(errorForm, categ))
//        )
//      },
//      category => {
//        categoryRepo.update(category.id, Category(category.id, category.name, category.description )).map { _ =>
//          Redirect(controllers.routes.HomeController.getProductsUpdate).flashing("success" -> "Zaktualizowano dane o produkcie.")
//        }
//      }
//
//    )
//
//  }


//  def addProduct: Action[AnyContent] = Action.async { implicit request: MessagesRequest[AnyContent] =>
//    val categories = categoryRepo.list()
//    categories.map (cat => Ok(views.html.productadd(categoryForm, cat)))
//  }
//
//  def addProductHandle = Action.async { implicit request =>
//    var categ:Seq[Category] = Seq[Category]()
//    val categories = categoryRepo.list().onComplete{
//      case Success(cat) =>  categ = cat
//      case Failure(_) => print("fail")
//    }
//
//    categoryForm.bindFromRequest.fold(
//      errorForm => {
//        Future.successful(
//          BadRequest(views.html.categoryadd(errorForm, categ))
//        )
//      },
//      category => {
//          categoryRepo.create(category.name).map { _ =>
//          Redirect(controllers.routes.HomeController.getProducts).flashing("success" -> "Kategoria zostala dodana")
//        }
//       }
//    )
//  }
}

case class CreateCategoryForm(name: String, desc: String)
case class UpdateCategoryForm(id: Long, name: String, desc: String)