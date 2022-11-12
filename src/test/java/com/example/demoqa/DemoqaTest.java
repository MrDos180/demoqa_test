package com.example.demoqa;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        //Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $x("//input[@id='firstName']").setValue("Ivan");
        $x("//input[@id='lastName']").setValue("Drago");
        $x("//input[@id='userEmail']").setValue("Drago@gmail.com");
        $x("//label[text()='Male']").click();
        $x("//input[@id='userNumber']").setValue("8505555555");
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__month-select']").click();
        $x("//option[text()='February']").click();
        $x("//select[@class='react-datepicker__year-select']").click();
        $x("//option[text()='1988']").click();
        $x("//div[@aria-label='Choose Monday, February 29th, 1988']").click();
        $x("//input[@id='subjectsInput']").setValue("subjects");
        $x("//label[text()='Sports']").click();
        $x("//label[text()='Reading']").click();
        $x("//label[text()='Music']").click();
        $x("//input[@id='uploadPicture']").uploadFile(new File("src/test/data/ivan.jpeg"));
        $x("//textarea[@id='currentAddress']").setValue("Moscow, lenina st 25");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $x("//div[text()='Select State']").scrollIntoView(true).click();
        $x("//div[text()='Uttar Pradesh']").click();
        $x("//div[text()='Select City']").click();
        $x("//div[text()='Agra']").click();
        executeJavaScript("arguments[0].click();",$x("//button[@id='submit']"));

        $x("//div[text()='Thanks for submitting the form']").shouldBe(Condition.visible);

        $$x("//table[@class='table table-dark table-striped table-bordered table-hover']").shouldHave(CollectionCondition.texts(
                "Label Values\n" +
                        "Student Name Ivan Drago\n" +
                        "Student Email Drago@gmail.com\n" +
                        "Gender Male\n" +
                        "Mobile 8505555555\n" +
                        "Date of Birth 29 February,1988\n" +
                        "Subjects\n" +
                        "Hobbies Sports, Reading, Music\n" +
                        "Picture ivan.jpeg\n" +
                        "Address Moscow, lenina st 25\n" +
                        "State and City Uttar Pradesh Agra"
        ));



















    }
}
