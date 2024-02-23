package desafio.picPay.service;

import desafio.picPay.domain.user.User;
import desafio.picPay.domain.user.UserDTO;
import desafio.picPay.domain.user.exceptions.UserNotFoundException;
import desafio.picPay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(UserDTO userData) {
        User newUser = new User(userData);
        this.repository.save(newUser);
        return newUser;
    }
    public List<User> getAll(){
        return this.repository.findAll();
    }

    public User update(Long id, UserDTO userData) {
        User user = this.repository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        if(!userData.name().isEmpty()) user.setName(userData.name());
        if(!userData.email().isEmpty()) user.setEmail(userData.email());
        if(!userData.balance().equals(false)) user.setBalance(userData.balance());
        if(!userData.type().equals(false)) user.setType(userData.type());
        return repository.save(user);
    }

    public User findById(long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }


}
