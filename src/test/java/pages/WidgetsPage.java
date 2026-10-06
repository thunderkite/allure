package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WidgetsPage extends BasePage {
    private final By slider = By.cssSelector("input[type='range']");
    private final By sliderValue = By.id("sliderValue");

    public WidgetsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Открыть страницу Slider")
    public void openSlider() {
        driver.get("https://demoqa.com/slider");
    }

    @Step("Установить значение слайдера")
    public void setSliderValue(String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", visible(slider), value);
    }

    public String sliderValue() {
        return visible(sliderValue).getDomProperty("value");
    }
}