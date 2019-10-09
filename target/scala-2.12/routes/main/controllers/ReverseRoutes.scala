// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ahmed/Desktop/test/dlp-test/conf/routes
// @DATE:Wed Oct 09 16:53:35 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def testMultiple(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "testMultiple")
    }
  
    // @LINE:14
    def allInOnView(showOneImage:Boolean): Call = {
    
      (showOneImage: @unchecked) match {
      
        // @LINE:14
        case (showOneImage) if showOneImage == true =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("showOneImage", true))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "all/")
      
        // @LINE:15
        case (showOneImage)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "all/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Boolean]].unbind("showOneImage", showOneImage)))
      
      }
    
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:12
    def test(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "test")
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
