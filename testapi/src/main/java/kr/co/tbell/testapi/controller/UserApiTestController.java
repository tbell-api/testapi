package kr.co.tbell.testapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tbell.testapi.model.network.Header;
import kr.co.tbell.testapi.model.network.request.UserApiRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/test/user")
public class UserApiTestController {
	
    @PostMapping("")    // /api/user
    public String create(String request) {
        log.info("{}", request);
        return "User를 생성합니다.";
    }

    @GetMapping("{id}") // /api/user/{id}
    public String read(String id) {
        log.info("read id : {}", id);
        return "User의 정보를 조회합니다.";
    }

    @PutMapping("") // /api/user
    public String update(String request) {
        log.info("{}", request);
        return "User의 정보를 수정합니다.";
    }

    @DeleteMapping("{id}")  // /api/user/{id}
    public String delete(String id) {
        log.info("delete : {}", id);
        return "User의 정보를 삭제합니다.";
    }
}
