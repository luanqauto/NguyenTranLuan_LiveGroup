package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestCases extends BaseTest {

    @Test
    public void Testcase1() {
        homePage.uploadFile("C:\\NguyenTranLuan_LiveGroup\\src\\main\\resources\\doc.docx");
        assertTrue(homePage.getFileNameUploaded().contains("doc.docx"), "Upload file is failed");
    }

    @Test
    public void Testcase2() {
        homePage.moveCountryFromLeftToRight("USA")
                .moveCountryFromLeftToRight("Japan")
                .moveCountryFromLeftToRight("Germany");
        assertTrue(homePage.getCountryNameInRightTable().contains("USA"), "Failed to move USA");
        assertTrue(homePage.getCountryNameInRightTable().contains("Japan"), "Failed to move Japan");
        assertTrue(homePage.getCountryNameInRightTable().contains("Germany"), "Failed to move Germany");
        homePage.moveCountryFromRightToLeft("USA");
        assertTrue(homePage.getCountryNameInLeftTable().contains("USA"), "Failed to move USA");
    }

    @Test
    public void Testcase3() {
        homePage.clickSubmitButton();
        assertEquals(homePage.getTimeLeft(), "Time Left: 20 seconds", "Check time left again!");
    }

    @Test
    public void Testcase4() {
        homePage.clickGetConfirmationButton().clickCancelGetConfirmationPopup();
    }
}
