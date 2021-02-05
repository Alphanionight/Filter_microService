package org.mql.ws.miniproject.resources;

import java.security.MessageDigest;
import java.util.List;
import java.util.Vector;

import org.mql.ws.business.HexConverter;
import org.mql.ws.business.Session;
import org.mql.ws.dao.CourseDao;
import org.mql.ws.dao.CourseDaoImpl;
import org.mql.ws.dao.UserDaoImpl;
import org.mql.ws.models.Course;
import org.mql.ws.models.CourseToken;
import org.mql.ws.models.ResponseMessage;
import org.mql.ws.models.User;
import org.mql.ws.models.UserToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class CourseResource {

	CourseDao courseDao = CourseDaoImpl.getInstance();
	UserDaoImpl userDao = UserDaoImpl.getInstance();


	@RequestMapping("auth")
	@PostMapping

	public ResponseMessage authenticate(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		boolean result = userDao.validateAuthentication(username, password);
		String message = "Username or Password incorrect!";
		if (result) {
			if (!Session.getUsers().containsKey(username)) {
				MessageDigest md;
				try {
					int rand = (int) (Math.random()*999999 + 1);
					String md5 = username + ":" + password + ":" + rand;
					md = MessageDigest.getInstance("MD5");
					md.update(md5.getBytes());
					byte[] digest = md.digest();
					String token = HexConverter.hex(digest);
					System.out.println(token);
					Session.addUser(username, token);
					message = "Username and Password are correct :D";
					return new ResponseMessage(message, token);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return new ResponseMessage(message, Session.getToken(username));
		}
		return null;
	}

	@RequestMapping("/filter")
	@PostMapping

	public ResponseMessage filter(@RequestBody CourseToken ct){
		String message = null;
		String token = ct.getToken();
		Course course = ct.getCourse();
		if (Session.validToken(token)) {
			List<Course> courses = new Vector<Course>();
			courses = courseDao.getMatches(course);
			message = "Authenticated Successfully";
			return new ResponseMessage(message, courses);
		}
		message = "Authentication Failed";
		return new ResponseMessage(message, null);
	}

	@RequestMapping("/end")
	@GetMapping

	public ResponseMessage disconnect(@RequestBody UserToken ut) {
		String token = ut.getToken();
		String username = ut.getUser();
		String message = "Invalid Token!";
		if (Session.validToken(token)) {
			Session.removeUser(username);
			message = "Session has been closed successfully :D";
			return new ResponseMessage(message, true);
		}
		return new ResponseMessage(message, false);
	}
}
