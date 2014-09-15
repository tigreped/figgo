// @SOURCE:/home/pedro/workspace/figgo_bkp/conf/routes
// @HASH:4ec77c3519179fd5d787e5c2cbbb749536a01344
// @DATE:Mon Sep 15 09:53:05 BRT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
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
                          

// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:28
def deleteRole(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/delete")
}
                                                

// @LINE:27
def newRole(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles")
}
                                                

// @LINE:26
def roles(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "roles")
}
                                                

// @LINE:30
def removePermission(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/removePermission")
}
                                                

// @LINE:33
def newCardTransaction(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "cardTransactions")
}
                                                

// @LINE:29
def addPermission(id:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "roles/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/addPermission")
}
                                                

// @LINE:23
def removeRole(userId:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[String]].unbind("userId", dynamicString(userId)) + "/removeRole")
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
                                                

// @LINE:22
def addRole(userId:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[String]].unbind("userId", dynamicString(userId)) + "/addRole")
}
                                                
    
}
                          
}
                  


// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
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
              

// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:28
def deleteRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteRole",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/delete"})
      }
   """
)
                        

// @LINE:27
def newRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newRole",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles"})
      }
   """
)
                        

// @LINE:26
def roles : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.roles",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "roles"})
      }
   """
)
                        

// @LINE:30
def removePermission : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.removePermission",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/removePermission"})
      }
   """
)
                        

// @LINE:33
def newCardTransaction : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newCardTransaction",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "cardTransactions"})
      }
   """
)
                        

// @LINE:29
def addPermission : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addPermission",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "roles/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/addPermission"})
      }
   """
)
                        

// @LINE:23
def removeRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.removeRole",
   """
      function(userId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userId", encodeURIComponent(userId)) + "/removeRole"})
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
                        

// @LINE:22
def addRole : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addRole",
   """
      function(userId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("userId", encodeURIComponent(userId)) + "/addRole"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
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
                          

// @LINE:33
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:6
class ReverseApplication {
    

// @LINE:28
def deleteRole(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteRole(id), HandlerDef(this, "controllers.Application", "deleteRole", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/delete""")
)
                      

// @LINE:27
def newRole(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newRole(), HandlerDef(this, "controllers.Application", "newRole", Seq(), "POST", """""", _prefix + """roles""")
)
                      

// @LINE:26
def roles(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.roles(), HandlerDef(this, "controllers.Application", "roles", Seq(), "GET", """Roles""", _prefix + """roles""")
)
                      

// @LINE:30
def removePermission(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.removePermission(id), HandlerDef(this, "controllers.Application", "removePermission", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/removePermission""")
)
                      

// @LINE:33
def newCardTransaction(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newCardTransaction(), HandlerDef(this, "controllers.Application", "newCardTransaction", Seq(), "POST", """Card Transactions""", _prefix + """cardTransactions""")
)
                      

// @LINE:29
def addPermission(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addPermission(id), HandlerDef(this, "controllers.Application", "addPermission", Seq(classOf[String]), "POST", """""", _prefix + """roles/$id<[^/]+>/addPermission""")
)
                      

// @LINE:23
def removeRole(userId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.removeRole(userId), HandlerDef(this, "controllers.Application", "removeRole", Seq(classOf[String]), "POST", """""", _prefix + """users/$userId<[^/]+>/removeRole""")
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
                      

// @LINE:22
def addRole(userId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addRole(userId), HandlerDef(this, "controllers.Application", "addRole", Seq(classOf[String]), "POST", """""", _prefix + """users/$userId<[^/]+>/addRole""")
)
                      
    
}
                          
}
        
    