package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {

    private static Form<Login> loginForm = Form.form(Login.class).bindFromRequest();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result login() {
      return ok(
        login.render(Form.form(Login.class))
      );
    }

    public static Result authenticate() {
      if (loginForm.hasErrors()) {
	return badRequest(login.render(loginForm));
      } else {
        session().clear();
	session("email", loginForm.get().email);
	return redirect(
	  routes.Application.index()
	);  
      }
    }

    public static String validate() {
      String email = loginForm.get().email;
      String pass =  loginForm.get().password;
      if (User.authenticate(loginForm.get().email, pass) ==  null)
        return "Invalid user or password";
      return null;
    }

    public static class Login {
      public String email;
      public String password;
    }
}
