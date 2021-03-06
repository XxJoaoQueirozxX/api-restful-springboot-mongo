package com.restful.api.services;

import com.restful.api.domain.User;
import com.restful.api.dto.UserDTO;
import com.restful.api.repositories.UserRepository;
import com.restful.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User u){
        return repository.insert(u);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user){
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

}
