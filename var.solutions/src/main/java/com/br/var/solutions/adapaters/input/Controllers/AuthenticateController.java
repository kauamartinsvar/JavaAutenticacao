package com.br.var.solutions.adapaters.input.Controllers;

import com.br.var.solutions.adapaters.input.Entities.GenerateToken;
import com.br.var.solutions.adapaters.input.Entities.Usuario;
import com.br.var.solutions.application.services.useCase.UsuarioUseCase;
import com.br.var.solutions.infraestructure.config.security.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthenticateController {

    @Autowired
    UsuarioUseCase usuarioUseCase;


    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<GenerateToken> generateToken (@RequestParam("client_id") String client_id,
                                                        @RequestParam("password") String password)
    {
        log.info("Bora tentar ne gerar o token se der certo blz se não der paciência");
        Usuario user = usuarioUseCase.buscarUsuario(Usuario.builder()
                .usuario(client_id)
                .senha(password)
                .build());

        if(Objects.isNull(user))
        {
            log.info("Seu token não vai ser gerado simplesmente pq não quero e .");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenerateToken());
        }
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();

        String token = jwtTokenUtil.generateToken(client_id);


        GenerateToken tokenResponse = new GenerateToken();
        tokenResponse.setToken(token);

        log.info("Seu token ta gerado pelo user :" + client_id + " em" + System.currentTimeMillis());
        return ResponseEntity.ok(tokenResponse);
    }

}



