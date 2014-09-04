// @SOURCE:/home/pedro/workspace/playtestdrive/conf/routes
// @HASH:e8bf081205dcfe53c62f487f1689f430d49b0503
// @DATE:Sun Jun 08 22:07:09 BRT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
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
                          

// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def deleteRole(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/delete")
}
                                                

// @LINE:25
def newRole(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles")
}
                                                

// @LINE:24
def roles(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "roles")
}
                                                

// @LINE:28
def removePermission(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/removePermission")
}
                                                

// @LINE:31
def newCardTransaction(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cardTransactions")
}
                                                

// @LINE:27
def addPermission(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/addPermission")
}
                                                

// @LINE:19
def users(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "users")
}
                                                

// @LINE:16
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:21
def deleteUser(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/delete")
}
                                                

// @LINE:13
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:20
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
                  


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
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
              

// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def deleteRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteRole",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/delete"})
      }
   """
)
                        

// @LINE:25
def newRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newRole",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles"})
      }
   """
)
                        

// @LINE:24
def roles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.roles",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "roles"})
      }
   """
)
                        

// @LINE:28
def removePermission : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.removePermission",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/removePermission"})
      }
   """
)
                        

// @LINE:31
def newCardTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newCardTransaction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cardTransactions"})
      }
   """
)
                        

// @LINE:27
def addPermission : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addPermission",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/addPermission"})
      }
   """
)
                        

// @LINE:19
def users : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.users",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
      }
   """
)
                        

// @LINE:16
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:21
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
                        

// @LINE:20
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
        


// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
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
                          

// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def deleteRole(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteRole(id), HandlerDef(this, "controllers.Application", "deleteRole", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/delete""")
)
                      

// @LINE:25
def newRole(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newRole(), HandlerDef(this, "controllers.Application", "newRole", Seq(), "POST", """""", _prefix + """roles""")
)
                      

// @LINE:24
def roles(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.roles(), HandlerDef(this, "controllers.Application", "roles", Seq(), "GET", """Roles""", _prefix + """roles""")
)
                      

// @LINE:28
def removePermission(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.removePermission(id), HandlerDef(this, "controllers.Application", "removePermission", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/removePermission""")
)
                      

// @LINE:31
def newCardTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newCardTransaction(), HandlerDef(this, "controllers.Application", "newCardTransaction", Seq(), "POST", """Card Transactions""", _prefix + """cardTransactions""")
)
                      

// @LINE:27
def addPermission(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addPermission(id), HandlerDef(this, "controllers.Application", "addPermission", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/addPermission""")
)
                      

// @LINE:19
def users(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.users(), HandlerDef(this, "controllers.Application", "users", Seq(), "GET", """Users""", _prefix + """users""")
)
                      

// @LINE:16
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """Logout""", _prefix + """logout""")
)
                      

// @LINE:21
def deleteUser(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteUser(id), HandlerDef(this, "controllers.Application", "deleteUser", Seq(classOf[String]), "POST", """""", _prefix + """users/$id<[^/]+>/delete""")
)
                      

// @LINE:13
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:20
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
        
    