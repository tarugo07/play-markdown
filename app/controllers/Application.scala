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
        val markdown = data.getOrElse("markdown", Seq("")).head
        val htmlOpt = Option(new PegDownProcessor().markdownToHtml(markdown))
        Ok(htmlOpt.getOrElse(""))
      case None =>
        BadRequest("markdown not found")
    }
  }

}
