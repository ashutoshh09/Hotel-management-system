package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.IAdmin;
import dao.IGuest;
import dao.IService;
import dao.IUser;
import model.Admin;
import model.Guest;
import model.Service;
import model.User;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IGuest guest;
	@Autowired
	IUser user;
	@Autowired
	IAdmin admin;
	@Autowired
	IService service;
	
	

	@SuppressWarnings("unchecked")
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin a){
		System.out.println(a.getUsername());
		System.out.println(a.getPassword());
		
		Admin admin1=admin.findByUsername(a.getUsername());
		if(admin1.getPassword().equals(a.getPassword())){
			return ResponseEntity.ok(admin1);
		}
		return (ResponseEntity<Admin>) ResponseEntity.internalServerError();
		
	}
	
	@GetMapping("login/{username}/{password}")
	public boolean adminlogin(@PathVariable("username")String username,@PathVariable("password")String password) {
		
		List<Admin> list=admin.findAll();
		for(Admin admin:list) {
			if(admin.getUsername().equals(username)&& admin.getPassword().equals(password))
				{return true;}
		}
		return false;
	}
	
	@GetMapping("/")
	public  String welcome() {
		return "Welcome to AdminController";
	}
	
	@GetMapping("/allguest")
	public List<Guest> allguest(){
		return guest.findAll();
	}
	@PostMapping("/addguest")
	public String booked(@RequestBody Guest g) {
		guest.save(g);
		return "Guest Booked";
	}
	
	@PostMapping("/addservice")
	public ResponseEntity<Service>  Serviceadd(@RequestBody Service g) {
		Service newEmployee =service.save(g);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/allservice")
	public List<Service> allService(){
		return service.findAll();
	}
	
	
	@GetMapping("/alluser")
	public List<User> alluser() {
		return user.findAll();
	}
	
//	@PostMapping("/adduser")
//	public String adduser(@RequestBody User g) {
//		user.save(g);
//		return "user registered";}
	
	 @GetMapping("/finduser/{id}")
	    public Optional<User> getUserById (@PathVariable("id") int id) {
	        
	        return user.findById(id);
	    }
	 
	 @GetMapping("/findguest/{id}")
	 public Optional<Guest> getGuestById (@PathVariable("id") int id) {
	        
	        return guest.findById(id);
	    }
	 
	 @GetMapping("/findusername/{id}")
	 public  ResponseEntity<User>getUserByString (@PathVariable("id") String id) {
	        User g=user.findByEmail(id);
	        return ResponseEntity.ok(g);
	    }
	 
	 @GetMapping("/findguestname/{id}")
	 public  ResponseEntity<Guest>getGuestByString (@PathVariable("id") String id) {
	        Guest g=guest.findByName(id);
	        return ResponseEntity.ok(g);
	    }
	 
	 @PutMapping("/guest/{id}")
	    public ResponseEntity<Guest> updateguest(@RequestBody Guest employee,@PathVariable int id) {
	        Guest g = guest.findById(id).orElseThrow();
	        
	        g.setName(employee.getName());
	        g.setCheck_in(employee.getCheck_in());
	        g.setCheck_out(employee.getCheck_out());
	        g.setRoom(employee.getRoom());
	        g.setNosguest(employee.getNosguest());
	        
	        
	        Guest Updatedguest=guest.save(g);
	        return ResponseEntity.ok(Updatedguest);
	    }
	 
	 @PutMapping("/updatepassword/{admin}")
	    public ResponseEntity<Admin> updatePassword(@RequestBody Admin employee,@PathVariable("admin")String previousp) {
	        
		 Admin g = admin.findById(previousp).orElseThrow();
	        
	        g.setPassword(employee.getPassword());
	       
	        
	        
	        Admin Updatedguest=admin.save(g);
	        return ResponseEntity.ok(Updatedguest);
	    }

	 

	    @PostMapping("/adduser")
	    public ResponseEntity<User> addUser(@RequestBody User employee) {
	        User newEmployee = user.save(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }

//	    @PutMapping("/update")
//	    public ResponseEntity<User> updateEmployee(@RequestBody User employee) {
//	        User updateEmployee = user.save(employee);
//	        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
//	    }
	    @PutMapping("/updateuser/{id}")
		public Optional<User> updateService(@PathVariable int id, @RequestBody User ser) {
			user.findById(id).map(update -> {
				update.setId(ser.getId());
				update.setName(ser.getName());
				update.setEmail(ser.getEmail());
				update.setMobile(ser.getMobile());
				update.setAddress(ser.getAddress());
				update.setPassword(ser.getPassword());
				
				return user.save(update);});
			
		
			return user.findById(id);

	}
	    
	    @PutMapping("/updateservice/{id}")
	  		public Optional<Service> updateServices(@PathVariable int id, @RequestBody Service ser) {
	  			service.findById(id).map(update -> {
	  				update.setId(ser.getId());
	  				update.setServicename(ser.getServicename());
	  				update.setServicedesc(ser.getServicedesc());
	  				update.setContact(ser.getContact());
	  				
	  				
	  				return service.save(update);});
	  			
	  		
	  			return service.findById(id);

	  	}
	    
	    @DeleteMapping("/deleteuser/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
	        user.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/deleteguest/{id}")
	    public ResponseEntity<?> deleteGuest(@PathVariable("id") int id) {
	        guest.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/deleteservice/{id}")
	    public ResponseEntity<?> deleteService(@PathVariable("id") int id) {
	        service.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	
	
}
