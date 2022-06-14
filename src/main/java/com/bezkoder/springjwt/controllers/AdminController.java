package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.Vacaciones;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.TablaRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.VacacionesRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST,
		RequestMethod.DELETE })
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	VacacionesRepository vacacionesRepository;

	@Autowired
	TablaRepository tablaRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	JwtUtils jwtUtils;

//	  @Autowired
//	  Vacaciones vacas;

	// PreAuthorize ES PARA DAR PRIVILEGIOS

//	  @PreAuthorize("hasRole('MODERATOR')")
	@GetMapping("/lista-empleados")
//	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<User> listaEmpleados() {
		System.out.println("PUTA LISTA DE EMPLEADOS DE MIERDA");
		return userDetailsService.findAll();
	}

	@GetMapping("/hola")
//	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	  @PreAuthorize("hasRole('MODERATOR')")
	public String hola() {
		return "HOLA";
	}

	@PostMapping("/vacaciones")
//	@GetMapping("/vacaciones")
	public ResponseEntity<?> registerUser(@RequestParam("id") Long id, @RequestBody Vacaciones vacaciones) {
//	public ResponseEntity<?> registerUser() { 
		System.out.println("VACACIONES");

		Long a = (long) 1;
//		Optional<User> user = userRepository.findById(a);
		User user = userRepository.findPorId(id);
//		User user = new User("A","A","A");
//		Vacaciones vaca = new Vacaciones();
//		vaca.setEstado("A");
//		vaca.setEstado_Adm("A");
//		vaca.setEstado_Resp("A");
//		vaca.setFecha_fin("2021-12-12");
//		vaca.setFecha_ini("2021-12-12");
//		vaca.setId(1);
//		vaca.setMotivo_cambio(1);
//		vaca.setNumero_dias(1);
//		vaca.setUser(user);
////		vaca.setId_key_empleado(1);
//		userRepository.save(vacaciones);
		vacaciones.setUser(user);
		vacacionesRepository.save(vacaciones);
		
		System.out.println("VACACIONES");
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@GetMapping("/lista-vacaciones")
//	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	  @PreAuthorize("hasRole('MODERATOR')")
	public User listaVacaciones() {
		return userRepository.findPorIdVacaciones((long) 2);
//		return "HOLA";
	}
	
	@GetMapping("/empleado")
//	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	  @PreAuthorize("hasRole('MODERATOR')")
	public User getEmpleado() {
		return userRepository.findById((long) 1).orElse(null);
//		return "HOLA PROIBANDO ";
//		APARECE EN 001  -- 03";
//		APARECE EN DEVELOP 03";
//		APARECE EN MASTER  03";
	}
	
	

}
