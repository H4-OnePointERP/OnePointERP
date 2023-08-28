package project.onepoint.erp.Login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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

