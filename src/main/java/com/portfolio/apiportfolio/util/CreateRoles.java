package com.portfolio.apiportfolio.util;

import com.portfolio.apiportfolio.security.enums.RolNombre;
import com.portfolio.apiportfolio.security.models.Rol;
import com.portfolio.apiportfolio.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class CreateRoles implements CommandLineRunner{	

    
      @Autowired
  RolService rolService;
    
    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol (RolNombre.ROLE_ADMIN);
	Rol rolUser = new Rol (RolNombre.ROLE_USER);
	rolService.save(rolAdmin);
	rolService.save(rolUser);
    }
   


}