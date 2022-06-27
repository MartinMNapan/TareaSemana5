package pe.idat.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.edu.dto.UserDTORequest;
import pe.idat.edu.dto.UserDTOResponse;

import pe.idat.edu.security.JWTUtil;
import pe.idat.edu.security.UserDetailService;

@RestController
public class UserController {
	
	@Autowired
	private JWTUtil util;
	
	@Autowired
	private UserDetailService service;
	
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UserDTORequest request){
		
		UserDetails user = service.loadUserByUsername(request.getUser());
		return ResponseEntity.ok(new UserDTOResponse(util.generateToken(user.getUsername())));
	}

}
