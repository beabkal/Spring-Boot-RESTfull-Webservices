package springbootrestfulwebservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springbootrestfulwebservices.dto.UserDTO;
import springbootrestfulwebservices.entity.User;

@Mapper
public interface AutoUserMapper {

//    Provides the implementation for this interface at compile time
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    User mapToUser(UserDTO userDTO);

    UserDTO mapToUserDTO(User user);
}
