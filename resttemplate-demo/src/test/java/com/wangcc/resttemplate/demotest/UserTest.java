package com.wangcc.resttemplate.demotest;

import com.wangcc.resttemplate.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Author: BryantCong
 * @Date: 2019/12/19 10:15
 * @Description:
 */
@Slf4j
public class UserTest extends BaseTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        final String uri = "http://localhost:8081/user/detail";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("TermTyp", "web");
        User user = new User();
        user.setName("Kobe");
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        ResponseEntity<User> result = restTemplate.exchange(uri, HttpMethod.POST, entity, User.class);
        User retUser = result.getBody();
        log.info("retUser:{}",retUser);
    }

}
