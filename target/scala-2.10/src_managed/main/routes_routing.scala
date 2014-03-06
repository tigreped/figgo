// @SOURCE:/home/pedro/workspace/playtestdrive/conf/routes
// @HASH:56dd1addf7f86fc8189ad78dbbc0c70977029699
// @DATE:Wed Mar 05 23:25:32 BRT 2014


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
private[this] lazy val controllers_Application_users4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:17
private[this] lazy val controllers_Application_newUser5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users"))))
        

// @LINE:18
private[this] lazy val controllers_Application_deleteUser6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("users/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.Application.users()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users""","""controllers.Application.newUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """users/$id<[^/]+>/delete""","""controllers.Application.deleteUser(id:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Application_users4(params) => {
   call { 
        invokeHandler(controllers.Application.users(), HandlerDef(this, "controllers.Application", "users", Nil,"GET", """Users""", Routes.prefix + """users"""))
   }
}
        

// @LINE:17
case controllers_Application_newUser5(params) => {
   call { 
        invokeHandler(controllers.Application.newUser(), HandlerDef(this, "controllers.Application", "newUser", Nil,"POST", """""", Routes.prefix + """users"""))
   }
}
        

// @LINE:18
case controllers_Application_deleteUser6(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Application.deleteUser(id), HandlerDef(this, "controllers.Application", "deleteUser", Seq(classOf[String]),"POST", """""", Routes.prefix + """users/$id<[^/]+>/delete"""))
   }
}
        
}

}
     