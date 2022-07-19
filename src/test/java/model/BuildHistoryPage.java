package model;

import model.base.BaseBuildPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BuildHistoryPage extends BaseBuildPage {

    public BuildHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td/a[contains(@href, 'job/')][1]")
    private List<WebElement> listBuildHistory;


    @FindBy(xpath = "//table[@id='projectStatus']/tbody")
    private WebElement tableOfProjects;

    @FindBy(linkText = "Changes")
    private WebElement changesButton;

    @FindBy(linkText = "Console Output")
    private WebElement consoleButton;

    public List<String> collectListBuildHistory() {

        return listBuildHistory.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean checkProjectIsOnBoard(String projectName) {
        return tableOfProjects.getText().contains(projectName);
    }

    public BuildHistoryPage clickBuildSpanMenu(String projectName, String buildName) {
        getActions().moveToElement(getDriver().findElement(
                By.xpath("//a[@href='/job/" + projectName + "/" + buildName + "/']"))).perform();
        getDriver().findElement(By.id("menuSelector")).click();

        return this;
    }

    public BuildChangesPage clickChangesAndGoToChangesPage() {
        changesButton.click();

        return new BuildChangesPage(getDriver());
    }

    public BuildConsolePage clickConsoleAndGoToConsolePage() {
        consoleButton.click();

        return new BuildConsolePage(getDriver());
    }
}

