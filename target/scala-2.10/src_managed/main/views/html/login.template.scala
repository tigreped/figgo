
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""
<html>
  <head>
    <title>Login</title>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*5.55*/routes/*5.61*/.Assets.at("images/favicon.png"))),format.raw/*5.93*/("""">
    <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*6.66*/routes/*6.72*/.Assets.at("stylesheets/login.css"))),format.raw/*6.107*/("""">
  </head>
  <body>
    <header>
      <a href=""""),_display_(Seq[Any](/*10.17*/routes/*10.23*/.Application.index)),format.raw/*10.41*/("""" id="logo"><span>Home</span></a>
      <a href=""""),_display_(Seq[Any](/*11.17*/routes/*11.23*/.Application.users)),format.raw/*11.41*/(""""><span>Users</span></a>
    </header>
    """),_display_(Seq[Any](/*13.6*/helper/*13.12*/.form(routes.Application.authenticate)/*13.50*/ {_display_(Seq[Any](format.raw/*13.52*/("""
      </br>
      <h1>Sign in</h1>
      """),_display_(Seq[Any](/*16.8*/if(form.hasGlobalErrors)/*16.32*/ {_display_(Seq[Any](format.raw/*16.34*/("""
	<p class="error">
	  """),_display_(Seq[Any](/*18.5*/form/*18.9*/.globalError.message)),format.raw/*18.29*/("""
	</p>  
      """)))})),format.raw/*20.8*/("""
      <p>
        <input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*22.70*/form("email")/*22.83*/.value)),format.raw/*22.89*/("""">
      </p>
      <p>
        <input type="password" name="password" placeholder="Password">
      </p>
      <p>
        <button type="submit">Login</button>
      </p>
    """)))})),format.raw/*30.6*/("""
  </body>
</html>
    
    
"""))}
    }
    
    def render(form:Form[Application.Login]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 05 19:06:19 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/login.scala.html
                    HASH: 85e8c30830145cd932624b9d1ef0e6fb43533edf
                    MATRIX: 791->1|916->32|1047->128|1061->134|1114->166|1217->234|1231->240|1288->275|1375->326|1390->332|1430->350|1516->400|1531->406|1571->424|1650->468|1665->474|1712->512|1752->514|1830->557|1863->581|1903->583|1962->607|1974->611|2016->631|2063->647|2179->727|2201->740|2229->746|2437->923
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|38->10|38->10|38->10|39->11|39->11|39->11|41->13|41->13|41->13|41->13|44->16|44->16|44->16|46->18|46->18|46->18|48->20|50->22|50->22|50->22|58->30
                    -- GENERATED --
                */
            