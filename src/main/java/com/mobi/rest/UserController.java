package com.mobi.rest;

import com.mobi.domain.Retorno;
import com.mobi.domain.Users;
import com.mobi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Criando um usuário
     * POST para http://localhost:8080/v1/user
     *
     * Payload:
     *
     * {
     *     "username":"Marcos",
     *     "cpf":"21804536806"
     * }
     *
     * @param usuario
     * @return
     */

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Retorno criarUsuario(final @RequestBody Users usuario){
        userService.criarUsuario(usuario);
        return new Retorno("Usuário criado com sucesso");
    }

    @GetMapping(value = "/users")
    public List<Users> listaUsuarios() {
        return userService.listarUsuarios();
    }
}
