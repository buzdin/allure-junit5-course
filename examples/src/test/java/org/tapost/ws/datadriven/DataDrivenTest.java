package org.tapost.ws.datadriven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class DataDrivenTest {

    private static final Logger logger = LoggerFactory.getLogger(DataDrivenTest.class);

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
    }

    @DisplayName("Custom Name")
    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @ValueSource(strings = {"a", "b", "c"})
    public void testWithParam(String param, TestInfo info) {
        logger.info(param);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/users.csv")
    public void withCsvSource(String user, String password, Integer id) {
        logger.info("{}:{}:{}", user, password, id);
    }

    @ParameterizedTest
    @MethodSource("customData")
    public void testWithMethodSource() {
    }

    static Stream<Arguments> customData() {
        return Stream.of(
                Arguments.of("1", "a", true),
                Arguments.of("3", "b", false)
        );
    }

    @RepeatedTest(3)
    public void repeat(RepetitionInfo repetitionInfo) {
        logger.info("{}", repetitionInfo);
    }

}
