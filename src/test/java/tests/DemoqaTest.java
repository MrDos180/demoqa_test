package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;

import static io.qameta.allure.Allure.step;


public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fillFormTest() {
        step("Открываем сраницу",()->{
            registrationPage.openPage();
        });
        step("Вводим имя",()->{
            registrationPage.setFirstName(testData.firstName);
        });
        step("Вводим фамилию",()->{
            registrationPage.setLastName(testData.lastName);
        });
        step("Вводим email",()->{
            registrationPage.setEmail(testData.email);
        });
        step("Выбираем пол",()->{
            registrationPage.setGender(testData.gender);
        });
        step("Вводим номер",()->{
            registrationPage.setUserNumber(testData.number);
        });
        step("Вводим дату рождения",()->{
            registrationPage.setBDate(testData.dayBirth, testData.monthBirth, testData.yearBirth);
        });
        step("Вводим темы",()->{
            registrationPage.setSubject(testData.subject);
        });
        step("Выбираем хобби",()->{
            registrationPage.setHobbies(testData.hobbie);
        });
        step("Загружаем фотографию",()->{
            registrationPage.uploadPicture(testData.pictureDirectory);
        });
        step("Вводим адрес",()->{
            registrationPage.setAdress(testData.adress);
        });
        step("Выбираем штат",()->{
            registrationPage.setState(testData.state);
        });
        step("Выбираем город",()->{
            registrationPage.setCity(testData.city);
        });
        step("Нажимаем кнопку submit",()->{
            registrationPage.clickSubmit();
        });
        step("Провеверям что данные верны",()->{
            registrationPage.verifyResultsModalAppears().
                    verifyResult("Student Name", testData.firstName+" "+ testData.lastName).
                    verifyResult("Student Email", testData.email).
                    verifyResult("Gender", testData.gender).
                    verifyResult("Mobile", testData.number).
                    verifyResult("Date of Birth", testData.dayBirth+" "+ testData.monthBirth+","+testData.yearBirth).
                    verifyResult("Subjects", testData.subject).
                    verifyResult("Hobbies", testData.hobbie).
                    verifyResult("Picture", testData.pictureDirectory.replaceAll("src/test/resources/","")).
                    verifyResult("Address", testData.adress).
                    verifyResult("State and City", testData.state+ " "+testData.city);
        });
        step("Надимаем кнопка close",()->{
            registrationPage.clickClose();;
        });


    }
}
