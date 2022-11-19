package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage().
                setFirstName("Ivan").
                setLastName("Drago").
                setEmail("Drago@gmail.com").
                setGender("Male").
                setUserNumber("8505555555").
                setBDate("29", "February", "1988").
                setSubject("Math").
                setHobbies("Sports").
                uploadPicture("src/test/resources/ivan.jpeg").
                setAdress("Moscow, lenina st 25").
                setState("Uttar Pradesh").
                setCity("Agra").
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", "Ivan Drago").
                verifyResult("Student Email", "Drago@gmail.com").
                verifyResult("Gender", "Male").
                verifyResult("Mobile", "8505555555").
                verifyResult("Date of Birth", "29 February,1988").
                verifyResult("Subjects", "Maths").
                verifyResult("Hobbies", "Sports").
                verifyResult("Picture", "ivan.jpeg").
                verifyResult("Address", "Moscow, lenina st 25").
                verifyResult("State and City", "Uttar Pradesh Agra").
                clickClose();


    }
}
