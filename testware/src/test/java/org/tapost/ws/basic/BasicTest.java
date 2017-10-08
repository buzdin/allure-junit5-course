package org.tapost.ws.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicTest {

    private static final Logger logger = LoggerFactory.getLogger(BasicTest.class);

    @BeforeAll
    public static void init() {
        logger.info("init");
    }

    @AfterAll
    public static void destroy() {
        logger.info("destroy");
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        logger.info("setUp : {}", testInfo);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        logger.info("tearDown : {}", testInfo);
    }

    @Test
    @DisplayName("Hello")
    public void test() {
        logger.info("Hello");
    }

    @Test
    public void throwsError() {
        assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException();
        });
    }

    @Test
    @Disabled
    public void ignored() {
        logger.info("ignored");
    }


}
