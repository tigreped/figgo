package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {

  @Test
  public void createAndRetrieveUser() {
    new User(new Long(1), "foo@bar.com", "Bob", "pass").save();
    User bob = User.find.where().eq("email", "foo@bar.com").findUnique();
    assertNotNull(bob);
    assertEquals("Bob", bob.name);
  }
}
