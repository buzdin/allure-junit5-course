package org.tapost.ws.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("User Friendly Name")
    public void test() {
        logger.info("Hello");
    }

    @Test
    public void assertions() {
        assertAll("person",
                () -> assertEquals("John", "John"),
                () -> assertEquals("Doe", "Doe")
        );
    }

    @Test
    public void throwsError() {
        assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException();
        });
    }

    @Test
    public void waitsForTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(100);
        });
    }

    @Test
    public void assumptions() {
        Assumptions.assumingThat(false, () -> {
            assertTrue(false);
        });
    }

    @Test
    public void lamdaAssertion() {
        assertTrue(() -> true, "This it not true");
    }

}
