package com.mobi.services;

import com.mobi.domain.Users;
import com.mobi.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepo usersRepo;

    /**
     * Prefiro colocar regras de negócios no Service ou em
     * uma camada distinta.
     * @param user
     */
    public void criarUsuario(Users user){
        usersRepo.save(user);
    }

    public List<Users> listarUsuarios(){
        return usersRepo.findAll();
    }
}
