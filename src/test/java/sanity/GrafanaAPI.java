package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

import java.util.concurrent.TimeUnit;

public class GrafanaAPI extends CommonOps {
    @Test(description = "Test 01:Get Team From Grafana" )
    @Description("This Test Verify Team Property")
    public void test01_verifyTeam(){
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[0].name"),"AvivitTeam");
    }

    @Test(description = "Test 02:Add Team And verify" )
    @Description("This Test Adds a Team to Greafana and Verify it")
    public void test02_addTeamAndVerify(){
        ApiFlows.postTeam("Avivitba","AvivitTeam4@teams.com");
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[1].name"),"Avivitba");
    }

    @Test(description = "Test 03:Update Team And verify" )
    @Description("This Test Updates a Team to Greafana and Verify it")
    public void test03_UpdateTeamAndVerify(){
       String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("Avivitba","AvivitTeam@kuku34.com",id);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Verifications.VerifyText(ApiFlows.getTeamProperty("teams[1].email"),"AvivitTeam@kuku34.com");
    }

    @Test(description = "Test 04:Delete Team And verify" )
    @Description("This Test Deletes a Team to Greafana and Verify it")
    public void test04_DeleteTeamAndVerify(){
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        Verifications.VerifyText(ApiFlows.getTeamProperty("totalCount"),"1");
    }


}
