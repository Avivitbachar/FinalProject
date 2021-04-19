package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class GrafanaWebDB extends CommonOps {
    @Test(description = "Test01 - Login to Grafana with DB Credentials")
    @Description("This Test login with DB Credentials and verifies the main header")
    public void test01_loginDBAndVerifyHeader(){
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        WebFlows.loginDB();
        Verifications.verifyTextInElement(grafanaMain.head_Dashboard,"Welcome to Grafana");

    }
}
