package org.tapost.ws.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StructureTests {

    private static final Logger logger = LoggerFactory.getLogger(StructureTests.class);

    @Tag("hello")
    @Test
    public void test() {

    }

    @Tag("a")
    @Tag("b")
    public void multipleTags() {
    }

    @Nested
    class LoginTests {

        @BeforeEach
        public void setUp() {
        }

        @Test
        public void shouldLogin() {
        }

    }

    @Nested
    class LogoutTests {

        @Test
        public void shouldLogout() {
        }

    }

    @Regression
    @Test
    public void regressionTest() {
    }

    @Test
    @Disabled("it was failing")
    public void ignored() {
        logger.info("ignored");
    }

}
