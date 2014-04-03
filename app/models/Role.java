package models;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

//import com.mongodb.DBCursor;

public class Role {

	@Id
	@ObjectId
	public String id;

	public String name;
	public ArrayList<String> permissions;

	private static JacksonDBCollection<Role, String> collection = MongoDB
			.getCollection("roles", Role.class, String.class);

	public static List<Role> all() {
		return getCollection().find().toArray();
	}

	public static void create(Role role) {
		getCollection().save(role);
	}

	public static void delete(String id) {
		Role role = getCollection().findOneById(id);
		if (role != null)
			getCollection().remove(role);
	}

	public static Role findByName(String name) {
		DBCursor<Role> cursor = getCollection().find().is("name", name);
		if (cursor.hasNext()) {
			Role role = cursor.next();
			return role;
		}
		return null;
	}
	
	public static JacksonDBCollection<Role, String> getCollection() {
		return collection;
	}
		
	public ArrayList<String> getPermissions() {
		return this.permissions;
	}
	
	/**
	 * Retrieve a list with all permissions associated with the role of name as the parameter
	 * @param name
	 * @return
	 */
	public static ArrayList<String> getRolePermissions(String name) {
		DBCursor<Role> cursor = getCollection().find().is("name", name);
		if (cursor.hasNext()) {
			Role role = cursor.next();
			return role.getPermissions();
		}
		return null;
	}
	
	/**
	 * Add new persmission to a role 
	 * @param role
	 * @param permission
	 */
	public static void addPermission(Role role, String permission) {
		if (!role.equals(null)) {
			// Has no permissions, create ArrayList and add
			if (role.permissions.equals(null)) {
				role.permissions = new ArrayList<String>();
				role.permissions.add(permission);
				getCollection().save(role);
			}
			// Already has some permissions
			else {
				// Check that the permission is not listed yet
				if (!role.permissions.contains(permission)) {
					role.permissions.add(permission);
					getCollection().save(role);
				}
			}			
		}
	}
	
	public static void removePermission(Role role, String permission) {
		if (!role.equals(null)) {
			// If it finds such a role in the user roles
			if (role.permissions.indexOf(permission) != -1) {
				// remove it from its role list
				role.permissions.remove(permission);
				// update object on MongoDB
				getCollection().save(role);
			}
		}
	}
}
