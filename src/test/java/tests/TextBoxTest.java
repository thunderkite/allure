package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

@Epic("Elements")
@Feature("Text Box")
@Owner("Студент")
@Story("Работа с текстовой формой")
public class TextBoxTest extends BaseTest {
    @Test(description = "Позитив: валидные данные отображаются в результате")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSubmitValidData() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "ivan.petrov@example.com", "Current", "Permanent");
        Assert.assertTrue(page.isOutputVisible(), "Блок результата не отображается");
    }

    @Test(description = "Негатив: невалидный email не проходит HTML-валидацию")
    @Severity(SeverityLevel.NORMAL)
    public void shouldRejectInvalidEmail() {
        TextBoxPage page = new TextBoxPage(driver, wait);
        page.open();
        page.fill("Ivan Petrov", "not-an-email", "Current", "Permanent");
        Assert.assertFalse(driver.findElement(By.id("userEmail")).getAttribute("validationMessage").isBlank(), "Браузер не сообщил о невалидном email");
    }
}