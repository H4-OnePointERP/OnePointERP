package project.onepoint.erp.Login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.onepoint.erp.Login.dto.req.LoginDto;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {


    HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<String> getLogin(@RequestBody LoginDto loginDto) {

        if (loginDto.getId().equals("asdf") && loginDto.getPassword().equals("1234")) {

            return ResponseEntity.ok("{\"success\": true}");
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

