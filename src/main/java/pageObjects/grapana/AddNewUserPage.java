package pageObjects.grapana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AddNewUserPage {
    @FindBy(how = How.NAME ,using = "name")
    public WebElement txt_name;

    @FindBy(how = How.NAME,using = "email")
    public WebElement txt_email;

    @FindBy(how = How.NAME ,using = "login")
    public WebElement txt_userName;

    @FindBy(how = How.NAME ,using = "password")
    public WebElement txt_passWord;

    @FindBy(how = How.CSS ,using = "button[class='css-a5ta8x-button']")
    public WebElement btn_create;
}
