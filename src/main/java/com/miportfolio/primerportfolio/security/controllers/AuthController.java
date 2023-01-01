//package com.miportfolio.primerportfolio.security.controllers;
//
//
//import com.miportfolio.primerportfolio.dto.Mensaje;
//import com.miportfolio.primerportfolio.security.dto.JwtDto;
//import com.miportfolio.primerportfolio.security.dto.LoginUser;
//import com.miportfolio.primerportfolio.security.dto.NewUser;
//import com.miportfolio.primerportfolio.security.enums.RolNombre;
//import com.miportfolio.primerportfolio.security.jwt.JwtProvider;
//import com.miportfolio.primerportfolio.security.models.Rol;
//import com.miportfolio.primerportfolio.security.models.User;
//import com.miportfolio.primerportfolio.security.services.RolService;
//import com.miportfolio.primerportfolio.security.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashSet;
//import java.util.Set;
//
///**===/ API REST /===**/
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//public class AuthController {
//    
//}
