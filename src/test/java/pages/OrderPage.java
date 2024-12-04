package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By buttonOrder = By.className("Button_Button__ra12g");
    private By inputName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private By inputSurname = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private By inputAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private By inputMetro = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    private By inputPhone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private By buttonNext = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    private By inputDate = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input");
    private By timeOfOrder = By.className("Dropdown-placeholder");
    private By selectTime = By.className("Dropdown-option");
    private By submitOrder = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    private By checkStatus = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    private By successOrder = By.className("Order_Modal__YZ-d3");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrder() {
        driver.findElement(buttonOrder).click();
    }

    public void fillOrderForm(String name, String surname, String address, String metro, String phone) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputSurname).sendKeys(surname);
        driver.findElement(inputAddress).sendKeys(address);
        driver.findElement(inputMetro).sendKeys(metro);
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void submitOrder(String date) {
        driver.findElement(buttonNext).click();
        driver.findElement(inputDate).sendKeys(date);
        driver.findElement(timeOfOrder).click();
        driver.findElement(selectTime).click();
        driver.findElement(submitOrder).click();
        driver.findElement(checkStatus).click();
    }
    public boolean orderSuccess() {
        driver.findElement(successOrder);
        return true;
    }
}

