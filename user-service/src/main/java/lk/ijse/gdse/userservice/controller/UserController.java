package lk.ijse.gdse.userservice.controller;

import lk.ijse.gdse.userservice.dto.UserDTO;
import lk.ijse.gdse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "User service is up and running";
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok("User saved successfully");
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok("User updated successfully");
    }
}
