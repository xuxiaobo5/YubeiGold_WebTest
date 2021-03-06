package com.yubeigold.web.testcase;

import com.yubeigold.web.utils.BasicPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.yubeigold.web.pages.Page_Login;

import java.io.IOException;


/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class TestCase_FriendLink extends BasicPage {

    @BeforeMethod
    public void open(){
        openBrowser("http://192.168.1.165:8010/trade-mis");
    }

    @Test
    public void aVoid() throws InterruptedException, IOException {
        Page_Login.Login();
        //BasicPage.switchToFrame(2);
        BasicPage.switchToParFrame();
        BasicPage.click(Page_Login.Page_FriendLink.firstTab_ContentManagement);
        BasicPage.click(Page_Login.Page_FriendLink.friendLinkTab);
        BasicPage.switchToFrame(Page_Login.FrameUtils.rightFrame);
        BasicPage.click(Page_Login.Page_FriendLink.addFriLink);
        BasicPage.switchToDef();
        BasicPage.switchToFrame(Page_Login.FrameUtils.inputFrame);
        BasicPage.type(Page_Login.Page_FriendLink.newFriLinkName,"testd  ata");
        BasicPage.type(Page_Login.Page_FriendLink.newFriLinkLink,"http://www.qq.com");
        BasicPage.click(Page_Login.Page_FriendLink.newFrilinkConfirm);


    }

    @AfterMethod
    public void close(){
        closeBrowser();
    }
}
