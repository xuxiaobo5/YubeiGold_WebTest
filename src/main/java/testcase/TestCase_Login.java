package testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.background.Page_Login;
import utils.BasicPage;
import utils.LoggerControler;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class TestCase_Login {

    @BeforeMethod
    public void openBrowser(){
        BasicPage.openBrowser();
        BasicPage.navigate("http://192.168.1.165:8010/trade-mis");
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
