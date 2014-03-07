package models;

import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

//import com.mongodb.DBCursor;

public class User {

	@Id
	@ObjectId
	public String id;

	public String email;
	public String name;
	public String password;

	private static JacksonDBCollection<User, String> collection = MongoDB
			.getCollection("users", User.class, String.class);

	public static List<User> all() {
		return getCollection().find().toArray();
	}

	public static void create(User user) {
		getCollection().save(user);
	}

	public static void delete(String id) {
		User user = getCollection().findOneById(id);
		if (user != null)
			getCollection().remove(user);
	}

	public static User authenticate(String email, String password) {
		DBCursor cursor = getCollection().find().is("email", email)
				.is("password", password);
		if (cursor.hasNext()) {
			User user = (User) cursor.next();
			System.out.println("User.authenticate() - email:" + user.email);
			return user;
		}
		return null;
	}

	public static JacksonDBCollection<User, String> getCollection() {
		return collection;
	}
}
