package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormWithPageObjectTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationWithFullDataTest() {

        String firstName = "Rick";
        String lastName = "Astley";
        String userEmail = "RickAstley@gmail.com";
        String gender = "Male";
        String phoneNumber = "1234567890";
        String dayOfBirth = "30";
        String monthOfBirth = "July";
        String yearOfBirth = "1991";
        String[] subjects = {"Maths"};
        String[] hobbies = {"Sports"};
        String pictureName = "rick.jpg";
        String currentAddress = "London, Great Britain";
        String state = "NCR";
        String city = "Noida";

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth",dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjects[0])
                .checkResult("Hobbies", hobbies[0])
                .checkResult("Picture", pictureName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationWithRequiredFieldsTest() {
        String firstName = "Rick";
        String lastName = "Astley";
        String gender = "Male";
        String phoneNumber = "1234567890";

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit();

        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .clickSubmit();

        registrationPage.negativeCheck();
    }
}
