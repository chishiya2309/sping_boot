package vn.tayjava.controller;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping(value = "/", headers = "apiKey=v1.0")
    @RequestMapping(method = POST, path = "/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO userDTO)
    {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO)
    {
        System.out.println("Request update userId = " + userId);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status)
    {
        System.out.println("Request change status, userId = " + userId);
        return "User changed status";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId)
    {
        System.out.println("Request delete userId = " + userId);
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId)
    {
        System.out.println("Request get user detail by userId" + userId);
        return new UserRequestDTO("Tay", "Java", "phone", "email");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize)
    {
        System.out.println("Request get user list");
        return List.of(new UserRequestDTO("Tay", "Java", "phone", "email"),
                new UserRequestDTO("Tay", "Python", "phone", "email"));
    }

}
