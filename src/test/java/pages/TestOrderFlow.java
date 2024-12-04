package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestOrderFlow {
    private WebDriver driver;
    private OrderPage orderPage;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String metro;
    private String date;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Иван", "иванов", "ул. Пушкина, д. 1", "Калужская", "88008088080", "12.11.24"},
                {"Петр", "петров", "Невский пр., д. 2", "Октябрьская", "88008080808", "24.11.24"}
        });
    }

    public TestOrderFlow(String name, String surname, String address, String metro, String phone, String date) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPage = new OrderPage(driver);
    }

    @Test
    public void testOrderFlow() {
        orderPage.clickOrder();
        orderPage.fillOrderForm(name, surname, address, metro, phone);
        orderPage.submitOrder(date);
        Assert.assertTrue("появилась кнопка проверить статус заказа", orderPage.orderSuccess());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
