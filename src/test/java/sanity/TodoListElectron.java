package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;
import workflows.WebFlows;

import java.util.concurrent.TimeUnit;

public class TodoListElectron extends CommonOps {
    @Test(description = "Test01 -  Add and Verify New Task")
    @Description("This Test adds a new task and verifies it in the list of tasks")
    public void test01_addAndVerifyNewTask(){
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        ElectronFlows.addNewTask("Learn Java");
        Uninterruptibles.sleepUninterruptibly(10,TimeUnit.SECONDS);
        Verifications.VerifyNumber(ElectronFlows.getNumberOfTasks(),1);

    }
}
