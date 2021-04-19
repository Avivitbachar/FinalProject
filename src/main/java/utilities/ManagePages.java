package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.grapana.AddNewUserPage;
import pageObjects.grapana.EditUserPage;
import pageObjects.grapana.ServerAdminMainPage;
import pageObjects.grapana.ServerAdminMenuPage;

public class ManagePages extends Base{
    public static void initGrafana(){
        grafanalogin = PageFactory.initElements(driver,pageObjects.grapana.LoginPage.class);
        grafanaMain = PageFactory.initElements(driver,pageObjects.grapana.MainPage.class);
        grafanaLeftMenu= PageFactory.initElements(driver,pageObjects.grapana.LeftMenuPage.class);
        grafanaServeradmin= PageFactory.initElements(driver, ServerAdminMenuPage.class);
        grafanaServeradminMain= PageFactory.initElements(driver, ServerAdminMainPage.class);
        grafanaAddNewUser= PageFactory.initElements(driver, AddNewUserPage.class);
        grafanaEditUser= PageFactory.initElements(driver, EditUserPage.class);
    }

    public static void initToDo(){
        todoMain = PageFactory.initElements(driver,pageObjects.todo.MainPage.class);
    }
}
