package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.ProfileAndVisibility;

public class ProfileTests extends ApplicationManager {
    UserDTO user = UserDTO.builder()
            .email("aksiomamedved@gmail.com")
            .password("AlexMed123!")
            .build();
    ProfileAndVisibility profileAndVisibility;

    @BeforeMethod
    public void loginBeforeProfile() {
        HomePage homePage = new HomePage(getDriver());
        profileAndVisibility = homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .goToProfileAndVisibility();
    }

    @Test
    public void changeProfilePhotoPositiveTest(){
            profileAndVisibility.changeAvatar("qa_blue.jpg");
    }
}
