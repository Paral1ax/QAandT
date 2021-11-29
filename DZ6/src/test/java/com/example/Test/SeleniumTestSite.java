package com.example.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SeleniumTestSite {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    //инициализация, введите свой путь к драйверу
    System.setProperty("webdriver.chrome.driver", "C:\\distrib\\selenium-java\\selenium-chrome-driver-4.jar");
    driver = new ChromeDriver();
    baseUrl = "https://ruswizard.su/test/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testRegistration() throws Exception {
    //тестовая регистрация, но так как я переделывал много раз, у меня кончились почты, и пришлось просто авторизоваться
    driver.get("https://ruswizard.su/test/wp-login.php?loggedout=true&wp_lang=ru_RU");
    driver.findElement(By.id("user_login")).clear();
    driver.findElement(By.id("user_login")).sendKeys("para");
    driver.findElement(By.id("user_pass")).click();
    driver.findElement(By.id("user_pass")).clear();
    driver.findElement(By.id("user_pass")).sendKeys("12345");
    driver.findElement(By.id("wp-submit")).click();
  }


  @Test
  public void testCreateNewPublicNote() throws Exception {
    //Тестовое добавление новой публичной записи
    driver.get("https://ruswizard.su/test/wp-admin/");
    driver.findElement(By.linkText("Добавить новую")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмена'])[1]/following::*[name()='svg'][1]")).click();
    driver.findElement(By.id("post-title-0")).click();
    driver.findElement(By.id("post-title-0")).clear();
    driver.findElement(By.id("post-title-0")).sendKeys("Редакция Заголовка");
    driver.findElement(By.id("id-1fd5nu-1")).click();
    //редакция заголовка
    //редакция записи
    //добавление абзаца
    //добавление цитаты
    //добавление метки
    //добавление ссылки
    //добавление картинки к записи
    driver.findElement(By.xpath("//div[@id='editor']/div[2]/div/div/div/div/div/div/div[2]/button")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить запись'])[1]/following::*[name()='svg'][2]")).click();
    driver.findElement(By.xpath("//button[@id='id-g8sh1k-2']/span")).click();
    driver.findElement(By.id("block-b0a3176b-0a1d-49f2-a56c-c93f12b15c5b")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить запись'])[1]/following::*[name()='svg'][2]")).click();
    //ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Список'])[1]/following::*[name()='svg'][3]")).click();
    driver.findElement(By.xpath("//blockquote[@id='block-1f3d71fe-66fa-4cfe-86a3-804f567dde4f']/div/p")).click();
    //ERROR: Caught exception [unknown command [editContent]]
    driver.findElement(By.cssSelector("div.interface-pinned-items > button.components-button.has-icon > svg > path")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[3]/div/div[2]/ul/li/button")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Постоянная ссылка'])[1]//*[name()='svg'][1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Постоянная ссылка'])[1]//*[name()='svg'][1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Метки'])[1]//*[name()='svg'][1]")).click();
    driver.findElement(By.id("components-form-token-input-0")).click();
    driver.findElement(By.id("components-form-token-input-0")).clear();
    driver.findElement(By.id("components-form-token-input-0")).sendKeys("новая метка");
    driver.findElement(By.id("components-form-token-input-0")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//blockquote[@id='block-1f3d71fe-66fa-4cfe-86a3-804f567dde4f']/div/p")).click();
    driver.findElement(By.cssSelector("#id-q68hr3-1 > svg > path")).click();
    driver.findElement(By.cssSelector("#id-ss6jks-16 > span.block-editor-block-types-list__item-icon > span.block-editor-block-icon.has-colors > svg > path")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[3]")).click();
    driver.findElement(By.xpath("//figure[@id='block-e786d244-4ec4-4d70-bae7-97aea1e360e3']/div/div[3]/div[2]/button")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Опубликовать'])[1]/following::*[name()='svg'][1]")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[3]/div/div[2]/ul/li/button")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Постоянная ссылка'])[1]//*[name()='svg'][1]")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div/div/div[2]/button[2]")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[4]/div[2]/div/div/div/div/button")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[4]/div[2]/div/div/div[2]/div/div[2]/div[2]/button")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
    driver.findElement(By.linkText("Просмотреть запись")).click();
  }

  @Test
  public void testCreateNewCommentAsAuthUser() throws Exception {
    //добавление комментария к записи будучи авторизованным пользователем
    driver.get("https://ruswizard.su/test/2021/11/28/%d1%80%d0%b5%d0%b4%d0%b0%d0%ba%d1%86%d0%b8%d1%8f-%d0%b7%d0%b0%d0%b3%d0%be%d0%bb%d0%be%d0%b2%d0%ba%d0%b0/");
    driver.findElement(By.id("comment")).click();
    driver.findElement(By.id("comment")).click();
    driver.findElement(By.id("comment")).clear();
    driver.findElement(By.id("comment")).sendKeys("its paral1ax, hello");
    driver.findElement(By.id("submit")).click();
  }

  @Test
  public void testCreateNewPrivateDeferredNote() throws Exception {
    //тестовое создание новой приватной записи с отложенной публикацией
    driver.get("https://ruswizard.su/test/2021/11/28/%d1%80%d0%b5%d0%b4%d0%b0%d0%ba%d1%86%d0%b8%d1%8f-%d0%b7%d0%b0%d0%b3%d0%be%d0%bb%d0%be%d0%b2%d0%ba%d0%b0/");
    driver.findElement(By.linkText("Запись")).click();
    driver.findElement(By.id("post-title-0")).clear();
    driver.findElement(By.id("post-title-0")).sendKeys("Это закрытая запись");
    driver.findElement(By.id("block-ad65d0eb-ebcc-44f6-997f-7e0b9a21fc6b")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[3]/div/div[2]/ul/li/button")).click();
    acceptNextAlert = true;
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[3]/div/div[3]/div/div/div/button")).click();
    driver.findElement(By.id("editor-post-private-0")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Вы хотите опубликовать запись как личную[\\s\\S]$"));
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div[2]/div[3]/div/div[3]/div/div[2]/div/button")).click();
    driver.findElement(By.name("minutes")).click();
    driver.findElement(By.name("minutes")).clear();
    driver.findElement(By.name("minutes")).sendKeys("28");
    driver.findElement(By.id("post-title-0")).click();
    driver.findElement(By.xpath("//div[@id='editor']/div/div/div/div/div[2]/button[2]")).click();
  }



  @Test
  public void testCheckDelayedNote() throws Exception {
    //проверка записи с отложенной публикацией
    driver.get("https://ruswizard.su/test/wp-admin/");
    driver.findElement(By.xpath("//li[@id='menu-posts']/a/div[3]")).click();
    driver.findElement(By.linkText("Это закрытая запись")).click();
    driver.findElement(By.linkText("Перейти")).click();
  }

  @Test
  public void testCheckComments() throws Exception {
    //проверка комментариев при нажатии на кнопку "1 комментарий"
    driver.get("https://ruswizard.su/test/wp-admin/edit.php?post_type=post");
    driver.findElement(By.linkText("Выйти")).click();
    driver.get("https://ruswizard.su/test/wp-admin/post.php?post=31112&action=edit");
    driver.findElement(By.linkText("← Перейти к Testing example")).click();
    driver.findElement(By.linkText("1 комментарий к записи Редакция Заголовка")).click();
  }

  @Test
  public void testCreateCommentAsUnAuth() throws Exception {
    //тестовое создание комментария будучи неавторизованным пользователем
    driver.get("https://ruswizard.su/test/");
    driver.findElement(By.linkText("Комментариев к записи My secret нет")).click();
    driver.findElement(By.id("comment")).click();
    driver.findElement(By.id("comment")).clear();
    //ввод комментария
    driver.findElement(By.id("comment")).sendKeys("hi");
    driver.findElement(By.id("author")).click();
    driver.findElement(By.id("author")).clear();
    //ввод ника
    driver.findElement(By.id("author")).sendKeys("ilya");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    //ввод имейла
    driver.findElement(By.id("email")).sendKeys("stayhigh78@mail.ru");
    driver.findElement(By.id("url")).click();
    driver.findElement(By.id("url")).clear();
    //ввод сайта
    driver.findElement(By.id("url")).sendKeys("vkontakte");
    driver.findElement(By.id("wp-comment-cookies-consent")).click();
    driver.findElement(By.id("submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
