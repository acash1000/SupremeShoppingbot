package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/alexdudin/Desktop/chromedriver");
        WebDriver obj = new ChromeDriver();
        obj.get("https://www.supremenewyork.com/shop/all/t-shirts");
        WebDriverWait wait=new WebDriverWait(obj, 20);
//        WebElement location = obj.findElement(By.xpath("//*[@id=\"nav-categories\"]/li[9]/a"));
        Actions action = new Actions(obj);
//        action.click(location);
//        action.perform();
        wait.until(ExpectedConditions.urlToBe("https://www.supremenewyork.com/shop/all/t-shirts"));
        boolean refresh = false;
      do {
          try {

              refresh = obj.findElement(By.partialLinkText("Box")).isDisplayed();
          } catch (Exception e) {
              obj.navigate().refresh();
          }
      }while (refresh == false);
      WebElement shirt = obj.findElement(By.partialLinkText("Box"));
        action.click(shirt);
        action.perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/form/fieldset[2]/input")));
        WebElement cart =  obj.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/fieldset[2]/input"));
        action.click(cart);
        action.perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/a[2]")));
        WebElement checkout = obj.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/a[2]"));
        action.click(checkout);
        action.perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart-address\"]/fieldset/div[1]")));
        WebElement name = obj.findElement(By.xpath("//*[@id=\"cart-address\"]/fieldset/div[1]"));
        action.click(name);
        action.perform();
        action.sendKeys("name");
        action.perform();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart-address\"]/fieldset/div[2]")));
        WebElement email = obj.findElement(By.xpath("//*[@id=\"cart-address\"]/fieldset/div[2]"));
        action.click(email);
        action.perform();
        action.sendKeys("email");
        action.perform();
        WebElement tel = obj.findElement(By.xpath("//*[@id=\"cart-address\"]/fieldset/div[3]"));
        action.click(tel);
        action.perform();
        action.sendKeys("number");
        action.perform();
        WebElement address = obj.findElement(By.xpath("//*[@id=\"address_row\"]/div[1]"));
        action.click(address);
        action.perform();
        action.sendKeys("adress");
        action.perform();
        WebElement unit = obj.findElement(By.xpath("//*[@id=\"address_row\"]/div[2]"));
        action.click(unit);
        action.perform();
        action.sendKeys("unit");
        action.perform();
        WebElement zip = obj.findElement(By.xpath("//*[@id=\"zip_city_state_row\"]/div[1]"));
        action.click(zip);
        action.perform();
        action.sendKeys("zip");
        action.perform();
        WebElement city = obj.findElement(By.xpath("//*[@id=\"zip_city_state_row\"]/div[2]"));
        action.click(city);
        action.perform();
        action.sendKeys("city");
        action.perform();
        WebElement card = obj.findElement(By.xpath("//*[@id=\"card_details\"]/div[2]"));
        action.click(card);
        action.perform();
        action.sendKeys("xxxx xxxx xxxx xxxx");
        action.perform();
        WebElement cv = obj.findElement(By.xpath("//*[@id=\"rmae\"]"));
        action.click(cv);
        action.perform();
        action.sendKeys("security");
        action.perform();
        Select slec = new Select(obj.findElement(By.id("credit_card_month")));
        slec.selectByValue("month");
        slec = new Select(obj.findElement(By.id("credit_card_year")));
        slec.selectByValue("year");
        WebElement agree = obj.findElement(By.xpath("//*[@id=\"cart-cc\"]/fieldset/p[2]/label/div"));
        action.click(agree);
        action.perform();
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement done = obj.findElement(By.xpath("//*[@id=\"pay\"]/input"));
        action.click(done);
        action.perform();
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){

        }
//         obj.close();
    }

    public static void getnum(WebDriver obj){
        Actions action = new Actions(obj);
        WebElement res = null;
        List<WebElement> all = obj.findElements(By.xpath("//*[@id=\"container\"]"));
        for(int i = 0 ; i< all.size();i++){
            System.out.println(all.get(i).getCssValue("class"));
        }

    }
}
