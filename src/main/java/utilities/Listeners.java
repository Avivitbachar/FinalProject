package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    {
    }

    public void onFinish(ITestContext execution) {
        System.out.println("----------Ending Execution------------");
    }

    public void onStart(ITestContext execution) {
        System.out.println("----------Stating Execution------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODD implement this....
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("-----------Test:"  + test.getName()  +  "Failed -------------");

        if (!platform.equalsIgnoreCase("api")){
            // Stop Recording
            try {
                MonteScreenReorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
        }



    public void onTestSkipped(ITestResult test) {
        System.out.println("---------Skipping Test:" + test.getName() + "------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("------------Starting Test:" + test.getName() + "--------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------Test:"  +  test.getName()  +  "Passed-----------");

        if (!platform.equalsIgnoreCase("api")){
            // Stop Recording
            try {
                MonteScreenReorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
            // Delete Recorder File
            File file = new File ("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to Delete File");
        }
        }



    @Attachment(value = "Page Screen-Shot" , type = "image/png")
    public  byte [] saveScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
