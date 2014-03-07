
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
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*5.51*/routes/*5.57*/.Assets.at("images/favicon.png"))),format.raw/*5.89*/("""">
<link rel="stylesheet" type="text/css" media="screen"
	href=""""),_display_(Seq[Any](/*7.9*/routes/*7.15*/.Assets.at("stylesheets/login.css"))),format.raw/*7.50*/("""">
</head>
<body>
	<header>
		<a href=""""),_display_(Seq[Any](/*11.13*/routes/*11.19*/.Application.index)),format.raw/*11.37*/("""" id="logo"><span>Home</span></a> |  
		<a href=""""),_display_(Seq[Any](/*12.13*/routes/*12.19*/.Application.users)),format.raw/*12.37*/(""""><span>Users</span></a> | 
    	<a href=""""),_display_(Seq[Any](/*13.16*/routes/*13.22*/.Application.logout())),format.raw/*13.43*/("""">Logout</a>
	</header>
	"""),_display_(Seq[Any](/*15.3*/helper/*15.9*/.form(routes.Application.authenticate)/*15.47*/ {_display_(Seq[Any](format.raw/*15.49*/("""
	</br>
	<h1>Sign in</h1>
	"""),_display_(Seq[Any](/*18.3*/if(form.hasGlobalErrors)/*18.27*/ {_display_(Seq[Any](format.raw/*18.29*/("""
	<p class="error">"""),_display_(Seq[Any](/*19.20*/form/*19.24*/.globalError.message)),format.raw/*19.44*/("""</p>
	""")))})),format.raw/*20.3*/("""
	"""),_display_(Seq[Any](/*21.3*/if(flash.contains("success"))/*21.32*/ {_display_(Seq[Any](format.raw/*21.34*/("""
    <p class="success">
        """),_display_(Seq[Any](/*23.10*/flash/*23.15*/.get("success"))),format.raw/*23.30*/("""
    </p>
	""")))})),format.raw/*25.3*/("""
	<p>
		<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*27.64*/form("email")/*27.77*/.value)),format.raw/*27.83*/("""">
	</p>
	<p>
		<input type="password" name="password" placeholder="Password">
	</p>
	<p>
		<button type="submit">Login</button>
	</p>
	""")))})),format.raw/*35.3*/("""
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
                    DATE: Fri Mar 07 13:16:09 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/login.scala.html
                    HASH: 88b45f72a718acc59fc180d5d976e89f1a59b3c8
                    MATRIX: 791->1|916->32|1037->118|1051->124|1104->156|1203->221|1217->227|1273->262|1349->302|1364->308|1404->326|1490->376|1505->382|1545->400|1624->443|1639->449|1682->470|1743->496|1757->502|1804->540|1844->542|1907->570|1940->594|1980->596|2036->616|2049->620|2091->640|2129->647|2167->650|2205->679|2245->681|2315->715|2329->720|2366->735|2409->747|2514->816|2536->829|2564->835|2732->972
                    LINES: 26->1|29->1|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|49->21|49->21|49->21|51->23|51->23|51->23|53->25|55->27|55->27|55->27|63->35
                    -- GENERATED --
                */
            