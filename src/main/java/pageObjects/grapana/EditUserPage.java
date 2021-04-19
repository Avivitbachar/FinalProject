package pageObjects.grapana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EditUserPage {
    @FindBy(how = How.CSS ,using = "button[class='css-jigxr0-button']")
    public WebElement btn_DeleteUser;

    @FindBy(how = How.XPATH ,using = "//div[@class='css-1nrg97p']")
    public WebElement btn_confirmDeleteUser;
}
