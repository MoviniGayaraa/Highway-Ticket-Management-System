package lk.ijse.gdse.userservice.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.userservice.convertion.Converte;
import lk.ijse.gdse.userservice.dto.UserDTO;
import lk.ijse.gdse.userservice.repository.UserServiceDAO;
import lk.ijse.gdse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amil Srinath
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserServiceDAO userServiceDAO;
    @Autowired
    private Converte converte;

    @Override
    public void save(UserDTO userDTO) {
        userServiceDAO.save(converte.convertToEntity(userDTO));
    }
}
