package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage extends BasePage {
    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By output = By.id("output");

    public TextBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Открыть страницу Text Box")
    public void open() {
        driver.get("https://demoqa.com/text-box");
        removeOverlays();
    }

    @Step("Заполнить форму Text Box")
    public void fill(String name, String email, String current, String permanent) {
        type(userName, name);
        type(userEmail, email);
        type(currentAddress, current);
        type(permanentAddress, permanent);
        click(submit);
    }

    public boolean isOutputVisible() {
        return visible(output).isDisplayed();
    }
}