package biocept.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import biocept.qa.base.BioceptBase;
import biocept.qa.utill.ExplicitWait;

public class UploadAccessionImages extends BioceptBase {
	ExplicitWait explicitWait = new ExplicitWait();
	@FindBy(tagName = "h2")
	WebElement title;

	@FindBy(id = "txtbxAccession")
	WebElement enterAccessionNumber;

	@FindBy(css = "select[data-bind*='folderSelected']")
	WebElement foldername;

	@FindBy(css = "input[name='files[]']")
	WebElement addFiles;

	public UploadAccessionImages() {
		PageFactory.initElements(Driver(), this);
	}

	public String title() {
		return title.getText();
	}

	public void enterAccessionNumber(String AccessionID) {
		enterAccessionNumber.sendKeys(AccessionID);

	}

	public void enumerationImages() throws InterruptedException {

		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilElementToBeVisible(foldername);
		// foldername.click();
		explicitWait.invisibilityOfLoader();
		Select folderName = new Select(foldername);
		folderName.selectByValue("enumeration-images");

		addFiles.sendKeys(System.getProperty("user.dir") + "/src/main/java/biocept/qa/testdata/CTC.jpg");

	}

	public void fishImages() {

		explicitWait.invisibilityOfLoader();
		explicitWait.waitUntilElementToBeVisible(foldername);
		// foldername.click();
		explicitWait.invisibilityOfLoader();
		Select folderName = new Select(foldername);
		folderName.selectByValue("fish-images");
		addFiles.sendKeys(System.getProperty("user.dir") + "/src/main/java/biocept/qa/testdata/CTC.jpg");

	}
}
