package model;

import model.base.BaseHeaderFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatedDomainPage extends BaseHeaderFooterPage {

    @FindBy(xpath = "//h1")
    private WebElement headerDomain;

    public CreatedDomainPage(WebDriver driver) {
        super(driver);
    }

    public String getDomainHeader(){

        return headerDomain.getText();
    }
}
