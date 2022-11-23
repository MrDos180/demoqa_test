package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fillFormTest() {
        registrationPage.openPage().
                setFirstName(testData.firstName).
                setLastName(testData.lastName).
                setEmail(testData.email).
                setGender(testData.gender).
                setUserNumber(testData.number).
                setBDate(testData.dayBirth, testData.monthBirth, testData.yearBirth).
                setSubject(testData.subject).
                setHobbies(testData.hobbie).
                uploadPicture(testData.pictureDirectory).
                setAdress(testData.adress).
                setState(testData.state).
                setCity(testData.city).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", testData.firstName+" "+ testData.lastName).
                verifyResult("Student Email", testData.email).
                verifyResult("Gender", testData.gender).
                verifyResult("Mobile", testData.number).
                verifyResult("Date of Birth", testData.dayBirth+" "+ testData.monthBirth+","+testData.yearBirth).
                verifyResult("Subjects", testData.subject).
                verifyResult("Hobbies", testData.hobbie).
                verifyResult("Picture", testData.pictureDirectory.replaceAll("src/test/resources/","")).
                verifyResult("Address", testData.adress).
                verifyResult("State and City", testData.state+ " "+testData.city).
                clickClose();


    }
}
