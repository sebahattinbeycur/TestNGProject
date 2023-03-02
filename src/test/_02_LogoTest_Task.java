package test;

import pages.LoginPage;
import utils.BaseClass;

public class _02_LogoTest_Task extends BaseClass {
    public static void main(String[] args) {
        setUp();

        // without page factory
//        var loginPage = new _01_LoginPageWithoutPageFactory();
//        boolean homepageLogoDisplayed = loginPage.homepageLogo.isDisplayed();
//        if (homepageLogoDisplayed)
//            System.out.println("Logo is displayed");
//        else
//            System.out.println("Logo is not displayed");

        // with PageFactory
        var loginWithPF = new LoginPage();
        boolean logoDisplayed = loginWithPF.homepageLogo.isDisplayed();
        if (logoDisplayed)
            System.out.println("Logo is displayed");
        else
            System.out.println("Logo is not displayed");


        tearDown();
    }
}
