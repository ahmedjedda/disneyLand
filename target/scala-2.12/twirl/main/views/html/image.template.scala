
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

object image extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(source: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/(""" 
  """),format.raw/*2.3*/("""<h1>TASK 2</h1>
  
  <img #imgID src="""),_display_(/*4.20*/source),format.raw/*4.26*/(""" """),format.raw/*4.27*/("""width="500" height="500">

"""))
      }
    }
  }

  def render(source:String): play.twirl.api.HtmlFormat.Appendable = apply(source)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (source) => apply(source)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Oct 08 19:19:30 CEST 2019
                  SOURCE: C:/Users/ahmed/Desktop/test/dlp-test/app/views/image.scala.html
                  HASH: 8a3990ede1852377f35e8b21f0d7eb062f5ba92a
                  MATRIX: 948->1|1059->17|1090->22|1156->62|1182->68|1210->69
                  LINES: 28->1|33->1|34->2|36->4|36->4|36->4
                  -- GENERATED --
              */
          