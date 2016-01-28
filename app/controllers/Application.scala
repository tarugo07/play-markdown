package controllers

import org.pegdown.PegDownProcessor
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def convert = Action { implicit request =>
    request.body.asFormUrlEncoded match {
      case Some(data) =>
        data.get("markdown") match {
          case Some(markdown) =>
            val htmlOpt = Option(new PegDownProcessor().markdownToHtml(markdown.head))
            Ok(htmlOpt.getOrElse(""))
          case None =>
            BadRequest("markdown not found")
        }
      case None =>
        BadRequest("invalid request parameter")
    }
  }

}
