package com.kathiravanvp.tests.pageObjectModel_tests.VWO_Application;

import com.kathiravanvp.base.CommonToAll;
import com.kathiravanvp.base.CommonToAllTest;
import com.kathiravanvp.driver.DriverManager;
import com.kathiravanvp.pages.pageObjectModel.normal_POM.LoginPage;
import com.kathiravanvp.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_NormalScript_POM extends CommonToAllTest {
    @Description("Verify that with invalid email and password, error message is displayed")
    @Test
    public void test_negative_login(){
        WebDriver driver = DriverManager.getDriver();

        LoginPage loginPage = new LoginPage(driver);

        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readkey("invalid_username"),PropertiesReader.readkey("invalid_password"));

        assertThat(error_msg).isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readkey("error_message"));
    }
}
