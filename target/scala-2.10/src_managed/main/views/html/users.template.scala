
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
object users extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[User],Form[User],User,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(users: List[User], userForm: Form[User], user: User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Users")/*5.15*/ {_display_(Seq[Any](format.raw/*5.17*/("""

	<header>
		<a href=""""),_display_(Seq[Any](/*8.13*/routes/*8.19*/.Application.index)),format.raw/*8.37*/("""" id="logo"><span>Home</span></a> |
		<a href=""""),_display_(Seq[Any](/*9.13*/routes/*9.19*/.Application.users)),format.raw/*9.37*/(""""><span>Users</span></a> |
		<a href=""""),_display_(Seq[Any](/*10.13*/routes/*10.19*/.Application.roles)),format.raw/*10.37*/(""""><span>Roles</span></a> |
		"""),_display_(Seq[Any](/*11.4*/if( user != null )/*11.22*/ {_display_(Seq[Any](format.raw/*11.24*/("""
			<a href=""""),_display_(Seq[Any](/*12.14*/routes/*12.20*/.Application.logout())),format.raw/*12.41*/(""""> Logout ("""),_display_(Seq[Any](/*12.53*/user/*12.57*/.name)),format.raw/*12.62*/(""")</a> 
		""")))})),format.raw/*13.4*/("""
	</header>
	
	<h2> Add a new user: </h2>
  	"""),_display_(Seq[Any](/*17.5*/form(routes.Application.newUser())/*17.39*/ {_display_(Seq[Any](format.raw/*17.41*/("""
		"""),_display_(Seq[Any](/*18.4*/inputText(userForm("email")))),format.raw/*18.32*/("""
		"""),_display_(Seq[Any](/*19.4*/inputText(userForm("name")))),format.raw/*19.31*/("""
		"""),_display_(Seq[Any](/*20.4*/inputPassword(userForm("password")))),format.raw/*20.39*/("""
		<input type="submit" value="create">
	""")))})),format.raw/*22.3*/("""
	
	<h2>User list ["""),_display_(Seq[Any](/*24.18*/users/*24.23*/.size)),format.raw/*24.28*/(""" user(s)]</h2>
	<div class="container">
		<div class="heading">
	  		<div class="col">Email:</div>
	  		<div class="col">Name:</div>
	  		<div class="col">Balance:</div>
	  		<div class="col">Timestamp:</div>
	  		<div class="col">Roles:</div>
	  		<div class="col">Delete:</div>
		</div>
		"""),_display_(Seq[Any](/*34.4*/for(user <- users) yield /*34.22*/ {_display_(Seq[Any](format.raw/*34.24*/("""
			<div class="table-row">
				<div class="col">"""),_display_(Seq[Any](/*36.23*/user/*36.27*/.email)),format.raw/*36.33*/("""</div>
				<div class="col">"""),_display_(Seq[Any](/*37.23*/user/*37.27*/.name)),format.raw/*37.32*/("""</div>
				<div class="col">
					"""),_display_(Seq[Any](/*39.7*/if(user.cardBalance > 0)/*39.31*/ {_display_(Seq[Any](format.raw/*39.33*/("""
						  	<positive>"""),_display_(Seq[Any](/*40.21*/user/*40.25*/.cardBalance)),format.raw/*40.37*/("""</positive>
						""")))})),format.raw/*41.8*/("""  
					"""),_display_(Seq[Any](/*42.7*/if(user.cardBalance < 0)/*42.31*/ {_display_(Seq[Any](format.raw/*42.33*/("""
						  	<negative>"""),_display_(Seq[Any](/*43.21*/user/*43.25*/.cardBalance)),format.raw/*43.37*/("""</negative>
						""")))})),format.raw/*44.8*/(""" 
					"""),_display_(Seq[Any](/*45.7*/if(user.cardBalance == 0)/*45.32*/{_display_(Seq[Any](format.raw/*45.33*/("""
							"""),_display_(Seq[Any](/*46.9*/user/*46.13*/.cardBalance)),format.raw/*46.25*/("""
						""")))})),format.raw/*47.8*/("""
				</div>
				<div class="col">"""),_display_(Seq[Any](/*49.23*/user/*49.27*/.cardBalanceTimestamp)),format.raw/*49.48*/("""</div>
				<div class="col">"""),_display_(Seq[Any](/*50.23*/user/*50.27*/.roles)),format.raw/*50.33*/("""</div>
				<div class="col">
		  			"""),_display_(Seq[Any](/*52.9*/form(routes.Application.deleteUser(user.id))/*52.53*/ {_display_(Seq[Any](format.raw/*52.55*/("""
						<input type="submit" value="delete">
					""")))})),format.raw/*54.7*/("""
				</div>
			</div>	
		""")))})),format.raw/*57.4*/("""
	</div>
""")))})))}
    }
    
    def render(users:List[User],userForm:Form[User],user:User): play.api.templates.HtmlFormat.Appendable = apply(users,userForm,user)
    
    def f:((List[User],Form[User],User) => play.api.templates.HtmlFormat.Appendable) = (users,userForm,user) => apply(users,userForm,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jun 08 21:50:53 BRT 2014
                    SOURCE: /home/pedro/workspace/playtestdrive/app/views/users.scala.html
                    HASH: 2ce0f39af6d84d426dc3e5aa688d6257e8e54712
                    MATRIX: 794->1|957->54|985->73|1021->75|1042->88|1081->90|1140->114|1154->120|1193->138|1276->186|1290->192|1329->210|1404->249|1419->255|1459->273|1524->303|1551->321|1591->323|1641->337|1656->343|1699->364|1747->376|1760->380|1787->385|1828->395|1909->441|1952->475|1992->477|2031->481|2081->509|2120->513|2169->540|2208->544|2265->579|2338->621|2394->641|2408->646|2435->651|2762->943|2796->961|2836->963|2922->1013|2935->1017|2963->1023|3028->1052|3041->1056|3068->1061|3138->1096|3171->1120|3211->1122|3268->1143|3281->1147|3315->1159|3365->1178|3409->1187|3442->1211|3482->1213|3539->1234|3552->1238|3586->1250|3636->1269|3679->1277|3713->1302|3752->1303|3796->1312|3809->1316|3843->1328|3882->1336|3952->1370|3965->1374|4008->1395|4073->1424|4086->1428|4114->1434|4186->1471|4239->1515|4279->1517|4360->1567|4417->1593
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|41->13|45->17|45->17|45->17|46->18|46->18|47->19|47->19|48->20|48->20|50->22|52->24|52->24|52->24|62->34|62->34|62->34|64->36|64->36|64->36|65->37|65->37|65->37|67->39|67->39|67->39|68->40|68->40|68->40|69->41|70->42|70->42|70->42|71->43|71->43|71->43|72->44|73->45|73->45|73->45|74->46|74->46|74->46|75->47|77->49|77->49|77->49|78->50|78->50|78->50|80->52|80->52|80->52|82->54|85->57
                    -- GENERATED --
                */
            