package pageObjects.grapana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminMainPage {
    @FindBy(how = How.CSS ,using = "td[class='width-4 text-center link-td']")
    public List<WebElement> rows;

    @FindBy(how = How.LINK_TEXT ,using = "New user")
    public WebElement btn_newUser;

    @FindBy(how = How.CSS ,using = "input[placeholder='Search user by login, email or name']")
    public WebElement txt_search;
}
