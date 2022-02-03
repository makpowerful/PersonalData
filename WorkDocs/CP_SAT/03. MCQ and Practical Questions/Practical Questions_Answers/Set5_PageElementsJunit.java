package cpsatExamJunit;

public interface Set5_PageElementsJunit {
	// Question 5
	String elucidminusrdibtn_id = "gwt-uid-7";
	String firstnumberfield_xpath = "//*[contains(text(),'first number')]//following::input[1]";
	String secondnumberfield_Xpath = "//*[contains(text(),'second number')]//following::input[1]";
	String calculatebtn_xpath = "//button[contains(@id,'calculator')]";
	String generatedfield_xpath = "//input[contains(@id,'nameField3')]";
	
	// Question 3
	String mainheader_xpath = "//*[contains(@class,'logo_contianer')]";
	String footercontent_xpath = "//nav[@class='center']/ul/li/span";
	String twittericon_xpath = "(//a[contains(@href,'twitter')])[2]";
	String contactusicon_xpath = "(//a[contains(@href,'contact')])[2]";
	String drpdwnmenu_xpath = "((//div[contains(@class,'social')]//following::ul)[2]//li[contains(@class,'dropdown')]//a[1])[1]";
	String firstdrpdwnoptn_xpath = "((//div[contains(@class,'social')]//following::ul)[2]//li[contains(@class,'dropdown')]//a[1])[2]";
	String secnddrpdwnoptn_xpath = "((//div[contains(@class,'social')]//following::ul)[2]//li[contains(@class,'dropdown')]//a[1])[3]";
	String leadingSAFeheader_xpath = "(//div[contains(text(),'Leading SAFe')])[1]";
	String SAFeDevopsheader_xpath = "(//div[contains(text(),'DevOps')])[1]";

    //Question4
	String searchinptfiels_xpath = "(//form[contains(@class,'search')]//input)[2]";
	String searchresults_xpath = "//h4[contains(text(),'Movie')]//following::div";
	String moviegenre_xpath = "//span[contains(@class,'movie-genres')]//a";
	String mpaaRating_xpath = "//span[contains(text(),'MPAA')]";
	String castcrewtab_xpath = "//a[contains(@href,'cast')]";
	String directorname_xpath = "//h2[contains(text(),'Director')]//following::dt//a[1]";
	String alpacinocastrole_xpath = "(//a[contains(text(),'Al Pacino')]//following::div)[1]";
	
}
