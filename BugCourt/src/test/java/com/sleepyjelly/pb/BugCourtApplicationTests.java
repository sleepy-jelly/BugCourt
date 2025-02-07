package com.sleepyjelly.pb;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = BugCourtApplicationTestConfig.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@MapperScan("com.sleepyjelly.pb.common.user.service.impl")
class BugCourtApplicationTests {

	@Test
	void contextLoads() {
	}

}
