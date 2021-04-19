package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.grapana.AddNewUserPage;
import pageObjects.grapana.EditUserPage;
import pageObjects.grapana.ServerAdminMainPage;
import pageObjects.grapana.ServerAdminMenuPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General

    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static  String platform;

    //Web
    protected static WebDriver driver;

    //Electron
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Pages Objects - Web
    protected static pageObjects.grapana.LoginPage grafanalogin;
    protected static pageObjects.grapana.MainPage grafanaMain;
    protected static pageObjects.grapana.LeftMenuPage grafanaLeftMenu;
    protected static ServerAdminMenuPage grafanaServeradmin;
    protected static ServerAdminMainPage grafanaServeradminMain;
    protected static AddNewUserPage grafanaAddNewUser;
    protected static EditUserPage grafanaEditUser;

    //Pages Objects - Electron
    protected static pageObjects.todo.MainPage todoMain;
}
