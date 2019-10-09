
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

object all extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,List[String],Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(source: String , images: List[String] , showOneImage : Boolean ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.67*/("""
  """),format.raw/*2.3*/("""<h1>ALL IN ONE VIEW</h1>


"""),_display_(/*5.2*/if(!source.isEmpty())/*5.23*/ {_display_(Seq[Any](format.raw/*5.25*/("""
"""),format.raw/*6.1*/("""<input type="submit" onclick="location.href='/all/false';" value="Switch" />


  <h1>ONE IMAGE </h1>
  
  <img #imgID src="""),_display_(/*11.20*/source),format.raw/*11.26*/(""" """),format.raw/*11.27*/("""width="500" height="500">
  
  
""")))}),format.raw/*14.2*/(""" 
"""),_display_(/*15.2*/if(images.size() != 0)/*15.24*/ {_display_(Seq[Any](format.raw/*15.26*/("""
"""),format.raw/*16.1*/("""<input type="submit" onclick="location.href='/all/true';" value="Switch" />

<h1>MULTIPLE IMAGES</h1>

<ul>
"""),_display_(/*21.2*/for(image <- images) yield /*21.22*/ {_display_(Seq[Any](format.raw/*21.24*/("""
  """),format.raw/*22.3*/("""<img src="""),_display_(/*22.13*/image),format.raw/*22.18*/(""" """),format.raw/*22.19*/("""width="500" height="500">
""")))}),format.raw/*23.2*/("""
"""),format.raw/*24.1*/("""</ul> 

""")))}))
      }
    }
  }

  def render(source:String,images:List[String],showOneImage:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(source,images,showOneImage)

  def f:((String,List[String],Boolean) => play.twirl.api.HtmlFormat.Appendable) = (source,images,showOneImage) => apply(source,images,showOneImage)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Oct 09 18:37:45 CEST 2019
                  SOURCE: C:/Users/ahmed/Desktop/test/dlp-test/app/views/all.scala.html
                  HASH: d9a6e304e93551130b91c4dd31c0e1be159598da
                  MATRIX: 967->1|1127->66|1157->70|1213->101|1242->122|1281->124|1309->126|1464->254|1491->260|1520->261|1586->297|1616->301|1647->323|1687->325|1716->327|1856->441|1892->461|1932->463|1963->467|2000->477|2026->482|2055->483|2113->511|2142->513
                  LINES: 28->1|33->1|34->2|37->5|37->5|37->5|38->6|43->11|43->11|43->11|46->14|47->15|47->15|47->15|48->16|53->21|53->21|53->21|54->22|54->22|54->22|54->22|55->23|56->24
                  -- GENERATED --
              */
          