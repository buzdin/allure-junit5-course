package org.tapost.ws.allure;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportingTest {

    private static final Logger logger = LoggerFactory.getLogger(ReportingTest.class);

    @Test
    public void traceability(TestReporter testReporter) {
        testReporter.publishEntry("key", "value");
        login("admin", "pwd");
        logout();
    }

    @Epic("JIRA-123")
    @Story("JIRA-456")
    @Description("hello")
    @Feature("Login")
    @Issue("BUG-23")
    @Link("http://google.com")
    @Owner("dmitry.buzdin")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("TMS-22")
    @Test
    public void allureParameters() {
        logger.info("Allure");
    }

    @Epics({@Epic("1"), @Epic("2")})
    @Stories({@Story("1"), @Story("2")})
    public void multipleLabels() {
        logger.info("Allure");
    }

    @Test
    public void attachment() {
        storeResponse();
    }

    @Test
    public void itWasFailing() {

    }

    @Step
    public void login(String username, String password) {

    }

    @Step
    public void logout() {

    }

    @Attachment(type = "application/json")
    public byte[] storeResponse() {
        return "{\"response\" : \"ok\"}".getBytes();
    }

}
