package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.CSS,using = "input[placeholder='Create a task']")
    public WebElement txt_create;

    @FindBy(how = How.CLASS_NAME,using = "task_2b-4p task_3i8Uo")
    public List<WebElement> list_tasks;

}
