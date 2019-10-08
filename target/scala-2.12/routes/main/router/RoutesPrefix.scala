// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/ahmed/Desktop/test/dlp-test/conf/routes
// @DATE:Tue Oct 08 19:54:18 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
