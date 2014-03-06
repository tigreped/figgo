// @SOURCE:/home/pedro/workspace/playtestdrive/conf/routes
// @HASH:56dd1addf7f86fc8189ad78dbbc0c70977029699
// @DATE:Wed Mar 05 23:25:32 BRT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def users(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users")
}
                                                

// @LINE:18
def deleteUser(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/delete")
}
                                                

// @LINE:13
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:17
def newUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:12
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def users : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.users",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        

// @LINE:18
def deleteUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteUser",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/delete"})
      }
   """
)
                        

// @LINE:13
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:17
def newUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:12
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:16
def users(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.users(), HandlerDef(this, "controllers.Application", "users", Seq(), "GET", """Users""", _prefix + """users""")
)
                      

// @LINE:18
def deleteUser(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteUser(id), HandlerDef(this, "controllers.Application", "deleteUser", Seq(classOf[String]), "POST", """""", _prefix + """users/$id<[^/]+>/delete""")
)
                      

// @LINE:13
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:17
def newUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newUser(), HandlerDef(this, "controllers.Application", "newUser", Seq(), "POST", """""", _prefix + """users""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:12
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """Login""", _prefix + """login""")
)
                      
    
}
                          
}
        
    