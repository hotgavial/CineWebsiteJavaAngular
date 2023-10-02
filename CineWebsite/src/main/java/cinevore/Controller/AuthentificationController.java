package cinevore.Controller;

import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import cinevore.Entity.User;
import cinevore.Repository.UserRepository;
import cinevore.Service.JwtAuthService;

@RestController
public class AuthentificationController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private JwtAuthService authService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login (@RequestBody User user) {

		User optUser = userRepo.findByPseudo(user.getPseudo());
		if(optUser != null) {
			if(BCrypt.checkpw(user.getPassword(), optUser.getPassword())) {
				String token = authService.generateToken(user.getPseudo());
				return ResponseEntity.ok(token);
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with this username");
		}
		
	}
	
	@PostMapping("/authorization-check")
	public ResponseEntity<Void> checkAuthorization (@RequestBody Map<String, String> loginData) {
		
		String pseudo = loginData.get("pseudo");
        String token = loginData.get("token");
        
        if(authService.isTokenValid(token, pseudo)) {
        	return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
}
