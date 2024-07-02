package lk.ijse.gdse.userservice.service;

import lk.ijse.gdse.userservice.dto.UserDTO;


public interface UserService {
    void save(UserDTO userDTO);
    boolean isExistsUser(String userId);
    boolean checkCredentials(UserDTO userDTO);
}
