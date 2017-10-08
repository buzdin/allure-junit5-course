package org.tapost.ws.allure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class ReportingTest {

    @Test
    public void traceability(TestReporter testReporter) {
        testReporter.publishEntry("key", "value");
    }

}
