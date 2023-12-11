package com.feature.testcases;

import org.testng.annotations.Test;
import com.feature.pages.BaseClass;
import com.feature.utility.ExcelDataProvider;

public class FeatureTest extends BaseClass {

	
	ExcelDataProvider excelDP;

	@Test
	public void testCase1() throws Exception {
		
		excelDP = new ExcelDataProvider();
		
		pp.radioBtnClick();
		pp.openWin();
		pp.openTabs();
		pp.selectClassExample();
		pp.checkboxClick();
		pp.mulSelectClass();
		pp.autoSuggestion(excelDP.getStringValue(0, 0));
		pp.disableEnableText(excelDP.getIntegerValue(1, 0), excelDP.getIntegerValue(1, 1));
		pp.elementDisplayed(excelDP.getStringValue(2, 0), excelDP.getStringValue(2, 1));
		pp.switchToAlert(excelDP.getStringValue(0, 1));
		pp.hoverAndClick();
		pp.webtableElement();
		pp.iframes();
		
	}

}
