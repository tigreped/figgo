package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

public class Application extends Controller {

  private static Form<User> userForm = Form.form(User.class);

  public static Result index() {
    return ok(
      index.render("Your new application is ready.")
    );
  }

  public static Result users() {
    return ok(
      views.html.users.render(User.all(), userForm)
    );
  }

  public static Result newUser() {
    Form<User> filledForm = userForm.bindFromRequest();
    if (filledForm.hasErrors()) {
      return badRequest(
        views.html.users.render(User.all(), filledForm)
      );
    } else {
      User.create(filledForm.get());
      return redirect(
        routes.Application.users()
      );
    }
  }

  public static Result deleteUser(Long id) {
    User.delete(id);
    return redirect(
      routes.Application.users()
    );
  }

  public static Result login() {
    return ok(
      login.render(Form.form(Login.class))
    );
  }

  public static Result authenticate() {
    Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
    if (loginForm.hasErrors()) {
      return badRequest(
        login.render(loginForm)
      );
    } else {
      session().clear();
      session("email", loginForm.get().email);
      return redirect(
        routes.Application.index()
      );  
    }
  }

  public static class Login {   
    
    public String email;
    public String password;
    
    public String validate() {
      if (User.authenticate(email, password) ==  null) {
        return "Invalid user or password";
      }
      return null;
    }
  }
}
