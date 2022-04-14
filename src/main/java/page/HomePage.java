package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By btnUploadFile = By.xpath("//input[@type='file']");
    private By optionCountryUSA = By.xpath("//option[text()='USA']");
    private By optionCountryJapan = By.xpath("//option[text()='Japan']");
    private By optionCountryGermany = By.xpath("//option[text()='Germany']");
    private By btnMoveToRight = By.xpath("//input[@value='->']");
    private By btnMoveToLeft = By.xpath("//input[@value='<-']");
    private By leftTable = By.xpath("//select[@name='FromLB']");
    private By rightTable = By.xpath("//select[@name='ToLB']");
    private By btnSubmit = By.xpath("//input[@id='submitButton']");
    private By timeLeft = By.xpath("//div[@id='timeLeft']");
    private By btnGetConfirmation = By.xpath("//button[text()='Get Confirmation']");

    public HomePage uploadFile(String path) {
        driver.findElement(btnUploadFile).sendKeys(path);
        return this;
    }

    public String getFileNameUploaded() {
        return driver.findElement(btnUploadFile).getAttribute("value");
    }

    public HomePage moveCountryFromLeftToRight(String countryName) {
        By country = By.xpath("//option[text()='" + countryName + "']");
        driver.findElement(country).click();
        driver.findElement(btnMoveToRight).click();
        return this;
    }

    public HomePage moveCountryFromRightToLeft(String countryName) {
        By country = By.xpath("//option[text()='" + countryName + "']");
        driver.findElement(country).click();
        driver.findElement(btnMoveToLeft).click();
        return this;
    }

    public String getCountryNameInLeftTable() {
        return driver.findElement(leftTable).getText();
    }

    public String getCountryNameInRightTable() {
        return driver.findElement(rightTable).getText();
    }

    public HomePage clickSubmitButton() {
        driver.findElement(btnSubmit).click();
        return this;
    }

    public String getTimeLeft() {
        return driver.findElement(timeLeft).getText();
    }

    public HomePage clickGetConfirmationButton() {
        driver.findElement(btnGetConfirmation).click();
        driver.switchTo().alert().dismiss();
        return this;
    }

    public HomePage clickCancelGetConfirmationPopup() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        //driver.switchTo().alert().dismiss();
        return this;
    }

}
