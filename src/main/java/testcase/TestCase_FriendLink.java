package testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.background.Page_FriendLink;
import pages.background.Page_Login;
import utils.BasicPage;

import java.io.IOException;

import static pages.background.FrameUtils.inputFrame;
import static pages.background.FrameUtils.rightFrame;


/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class TestCase_FriendLink {

    @BeforeMethod
    public void open(){
        BasicPage.openBrowser();
        BasicPage.navigate("http://192.168.1.165:8010/trade-mis");
    }
    @Test
    public void aVoid() throws InterruptedException, IOException {
        Page_Login.Login();
        //BasicPage.switchToFrame(2);
        BasicPage.switchToParFrame();
        BasicPage.click(Page_FriendLink.firstTab_ContentManagement);
        BasicPage.click(Page_FriendLink.friendLinkTab);
        BasicPage.switchToFrame(rightFrame);
        BasicPage.click(Page_FriendLink.addFriLink);
        BasicPage.switchToDef();
        BasicPage.switchToFrame(inputFrame);
        BasicPage.type(Page_FriendLink.newFriLinkName,"testd  ata");
        BasicPage.type(Page_FriendLink.newFriLinkLink,"http://www.qq.com");
        BasicPage.click(Page_FriendLink.newFrilinkConfirm);


    }

    /*@AfterMethod
    public void close(){
        BasicPage.closeBrowser();
    }*/
}
