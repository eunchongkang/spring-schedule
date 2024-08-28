package spring.schedulejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import spring.schedulejpa.dto.UserAllResponseDto;
import spring.schedulejpa.dto.UserSaveRequestDto;
import spring.schedulejpa.dto.UserSaveResponseDto;
import spring.schedulejpa.dto.UserdetailResponseDto;
import spring.schedulejpa.entity.User;
import spring.schedulejpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto SaveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        User user = new User(
                userSaveRequestDto.getUsername(),
                userSaveRequestDto.getEmail()
        );
        User savedUser = userRepository.save(user);
        return new UserSaveResponseDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }


    public List<UserAllResponseDto> getUser(){

        List<User> users= userRepository.findAll();
        List<UserAllResponseDto> userList = new ArrayList<>();
        for(User user : users){
            UserAllResponseDto userDto = new UserAllResponseDto(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            userList.add(userDto);
        }
        return userList;
    }

    public UserdetailResponseDto getUser(Long userid){
        User user = userRepository.findById(userid).orElseThrow(() -> new NoSuchElementException("Id가 존재하지 않습니다."));
        return new UserdetailResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
    @Transactional
    public void deleteUser(Long userid){
        User user = userRepository.findById(userid).orElseThrow(() -> new NoSuchElementException("Id가 존재하지 않습니다."));
        userRepository.delete(user);
    }
}
