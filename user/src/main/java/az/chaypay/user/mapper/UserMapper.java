package az.chaypay.user.mapper;


import az.chaypay.shared.user.CreateUserRequest;
import az.chaypay.shared.user.UserDTO;
import az.chaypay.shared.user.UserInfoResponse;
import az.chaypay.shared.user.UserLightDTO;
import az.chaypay.user.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "team", source = "team.name")
    @Mapping(target = "organization", source = "team.organization.name")
    public abstract UserDTO toUserDTO(User entity);

    @Mapping(target = "teamId", source = "team.id")
    public abstract UserLightDTO toUserLightDTO(User entity);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "team", source = "team.name")
    @Mapping(target = "organization", source = "team.organization.name")
    public abstract UserInfoResponse toUserInfoResponse(User user);

    @Mapping(target = "team.name", source = "team")
    @Mapping(target = "team.organization.name", source = "organization")
    public abstract User toUserEntity(CreateUserRequest request);
}
