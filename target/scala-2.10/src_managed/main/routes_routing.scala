// @SOURCE:/home/pedro/workspace/playtestdrive/conf/routes
// @HASH:e8bf081205dcfe53c62f487f1689f430d49b0503
// @DATE:Sun Jun 08 22:07:09 BRT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:12
private[this] lazy val controllers_Application_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:13
private[this] lazy val controllers_Application_authenticate3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:16
private[this] lazy val controllers_Application_logout4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:19
private[this] lazy val controllers_Application_users5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:20
private[this] lazy val controllers_Application_newUser6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:21
private[this] lazy val controllers_Application_deleteUser7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
        

// @LINE:24
private[this] lazy val controllers_Application_roles8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("roles"))))
        

// @LINE:25
private[this] lazy val controllers_Application_newRole9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("roles"))))
        

// @LINE:26
private[this] lazy val controllers_Application_deleteRole10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("roles/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
        

// @LINE:27
private[this] lazy val controllers_Application_addPermission11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("roles/"),DynamicPart("id", """[^/]+""",true),StaticPart("/addPermission"))))
        

// @LINE:28
private[this] lazy val controllers_Application_removePermission12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("roles/"),DynamicPart("id", """[^/]+""",true),StaticPart("/removePermission"))))
        

// @LINE:31
private[this] lazy val controllers_Application_newCardTransaction13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("cardTransactions"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.Application.users()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.Application.newUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/$id<[^/]+>/delete""","""controllers.Application.deleteUser(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """roles""","""controllers.Application.roles()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """roles""","""controllers.Application.newRole()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """roles/$id<[^/]+>/delete""","""controllers.Application.deleteRole(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """roles/$id<[^/]+>/addPermission""","""controllers.Application.addPermission(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """roles/$id<[^/]+>/removePermission""","""controllers.Application.removePermission(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """cardTransactions""","""controllers.Application.newCardTransaction()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:12
case controllers_Application_login2(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """Login""", Routes.prefix + """login"""))
   }
}
        

// @LINE:13
case controllers_Application_authenticate3(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:16
case controllers_Application_logout4(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """Logout""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:19
case controllers_Application_users5(params) => {
   call { 
        invokeHandler(controllers.Application.users(), HandlerDef(this, "controllers.Application", "users", Nil,"GET", """Users""", Routes.prefix + """users"""))
   }
}
        

// @LINE:20
case controllers_Application_newUser6(params) => {
   call { 
        invokeHandler(controllers.Application.newUser(), HandlerDef(this, "controllers.Application", "newUser", Nil,"POST", """""", Routes.prefix + """users"""))
   }
}
        

// @LINE:21
case controllers_Application_deleteUser7(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteUser(id), HandlerDef(this, "controllers.Application", "deleteUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """users/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:24
case controllers_Application_roles8(params) => {
   call { 
        invokeHandler(controllers.Application.roles(), HandlerDef(this, "controllers.Application", "roles", Nil,"GET", """Roles""", Routes.prefix + """roles"""))
   }
}
        

// @LINE:25
case controllers_Application_newRole9(params) => {
   call { 
        invokeHandler(controllers.Application.newRole(), HandlerDef(this, "controllers.Application", "newRole", Nil,"POST", """""", Routes.prefix + """roles"""))
   }
}
        

// @LINE:26
case controllers_Application_deleteRole10(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteRole(id), HandlerDef(this, "controllers.Application", "deleteRole", Seq(classOf[String]),"POST", """""", Routes.prefix + """roles/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:27
case controllers_Application_addPermission11(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.addPermission(id), HandlerDef(this, "controllers.Application", "addPermission", Seq(classOf[String]),"POST", """""", Routes.prefix + """roles/$id<[^/]+>/addPermission"""))
   }
}
        

// @LINE:28
case controllers_Application_removePermission12(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.removePermission(id), HandlerDef(this, "controllers.Application", "removePermission", Seq(classOf[String]),"POST", """""", Routes.prefix + """roles/$id<[^/]+>/removePermission"""))
   }
}
        

// @LINE:31
case controllers_Application_newCardTransaction13(params) => {
   call { 
        invokeHandler(controllers.Application.newCardTransaction(), HandlerDef(this, "controllers.Application", "newCardTransaction", Nil,"POST", """Card Transactions""", Routes.prefix + """cardTransactions"""))
   }
}
        
}

}
     