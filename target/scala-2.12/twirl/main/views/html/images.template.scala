
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object images extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/( images: List[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.25*/("""

"""),format.raw/*3.1*/("""<h1>TASK 3</h1>

<ul>
"""),_display_(/*6.2*/for(image <- images) yield /*6.22*/ {_display_(Seq[Any](format.raw/*6.24*/("""
  """),format.raw/*7.3*/("""<img src="""),_display_(/*7.13*/image),format.raw/*7.18*/(""" """),format.raw/*7.19*/("""width="500" height="500">
""")))}),format.raw/*8.2*/("""
"""),format.raw/*9.1*/("""</ul> """))
      }
    }
  }

  def render(images:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(images)

  def f:((List[String]) => play.twirl.api.HtmlFormat.Appendable) = (images) => apply(images)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 08 16:16:15 CEST 2019
                  SOURCE: C:/Users/ahmed/Desktop/test/dlp-test/app/views/images.scala.html
                  HASH: 2c46810f7dfd78921c5cc2607c7522260ad4b088
                  MATRIX: 955->1|1073->24|1103->28|1154->54|1189->74|1228->76|1258->80|1294->90|1319->95|1347->96|1404->124|1432->126
                  LINES: 28->1|33->1|35->3|38->6|38->6|38->6|39->7|39->7|39->7|39->7|40->8|41->9
                  -- GENERATED --
              */
          