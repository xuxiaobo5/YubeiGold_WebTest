package com.yubeigold.web.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.yubeigold.web.pages.Page_Login;
import com.yubeigold.web.utils.BasicPage;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class TestCase_Login {

    @BeforeMethod
    public void openBrowser(){
        BasicPage.openBrowser("http://192.168.1.165:8010/trade-mis");
    }

    @Test
    public void testLogin(){
        Page_Login.Login();
    }

    @Test
    public void testLogout(){
        Page_Login.Logout();
    }

    @AfterMethod
    public void closeBrowser(){
        BasicPage.closeBrowser();
    }
}
