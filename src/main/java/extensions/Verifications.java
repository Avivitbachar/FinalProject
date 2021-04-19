package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.testng.Assert.*;


public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem,String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected);
    }

    @Step("Number Of Elements")
    public static void numberOfElements(List<WebElement>elems,int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expected);



    }

    @Step("Visibility Of Elements (Soft-Assertion")
    public static void visibilityOfElements(List<WebElement> elems){
        for (WebElement elem : elems){
            softAssert.assertTrue(elem.isDisplayed(),"Sorry" + elem.getText() + "Not displayed");
        }

        softAssert.assertAll("Some elements were not displayed");
    }
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing Image File" + findFailed);
            fail("Error Comparing Image File" + findFailed);

        }
    }

   @Step("Verify Element Displayed")
    public static void existanceOfElement(List<WebElement>elements){
        assertTrue(elements.size() > 0);
   }

    @Step("Verify Element Not Displayed")
    public static void nonExistancOfElements(List<WebElement>elements){
        assertFalse(elements.size() > 0);
    }


@Step("Verify Text with Text")
public static void VerifyText(String actual,String expected){
        assertEquals(actual,expected);

   }

    @Step("Verify Number with Number")
    public static void VerifyNumber(int actual,int expected){
        assertEquals(actual,expected);

    }
}
