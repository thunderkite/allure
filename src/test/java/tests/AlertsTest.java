package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

@Epic("Alerts, Frame & Windows")
@Feature("Alerts")
public class AlertsTest extends BaseTest {
    @Test(description = "Confirm: отмена отображает корректный результат")
    @Severity(SeverityLevel.MINOR)
    public void shouldDismissConfirm() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.dismissConfirm();
        Assert.assertTrue(page.confirmResult().toLowerCase().contains("cancel"), "Не найден результат отмены");
    }

    @Test(description = "Prompt: введённый текст отображается в результате")
    @Severity(SeverityLevel.NORMAL)
    public void shouldAcceptPromptWithText() {
        AlertsPage page = new AlertsPage(driver, wait);
        page.open();
        page.acceptPrompt("demo");
        Assert.assertTrue(page.promptResult().contains("demo"), "Введённый текст не отображается");
    }
}