import java.util.List;

import core.User;
import dao.UserDAO;

public class demo {

	public static void main(String[] args) throws Exception {
		UserDAO dao = new UserDAO();
		List<User> users = null;
		users = dao.searchUsers("admin1");
		System.out.println(users);
		System.out.println(users.get(0).getFirstName());
		System.out.println(users.get(0).getPassword());

	}

}
