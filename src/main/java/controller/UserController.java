package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IUser;
import model.User;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private IUser repo;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		
	 System.out.println("Controller called");
	 return ResponseEntity.ok(repo.save(user));
		
		
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/login")
	public ResponseEntity<User> loginAdmin(@RequestBody User a){
		System.out.println(a.getEmail());
		System.out.println(a.getPassword());
		
		User admin1=repo.findByEmail(a.getEmail());
		if(admin1.getPassword().equals(a.getPassword())){
			return ResponseEntity.ok(admin1);
		}
		return (ResponseEntity<User>) ResponseEntity.internalServerError();
		
	}
}
