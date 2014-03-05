
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
      <a href=""""),_display_(Seq[Any](/*10.17*/routes/*10.23*/.Application.index)),format.raw/*10.41*/("""" id="logo"><span>Login</span></a>
    </header>
    """),_display_(Seq[Any](/*12.6*/helper/*12.12*/.form(routes.Application.authenticate)/*12.50*/ {_display_(Seq[Any](format.raw/*12.52*/("""
      </br>
      <h1>Sign in</h1>
      <p>
        <input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*16.70*/form("email")/*16.83*/.value)),format.raw/*16.89*/("""">
      </p>
      <p>
        <input type="password" name="password" placeholder="Password">
      </p>
      <p>
        <button type="submit">Login</button>
      </p>
    """)))})),format.raw/*24.6*/("""
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
                    DATE: Wed Mar 05 15:55:56 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/login.scala.html
                    HASH: 7593cfd73120b574d149fe641bac1eb9f2415b62
                    MATRIX: 791->1|916->32|1047->128|1061->134|1114->166|1217->234|1231->240|1288->275|1375->326|1390->332|1430->350|1519->404|1534->410|1581->448|1621->450|1772->565|1794->578|1822->584|2030->761
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|38->10|38->10|38->10|40->12|40->12|40->12|40->12|44->16|44->16|44->16|52->24
                    -- GENERATED --
                */
            