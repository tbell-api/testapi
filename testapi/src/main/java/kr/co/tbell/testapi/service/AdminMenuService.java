package kr.co.tbell.testapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.tbell.testapi.model.front.AdminMenu;

@Service
public class AdminMenuService {

    public List<AdminMenu> getAdminMenu(){

        return Arrays.asList(
                AdminMenu.builder().title("고객 관리").url("/testapi/pages/user").code("user").build()
        );

    }

}
