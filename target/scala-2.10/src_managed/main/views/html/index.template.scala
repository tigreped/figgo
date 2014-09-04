
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[User,Form[CardTransaction],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: User, cardTransactionForm: Form[CardTransaction]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.58*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Index")/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""
	<header>
		<a href=""""),_display_(Seq[Any](/*7.13*/routes/*7.19*/.Application.index)),format.raw/*7.37*/("""" id="logo"><span>Home</span></a> |
		<a href=""""),_display_(Seq[Any](/*8.13*/routes/*8.19*/.Application.users)),format.raw/*8.37*/(""""><span>Users</span></a> |
		<a href=""""),_display_(Seq[Any](/*9.13*/routes/*9.19*/.Application.roles)),format.raw/*9.37*/(""""><span>Roles</span></a> |
		"""),_display_(Seq[Any](/*10.4*/if( user != null )/*10.22*/ {_display_(Seq[Any](format.raw/*10.24*/("""
			<a href=""""),_display_(Seq[Any](/*11.14*/routes/*11.20*/.Application.logout())),format.raw/*11.41*/(""""> Logout ("""),_display_(Seq[Any](/*11.53*/user/*11.57*/.name)),format.raw/*11.62*/(""")</a> 
		""")))})),format.raw/*12.4*/(""" 
	</header>
	<br/>
	<h2>
		Saldo atual: 
		"""),_display_(Seq[Any](/*17.4*/if(user.cardBalance > 0)/*17.28*/ {_display_(Seq[Any](format.raw/*17.30*/("""
			<positive>"""),_display_(Seq[Any](/*18.15*/user/*18.19*/.cardBalance)),format.raw/*18.31*/("""</positive>
		""")))})),format.raw/*19.4*/("""  
		"""),_display_(Seq[Any](/*20.4*/if(user.cardBalance < 0)/*20.28*/ {_display_(Seq[Any](format.raw/*20.30*/("""
		  	<negative>"""),_display_(Seq[Any](/*21.17*/user/*21.21*/.cardBalance)),format.raw/*21.33*/("""</negative>
		""")))})),format.raw/*22.4*/(""" 
		"""),_display_(Seq[Any](/*23.4*/if(user.cardBalance == 0)/*23.29*/ {_display_(Seq[Any](format.raw/*23.31*/("""
			"""),_display_(Seq[Any](/*24.5*/user/*24.9*/.cardBalance)),format.raw/*24.21*/("""
		""")))})),format.raw/*25.4*/("""
	</h2>

	"""),_display_(Seq[Any](/*28.3*/if(user.cardBalance > 0)/*28.27*/ {_display_(Seq[Any](format.raw/*28.29*/("""
		<h2>Realizar transferência:</h2>
		"""),_display_(Seq[Any](/*30.4*/form(routes.Application.newCardTransaction())/*30.49*/ {_display_(Seq[Any](format.raw/*30.51*/("""
			"""),_display_(Seq[Any](/*31.5*/inputText(cardTransactionForm("amount")))),format.raw/*31.45*/("""
			"""),_display_(Seq[Any](/*32.5*/inputText(cardTransactionForm("to")))),format.raw/*32.41*/("""
			<input type="submit" value="transfer">
		""")))})),format.raw/*34.4*/("""

	""")))})),format.raw/*36.3*/("""
""")))})),format.raw/*37.2*/("""	"""))}
    }
    
    def render(user:User,cardTransactionForm:Form[CardTransaction]): play.api.templates.HtmlFormat.Appendable = apply(user,cardTransactionForm)
    
    def f:((User,Form[CardTransaction]) => play.api.templates.HtmlFormat.Appendable) = (user,cardTransactionForm) => apply(user,cardTransactionForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Sep 04 12:35:07 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/index.scala.html
                    HASH: 15b67e821f3c71906fc7a3b6430b756cf7dc6262
                    MATRIX: 794->1|960->57|988->76|1024->78|1045->91|1084->93|1142->116|1156->122|1195->140|1278->188|1292->194|1331->212|1405->251|1419->257|1458->275|1523->305|1550->323|1590->325|1640->339|1655->345|1698->366|1746->378|1759->382|1786->387|1827->397|1907->442|1940->466|1980->468|2031->483|2044->487|2078->499|2124->514|2165->520|2198->544|2238->546|2291->563|2304->567|2338->579|2384->594|2424->599|2458->624|2498->626|2538->631|2550->635|2584->647|2619->651|2665->662|2698->686|2738->688|2812->727|2866->772|2906->774|2946->779|3008->819|3048->824|3106->860|3183->906|3218->910|3251->912
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|39->11|39->11|40->12|45->17|45->17|45->17|46->18|46->18|46->18|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|56->28|56->28|56->28|58->30|58->30|58->30|59->31|59->31|60->32|60->32|62->34|64->36|65->37
                    -- GENERATED --
                */
            