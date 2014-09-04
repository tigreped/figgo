
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

"""),_display_(Seq[Any](/*3.2*/main("Login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
	<head>
		<title>Login</title>
		<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.53*/routes/*6.59*/.Assets.at("images/favicon.png"))),format.raw/*6.91*/("""">
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.64*/routes/*7.70*/.Assets.at("stylesheets/login.css"))),format.raw/*7.105*/("""">
	</head>
	<body>
		<header>
			<a href=""""),_display_(Seq[Any](/*11.14*/routes/*11.20*/.Application.index)),format.raw/*11.38*/("""" id="logo"><span>Home</span></a> |
			<a href=""""),_display_(Seq[Any](/*12.14*/routes/*12.20*/.Application.users)),format.raw/*12.38*/(""""><span>Users</span></a> |
			<a href=""""),_display_(Seq[Any](/*13.14*/routes/*13.20*/.Application.roles)),format.raw/*13.38*/(""""><span>Roles</span></a> |
			"""),_display_(Seq[Any](/*14.5*/if( user != null )/*14.23*/ {_display_(Seq[Any](format.raw/*14.25*/("""
				<a href=""""),_display_(Seq[Any](/*15.15*/routes/*15.21*/.Application.logout())),format.raw/*15.42*/(""""> Logout ("""),_display_(Seq[Any](/*15.54*/user/*15.58*/.name)),format.raw/*15.63*/(""")</a> 
			""")))})),format.raw/*16.5*/("""
		</header>
		<div class="loginbox">
		"""),_display_(Seq[Any](/*19.4*/helper/*19.10*/.form(routes.Application.authenticate)/*19.48*/ {_display_(Seq[Any](format.raw/*19.50*/("""
				</br>
				<h1>Sign in</h1>
				"""),_display_(Seq[Any](/*22.6*/if(form.hasGlobalErrors)/*22.30*/ {_display_(Seq[Any](format.raw/*22.32*/("""
					<p class="error"><b>"""),_display_(Seq[Any](/*23.27*/form/*23.31*/.globalError.message)),format.raw/*23.51*/("""</b></p>
				""")))})),format.raw/*24.6*/(""" 
				"""),_display_(Seq[Any](/*25.6*/if(flash.contains("success"))/*25.35*/ {_display_(Seq[Any](format.raw/*25.37*/("""
					<p class="success"><b>"""),_display_(Seq[Any](/*26.29*/flash/*26.34*/.get("success"))),format.raw/*26.49*/("""</b></p>
				""")))})),format.raw/*27.6*/("""
				<p>
					<input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*29.67*/form("email")/*29.80*/.value)),format.raw/*29.86*/("""">
				</p>
				<p>
					<input type="password" name="password" placeholder="Password">
				</p>
				<p>
					<button type="submit" style="float: right;">Login</button>
				</p>
		""")))})),format.raw/*37.4*/("""
		</div>
	</body>
""")))})),format.raw/*40.2*/("""

"""))}
    }
    
    def render(form:Form[Application.Login],user:User): play.api.templates.HtmlFormat.Appendable = apply(form,user)
    
    def f:((Form[Application.Login],User) => play.api.templates.HtmlFormat.Appendable) = (form,user) => apply(form,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Sep 04 12:51:08 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/login.scala.html
                    HASH: d4c74e1aa90daa08193aac177022f0fddebef5e9
                    MATRIX: 796->1|933->44|970->47|991->60|1030->62|1149->146|1163->152|1216->184|1317->250|1331->256|1388->291|1468->335|1483->341|1523->359|1608->408|1623->414|1663->432|1739->472|1754->478|1794->496|1860->527|1887->545|1927->547|1978->562|1993->568|2036->589|2084->601|2097->605|2124->610|2166->621|2242->662|2257->668|2304->706|2344->708|2416->745|2449->769|2489->771|2552->798|2565->802|2607->822|2652->836|2694->843|2732->872|2772->874|2837->903|2851->908|2888->923|2933->937|3044->1012|3066->1025|3094->1031|3306->1212|3357->1232
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|43->15|43->15|43->15|44->16|47->19|47->19|47->19|47->19|50->22|50->22|50->22|51->23|51->23|51->23|52->24|53->25|53->25|53->25|54->26|54->26|54->26|55->27|57->29|57->29|57->29|65->37|68->40
                    -- GENERATED --
                */
            