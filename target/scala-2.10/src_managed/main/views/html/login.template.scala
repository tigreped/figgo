
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Application.Login],User,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login], user: User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""
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
		"""),_display_(Seq[Any](/*13.4*/if( user != null )/*13.22*/ {_display_(Seq[Any](format.raw/*13.24*/("""
		<a href=""""),_display_(Seq[Any](/*14.13*/routes/*14.19*/.Application.logout())),format.raw/*14.40*/(""""> Logout ("""),_display_(Seq[Any](/*14.52*/user/*14.56*/.name)),format.raw/*14.61*/(""")</a> 
		""")))})),format.raw/*15.4*/("""
	</header>
	"""),_display_(Seq[Any](/*17.3*/helper/*17.9*/.form(routes.Application.authenticate)/*17.47*/ {_display_(Seq[Any](format.raw/*17.49*/("""
	</br>
	<h1>Sign in</h1>
	"""),_display_(Seq[Any](/*20.3*/if(form.hasGlobalErrors)/*20.27*/ {_display_(Seq[Any](format.raw/*20.29*/("""
	<p class="error">"""),_display_(Seq[Any](/*21.20*/form/*21.24*/.globalError.message)),format.raw/*21.44*/("""</p>
	""")))})),format.raw/*22.3*/(""" """),_display_(Seq[Any](/*22.5*/if(flash.contains("success"))/*22.34*/ {_display_(Seq[Any](format.raw/*22.36*/("""
	<p class="success">"""),_display_(Seq[Any](/*23.22*/flash/*23.27*/.get("success"))),format.raw/*23.42*/("""</p>
	""")))})),format.raw/*24.3*/("""
	<p>
		<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*26.64*/form("email")/*26.77*/.value)),format.raw/*26.83*/("""">
	</p>
	<p>
		<input type="password" name="password" placeholder="Password">
	</p>
	<p>
		<button type="submit">Login</button>
	</p>
	""")))})),format.raw/*34.3*/("""
</body>
</html>


"""))}
    }
    
    def render(form:Form[Application.Login],user:User): play.api.templates.HtmlFormat.Appendable = apply(form,user)
    
    def f:((Form[Application.Login],User) => play.api.templates.HtmlFormat.Appendable) = (form,user) => apply(form,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Mar 07 14:06:54 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/login.scala.html
                    HASH: 0073634ed90f8ec1c7e84d41fdd2024d4043ea92
                    MATRIX: 796->1|933->44|1054->130|1068->136|1121->168|1220->233|1234->239|1290->274|1366->314|1381->320|1421->338|1505->386|1520->392|1560->410|1626->441|1653->459|1693->461|1742->474|1757->480|1800->501|1848->513|1861->517|1888->522|1929->532|1978->546|1992->552|2039->590|2079->592|2142->620|2175->644|2215->646|2271->666|2284->670|2326->690|2364->697|2401->699|2439->728|2479->730|2537->752|2551->757|2588->772|2626->779|2731->848|2753->861|2781->867|2949->1004
                    LINES: 26->1|29->1|33->5|33->5|33->5|35->7|35->7|35->7|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|42->14|42->14|42->14|43->15|45->17|45->17|45->17|45->17|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|54->26|54->26|54->26|62->34
                    -- GENERATED --
                */
            