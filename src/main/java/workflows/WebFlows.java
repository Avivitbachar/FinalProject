package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to Grafana")
    public static void login(String user,String pass){
        UIActions.updateText(grafanalogin.txt_username,user);
        UIActions.updateText(grafanalogin.txt_password,pass);
        UIActions.click(grafanalogin.btn_login);
        UIActions.click(grafanalogin.btn_skip);

    }

    @Step("Business Flow: Login to Grafana with DB Credentials")
    public static void loginDB(){
        String query = "SELECT name , password FROM Employees WHERE id = '3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(grafanalogin.txt_username,cred.get(0));
        UIActions.updateText(grafanalogin.txt_password,cred.get(1));
        UIActions.click(grafanalogin.btn_login);
        UIActions.click(grafanalogin.btn_skip);

    }
    @Step("Business Flow: Create New User")
    public static void createNewUser(String name,String email,String userName,String pass){
        UIActions.click(grafanaServeradminMain.btn_newUser);
        UIActions.updateText(grafanaAddNewUser.txt_name,name);
        UIActions.updateText(grafanaAddNewUser.txt_email,email);
        UIActions.updateText(grafanaAddNewUser.txt_userName,userName);
        UIActions.updateText(grafanaAddNewUser.txt_passWord,pass);
        UIActions.click(grafanaAddNewUser.btn_create);

    }

    @Step("Business Flow: Delete Last User")
    public static void deleteLastUser (){
        UIActions.click(grafanaServeradminMain.rows.get(grafanaServeradminMain.rows.size()-1));
        UIActions.click(grafanaEditUser.btn_DeleteUser);
        UIActions.click(grafanaEditUser.btn_confirmDeleteUser);
    }

    @Step("Business Flow: Search and Verify User")
    public static void serachAndVerifyUser(String user , String shouldExists){
        UIActions.updateTextHuman(grafanaServeradminMain.txt_search , user);
        if (shouldExists.equalsIgnoreCase("exists"))
            Verifications.existanceOfElement(grafanaServeradminMain.rows);
        else if (shouldExists.equalsIgnoreCase("not-exists"))
                 Verifications.nonExistancOfElements(grafanaServeradminMain.rows);
        else
            throw new RuntimeException("Invalid Expected Output Option in Data Driven testing, Should be exists or not-exists");
    }
}
