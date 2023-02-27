package com.juaracoding.selenium14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Tugas14 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String year = "2023";
        String month = "February";
        String day = "02";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = ("https://formy-project.herokuapp.com/form");
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        //Locator
        driver.findElement(By.id("first-name")).sendKeys("Syarifah");
        System.out.println("Berhasil Input Nama Depan");
        driver.findElement(By.id("last-name")).sendKeys("Atiyah");
        System.out.println("Berhasil Input Nama Belakang");
        driver.findElement(By.id("job-title")).sendKeys("Programmer");
        System.out.println("Berhasil Input Job");

        //RadioButton
        driver.findElement(By.xpath("//*[@id='radio-button-2']")).click();
        System.out.println("Klik College");

        //CheckBox
        driver.findElement(By.xpath("//*[@id='checkbox-2']")).click();
        System.out.println("Klik Female");

        //SelectOption
        WebElement selectExpirience = driver.findElement(By.xpath("//*[@id='select-menu']"));
        Select expirience = new Select(selectExpirience);
        expirience.selectByValue("2");
        expirience.selectByIndex(2);
        expirience.deselectByVisibleText("2-4");
        System.out.println("Select 2-4 year");

        //Date
        driver.findElement(By.xpath("//*[@id='datepicker']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[5]/td[contains(text(), "+day+")]")).click();

        System.out.println("Berhasil Input Tanggal");

        //scroll by pixel vertical
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Data Berhasil Disimpan");


        System.out.println("Delay 5 Detik");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Quit Browser");
    }
}