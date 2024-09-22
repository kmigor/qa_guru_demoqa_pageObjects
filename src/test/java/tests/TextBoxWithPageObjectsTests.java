package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxWithPageObjectsTests extends TestBase{

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxWithFullDataTest() {
        String userName = "Rick Astley";
        String userEmail = "RickAstley@gmail.com";
        String currentAddress = "London, Great Britain";
        String permanentAddress = "Paris, France";

        textBoxPage.openPage()
                .removeBanner()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }

}
