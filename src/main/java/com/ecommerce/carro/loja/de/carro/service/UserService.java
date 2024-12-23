package com.ecommerce.carro.loja.de.carro.service;

import com.ecommerce.carro.loja.de.carro.model.UserModel;
import com.ecommerce.carro.loja.de.carro.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

private final UserRepository userRepository;

@Autowired
    public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
}


    public User CreateNewUser(UserModel userModel){

    }

}
