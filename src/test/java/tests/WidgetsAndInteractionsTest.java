package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InteractionsPage;
import pages.WidgetsPage;

@Epic("Widgets and Interactions")
@Feature("Slider and Drag and Drop")
public class WidgetsAndInteractionsTest extends BaseTest {
    @Test(description = "Slider: значение изменяется на заданное")
    @Severity(SeverityLevel.NORMAL)
    public void shouldChangeSliderValue() {
        WidgetsPage page = new WidgetsPage(driver, wait);
        page.openSlider();
        page.setSliderValue("75");
        Assert.assertEquals(page.sliderValue(), "75", "Значение слайдера не изменилось");
    }

    @Test(description = "Drag and Drop: элемент перемещается в область назначения")
    @Severity(SeverityLevel.NORMAL)
    public void shouldDropElement() {
        InteractionsPage page = new InteractionsPage(driver, wait);
        page.openDroppable();
        page.dragAndDrop();
        Assert.assertEquals(page.targetText(), "Dropped!", "Элемент не был перемещён");
    }
}