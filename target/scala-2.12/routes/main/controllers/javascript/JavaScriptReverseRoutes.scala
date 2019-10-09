// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ahmed/Desktop/test/dlp-test/conf/routes
// @DATE:Wed Oct 09 16:53:35 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def testMultiple: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.testMultiple",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "testMultiple"})
        }
      """
    )
  
    // @LINE:14
    def allInOnView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.allInOnView",
      """
        function(showOneImage0) {
        
          if (showOneImage0 == """ + implicitly[play.api.mvc.JavascriptLiteral[Boolean]].to(true) + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all/"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Boolean]].javascriptUnbind + """)("showOneImage", showOneImage0))})
          }
        
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:12
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
