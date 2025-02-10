package com.sleepyjelly.pb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = BugCourtApplicationTestConfig.class, webEnvironment = WebEnvironment.DEFINED_PORT)
class BugCourtApplicationTests {

	@Test
	void contextLoads() {
	}

}
