package cpsatExamTestNG;

public interface Set7_TestNGQuestionsPageObject {
//Question 5
	String peopleheader_xpath = "//a[contains(@href,'people')]";
	String firstreviewerreviews_xpath = "(//td[contains(@class,'person')]//a[contains(text(),'reviews')])[1]";
	String reviewersnamelist_xpath = "(//td[contains(@class,'person')]//following::h3)";

//Question 6
	String derivativeoption_xpath = "(//div[contains(@class,'tabs')]//a[contains(text(),'Derivatives')])[1]";
	String currencyderivative_xpath = "(//div[contains(@class,'tabs')]//a[contains(text(),'Currency Derivatives')])[1]";
	String currencyderivativesearchbox_xpath = "(//input[contains(@placeholder,'Search')])[1]";
	String currencytext_xpath = "//p[text()='U S Dollar - Indian Rupee']";
}
