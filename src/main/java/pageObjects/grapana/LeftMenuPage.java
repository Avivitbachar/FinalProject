package pageObjects.grapana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LeftMenuPage {
    @FindBy(how = How.XPATH ,using = "//div[@class='sidemenu-item dropdown'][7]")
    public WebElement btn_server;

    @FindBy(how = How.XPATH ,using = "//div[@class='sidemenu-item dropdown'][6]")
    public WebElement btn_configuration;

    @FindBy(how = How.XPATH ,using = "//div[@class='sidemenu-item dropdown'][5]")
    public WebElement btn_alerting;
}
