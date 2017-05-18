package pages.background;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BasicPage;

import static pages.background.FrameUtils.leftFrame;
import static pages.background.FrameUtils.rightFrame;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class Page_Login{

    //定位用户名输入框
    public static By usernameInput = By.id("account");

    //定位密码输入框
    public static By passwordInput = By.id("password");

    //定位登录按钮
    public static By loginBtn = By.className("btn");

    //定位登出按钮
    public static By logoutBtn = By.xpath("//*[@class='mb-control']/span");

    //定位登出确认按钮
    public static By logoutConfirmBtn = By.className("btn-success");

    //登陆成功文字
    public static By loginText = By.xpath("//*[@class='profile-data']/div");

    //登出成功文字
    public static By logoutText = By.xpath("//*[@class='login-container lightmode']//label");

    //登录系统后台
    public static void Login(){
        BasicPage.type(usernameInput,"superadmin");
        BasicPage.type(passwordInput,"123456");
        BasicPage.click(loginBtn);
        BasicPage.switchToFrame(leftFrame);
        BasicPage.switchToFrame(rightFrame);
        Assert.assertEquals(BasicPage.getText(loginText),"系統管理員");
    }

    //登出系统后台
    public static void Logout(){
        Page_Login.Login();
        BasicPage.switchToParFrame();
        BasicPage.click(logoutBtn);
        BasicPage.click(logoutConfirmBtn);
        Assert.assertEquals(BasicPage.getText(logoutText),"交易管理系统");
    }
}
