
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
object users extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[User],Form[User],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(users: List[User], userForm: Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.43*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Users")/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""

  <h2>User list. ["""),_display_(Seq[Any](/*7.20*/users/*7.25*/.size)),format.raw/*7.30*/(""" user(s)]</h2>

  <ul>
    """),_display_(Seq[Any](/*10.6*/for(user <- users) yield /*10.24*/ {_display_(Seq[Any](format.raw/*10.26*/("""
      <li>
        <strong>Email:</strong> """),_display_(Seq[Any](/*12.34*/user/*12.38*/.email)),format.raw/*12.44*/("""
	<strong>Name:</strong> """),_display_(Seq[Any](/*13.26*/user/*13.30*/.name)),format.raw/*13.35*/("""
	"""),_display_(Seq[Any](/*14.3*/form(routes.Application.deleteUser(user.id))/*14.47*/ {_display_(Seq[Any](format.raw/*14.49*/("""
	  <input type="submit" value="delete">
	""")))})),format.raw/*16.3*/("""
      </li>
    """)))})),format.raw/*18.6*/("""
  </ul>  

  <h2> Add a new user: </h2>
  
  """),_display_(Seq[Any](/*23.4*/form(routes.Application.newUser())/*23.38*/ {_display_(Seq[Any](format.raw/*23.40*/("""
    """),_display_(Seq[Any](/*24.6*/inputText(userForm("email")))),format.raw/*24.34*/("""
    """),_display_(Seq[Any](/*25.6*/inputText(userForm("name")))),format.raw/*25.33*/("""
    """),_display_(Seq[Any](/*26.6*/inputPassword(userForm("password")))),format.raw/*26.41*/("""
    <input type="submit" value="create">
  """)))})),format.raw/*28.4*/("""
""")))})),format.raw/*29.2*/("""
"""))}
    }
    
    def render(users:List[User],userForm:Form[User]): play.api.templates.HtmlFormat.Appendable = apply(users,userForm)
    
    def f:((List[User],Form[User]) => play.api.templates.HtmlFormat.Appendable) = (users,userForm) => apply(users,userForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Mar 05 18:37:27 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/users.scala.html
                    HASH: 11b91a116e5b7b8267d1432737b99fdb9b323390
                    MATRIX: 789->1|940->42|968->61|1004->63|1025->76|1064->78|1120->99|1133->104|1159->109|1222->137|1256->155|1296->157|1377->202|1390->206|1418->212|1480->238|1493->242|1520->247|1558->250|1611->294|1651->296|1725->339|1774->357|1856->404|1899->438|1939->440|1980->446|2030->474|2071->480|2120->507|2161->513|2218->548|2294->593|2327->595
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|38->10|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|44->16|46->18|51->23|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|56->28|57->29
                    -- GENERATED --
                */
            