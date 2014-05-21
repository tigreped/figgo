package controllers;

import models.Role;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.index;
import views.html.login;

public class Application extends Controller {

	private static Form<User> userForm = Form.form(User.class);
	private static Form<Role> roleForm = Form.form(Role.class);

	@Security.Authenticated(Secured.class)
	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	@Security.Authenticated(Secured.class)
	public static Result users() {
		return ok(views.html.users.render(User.all(), userForm, User.findByEmail(session().get("email"))));
	}
	
	@Security.Authenticated(Secured.class)
	public static Result newUser() {
		Form<User> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.users.render(User.all(), filledForm, User.findByEmail(session().get("email"))));
		} else {
			User.create(filledForm.get());
			return redirect(routes.Application.users());
		}
	}

	@Security.Authenticated(Secured.class)
	public static Result deleteUser(String id) {
		User.delete(id);
		return redirect(routes.Application.users());
	}

	@Security.Authenticated(Secured.class)
	public static Result roles() {
		return ok(views.html.roles.render(Role.all(), roleForm, User.findByEmail(session().get("email"))));
	}

	@Security.Authenticated(Secured.class)
	public static Result newRole() {
		Form<Role> filledForm = roleForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), filledForm, User.findByEmail(session().get("email"))));
		} else {
			Role.create(filledForm.get());
			return redirect(routes.Application.roles());
		}
	}
	
	@Security.Authenticated(Secured.class)
	public static Result deleteRole(String id) {
		Role.delete(id);
		return redirect(routes.Application.roles());
	}
	
	@Security.Authenticated(Secured.class)
	public static Result addPermission(String id) {
		Form<Role> filledForm = roleForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), filledForm, User.findByEmail(session().get("email"))));
		} else {
			Role.addPermission(id, filledForm.field("permission").value());
			return redirect(routes.Application.roles());
		}
	}
	
	@Security.Authenticated(Secured.class)
	public static Result removePermission(String id) {
		Form<Role> filledForm = roleForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), filledForm, User.findByEmail(session().get("email"))));
		} else {
			Role.removePermission(id, filledForm.field("permission").value());
			return redirect(routes.Application.roles());
		}
	}
	
	@Security.Authenticated(Secured.class)
	public static Result login() {
		return ok(
			login.render(
				Form.form(Login.class), User.findByEmail(session().get("email"))
			)
		);
	}

	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Application.login());
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm, null));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (User.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}
	}
}
