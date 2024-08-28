package spring.schedulejpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.schedulejpa.dto.UserAllResponseDto;
import spring.schedulejpa.dto.UserSaveRequestDto;
import spring.schedulejpa.dto.UserSaveResponseDto;
import spring.schedulejpa.dto.UserdetailResponseDto;
import spring.schedulejpa.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserSaveResponseDto saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return userService.SaveUser(userSaveRequestDto);
    }

    //전체 조회
    @GetMapping("/user")
    public List<UserAllResponseDto> getAllUser(){
        return userService.getUser();
    }

    @GetMapping("/user/{userid}")
    public UserdetailResponseDto getUser(@PathVariable long userid){
        return userService.getUser(userid);
    }

    @DeleteMapping("/user/{userid}")
    public void deleteUser(@PathVariable long userid){
        userService.deleteUser(userid);
    }
}
