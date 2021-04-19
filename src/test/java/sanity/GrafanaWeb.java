package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
@Listeners(utilities.Listeners.class)
public class GrafanaWeb extends CommonOps {
    @Test(description = "Test01 - Verify Header")
    @Description("This Test login and verifies the main header")
    public void test01_verifyHeader(){
        WebFlows.login(getData("UserName"),getData("Password"));
        Verifications.verifyTextInElement(grafanaMain.head_Dashboard,"Welcome to Grafana");

    }
   @Test(description = "Test02 - Verify Default Users")
    @Description("This Test verifies the default users")
    public void test02_verifyDefaultUsers(){
       UIActions.mousehover(grafanaLeftMenu.btn_server,grafanaServeradmin.link_users);
       Verifications.numberOfElements(grafanaServeradminMain.rows, 1);
    }

   @Test(description = "Test03 - Verify New User")
  @Description("This Test verifies a new user has been added")
   public void test03_verifyNewUser(){
       UIActions.mousehover(grafanaLeftMenu.btn_server,grafanaServeradmin.link_users);
      WebFlows.createNewUser("Avivit","nems.bachar@gmail.com","avivitb","12345");
      Verifications.numberOfElements(grafanaServeradminMain.rows, 2);
    }

  @Test(description = "Test04 - Verify User Deletion")
  @Description("This Test login and verifies the main header")
  public void test04_verifyNewUserDeletion(){
      UIActions.mousehover(grafanaLeftMenu.btn_server,grafanaServeradmin.link_users);
     WebFlows.deleteLastUser();

       Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);

       Verifications.numberOfElements(grafanaServeradminMain.rows, 1);
   }

   @Test(description = "Test05 - Verify Progress Steps")
  @Description("This Test verifies the default progress steps are displayed (using soft assertion")
   public void test05_verifyProgressStep(){
     Verifications.visibilityOfElements(grafanaMain.list_progressSteps);


   }

 // @Test(description = "Test06 - Verify Avatar Icon")
 //@Description("This Test verifies the Avatar Image Using Sikuli tool")
 // public void test06_verifyAvatarIcon(){
     // Uninterruptibles.sleepUninterruptibly(15,TimeUnit.SECONDS);
     // Verifications.visualElement("Avatar");


  // }//

    @Test(description = "Test07 - Search Users",dataProvider = "data-provider-users",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Searched Users in a table using DDT")
    public void test07_searchUsers(String user,String shouldExist){
        UIActions.mousehover(grafanaLeftMenu.btn_server,grafanaServeradmin.link_users);
        WebFlows.serachAndVerifyUser(user, shouldExist);


}
}
