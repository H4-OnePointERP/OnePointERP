package project.onepoint.erp.Login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.onepoint.erp.Login.dto.req.LoginDto;


@RestController
public class LoginController {



    @PostMapping("/login.do")
    public ResponseEntity<String> getLogin(@RequestBody LoginDto loginDto) {

        if (loginDto.getId().equals("asdf") && loginDto.getPassword().equals("1234")) {
            // 로그인 성공 시 세션에 사용자 아이디 저장

            return ResponseEntity.ok("{\"success\": true}");
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

