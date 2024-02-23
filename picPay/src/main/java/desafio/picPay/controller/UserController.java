package desafio.picPay.controller;

import desafio.picPay.domain.user.User;
import desafio.picPay.domain.user.UserDTO;
import desafio.picPay.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO user) {
        User newUser = this.service.insert(user);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = this.service.getAll();
        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody UserDTO user) {
        User updatedUser = this.service.update(id, user);
        return ResponseEntity.ok().body(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
