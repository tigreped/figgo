package controllers;

import java.util.Date;

import models.CardTransaction;
import models.Role;
import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.login;

public class Application extends Controller {

	private static Form<User> userForm = Form.form(User.class);
	private static Form<Role> roleForm = Form.form(Role.class);
	private static Form<CardTransaction> cardTransactionForm = Form
			.form(CardTransaction.class);

	@Security.Authenticated(Secured.class)
	public static Result index() {
		//Form<CardTransaction> filledForm = cardTransactionForm.bindFromRequest();
		return ok(views.html.index.render(User.findByEmail(session().get("email")), cardTransactionForm));
	}

	@Security.Authenticated(Secured.class)
	public static Result users() {
		return ok(views.html.users.render(User.all(), userForm,
				User.findByEmail(session().get("email"))));
	}

	@Security.Authenticated(Secured.class)
	public static Result newUser() {
		Form<User> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.users.render(User.all(), filledForm,
					User.findByEmail(session().get("email"))));
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
	
	/**
	 * Add a role to a given user
	 * @param userId
	 * @return
	 */
	@Security.Authenticated(Secured.class)
	public static Result addRole(String userId) {
		Form<User> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), roleForm, filledForm, User.all(),
					User.findByEmail(session().get("email"))));
		} else {
			String roleName = filledForm.field("availableRoles").value();
			User.addRole(userId, roleName);
			return redirect(routes.Application.roles());
		}
	}
	
	/**
	 * Remove a role to a given user
	 * @param userId
	 * @return
	 */
	@Security.Authenticated(Secured.class)
	public static Result removeRole(String userId) {
		Form<User> filledForm = userForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), roleForm, filledForm, User.all(),
					User.findByEmail(session().get("email"))));
		} else {
			String roleName = filledForm.field("currentRoles").value();
			User.removeRole(userId, roleName);
			return redirect(routes.Application.roles());
		}
	}

	@Security.Authenticated(Secured.class)
	public static Result roles() {
		return ok(views.html.roles.render(Role.all(), roleForm, userForm, User.all(),
				User.findByEmail(session().get("email"))));
	}

	@Security.Authenticated(Secured.class)
	public static Result newRole() {
		Form<Role> filledForm = roleForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), filledForm, userForm, User.all(),
					User.findByEmail(session().get("email"))));
		} else {
			Role role = filledForm.get();
			// Check if the role already exists:
			if (!Role.exists(role))
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
			return badRequest(views.html.roles.render(Role.all(), filledForm, userForm, User.all(),
					User.findByEmail(session().get("email"))));
		} else {
			Role.addPermission(id, filledForm.field("permission").value());
			return redirect(routes.Application.roles());
		}
	}

	@Security.Authenticated(Secured.class)
	public static Result removePermission(String id) {
		Form<Role> filledForm = roleForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.roles.render(Role.all(), filledForm, userForm, User.all(),
					User.findByEmail(session().get("email"))));
		} else {
			Role.removePermission(id, filledForm.field("permission").value());
			return redirect(routes.Application.roles());
		}
	}

	@Security.Authenticated(Secured.class)
	public static Result newCardTransaction() {
		Form<CardTransaction> filledForm = cardTransactionForm
				.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(
					User.findByEmail(session().get("email")), filledForm));
		} else {
			// 1) Check if balance is enough:
			User from = User.findByEmail(session().get("email"));
			double balance = User.getCardBalance(from); 
			double amount = new Double(filledForm.field("amount").value());
			if (balance >= amount) {
				// 2) Check destiny validity:
				User to = User.findByEmail(filledForm.field("to").value());
				if (to != null) {
					// 3) Create operation:
					new CardTransaction(from.id, to.id, new Date(), amount);
					// Update balances:
					User.updateCardBalance(from);
					User.updateCardBalance(to);
				}
			}
			return redirect(routes.Application.users());
		}
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class),
				User.findByEmail(session().get("email"))));
	}

	@Security.Authenticated(Secured.class)
	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out!");
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
				return "Invalid user or password!\nPlease check your information and try again!";
			}
			return null;
		}
	}
}
