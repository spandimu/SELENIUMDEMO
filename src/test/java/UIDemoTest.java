import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class UIDemoTest extends BaseClass{

    @Test
    public void Verify_propertiesTest() {
        Assert.assertEquals(webElementXpath("//div[@class='widget-title']").getText(),"CONTACT US");
        Assert.assertEquals(webElementLinkText("This is a link").getAttribute("href"),"http://www.seleniumframework.com/");
        Assert.assertEquals(webElementLinkText("This is a link").getText(),"This is a link");
    }

    @Test
    public void Verify_ContactUsForm_ClearTest() throws IOException {
        boolean btnSubmitCheck = webElementXpath("//a[@class='dt-btn dt-btn-m dt-btn-submit']").isDisplayed();

        if(btnSubmitCheck){
            setText(UIMapContactus.NAME_XPATH,ContactDataConstants.FIRST_NAME);
            setText(UIMapContactus.EMAIL_XPATH,ContactDataConstants.EMAIL);
            setText(UIMapContactus.PHONE_XPATH,ContactDataConstants.PHONE);
            setText(UIMapContactus.COUNTRY_XPATH,ContactDataConstants.COUNTRY);
            setText(UIMapContactus.COMPANY_XPATH,ContactDataConstants.COMPANY);
            setText(UIMapContactus.MESSAGE_XPATH,ContactDataConstants.MESSAGE);

            Assert.assertEquals(webElementXpath(UIMapContactus.NAME_XPATH).getAttribute("value"),ContactDataConstants.FIRST_NAME);
            Assert.assertEquals(webElementXpath(UIMapContactus.EMAIL_XPATH).getAttribute("value"),ContactDataConstants.EMAIL);
            Assert.assertEquals(webElementXpath(UIMapContactus.PHONE_XPATH).getAttribute("value"),ContactDataConstants.PHONE);
            Assert.assertEquals(webElementXpath(UIMapContactus.COUNTRY_XPATH).getAttribute("value"),ContactDataConstants.COUNTRY);
            Assert.assertEquals(webElementXpath(UIMapContactus.COMPANY_XPATH).getAttribute("value"),ContactDataConstants.COMPANY);
            Assert.assertEquals(webElementXpath(UIMapContactus.MESSAGE_XPATH).getAttribute("value"),ContactDataConstants.MESSAGE);

            webElementXpath(UIMapContactus.CLEAR_XPATH).click();

            Assert.assertEquals(webElementXpath(UIMapContactus.NAME_XPATH).getAttribute("value"),"");
            Assert.assertEquals(webElementXpath(UIMapContactus.EMAIL_XPATH).getAttribute("value"),"");
            Assert.assertEquals(webElementXpath(UIMapContactus.PHONE_XPATH).getAttribute("value"),"");
            Assert.assertEquals(webElementXpath(UIMapContactus.COUNTRY_XPATH).getAttribute("value"),"");
            Assert.assertEquals(webElementXpath(UIMapContactus.COMPANY_XPATH).getAttribute("value"),"");
            Assert.assertEquals(webElementXpath(UIMapContactus.MESSAGE_XPATH).getAttribute("value"),"");

        }

    }

}
