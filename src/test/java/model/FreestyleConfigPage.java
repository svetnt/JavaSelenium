package model;

import model.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FreestyleConfigPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit' and contains(text(), 'Save')]")
    private WebElement saveButton;

    @FindBy(name = "description")
    private WebElement descriptionTextarea;

    @FindBy(name = "githubProject")
    private WebElement githubProjectCheckbox;

    @FindBy(name = "_.projectUrlStr")
    private WebElement githubUrl;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    private WebElement applyButton;

    public FreestyleConfigPage(WebDriver driver) {
        super(driver);
    }

    public FreestylePage saveConfigAndGoToFreestyleProject() {
        saveButton.click();

        return new FreestylePage(getDriver());
    }

    public ProjectPage saveConfigAndGoToProject() {
        saveButton.click();

        return new ProjectPage(getDriver());
    }

    public FreestyleConfigPage setDescription(String text) {
        descriptionTextarea.sendKeys(text);

        return this;
    }

    public String getDescription() {
        return descriptionTextarea.getText();
    }

    public FreestyleConfigPage clickGithubProjectCheckbox() {
        githubProjectCheckbox.click();

        return this;
    }

    public FreestyleConfigPage setGithubUrl(String text) {
        githubUrl.sendKeys(text);

        return this;
    }

    public String getGithubUrl() {
        return githubUrl.getAttribute("value");
    }

    public String getHelpNamesGeneral() {
        getActions().moveToElement(getDriver().findElement(By.xpath("//label[text()='Discard old builds']/../a"))).pause(500).build().perform();
        getActions().moveToElement(getDriver().findElement(By.xpath("//a[@tooltip='Help for feature: Discard old builds']"))).build().perform();

        return getWait20().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'tt']"))).getText();
    }

    public String getHelpNamesBuildTriggers() {
        getActions().moveToElement(getDriver().findElement(By.xpath("//a[@tooltip='Help for feature: Build periodically']"))).pause(500).build().perform();

        return getWait20().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id = 'tt']"))).getText();
    }

    public FreestyleConfigPage clickBuildTriggers() {
        getActions().moveToElement(getDriver().findElement(By.cssSelector(".tab.config-section-activator.config_build_triggers"))).pause(500).build().perform();

        return this;
    }

    public boolean clickApplyAndGetAlert() {
        applyButton.click();

        return getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.id("notification-bar"))).isDisplayed();
    }
}

