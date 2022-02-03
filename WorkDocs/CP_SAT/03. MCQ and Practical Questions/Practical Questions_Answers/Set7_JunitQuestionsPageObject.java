package cpsatExamJunit;

public interface Set7_JunitQuestionsPageObject {
	//Question 1
	String brandheaderbtn_xpath = "//a[contains(@title,'BRANDS')]";
	String huatecurryimglnk_xpath = "(//div[contains(@class,'brand_logos')]//img)[1]";
	String huatecurryviewnowlnk_xpath = "(//div[contains(@class,'brand_logos')]//span)[1]";
	String startsomethingnewtxt_xpath = "//p[contains(text(),'start something new')]";
	String followusfooter_xpath = "//strong[contains(text(),'FOLLOW')]";
	String twittericonurl_xpath = "//li[contains(@class,'twitter')]//a";
	String twitterlogo_xpath = "//li[contains(@class,'twitter')]";
	//Question 2
	String imdbsearchbox_xpath = "//input[contains(@placeholder,'Search IMDb')]";
	String imdbmoviwresult_xpath = "((//table[contains(@class,'findList')])[1]//td[contains(@class,'result')]//a)[1]";
	String mpaarating_xpath = "(//h4[a[contains(text(),'MPAA')]]//following-sibling::span)[1]";
	String movieruntime_xpath = "(//h4[contains(text(),'time')]//following-sibling::time)[1]";
	String moviegenres_xpath = "//h4[contains(text(),'Genres')]//following-sibling::a";
	String userreviewsection_xpath = "//h2[contains(text(),'Reviews')]";
	String reviewername_xpath = "//div[contains(@class,'comment')]//following::span//a//span";
	//Question 3
	String firstcrysearchbox_xpath = "//form[input[contains(@id,'search_box')]]";
	String firstcrysearchbox1_xpath = "//form[input[contains(@id,'search_box')]]";
	String firstcrysearchbtn_xpath = "//span[contains(@class,'search-button')]";
	String sortdrpdown_xpath = "(//div[contains(@class,'select')]//div)[1]";
	String pricesortoption_xpath = "(//li[contains(@data-val,'Price')]/a)[1]";
	String productprice_xpath = "(//div[contains(@class,'rupee')]//a)";
	String popup_xpath = "//div[contains(@id,'notification-close')]";
}
