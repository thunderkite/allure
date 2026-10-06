package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractionsPage extends BasePage {
    private final By source = By.id("draggable");
    private final By target = By.id("droppable");

    public InteractionsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Открыть страницу Droppable")
    public void openDroppable() {
        driver.get("https://demoqa.com/droppable");
    }

    @Step("Перетащить элемент в область назначения")
    public void dragAndDrop() {
        new Actions(driver).dragAndDrop(visible(source), visible(target)).perform();
    }

    public String targetText() {
        return visible(target).getText();
    }
}