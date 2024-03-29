// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ahmed/Desktop/test/dlp-test/conf/routes
// @DATE:Wed Oct 09 16:53:35 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """controllers.HomeController.test"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """testMultiple""", """controllers.HomeController.testMultiple"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all/""", """controllers.HomeController.allInOnView(showOneImage:Boolean = true)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all/""" + "$" + """showOneImage<[^/]+>""", """controllers.HomeController.allInOnView(showOneImage:Boolean)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_test2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_HomeController_test2_invoker = createInvoker(
    HomeController_0.test,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "test",
      Nil,
      "GET",
      this.prefix + """test""",
      """ Get image route """,
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_testMultiple3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("testMultiple")))
  )
  private[this] lazy val controllers_HomeController_testMultiple3_invoker = createInvoker(
    HomeController_0.testMultiple,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "testMultiple",
      Nil,
      "GET",
      this.prefix + """testMultiple""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_allInOnView4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all/")))
  )
  private[this] lazy val controllers_HomeController_allInOnView4_invoker = createInvoker(
    HomeController_0.allInOnView(fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "allInOnView",
      Seq(classOf[Boolean]),
      "GET",
      this.prefix + """all/""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_allInOnView5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all/"), DynamicPart("showOneImage", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_allInOnView5_invoker = createInvoker(
    HomeController_0.allInOnView(fakeValue[Boolean]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "allInOnView",
      Seq(classOf[Boolean]),
      "GET",
      this.prefix + """all/""" + "$" + """showOneImage<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:12
    case controllers_HomeController_test2_route(params@_) =>
      call { 
        controllers_HomeController_test2_invoker.call(HomeController_0.test)
      }
  
    // @LINE:13
    case controllers_HomeController_testMultiple3_route(params@_) =>
      call { 
        controllers_HomeController_testMultiple3_invoker.call(HomeController_0.testMultiple)
      }
  
    // @LINE:14
    case controllers_HomeController_allInOnView4_route(params@_) =>
      call(Param[Boolean]("showOneImage", Right(true))) { (showOneImage) =>
        controllers_HomeController_allInOnView4_invoker.call(HomeController_0.allInOnView(showOneImage))
      }
  
    // @LINE:15
    case controllers_HomeController_allInOnView5_route(params@_) =>
      call(params.fromPath[Boolean]("showOneImage", None)) { (showOneImage) =>
        controllers_HomeController_allInOnView5_invoker.call(HomeController_0.allInOnView(showOneImage))
      }
  }
}
