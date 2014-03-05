package models;

import java.util.*;

import play.db.ebean.*;
import com.avaje.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class User extends Model {

  @Id
  public Long id;
  
  @Required
  public String email;
  public String name;
  @Required
  public String password;

  // Class constructor
  public User (Long id, String email, String name, String password) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

  public static List<User> all() {
    return find.all();
  }

  public static void create(User user) {
    user.save();
  }

  public static void delete(Long id) {
    find.ref(id).delete();
  }

  public static User authenticate(String email, String password) {
    return find.where().eq("email", email).eq("password", password).findUnique();
  }
}
