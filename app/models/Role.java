package models;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;

public class Role {

	@Id
	@ObjectId
	public String id;

	public String name;
	public ArrayList<String> permissions = new ArrayList<String>();

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
		return Collections.getRoleCollection();
	}

	public ArrayList<String> getPermissions() {
		return this.permissions;
	}

	/**
	 * Retrieve a list with all permissions associated with the role of name as
	 * the parameter
	 * 
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
	 * 
	 * @param role
	 * @param permission
	 */
	public static void addPermission(String id, String permission) {
		Role role = getCollection().findOneById(id);
		if (!role.equals(null)) {
			System.out.println("*** id: " + id + " permission: " + permission
					+ "***");
			System.out.println("98074829743    " + role.id);
			// Has no permissions, create ArrayList and add
			if (role.permissions.size() != 0) {
				System.out.println("*** No permissions! ***");
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
		System.out.println("*** Null role ***");
	}

	public static void removePermission(String id, String permission) {
		Role role = getCollection().findOneById(id);
		// Role exists
		if (!role.equals(null)) {
			// Role has permissions
			if (role.permissions.size() != 0) {
				// Finds such a role in the user roles
				if (role.permissions.indexOf(permission) != -1) {
					// remove it from its role list
					role.permissions.remove(permission);
					// update object on MongoDB
					getCollection().save(role);
				}
			}
		}
	}
}
