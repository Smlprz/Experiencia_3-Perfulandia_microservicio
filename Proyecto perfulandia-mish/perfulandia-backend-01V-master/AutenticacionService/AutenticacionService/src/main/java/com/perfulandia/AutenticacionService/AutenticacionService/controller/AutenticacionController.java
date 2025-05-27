package com.perfulandia.AutenticacionService.AutenticacionService.controller;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import com.perfulandia.AutenticacionService.AutenticacionService.service.AutenticationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/login")
public class AutenticacionController {
    private final AutenticationService Service;
    public AutenticacionController(AutenticationService Service) {

    }

}
