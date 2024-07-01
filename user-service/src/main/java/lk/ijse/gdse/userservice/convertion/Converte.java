package lk.ijse.gdse.userservice.convertion;

import lk.ijse.gdse.userservice.dto.UserDTO;
import lk.ijse.gdse.userservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Amil Srinath
 */
@Component
@RequiredArgsConstructor
public class Converte {
    private final ModelMapper modelMapper;

    public User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
