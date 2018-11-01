package com.primero.qa.util;

public class CommonUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	
	public static long IMPLICIT_WAIT=10;

}

//Adding comment in common util

//******************Wait conditions ***********************8
/*
//Wait for element
// wait for field

WebDriverWait wait = new WebDriverWait(driver, 90);
wait.until(ExpectedConditions.visibilityOf(element));


•Wait for page to get load
// Wait till page get loaded completely

static void waitForPageLoad(WebDriver wdriver) {
  WebDriverWait wait = new WebDriverWait(wdriver, 60);

    Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {

    @Override
    public boolean apply(WebDriver input) {
        return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
    }

  };
wait.until(pageLoaded);

}
*/

