package pages.background;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class Page_FriendLink {

    //定位一级标签 内容管理
    public static By firstTab_ContentManagement = By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[12]/a/span[2]");

    //定位子级标签 内容管理
    public static By contentManagementTab = By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[12]/ul/li[2]/a/span");

    //定位子级标签 友情链接
    public static By friendLinkTab = By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[12]/ul/li[3]/a/span");

    //定位 添加友情链接 按钮
    public static By addFriLink = By.xpath("//*[@id=\"query_form\"]/div/div/div/div/div[1]/ul/li[1]/button");

    //定位 编辑友情链接 按钮
    public static By editFriLink = By.xpath("//*[@id=\"list_table\"]/tbody/tr[1]/td[5]/button[1]");

    //定位 删除友情链接 按钮
    public static By delFriLink = By.xpath("//*[@id=\"list_table\"]/tbody/tr[3]/td[5]/button[2]");

    //定位 新增友情链接的名称 输入框
    public static By newFriLinkName = By.xpath("//*[@id=\"save_form\"]/div/div[3]/div[1]/div/div/input");

    //定位 新增友情链接的链接 输入框
    public static By newFriLinkLink = By.xpath("//*[@id=\"save_form\"]/div/div[3]/div[2]/div/div/input");

    //定位 新增友情链接的确定 按钮
    public static By newFrilinkConfirm = By.xpath("//*[@id=\"save_form\"]/div/div[4]/div/div[3]/button");

    //定位 新增友情链接的取消 按钮
    public static By newFriLinkCancel = By.xpath("//*[@id=\"save_form\"]/div/div[4]/div/div[2]/button");

    //定位搜索输入框
    public static By searchInput = By.xpath("//*[@id=\"query_form\"]/div/div/div/div/div[2]/div/div/div/div[1]/input");

    //定位 搜索按钮
    public static By searchBtn = By.xpath("//*[@id=\"query_form\"]/div/div/div/div/div[2]/div/div/div/div[2]/button");


/*    @Test
    public void clickFriendlyLink() throws InterruptedException {
        BasicPage.openBrowser("chrome");
        BasicPage.navigate("http://192.168.1.165:8010/trade-mis");
        Page_Login.Login();
        BasicPage.switchToFrame(leftFrame);
        BasicPage.click(firstTab_ContentManagement);
        BasicPage.click(friendlyLinkTab);
        BasicPage.switchToFrame(rightFrame);
        BasicPage.click(addFriendlyLink);
        //BasicPage.type(newFriLinkName,);

        Thread.sleep(5000);
        BasicPage.closeBrowser();

    }*/

}
