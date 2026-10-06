package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends BasePage {
    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Открыть страницу Alerts")
    public void open() {
        driver.get("https://demoqa.com/alerts");
        removeOverlays();
    }

    @Step("Отклонить окно подтверждения")
    public void dismissConfirm() {
        click(confirmButton);
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    @Step("Ввести текст в prompt и подтвердить")
    public void acceptPrompt(String text) {
        click(promptButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    public String confirmResult() {
        return visible(confirmResult).getText();
    }

    public String promptResult() {
        return visible(promptResult).getText();
    }
}