package sis.pcm.pageobjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import sis.pcm.stepdefinitions.baseclass;
import sis.pcm.utilities.Formulas;
import sis.pcm.utilities.ReadConfig;

public class pcm_pom extends baseclass {

	public WebDriver ldriver;
	ReadConfig rd;
	Formulas formulas;

	public pcm_pom(WebDriver rdriver) throws IOException {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		logger = Logger.getLogger(getClass());

		common = new common_pom(ldriver);

		rd = new ReadConfig();

		formulas = new Formulas();

		ProjectGroupValue = rd.getXl_ProjectGroup();

		FundingTypeValue = rd.getXl_Fundingtype();

		FundingSourceValue = rd.getXl_Fundingsource();

		ProjectManagerNameValue = rd.getXl_Projectmanagername();

		BudgetLines = rd.getXl_Bugdgetlines();

		RetainageValue = rd.getXl_Retainage();

		ConstructionContracts = rd.getXl_ContructionContract();

		SubContracts = rd.getXl_SubContract();

		SpecialityValue = rd.getXl_Speciality();

		VendorAccountValue = rd.getXl_VendorAccount();

		ProjectID_Journal = rd.getXlProjectID_Journal();

		// UpdateContracts = rd.getXl_UpdateContract();

		// ================================================Monica========================================================//

		HourJournals = rd.getXl_HourJournals();
		ItemName = rd.getXlItemName_Journal();
		ItemJournals = rd.getXl_ItemJournals();
		ExpenseJournals = rd.getXl_ExpenseJournals();
		RuleId = rd.getXlRuleID_Journal();

		// =======================Execute Revenue recognition using
		// PFO============================

		FiscalYear_RefreshProjFinData = rd.getXlFiscalYear_RefreshProjFinancialData();

		EndDate_RefreshProjFinData = rd.getXlEndDate_RefreshProjFinancialData();

		// ===============Added by Monica(21-02-2023)======================
		// ==========Release and cancel retainage amount========================
		RetainagePercentage1_ConstructionContract = rd.getXlRetainagePercentage1_ConstructionContract();
		RetainagePercentage2_ConstructionContract = rd.getXlRetainagePercentage2_ConstructionContract();

		UpdateECACData = rd.getXl_ECAC();

		TaskSummary_Expected = new HashMap<String, ArrayList<ArrayList<String>>>();

		changeOrderId = new HashMap<String, String>();

		// 17th scenario

		HourJournals_Period2 = rd.getXl_HourJournalsForPeriod2();
		ItemJournals_Period2 = rd.getXl_ItemJournalsForPeriod2();
		ExpenseJournals_Period2 = rd.getXl_ExpenseJournalsForPeriod2();

		// arthi

		TaskSummary_Expected = new HashMap<String, ArrayList<ArrayList<String>>>();
		SubContractCommittedCost_Expected = new HashMap<String, ArrayList<ArrayList<String>>>();
		PurchaseOrder_Expected = new HashMap<String, ArrayList<ArrayList<String>>>();

		CustomerPaymentName = rd.getXl_CustomerPaymentName();
		OffsetAccountType = rd.getXl_OffsetAccountType();
		OffsetAccount = rd.getXl_OffsetAccount();

		BudgetTotalsData = new HashMap<String, String>();

		UpdateContracts1 = rd.getXl_UpdateContract1();

		// UpdateContracts2 = rd.getXl_UpdateContract2();

		BudgetAmount_ExcludeRevRec = new HashMap<String, String>();

		Budget_RevenueBudget = new HashMap<String, String>();

		Budget_CostBudget = new HashMap<String, String>();

		// Test Data

		ProjectID_TestData = rd.getProjectID_TestData();

		JournalProjectID_TestData = rd.getJournal_TestData();

		PercentCompletePeriod2_Journal = rd.getXlPercentCompletePeriod2_Journal();

		PercentComplete3 = rd.getXl_PercentComplete3();

		UpdateContracts3 = rd.getXl_UpdateContract2();

		Name_SubcontractPaymentRelease = rd.getXlName_SubcontractPaymentRelease_Journal();

		OffSetAccountType_SubcontractPaymentRelease = rd.getXlOffSetAccountType_SubcontractPaymentRelease_Journal();

		OffSetAccount_SubcontractPaymentRelease = rd.getXlOffSetAccount_SubcontractPaymentRelease_Journal();

		JournalsAmount_AllTransactions = new HashMap<String, String>();

		ComplianceItem_Data = new HashMap<String, ArrayList<String>>();

		ComplianceItem_VendorsMapping = new HashMap<String, HashMap<String, ArrayList<String>>>();

		Subcontract_Compliance = rd.getXl_Subcontract_Compliance();

		Subcontract_Compliance_add1 = rd.getXl_Subcontract_Compliance_add1();

		Subcontract_Compliance_add2 = rd.getXl_Subcontract_Compliance_add2();

		SubcontractCompliance_Valid = rd.getXl_SubcontractCompliance_Valid();

		SubcontractCompliance_Expired = rd.getXl_SubcontractCompliance_Expired();

		//VendorAgreements = rd.getXl_VendorAgreements();

		ExpectedNotificationMessage_VendorSubcontractCompliance = new ArrayList<String>();

		Subcontract_SubcontractNumberMapping = new HashMap<String, String>();
	}

	// ================================================Ram
	// Coding========================================================//

	@FindBy(xpath = "//*[normalize-space()='Expand all']")
	WebElement Expandall;

	public void clickExpandall() throws InterruptedException {

		common.clickElement(Expandall);
	}

	@FindBy(xpath = "//*[@aria-label='Expand the navigation pane']")
	WebElement Expandthenavigationpane;

	public void clickExpandthenavigationpane() throws InterruptedException {

		common.clickElement(Expandthenavigationpane);
	}

	@FindBy(xpath = "//*[text()='Modules']")
	WebElement Modules;

	public void clickModules() throws InterruptedException {

		Thread.sleep(3000);

		if (!common.isMenuExpanded(Modules)) {

			common.clickElement(Modules);

		}
	}

	@FindBy(xpath = "//a[normalize-space()='Project cost management']")
	WebElement Projectcostmanagement;

	public void clickProjectcostmanagement() throws InterruptedException {

		common.clickElement(Projectcostmanagement);
	}

	@FindBy(xpath = "//*[text()='Equipment usage']")
	WebElement Equipmentusage;

	@FindBy(xpath = "//*[text()='Equipment standard costs']")
	WebElement Equipmentstandardcosts;

	@FindBy(xpath = "//*[text()='Procurement and sourcing']")
	WebElement Procurementandsourcing;

	// ------------------Product information management sub module------------------
	@FindBy(xpath = "//*[text()='Released products']")
	WebElement Releasedproducts_Products;

	public void selectPrdInfMngmtSubModule(String arg1) throws InterruptedException {

		if (arg1.equals("Released products")) {

			common.clickElement(Releasedproducts_Products);
			Thread.sleep(3000);

		}
	}

	/*
	 * public void selectModule(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("Project cost management")) {
	 * 
	 * common.clickElement(Projectcostmanagement); }
	 * 
	 * // Added by Monica
	 * 
	 * if (arg1.equals("Procurement and Sourcing")) {
	 * 
	 * common.clickElement(Procurementandsourcing);
	 * 
	 * } if (arg1.equals("Product information management")) {
	 * 
	 * common.clickElement(Productinformationmanagement); Thread.sleep(3000);
	 * 
	 * } if (arg1.equals("Equipment usage")) {
	 * 
	 * common.clickElement(Equipmentusage);
	 * 
	 * }
	 * 
	 * }
	 */

	@FindBy(xpath = "//a[normalize-space()='Projects']")
	WebElement Projects;

	public void clickProjects() throws InterruptedException {

		if (!common.isMenuExpanded(Projects)) {

			common.clickElement(Projects);

		}
	}

	@FindBy(xpath = "//a[normalize-space()='All projects']")
	WebElement Allprojects;

	public void clickAllprojects() throws InterruptedException {

		common.clickElement(Allprojects);
	}

	@FindBy(xpath = "//*[text()='Product information management']")
	WebElement Productinformationmanagement;

	@FindBy(xpath = "//*[text()='Project allocation rules']")
	WebElement Projectallocationrules_PCMSubModule;

	/*
	 * public void selectSubModule(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("All projects")) {
	 * 
	 * common.clickElement(Allprojects); }
	 * 
	 * // Added by Monica
	 * 
	 * if (arg1.equals("Project allocation rules")) {
	 * 
	 * common.clickElement(Projectallocationrules_PCMSubModule);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public void clickModulesAndSubModules(String arg1, String arg2) throws
	 * InterruptedException
	 * 
	 * { if (arg2.equals("Project cost management")) {
	 * 
	 * common.clickElement(Projectcostmanagement);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("All projects")) {
	 * 
	 * common.clickElement(Allprojects);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Project allocation rules")) {
	 * 
	 * common.clickElement(Projectallocationrules_PCMSubModule);
	 * 
	 * Thread.sleep(2000); } }
	 * 
	 * if (arg2.equals("Equipment usage")) {
	 * 
	 * if (!common.isMenuExpanded(Equipmentusage)) {
	 * 
	 * common.clickElement(Equipmentusage); }
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("Equipment standard costs")) {
	 * 
	 * common.clickElement(Equipmentstandardcosts);
	 * 
	 * Thread.sleep(2000); } }
	 * 
	 * if (arg2.equals("Product information management")) {
	 * 
	 * common.clickElement(Productinformationmanagement);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("Released products")) {
	 * 
	 * common.clickElement(Releasedproducts_Products);
	 * 
	 * Thread.sleep(2000); } } }
	 */

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement New1;

	@FindBy(xpath = "(//span[normalize-space()='New'])[2]")
	WebElement New2;

	@FindBy(xpath = "(//span[normalize-space()='New'])[3]")
	WebElement New3;

	@FindBy(xpath = "(//span[normalize-space()='New'])[4]")
	WebElement New4;

	@FindBy(xpath = "(//span[normalize-space()='New'])[5]")
	WebElement New5;

	public void clickNew() throws InterruptedException {

		Thread.sleep(3000);

		try {

			common.clickElement(New1);

		}

		catch (Exception e1) {

			try {

				common.clickElement(New2);

			}

			catch (Exception e2) {

				try {

					common.clickElement(New3);

				}

				catch (Exception e3) {

					try {

						common.clickElement(New4);

					}

					catch (Exception e4) {

						common.clickElement(New5);
					}
				}

			}
		}

		Thread.sleep(2000);
	}

	@FindBy(xpath = "//*[contains(@id,'NewButtonProjLines')]//following::*[text()='New']")
	WebElement New_ConstructionConractLine;

	public void clickNewConstructionConractLine() throws InterruptedException {

		Thread.sleep(5000);

		common.clickElement(New_ConstructionConractLine);
	}

	@FindBy(xpath = "(//*[text()='New subcontract']//following::*[text()='New'])[1]")
	WebElement New_Subcontract;

	public void clickNew_Subcontract() throws InterruptedException {

		common.clickElement(New_Subcontract);
	}

	@FindBy(xpath = "//*[contains(@id,'CommandButtonNew_label') and text()='New']")
	WebElement New_SubContractLine;

	public void clickNewSubConractLine() throws InterruptedException {

		common.clickElement(New_SubContractLine);
	}

	@FindBy(xpath = "//input[@name='projTable_Type']")
	WebElement Projecttype;

	public void clickProjecttype() throws InterruptedException {

		common.clickElement(Projecttype);
	}

	public void selectProjecttype(String value) throws InterruptedException {

		clickProjecttype();

		common.selectDropDownValue(value);

	}

	/*
	 * @FindBy(xpath = "//input[@name='CtrlProjId']") WebElement ProjectID;
	 * 
	 * public void setProjectID() throws InterruptedException {
	 * 
	 * ProjectIDValue = common.generateUniqueID("ProjectID");
	 * 
	 * common.setText(ProjectID, ProjectIDValue);
	 * 
	 * 
	 * 
	 * }
	 */

	@FindBy(xpath = "//input[@name='Name']")
	WebElement Projectname;

	public void setProjectName() throws InterruptedException {

		ProjectNameValue = common.generateUniqueID("ProjectName");

		common.setText(Projectname, ProjectNameValue);

	}

	@FindBy(xpath = "//input[@name='ProjTable_ProjGroupId']")
	WebElement Projectgroup;

	public void setProjectGroup() throws InterruptedException {

		common.setText(Projectgroup, ProjectGroupValue);

	}

	@FindBy(xpath = "//input[@aria-label='Project group']")
	WebElement Projectgroupvalue;

	public void selectProjectGroupValue() throws InterruptedException {

		common.clickElement(Projectgroupvalue);

	}

	@FindBy(xpath = "//button[@name='NewProjectContract']")
	WebElement ProjectcontractNew;

	public void clickProjectcontractNew() throws InterruptedException {

		common.clickElement(ProjectcontractNew);

	}

	@FindBy(xpath = "//input[@name='ProjInvoiceTable_Name']")
	WebElement Name;

	public void setName() throws InterruptedException {

		common.setText(Name, ProjectIDValue);

	}

	@FindBy(xpath = "//input[@name='ProjFundingSource_FundingType']")
	WebElement Fundingtype;

	public void setFundingtype() throws InterruptedException {

		common.clickElementJS(Fundingtype);

		common.selectDropDownValue(FundingTypeValue);

	}

	@FindBy(xpath = "//input[@name='ProjFundingSource_FundingSourceId']")
	WebElement Fundingsource;

	@FindBy(xpath = "//input[@name='ProjFundingSource_FundingSourceId']")
	WebElement Fundingsource_customeraccount;

	public void setFundingsource() throws InterruptedException {

		common.setText(Fundingsource, FundingSourceValue);

		common.clickElement(Fundingsource_customeraccount);

	}

	@FindBy(xpath = "//*[text()='OK']")
	WebElement OK;

	public void clickOK() throws InterruptedException {

		common.clickElementJS(OK);

	}

	@FindBy(xpath = "//input[@name='ProjInvoiceId']")
	WebElement ProjectcontractID;

	public void getProjectcontractID() throws InterruptedException {

		ProjectContractIDValue = common.getValue(ProjectcontractID);

	}

	@FindBy(xpath = "//input[@name='ProjTable_WorkerResponsible_DirPerson_FK_Name']")
	WebElement Projectmanager;

	@FindBy(xpath = "//input[contains(@id,'DirPerson_Name')]")
	WebElement Projectmanagername;

	public void setProjectManager() throws InterruptedException {

		Thread.sleep(5000);

		common.setText(Projectmanager, ProjectManagerNameValue);

		// common.clickElement(Projectmanagername);
	}

	@FindBy(xpath = "//span[normalize-space()='Create project']")
	WebElement Createproject;

	public void clickCreateproject() throws InterruptedException {

		common.clickElement(Createproject);

		Thread.sleep(30000);

	}

	@FindBy(xpath = "(//span[contains(@class,'appBar') and normalize-space()='Project'])[1]")
	WebElement Project1;

	@FindBy(xpath = "(//span[contains(@class,'appBar') and normalize-space()='Project'])[2]")
	WebElement Project2;

	public void clickProjectTab() throws InterruptedException {

		// Thread.sleep(3000);

		try {
			common.clickElementJS(Project1);
		}

		catch (Exception e) {
			common.clickElementJS(Project2);
		}

		Thread.sleep(20000);
	}

	@FindBy(xpath = "//span[normalize-space()='Projects']")
	WebElement Projects_PageHeader;

	public void clickProjectsHeader() throws InterruptedException {

		common.clickElement(Projects_PageHeader);

	}

	@FindBy(xpath = "(//label[text()='Maintain']//following::button[@name='CtrlStages'])")
	WebElement Projectstage_menu;

	@FindBy(xpath = "(//label[text()='Maintain']//following::button[@name='CtrlStages'])[2]")
	WebElement Projectstage_menu2;

	public void clickProjectstage_menu() throws InterruptedException {

		try {
			common.clickElementJS(Projectstage_menu);

		}

		catch (Exception e) {

			common.clickElementJS(Projectstage_menu2);

		}

	}

	@FindBy(xpath = "//span[normalize-space()='In process']")
	WebElement Inprocess;

	public void clickInprocess() throws InterruptedException {

		common.clickElement(Inprocess);

	}

	@FindBy(xpath = "//button[@name='Ok']")
	WebElement OK_UpdateProjectStatus;

	public void clickOK_UpdateProjectStatus() throws InterruptedException {

		common.clickElement(OK_UpdateProjectStatus);

	}

	@FindBy(xpath = "//input[@name='ProjStage_Stage']")
	WebElement Projectstage;

	public String getProjectstage() throws InterruptedException {

		Thread.sleep(3000);

		clickFastTab("General");

		Thread.sleep(10000);

		String ProjectStage = common.getValue(Projectstage);

		return ProjectStage;

	}

	public void checkProjectStage(String projectStage) throws InterruptedException {

		Assert.assertEquals(getProjectstage(), projectStage, "Project stage is not as expected");

	}

	@FindBy(xpath = "(//span[normalize-space()='Project cost management'])[1]//parent::button")
	WebElement Projectcostmanagement_PageHeader1;

	@FindBy(xpath = "(//span[normalize-space()='Project cost management'])[2]//parent::button")
	WebElement Projectcostmanagement_PageHeader2;

	@FindBy(xpath = "(//span[normalize-space()='Project cost management'])[3]//parent::button")
	WebElement Projectcostmanagement_PageHeader3;

	public void clickProjectcostmanagement_PageHeader() throws InterruptedException {

		try {
			common.clickElement(Projectcostmanagement_PageHeader1);
		} catch (Exception e1) {
			try {
				common.clickElement(Projectcostmanagement_PageHeader2);
			} catch (Exception e2) {
				common.clickElement(Projectcostmanagement_PageHeader3);
			}
		}

	}

	/*
	 * public void clickPageHeader(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("Project cost management")) {
	 * 
	 * clickProjectcostmanagement_PageHeader(); }
	 * 
	 * if (arg1.equals("Manage")) {
	 * 
	 * clickManage(); } }
	 */

	/*
	 * @FindBy(xpath = "(//*[text()='New budget'])") WebElement Newbudget;
	 * 
	 * @FindBy(xpath = "(//*[text()='New budget'])[2]") WebElement Newbudget2;
	 * 
	 * public void clickNewbudget() throws InterruptedException {
	 * 
	 * try { common.clickElement(Newbudget); }
	 * 
	 * catch (Exception e) { common.clickElement(Newbudget2); }
	 * 
	 * }
	 */

	@FindBy(xpath = "//button[normalize-space()='Budget lines']")
	WebElement Budgetlines;

	public void clickBudgetlines() throws InterruptedException {

		if (!common.isSectionExpanded(Budgetlines)) {

			common.clickElement(Budgetlines);

		}

	}

	@FindBy(xpath = "(//span[contains(@id,'Budget') and normalize-space()='New'])[2]")
	WebElement New_Budgetlines;

	public void clickNew_Budgetlines() throws InterruptedException {

		common.clickElement(New_Budgetlines);

	}

	@FindBy(xpath = "//input[@aria-label='Task code']")
	WebElement Taskcode;

	public void setTaskcode(String value) throws InterruptedException {

		common.setText(Taskcode, value);

	}

	@FindBy(xpath = "//input[@aria-label='Description']")
	WebElement Description;

	public void setDescription(String value) throws InterruptedException {

		common.setText(Description, value);

	}

	@FindBy(xpath = "//input[@aria-label='Budget category']")
	WebElement Budgetcategory;

	public void setBudgetcategory(String value) throws InterruptedException {

		common.setText(Budgetcategory, value);

	}

	@FindBy(xpath = "//input[@aria-label='Quantity']")
	WebElement Quantity;

	public void setQuantity(String value) throws InterruptedException {

		common.setText(Quantity, value);

	}

	@FindBy(xpath = "//input[@aria-label='Unit']")
	WebElement Unit;

	public void setUnit(String value) throws InterruptedException {

		common.setText(Unit, value);

	}

	@FindBy(xpath = "//input[@aria-label='Unit price']")
	WebElement Unitprice;

	public void setUnitprice(String value) throws InterruptedException {

		common.setText(Unitprice, value);

	}

	@FindBy(xpath = "//input[@aria-label='Line amount']")
	WebElement Lineamount;

	public void setLineamount(String value) throws InterruptedException {

		common.setText(Lineamount, value);

	}

	public String checkLineAmount(String Quantity, String UnitPrice, String LineAmount, int Row)
			throws InterruptedException {

		String LineAmountExpectedValue = formulas.getExpectedLineAmount(Quantity, UnitPrice);

		Assert.assertEquals(LineAmount, LineAmountExpectedValue,
				"Line amount value is not as expected for row number " + Row);

		return LineAmountExpectedValue;

	}

	/*
	 * public void setBudgetLines() throws InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * for (ArrayList<String> BudgetLine : BudgetLines) {
	 * 
	 * common.clickElement(New_Budgetlines);
	 * 
	 * String TaskcodeValue = BudgetLine.get(0);
	 * 
	 * String DescriptionValue = BudgetLine.get(1);
	 * 
	 * String BudgetcategoryValue = BudgetLine.get(2);
	 * 
	 * String QuantityValue = BudgetLine.get(3);
	 * 
	 * String UnitValue = BudgetLine.get(4);
	 * 
	 * String UnitPriceValue = BudgetLine.get(5);
	 * 
	 * // String LineAmountValue = BudgetLine.get(6);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Taskcode =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));
	 * 
	 * common.setText(Taskcode, TaskcodeValue);
	 * 
	 * if (!DescriptionValue.equals("")) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
	 * "]"));
	 * 
	 * common.setText(Description, DescriptionValue);
	 * 
	 * }
	 * 
	 * WebElement Budgetcategory = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Budget category'])[" + row + "]"));
	 * 
	 * common.setText(Budgetcategory, BudgetcategoryValue);
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * WebElement Quantity =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));
	 * 
	 * common.setTextAfterDelete(Quantity, QuantityValue);
	 * 
	 * }
	 * 
	 * if (!UnitValue.equals("")) {
	 * 
	 * WebElement Unit = ldriver.findElement(By.xpath("(//*[@aria-label='Unit'])[" +
	 * row + "]"));
	 * 
	 * common.setTextAfterDelete(Unit, UnitValue);
	 * 
	 * }
	 * 
	 * if (!UnitPriceValue.equals("")) {
	 * 
	 * WebElement UnitPrice =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Unit price'])[" + row +
	 * "]"));
	 * 
	 * common.setTextAfterDelete(UnitPrice, UnitPriceValue);
	 * 
	 * }
	 * 
	 * WebElement Lineamount =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Line amount'])[" + row +
	 * "]"));
	 * 
	 * String LineAmountValue = common.getValue(Lineamount);
	 * 
	 * checkLineAmount(QuantityValue, UnitPriceValue, LineAmountValue, row);
	 * 
	 * common.KeyboardAction("Tab");
	 * 
	 * row++;
	 * 
	 * } }
	 */

	public void setConstructionContract() throws InterruptedException {

		int row = 1;

		for (ArrayList<String> ConstructionContract : ConstructionContracts) {

			String DescriptionValue = ConstructionContract.get(0);

			// String BillingBasisValue = ConstructionContract.get(1);

			String ScheduledValue = ConstructionContract.get(1);

			if (row != 1) {

				clickNewConstructionConractLine();

			}

			Thread.sleep(3000);

			// WebElement Description =
			// ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
			// "]"));

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])"));

			common.setTextAfterClear(Description, DescriptionValue);

			/*
			 * WebElement BillingBasis =
			 * ldriver.findElement(By.xpath("(//*[@aria-label='Billing basis'])[" + row +
			 * "]"));
			 * 
			 * common.setTextAfterClear(BillingBasis, BillingBasisValue);
			 * 
			 * common.selectDropDownValue(BillingBasisValue);
			 */

			// WebElement Scheduledvalue =
			// ldriver.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + row +
			// "]"));

			WebElement Scheduledvalue = ldriver.findElement(By.xpath("(//*[@aria-label='Scheduled value'])"));

			common.setTextAfterDelete(Scheduledvalue, ScheduledValue);

			row++;

		}
	}

	@FindBy(xpath = "//button[normalize-space()='Totals']")
	WebElement Totals;

	public void clickTotals() throws InterruptedException {

		if (!common.isSectionExpanded(Totals)) {

			common.clickElement(Totals);

			Thread.sleep(3000);

		}

	}

	/*
	 * @FindBy(xpath = "//input[@name='GroupBudgetTotals_totalRevenueAmount']")
	 * WebElement RevenueBudget;
	 * 
	 * public String getRevenueBudget() throws InterruptedException {
	 * 
	 * String RevenueBudgetValue = common.getValue(RevenueBudget);
	 * 
	 * logger.info("RevenueBudgetValue:" + RevenueBudgetValue);
	 * 
	 * return RevenueBudgetValue;
	 * 
	 * }
	 * 
	 * @FindBy(xpath = "//input[@name='GroupBudgetTotals_totalSalesAmount']")
	 * WebElement Salesamount;
	 * 
	 * public String getSalesamount() throws InterruptedException {
	 * 
	 * SalesamountValue = common.getValue(Salesamount);
	 * 
	 * return SalesamountValue;
	 * 
	 * }
	 * 
	 * @FindBy(xpath = "//input[@name='GroupBudgetTotals_totalBudgetAmount']")
	 * WebElement CostBudget;
	 * 
	 * public String getCostBudget() throws InterruptedException {
	 * 
	 * String CostBudgetValue = common.getValue(CostBudget);
	 * 
	 * return CostBudgetValue;
	 * 
	 * }
	 * 
	 * @FindBy(xpath = "//input[@name='GroupBudgetTotals_profitMargin']") WebElement
	 * Profitmargin;
	 * 
	 * public String getProfitmargin() throws InterruptedException {
	 * 
	 * String ProfitmarginValue = common.getValue(Profitmargin);
	 * 
	 * return ProfitmarginValue;
	 * 
	 * }
	 */

	public void checkRevenueBudget() throws InterruptedException {

		RevenueBudgetValue_Expected = formulas.getExpectedRevenueBudget(BudgetLines, BudgetCategories_RevenueType);

		logger.info("RevenueBudgetValue_Expected: " + RevenueBudgetValue_Expected);

		Assert.assertEquals(getRevenueBudget(), RevenueBudgetValue_Expected, "Revenue Budget value is not as expected");

	}

	public void checkCostBudget() throws InterruptedException {

		CostBudgetValue_Expected = formulas.getExpectedCostBudget(BudgetLines, BudgetCategories_ExpenseType);

		logger.info("CostBudgetValue_Expected: " + CostBudgetValue_Expected);

		Assert.assertEquals(getCostBudget(), CostBudgetValue_Expected, "Cost Budget value is not as expected");

	}

	public void checkProfitMargin() throws InterruptedException {

		String ProfitMargin = getProfitmargin();

		ProfitmarginValue_Expected = formulas.getExpectedProfitMargin(RevenueBudgetValue_Expected,
				CostBudgetValue_Expected);

		logger.info("ProfitmarginValue_Expected: " + ProfitmarginValue_Expected);

		Assert.assertEquals(ProfitMargin, ProfitmarginValue_Expected, "Profit margin value is not as expected");

	}

	/*
	 * @FindBy(xpath = "(//span[normalize-space()='Save'])[1]") WebElement Save1;
	 * 
	 * @FindBy(xpath = "(//span[normalize-space()='Save'])[2]") WebElement Save2;
	 * 
	 * public void clickSave() throws InterruptedException {
	 * 
	 * try {
	 * 
	 * common.clickElement(Save1);
	 * 
	 * }
	 * 
	 * catch (Exception e) {
	 * 
	 * common.clickElement(Save2);
	 * 
	 * }
	 * 
	 * }
	 */
	@FindBy(xpath = "(//span[normalize-space()='Save'])")
	WebElement Save_Contract;

	public void clickSave_Contract() throws InterruptedException {

		common.clickElement(Save_Contract);

	}

	/*
	 * @FindBy(xpath = "//input[contains(@id,'BudgetStatus')]") WebElement
	 * Budgetstatus;
	 * 
	 * public String getBudgetStatus() throws InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * String BudgetStatus = common.getValue(Budgetstatus);
	 * 
	 * return BudgetStatus;
	 * 
	 * }
	 */

	@FindBy(xpath = "//button[normalize-space()='Project budget']")
	WebElement Projectbudget;

	public void clickProjectbudget() throws InterruptedException {

		common.clickElement(Projectbudget);

		Thread.sleep(3000);

	}

	/*
	 * @FindBy(xpath = "//span[normalize-space()='Submit']") WebElement Submit;
	 * 
	 * public void clickSubmit() throws InterruptedException {
	 * 
	 * common.clickElement(Submit);
	 * 
	 * }
	 * 
	 * @FindBy(xpath = "//span[normalize-space()='Approve']") WebElement Approve;
	 * 
	 * public void clickApprove() throws InterruptedException {
	 * 
	 * common.clickElement(Approve);
	 * 
	 * }
	 * 
	 * @FindBy(xpath = "//span[normalize-space()='Commit']") WebElement Commit;
	 * 
	 * public void clickCommit() throws InterruptedException {
	 * 
	 * common.clickElement(Commit);
	 * 
	 * }
	 */

	public void clickProjectBudgetStatus(String arg1) throws InterruptedException {

		if (arg1.equals("Submit")) {

			clickSubmit();
		}

		else if (arg1.equals("Approve")) {

			clickApprove();
		}

		else if (arg1.equals("Commit")) {

			clickCommit();
		}
	}

	public void checkBudgetStatus(String budgetStatus) throws InterruptedException {

		Thread.sleep(10000);

		Assert.assertEquals(getBudgetStatus(), budgetStatus, "Budget status is not as expected");

	}

	/*
	 * @FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[1]") WebElement
	 * Close1;
	 * 
	 * @FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[2]") WebElement
	 * Close2;
	 * 
	 * @FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[3]") WebElement
	 * Close3;
	 * 
	 * @FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[4]") WebElement
	 * Close4;
	 * 
	 * public void clickClose() throws InterruptedException {
	 * 
	 * try {
	 * 
	 * common.clickElementJS(Close1);
	 * 
	 * }
	 * 
	 * catch (Exception e1) {
	 * 
	 * try {
	 * 
	 * common.clickElementJS(Close2);
	 * 
	 * }
	 * 
	 * catch (Exception e2) {
	 * 
	 * try {
	 * 
	 * common.clickElementJS(Close3);
	 * 
	 * }
	 * 
	 * catch (Exception e3) {
	 * 
	 * common.clickElementJS(Close4);
	 * 
	 * }
	 * 
	 * } } }
	 */

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[4]")
	WebElement Close_Subcontract;

	public void clickClose_Subcontract() throws InterruptedException {

		common.clickElement(Close_Subcontract);

	}

	@FindBy(xpath = "//*[text()='Construction contract' and contains(@id,'ConstructionContractButton')]")
	WebElement Constructioncontract1;

	@FindBy(xpath = "(//*[text()='Construction contract' and contains(@id,'ConstructionContractButton')])[2]")
	WebElement Constructioncontract2;

	public void clickConstructioncontract() throws InterruptedException {

		try {

			common.clickElement(Constructioncontract1);

		}

		catch (Exception e) {

			common.clickElement(Constructioncontract2);
		}

	}

	@FindBy(xpath = "//*[@name='GroupContractOverview_ContractStatus']")
	WebElement Contractstatus;

	public void clickContractstatus() throws InterruptedException {

		common.clickElement(Contractstatus);

	}

	public void setContractstatus(String status) throws InterruptedException {

		Thread.sleep(3000);

		common.setText(Contractstatus, status);

		common.selectDropDownValue(status);

	}

	/*
	 * @FindBy(xpath = "//*[@name='GroupContractOverview_RetainagePercentage']")
	 * WebElement Retainage;
	 * 
	 * public void setRetainage() throws InterruptedException {
	 * 
	 * logger.info("RetainageValue: " + RetainageValue);
	 * 
	 * common.setTextAfterDelete(Retainage, RetainageValue); }
	 */

	@FindBy(xpath = "//*[text()='Yes']")
	WebElement Yes;

	public void clickYes() throws InterruptedException {

		common.clickElementJS(Yes);

	}

	@FindBy(xpath = "//*[text()='Subcontracts']")
	WebElement Subcontract;

	@FindBy(xpath = "(//*[text()='Subcontracts'])[2]")
	WebElement Subcontract2;

	public void clickSubcontract() throws InterruptedException {

		try {

			common.clickElement(Subcontract);

		}

		catch (Exception e) {

			common.clickElement(Subcontract2);

		}

	}

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * common.clickElement(Postedtransactions);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Overview'])[2]")
	WebElement Overview;

	public void clickOverview() throws InterruptedException {

		if (!common.isSectionExpanded(Overview)) {

			common.clickElement(Overview);
		}
	}

	@FindBy(xpath = "(//*[text()='Edit'])")
	WebElement Edit1;

	@FindBy(xpath = "(//*[text()='Edit'])[2]")
	WebElement Edit2;

	/*
	 * @FindBy(xpath = "(//*[text()='Edit'])[3]") WebElement Edit3;
	 * 
	 * public void clickEdit() throws InterruptedException {
	 * 
	 * try { common.clickElement(Edit1); } catch (Exception e1) { try {
	 * common.clickElement(Edit2); } catch (Exception e3) {
	 * common.clickElement(Edit3); } } }
	 */

	@FindBy(xpath = "//*[text()='Map task codes']")
	WebElement Maptaskcodes;

	public void clickMapTaskCodes() throws InterruptedException {

		if (!common.isSectionExpanded(Maptaskcodes)) {

			common.clickElement(Maptaskcodes);

		}

	}

	@FindBy(xpath = "//*[contains(@id,'ShowNotBillableTasks_toggle')]")
	WebElement Shownonbillabletasks;

	public void clickShownonbillabletasks() throws InterruptedException {

		common.clickElement(Shownonbillabletasks);

	}

	@FindBy(xpath = "//*[text()='Remaining task codes']//following::*[contains(@id,'column_1') and @role='textbox']")
	List<WebElement> RemainingTaskCodes;

	public void selectTaskCodeForContracts() throws InterruptedException {

		for (ArrayList<String> Contract : ConstructionContracts) {

			logger.info("Contract: " + Contract);

			String ContractDescription = Contract.get(0);

			String ContractTasks = Contract.get(2);

			if (!ContractTasks.equals("")) {

				String TaskCodes[] = ContractTasks.split(";");

				for (int i = 0; i < TaskCodes.length; i++) {

					WebElement ContractLine = ldriver.findElement(By.xpath(
							"//*[contains(@id,'GridProjLines_Description') and @value='" + ContractDescription + "']"));

					common.clickElement(ContractLine);

					Thread.sleep(2000);

					WebElement TaskCodeElement = ldriver.findElement(By.xpath(
							"//*[text()='Remaining task codes']//following::*[contains(@id,'column_1') and @role='textbox' and @value='"
									+ TaskCodes[i] + "']"));

					common.clickElement(TaskCodeElement);

					clickMoveRight();

					Thread.sleep(1000);

					// clickSave_Contract();

					clickSave();

					Thread.sleep(1000);

				}

			}

		}
	}

	@FindBy(xpath = "//*[contains(@class,'MoveRight')]")
	WebElement MoveRight;

	public void clickMoveRight() throws InterruptedException {

		common.clickElement(MoveRight);

	}

	/*
	 * @FindBy(xpath = "//*[contains(@class,'Refresh')]") WebElement Refresh1;
	 * 
	 * @FindBy(xpath = "(//*[contains(@class,'Refresh')])[2]") WebElement Refresh2;
	 * 
	 * @FindBy(xpath = "(//*[contains(@class,'Refresh')])[3]") WebElement Refresh3;
	 * 
	 * public void clickRefresh() throws InterruptedException { try {
	 * common.clickElementJS(Refresh1); } catch (Exception e) { try {
	 * common.clickElementJS(Refresh2); } catch (Exception e2) {
	 * common.clickElementJS(Refresh3); } } Thread.sleep(3000); }
	 */

	@FindBy(xpath = "//*[@name='GroupContractOverview_M_onAccountBudgetAmount']")
	WebElement RevenueBudget_Contract;

	public String getRevenueBudget_Contract() throws InterruptedException {

		RevenueBudgetValue_Contract = common.getValue(RevenueBudget_Contract);

		logger.info("RevenueBudgetValue_Contract: " + RevenueBudgetValue_Contract);

		return RevenueBudgetValue_Contract;

	}

	@FindBy(xpath = "//*[@name='GroupContractOverview_M_contractAmount']")
	WebElement Scheduledvalue_Total;

	public String getScheduledValueTotal() throws InterruptedException {

		Thread.sleep(5000);

		ScheduledValue_Total = common.getValue(Scheduledvalue_Total);

		logger.info("ScheduledValue_Total: " + ScheduledValue_Total);

		return ScheduledValue_Total;

	}

	public void checkRevenueBudgetInConstructionContract() throws InterruptedException {

		Assert.assertEquals(getRevenueBudget_Contract(), RevenueBudgetValue_Expected,
				"Revenue Budget value is not as expected in Construction Contract");
	}

	public void checkScheduledValueInConstructionContract() throws InterruptedException {

		String TotalScheduledValueExpected = formulas.getExpectedTotalScheduledValue(ConstructionContracts);

		Assert.assertEquals(getScheduledValueTotal(), TotalScheduledValueExpected,
				"Total scheduled value is not as expected in Construction Contract");
	}

	@FindBy(xpath = "//*[contains(@name,'Baseinfo_Status')]")
	WebElement Status;

	public String getSubContractStatus() throws InterruptedException {

		Thread.sleep(20000);

		String StatusValue = common.getValue(Status);

		logger.info("SubContract_Status: " + StatusValue);

		return StatusValue;

	}

	public void checkSubContractStatus(String status) throws InterruptedException {

		Assert.assertEquals(getSubContractStatus(), status, "Sub contract status is not as expected");

	}

	@FindBy(xpath = "//*[contains(@name,'VendorSpeciality')]")
	WebElement Speciality;

	@FindBy(xpath = "//*[@aria-label='Speciality']")
	WebElement SpecialityID;

	public void setSpeciality() throws InterruptedException {

		common.setText(Speciality, SpecialityValue);

		common.clickElement(SpecialityID);

		Thread.sleep(2000);

	}

	@FindBy(xpath = "//*[contains(@name,'VendAccount')]")
	WebElement Vendoraccount;

	@FindBy(xpath = "//*[@aria-label='Vendor account']")
	WebElement VendoraccountID;

	public void setVendorAccount() throws InterruptedException {

		common.setText(Vendoraccount, VendorAccountValue);

		common.clickElement(VendoraccountID);

	}

	/*
	 * @FindBy(xpath = "(//*[text()='Lines'])[2]") WebElement Lines;
	 * 
	 * public void clickLines() throws InterruptedException {
	 * 
	 * common.clickElement(Lines);
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[@aria-label='Category']")
	WebElement Category;

	/*
	 * public void setSubContract() throws InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * for (ArrayList<String> SubContract : SubContracts) {
	 * 
	 * String TaskCodeValue = SubContract.get(0);
	 * 
	 * String ProjectCategoryValue = SubContract.get(1);
	 * 
	 * String ProcurementCategoryValue = SubContract.get(2);
	 * 
	 * String QuantityValue = SubContract.get(3);
	 * 
	 * String UnitPriceValue = SubContract.get(4);
	 * 
	 * clickNewSubConractLine();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Category =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Category'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(Category, ProjectCategoryValue);
	 * 
	 * WebElement TaskCode =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(TaskCode, TaskCodeValue);
	 * 
	 * WebElement ProcurementCategory = ldriver.findElement(
	 * By.xpath("//*[contains(@id,'ProcurementCategory') and @aria-label='Name'][" +
	 * row + "]"));
	 * 
	 * common.setTextAfterDelete(ProcurementCategory, ProcurementCategoryValue);
	 * 
	 * WebElement Quantity =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Quantity'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(Quantity, QuantityValue);
	 * 
	 * WebElement UnitPrice =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Unit price'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(UnitPrice, UnitPriceValue);
	 * 
	 * WebElement NetAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Net amount'][" + row + "]"));
	 * 
	 * String NetAmountValue = common.getValue(NetAmount);
	 * 
	 * checkLineAmount(QuantityValue, UnitPriceValue, NetAmountValue, row);
	 * 
	 * common.setTextAfterDelete(Category, ProjectCategoryValue);
	 * 
	 * // row++;
	 * 
	 * }
	 * 
	 * clickSave();
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Submit'])[2]")
	WebElement Submit_SubContract;

	public void clickSubmit_SubContract() throws InterruptedException {

		common.clickElement(Submit_SubContract);

	}

	public void clickSubContractStatus(String arg1) throws InterruptedException {

		if (arg1.equals("Submit")) {

			clickSubmit_SubContract();
		}

		else if (arg1.equals("Approve")) {

			clickApprove_SubContract();
		}

		else if (arg1.equals("Commit")) {

			clickCommit_SubContract();
		}

	}

	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Approve'])[2]")
	WebElement Approve_SubContract;

	public void clickApprove_SubContract() throws InterruptedException {

		common.clickElement(Approve_SubContract);

	}

	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Commit'])[2]")
	WebElement Commit_SubContract;

	public void clickCommit_SubContract() throws InterruptedException {

		common.clickElement(Commit_SubContract);

	}

	@FindBy(xpath = "(//*[text()='Subcontract totals']//following::*[contains(@name,'subcontractAmount')])[1]")
	WebElement SubcontractAmount;

	public String getSubContractAmount() throws InterruptedException {

		String SubContractAmountValue = common.getValue(SubcontractAmount);

		return SubContractAmountValue;
	}

	@FindBy(xpath = "(//*[text()='Subcontract totals']//following::*[contains(@name,'subcontractChangeOrderAmount')])[1]  ")
	WebElement ChangeOrderAmount;

	public String getChangeOrderAmount() throws InterruptedException {

		String ChangeOrdersValue = common.getValue(ChangeOrderAmount);

		return ChangeOrdersValue;
	}

	@FindBy(xpath = "(//*[text()='Subcontract totals']//following::*[contains(@name,'subcontractTotalAmount')])")
	WebElement SubcontractTotal;

	public String getSubContractTotal() throws InterruptedException {

		String SubcontractTotalValue = common.getValue(SubcontractTotal);

		return SubcontractTotalValue;
	}

	public void checkSubContractAmount() throws InterruptedException {

		ExpectedSubcontractAmountValue = formulas.getExpectedSubContractAmount(SubContracts);

		Assert.assertEquals(getSubContractTotal(), ExpectedSubcontractAmountValue,
				"Sub contract amount is not as expected");

	}

	/*
	 * public void checkSubContractTotal() throws InterruptedException {
	 * 
	 * String ExpectedSubcontractTotalValue =
	 * formulas.getSum(ExpectedSubcontractAmountValue, getChangeOrderAmount());
	 * 
	 * Assert.assertEquals(getSubContractTotal(), ExpectedSubcontractTotalValue,
	 * "Sub contract total is not as expected");
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Purchase order']//following::*[contains(@name,'PurchId')])[1]")
	WebElement Purchaseorder;

	public String getPurchaseorder() throws InterruptedException {

		PurchaseOrderValue = common.getValue(Purchaseorder);

		return PurchaseOrderValue;
	}

	public void checkPurchaseorderCreated() throws InterruptedException {

		String PurchaseOrderValue = getPurchaseorder();

		try {

			ldriver.findElement(By.xpath("//*[text()='Purchase order " + PurchaseOrderValue + " created/updated']"))
					.isDisplayed();

			Assert.assertTrue(true);

		}

		catch (Exception e) {
			ldriver.findElement(By.xpath("//*[text()='Purchase order " + PurchaseOrderValue + " created/updated']"))
					.isDisplayed();

			Assert.fail("Purchase order has not been created as expected");
		}
	}

	@FindBy(xpath = "//*[text()='Project financial overview detail']")
	WebElement Projectfinancialoverviewdetail;

	@FindBy(xpath = "(//*[text()='Project financial overview detail'])[2]")
	WebElement Projectfinancialoverviewdetail2;

	public void clickProjectFinancialOverviewDetail() throws InterruptedException {

		clickProjectcostmanagement_PageHeader();

		try {

			common.clickElement(Projectfinancialoverviewdetail);

		}

		catch (Exception e) {

			common.clickElement(Projectfinancialoverviewdetail2);

		}

		Thread.sleep(30000);

	}

	// Projects -> new section
	@FindBy(xpath = "//*[text()='Subproject']")
	WebElement Subproject;

	@FindBy(xpath = "//*[text()='Copy project']")
	WebElement Copyproject;

	// Projects -> setup section

	@FindBy(xpath = "//*[text()='Beginning balances']")
	WebElement Beginningbalances;

	@FindBy(xpath = "//*[text()='Collaboration workspace']")
	WebElement Collabrationworkspace;

	@FindBy(xpath = "//*[text()='Line properties']")
	WebElement Lineproperties;

	@FindBy(xpath = "//*[text()='Ledger posting']")
	WebElement Ledgerposting;

	// Projects -> cost prices section

	@FindBy(xpath = "(//*[text()='Cost prices']//following::*[text()='Hours'])[1]")
	WebElement Hours_CP;

	@FindBy(xpath = "(//*[text()='Cost prices']//following::*[text()='Expenses'])[1]")
	WebElement Expenses_CP;

	@FindBy(xpath = "//*[text()='Transfer prices']")
	WebElement Transferprices;

	// Projects -> sales prices section

	@FindBy(xpath = "(//*[text()='Sales prices']//following::*[text()='Hours'])[1]")
	WebElement Hours_SP;

	@FindBy(xpath = "(//*[text()='Sales prices']//following::*[text()='Expenses'])[1]")
	WebElement Expenses_SP;

	@FindBy(xpath = "//*[text()='Fees']")
	WebElement Fees_SP;

	@FindBy(xpath = "//*[text()='Subscriptions']")
	WebElement Subscriptions;

	// Projects -> journals section

	@FindBy(xpath = "//*[text()='Fee']")
	WebElement Fee_Journals;

	// Projects -> SIS Utility section

	@FindBy(xpath = "//*[text()='Copy test project']")
	WebElement Copytestproject;

	// Plan -> Activities section

	@FindBy(xpath = "//*[text()='Work breakdown structure']")
	WebElement Workbreakdownstructure;

	@FindBy(xpath = "//*[text()='Open in Microsoft Project']")
	WebElement OpeninMSproject;

	@FindBy(xpath = "//*[text()='Unlink from Microsoft Project']")
	WebElement UnlinkfromMSproject;

	// Plan -> Item requirements section
	@FindBy(xpath = "//span[normalize-space()='Item requirements']")
	WebElement Itemrequirements;

	@FindBy(xpath = "(//*[text()='Item requirements']//following::*[text()='Transfer from quotation'])[1]")
	WebElement Transferfromquotation_IR;

	@FindBy(xpath = "//*[text()='Transfer from WBS estimates']")
	WebElement TransferfromWBSestimates;

	// Plan -> Forecast section

	@FindBy(xpath = "//*[text()='All forecasts']")
	WebElement Allforecasts;

	@FindBy(xpath = "//*[text()='Hour forecasts']")
	WebElement Hourforecasts;

	@FindBy(xpath = "//*[text()='Expense forecasts']")
	WebElement Expenseforecasts;

	@FindBy(xpath = "//*[text()='Item forecasts']")
	WebElement Itemforecasts;

	@FindBy(xpath = "//*[text()='Fee forecasts']")
	WebElement Feeforecasts;

	@FindBy(xpath = "//*[text()='On-account forecasts']")
	WebElement OnAccountforecasts;

	@FindBy(xpath = "//*[text()='Cash flow forecast']")
	WebElement Cashflowforecasts;

	// Plan -> Maintain Forecast section

	@FindBy(xpath = "//*[text()='Copy forecasts']")
	WebElement Copyforecasts;

	@FindBy(xpath = "//*[text()='Copy forecasts to ledger']")
	WebElement CopyforecastsToledger;

	@FindBy(xpath = "//*[text()='Delete forecasts']")
	WebElement Deleteforecasts;

	@FindBy(xpath = "(//*[text()='Maintain forecast']//following::*[text()='Transfer from quotation'])[1]")
	WebElement Transferfromquotation_MF;

	@FindBy(xpath = "//*[text()='Transfer from WBS']")
	WebElement TransferfromWBS;

	// Plan -> Validation section

	@FindBy(xpath = "//*[text()='Assign resources']")
	WebElement Assignresources;

	@FindBy(xpath = "//*[text()='Assign categories']")
	WebElement Assigncategories;

	// Manage -> New section

	@FindBy(xpath = "(//*[text()='Manage'])")
	WebElement Manage1;

	@FindBy(xpath = "(//*[text()='Manage'])[2]")
	WebElement Manage2;

	public void clickManage() throws InterruptedException {
		try {
			common.clickElement(Manage1);
		}

		catch (Exception e) {
			common.clickElement(Manage2);
		}
	}

	@FindBy(xpath = "//*[text()='Item task']")
	WebElement Itemtask;

	@FindBy(xpath = "//*[text()='Invoice proposal']")
	WebElement Invoiceproposal;

	@FindBy(xpath = "//*[text()='Project quotation']")
	WebElement ProjQuotation;

	@FindBy(xpath = "(//*[text()='New']//following::*[text()='Service'])[1]")
	WebElement Services;

	@FindBy(xpath = "//*[text()='Case']")
	WebElement Case;

	// Manage -> Process section
	@FindBy(xpath = "//*[text()='Adjust transactions']")
	WebElement Adjusttransactions;

	@FindBy(xpath = "//*[text()='Estimates']")
	WebElement Estimates;

	@FindBy(xpath = "//*[text()='Accrue revenue']")
	WebElement Accruerevenue;

	@FindBy(xpath = "//*[text()='Post costs']")
	WebElement Postcost;

	@FindBy(xpath = "//*[text()='Post service orders']")
	WebElement Postserviceorders;

	@FindBy(xpath = "//*[text()='Index subscription']")
	WebElement Indexsubscription;

	// Manage -> Bill section
	@FindBy(xpath = "//*[text()='Project invoice proposals']")
	WebElement Projectinvoiceproposals;

	@FindBy(xpath = "//*[text()='Invoice journals']")
	WebElement Invoicejournals;

	@FindBy(xpath = "//*[text()='On-account transactions']")
	WebElement Onaccounttransactions;

	@FindBy(xpath = "//*[text()='Customer advance']")
	WebElement Customeradvance;

	@FindBy(xpath = "//*[text()='Request retained amount']")
	WebElement Requestretainedamount;

	// Manage -> Related information section
	@FindBy(xpath = "//*[text()='Item tasks']")
	WebElement Itemtasks;

	@FindBy(xpath = "//*[text()='Pending transactions']")
	WebElement Pendingtransactions;

	@FindBy(xpath = "(//*[text()='Posted transactions'])[1]")
	WebElement Postedtransactions1;

	@FindBy(xpath = "(//*[text()='Posted transactions'])[2]")
	WebElement Postedtransactions2;

	public void clickPostedtransactions() throws InterruptedException {

		common.clickElement(Postedtransactions1);

	}

	@FindBy(xpath = "(//*[text()='Related information']//following::*[text()='Service'])[1]")
	WebElement Service;

	@FindBy(xpath = "//*[text()='Cases']")
	WebElement Cases;

	@FindBy(xpath = "//*[text()='Project transaction']")
	WebElement Projecttransaction;

	// Manage -> Related information section -> Posted transactions

	@FindBy(xpath = "//*[@title='Total sales amount']")
	WebElement Totalsalesamount;

	public void rightClickTotalSalesAmountHeader() throws InterruptedException {

		common.rightClickElement(Totalsalesamount);
	}

	@FindBy(xpath = "//*[@title='Total cost amount']")
	WebElement Totalcostamount;

	public void rightClickTotalCostAmountHeader() throws InterruptedException {

		common.rightClickElement(Totalcostamount);
	}

	@FindBy(xpath = "//*[@title='Amount in transaction currency']")
	WebElement Amountintransactioncurrency;

	public void rightClickAmountInTransactionCurrencyHeader() throws InterruptedException {

		common.rightClickElement(Amountintransactioncurrency);
	}

	@FindBy(xpath = "//*[text()='Total']//following::div[@role='columnheader'][16]//child::*[@role='button']//following::div[1]")
	WebElement Totalsalesamount_value;

	public String getTotalSalesAmount() throws InterruptedException {

		Thread.sleep(10000);

		String TotalSalesAmount = common.getText(Totalsalesamount_value);

		return TotalSalesAmount;
	}

	@FindBy(xpath = "//*[text()='Total']//following::div[@role='columnheader'][17]//child::*[@role='button']//following::div[1]")
	WebElement Amountintransactioncurrency_value;

	public String getAmountInTransactionCurrency() throws InterruptedException {

		Thread.sleep(2000);

		String AmountInTransactionCurrency = common.getText(Amountintransactioncurrency_value);

		return AmountInTransactionCurrency;
	}

	@FindBy(xpath = "//*[text()='Total']//following::div[@role='columnheader'][18]//child::*[@role='button']//following::div[1]")
	WebElement Totalcostamount_value;

	public String getTotalCostAmount() throws InterruptedException {

		Thread.sleep(2000);

		String TotalCostAmount = common.getText(Totalcostamount_value);

		return TotalCostAmount;
	}

	public void getTotalFromPostedTransactions(String arg1) throws InterruptedException {

		if (arg1.equals("Total sales amount")) {

			TotalSalesAmount = getTotalSalesAmount();

			logger.info("TotalSalesAmount: " + TotalSalesAmount);
		}

		if (arg1.equals("Total cost amount")) {

			TotalCostAmount = getTotalCostAmount();

			logger.info("TotalCostAmount: " + TotalCostAmount);

		}

		if (arg1.equals("Amount in transaction currency")) {

			AmountInTransactionCurrency = getAmountInTransactionCurrency();

			logger.info("AmountInTransactionCurrency: " + AmountInTransactionCurrency);

		}
	}

	// Control -> Statements section

	@FindBy(xpath = "//*[text()='Project statements']")
	WebElement Projectstatements;

	@FindBy(xpath = "//*[text()='Cash flow']")
	WebElement Cashflow;

	// Control -> Control section

	@FindBy(xpath = "//*[text()='Invoice control']")
	WebElement Invoicecontrol;

	@FindBy(xpath = "//*[text()='Cost control']")
	WebElement Costcontrol;

	@FindBy(xpath = "//*[text()='Project budget balances']")
	WebElement ProjBudgetbalances;

	@FindBy(xpath = "//*[text()='Unbudgeted cost']")
	WebElement Unbudgetedcost;

	@FindBy(xpath = "(//*[text()='Committed cost'])[1]")
	WebElement Committedcost1;

	@FindBy(xpath = "(//*[text()='Committed cost'])[2]")
	WebElement Committedcost2;

	// Control -> Project tracking section
	@FindBy(xpath = "//*[text()='Tracking Views']")
	WebElement Trackingviews;

	// Control -> Utilization section

	@FindBy(xpath = "//*[text()='Hour utilization']")
	WebElement Hourutilization;

	@FindBy(xpath = "//*[text()='Resource utilization']")
	WebElement Resourceutilization;

	// Control -> Retention section

	@FindBy(xpath = "//*[text()='Vendor invoices']")
	WebElement Vendorinvoices;

	@FindBy(xpath = "//*[text()='Customer retained payments']")
	WebElement Customerretainedpayments;

	@FindBy(xpath = "//*[text()='Payments retained from vendors']")
	WebElement PaymentsretainedfrVendors;

	// PCM -> PCM section

	@FindBy(xpath = "//*[text()='Task code management']")
	WebElement Taskcodemanagement;

	@FindBy(xpath = "//*[text()='Budget versions']")
	WebElement Budgetversions1;

	@FindBy(xpath = "(//*[text()='Budget versions'])[2]")
	WebElement Budgetversions2;

	@FindBy(xpath = "//*[text()='ECAC']")
	WebElement ECAC;

	@FindBy(xpath = "//*[text()='Budget category transactions']")
	WebElement Budgetcategorytransactions;

	@FindBy(xpath = "//*[text()='Project change order']")
	WebElement Projectchangeorder;

	@FindBy(xpath = "//*[text()='Customer change orders']")
	WebElement Customerchangeorder;

	// PCM -> Inquiries and reports section
	@FindBy(xpath = "//*[text()='Project summary inquiry']")
	WebElement Projectsummaryinquiry;

	@FindBy(xpath = "(//*[text()='Generate project cost analysis report'])[2]")
	WebElement GeneratePCAreport;

	@FindBy(xpath = "//*[text()='Project financial overview detail']")
	WebElement GeneratePFOreport;

	@FindBy(xpath = "//*[text()='Project 360']")
	WebElement Project360;

	// PCM -> Project transactions section
	@FindBy(xpath = "//*[text()='All transactions']")
	WebElement Alltransactions;

	@FindBy(xpath = "//*[text()='Overhead transaction inquiry']")
	WebElement OverheadTransInq;

	// Options -> Personalize section
	@FindBy(xpath = "//*[text()='Always open for editing']")
	WebElement Alwaysopenforediting;

	@FindBy(xpath = "//*[text()='Personalize this page']")
	WebElement pSersonalizeThisPage;

	@FindBy(xpath = "//*[text()='Add to workspace']")
	WebElement addToWorkspace;

	// Options -> Page options section

	@FindBy(xpath = "//*[text()='Security diagnostics']")
	WebElement securityDiagnostics;

	@FindBy(xpath = "//*[text()='Advanced filter or sort']")
	WebElement advancedFilterOrSort;

	@FindBy(xpath = "//*[text()='Record info']")
	WebElement recordInfo;

	// Options -> Share section
	@FindBy(xpath = "//*[text()='Get a link']")
	WebElement getaLink;

	@FindBy(xpath = "//*[text()='Create a custom alert']")
	WebElement createACustomAlert;

	@FindBy(xpath = "//*[text()='Manage my alerts']")
	WebElement manageMyAlerts;

//--------------Subcontract----------------

	// Click Subcontract -> New subcontract -> new
	@FindBy(xpath = "(//*[text()='New'])[3]")
	WebElement New_Newsubcontract;

	// Click Lines tab
	@FindBy(xpath = "(//*[text()='Lines'])[2]")
	WebElement Lines_linesTab;

	// Click Detail lines -> new (to add line)
	@FindBy(xpath = "//*[text()='Detail lines']//following::*[text()='New']")
	WebElement New_Lines;

	// Click Detail lines -> delete (to delete line)
	@FindBy(xpath = "//*[text()='Detail lines']//following::*[text()='Delete']")
	WebElement Delete_Line;

	// lines -> Task Code
	@FindBy(xpath = "(//*[text()='Task code']//following::*[contains(@id,'TaskCode')])[3]")
	WebElement TaskCode;

	// lines -> Procurement Category
	@FindBy(xpath = "(//*[text()='Procurement category']//following::*[contains(@id,'ProcurementCategory')])[3] ")
	WebElement procurementCategory;

	// lines -> Enter Unit Price
	@FindBy(xpath = "(//*[text()='Unit price']//following::*[contains(@id,'PurchPrice')])[3] ")
	WebElement UnitPrice;

	// lines -> Get Net Amount
	@FindBy(xpath = "(//*[text()='Net amount']//following::*[contains(@id,'LineAmount')])[3] ")
	WebElement Netamount;

	// Subcontracts -> Workflow/status -> click Draft
	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Draft'])[2]")
	WebElement Draft;

	// Subcontracts -> Workflow/status -> click Reject
	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Reject'])[2]")
	WebElement Reject;

	// Subcontracts -> Workflow/status -> click Cancel
	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Cancel'])[2]")
	WebElement Cancel;

	// Subcontracts -> Workflow/status -> click Closed
	@FindBy(xpath = "(//*[text()='Workflow/Status']//following::*[text()='Closed'])[2]")
	WebElement Closed;

	// Subcontracts -> Change order -> click New
	@FindBy(xpath = "(//*[text()='Change orders']//following::*[text()='New'])[4]")
	WebElement New_ChangeOrder;

	// Subcontracts -> Change order -> click List
	@FindBy(xpath = "(//*[text()='Change orders']//following::*[text()='List'])[2]")
	WebElement List_ChangeOrder;

	// Subcontracts -> Payment request-> click New
//	@FindBy(xpath = "(//*[text()='Payment request']//following::*[text()='New'])[4]")
//	WebElement New_PaymentRequest;

	// Subcontracts -> Payment request-> click list
	@FindBy(xpath = "(//*[text()='Payment request']//following::*[text()='list'])[2]")
	WebElement list_PaymentRequest;

	// Subcontracts -> Evaluation -> click Subcontract evaluation
	@FindBy(xpath = "(//*[text()='Evaluation']//following::*[text()='Subcontract evaluation'])[2]")
	WebElement subcontractEvaluation;

	// Subcontracts -> Lines -> Change Order
	@FindBy(xpath = "(//*[text()='Subcontract totals']//following::*[contains(@name,'subcontractChangeOrderAmount')])[1]  ")
	WebElement Changerders;

	// Budget -> Original
	@FindBy(xpath = "//*[text()='Orig Contract Value']//following::*[2]")
	WebElement OrigContractValue_element;

	public String getOrigContractValue() throws InterruptedException {

		String OrigContractValue = common.getText(OrigContractValue_element);

		return OrigContractValue;

	}

	public void checkgetOrigContractValue() throws InterruptedException {

		logger.info("Orig Contract Value_PFO_Expected:" + RevenueBudgetValue_Expected);

		logger.info("Orig Contract Value_PFO_Actual:" + getOrigContractValue());

		sa.assertEquals(getOrigContractValue(), RevenueBudgetValue_Expected,
				"Orig Contract Valuein the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Orig Cost Budget']//following::*[2]")
	WebElement OrigCostBudget;

	public String getOrigCostBudget() throws InterruptedException {

		String OrigCostBudgetValue = common.getText(OrigCostBudget);

		return OrigCostBudgetValue;

	}

	public void checkOrigCostBudget() throws InterruptedException {

		logger.info("Orig Cost Budget_PFO_Expected:" + CostBudgetValue_Expected);

		logger.info("Orig Cost Budget_PFO_Actual:" + getOrigCostBudget());

		sa.assertEquals(getOrigCostBudget(), CostBudgetValue_Expected,
				"Orig Cost Budget in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Orig GM']//following::*[2]")
	WebElement OrigGM;

	public String getOrigGM() throws InterruptedException {

		String OrigGMValue = common.getText(OrigGM);

		return OrigGMValue;

	}

	public void checkOrigGM() throws InterruptedException {

		String OrigGMValue = formulas.getDifference(RevenueBudgetValue_Expected, CostBudgetValue_Expected);

		logger.info("Orig GM_PFO_Expected:" + OrigGMValue);

		logger.info("Orig GM_PFO_Actual:" + getOrigGM());

		sa.assertEquals(getOrigGM(), OrigGMValue, "Orig GM in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Orig GM %']//following::*[2]")
	WebElement OrigGMPercentage;

	public String getOrigGMPercentage() throws InterruptedException {

		String OrigGMPercentageValue = common.getText(OrigGMPercentage);

		return OrigGMPercentageValue;

	}

	public void checkgetOrigGMPercentage() throws InterruptedException {

		logger.info("Orig GM %_PFO_Expected:" + ProfitmarginValue_Expected);

		logger.info("Orig GM %_PFO_Actual:" + getOrigGMPercentage());

		sa.assertEquals(getOrigGMPercentage(), ProfitmarginValue_Expected,
				"Orig GM percentage in the PFO Report is not as expected");
	}

	// Budget -> Change Order

	@FindBy(xpath = "//*[text()='Approved CO']//following::*[2]")
	WebElement approvedCO;

	public String getapprovedCO() throws InterruptedException {

		String approvedCOValue = common.getText(approvedCO);

		return approvedCOValue;

	}

	public void checkApprovedCO() throws InterruptedException {

		/*
		 * String ExpectedApprovedCO = ;
		 * 
		 * logger.info("Pending CO_PFO_Expected:" + ExpectedApprovedCO);
		 * 
		 * logger.info("Pending CO_PFO_Actual:" + getapprovedCO());
		 * 
		 * sa.assertEquals(getapprovedCO(), ExpectedApprovedCO,
		 * "Approved CO in the PFO Report is not as expected");
		 */

	}

	@FindBy(xpath = "//*[text()='Pending CO']//following::*[2]")
	WebElement pendingCO;

	public String getpendingCO() throws InterruptedException {

		String pendingCOValue = common.getText(pendingCO);

		return pendingCOValue;

	}

	public void checkPendingCO() throws InterruptedException {

		logger.info("Pending CO_PFO_Expected:" + BudgetTotalsData.get("BudgetLines_Revision1:RevenueBudget"));

		logger.info("Pending CO_PFO_Actual:" + getpendingCO());

		sa.assertEquals(getpendingCO(), BudgetTotalsData.get("BudgetLines_Revision1:RevenueBudget"),
				"Pending CO in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='CO Budget']//following::*[2]")
	WebElement CObudget;

	public String getCObudget() throws InterruptedException {

		String CObudgetValue = common.getText(CObudget);

		return CObudgetValue;

	}

	public void checkCOBudget() throws InterruptedException {

		String COBudget_PFO_Expected = "0.00";

		if (PFOPeriod.equals("Current Period")) {

			for (Map.Entry<String, String> entry : Budget_CostBudget.entrySet()) {

				if (entry.getKey().contains("Revision1")) {

					String COBudget = entry.getValue();

					COBudget_PFO_Expected = formulas.getSum(COBudget_PFO_Expected, COBudget);

				}

			}
		}

		else if (PFOPeriod.equals("Next Period")) {

			for (Map.Entry<String, String> entry : Budget_CostBudget.entrySet()) {

				if (entry.getKey().contains("Revision2") || entry.getKey().contains("Revision1")) {

					String COBudget = entry.getValue();

					COBudget_PFO_Expected = formulas.getSum(COBudget_PFO_Expected, COBudget);

				}

			}
		}

		logger.info("CO Budget_PFO_Expected:" + COBudget_PFO_Expected);

		logger.info("CO Budget_PFO_Actual:" + getCObudget());

		sa.assertEquals(getCObudget(), COBudget_PFO_Expected, "CO Budget in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='CO Margin']//following::*[2]")
	WebElement COmargin;

	public String getCOmargin() throws InterruptedException {

		String COmarginValue = common.getText(COmargin);

		return COmarginValue;

	}

	public void checkCOMargin() throws InterruptedException {

		String COMarginExpectedValue = formulas.getDifference(formulas.getSum(getapprovedCO(), getpendingCO()),
				getCObudget());

		logger.info("CO Margin_PFO_Expected:" + COMarginExpectedValue);

		logger.info("CO Margin_PFO_Actual:" + getCOmargin());

		sa.assertEquals(getCOmargin(), COMarginExpectedValue, "CO Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='CO Margin %']//following::*[2]")
	WebElement COmarginPercentage;

	public String getCOMarginPercentage() throws InterruptedException {

		String COMarginPercentage = common.getText(COmarginPercentage);

		return COMarginPercentage;

	}

	public void checkCOMarginPercentage() throws InterruptedException {

//		if (getapprovedCO().equals("0.00")) {
//
//			COMarginPercentageExpectedValue = "0.00";
//		}
//
//		else {
//
//			COMarginPercentageExpectedValue = formulas.getExpectedCOMarginPercentage(getapprovedCO(), getpendingCO(),
//					getCObudget());
//
//		}

		String COMarginPercentageExpectedValue = formulas.getExpectedCOMarginPercentage(getapprovedCO(), getpendingCO(),
				getCObudget());

		logger.info("CO Margin Percentage_PFO_Expected:" + COMarginPercentageExpectedValue);

		logger.info("CO Margin Percentage_PFO_Actual:" + getCOMarginPercentage());

		sa.assertEquals(getCOMarginPercentage(), COMarginPercentageExpectedValue,
				"CO Margin Percentage in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Pending Internal CO']//following::*[2]")
	WebElement pendingInternalCO;

	// Budget -> Current
	@FindBy(xpath = "//*[text()='Current CV']//following::*[2]")
	WebElement currentCV;

	public String getcurrentCV() throws InterruptedException {

		String currentCVValue = common.getText(currentCV);

		return currentCVValue;

	}

	public void checkCurrentCV() throws InterruptedException {

		String CurrentCVValue = formulas.getSum(getOrigContractValue(), getapprovedCO(), getpendingCO());

		logger.info("Current CV_PFO_Expected:" + CurrentCVValue);

		logger.info("Current CV_PFO_Actual:" + getcurrentCV());

		sa.assertEquals(getcurrentCV(), CurrentCVValue, "Current CV in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Current CO Budget']//following::*[2]")
	WebElement currentCOBudget;

	public String getCurrentCOBudget() throws InterruptedException {

		String currentCOBudgetValue = common.getText(currentCOBudget);

		return currentCOBudgetValue;

	}

	public void checkCurrentCOBudget() throws InterruptedException {

		String CurrentCOBudgetValue = formulas.getSum(getOrigCostBudget(), getCObudget());

		logger.info("Current CO Budget_PFO_Expected:" + CurrentCOBudgetValue);

		logger.info("Current CO Budget_PFO_Actual:" + getCurrentCOBudget());

		sa.assertEquals(getCurrentCOBudget(), CurrentCOBudgetValue,
				"Current CO Budget in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Current Gross Margin']//following::*[2]")
	WebElement currentGM;

	public String getcurrentGM() throws InterruptedException {

		String currentGMValue = common.getText(currentGM);

		return currentGMValue;

	}

	public void checkCurrentGrossMargin() throws InterruptedException {

		String CurrentGrossMargin = formulas.getDifference(getcurrentCV(), getCurrentCOBudget());

		logger.info("Current Gross Margin_PFO_Expected:" + CurrentGrossMargin);

		logger.info("Current Gross Margin_PFO_Actual:" + getcurrentGM());

		sa.assertEquals(getcurrentGM(), CurrentGrossMargin,
				"Current Gross Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Current GM %']//following::*[2]")
	WebElement currentGMPercentage;

	public String getcurrentGMPercentage() throws InterruptedException {

		String currentGMPercentageValue = common.getText(currentGMPercentage);

		return currentGMPercentageValue;

	}

	public void checkCurrentGMPercentage() throws InterruptedException {

		String CurrentGMPercentage = formulas.getGMPercentage(getcurrentCV(), getCurrentCOBudget());

		logger.info("Current GM Percentage_PFO_Expected:" + CurrentGMPercentage);

		logger.info("Current GM Percentage_PFO_Actual:" + getcurrentGMPercentage());

		sa.assertEquals(getcurrentGMPercentage(), CurrentGMPercentage,
				"Current GM Percentage in the PFO Report is not as expected");
	}

	// Budget -> ECAC

	@FindBy(xpath = "(//*[text()='ECAC']//following::*[text()='ECAC Cost']//following::*[2])[1]")
	WebElement ECACcost_ECAC;

	public String getECACcost_ECAC() throws InterruptedException {

		String ECACcost_ECACValue = common.getText(ECACcost_ECAC);

		return ECACcost_ECACValue;

	}

	public void checkECACCost() throws InterruptedException {

		String ExpectedECACCost = formulas.getSum(getCurrentCOBudget(), ECACNetChangeValueTotal);

		logger.info("ECAC Cost_PFO_Expected:" + ExpectedECACCost);

		logger.info("ECAC Cost_PFO_Actual:" + getECACcost_ECAC());

		sa.assertEquals(getECACcost_ECAC(), ExpectedECACCost, "ECAC Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Total POC %']//following::*[2]")
	WebElement TotalPOCpercentage;

	public String getTotalPOCpercentage() throws InterruptedException {

		String TotalPOCpercentageValue = common.getText(TotalPOCpercentage);

		return TotalPOCpercentageValue;

	}

	public void checkTotalPOCpercentage() throws InterruptedException {

		String TotalPOCPercentageExpected = formulas.getPercentageComplete(getPTDCost(), getECACcost_ECAC());

		logger.info("Total POC percentage_PFO_Expected:" + TotalPOCPercentageExpected);

		logger.info("Total POC percentage_PFO_Actual:" + getTotalPOCpercentage());

		sa.assertEquals(getTotalPOCpercentage(), TotalPOCPercentageExpected,
				"Total POC percentage in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='ECAC Gross Margin']//following::*[2]")
	WebElement ECACGrossmargin;

	public String getECACGrossmargin() throws InterruptedException {

		String ECACGrossmarginValue = common.getText(ECACGrossmargin);

		return ECACGrossmarginValue;

	}

	public void checkECACGrossMargin() throws InterruptedException {

		String ECACGrossmargin = formulas.getDifference(getcurrentCV(), getECACcost_ECAC());

		logger.info("ECAC Gross Margin_PFO_Expected:" + ECACGrossmargin);

		logger.info("ECAC Gross Margin_PFO_Actual:" + getECACGrossmargin());

		sa.assertEquals(getECACGrossmargin(), ECACGrossmargin,
				"ECAC Gross Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='ECAC GM %']//following::*[2]")
	WebElement ECACGMPercentage;

	public String getECACGMPercentage() throws InterruptedException {

		String ECACGMPercentageValue = common.getText(ECACGMPercentage);

		return ECACGMPercentageValue;

	}

	public void checkECACGMPercentage() throws InterruptedException {

		String ECACGMPercentage = formulas.getGMPercentage(getcurrentCV(), getECACcost_ECAC());

		logger.info("ECAC GM Percentage_PFO_Expected:" + ECACGMPercentage);

		logger.info("ECAC GM Percentage_PFO_Actual:" + getECACGMPercentage());

		sa.assertEquals(getECACGMPercentage(), ECACGMPercentage,
				"ECAC GM Percentage in the PFO Report is not as expected");
	}

	// Budget -> RevREC

	@FindBy(xpath = "(//*[text()='RevREC']//following::*[text()='ECAC Cost']//following::*[2])[2]")
	WebElement ECACcost_RevREC;

	public String getECACcost_RevREC() throws InterruptedException {

		String ECACcost_RevRECValue = common.getText(ECACcost_RevREC);

		return ECACcost_RevRECValue;

	}

	public void checkECACcost_RevREC() throws InterruptedException {

		String ECACcost_RevREC_BudgetLines_Original = BudgetAmount_ExcludeRevRec.get("BudgetLines_Original");

		String ECACcost_RevREC_BudgetLines_Revision1 = BudgetAmount_ExcludeRevRec.get("BudgetLines_Revision1");

		String ECACcost_RevREC_BudgetLines_Revision2 = BudgetAmount_ExcludeRevRec.get("BudgetLines_Revision2");

		if (ECACcost_RevREC_BudgetLines_Revision1 == null) {

			ECACcost_RevREC_BudgetLines_Revision1 = "0.00";
		}

		if (ECACcost_RevREC_BudgetLines_Revision2 == null) {

			ECACcost_RevREC_BudgetLines_Revision2 = "0.00";
		}

		String ECACcost_RevREC = "";

		if (PFOPeriod.equals("Current Period")) {

			ECACcost_RevREC = formulas.getSum(ECACcost_RevREC_BudgetLines_Original,
					ECACcost_RevREC_BudgetLines_Revision1);

		}

		else if (PFOPeriod.equals("Next Period")) {

			ECACcost_RevREC = formulas.getSum(ECACcost_RevREC_BudgetLines_Original,
					ECACcost_RevREC_BudgetLines_Revision1, ECACcost_RevREC_BudgetLines_Revision2);

		}

		ECACcost_RevREC = formulas.getSum(ECACcost_RevREC, ECACNetChangeValueTotal);

		logger.info("ECAC Cost RevREC_PFO_Expected:" + ECACcost_RevREC);

		logger.info("ECAC Cost RevREC_PFO_Actual:" + getECACcost_RevREC());

		sa.assertEquals(getECACcost_RevREC(), ECACcost_RevREC,
				"ECAC Cost - RevREC in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Actual Cost']//following::*[2]")
	WebElement ActualCost;

	public String getActualCost() throws InterruptedException {

		String ActualCostValue = common.getText(ActualCost);

		return ActualCostValue;

	}

	public void checkActualCost() throws InterruptedException {

		/*
		 * String ActualCost_PFO_Expected =
		 * formulas.getActualCost(Amount_OverheadTransactions_Total_CurrentPeriod,
		 * Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod,
		 * Amount_OverheadTransactions_Total_NextPeriod,
		 * Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod,
		 * InvoiceAmountTotal);
		 */

		if (Amount_OverheadTransactions_Total_NextPeriod == null) {

			Amount_OverheadTransactions_Total_NextPeriod = "0.00";

		}

		if (Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod == null) {

			Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod = "0.00";
		}

		String ActualCost_PFO_Expected = formulas.getActualCost(Amount_OverheadTransactions_Total_CurrentPeriod,
				Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod,
				Amount_OverheadTransactions_Total_NextPeriod,
				Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod);

		logger.info("Actual Cost_PFO_Expected:" + ActualCost_PFO_Expected);

		logger.info("Actual Cost_PFO_Actual:" + getActualCost());

		sa.assertEquals(getActualCost(), ActualCost_PFO_Expected, "Actual Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='% Complete']//following::*[2]")
	WebElement percentageComplete;

	public String getpercentageComplete() throws InterruptedException {

		String percentageCompleteValue = common.getText(percentageComplete);

		return percentageCompleteValue;

	}

	public void checkPercentageComplete() throws InterruptedException {

		String PercentageComplete = formulas.getPercentageComplete(getActualCost(), getECACcost_RevREC());

		logger.info("PercentageComplete_PFO_Expected:" + PercentageComplete);

		logger.info("PercentageComplete_PFO_Actual:" + getpercentageComplete());

		sa.assertEquals(getpercentageComplete(), PercentageComplete,
				"Percentage Complete- RevREC in the PFO Report is not as expected");
	}

	// Actuals -> Project to date

	@FindBy(xpath = "//*[text()='PTD Revenue']//following::*[2]")
	WebElement ptdRevenue;

	public String getPTDRevenue() throws InterruptedException {

		String PTDRevenueValue = common.getText(ptdRevenue);

		return PTDRevenueValue;

	}

	public void checkPTDRevenue() throws InterruptedException {

		String PTDRevenue_PFO_Expected = RevenueRecognition.get("Unpostedrevenue");

		logger.info("PTD Revenue_PFO_Expected:" + PTDRevenue_PFO_Expected);

		logger.info("PTD Revenue_PFO_Actual:" + getPTDRevenue());

		sa.assertEquals(getPTDRevenue(), PTDRevenue_PFO_Expected, "PTD Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='PTD Cost']//following::*[2]")
	WebElement ptdCost;

	public String getPTDCost() throws InterruptedException {

		String PTDCostValue = common.getText(ptdCost);

		return PTDCostValue;

	}

	public void checkPTDCost() throws InterruptedException {

		// String PTDCost_PFO_Expected =
		// formulas.getYTDCost(Amount_OverheadTransactions_Total_CurrentPeriod,
		// Amount_OverheadTransactions_Total_NextPeriod, InvoiceAmountTotal);

		if (Amount_OverheadTransactions_Total_NextPeriod == null) {

			Amount_OverheadTransactions_Total_NextPeriod = "0.00";

		}

		String PTDCost_PFO_Expected = formulas.getSum(Amount_OverheadTransactions_Total_CurrentPeriod,
				Amount_OverheadTransactions_Total_NextPeriod);

		logger.info("PTD Cost_PFO_Expected:" + PTDCost_PFO_Expected);

		logger.info("PTD Cost_PFO_Actual:" + getPTDCost());

		sa.assertEquals(getPTDCost(), PTDCost_PFO_Expected, "PTD Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='PTD Margin']//following::*[2]")
	WebElement ptdMargin;

	public String getPTDMargin() throws InterruptedException {

		String PTDMarginValue = common.getText(ptdMargin);

		return PTDMarginValue;

	}

	public void checkPTDMargin() throws InterruptedException {

		String PTDMarginExpected = null;

		if (formulas.isValue1Greater(getOrigContractValue(), getOrigCostBudget())) {

			PTDMarginExpected = formulas.getDifference(getPTDRevenue(), getActualCost());
		}

		else {

			PTDMarginExpected = getECACGrossmargin();
		}

		logger.info("PTD Margin_PFO_Expected:" + PTDMarginExpected);

		logger.info("PTD Margin_PFO_Actual:" + getPTDMargin());

		sa.assertEquals(getPTDMargin(), PTDMarginExpected, "PTD Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='PTD incurred margin']//following::*[2]")
	WebElement ptdIncurredMargin;

	public String getPTDIncurredMargin() throws InterruptedException {

		String PTDIncurredMarginValue = common.getText(ptdIncurredMargin);

		return PTDIncurredMarginValue;

	}

	public void checkPTDIncurredMargin() throws InterruptedException {

		String PTDIncurredMarginExpected = formulas.getDifference(getPTDRevenue(), getActualCost());

		logger.info("PTD Incurred Margin_PFO_Expected:" + PTDIncurredMarginExpected);

		logger.info("PTD Incurred Margin_PFO_Actual:" + getPTDIncurredMargin());

		sa.assertEquals(getPTDIncurredMargin(), PTDIncurredMarginExpected,
				"PTD Incurred Margin in the PFO Report is not as expected");
	}

	// Actuals -> Cost

	@FindBy(xpath = "//*[text()='CTC']//following::*[2]")
	WebElement CTC;

	public String getCTC() throws InterruptedException {

		String CTCValue = common.getText(CTC);

		return CTCValue;

	}

	public void checkCTC() throws InterruptedException {

		String CTC = formulas.getDifference(getECACcost_ECAC(), getPTDCost());

		logger.info("CTC_PFO_Expected:" + CTC);

		logger.info("CTC_PFO_Actual:" + getCTC());

		sa.assertEquals(getCTC(), CTC, "CTC in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='CMTD']//following::*[2]")
	WebElement CMTD;

	public String getCMTD() throws InterruptedException {

		String CMTDValue = common.getText(CMTD);

		return CMTDValue;

	}

	public void checkCMTD() throws InterruptedException {

		logger.info("CMTD_PFO_Expected:" + TotalCostAmount_CommittedCost);

		logger.info("CMTD_PFO_Actual:" + getCMTD());

		sa.assertEquals(getCMTD(), TotalCostAmount_CommittedCost, "CMTD in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='ETC']//following::*[2]")
	WebElement ETC;

	public String getETC() throws InterruptedException {

		String ETCValue = common.getText(ETC);

		return ETCValue;

	}

	public void checkETC() throws InterruptedException {

		String ETC = formulas.getDifference(getCTC(), getCMTD());

		logger.info("ETC_PFO_Expected:" + ETC);

		logger.info("ETC_PFO_Actual:" + getETC());

		sa.assertEquals(getETC(), ETC, "ETC in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='WIP Cost']//following::*[2]")
	WebElement wipCost;

	public String getwipCost() throws InterruptedException {

		String wipCostValue = common.getText(wipCost);

		return wipCostValue;

	}

	// Actuals -> Billing

	@FindBy(xpath = "//*[text()='Prog Billing']//following::*[2]")
	WebElement progBilling;

	public String getProgBilling() throws InterruptedException {

		String ProgBillingValue = common.getText(progBilling);

		return ProgBillingValue;

	}

	public void checkProgBilling() throws InterruptedException {

		String ProgBilling_PFO_Expected = null;

		if (PFOPeriod.equals("Current Period")) {

			ProgBilling_PFO_Expected = InvoiceLineAmount_Invoicejournals_CurrentPeriod;

		}

		else if (PFOPeriod.equals("Next Period")) {

			ProgBilling_PFO_Expected = InvoiceLineAmount_Invoicejournals_NextPeriod;

		}

		logger.info("Prog Billing_PFO_Expected:" + ProgBilling_PFO_Expected);

		logger.info("Prog Billing_PFO_Actual:" + getProgBilling());

		sa.assertEquals(getProgBilling(), ProgBilling_PFO_Expected,
				"Prog Billing in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Over Billing']//following::*[2]")
	WebElement overBilling;

	public String getoverBilling() throws InterruptedException {

		String overBillingValue = common.getText(overBilling);

		return overBillingValue;

	}

	public void checkOverBilling() throws InterruptedException {

		boolean PTDRevenueHigher = formulas.isValue1Greater(getProgBilling(), getPTDRevenue());

		String OverBillingExpected = "0.00";

		if (PTDRevenueHigher == true) {

			OverBillingExpected = formulas.getDifference(getProgBilling(), getPTDRevenue());
		}

		logger.info("OverBilling_PFO_Expected:" + OverBillingExpected);

		logger.info("OverBilling_PFO_Actual:" + getoverBilling());

		sa.assertEquals(getoverBilling(), OverBillingExpected, "OverBilling in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Under Billing']//following::*[2]")
	WebElement underBilling;

	public String getunderBilling() throws InterruptedException {

		String underBillingValue = common.getText(underBilling);

		return underBillingValue;

	}

	@FindBy(xpath = "//*[text()='% Billed']//following::*[2]")
	WebElement percentageBilled;

	public String getpercentageBilled() throws InterruptedException {

		String percentageBilledValue = common.getText(percentageBilled);

		return percentageBilledValue;

	}

	public void checkPercentageBilled() throws InterruptedException {

		String PercentageBilledExpected = formulas.getPercentageBilled(getProgBilling(), getcurrentCV());

		logger.info("Percentage Billed_PFO_Expected:" + PercentageBilledExpected);

		logger.info("Percentage Billed_PFO_Actual:" + getpercentageBilled());

		sa.assertEquals(getpercentageBilled(), PercentageBilledExpected,
				"Percentage Billed in the PFO Report is not as expected");
	}

	// Backlogs

	@FindBy(xpath = "//*[text()='Backog Revenue']//following::*[2]")
	WebElement BacklogRevenue;

	public String getBacklogRevenue() throws InterruptedException {

		String BacklogRevenueValue = common.getText(BacklogRevenue);

		return BacklogRevenueValue;

	}

	public void checkBacklogRevenue() throws InterruptedException {

		String BacklogRevenue = formulas.getDifference(getcurrentCV(), getPTDRevenue());

		logger.info("BacklogRevenue_PFO_Expected:" + BacklogRevenue);

		logger.info("BacklogRevenue_PFO_Actual:" + getBacklogRevenue());

		sa.assertEquals(getBacklogRevenue(), BacklogRevenue, "Backlog Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Backlog Cost']//following::*[2]")
	WebElement BacklogCost;

	public String getBacklogCost() throws InterruptedException {

		String BacklogCostValue = common.getText(BacklogCost);

		return BacklogCostValue;

	}

	public void checkBacklogCost() throws InterruptedException {

		String BacklogCost = formulas.getDifference(getECACcost_ECAC(), getPTDCost());

		logger.info("Backlog Cost_PFO_Expected:" + BacklogCost);

		logger.info("Backlog Cost_PFO_Actual:" + getBacklogCost());

		sa.assertEquals(getBacklogCost(), BacklogCost, "Backlog Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Backlog Margin']//following::*[2]")
	WebElement BacklogMargin;

	public String getBacklogMargin() throws InterruptedException {

		String BacklogMarginValue = common.getText(BacklogMargin);

		return BacklogMarginValue;

	}

	public void checkBacklogMargin() throws InterruptedException {

		String BacklogMargin = formulas.getDifference(getBacklogRevenue(), getBacklogCost());

		logger.info("Backlog Margin_PFO_Expected:" + BacklogMargin);

		logger.info("Backlog Margin_PFO_Actual:" + getBacklogMargin());

		sa.assertEquals(getBacklogMargin(), BacklogMargin, "Backlog Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Backlog Billing']//following::*[2]")
	WebElement BacklogBilling;

	public String getBacklogBilling() throws InterruptedException {

		String BacklogBillingValue = common.getText(BacklogBilling);

		return BacklogBillingValue;

	}

	public void checkBacklogBilling() throws InterruptedException {

		String BacklogBilling = formulas.getDifference(getcurrentCV(), getProgBilling());

		logger.info("Backlog Billing_PFO_Expected:" + BacklogBilling);

		logger.info("Backlog Billing_PFO_Actual:" + getBacklogBilling());

		sa.assertEquals(getBacklogBilling(), BacklogBilling, "Backlog Billing in the PFO Report is not as expected");
	}

	public void checkPFOReportData(String arg1, String arg2) throws InterruptedException {

		if (arg2.equals("PFO Report")) {

			if (arg1.equals("Original")) {

				checkgetOrigContractValue();

				checkOrigCostBudget();

				checkOrigGM();

				checkgetOrigGMPercentage();
			}

			if (arg1.equals("Current")) {

				checkCurrentCV();

				checkCurrentCOBudget();

				checkCurrentGrossMargin();

				checkCurrentGMPercentage();

			}

			if (arg1.equals("ECAC")) {

				checkECACCost();

				checkTotalPOCpercentage();

				checkECACGrossMargin();

				checkECACGMPercentage();

			}

			if (arg1.equals("RevREC")) {

				checkActualCost();

				checkECACcost_RevREC();

				checkPercentageComplete();

			}

			if (arg1.equals("COST")) {

				checkCTC();

				checkCMTD();

				checkETC();

			}

			if (arg1.equals("Backlogs")) {

				checkBacklogRevenue();

				checkBacklogCost();

				checkBacklogMargin();

				checkBacklogBilling();

				checkUnpostedRevenue();

			}

			if (arg1.equals("Actuals-Month To Date")) {

				checkmtdRevenue();

				checkmtdCost();

				checkmtdMargin();

			}

			if (arg1.equals("Quarter To Date")) {

				checkQTDRevenue();

				checkQTDCost();

				checkqtdMargin();

			}

			if (arg1.equals("Year To Date")) {

				checkYTDCost();

				checkytdMargin();
			}

			if (arg1.equals("Actuals-Project To Date")) {

				checkPTDCost();

				checkPTDMargin();

				checkPTDIncurredMargin();
			}

			if (arg1.equals("Billing")) {

				checkProgBilling();

				checkOverBilling();

				checkPercentageBilled();

			}

			if (arg1.equals("AR")) {

				checkARBalance();

				checkARRetention();

				checkCashPosition();

				checkAvailableForBilling();

			}

			if (arg1.equals("Earned-Month To Date")) {

				checkMTDEarnedRevenue();

				checkMTDEarnedMargin();

				checkMTDEarnedMarginPercentage();

				checkUnpostedRevenue();

			}

			if (arg1.equals("Earned-Project To Date")) {

				checkPTDEarnedRevenue();

				checkPTDEarnedMargin();

				checkPTDEarnedMarginPercentage();
			}

			if (arg1.equals("Change Order")) {

				checkPendingCO();

				checkCOBudget();

				checkCOMargin();

				checkCOMarginPercentage();
			}

		}

		// sa.assertAll();

	}

	@FindBy(xpath = "//*[text()='Last Labor Date']//following::*[2]")
	WebElement LastLaborDate;

	public String getLastLaborDate() throws InterruptedException {

		String LastLaborDateValue = common.getText(LastLaborDate);

		return LastLaborDateValue;

	}

	@FindBy(xpath = "//*[text()='Last Invoice Date']")
	WebElement LastInvoiceDate;

	public String getLastInvoiceDate() throws InterruptedException {

		String LastInvoiceDateValue = common.getText(LastInvoiceDate);

		return LastInvoiceDateValue;

	}

	// Budget -> Original
	@FindBy(xpath = "//*[text()='Orig Contract Value']//following::*[2]")
	WebElement origContactValue;

	@FindBy(xpath = "//*[text()='Orig Cost Budget']//following::*[2]")
	WebElement origCostBudget;

	@FindBy(xpath = "//*[text()='Orig GM']//following::*[2]")
	WebElement origGM;

	@FindBy(xpath = "//*[text()='Orig GM %']//following::*[2]")
	WebElement origGMPercentage;

	// Budget -> Margin Variance

	@FindBy(xpath = "//*[text()='Margin Variance $']//following::*[2]")
	WebElement marginVarianceDollar;

	public String getMarginVarianceDollar() throws InterruptedException {

		String MarginVarianceDollar = common.getText(marginVarianceDollar);

		return MarginVarianceDollar;

	}

	public void checkMarginVarianceDollar() throws InterruptedException {

		String MarginVarianceDollar_PFO_Expected = formulas.getDifference(getECACGrossmargin(), getcurrentGM());

		logger.info("MarginVarianceDollar_PFO_Expected:" + MarginVarianceDollar_PFO_Expected);

		logger.info("MarginVarianceDollar_PFO_Actual:" + getMarginVarianceDollar());

		sa.assertEquals(getMarginVarianceDollar(), MarginVarianceDollar_PFO_Expected,
				"Margin Variance $ in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Margin Variance %']//following::*[2]")
	WebElement MarginVariancePercentage;

	public String getMarginVariancePercentage() throws InterruptedException {

		String MarginVariancePercentageValue = common.getText(MarginVariancePercentage);

		return MarginVariancePercentageValue;

	}

	public void checkMarginVariancePercentage() throws InterruptedException {

		String MarginVariancePercentage_PFO_Expected = formulas.getMarginVariancePercentage(getcurrentCV(),
				getECACcost_ECAC(), getCurrentCOBudget());

		logger.info("MarginVariancePercentage_PFO_Expected:" + MarginVariancePercentage_PFO_Expected);

		logger.info("MarginVariancePercentage_PFO_Actual:" + getMarginVariancePercentage());

		sa.assertEquals(getMarginVariancePercentage(), MarginVariancePercentage_PFO_Expected,
				"Margin Variance % in the PFO Report is not as expected");
	}

	// Actuals -> Month to date

	@FindBy(xpath = "//*[text()='MTD Revenue']//following::*[2]")
	WebElement mtdRevenue;

	public String getmtdRevenue() throws InterruptedException {

		String mtdRevenueValue = common.getText(mtdRevenue);

		return mtdRevenueValue;

	}

	public void checkmtdRevenue() throws InterruptedException {

		String MTDRevenue_PFO_Expected = RevenueRecognition.get("Unpostedrevenue");

		logger.info("MTD Revenue_PFO_Expected:" + MTDRevenue_PFO_Expected);

		logger.info("MTD Revenue_PFO_Actual:" + getmtdRevenue());

		sa.assertEquals(getmtdRevenue(), MTDRevenue_PFO_Expected, "MTD Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='MTD Cost']//following::*[2]")
	WebElement mtdCost;

	public String getmtdCost() throws InterruptedException {

		String mtdRevenueValue = common.getText(mtdCost);

		return mtdRevenueValue;

	}

	public void checkmtdCost() throws InterruptedException {

		String MTDCost_PFO_Expected = null;

		if (PFOPeriod.equals("Current Period")) {

			// MTDCost_PFO_Expected =
			// formulas.getSum(Amount_OverheadTransactions_Total_CurrentPeriod,
			// InvoiceAmountTotal);

			MTDCost_PFO_Expected = Amount_OverheadTransactions_Total_CurrentPeriod;

		}

		else if (PFOPeriod.equals("Next Period")) {

			// MTDCost_PFO_Expected =
			// formulas.getSum(Amount_OverheadTransactions_Total_NextPeriod,
			// InvoiceAmountTotal);

			MTDCost_PFO_Expected = Amount_OverheadTransactions_Total_NextPeriod;

		}

		logger.info("MTD Cost_PFO_Expected:" + MTDCost_PFO_Expected);

		logger.info("MTD Cost_PFO_Actual:" + getmtdCost());

		sa.assertEquals(getmtdCost(), MTDCost_PFO_Expected, "MTD Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='MTD Margin']//following::*[2]")
	WebElement mtdMargin;

	public String getmtdMargin() throws InterruptedException {

		String mtdMarginValue = common.getText(mtdMargin);

		return mtdMarginValue;

	}

	/*
	 * public void checkmtdMargin() throws InterruptedException {
	 * 
	 * String MTD_Margin_PFO_Expected = "";
	 * 
	 * if (formulas.isValue1Greater(getcurrentCV(), getCurrentCOBudget()) == true) {
	 * 
	 * MTD_Margin_PFO_Expected = formulas.getDifference(getmtdCost(),
	 * formulas.getDifference(getActualCost(), ActualCostValueExisting)); }
	 * 
	 * else {
	 * 
	 * MTD_Margin_PFO_Expected = getECACGrossmargin();
	 * 
	 * }
	 * 
	 * logger.info("MTD Margin_PFO_Expected:" + MTD_Margin_PFO_Expected);
	 * 
	 * logger.info("MTD Margin_PFO_Actual:" + getmtdMargin());
	 * 
	 * sa.assertEquals(getmtdMargin(), MTD_Margin_PFO_Expected,
	 * "MTD Margin in the PFO Report is not as expected"); }
	 */

	public void checkmtdMargin() throws InterruptedException {

		String MTD_Margin_PFO_Expected = "";

		if (formulas.isValue1Greater(getcurrentCV(), getCurrentCOBudget()) == true) {

			MTD_Margin_PFO_Expected = formulas.getDifference(getmtdRevenue(),
					formulas.getDifference(getActualCost(), ActualCostValueExisting));
		}

		else {

			MTD_Margin_PFO_Expected = getECACGrossmargin();

		}

		logger.info("MTD Margin_PFO_Expected:" + MTD_Margin_PFO_Expected);

		logger.info("MTD Margin_PFO_Actual:" + getmtdMargin());

		sa.assertEquals(getmtdMargin(), MTD_Margin_PFO_Expected, "MTD Margin in the PFO Report is not as expected");
	}

	// Actuals -> Quater to date

	@FindBy(xpath = "//*[text()='QTD Rev $']//following::*[2]")
	WebElement qtdRev;

	public String getqtdRev() throws InterruptedException {

		String qtdRevValue = common.getText(qtdRev);

		return qtdRevValue;

	}

	public void checkQTDRevenue() throws InterruptedException {

		String QTDRevenue_PFO_Expected = RevenueRecognition.get("Unpostedrevenue");

		logger.info("QTD Revenue_PFO_Expected:" + QTDRevenue_PFO_Expected);

		logger.info("QTD Revenue_PFO_Actual:" + getqtdRev());

		sa.assertEquals(getqtdRev(), QTDRevenue_PFO_Expected, "QTD Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='QTD Cost $']//following::*[2]")
	WebElement qtdCost;

	public String getqtdCost() throws InterruptedException {

		String qtdMostValue = common.getText(qtdCost);

		return qtdMostValue;

	}

	public void checkQTDCost() throws InterruptedException {

		String QTDCost_PFO_Expected = null;

		if (PFOPeriod.equals("Current Period")) {

			// QTDCost_PFO_Expected =
			// formulas.getSum(Amount_OverheadTransactions_Total_CurrentPeriod,
			// InvoiceAmountTotal);

			QTDCost_PFO_Expected = Amount_OverheadTransactions_Total_CurrentPeriod;

		}

		else if (PFOPeriod.equals("Next Period")) {

			// QTDCost_PFO_Expected =
			// formulas.getSum(Amount_OverheadTransactions_Total_NextPeriod,
			// InvoiceAmountTotal);

			QTDCost_PFO_Expected = Amount_OverheadTransactions_Total_NextPeriod;

		}

		logger.info("QTD Cost_PFO_Expected:" + QTDCost_PFO_Expected);

		logger.info("QTD Cost_PFO_Actual:" + getqtdCost());

		sa.assertEquals(getqtdCost(), QTDCost_PFO_Expected, "QTD Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='QTD Margin $']//following::*[2]")
	WebElement qtdMargin;

	public String getqtdMargin() throws InterruptedException {

		String qtdMarginValue = common.getText(qtdMargin);

		return qtdMarginValue;

	}

	public void checkqtdMargin() throws InterruptedException {

		String QTD_Margin_PFO_Expected = null;

		if (formulas.isValue1GreaterOrEqual(getcurrentCV(), getECACcost_ECAC())) {

			// QTD_Margin_PFO_Expected = formulas.getDifference(getPTDRevenue(),
			// getActualCost());

			QTD_Margin_PFO_Expected = formulas.getDifference(getqtdRev(),
					formulas.getDifference(getActualCost(), ActualCostValueExisting));

		}

		else {

			QTD_Margin_PFO_Expected = getECACGrossmargin();
		}

		logger.info("QTD Margin_PFO_Expected:" + QTD_Margin_PFO_Expected);

		logger.info("QTD Margin_PFO_Actual:" + getqtdMargin());

		sa.assertEquals(getqtdMargin(), QTD_Margin_PFO_Expected, "QTD Margin in the PFO Report is not as expected");
	}

	// Actuals -> Year to date

	@FindBy(xpath = "//*[text()='YTD Revenue']//following::*[2]")
	WebElement ytdRevenue;

	public String getytdRevenue() throws InterruptedException {

		String ytdRevenueValue = common.getText(ytdRevenue);

		return ytdRevenueValue;

	}

	public void checkYTDRevenue() throws InterruptedException {

		String YTDRevenue_PFO_Expected = RevenueRecognition.get("Unpostedrevenue");

		logger.info("YTD Revenue_PFO_Expected:" + YTDRevenue_PFO_Expected);

		logger.info("YTD Revenue_PFO_Actual:" + getytdRevenue());

		sa.assertEquals(getytdRevenue(), YTDRevenue_PFO_Expected, "YTD Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='YTD Cost']//following::*[2]")
	WebElement ytdCost;

	public String getytdCost() throws InterruptedException {

		String ytdCostValue = common.getText(ytdCost);

		return ytdCostValue;

	}

	public void checkYTDCost() throws InterruptedException {

		// String YTDCost_PFO_Expected =
		// formulas.getYTDCost(Amount_OverheadTransactions_Total_CurrentPeriod,
		// Amount_OverheadTransactions_Total_NextPeriod, InvoiceAmountTotal);

		if (Amount_OverheadTransactions_Total_NextPeriod == null) {

			Amount_OverheadTransactions_Total_NextPeriod = "0.00";

		}

		String YTDCost_PFO_Expected = formulas.getSum(Amount_OverheadTransactions_Total_CurrentPeriod,
				Amount_OverheadTransactions_Total_NextPeriod);

		logger.info("YTD Cost_PFO_Expected:" + YTDCost_PFO_Expected);

		logger.info("YTD Cost_PFO_Actual:" + getytdCost());

		sa.assertEquals(getytdCost(), YTDCost_PFO_Expected, "YTD Cost in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='YTD Margin']//following::*[2]")
	WebElement ytdMargin;

	public String getytdMargin() throws InterruptedException {

		String ytdMarginValue = common.getText(ytdMargin);

		return ytdMarginValue;

	}

	public void checkytdMargin() throws InterruptedException {

		String YTD_Margin_PFO_Expected = null;

		if (formulas.isValue1Greater(getOrigContractValue(), getOrigCostBudget())) {

			YTD_Margin_PFO_Expected = formulas.getDifference(getPTDRevenue(), getActualCost());
		}

		else {

			YTD_Margin_PFO_Expected = getECACGrossmargin();
		}

		logger.info("YTD Margin_PFO_Expected:" + YTD_Margin_PFO_Expected);

		logger.info("YTD Margin_PFO_Actual:" + getytdMargin());

		sa.assertEquals(getytdMargin(), YTD_Margin_PFO_Expected, "YTD Margin in the PFO Report is not as expected");
	}

	// Actuals -> AR

	@FindBy(xpath = "//*[text()='AR Balance']//following::*[2]")
	WebElement arBalance;

	public String getarBalance() throws InterruptedException {

		String arBalanceValue = common.getText(arBalance);

		return arBalanceValue;

	}

	public void checkARBalance() throws InterruptedException {

		String ARBalance_PFO_Expected = null;

		if (PFOPeriod.equals("Current Period")) {

			ARBalance_PFO_Expected = formulas.getDifference(InvoiceAmount_Invoicejournals_CurrentPeriod, CreditValue);

		}

		else if (PFOPeriod.equals("Next Period")) {

			ARBalance_PFO_Expected = InvoiceAmount_Invoicejournals_NextPeriod;

		}

		logger.info("AR Balance_PFO_Expected:" + ARBalance_PFO_Expected);

		logger.info("AR Balance_PFO_Actual:" + getarBalance());

		sa.assertEquals(getarBalance(), ARBalance_PFO_Expected, "AR Balance in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='AR Retention']//following::*[2]")
	WebElement arRetention;

	public String getarRetention() throws InterruptedException {

		String arRetentionValue = common.getText(arRetention);

		return arRetentionValue;

	}

	public void checkARRetention() throws InterruptedException {

		String ARRetention_Expected = null;

		if (PFOPeriod.equals("Current Period")) {

			ARRetention_Expected = formulas.getDifference(CustomerRetainedAmount_Invoicejournals_CurrentPeriod,
					RetentionReleaseAmount_Invoicejournals_CurrentPeriod);

		}

		else if (PFOPeriod.equals("Next Period")) {

			ARRetention_Expected = formulas.getDifference(CustomerRetainedAmount_Invoicejournals_NextPeriod,
					RetentionReleaseAmount_Invoicejournals_NextPeriod);

		}

		logger.info("AR Retention_PFO_Expected:" + ARRetention_Expected);

		logger.info("AR Retention_PFO_Actual:" + getarRetention());

		sa.assertEquals(getarRetention(), ARRetention_Expected, "AR Retention in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Cash Position']//following::*[2]")
	WebElement cashPosition;

	public String getcashPosition() throws InterruptedException {

		String cashPositionValue = common.getText(cashPosition);

		return cashPositionValue;

	}

	public void checkCashPosition() throws InterruptedException {

		String CashPositionExpected = formulas.getDifference(
				formulas.getSum(formulas.getSum(formulas.getDifference(
						formulas.getDifference(formulas.getDifference(getProgBilling(), getarBalance()), getPTDCost()),
						getarRetention()), TotalAmount_AP_Project360), TotalAmountToRetain_AP_Project360),
				TotalSettledAmount_AP_Project360);

		logger.info("Cash Position_PFO_Expected:" + CashPositionExpected);

		logger.info("Cash Position_PFO_Actual:" + getcashPosition());

		sa.assertEquals(getcashPosition(), CashPositionExpected, "Cash Position in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Available For']//following::*[text()='Billing']//following::*[2]")
	WebElement availableForBilling;

	public String getavailableForBilling() throws InterruptedException {

		String availableForBillingValue = common.getText(availableForBilling);

		return availableForBillingValue;

	}

	public void checkAvailableForBilling() throws InterruptedException {

		String AvailableForBillingExpected = formulas.getAvailableForBilling(getcurrentCV(), getTotalPOCpercentage(),
				getProgBilling());

		logger.info("Available For Billing_PFO_Expected:" + AvailableForBillingExpected);

		logger.info("Available For Billing_PFO_Actual:" + getavailableForBilling());

		sa.assertEquals(getavailableForBilling(), AvailableForBillingExpected,
				"Available For Billing in the PFO Report is not as expected");
	}

	// Earned -> Month to date

	@FindBy(xpath = "//*[text()='MTD Earned Revenue']//following::*[2]")
	WebElement mtdEarnedRevenue;

	public String getmtdEarnedRevenue() throws InterruptedException {

		String mtdEarnedRevenueValue = common.getText(mtdEarnedRevenue);

		return mtdEarnedRevenueValue;

	}

	public void checkMTDEarnedRevenue() throws InterruptedException {

		String MTDEarnedRevenueExpected = formulas.getDifference(getptdEarnedRevenue(), PTDEarnedRevenueValueExisting);

		logger.info("MTD Earned Revenue_PFO_Expected:" + MTDEarnedRevenueExpected);

		logger.info("MTD Earned Revenue_PFO_Actual:" + getmtdEarnedRevenue());

		sa.assertEquals(getmtdEarnedRevenue(), MTDEarnedRevenueExpected,
				"MTD Earned Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='MTD Earned Margin']//following::*[2]")
	WebElement mtdEarnedMargin;

	public String getmtdEarnedMargin() throws InterruptedException {

		String mtdEarnedMarginValue = common.getText(mtdEarnedMargin);

		return mtdEarnedMarginValue;

	}

	public void checkMTDEarnedMargin() throws InterruptedException {

		String MTDEarnedMarginExpected = formulas.getDifference(getptdEarnedMargin(), PTDEarnedMarginValueExisting);

		logger.info("MTD Earned Margin_PFO_Expected:" + MTDEarnedMarginExpected);

		logger.info("MTD Earned Margin_PFO_Actual:" + getmtdEarnedMargin());

		sa.assertEquals(getmtdEarnedMargin(), MTDEarnedMarginExpected,
				"MTD Earned Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='MTD Earned Margin %']//following::*[2]")
	WebElement mtdEarnedMarginPercentage;

	public String getmtdEarnedMarginPercentage() throws InterruptedException {

		String mtdEarnedMarginPercentageValue = common.getText(mtdEarnedMarginPercentage);

		return mtdEarnedMarginPercentageValue;

	}

	public void checkMTDEarnedMarginPercentage() throws InterruptedException {

		String MTDEarnedMarginPercentageExpected = formulas.getPTDEarnedMarginPercentage(getmtdEarnedMargin(),
				getmtdEarnedRevenue());

		logger.info("MTD Earned Margin Percentage_PFO_Expected:" + MTDEarnedMarginPercentageExpected);

		logger.info("MTD Earned Margin Percentage_PFO_Actual:" + getmtdEarnedMarginPercentage());

		sa.assertEquals(getmtdEarnedMarginPercentage(), MTDEarnedMarginPercentageExpected,
				"MTD Earned Margin Percentage in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='Unposted Revenue']//following::*[2]")
	WebElement unpostedRevenue;

	public String getunpostedRevenue() throws InterruptedException {

		String unpostedRevenueValue = common.getText(unpostedRevenue);

		return unpostedRevenueValue;

	}

	public void checkUnpostedRevenue() throws InterruptedException {

		String UnpostedRevenueExpected = formulas.getUnpostedRevenue(getcurrentCV(), getpercentageComplete(),
				getPTDRevenue());

		logger.info("Unposted Revenue_PFO_Expected:" + UnpostedRevenueExpected);

		logger.info("Unposted Revenue_PFO_Actual:" + getunpostedRevenue());

		sa.assertEquals(getunpostedRevenue(), UnpostedRevenueExpected,
				"Unposted Revenue in the PFO Report is not as expected");
	}

	// Earned -> Project to date

	@FindBy(xpath = "//*[text()='PTD Earned Revenue']//following::*[2]")
	WebElement ptdEarnedRevenue;

	public String getptdEarnedRevenue() throws InterruptedException {

		String PTDEarnedRevenueValue = common.getText(ptdEarnedRevenue);

		return PTDEarnedRevenueValue;

	}

	public void checkPTDEarnedRevenue() throws InterruptedException {

		String PTDEarnedRevenueExpected = formulas.getInvoiceAmount(getcurrentCV(), getpercentageComplete());

		logger.info("PTD Earned Revenue_PFO_Expected:" + PTDEarnedRevenueExpected);

		logger.info("PTD Earned Revenue_PFO_Actual:" + getptdEarnedRevenue());

		sa.assertEquals(getptdEarnedRevenue(), PTDEarnedRevenueExpected,
				"PTD Earned Revenue in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='PTD Earned Margin']//following::*[2]")
	WebElement ptdEarnedMargin;

	public String getptdEarnedMargin() throws InterruptedException {

		String PTDEarnedMarginValue = common.getText(ptdEarnedMargin);

		return PTDEarnedMarginValue;

	}

	public void checkPTDEarnedMargin() throws InterruptedException {

		String PTDEarnedMarginExpected = formulas.getPTDEarnedMargin(getcurrentCV(), getpercentageComplete(),
				getECACGMPercentage());

		logger.info("PTD Earned Margin_PFO_Expected:" + PTDEarnedMarginExpected);

		logger.info("PTD Earned Margin_PFO_Actual:" + getptdEarnedMargin());

		sa.assertEquals(getptdEarnedMargin(), PTDEarnedMarginExpected,
				"PTD Earned Margin in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//*[text()='PTD Earned Margin %']//following::*[2]")
	WebElement ptdEarnedMarginPercentage;

	public String getptdEarnedMarginPercentage() throws InterruptedException {

		String ptdEarnedMarginPercentageValue = common.getText(ptdEarnedMarginPercentage);

		return ptdEarnedMarginPercentageValue;

	}

	public void checkPTDEarnedMarginPercentage() throws InterruptedException {

		String PTDEarnedMarginPercentageExpected = formulas.getPTDEarnedMarginPercentage(getptdEarnedMargin(),
				getptdEarnedRevenue());

		logger.info("PTD Earned Margin Percentage_PFO_Expected:" + PTDEarnedMarginPercentageExpected);

		logger.info("PTD Earned Margin Percentage_PFO_Actual:" + getptdEarnedMarginPercentage());

		sa.assertEquals(getptdEarnedMarginPercentage(), PTDEarnedMarginPercentageExpected,
				"PTD Earned Margin Percentage in the PFO Report is not as expected");
	}

	@FindBy(xpath = "//iframe[@title='Project financial overview detail']")
	WebElement Projectfinancialoverviewdetail_report;

	public void switchToProjectFinancialOverviewDetailReport() throws InterruptedException {

		common.switchToIframe(Projectfinancialoverviewdetail_report);

	}

	@FindBy(xpath = "//*[@aria-label='Budget category' and @type='text']")
	List<WebElement> BudgetCategories_list;

	@FindBy(xpath = "(//*[contains(@aria-labelledby,'ExcludeFromRevRec')])[2]")
	WebElement ExcludefromRevRec;

	@FindBy(xpath = "//*[contains(@aria-label,'Category')]")
	List<WebElement> Categories;

	public ArrayList<String> getProjectCategoriesList() throws InterruptedException {

		ArrayList<String> CategoriesValue = new ArrayList<String>();

		for (WebElement Category : Categories) {

			CategoriesValue.add(Category.getAttribute("value"));
		}
		return CategoriesValue;

	}

	/*
	 * public void getBudgetCategoriesData() throws InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * BudgetCategories_ExcludedFromRevRec = new ArrayList<String>();
	 * 
	 * BudgetCategories_RevenueType = new ArrayList<String>();
	 * 
	 * BudgetCategories_ExpenseType = new ArrayList<String>();
	 * 
	 * BudgetCategory_ProjectCategories_Mapping = new HashMap<String,
	 * ArrayList<String>>();
	 * 
	 * for (WebElement BudgetCategory : BudgetCategories_list) {
	 * 
	 * common.clickElement(BudgetCategory);
	 * 
	 * String BudgetCategoryValue = common.getValue(BudgetCategory);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (ExcludefromRevRec.getAttribute("aria-checked").equals("true")) {
	 * 
	 * BudgetCategories_ExcludedFromRevRec.add(BudgetCategoryValue);
	 * 
	 * }
	 * 
	 * if (common.getValue(Type).equals("Revenue")) {
	 * 
	 * BudgetCategories_RevenueType.add(BudgetCategoryValue);
	 * 
	 * }
	 * 
	 * if (common.getValue(Type).equals("Expense")) {
	 * 
	 * BudgetCategories_ExpenseType.add(BudgetCategoryValue);
	 * 
	 * }
	 * 
	 * BudgetCategory_ProjectCategories_Mapping.put(BudgetCategoryValue,
	 * getProjectCategoriesList());
	 * 
	 * }
	 * 
	 * logger.info("BudgetCategories_ExcludedFromRevRec: " +
	 * BudgetCategories_ExcludedFromRevRec);
	 * 
	 * logger.info("BudgetCategories_RevenueType: " + BudgetCategories_RevenueType);
	 * 
	 * logger.info("BudgetCategories_ExpenseType: " + BudgetCategories_ExpenseType);
	 * 
	 * logger.info("BudgetCategory_ProjectCategories_Mapping: " +
	 * BudgetCategory_ProjectCategories_Mapping);
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[text()='Budget categories']")
	WebElement Budgetcategories;

	public void clickBudgetcategories() throws InterruptedException {

		common.clickElement(Budgetcategories);

	}

	@FindBy(xpath = "//*[@name='Overview_BudgetCategoryType']")
	WebElement Type;

	// --------------Project allocation rule-----------------

	// Navigation
	// PCM -> Overhead allocation
	@FindBy(xpath = "//*[@aria-label='Overhead allocation']")
	WebElement Overheadallocation;

	// PCM -> Overhead allocation -> Project allocation rule
	@FindBy(xpath = "(//*[text()='Project allocation rules'])[2]")
	WebElement Projectallocationrules;

	// -----------Hour journal--------------------

	// To click Lines tab

	// To click Validate tab
	@FindBy(xpath = "(//*[text()='Validate'])[2]")
	WebElement Validate_Journal;

	// To click Financial dimensions tab
	@FindBy(xpath = "//*[text()='Financial dimensions']")
	WebElement Financialdimensions_Journal;

	// To click Log tab
	@FindBy(xpath = "(//*[text()='Log'])[2]")
	WebElement Log_Journal;

	// To click Functions tab
	@FindBy(xpath = "(//*[contains(@id,'Functions')])[3]")
	WebElement Functions_Journal;

	// To click Trade agreement tab
	@FindBy(xpath = "(//*[contains(@id,'TradeAgreement')])[5]")
	WebElement Tradeagreement_Journal;

	// To click Options tab
	@FindBy(xpath = "(//*[text()='Options'])[3]")
	WebElement Options_Journal;

	// To click Lines
	@FindBy(xpath = "(//*[text()='New'])[4]")
	WebElement New_Journal;

	// To enter Activity number
	@FindBy(xpath = "(//*[text()='Activity number']//following::*[contains(@id,'ActivityNumber')])[3]")
	WebElement Activitynumber_Journal;

	// To enter Resource ID
	@FindBy(xpath = "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[5]")
	WebElement Resourceid_Journal;

	// To enter Resource name
	@FindBy(xpath = "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[7]")
	WebElement Resource_Journal;

	// To enter Resource Role ID
	@FindBy(xpath = "(//*[text()='Role ID']//following::*[contains(@id,'ResourceCategory')])[3]")
	WebElement RoleID_Journal;

	// To enter Description
	@FindBy(xpath = "(//*[text()='Description']//following::*[contains(@id,'Txt')])[4]")
	WebElement Description_Journal;

	// To enter Hours
	@FindBy(xpath = "(//*[text()='Hours']//following::*[contains(@id,'ctrlProjQty')])[3]")
	WebElement Hours_Journal;

	// To enter Timesheet number
	@FindBy(xpath = "(//*[text()='Timesheet number']//following::*[contains(@id,'TimesheetNumber')])[3]")
	WebElement Timesheetnumber_Journal;

	// To enter Line number
	@FindBy(xpath = "(//*[text()='Line number']//following::*[contains(@id,'LineNum')])[3]")
	WebElement Linenumber_Journal;

	// To enter Line property
	@FindBy(xpath = "(//*[text()='Line property']//following::*[contains(@id,'LinePropertyId')])[3]")
	WebElement Lineproperty_Journal;

	// Reversing entry has to be taken

	// To enter Reversing date
	@FindBy(xpath = "(//*[text()='Reversing date']//following::*[contains(@id,'ReverseDate')])[3]")
	WebElement Reversingdate_Journal;

	// Log has to be taken

	// Click Overview subtab
	@FindBy(xpath = "(//*[text()='Overview'])[2]")
	WebElement Overview_Journal;

	// Enter Hours in general subtab
	@FindBy(xpath = "//*[text()='Hours']//following::*[@name='CostPrice_Qty']")
	WebElement Hours_GeneraltabJournal;

	// Enter Cost price in subgeneral tab
	@FindBy(xpath = "//*[text()='Cost price']//following::*[@name='CostPrice_CostPrice']")
	WebElement Costprice_Journal;

	// Enter Hours in general subtab
	@FindBy(xpath = "//*[text()='Sales price']//following::*[@name='SalesPrice_SalesPrice']")
	WebElement Salesprice_Journal;

// Click Delete Button
	@FindBy(xpath = "(//*[text()='Delete'])[3]")
	WebElement Delete_Journal;

	// Click Save Button
	@FindBy(xpath = "(//*[text()='Save'])[2]")
	WebElement Save_Journal;

	// To select all rows
	@FindBy(xpath = "(//*[@title='Select or unselect all rows'])[3]")
	WebElement Selectorunselectallrows_Journals;

	// ----------------------------Item Journal-----------------------

	// To Click Open in XL tab
	@FindBy(xpath = "//*[text()='Open in Excel']")
	WebElement OpeninExcel_Journal;

	// To Click Print tab
	@FindBy(xpath = "//*[text()='Print']")
	WebElement Print_Journal;

	// Overview -> Name field
	@FindBy(xpath = "(//*[text()='Name']//following::*[contains(@id,'JournalNameId')])[3]")
	WebElement Name_Journal;

	// click Item field
	@FindBy(xpath = "( //*[text()='Item number']//following::*[contains(@id,'ItemId')])[3]")
	WebElement Itemnumber_Journal;

	// click Quantity field

	// click Cost price field
	@FindBy(xpath = "( //*[text()='Cost price']//following::*[contains(@id,'CostPrice')])[3]")
	WebElement Costprice_ItemJournal;

	// click Cost amount field
	@FindBy(xpath = "( //*[text()='Cost amount']//following::*[contains(@id,'CostAmount')])[3]")
	WebElement Costamount_Journal;

	// click Activity number field
	@FindBy(xpath = "(//*[text()='Activity number']//following::*[contains(@id,'PSAeditActivityPurposeNew')])[3]")
	WebElement Activitynumber_ItemJournal;

	// Project Subtab -> Charge type
	@FindBy(xpath = "//*[text()='Charge type']//following::*[contains(@name,'EquipmentChargeType')]")
	WebElement Chargetype_Journal;

	// Product dimensions Subtab -> Warehouse
	@FindBy(xpath = "//*[text()='Warehouse']//following::*[contains(@name,'InventLocationId')]")
	WebElement Warehouse_Journal;

	// Product dimensions Subtab -> Site
	@FindBy(xpath = "//*[text()='Site']//following::*[contains(@name,'InventSiteId')]")
	WebElement Site_Journal;

	// -------------------------Expense Journal----------------------------

	// To click Financial dimensions tab Expense Journal
	@FindBy(xpath = "(//*[text()='Financial dimensions'])[2]")
	WebElement Financialdimensions_ExpenseJournal;

	// To click Sales tax tab Expense Journal
	@FindBy(xpath = "//*[text()='Sales tax']")
	WebElement Salestax_ExpenseJournal;

	// To click Inquiries tab Expense Journal
	@FindBy(xpath = "(//*[text()='Inquiries'])[2]")
	WebElement Inquiries_ExpenseJournal;

	// To click Print tab Expense Journal
	@FindBy(xpath = "(//*[text()='Print'])[2]")
	WebElement Print_ExpenseJournal;

	// To click Overview Subtab Expense Journal
	@FindBy(xpath = "//*[text()='Overview']")
	WebElement Overview_ExpenseJournal;

	// To click History Subtab Expense Journal
	@FindBy(xpath = "(//*[text()='History'])[2]")
	WebElement History_ExpenseJournal;

	// To click 1099 Subtab Expense Journal
	@FindBy(xpath = "//*[text()='1099']")
	WebElement Lastsubtab_ExpenseJournal;

// click Overview -> Project 
	@FindBy(xpath = "((//*[text()='Project'])[4]//following::*[contains(@id,'AccountNum')])[5]")
	WebElement Project_ExpenseJournal;

	// click Overview -> Resorce Id
	@FindBy(xpath = "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[4]")
	WebElement ResourceId_ExpenseJournal;

	// click Overview -> Quantity field
	@FindBy(xpath = "(//*[text()='Quantity']//following::*[contains(@id,'ProjQty')])[3]")
	WebElement Quantity_ExpenseJournal;

	// click Overview -> Currency field
	@FindBy(xpath = "(//*[text()='Currency']//following::*[contains(@id,'CurrencyCode')])[3]")
	WebElement Currency_ExpenseJournal;

	// click Overview -> Sales price field

	// click Overview -> Line property field
	@FindBy(xpath = "(//*[text()='Line property']//following::*[contains(@id,'ProjStatusId')])[3]")
	WebElement Lineproperty_ExpenseJournal;

	// click Overview -> Offset account type field
	@FindBy(xpath = "(//*[text()='Offset account type']//following::*[contains(@id,'OffsetAccountType')])[3]")
	WebElement Offsetaccounttype_ExpenseJournal;

	// click Overview -> Offset account field
	@FindBy(xpath = "(//*[text()='Offset account']//following::*[contains(@id,'OffsetAccount')])[8]")
	WebElement Offsetaccount_ExpenseJournal;

	/*
	 * // --------------------Overhead transactions in //
	 * journal---------------------------- // click Transaction ID field
	 * 
	 * @FindBy(xpath =
	 * "((//*[text()='Transaction ID'])[2]//following::*[contains(@id,'TransId')])[3]"
	 * ) WebElement TransactionID_OverheadTransactions;
	 * 
	 * // click Project ID field
	 * 
	 * @FindBy(xpath =
	 * "((//*[text()='Project ID'])[2]//following::*[contains(@id,'SISMOPSOverheadTransaction_ProjId')])[4]"
	 * ) WebElement ProjectID_OverheadTransactions;
	 * 
	 * // click Date field
	 * 
	 * @FindBy(xpath =
	 * "((//*[text()='Date'])[2]//following::*[contains(@id,'SISMOPSOverheadTransaction_TransDate')])[3]")
	 * WebElement Date_OverheadTransactions;
	 * 
	 * // click Task code field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Task code']//following::*[contains(@id,'TaskCode')])[10]")
	 * WebElement Taskcode_OverheadTransactions;
	 * 
	 * // click Quantity field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Quantity']//following::*[contains(@id,'Qty')])[10]") WebElement
	 * Quantity_OverheadTransactions;
	 * 
	 * // click Priority field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Priority']//following::*[contains(@id,'Priority')])[4]")
	 * WebElement Priority_OverheadTransactions;
	 * 
	 * // click Item number field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Item number']//following::*[contains(@id,'ItemId')])[4]")
	 * WebElement Itemnumber_OverheadTransactions;
	 * 
	 * // click Item group field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Item group']//following::*[contains(@id,'ItemGroup')])[4]")
	 * WebElement Itemgroup_OverheadTransactions;
	 * 
	 * // click Source category field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Source category']//following::*[contains(@id,'SourceCategoryId')])[4]"
	 * ) WebElement Sourcecategory_OverheadTransactions;
	 * 
	 * // click category ID field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Category ID']//following::*[contains(@id,'CategoryId')])[8]")
	 * WebElement CategoryID_OverheadTransactions;
	 * 
	 * // click Rule ID field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Rule ID']//following::*[contains(@id,'RuleID')])[4]")
	 * WebElement RuleID_OverheadTransactions;
	 * 
	 * // click Rate value field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Rate value']//following::*[contains(@id,'RateValue')])[4]")
	 * WebElement Ratevalue_OverheadTransactions;
	 * 
	 * // click Total cost price field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Total cost price']//following::*[contains(@id,'TotalCostPrice')])[4]"
	 * ) WebElement Totalcostprice_OverheadTransactions;
	 * 
	 * // click Rate percent field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Rate percent']//following::*[contains(@id,'RatePercent')])[4]")
	 * WebElement Ratepercent_OverheadTransactions;
	 * 
	 * // click Amount field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Amount']//following::*[contains(@id,'Amount')])[4]") WebElement
	 * Amount_OverheadTransactions;
	 * 
	 * // click Cost price field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Cost price']//following::*[contains(@id,'CostPrice')])[14]")
	 * WebElement Costprice_OverheadTransactions;
	 * 
	 * // click Currency field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Currency']//following::*[contains(@id,'Currency')])[10]")
	 * WebElement Currency_OverheadTransactions;
	 * 
	 * // click Journal field
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Journal']//following::*[contains(@id,'JournalId')])[4]")
	 * WebElement Journal_OverheadTransactions;
	 */
	// Click General tab - contract
	/*
	 * @FindBy(xpath = "(//*[text()='General'])") WebElement General1;
	 * 
	 * @FindBy(xpath = "(//*[text()='General'])[2]") WebElement General2;
	 * 
	 * public void clickGeneral() throws InterruptedException {
	 * 
	 * try {
	 * 
	 * common.clickElementJS(General1); }
	 * 
	 * catch (Exception e) {
	 * 
	 * common.clickElementJS(General2);
	 * 
	 * }
	 * 
	 * Thread.sleep(5000);
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Select transactions'])")
	WebElement Selecttransactions;

	public void clickSelecttransactions() throws InterruptedException {

		Thread.sleep(3000);

		common.clickElementJS(Selecttransactions);

	}

	@FindBy(xpath = "//*[text()='Search' and contains(@id,'ConstructionContract')]")
	WebElement Search;

	public void clickSearch() throws InterruptedException {

		common.clickElement(Search);

	}

	@FindBy(xpath = "//*[text()='Select all']")
	WebElement Selectall;

	public void clickSelectall() throws InterruptedException {

		common.clickElement(Selectall);

		Thread.sleep(5000);

	}

	/*
	 * @FindBy(xpath =
	 * "//*[text()='Total']//following::div[@role='columnheader'][18]//child::*[@role='button']//following::div[1]")
	 * WebElement Totalsalesprice_Contract;
	 * 
	 * public String getTotalsalesprice_Contract() throws InterruptedException {
	 * 
	 * Thread.sleep(5000);
	 * 
	 * String TotalSalesAmount = common.getText(Totalsalesprice_Contract);
	 * 
	 * return TotalSalesAmount; }
	 * 
	 * @FindBy(xpath =
	 * "//*[text()='Total']//following::div[@role='columnheader'][17]//child::*[@role='button']//following::div[1]")
	 * WebElement Totalcost_Contract;
	 * 
	 * public String getTotalcost_Contract() throws InterruptedException {
	 * 
	 * Thread.sleep(2000);
	 * 
	 * String TotalCostAmount = common.getText(Totalcost_Contract);
	 * 
	 * return TotalCostAmount; }
	 */

	public void checkTotalSalesAmount() throws InterruptedException {

		logger.info("Total Sales Amount Expected: " + TotalSalesAmount);

		logger.info("Total Sales Amount Actual: " + getTotalsalesprice_Contract());

		Assert.assertEquals(getTotalsalesprice_Contract(), TotalSalesAmount, "Total Sales Amount is not as expected");
	}

	public void checkTotalCostAmount() throws InterruptedException {

		logger.info("Total Cost Amount Expected: " + TotalCostAmount);

		logger.info("Total Cost Amount Actual: " + getTotalcost_Contract());

		Assert.assertEquals(getTotalcost_Contract(), TotalCostAmount,
				"Total Cost Amount in Contract Project Transaction is not as expected");
	}

	public void checkTotalInContracts(String arg1) throws InterruptedException {

		if (arg1.equals("Total sales price")) {

			checkTotalSalesAmount();
		}

		if (arg1.equals("Total cost")) {

			checkTotalCostAmount();
		}

	}

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[2]")
	WebElement Close_ProjectTransactions;

	public void clickClose_ProjectTransactions() throws InterruptedException {

		common.clickElement(Close_ProjectTransactions);

	}

	@FindBy(xpath = "//*[contains(@id,'MOPSCostWorkInPlace') and @aria-label='Costs']")
	List<WebElement> Costs_ContractOverview;

	public String getTotalCost_ContractOverview() throws InterruptedException {

		String TotalCost = "0.00";

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		for (WebElement Cost_ContractOverview : Costs_ContractOverview) {

			String Cost = common.getValue(Cost_ContractOverview).replace(",", "");

			TotalCost = TotalCost.replace(",", "");

			logger.info("TotalCost:" + TotalCost);

			logger.info("Cost:" + Cost);

			TotalCost = df.format(Double.parseDouble(TotalCost) + Double.parseDouble(Cost));

		}

		return TotalCost;
	}

	public void checkTotalCostInContractOverview() throws InterruptedException {

		Thread.sleep(10000);

		String TotalCostInContractOverview = getTotalCost_ContractOverview();

		logger.info("Total Cost Expected: " + TotalCostAmount);

		logger.info("Total Cost Actual: " + TotalCostInContractOverview);

		Assert.assertEquals(TotalCostInContractOverview, TotalCostAmount,
				"Total Cost Amount in Contract Overview is not as expected");

	}

	public void checkWorkInPlace(String ScheduledValue, String PercentComplete, String WorkInPlace,
			String DescriptionValue) throws InterruptedException {

		String ExpectedWorkInPlace = formulas.getWorkInPlace(ScheduledValue, PercentComplete);

		logger.info("Work in place Expected: " + ExpectedWorkInPlace);

		logger.info("Work in place Actual: " + WorkInPlace);

		Assert.assertEquals(WorkInPlace, ExpectedWorkInPlace,
				"Work in place in Contract is not as expected for " + DescriptionValue);

	}

	public void checkWorkInPlaceWithoutPercentCompleteUpdate(String InvoiceAmount, String WorkInPlace,
			String DescriptionValue) throws InterruptedException {

		logger.info("Work in place Expected: " + InvoiceAmount);

		logger.info("Work in place Actual: " + WorkInPlace);

		Assert.assertEquals(WorkInPlace, InvoiceAmount,
				"Work in place in Contract is not as expected for " + DescriptionValue);

	}

	public void checkAmountRemaining(String ScheduledValue, String WorkInPlace, String AmountRemaining,
			String DescriptionValue) throws InterruptedException {

		String ExpectedAmountRemaining = formulas.getAmountRemaining(ScheduledValue, WorkInPlace);

		logger.info("Amount Remaining Expected: " + ExpectedAmountRemaining);

		logger.info("Amount Remaining Actual: " + WorkInPlace);

		Assert.assertEquals(AmountRemaining, ExpectedAmountRemaining,
				"Amount Remaining in Contract is not as expected for " + DescriptionValue);

	}

	public void checkInvoiceAmount(ArrayList<ArrayList<String>> ConstructionContract, String InvoiceAmount,
			String DescriptionValue) throws InterruptedException {

		String InvoiceAmountExpected = "0.00";

		for (ArrayList<String> Contract : ConstructionContract) {

			String Description_Contract = Contract.get(0);

			if (DescriptionValue.equals(Description_Contract)) {

				String ContractTasks = Contract.get(2);

				if (!ContractTasks.equals("")) {

					String TaskCodes[] = ContractTasks.split(";");

					for (int i = 0; i < TaskCodes.length; i++) {

						String TaskCode = TaskCodes[i];

						String Amount = InvoiceAmount_Journals.get(TaskCode);

						if (Amount == null) {

							Amount = "0.00";
						}
						InvoiceAmountExpected = formulas.getSum(InvoiceAmountExpected, Amount);

					}

					break;
				}

			}
		}

		Assert.assertEquals(InvoiceAmount, InvoiceAmountExpected,
				"Invoice Amount in Contract is not as expected for Description: " + DescriptionValue);

	}

	public void checkInvoiceAmount(String ScheduledValue, String PercentComplete, String InvoiceAmount,
			String DescriptionValue) throws InterruptedException {

		String ExpectedInvoiceAmount = formulas.getInvoiceAmount(ScheduledValue, PercentComplete);

		logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmount);

		logger.info("Invoice Amount Actual: " + InvoiceAmount);

		Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmount,
				"Invoice Amount in Contract is not as expected for " + DescriptionValue);

	}

	public void checkRetainageAmount(String InvoiceAmount, String RetainagePercentage, String RetainageAmount,
			String DescriptionValue) throws InterruptedException {

		String ExpectedRetainageAmount = formulas.getRetainageAmount(InvoiceAmount, RetainagePercentage);

		logger.info("Retainage Amount Expected: " + ExpectedRetainageAmount);

		logger.info("Retainage Amount Actual: " + RetainageAmount);

		Assert.assertEquals(RetainageAmount, ExpectedRetainageAmount,
				"Retainage Amount in Contract is not as expected for " + DescriptionValue);

	}

	public void checkRetainageAmount(String InvoiceAmount, String RetainagePercentage, String RetainageAmount,
			String TotalRetainage, String PrevRetainage, boolean RetentionCalcAtApplicationStatus,
			String DescriptionValue) throws InterruptedException {

		String ExpectedRetainageAmount = "";

		if (RetentionCalcAtApplicationStatus == true) {

			ExpectedRetainageAmount = formulas.getProdOfTwoValuesDivHundred(InvoiceAmount, RetainagePercentage);

		}

		else if (RetentionCalcAtApplicationStatus == false) {

			ExpectedRetainageAmount = formulas.getDifference(TotalRetainage, PrevRetainage);

		}

		logger.info("Retainage Amount Expected: " + ExpectedRetainageAmount);

		logger.info("Retainage Amount Actual: " + RetainageAmount);

		Assert.assertEquals(RetainageAmount, ExpectedRetainageAmount,
				"Retainage Amount in Contract is not as expected for " + DescriptionValue);

	}

	public void checkTotalRetainage(String RetainageAmount, String PrevRetainage, String TotalRetainage,
			String DescriptionValue) throws InterruptedException {

		String ExpectedTotalRetainage = formulas.getSum(RetainageAmount, PrevRetainage);

		logger.info("Total Retainage Expected: " + ExpectedTotalRetainage);

		logger.info("Total Retainage Actual: " + TotalRetainage);

		Assert.assertEquals(TotalRetainage, ExpectedTotalRetainage,
				"Total Retainage in Contract is not as expected for " + DescriptionValue);

	}

	public void checkTotalRetainage(String RetainageAmount, String PrevRetainage, String WorkInPlace,
			String RetainagePercentage, String TotalRetainage, boolean RetentionCalcAtApplicationStatus,
			String DescriptionValue) throws InterruptedException {

		String ExpectedTotalRetainage = "";

		if (RetentionCalcAtApplicationStatus == true) {

			ExpectedTotalRetainage = formulas.getSum(RetainageAmount, PrevRetainage);

		}

		else if (RetentionCalcAtApplicationStatus == false) {

			ExpectedTotalRetainage = formulas.getProdOfTwoValuesDivHundred(WorkInPlace, RetainagePercentage);

		}

		logger.info("Total Retainage Expected: " + ExpectedTotalRetainage);

		logger.info("Total Retainage Actual: " + TotalRetainage);

		Assert.assertEquals(TotalRetainage, ExpectedTotalRetainage,
				"Total Retainage in Contract is not as expected for " + DescriptionValue);

	}

	public void checkInvoiceAmountAfterPercentCompleteUpdate(String ScheduledValue, String PercentComplete,
			String InvoiceAmount, String DescriptionValue) throws InterruptedException {

		String ExpectedInvoiceAmount = formulas.getWorkInPlace(ScheduledValue, PercentComplete);

		logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmount);

		logger.info("Invoice Amount Actual: " + InvoiceAmount);

		Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmount,
				"Invoice Amount in Contract is not as expected after percent complete update for " + DescriptionValue);

	}

	public void checkWorkInPlaceAfterPercentCompleteUpdate(String ScheduledValue, String PercentComplete,
			String WorkInPlace, String DescriptionValue) throws InterruptedException {

		String ExpectedWorkInPlace = formulas.getWorkInPlace(ScheduledValue, PercentComplete);

		logger.info("Work In Place Expected: " + ExpectedWorkInPlace);

		logger.info("Work In Place Actual: " + WorkInPlace);

		Assert.assertEquals(WorkInPlace, ExpectedWorkInPlace,
				"Work In Place in Contract is not as expected after percent complete update for " + DescriptionValue);

	}

	/*
	 * public void setUpdatedContractAndValidateCalculations() throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * clickEdit();
	 * 
	 * for (ArrayList<String> UpdateContract : UpdateContracts) {
	 * 
	 * String DescriptionValue = UpdateContract.get(0);
	 * 
	 * String PercentCompleteValue = UpdateContract.get(1);
	 * 
	 * WebElement Description = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']"));
	 * 
	 * common.clickElement(Description);
	 * 
	 * WebElement PercentComplete =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Percent complete'][1]"));
	 * 
	 * common.setTextAfterDelete(PercentComplete, PercentCompleteValue);
	 * 
	 * clickRefresh();
	 * 
	 * WebElement ScheduledValueElement =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Scheduled value'][1]"));
	 * 
	 * String ScheduledValue = common.getValue(ScheduledValueElement);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement InvoiceAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));
	 * 
	 * String InvoiceAmountvalue = common.getValue(InvoiceAmount);
	 * 
	 * checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue, InvoiceAmountvalue, DescriptionValue);
	 * 
	 * WebElement RetainagePercentage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage %'][1]"));
	 * 
	 * String RetainagePercentagevalue = common.getValue(RetainagePercentage);
	 * 
	 * WebElement RetainageAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage amount'][1]"));
	 * 
	 * String RetainageAmountvalue = common.getValue(RetainageAmount);
	 * 
	 * checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
	 * RetainageAmountvalue, DescriptionValue);
	 * 
	 * WebElement PrevRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * WebElement TotalRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Total retainage'][1]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
	 * TotalRetainagevalue, DescriptionValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));
	 * 
	 * String WorkInPlacevalue = common.getValue(WorkInPlace);
	 * 
	 * checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue, WorkInPlacevalue, DescriptionValue);
	 * 
	 * WebElement AmountRemaining =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Amount remaining'][1]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue,
	 * DescriptionValue);
	 * 
	 * }
	 * 
	 * clickSave_Contract(); }
	 */

	/*
	 * @FindBy(xpath =
	 * "//*[@aria-label='Line num' and contains(@id,'GridProjLines')]")
	 * List<WebElement> NumberofLinesInContractOverview;
	 * 
	 * public int getNumberofLinesInContractOverview() throws InterruptedException {
	 * 
	 * return NumberofLinesInContractOverview.size();
	 * 
	 * }
	 */

	public void checkContractCalculations() throws InterruptedException {

		Thread.sleep(3000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement ScheduledValueElement = ldriver
					.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + row + "]"));

			String ScheduledValue = common.getValue(ScheduledValueElement);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountvalue = common.getValue(InvoiceAmount);

			checkInvoiceAmount(ConstructionContracts, InvoiceAmountvalue, DescriptionValue);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentagevalue = common.getValue(RetainagePercentage);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountvalue = common.getValue(RetainageAmount);

			checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue, RetainageAmountvalue, DescriptionValue);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue, TotalRetainagevalue, DescriptionValue);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlacevalue = common.getValue(WorkInPlace);

			checkWorkInPlace(ScheduledValue, PercentCompleteValue, WorkInPlacevalue, DescriptionValue);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue, DescriptionValue);

		}

	}

	@FindBy(xpath = "(//*[text()='Retention calc at application']//following::*[@role='switch'])[1]")
	WebElement RetentionCalcAtApplication;

	public boolean getRetentionCalcAtApplicationStatus() {

		if (RetentionCalcAtApplication.getAttribute("aria-checked").equals("true")) {

			return true;
		}

		else {

			return false;
		}
	}

	public void checkContractCalculations_AfterRetainageUpdate() throws InterruptedException {

		Thread.sleep(3000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			common.clickElement(Description);

			WebElement ScheduledValueElement = ldriver
					.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + row + "]"));

			String ScheduledValue = common.getValue(ScheduledValueElement);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountvalue = common.getValue(InvoiceAmount);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentagevalue = common.getValue(RetainagePercentage);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountvalue = common.getValue(RetainageAmount);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlacevalue = common.getValue(WorkInPlace);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			WebElement ActualCosts = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			common.scrollIntoView(ActualCosts);

			String ActualCostsValue = common.getValue(ActualCosts);

			boolean RetentionCalcAtApplicationStatus = getRetentionCalcAtApplicationStatus();

			checkPercentComplete(ScheduledValue, WorkInPlacevalue, PercentCompleteValue, DescriptionValue);

			checkInvoiceAmount(ScheduledValue, PercentCompleteValue, InvoiceAmountvalue, DescriptionValue);

			// checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
			// RetainageAmountvalue, DescriptionValue);

			checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue, RetainageAmountvalue,
					TotalRetainagevalue, PrevRetainagevalue, RetentionCalcAtApplicationStatus, DescriptionValue);

			// checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
			// TotalRetainagevalue, DescriptionValue);

			checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue, WorkInPlacevalue, RetainagePercentagevalue,
					TotalRetainagevalue, RetentionCalcAtApplicationStatus, DescriptionValue);

			checkWorkInPlace(ScheduledValue, PercentCompleteValue, WorkInPlacevalue, DescriptionValue);

			checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue, DescriptionValue);

			checkContractCalculations_costs(DescriptionValue, ActualCostsValue);

			common.scrollIntoView(Description);

			common.clickElement(Description);

			if (row < getNumberofLinesInContractOverview()) {

				common.KeyboardAction("Down");

			}
		}
	}

	public void checkContractCalculations_test() throws InterruptedException {

		Thread.sleep(3000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement ScheduledValueElement = ldriver
					.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + row + "]"));

			String ScheduledValue = common.getValue(ScheduledValueElement);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountvalue = common.getValue(InvoiceAmount);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentagevalue = common.getValue(RetainagePercentage);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountvalue = common.getValue(RetainageAmount);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlacevalue = common.getValue(WorkInPlace);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			WebElement ActualCosts = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			common.scrollIntoView(ActualCosts);

			String ActualCostsValue = common.getValue(ActualCosts);

			boolean RetentionCalcAtApplicationStatus = getRetentionCalcAtApplicationStatus();

			checkPercentComplete(ScheduledValue, WorkInPlacevalue, PercentCompleteValue, DescriptionValue);

			// checkInvoiceAmount(ConstructionContracts, InvoiceAmountvalue,
			// DescriptionValue);

			// checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
			// RetainageAmountvalue, DescriptionValue);

			checkInvoiceAmount(ScheduledValue, PercentCompleteValue, InvoiceAmountvalue, DescriptionValue);

			checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue, RetainageAmountvalue,
					TotalRetainagevalue, PrevRetainagevalue, RetentionCalcAtApplicationStatus, DescriptionValue);

			// checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
			// TotalRetainagevalue, DescriptionValue);

			checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue, WorkInPlacevalue, RetainagePercentagevalue,
					TotalRetainagevalue, RetentionCalcAtApplicationStatus, DescriptionValue);

			checkWorkInPlace(ScheduledValue, PercentCompleteValue, WorkInPlacevalue, DescriptionValue);

			checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue, DescriptionValue);

			checkContractCalculations_costs(DescriptionValue, ActualCostsValue);
		}
	}

	public void checkPercentComplete(String ScheduledValue, String WorkInPlace, String PercentComplete,
			String DescriptionValue) throws InterruptedException {

		String ExpectedPercentComplete = formulas.getPercentComplete(WorkInPlace, ScheduledValue);

		logger.info("Percent Complete Expected: " + ExpectedPercentComplete);

		logger.info("Percent Complete Actual: " + PercentComplete);

		Assert.assertEquals(PercentComplete, ExpectedPercentComplete,
				"Percent Complete in Contract is not as expected for " + DescriptionValue);

	}

	@FindBy(xpath = "//*[@aria-label='Line num']")
	List<WebElement> LineNumbersInContractOverview;

	public int getLineNumbersInContractOverview() throws InterruptedException {

		return LineNumbersInContractOverview.size();

	}

	/*
	 * public ArrayList<ArrayList<String>> getDataFromContractOverview() throws
	 * InterruptedException {
	 * 
	 * clickRefresh();
	 * 
	 * DataInContractOverview = new ArrayList<ArrayList<String>>();
	 * 
	 * ArrayList<String> Data = new ArrayList<String>();
	 * 
	 * for (int line = 1; line <= getLineNumbersInContractOverview(); line++) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + line +
	 * "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * Data.add(DescriptionValue);
	 * 
	 * WebElement Percentcomplete = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + line +
	 * "]"));
	 * 
	 * String PercentCompleteValue = common.getValue(Percentcomplete);
	 * 
	 * Data.add(PercentCompleteValue);
	 * 
	 * WebElement InvoiceAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + line + "]"));
	 * 
	 * String InvoiceAmountValue = common.getValue(InvoiceAmount);
	 * 
	 * Data.add(InvoiceAmountValue);
	 * 
	 * DataInContractOverview.add(new ArrayList<String>(Data));
	 * 
	 * Data.clear();
	 * 
	 * } logger.info("DataInContractOverview: " + DataInContractOverview); return
	 * DataInContractOverview; }
	 */

	@FindBy(xpath = "//*[@aria-label='Line num' and contains(@id,'GridLines')]")
	List<WebElement> NumberofLinesInApplicationDrawOverview;

	public int getNumberofLinesInApplicationDrawOverview() throws InterruptedException {

		return NumberofLinesInApplicationDrawOverview.size();

	}

	public ArrayList<ArrayList<String>> getDataFromContractApplications() throws InterruptedException {

		Thread.sleep(3000);

		DataInContractApplications = new ArrayList<ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		for (int line = 1; line <= getNumberofLinesInApplicationDrawOverview(); line++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridLines')])[" + line + "]"));

			String DescriptionValue = common.getValue(Description);

			Data.add(DescriptionValue);

			WebElement Percentcomplete = ldriver.findElement(
					By.xpath("(//*[@aria-label='Percent complete' and contains(@id,'GridLines')])[" + line + "]"));

			String PercentCompleteValue = common.getValue(Percentcomplete);

			Data.add(PercentCompleteValue);

			WebElement Invoiceamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Invoice amount' and contains(@id,'GridLines')])[" + line + "]"));

			String InvoiceamountValue = common.getValue(Invoiceamount);

			Data.add(InvoiceamountValue);

			DataInContractApplications.add(new ArrayList<String>(Data));

			Data.clear();

		}

		logger.info("PercentCompleteDataInContractApplications: " + DataInContractApplications);

		return DataInContractApplications;
	}

	public void checkContractApplicationsData() throws InterruptedException {

		logger.info("Contract Data in Contract Applications Expected: " + DataInContractOverview);

		logger.info("Contract Data in Contract Applications Actual: " + DataInContractApplications);

		Assert.assertEquals(DataInContractOverview, DataInContractApplications,
				"Contract Data in Contract Applications is not as expected");

	}

	/*
	 * public void checkRetentionToDate(String RetainageAmount, String
	 * RetentionToDate, String Description) {
	 * 
	 * logger.info("Retention To Date in Contract Applications Expected: " +
	 * RetainageAmount);
	 * 
	 * logger.info("Retention To Date in Contract Applications Actual: " +
	 * RetentionToDate);
	 * 
	 * Assert.assertEquals(RetentionToDate, RetainageAmount,
	 * "Retention To Date in Contract Applications is not as expected for Description: "
	 * + Description); }
	 */

	public void checkAmountdue(String InvoiceAmount, String RetainageAmount, String Amountdue, String Description)
			throws InterruptedException {

		String AmountdueExpected = formulas.getDifference(InvoiceAmount, RetainageAmount);

		logger.info("Amount due in Contract Applications Expected: " + AmountdueExpected);

		logger.info("Amount due in Contract Applications Actual: " + Amountdue);

		Assert.assertEquals(Amountdue, AmountdueExpected,
				"Amount due in Contract Applications is not as expected for Description: " + Description);
	}

	public void checkContractApplicationCalculations() throws InterruptedException {

		for (int line = 1; line <= getNumberofLinesInApplicationDrawOverview(); line++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridLines')])[" + line + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement Invoiceamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Invoice amount' and contains(@id,'GridLines')])[" + line + "]"));

			String InvoiceamountValue = common.getValue(Invoiceamount);

			WebElement Retention = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage %' and contains(@id,'GridLines')])[" + line + "]"));

			String RetentionValue = common.getValue(Retention);

			WebElement Retentiontodate = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retention to date' and contains(@id,'GridLines')])[" + line + "]"));

			String RetentiontodateValue = common.getValue(Retentiontodate);

			WebElement Retainageamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage amount' and contains(@id,'GridLines')])[" + line + "]"));

			String RetainageamountValue = common.getValue(Retainageamount);

			WebElement Amountdue = ldriver.findElement(
					By.xpath("(//*[@aria-label='Amount due' and contains(@id,'GridLines')])[" + line + "]"));

			String AmountdueValue = common.getValue(Amountdue);

			checkRetainageAmount(InvoiceamountValue, RetentionValue, RetainageamountValue, DescriptionValue);

			checkRetentionToDate(RetainageamountValue, RetentiontodateValue, DescriptionValue);

			checkAmountdue(InvoiceamountValue, RetainageamountValue, AmountdueValue, DescriptionValue);

		}

	}

	@FindBy(xpath = "(//*[@aria-label='Invoice amount' and contains(@id,'GridLines')])")
	List<WebElement> InvoiceAmount_ContractApplications;

	@FindBy(xpath = "(//*[@aria-label='Retainage amount' and contains(@id,'GridLines')])")
	List<WebElement> RetainageAmount_ContractApplications;

	@FindBy(xpath = "(//*[@aria-label='Amount due' and contains(@id,'GridLines')])")
	List<WebElement> AmountDue_ContractApplications;

	public String getInvoiceAmountTotalCalculatedFromContractApplications() throws InterruptedException {

		String InvoiceAmountTotal = "0.00";

		for (WebElement InvoiceAmount : InvoiceAmount_ContractApplications) {

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			InvoiceAmountTotal = formulas.getSum(InvoiceAmountValue, InvoiceAmountTotal);

		}

		return InvoiceAmountTotal;

	}

	public String getRetainageAmountTotalCalculatedFromContractApplications() throws InterruptedException {

		String RetainageAmountTotal = "0.00";

		for (WebElement RetainageAmount : RetainageAmount_ContractApplications) {

			String RetainageAmountValue = common.getValue(RetainageAmount);

			RetainageAmountTotal = formulas.getSum(RetainageAmountValue, RetainageAmountTotal);

		}

		return RetainageAmountTotal;

	}

	public String getAmountDueTotalCalculatedFromContractApplications() throws InterruptedException {

		String AmountDueTotal = "0.00";

		for (WebElement AmountDue : AmountDue_ContractApplications) {

			String AmountDueValue = common.getValue(AmountDue);

			AmountDueTotal = formulas.getSum(AmountDueValue, AmountDueTotal);

		}

		return AmountDueTotal;

	}

	@FindBy(xpath = "//*[@name='InvoiceAmount']")
	WebElement InvoiceAmount_Total_ContractApplications;

	@FindBy(xpath = "//*[@name='RetainageAmount']")
	WebElement RetainageAmount_Total_ContractApplications;

	@FindBy(xpath = "//*[@name='AmountDue']")
	WebElement Amountdue_Total_ContractApplications;

	public String getInvoiceAmount_ContractApplications() throws InterruptedException {

		String InvoiceAmountValue = common.getValue(InvoiceAmount_Total_ContractApplications);

		return InvoiceAmountValue;

	}

	public String getRetainageAmount_ContractApplications() throws InterruptedException {

		String RetainageAmount_Applications = common.getValue(RetainageAmount_Total_ContractApplications);

		return RetainageAmount_Applications;

	}

	public String getAmountdue_ContractApplications() throws InterruptedException {

		String AmountDue_Applications = common.getValue(Amountdue_Total_ContractApplications);

		return AmountDue_Applications;

	}

	public void checkInvoiceAmountTotalInContractApplications() throws InterruptedException {

		InvoiceAmountTotal_ContractApplications = getInvoiceAmountTotalCalculatedFromContractApplications();

		logger.info("Invoice Amount Total_Contract Applications_Expected: " + InvoiceAmountTotal_ContractApplications);

		logger.info("Invoice Amount Total_Contract Applications_Actual: " + getInvoiceAmount_ContractApplications());

		Assert.assertEquals(getInvoiceAmount_ContractApplications(), InvoiceAmountTotal_ContractApplications,
				"Invoice Amount Total in Contract Applications is not as expected");

	}

	public void checkRetainageAmountTotalInContractApplications() throws InterruptedException {

		RetainageAmount_Applications = getRetainageAmountTotalCalculatedFromContractApplications();

		logger.info("Retainage Amount Total_Contract Applications_Expected: " + RetainageAmount_Applications);

		logger.info(
				"Retainage Amount Total_Contract Applications_Actual: " + getRetainageAmount_ContractApplications());

		Assert.assertEquals(getRetainageAmount_ContractApplications(), RetainageAmount_Applications,
				"Retainage Amount Total in Contract Applications is not as expected");

	}

	public void checkAmountDueTotalInContractApplications() throws InterruptedException {

		AmountDue_Applications = getAmountDueTotalCalculatedFromContractApplications();

		logger.info("Amount due Total_Contract Applications_Expected: " + AmountDue_Applications);

		logger.info("Amount due Total_Contract Applications_Actual: " + getAmountdue_ContractApplications());

		Assert.assertEquals(getAmountdue_ContractApplications(), AmountDue_Applications,
				"Amount due Total in Contract Applications is not as expected");

	}

	@FindBy(xpath = "//*[text()='Applications/draws']")
	WebElement Applicationsdraws;

	public void clickApplicationsdraws() throws InterruptedException {

		common.clickElement(Applicationsdraws);

	}

	public void getInvoiceAmountFromHourJournals() throws InterruptedException {

		InvoiceAmount_HourJournals = new HashMap<String, String>();

		for (ArrayList<String> HourJournal : HourJournals) {

			String TaskCode = HourJournal.get(0);

			String Hours = HourJournal.get(3);

			String SalesPrice = HourJournal.get(5);

			String Amount = formulas.getProduct(Hours, SalesPrice);

			if (InvoiceAmount_HourJournals.get(TaskCode) == null) {

				InvoiceAmount_HourJournals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_HourJournals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_HourJournals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Hour Journals: " + InvoiceAmount_HourJournals);

	}

	public void getInvoiceAmountFromItemJournals() throws InterruptedException {

		InvoiceAmount_ItemJournals = new HashMap<String, String>();

		for (ArrayList<String> ItemJournal : ItemJournals) {

			String TaskCode = ItemJournal.get(3);

			String Quantity = ItemJournal.get(1);

			String SalesPrice = ItemJournal.get(6);

			String Amount = formulas.getProduct(Quantity, SalesPrice);

			if (InvoiceAmount_HourJournals.get(TaskCode) == null) {

				InvoiceAmount_HourJournals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_HourJournals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_HourJournals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Item Journals: " + InvoiceAmount_HourJournals);

	}

	public void getInvoiceAmountFromExpenseJournals() throws InterruptedException {

		InvoiceAmount_ExpenseJournals = new HashMap<String, String>();

		for (ArrayList<String> ExpenseJournal : ExpenseJournals) {

			String TaskCode = ExpenseJournal.get(0);

			String Quantity = ExpenseJournal.get(3);

			String SalesPrice = ExpenseJournal.get(5);

			String Amount = formulas.getProduct(Quantity, SalesPrice);

			if (InvoiceAmount_ExpenseJournals.get(TaskCode) == null) {

				InvoiceAmount_ExpenseJournals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_ExpenseJournals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_ExpenseJournals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Expense Journals: " + InvoiceAmount_ExpenseJournals);

	}

	public void getInvoiceAmountFromJournals() throws InterruptedException {

		logger.info("Hour Journals:" + HourJournals);

		logger.info("Item Journals:" + ItemJournals);

		logger.info("Expense Journals:" + ExpenseJournals);

		InvoiceAmount_Journals = new HashMap<String, String>();

		for (ArrayList<String> HourJournal : HourJournals) {

			String TaskCode = HourJournal.get(0);

			String Hours = HourJournal.get(3);

			String SalesPrice = HourJournal.get(5);

			String Amount = formulas.getProduct(Hours, SalesPrice);

			if (InvoiceAmount_Journals.get(TaskCode) == null) {

				InvoiceAmount_Journals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_Journals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_Journals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Hour Journals: " + InvoiceAmount_Journals);

		InvoiceAmount_ItemJournals = new HashMap<String, String>();

		for (ArrayList<String> ItemJournal : ItemJournals) {

			String TaskCode = ItemJournal.get(3);

			String Quantity = ItemJournal.get(1);

			String SalesPrice = ItemJournal.get(6);

			if (SalesPrice.equals("")) {

				String ItemNumber = ItemJournal.get(0);

				String EquipmentItem = ExtendedAttributesData.get(ItemNumber).get(0);

				if (EquipmentItem.equals("No")) {

					SalesPrice = "0.00";
				}

				else if (EquipmentItem.equals("Yes")) {

					SalesPrice = EquipmentStandardCosts.get(ItemNumber).get(1);
				}

			}

			String Amount = formulas.getProduct(Quantity, SalesPrice);

			if (InvoiceAmount_Journals.get(TaskCode) == null) {

				InvoiceAmount_Journals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_Journals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_Journals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Item Journals: " + InvoiceAmount_Journals);

		InvoiceAmount_ExpenseJournals = new HashMap<String, String>();

		for (ArrayList<String> ExpenseJournal : ExpenseJournals) {

			String TaskCode = ExpenseJournal.get(0);

			String Quantity = ExpenseJournal.get(3);

			String SalesPrice = ExpenseJournal.get(5);

			String Amount = formulas.getProduct(Quantity, SalesPrice);

			if (InvoiceAmount_Journals.get(TaskCode) == null) {

				InvoiceAmount_Journals.put(TaskCode, Amount);

			}

			else {

				String ExistingAmount = InvoiceAmount_Journals.get(TaskCode);

				String NewAmount = formulas.getSum(ExistingAmount, Amount);

				InvoiceAmount_Journals.put(TaskCode, NewAmount);

			}

		}

		logger.info("InvoiceAmounts_Expense Journals: " + InvoiceAmount_Journals);

	}

	@FindBy(xpath = "//*[text()='Auto Invoice posting']")
	WebElement AutoInvoiceposting;

	public void clickAutoInvoiceposting() throws InterruptedException {

		Thread.sleep(2000);

		common.clickElementJS(AutoInvoiceposting);

		Thread.sleep(5000);

	}

	// ================================================Sadhana
	// Coding====================================================//
	// ================================================Monica
	// Coding=====================================================//

	@FindBy(xpath = "//*[@name='SystemDefinedCloseButton']")
	WebElement Close_DefaultOrderSetting;

	public void clickClose_DefaultOrderSetting() throws InterruptedException {

		common.clickElement(Close_DefaultOrderSetting);

	}

	@FindBy(xpath = "(//*[contains(@class,'isFilterable') and contains(@id,'_ProjId')])[1]")
	WebElement ProjectID_Search1;

	@FindBy(xpath = "(//*[contains(@class,'isFilterable') and contains(@id,'_ProjId')])[2]")
	WebElement ProjectID_Search2;

	public void clickProjectID() throws InterruptedException {

		try {

			common.clickElement(ProjectID_Search1);

		}

		catch (Exception e) {

			common.clickElement(ProjectID_Search2);

		}
	}

	/*
	 * public void selectSearchOptions(String arg1) throws InterruptedException { if
	 * (arg1.equals("ProjectID")) { clickProjectID(); } if
	 * (arg1.equals("Task Description")) { clickJobdescription(); } if
	 * (arg1.equals("Batch Job ID")) { clickBatchjobID(); } if
	 * (arg1.equals("Category Id")) { clickCategoryID(); } }
	 */

	@FindBy(xpath = "//*[contains(@aria-label,'Filter field:') and not(contains(@id,'Parent'))]")
	WebElement FilterField;

	@FindBy(xpath = "(//*[contains(@aria-label,'Filter field:') and not(contains(@id,'Parent'))])[2]")
	WebElement FilterField2;

	@FindBy(xpath = "(//*[contains(@aria-label,'Filter field:') and not(contains(@id,'Parent'))])[3]")
	WebElement FilterField3;

	public void setFilterFieldText(String value) throws InterruptedException {

		try {

			common.setTextAfterDelete(FilterField, value);

		}

		catch (Exception e1)

		{

			try {

				common.setTextAfterDelete(FilterField2, value);

			}

			catch (Exception e2) {

				common.setTextAfterDelete(FilterField3, value);

			}
		}
	}

	/*
	 * public void setFilterField(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("ProjectID")) {
	 * 
	 * setFilterFieldText(ProjectID_Journal);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Task Description")) {
	 * 
	 * setFilterFieldText(TaskDescription_RefreshProjFinData);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Batch Job ID")) {
	 * 
	 * setFilterFieldText(JobID);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Category Id")) {
	 * 
	 * setFilterFieldText(CategoryID);
	 * 
	 * } }
	 */

	/*
	 * @FindBy(xpath = "(//*[text()='Apply'])") WebElement Apply1;
	 * 
	 * @FindBy(xpath = "(//*[text()='Apply'])[2]") WebElement Apply2;
	 * 
	 * @FindBy(xpath = "(//*[text()='Apply'])[3]") WebElement Apply3;
	 * 
	 * public void clickApply() throws InterruptedException {
	 * 
	 * try {
	 * 
	 * common.clickElementJS(Apply1); }
	 * 
	 * catch (Exception e) {
	 * 
	 * try { common.clickElementJS(Apply2); }
	 * 
	 * catch (Exception e1) {
	 * 
	 * common.clickElementJS(Apply3); } } Thread.sleep(5000); }
	 */

	/*
	 * @FindBy(xpath =
	 * "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour']"
	 * ) WebElement Hour_Journals1;
	 * 
	 * @FindBy(xpath =
	 * "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour'][2]"
	 * ) WebElement Hour_Journals2;
	 * 
	 * public void clickHourJournal() throws InterruptedException {
	 * 
	 * try { common.clickElement(Hour_Journals1); } catch (Exception e) {
	 * common.clickElement(Hour_Journals2); }
	 * 
	 * }
	 */

	/*
	 * @FindBy(xpath = "(//*[text()='New'])[3]") WebElement New_Journals;
	 * 
	 * public void clickNewButton() throws InterruptedException {
	 * 
	 * Thread.sleep(2000);
	 * 
	 * common.clickElement(New_Journals);
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Lines'])[1]")
	WebElement Lines_Journal;

	public void clickLines_Journals() throws InterruptedException {

		common.clickElementJS(Lines_Journal);

	}

	/*
	 * @FindBy(xpath = "(//*[text()='New'])[4]") WebElement New_JournalLine;
	 * 
	 * public void clickNewJournalLine() throws InterruptedException {
	 * 
	 * common.clickElement(New_JournalLine); }
	 */

	@FindBy(xpath = "(//*[text()='General'])[1]")
	WebElement General_Journal1;

	@FindBy(xpath = "(//*[text()='General'])[2]")
	WebElement General_Journal2;

	@FindBy(xpath = "(//*[text()='General'])[3]")
	WebElement General_Journal3;

	public void clickGeneralTab() throws InterruptedException {

		try {
			common.clickElement(General_Journal1);
		}

		catch (Exception e) {
			try {
				common.clickElement(General_Journal2);
			}

			catch (Exception e2) {
				common.clickElement(General_Journal3);
			}
		}
		Thread.sleep(4000);
	}

	@FindBy(xpath = "//*[text()='Select']")
	WebElement Select;

	public void clickSelect() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", Select);

		common.clickElement(Select);

		Thread.sleep(4000);

	}

	@FindBy(xpath = "//*[text()='Overhead allocation']")
	WebElement Overheadallocation_Journal;

	public void clickOverheadAllocation() throws InterruptedException {

		Thread.sleep(5000);

		common.clickElementJS(Overheadallocation_Journal);

	}

	@FindBy(xpath = "//*[contains(@name,'SISMOPSOverheadAllocationTransCalculate')]")
	WebElement Calculate_Journal;

	public void clickCalculate() throws InterruptedException {

		common.clickElement(Calculate_Journal);

	}

	@FindBy(xpath = "//*[text()='Calculate']")
	WebElement Calculate_ExpenseJournal;

	public void clickCalculate_Expense() throws InterruptedException {

		common.clickElement(Calculate_ExpenseJournal);

	}

	@FindBy(xpath = "//*[text()='Overhead transactions']")
	WebElement Overheadtransactions_Journal;

	public void clickOverheadTransactions() throws InterruptedException {

		common.clickElement(Overheadtransactions_Journal);

	}

	@FindBy(xpath = "(//*[contains(@data-dyn-controlname,'MessageBarClose')])[1]")
	WebElement closeMessageBar;

	public void clickcloseMessageBar() throws InterruptedException {

		common.clickElementJS(closeMessageBar);

	}

	@FindBy(xpath = "//*[text()='Project overhead allocation calculated.']")
	WebElement OverheadAllocationCalculatedMessage;

	public void checkOverheadAllocationCalculated() throws InterruptedException {

		// Thread.sleep(2000);

		Assert.assertTrue(common.isTextDisplayed(OverheadAllocationCalculatedMessage),
				"Project Overhead allocation has not been calculated as expected");

	}

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[4]")
	WebElement Close_OverheadAllocationTransaction;

	public void clickClose_OverheadAllocationTransaction() throws InterruptedException {

		common.clickElement(Close_OverheadAllocationTransaction);

	}

	public void clickOverview_Journal() throws InterruptedException {

		common.clickElement(Overview);

	}

	@FindBy(xpath = "//*[contains(@aria-label,'Line number')]")
	List<WebElement> LineNumbers_HourJournals;

	public void clickLineNumber(String Line) throws InterruptedException {

		for (WebElement LineNumber : LineNumbers_HourJournals) {

			if (common.getValue(LineNumber).split("\\.")[0].equals(Line)) {

				common.clickElement(LineNumber);
			} else {

				// clickSave();
			}

		}
	}

	public int getNumberOfLinesInHourJournal() {

		return LineNumbers_HourJournals.size();

	}

	public void selectResource_HourJournal(String ResourceID) throws InterruptedException {

		if (common.isTextDisplayed(Select) == false) {

			clickResourceDropDown();

			Thread.sleep(2000);
		}

		WebElement SelectResourceID = ldriver
				.findElement(By.xpath("//*[@aria-label='Resource ID' and @role='textbox' and @value='" + ResourceID
						+ "' and not(contains(@id,'ProjJournalTrans'))]"));

		common.clickElement(SelectResourceID);

		clickSelect();
	}

	public String getAmount_OverheadTransactions_Total_ExcludeFromRevRec(String ProjectCategorty, String Price)
			throws InterruptedException {

		String Amount_OverheadTransactions_Total_ExcludeFromRevRec = "0.00";

		for (Map.Entry<String, ArrayList<String>> entry : BudgetCategory_ProjectCategories_Mapping.entrySet()) {

			if (entry.getValue().contains(ProjectCategorty)) {

				String BudgetCategory = entry.getKey();

				if (BudgetCategories_ExcludedFromRevRec.contains(BudgetCategory)) {

					Amount_OverheadTransactions_Total_ExcludeFromRevRec = formulas
							.getSum(Amount_OverheadTransactions_Total_ExcludeFromRevRec, Price);

				}
			}

		}
		return Amount_OverheadTransactions_Total_ExcludeFromRevRec;

	}

	public String getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(String ProjectCategorty, String Price)
			throws InterruptedException {

		for (Map.Entry<String, ArrayList<String>> entry : BudgetCategory_ProjectCategories_Mapping.entrySet()) {

			if (entry.getValue().contains(ProjectCategorty)) {

				String BudgetCategory = entry.getKey();

				if (BudgetCategories_ExcludedFromRevRec.contains(BudgetCategory)) {

					Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec = formulas
							.getSum(Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec, Price);

				}
			}

		}
		return Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec;

	}

	/*
	 * public void setHourJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * for (ArrayList<String> HourJournal : HourJournals) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * String TaskcodeValue = HourJournal.get(0);
	 * 
	 * String ProjectCategoryValue = HourJournal.get(1);
	 * 
	 * String ResourseIdValue = HourJournal.get(2);
	 * 
	 * String HoursValue = HourJournal.get(3);
	 * 
	 * String CostPriceValue = HourJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = HourJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(HoursValue, CostPriceValue);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( ProjectCategoryValue,
	 * TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Projectdate = ldriver
	 * .findElement(By.xpath("//*[contains(@class,'date-picker-button')][" + row +
	 * "]"));
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * WebElement Taskcode_Journal = ldriver.findElement(By
	 * .xpath("(//*[text()='Task code']//following::*[contains(@id,'SISTaskCode')])[3]["
	 * + row + "]"));
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ProjectCategoryValue.equals("")) {
	 * 
	 * WebElement Category_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Category']//following::*[contains(@id,'CategoryId')])[3][" +
	 * row + "]"));
	 * 
	 * common.setTextAfterDelete(Category_Journal, ProjectCategoryValue);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * WebElement Resourceid_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[5][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Resourceid_Journal, ResourseIdValue);
	 * 
	 * selectResource_HourJournal(ResourseIdValue);
	 * 
	 * // clickSelect();
	 * 
	 * }
	 * 
	 * if (!HoursValue.equals("")) {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) ldriver;
	 * 
	 * js.executeScript("arguments[0].scrollIntoView(true);", Hours_Journal);
	 * 
	 * WebElement Hours_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Hours']//following::*[contains(@id,'ctrlProjQty')])[4][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Hours_Journal, HoursValue);
	 * 
	 * }
	 * 
	 * clickGeneralTab();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * WebElement Costprice_Journal = ldriver.findElement( By.
	 * xpath("//*[text()='Cost price']//following::*[@name='CostPrice_CostPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterDelete(Costprice_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * WebElement Salesprice_Journal = ldriver.findElement(By
	 * .xpath("//*[text()='Sales price']//following::*[@name='SalesPrice_SalesPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterClear(Salesprice_Journal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(ProjectCategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, ProjectCategoryValue,
	 * TotalCostPrice, HoursValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickRefresh();
	 * 
	 * int Line = Integer.parseInt(LineNumberValue) + 1;
	 * 
	 * LineNumberValue = Integer.toString(Line);
	 * 
	 * // row++; } }
	 */

	/*
	 * @FindBy(xpath = "(//*[text()='Post'])[1]") WebElement Post_Journal;
	 */

	/*
	 * public void clickPost_Journal() throws InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.clickElement(Post_Journal);
	 * 
	 * }
	 */

	/*
	 * public void selectPost_Journals(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("Post")) {
	 * 
	 * clickPost_Journal(); }
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[text()='OK']")
	WebElement clickOK_Journals;

	public void clickOK_Journals() throws InterruptedException {

		common.clickElement(clickOK_Journals);

		Thread.sleep(6000);
	}

	@FindBy(xpath = "//*[contains(@id,'JournalId') and @aria-label='Journal']")
	WebElement JournalID_Journal;

	public String getJournalID_Journal() throws InterruptedException {

		Thread.sleep(5000);

		JournalId = common.getValue(JournalID_Journal);

		logger.info("Journal ID: " + JournalId);

		return JournalId;
	}

	@FindBy(xpath = "//*[contains(@title,'Journal:')]")
	WebElement JournalPostedMessage;

	public void checkJournalPostedMessage(String JournalID) throws InterruptedException {

		Thread.sleep(5000);

		WebElement JournalPostedMsg = ldriver
				.findElement(By.xpath("//*[text()='Journal: " + JournalId + " Journal has been posted. ']"));

		Assert.assertTrue(common.isTextDisplayed(JournalPostedMsg),
				"Journal posted message has not been displayed as expected");
	}

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[2]")
	WebElement closeJournal;

	public void clickCloseJournal() throws InterruptedException {

		common.clickElement(closeJournal);

	}

	// Item Journal
	/*
	 * @FindBy(xpath =
	 * "//*[text()='Journals']//following::*[contains(@id,'ItemJournalEntry') and text()='Item']"
	 * ) WebElement Item_Journals;
	 * 
	 * public void clickItemJournal() throws InterruptedException {
	 * 
	 * common.clickElement(Item_Journals);
	 * 
	 * Thread.sleep(3000); }
	 */

	@FindBy(xpath = "//*[contains(@id,'JournalNameId') and @aria-label='Name']")
	WebElement Name_Journals;

	public void setItemName() throws InterruptedException {

		common.clickElement(Name_Journals);

		common.setText(Name_Journals, ItemName);

		common.KeyboardAction("Enter");

	}

	@FindBy(xpath = "//*[contains(@class,'date-picker-button')]")
	WebElement Projectdate;

	@FindBy(xpath = "(//*[text()='Task code']//following::*[contains(@id,'SISTaskCode')])[3]")
	WebElement Taskcode_Journal;

	@FindBy(xpath = "//*[contains(@id,'ItemId') and @aria-label='Item number']")
	WebElement ItemNumber_Journal;

	@FindBy(xpath = "//*[contains(@id,'Qty') and @aria-label='Quantity']")
	WebElement Quantity_Journal;

	@FindBy(xpath = "//*[contains(@name,'EquipmentChargeType')]")
	WebElement ChargeType_Journal;

	@FindBy(xpath = "//*[contains(@name,'ProjCategoryId')]")
	WebElement Category_ItemJournal;

	@FindBy(xpath = "//*[contains(@name,'InventSiteId')]")
	WebElement Site_ItemJournal;

	@FindBy(xpath = "//*[contains(@name,'InventLocationId')]")
	WebElement Warehouse_ItemJournal;

	@FindBy(xpath = "//*[contains(@id,'CostAmount') and @aria-label='Cost amount']")
	WebElement Costamount;

	@FindBy(xpath = "//*[contains(@id,'CostPrice') and @aria-label='Cost price']")
	WebElement CostPriceValue_Journal;

	@FindBy(xpath = "//*[text()='Sales price']//following::*[contains(@name,'ProjSalesPrice')]")
	WebElement Salesprice_ItemJournal;

	public void updateItemJournalData(String ItemNumberValue, String QuantityValue, String CostPriceValue,
			String TaskcodeValue, String ChargeTypeValue, String CategoryValue, String SalesPriceValue,
			String SiteValue, String WarehouseValue) {

		ArrayList<String> Data = new ArrayList<String>();

		Data.add(ItemNumberValue);

		Data.add(QuantityValue);

		Data.add(CostPriceValue);

		Data.add(TaskcodeValue);

		Data.add(ChargeTypeValue);

		Data.add(CategoryValue);

		Data.add(SalesPriceValue);

		Data.add(SiteValue);

		Data.add(WarehouseValue);

		ItemJournals.add(new ArrayList<String>(Data));

		Data.clear();
	}

	/*
	 * public void setItemJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * for (ArrayList<String> ItemJournal : ItemJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * }
	 * 
	 * String ItemNumberValue = ItemJournal.get(0);
	 * 
	 * String QuantityValue = ItemJournal.get(1);
	 * 
	 * String CostPriceValue = ItemJournal.get(2);
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue); }
	 * 
	 * String TaskcodeValue = ItemJournal.get(3);
	 * 
	 * String ChargeTypeValue = ItemJournal.get(4);
	 * 
	 * String CategoryValue = ItemJournal.get(5);
	 * 
	 * String SalesPriceValue = ItemJournal.get(6);
	 * 
	 * String SiteValue = ItemJournal.get(7);
	 * 
	 * String WarehouseValue = ItemJournal.get(8);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ItemNumberValue.equals("")) {
	 * 
	 * common.setText(ItemNumber_Journal, ItemNumberValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * common.KeyboardAction("Enter");
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * clickProjectSubtab();
	 * 
	 * if (!ChargeTypeValue.equals("")) {
	 * 
	 * common.setTextAfterClear(ChargeType_Journal, ChargeTypeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Category_ItemJournal, CategoryValue);
	 * 
	 * }
	 * 
	 * else if (CategoryValue.equals("")) {
	 * 
	 * CategoryValue = checkCategoryValue(ItemNumberValue); }
	 * 
	 * if (SalesPriceValue.equals("")) {
	 * 
	 * SalesPriceValue = checkSalesPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * else if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ItemJournal, SalesPriceValue); }
	 * 
	 * clickOverview_Journal();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(CostPriceValue_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * else if (CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = checkCostPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * String CostAmountValue = common.getValue(Costamount);
	 * 
	 * String CostAmount = checkLineAmount(QuantityValue, CostPriceValue,
	 * CostAmountValue, row);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( CategoryValue,
	 * CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * clickProductDimensionsSubtab();
	 * 
	 * if (!SiteValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Site_ItemJournal, SiteValue);
	 * 
	 * }
	 * 
	 * else if (SiteValue.equals("")) {
	 * 
	 * SiteValue = checkSiteValue(ItemNumberValue); }
	 * 
	 * if (!WarehouseValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Warehouse_ItemJournal, WarehouseValue);
	 * 
	 * }
	 * 
	 * else if (WarehouseValue.equals("")) {
	 * 
	 * WarehouseValue = checkWarehouseValue(ItemNumberValue); }
	 * 
	 * // clickOverview_Journal();
	 * 
	 * common.KeyboardAction("Tab");
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData_ItemJournal(TaskcodeValue, CategoryValue,
	 * ItemNumberValue, CostAmountValue, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * if (row == 1) {
	 * 
	 * ItemJournals = new ArrayList<ArrayList<String>>();
	 * 
	 * }
	 * 
	 * updateItemJournalData(ItemNumberValue, QuantityValue, CostPriceValue,
	 * TaskcodeValue, ChargeTypeValue, CategoryValue, SalesPriceValue, SiteValue,
	 * WarehouseValue);
	 * 
	 * row++; } }
	 */

	public String getCategoryValue() throws InterruptedException {

		String CategoryValue = common.getValue(Category_ItemJournal);

		return CategoryValue;

	}

	public String checkCategoryValue(String ItemNumber) throws InterruptedException {

		String CategoryValueExpected = ProjectCategories_FieldService.get(ItemNumber);

		Assert.assertEquals(getCategoryValue(), CategoryValueExpected,
				"Category value from Field Service is not as expected for ItemNumber: " + ItemNumber);

		return CategoryValueExpected;

	}

	public String checkCostPriceValue(String ItemNumber) throws InterruptedException {

		String EquipmentItem = ExtendedAttributesData.get(ItemNumber).get(0);

		String CostPrice = null;

		if (EquipmentItem.equals("No")) {

			CostPrice = ManageCostsData.get(ItemNumber).get(0);
		} else if (EquipmentItem.equals("Yes")) {

			CostPrice = EquipmentStandardCosts.get(ItemNumber).get(0);
		}

		Assert.assertEquals(getCostPriceValue(), CostPrice,
				"Cost Price value from Manage cost/Equipment Standard Cost is not as expected for ItemNumber: "
						+ ItemNumber);

		return CostPrice;
	}

	public String getCostPriceValue() throws InterruptedException {

		String CostPriceValue = common.getValue(CostPriceValue_Journal);

		return CostPriceValue;

	}

	public String checkSalesPriceValue(String ItemNumber) throws InterruptedException {

		String EquipmentItem = ExtendedAttributesData.get(ItemNumber).get(0);

		String SalesPrice = null;

		if (EquipmentItem.equals("No")) {

			SalesPrice = "0.00";
		}

		else if (EquipmentItem.equals("Yes")) {

			SalesPrice = EquipmentStandardCosts.get(ItemNumber).get(1);
		}

		Assert.assertEquals(getSalesPriceValue(), SalesPrice,
				"Sales Price value from Manage cost/Equipment Standard Cost is not as expected for ItemNumber: "
						+ ItemNumber);
		return SalesPrice;

	}

	public String getSalesPriceValue() throws InterruptedException {

		String SalesPriceValue = common.getValue(Salesprice_ItemJournal);

		return SalesPriceValue;

	}

	public String checkSiteValue(String ItemNumber) throws InterruptedException {

		ArrayList<String> Inventory = InventoryData.get(ItemNumber);

		Assert.assertEquals(getSiteValue(), Inventory.get(0),
				"Site value from Field Service is not as expected for ItemNumber: " + ItemNumber);

		return Inventory.get(0);
	}

	public String getSiteValue() throws InterruptedException {

		String SiteValue = common.getValue(Site_ItemJournal);

		return SiteValue;

	}

	public String checkWarehouseValue(String ItemNumber) throws InterruptedException {

		ArrayList<String> Inventory = InventoryData.get(ItemNumber);

		Assert.assertEquals(getWarehouseValue(), Inventory.get(1),
				"Warehouse value from Field Service is not as expected for ItemNumber: " + ItemNumber);

		return Inventory.get(1);

	}

	public String getWarehouseValue() throws InterruptedException {

		String WarehouseValue = common.getValue(Warehouse_ItemJournal);

		return WarehouseValue;

	}

	@FindBy(xpath = "(//span[@class='pivot-label' and text()='Project'])")
	WebElement Project_Journal;

	public void clickProjectSubtab() throws InterruptedException {

		common.clickElement(Project_Journal);

		Thread.sleep(1000);
	}

	@FindBy(xpath = "//*[text()='Product dimensions']")
	WebElement Productdimensions_Journal;

	public void clickProductDimensionsSubtab() throws InterruptedException {

		common.clickElement(Productdimensions_Journal);

		Thread.sleep(5000);
	}

	// Expense Journal

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'ExpenseEntry') and text()='Expense']")
	WebElement Expense_Journals;

	/*
	 * public void clickExpenseJournal() throws InterruptedException {
	 * 
	 * common.clickElement(Expense_Journals);
	 * 
	 * Thread.sleep(3000); }
	 */

	@FindBy(xpath = "//*[text()='Operation completed']")
	WebElement ExpenseJournalPostedMessage;

	public void checkExpenseJournalPostedMessage() throws InterruptedException {

		// Thread.sleep(2000);

		Assert.assertTrue(common.isTextDisplayed(ExpenseJournalPostedMessage), "Operation has not been completed");

	}

	@FindBy(xpath = "(//*[contains(@id,'JournalNum') and @aria-label='Journal batch number'])[1]")
	WebElement JournalID_ExpenseJournal;

	public String getJournalID_ExpenseJournal() throws InterruptedException {

		Thread.sleep(3000);

		ExpenseJournalId = common.getValue(JournalID_ExpenseJournal);

		logger.info("Journal ID: " + ExpenseJournalId);

		return ExpenseJournalId;
	}

	@FindBy(xpath = "(//*[contains(@id,'Resource_Name')]//following::*[@title='Open'])[1]")
	WebElement ResourceDropDown;

	public void clickResourceDropDown() throws InterruptedException {

		common.clickElement(ResourceDropDown);
	}

	public void selectResource_ExpenseJournal(String ResourceID) throws InterruptedException {

		if (common.isTextDisplayed(Select) == false) {

			clickResourceDropDown();

			Thread.sleep(2000);
		}

		WebElement SelectResourceID = ldriver
				.findElement(By.xpath("//*[@aria-label='Resource ID' and @role='textbox' and @value='" + ResourceID
						+ "' and not(contains(@id,'LedgerJournalTrans_Project'))]"));

		common.clickElement(SelectResourceID);

		clickSelect();
	}

	/*
	 * @FindBy(xpath = "(//*[contains(@class,'date-picker-button')])[2]") WebElement
	 * Projectdate_ExpenseJournal;
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Category']//following::*[contains(@id,'CategoryId')])[3]")
	 * WebElement Category_Journal;
	 * 
	 * @FindBy(xpath =
	 * "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[4]")
	 * WebElement ExpenseResourceid_Journal;
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(@id,'CostPrice') and @aria-label='Cost price']") WebElement
	 * Costprice_ExpenseJournal;
	 * 
	 * @FindBy(xpath =
	 * "//*[contains(@id,'SalesPrice') and @aria-label='Sales price']") WebElement
	 * Salesprice_ExpenseJournal;
	 */

	/*
	 * public void setExpenseJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * for (ArrayList<String> ExpenseJournal : ExpenseJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * }
	 * 
	 * String TaskcodeValue = ExpenseJournal.get(0);
	 * 
	 * String CategoryValue = ExpenseJournal.get(1);
	 * 
	 * String ResourseIdValue = ExpenseJournal.get(2);
	 * 
	 * String QuantityValue = ExpenseJournal.get(3);
	 * 
	 * String CostPriceValue = ExpenseJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = ExpenseJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(QuantityValue, CostPriceValue);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( CategoryValue,
	 * TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Category_Journal, CategoryValue);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(ExpenseResourceid_Journal, ResourseIdValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * selectResource_ExpenseJournal(ResourseIdValue);
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Costprice_ExpenseJournal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ExpenseJournal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, CategoryValue,
	 * TotalCostPrice, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * row++; } }
	 */

	@FindBy(xpath = "//*[contains(@aria-label,'Post')]//following::*[text()='Post']")
	WebElement Post_ExpenseJournal;

	public void clickPost_ExpenseJournal() throws InterruptedException {

		Thread.sleep(3000);

		common.clickElement(Post_ExpenseJournal);

		Thread.sleep(8000);

	}

	// Modules Icon
	@FindBy(xpath = "//*[contains(@class,'image GroupedList')]")
	WebElement ModulesIcon;

	public void clickModulesIcon() throws InterruptedException {

		common.clickElement(ModulesIcon);
	}

	// To select rule ID DEMO2
	public void clickRuleID(String arg1) throws InterruptedException {

		Thread.sleep(3000);

		WebElement RuleID = ldriver.findElement(By.xpath("//*[contains(@id,'RuleID') and @value='" + arg1 + "']"));

		common.clickElement(RuleID);
	}

	// To click Rate tab
	@FindBy(xpath = "//*[text()='Rate']")
	WebElement Rate;

	public void clickRate() throws InterruptedException {

		common.clickElement(Rate);

		Thread.sleep(1000);
	}

	@FindBy(xpath = "//*[@aria-label='Rule ID' and contains(@id,'ProjectAllocationRate')]")
	List<WebElement> NumberOfProjectAllocationRates;

	public int getNumberOfProjectAllocationRates() {

		return NumberOfProjectAllocationRates.size();

	}

	public void getProjectAllocationRates() throws InterruptedException {

		ProjectAllocationRates = new HashMap<String, ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		for (int i = 1; i <= getNumberOfProjectAllocationRates(); i++) {

			WebElement CategoryID = ldriver
					.findElement(By.xpath("(//*[contains(@id,'CategoryId') and @aria-label='Category'])[" + i + "]"));

			String CategoryIDValue = common.getValue(CategoryID);

			WebElement Priority = ldriver
					.findElement(By.xpath("(//*[contains(@id,'Priority') and @aria-label='Priority'])[" + i + "]"));

			String PriorityValue = common.getValue(Priority);

			WebElement RateType = ldriver
					.findElement(By.xpath("(//*[contains(@id,'RateType') and @aria-label='Rate type'])[" + i + "]"));

			String RateTypeValue = common.getValue(RateType);

			WebElement Rate = ldriver
					.findElement(By.xpath("(//*[contains(@id,'RateValue') and @aria-label='Rate'])[" + i + "]"));

			String RateValue = common.getValue(Rate);

			Data.add(PriorityValue);

			Data.add(RateTypeValue);

			Data.add(RateValue);

			ProjectAllocationRates.put(CategoryIDValue, new ArrayList<String>(Data));

			Data.clear();

		}

		logger.info("Project Allocation Rates:" + ProjectAllocationRates);

		clickClose();
	}

	@FindBy(xpath = "//*[@aria-label='Source category' and contains(@id,'SourceCriteria')]")
	List<WebElement> NumberOfSourceCategory;

	public int getNumberOfSourceCategory() {

		return NumberOfSourceCategory.size();
	}

	public void getDestinatonCategory() throws InterruptedException {

		DestinatonCategory = new HashMap<String, String>();

		for (int i = 1; i <= getNumberOfSourceCategory(); i++) {

			WebElement SourceCategory = ldriver.findElement(
					By.xpath("(//*[@aria-label='Source category' and contains(@id,'SourceCriteria')])[" + i + "]"));

			String SourceCategoryValue = SourceCategory.getAttribute("value");

			WebElement DestinationCategory = ldriver.findElement(By.xpath(
					"(//*[@aria-label='Destination category' and contains(@id,'DestinationCriteria')])[" + i + "]"));

			String DestinationCategoryValue = DestinationCategory.getAttribute("value");

			DestinatonCategory.put(SourceCategoryValue, DestinationCategoryValue);

		}

		logger.info("Destinaton Category: " + DestinatonCategory);
	}

	// to validate Site and warehouse

	@FindBy(xpath = "//*[text()='Manage inventory']")
	WebElement Manageinventory;

	@FindBy(xpath = "//*[text()='Default order settings']")
	WebElement Defaultordersettings;

	public void clickSection_ProductInformationManagement(String arg1, String arg2) throws InterruptedException {

		if (arg2.equals("Manage Inventory")) {

			if (arg1.equals("Default Order Settings")) {

				common.clickElement(Defaultordersettings);
			}
		}
	}

	@FindBy(xpath = "//*[text()='Item number' and contains(@class,'headerCellLabel')]")
	WebElement Itemnumber_Filter;

	public void clickItemnumber_Filter() throws InterruptedException {

		common.clickElement(Itemnumber_Filter);

	}

	public void SelectItemNumber(String ItemNumber) throws InterruptedException {

		Thread.sleep(2000);

		WebElement selectItemNumber = ldriver
				.findElement(By.xpath("//*[contains(@id,'ItemIdGrid') and @value='" + ItemNumber + "']"));

		common.clickUsingActions(selectItemNumber);

		common.KeyboardAction("Enter");

		Thread.sleep(5000);

	}

	@FindBy(xpath = "//*[contains(@name,'InventSiteIdInvent')]")
	WebElement Defaultsite;

	public String getDefaultsite() throws InterruptedException {

		Thread.sleep(5000);

		String DefaultsiteValue = common.getText(Defaultsite);

		return DefaultsiteValue;

	}

	@FindBy(xpath = "//*[contains(@name,'InventLocationIdInvent')]")
	WebElement Defaultwarehouse;

	public String getDefaultwarehouse() throws InterruptedException {

		String DefaultwarehouseValue = common.getText(Defaultwarehouse);

		return DefaultwarehouseValue;

	}

	public void filterItemNumber(String ItemNumber) throws InterruptedException {

		Thread.sleep(3000);

		clickItemnumber_Filter();

		setFilterFieldText(ItemNumber);

		clickApply();

	}

	public void getInventoryData() throws InterruptedException {

		Thread.sleep(3000);

		// InventoryData = new HashMap<String, ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		/*
		 * for(ArrayList<String> Journal: ItemJournals) {
		 * 
		 * ItemNumber = Journal.get(0);
		 * 
		 * filterItemNumber(ItemNumber);
		 */

		common.clickElement(Manageinventory);

		common.clickElementJS(Defaultordersettings);

		Thread.sleep(3000);

		Data.add(getDefaultsite());

		Data.add(getDefaultwarehouse());

		InventoryData.put(ItemNumber, new ArrayList<String>(Data));

		Data.clear();

		logger.info("Inventory Data: " + InventoryData);

		clickClose();
	}
	// }

	@FindBy(xpath = "//*[text()='Price']//following::*[@name='CostBasePrice_Price' and @role='textbox']")
	WebElement Prices;

	public String getPrices() throws InterruptedException {

		String PricesValue = common.getValue(Prices);

		return PricesValue;
	}

	@FindBy(xpath = "//*[text()='Price']//following::*[contains(@name,'CostBasePrice_PriceUnit')]")
	WebElement Pricequantity;

	public String getPricequantity() throws InterruptedException {

		String PriceQuantityValue = common.getValue(Pricequantity);

		return PriceQuantityValue;
	}

	/*
	 * public void getManageCostsData() throws InterruptedException {
	 * 
	 * ManageCostsData = new HashMap<String, ArrayList<String>>();
	 * 
	 * ArrayList<String> Data = new ArrayList<String>();
	 * 
	 * for(ArrayList<String> Journal : ItemJournals) {
	 * 
	 * ItemNumber =Journal.get(0);
	 * 
	 * filterItemNumber(ItemNumber);
	 * 
	 * SelectItemNumber(ItemNumber);
	 * 
	 * clickManagecosts();
	 * 
	 * Data.add(getPrices());
	 * 
	 * Data.add(getPricequantity());
	 * 
	 * ManageCostsData.put(ItemNumber, new ArrayList<String>(Data));
	 * 
	 * Data.clear();
	 * 
	 * logger.info("Manage Costs Data: "+ ManageCostsData);
	 * 
	 * clickClose_DefaultOrderSetting(); } }
	 */

	@FindBy(xpath = "//*[contains(@id,'ItemId') and @aria-label='Item number']")
	List<WebElement> NumberOfEquipmentStatndardCosts;

	public int getNumberOfEquipmentStatndardCosts() {

		return NumberOfEquipmentStatndardCosts.size();
	}

	@FindBy(xpath = "//*[@aria-label='Field Service']")
	WebElement FieldService;

	public void clickFieldService() throws InterruptedException {

		if (common.isSectionExpanded(FieldService) == false) {

			common.clickElement(FieldService);
		}
	}

	@FindBy(xpath = "//*[text()='Project category']//following::*[contains(@name,'projCategoryId')]")
	WebElement ProjectCategory;

	public String getProjectCategory_FieldService() throws InterruptedException {

		String ProjectCategoryID = common.getValue(ProjectCategory);

		// String ProjectCategoryID = common.getText(ProjectCategory);

		return ProjectCategoryID;

	}

	public void getProjectCategories_FieldService() throws InterruptedException {

		// ProjectCategories_FieldService = new HashMap<String, String>();

		/*
		 * for(ArrayList<String> ItemJournal : ItemJournals) {
		 * 
		 * String ItemNumber = ItemJournal.get(0);
		 * 
		 * filterItemNumber(ItemNumber);
		 * 
		 * SelectItemNumber(ItemNumber);
		 */

		clickFieldService();

		Thread.sleep(3000);

		String ProjectCategory = getProjectCategory_FieldService();

		logger.info("ProjectCategory: " + ProjectCategory);

		ProjectCategories_FieldService.put(ItemNumber, ProjectCategory);

		// clickClose_DefaultOrderSetting();

		logger.info("Project Categories_Field Service: " + ProjectCategories_FieldService);

		logger.info("Project Categories_Field Service: " + ProjectCategories_FieldService);
	}
	// }

	public void getEquipmentStandardCosts() throws InterruptedException {

		EquipmentStandardCosts = new HashMap<String, ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		for (Map.Entry<String, ArrayList<String>> ESCData : ExtendedAttributesData.entrySet()) {

			if (ESCData.getValue().get(0).equals("Yes")) {

				String ItemNumberValue = ESCData.getKey();

				filterItemNumber(ItemNumberValue);

				WebElement CostPrice = ldriver
						.findElement(By.xpath("//*[contains(@id,'CostPrice') and @aria-label='Cost price']"));

				String CostPriceValue = common.getValue(CostPrice);

				WebElement DefaultSalesPrice = ldriver
						.findElement(By.xpath("//*[contains(@id,'SalesPrice') and @aria-label='Default sales price']"));

				String DefaultSalesPriceValue = common.getValue(DefaultSalesPrice);

				Data.add(CostPriceValue);

				Data.add(DefaultSalesPriceValue);

				EquipmentStandardCosts.put(ItemNumberValue, new ArrayList<String>(Data));

				Data.clear();

			}

		}

		logger.info("Equipment Standard Costs:" + EquipmentStandardCosts);
	}

	public void getExtendedAttributesDataProjectCategoryInventoryData() throws InterruptedException {

		ExtendedAttributesData = new HashMap<String, ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		ManageCostsData = new HashMap<String, ArrayList<String>>();

		ProjectCategories_FieldService = new HashMap<String, String>();

		InventoryData = new HashMap<String, ArrayList<String>>();

		for (ArrayList<String> Journal : ItemJournals) {

			ItemNumber = Journal.get(0);

			logger.info("ItemNumber: " + ItemNumber);

			filterItemNumber(ItemNumber);

			SelectItemNumber(ItemNumber);

			clickExtendedattributes();

			String EquipmentItem = getEquipmentItem();

			String ProductionItem = getProductionItem();

			if (EquipmentItem.equals("No")) {

				clickManagecosts();

				Thread.sleep(2000);

				Data.add(getPrices());

				Data.add(getPricequantity());

				ManageCostsData.put(ItemNumber, new ArrayList<String>(Data));

				Data.clear();

				Data.add(EquipmentItem);

				Data.add(ProductionItem);

				ExtendedAttributesData.put(ItemNumber, new ArrayList<String>(Data));

				Data.clear();

				getProjectCategories_FieldService();

				getInventoryData();

				clickClose();

			}

			else if (EquipmentItem.equals("Yes")) {

				Data.add(EquipmentItem);

				Data.add(ProductionItem);

				ExtendedAttributesData.put(ItemNumber, new ArrayList<String>(Data));

				Data.clear();

				getProjectCategories_FieldService();

				getInventoryData();

				clickClose();
			}
		}

		logger.info("Extended Attributes Data :" + ExtendedAttributesData);

		logger.info("Manage Costs Data: " + ManageCostsData);
	}

	@FindBy(xpath = "//*[@class='toggle-box' and contains(@aria-labelledby,'EquipmentItem')]//following-sibling::*[@class='toggle-value']")
	WebElement EquipmentItem;

	public String getEquipmentItem() throws InterruptedException {

		String EquipmentItemValue = common.getText(EquipmentItem);

		return EquipmentItemValue;

	}

	public void checkEquipmentItemToggleNotSelected() throws InterruptedException {

		Assert.assertEquals(getEquipmentItem(), "No", "Equipment Item Toggle is Selected which is not expected");
	}

	public void checkEquipmentItemToggleSelected() throws InterruptedException {

		Assert.assertEquals(getEquipmentItem(), "Yes", "Equipment Item Toggle is not Selected as expected");
	}

	@FindBy(xpath = "//*[@class='toggle-box' and contains(@aria-labelledby,'ProductionItem')]//following-sibling::*[@class='toggle-value']")
	WebElement ProductionItem;

	public String getProductionItem() throws InterruptedException {

		String ProductionItemValue = common.getText(ProductionItem);

		return ProductionItemValue;

	}

	public void checkProductionItemToggleNotSelected() throws InterruptedException {

		Assert.assertEquals(getProductionItem(), "No", "Production Item Toggle is Selected which is not expected");
	}

	@FindBy(xpath = "//*[text()='Extended attributes' and @aria-label='Extended attributes']")
	WebElement Extendedattributes;

	public void clickExtendedattributes() throws InterruptedException {

		if (common.isSectionExpanded(Extendedattributes) == false) {

			common.clickElement(Extendedattributes);
		}
	}

	@FindBy(xpath = "//*[text()='Manage costs' and @aria-label='Manage costs']")
	WebElement Managecosts;

	public void clickManagecosts() throws InterruptedException {

		if (common.isSectionExpanded(Managecosts) == false) {

			common.clickElement(Managecosts);
		}
	}

	@FindBy(xpath = "//*[@aria-label='Transaction ID']")
	WebElement TransactionID_OverheadTransactions;

	public boolean checkOverheadTransactionsDisplayed() throws InterruptedException {

		return common.isTextDisplayed(TransactionID_OverheadTransactions);

	}

	public boolean checkOverheadTransactionsPosted(String CategoryValue) throws InterruptedException {

		boolean Post;

		logger.info("Category Value:" + CategoryValue);

		if (ProjectAllocationRates.containsKey(CategoryValue)) {

			Post = true;

		} else {

			Post = false;
		}

		if (Post == true) {

			Assert.assertEquals(checkOverheadTransactionsDisplayed(), Post,
					"Overhead Transactions has not been posted as expected for Category: " + CategoryValue);

		}

		else if (Post == false) {

			Assert.assertEquals(checkOverheadTransactionsDisplayed(), Post,
					"Overhead Transactions has been posted which is not expected for Category: " + CategoryValue);

		}
		return Post;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Task code']")
	WebElement Taskcode_OverheadTransactions;

	public String getTaskcode_OverheadTransactions() throws InterruptedException {

		String Taskcode_OT = common.getValue(Taskcode_OverheadTransactions);

		return Taskcode_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Priority']")
	WebElement Priority_OverheadTransactions;

	public String getPriority_OverheadTransactions() throws InterruptedException {

		String Priority_OT = common.getValue(Priority_OverheadTransactions);

		return Priority_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Source category']")
	WebElement Sourcecategory_OverheadTransactions;

	public String getSourceCategory_OverheadTransactions() throws InterruptedException {

		String SourceCategory_OT = common.getValue(Sourcecategory_OverheadTransactions);

		return SourceCategory_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Category ID']")
	WebElement CategoryID_OverheadTransactions;

	public String getCategoryID_OverheadTransactions() throws InterruptedException {

		String CategoryID_OT = common.getValue(CategoryID_OverheadTransactions);

		return CategoryID_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Rule ID']")
	WebElement RuleID_OverheadTransactions;

	public String getRuleID_OverheadTransactions() throws InterruptedException {

		String RuleID_OT = common.getValue(RuleID_OverheadTransactions);

		return RuleID_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Rate value']")
	WebElement RateValue_OverheadTransactions;

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Rate percent']")
	WebElement RatePercent_OverheadTransactions;

	public String getRate_OverheadTransactions(String Category) throws InterruptedException {

		String RateType = ProjectAllocationRates.get(Category).get(1);

		String Rate = null;

		if (RateType.equals("Quantity")) {

			Rate = common.getValue(RateValue_OverheadTransactions);
		}

		else if (RateType.equals("Charges percentage")) {

			Rate = common.getValue(RatePercent_OverheadTransactions);
		}

		return Rate;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Total cost price']")
	WebElement Totalcostprice_OverheadTransactions;

	public String getTotalcostprice_OverheadTransactions() throws InterruptedException {

		String Totalcostprice_OT = common.getValue(Totalcostprice_OverheadTransactions);

		return Totalcostprice_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Item number']")
	WebElement Itemnumber_OverheadTransactions;

	public String getItemnumber_OverheadTransactions() throws InterruptedException {

		String ItemNumber_OT = common.getValue(Itemnumber_OverheadTransactions);

		return ItemNumber_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Amount']")
	WebElement Amount_OverheadTransactions;

	public String getAmount_OverheadTransactions() throws InterruptedException {

		String Amount_OT = common.getValue(Amount_OverheadTransactions);

		return Amount_OT;
	}

	@FindBy(xpath = "//*[contains(@id,'OverheadTransaction') and @aria-label='Cost price']")
	WebElement Costprice_OverheadTransactions;

	public String getCostprice_OverheadTransactions() throws InterruptedException {

		String Costprice_OT = common.getValue(Costprice_OverheadTransactions);

		return Costprice_OT;
	}

	public String getPriorityBasedOnProjectCategory(String ProjectCategory) {

		ArrayList<String> ProjectAllocationData = ProjectAllocationRates.get(ProjectCategory);

		String Priority = ProjectAllocationData.get(0);

		return Priority;

	}

	public String getDestinationCategoryBasedOnSourceCategory(String ProjectCategory) {

		String DestinatonCategoryValue = DestinatonCategory.get(ProjectCategory);

		return DestinatonCategoryValue;

	}

	public String getRateBasedOnProjectCategory(String ProjectCategory) throws InterruptedException {

		String Rate = ProjectAllocationRates.get(ProjectCategory).get(2);

		return Rate;

	}

	public String getAmountFromRateValueAndHours(String HoursOrQuantity, String Category) throws InterruptedException {

		String Amount = formulas.getProduct(HoursOrQuantity, getRate_OverheadTransactions(Category));

		return Amount;
	}

	public String getAmountFromRateAndTotalCostPrice(String Category) throws InterruptedException {

		String Amount = formulas.getInvoiceAmount(getRate_OverheadTransactions(Category),
				getTotalcostprice_OverheadTransactions());

		return Amount;
	}

	/*
	 * public void checkOverheadTransactionsPostedData(String TaskCode, String
	 * ProjectCategory, String TotalCostPrice, String HoursOrQuantity, String
	 * CostPrice) throws InterruptedException {
	 * 
	 * SoftAssert sa = new SoftAssert();
	 * 
	 * sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
	 * "Task code is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getPriority_OverheadTransactions(),
	 * getPriorityBasedOnProjectCategory(ProjectCategory),
	 * "Priority is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
	 * "Source Category is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCategoryID_OverheadTransactions(),
	 * getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
	 * "CategoryID is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
	 * "RuleID is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRate_OverheadTransactions(ProjectCategory),
	 * getRateBasedOnProjectCategory(ProjectCategory),
	 * "Rate Value is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
	 * "Total Cost Price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getAmount_OverheadTransactions(),
	 * getAmountFromRateValueAndHours(HoursOrQuantity, ProjectCategory),
	 * "Amount is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
	 * "Cost price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertAll();
	 * 
	 * Amount_OverheadTransactions_Total_Posted =
	 * formulas.getSum(Amount_OverheadTransactions_Total_Posted,
	 * getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted: " +
	 * Amount_OverheadTransactions_Total_Posted);
	 * 
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
	 * ProjectCategory, getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec);
	 * 
	 * }
	 * 
	 * public void checkOverheadTransactionsPostedData_ItemJournal(String TaskCode,
	 * String ProjectCategory, String ItemNumber, String TotalCostPrice, String
	 * Hours, String CostPrice) throws InterruptedException {
	 * 
	 * SoftAssert sa = new SoftAssert();
	 * 
	 * sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
	 * "Task code is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getPriority_OverheadTransactions(),
	 * getPriorityBasedOnProjectCategory(ProjectCategory),
	 * "Priority is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
	 * "Source Category is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCategoryID_OverheadTransactions(),
	 * getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
	 * "CategoryID is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
	 * "RuleID is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRate_OverheadTransactions(ProjectCategory),
	 * getRateBasedOnProjectCategory(ProjectCategory),
	 * "Rate Value is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getItemnumber_OverheadTransactions(), ItemNumber,
	 * "Item number is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
	 * "Total Cost Price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getAmount_OverheadTransactions(),
	 * getAmountFromRateAndTotalCostPrice(ProjectCategory),
	 * "Amount is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
	 * "Cost price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertAll();
	 * 
	 * Amount_OverheadTransactions_Total_Posted =
	 * formulas.getSum(Amount_OverheadTransactions_Total_Posted,
	 * getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted: " +
	 * Amount_OverheadTransactions_Total_Posted);
	 * 
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
	 * ProjectCategory, getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec); }
	 */

	// ======================Execute revenue recognition using PFO
	// report===================

	@FindBy(xpath = "(//*[text()='Fiscal year']//following::input)[1]")
	WebElement Fiscalyear;

	public void setFiscalyear(String FiscalYear) throws InterruptedException {

		Thread.sleep(2000);

		common.setTextAfterDelete(Fiscalyear, FiscalYear);
	}

	/*
	 * @FindBy(xpath = "(//*[text()='End date']//following::input)[1]") WebElement
	 * Enddate;
	 * 
	 * public void setEndDate(String EndDate) throws InterruptedException {
	 * 
	 * common.setTextAfterClear(Enddate, EndDate); }
	 */

	@FindBy(xpath = "(//*[text()='Task description']//following::input)[1]")
	WebElement Taskdescription;

	public String setTaskDescription() throws InterruptedException {

		TaskDescription_RefreshProjFinData = common.generateUniqueID("TaskDescription");

		common.setTextAfterClear(Taskdescription, TaskDescription_RefreshProjFinData);

		logger.info("Task Description: " + TaskDescription_RefreshProjFinData);

		return TaskDescription_RefreshProjFinData;

	}

	@FindBy(xpath = "(//*[text()='Job description'])[2]")
	WebElement Jobdescription;

	public void clickJobdescription() throws InterruptedException {

		common.clickElement(Jobdescription);

	}

	/*
	 * @FindBy(xpath = "(//*[text()='Scheduled start date/time'])[2]") WebElement
	 * Scheduledstartdateortime;
	 * 
	 * @FindBy(xpath = "//*[text()='Sort newest to oldest']") WebElement
	 * Sortnewesttooldest;
	 * 
	 * public void clickScheduledstartdateortime() throws InterruptedException {
	 * 
	 * common.clickElement(Scheduledstartdateortime);
	 * 
	 * common.clickElement(Sortnewesttooldest);
	 * 
	 * Thread.sleep(3000); }
	 */

	public String getStatus_Batchjob(String TaskDescription) throws InterruptedException {

		WebElement Status_Batchjob = ldriver.findElement(By.xpath("//*[@value='" + TaskDescription
				+ "']//ancestor::*[contains(@id,'Caption')]//preceding-sibling::*[contains(@id,'Status')]//child::*[@aria-label='Status']"));

		return common.getValue(Status_Batchjob);

	}

	public String getJobID_Batchjob(String TaskDescription) throws InterruptedException {

		WebElement JobID_Batchjob = ldriver.findElement(By.xpath("//*[@value='" + TaskDescription
				+ "']//ancestor::*[contains(@id,'Caption')]//preceding-sibling::*[contains(@id,'RecId')]//child::*[@aria-label='Job ID']"));

		return JobID = common.getValue(JobID_Batchjob);

	}

	public void checkStatus_BatchJob_Ended(String Description, String Status) throws InterruptedException {

		int counter = 1;

		String ActualStatus = getStatus_Batchjob(Description);

		while (!ActualStatus.equals(Status)) {

			Thread.sleep(5000);

			clickRefresh();

			if (counter > 48) {

				Assert.assertEquals(ActualStatus, Status,
						"Batch job status has not been updated as expected in 4 minutes");

			} else if (ActualStatus.equals(Status)) {

				Assert.assertTrue(true);

				logger.info("Batch job status has been updated to " + Status + " status as expected");
			}
			counter = counter + 1;

			ActualStatus = getStatus_Batchjob(Description);

		}
	}

	@FindBy(xpath = "(//*[text()='Batch job ID'])[2]")
	WebElement BatchjobID;

	public void clickBatchjobID() throws InterruptedException {

		common.clickElement(BatchjobID);

	}

	@FindBy(xpath = "//*[contains(@aria-label,'Batch job ID')]")
	WebElement BatchJobIds;

	public void checkBatchJobId(String BatchJobID) throws InterruptedException {

		Thread.sleep(3000);

		WebElement BatchJobIds = ldriver.findElement(By.xpath("//*[contains(@value,'" + BatchJobID + "')]"));

		Assert.assertTrue(common.isTextDisplayed(BatchJobIds), "Batch job ID has not been displayed as expected");
	}

	@FindBy(xpath = "//*[@aria-label='Current CV $']")
	WebElement CurrentCV$;
	@FindBy(xpath = "//*[@aria-label='Rev Rec ECAC cost']")
	WebElement RevRecECACcost;
	@FindBy(xpath = "//*[@aria-label='Rev Rec Actual cost']")
	WebElement RevRecActualcost;
	@FindBy(xpath = "//*[@aria-label='% cmp']")
	WebElement Percentagecmp;
	@FindBy(xpath = "//*[@aria-label='MTD Earned Revenue']")
	WebElement MTDEarnedRevenue;
	@FindBy(xpath = "//*[@aria-label='PTD Earned Revenue']")
	WebElement PTDEarnedRevenue;
	@FindBy(xpath = "//*[@aria-label='Unposted revenue']")
	WebElement Unpostedrevenue;
	@FindBy(xpath = "//*[@aria-label='ECAC Cost $']")
	WebElement ECACCost$;
	@FindBy(xpath = "//*[@aria-label='PTD Cost $']")
	WebElement PTDCost$;
	@FindBy(xpath = "//*[@aria-label='PTD Rev $']")
	WebElement PTDRev$;
	@FindBy(xpath = "//*[@aria-label='PTD Earned Margin']")
	WebElement PTDEarnedMargin;
	@FindBy(xpath = "//*[@aria-label='PTD Earned Margin Percent']")
	WebElement PTDEarnedMarginPercent;
	@FindBy(xpath = "//*[@aria-label='PTD Earned Revenue Cost']")
	WebElement PTDEarnedRevenueCost;

	public void getRevenueRecognition() throws InterruptedException {

		RevenueRecognition = new HashMap<String, String>();

		RevenueRecognition.put("CurrentCV", common.getValue(CurrentCV$));

		RevenueRecognition.put("RevRecECACcost", common.getValue(RevRecECACcost));

		RevenueRecognition.put("RevRecActualcost", common.getValue(RevRecActualcost));

		RevenueRecognition.put("Percentagecmp", common.getValue(Percentagecmp));

		RevenueRecognition.put("MTDEarnedRevenue", common.getValue(MTDEarnedRevenue));

		RevenueRecognition.put("PTDEarnedRevenue", common.getValue(PTDEarnedRevenue));

		RevenueRecognition.put("Unpostedrevenue", common.getValue(Unpostedrevenue));

		RevenueRecognition.put("ECACCost", common.getValue(ECACCost$));

		RevenueRecognition.put("PTDCost", common.getValue(PTDCost$));

		RevenueRecognition.put("PTDRev", common.getValue(PTDRev$));

		RevenueRecognition.put("PTDEarnedMargin", common.getValue(PTDEarnedMargin));

		RevenueRecognition.put("PTDEarnedMarginPercent", common.getValue(PTDEarnedMarginPercent));

		RevenueRecognition.put("PTDEarnedRevenueCost", common.getValue(PTDEarnedRevenueCost));

		logger.info("Revenue Recognition: " + RevenueRecognition);
	}

	@FindBy(xpath = "//*[contains(@class,'dyn-hoverMarkingColumn')]")
	WebElement selectline;

	public void selectLine() throws InterruptedException {

		Thread.sleep(2000);

		common.scrollIntoView(selectline);

		Thread.sleep(2000);

		common.clickElement(selectline);

		Thread.sleep(2000);
	}

	@FindBy(xpath = "//*[text()='The Revenue recognition process job is added to the batch queue.']")
	WebElement batchAddedMessage;

	public void validateProcessJobIsAddedToTheBatchQueue() throws InterruptedException {

		Assert.assertTrue(common.isTextDisplayed(batchAddedMessage),
				"The Revenue recognition process job is not added to the batch queue as expected");

	}

	@FindBy(xpath = "//*[text()='Project group']//following::*[contains(@aria-labelledby,'ctrlProjGroup')]")
	WebElement Projectgroup_Projects;

	public void selectProjectgroup_Projects() throws InterruptedException {

		clickProjectTab();

		Thread.sleep(10000);

		clickFastTab("General");

		Thread.sleep(30000);

		common.clickElementJS(Projectgroup_Projects);

		Thread.sleep(30000);
	}

	@FindBy(xpath = "//*[contains(@aria-label,'Estimate')]")
	WebElement Estimate;

	public void clickEstimate() throws InterruptedException {

		if (common.isSectionExpanded(Estimate) == false) {

			common.clickElement(Estimate);
		}
	}

	@FindBy(xpath = "//*[text()='Sales value']//following::*[contains(@aria-labelledby,'SalesvalueCategoryId')]")
	WebElement SalesValue;

	public String getCategoryId() throws InterruptedException {

		CategoryID = common.getText(SalesValue);

		logger.info("Category ID: " + CategoryID);

		return CategoryID;
	}

	@FindBy(xpath = "//*[contains(@class,'isFilterable') and contains(@data-dyn-controlname,'CategoryId')]")
	WebElement CategoryID_ProjectGroup;

	public void clickCategoryID() throws InterruptedException {

		common.clickElement(CategoryID_ProjectGroup);

	}

	@FindBy(xpath = "//*[@aria-label='Category ID']")
	WebElement CategoryID_PostedTransactions;

	public void validateCategoryID_PostedTransactions() throws InterruptedException {

		Assert.assertEquals(common.getValue(CategoryID_PostedTransactions), CategoryID,
				"Category ID: " + CategoryID + " is not dispayed as expected");
	}

	@FindBy(xpath = "//*[@aria-label='Total sales amount']")
	WebElement Totalsalesamount_PostedTransactions;

	public void validateTotalsalesamount_PostedTransactions() throws InterruptedException {

		Assert.assertEquals(common.getValue(Totalsalesamount_PostedTransactions),
				RevenueRecognition.get("Unpostedrevenue"), "Total Sales amount has not been displayed as expected");
	}

	@FindBy(xpath = "//*[@aria-label='Transaction type']")
	WebElement Transactiontype_PostedTransactions;

	public void validateTransactiontype_PostedTransactions(String arg1) throws InterruptedException {

		Assert.assertEquals(common.getValue(Transactiontype_PostedTransactions), arg1,
				"Transaction type has not been displayed as expected");

	}

	// Added by Monica Part 2
	@FindBy(xpath = "//*[text()='Refresh project financials data']")
	WebElement Refreshprojectfinancialsdata_PCMSubModule;

	@FindBy(xpath = "//*[contains(@aria-label,'Project cost management') and @data-dyn-title='Project cost management']")
	WebElement Projectcostmanagement_PCMSubModule;

	@FindBy(xpath = "//*[text()='My projects']")
	WebElement Myprojects_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project contracts']")
	WebElement Projectcontracts_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project budgets']")
	WebElement Projectbudgets_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project change order']")
	WebElement Projectchangeorder_PCMSubModule;

	@FindBy(xpath = "(//*[text()='ECAC'])[1]")
	WebElement ECAC_PCMSubModuleProjBudget;

	@FindBy(xpath = "//*[text()='Summary ECAC - request']")
	WebElement SummaryECACrequest_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Set ECAC to actual'])[1]")
	WebElement SetECACtoactual_PCMSubModuleProjBudget;

	@FindBy(xpath = "//*[text()='Customer change orders']")
	WebElement Customerchangeorders_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Construction contracts'])[2]")
	WebElement Constructioncontracts_PCMSubModule;

	@FindBy(xpath = "//*[text()='Construction applications']")
	WebElement Constructionapplications_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Subcontracts'])[2]")
	WebElement Subcontracts_PCMSubModuleSubcontracts;

	@FindBy(xpath = "//*[text()='All vendors']")
	WebElement Allvendors_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Loss making project'])[2]")
	WebElement Lossmakingproject_PCMSubModule;

	@FindBy(xpath = "//*[text()='Loss making audit trail']")
	WebElement Lossmakingaudittrail_PCMSubModule;

	@FindBy(xpath = "//*[text()='Revenue recognition audit trail']")
	WebElement Revenuerecognitionaudittrail_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project allocation rates']")
	WebElement Projectallocationrates_PCMSubModule;

	@FindBy(xpath = "//*[text()='Overhead transaction inquiry']")
	WebElement Overheadtransactioninquiry_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO template excel export']")
	WebElement PFOtemplateexcelexport_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO template excel import']")
	WebElement PFOtemplateexcelimport_PCMSubModule;

	@FindBy(xpath = "//*[text()='PCA template excel export']")
	WebElement PCAtemplateexcelexport_PCMSubModule;

	@FindBy(xpath = "//*[text()='PCA template excel import']")
	WebElement PCAtemplateexcelimport_PCMSubModule;

	@FindBy(xpath = "//*[text()='Refresh PCA data']")
	WebElement RefreshPCAdata_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project dimension setup table update']")
	WebElement Projectdimensionsetuptableupdate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Delete project financial data']")
	WebElement Deleteprojectfinancialdata_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO & PCA data refresh']")
	WebElement PFOPCAdatarefresh_PCMSubModule;

	@FindBy(xpath = "//*[text()='Refresh project cost by cost type']")
	WebElement Refreshprojectcostbycosttype_PCMSubModule;

	@FindBy(xpath = "//*[text()='PCA batch history']")
	WebElement PCAbatchhistory_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project budget Import']")
	WebElement ProjectbudgetImport_PCMSubModule;

	@FindBy(xpath = "//*[text()='Import budget from excel']")
	WebElement Importbudgetfromexcel_PCMSubModule;

	@FindBy(xpath = "//*[text()='Approve budgets']")
	WebElement Approvebudgets_PCMSubModule;

	@FindBy(xpath = "//*[text()='Commit approved budgets']")
	WebElement Commitapprovedbudgets_PCMSubModule;

	@FindBy(xpath = "//*[text()='Verify subcontract compliance']")
	WebElement Verifysubcontractcompliance_PCMSubModule;

	@FindBy(xpath = "//*[text()='Release invoices']")
	WebElement Releaseinvoices_PCMSubModule;

	@FindBy(xpath = "//*[text()='Create construction contract template']")
	WebElement Createconstructioncontracttemplate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Import construction contract from excel']")
	WebElement Importconstructioncontractfromexcel_PCMSubModule;

	@FindBy(xpath = "//*[text()='Create ECAC import template']")
	WebElement CreateECACimporttemplate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Import ECAC from excel']")
	WebElement ImportECACfromexcel_PCMSubModule;

	@FindBy(xpath = "//*[text()='Approve ECAC']")
	WebElement ApproveECAC_PCMSubModule;

	@FindBy(xpath = "//*[text()='Commit approved ECAC']")
	WebElement CommitapprovedECAC_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Set ECAC to actual'])[2]")
	WebElement SetECACtoactual_PCMSubModuleECAC;

	@FindBy(xpath = "//*[text()='Project cost analysis BI data provider']")
	WebElement ProjectcostanalysisBIdataprovider_PCMSubModule;

	@FindBy(xpath = "//*[text()='Production performance BI']")
	WebElement ProductionperformanceBI_PCMSubModule;

	@FindBy(xpath = "//*[text()='Last labor date update']")
	WebElement Lastlabordateupdate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Last invoice date update']")
	WebElement Lastinvoicedateupdate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Time and material percent complete']")
	WebElement Timeandmaterialpercentcomplete_PCMSubModule;

	@FindBy(xpath = "//*[text()='Time and material percent complete audit trail']")
	WebElement Timeandmaterialpercentcompleteaudittrail_PCMSubModule;

	@FindBy(xpath = "//*[text()='PCA inquiry']")
	WebElement PCAinquiry_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO Inquiry']")
	WebElement PFOInquiry_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project summary inquiry']")
	WebElement Projectsummaryinquiry_PCMSubModule;

	@FindBy(xpath = "//*[text()='Orphan PFO inquiry']")
	WebElement OrphanPFOinquiry_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project summary report']")
	WebElement Projectsummaryreport_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project WIP']")
	WebElement ProjectWIP_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project net change WIP']")
	WebElement ProjectnetchangeWIP_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project cost analysis']")
	WebElement Projectcostanalysis_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project sales value analysis']")
	WebElement Projectsalesvalueanalysis_PCMSubModule;

	@FindBy(xpath = "//*[text()='Revenue recognition preview']")
	WebElement Revenuerecognitionpreview_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project key performance indicators']")
	WebElement Projectkeyperformanceindicators_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project ECAC revision history']")
	WebElement ProjectECACrevisionhistory_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project ECAC margin trend']")
	WebElement ProjectECACmargintrend_PCMSubModule;

	@FindBy(xpath = "//*[text()='Customer aging report by project']")
	WebElement Customeragingreportbyproject_PCMSubModule;

	@FindBy(xpath = "//*[text()='Vendor aging report by project']")
	WebElement Vendoragingreportbyproject_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project transaction by contract line']")
	WebElement Projecttransactionbycontractline_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project actual transactions']")
	WebElement Projectactualtransactions_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project 360']")
	WebElement Project360_PCMSubModule;

	@FindBy(xpath = "//*[text()='Task code by project']")
	WebElement Taskcodebyproject_PCMSubModule;

	@FindBy(xpath = "//*[text()='Production performance']")
	WebElement Productionperformance_PCMSubModule;

	@FindBy(xpath = "//*[text()='SOV worksheet']")
	WebElement SOVworksheet_PCMSubModule;

	@FindBy(xpath = "//*[text()='Orphan project categories']")
	WebElement Orphanprojectcategories_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project open invoices']")
	WebElement Projectopeninvoices_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project customer invoices overdue']")
	WebElement Projectcustomerinvoicesoverdue_PCMSubModule;

	@FindBy(xpath = "//*[text()='PCM - Customer account statement']")
	WebElement PCMCustomeraccountstatement_PCMSubModule;
	/*
	 * @FindBy(xpath = "//*[text()='SIS system parameters']") WebElement
	 * SISsystemparameters_PCMSubModule;
	 */

	@FindBy(xpath = "//*[text()='Project cost management parameters']")
	WebElement Projectcostmanagementparameters_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project cost management workflow']")
	WebElement Projectcostmanagementworkflow_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project default dimension setup']")
	WebElement Projectdefaultdimensionsetup_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO inquiry column setup']")
	WebElement PFOinquirycolumnsetup_PCMSubModule;

	@FindBy(xpath = "//*[text()='PFO inquiry template']")
	WebElement PFOinquirytemplate_PCMSubModule;

	@FindBy(xpath = "//*[text()='Budget categories']")
	WebElement Budgetcategories_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Task codes'])[2]")
	WebElement Taskcodes_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project task - hour sales price']")
	WebElement Projecttaskhoursalesprice_PCMSubModule;

	@FindBy(xpath = "//*[text()='Project task templates']")
	WebElement Projecttasktemplates_PCMSubModule;

	@FindBy(xpath = "//*[text()='Vendor speciality']")
	WebElement Vendorspeciality_PCMSubModule;

	@FindBy(xpath = "//*[text()='Compliance type']")
	WebElement Compliancetype_PCMSubModule;

	@FindBy(xpath = "//*[text()='Vendor evaluation criteria']")
	WebElement Vendorevaluationcriteria_PCMSubModule;

	@FindBy(xpath = "//*[text()='Last labor project category setup']")
	WebElement Lastlaborprojectcategorysetup_PCMSubModule;

	@FindBy(xpath = "//*[text()='Work sites']")
	WebElement Worksites_PCMSubModule;

	@FindBy(xpath = "//*[text()='Priority Search']")
	WebElement PrioritySearch_PCMSubModule;

	@FindBy(xpath = "//*[text()='System administration']")
	WebElement Systemadministration;

	@FindBy(xpath = "//*[text()='Projects ready for ECAC']")
	WebElement ProjectsReadyForECAC_PCMSubModule;

	/*
	 * public void selectSubModule(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("All projects")) {
	 * 
	 * common.clickElement(Allprojects); }
	 * 
	 * // Added by Monica
	 * 
	 * if (arg1.equals("Project allocation rules")) {
	 * 
	 * common.clickElement(Projectallocationrules_PCMSubModule);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * } // Added by Monica on 3/2/23
	 * 
	 * if (arg1.equals("Refresh project financial data")) {
	 * 
	 * common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); } if (arg1.equals("Project cost management")) {
	 * 
	 * common.clickElement(Projectcostmanagement_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("My projects")) {
	 * 
	 * common.clickElement(Myprojects_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project contracts")) {
	 * 
	 * common.clickElement(Projectcontracts_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project budgets")) {
	 * 
	 * common.clickElement(Projectbudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project change order")) {
	 * 
	 * common.clickElement(Projectchangeorder_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("ECAC")) {
	 * 
	 * common.clickElement(ECAC_PCMSubModuleProjBudget);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Summary ECAC - request")) {
	 * 
	 * common.clickElement(SummaryECACrequest_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Set ECAC to actual")) {
	 * 
	 * common.clickElement(SetECACtoactual_PCMSubModuleProjBudget);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Customer change orders")) {
	 * 
	 * common.clickElement(Customerchangeorders_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Construction contracts")) {
	 * 
	 * common.clickElement(Constructioncontracts_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Construction applications")) {
	 * 
	 * common.clickElement(Constructionapplications_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Subcontracts")) {
	 * 
	 * common.clickElement(Subcontracts_PCMSubModuleSubcontracts);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("All vendors")) {
	 * 
	 * common.clickElement(Allvendors_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Loss making project")) {
	 * 
	 * common.clickElement(Lossmakingproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Loss making audit trail")) {
	 * 
	 * common.clickElement(Lossmakingaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Revenue recognition audit trail")) {
	 * 
	 * common.clickElement(Revenuerecognitionaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project allocation rates")) {
	 * 
	 * common.clickElement(Projectallocationrates_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Overhead transaction inquiry")) {
	 * 
	 * common.clickElement(Overheadtransactioninquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO template excel export")) {
	 * 
	 * common.clickElement(PFOtemplateexcelexport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO template excel import")) {
	 * 
	 * common.clickElement(PFOtemplateexcelimport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA template excel export")) {
	 * 
	 * common.clickElement(PCAtemplateexcelexport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA template excel import")) {
	 * 
	 * common.clickElement(PCAtemplateexcelimport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh project financials data")) {
	 * 
	 * common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh PCA data")) {
	 * 
	 * common.clickElement(RefreshPCAdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project dimension setup table update")) {
	 * 
	 * common.clickElement(Projectdimensionsetuptableupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Delete project financial data")) {
	 * 
	 * common.clickElement(Deleteprojectfinancialdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO & PCA data refresh")) {
	 * 
	 * common.clickElement(PFOPCAdatarefresh_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh project cost by cost type")) {
	 * 
	 * common.clickElement(Refreshprojectcostbycosttype_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA batch history")) {
	 * 
	 * common.clickElement(PCAbatchhistory_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project budget Import")) {
	 * 
	 * common.clickElement(ProjectbudgetImport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import budget from excel")) {
	 * 
	 * common.clickElement(Importbudgetfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Approve budgets")) {
	 * 
	 * common.clickElement(Approvebudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Commit approved budgets")) {
	 * 
	 * common.clickElement(Commitapprovedbudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Verify subcontract compliance")) {
	 * 
	 * common.clickElement(Verifysubcontractcompliance_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Release invoices")) {
	 * 
	 * common.clickElement(Releaseinvoices_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Create construction contract template")) {
	 * 
	 * common.clickElement(Createconstructioncontracttemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import construction contract from excel")) {
	 * 
	 * common.clickElement(Importconstructioncontractfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Create ECAC import template")) {
	 * 
	 * common.clickElement(CreateECACimporttemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import ECAC from excel")) {
	 * 
	 * common.clickElement(ImportECACfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Approve ECAC")) {
	 * 
	 * common.clickElement(ApproveECAC_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Commit approved ECAC")) {
	 * 
	 * common.clickElement(CommitapprovedECAC_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Set ECAC to actual")) {
	 * 
	 * common.clickElement(SetECACtoactual_PCMSubModuleECAC);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost analysis BI data provider")) {
	 * 
	 * common.clickElement(ProjectcostanalysisBIdataprovider_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Production performance BI")) {
	 * 
	 * common.clickElement(ProductionperformanceBI_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last labor date update")) {
	 * 
	 * common.clickElement(Lastlabordateupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last invoice date update")) {
	 * 
	 * common.clickElement(Lastinvoicedateupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Time and material percent complete")) {
	 * 
	 * common.clickElement(Timeandmaterialpercentcomplete_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Time and material percent complete audit trail")) {
	 * 
	 * common.clickElement(Timeandmaterialpercentcompleteaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA inquiry")) {
	 * 
	 * common.clickElement(PCAinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO Inquiry")) {
	 * 
	 * common.clickElement(PFOInquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project summary inquiry")) {
	 * 
	 * common.clickElement(Projectsummaryinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Orphan PFO inquiry")) {
	 * 
	 * common.clickElement(OrphanPFOinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project WIP")) {
	 * 
	 * common.clickElement(ProjectWIP_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project summary report")) {
	 * 
	 * common.clickElement(Projectsummaryreport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost analysis")) {
	 * 
	 * common.clickElement(Projectcostanalysis_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project sales value analysis")) {
	 * 
	 * common.clickElement(Projectsalesvalueanalysis_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Revenue recognition preview")) {
	 * 
	 * common.clickElement(Revenuerecognitionpreview_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project key performance indicators")) {
	 * 
	 * common.clickElement(Projectkeyperformanceindicators_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project ECAC revision history")) {
	 * 
	 * common.clickElement(ProjectECACrevisionhistory_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project ECAC margin trend")) {
	 * 
	 * common.clickElement(ProjectECACmargintrend_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Customer aging report by project")) {
	 * 
	 * common.clickElement(Customeragingreportbyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor aging report by project")) {
	 * 
	 * common.clickElement(Vendoragingreportbyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project transaction by contract line")) {
	 * 
	 * common.clickElement(Projecttransactionbycontractline_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project actual transactions")) {
	 * 
	 * common.clickElement(Projectactualtransactions_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project 360")) {
	 * 
	 * common.clickElement(Project360_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Task code by project")) {
	 * 
	 * common.clickElement(Taskcodebyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Production performance")) {
	 * 
	 * common.clickElement(Productionperformance_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("SOV worksheet")) {
	 * 
	 * common.clickElement(SOVworksheet_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Orphan project categories")) {
	 * 
	 * common.clickElement(Orphanprojectcategories_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project open invoices")) {
	 * 
	 * common.clickElement(Projectopeninvoices_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project customer invoices overdue")) {
	 * 
	 * common.clickElement(Projectcustomerinvoicesoverdue_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCM - Customer account statement")) {
	 * 
	 * common.clickElement(PCMCustomeraccountstatement_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("SIS system parameters")) {
	 * 
	 * common.clickElement(SISsystemparameters_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost management parameters")) {
	 * 
	 * common.clickElement(Projectcostmanagementparameters_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost management workflow")) {
	 * 
	 * common.clickElement(Projectcostmanagementworkflow_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project default dimension setup")) {
	 * 
	 * common.clickElement(Projectdefaultdimensionsetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO inquiry column setup")) {
	 * 
	 * common.clickElement(PFOinquirycolumnsetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO inquiry template")) {
	 * 
	 * common.clickElement(PFOinquirytemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Budget categories")) {
	 * 
	 * common.clickElement(Budgetcategories_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Task codes")) {
	 * 
	 * common.clickElement(Taskcodes_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project task - hour sales price")) {
	 * 
	 * common.clickElement(Projecttaskhoursalesprice_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project task templates")) {
	 * 
	 * common.clickElement(Projecttasktemplates_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor speciality")) {
	 * 
	 * common.clickElement(Vendorspeciality_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Compliance type")) {
	 * 
	 * common.clickElement(Compliancetype_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor evaluation criteria")) {
	 * 
	 * common.clickElement(Vendorevaluationcriteria_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last labor project category setup")) {
	 * 
	 * common.clickElement(Lastlaborprojectcategorysetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Work sites")) {
	 * 
	 * common.clickElement(Worksites_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Priority Search")) {
	 * 
	 * common.clickElement(PrioritySearch_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project management and accounting parameters")) {
	 * 
	 * common.clickElement(Projectmanagementandaccountingparameters_PMA);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * }
	 */

	/*
	 * @FindBy(xpath = "//*[text()='PFO batch history']") WebElement
	 * PFObatchhistory_PCMSubModule;
	 * 
	 * @FindBy(xpath = "(//*[text()='Revenue recognition'])[3]") WebElement
	 * Revenuerecognition_PCMSubModule;
	 * 
	 * @FindBy(xpath = "//*[text()='Batch jobs']") WebElement
	 * Batchjobs_SysAdmSubModule;
	 */

	/*
	 * public void clickModulesAndSubModules(String arg1, String arg2) throws
	 * InterruptedException
	 * 
	 * {
	 * 
	 * clickModules();
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * common.clickElement(Projectcostmanagement);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * clickExpandall();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("All projects")) {
	 * 
	 * common.clickElement(Allprojects);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Project allocation rules")) {
	 * 
	 * common.clickElement(Projectallocationrules_PCMSubModule);
	 * 
	 * Thread.sleep(2000); } // Added by Monica on 6/2/23
	 * 
	 * if (arg1.equals("PFO batch history")) {
	 * 
	 * common.clickElement(PFObatchhistory_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Revenue recognition")) {
	 * 
	 * common.clickElement(Revenuerecognition_PCMSubModule);
	 * 
	 * Thread.sleep(1000); } if (arg1.equals("Project contracts")) {
	 * 
	 * common.clickElement(Projectcontracts_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project budgets")) {
	 * 
	 * common.clickElement(Projectbudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project change order")) {
	 * 
	 * common.clickElement(Projectchangeorder_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("ECAC")) {
	 * 
	 * common.clickElement(ECAC_PCMSubModuleProjBudget);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Summary ECAC - request")) {
	 * 
	 * common.clickElement(SummaryECACrequest_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Set ECAC to actual")) {
	 * 
	 * common.clickElement(SetECACtoactual_PCMSubModuleProjBudget);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Customer change orders")) {
	 * 
	 * common.clickElement(Customerchangeorders_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Construction contracts")) {
	 * 
	 * common.clickElement(Constructioncontracts_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Construction applications")) {
	 * 
	 * common.clickElement(Constructionapplications_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Subcontracts")) {
	 * 
	 * common.clickElement(Subcontracts_PCMSubModuleSubcontracts);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("All vendors")) {
	 * 
	 * common.clickElement(Allvendors_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Loss making project")) {
	 * 
	 * common.clickElement(Lossmakingproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Loss making audit trail")) {
	 * 
	 * common.clickElement(Lossmakingaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Revenue recognition audit trail")) {
	 * 
	 * common.clickElement(Revenuerecognitionaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project allocation rates")) {
	 * 
	 * common.clickElement(Projectallocationrates_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Overhead transaction inquiry")) {
	 * 
	 * common.clickElement(Overheadtransactioninquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO template excel export")) {
	 * 
	 * common.clickElement(PFOtemplateexcelexport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO template excel import")) {
	 * 
	 * common.clickElement(PFOtemplateexcelimport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA template excel export")) {
	 * 
	 * common.clickElement(PCAtemplateexcelexport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA template excel import")) {
	 * 
	 * common.clickElement(PCAtemplateexcelimport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh project financials data")) {
	 * 
	 * common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh PCA data")) {
	 * 
	 * common.clickElement(RefreshPCAdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project dimension setup table update")) {
	 * 
	 * common.clickElement(Projectdimensionsetuptableupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Delete project financial data")) {
	 * 
	 * common.clickElement(Deleteprojectfinancialdata_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO & PCA data refresh")) {
	 * 
	 * common.clickElement(PFOPCAdatarefresh_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Refresh project cost by cost type")) {
	 * 
	 * common.clickElement(Refreshprojectcostbycosttype_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA batch history")) {
	 * 
	 * common.clickElement(PCAbatchhistory_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project budget Import")) {
	 * 
	 * common.clickElement(ProjectbudgetImport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import budget from excel")) {
	 * 
	 * common.clickElement(Importbudgetfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Approve budgets")) {
	 * 
	 * common.clickElement(Approvebudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Commit approved budgets")) {
	 * 
	 * common.clickElement(Commitapprovedbudgets_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Verify subcontract compliance")) {
	 * 
	 * common.clickElement(Verifysubcontractcompliance_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Release invoices")) {
	 * 
	 * common.clickElement(Releaseinvoices_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Create construction contract template")) {
	 * 
	 * common.clickElement(Createconstructioncontracttemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import construction contract from excel")) {
	 * 
	 * common.clickElement(Importconstructioncontractfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Create ECAC import template")) {
	 * 
	 * common.clickElement(CreateECACimporttemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Import ECAC from excel")) {
	 * 
	 * common.clickElement(ImportECACfromexcel_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Approve ECAC")) {
	 * 
	 * common.clickElement(ApproveECAC_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Commit approved ECAC")) {
	 * 
	 * common.clickElement(CommitapprovedECAC_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Set ECAC to actual")) {
	 * 
	 * common.clickElement(SetECACtoactual_PCMSubModuleECAC);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost analysis BI data provider")) {
	 * 
	 * common.clickElement(ProjectcostanalysisBIdataprovider_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Production performance BI")) {
	 * 
	 * common.clickElement(ProductionperformanceBI_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last labor date update")) {
	 * 
	 * common.clickElement(Lastlabordateupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last invoice date update")) {
	 * 
	 * common.clickElement(Lastinvoicedateupdate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Time and material percent complete")) {
	 * 
	 * common.clickElement(Timeandmaterialpercentcomplete_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Time and material percent complete audit trail")) {
	 * 
	 * common.clickElement(Timeandmaterialpercentcompleteaudittrail_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCA inquiry")) {
	 * 
	 * common.clickElement(PCAinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO Inquiry")) {
	 * 
	 * common.clickElement(PFOInquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project summary inquiry")) {
	 * 
	 * common.clickElement(Projectsummaryinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Orphan PFO inquiry")) {
	 * 
	 * common.clickElement(OrphanPFOinquiry_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project WIP")) {
	 * 
	 * common.clickElement(ProjectWIP_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project summary report")) {
	 * 
	 * common.clickElement(Projectsummaryreport_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost analysis")) {
	 * 
	 * common.clickElement(Projectcostanalysis_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project sales value analysis")) {
	 * 
	 * common.clickElement(Projectsalesvalueanalysis_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Revenue recognition preview")) {
	 * 
	 * common.clickElement(Revenuerecognitionpreview_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project key performance indicators")) {
	 * 
	 * common.clickElement(Projectkeyperformanceindicators_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project ECAC revision history")) {
	 * 
	 * common.clickElement(ProjectECACrevisionhistory_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project ECAC margin trend")) {
	 * 
	 * common.clickElement(ProjectECACmargintrend_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Customer aging report by project")) {
	 * 
	 * common.clickElement(Customeragingreportbyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor aging report by project")) {
	 * 
	 * common.clickElement(Vendoragingreportbyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project transaction by contract line")) {
	 * 
	 * common.clickElement(Projecttransactionbycontractline_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project actual transactions")) {
	 * 
	 * common.clickElement(Projectactualtransactions_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project 360")) {
	 * 
	 * common.clickElement(Project360_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Task code by project")) {
	 * 
	 * common.clickElement(Taskcodebyproject_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Production performance")) {
	 * 
	 * common.clickElement(Productionperformance_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("SOV worksheet")) {
	 * 
	 * common.clickElement(SOVworksheet_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Orphan project categories")) {
	 * 
	 * common.clickElement(Orphanprojectcategories_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project open invoices")) {
	 * 
	 * common.clickElement(Projectopeninvoices_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project customer invoices overdue")) {
	 * 
	 * common.clickElement(Projectcustomerinvoicesoverdue_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PCM - Customer account statement")) {
	 * 
	 * common.clickElement(PCMCustomeraccountstatement_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("SIS system parameters")) {
	 * 
	 * common.clickElement(SISsystemparameters_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost management parameters")) {
	 * 
	 * common.clickElement(Projectcostmanagementparameters_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project cost management workflow")) {
	 * 
	 * common.clickElement(Projectcostmanagementworkflow_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project default dimension setup")) {
	 * 
	 * common.clickElement(Projectdefaultdimensionsetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO inquiry column setup")) {
	 * 
	 * common.clickElement(PFOinquirycolumnsetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("PFO inquiry template")) {
	 * 
	 * common.clickElement(PFOinquirytemplate_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Budget categories")) {
	 * 
	 * common.clickElement(Budgetcategories_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Task codes")) {
	 * 
	 * common.clickElement(Taskcodes_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project task - hour sales price")) {
	 * 
	 * common.clickElement(Projecttaskhoursalesprice_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Project task templates")) {
	 * 
	 * common.clickElement(Projecttasktemplates_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor speciality")) {
	 * 
	 * common.clickElement(Vendorspeciality_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Compliance type")) {
	 * 
	 * common.clickElement(Compliancetype_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Vendor evaluation criteria")) {
	 * 
	 * common.clickElement(Vendorevaluationcriteria_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Last labor project category setup")) {
	 * 
	 * common.clickElement(Lastlaborprojectcategorysetup_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Work sites")) {
	 * 
	 * common.clickElement(Worksites_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Priority Search")) {
	 * 
	 * common.clickElement(PrioritySearch_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * if (arg1.equals("Projects ready for ECAC")) {
	 * 
	 * common.clickElement(ProjectsReadyForECAC_PCMSubModule);
	 * 
	 * Thread.sleep(1000); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Equipment usage")) {
	 * 
	 * if (!common.isMenuExpanded(Equipmentusage)) {
	 * 
	 * common.clickElement(Equipmentusage); }
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("Equipment standard costs")) {
	 * 
	 * common.clickElement(Equipmentstandardcosts);
	 * 
	 * Thread.sleep(2000); } }
	 * 
	 * if (arg2.equals("Product information management")) {
	 * 
	 * common.clickElement(Productinformationmanagement);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * if (arg1.equals("Released products")) {
	 * 
	 * common.clickElement(Releasedproducts_Products);
	 * 
	 * Thread.sleep(2000); } }
	 * 
	 * // Added by Monica on 6/2/23 if (arg2.equals("System administration")) {
	 * 
	 * common.clickElement(Systemadministration);
	 * 
	 * Thread.sleep(1000);
	 * 
	 * if (arg1.equals("Batch jobs")) {
	 * 
	 * common.clickElement(Batchjobs_SysAdmSubModule);
	 * 
	 * Thread.sleep(1000); } }
	 * 
	 * if (arg2.equals("Accounts receivable")) {
	 * 
	 * common.clickElement(AccountsReceivable);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * clickExpandall();
	 * 
	 * if (arg1.equals("Customer payment journal")) {
	 * 
	 * common.clickElement(CustomerPaymentJournal);
	 * 
	 * Thread.sleep(3000); }
	 * 
	 * }
	 * 
	 * }
	 */

	// ==============Changed by Monica

	/*
	 * @FindBy(xpath = "//*[@name='GroupContractOverview_RetainagePercentage']")
	 * WebElement Retainage;
	 * 
	 * public void setRetainage(String RetainageValue) throws InterruptedException {
	 * logger.info("RetainageValue: " + RetainageValue);
	 * common.setTextAfterDelete(Retainage, RetainageValue); }
	 */

	@FindBy(xpath = "//input[@name='CtrlProjId']")
	WebElement ProjectID;

	public void setProjectID() throws InterruptedException {
		ProjectIDValue = common.generateUniqueID("ProjID");
		common.setText(ProjectID, ProjectIDValue);
		logger.info("Project ID:" + ProjectIDValue);
	}

	/*
	 * public void clickPageHeader(String arg1) throws InterruptedException { if
	 * (arg1.equals("Project cost management")) {
	 * clickProjectcostmanagement_PageHeader(); } if (arg1.equals("Manage")) {
	 * clickManage(); } }
	 */

	@FindBy(xpath = "(//*[text()='New'])[4]")
	WebElement New_JournalLine;
	@FindBy(xpath = "(//*[text()='New'])[5]")
	WebElement New_JournalLine2;

	public void clickNewJournalLine() throws InterruptedException {
		try {
			common.clickElement(New_JournalLine);
		} catch (Exception e) {
			common.clickElement(New_JournalLine2);
		}
	}

//===============changed by Monica(27-02-2023)======================

	/*
	 * public void setHourJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * AmountData_Journals = new HashMap<String, String>();
	 * 
	 * for (ArrayList<String> HourJournal : HourJournals) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * String TaskcodeValue = HourJournal.get(0);
	 * 
	 * String ProjectCategoryValue = HourJournal.get(1);
	 * 
	 * String ResourseIdValue = HourJournal.get(2);
	 * 
	 * String HoursValue = HourJournal.get(3);
	 * 
	 * String CostPriceValue = HourJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = HourJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(HoursValue, CostPriceValue);
	 * 
	 * getJournalsAmountData(TaskcodeValue, TotalCostPrice);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( ProjectCategoryValue,
	 * TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Projectdate = ldriver
	 * .findElement(By.xpath("//*[contains(@class,'date-picker-button')][" + row +
	 * "]"));
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * WebElement Taskcode_Journal = ldriver.findElement(By
	 * .xpath("(//*[text()='Task code']//following::*[contains(@id,'SISTaskCode')])[3]["
	 * + row + "]"));
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ProjectCategoryValue.equals("")) {
	 * 
	 * WebElement Category_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Category']//following::*[contains(@id,'CategoryId')])[3][" +
	 * row + "]"));
	 * 
	 * common.setTextAfterDelete(Category_Journal, ProjectCategoryValue);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * WebElement Resourceid_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[5][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Resourceid_Journal, ResourseIdValue);
	 * 
	 * selectResource_HourJournal(ResourseIdValue);
	 * 
	 * // clickSelect();
	 * 
	 * }
	 * 
	 * if (!HoursValue.equals("")) {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) ldriver;
	 * 
	 * js.executeScript("arguments[0].scrollIntoView(true);", Hours_Journal);
	 * 
	 * WebElement Hours_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Hours']//following::*[contains(@id,'ctrlProjQty')])[4][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Hours_Journal, HoursValue);
	 * 
	 * }
	 * 
	 * clickGeneralTab();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * WebElement Costprice_Journal = ldriver.findElement( By.
	 * xpath("//*[text()='Cost price']//following::*[@name='CostPrice_CostPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterDelete(Costprice_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * WebElement Salesprice_Journal = ldriver.findElement(By
	 * .xpath("//*[text()='Sales price']//following::*[@name='SalesPrice_SalesPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterClear(Salesprice_Journal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(ProjectCategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, ProjectCategoryValue,
	 * TotalCostPrice, HoursValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickRefresh();
	 * 
	 * int Line = Integer.parseInt(LineNumberValue) + 1;
	 * 
	 * LineNumberValue = Integer.toString(Line);
	 * 
	 * // row++; } }
	 */

	@FindBy(xpath = "(//*[contains(@class,'date-picker-button')])[2]")
	WebElement Projectdate_ExpenseJournal;

	@FindBy(xpath = "//*[@aria-label='Category']")
	WebElement Category_Journal;

	@FindBy(xpath = "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[4]")
	WebElement ExpenseResourceid_Journal;

	@FindBy(xpath = "//*[contains(@id,'CostPrice') and @aria-label='Cost price']")
	WebElement Costprice_ExpenseJournal;

	@FindBy(xpath = "//*[contains(@id,'SalesPrice') and @aria-label='Sales price']")
	WebElement Salesprice_ExpenseJournal;

	/*
	 * public void setExpenseJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * for (ArrayList<String> ExpenseJournal : ExpenseJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * }
	 * 
	 * String TaskcodeValue = ExpenseJournal.get(0);
	 * 
	 * String CategoryValue = ExpenseJournal.get(1);
	 * 
	 * String ResourseIdValue = ExpenseJournal.get(2);
	 * 
	 * String QuantityValue = ExpenseJournal.get(3);
	 * 
	 * String CostPriceValue = ExpenseJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = ExpenseJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(QuantityValue, CostPriceValue);
	 * 
	 * getJournalsAmountData(TaskcodeValue, TotalCostPrice);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( CategoryValue,
	 * TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Category_Journal, CategoryValue);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(ExpenseResourceid_Journal, ResourseIdValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * selectResource_ExpenseJournal(ResourseIdValue);
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Costprice_ExpenseJournal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ExpenseJournal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, CategoryValue,
	 * TotalCostPrice, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * row++; } }
	 * 
	 * public void setItemJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * for (ArrayList<String> ItemJournal : ItemJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNewJournalLine();
	 * 
	 * }
	 * 
	 * String ItemNumberValue = ItemJournal.get(0);
	 * 
	 * String QuantityValue = ItemJournal.get(1);
	 * 
	 * String CostPriceValue = ItemJournal.get(2);
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue); }
	 * 
	 * String TaskcodeValue = ItemJournal.get(3);
	 * 
	 * String ChargeTypeValue = ItemJournal.get(4);
	 * 
	 * String CategoryValue = ItemJournal.get(5);
	 * 
	 * String SalesPriceValue = ItemJournal.get(6);
	 * 
	 * String SiteValue = ItemJournal.get(7);
	 * 
	 * String WarehouseValue = ItemJournal.get(8);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ItemNumberValue.equals("")) {
	 * 
	 * common.setText(ItemNumber_Journal, ItemNumberValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * common.KeyboardAction("Enter");
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * clickProjectSubtab();
	 * 
	 * if (!ChargeTypeValue.equals("")) {
	 * 
	 * common.setTextAfterClear(ChargeType_Journal, ChargeTypeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Category_ItemJournal, CategoryValue);
	 * 
	 * }
	 * 
	 * else if (CategoryValue.equals("")) {
	 * 
	 * CategoryValue = checkCategoryValue(ItemNumberValue); }
	 * 
	 * if (SalesPriceValue.equals("")) {
	 * 
	 * SalesPriceValue = checkSalesPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * else if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ItemJournal, SalesPriceValue); }
	 * 
	 * clickOverview_Journal();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(CostPriceValue_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * else if (CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = checkCostPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * String CostAmountValue = common.getValue(Costamount);
	 * 
	 * String CostAmount = checkLineAmount(QuantityValue, CostPriceValue,
	 * CostAmountValue, row);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( CategoryValue,
	 * CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * clickProductDimensionsSubtab();
	 * 
	 * if (!SiteValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Site_ItemJournal, SiteValue);
	 * 
	 * }
	 * 
	 * else if (SiteValue.equals("")) {
	 * 
	 * SiteValue = checkSiteValue(ItemNumberValue); }
	 * 
	 * if (!WarehouseValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Warehouse_ItemJournal, WarehouseValue);
	 * 
	 * }
	 * 
	 * else if (WarehouseValue.equals("")) {
	 * 
	 * WarehouseValue = checkWarehouseValue(ItemNumberValue); }
	 * 
	 * // clickOverview_Journal();
	 * 
	 * common.KeyboardAction("Tab");
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData_ItemJournal(TaskcodeValue, CategoryValue,
	 * ItemNumberValue, CostAmountValue, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose_OverheadAllocationTransaction();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * if (row == 1) {
	 * 
	 * ItemJournals = new ArrayList<ArrayList<String>>();
	 * 
	 * }
	 * 
	 * updateItemJournalData(ItemNumberValue, QuantityValue, CostPriceValue,
	 * TaskcodeValue, ChargeTypeValue, CategoryValue, SalesPriceValue, SiteValue,
	 * WarehouseValue);
	 * 
	 * row++; } }
	 * 
	 * public void checkOverheadTransactionsPostedData(String TaskCode, String
	 * ProjectCategory, String TotalCostPrice, String HoursOrQuantity, String
	 * CostPrice) throws InterruptedException {
	 * 
	 * SoftAssert sa = new SoftAssert();
	 * 
	 * sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
	 * "Task code is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getPriority_OverheadTransactions(),
	 * getPriorityBasedOnProjectCategory(ProjectCategory),
	 * "Priority is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
	 * "Source Category is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCategoryID_OverheadTransactions(),
	 * getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
	 * "CategoryID is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
	 * "RuleID is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRate_OverheadTransactions(ProjectCategory),
	 * getRateBasedOnProjectCategory(ProjectCategory),
	 * "Rate Value is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
	 * "Total Cost Price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getAmount_OverheadTransactions(),
	 * getAmountFromRateValueAndHours(HoursOrQuantity, ProjectCategory),
	 * "Amount is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
	 * "Cost price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertAll();
	 * 
	 * Amount_OverheadTransactions_Total_Posted =
	 * formulas.getSum(Amount_OverheadTransactions_Total_Posted,
	 * getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted: " +
	 * Amount_OverheadTransactions_Total_Posted);
	 * 
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
	 * ProjectCategory, getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec);
	 * 
	 * getJournalsAmountData(TaskCode, getAmount_OverheadTransactions());
	 * 
	 * }
	 * 
	 * public void checkOverheadTransactionsPostedData_ItemJournal(String TaskCode,
	 * String ProjectCategory, String ItemNumber, String TotalCostPrice, String
	 * Hours, String CostPrice) throws InterruptedException {
	 * 
	 * SoftAssert sa = new SoftAssert();
	 * 
	 * sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
	 * "Task code is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getPriority_OverheadTransactions(),
	 * getPriorityBasedOnProjectCategory(ProjectCategory),
	 * "Priority is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
	 * "Source Category is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCategoryID_OverheadTransactions(),
	 * getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
	 * "CategoryID is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
	 * "RuleID is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getRate_OverheadTransactions(ProjectCategory),
	 * getRateBasedOnProjectCategory(ProjectCategory),
	 * "Rate Value is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getItemnumber_OverheadTransactions(), ItemNumber,
	 * "Item number is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
	 * "Total Cost Price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getAmount_OverheadTransactions(),
	 * getAmountFromRateAndTotalCostPrice(ProjectCategory),
	 * "Amount is not as expected in overhead transactions for Project Category: " +
	 * ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
	 * "Cost price is not as expected in overhead transactions for Project Category: "
	 * + ProjectCategory + " and Taskcode: " + TaskCode);
	 * 
	 * sa.assertAll();
	 * 
	 * Amount_OverheadTransactions_Total_Posted =
	 * formulas.getSum(Amount_OverheadTransactions_Total_Posted,
	 * getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted: " +
	 * Amount_OverheadTransactions_Total_Posted);
	 * 
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
	 * ProjectCategory, getAmount_OverheadTransactions());
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec);
	 * 
	 * getJournalsAmountData(TaskCode, getAmount_OverheadTransactions());
	 * 
	 * }
	 */

//==========Release and cancel retainage amount========================

	@FindBy(xpath = "//*[text()='Retainage release application']")
	WebElement Retainagereleaseapplication;

	public void clickRetainagereleaseapplication() throws InterruptedException {

		common.clickElement(Retainagereleaseapplication);

		Thread.sleep(5000);

	}

	@FindBy(xpath = "//*[text()='Auto release retention amount']")
	WebElement Autoreleaseretentionamount;

	public void clickAutoreleaseretentionamount() throws InterruptedException {

		Thread.sleep(2000);

		common.clickElementJS(Autoreleaseretentionamount);

		Thread.sleep(2000);

	}

	/*
	 * public void getConstructionContractOverviewData() throws InterruptedException
	 * {
	 * 
	 * ConstructionContract_RetainagePercentage = new HashMap<String, String>();
	 * ConstructionContract_RetainageAmount = new HashMap<String, String>();
	 * ConstructionContract_PrevRetainage = new HashMap<String, String>();
	 * ConstructionContract_TotalRetainage = new HashMap<String, String>();
	 * ConstructionContract_PrevWorkInPlace = new HashMap<String, String>();
	 * ConstructionContract_PrevPercentage = new HashMap<String, String>();
	 * ConstructionContract_Cost = new HashMap<String, String>();
	 * ConstructionContract_PercentComplete = new HashMap<String, String>();
	 * ConstructionContract_WorkInPlace = new HashMap<String, String>();
	 * ConstructionContract_InvoiceAmount = new HashMap<String, String>();
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description = ldriver.findElement( By.
	 * xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" +
	 * row + "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));
	 * 
	 * String RetainagePercentageValue = common.getValue(RetainagePercentage);
	 * 
	 * ConstructionContract_RetainagePercentage.put(DescriptionValue,
	 * RetainagePercentageValue);
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));
	 * 
	 * String PercentCompleteValue = common.getValue(PercentComplete);
	 * 
	 * ConstructionContract_PercentComplete.put(DescriptionValue,
	 * PercentCompleteValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row +
	 * "]"));
	 * 
	 * String WorkInPlaceValue = common.getValue(WorkInPlace);
	 * 
	 * ConstructionContract_WorkInPlace.put(DescriptionValue, WorkInPlaceValue);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));
	 * 
	 * String RetainageAmountValue = common.getValue(RetainageAmount);
	 * 
	 * ConstructionContract_RetainageAmount.put(DescriptionValue,
	 * RetainageAmountValue);
	 * 
	 * WebElement PrevRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * ConstructionContract_PrevRetainage.put(DescriptionValue, PrevRetainagevalue);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * ConstructionContract_TotalRetainage.put(DescriptionValue,
	 * TotalRetainagevalue);
	 * 
	 * WebElement PrevWorkInPlace = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row +
	 * "]"));
	 * 
	 * String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);
	 * 
	 * ConstructionContract_PrevWorkInPlace.put(DescriptionValue,
	 * PrevWorkInPlaceValue);
	 * 
	 * WebElement PrevPercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));
	 * 
	 * String PrevPercentageValue = common.getValue(PrevPercentage);
	 * 
	 * ConstructionContract_PrevPercentage.put(DescriptionValue,
	 * PrevPercentageValue);
	 * 
	 * WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])["
	 * + row + "]"));
	 * 
	 * String CostsValue = common.getValue(Costs);
	 * 
	 * ConstructionContract_Cost.put(DescriptionValue, CostsValue);
	 * 
	 * WebElement InvoiceAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));
	 * 
	 * String InvoiceAmountValue = common.getValue(InvoiceAmount);
	 * 
	 * ConstructionContract_InvoiceAmount.put(DescriptionValue, InvoiceAmountValue);
	 * }
	 * 
	 * logger.info("ConstructionContract_RetainagePercentage :" +
	 * ConstructionContract_RetainagePercentage);
	 * 
	 * logger.info("ConstructionContract_RetainageAmount :" +
	 * ConstructionContract_RetainageAmount);
	 * 
	 * logger.info("ConstructionContract_PrevRetainage :" +
	 * ConstructionContract_PrevRetainage);
	 * 
	 * logger.info("ConstructionContract_TotalRetainage :" +
	 * ConstructionContract_TotalRetainage);
	 * 
	 * logger.info("ConstructionContract_PrevWorkInPlace :" +
	 * ConstructionContract_PrevWorkInPlace);
	 * 
	 * logger.info("ConstructionContract_PrevPercentage :" +
	 * ConstructionContract_PrevPercentage);
	 * 
	 * logger.info("ConstructionContract_Cost :" + ConstructionContract_Cost);
	 * 
	 * logger.info("ConstructionContract_PercentComplete :" +
	 * ConstructionContract_PercentComplete);
	 * 
	 * logger.info("ConstructionContract_WorkInPlace :" +
	 * ConstructionContract_WorkInPlace);
	 * 
	 * logger.info("ConstructionContract_InvoiceAmount :" +
	 * ConstructionContract_InvoiceAmount);
	 * 
	 * }
	 */

	/*
	 * @FindBy (xpath = "(//*[@aria-label='Retention invoice'])[2]") WebElement
	 * Retentioninvoice; public String getRetentionInvoice() throws
	 * InterruptedException {
	 * 
	 * RetentionInvoice = common.getValue(Retentioninvoice);
	 * 
	 * return RetentionInvoice; }
	 * 
	 * public void checkRetentioninvoicepopulated() {
	 * 
	 * WebElement Retentioninvoice1 =
	 * ldriver.findElement(By.xpath("//*[@value='"+RetentionInvoice+"']"));
	 * 
	 * common.isTextDisplayed(Retentioninvoice1);
	 * 
	 * }
	 */

	public void getConstructionContractApplicationsData() throws InterruptedException {

		PercentComplete_CCapplication = new HashMap<String, String>();
		InvoiceAmount_CCapplication = new HashMap<String, String>();
		RetainagePercentage_CCapplication = new HashMap<String, String>();
		RetentionToDate_CCapplication = new HashMap<String, String>();
		RetainageAmount_CCapplication = new HashMap<String, String>();
		AmountDue_CCapplication = new HashMap<String, String>();

		for (int line = 1; line <= getNumberofLinesInApplicationDrawOverview(); line++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridLines')])[" + line + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement Percentcomplete = ldriver.findElement(
					By.xpath("(//*[@aria-label='Percent complete' and contains(@id,'GridLines')])[" + line + "]"));

			String PercentcompleteValue = common.getValue(Percentcomplete);

			PercentComplete_CCapplication.put(DescriptionValue, PercentcompleteValue);

			WebElement Invoiceamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Invoice amount' and contains(@id,'GridLines')])[" + line + "]"));

			String InvoiceamountValue = common.getValue(Invoiceamount);

			InvoiceAmount_CCapplication.put(DescriptionValue, InvoiceamountValue);

			WebElement Retentionpercentage = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage %' and contains(@id,'GridLines')])[" + line + "]"));

			String RetentionpercentageValue = common.getValue(Retentionpercentage);

			RetainagePercentage_CCapplication.put(DescriptionValue, RetentionpercentageValue);

			WebElement Retentiontodate = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retention to date' and contains(@id,'GridLines')])[" + line + "]"));

			String RetentiontodateValue = common.getValue(Retentiontodate);

			RetentionToDate_CCapplication.put(DescriptionValue, RetentiontodateValue);

			WebElement Retainageamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage amount' and contains(@id,'GridLines')])[" + line + "]"));

			String RetainageamountValue = common.getValue(Retainageamount);

			RetainageAmount_CCapplication.put(DescriptionValue, RetainageamountValue);

			WebElement Amountdue = ldriver.findElement(
					By.xpath("(//*[@aria-label='Amount due' and contains(@id,'GridLines')])[" + line + "]"));

			String AmountdueValue = common.getValue(Amountdue);

			AmountDue_CCapplication.put(DescriptionValue, AmountdueValue);
		}

	}

	public void checkContractOverviewCalcAfterRetainageUpdate() throws InterruptedException {

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentageValue = common.getValue(RetainagePercentage);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			checkPreviousRetainage_CCOverview_AfterRetainageChange(DescriptionValue, PrevRetainagevalue);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountValue = common.getValue(RetainageAmount);

			checkRetainageAmountAfterRetainageRelease(PrevRetainagevalue, RetainagePercentageValue,
					RetainageAmountValue, DescriptionValue);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			checkTotalRetainage_CCOverview_AfterRetainageChange(RetainageAmountValue, PrevRetainagevalue,
					TotalRetainagevalue, DescriptionValue);

			WebElement PrevWorkInPlace = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row + "]"));

			String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);

			checkPrevWorkInPlace_CCOverview_AfterRetainageChange(DescriptionValue, PrevWorkInPlaceValue);

			WebElement PrevPercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));

			String PrevPercentageValue = common.getValue(PrevPercentage);

			checkPrevPercentage_CCOverview_AfterRetainageChange(DescriptionValue, PrevPercentageValue);

			WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			String CostsValue = common.getValue(Costs);

			checkCostAmount_CCOverview_AfterRetainageChange(DescriptionValue, CostsValue);

		}
	}

	/*
	 * public void checkCostAmount_CCOverview_AfterRetainageChange(String
	 * DescriptionValue, String CostAmount) throws InterruptedException {
	 * 
	 * logger.info("Amount Data Journals: " + AmountData_Journals);
	 * 
	 * String ExpectedCostAmount = "0.00";
	 * 
	 * for (ArrayList<String> ConstructionContract : ConstructionContracts) {
	 * 
	 * String Description = ConstructionContract.get(0);
	 * 
	 * if (Description.equals(DescriptionValue)) {
	 * 
	 * String[] TaskCodes = ConstructionContract.get(2).split(";");
	 * 
	 * for (int i = 0; i < TaskCodes.length; i++) {
	 * 
	 * String Amount = AmountData_Journals.get(TaskCodes[i]);
	 * 
	 * if (Amount != null) {
	 * 
	 * ExpectedCostAmount = formulas.getSum(ExpectedCostAmount, Amount); } } }
	 * 
	 * }
	 * 
	 * logger.info("Cost Amount Expected: " + ExpectedCostAmount);
	 * 
	 * logger.info("Cost Amount Actual: " + CostAmount);
	 * 
	 * Assert.assertEquals(CostAmount, ExpectedCostAmount,
	 * "Cost Amount in Contract is not as expected after retainage change for " +
	 * DescriptionValue); }
	 */

	public void checkPreviousRetainage_CCOverview_AfterRetainageChange(String DescriptionValue,
			String PrevRetainage_CCOverview) throws InterruptedException {

		String ExpectedPrevRetainage = ConstructionContract_RetainageAmount.get(DescriptionValue);

		logger.info("Prev.Retainage Expected: " + ExpectedPrevRetainage);

		logger.info("Prev.Retainage Actual: " + PrevRetainage_CCOverview);

		Assert.assertEquals(PrevRetainage_CCOverview, ExpectedPrevRetainage,
				"Prev.Retainage in Contract is not as expected after retainage change for " + DescriptionValue);

	}

	public void checkRetainageAmountAfterRetainageRelease(String PrevRetainage, String UpdatedRetainagePercentage,
			String RetainageAmount, String DescriptionValue) throws InterruptedException {

		String ExpectedRetainageAmount = formulas.getProdOfTwoValuesDivTen(PrevRetainage, UpdatedRetainagePercentage);

		if (Double.parseDouble(ExpectedRetainageAmount) > 0) {

			ExpectedRetainageAmount = "-" + ExpectedRetainageAmount;
		}

		logger.info("Retainage Amount Expected: " + ExpectedRetainageAmount);

		logger.info("Retainage Amount Actual: " + RetainageAmount);

		Assert.assertEquals(RetainageAmount, ExpectedRetainageAmount,
				"Retainage Amount in Contract is not as expected after retainage release for " + DescriptionValue);

	}

	public void checkTotalRetainage_CCOverview_AfterRetainageChange(String RetainageAmount, String PrevRetainage,
			String TotalRetainage, String DescriptionValue) throws InterruptedException {

		String ExpectedTotalRetainage = formulas.getSum(RetainageAmount, PrevRetainage);

		logger.info("TotalRetainage Expected: " + ExpectedTotalRetainage);

		logger.info("TotalRetainage Actual: " + TotalRetainage);

		Assert.assertEquals(TotalRetainage, ExpectedTotalRetainage,
				"Total Retainage in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkPrevWorkInPlace_CCOverview_AfterRetainageChange(String DescriptionValue, String PrevWorkInPlace) {

		String ExpectedPrevWorkInPlace = ConstructionContract_WorkInPlace.get(DescriptionValue);

		logger.info("Prev.WorkInPlace Expected: " + ExpectedPrevWorkInPlace);

		logger.info("Prev.WorkInPlace Actual: " + PrevWorkInPlace);

		Assert.assertEquals(PrevWorkInPlace, ExpectedPrevWorkInPlace,
				"Prev.Work in place in Contract is not as expected after retainage change for " + DescriptionValue);

	}

	public void checkPrevPercentage_CCOverview_AfterRetainageChange(String DescriptionValue, String PrevPercentage) {

		String ExpectedPrevPercentage = ConstructionContract_PercentComplete.get(DescriptionValue);

		logger.info("PrevPercentage Expected: " + ExpectedPrevPercentage);

		logger.info("Prev.Percentage Actual: " + PrevPercentage);

		Assert.assertEquals(PrevPercentage, ExpectedPrevPercentage,
				"Prev.Percentage in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkContractApplicationCalcAfterRetainageUpdate() throws InterruptedException {

		for (int line = 1; line <= getNumberofLinesInApplicationDrawOverview(); line++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridLines')])[" + line + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement Percentcomplete = ldriver.findElement(
					By.xpath("(//*[@aria-label='Percent complete' and contains(@id,'GridLines')])[" + line + "]"));

			String PercentCompleteValue = common.getValue(Percentcomplete);

			checkPercentComplete_CCApplication_AfterRetainageChange(DescriptionValue, PercentCompleteValue);

			WebElement Invoiceamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Invoice amount' and contains(@id,'GridLines')])[" + line + "]"));

			String InvoiceamountValue = common.getValue(Invoiceamount);

			checkInvoiceAmount_CCApplication_AfterRetainageChange(DescriptionValue, InvoiceamountValue);

			WebElement RetainagePercentage = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage %' and contains(@id,'GridLines')])[" + line + "]"));

			String RetainagePercentageValue = common.getValue(RetainagePercentage);

			checkRetainagePercentage_CCApplication_AfterRetainageChange(DescriptionValue, RetainagePercentageValue);

			WebElement RetentionToData = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retention to date' and contains(@id,'GridLines')])[" + line + "]"));

			String RetentionToDateValue = common.getValue(RetentionToData);

			checkRetentionToDate_CCApplication_AfterRetainageChange(DescriptionValue, RetentionToDateValue);

			WebElement RetainageAmount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Retainage amount' and contains(@id,'GridLines')])[" + line + "]"));

			String RetainageAmountValue = common.getValue(RetainageAmount);

			checkRetainageAmount_CCApplication_AfterRetainageChange(DescriptionValue, RetainageAmountValue);
			WebElement AmountDue = ldriver.findElement(
					By.xpath("(//*[@aria-label='Amount due' and contains(@id,'GridLines')])[" + line + "]"));

			String AmountDueValue = common.getValue(AmountDue);

			checkAmountDue_CCApplication_AfterRetainageChange(DescriptionValue, RetainageAmountValue,
					InvoiceamountValue, AmountDueValue);
		}
	}

	/*
	 * public void checkAmountDue_CCApplication_AfterRetainageChange(String
	 * DescriptionValue, String RetainageAmount, String InvoiceAmount, String
	 * AmountDue) throws InterruptedException {
	 * 
	 * String ExpectedAmountDue_CCApplication =
	 * formulas.getSubtractionOfTwoValues(InvoiceAmount, RetainageAmount);
	 * 
	 * logger.info("Percent Complete Expected: " + ExpectedAmountDue_CCApplication);
	 * 
	 * logger.info("Percent Complete Actual: " + AmountDue);
	 * 
	 * Assert.assertEquals(AmountDue, ExpectedAmountDue_CCApplication,
	 * "Amount Due in Contract is not as expected after retainage change for " +
	 * DescriptionValue); }
	 */

	public void checkRetainageAmount_CCApplication_AfterRetainageChange(String DescriptionValue,
			String RetainageAmount) {

		String ExpectedRetainageAmount_CCApplication = ConstructionContract_RetainageAmount_AfterRetainageChange
				.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedRetainageAmount_CCApplication);

		logger.info("Percent Complete Actual: " + RetainageAmount);

		Assert.assertEquals(RetainageAmount, ExpectedRetainageAmount_CCApplication,
				"Retainage Amount in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkRetentionToDate_CCApplication_AfterRetainageChange(String DescriptionValue,
			String RetentionToDate) {

		String ExpectedRetentionToDate_CCApplication = ConstructionContract_TotalRetainage_AfterRetainageChange
				.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedRetentionToDate_CCApplication);

		logger.info("Percent Complete Actual: " + RetentionToDate);

		Assert.assertEquals(RetentionToDate, ExpectedRetentionToDate_CCApplication,
				"Retention To Date in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkRetainagePercentage_CCApplication_AfterRetainageChange(String DescriptionValue,
			String RetainagePercentage) {

		String ExpectedRetainagePercentage_CCApplication = ConstructionContract_RetainagePercentage_AfterRetainageChange
				.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedRetainagePercentage_CCApplication);

		logger.info("Percent Complete Actual: " + RetainagePercentage);

		Assert.assertEquals(RetainagePercentage, ExpectedRetainagePercentage_CCApplication,
				"Retainage Percentage in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkPercentComplete_CCApplication_AfterRetainageChange(String DescriptionValue,
			String PercentComplete) {

		String ExpectedPercentComplete_CCApplication = ConstructionContract_PercentComplete_AfterRetainageChange
				.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedPercentComplete_CCApplication);

		logger.info("Percent Complete Actual: " + PercentComplete);

		Assert.assertEquals(PercentComplete, ExpectedPercentComplete_CCApplication,
				"Percent Complete in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkInvoiceAmount_CCApplication_AfterRetainageChange(String DescriptionValue, String InvoiceAmount) {

		String ExpectedInvoiceAmount_CCApplication = ConstructionContract_InvoiceAmount_AfterRetainageChange
				.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedInvoiceAmount_CCApplication);

		logger.info("Percent Complete Actual: " + InvoiceAmount);

		Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmount_CCApplication,
				"Invoice Amount in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void getJournalsAmountData(String Taskcode, String Amount) throws InterruptedException {

		if (!AmountData_Journals.containsKey(Taskcode)) {

			AmountData_Journals.put(Taskcode, Amount);
		}

		else {

			String Value = AmountData_Journals.get(Taskcode);

			AmountData_Journals.put(Taskcode, formulas.getSum(Value, Amount));

		}

		logger.info("Amount Data Journals: " + AmountData_Journals);
	}

	@FindBy(xpath = "//*[@value='On account transaction created']//ancestor::*[contains(@id,'BillingStatus')]//following-sibling::*[contains(@id,'RetainageApplication')]//*[@title='Yes']//ancestor::*[contains(@id,'RetainageApplication')]//preceding-sibling::*[contains(@id,'ApplicationNumber')]//*[@aria-label='Application #']")
	List<WebElement> RetainageApplications;

	public void checkRetentionInvoiceGenerated() throws InterruptedException {
		ArrayList<String> RetainageReleaseApplications = new ArrayList<String>();

		for (WebElement RetainageApplication : RetainageApplications) {

			RetainageReleaseApplications.add(common.getValue(RetainageApplication));
		}

		for (String ApplicationNumber : RetainageReleaseApplications) {

			WebElement ApplicationNumberElement = ldriver
					.findElement(By.xpath("//*[@aria-label='Application #' and @value='" + ApplicationNumber + "']"));

			logger.info("Application Number: " + ApplicationNumber);

			common.clickElement(ApplicationNumberElement);

			clickGeneral();

			Thread.sleep(2000);

			clickAutoreleaseretentionamount();

			Thread.sleep(2000);

			clickYes();

			Thread.sleep(10000);

			WebElement RetentionInvoice = ldriver.findElement(By.xpath("//*[@aria-label='Application #' and @value='"
					+ ApplicationNumber
					+ "']//ancestor::*[contains(@id,'GridApplications_ApplicationNumber')]//following-sibling::*[contains(@id,'retentionInvoiceId')]//*[@aria-label='Retention invoice']"));

			RetentionInvoiceValue = common.getValue(RetentionInvoice);

			logger.info("Retention Invoice Number: " + RetentionInvoiceValue);

			if (!RetentionInvoiceValue.equals("")) {

				Assert.assertTrue(true);
				logger.info("Retention invoice number " + RetentionInvoiceValue + " generated for Application number: "
						+ ApplicationNumber);
			}

			else {
				logger.info("Retention invoice number not generated for Application number: " + ApplicationNumber);

				Assert.fail("Retention invoice number not generated for Application number: " + ApplicationNumber);

			}
		}

		Thread.sleep(10000);

	}

	public void checkRetentionReversalGenerated() throws InterruptedException {

		Thread.sleep(5000);

		WebElement SelectLineToCancelRetainage = ldriver.findElement(By.xpath(
				"//*[@value='On account transaction created']//ancestor::*[contains(@id,'BillingStatus')]//following-sibling::*[contains(@id,'retentionInvoiceId')]//*[@aria-label='Retention invoice' and @value='"
						+ RetentionInvoiceValue
						+ "']//ancestor::*[contains(@id,'retentionInvoiceId')] //preceding-sibling::*[contains(@id,'ApplicationNumber')]//*[@aria-label='Application #']"));

		String ApplicationNumber = common.getValue(SelectLineToCancelRetainage);

		common.clickElement(SelectLineToCancelRetainage);

		clickGeneral();

		clickAutocancelretainageapplication();

		Thread.sleep(10000);

		WebElement RetentionReversal = ldriver.findElement(By.xpath(
				"//*[@value='Cancelled']//ancestor::*[contains(@id,'BillingStatus')]//preceding-sibling::*[contains(@id,'ApplicationNumber')]//*[@aria-label='Application #' and @value='"
						+ ApplicationNumber
						+ "']//ancestor::*[contains(@id,'GridApplications_ApplicationNumber')]//following-sibling::*[contains(@id,'retentionCancelInvoiceId')]//*[@aria-label='Retention reversal']"));

		String RetentionReversalValue = common.getValue(RetentionReversal);

		logger.info("Retention Reversal Number: " + RetentionReversal);

		if (!RetentionReversalValue.equals("")) {

			Assert.assertTrue(true);

			logger.info("Retention Reversal number " + RetentionReversalValue + " generated for Application number: "
					+ ApplicationNumber);
		}

		else {

			logger.info("Retention Reversal number not generated for Application number: " + ApplicationNumber);

			Assert.fail("Retention Reversal number not generated for Application number: " + ApplicationNumber);

		}

	}

	public void checkInvoiceReversalGenerated() throws InterruptedException {

		clickRefresh();

		WebElement SelectLineToCancelInvoice = ldriver.findElement(By.xpath(
				"//*[@value='On account transaction created']//ancestor::*[contains(@id,'BillingStatus')]//following-sibling::*[contains(@id,'projInvoiceId')]//*[@aria-label='Invoice' and @value='"
						+ InvoiceValue
						+ "']//ancestor::*[contains(@id,'projInvoiceId')] //preceding-sibling::*[contains(@id,'ApplicationNumber')]//*[@aria-label='Application #']"));

		String ApplicationNumber = common.getValue(SelectLineToCancelInvoice);

		common.clickElement(SelectLineToCancelInvoice);

		clickGeneral();

		clickAutoCancelApplication();

		WebElement InvoiceReversal = ldriver.findElement(By.xpath(
				"//*[@value='Cancelled']//ancestor::*[contains(@id,'BillingStatus')]//preceding-sibling::*[contains(@id,'ApplicationNumber')]//*[@aria-label='Application #' and @value='"
						+ ApplicationNumber
						+ "']//ancestor::*[contains(@id,'GridApplications_ApplicationNumber')]//following-sibling::*[contains(@id,'cancelProjInvoiceId')]//*[@aria-label='Invoice reversal']"));

		String InvoiceReversalValue = common.getValue(InvoiceReversal);

		logger.info("Invoice Reversal Number: " + InvoiceReversal);

		if (!InvoiceReversalValue.equals("")) {

			Assert.assertTrue(true);

			logger.info("Invoice Reversal number " + InvoiceReversalValue + " generated for Application number: "
					+ ApplicationNumber);
		}

		else {

			logger.info("Invoice Reversal number not generated for Application number: " + ApplicationNumber);

			Assert.fail("Invoice Reversal number not generated for Application number: " + ApplicationNumber);

		}

	}

	@FindBy(xpath = "//*[text()='Auto cancel retainage application']")
	WebElement Autocancelretainageapplication;

	public void clickAutocancelretainageapplication() throws InterruptedException {

		Thread.sleep(2000);

		common.clickElementJS(Autocancelretainageapplication);

		Thread.sleep(2000);

	}

	@FindBy(xpath = "(//*[@aria-label='Invoice'])[1]")
	WebElement Invoice;

	@FindBy(xpath = "(//*[@aria-label='Invoice'])[2]")
	WebElement Invoice2;

	@FindBy(xpath = "(//*[@aria-label='Invoice'])[3]")
	WebElement Invoice3;

	public void getInvoiceNumber() throws InterruptedException {

		Thread.sleep(25000);

		try {

			InvoiceValue = common.getValue(Invoice);

			logger.info("InvoiceValue: " + InvoiceValue);

		} catch (Exception e1) {

			try {
				InvoiceValue = common.getValue(Invoice2);

				logger.info("InvoiceValue: " + InvoiceValue);

			} catch (Exception e2) {

				InvoiceValue = common.getValue(Invoice3);

				logger.info("InvoiceValue: " + InvoiceValue);

			}
		}
	}

	@FindBy(xpath = "//*[text()='Auto cancel application']")
	WebElement Autocancelapplication;

	public void clickAutoCancelApplication() throws InterruptedException {

		common.clickElementJS(Autocancelapplication);

		Thread.sleep(10000);
	}

	public void getBudgetCategoriesData() throws InterruptedException {

		Thread.sleep(10000);

		BudgetCategories_ExcludedFromRevRec = new ArrayList<String>();

		BudgetCategories_RevenueType = new ArrayList<String>();

		BudgetCategories_ExpenseType = new ArrayList<String>();

		BudgetCategory_ProjectCategories_Mapping = new HashMap<String, ArrayList<String>>();

		BudgetCategory_ECACcalctype_Mapping = new HashMap<String, String>();

		for (WebElement BudgetCategory : BudgetCategories_list) {

			common.clickElementJS(BudgetCategory);

			Thread.sleep(5000);

			String BudgetCategoryValue = common.getValue(BudgetCategory);

			String ECACcalctypeValue = common.getValue(ECACcalctype);

			if (ExcludefromRevRec.getAttribute("aria-checked").equals("true")) {

				BudgetCategories_ExcludedFromRevRec.add(BudgetCategoryValue);

			}

			if (common.getValue(Type).equals("Revenue")) {

				BudgetCategories_RevenueType.add(BudgetCategoryValue);

			}

			if (common.getValue(Type).equals("Expense")) {

				BudgetCategories_ExpenseType.add(BudgetCategoryValue);

			}

			BudgetCategory_ECACcalctype_Mapping.put(BudgetCategoryValue, ECACcalctypeValue);

			BudgetCategory_ProjectCategories_Mapping.put(BudgetCategoryValue, getProjectCategoriesList());

		}

		logger.info("BudgetCategories_ExcludedFromRevRec: " + BudgetCategories_ExcludedFromRevRec);

		logger.info("BudgetCategories_RevenueType: " + BudgetCategories_RevenueType);

		logger.info("BudgetCategories_ExpenseType: " + BudgetCategories_ExpenseType);

		logger.info("BudgetCategory_ProjectCategories_Mapping: " + BudgetCategory_ProjectCategories_Mapping);

		logger.info("BudgetCategory_ECACcalctype_Mapping: " + BudgetCategory_ECACcalctype_Mapping);

	}

	@FindBy(xpath = "//*[@name='HeaderGroup_Overview_ECACCalcType']")
	WebElement ECACcalctype;

	@FindBy(xpath = "//*[text()='ECAC table']//parent::*[contains(@id,'ECACTable')]")
	WebElement ECACTable;

	public void clickECACTable() throws InterruptedException {

		if (!common.isSectionExpanded(ECACTable)) {

			common.clickElement(ECACTable);
		}

	}

	public void clickECAC() throws InterruptedException {
		{

			common.clickElement(ECAC);
		}

	}

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } if (arg1.equals("ECAC")) { clickECAC(); } }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * common.clickElement(Postedtransactions);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[text()='New ECAC']")
	WebElement NewECAC;

	public void clickNewECAC() throws InterruptedException {

		common.clickElement(NewECAC);

	}

	@FindBy(xpath = "//*[@class='textbox field displayoption viewMarker alignmentAuto']")
	WebElement DescriptionTextBox;

	public void clickDescriptionTextBox() throws InterruptedException {

		common.clickElement(DescriptionTextBox);

		common.setTextAfterClear(DescriptionTextBox, ProjectID_Journal);// sendkeys project ID

	}

	@FindBy(xpath = "//*[text()='Period end date']//parent::*//input")
	WebElement PeriodEnddate;

	public void setPeriodEndDate() throws InterruptedException {
		{

			common.setTextAfterClear(PeriodEnddate, common.getCurrentMonthEndDate());

		}

	}

	/*
	 * public void setECACData() throws InterruptedException {
	 * 
	 * clickRefresh();
	 * 
	 * for (ArrayList<String> ECAC : UpdateECACData) {
	 * 
	 * String TaskCodeValue = ECAC.get(0);
	 * 
	 * String BudgetCategoryValue = ECAC.get(1);
	 * 
	 * String RevisedQtyValue = ECAC.get(2);
	 * 
	 * String ECACNetChangeValue = ECAC.get(3);
	 * 
	 * WebElement RevisedQty =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='" +
	 * TaskCodeValue +
	 * "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
	 * + BudgetCategoryValue +
	 * "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedQty')]//*[@aria-label='Revised qty']"
	 * ));
	 * 
	 * String RevisedQtyExistingValue = common.getValue(RevisedQty);
	 * 
	 * if (!RevisedQtyValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(RevisedQty, RevisedQtyValue);
	 * 
	 * }
	 * 
	 * WebElement RevisedRate =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='" +
	 * TaskCodeValue +
	 * "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
	 * + BudgetCategoryValue +
	 * "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedUnitPrice')]//*[@aria-label='Revised rate']"
	 * ));
	 * 
	 * String RevisedRateValue = common.getValue(RevisedRate);
	 * 
	 * WebElement ECACNetChange =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='" +
	 * TaskCodeValue +
	 * "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
	 * + BudgetCategoryValue +
	 * "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'NetChange')]//*[@aria-label='ECAC net change']"
	 * ));
	 * 
	 * if (ECACNetChangeValue.equals("")) {
	 * 
	 * ECACNetChangeValue = common.getValue(ECACNetChange);
	 * 
	 * checkECACNetChange(RevisedQtyExistingValue, RevisedQtyValue,
	 * RevisedRateValue, ECACNetChangeValue, TaskCodeValue, BudgetCategoryValue);
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * common.doubleClickElement(ECACNetChange);
	 * 
	 * common.setTextAfterDelete(ECACNetChange, ECACNetChangeValue);
	 * 
	 * }
	 * 
	 * WebElement ECACRevisedAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='" +
	 * TaskCodeValue +
	 * "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
	 * + BudgetCategoryValue +
	 * "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedAmount')]//*[@aria-label='ECAC revised amount']"
	 * ));
	 * 
	 * String ECACRevisedAmountValue = common.getValue(ECACRevisedAmount);
	 * 
	 * WebElement ECACAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='" +
	 * TaskCodeValue +
	 * "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
	 * + BudgetCategoryValue +
	 * "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'PriorECACAmount')]//*[@aria-label='ECAC amount']"
	 * ));
	 * 
	 * String ECACAmountValue = common.getValue(ECACAmount);
	 * 
	 * checkECACRevisedAmount(ECACAmountValue, ECACNetChangeValue,
	 * ECACRevisedAmountValue, TaskCodeValue, BudgetCategoryValue); }
	 * 
	 * }
	 */

	/*
	 * public void checkECACNetChange(String RevisedQtyExistingValue, String
	 * RevisedQtyValue, String RevisedRateValue, String ECACNetChangeValue, String
	 * TaskCodeValue, String BudgetCategoryValue) throws InterruptedException {
	 * 
	 * String ECACNetChangeValueExpected = formulas.getProduct(
	 * formulas.getSubtractionOfTwoValues(RevisedQtyValue, RevisedQtyExistingValue),
	 * RevisedRateValue);
	 * 
	 * logger.info("Expected ECACNetChange value:" + ECACNetChangeValueExpected);
	 * 
	 * logger.info("Actual ECACNetChange value: " + ECACNetChangeValue);
	 * 
	 * Assert.assertEquals(ECACNetChangeValue, ECACNetChangeValueExpected,
	 * "ECAC Net Change Value is not as Expected for TaskCode:" + TaskCodeValue +
	 * "& Budget Category " + BudgetCategoryValue); }
	 */

	public void checkECACRevisedAmount(String ECACAmountValue, String ECACNetChangeValue, String ECACRevisedAmountValue,
			String TaskCodeValue, String BudgetCategoryValue) throws InterruptedException {

		String ECACRevisedAmountExpected = formulas.getSum(ECACAmountValue, ECACNetChangeValue);

		logger.info("Expected ECAC Revised Amount value:" + ECACRevisedAmountExpected);

		logger.info("Actual ECAC Revised Amount value: " + ECACRevisedAmountValue);

		Assert.assertEquals(ECACRevisedAmountValue, ECACRevisedAmountExpected,
				"ECAC Revised Amount Value is not as Expected for Taskcode:" + TaskCodeValue + "& BudgetCategory"
						+ BudgetCategoryValue);
	}

	@FindBy(xpath = "(//*[contains(@id,'TaskCode') and @aria-label='Task code'])")
	List<WebElement> NumberOfECAClines;

	public int getNumberOfECAClines() {

		return NumberOfECAClines.size();

	}

	public void checkECACTableData() throws InterruptedException {

		// ArrayList<String> Data = new ArrayList<String>();

		for (int i = 1; i <= getNumberOfECAClines(); i++) {

			WebElement TaskCode = ldriver
					.findElement(By.xpath("(//*[contains(@id,'TaskCode') and @aria-label='Task code'])[" + i + "]"));

			String TaskcodeValue = common.getValue(TaskCode);

			WebElement BudgetCategory = ldriver.findElement(
					By.xpath("(//*[contains(@id,'BudgetCategoryId') and @aria-label='Budget category'])[" + i + "]"));

			String BudgetCategoryValue = common.getValue(BudgetCategory);

			WebElement ActualAmount = ldriver.findElement(
					By.xpath("(//*[contains(@id,'ActualAmount') and @aria-label='Actual amount'])[" + i + "]"));

			String ActualAmountValue = common.getValue(ActualAmount);

			WebElement CommittedCost = ldriver.findElement(
					By.xpath("(//*[contains(@id,'CommittedCost') and @aria-label='Committed cost'])[" + i + "]"));

			String CommittedCostValue = common.getValue(CommittedCost);

			WebElement ECACAmount = ldriver.findElement(
					By.xpath("(//*[contains(@id,'ECACAmount') and @aria-label='ECAC amount'])[" + i + "]"));

			String ECACAmountValue = common.getValue(ECACAmount);

			WebElement ETC = ldriver
					.findElement(By.xpath("(//*[contains(@id,'ETCAmount') and @aria-label='ETC'])[" + i + "]"));

			String ETCValue = common.getValue(ETC);

			WebElement CTCAmount = ldriver
					.findElement(By.xpath("(//*[contains(@id,'CTCAmount') and @aria-label='CTC amount'])[" + i + "]"));

			String CTCAmountValue = common.getValue(CTCAmount);

			checkETCandCTCAmount(ECACAmountValue, ActualAmountValue, CommittedCostValue, ETCValue, CTCAmountValue,
					TaskcodeValue, BudgetCategoryValue);

			checkECACAmount(ECACAmountValue, TaskcodeValue, BudgetCategoryValue);

			checkActualAmount(ActualAmountValue, TaskcodeValue, BudgetCategoryValue);

			checkCommittedCost(CommittedCostValue, TaskcodeValue, BudgetCategoryValue);

			common.scrollIntoView(TaskCode);

			common.clickElement(TaskCode);

			common.KeyboardAction("Down");

		}

		// clickCloseJournal();
	}

	/*
	 * public void checkCommittedCost(String CommittedCostValue, String
	 * TaskcodeValue, String BudgetCategoryValue) {
	 * 
	 * List<String> ProjectCategories =
	 * BudgetCategory_ProjectCategories_Mapping.get(BudgetCategoryValue);
	 * 
	 * String Expected_CommittedCostValue = "0.00";
	 * 
	 * for (String ProjectCategory : ProjectCategories) {
	 * 
	 * String Amount = SubContract_NetAmount.get(TaskcodeValue + ":" +
	 * ProjectCategory);
	 * 
	 * if (!Amount.equals(null)) {
	 * 
	 * Expected_CommittedCostValue = Expected_CommittedCostValue + Amount;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * logger.info("Expected Committed Cost :" + Expected_CommittedCostValue);
	 * 
	 * logger.info("Actual Committed Cost :" + CommittedCostValue);
	 * 
	 * Assert.assertEquals(CommittedCostValue, Expected_CommittedCostValue,
	 * "Committed cost not As Expected For Task code" + TaskcodeValue +
	 * "& Budget Category" + BudgetCategoryValue);
	 * 
	 * }
	 * 
	 * public void checkActualAmount(String ActualAmountValue, String TaskcodeValue,
	 * String BudgetCategoryValue) {
	 * 
	 * List<String> ProjectCategories =
	 * BudgetCategory_ProjectCategories_Mapping.get(BudgetCategoryValue);
	 * 
	 * String Expected_ActualAmount = "0.00";
	 * 
	 * for (String ProjectCategory : ProjectCategories) {
	 * 
	 * String Amount = Journals_ActualAmount.get(TaskcodeValue + ":" +
	 * ProjectCategory);
	 * 
	 * if (!Amount.equals(null)) {
	 * 
	 * Expected_ActualAmount = Expected_ActualAmount + Amount;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * logger.info("Expected Actual Amount :" + Expected_ActualAmount);
	 * 
	 * logger.info("Actual Amount :" + ActualAmountValue);
	 * 
	 * Assert.assertEquals(ActualAmountValue, Expected_ActualAmount,
	 * "Actual Amount Value not As Expected For Task code" + TaskcodeValue +
	 * "& Budget Category" + BudgetCategoryValue);
	 * 
	 * }
	 */

	/*
	 * public void checkETCandCTCAmount(String ECACAmountValue, String
	 * ActualAmountValue, String CommittedCostValue, String ETCValue, String
	 * CTCAmountValue, String TaskCodeValue, String BudgetCategoryValue) throws
	 * InterruptedException {
	 * 
	 * String CTCAmountExpected =
	 * formulas.getSubtractionOfTwoValues(ECACAmountValue, ActualAmountValue);
	 * 
	 * String ETCExpected = formulas.getSubtractionOfTwoValues(CTCAmountExpected,
	 * CommittedCostValue);
	 * 
	 * logger.info("Expected ETC value:" + ETCExpected);
	 * 
	 * logger.info("Actual ETC value: " + ETCValue);
	 * 
	 * Assert.assertEquals(ETCValue, ETCExpected,
	 * "ETC Value is not As Expected For Task code" + TaskCodeValue +
	 * "& Budget Category" + BudgetCategoryValue);
	 * 
	 * logger.info("Expected CTC Amount value:" + CTCAmountExpected);
	 * 
	 * logger.info("Actual CTC Amount value: " + CTCAmountValue);
	 * 
	 * Assert.assertEquals(CTCAmountValue, CTCAmountExpected,
	 * "CTC Amount Value not As Expected For Task code" + TaskCodeValue +
	 * "& Budget Category" + BudgetCategoryValue);
	 * 
	 * }
	 */

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	WebElement Submit;

	/*
	 * @FindBy(xpath = "(//span[normalize-space()='Submit'])[2]") WebElement
	 * Submit1;
	 * 
	 * public void clickSubmit() throws InterruptedException { try {
	 * common.clickElement(Submit); }
	 * 
	 * catch (Exception e) { common.clickElement(Submit1); } }
	 */

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement Approve;

	/*
	 * @FindBy(xpath = "(//span[normalize-space()='Approve'])[2]") WebElement
	 * Approve1;
	 * 
	 * public void clickApprove() throws InterruptedException {
	 * 
	 * try { common.clickElement(Approve); }
	 * 
	 * catch (Exception e) { common.clickElement(Approve1); } }
	 */

	@FindBy(xpath = "//span[normalize-space()='Commit']")
	WebElement Commit;

	/*
	 * @FindBy(xpath = "(//span[normalize-space()='Commit'])[2]") WebElement
	 * Commit1;
	 * 
	 * public void clickCommit() throws InterruptedException {
	 * 
	 * try { common.clickElement(Commit); }
	 * 
	 * catch (Exception e) { common.clickElement(Commit1); }
	 * 
	 * }
	 */

	@FindBy(xpath = "//input[contains(@id,'BudgetStatus')]")
	WebElement Budgetstatus;

	@FindBy(xpath = "//input[contains(@id,'Status_input')]")
	WebElement Budgetstatus1;

	public String getBudgetStatus() throws InterruptedException {

		Thread.sleep(3000);

		String BudgetStatus = "";

		try {

			BudgetStatus = common.getValue(Budgetstatus);
		} catch (Exception e) {

			BudgetStatus = common.getValue(Budgetstatus1);
		}
		return BudgetStatus;

	}

	public void setBudgetLines() throws InterruptedException {

		BudgetLines_LineAmount = new HashMap<String, String>();

		int row = 1;

		for (ArrayList<String> BudgetLine : BudgetLines) {

			common.clickElement(New_Budgetlines);

			String TaskcodeValue = BudgetLine.get(0);

			String DescriptionValue = BudgetLine.get(1);

			String BudgetcategoryValue = BudgetLine.get(2);

			String QuantityValue = BudgetLine.get(3);

			String UnitValue = BudgetLine.get(4);

			String UnitPriceValue = BudgetLine.get(5);

			// String LineAmountValue = BudgetLine.get(6);

			Thread.sleep(3000);

			WebElement Taskcode = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			common.setText(Taskcode, TaskcodeValue);

			if (!DescriptionValue.equals("")) {

				WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

				common.setText(Description, DescriptionValue);

			}

			WebElement Budgetcategory = ldriver
					.findElement(By.xpath("(//*[@aria-label='Budget category'])[" + row + "]"));

			common.setText(Budgetcategory, BudgetcategoryValue);

			if (!QuantityValue.equals("")) {

				WebElement Quantity = ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));

				common.setTextAfterDelete(Quantity, QuantityValue);

			}

			if (!UnitValue.equals("")) {

				WebElement Unit = ldriver.findElement(By.xpath("(//*[@aria-label='Unit'])[" + row + "]"));

				common.setTextAfterDelete(Unit, UnitValue);

			}

			if (!UnitPriceValue.equals("")) {

				WebElement UnitPrice = ldriver.findElement(By.xpath("(//*[@aria-label='Unit price'])[" + row + "]"));

				common.setTextAfterDelete(UnitPrice, UnitPriceValue);

			}

			WebElement Lineamount = ldriver.findElement(By.xpath("(//*[@aria-label='Line amount'])[" + row + "]"));

			String LineAmountValue = common.getValue(Lineamount);

			BudgetLines_LineAmount.put(TaskcodeValue + ":" + BudgetcategoryValue, LineAmountValue);

			checkLineAmount(QuantityValue, UnitPriceValue, LineAmountValue, row);

			common.KeyboardAction("Tab");

			row++;

		}

		logger.info("BudgetLines_LineAmount with Task Code and Budget Category is" + BudgetLines_LineAmount);
	}

	/*
	 * public void checkECACAmount(String ECACAmountValue, String TaskCodeValue,
	 * String BudgetCategoryValue) throws InterruptedException {
	 * 
	 * String ECACAmountValueExpected = BudgetLines_LineAmount.get(TaskCodeValue +
	 * ":" + BudgetCategoryValue);
	 * 
	 * logger.info("Expected ECACAmount Values is: " + ECACAmountValueExpected);
	 * 
	 * logger.info("Actual ECACAmount Values is: " + ECACAmountValue);
	 * 
	 * Assert.assertEquals(ECACAmountValue, ECACAmountValueExpected,
	 * "ECAC Amount Value is not as Expected for Taskcode " + TaskCodeValue +
	 * " & Budget Category " + BudgetCategoryValue);
	 * 
	 * }
	 */

	/*
	 * public void setHourJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * AmountData_Journals = new HashMap<String, String>();
	 * 
	 * Journals_ActualAmount = new HashMap<String, String>();
	 * 
	 * for (ArrayList<String> HourJournal : HourJournals) {
	 * 
	 * clickNew();
	 * 
	 * String TaskcodeValue = HourJournal.get(0);
	 * 
	 * String ProjectCategoryValue = HourJournal.get(1);
	 * 
	 * String ResourseIdValue = HourJournal.get(2);
	 * 
	 * String HoursValue = HourJournal.get(3);
	 * 
	 * String CostPriceValue = HourJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = HourJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(HoursValue, CostPriceValue);
	 * 
	 * getJournalsAmountData(TaskcodeValue, TotalCostPrice);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * // Amount_OverheadTransactions_Total_ExcludeFromRevRec = //
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec(ProjectCategoryValue,
	 * // TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement Projectdate = ldriver
	 * .findElement(By.xpath("//*[contains(@class,'date-picker-button')][" + row +
	 * "]"));
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * WebElement Taskcode_Journal = ldriver.findElement(By
	 * .xpath("(//*[text()='Task code']//following::*[contains(@id,'SISTaskCode')])[3]["
	 * + row + "]"));
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ProjectCategoryValue.equals("")) {
	 * 
	 * WebElement Category_Journal = ldriver.findElement(
	 * By.xpath("(//*[text()='Category']//following::*[@aria-label='Category'])[" +
	 * row + "]"));
	 * 
	 * common.setTextAfterDelete(Category_Journal, ProjectCategoryValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * WebElement Resourceid_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Resource']//following::*[contains(@id,'Resource')])[5][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Resourceid_Journal, ResourseIdValue);
	 * 
	 * selectResource_HourJournal(ResourseIdValue);
	 * 
	 * // clickSelect();
	 * 
	 * }
	 * 
	 * if (!HoursValue.equals("")) {
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) ldriver;
	 * 
	 * js.executeScript("arguments[0].scrollIntoView(true);", Hours_Journal);
	 * 
	 * WebElement Hours_Journal = ldriver.findElement( By.xpath(
	 * "(//*[text()='Hours']//following::*[contains(@id,'ctrlProjQty')])[4][" + row
	 * + "]"));
	 * 
	 * common.setTextAfterDelete(Hours_Journal, HoursValue);
	 * 
	 * }
	 * 
	 * clickGeneralTab();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * WebElement Costprice_Journal = ldriver.findElement( By.
	 * xpath("//*[text()='Cost price']//following::*[@name='CostPrice_CostPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterDelete(Costprice_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * WebElement Salesprice_Journal = ldriver.findElement(By
	 * .xpath("//*[text()='Sales price']//following::*[@name='SalesPrice_SalesPrice']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterClear(Salesprice_Journal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(ProjectCategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, ProjectCategoryValue,
	 * TotalCostPrice, HoursValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose();
	 * 
	 * clickRefresh();
	 * 
	 * int Line = Integer.parseInt(LineNumberValue) + 1;
	 * 
	 * LineNumberValue = Integer.toString(Line);
	 * 
	 * // row++; setJournalsActualAmount(TaskcodeValue, ProjectCategoryValue,
	 * TotalCostPrice); } }
	 */

	public void setJournalsActualAmount(String TaskcodeValue, String ProjectCategoryValue, String Amount)
			throws InterruptedException {

		if (Journals_ActualAmount.get(TaskcodeValue + ":" + ProjectCategoryValue) == null) {

			Journals_ActualAmount.put(TaskcodeValue + ":" + ProjectCategoryValue, Amount);
		}

		else {

			String ExistingActualAmount = Journals_ActualAmount.get(TaskcodeValue + ":" + ProjectCategoryValue);

			Journals_ActualAmount.put(TaskcodeValue + ":" + ProjectCategoryValue,
					formulas.getSum(ExistingActualAmount, Amount));
		}

		logger.info("Journals Actual Amount :" + Journals_ActualAmount);

	}

	/*
	 * public void setItemJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * for (ArrayList<String> ItemJournal : ItemJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNew();
	 * 
	 * }
	 * 
	 * String ItemNumberValue = ItemJournal.get(0);
	 * 
	 * String QuantityValue = ItemJournal.get(1);
	 * 
	 * String CostPriceValue = ItemJournal.get(2);
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue); }
	 * 
	 * String TaskcodeValue = ItemJournal.get(3);
	 * 
	 * String ChargeTypeValue = ItemJournal.get(4);
	 * 
	 * String CategoryValue = ItemJournal.get(5);
	 * 
	 * String SalesPriceValue = ItemJournal.get(6);
	 * 
	 * String SiteValue = ItemJournal.get(7);
	 * 
	 * String WarehouseValue = ItemJournal.get(8);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!ItemNumberValue.equals("")) {
	 * 
	 * common.setText(ItemNumber_Journal, ItemNumberValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * common.KeyboardAction("Enter");
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * clickProjectSubtab();
	 * 
	 * if (!ChargeTypeValue.equals("")) {
	 * 
	 * common.setTextAfterClear(ChargeType_Journal, ChargeTypeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Category_ItemJournal, CategoryValue);
	 * 
	 * }
	 * 
	 * else if (CategoryValue.equals("")) {
	 * 
	 * CategoryValue = checkCategoryValue(ItemNumberValue); }
	 * 
	 * if (SalesPriceValue.equals("")) {
	 * 
	 * SalesPriceValue = checkSalesPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * else if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ItemJournal, SalesPriceValue); }
	 * 
	 * clickOverview_Journal();
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(CostPriceValue_Journal, CostPriceValue);
	 * 
	 * }
	 * 
	 * else if (CostPriceValue.equals("")) {
	 * 
	 * CostPriceValue = checkCostPriceValue(ItemNumberValue);
	 * 
	 * }
	 * 
	 * String CostAmountValue = common.getValue(Costamount);
	 * 
	 * String CostAmount = checkLineAmount(QuantityValue, CostPriceValue,
	 * CostAmountValue, row);
	 * 
	 * getJournalsAmountData(TaskcodeValue, CostAmount);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( CategoryValue,
	 * CostAmount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * clickProductDimensionsSubtab();
	 * 
	 * if (!SiteValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Site_ItemJournal, SiteValue);
	 * 
	 * }
	 * 
	 * else if (SiteValue.equals("")) {
	 * 
	 * SiteValue = checkSiteValue(ItemNumberValue); }
	 * 
	 * if (!WarehouseValue.equals("")) {
	 * 
	 * common.setTextAfterClear(Warehouse_ItemJournal, WarehouseValue);
	 * 
	 * }
	 * 
	 * else if (WarehouseValue.equals("")) {
	 * 
	 * WarehouseValue = checkWarehouseValue(ItemNumberValue); }
	 * 
	 * // clickOverview_Journal();
	 * 
	 * common.KeyboardAction("Tab");
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData_ItemJournal(TaskcodeValue, CategoryValue,
	 * ItemNumberValue, CostAmountValue, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose();
	 * 
	 * clickOverview_Journal();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * if (row == 1) {
	 * 
	 * ItemJournals = new ArrayList<ArrayList<String>>();
	 * 
	 * }
	 * 
	 * updateItemJournalData(ItemNumberValue, QuantityValue, CostPriceValue,
	 * TaskcodeValue, ChargeTypeValue, CategoryValue, SalesPriceValue, SiteValue,
	 * WarehouseValue);
	 * 
	 * row++;
	 * 
	 * setJournalsActualAmount(TaskcodeValue, CategoryValue, CostAmount);
	 * 
	 * } }
	 */

	/*
	 * public void setExpenseJournalAndOverheadTransactionsValidation() throws
	 * InterruptedException {
	 * 
	 * int row = 1;
	 * 
	 * String LineNumberValue = "1";
	 * 
	 * String ProjectdateValue = getCurrentDate();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * for (ArrayList<String> ExpenseJournal : ExpenseJournals) {
	 * 
	 * if (row != 1) {
	 * 
	 * clickNew();
	 * 
	 * }
	 * 
	 * String TaskcodeValue = ExpenseJournal.get(0);
	 * 
	 * String CategoryValue = ExpenseJournal.get(1);
	 * 
	 * String ResourseIdValue = ExpenseJournal.get(2);
	 * 
	 * String QuantityValue = ExpenseJournal.get(3);
	 * 
	 * String CostPriceValue = ExpenseJournal.get(4);
	 * 
	 * CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);
	 * 
	 * String SalesPriceValue = ExpenseJournal.get(5);
	 * 
	 * String TotalCostPrice = formulas.getProduct(QuantityValue, CostPriceValue);
	 * 
	 * getJournalsAmountData(TaskcodeValue, TotalCostPrice);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec(CategoryValue,
	 * TotalCostPrice);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * common.setTextAfterDelete(Projectdate, ProjectdateValue);
	 * 
	 * if (!TaskcodeValue.equals("")) {
	 * 
	 * common.setText(Taskcode_Journal, TaskcodeValue);
	 * 
	 * }
	 * 
	 * if (!CategoryValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Category_Journal, CategoryValue);
	 * 
	 * }
	 * 
	 * if (!ResourseIdValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(ExpenseResourceid_Journal, ResourseIdValue);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * selectResource_ExpenseJournal(ResourseIdValue);
	 * 
	 * }
	 * 
	 * if (!QuantityValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Quantity_Journal, QuantityValue);
	 * 
	 * }
	 * 
	 * if (!CostPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Costprice_ExpenseJournal, CostPriceValue);
	 * 
	 * }
	 * 
	 * if (!SalesPriceValue.equals("")) {
	 * 
	 * common.setTextAfterDelete(Salesprice_ExpenseJournal, SalesPriceValue);
	 * 
	 * }
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickCalculate_Expense();
	 * 
	 * checkOverheadAllocationCalculated();
	 * 
	 * clickcloseMessageBar();
	 * 
	 * logger.info("LineNumberValue:" + LineNumberValue);
	 * 
	 * // clickLineNumber(LineNumberValue);
	 * 
	 * clickOverheadAllocation();
	 * 
	 * clickOverheadTransactions();
	 * 
	 * boolean posted = checkOverheadTransactionsPosted(CategoryValue);
	 * 
	 * if (posted == true) {
	 * 
	 * checkOverheadTransactionsPostedData(TaskcodeValue, CategoryValue,
	 * TotalCostPrice, QuantityValue, CostPriceValue);
	 * 
	 * }
	 * 
	 * clickClose();
	 * 
	 * clickRefresh();
	 * 
	 * // int Line = Integer.parseInt(LineNumberValue);
	 * 
	 * // LineNumberValue = Integer.toString(Line);
	 * 
	 * row++;
	 * 
	 * setJournalsActualAmount(TaskcodeValue, CategoryValue, TotalCostPrice);
	 * 
	 * } }
	 */

	public void checkOverheadTransactionsPostedData(String TaskCode, String ProjectCategory, String TotalCostPrice,
			String HoursOrQuantity, String CostPrice) throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
				"Task code is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getPriority_OverheadTransactions(), getPriorityBasedOnProjectCategory(ProjectCategory),
				"Priority is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
				"Source Category is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getCategoryID_OverheadTransactions(),
				getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
				"CategoryID is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
				"RuleID is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getRate_OverheadTransactions(ProjectCategory), getRateBasedOnProjectCategory(ProjectCategory),
				"Rate Value is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
				"Total Cost Price is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getAmount_OverheadTransactions(),
				getAmountFromRateValueAndHours(HoursOrQuantity, ProjectCategory),
				"Amount is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
				"Cost price is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertAll();

		Amount_OverheadTransactions_Total_Posted = formulas.getSum(Amount_OverheadTransactions_Total_Posted,
				getAmount_OverheadTransactions());

		logger.info("Amount_OverheadTransactions_Total_Posted: " + Amount_OverheadTransactions_Total_Posted);

		Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
				ProjectCategory, getAmount_OverheadTransactions());

		logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: "
				+ Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec);

		getJournalsAmountData(TaskCode, getAmount_OverheadTransactions());

		setJournalsActualAmount(TaskCode, getCategoryID_OverheadTransactions(), getAmount_OverheadTransactions());

	}

	public void checkOverheadTransactionsPostedData_ItemJournal(String TaskCode, String ProjectCategory,
			String ItemNumber, String TotalCostPrice, String Hours, String CostPrice) throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(getTaskcode_OverheadTransactions(), TaskCode,
				"Task code is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getPriority_OverheadTransactions(), getPriorityBasedOnProjectCategory(ProjectCategory),
				"Priority is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getSourceCategory_OverheadTransactions(), ProjectCategory,
				"Source Category is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getCategoryID_OverheadTransactions(),
				getDestinationCategoryBasedOnSourceCategory(ProjectCategory),
				"CategoryID is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getRuleID_OverheadTransactions(), RuleId,
				"RuleID is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getRate_OverheadTransactions(ProjectCategory), getRateBasedOnProjectCategory(ProjectCategory),
				"Rate Value is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getItemnumber_OverheadTransactions(), ItemNumber,
				"Item number is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getTotalcostprice_OverheadTransactions(), TotalCostPrice,
				"Total Cost Price is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getAmount_OverheadTransactions(), getAmountFromRateAndTotalCostPrice(ProjectCategory),
				"Amount is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertEquals(getCostprice_OverheadTransactions(), CostPrice,
				"Cost price is not as expected in overhead transactions for Project Category: " + ProjectCategory
						+ " and Taskcode: " + TaskCode);

		sa.assertAll();

		Amount_OverheadTransactions_Total_Posted = formulas.getSum(Amount_OverheadTransactions_Total_Posted,
				getAmount_OverheadTransactions());

		logger.info("Amount_OverheadTransactions_Total_Posted: " + Amount_OverheadTransactions_Total_Posted);

		Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_Posted_ExcludeFromRevRec(
				ProjectCategory, getAmount_OverheadTransactions());

		logger.info("Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec: "
				+ Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec);

		getJournalsAmountData(TaskCode, getAmount_OverheadTransactions());

		setJournalsActualAmount(TaskCode, getCategoryID_OverheadTransactions(), getAmount_OverheadTransactions());

	}

	public void setSubContract() throws InterruptedException {

		int row = 1;

		SubContract_NetAmount = new HashMap<String, String>();

		for (ArrayList<String> SubContract : SubContracts) {

			String TaskCodeValue = SubContract.get(0);

			String ProjectCategoryValue = SubContract.get(1);

			String ProcurementCategoryValue = SubContract.get(2);

			String QuantityValue = SubContract.get(3);

			String UnitPriceValue = SubContract.get(4);

			clickNewSubConractLine();

			Thread.sleep(3000);

			WebElement Category = ldriver.findElement(By.xpath("//*[@aria-label='Category'][" + row + "]"));

			common.setTextAfterDelete(Category, ProjectCategoryValue);

			WebElement TaskCode = ldriver.findElement(By.xpath("//*[@aria-label='Task code'][" + row + "]"));

			common.setTextAfterDelete(TaskCode, TaskCodeValue);

			WebElement ProcurementCategory = ldriver.findElement(By.xpath(
					"//*[contains(@id,'ProcurementCategory') and @aria-label='Procurement category'][" + row + "]"));

			common.setTextAfterDelete(ProcurementCategory, ProcurementCategoryValue);

			WebElement Quantity = ldriver.findElement(By.xpath("//*[@aria-label='Quantity'][" + row + "]"));

			common.setTextAfterDelete(Quantity, QuantityValue);

			WebElement UnitPrice = ldriver.findElement(By.xpath("//*[@aria-label='Unit price'][" + row + "]"));

			common.setTextAfterDelete(UnitPrice, UnitPriceValue);

			WebElement NetAmount = ldriver.findElement(By.xpath("//*[@aria-label='Net amount'][" + row + "]"));

			String NetAmountValue = common.getValue(NetAmount);

			checkLineAmount(QuantityValue, UnitPriceValue, NetAmountValue, row);

			common.setTextAfterDelete(Category, ProjectCategoryValue);

			// row++;

			setSubcontractNetAmount(TaskCodeValue, ProjectCategoryValue, NetAmountValue);

		}

		logger.info("SubContract NetAmount: " + SubContract_NetAmount);

		clickSave();

	}

	public void setSubcontractNetAmount(String TaskcodeValue, String ProjectCategoryValue, String Amount)
			throws InterruptedException {

		if (SubContract_NetAmount.get(TaskcodeValue + ":" + ProjectCategoryValue) == null) {

			SubContract_NetAmount.put(TaskcodeValue + ":" + ProjectCategoryValue, Amount);
		} else {
			String ExistingSubcontractNetAmount = SubContract_NetAmount.get(TaskcodeValue + ":" + ProjectCategoryValue);

			SubContract_NetAmount.put(TaskcodeValue + ":" + ProjectCategoryValue,
					formulas.getSum(ExistingSubcontractNetAmount, Amount));
		}
	}

	// -------------Change by Monica 07-03-2023----------------

	/*
	 * public void getConstructionContractOverviewDataAfterRetainageChange() throws
	 * InterruptedException {
	 * 
	 * ConstructionContract_RetainagePercentage_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_RetainageAmount_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_PrevRetainage_AfterRetainageChange = new HashMap<String,
	 * String>(); ConstructionContract_TotalRetainage_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_PrevWorkInPlace_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_PrevPercentage_AfterRetainageChange = new
	 * HashMap<String, String>(); ConstructionContract_Cost_AfterRetainageChange =
	 * new HashMap<String, String>();
	 * ConstructionContract_PercentComplete_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_WorkInPlace_AfterRetainageChange = new HashMap<String,
	 * String>(); ConstructionContract_InvoiceAmount_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * ConstructionContract_AmountRemaining_AfterRetainageChange = new
	 * HashMap<String, String>();
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description = ldriver.findElement( By.
	 * xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" +
	 * row + "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));
	 * 
	 * String RetainagePercentageValue = common.getValue(RetainagePercentage);
	 * 
	 * ConstructionContract_RetainagePercentage_AfterRetainageChange.put(
	 * DescriptionValue, RetainagePercentageValue);
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));
	 * 
	 * String PercentCompleteValue = common.getValue(PercentComplete);
	 * 
	 * ConstructionContract_PercentComplete_AfterRetainageChange.put(
	 * DescriptionValue, PercentCompleteValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row +
	 * "]"));
	 * 
	 * String WorkInPlaceValue = common.getValue(WorkInPlace);
	 * 
	 * ConstructionContract_WorkInPlace_AfterRetainageChange.put(DescriptionValue,
	 * WorkInPlaceValue);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));
	 * 
	 * String RetainageAmountValue = common.getValue(RetainageAmount);
	 * 
	 * ConstructionContract_RetainageAmount_AfterRetainageChange.put(
	 * DescriptionValue, RetainageAmountValue);
	 * 
	 * WebElement PrevRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * ConstructionContract_PrevRetainage_AfterRetainageChange.put(DescriptionValue,
	 * PrevRetainagevalue);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * ConstructionContract_TotalRetainage_AfterRetainageChange.put(
	 * DescriptionValue, TotalRetainagevalue);
	 * 
	 * WebElement PrevWorkInPlace = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row +
	 * "]"));
	 * 
	 * String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);
	 * 
	 * ConstructionContract_PrevWorkInPlace_AfterRetainageChange.put(
	 * DescriptionValue, PrevWorkInPlaceValue);
	 * 
	 * WebElement PrevPercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));
	 * 
	 * String PrevPercentageValue = common.getValue(PrevPercentage);
	 * 
	 * ConstructionContract_PrevPercentage_AfterRetainageChange.put(
	 * DescriptionValue, PrevPercentageValue);
	 * 
	 * WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])["
	 * + row + "]"));
	 * 
	 * String CostsValue = common.getValue(Costs);
	 * 
	 * ConstructionContract_Cost_AfterRetainageChange.put(DescriptionValue,
	 * CostsValue);
	 * 
	 * WebElement InvoiceAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));
	 * 
	 * String InvoiceAmountValue = common.getValue(InvoiceAmount);
	 * 
	 * ConstructionContract_InvoiceAmount_AfterRetainageChange.put(DescriptionValue,
	 * InvoiceAmountValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * ConstructionContract_AmountRemaining_AfterRetainageChange.put(
	 * DescriptionValue, AmountRemainingValue); }
	 * 
	 * logger.info("ConstructionContract_RetainagePercentage_AfterRetainageChange: "
	 * + ConstructionContract_RetainagePercentage_AfterRetainageChange);
	 * logger.info("ConstructionContract_RetainageAmount_AfterRetainageChange: " +
	 * ConstructionContract_RetainageAmount_AfterRetainageChange);
	 * logger.info("ConstructionContract_PrevRetainage_AfterRetainageChange: " +
	 * ConstructionContract_PrevRetainage_AfterRetainageChange);
	 * logger.info("ConstructionContract_TotalRetainage_AfterRetainageChange: " +
	 * ConstructionContract_TotalRetainage_AfterRetainageChange);
	 * logger.info("ConstructionContract_PrevWorkInPlace_AfterRetainageChange: " +
	 * ConstructionContract_PrevWorkInPlace_AfterRetainageChange);
	 * logger.info("ConstructionContract_PrevPercentage_AfterRetainageChange: " +
	 * ConstructionContract_PrevPercentage_AfterRetainageChange); logger.info(
	 * "ConstructionContract_Cost_AfterRetainageChange: " +
	 * ConstructionContract_Cost_AfterRetainageChange);
	 * logger.info("ConstructionContract_PercentComplete_AfterRetainageChange: " +
	 * ConstructionContract_PercentComplete_AfterRetainageChange);
	 * logger.info("ConstructionContract_WorkInPlace_AfterRetainageChange: " +
	 * ConstructionContract_WorkInPlace_AfterRetainageChange);
	 * logger.info("ConstructionContract_InvoiceAmount_AfterRetainageChange: " +
	 * ConstructionContract_InvoiceAmount_AfterRetainageChange);
	 * logger.info("ConstructionContract_AmountRemaining_AfterRetainageChange: " +
	 * ConstructionContract_AmountRemaining_AfterRetainageChange); }
	 * 
	 * public void getConstructionContractOverviewData() throws InterruptedException
	 * {
	 * 
	 * ConstructionContract_RetainagePercentage = new HashMap<String, String>();
	 * ConstructionContract_RetainageAmount = new HashMap<String, String>();
	 * ConstructionContract_PrevRetainage = new HashMap<String, String>();
	 * ConstructionContract_TotalRetainage = new HashMap<String, String>();
	 * ConstructionContract_PrevWorkInPlace = new HashMap<String, String>();
	 * ConstructionContract_PrevPercentage = new HashMap<String, String>();
	 * ConstructionContract_Cost = new HashMap<String, String>();
	 * ConstructionContract_PercentComplete = new HashMap<String, String>();
	 * ConstructionContract_WorkInPlace = new HashMap<String, String>();
	 * ConstructionContract_InvoiceAmount = new HashMap<String, String>();
	 * ConstructionContract_AmountRemaining = new HashMap<String, String>();
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description = ldriver.findElement( By.
	 * xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" +
	 * row + "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));
	 * 
	 * String RetainagePercentageValue = common.getValue(RetainagePercentage);
	 * 
	 * ConstructionContract_RetainagePercentage.put(DescriptionValue,
	 * RetainagePercentageValue);
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));
	 * 
	 * String PercentCompleteValue = common.getValue(PercentComplete);
	 * 
	 * ConstructionContract_PercentComplete.put(DescriptionValue,
	 * PercentCompleteValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row +
	 * "]"));
	 * 
	 * String WorkInPlaceValue = common.getValue(WorkInPlace);
	 * 
	 * ConstructionContract_WorkInPlace.put(DescriptionValue, WorkInPlaceValue);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));
	 * 
	 * String RetainageAmountValue = common.getValue(RetainageAmount);
	 * 
	 * ConstructionContract_RetainageAmount.put(DescriptionValue,
	 * RetainageAmountValue);
	 * 
	 * WebElement PrevRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * ConstructionContract_PrevRetainage.put(DescriptionValue, PrevRetainagevalue);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * ConstructionContract_TotalRetainage.put(DescriptionValue,
	 * TotalRetainagevalue);
	 * 
	 * WebElement PrevWorkInPlace = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row +
	 * "]"));
	 * 
	 * String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);
	 * 
	 * ConstructionContract_PrevWorkInPlace.put(DescriptionValue,
	 * PrevWorkInPlaceValue);
	 * 
	 * WebElement PrevPercentage = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));
	 * 
	 * String PrevPercentageValue = common.getValue(PrevPercentage);
	 * 
	 * ConstructionContract_PrevPercentage.put(DescriptionValue,
	 * PrevPercentageValue);
	 * 
	 * WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])["
	 * + row + "]"));
	 * 
	 * String CostsValue = common.getValue(Costs);
	 * 
	 * ConstructionContract_Cost.put(DescriptionValue, CostsValue);
	 * 
	 * WebElement InvoiceAmount = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));
	 * 
	 * String InvoiceAmountValue = common.getValue(InvoiceAmount);
	 * 
	 * ConstructionContract_InvoiceAmount.put(DescriptionValue, InvoiceAmountValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * ConstructionContract_AmountRemaining.put(DescriptionValue,
	 * AmountRemainingValue); }
	 * 
	 * logger.info("ConstructionContract_RetainagePercentage: " +
	 * ConstructionContract_RetainagePercentage);
	 * logger.info("ConstructionContract_RetainageAmount: " +
	 * ConstructionContract_RetainageAmount);
	 * logger.info("ConstructionContract_PrevRetainage: " +
	 * ConstructionContract_PrevRetainage);
	 * logger.info("ConstructionContract_TotalRetainage: " +
	 * ConstructionContract_TotalRetainage);
	 * logger.info("ConstructionContract_PrevWorkInPlace: " +
	 * ConstructionContract_PrevWorkInPlace);
	 * logger.info("ConstructionContract_PrevPercentage: " +
	 * ConstructionContract_PrevPercentage);
	 * logger.info("ConstructionContract_Cost: " + ConstructionContract_Cost);
	 * logger.info("ConstructionContract_PercentComplete: " +
	 * ConstructionContract_PercentComplete);
	 * logger.info("ConstructionContract_WorkInPlace: " +
	 * ConstructionContract_WorkInPlace);
	 * logger.info("ConstructionContract_InvoiceAmount: " +
	 * ConstructionContract_InvoiceAmount);
	 * logger.info("ConstructionContract_AmountRemaining: " +
	 * ConstructionContract_AmountRemaining);
	 * 
	 * }
	 */

	public void checkCostAmount_CCOverview_AfterRetainageChange(String DescriptionValue, String CostAmount)
			throws InterruptedException {

		logger.info("Amount Data Journals: " + AmountData_Journals);

		String ExpectedCostAmount = "0.00";

		for (ArrayList<String> ConstructionContract : ConstructionContracts) {

			String Description = ConstructionContract.get(0);

			if (Description.equals(DescriptionValue)) {

				String[] TaskCodes = ConstructionContract.get(2).split(";");

				for (int i = 0; i < TaskCodes.length; i++) {

					String Amount = AmountData_Journals.get(TaskCodes[i]);

					if (Amount != null) {

						ExpectedCostAmount = formulas.getSum(ExpectedCostAmount, Amount);
					}
				}
			}

		}

		logger.info("Cost Amount Expected: " + ExpectedCostAmount);

		logger.info("Cost Amount Actual: " + CostAmount);

		Assert.assertEquals(CostAmount, ExpectedCostAmount,
				"Cost Amount in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	WebElement Submit1;

	@FindBy(xpath = "(//span[normalize-space()='Submit'])[2]")
	WebElement Submit2;

	@FindBy(xpath = "(//span[normalize-space()='Submit'])[3]")
	WebElement Submit3;

	public void clickSubmit() throws InterruptedException {

		try {

			common.clickElementJS(Submit1);
		}

		catch (Exception e1) {

			try {

				common.clickElementJS(Submit2);
			}

			catch (Exception e2) {

				common.clickElementJS(Submit3);

			}
		}

	}

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement Approve1;

	@FindBy(xpath = "(//span[normalize-space()='Approve'])[2]")
	WebElement Approve2;

	@FindBy(xpath = "(//span[normalize-space()='Approve'])[3]")
	WebElement Approve3;

	public void clickApprove() throws InterruptedException {

		try {

			common.clickElementJS(Approve1);

		}

		catch (Exception e1) {
			try {

				common.clickElementJS(Approve2);

			}

			catch (Exception e2) {
				common.clickElementJS(Approve3);
			}
		}
	}

	@FindBy(xpath = "//span[normalize-space()='Commit']")
	WebElement Commit1;

	@FindBy(xpath = "(//span[normalize-space()='Commit'])[2]")
	WebElement Commit2;

	@FindBy(xpath = "(//span[normalize-space()='Commit'])[3]")
	WebElement Commit3;

	public void clickCommit() throws InterruptedException {

		try {

			common.clickElementJS(Commit1);

		} catch (Exception e1) {

			try {

				common.clickElementJS(Commit2);

			} catch (Exception e2) {

				common.clickElementJS(Commit3);
			}
		}

	}

	public void clickStatus(String arg1) throws InterruptedException {

		if (arg1.equals("Submit")) {

			clickSubmit();
		}

		else if (arg1.equals("Approve")) {

			clickApprove();
		}

		else if (arg1.equals("Commit")) {

			clickCommit();
		}
	}

	@FindBy(xpath = "(//input[contains(@id,'Status')])[2]")
	WebElement Status_NewPayment;

	public String getStatus_NewPayment() throws InterruptedException {

		Thread.sleep(3000);

		String NewPaymentStatus = common.getValue(Status_NewPayment);

		logger.info("New Payment Status: " + NewPaymentStatus);

		return NewPaymentStatus;
	}

	public void checkNewPaymentStatus(String Status) throws InterruptedException {

		logger.info("New Payment status expected: " + Status);

		logger.info("New Payment status Actual: " + getStatus_NewPayment());

		Assert.assertEquals(getStatus_NewPayment(), Status, "New Payment status is not as expected");
	}

	@FindBy(xpath = "(//*[text()='Payment request'])[1]//following::*[text()='New'][1]")
	WebElement New_PaymentRequest1;

	@FindBy(xpath = "(//*[text()='Payment request'])[2]//following::*[text()='New'][1]")
	WebElement New_PaymentRequest2;

	public void clickNewSubcontractPayment() throws InterruptedException {

		try {
			common.clickElement(New_PaymentRequest1);
		}

		catch (Exception e) {
			common.clickElement(New_PaymentRequest2);
		}

	}

	public String getRetentionReversalStatus() throws InterruptedException {

		WebElement Billingstatus = ldriver.findElement(By.xpath("//*[@aria-label='Retention invoice' and @value='"
				+ RetentionInvoiceValue
				+ "']//ancestor::*[contains(@id,'retentionInvoiceId')]//preceding-sibling::*[contains(@id,'BillingStatus')]//*[@aria-label='Billing status']"));

		String StatusValue = common.getValue(Billingstatus);

		logger.info("Status Value: " + StatusValue);

		return StatusValue;

	}

	public void checkRetentionReversalStatus(String Status) throws InterruptedException {

		logger.info("Retention Reversal Billing Status Expected: " + Status);

		logger.info("Retention Reversal Billing Status Actual: " + getRetentionReversalStatus());

		Assert.assertEquals(getRetentionReversalStatus(), Status, "Retention Reversal Status is not as expected");
	}

	public String getRetentionReversalInvoiceAmount() throws InterruptedException {

		WebElement InvoiceAmount = ldriver.findElement(By.xpath("//*[@aria-label='Retention invoice' and @value='"
				+ RetentionInvoiceValue
				+ "']//ancestor::*[contains(@id,'retentionInvoiceId')]//preceding-sibling::*[contains(@id,'InvoiceAmount')]//*[@aria-label='Invoice amount']"));

		String InvoiceAmountValue = common.getValue(InvoiceAmount);

		logger.info("Invoice Amount Value: " + InvoiceAmountValue);

		return InvoiceAmountValue;

	}

	public void checkRetentionReversalInvoiceAmount() throws InterruptedException {

		logger.info(
				"Retention Reversal Invoice Amount Expected: " + InvoiceAmount_Applications_FromRetainageReleaseData);

		logger.info("Retention Reversal Invoice Amount Actual: " + getRetentionReversalInvoiceAmount());

		Assert.assertEquals(getRetentionReversalInvoiceAmount(), InvoiceAmount_Applications_FromRetainageReleaseData,
				"Retention Reversal Invoice Amount is not as expected");
	}

	public String getRetentionReversalRetainageAmount() throws InterruptedException {

		WebElement RetainageAmount = ldriver.findElement(By.xpath("//*[@aria-label='Retention invoice' and @value='"
				+ RetentionInvoiceValue
				+ "']//ancestor::*[contains(@id,'retentionInvoiceId')]//preceding-sibling::*[contains(@id,'RetainageAmount')]//*[@aria-label='Retainage amount']"));

		String RetainageAmountValue = common.getValue(RetainageAmount);

		logger.info("Retainage Amount: " + RetainageAmountValue);

		return RetainageAmountValue;

	}

	public void checkRetentionReversalRetainageAmount() throws InterruptedException {

		logger.info("Retention Reversal Retainage Amount Expected: "
				+ RetainageAmount_Applications_FromRetainageReleaseData);

		logger.info("Retention Reversal Retainage Amount Actual: " + getRetentionReversalRetainageAmount());

		Assert.assertEquals(getRetentionReversalRetainageAmount(),
				RetainageAmount_Applications_FromRetainageReleaseData,
				"Retention Reversal Retainage Amount is not as expected");
	}

	public String getRetentionReversalAmountDue() throws InterruptedException {

		WebElement AmountDue = ldriver.findElement(By.xpath("//*[@aria-label='Retention invoice' and @value='"
				+ RetentionInvoiceValue
				+ "']//ancestor::*[contains(@id,'retentionInvoiceId')]//preceding-sibling::*[contains(@id,'amountDue')]//*[@aria-label='Amount due']"));

		String AmountDueValue = common.getValue(AmountDue);

		logger.info("Amount Due: " + AmountDueValue);

		return AmountDueValue;

	}

	public void checkRetentionReversalAmountDue() throws InterruptedException {

		logger.info("Retention Reversal Amount Due Expected: " + AmountDue_Applications_FromRetainageReleaseData);

		logger.info("Retention Reversal Amount Due Actual: " + getRetentionReversalAmountDue());

		Assert.assertEquals(getRetentionReversalAmountDue(), AmountDue_Applications_FromRetainageReleaseData,
				"Retetion Reversal Amount Due is not as expected");
	}

	public String getInvoiceReversalStatus() throws InterruptedException {

		WebElement Billingstatus = ldriver.findElement(By.xpath("//*[@aria-label='Invoice' and @value='" + InvoiceValue
				+ "']//ancestor::*[contains(@id,'projInvoiceId')]//preceding-sibling::*[contains(@id,'BillingStatus')]//*[@value='Cancelled']"));

		String StatusValue = common.getValue(Billingstatus);

		logger.info("Status Value: " + StatusValue);

		return StatusValue;

	}

	public void checkInvoiceReversalStatus(String Status) throws InterruptedException {

		logger.info("Invoice Reversal Billing Status Expected: " + Status);

		logger.info("Invoice Reversal Billing Status Actual: " + getInvoiceReversalStatus());

		Assert.assertEquals(getInvoiceReversalStatus(), Status, "Invoice Reversal Status is not as expected");
	}

	public String getInvoiceReversalInvoiceAmount() throws InterruptedException {

		WebElement InvoiceAmount = ldriver.findElement(By.xpath("//*[@aria-label='Invoice' and @value='" + InvoiceValue
				+ "']//ancestor::*[contains(@id,'projInvoiceId')]//preceding-sibling::*[contains(@id,'InvoiceAmount')]//*[@aria-label='Invoice amount']"));

		String InvoiceAmountValue = common.getValue(InvoiceAmount);

		logger.info("Invoice Amount Value: " + InvoiceAmountValue);

		return InvoiceAmountValue;

	}

	public void checkInvoiceReversalInvoiceAmount() throws InterruptedException {

		logger.info("Invoice Reversal Invoice Amount Expected: " + InvoiceAmountTotal_ContractApplications);

		logger.info("Invoice Reversal Invoice Amount Actual: " + getInvoiceReversalInvoiceAmount());

		Assert.assertEquals(getInvoiceReversalInvoiceAmount(), "-" + InvoiceAmountTotal_ContractApplications,
				"Invoice Reversal Invoice Amount is not as expected");
	}

	public String getInvoiceReversalRetainageAmount() throws InterruptedException {

		WebElement RetainageAmount = ldriver.findElement(By.xpath("//*[@aria-label='Invoice' and @value='"
				+ InvoiceValue
				+ "']//ancestor::*[contains(@id,'projInvoiceId')]//preceding-sibling::*[contains(@id,'RetainageAmount')]//*[@aria-label='Retainage amount']"));

		String RetainageAmountValue = common.getValue(RetainageAmount);

		logger.info("Retainage Amount: " + RetainageAmountValue);

		return RetainageAmountValue;

	}

	public void checkInvoiceReversalRetainageAmount() throws InterruptedException {

		logger.info("Invoice Reversal Retainage Amount Expected: " + RetainageAmount_Applications);

		logger.info("Invoice Reversal Retainage Amount Actual: " + getInvoiceReversalRetainageAmount());

		Assert.assertEquals(getInvoiceReversalRetainageAmount(), "-" + RetainageAmount_Applications,
				"Invoice Reversal Retainage Amount is not as expected");
	}

	public String getInvoiceReversalAmountDue() throws InterruptedException {

		WebElement AmountDue = ldriver.findElement(By.xpath("//*[@aria-label='Invoice' and @value='" + InvoiceValue
				+ "']//ancestor::*[contains(@id,'projInvoiceId')]//preceding-sibling::*[contains(@id,'amountDue')]//*[@aria-label='Amount due']"));

		String AmountDueValue = common.getValue(AmountDue);

		logger.info("Amount Due: " + AmountDueValue);

		return AmountDueValue;

	}

	public void checkInvoiceReversalAmountDue() throws InterruptedException {

		logger.info("Invoice Reversal Amount Due Expected: " + AmountDue_Applications);

		logger.info("Invoice Reversal Amount Due Actual: " + getInvoiceReversalAmountDue());

		Assert.assertEquals(getInvoiceReversalAmountDue(), "-" + AmountDue_Applications,
				"Invoice Reversal Amount Due is not as expected");
	}

	public String getInvoiceAmount_ContractApplications_FromRetainageReleaseData() throws InterruptedException {

		InvoiceAmount_Applications_FromRetainageReleaseData = common.getValue(InvoiceAmount_Total_ContractApplications);

		return InvoiceAmount_Applications_FromRetainageReleaseData;

	}

	public String getRetainageAmount_ContractApplications_FromRetainageReleaseData() throws InterruptedException {

		RetainageAmount_Applications_FromRetainageReleaseData = common
				.getValue(RetainageAmount_Total_ContractApplications);

		return RetainageAmount_Applications_FromRetainageReleaseData;

	}

	public String getAmountdue_ContractApplications_FromRetainageReleaseData() throws InterruptedException {

		AmountDue_Applications_FromRetainageReleaseData = common.getValue(Amountdue_Total_ContractApplications);

		return AmountDue_Applications_FromRetainageReleaseData;

	}

	public void checkContractOverviewCalcAfterRetainageAndInvoiceCancel() throws InterruptedException {

		Thread.sleep(5000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			checkPercentComplete_ContractOverview(DescriptionValue, PercentCompleteValue);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlaceValue = common.getValue(WorkInPlace);

			checkWorkInPlace_ContractOverview(DescriptionValue, WorkInPlaceValue);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			checkInvoiceAmount_ContractOverview(DescriptionValue, InvoiceAmountValue);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			checkAmountRemaining_ContractOverview(DescriptionValue, AmountRemainingValue);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentageValue = common.getValue(RetainagePercentage);

			checkRetainangePercentage_ContractOverview(DescriptionValue, RetainagePercentageValue);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountValue = common.getValue(RetainageAmount);

			checkRetainangeAmount_ContractOverview(DescriptionValue, RetainageAmountValue);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			checkTotalRetainange_ContractOverview(DescriptionValue, TotalRetainagevalue);

			WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			String CostsValue = common.getValue(Costs);

			checkCostAmount_CCOverview_AfterRetainageChange(DescriptionValue, CostsValue);

		}

	}

	public void checkPercentComplete_ContractOverview(String DescriptionValue, String PercentComplete) {

		String ExpectedPercentComplete = ConstructionContract_PercentComplete.get(DescriptionValue);

		logger.info("Percent Complete Expected: " + ExpectedPercentComplete);

		logger.info("Percent Complete Actual: " + PercentComplete);

		Assert.assertEquals(PercentComplete, ExpectedPercentComplete,
				"Percent Complete in Contract is not as expected after retainage and invoice cancel for Description "
						+ DescriptionValue);
	}

	public void checkInvoiceAmount_ContractOverview(String DescriptionValue, String InvoiceAmount) {

		String ExpectedInvoiceAmount = ConstructionContract_InvoiceAmount.get(DescriptionValue);

		logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmount);

		logger.info("Invoice Amount Actual: " + InvoiceAmount);

		Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmount,
				"Invoice Amount in Contract is not as expected after retainage and invoice cancel for Description "
						+ DescriptionValue);
	}

	public void checkWorkInPlace_ContractOverview(String DescriptionValue, String WorkInPlace) {

		String ExpectedWorkInPlace_CCApplication = ConstructionContract_WorkInPlace.get(DescriptionValue);

		logger.info("Work In Place Expected: " + ExpectedWorkInPlace_CCApplication);

		logger.info("Work In Place Actual: " + WorkInPlace);

		Assert.assertEquals(WorkInPlace, ExpectedWorkInPlace_CCApplication,
				"Work In Place in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkAmountRemaining_ContractOverview(String DescriptionValue, String AmountRemaining) {

		String ExpectedAmountRemaining_CCApplication = ConstructionContract_AmountRemaining.get(DescriptionValue);

		logger.info("Amount Remaining Expected: " + ExpectedAmountRemaining_CCApplication);

		logger.info("Amount Remaining Actual: " + AmountRemaining);

		Assert.assertEquals(AmountRemaining, ExpectedAmountRemaining_CCApplication,
				"Amount Remaining in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkRetainangePercentage_ContractOverview(String DescriptionValue, String RetainagePercentage) {

		String ExpectedRetainagePercentage_CCApplication = ConstructionContract_RetainagePercentage
				.get(DescriptionValue);

		logger.info("Retainage Percentage Expected: " + ExpectedRetainagePercentage_CCApplication);

		logger.info("Retainage Percentage Actual: " + RetainagePercentage);

		Assert.assertEquals(RetainagePercentage, ExpectedRetainagePercentage_CCApplication,
				"Retainage Percentage in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkRetainangeAmount_ContractOverview(String DescriptionValue, String RetainageAmount) {

		String ExpectedRetainageAmount_CCApplication = ConstructionContract_RetainageAmount.get(DescriptionValue);

		logger.info("Retainage Amount Expected: " + ExpectedRetainageAmount_CCApplication);

		logger.info("Retainage Amount Actual: " + RetainageAmount);

		Assert.assertEquals(RetainageAmount, ExpectedRetainageAmount_CCApplication,
				"Retainage Amount in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkTotalRetainange_ContractOverview(String DescriptionValue, String TotalRetainange) {

		String ExpectedTotalRetainage_CCApplication = ConstructionContract_TotalRetainage.get(DescriptionValue);

		logger.info("Total Retainange Expected: " + ExpectedTotalRetainage_CCApplication);

		logger.info("Total Retainange Actual: " + TotalRetainange);

		Assert.assertEquals(TotalRetainange, ExpectedTotalRetainage_CCApplication,
				"Total Retainange in Contract is not as expected after retainage change for " + DescriptionValue);
	}

	public void checkInvoiceAmountTotalInContractApplications_AfterRetainageRelease() throws InterruptedException {

		InvoiceAmount_Applications_FromRetainageReleaseData = getInvoiceAmountTotalCalculatedFromContractApplications();

		logger.info("Invoice Amount Total_Contract Applications_Expected: "
				+ InvoiceAmount_Applications_FromRetainageReleaseData);

		logger.info("Invoice Amount Total_Contract Applications_Actual: " + getInvoiceAmount_ContractApplications());

		Assert.assertEquals(getInvoiceAmount_ContractApplications(),
				InvoiceAmount_Applications_FromRetainageReleaseData,

				"Invoice Amount Total in Contract Applications is not as expected");
	}

	public void checkRetainageAmountTotalInContractApplications_AfterRetainageRelease() throws InterruptedException {

		RetainageAmount_Applications_FromRetainageReleaseData = getRetainageAmountTotalCalculatedFromContractApplications();

		logger.info("Retainage Amount Total_Contract Applications_Expected: "
				+ RetainageAmount_Applications_FromRetainageReleaseData);

		logger.info(
				"Retainage Amount Total_Contract Applications_Actual: " + getRetainageAmount_ContractApplications());

		Assert.assertEquals(getRetainageAmount_ContractApplications(),
				RetainageAmount_Applications_FromRetainageReleaseData,
				"Retainage Amount Total in Contract Applications is not as expected");
	}

	public void checkAmountDueTotalInContractApplications_AfterRetainageRelease() throws InterruptedException {

		AmountDue_Applications_FromRetainageReleaseData = getAmountDueTotalCalculatedFromContractApplications();

		logger.info(
				"Amount due Total_Contract Applications_Expected: " + AmountDue_Applications_FromRetainageReleaseData);

		logger.info("Amount due Total_Contract Applications_Actual: " + getAmountdue_ContractApplications());

		Assert.assertEquals(getAmountdue_ContractApplications(), AmountDue_Applications_FromRetainageReleaseData,
				"Amount due Total in Contract Applications is not as expected");
	}

	// Arthi

	@FindBy(xpath = "(//*[text()='Project change order'])[2]")
	WebElement Projectchangeorder1;

	public void clickProjectchangeorder1() throws InterruptedException {
		try {
			common.clickElement(Projectchangeorder);
		} catch (Exception e) {

			common.clickElement(Projectchangeorder1);
		}

	}

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } if (arg1.equals("ECAC")) { clickECAC(); }
	 * 
	 * if (arg1.equals("Project change order")) { clickProjectchangeorder1(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * common.clickElement(Postedtransactions);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[contains(@id,'tabBudgets')][text()='Budgets']")
	WebElement Budgets;

	public void clickBudgets() throws InterruptedException {

		common.scrollIntoView(Budgets);

		if (!common.isSectionExpanded(Budgets)) {

			common.clickElement(Budgets);
		}

	}

	@FindBy(xpath = "(//*[text()='New budget'])")
	WebElement Newbudget;

	@FindBy(xpath = "(//*[text()='New budget'])[2]")
	WebElement Newbudget2;

	@FindBy(xpath = "(//*[text()='New budget'])[3]")
	WebElement Newbudget3;

	@FindBy(xpath = "(//*[text()='New budget'])[4]")
	WebElement Newbudget4;

	public void clickNewbudget() throws InterruptedException {

		Thread.sleep(5000);

		try {
			common.clickElement(Newbudget);
		}

		catch (Exception e1) {

			try {

				common.clickElement(Newbudget2);
			}

			catch (Exception e2) {
				try {
					Thread.sleep(5000);
					common.scrollIntoView(Newbudget3);
					common.clickElement(Newbudget3);
				} catch (Exception e) {
					common.scrollIntoView(Newbudget4);
					common.clickElement(Newbudget4);
				}
			}
		}
	}

	@FindBy(xpath = "//*[contains(@id,'ProjPeriodTo_input')]")
	WebElement CommittedPeriod;

	/*
	 * public void clickCommittedPeriod() throws InterruptedException {
	 * 
	 * common.clickElement(CommittedPeriod); }
	 */

	public void setcurrentPeriod() throws InterruptedException {

		String currentPeriodEndDate = common.getCurrentMonthEndDate();

		common.setTextAfterDelete(CommittedPeriod, currentPeriodEndDate);
	}

	public void setNextPeriod() throws InterruptedException {

		String nextPeriodEndDate = common.getNextMonthEndDate();

		common.setTextAfterDelete(CommittedPeriod, nextPeriodEndDate);
	}

	public void setCommittedPeriod(String arg1) throws InterruptedException {

		if (arg1.equals("Current Period")) {

			setcurrentPeriod();

		} else if (arg1.equals("Next Period")) {

			setNextPeriod();

		}

	}

	public void checkCommittedPeriod(String arg1) throws InterruptedException {

		String ActualCommittedPeriod = common.getValue(CommittedPeriod);

		String ExpectedCommittedPeriod = "";

		if (arg1.equals("Current Period")) {

			ExpectedCommittedPeriod = common.getCurrentMonthEndDate();

		} else if (arg1.equals("Next Period")) {

			ExpectedCommittedPeriod = common.getNextMonthEndDate();

		}

		Assert.assertEquals(ActualCommittedPeriod, ExpectedCommittedPeriod, "Committed period is not as Expected");

		logger.info("Expected committed period is : " + ExpectedCommittedPeriod);

		logger.info("Actual committed period is : " + ActualCommittedPeriod);
	}

	@FindBy(xpath = "(//*[contains(@name,'ChangeOrderId')])[2]")
	WebElement ChangeOrderId;

	public void getChangeOrderID(String arg1) throws InterruptedException {

		common.clickElement(ChangeOrderId);

		changeOrderId.put(arg1, common.getValue(ChangeOrderId));

		logger.info("Change Order ID: " + changeOrderId);

		// logger.info("change order id is "+ changeOrderId);

	}

	@FindBy(xpath = "(//*[contains(@id,'BudgetType')])[4]")
	WebElement BudgetType;

	public void checkBudgetType(String arg1) throws InterruptedException {

		String BudgetTypeValue = common.getValue(BudgetType);

		logger.info("Expected Budget Type :" + arg1);

		logger.info("Actual Budget Type :" + BudgetTypeValue);

		Assert.assertEquals(BudgetTypeValue, arg1, "Budget type is not as Expected");

	}

	@FindBy(xpath = "(//*[contains(text(),'WBS structure created for project ')])[2]")
	WebElement BudgetChangeOrderPostedMessage;

	public void checkBudgetChangeOrderPostedMessage() throws InterruptedException {

		Thread.sleep(5000);

		logger.info("Budget Change Order Posted Message :  " + common.getText(BudgetChangeOrderPostedMessage));

		// logger.info( " true or false "+
		// common.isTextDisplayed(BudgetChangeOrderPostedMessage));

		Assert.assertTrue(common.isTextDisplayed(BudgetChangeOrderPostedMessage),
				"Budget Change Order posted message has not been displayed as expected");
	}

	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	WebElement Save1;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[2]")
	WebElement Save2;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[3]")
	WebElement Save3;

	public void clickSave() throws InterruptedException {

		try {

			common.clickElement(Save1);

		}

		catch (Exception e) {
			try {

				common.clickElement(Save2);

			} catch (Exception e1) {
				common.clickElement(Save3);
			}

		}

		Thread.sleep(5000);
	}

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[1]")
	WebElement Close1;

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[2]")
	WebElement Close2;

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[3]")
	WebElement Close3;

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[4]")
	WebElement Close4;

	@FindBy(xpath = "(//*[@name='SystemDefinedCloseButton'])[5]")
	WebElement Close5;

	public void clickClose() throws InterruptedException {

		try {

			common.clickElementJS(Close1);

		}

		catch (Exception e1) {

			try {

				common.clickElementJS(Close2);

			}

			catch (Exception e2) {

				try {

					common.clickElementJS(Close3);

				}

				catch (Exception e3) {

					try {

						common.clickElementJS(Close4);

					}

					catch (Exception e4) {

						common.clickElementJS(Close5);

					}

				}

			}
		}
	}

	@FindBy(xpath = "//*[contains(@class,'Refresh')]")
	WebElement Refresh1;

	@FindBy(xpath = "(//*[contains(@class,'Refresh')])[2]")
	WebElement Refresh2;

	@FindBy(xpath = "(//*[contains(@class,'Refresh')])[3]")
	WebElement Refresh3;

	@FindBy(xpath = "(//*[contains(@class,'Refresh')])[4]")
	WebElement Refresh4;

	@FindBy(xpath = "(//*[contains(@class,'Refresh')])[5]")
	WebElement Refresh5;

	public void clickRefresh() throws InterruptedException {
		try {
			common.clickElementJS(Refresh1);
		} catch (Exception e) {
			try {
				common.clickElementJS(Refresh2);
			} catch (Exception e2) {
				try {
					common.clickElementJS(Refresh3);
				} catch (Exception e3) {
					try {
						common.clickElementJS(Refresh4);
					} catch (Exception e4) {
						common.clickElementJS(Refresh5);
					}
				}

			}
		}
		Thread.sleep(5000);
	}

	public void setECACData() throws InterruptedException {

		ECACNetChangeValue_AfterChanges = new HashMap<String, String>();

		clickRefresh();

		for (ArrayList<String> ECAC : UpdateECACData) {

			String TaskCodeValue = ECAC.get(0);

			String BudgetCategoryValue = ECAC.get(1);

			String RevisedQtyValue = ECAC.get(2);

			String ECACNetChangeValue = ECAC.get(3);

			WebElement RevisedQty = ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='"
					+ TaskCodeValue
					+ "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
					+ BudgetCategoryValue
					+ "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedQty')]//*[@aria-label='Revised qty']"));

			String RevisedQtyExistingValue = common.getValue(RevisedQty);

			if (!RevisedQtyValue.equals("")) {

				Thread.sleep(3000);

				common.setTextAfterDelete(RevisedQty, RevisedQtyValue);

			}

			WebElement RevisedRate = ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='"
					+ TaskCodeValue
					+ "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
					+ BudgetCategoryValue
					+ "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedUnitPrice')]//*[@aria-label='Revised rate']"));

			String RevisedRateValue = common.getValue(RevisedRate);

			WebElement ECACNetChange = ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='"
					+ TaskCodeValue
					+ "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
					+ BudgetCategoryValue
					+ "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'NetChange')]//*[@aria-label='ECAC net change']"));

			if (ECACNetChangeValue.equals("")) {

				ECACNetChangeValue = common.getValue(ECACNetChange);

				checkECACNetChange(RevisedQtyExistingValue, RevisedQtyValue, RevisedRateValue, ECACNetChangeValue,
						TaskCodeValue, BudgetCategoryValue);

			}

			else {

				// common.doubleClickElement(ECACNetChange);

				common.scrollIntoView(ECACNetChange);

				common.setTextAfterDelete(ECACNetChange, ECACNetChangeValue);

			}

			ECACNetChangeValue_AfterChanges.put(TaskCodeValue + ":" + BudgetCategoryValue, ECACNetChangeValue);

			WebElement ECACRevisedAmount = ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='"
					+ TaskCodeValue
					+ "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
					+ BudgetCategoryValue
					+ "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'RevisedAmount')]//*[@aria-label='ECAC revised amount']"));

			String ECACRevisedAmountValue = common.getValue(ECACRevisedAmount);

			WebElement ECACAmount = ldriver.findElement(By.xpath("//*[@aria-label='Task code' and @value='"
					+ TaskCodeValue
					+ "']//ancestor::*[contains(@id,'TaskCode') and @role='gridcell']//following-sibling::*[contains(@id,'BudgetCategoryId')]//*[@aria-label='Budget category' and @value='"
					+ BudgetCategoryValue
					+ "']//ancestor::*[contains(@id,'BudgetCategory')]//following-sibling::*[contains(@id,'PriorECACAmount')]//*[@aria-label='ECAC amount']"));

			String ECACAmountValue = common.getValue(ECACAmount);

			checkECACRevisedAmount(ECACAmountValue, ECACNetChangeValue, ECACRevisedAmountValue, TaskCodeValue,
					BudgetCategoryValue);
		}

	}

	@FindBy(xpath = "(//*[text()='New'])[5]")
	WebElement New_Journals;

	@FindBy(xpath = "(//*[text()='New'])[2]")
	WebElement New_Journals1;

	public void clickNewButton() throws InterruptedException {

		Thread.sleep(2000);
		try {
			common.clickElement(New_Journals);
		} catch (Exception e) {
			common.clickElement(New_Journals1);
		}
	}

	public void getBudgetLines(String BudgetLinesData) throws IOException {

		if (BudgetLinesData.equals("BudgetLines_Original")) {

			BudgetLines = rd.getXl_Bugdgetlines();
		} else if (BudgetLinesData.equals("BudgetLines_Revision1")) {

			BudgetLines = rd.getXl_Bugdgetlines_Revision1();
		} else if (BudgetLinesData.equals("BudgetLines_Revision2")) {

			BudgetLines = rd.getXl_Bugdgetlines_Revision2();
		}
	}

	/*
	 * public void getExpectedTaskSummaryData(String TaskcodeValue, String
	 * BudgetcategoryValue, String QuantityValue, String LineAmountValue, String
	 * BudgetLinesData) {
	 * 
	 * ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();
	 * ArrayList<String> Data = new ArrayList<String>();
	 * Data.add(BudgetcategoryValue); Data.add(TaskcodeValue);
	 * Data.add(QuantityValue); Data.add(LineAmountValue);
	 * 
	 * if (!TaskSummary_Expected.containsKey(BudgetLinesData)) {
	 * 
	 * DataSet.add(new ArrayList<String>(Data));
	 * 
	 * TaskSummary_Expected.put(BudgetLinesData, new
	 * ArrayList<ArrayList<String>>(DataSet));
	 * 
	 * Data.clear();
	 * 
	 * DataSet.clear(); } else { DataSet =
	 * TaskSummary_Expected.get(BudgetLinesData);
	 * 
	 * DataSet.add(new ArrayList<String>(Data));
	 * 
	 * TaskSummary_Expected.put(BudgetLinesData, new
	 * ArrayList<ArrayList<String>>(DataSet));
	 * 
	 * Data.clear();
	 * 
	 * DataSet.clear(); }
	 * 
	 * }
	 */

	public void setBudgetLines(String BudgetLinesData) throws InterruptedException, IOException {

		getBudgetLines(BudgetLinesData);

		BudgetLines_LineAmount = new HashMap<String, String>();

		String CostBudget_RevRec = "0.00";

		int row = 1;

		for (ArrayList<String> BudgetLine : BudgetLines) {

			common.clickElement(New_Budgetlines);

			String TaskcodeValue = BudgetLine.get(0);

			// String DescriptionValue = BudgetLine.get(1);

			String BudgetcategoryValue = BudgetLine.get(2);

			String QuantityValue = BudgetLine.get(3);

			String UnitValue = BudgetLine.get(4);

			String UnitPriceValue = BudgetLine.get(5);

			// String LineAmountValue = BudgetLine.get(6);

			Thread.sleep(3000);

			WebElement Taskcode = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			common.setText(Taskcode, TaskcodeValue);

//			if (!DescriptionValue.equals("")) {
//
//				WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));
//
//				common.setText(Description, DescriptionValue);
//
//			}

			WebElement Budgetcategory = ldriver
					.findElement(By.xpath("(//*[@aria-label='Budget category'])[" + row + "]"));

			common.setText(Budgetcategory, BudgetcategoryValue);

			if (!QuantityValue.equals("")) {

				WebElement Quantity = ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));

				common.setTextAfterDelete(Quantity, QuantityValue);

			}

			if (!UnitValue.equals("")) {

				WebElement Unit = ldriver.findElement(By.xpath("(//*[@aria-label='Unit'])[" + row + "]"));

				common.setTextAfterDelete(Unit, UnitValue);

			}

			if (!UnitPriceValue.equals("")) {

				WebElement UnitPrice = ldriver.findElement(By.xpath("(//*[@aria-label='Unit price'])[" + row + "]"));

				common.setTextAfterDelete(UnitPrice, UnitPriceValue);

			}

			Thread.sleep(2000);

			WebElement Lineamount = ldriver.findElement(By.xpath("(//*[@aria-label='Line amount'])[" + row + "]"));

			String LineAmountValue = common.getValue(Lineamount);

			BudgetLines_LineAmount.put(TaskcodeValue + ":" + BudgetcategoryValue, LineAmountValue);

			checkLineAmount(QuantityValue, UnitPriceValue, LineAmountValue, row);

			common.KeyboardAction("Tab");

			row++;

			getExpectedTaskSummaryData(TaskcodeValue, BudgetcategoryValue, QuantityValue, LineAmountValue,
					BudgetLinesData);

			if (BudgetCategories_ExcludedFromRevRec.contains(BudgetcategoryValue)) {

				CostBudget_RevRec = formulas.getSum(CostBudget_RevRec, LineAmountValue);

			}

		}

		clickSave();

		CostBudget_ExcludeRevRec = formulas.getDifference(getCostBudget(), CostBudget_RevRec);

		logger.info("CostBudget: " + getCostBudget());

		logger.info("CostBudget_RevRec: " + CostBudget_RevRec);

		logger.info("CostBudget_ExcludeRevRec: " + CostBudget_ExcludeRevRec);

		logger.info("BudgetLines_LineAmount with Task Code and Budget Category: " + BudgetLines_LineAmount);

		logger.info("TaskSummary_Expected for BudgetLines: " + TaskSummary_Expected);

		logger.info("TaskSummary_Expected for BudgetLines: " + TaskSummary_Expected);
	}

	@FindBy(xpath = "(//*[text()='General']//parent::button)[1]")
	WebElement General1;

	@FindBy(xpath = "(//*[text()='General']//parent::button)[2]")
	WebElement General2;

	@FindBy(xpath = "(//*[text()='General']//parent::button)[3]")
	WebElement General3;

	@FindBy(xpath = "(//*[text()='General']//parent::button)[4]")
	WebElement General4;

	@FindBy(xpath = "(//*[text()='General']//parent::button)[5]")
	WebElement General5;

	@FindBy(xpath = "(//*[text()='General']//parent::button)[6]")
	WebElement General6;

	public void clickGeneral() throws InterruptedException {

		try {
			if (!common.isSectionExpanded(General1))

				common.clickElementJS(General1);

		} catch (Exception e1) {

			try {
				if (!common.isSectionExpanded(General2))

					common.clickElementJS(General2);
			} catch (Exception e2) {
				try {
					if (!common.isSectionExpanded(General3))

						common.clickElementJS(General3);
				} catch (Exception e3) {

					try {
						if (!common.isSectionExpanded(General4))

							common.clickElementJS(General4);
					} catch (Exception e4) {

						try {
							if (!common.isSectionExpanded(General5))

								common.clickElementJS(General5);
						} catch (Exception e5) {

							if (!common.isSectionExpanded(General6))

								common.clickElementJS(General6);
						}
					}
				}
			}

		}

		Thread.sleep(2000);

	}

	@FindBy(xpath = "//*[contains(@name,'totalRevenueAmount')]")
	WebElement RevenueBudget;

	@FindBy(xpath = "(//*[contains(@name,'totalRevenueAmount')])[2]")
	WebElement RevenueBudget1;

	public String getRevenueBudget() throws InterruptedException {

		String RevenueBudgetValue = "";
		try {
			RevenueBudgetValue = common.getValue(RevenueBudget);
		} catch (Exception e) {
			RevenueBudgetValue = common.getValue(RevenueBudget1);
		}
		logger.info("RevenueBudgetValue:" + RevenueBudgetValue);

		return RevenueBudgetValue;

	}

	@FindBy(xpath = "//input[@name='GroupBudgetTotals_totalSalesAmount']")
	WebElement Salesamount;

	public String getSalesamount() throws InterruptedException {

		SalesamountValue = common.getValue(Salesamount);

		return SalesamountValue;

	}

	@FindBy(xpath = "//*[contains(@name,'totalBudgetAmount')]")
	WebElement CostBudget;

	@FindBy(xpath = "(//*[contains(@name,'totalBudgetAmount')])[2]")
	WebElement CostBudget1;

	public String getCostBudget() throws InterruptedException {

		Thread.sleep(5000);

		String CostBudgetValue = "";
		try {
			CostBudgetValue = common.getValue(CostBudget);
		} catch (Exception e) {
			CostBudgetValue = common.getValue(CostBudget1);
		}
		return CostBudgetValue;

	}

	@FindBy(xpath = "//*[contains(@name,'profitMargin')]")
	WebElement Profitmargin;

	@FindBy(xpath = "(//*[contains(@name,'profitMargin')])[2]")
	WebElement Profitmargin1;

	public String getProfitmargin() throws InterruptedException {

		String ProfitmarginValue = "";
		try {
			ProfitmarginValue = common.getValue(Profitmargin);
		} catch (Exception e) {
			ProfitmarginValue = common.getValue(Profitmargin1);
		}
		return ProfitmarginValue;

	}

	/*
	 * @FindBy(xpath = "//*[contains(@name,'grossMargin')]") WebElement GrossMargin;
	 */

	public String getGrossMargin() throws InterruptedException {

		String GrossMarginValue = common.getValue(GrossMargin);

		return GrossMarginValue;

	}

	public void checkGrossMargin() throws InterruptedException {

		String GrossMargin = getGrossMargin();

		GrossMarginValue_Expected = formulas.getDifference(RevenueBudgetValue_Expected, CostBudgetValue_Expected);

		Assert.assertEquals(GrossMargin, GrossMarginValue_Expected, "Gross margin value is not as expected");

	}

	// ===============Progress subcontract=========================

	@FindBy(xpath = "//*[text()='Vendor invoice number']//following::input[contains(@id,'VendorInvoiceNumber')]")
	WebElement Vendorinvoicenumber;

	public String setVendorinvoicenumber() throws InterruptedException {

		VendorInvoiceNumberValue = common.generateUniqueID("VIN");

		common.setText(Vendorinvoicenumber, VendorInvoiceNumberValue);

		logger.info("Vendor Invoice Number Value: " + VendorInvoiceNumberValue);

		logger.info("Vendor Invoice Number Value: " + VendorInvoiceNumberValue);
		return VendorInvoiceNumberValue;
	}

	@FindBy(xpath = "//*[text()='Load lines']")
	WebElement Loadlines;

	public void clickLoadlines() throws InterruptedException {

		common.clickElement(Loadlines);

	}

	@FindBy(xpath = "//*[@aria-label='SV line#' and contains(@id,'SVLineNum')]")
	List<WebElement> NumberOfInvoiceLines;

	public int getNumberOfInvoiceLines() throws InterruptedException {

		return NumberOfInvoiceLines.size();

	}

	@FindBy(xpath = "//*[text()='Net amount']//following::*[contains(@id,'GridInvoiceLines_LineAmount') and @aria-label='Net amount']")
	List<WebElement> Netamount_Subcontract;

	@FindBy(xpath = "//*[text()='Invoice amount']//following::*[contains(@id,'GridInvoiceLines_InvoiceAmount') and @aria-label='Invoice amount']")
	List<WebElement> Invoiceamount_Subcontract;

	public String getSumOfNetAmount_SubcontractPayment() throws InterruptedException {

		SubcontractPayment_NetAmount = "0.00";

		for (WebElement NetAmount : Netamount_Subcontract) {

			String NetamountValue = common.getValue(NetAmount);

			SubcontractPayment_NetAmount = formulas.getSum(NetamountValue, SubcontractPayment_NetAmount);

		}
		return SubcontractPayment_NetAmount;
	}

	public String getSumOfInvoiceAmount_SubcontractPayment() throws InterruptedException {

		SubcontractPayment_InvoiceAmount = "0.00";

		for (WebElement InvoiceAmount : Invoiceamount_Subcontract) {

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			SubcontractPayment_InvoiceAmount = formulas.getSum(InvoiceAmountValue, SubcontractPayment_InvoiceAmount);

		}
		return SubcontractPayment_InvoiceAmount;

	}

	@FindBy(xpath = "//*[text()='Line total']//following::input[contains(@id,'GroupIdentification_M_lineTotal')]")
	WebElement Linetotal;

	public void checkLineTotal() throws InterruptedException {

		String ActualLineAmount = common.getValue(Linetotal);

		logger.info("Expected Net amount: " + getSumOfNetAmount_SubcontractPayment());

		logger.info("Actual Net amount: " + ActualLineAmount);

		Assert.assertEquals(ActualLineAmount, getSumOfNetAmount_SubcontractPayment(),
				"Line total amount is not displayed as expected");
	}

	@FindBy(xpath = "//*[text()='Invoice amount']//following::input[contains(@id,'invoicedwithoutRetainageAmount')]")
	WebElement Invoiceamount;

	public void checkInvoiceAmount() throws InterruptedException {

		InvoiceAmountValue = common.getValue(Invoiceamount);

		logger.info("Expected Invoice amount: " + getSumOfInvoiceAmount_SubcontractPayment());

		logger.info("Actual Invoice amount: " + InvoiceAmountValue);

		Assert.assertEquals(InvoiceAmountValue, getSumOfInvoiceAmount_SubcontractPayment(),
				"Invoice amount is not displayed as expected");
	}

	@FindBy(xpath = "(//*[text()='Payment request' and contains(@class,'headerLabel')])[1]")
	WebElement Paymentrequest1;

	@FindBy(xpath = "(//*[text()='Payment request' and contains(@class,'headerLabel')])[2]")
	WebElement Paymentrequest2;

	public void clickPaymentrequest() throws InterruptedException {

		try {

			common.clickElementJS(Paymentrequest1);

		} catch (Exception e1) {

			common.clickElementJS(Paymentrequest2);

		}

		Thread.sleep(15000);
	}

	@FindBy(xpath = "//*[text()='Status']//following::input[contains(@id,'GroupIdentification_Status')]")
	WebElement Subcontract_PaymentRequeststatus;

	public String getSubcontract_PaymentRequeststatus() throws InterruptedException {

		Thread.sleep(3000);

		String SubcontractPaymentRequeststatus = common.getValue(Subcontract_PaymentRequeststatus);

		return SubcontractPaymentRequeststatus;

	}

	public void checkSubcontractPaymentRequeststatus(String status) throws InterruptedException {

		Thread.sleep(7000);

		Assert.assertEquals(getSubcontract_PaymentRequeststatus(), status,
				"Sub contract payment request status is not as expected");

	}

	public void checkSubcontractPaymentRequestMessage() throws InterruptedException {

		Thread.sleep(5000);

		WebElement SubcontractPaymentRequestMessage = ldriver
				.findElement(By.xpath("//*[text()='Invoice " + VendorInvoiceNumberValue + " with amount "
						+ InvoiceAmountValue + " was applied to purchase order " + PurchaseOrderValue + "']"));

		Assert.assertTrue(common.isTextDisplayed(SubcontractPaymentRequestMessage),
				"Subcontract Payment Request Message has been dispalyed as expected");

	}

	// ======Code to get Retainage Invoice data ============

	@FindBy(xpath = "//*[contains(@id,'Card')]")
	List<WebElement> InvoiceLines_Invoicejournals;

	public int getNumberOfInvoiceLines_Invoicejournals() {

		return InvoiceLines_Invoicejournals.size();

	}

	/*
	 * @FindBy(xpath = "//*[@name='ProjectInvoiceJour_InvoiceAmount']") WebElement
	 * Invoiceamount_Invoicejournals;
	 * 
	 * @FindBy(xpath = "//*[@aria-label='Invoice line amount']") WebElement
	 * Invoicelineamount_Invoicejournals;
	 * 
	 * @FindBy(xpath = "//*[@aria-label='Customer retained amount']") WebElement
	 * Customerretainedamount_Invoicejournals;
	 * 
	 * @FindBy(xpath = "//*[@aria-label='Retention release amount']") WebElement
	 * Retentionreleaseamount_Invoicejournals;
	 */

	/*
	 * public void getSumOfInvoiceAmountAndInvoiceLineAmount() throws
	 * InterruptedException {
	 * 
	 * InvoiceAmount_Invoicejournals = "0.00";
	 * 
	 * InvoiceLineAmount_Invoicejournals = "0.00";
	 * 
	 * CustomerRetainedAmount_Invoicejournals = "0.00";
	 * 
	 * RetentionReleaseAmount_Invoicejournals = "0.00";
	 * 
	 * for (WebElement Invoicejournal : InvoiceLines_Invoicejournals) {
	 * 
	 * common.clickElement(Invoicejournal);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * String InvoiceAmountValue = common.getValue(Invoiceamount_Invoicejournals);
	 * 
	 * InvoiceAmount_Invoicejournals =
	 * formulas.getSum(InvoiceAmount_Invoicejournals, InvoiceAmountValue);
	 * 
	 * logger.info("Total Invoice Amount in Invoice journals: " +
	 * InvoiceAmount_Invoicejournals);
	 * 
	 * // logger.info("Invoice Amount in Invoice journals: " + //
	 * InvoiceAmount_Invoicejournals); String InvoiceLineAmountValue =
	 * common.getValue(Invoicelineamount_Invoicejournals);
	 * 
	 * InvoiceLineAmount_Invoicejournals =
	 * formulas.getSum(InvoiceLineAmount_Invoicejournals, InvoiceLineAmountValue);
	 * 
	 * logger.info("Total Invoice line Amount in Invoice journals: " +
	 * InvoiceLineAmount_Invoicejournals);
	 * 
	 * // logger.info("Invoice line Amount in Invoice journals: " + //
	 * InvoiceLineAmount_Invoicejournals);
	 * 
	 * String CustomerRetainedAmountValue =
	 * common.getValue(Customerretainedamount_Invoicejournals);
	 * 
	 * CustomerRetainedAmount_Invoicejournals =
	 * formulas.getSum(CustomerRetainedAmount_Invoicejournals,
	 * CustomerRetainedAmountValue);
	 * 
	 * logger.info( "Total Customer retained Amount in Invoice journals: " +
	 * CustomerRetainedAmount_Invoicejournals);
	 * 
	 * String RetentionReleaseAmountValue =
	 * common.getValue(Retentionreleaseamount_Invoicejournals);
	 * 
	 * RetentionReleaseAmount_Invoicejournals =
	 * formulas.getSum(RetentionReleaseAmount_Invoicejournals,
	 * RetentionReleaseAmountValue);
	 * 
	 * logger.info( "Total Retention Release Amount in Invoice journals: " +
	 * RetentionReleaseAmount_Invoicejournals);
	 * 
	 * }
	 * 
	 * }
	 */

	public String getDifferenceOfCustomerRetainedAmountAndRetentionReleaseAmount() throws InterruptedException {

		String SumOfCustomerRetainedAmountAndRetentionReleaseAmount = formulas
				.getDifference(CustomerRetainedAmount_Invoicejournals, RetentionReleaseAmount_Invoicejournals);

		logger.info("Sum of Customer retained amount and Retention release amount: "
				+ SumOfCustomerRetainedAmountAndRetentionReleaseAmount);

		return SumOfCustomerRetainedAmountAndRetentionReleaseAmount;
	}
	// =============Changed by Monica during Retainage PFO Val==========

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * }
	 * 
	 * if (arg1.equals("ECAC")) {
	 * 
	 * clickECAC();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * common.clickElement(Postedtransactions);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Bill")) {
	 * 
	 * if (arg1.equals("Invoice journals")) {
	 * 
	 * common.clickElement(Invoicejournals);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Control")) {
	 * 
	 * if (arg1.equals("Committed Cost")) {
	 * 
	 * common.clickElement(Committedcost);
	 * 
	 * Thread.sleep(5000); } } }
	 */

	@FindBy(xpath = "(//*[contains(@class,'appBarTab') and text()='Control'])[1]")
	WebElement Control1;

	@FindBy(xpath = "(//*[contains(@class,'appBarTab') and text()='Control'])[2]")
	WebElement Control2;

	/*
	 * public void clickPageHeader(String arg1) throws InterruptedException { if
	 * (arg1.equals("Project cost management")) {
	 * clickProjectcostmanagement_PageHeader(); } if (arg1.equals("Manage")) {
	 * clickManage(); } if (arg1.equals("Control")) {
	 * 
	 * try { common.clickElement(Control1); } catch (Exception e) {
	 * common.clickElement(Control2); } }
	 * 
	 * if (arg1.equals("Project")) {
	 * 
	 * clickProjectTab(); } }
	 */

	public void checkAmountDue_CCApplication_AfterRetainageChange(String DescriptionValue, String RetainageAmount,
			String InvoiceAmount, String AmountDue) throws InterruptedException {

		String ExpectedAmountDue_CCApplication = formulas.getDifference(InvoiceAmount, RetainageAmount);

		logger.info("Percent Complete Expected: " + ExpectedAmountDue_CCApplication);

		logger.info("Percent Complete Actual: " + AmountDue);

		Assert.assertEquals(AmountDue, ExpectedAmountDue_CCApplication,
				"Amount Due in Contract is not as expected after retainage change for " + DescriptionValue);

	}

	public void checkECACNetChange(String RevisedQtyExistingValue, String RevisedQtyValue, String RevisedRateValue,
			String ECACNetChangeValue, String TaskCodeValue, String BudgetCategoryValue) throws InterruptedException {

		String ECACNetChangeValueExpected = formulas.getProduct(

				formulas.getDifference(RevisedQtyValue, RevisedQtyExistingValue), RevisedRateValue);

		logger.info("Expected ECACNetChange value:" + ECACNetChangeValueExpected);

		logger.info("Actual ECACNetChange value: " + ECACNetChangeValue);

		Assert.assertEquals(ECACNetChangeValue, ECACNetChangeValueExpected,
				"ECAC Net Change Value is not as Expected for TaskCode:" + TaskCodeValue + "& Budget Category "
						+ BudgetCategoryValue);
	}

	public void checkETCandCTCAmount(String ECACAmountValue, String ActualAmountValue, String CommittedCostValue,
			String ETCValue, String CTCAmountValue, String TaskCodeValue, String BudgetCategoryValue)
			throws InterruptedException {

		String CTCAmountExpected = formulas.getDifference(ECACAmountValue, ActualAmountValue);

		String ETCExpected = formulas.getDifference(CTCAmountExpected, CommittedCostValue);

		logger.info("Expected ETC value:" + ETCExpected);

		logger.info("Actual ETC value: " + ETCValue);

		Assert.assertEquals(ETCValue, ETCExpected, "ETC Value is not As Expected For Task code" + TaskCodeValue
				+ "& Budget Category" + BudgetCategoryValue);
		logger.info("Expected CTC Amount value:" + CTCAmountExpected);

		logger.info("Actual CTC Amount value: " + CTCAmountValue);

		Assert.assertEquals(CTCAmountValue, CTCAmountExpected, "CTC Amount Value not As Expected For Task code"
				+ TaskCodeValue + "& Budget Category" + BudgetCategoryValue);

	}

	@FindBy(xpath = "(//*[@aria-label='Task code'])")
	List<WebElement> numberOfLinesInCommittedCost;

	public int NumberOfLinesInCommittedCost() throws InterruptedException {

		Thread.sleep(5000);

		logger.info("Number Of Lines In Committed Cost: " + numberOfLinesInCommittedCost.size());

		return numberOfLinesInCommittedCost.size();

	}

	public void getSumOfTotalCostAmount() throws InterruptedException {

		TotalCostAmount_CommittedCost = "0.00";

		for (int row = 1; row <= NumberOfLinesInCommittedCost(); row++) {

			WebElement Costamount_CommittedCost = ldriver
					.findElement(By.xpath("(//*[@aria-label='Cost amount'])[" + row + "]"));

			String CostAmount = common.getValue(Costamount_CommittedCost);

			TotalCostAmount_CommittedCost = formulas.getSum(TotalCostAmount_CommittedCost, CostAmount);

		}

		logger.info("Total cost amount in committed cost: " + TotalCostAmount_CommittedCost);

	}

	@FindBy(xpath = "(//*[@aria-label='Project ID'])[2]")
	WebElement ProjectID_CommittedCost;

	@FindBy(xpath = "(//*[text()='Transaction ID']//parent::div)[1]")
	WebElement TransactionID_CommittedCost;

	public void checkCommittedCostLinesDisplayed() throws InterruptedException {

		Thread.sleep(3000);

		// logger.info("Committed cost lines are displayed after progress subcontract
		// which is not expected");

		Assert.assertFalse(common.isTextDisplayed(ProjectID_CommittedCost),
				"Committed cost lines are displayed after progress subcontract which is not expected");

	}

	@FindBy(xpath = "//*[text()='SIS system parameters']")

	WebElement SISsystemparameters_PCMSubModule;

	public void clickSISsystemparameters_PCMSubModule() throws InterruptedException {

		common.clickElement(SISsystemparameters_PCMSubModule);

	}

	/*
	 * @FindBy(xpath =
	 * "//*[@data-dyn-title='Project management and accounting parameters']")
	 * WebElement Projectmanagementandaccountingparameters_PMA;
	 * 
	 * @FindBy(xpath = "//*[@data-dyn-title='Project management and accounting']")
	 * WebElement Projectmanagementandaccounting;
	 * 
	 * 
	 */

	@FindBy(xpath = "//*[@data-dyn-title='Vendor payment journal']")
	WebElement Vendorpaymentjournal_AP;

	@FindBy(xpath = "//*[text()='Accounts payable']")
	WebElement Accountspayable;

	public void selectModule(String arg1) throws InterruptedException {

		if (arg1.equals("Project cost management")) {

			common.clickElement(Projectcostmanagement);

		}

// Added by Monica						
		if (arg1.equals("Procurement and Sourcing")) {

			common.clickElement(Procurementandsourcing);

		}

		if (arg1.equals("Product information management")) {

			common.clickElement(Productinformationmanagement);

			Thread.sleep(3000);

		}

		if (arg1.equals("Equipment usage")) {

			common.clickElement(Equipmentusage);

		}
		if (arg1.equals("Project Management and Accounting")) {

			common.clickElement(Projectmanagementandaccounting);

		}

		if (arg1.equals("Accounts payable")) {

			common.clickElement(Accountspayable);

		}
	}

	@FindBy(xpath = "(//*[text()='Cost control'])[1]")
	WebElement Costcontrol_PMA1;

	@FindBy(xpath = "(//*[text()='Cost control'])[2]")
	WebElement Costcontrol_PMA2;

	public void clickCostcontrol_PMA() throws InterruptedException {

		try {
			common.clickElement(Costcontrol_PMA1);
		} catch (Exception e) {
			common.clickElement(Costcontrol_PMA2);
		}
	}

	@FindBy(xpath = "//*[text()='Cost commitments']")
	WebElement Costcommitments_Fasttab;

	public void checkCostcommitments_FasttabIsExpanded() throws InterruptedException {

		if (!common.isSectionExpanded(Costcommitments_Fasttab)) {

			common.clickElement(Costcommitments_Fasttab);

			Thread.sleep(3000);
		}
	}

	@FindBy(xpath = "//*[text()='Purchase order']//following::*[contains(@aria-labelledby,'CommittedCostPurchaseOrder')]")
	WebElement Purchaseorder_PMAParameter;

	@FindBy(xpath = "//*[text()='Vendor invoice']//following::*[contains(@aria-labelledby,'CommittedCostVendInvoice')]")
	WebElement Vendorinvoice_PMAParameter;

	public void checkCommittedCostData_PMAParameter() {

		boolean PurchaseOrderToggle = Purchaseorder_PMAParameter.getAttribute("aria-checked").equals("true");

		Assert.assertTrue(PurchaseOrderToggle, "Purchase order toggle is not on as expected");

		boolean VendorInvoiceToggle = Vendorinvoice_PMAParameter.getAttribute("aria-checked").equals("true");

		Assert.assertTrue(VendorInvoiceToggle, "Vendor invoice toggle is not on as expected");

	}

	// Create customer change order and add to construction contract
	// Added by Carolin

	@FindBy(xpath = "(//*[text()='Customer change orders'])")
	WebElement Customerchangeorders;

	@FindBy(xpath = "(//*[text()='Customer change orders'])[2]")
	WebElement Customerchangeorders2;

	public void clickCustomerchangeorders() throws InterruptedException {

		try {
			common.clickElement(Customerchangeorders);
		}

		catch (Exception e) {
			common.clickElement(Customerchangeorders2);
		}

	}

	@FindBy(xpath = "//*[@name='Overview_ChangeOrderNo']")
	WebElement Customerchangeorderno;

	public void setCustomerchangeorderno(String value) throws InterruptedException {

		CustomerChangeOrderNo = value;
		logger.info("Customer Change Order No: " + CustomerChangeOrderNo);
		common.setText(Customerchangeorderno, value);

	}

//			public String getCustomerchangeorderno() throws InterruptedException {
	//
//				CustomerChangeOrderNo = common.getValue(Customerchangeorderno);
//				logger.info("Customer Change Order No: " + CustomerChangeOrderNo);
//				logger.info("CustomerChangeOrderNo : "+CustomerChangeOrderNo);
//				return CustomerChangeOrderNo;
//			}

	@FindBy(xpath = "//*[@name='Overview_ChangeOrderCustApprovedDate']")
	WebElement Overview_ChangeOrderCustApprovedDate;

	@FindBy(xpath = "//*[@name='Overview_ApprovedDateTime']")
	WebElement Overview_ApprovedDateTime;

	@FindBy(xpath = "//*[@name='Overview_Description']")
	WebElement Overview_Description;

	public void setOverview_ChangeOrderCustApprovedDate() throws InterruptedException {

		String date = common.getCurrentDate();
		common.setTextAfterDelete(Overview_ChangeOrderCustApprovedDate, date);
	}

	public void validateApproveDate() throws InterruptedException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");

		LocalDateTime now = LocalDateTime.now();

		String TodayDate = dtf.format(now);

		String ApproveDateTime = common.getValue(Overview_ChangeOrderCustApprovedDate);

		if (ApproveDateTime.contains(TodayDate)) {

			Assert.assertTrue(true);
			logger.info("Approved date is as expected");
		} else {

			Assert.fail(
					"Approved date is 'NOT' as expected. Expected: " + TodayDate + " " + "Actual: " + ApproveDateTime);
			logger.info(
					"Approved date is 'NOT' as expected. Expected: " + TodayDate + " " + "Actual: " + ApproveDateTime);

		}
	}

	public void getProjectDescription() throws InterruptedException {

		ProjectDescription = common.getValue(Overview_Description);

	}

	@FindBy(xpath = "//*[@name='Overview_Status']")
	WebElement Overview_Status;

	public String getOverview_Status() throws InterruptedException {

		Thread.sleep(4000);

		String CustomerChangeOrder_OverviewStatus = common.getValue(Overview_Status);

		logger.info("Customer Change order Overview Status: " + CustomerChangeOrder_OverviewStatus);

		logger.info("Customer Change order Overview Status: " + CustomerChangeOrder_OverviewStatus);
		return CustomerChangeOrder_OverviewStatus;
	}

	public void checkChangeOrderStatus(String status) throws InterruptedException {

		logger.info("Customer Change order Overview Expected Status: " + status);
		logger.info("Customer Change order Overview Actual Status: " + getOverview_Status());
		Assert.assertEquals(getOverview_Status(), status, "Overview Change Order is not in " + status + "Status");

	}

	// To open fast tabs after checking if not opened (Re-usable function)

	public void clickFastTab(String strFastTabName) throws InterruptedException {

		WebElement fastTabElement = ldriver.findElement(By.xpath("//*[text()='" + strFastTabName + "']"));

		if (!common.isSectionExpanded(fastTabElement)) {

			// common.clickElement(fastTabElement);
			common.clickElementJS(fastTabElement);
		}
	}

//			@FindBy(xpath = "//*[contains(@class,'isFilterable') and contains(@id,'ListPageGrid_ChangeOrderId') ]/child::*[not(contains(@title,'Change order Id'))]")
//			WebElement ChangeOrderId_Search;

	@FindBy(xpath = "(//*[contains(@class,'isFilterable') and contains(@id,'ListPageGrid_ChangeOrderId')])[1]")
	WebElement ChangeOrderId_Search1;

	@FindBy(xpath = "(//*[contains(@class,'isFilterable') and contains(@id,'ListPageGrid_ChangeOrderId')])[2]")
	WebElement ChangeOrderId_Search2;

	public void clickChangeOrderID() throws InterruptedException {

		try {
			common.clickElement(ChangeOrderId_Search1);
		}

		catch (Exception e) {
			common.clickElement(ChangeOrderId_Search2);
		}

	}

	public void getChangeOrderIdFromBudegetRevisions(String strRevision) throws InterruptedException {

		ChangeOrderIdValue = changeOrderId.get(strRevision);

	}

	public void setChangeOrderStatus(String strStatus) throws InterruptedException {

		common.clickElement(Overview_Status);
		common.selectDropDownValue(strStatus);
		logger.info("The Customer Change order status is : " + common.getValue(Overview_Status));

	}

	@FindBy(xpath = "(//span[normalize-space()='Add to Construction contract'])[2]")
	WebElement AddtoConstructioncontract2;

	@FindBy(xpath = "(//span[normalize-space()='Add to Construction contract'])[1]")
	WebElement AddtoConstructioncontract1;

	public void clickAddtoConstructioncontract() throws InterruptedException {

		try {

			common.clickElement(AddtoConstructioncontract1);
		} catch (Exception e) {

			common.clickElement(AddtoConstructioncontract2);
		}
	}

	// Modified for the scenario Create customer change order and add to constuction
	// contract

	/*
	 * public void selectSearchOptions(String arg1) throws InterruptedException { if
	 * (arg1.equals("ProjectID")) { clickProjectID(); } if
	 * (arg1.equals("Task Description")) { clickJobdescription(); } if
	 * (arg1.equals("Batch Job ID")) { clickBatchjobID(); } if
	 * (arg1.equals("Category Id")) { clickCategoryID(); }
	 * 
	 * // Added by Carolin if (arg1.equals("Change order Id")) {
	 * 
	 * // Thread.sleep(4000); clickChangeOrderID(); }
	 * 
	 * if (arg1.equals("Invoice")) {
	 * 
	 * clickInvoice();
	 * 
	 * }
	 * 
	 * if (arg1.equals("Date")) {
	 * 
	 * setDate_Postedprojecttransactions();
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public void setFilterField(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("ProjectID")) {
	 * 
	 * logger.info("Project ID: " + ProjectID_Journal);
	 * 
	 * setFilterFieldText(ProjectID_Journal);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Task Description")) {
	 * 
	 * setFilterFieldText(TaskDescription_RefreshProjFinData);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Batch Job ID")) {
	 * 
	 * setFilterFieldText(JobID);
	 * 
	 * }
	 * 
	 * if (arg1.equals("Category Id")) {
	 * 
	 * setFilterFieldText(CategoryID);
	 * 
	 * }
	 * 
	 * 
	 * // Added by Carolin if (arg1.equals("Change order Id")) {
	 * 
	 * setFilterFieldText(ChangeOrderIdValue); }
	 * 
	 * 
	 * if (arg1.equals("Invoice")) {
	 * 
	 * setFilterFieldText(VendorInvoices.get("1"));
	 * 
	 * }
	 * 
	 * if (arg1.equals("Current Period")) {
	 * 
	 * setFilterFieldText(common.getCurrentMonthEndDate());
	 * 
	 * }
	 * 
	 * if (arg1.equals("Next Period")) {
	 * 
	 * setFilterFieldText(common.getNextMonthEndDate());
	 * 
	 * }
	 * 
	 * if (arg1.equals("Invoice_CustomerPayment")) {
	 * 
	 * setFilterFieldText(InvoiceJournalIDValue);
	 * 
	 * } }
	 */

	@FindBy(xpath = "//*[@aria-label='Budget category' and contains(@id, 'GridTaskList_BudgetCategoryId')]")
	List<WebElement> NumberofLinesInTaskSummary;

	public int getNumberofLinesInTaskSummary() throws InterruptedException {

		return NumberofLinesInTaskSummary.size();

	}

	public ArrayList<ArrayList<String>> getTaskSummaryTableValues() throws InterruptedException {

		Thread.sleep(5000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();

		for (int row = 1; row <= getNumberofLinesInTaskSummary(); row++) {

			logger.info("Number of lines in Task Summary: " + getNumberofLinesInTaskSummary());

			WebElement BudgetCategory = ldriver.findElement(
					By.xpath("(//*[@aria-label='Budget category' and contains(@id,'GridTaskList_BudgetCategoryId')])["
							+ row + "]"));

			String BudgetCategoryValue = common.getValue(BudgetCategory);
			data.add(BudgetCategoryValue);

			WebElement Taskcode = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			String TaskcodeValue = common.getValue(Taskcode);
			data.add(TaskcodeValue);

			WebElement Quantity = ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));

			String QuantityValue = common.getValue(Quantity);
			data.add(QuantityValue);

//					WebElement Unit = ldriver.findElement(By.xpath("(//*[@aria-label='Unit'])[" + row + "]"));
			//
//					String UnitValue = common.getValue(Unit);

			WebElement Budgetamount = ldriver.findElement(By.xpath("(//*[@aria-label='Budget amount'])[" + row + "]"));

			String BudgetamountValue = common.getValue(Budgetamount);

			data.add(BudgetamountValue);

			dataSet.add(new ArrayList<String>(data));

			data.clear();

			common.clickElement(BudgetCategory);
			common.KeyboardAction("Down");

		}

		logger.info(dataSet);
		return dataSet;
	}

//			@FindBy(xpath = "//*[@aria-label='Line num' and contains(@id, 'GridProjLines_LineNum')]")
//			List<WebElement> NumberofLinesInOverviewTab_ConstructionContract;
	//
//			public int getNumberofLinesInOverview_ConstructionContract() throws InterruptedException {
//				
//				return NumberofLinesInOverviewTab_ConstructionContract.size();
	//
//			}

	public void checkNewlyAddedChangeOrderInConstructionContract() throws InterruptedException {

		Thread.sleep(5000);

		String SVquantity_Expected = "";
		String Unitprice_Expected = "";

		strDescription = "CO# " + CustomerChangeOrderNo + ": " + ProjectDescription;

		int NoOfRows = ldriver
				.findElements(By.xpath("//*[contains(@id,'GridProjLines_Description') and @aria-label='Description']"))
				.size();

		logger.info("No of rows :" + NoOfRows);
		int i;
		for (i = 1; i <= NoOfRows; i++) {
			// logger.info("Value of I: "+i);
			WebElement rowElement = ldriver.findElement(By.xpath(
					"(//*[contains(@id,'GridProjLines_Description') and @aria-label='Description'])[" + i + "]"));

			String rowElementValue = common.getValue(rowElement);

			if (!rowElementValue.equals(strDescription)) {
				logger.info("rowElementValue: " + rowElementValue);
				common.clickElement(rowElement);
				common.KeyboardAction("Down");
			}

			else {
				break;
			}
		}

		WebElement Description = ldriver.findElement(By.xpath("//*[@value='" + strDescription + "']"));

		String DescriptionValue = common.getValue(Description);
		logger.info("Newly added customer change order Description : " + DescriptionValue);

		WebElement BillingBasis = ldriver.findElement(By.xpath("(//*[@aria-label='Billing basis'])[" + i + "]"));

		String BillingBasisValue = common.getValue(BillingBasis);

//				WebElement BillingBasis = ldriver.findElement(
//						By.xpath("//*[@value='"+strDescription +"']//following::*[@aria-label='Billing basis']"));
//				
//				String BillingBasisValue = common.getValue(BillingBasis);

		logger.info("Billing basis : " + BillingBasisValue);

		if (BillingBasisValue.equals(BillingDefaultBasis_SISParameterTable)) {

			SVquantity_Expected = "0.00";
			Unitprice_Expected = "0.00";

		} else {

			ArrayList<ArrayList<String>> BudgetLineData = TaskSummary_Expected.get("BudgetLines_Revision1");

			for (ArrayList<String> Dataline : BudgetLineData) {

				String BudgetCategory = Dataline.get(0);
				if (BudgetCategory.equals("Revenue")) {
					SVquantity_Expected = Dataline.get(2);
					String BudgetAmount = Dataline.get(3);
					Unitprice_Expected = formulas.getDivision(BudgetAmount, SVquantity_Expected);
				}
			}

		}

		WebElement LineNumber = ldriver.findElement(By.xpath("(//*[@aria-label='Line num'])[" + i + "]"));

		String LineNumberValue = common.getValue(LineNumber);
		Assert.assertEquals(LineNumberValue, constructionContractLineNum_CustomerChangeOrderPg,
				"Line number in Construction Contract is NOT as expected.");

		logger.info("Line number in Construction Contract is as expected.");

		WebElement SVquantity = ldriver.findElement(By.xpath("(//*[@aria-label='SV quantity'])[" + i + "]"));

		String SVquantityValue = common.getValue(SVquantity);
		Assert.assertEquals(SVquantityValue, SVquantity_Expected,
				"SV Quantity in Construction Contract is NOT as expected.");

		logger.info("SV quantity in Construction Contract is as expected.");

		WebElement Unitprice = ldriver.findElement(By.xpath("(//*[@aria-label='Unit price'])[" + i + "]"));

		String UnitpriceValue = common.getValue(Unitprice);
		Assert.assertEquals(UnitpriceValue, Unitprice_Expected,
				"Unit price in Construction Contract is NOT as expected.");

		logger.info("Unit price in Construction Contract is as expected.");

		// Scheduled Value- need to be added

		WebElement ScheduledValue = ldriver.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + i + "]"));

		String ScheduledvalueValue = common.getValue(ScheduledValue);
		Assert.assertEquals(ScheduledvalueValue, RevenueBudgetValue_Expected,
				"Scheduled value in Construction Contract is NOT as expected.");

		logger.info("Scheduled value in Construction Contract is as expected.");
	}

	// Changed for the scenario Create customer change order and add to construction
	// contract

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } if (arg1.equals("ECAC")) { clickECAC(); }
	 * 
	 * if (arg1.equals("Project change order")) { clickProjectchangeorder1(); } //
	 * Added by Carolin if (arg1.equals("Customer change orders")) {
	 * 
	 * clickCustomerchangeorders(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * common.clickElement(Postedtransactions);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Control")) {
	 * 
	 * if (arg1.equals("Committed Cost")) {
	 * 
	 * common.clickElement(Committedcost);
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Bill")) {
	 * 
	 * if (arg1.equals("Invoice journals")) {
	 * 
	 * Thread.sleep(5000);
	 * 
	 * clickInvoiceJournal();
	 * 
	 * } } }
	 */

	@FindBy(xpath = "//*[text()='SIS system parameters']")
	WebElement SISsystemparameters;

	// Modified by Carolin For Create customer change order and add to construction
	// contract -16th scenario

	public void selectSubModule(String arg1) throws InterruptedException {

		if (arg1.equals("All projects")) {

			common.clickElement(Allprojects);
		}

		// Added by Monica

		if (arg1.equals("Project allocation rules")) {

			common.clickElement(Projectallocationrules_PCMSubModule);

			Thread.sleep(3000);

		}
		// Added by Monica on 3/2/23

		if (arg1.equals("Refresh project financial data")) {

			common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);

			Thread.sleep(1000);
		}
		if (arg1.equals("Project cost management")) {

			common.clickElement(Projectcostmanagement_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("My projects")) {

			common.clickElement(Myprojects_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project contracts")) {

			common.clickElement(Projectcontracts_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project budgets")) {

			common.clickElement(Projectbudgets_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project change order")) {

			common.clickElement(Projectchangeorder_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("ECAC")) {

			common.clickElement(ECAC_PCMSubModuleProjBudget);

			Thread.sleep(1000);
		}

		if (arg1.equals("Summary ECAC - request")) {

			common.clickElement(SummaryECACrequest_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Set ECAC to actual")) {

			common.clickElement(SetECACtoactual_PCMSubModuleProjBudget);

			Thread.sleep(1000);
		}

		if (arg1.equals("Customer change orders")) {

			common.clickElement(Customerchangeorders_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Construction contracts")) {

			common.clickElement(Constructioncontracts_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Construction applications")) {

			common.clickElement(Constructionapplications_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Subcontracts")) {

			common.clickElement(Subcontracts_PCMSubModuleSubcontracts);

			Thread.sleep(1000);
		}

		if (arg1.equals("All vendors")) {

			common.clickElement(Allvendors_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Loss making project")) {

			common.clickElement(Lossmakingproject_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Loss making audit trail")) {

			common.clickElement(Lossmakingaudittrail_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Revenue recognition audit trail")) {

			common.clickElement(Revenuerecognitionaudittrail_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project allocation rates")) {

			common.clickElement(Projectallocationrates_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Overhead transaction inquiry")) {

			common.clickElement(Overheadtransactioninquiry_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO template excel export")) {

			common.clickElement(PFOtemplateexcelexport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO template excel import")) {

			common.clickElement(PFOtemplateexcelimport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PCA template excel export")) {

			common.clickElement(PCAtemplateexcelexport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PCA template excel import")) {

			common.clickElement(PCAtemplateexcelimport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Refresh project financials data")) {

			common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Refresh PCA data")) {

			common.clickElement(RefreshPCAdata_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project dimension setup table update")) {

			common.clickElement(Projectdimensionsetuptableupdate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Delete project financial data")) {

			common.clickElement(Deleteprojectfinancialdata_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO & PCA data refresh")) {

			common.clickElement(PFOPCAdatarefresh_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Refresh project cost by cost type")) {

			common.clickElement(Refreshprojectcostbycosttype_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PCA batch history")) {

			common.clickElement(PCAbatchhistory_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project budget Import")) {

			common.clickElement(ProjectbudgetImport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Import budget from excel")) {

			common.clickElement(Importbudgetfromexcel_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Approve budgets")) {

			common.clickElement(Approvebudgets_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Commit approved budgets")) {

			common.clickElement(Commitapprovedbudgets_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Verify subcontract compliance")) {

			common.clickElement(Verifysubcontractcompliance_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Release invoices")) {

			common.clickElement(Releaseinvoices_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Create construction contract template")) {

			common.clickElement(Createconstructioncontracttemplate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Import construction contract from excel")) {

			common.clickElement(Importconstructioncontractfromexcel_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Create ECAC import template")) {

			common.clickElement(CreateECACimporttemplate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Import ECAC from excel")) {

			common.clickElement(ImportECACfromexcel_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Approve ECAC")) {

			common.clickElement(ApproveECAC_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Commit approved ECAC")) {

			common.clickElement(CommitapprovedECAC_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Set ECAC to actual")) {

			common.clickElement(SetECACtoactual_PCMSubModuleECAC);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project cost analysis BI data provider")) {

			common.clickElement(ProjectcostanalysisBIdataprovider_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Production performance BI")) {

			common.clickElement(ProductionperformanceBI_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Last labor date update")) {

			common.clickElement(Lastlabordateupdate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Last invoice date update")) {

			common.clickElement(Lastinvoicedateupdate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Time and material percent complete")) {

			common.clickElement(Timeandmaterialpercentcomplete_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Time and material percent complete audit trail")) {

			common.clickElement(Timeandmaterialpercentcompleteaudittrail_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PCA inquiry")) {

			common.clickElement(PCAinquiry_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO Inquiry")) {

			common.clickElement(PFOInquiry_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project summary inquiry")) {

			common.clickElement(Projectsummaryinquiry_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Orphan PFO inquiry")) {

			common.clickElement(OrphanPFOinquiry_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project WIP")) {

			common.clickElement(ProjectWIP_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project summary report")) {

			common.clickElement(Projectsummaryreport_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project cost analysis")) {

			common.clickElement(Projectcostanalysis_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project sales value analysis")) {

			common.clickElement(Projectsalesvalueanalysis_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Revenue recognition preview")) {

			common.clickElement(Revenuerecognitionpreview_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project key performance indicators")) {

			common.clickElement(Projectkeyperformanceindicators_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project ECAC revision history")) {

			common.clickElement(ProjectECACrevisionhistory_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project ECAC margin trend")) {

			common.clickElement(ProjectECACmargintrend_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Customer aging report by project")) {

			common.clickElement(Customeragingreportbyproject_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Vendor aging report by project")) {

			common.clickElement(Vendoragingreportbyproject_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project transaction by contract line")) {

			common.clickElement(Projecttransactionbycontractline_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project actual transactions")) {

			common.clickElement(Projectactualtransactions_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project 360")) {

			common.clickElement(Project360_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Task code by project")) {

			common.clickElement(Taskcodebyproject_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Production performance")) {

			common.clickElement(Productionperformance_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("SOV worksheet")) {

			common.clickElement(SOVworksheet_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Orphan project categories")) {

			common.clickElement(Orphanprojectcategories_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project open invoices")) {

			common.clickElement(Projectopeninvoices_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project customer invoices overdue")) {

			common.clickElement(Projectcustomerinvoicesoverdue_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PCM - Customer account statement")) {

			common.clickElement(PCMCustomeraccountstatement_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("SIS system parameters")) {

			common.clickElement(SISsystemparameters_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project cost management parameters")) {

			common.clickElement(Projectcostmanagementparameters_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project cost management workflow")) {

			common.clickElement(Projectcostmanagementworkflow_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project default dimension setup")) {

			common.clickElement(Projectdefaultdimensionsetup_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO inquiry column setup")) {

			common.clickElement(PFOinquirycolumnsetup_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("PFO inquiry template")) {

			common.clickElement(PFOinquirytemplate_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Budget categories")) {

			common.clickElement(Budgetcategories_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Task codes")) {

			common.clickElement(Taskcodes_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project task - hour sales price")) {

			common.clickElement(Projecttaskhoursalesprice_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project task templates")) {

			common.clickElement(Projecttasktemplates_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Vendor speciality")) {

			common.clickElement(Vendorspeciality_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Compliance type")) {

			common.clickElement(Compliancetype_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Vendor evaluation criteria")) {

			common.clickElement(Vendorevaluationcriteria_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Last labor project category setup")) {

			common.clickElement(Lastlaborprojectcategorysetup_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Work sites")) {

			common.clickElement(Worksites_PCMSubModule);

			Thread.sleep(1000);
		}

		if (arg1.equals("Priority Search")) {

			common.clickElement(PrioritySearch_PCMSubModule);

			Thread.sleep(1000);
		}

		// Added by Carolin
		if (arg1.equals("SIS system parameters")) {

			common.clickElement(SISsystemparameters);

			Thread.sleep(1000);
		}

		if (arg1.equals("Project management and accounting parameters")) {

			common.clickElement(Projectmanagementandaccountingparameters_PMA);

			Thread.sleep(1000);

		}

		if (arg1.equals("Vendor payment journal")) {

			common.clickElement(Vendorpaymentjournal_AP);

		}

	}

	@FindBy(xpath = "//*[text()='Project cost management' and contains(@id,'sisparametertable_')]")
	WebElement Projectcostmanagement_sisparameter;

	@FindBy(xpath = "//*[@name='SISParameterTable_BillingDefaultBasis']")
	WebElement SISParameterTable_BillingDefaultBasis;

	public void getDefaultBillingBasis() throws InterruptedException {

		clickExpandthenavigationpane();
		clickModules();
		selectModule("Project cost management");
		// clickExpandall();
		selectSubModule("SIS system parameters");
		common.clickElement(Projectcostmanagement_sisparameter);
		Thread.sleep(4000);
		clickFastTab("Construction contracts");
		BillingDefaultBasis_SISParameterTable = common.getValue(SISParameterTable_BillingDefaultBasis);
		logger.info("BillingDefaultBasis_SISParameterTable : " + BillingDefaultBasis_SISParameterTable);
		clickClose();
	}

	public void getExpectedTaskSummaryData(String TaskcodeValue, String BudgetcategoryValue, String QuantityValue,
			String LineAmountValue, String BudgetLinesData) {

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();
		ArrayList<String> Data = new ArrayList<String>();
		Data.add(BudgetcategoryValue);
		Data.add(TaskcodeValue);
		Data.add(formulas.getNumericValueFormatted(QuantityValue));
		Data.add(LineAmountValue);

		if (!TaskSummary_Expected.containsKey(BudgetLinesData)) {

			DataSet.add(new ArrayList<String>(Data));

			TaskSummary_Expected.put(BudgetLinesData, new ArrayList<ArrayList<String>>(DataSet));

			Data.clear();

			DataSet.clear();
		} else {
			DataSet = TaskSummary_Expected.get(BudgetLinesData);

			DataSet.add(new ArrayList<String>(Data));

			TaskSummary_Expected.put(BudgetLinesData, new ArrayList<ArrayList<String>>(DataSet));

			Data.clear();

			DataSet.clear();
		}

	}

	public void checkTaskSummary_CustomerChangeOrder(String BudgetRevision) throws InterruptedException {

		ArrayList<ArrayList<String>> taskSummary_Expected = TaskSummary_Expected.get(BudgetRevision);
		ArrayList<ArrayList<String>> taskSummary_Actual = getTaskSummaryTableValues();
		logger.info("TaskSummary Expected : " + taskSummary_Expected);
		logger.info("TaskSummary Actual : " + taskSummary_Actual);

		Assert.assertTrue(
				taskSummary_Expected.containsAll(taskSummary_Actual)
						&& taskSummary_Actual.containsAll(taskSummary_Expected),
				"Task Summary Data is NOT as expected");

	}

	@FindBy(xpath = "//*[@name='Overview_constructionContractDetailLineNum']")
	WebElement Overview_constructionContractDetailLineNum;

	public void getConstrctionContractLineNo() throws InterruptedException {

		Thread.sleep(5000);
		constructionContractLineNum_CustomerChangeOrderPg = common.getValue(Overview_constructionContractDetailLineNum);

		logger.info("ConstructionContractLineNum from CustomerChangeOrderPg :"
				+ constructionContractLineNum_CustomerChangeOrderPg);
	}

	// Added by carolin for Add customer change order to CC
	@FindBy(xpath = "(//*[text()='Edit'])[3]")
	WebElement Edit3;

	public void clickEdit() throws InterruptedException {

		try {

			common.clickElement(Edit1);
		}

		catch (Exception e) {

			try {

				common.clickElement(Edit2);

			} catch (Exception e2) {

				common.clickElement(Edit3);
			}
		}

		Thread.sleep(2000);
	}

	/*
	 * public void setSubContract(String SubcontractData) throws
	 * InterruptedException, IOException {
	 * 
	 * getSubcontract(SubcontractData);
	 * 
	 * int row = 1;
	 * 
	 * SubContract_NetAmount = new HashMap<String, String>();
	 * 
	 * for (ArrayList<String> SubContract : SubContracts) {
	 * 
	 * String TaskCodeValue = SubContract.get(0);
	 * 
	 * String ProjectCategoryValue = SubContract.get(1);
	 * 
	 * String ProcurementCategoryValue = SubContract.get(2);
	 * 
	 * String QuantityValue = SubContract.get(3);
	 * 
	 * String UnitPriceValue = SubContract.get(4);
	 * 
	 * clickNewSubConractLine();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * WebElement SVLine =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='SV line#'])[" + row + "]"));
	 * 
	 * String SVLineValue = common.getValue(SVLine);
	 * 
	 * WebElement Category =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Category'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(Category, ProjectCategoryValue);
	 * 
	 * WebElement TaskCode =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Task code'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(TaskCode, TaskCodeValue);
	 * 
	 * WebElement ProcurementCategory = ldriver.findElement(By.xpath(
	 * "//*[contains(@id,'ProcurementCategory') and @aria-label='Procurement category']["
	 * + row + "]"));
	 * 
	 * common.setTextAfterDelete(ProcurementCategory, ProcurementCategoryValue);
	 * 
	 * WebElement Quantity =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Quantity'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(Quantity, QuantityValue);
	 * 
	 * WebElement UnitPrice =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Unit price'][" + row + "]"));
	 * 
	 * common.setTextAfterDelete(UnitPrice, UnitPriceValue);
	 * 
	 * WebElement NetAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Net amount'][" + row + "]"));
	 * 
	 * String NetAmountValue = common.getValue(NetAmount);
	 * 
	 * checkLineAmount(QuantityValue, UnitPriceValue, NetAmountValue, row);
	 * 
	 * common.setTextAfterDelete(Category, ProjectCategoryValue);
	 * 
	 * // row++;
	 * 
	 * setSubcontractNetAmount(TaskCodeValue, ProjectCategoryValue, NetAmountValue);
	 * 
	 * getExpectedCommittedCostData(SubcontractData, TaskCodeValue,
	 * ProjectCategoryValue, QuantityValue, UnitPriceValue, NetAmountValue);
	 * 
	 * getExpectedPurchaseOrderData(SubcontractData, SVLineValue, TaskCodeValue,
	 * ProjectCategoryValue, QuantityValue, UnitPriceValue, NetAmountValue); }
	 * 
	 * logger.info("SubContract NetAmount: " + SubContract_NetAmount);
	 * 
	 * logger.info("Expected SubContract Committed Cost Data: " +
	 * SubContractCommittedCost_Expected);
	 * 
	 * logger.info("SubContract ExpectedPurchaseOrderData Data: " +
	 * PurchaseOrder_Expected);
	 * 
	 * clickSave();
	 * 
	 * }
	 * 
	 * public void getSubcontract(String SubcontractData) throws IOException {
	 * 
	 * if (SubcontractData.equals("SubContract_Original")) {
	 * 
	 * SubContracts = rd.getXl_SubContract(); } else if
	 * (SubcontractData.equals("SubContract_Revision1")) {
	 * 
	 * SubContracts = rd.getXl_SubContract_Revision1(); } }
	 */

	public void getExpectedCommittedCostData(String SubcontractData, String TaskCodeValue, String ProjectCategoryValue,
			String QuantityValue, String UnitPriceValue, String NetAmountValue) {

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();
		ArrayList<String> Data = new ArrayList<String>();
		Data.add("true");
		Data.add(ProjectIDValue);
		Data.add(TaskCodeValue);
		Data.add(ProjectCategoryValue);
		Data.add(formulas.getNumericValueFormatted(QuantityValue));
		Data.add(formulas.getNumericValueFormatted(UnitPriceValue));
		Data.add(NetAmountValue);
		Data.add("Purchase order");
		Data.add(VendorAccountValue);

		if (!SubContractCommittedCost_Expected.containsKey(SubcontractData)) {
			DataSet.add(new ArrayList<String>(Data));
			SubContractCommittedCost_Expected.put(SubcontractData, new ArrayList<ArrayList<String>>(DataSet));
			Data.clear();
			DataSet.clear();
		} else {
			DataSet = SubContractCommittedCost_Expected.get(SubcontractData);
			DataSet.add(new ArrayList<String>(Data));
			SubContractCommittedCost_Expected.put(SubcontractData, new ArrayList<ArrayList<String>>(DataSet));
			Data.clear();
			DataSet.clear();
		}
	}

	public void getExpectedPurchaseOrderData(String SubcontractData, String SVLineValue, String TaskCodeValue,
			String ProjectCategoryValue, String QuantityValue, String UnitPriceValue, String NetAmountValue) {

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		Data.add(SVLineValue);
		Data.add(TaskCodeValue);
		Data.add(formulas.getNumericValueFormatted(QuantityValue));
		Data.add(formulas.getNumericValueFormatted(UnitPriceValue));
		Data.add(NetAmountValue);

		if (!PurchaseOrder_Expected.containsKey(SubcontractData)) {
			DataSet.add(new ArrayList<String>(Data));
			PurchaseOrder_Expected.put(SubcontractData, new ArrayList<ArrayList<String>>(DataSet));
			Data.clear();
			DataSet.clear();

		} else {
			DataSet = PurchaseOrder_Expected.get(SubcontractData);
			DataSet.add(new ArrayList<String>(Data));
			PurchaseOrder_Expected.put(SubcontractData, new ArrayList<ArrayList<String>>(DataSet));
			Data.clear();
			DataSet.clear();

		}

	}

	@FindBy(xpath = "//*[contains(@id,'ChangeOrderTable') and text()='New']")
	WebElement New_Changeorder;

	public void clickNew_SubChangeOrder() throws InterruptedException {

		common.clickElement(New_Changeorder);

	}

	@FindBy(xpath = "//*[contains(@id,'ChangeOrderNum') and contains(@name,'ChangeOrderNum')]")
	WebElement Changeorderno;

	public void getSubContractChangeOrderNo() throws InterruptedException {

		common.waitForElement(Changeorderno);

		// String ChangeordernoValue=common.getValue(Changeorderno);

		SubContract_ChangeOrderNumber = new ArrayList<String>();

		SubContract_ChangeOrderNumber.add(common.getValue(Changeorderno));

		logger.info("Change order no:  " + SubContract_ChangeOrderNumber);

	}

	@FindBy(xpath = "(//*[contains(@id,'PurchId_input')])[1]")
	WebElement PurchaseOrder;

	public void clickPurchaseOrder() throws InterruptedException {

		common.clickElement(PurchaseOrder);

	}

	@FindBy(xpath = "//*[contains(@id,'ApprovalStatus_input')]")
	WebElement ConfirmedStatus;

	public String getApprovalStatus() throws InterruptedException {

		String ActualStatus = common.getValue(ConfirmedStatus);

		return ActualStatus;
	}

	public void checkApprovalStatus(String Status) throws InterruptedException {

		logger.info("Subcontract Approval status expected: " + Status);

		String ActualStatus = getApprovalStatus();

		logger.info("Subcontract Approval status Actual: " + ActualStatus);

		Assert.assertEquals(ActualStatus, Status, "Subcontract Approval status is not as expected");

	}

	@FindBy(xpath = "//*[contains(@id,'ChangeOrderDate') and contains(@name,'ChangeOrderDate')]")
	WebElement ChangeOrderDate;

	public void setChangeOrderDate() throws InterruptedException {

		String ChangeOrderDateValue = common.getCurrentDate();

		common.setText(ChangeOrderDate, ChangeOrderDateValue);
	}

	@FindBy(xpath = "//*[contains(@id,'PurchStatus') and contains(@aria-describedby,'PurchStatus')]")
	WebElement OpenOrderStatus;

	public String getPurchaseOrderStatus() throws InterruptedException {

		common.waitForElement(OpenOrderStatus);

		String ActualStatus = common.getValue(OpenOrderStatus);

		return ActualStatus;
	}

	public void checkPurchaseOrderStatus(String Status) throws InterruptedException {

		logger.info("Subcontract Purchase Order expected: " + Status);

		logger.info("Subcontract Purchase Order status Actual: " + getPurchaseOrderStatus());

		Assert.assertEquals(getPurchaseOrderStatus(), Status, "Subcontract Purchase Order status is not as expected");

	}

	@FindBy(xpath = "//*[contains(@id,'SVLineNum') and (@aria-label='SV line#')]")
	List<WebElement> NumberofLinesInSubContractChangeOrder;

	public int getNumberofLinesInSubContractChangeOrder() throws InterruptedException {

		return NumberofLinesInSubContractChangeOrder.size();

	}

	public ArrayList<String> getSubContractLineNumber() throws InterruptedException {

		Thread.sleep(3000);

		ArrayList<String> SVLineValue = new ArrayList<String>();

		for (int row = 1; row <= getNumberofLinesInSubContractChangeOrder(); row++) {

			WebElement SVLine = ldriver.findElement(By.xpath("(//*[@aria-label='SV line#'])[" + row + "]"));

			SVLineValue.add(common.getValue(SVLine));

		}
		return SVLineValue;

	}

	@FindBy(xpath = "//*[contains(@id,'LineNumber') and @aria-label='Line number']")
	List<WebElement> NumberofLinesInSubContractPurchaseOrder;

	public int getNumberofLinesInSubContractPurchaseOrder() throws InterruptedException {

		return NumberofLinesInSubContractPurchaseOrder.size();

	}

	public ArrayList<ArrayList<String>> getPurchaseOrderTable() throws InterruptedException {

		Thread.sleep(9000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();

		// ArrayList<String> LineNumberValue=new ArrayList<String>();

		for (int row = 1; row <= getNumberofLinesInSubContractPurchaseOrder(); row++) {

			WebElement LineNumber = ldriver.findElement(By.xpath("(//*[@aria-label='Line number'])[" + row + "]"));

			String LineNumberValue = common.getValue(LineNumber);

//			WebElement Category = ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));			
//			
//			String CategoryValue = common.getValue(Category);	
//			
			WebElement Taskcode = ldriver
					.findElement(By.xpath("(//*[@aria-label='Task code' and contains(@id,'PurchLine')])[" + row + "]"));

			String TaskcodeValue = common.getValue(Taskcode);

			WebElement Quantity = ldriver
					.findElement(By.xpath("(//*[@aria-label='Quantity' and contains(@id,'PurchLine')])[" + row + "]"));

			String QuantityValue = common.getValue(Quantity);

			WebElement UnitPrice = ldriver.findElement(
					By.xpath("(//*[@aria-label='Unit price' and contains(@id,'PurchLine')])[" + row + "]"));

			String UnitPriceValue = common.getValue(UnitPrice);

			WebElement Netamount = ldriver.findElement(
					By.xpath("(//*[@aria-label='Net amount' and contains(@id,'PurchLine')])[" + row + "]"));

			String NetamountValue = common.getValue(Netamount);

			data.add(LineNumberValue);
			data.add(TaskcodeValue);
			data.add(QuantityValue);
			data.add(UnitPriceValue);
			data.add(NetamountValue);

			dataSet.add(new ArrayList<String>(data));

			data.clear();
		}
		// logger.info(dataSet);
		return dataSet;
	}

	public void checkPurchaseOrderLines(String SubcontractData) throws InterruptedException {

		ArrayList<ArrayList<String>> PurchaseOrderExpected = PurchaseOrder_Expected.get(SubcontractData);
		ArrayList<ArrayList<String>> PurchaseOrdeLines_Actual = getPurchaseOrderTable();
		logger.info("PurchaseOrder Expected : " + PurchaseOrderExpected);
		logger.info("PurchaseOrdeLines Actual : " + PurchaseOrdeLines_Actual);
		Assert.assertTrue(PurchaseOrdeLines_Actual.containsAll(PurchaseOrderExpected),
				"SubContract Change Order line values are not present in Purchase Order");

	}

	@FindBy(xpath = "//*[@aria-label='Task code' and contains(@id,'Taskcode')]")
	List<WebElement> NumberofLinesInCommittedCost;

	public int getNumberofLinesInCommittedCost() throws InterruptedException {

		return NumberofLinesInCommittedCost.size();

	}

	/*
	 * public ArrayList<ArrayList<String>> getCommittedCostTable() throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(9000); ArrayList<String> data = new ArrayList<String>();
	 * ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();
	 * 
	 * logger.info("NumberofLinesInCommittedCost: " +
	 * getNumberofLinesInCommittedCost());
	 * 
	 * for (int row = 1; row <= getNumberofLinesInCommittedCost(); row++) {
	 * 
	 * WebElement Open = ldriver .findElement(By.xpath("(//*[@aria-label='Open'])["
	 * + row + "]//child::*[@type='checkbox']"));
	 * 
	 * String OpenCheckbox; try { Open.getAttribute("Checked"); OpenCheckbox =
	 * "true"; } catch (Exception e) { OpenCheckbox = "false"; }
	 * 
	 * WebElement ProjectID = ldriver.findElement( By.
	 * xpath("(//*[@aria-label='Project ID' and not(contains(@id,'ProjTable'))])[" +
	 * row + "]"));
	 * 
	 * String ProjectIDValue = common.getValue(ProjectID);
	 * 
	 * WebElement Taskcode =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));
	 * 
	 * String TaskcodeValue = common.getValue(Taskcode);
	 * 
	 * WebElement Category =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));
	 * 
	 * String CategoryValue = common.getValue(Category);
	 * 
	 * WebElement Quantity =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));
	 * 
	 * String QuantityValue = common.getValue(Quantity);
	 * 
	 * WebElement CostPrice =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Cost price'])[" + row +
	 * "]"));
	 * 
	 * String CostPriceValue = common.getValue(CostPrice);
	 * 
	 * WebElement Costamount =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Cost amount'])[" + row +
	 * "]"));
	 * 
	 * String CostamountValue = common.getValue(Costamount);
	 * 
	 * WebElement Transactionorigin = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Transaction origin'])[" + row +
	 * "]"));
	 * 
	 * String TransactionoriginValue = common.getValue(Transactionorigin);
	 * 
	 * WebElement Vendor =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Vendor'])[" + row + "]"));
	 * 
	 * String VendorValue = common.getValue(Vendor);
	 * 
	 * data.add(OpenCheckbox); data.add(ProjectIDValue); data.add(TaskcodeValue);
	 * data.add(CategoryValue); data.add(QuantityValue); data.add(CostPriceValue);
	 * data.add(CostamountValue); data.add(TransactionoriginValue);
	 * data.add(VendorValue); dataSet.add(new ArrayList<String>(data));
	 * 
	 * data.clear(); }
	 * 
	 * logger.info(dataSet); return dataSet; }
	 */

	/*
	 * public ArrayList<ArrayList<String>> getCommittedCostTable() throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(9000); ArrayList<String> data = new ArrayList<String>();
	 * ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();
	 * 
	 * common.scrollIntoView(ProjectID_CommittedCost);
	 * 
	 * logger.info("NumberofLinesInCommittedCost: " +
	 * getNumberofLinesInCommittedCost());
	 * 
	 * for (int row = 1; row <= getNumberofLinesInCommittedCost(); row++) {
	 * 
	 * WebElement Open = ldriver .findElement(By.xpath("(//*[@aria-label='Open'])["
	 * + row + "]//child::*[@type='checkbox']"));
	 * 
	 * String OpenCheckbox; try { Open.getAttribute("Checked"); OpenCheckbox =
	 * "true"; } catch (Exception e) { OpenCheckbox = "false"; }
	 * 
	 * System.out.println("OpenCheckbox" + OpenCheckbox);
	 * 
	 * WebElement ProjectID =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Project ID'][" + row + "]"));
	 * 
	 * String ProjectIDValue = common.getValue(ProjectID);
	 * 
	 * WebElement Taskcode =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));
	 * 
	 * String TaskcodeValue = common.getValue(Taskcode);
	 * 
	 * WebElement Category =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));
	 * 
	 * String CategoryValue = common.getValue(Category);
	 * 
	 * WebElement Quantity =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));
	 * 
	 * String QuantityValue = common.getValue(Quantity);
	 * 
	 * WebElement CostPrice =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Cost price'])[" + row +
	 * "]"));
	 * 
	 * String CostPriceValue = common.getValue(CostPrice);
	 * 
	 * WebElement Costamount =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Cost amount'])[" + row +
	 * "]"));
	 * 
	 * String CostamountValue = common.getValue(Costamount);
	 * 
	 * WebElement Transactionorigin = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Transaction origin'])[" + row +
	 * "]"));
	 * 
	 * String TransactionoriginValue = common.getValue(Transactionorigin);
	 * 
	 * WebElement Vendor =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Vendor'])[" + row + "]"));
	 * 
	 * String VendorValue = common.getValue(Vendor);
	 * 
	 * data.add(OpenCheckbox); data.add(ProjectIDValue); data.add(TaskcodeValue);
	 * data.add(CategoryValue); data.add(QuantityValue); data.add(CostPriceValue);
	 * data.add(CostamountValue); data.add(TransactionoriginValue);
	 * data.add(VendorValue); dataSet.add(new ArrayList<String>(data));
	 * 
	 * data.clear(); }
	 * 
	 * logger.info(dataSet); return dataSet; }
	 */

	/*
	 * public void checkCommittedCostTable(String Subcontract) throws
	 * InterruptedException {
	 * 
	 * ArrayList<ArrayList<String>> CommittedCost_Expected =
	 * SubContractCommittedCost_Expected.get(Subcontract);
	 * ArrayList<ArrayList<String>> CommittedCost_Actual = getCommittedCostTable();
	 * logger.info("SubContractCommittedCost Expected : " +
	 * SubContractCommittedCost_Expected); logger.info("CommittedCost Actual : " +
	 * CommittedCost_Actual); Assert.assertEquals(CommittedCost_Actual,
	 * CommittedCost_Expected, "Committed Cost Data is NOT as expected"); }
	 */

	public void clickControlSection(String arg1) throws InterruptedException {

		if (arg1.equals("Committed cost")) {
			try {
				common.clickElement(Committedcost1);
			} catch (Exception e) {
				common.clickElement(Committedcost2);
			}
		}
	}

	/*
	 * public void checkSubContractAmount(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("SubContract_Original")) {
	 * 
	 * ExpectedSubcontractAmountValue =
	 * formulas.getExpectedSubContractAmount(SubContracts);
	 * 
	 * logger.info("ExpectedSubcontractAmountValue " +
	 * ExpectedSubcontractAmountValue);
	 * 
	 * logger.info("Actual SubcontractAmountValue " + getSubContractAmount());
	 * 
	 * Assert.assertEquals(getSubContractAmount(), ExpectedSubcontractAmountValue,
	 * "Sub contract amount is not as expected");
	 * 
	 * } }
	 */

	public void checkChangeOrderAmount(String arg1) throws InterruptedException {

		if (!arg1.equals("SubContract_Original")) {

			ExpectedChangeOrderAmountValue = formulas.getExpectedSubContractAmount(SubContracts);

			String ActualChangeOrderAmountValue = getChangeOrderAmount();

			logger.info("Expected ChangeOrderAmountValue " + ExpectedChangeOrderAmountValue);

			logger.info("Actual ChangeOrderAmountValue " + ActualChangeOrderAmountValue);

			Assert.assertEquals(ActualChangeOrderAmountValue, ExpectedChangeOrderAmountValue,
					"Sub contract Change Order amount is not as expected");

		}
	}

	public void checkSubContractTotal() throws InterruptedException {

		String ExpectedSubcontractTotalValue = formulas.getSum(ExpectedSubcontractAmountValue, getChangeOrderAmount());

		String ActualSubcontractTotalValue = getSubContractTotal();

		logger.info("Expected Subcontract Total Value " + ExpectedSubcontractTotalValue);

		logger.info("Actual Subcontract Total Value" + ActualSubcontractTotalValue);

		Assert.assertEquals(ActualSubcontractTotalValue, ExpectedSubcontractTotalValue,
				"Sub contract total is not as expected");

	}

	@FindBy(xpath = "//*[contains(@id,'SISSysBoxForm') and text()='Close']")
	WebElement CloseAlert;

	public void clickCloseAlert() {

		try {

			CloseAlert.isDisplayed();
			common.clickElement(CloseAlert);
		}

		catch (Exception e) {

		}

	}

	public void setHourJournalAndOverheadTransactionsValidation(String Period) throws InterruptedException {

		ArrayList<ArrayList<String>> Journals = new ArrayList<ArrayList<String>>();

		int row = 1;

		String LineNumberValue = "1";

		String ProjectdateValue = null;

		if (Period.equals("Current Period")) {

			Journals = HourJournals;

			ProjectdateValue = common.getCurrentDate();

		}

		else if (Period.equals("Next Period")) {

			Journals = HourJournals_Period2;

			ProjectdateValue = common.getNextMonthEndDate();

		}

		AmountData_Journals = new HashMap<String, String>();

		Journals_ActualAmount = new HashMap<String, String>();

		for (ArrayList<String> HourJournal : Journals) {

			clickNew();

			String TaskcodeValue = HourJournal.get(0);

			String ProjectCategoryValue = HourJournal.get(1);

			String ResourseIdValue = HourJournal.get(2);

			String HoursValue = HourJournal.get(3);

			String CostPriceValue = HourJournal.get(4);

			CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);

			String SalesPriceValue = HourJournal.get(5);

			String TotalCostPrice = formulas.getProduct(HoursValue, CostPriceValue);
			getJournalsAmountData(TaskcodeValue, TotalCostPrice);

			Amount_OverheadTransactions_Total = formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);

			logger.info("Amount_OverheadTransactions_Total: " + Amount_OverheadTransactions_Total);

			Amount_OverheadTransactions_Total_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(
					ProjectCategoryValue, TotalCostPrice);

			logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: "
					+ Amount_OverheadTransactions_Total_ExcludeFromRevRec);

			Thread.sleep(3000);

			WebElement Projectdate = ldriver.findElement(By.xpath("(//*[@aria-label='Project date'])"));

			common.setTextAfterDelete(Projectdate, ProjectdateValue);

			if (!TaskcodeValue.equals("")) {

				WebElement Taskcode_Journal = ldriver.findElement(By
						.xpath("(//*[text()='Task code']//following::*[contains(@id,'SISTaskCode')])[3][" + row + "]"));

				common.setText(Taskcode_Journal, TaskcodeValue);

			}

			if (!ProjectCategoryValue.equals("")) {

				WebElement Category_Journal = ldriver.findElement(
						By.xpath("(//*[text()='Category']//following::*[@aria-label='Category'])[" + row + "]"));

				common.setTextAfterDelete(Category_Journal, ProjectCategoryValue);

				Thread.sleep(2000);

			}

			if (!ResourseIdValue.equals("")) {

				WebElement Resourceid_Journal = ldriver.findElement(
						By.xpath("(//*[text()='Resource']//following::*[contains(@id,'Resource')])[5][" + row + "]"));

				common.setTextAfterDelete(Resourceid_Journal, ResourseIdValue);

				selectResource_HourJournal(ResourseIdValue);

			}

			if (!HoursValue.equals("")) {

				JavascriptExecutor js = (JavascriptExecutor) ldriver;

				js.executeScript("arguments[0].scrollIntoView(true);", Hours_Journal);

				WebElement Hours_Journal = ldriver.findElement(

						By.xpath("(//*[text()='Hours']//following::*[contains(@id,'ctrlProjQty')])[4][" + row + "]"));

				common.setTextAfterDelete(Hours_Journal, HoursValue);

			}

			clickGeneralTab();

			if (!CostPriceValue.equals("")) {

				WebElement Costprice_Journal = ldriver.findElement(
						By.xpath("//*[text()='Cost price']//following::*[@name='CostPrice_CostPrice'][" + row + "]"));

				common.setTextAfterDelete(Costprice_Journal, CostPriceValue);

			}

			if (!SalesPriceValue.equals("")) {

				WebElement Salesprice_Journal = ldriver.findElement(By
						.xpath("//*[text()='Sales price']//following::*[@name='SalesPrice_SalesPrice'][" + row + "]"));

				common.setTextAfterClear(Salesprice_Journal, SalesPriceValue);

			}

			clickOverheadAllocation();

			clickCalculate();

			checkOverheadAllocationCalculated();

			clickOverview_Journal();

			clickcloseMessageBar();

			logger.info("LineNumberValue:" + LineNumberValue);

			Thread.sleep(3000);

			clickLineNumber(LineNumberValue);

			clickOverheadAllocation();

			clickOverheadTransactions();

			boolean posted = checkOverheadTransactionsPosted(ProjectCategoryValue);

			if (posted == true) {

				checkOverheadTransactionsPostedData(TaskcodeValue, ProjectCategoryValue, TotalCostPrice, HoursValue,
						CostPriceValue);

			}

			clickClose();

			clickRefresh();

			int Line = Integer.parseInt(LineNumberValue) + 1;

			LineNumberValue = Integer.toString(Line);

			setJournalsActualAmount(TaskcodeValue, ProjectCategoryValue, TotalCostPrice);
		}
	}

	public void setItemJournalAndOverheadTransactionsValidation(String Period) throws InterruptedException {

		ArrayList<ArrayList<String>> Journals = new ArrayList<ArrayList<String>>();

		int row = 1;

		String LineNumberValue = "1";

		String ProjectdateValue = null;

		if (Period.equals("Current Period")) {

			Journals = ItemJournals;

			ProjectdateValue = common.getCurrentDate();

		}

		else if (Period.equals("Next Period")) {

			Journals = ItemJournals_Period2;

			ProjectdateValue = common.getNextMonthEndDate();

		}

		for (ArrayList<String> ItemJournal : Journals) {

			if (row != 1) {

				clickNew();

			}

			String ItemNumberValue = ItemJournal.get(0);

			String QuantityValue = ItemJournal.get(1);

			String CostPriceValue = ItemJournal.get(2);

			if (!CostPriceValue.equals("")) {

				CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);

			}

			String TaskcodeValue = ItemJournal.get(3);

			String ChargeTypeValue = ItemJournal.get(4);

			String CategoryValue = ItemJournal.get(5);

			String SalesPriceValue = ItemJournal.get(6);

			String SiteValue = ItemJournal.get(7);

			String WarehouseValue = ItemJournal.get(8);

			Thread.sleep(3000);

			WebElement Projectdate = ldriver.findElement(By.xpath("(//*[@aria-label='Project date'])"));

			common.setTextAfterDelete(Projectdate, ProjectdateValue);

			if (!TaskcodeValue.equals("")) {

				common.setText(Taskcode_Journal, TaskcodeValue);

			}

			if (!ItemNumberValue.equals("")) {

				common.setText(ItemNumber_Journal, ItemNumberValue);

				Thread.sleep(2000);

				common.KeyboardAction("Enter");

			}

			if (!QuantityValue.equals("")) {

				common.setTextAfterDelete(Quantity_Journal, QuantityValue);

			}

			clickProjectSubtab();

			if (!ChargeTypeValue.equals("")) {

				common.setTextAfterClear(ChargeType_Journal, ChargeTypeValue);

			}

			if (!CategoryValue.equals("")) {

				common.setTextAfterClear(Category_ItemJournal, CategoryValue);

			}

			else if (CategoryValue.equals("")) {

				CategoryValue = checkCategoryValue(ItemNumberValue);

			}

			if (SalesPriceValue.equals("")) {

				SalesPriceValue = checkSalesPriceValue(ItemNumberValue);

			}

			else if (!SalesPriceValue.equals("")) {

				common.setTextAfterDelete(Salesprice_ItemJournal, SalesPriceValue);

			}

			clickOverview_Journal();

			if (!CostPriceValue.equals("")) {

				common.setTextAfterDelete(CostPriceValue_Journal, CostPriceValue);
			}

			else if (CostPriceValue.equals("")) {

				CostPriceValue = checkCostPriceValue(ItemNumberValue);
			}

			String CostAmountValue = common.getValue(Costamount);

			String CostAmount = checkLineAmount(QuantityValue, CostPriceValue, CostAmountValue, row);

			getJournalsAmountData(TaskcodeValue, CostAmount);

			Amount_OverheadTransactions_Total = formulas.getSum(Amount_OverheadTransactions_Total, CostAmount);

			logger.info("Amount_OverheadTransactions_Total: " + Amount_OverheadTransactions_Total);

			Amount_OverheadTransactions_Total_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(
					CategoryValue, CostAmount);

			logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: "
					+ Amount_OverheadTransactions_Total_ExcludeFromRevRec);

			clickProductDimensionsSubtab();

			if (!SiteValue.equals("")) {

				common.setTextAfterClear(Site_ItemJournal, SiteValue);

			}

			else if (SiteValue.equals("")) {

				SiteValue = checkSiteValue(ItemNumberValue);

			}

			if (!WarehouseValue.equals("")) {

				common.setTextAfterClear(Warehouse_ItemJournal, WarehouseValue);

			}

			else if (WarehouseValue.equals("")) {

				WarehouseValue = checkWarehouseValue(ItemNumberValue);

			}

			// clickOverview_Journal();

			common.KeyboardAction("Tab");

			clickOverheadAllocation();

			clickCalculate_Expense();

			checkOverheadAllocationCalculated();

			clickcloseMessageBar();

			logger.info("LineNumberValue:" + LineNumberValue);

			clickOverheadAllocation();

			clickOverheadTransactions();

			boolean posted = checkOverheadTransactionsPosted(CategoryValue);

			if (posted == true) {

				checkOverheadTransactionsPostedData_ItemJournal(TaskcodeValue, CategoryValue, ItemNumberValue,
						CostAmountValue, QuantityValue, CostPriceValue);

			}

			clickClose();

			clickOverview_Journal();

			clickRefresh();

			if (row == 1) {

				ItemJournals = new ArrayList<ArrayList<String>>();

			}

			updateItemJournalData(ItemNumberValue, QuantityValue, CostPriceValue, TaskcodeValue, ChargeTypeValue,
					CategoryValue, SalesPriceValue, SiteValue, WarehouseValue);

			row++;

			setJournalsActualAmount(TaskcodeValue, CategoryValue, CostAmount);
		}
	}

	@FindBy(xpath = "//*[@aria-label='Voucher date']")
	WebElement Voucherdate;

	public void setExpenseJournalAndOverheadTransactionsValidation(String Period) throws InterruptedException {

		ArrayList<ArrayList<String>> Journals = new ArrayList<ArrayList<String>>();

		int row = 1;

		String LineNumberValue = "1";

		String ProjectdateValue = null;

		if (Period.equals("Current Period")) {

			Journals = ExpenseJournals;

			ProjectdateValue = common.getCurrentDate();

		}

		else if (Period.equals("Next Period")) {

			Journals = ExpenseJournals_Period2;

			ProjectdateValue = common.getNextMonthEndDate();

		}

		Thread.sleep(3000);

		for (ArrayList<String> ExpenseJournal : Journals) {

			if (row != 1) {

				clickNew();

			}

			String TaskcodeValue = ExpenseJournal.get(0);

			String CategoryValue = ExpenseJournal.get(1);

			String ResourseIdValue = ExpenseJournal.get(2);

			String QuantityValue = ExpenseJournal.get(3);

			String CostPriceValue = ExpenseJournal.get(4);

			CostPriceValue = formulas.getNumericValueFormatted(CostPriceValue);

			String SalesPriceValue = ExpenseJournal.get(5);

			String TotalCostPrice = formulas.getProduct(QuantityValue, CostPriceValue);

			getJournalsAmountData(TaskcodeValue, TotalCostPrice);

			Amount_OverheadTransactions_Total = formulas.getSum(Amount_OverheadTransactions_Total, TotalCostPrice);

			logger.info("Amount_OverheadTransactions_Total: " + Amount_OverheadTransactions_Total);

			Amount_OverheadTransactions_Total_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(
					CategoryValue, TotalCostPrice);

			logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: "
					+ Amount_OverheadTransactions_Total_ExcludeFromRevRec);

			Thread.sleep(3000);

			WebElement Projectdate = ldriver.findElement(By.xpath("(//*[@aria-label='Project date'])"));

			common.setTextAfterDelete(Projectdate, ProjectdateValue);

			if (!TaskcodeValue.equals("")) {

				common.setText(Taskcode_Journal, TaskcodeValue);

			}

			if (!CategoryValue.equals("")) {

				common.setTextAfterDelete(Category_Journal, CategoryValue);

			}

			if (!ResourseIdValue.equals("")) {

				common.setTextAfterDelete(ExpenseResourceid_Journal, ResourseIdValue);

				Thread.sleep(2000);

				selectResource_ExpenseJournal(ResourseIdValue);

			}

			if (!QuantityValue.equals("")) {

				common.setTextAfterDelete(Quantity_Journal, QuantityValue);

			}

			if (!CostPriceValue.equals("")) {

				common.setTextAfterDelete(Costprice_ExpenseJournal, CostPriceValue);

			}

			if (!SalesPriceValue.equals("")) {

				common.setTextAfterDelete(Salesprice_ExpenseJournal, SalesPriceValue);

			}

			clickOverheadAllocation();

			clickCalculate_Expense();

			checkOverheadAllocationCalculated();

			clickcloseMessageBar();

			logger.info("LineNumberValue:" + LineNumberValue);

			clickOverheadAllocation();

			clickOverheadTransactions();

			boolean posted = checkOverheadTransactionsPosted(CategoryValue);

			if (posted == true) {

				checkOverheadTransactionsPostedData(TaskcodeValue, CategoryValue, TotalCostPrice, QuantityValue,
						CostPriceValue);

			}

			clickClose();

			clickRefresh();

			row++;

			setJournalsActualAmount(TaskcodeValue, CategoryValue, TotalCostPrice);

		}
	}

	@FindBy(xpath = "(//*[text()='End date']//following::input)[1]")
	WebElement Enddate;

	public void setEndDate(String EndDate) throws InterruptedException {

		if (EndDate.equals("Current Period")) {

			common.setTextAfterClear(Enddate, common.getCurrentMonthEndDate());
		} else if (EndDate.equals("Next Period")) {

			common.setTextAfterClear(Enddate, common.getNextMonthEndDate());
		}
	}

	/*
	 * public void AddDataInUpdatedContracts() {
	 * 
	 * ArrayList<String> ContractData = new ArrayList<String>();
	 * 
	 * ContractData.add("CO# 001: ATProjectName03212338");
	 * 
	 * ContractData.add(PercentCompletePeriod2_Journal);
	 * 
	 * UpdateContracts = new ArrayList<ArrayList<String>>();
	 * 
	 * UpdateContracts.add(ContractData);
	 * 
	 * }
	 */

	@FindBy(xpath = "//*[@value='Draft']//ancestor::*[contains(@id,'BillingStatus')]//preceding-sibling::*[contains(@id,'ApplicationDate')]//*[@aria-label='Application date']")
	WebElement Applicationdate_CCApplication;

	@FindBy(xpath = "//*[@value='Draft']//ancestor::*[contains(@id,'BillingStatus')]//preceding-sibling::*[contains(@id,'FromDate')]//*[@aria-label='From date']")
	WebElement Fromdate_CCApplication;

	@FindBy(xpath = "//*[@value='Draft']//ancestor::*[contains(@id,'BillingStatus')]//preceding-sibling::*[contains(@id,'ToDate')]//*[@aria-label='To date']")
	WebElement Todate_CCApplication;

	public void setApplicationDateFromDateToDate(String Period) throws InterruptedException {

		// clickEdit();

		if (Period.equals("Current Period")) {

			common.setTextAfterDelete(Applicationdate_CCApplication, common.getCurrentDate());

			common.setTextAfterDelete(Fromdate_CCApplication, common.getCurrentDate());

			common.setTextAfterDelete(Todate_CCApplication, common.getCurrentDate());
		}

		else if (Period.equals("Next Period")) {

			common.setTextAfterDelete(Applicationdate_CCApplication, common.getNextMonthEndDate());

			common.setTextAfterDelete(Fromdate_CCApplication, common.getNextMonthEndDate());

			common.setTextAfterDelete(Todate_CCApplication, common.getNextMonthEndDate());
		}

		clickSave();
	}

	@FindBy(xpath = "//*[@aria-label='Application #']")
	List<WebElement> numberOfLinesInSubcontractPaymentRequest;

	public int getNumberOfLinesInSubcontractPaymentRequest() {

		int PaymentRequestLines = numberOfLinesInSubcontractPaymentRequest.size();

		return PaymentRequestLines;

	}

	public void getListOfVendorInvoice() throws InterruptedException {

		VendorInvoices = new HashMap<String, String>();

		for (int i = 1; i <= getNumberOfLinesInSubcontractPaymentRequest(); i++) {

			WebElement ApplicationNumber = ldriver
					.findElement(By.xpath("(//*[@aria-label='Application #'])[" + i + "]"));

			String ApplicationNumbers = common.getValue(ApplicationNumber);

			WebElement VendorInvoiceNumber = ldriver
					.findElement(By.xpath("(//*[@aria-label='Vendor invoice number'])[" + i + "]"));

			String VendorInvoiceNumbers = common.getValue(VendorInvoiceNumber);

			VendorInvoices.put(ApplicationNumbers, VendorInvoiceNumbers);

			logger.info("Vendor Invoices: " + VendorInvoices);

			logger.info("Vendor Invoices: " + VendorInvoices);

		}
	}

//20th scenario

	@FindBy(xpath = "(//*[@aria-label='Name'])[1]")
	WebElement Name_VendorPaymentJournal;

	public void SetName_VendorPaymentJournal() throws InterruptedException {

		common.setText(Name_VendorPaymentJournal, Name_SubcontractPaymentRelease);

	}

	@FindBy(xpath = "//*[@aria-label='Account']")
	WebElement Account_VendorPaymentJournal;

	public void SetAccount_VendorPaymentJournal() throws InterruptedException {

		common.setText(Account_VendorPaymentJournal, VendorAccountValue);

	}

	@FindBy(xpath = "//*[text()='Settle transactions']")
	WebElement Settletransactions;

	public void ClickSettletransactions(String arg1) throws InterruptedException {

		if (arg1.equals("Settle transactions")) {

			common.clickElement(Settletransactions);

			Thread.sleep(4000);
		}
	}

	@FindBy(xpath = "//*[contains(@class,'isFilterable') and contains(@id,'Invoice')]")
	WebElement Invoice_VendorPaymentJournal;

	public void clickInvoice_VendorPaymentJournal(String arg1) throws InterruptedException {

		if (arg1.equals("Invoice")) {

			common.clickElement(Invoice_VendorPaymentJournal);

		}

	}

	@FindBy(xpath = "//*[@aria-label='Offset account type']")
	WebElement Offsetaccounttype;

	public void setOffsetaccounttype() throws InterruptedException {

		common.setTextAfterDelete(Offsetaccounttype, OffSetAccountType_SubcontractPaymentRelease);

	}

	@FindBy(xpath = "//*[@aria-label='Offset account']")
	WebElement Offsetaccount;

	public void setOffsetaccount() throws InterruptedException {

		common.setTextAfterDelete(Offsetaccount, OffSetAccount_SubcontractPaymentRelease);

	}

	@FindBy(xpath = "(//*[text()='Lines'])[1]")
	WebElement Lines1;

	@FindBy(xpath = "(//*[text()='Lines'])[2]")
	WebElement Lines2;

	public void clickLines() throws InterruptedException {

		try {

			common.clickElement(Lines1);

		} catch (Exception e) {

			common.clickElement(Lines2);
		}
	}

	@FindBy(xpath = "//*[contains(@id,'MarkTrans')]//ancestor::*[@title='No']")
	WebElement Mark;

	public void MarkLine() throws InterruptedException {

		common.clickElementJS(Mark);

	}

	@FindBy(xpath = "//*[@data-dyn-title='Project management and accounting parameters']")
	WebElement Projectmanagementandaccountingparameters_PMA;

	@FindBy(xpath = "//*[@data-dyn-title='Project management and accounting']")
	WebElement Projectmanagementandaccounting;

	public void selectPost_Journals(String arg1) throws InterruptedException {

		if (arg1.equals("Post")) {

			clickPost();
		}
	}

	/*
	 * @FindBy(xpath = "(//*[text()='Post'])[1]") WebElement Post_Journal;
	 */
	@FindBy(xpath = "(//*[text()='Post'])[2]")
	WebElement Post_VendPaymentJournal;

	public void clickPost() throws InterruptedException {

		Thread.sleep(3000);

		try {

			common.clickElement(Post_Journal);

		} catch (Exception e) {

			common.clickElement(Post_VendPaymentJournal);

		}

	}

	@FindBy(xpath = "//*[@name='GroupContractOverview_RetainagePercentage']")
	WebElement Retainage;

	public void setRetainage(String arg1) throws InterruptedException {

		if (arg1.equals("Retainage%_Construction contract")) {
			logger.info("RetainageValue: " + RetainageValue);
			common.setTextAfterDelete(Retainage, RetainageValue);
		}

		if (arg1.equals("Retainage%_Retainage Change")) {
			logger.info("RetainageValue: " + RetainagePercentage1_ConstructionContract);
			common.setTextAfterDelete(Retainage, RetainagePercentage1_ConstructionContract);

		}
		if (arg1.equals("Retainage%_Next period")) {
			logger.info("RetainageValue: " + RetainagePercentage2_ConstructionContract);
			common.setTextAfterDelete(Retainage, RetainagePercentage2_ConstructionContract);
		}

		Thread.sleep(3000);
	}

	@FindBy(xpath = "//*[text()='End date']//following::*[@name='PeriodDate']")
	WebElement Enddate_PFObatchHistory;

	public void setEnddate_PFObatchHistory(String arg1) throws InterruptedException {

		if (arg1.equals("Current Period")) {

			common.setTextAfterClear(Enddate_PFObatchHistory, common.getCurrentDate());
		} else if (arg1.equals("Next Period")) {

			common.setTextAfterClear(Enddate_PFObatchHistory, common.getNextMonthEndDate());
		}
	}

	@FindBy(xpath = "(//*[text()='Date'])[2]")
	WebElement Date_Postedprojecttransactions;

	public void setDate_Postedprojecttransactions() throws InterruptedException {

		common.clickElement(Date_Postedprojecttransactions);

	}

	/*
	 * public void setUpdatedContractAndValidateCalculations() throws
	 * InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * // clickEdit();
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
	 * "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * logger.info("DescriptionValue: " + DescriptionValue);
	 * 
	 * common.clickElement(Description);
	 * 
	 * for (ArrayList<String> UpdateContract : UpdateContracts) {
	 * 
	 * String DescriptionValue_UpdateContract = UpdateContract.get(0);
	 * 
	 * logger.info("DescriptionValue_UpdateContract: " +
	 * DescriptionValue_UpdateContract);
	 * 
	 * String PercentCompleteValue_UpdateContract = UpdateContract.get(1);
	 * 
	 * if (DescriptionValue.equals(DescriptionValue_UpdateContract)) {
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Percent complete'][1]"));
	 * 
	 * common.setTextAfterDelete(PercentComplete,
	 * PercentCompleteValue_UpdateContract);
	 * 
	 * // clickRefresh(); Thread.sleep(2000);
	 * 
	 * WebElement ScheduledValueElement = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Scheduled value'][1]"));
	 * 
	 * String ScheduledValue = common.getValue(ScheduledValueElement);
	 * 
	 * WebElement InvoiceAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));
	 * 
	 * String InvoiceAmountvalue = common.getValue(InvoiceAmount);
	 * 
	 * checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, InvoiceAmountvalue, DescriptionValue);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage %'][1]"));
	 * 
	 * String RetainagePercentagevalue = common.getValue(RetainagePercentage);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage amount'][1]"));
	 * 
	 * String RetainageAmountvalue = common.getValue(RetainageAmount);
	 * 
	 * checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
	 * RetainageAmountvalue, DescriptionValue);
	 * 
	 * WebElement PrevRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Total retainage'][1]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
	 * TotalRetainagevalue, DescriptionValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));
	 * 
	 * String WorkInPlacevalue = common.getValue(WorkInPlace);
	 * 
	 * checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, WorkInPlacevalue, DescriptionValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Amount remaining'][1]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue,
	 * DescriptionValue);
	 * 
	 * break; }
	 * 
	 * else {
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * clickSave_Contract(); }
	 */

	@FindBy(xpath = "//*[text()='Accounts receivable']")
	WebElement AccountsReceivable;

	@FindBy(xpath = "//*[text()='Customer payment journal']")
	WebElement CustomerPaymentJournal;

	@FindBy(xpath = "//*[contains(@id,'JournalName') and (@aria-label='Name')][1]")
	WebElement CustomerPayment_Name;

	public void setCustomerPaymentName() throws InterruptedException {

		common.setTextAfterDelete(CustomerPayment_Name, CustomerPaymentName);
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//*[contains(@id,'AccountNum') and (@aria-label='Account')]")
	WebElement Account;

	@FindBy(xpath = "//*[@aria-label='Offset account type']")
	WebElement OffsetAccountType1;

	@FindBy(xpath = "//*[@aria-label='Offset account']")
	WebElement OffsetAccount1;

	public void setCustomerPayments() throws InterruptedException {

		common.setTextAfterDelete(Account, InvoiceAccountValue);

		Thread.sleep(3000);

		common.scrollIntoView(OffsetAccountType1);

		common.setTextAfterDelete(OffsetAccountType1, OffsetAccountType);

		Thread.sleep(3000);

		common.scrollIntoView(OffsetAccount1);

		common.setTextAfterDelete(OffsetAccount1, OffsetAccount);

		Thread.sleep(3000);

	}

	@FindBy(xpath = "//*[text()='Settle transactions']")
	WebElement SettleTransaction;

	public void clickSettleTransaction() throws InterruptedException {
		// common.scrollIntoView(SettleTransaction);
		common.clickElement(SettleTransaction);

	}

	@FindBy(xpath = "//*[contains(@class,'isFilterable') and contains(@id,'_Invoice')]")
	WebElement Invoice_Search;

	public void clickInvoice() throws InterruptedException {

		Thread.sleep(4000);

		common.clickElement(Invoice_Search);
	}

	@FindBy(xpath = "//*[@aria-label='Mark']//following::span")
	WebElement Mark_CheckBox;

	public void clickMark_CheckBox() throws InterruptedException {

		Thread.sleep(4000);

		common.clickElement(Mark_CheckBox);

		WebElement Checkbox = ldriver.findElement(By.xpath("//*[contains(@id,'MarkTrans') and @role='checkbox']"));

		Thread.sleep(4000);

		Assert.assertTrue(Checkbox.getAttribute("aria-checked").contains("true"), "Invoice Journal is not Open");

	}

	@FindBy(xpath = "//*[@aria-label='Credit']")
	WebElement Credit_CustomerPayment;

	public String getCredit_CustomerPayment() throws InterruptedException {

		Thread.sleep(4000);

		CreditValue = common.getValue(Credit_CustomerPayment);

		logger.info("CreditValue: " + CreditValue);

		return CreditValue;
	}

	@FindBy(xpath = "(//*[text()='Post'])[1]")
	WebElement Post_Journal;

	@FindBy(xpath = "(//*[text()='Post'])[2]")
	WebElement Post_Journal2;

	public void clickPost_Journal() throws InterruptedException {

		Thread.sleep(3000);
		try {
			common.clickElement(Post_Journal);
		} catch (Exception e) {
			common.clickElement(Post_Journal2);
		}
	}

	@FindBy(xpath = "(//*[text()='Invoice journals'])[2]")
	WebElement InvoiceJournals1;

	public void clickInvoiceJournal() throws InterruptedException {

		try {

			common.clickElement(InvoiceJournals1);
		}

		catch (Exception e) {

			common.clickElement(Invoicejournals);
		}
	}

	@FindBy(xpath = "(//*[@aria-label='Invoice' and contains(@id,'ProjInvoiceJour')])")
	List<WebElement> NumberofLinesInvoiceJournals;

	public int getNumberofLinesInvoiceJournals() throws InterruptedException {

		return NumberofLinesInvoiceJournals.size();

	}

	public void getInvoiceData() throws InterruptedException {

		Thread.sleep(5000);

		Integer LastRow = getNumberofLinesInvoiceJournals();

		WebElement InvoiceJournalID = ldriver.findElement(
				By.xpath("(//*[@aria-label='Invoice' and contains(@id,'ProjInvoiceJour')])[" + LastRow + "]"));

		common.clickElement(InvoiceJournalID);

		InvoiceJournalIDValue = common.getValue(InvoiceJournalID);

		WebElement InvoiceAccount = ldriver
				.findElement(By.xpath("//*[contains(@name,'ProjInvoiceJour')and contains(@id,'InvoiceAccount')]"));

		common.scrollIntoView(InvoiceAccount);

		InvoiceAccountValue = common.getText(InvoiceAccount);

	}

	@FindBy(xpath = "//*[text()='Operation completed']")
	WebElement CustomerPaymentsPostedMessage;

	public void checkCustomerPaymentsPostedMessage() throws InterruptedException {

		// Thread.sleep(2000);

		Assert.assertTrue(common.isTextDisplayed(CustomerPaymentsPostedMessage), "Operation has not been completed");

	}

	public void checkRevenueBudget(String BudgetType) throws InterruptedException {

		RevenueBudgetValue_Expected = formulas.getExpectedRevenueBudget(BudgetLines, BudgetCategories_RevenueType);

		Assert.assertEquals(getRevenueBudget(BudgetType), RevenueBudgetValue_Expected,
				"Revenue Budget value is not as expected");

	}

	public void checkCostBudget(String BudgetType) throws InterruptedException {

		CostBudgetValue_Expected = formulas.getExpectedCostBudget(BudgetLines, BudgetCategories_ExpenseType);

		Assert.assertEquals(getCostBudget(BudgetType), CostBudgetValue_Expected,
				"Cost Budget value is not as expected");

	}

	public void checkProfitMargin(String BudgetType) throws InterruptedException {

		String ProfitMargin = getProfitmargin(BudgetType);

		ProfitmarginValue_Expected = formulas.getExpectedProfitMargin(RevenueBudgetValue_Expected,
				CostBudgetValue_Expected);

		Assert.assertEquals(ProfitMargin, ProfitmarginValue_Expected, "Profit margin value is not as expected");

	}

	public void checkGrossMargin(String BudgetType) throws InterruptedException {

		String GrossMargin = getGrossMargin(BudgetType);

		GrossMarginValue_Expected = formulas.getDifference(RevenueBudgetValue_Expected, CostBudgetValue_Expected);

		Assert.assertEquals(GrossMargin, GrossMarginValue_Expected, "Gross margin value is not as expected");

	}

	public String getRevenueBudget(String BudgetType) throws InterruptedException {

		String RevenueBudgetValue = "";
		try {
			RevenueBudgetValue = common.getValue(RevenueBudget);
		} catch (Exception e) {
			RevenueBudgetValue = common.getValue(RevenueBudget1);
		}
		logger.info("RevenueBudgetValue:" + RevenueBudgetValue);

		BudgetTotalsData.put(BudgetType + ":RevenueBudget", RevenueBudgetValue);

		return RevenueBudgetValue;

	}

	public String getCostBudget(String BudgetType) throws InterruptedException {

		String CostBudgetValue = "";
		try {
			CostBudgetValue = common.getValue(CostBudget);
		} catch (Exception e) {
			CostBudgetValue = common.getValue(CostBudget1);
		}
		BudgetTotalsData.put(BudgetType + ":CostBudget", CostBudgetValue);

		return CostBudgetValue;

	}

	public String getProfitmargin(String BudgetType) throws InterruptedException {

		String ProfitmarginValue = "";
		try {
			ProfitmarginValue = common.getValue(Profitmargin);
		} catch (Exception e) {
			ProfitmarginValue = common.getValue(Profitmargin1);
		}

		BudgetTotalsData.put(BudgetType + ":ProfitMargin", ProfitmarginValue);

		// logger.info("BudgetTotalsData"+ BudgetTotalsData);

		return ProfitmarginValue;

	}

	@FindBy(xpath = "//*[contains(@name,'grossMargin')]")
	WebElement GrossMargin;

	public String getGrossMargin(String BudgetType) throws InterruptedException {

		String GrossMarginValue = common.getValue(GrossMargin);

		BudgetTotalsData.put(BudgetType + ":GrossMargin", GrossMarginValue);

		logger.info("BudgetTotalsData" + BudgetTotalsData);

		return GrossMarginValue;

	}

	@FindBy(xpath = "//*[text()='list']")
	WebElement list_Paymentrequest;

	public void Buttons_SubcontractPaymentRequest(String arg1) throws InterruptedException {

		if (arg1.equals("New")) {

			common.clickElement(New5);

		}

		else if (arg1.equals("List")) {

			common.clickElement(list_Paymentrequest);
			Thread.sleep(2000);
		}
	}

	@FindBy(xpath = "//*[@aria-label='Debit']")
	WebElement Debit;

	public String getDebitValue() throws InterruptedException {

		Debit_SubcontractPayment = common.getValue(Debit);

		return Debit_SubcontractPayment;

	}

	/*
	 * public void setUpdatedContractAndValidateCalculations(String SheetName)
	 * throws InterruptedException {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * clickEdit();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * ArrayList<ArrayList<String>> UpdateContracts = new
	 * ArrayList<ArrayList<String>>();
	 * 
	 * if (SheetName.equals("UpdateContracts1")) {
	 * 
	 * UpdateContracts = UpdateContracts1; }
	 * 
	 * else if (SheetName.equals("UpdateContracts2")) {
	 * 
	 * UpdateContracts = UpdateContracts2; }
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
	 * "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * logger.info("DescriptionValue: " + DescriptionValue);
	 * 
	 * common.clickElement(Description);
	 * 
	 * for (ArrayList<String> UpdateContract : UpdateContracts) {
	 * 
	 * String DescriptionValue_UpdateContract = UpdateContract.get(0);
	 * 
	 * logger.info("DescriptionValue_UpdateContract: " +
	 * DescriptionValue_UpdateContract);
	 * 
	 * String PercentCompleteValue_UpdateContract = UpdateContract.get(1);
	 * 
	 * if (DescriptionValue.equals(DescriptionValue_UpdateContract)) {
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Percent complete'][1]"));
	 * 
	 * common.setTextAfterDelete(PercentComplete,
	 * PercentCompleteValue_UpdateContract);
	 * 
	 * clickRefresh();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * WebElement ScheduledValueElement = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Scheduled value'][1]"));
	 * 
	 * String ScheduledValue = common.getValue(ScheduledValueElement);
	 * 
	 * WebElement InvoiceAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));
	 * 
	 * String InvoiceAmountvalue = common.getValue(InvoiceAmount);
	 * 
	 * checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, InvoiceAmountvalue, DescriptionValue);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage %'][1]"));
	 * 
	 * String RetainagePercentagevalue = common.getValue(RetainagePercentage);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage amount'][1]"));
	 * 
	 * String RetainageAmountvalue = common.getValue(RetainageAmount);
	 * 
	 * checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
	 * RetainageAmountvalue, DescriptionValue);
	 * 
	 * WebElement PrevRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Total retainage'][1]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
	 * TotalRetainagevalue, DescriptionValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));
	 * 
	 * String WorkInPlacevalue = common.getValue(WorkInPlace);
	 * 
	 * checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, WorkInPlacevalue, DescriptionValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Amount remaining'][1]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue,
	 * DescriptionValue);
	 * 
	 * break; }
	 * 
	 * else {
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * clickSave_Contract(); }
	 */

	@FindBy(xpath = "//*[@name='ProjectInvoiceJour_InvoiceAmount']")
	WebElement Invoiceamount_Invoicejournals;

	@FindBy(xpath = "//*[@aria-label='Invoice line amount']")
	WebElement Invoicelineamount_Invoicejournals;

	@FindBy(xpath = "//*[@aria-label='Customer retained amount']")
	WebElement Customerretainedamount_Invoicejournals;

	@FindBy(xpath = "//*[@aria-label='Retention release amount']")
	WebElement Retentionreleaseamount_Invoicejournals;

	public void clickInvoiceLines_Invoicejournals() throws InterruptedException {

		common.clickElement(OrigContractValue_element);

	}

	public void getSumOfInvoiceAmountAndInvoiceLineAmount() throws InterruptedException {

		Thread.sleep(5000);

		InvoiceAmount_Invoicejournals_CurrentPeriod = "0.00";

		InvoiceLineAmount_Invoicejournals_CurrentPeriod = "0.00";

		CustomerRetainedAmount_Invoicejournals_CurrentPeriod = "0.00";

		RetentionReleaseAmount_Invoicejournals_CurrentPeriod = "0.00";

		InvoiceAmount_Invoicejournals_NextPeriod = "0.00";

		InvoiceLineAmount_Invoicejournals_NextPeriod = "0.00";

		CustomerRetainedAmount_Invoicejournals_NextPeriod = "0.00";

		RetentionReleaseAmount_Invoicejournals_NextPeriod = "0.00";

		logger.info("Number Of InvoiceLines in Invoicejournals: " + getNumberOfInvoiceLines_Invoicejournals());

		for (int row = 1; row <= getNumberOfInvoiceLines_Invoicejournals(); row++) {

			WebElement InvoiceJournal = ldriver.findElement(By.xpath("(//input[@aria-label='Invoice'])[" + row + "]"));

			common.clickElement(InvoiceJournal);

			Thread.sleep(5000);

			clickFastTab("Invoice header");

			Thread.sleep(3000);

			WebElement Date_Invoicejournals = ldriver.findElement(By.xpath("(//*[@aria-label='Date'])[" + row + "]"));

			String DateValue_Invoicejournals = common.getValue(Date_Invoicejournals);

			if (DateValue_Invoicejournals.equals(common.getCurrentDate())) {

				String InvoiceAmountValue = common.getValue(Invoiceamount_Invoicejournals);

				InvoiceAmount_Invoicejournals_CurrentPeriod = formulas
						.getSum(InvoiceAmount_Invoicejournals_CurrentPeriod, InvoiceAmountValue);

				// logger.info("Invoice Amount in Invoice journals: " +
				// InvoiceAmount_Invoicejournals);
				String InvoiceLineAmountValue = common.getValue(Invoicelineamount_Invoicejournals);

				InvoiceLineAmount_Invoicejournals_CurrentPeriod = formulas
						.getSum(InvoiceLineAmount_Invoicejournals_CurrentPeriod, InvoiceLineAmountValue);

				// logger.info("Invoice line Amount in Invoice journals: " +
				// InvoiceLineAmount_Invoicejournals);

				String CustomerRetainedAmountValue = common.getValue(Customerretainedamount_Invoicejournals);

				CustomerRetainedAmount_Invoicejournals_CurrentPeriod = formulas
						.getSum(CustomerRetainedAmount_Invoicejournals_CurrentPeriod, CustomerRetainedAmountValue);

				String RetentionReleaseAmountValue = common.getValue(Retentionreleaseamount_Invoicejournals);

				RetentionReleaseAmount_Invoicejournals_CurrentPeriod = formulas
						.getSum(RetentionReleaseAmount_Invoicejournals_CurrentPeriod, RetentionReleaseAmountValue);

			}

			else if (DateValue_Invoicejournals.equals(common.getNextMonthEndDate())) {

				String InvoiceAmountValue = common.getValue(Invoiceamount_Invoicejournals);

				InvoiceAmount_Invoicejournals_NextPeriod = formulas.getSum(InvoiceAmount_Invoicejournals_NextPeriod,
						InvoiceAmountValue);

				// logger.info("Invoice Amount in Invoice journals: " +
				// InvoiceAmount_Invoicejournals);
				String InvoiceLineAmountValue = common.getValue(Invoicelineamount_Invoicejournals);

				InvoiceLineAmount_Invoicejournals_NextPeriod = formulas
						.getSum(InvoiceLineAmount_Invoicejournals_NextPeriod, InvoiceLineAmountValue);

				// logger.info("Invoice line Amount in Invoice journals: " +
				// InvoiceLineAmount_Invoicejournals);

				String CustomerRetainedAmountValue = common.getValue(Customerretainedamount_Invoicejournals);

				CustomerRetainedAmount_Invoicejournals_NextPeriod = formulas
						.getSum(CustomerRetainedAmount_Invoicejournals_NextPeriod, CustomerRetainedAmountValue);

				String RetentionReleaseAmountValue = common.getValue(Retentionreleaseamount_Invoicejournals);

				RetentionReleaseAmount_Invoicejournals_NextPeriod = formulas
						.getSum(RetentionReleaseAmount_Invoicejournals_NextPeriod, RetentionReleaseAmountValue);

			}

		}

		logger.info("Total Invoice Amount in Invoice journals for current period: "
				+ InvoiceAmount_Invoicejournals_CurrentPeriod);

		logger.info("Total Invoice line Amount in Invoice journals for current period: "
				+ InvoiceLineAmount_Invoicejournals_CurrentPeriod);

		logger.info("Total Customer retained Amount in Invoice journals for current period: "
				+ CustomerRetainedAmount_Invoicejournals_CurrentPeriod);

		logger.info("Total Retention Release Amount in Invoice journals for current period: "
				+ RetentionReleaseAmount_Invoicejournals_CurrentPeriod);

		logger.info("Total Invoice Amount in Invoice journals for next period: "
				+ InvoiceAmount_Invoicejournals_NextPeriod);

		logger.info("Total Invoice line Amount in Invoice journals for next period: "
				+ InvoiceLineAmount_Invoicejournals_NextPeriod);

		logger.info("Total Customer retained Amount in Invoice journals for next period: "
				+ CustomerRetainedAmount_Invoicejournals_NextPeriod);

		logger.info("Total Retention Release Amount in Invoice journals for next period: "
				+ RetentionReleaseAmount_Invoicejournals_NextPeriod);

	}

	/*
	 * public void AddDataInUpdatedContracts() {
	 * 
	 * ArrayList<String> ContractData = new ArrayList<String>();
	 * 
	 * ContractData.add("CO# 001: ATProjectName03212338");
	 * 
	 * ContractData.add(PercentCompletePeriod2_Journal);
	 * 
	 * UpdateContracts1 = new ArrayList<ArrayList<String>>();
	 * 
	 * UpdateContracts1.add(ContractData);
	 * 
	 * UpdateContracts2.add(ContractData);
	 * 
	 * }
	 */

	public void setProjectID(String Feature) throws InterruptedException {

		ProjectIDValue = ProjectID_TestData.get(Feature);

		logger.info("Project ID for " + Feature + " : " + ProjectIDValue);

		setFilterFieldText(ProjectIDValue);

	}

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * clickProjectcostmanagement_PageHeader();
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } if (arg1.equals("ECAC")) { clickECAC(); }
	 * 
	 * if (arg1.equals("Project change order")) { clickProjectchangeorder1(); } //
	 * Added by Carolin if (arg1.equals("Customer change orders")) {
	 * 
	 * clickCustomerchangeorders(); } // Added by Monica if
	 * (arg1.equals("All transactions")) {
	 * 
	 * common.clickElement(Alltransactions); }
	 * 
	 * if (arg1.equals("Budget versions")) {
	 * 
	 * try { common.clickElement(Budgetversions1); }
	 * 
	 * catch (Exception e) { common.clickElement(Budgetversions2); } }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * try { common.clickElement(Postedtransactions1); } catch (Exception e) {
	 * common.clickElement(Postedtransactions2); }
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Control")) {
	 * 
	 * if (arg1.equals("Committed Cost")) {
	 * 
	 * try { common.clickElement(Committedcost1); } catch (Exception e) {
	 * common.clickElement(Committedcost2); }
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Bill")) {
	 * 
	 * if (arg1.equals("Invoice journals")) {
	 * 
	 * Thread.sleep(5000);
	 * 
	 * clickInvoiceJournal();
	 * 
	 * } } }
	 */

	@FindBy(xpath = "//*[contains(@id,'ViewSections_label')]")
	WebElement Showlines;

	public void clickShowlines() throws InterruptedException {

		common.clickElement(Showlines);

	}

	@FindBy(xpath = "//*[text()='Only cost transactions']")
	WebElement Onlycosttransactions;

	public void clickOnlycosttransactions(String arg1) throws InterruptedException {

		if (arg1.equals("Only cost transactions")) {

			common.clickElement(Onlycosttransactions);
		}
	}

	@FindBy(xpath = "//*[text()='Ok']")
	WebElement Ok_AllTransactions;

	public void clickOk_AllTransactions() throws InterruptedException {

		common.clickElement(Ok_AllTransactions);

		Thread.sleep(5000);

	}

	@FindBy(xpath = "(//*[text()='Total']//following::*)[1]")
	WebElement NumberOfRow_ProjectTransaction;

	public String getNumberOfRow_ProjectTransaction() throws InterruptedException {

		String Rows = common.getText(NumberOfRow_ProjectTransaction).split(" ")[0];

		return Rows;

	}

	/*
	 * public void getTotalAmount_ExcludeRevRec_AllTransactions() throws
	 * InterruptedException {
	 * 
	 * for (int row = 1; row <= getNumberOfRow_ProjectTransaction(); row++) {
	 * 
	 * logger.info(getNumberOfRow_ProjectTransaction());
	 * 
	 * WebElement ProjectCategory_AllTransactions = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Project category'])[" + row + "]"));
	 * 
	 * String ProjectCategory = common.getValue(ProjectCategory_AllTransactions);
	 * 
	 * WebElement Amount_AllTransactions = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Amount'])[" + row + "]"));
	 * 
	 * String Amount = common.getValue(Amount_AllTransactions);
	 * 
	 * Amount_OverheadTransactions_Total =
	 * formulas.getSum(Amount_OverheadTransactions_Total, Amount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total: " +
	 * Amount_OverheadTransactions_Total);
	 * 
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec =
	 * getAmount_OverheadTransactions_Total_ExcludeFromRevRec( ProjectCategory,
	 * Amount);
	 * 
	 * logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: " +
	 * Amount_OverheadTransactions_Total_ExcludeFromRevRec);
	 * 
	 * common.clickElement(ProjectCategory_AllTransactions);
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * }
	 * 
	 * }
	 */

	public void clickEdit_BudgetVersions() throws InterruptedException {

		common.clickElement(Edit2);

	}

	@FindBy(xpath = "//*[@aria-label='Task code']")
	List<WebElement> NumberOfLinesInBudget;

	public int getNumberOfLinesInBudget() {

		return NumberOfLinesInBudget.size();
	}

	/*
	 * public void getECACNetChange_ECAC() throws InterruptedException {
	 * 
	 * Thread.sleep(2000);
	 * 
	 * for (int row = 1; row <= getNumberOfECAClines(); row++) {
	 * 
	 * WebElement ECACNetChange = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='ECAC net change'])[" + row + "]"));
	 * 
	 * String ECACNetChangeValue = common.getValue(ECACNetChange);
	 * 
	 * ECACNetChangeValueTotal = formulas.getSum(ECACNetChangeValueTotal,
	 * ECACNetChangeValue);
	 * 
	 * // clickRefresh();
	 * 
	 * common.scrollIntoView(ECACNetChange);
	 * 
	 * common.clickElement(ECACNetChange);
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * }
	 * 
	 * logger.info("ECACNetChangeValueTotal: " + ECACNetChangeValueTotal); }
	 */

	@FindBy(xpath = "//*[contains(@id,'NetChangeAmount') and (@aria-label='ECAC net change')]")
	WebElement ECACNetChange;

	public void getECACNetChange_ECAC() throws InterruptedException {

		Thread.sleep(5000);

		common.scrollIntoView(ECACNetChange);

		ECACNetChangeValueTotal = common.getValue(ECACNetChange);

		logger.info("ECAC Net Change Value: " + ECACNetChangeValueTotal);

	}

	@FindBy(xpath = "//*[@aria-label='Purchase order']")
	WebElement Purchaseorder_Subcontract;

	public String getPurchaseorder_Subcontract() throws InterruptedException {

		PurchaseOrderValue = common.getValue(Purchaseorder_Subcontract);

		return PurchaseOrderValue;

	}

	/*
	 * @FindBy(xpath = "//*[@aria-label='Project ID']") WebElement ProjectIDLink;
	 */

	public void clickProjectIDLink() throws InterruptedException {

		common.clickElement(ProjectIDLink);
	}

	/*
	 * @FindBy(xpath = "//*[@aria-label='Task code']") List<WebElement>
	 * NumberOfLinesInSubContract;
	 * 
	 * public int getNumberOfLinesSubcontract() {
	 * 
	 * return NumberOfLinesInSubContract.size(); }
	 * 
	 * public void setSubcontractTotal_Amount(String TaskCodeValue, String
	 * ProjectCategory, String NetAmountValue) throws InterruptedException {
	 * 
	 * if (SubContractNetAmount.get(TaskCodeValue + ":" + ProjectCategory) == null)
	 * {
	 * 
	 * SubContractNetAmount.put(TaskCodeValue + ":" + ProjectCategory,
	 * NetAmountValue); } else { String ExistingSubcontractNetAmount =
	 * SubContractNetAmount.get(TaskCodeValue + ":" + ProjectCategory);
	 * 
	 * SubContractNetAmount.put(TaskCodeValue + ":" + ProjectCategory,
	 * formulas.getSum(ExistingSubcontractNetAmount, NetAmountValue)); } }
	 * 
	 * public void getSubContract() throws InterruptedException {
	 * 
	 * SubContractNetAmount = new HashMap<String, String>();
	 * 
	 * for (int row = 1; row <= getNumberOfLinesSubcontract(); row++) {
	 * 
	 * WebElement ProjectCategory =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));
	 * 
	 * String ProjectCategoryValue = common.getValue(ProjectCategory);
	 * 
	 * WebElement TaskCode =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));
	 * 
	 * String TaskCodeValue = common.getValue(TaskCode);
	 * 
	 * WebElement NetAmount =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Net amount'])[" + row +
	 * "]"));
	 * 
	 * String NetAmountValue = common.getValue(NetAmount);
	 * 
	 * setSubcontractTotal_Amount(TaskCodeValue, ProjectCategoryValue,
	 * NetAmountValue);
	 * 
	 * }
	 * 
	 * logger.info("SubContract NetAmount: " + SubContractNetAmount);
	 * 
	 * }
	 * 
	 * public void setJournalsActualAmount_AllTransactions(String TaskcodeValue,
	 * String ProjectCategoryValue, String Amount) throws InterruptedException {
	 * 
	 * if (JournalsAmount_AllTransactions.get(TaskcodeValue + ":" +
	 * ProjectCategoryValue) == null) {
	 * 
	 * JournalsAmount_AllTransactions.put(TaskcodeValue + ":" +
	 * ProjectCategoryValue, Amount); }
	 * 
	 * else {
	 * 
	 * String ExistingActualAmount = JournalsAmount_AllTransactions
	 * .get(TaskcodeValue + ":" + ProjectCategoryValue);
	 * 
	 * JournalsAmount_AllTransactions.put(TaskcodeValue + ":" +
	 * ProjectCategoryValue, formulas.getSum(ExistingActualAmount, Amount)); }
	 * 
	 * }
	 */

	public String getAmount_Total_ExcludeFromRevRec(String BudgetCategory, String LineAmount)
			throws InterruptedException {

		if (BudgetCategories_ExcludedFromRevRec.contains(BudgetCategory)) {

			LineAmount_Total_ExcludeFromRevRec = formulas.getSum(LineAmount_Total_ExcludeFromRevRec, LineAmount);

		}

		return LineAmount_Total_ExcludeFromRevRec;

	}

	/*
	 * public String getCostBudget_ExcludeFromRevRec() throws InterruptedException {
	 * 
	 * for (int i = 1; i <= getNumberOfLinesInBudget(); i++) {
	 * 
	 * WebElement Budgetcategory_Budget = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Budget category'])[" + i + "]"));
	 * 
	 * String BudgetCategory = common.getValue(Budgetcategory_Budget);
	 * 
	 * WebElement BudgetLineAmount_Budget = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Line amount'])[" + i + "]"));
	 * 
	 * String BudgetLineAmount = common.getValue(BudgetLineAmount_Budget);
	 * 
	 * BudgetLineAmount_ExcludedFromRevRec =
	 * getAmount_Total_ExcludeFromRevRec(BudgetCategory, BudgetLineAmount);
	 * 
	 * logger.info("BudgetLineAmount_ExcludedFromRevRec: " +
	 * BudgetLineAmount_ExcludedFromRevRec);
	 * 
	 * BudgetAmount_ExcludeRevRec = formulas.getDifference(getCostBudget(),
	 * BudgetLineAmount_ExcludedFromRevRec);
	 * 
	 * }
	 * 
	 * return BudgetAmount_ExcludeRevRec; }
	 */

	public void getCostBudget_ExcludeFromRevRec() throws InterruptedException {

		BudgetVersions_LineAmount = new HashMap<String, String>();

		for (int i = getNumberOfLinesInBudget(); i >= 1; i--) {

			// arthi
			WebElement TaskCode_Budget = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + i + "]"));

			String TaskCode = common.getValue(TaskCode_Budget);

			WebElement Budgetcategory_Budget = ldriver
					.findElement(By.xpath("(//*[@aria-label='Budget category'])[" + i + "]"));

			String BudgetCategory = common.getValue(Budgetcategory_Budget);

			WebElement BudgetLineAmount_Budget = ldriver
					.findElement(By.xpath("(//*[@aria-label='Line amount'])[" + i + "]"));

			String BudgetLineAmount = common.getValue(BudgetLineAmount_Budget);

			String BudgetLineAmount_ExcludedFromRevRec = getAmount_Total_ExcludeFromRevRec(BudgetCategory,
					BudgetLineAmount);

			logger.info("BudgetLineAmount_ExcludedFromRevRec: " + BudgetLineAmount_ExcludedFromRevRec);

			CostBudget_ExcludeRevRec = formulas.getDifference(getCostBudget(), BudgetLineAmount_ExcludedFromRevRec);

			BudgetVersions_LineAmount.put(TaskCode + ":" + BudgetCategory, BudgetLineAmount);

			common.scrollIntoView(TaskCode_Budget);

			common.clickElement(TaskCode_Budget);

			common.KeyboardAction("Up");
		}

		logger.info("BudgetAmount_ExcludeRevRec" + CostBudget_ExcludeRevRec);

		logger.info("BudgetVersions_LineAmount" + BudgetVersions_LineAmount);

		// return BudgetAmount_ExcludeRevRec;
	}

	public void getTotalAmount_ExcludeRevRec_AllTransactions() throws InterruptedException {

		JournalsAmount_AllTransactions = new HashMap<String, String>();

		Thread.sleep(5000);

		int size = Integer.parseInt(getNumberOfRow_ProjectTransaction());

		for (int row = 1; row <= size; row++) {

			WebElement ProjectCategory_AllTransactions = ldriver
					.findElement(By.xpath("(//*[@aria-label='Project category'])[" + row + "]"));

			String ProjectCategory = common.getValue(ProjectCategory_AllTransactions);

			WebElement Amount_AllTransactions = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount'])[" + row + "]"));

			String Amount = common.getValue(Amount_AllTransactions);

			Amount_OverheadTransactions_Total = formulas.getSum(Amount_OverheadTransactions_Total, Amount);

			logger.info("Amount_OverheadTransactions_Total: " + Amount_OverheadTransactions_Total);

			Amount_OverheadTransactions_Total_ExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(
					ProjectCategory, Amount);

			logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec: "
					+ Amount_OverheadTransactions_Total_ExcludeFromRevRec);

//Arthi
			WebElement TaskCode_AllTransactions = ldriver
					.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			String TaskCode = common.getValue(TaskCode_AllTransactions);

			setJournalsActualAmount_AllTransactions(TaskCode, ProjectCategory, Amount);

			common.scrollIntoView(TaskCode_AllTransactions);

			common.clickElement(TaskCode_AllTransactions);

			common.KeyboardAction("Down");

		}

		logger.info("JournalsAmount_AllTransactions: " + JournalsAmount_AllTransactions);
	}

	public void checkActualAmount(String ActualAmountValue, String TaskcodeValue, String BudgetCategoryValue)
			throws InterruptedException {

		List<String> ProjectCategories = BudgetCategory_ProjectCategories_Mapping.get(BudgetCategoryValue);

		logger.info("ProjectCategories: " + ProjectCategories);

		String Expected_ActualAmount = "0.00";

		for (String ProjectCategory : ProjectCategories) {

			String Amount = JournalsAmount_AllTransactions.get(TaskcodeValue + ":" + ProjectCategory);

			if (Amount != null) {

				Expected_ActualAmount = formulas.getSum(Expected_ActualAmount, Amount);

			}

		}

		logger.info("Expected Actual Amount :" + Expected_ActualAmount);

		logger.info("Actual Amount :" + ActualAmountValue);

		Assert.assertEquals(ActualAmountValue, Expected_ActualAmount,
				"Actual Amount Value not As Expected For Task code" + TaskcodeValue + "& Budget Category"
						+ BudgetCategoryValue);
	}

	public void checkCommittedCost(String CommittedCostValue, String TaskcodeValue, String BudgetCategoryValue)
			throws InterruptedException {

		Thread.sleep(5000);

		List<String> ProjectCategories = BudgetCategory_ProjectCategories_Mapping.get(BudgetCategoryValue);

		String Expected_CommittedCostValue = "0.00";

		for (String ProjectCategory : ProjectCategories) {

			String Amount = SubContractNetAmount.get(TaskcodeValue + ":" + ProjectCategory);

			if (Amount != null) {

				Expected_CommittedCostValue = formulas.getSum(Expected_CommittedCostValue, Amount);

			}

		}

		logger.info("Expected Committed Cost :" + Expected_CommittedCostValue);

		logger.info("Actual Committed Cost :" + CommittedCostValue);

		Assert.assertEquals(CommittedCostValue, Expected_CommittedCostValue,
				"Committed cost not As Expected For Task code" + TaskcodeValue + "& Budget Category"
						+ BudgetCategoryValue);
	}

	public void checkECACAmount(String ECACAmountValue, String TaskCodeValue, String BudgetCategoryValue)
			throws InterruptedException {

		String ECACAmountValueExpected = BudgetVersions_LineAmount.get(TaskCodeValue + ":" + BudgetCategoryValue);

		if (ECACAmountValueExpected == (null)) {

			ECACAmountValueExpected = "0.00";

		}

		logger.info("Expected ECACAmount Values is: " + ECACAmountValueExpected);

		logger.info("Actual ECACAmount Values is: " + ECACAmountValue);

		Assert.assertEquals(ECACAmountValue, ECACAmountValueExpected,
				"ECAC Amount Value is not as Expected for Taskcode " + TaskCodeValue + " & Budget Category "
						+ BudgetCategoryValue);

	}

	public void setJournalsActualAmount_AllTransactions(String TaskcodeValue, String ProjectCategoryValue,
			String Amount) throws InterruptedException {

		/*
		 * String BudgetCategory = "";
		 * 
		 * for (Map.Entry<String, ArrayList<String>> entry :
		 * BudgetCategory_ProjectCategories_Mapping.entrySet()) {
		 * 
		 * if (entry.getValue().contains(ProjectCategoryValue)) {
		 * 
		 * BudgetCategory = entry.getKey();
		 * 
		 * break;
		 * 
		 * } }
		 * 
		 * if (!BudgetCategory.equals("Subcontract")) {
		 */

		if (JournalsAmount_AllTransactions.get(TaskcodeValue + ":" + ProjectCategoryValue) == null) {

			JournalsAmount_AllTransactions.put(TaskcodeValue + ":" + ProjectCategoryValue, Amount);
		}

		else {

			String ExistingActualAmount = JournalsAmount_AllTransactions
					.get(TaskcodeValue + ":" + ProjectCategoryValue);

			JournalsAmount_AllTransactions.put(TaskcodeValue + ":" + ProjectCategoryValue,
					formulas.getSum(ExistingActualAmount, Amount));
		}

	}

	public void setInvoiceAmount_AllTransactions(String TaskcodeValue, String Amount) throws InterruptedException {

		if (InvoiceAmount_Journals.get(TaskcodeValue) == null) {

			InvoiceAmount_Journals.put(TaskcodeValue, Amount);
		}

		else {

			String ExistingAmount = InvoiceAmount_Journals.get(TaskcodeValue);

			InvoiceAmount_Journals.put(TaskcodeValue, formulas.getSum(ExistingAmount, Amount));
		}

	}

	// }

	@FindBy(xpath = "//*[@aria-label='Task code']")
	List<WebElement> NumberOfLinesInSubContract;

	public int getNumberOfLinesSubcontract() {

		return NumberOfLinesInSubContract.size();
	}

	public void getSubContract() throws InterruptedException {

		SubContractNetAmount = new HashMap<String, String>();

		for (int row = 1; row <= getNumberOfLinesSubcontract(); row++) {

			WebElement ProjectCategory = ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));

			String ProjectCategoryValue = common.getValue(ProjectCategory);

			WebElement TaskCode = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			String TaskCodeValue = common.getValue(TaskCode);

			WebElement NetAmount = ldriver.findElement(By.xpath("(//*[@aria-label='Net amount'])[" + row + "]"));

			String NetAmountValue = common.getValue(NetAmount);

			setSubcontractTotal_Amount(TaskCodeValue, ProjectCategoryValue, NetAmountValue);

		}

		logger.info("SubContract NetAmount: " + SubContractNetAmount);

	}

	public void setSubcontractTotal_Amount(String TaskCodeValue, String ProjectCategory, String NetAmountValue)
			throws InterruptedException {

		if (SubContractNetAmount.get(TaskCodeValue + ":" + ProjectCategory) == null) {

			SubContractNetAmount.put(TaskCodeValue + ":" + ProjectCategory, NetAmountValue);
		} else {
			String ExistingSubcontractNetAmount = SubContractNetAmount.get(TaskCodeValue + ":" + ProjectCategory);

			SubContractNetAmount.put(TaskCodeValue + ":" + ProjectCategory,
					formulas.getSum(ExistingSubcontractNetAmount, NetAmountValue));
		}

		InvoiceAmountTotal = formulas.getSum(InvoiceAmountTotal, NetAmountValue);

		logger.info("InvoiceAmountTotal: " + InvoiceAmountTotal);

	}

	public void checkPFOReportValues(String arg1, String arg2) throws InterruptedException {

		if (arg2.equals("PFO Report")) {

			if (arg1.equals("Orig Contract Value")) {

				checkgetOrigContractValue();
			}

			if (arg1.equals("Orig Cost Budget")) {

				checkOrigCostBudget();
			}

			if (arg1.equals("Orig GM")) {

				checkOrigGM();
			}

			if (arg1.equals("Orig GM %")) {

				checkgetOrigGMPercentage();
			}

			if (arg1.equals("Current CV")) {

				checkCurrentCV();

			}

			if (arg1.equals("Current CO Budget")) {

				checkCurrentCOBudget();

			}

			if (arg1.equals("Current Gross Margin")) {

				checkCurrentGrossMargin();

			}

			if (arg1.equals("Current GM %")) {

				checkCurrentGMPercentage();

			}

			if (arg1.equals("ECAC Cost")) {

				checkECACCost();

			}

			if (arg1.equals("Total POC %")) {

				checkTotalPOCpercentage();

			}

			if (arg1.equals("ECAC Gross Margin")) {

				checkECACGrossMargin();

			}

			if (arg1.equals("ECAC GM %")) {

				checkECACGMPercentage();

			}

			if (arg1.equals("Actual Cost")) {

				checkActualCost();

			}

			if (arg1.equals("ECAC Cost_RevREC")) {

				checkECACcost_RevREC();

			}

			if (arg1.equals("RevREC")) {

				checkPercentageComplete();

			}

			if (arg1.equals("CTC")) {

				checkCTC();

			}

			if (arg1.equals("CMTD")) {

				checkCMTD();

			}

			if (arg1.equals("ETC")) {

				checkETC();

			}

			if (arg1.equals("Backlog Revenue")) {

				checkBacklogRevenue();

			}

			if (arg1.equals("Backlog Cost")) {

				checkBacklogCost();

			}

			if (arg1.equals("Backlog Margin")) {

				checkBacklogMargin();

			}

			if (arg1.equals("Backlog Billing")) {

				checkBacklogBilling();

			}

			if (arg1.equals("Unposted Revenue")) {

				checkUnpostedRevenue();

			}

			if (arg1.equals("MTD Cost")) {

				checkmtdCost();

			}

			if (arg1.equals("MTD Margin")) {

				checkmtdMargin();

			}

			if (arg1.equals("QTD Cost $")) {

				checkQTDCost();

			}

			if (arg1.equals("QTD Margin $")) {

				checkqtdMargin();

			}

			if (arg1.equals("YTD Cost")) {

				checkYTDCost();

			}

			if (arg1.equals("YTD Margin")) {

				checkytdMargin();

			}

			if (arg1.equals("PTD Cost")) {

				checkPTDCost();

			}

			if (arg1.equals("PTD Margin")) {

				checkPTDMargin();

			}

			if (arg1.equals("PTD incurred margin")) {

				checkPTDIncurredMargin();
			}

			if (arg1.equals("Prog Billing")) {

				checkProgBilling();

			}

			if (arg1.equals("Over Billing")) {

				checkOverBilling();

			}

			if (arg1.equals("% Billed")) {

				checkPercentageBilled();

			}

			if (arg1.equals("AR Balance")) {

				checkARBalance();

			}

			if (arg1.equals("AR Retention")) {

				checkARRetention();

			}

			if (arg1.equals("Cash Position")) {

				checkCashPosition();

			}

			if (arg1.equals("Available For Billing")) {

				checkAvailableForBilling();

			}

			if (arg1.equals("MTD Earned Revenue")) {

				checkMTDEarnedRevenue();

			}

			if (arg1.equals("MTD Earned Margin")) {

				checkMTDEarnedMargin();

			}

			if (arg1.equals("MTD Earned Margin %")) {

				checkMTDEarnedMarginPercentage();

			}

			if (arg1.equals("Unposted Revenue")) {

				checkUnpostedRevenue();

			}

			if (arg1.equals("PTD Earned Revenue")) {

				checkPTDEarnedRevenue();

			}

			if (arg1.equals("PTD Earned Margin")) {

				checkPTDEarnedMargin();

			}

			if (arg1.equals("PTD Earned Margin %")) {

				checkPTDEarnedMarginPercentage();

			}

			if (arg1.equals("Approved CO")) {

				checkApprovedCO();

			}

			if (arg1.equals("Pending CO")) {

				checkPendingCO();

			}

			if (arg1.equals("CO Budget")) {

				checkCOBudget();

			}

			if (arg1.equals("CO Margin")) {

				checkCOMargin();

			}

			if (arg1.equals("CO Margin %")) {

				checkCOMarginPercentage();

			}

			if (arg1.equals("Margin Variance $")) {

				checkMarginVarianceDollar();

			}

			if (arg1.equals("Margin Variance %")) {

				checkMarginVariancePercentage();

			}
		}

	}

	public void checkExecutionCompletedSuccessfully(String feature) {

		logger.info("Execution completed successfully for '" + feature + "' with Project ID:" + ProjectIDValue);

	}

	public void setJournalProjectID(String Feature) throws InterruptedException {

		ProjectIDValue = JournalProjectID_TestData.get(Feature);
		logger.info("Journal Project ID for " + Feature + " : " + ProjectIDValue);
		setFilterFieldText(ProjectIDValue);

	}

	/*
	 * // Budget Change Order Arthi //
	 * '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
	 * '' public void setBudgetType(String BudgetVersion, String Period) throws
	 * InterruptedException {
	 * 
	 * String BudgetVersionValue = "";
	 * 
	 * String PeriodValue = "";
	 * 
	 * if (BudgetVersion.equals("BudgetLines_Original") &&
	 * (Period.equals("Current_Period"))) {
	 * 
	 * BudgetVersionValue = "Original";
	 * 
	 * PeriodValue = common.getCurrentMonthEndDate();
	 * 
	 * }
	 * 
	 * else if (BudgetVersion.equals("BudgetLines_ChangeOrder1") &&
	 * (Period.equals("Current_Period"))) {
	 * 
	 * BudgetVersionValue = "Change order";
	 * 
	 * PeriodValue = common.getCurrentMonthEndDate(); }
	 * 
	 * else if (BudgetVersion.equals("BudgetLines_ChangeOrder2") &&
	 * (Period.equals("Next_Period"))) {
	 * 
	 * BudgetVersionValue = "Change order";
	 * 
	 * PeriodValue = common.getNextMonthEndDate();
	 * 
	 * } Thread.sleep(5000);
	 * 
	 * WebElement ProjectID =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Budget type' and @value='" +
	 * BudgetVersionValue + "']//ancestor::*[contains(@id,'BudgetType')]" +
	 * "//following-sibling::*[contains(@id,'ProjPeriodTo')]//*[@aria-label='Committed period' and @value='"
	 * + PeriodValue + "']" +
	 * "//ancestor::*[contains(@id,'ProjPeriodTo')]//preceding-sibling::*[contains(@id,'ProjId')]//*[@aria-label='Project ID']"
	 * ));
	 * 
	 * clickRefresh();
	 * 
	 * common.clickUsingActions(ProjectID);
	 * 
	 * }
	 */

	// Budget Change Order Arthi

	// '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
	public void setBudgetType(String BudgetVersion, String Period) throws InterruptedException {

		String BudgetVersionValue = "";

		String PeriodValue = "";

		if (BudgetVersion.equals("BudgetLines_Original") && (Period.equals("Current_Period"))) {

			BudgetVersionValue = "Original";

			PeriodValue = common.getCurrentMonthEndDate();

		}

		else if (BudgetVersion.equals("BudgetLines_Revision1") && (Period.equals("Current_Period"))) {

			BudgetVersionValue = "Change order";

			PeriodValue = common.getCurrentMonthEndDate();
		}

		else if (BudgetVersion.equals("BudgetLines_Revision2") && (Period.equals("Next_Period"))) {

			BudgetVersionValue = "Change order";

			PeriodValue = common.getNextMonthEndDate();

		}
		Thread.sleep(5000);

		WebElement ProjectID = ldriver.findElement(By.xpath("//*[@aria-label='Budget type' and @value='"
				+ BudgetVersionValue + "']//ancestor::*[contains(@id,'BudgetType')]"
				+ "//following-sibling::*[contains(@id,'ProjPeriodTo')]//*[@aria-label='Committed period' and @value='"
				+ PeriodValue + "']"
				+ "//ancestor::*[contains(@id,'ProjPeriodTo')]//preceding-sibling::*[contains(@id,'ProjId')]//*[@aria-label='Project ID']//preceding::div[1]"));

		clickRefresh();

		common.clickUsingActions(ProjectID);

		common.KeyboardAction("Tab");

		common.KeyboardAction("Enter");

	}

	public void getCostBudget_ExcludeFromRevRec(String BudgetVersion, String Period) throws InterruptedException {

		setBudgetType(BudgetVersion, Period);

		Thread.sleep(10000);

		BudgetVersions_LineAmount = new HashMap<String, String>();

		String BudgetLineAmount_RevRecTotal = "0.00";

		for (int i = getNumberOfLinesInBudget(); i >= 1; i--) {

			// arthi
			WebElement TaskCode_Budget = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + i + "]"));

			String TaskCode = common.getValue(TaskCode_Budget);

			WebElement Budgetcategory_Budget = ldriver
					.findElement(By.xpath("(//*[@aria-label='Budget category'])[" + i + "]"));

			String BudgetCategory = common.getValue(Budgetcategory_Budget);

			WebElement BudgetLineAmount_Budget = ldriver
					.findElement(By.xpath("(//*[@aria-label='Line amount'])[" + i + "]"));

			String BudgetLineAmount = common.getValue(BudgetLineAmount_Budget);

			if (BudgetCategories_ExcludedFromRevRec.contains(BudgetCategory)) {

				BudgetLineAmount_RevRecTotal = formulas.getSum(BudgetLineAmount_RevRecTotal, BudgetLineAmount);

			}

			// BudgetLineAmount_RevRecTotal=getAmount_Total_ExcludeFromRevRec(BudgetCategory,
			// BudgetLineAmount);

			BudgetVersions_LineAmount.put(TaskCode + ":" + BudgetCategory, BudgetLineAmount);

			common.scrollIntoView(TaskCode_Budget);

			common.clickElement(TaskCode_Budget);

			common.KeyboardAction("Up");

		}
		BudgetAmount_ExcludeRevRec.put(BudgetVersion,
				formulas.getDifference(getCostBudget(), BudgetLineAmount_RevRecTotal));

		Budget_RevenueBudget.put(BudgetVersion, getRevenueBudget());

		Budget_CostBudget.put(BudgetVersion, getCostBudget());

		logger.info("BudgetVersions_LineAmount" + BudgetVersions_LineAmount);

		logger.info("BudgetLineAmount_RevRecTotal: " + BudgetLineAmount_RevRecTotal);

		logger.info("BudgetAmount_ExcludeRevRec: " + BudgetAmount_ExcludeRevRec);

		logger.info("Budget_RevenueBudget: " + Budget_RevenueBudget);

		logger.info("Budget_CostBudget: " + Budget_CostBudget);

	}

	public void checkPFOReportMismatches() {

		sa.assertAll();
	}

	@FindBy(xpath = "//*[@aria-label='Revenue Budget']")
	WebElement RevenueBudget_Customerchangeorder;

	public String getRevenueBudget_Customerchangeorder() throws InterruptedException {

		Thread.sleep(2000);

		common.scrollIntoView(RevenueBudget_Customerchangeorder);

		RevenueBudget_CustomerCO = common.getValue(RevenueBudget_Customerchangeorder);

		logger.info("RevenueBudget_CustomerCO: " + RevenueBudget_CustomerCO);

		return RevenueBudget_CustomerCO;

	}

	@FindBy(xpath = "(//*[text()='Payment request']//following::*[text()='list'])")
	WebElement list_PaymentRequest1;

	public void clickNewSubcontractPayment(String arg1) throws InterruptedException {

		if (arg1.equals("New")) {
			try {
				common.clickElement(New_PaymentRequest1);
			}

			catch (Exception e) {
				common.clickElement(New_PaymentRequest2);
			}
		} else if (arg1.equals("list")) {

			common.clickElement(list_PaymentRequest1);
		}

	}

	@FindBy(xpath = "//*[@aria-label='Application #']")
	List<WebElement> NumberOfLinesInProgressSubcontract;

	public int getNumberOfLinesInProgressSubcontract() {

		return NumberOfLinesInProgressSubcontract.size();
	}

	public void getInvoiceAmount_ProgressSubcontract() throws InterruptedException {

		Thread.sleep(5000);

		logger.info("NumberOfLinesInProgressSubcontract: " + getNumberOfLinesInProgressSubcontract());

		for (int i = 1; i <= getNumberOfLinesInProgressSubcontract(); i++) {

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("((//*[@aria-label='Invoice amount'])[" + i + "])"));
			Thread.sleep(5000);

			common.scrollIntoView(InvoiceAmount);

			String InvoiceAmount_ProgressSubcontract = common.getValue(InvoiceAmount);

			InvoiceAmountTotal = formulas.getSum(InvoiceAmount_ProgressSubcontract, InvoiceAmountTotal);

			logger.info("InvoiceAmount_ProgressSubcontract: " + InvoiceAmountTotal);

		}
	}

	@FindBy(xpath = "//*[text()='Period end date' and not(contains(@id,'PeriodEndDate'))]")
	WebElement Periodenddate_AllTransactions;

	public void getTotalAmount_ExcludeRevRec_AllTransactions(String Period) throws InterruptedException {

		Thread.sleep(5000);

		if (Period.equals("Current period end date")) {

			Amount_OverheadTransactions_Total_CurrentPeriod = "0.00";

			Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod = "0.00";

			Period = common.getCurrentMonthEndDate();

			common.clickElement(Periodenddate_AllTransactions);

			setFilterFieldText(Period);

			clickApply();

			Thread.sleep(5000);

			int rows = Integer.parseInt(getNumberOfRow_ProjectTransaction());

			logger.info("Number Of Row_Project Transaction: " + rows);

			for (int row = 1; row <= rows; row++) {

				WebElement ProjectCategory_AllTransactions = ldriver
						.findElement(By.xpath("(//*[@aria-label='Project category'])[" + row + "]"));

				String ProjectCategory = common.getValue(ProjectCategory_AllTransactions);

				WebElement Amount_AllTransactions = ldriver
						.findElement(By.xpath("(//*[@aria-label='Amount'])[" + row + "]"));

				String Amount = common.getValue(Amount_AllTransactions);

				Amount_OverheadTransactions_Total_CurrentPeriod = formulas
						.getSum(Amount_OverheadTransactions_Total_CurrentPeriod, Amount);

				// logger.info("Amount_OverheadTransactions_Total_CurrentPeriod: "+
				// Amount_OverheadTransactions_Total_CurrentPeriod);

				String AmountExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(ProjectCategory,
						Amount);

				Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod = formulas.getSum(
						AmountExcludeFromRevRec, Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod);

				// logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod:
				// "+ Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod);

//Arthi
				WebElement ProjectID_AllTransactions = ldriver.findElement(
						By.xpath("(//input[contains(@id,'PostedTransactionDetails') and @aria-label='Task code'])["
								+ row + "]"));

				String TaskCode = common.getValue(ProjectID_AllTransactions);

				setJournalsActualAmount_AllTransactions(TaskCode, ProjectCategory, Amount);

				common.scrollIntoView(ProjectID_AllTransactions);

				common.clickElement(ProjectID_AllTransactions);

				common.KeyboardAction("Down");

			}
		}

		else if (Period.equals("Next period end date")) {

			Amount_OverheadTransactions_Total_NextPeriod = "0.00";

			Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod = "0.00";

			Thread.sleep(2000);

			clickRefresh();

			Thread.sleep(2000);

			Period = common.getNextMonthEndDate();

			common.scrollIntoView(Periodenddate_AllTransactions);

			common.clickElement(Periodenddate_AllTransactions);

			setFilterFieldText(Period);

			clickApply();

			Thread.sleep(5000);

			int rows = Integer.parseInt(getNumberOfRow_ProjectTransaction());

			logger.info("Number Of Row_Project Transaction: " + rows);

			for (int row = 1; row <= rows; row++) {

				WebElement ProjectCategory_AllTransactions = ldriver
						.findElement(By.xpath("(//*[@aria-label='Project category'])[" + row + "]"));

				String ProjectCategory = common.getValue(ProjectCategory_AllTransactions);

				WebElement Amount_AllTransactions = ldriver
						.findElement(By.xpath("(//*[@aria-label='Amount'])[" + row + "]"));

				String Amount = common.getValue(Amount_AllTransactions);

				Amount_OverheadTransactions_Total_NextPeriod = formulas
						.getSum(Amount_OverheadTransactions_Total_NextPeriod, Amount);

				// logger.info("Amount_OverheadTransactions_Total_NextPeriod: "+
				// Amount_OverheadTransactions_Total_NextPeriod);

				String AmountExcludeFromRevRec = getAmount_OverheadTransactions_Total_ExcludeFromRevRec(ProjectCategory,
						Amount);

				Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod = formulas.getSum(
						AmountExcludeFromRevRec, Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod);

				// logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod:
				// "+ Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod);

				// Arthi
				WebElement TaskCode_AllTransactions = ldriver.findElement(
						By.xpath("(//input[contains(@id,'PostedTransactionDetails') and @aria-label='Task code'])["
								+ row + "]"));

				String TaskCode = common.getValue(TaskCode_AllTransactions);

				setJournalsActualAmount_AllTransactions(TaskCode, ProjectCategory, Amount);

				// common.scrollIntoView(TaskCode_AllTransactions);

				common.clickElement(TaskCode_AllTransactions);

				common.KeyboardAction("Down");

				Thread.sleep(2000);

			}
		}

		logger.info(
				"Amount_OverheadTransactions_Total_CurrentPeriod: " + Amount_OverheadTransactions_Total_CurrentPeriod);

		logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod: "
				+ Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod);

		logger.info("Amount_OverheadTransactions_Total_NextPeriod: " + Amount_OverheadTransactions_Total_NextPeriod);

		logger.info("Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod: "
				+ Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod);

		logger.info("JournalsAmount_AllTransactions: " + JournalsAmount_AllTransactions);

		logger.info("InvoiceAmount_Journals: " + InvoiceAmount_Journals);
	}

	// Arthi Subcontract Change Order
	/*
	 * public void checkSubContractAmount(String arg1) throws InterruptedException {
	 * 
	 * ExpectedSubcontractAmountValue = "0.00";
	 * 
	 * if (arg1.equals("SubContract_Original")) {
	 * 
	 * ExpectedSubcontractAmountValue =
	 * formulas.getExpectedSubContractAmount(SubContracts);
	 * 
	 * logger.info("ExpectedSubcontractAmountValue " +
	 * ExpectedSubcontractAmountValue);
	 * 
	 * logger.info("Actual SubcontractAmountValue " + getSubContractAmount());
	 * 
	 * Assert.assertEquals(getSubContractAmount(), ExpectedSubcontractAmountValue,
	 * "Sub contract amount is not as expected");
	 * 
	 * } else { for (String NetAmount : SubContractNetAmount.values()) {
	 * 
	 * ExpectedSubcontractAmountValue = formulas.getSum(NetAmount,
	 * ExpectedSubcontractAmountValue);
	 * 
	 * } logger.info("ExpectedSubcontractAmountValue" +
	 * ExpectedSubcontractAmountValue); }
	 * 
	 * }
	 */

	public void checkSubContractAmount(String arg1) throws InterruptedException {

		ExpectedSubcontractAmountValue = "0.00";

		if (arg1.equals("SubContract_Original")) {

			ExpectedSubcontractAmountValue = formulas.getExpectedSubContractAmount(SubContracts);

		} else if (arg1.equals("SubContract_Revision1")) {

			for (String NetAmount : SubContractNetAmount.values()) {

				ExpectedSubcontractAmountValue = formulas.getSum(NetAmount, ExpectedSubcontractAmountValue);

			}
			logger.info("ExpectedSubcontractAmountValue " + ExpectedSubcontractAmountValue);

			logger.info("Actual SubcontractAmountValue " + getSubContractAmount());

			Assert.assertEquals(getSubContractAmount(), ExpectedSubcontractAmountValue,
					"Sub contract amount is not as expected");

		}

	}

	@FindBy(xpath = "//*[text()='Posting date']//following::*[contains(@aria-controls,'datepicker')]")
	WebElement PostingDate_RevREC;

	public void checkPostingDate() throws InterruptedException {

		Assert.assertEquals(common.getValue(PostingDate_RevREC), common.getCurrentMonthEndDate(),
				"Posting date is not displayed as expected");

	}

	@FindBy(xpath = "//*[text()='Customer change order no']//following::*[@name='Overview_ChangeOrderNo']")
	WebElement ChangeOrderNumber;

	@FindBy(xpath = "//*[text()='Description']//following::*[@name='Overview_Description']")
	WebElement Description_CCO;

	public void getDescription_CCO() throws InterruptedException {
		String ChangeOrderNumberValue = common.getValue(ChangeOrderNumber);

		String Description_CCOValue = common.getValue(Description_CCO);

		strDescription_CCO = "CO# " + ChangeOrderNumberValue + ": " + Description_CCOValue;

		logger.info("Description in CCO: " + strDescription_CCO);

		logger.info("Description in CCO: " + strDescription_CCO);

	}

	/*
	 * public void setUpdatedContractAndValidateCalculations(String SheetName)
	 * throws InterruptedException {
	 * 
	 * // Thread.sleep(3000);
	 * 
	 * // clickEdit();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * ArrayList<ArrayList<String>> UpdateContracts = new
	 * ArrayList<ArrayList<String>>();
	 * 
	 * if (SheetName.equals("UpdateContracts1")) {
	 * 
	 * UpdateContracts = UpdateContracts1; }
	 * 
	 * else if (SheetName.equals("UpdateContracts2")) {
	 * 
	 * UpdateContracts = UpdateContracts2; }
	 * 
	 * int NumberofLinesInContractOverview = getNumberofLinesInContractOverview();
	 * 
	 * logger.info("NumberofLinesInContractOverview: " +
	 * getNumberofLinesInContractOverview());
	 * 
	 * for (int row = 1; row <= NumberofLinesInContractOverview; row++) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
	 * "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * logger.info("DescriptionValue: " + DescriptionValue);
	 * 
	 * common.clickElement(Description);
	 * 
	 * // Thread.sleep(2000);
	 * 
	 * for (ArrayList<String> UpdateContract : UpdateContracts) {
	 * 
	 * String DescriptionValue_UpdateContract = UpdateContract.get(0);
	 * 
	 * logger.info("DescriptionValue_UpdateContract: " +
	 * DescriptionValue_UpdateContract);
	 * 
	 * String PercentCompleteValue_UpdateContract = UpdateContract.get(1);
	 * 
	 * if (DescriptionValue.equals(DescriptionValue_UpdateContract)) {
	 * 
	 * logger.info("DescriptionValue : " + DescriptionValue +
	 * " Available in update contract");
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Percent complete'][1]"));
	 * 
	 * common.setTextAfterDelete(PercentComplete,
	 * PercentCompleteValue_UpdateContract);
	 * 
	 * // clickRefresh();
	 * 
	 * clickSave();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * WebElement ScheduledValueElement = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Scheduled value'][1]"));
	 * 
	 * String ScheduledValue = common.getValue(ScheduledValueElement);
	 * 
	 * WebElement InvoiceAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));
	 * 
	 * String InvoiceAmountvalue = common.getValue(InvoiceAmount);
	 * 
	 * checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, InvoiceAmountvalue, DescriptionValue);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage %'][1]"));
	 * 
	 * String RetainagePercentagevalue = common.getValue(RetainagePercentage);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage amount'][1]"));
	 * 
	 * String RetainageAmountvalue = common.getValue(RetainageAmount);
	 * 
	 * checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
	 * RetainageAmountvalue, DescriptionValue);
	 * 
	 * WebElement PrevRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Total retainage'][1]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
	 * TotalRetainagevalue, DescriptionValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));
	 * 
	 * String WorkInPlacevalue = common.getValue(WorkInPlace);
	 * 
	 * checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, WorkInPlacevalue, DescriptionValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Amount remaining'][1]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue,
	 * DescriptionValue);
	 * 
	 * break; }
	 * 
	 * else {
	 * 
	 * if (row < NumberofLinesInContractOverview) {
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * } } }
	 * 
	 * }
	 * 
	 * clickSave_Contract(); }
	 */

	@FindBy(xpath = "//*[@aria-label='Line num' and contains(@id,'GridProjLines')]")
	List<WebElement> NumberofLinesInContractOverview;

	public int getNumberofLinesInContractOverview() throws InterruptedException {

		logger.info(NumberofLinesInContractOverview.size());

		return NumberofLinesInContractOverview.size();

	}

	/*
	 * public void AddDataInUpdatedContracts() {
	 * 
	 * ArrayList<String> ContractData = new ArrayList<String>();
	 * 
	 * ContractData.add(strDescription_CCO);
	 * 
	 * ContractData.add(PercentCompletePeriod2_Journal);
	 * 
	 * UpdateContracts1 = new ArrayList<ArrayList<String>>();
	 * 
	 * UpdateContracts1.add(ContractData);
	 * 
	 * UpdateContracts2 = new ArrayList<ArrayList<String>>();
	 * 
	 * UpdateContracts2.add(ContractData);
	 * 
	 * logger.info("UpdateContracts2: " + UpdateContracts2);
	 * 
	 * }
	 */

	public void AddDataInUpdatedContracts() {

		ArrayList<String> ContractData = new ArrayList<String>();

		ContractData.add(strDescription_CCO);

		ContractData.add(PercentCompletePeriod2_Journal);

		UpdateContracts2 = new ArrayList<ArrayList<String>>();

		UpdateContracts2.add(ContractData);

		ContractData = new ArrayList<String>();

		ContractData.add(strDescription_CCO);

		ContractData.add(PercentComplete3);

		UpdateContracts3.add(ContractData);

		logger.info("Update Contracts2: " + UpdateContracts2);

		logger.info("Update Contracts3: " + UpdateContracts3);

	}

	/*
	 * public void checkInvoiceAmountAfterPercentCompleteUpdate(String
	 * ScheduledValue, String PercentComplete, String InvoiceAmount, String
	 * DescriptionValue, String PrevWorkInPlaceValue) throws InterruptedException {
	 * 
	 * String ExpectedInvoiceAmount = formulas.getWorkInPlace(ScheduledValue,
	 * PercentComplete);
	 * 
	 * String ExpectedInvoiceAmountValue =
	 * formulas.getDifference(ExpectedInvoiceAmount, PrevWorkInPlaceValue);
	 * 
	 * logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmountValue);
	 * 
	 * logger.info("Invoice Amount Actual: " + InvoiceAmount);
	 * 
	 * Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmountValue,
	 * "Invoice Amount in Contract is not as expected after percent complete update for "
	 * + DescriptionValue);
	 * 
	 * }
	 */

	public void setUpdatedContract(String SheetName) throws InterruptedException {

		// Thread.sleep(3000);

		// clickEdit();

		Thread.sleep(3000);

		ArrayList<ArrayList<String>> UpdateContracts = new ArrayList<ArrayList<String>>();

		if (SheetName.equals("UpdateContracts1")) {

			UpdateContracts = UpdateContracts1;
		}

		else if (SheetName.equals("UpdateContracts2")) {

			UpdateContracts = UpdateContracts2;
		}

		else if (SheetName.equals("UpdateContracts3")) {

			UpdateContracts = UpdateContracts3;
		}

		logger.info("UpdateContracts: " + UpdateContracts);

	}

	public void setUpdatedContractAndValidateCalculations(String SheetName) throws InterruptedException {

		// Thread.sleep(3000);

		// clickEdit();

		Thread.sleep(3000);

		ArrayList<ArrayList<String>> UpdateContracts = new ArrayList<ArrayList<String>>();

		if (SheetName.equals("UpdateContracts1")) {

			UpdateContracts = UpdateContracts1;
		}

		else if (SheetName.equals("UpdateContracts2")) {

			UpdateContracts = UpdateContracts2;
		}

		else if (SheetName.equals("UpdateContracts3")) {

			UpdateContracts = UpdateContracts3;
		}

		logger.info("getNumberofLinesInContractOverview: " + getNumberofLinesInContractOverview());

		logger.info("UpdateContracts: " + UpdateContracts);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			System.out.println("DescriptionValue: " + DescriptionValue);

			common.clickElement(Description);

			// Thread.sleep(2000);

			for (ArrayList<String> UpdateContract : UpdateContracts) {

				String DescriptionValue_UpdateContract = UpdateContract.get(0);

				System.out.println("DescriptionValue_UpdateContract: " + DescriptionValue_UpdateContract);

				String PercentCompleteValue_UpdateContract = UpdateContract.get(1);

				System.out.println("PercentCompleteValue_UpdateContract: " + PercentCompleteValue_UpdateContract);

				if (DescriptionValue.equals(DescriptionValue_UpdateContract)) {

					System.out.println("DescriptionValue : " + DescriptionValue + " Available in update contract");

					WebElement PercentComplete = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Percent complete'][1]"));

					common.setTextAfterDelete(PercentComplete, PercentCompleteValue_UpdateContract);

					clickSave();

					Thread.sleep(5000);

					WebElement ScheduledValueElement = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Scheduled value'][1]"));

					String ScheduledValue = common.getValue(ScheduledValueElement);

					WebElement PrevWorkInPlace = ldriver
							.findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row + "]"));

					String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);

					WebElement InvoiceAmount = ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='"
							+ DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));

					String InvoiceAmountvalue = common.getValue(InvoiceAmount);

					checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue, PercentCompleteValue_UpdateContract,
							InvoiceAmountvalue, DescriptionValue, PrevWorkInPlaceValue);

					WebElement RetainagePercentage = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Retainage %'][1]"));

					String RetainagePercentagevalue = common.getValue(RetainagePercentage);

					WebElement RetainageAmount = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Retainage amount'][1]"));

					String RetainageAmountvalue = common.getValue(RetainageAmount);

					checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue, RetainageAmountvalue,
							DescriptionValue);

					WebElement PrevRetainage = ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='"
							+ DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));

					String PrevRetainagevalue = common.getValue(PrevRetainage);

					WebElement TotalRetainage = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Total retainage'][1]"));

					String TotalRetainagevalue = common.getValue(TotalRetainage);

					checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue, TotalRetainagevalue,
							DescriptionValue);

					WebElement WorkInPlace = ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='"
							+ DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));

					String WorkInPlacevalue = common.getValue(WorkInPlace);

					checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue, PercentCompleteValue_UpdateContract,
							WorkInPlacevalue, DescriptionValue);

					WebElement AmountRemaining = ldriver
							.findElement(By.xpath("//*[@aria-label='Description' and @value='" + DescriptionValue
									+ "']//following::*[@aria-label='Amount remaining'][1]"));

					String AmountRemainingValue = common.getValue(AmountRemaining);

					checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue, DescriptionValue);

					common.scrollIntoView(Description);

					common.clickElement(Description);

					if (row < getNumberofLinesInContractOverview()) {

						common.KeyboardAction("Down");

					}

					break;

				}

				else {

					if (row < getNumberofLinesInContractOverview()) {

						common.KeyboardAction("Down");

					}
				}
			}

//			common.scrollIntoView(Description);
//
//			common.clickElement(Description);
//
//			if(row<getNumberofLinesInContractOverview()) {
//
//				common.KeyboardAction("Down");
//
//			}

		}

		clickRefresh();

		clickSave();

	}

	public void checkContractCalculations_costs() throws InterruptedException {

		Thread.sleep(9000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement ActualCosts = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			common.scrollIntoView(ActualCosts);

			String ActualCostsValue = common.getValue(ActualCosts);

			String Costs = "0.00";

			for (ArrayList<String> ContarctData : ConstructionContracts) {

				String ContractData_DescriptionValue = ContarctData.get(0);

				if (DescriptionValue.equals(ContractData_DescriptionValue)) {

					String TaskCodes = ContarctData.get(2);

					if (TaskCodes != "") {

						String[] Tasks = TaskCodes.split(";");

						for (int i = 0; i < Tasks.length; i++) {

							for (Map.Entry<String, String> entry : JournalsAmount_AllTransactions.entrySet()) {

								if (entry.getKey().contains(Tasks[i])) {

									Costs = formulas.getSum(Costs, entry.getValue());

								}
							}
						}
					}
				}

			}
			logger.info("Expected Costs Value:" + Costs);

			logger.info("ActualCostsValue :" + ActualCostsValue);

			Assert.assertEquals(ActualCostsValue, Costs, "Costs Value not As Expected For Task code");

		}
	}

	@FindBy(xpath = "(//*[text()='Date']//following::input)[1]")
	WebElement Date;

	public void setDate(String Period) throws InterruptedException {

		PFOPeriod = Period;

		if (Period.equals("Current Period")) {

			common.setTextAfterDelete(Date, common.getCurrentMonthEndDate());

		}

		else if (Period.equals("Next Period")) {

			common.setTextAfterDelete(Date, common.getNextMonthEndDate());

		}

	}

	public void checkInvoiceAmountAfterPercentCompleteUpdate(String ScheduledValue, String PercentComplete,
			String InvoiceAmount, String DescriptionValue, String PrevWorkInPlaceValue) throws InterruptedException {

		String ExpectedInvoiceAmount = formulas.getWorkInPlace(ScheduledValue, PercentComplete);

		String ExpectedInvoiceAmountValue = formulas.getDifference(ExpectedInvoiceAmount, PrevWorkInPlaceValue);

		logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmountValue);

		logger.info("Invoice Amount Actual: " + InvoiceAmount);

		Assert.assertEquals(InvoiceAmount, ExpectedInvoiceAmountValue,
				"Invoice Amount in Contract is not as expected after percent complete update for " + DescriptionValue);

	}

	/*
	 * public void setUpdatedContractAndValidateCalculations(String SheetName)
	 * throws InterruptedException {
	 * 
	 * // clickRefresh();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * // clickFastTab("Overview");
	 * 
	 * // clickEdit();
	 * 
	 * Thread.sleep(3000);
	 * 
	 * ArrayList<ArrayList<String>> UpdateContracts = new
	 * ArrayList<ArrayList<String>>();
	 * 
	 * if (SheetName.equals("UpdateContracts1")) {
	 * 
	 * UpdateContracts = UpdateContracts1; }
	 * 
	 * else if (SheetName.equals("UpdateContracts2")) {
	 * 
	 * UpdateContracts = UpdateContracts2; }
	 * 
	 * else if (SheetName.equals("UpdateContracts3")) {
	 * 
	 * UpdateContracts = UpdateContracts3; }
	 * 
	 * System.out.println("getNumberofLinesInContractOverview: " +
	 * getNumberofLinesInContractOverview());
	 * 
	 * for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {
	 * 
	 * WebElement Description =
	 * ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row +
	 * "]"));
	 * 
	 * String DescriptionValue = common.getValue(Description);
	 * 
	 * System.out.println("DescriptionValue: " + DescriptionValue);
	 * 
	 * common.clickElement(Description);
	 * 
	 * for (ArrayList<String> UpdateContract : UpdateContracts) {
	 * 
	 * String DescriptionValue_UpdateContract = UpdateContract.get(0);
	 * 
	 * System.out.println("DescriptionValue_UpdateContract: " +
	 * DescriptionValue_UpdateContract);
	 * 
	 * String PercentCompleteValue_UpdateContract = UpdateContract.get(1);
	 * 
	 * if (DescriptionValue.equals(DescriptionValue_UpdateContract)) {
	 * 
	 * System.out.println("DescriptionValue : " + DescriptionValue +
	 * " Available in update contract");
	 * 
	 * logger.info("PercentCompleteValue_UpdateContract : " +
	 * PercentCompleteValue_UpdateContract);
	 * 
	 * WebElement PercentComplete = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Percent complete'][1]"));
	 * 
	 * common.scrollIntoView(Description);
	 * 
	 * common.setTextAfterDelete(PercentComplete,
	 * PercentCompleteValue_UpdateContract);
	 * 
	 * // clickSave(); Thread.sleep(5000);
	 * 
	 * WebElement ScheduledValueElement = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Scheduled value'][1]"));
	 * common.scrollIntoView(ScheduledValueElement); String ScheduledValue =
	 * common.getValue(ScheduledValueElement);
	 * 
	 * WebElement PrevWorkInPlace = ldriver
	 * .findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row +
	 * "]"));
	 * 
	 * String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);
	 * 
	 * WebElement InvoiceAmount =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Invoice amount'][1]"));
	 * 
	 * String InvoiceAmountvalue = common.getValue(InvoiceAmount);
	 * 
	 * checkInvoiceAmountAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, InvoiceAmountvalue, DescriptionValue,
	 * PrevWorkInPlaceValue);
	 * 
	 * WebElement RetainagePercentage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage %'][1]"));
	 * 
	 * String RetainagePercentagevalue = common.getValue(RetainagePercentage);
	 * 
	 * WebElement RetainageAmount = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Retainage amount'][1]"));
	 * 
	 * String RetainageAmountvalue = common.getValue(RetainageAmount);
	 * 
	 * checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue,
	 * RetainageAmountvalue, DescriptionValue);
	 * 
	 * WebElement PrevRetainage =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Prev retainage'][1]"));
	 * 
	 * String PrevRetainagevalue = common.getValue(PrevRetainage);
	 * 
	 * WebElement TotalRetainage = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Total retainage'][1]"));
	 * 
	 * String TotalRetainagevalue = common.getValue(TotalRetainage);
	 * 
	 * checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue,
	 * TotalRetainagevalue, DescriptionValue);
	 * 
	 * WebElement WorkInPlace =
	 * ldriver.findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Work in place'][1]"));
	 * 
	 * String WorkInPlacevalue = common.getValue(WorkInPlace);
	 * 
	 * checkWorkInPlaceAfterPercentCompleteUpdate(ScheduledValue,
	 * PercentCompleteValue_UpdateContract, WorkInPlacevalue, DescriptionValue);
	 * 
	 * WebElement AmountRemaining = ldriver
	 * .findElement(By.xpath("//*[@aria-label='Description' and @value='" +
	 * DescriptionValue + "']//following::*[@aria-label='Amount remaining'][1]"));
	 * 
	 * String AmountRemainingValue = common.getValue(AmountRemaining);
	 * 
	 * checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue,
	 * DescriptionValue);
	 * 
	 * common.scrollIntoView(Description);
	 * 
	 * common.clickElement(Description);
	 * 
	 * if (row < getNumberofLinesInContractOverview()) {
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * if (row < getNumberofLinesInContractOverview()) {
	 * 
	 * common.KeyboardAction("Down");
	 * 
	 * } } }
	 * 
	 * // common.scrollIntoView(Description); // //
	 * common.clickElement(Description); // //
	 * if(row<getNumberofLinesInContractOverview()) { // //
	 * common.KeyboardAction("Down"); // // }
	 * 
	 * }
	 * 
	 * clickRefresh();
	 * 
	 * clickSave_Contract();
	 * 
	 * }
	 */

	public void checkContractCalculations_costs(String DescriptionValue, String ActualCostsValue)
			throws InterruptedException {

		Thread.sleep(1000);

		String Costs = "0.00";

		for (ArrayList<String> ContarctData : ConstructionContracts) {

			String ContractData_DescriptionValue = ContarctData.get(0);

			if (DescriptionValue.equals(ContractData_DescriptionValue)) {

				String TaskCodes = ContarctData.get(2);

				if (TaskCodes != "") {

					String[] Tasks = TaskCodes.split(";");

					for (int i = 0; i < Tasks.length; i++) {

						for (Map.Entry<String, String> entry : JournalsAmount_AllTransactions.entrySet()) {

							if (entry.getKey().contains(Tasks[i]) && !entry.getKey().split(":")[0].equals("22-0000")) {

								Costs = formulas.getSum(Costs, entry.getValue());

								System.out.println("DescriptionValue: " + DescriptionValue);

								System.out.println("Task: " + Tasks[i]);

								System.out.println("Costs: " + Costs);

							}
						}
					}
				}
			}

		}

		logger.info("Expected Costs Value:" + Costs);

		logger.info("ActualCostsValue :" + ActualCostsValue);

		Assert.assertEquals(ActualCostsValue, Costs, "Costs Value not As Expected For Task code");

	}

	public void checkContractCalculations_costs_finalinvoice(String DescriptionValue, String ActualCostsValue)
			throws InterruptedException {

		Thread.sleep(1000);

		String Costs = "0.00";

		for (ArrayList<String> ContarctData : ConstructionContracts) {

			String ContractData_DescriptionValue = ContarctData.get(0);

			if (DescriptionValue.equals(ContractData_DescriptionValue)) {

				String TaskCodes = ContarctData.get(2);

				if (TaskCodes != "") {

					String[] Tasks = TaskCodes.split(";");

					for (int i = 0; i < Tasks.length; i++) {

						for (Map.Entry<String, String> entry : JournalsAmount_AllTransactions.entrySet()) {

							if (entry.getKey().contains(Tasks[i])) {

								Costs = formulas.getSum(Costs, entry.getValue());

								System.out.println("DescriptionValue: " + DescriptionValue);

								System.out.println("Task: " + Tasks[i]);

								System.out.println("Costs: " + Costs);

							}
						}
					}
				}
			}

		}

		logger.info("Expected Costs Value:" + Costs);

		logger.info("ActualCostsValue :" + ActualCostsValue);

		Assert.assertEquals(ActualCostsValue, Costs, "Costs Value not As Expected For Task code");

	}

	public void EnterProjectID() throws InterruptedException {

		setFilterFieldText(ProjectIDValue);

	}

	public void checkContractCalculations_FinalInvoice() throws InterruptedException {

		Thread.sleep(5000);

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement ScheduledValueElement = ldriver
					.findElement(By.xpath("(//*[@aria-label='Scheduled value'])[" + row + "]"));

			String ScheduledValue = common.getValue(ScheduledValueElement);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlacevalue = common.getValue(WorkInPlace);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountvalue = common.getValue(InvoiceAmount);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentagevalue = common.getValue(RetainagePercentage);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountvalue = common.getValue(RetainageAmount);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			WebElement PreviousWorkInPlace = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row + "]"));

			String PreviousWorkInPlacevalue = common.getValue(PreviousWorkInPlace);

			WebElement PreviousPercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));

			String PreviousPercentagevalue = common.getValue(PreviousPercentage);

			WebElement ActualCosts = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			common.scrollIntoView(ActualCosts);

			String ActualCostsValue = common.getValue(ActualCosts);

			// checkWorkInPlace(ScheduledValue, PercentCompleteValue, WorkInPlacevalue,
			// DescriptionValue);
			// =======================================================================================
			String ExpectedWorkInPlace = formulas.getSum(InvoiceAmountvalue, PreviousWorkInPlacevalue);

			logger.info("Work in place Expected: " + ExpectedWorkInPlace);

			logger.info("Work in place Actual: " + WorkInPlacevalue);

			Assert.assertEquals(WorkInPlacevalue, ExpectedWorkInPlace,
					"Work in place in Contract is not as expected for " + DescriptionValue);

			// =======================================================================================

			checkAmountRemaining(ScheduledValue, WorkInPlacevalue, AmountRemainingValue, DescriptionValue);

			// checkInvoiceAmount(ConstructionContracts, InvoiceAmountvalue,
			// DescriptionValue);
			// =======================================================================================
			String ExpectedInvoiceAmount = formulas.getDifference(
					formulas.getInvoiceAmount(ScheduledValue, PercentCompleteValue), PreviousWorkInPlacevalue);

			logger.info("Invoice Amount Expected: " + ExpectedInvoiceAmount);

			logger.info("Invoice Amount Actual: " + InvoiceAmountvalue);

			Assert.assertEquals(InvoiceAmountvalue, ExpectedInvoiceAmount,
					"Invoice Amount in Contract is not as expected for " + DescriptionValue);
			// =======================================================================================

			checkRetainageAmount(InvoiceAmountvalue, RetainagePercentagevalue, RetainageAmountvalue, DescriptionValue);

			// checkPrevRetainage
			// =======================================================================================
			logger.info("Previous Retainage Amount Expected: "
					+ ConstructionContract_RetainageAmount.get(DescriptionValue));

			logger.info("Previous Retainage Amount Actual: " + PrevRetainagevalue);

			// Assert.assertEquals(PrevRetainagevalue,
			// ConstructionContract_RetainageAmount.get(DescriptionValue),
			// "Previous Retainage Amount in Contract is not as expected for " +
			// DescriptionValue);
			// =======================================================================================

			checkTotalRetainage(RetainageAmountvalue, PrevRetainagevalue, TotalRetainagevalue, DescriptionValue);

			// checkPrevWorkInPlace
			// =======================================================================================
			logger.info("PrevWorkInPlace Expected: " + ConstructionContract_WorkInPlace.get(DescriptionValue));

			logger.info("PrevWorkInPlace Actual: " + PreviousWorkInPlacevalue);

			Assert.assertEquals(PreviousWorkInPlacevalue, ConstructionContract_WorkInPlace.get(DescriptionValue),
					"PrevWorkInPlace Amount in Contract is not as expected for " + DescriptionValue);
			// =======================================================================================

			// checkPrevPercentage
			// =======================================================================================
			logger.info("PrevPercentage Expected: " + ConstructionContract_PercentComplete.get(DescriptionValue));

			logger.info("PrevPercentage Actual: " + PreviousPercentagevalue);

			Assert.assertEquals(PreviousPercentagevalue, ConstructionContract_PercentComplete.get(DescriptionValue),
					"PrevPercentage Amount in Contract is not as expected for " + DescriptionValue);
			// =======================================================================================

			checkContractCalculations_costs_finalinvoice(DescriptionValue, ActualCostsValue);

			common.scrollIntoView(Description);

			common.clickElement(Description);

			if (row < getNumberofLinesInContractOverview()) {

				common.KeyboardAction("Down");

			}

		}

	}

	public void getConstructionContractOverviewData() throws InterruptedException {

		Thread.sleep(5000);

		ConstructionContract_RetainagePercentage = new HashMap<String, String>();
		ConstructionContract_RetainageAmount = new HashMap<String, String>();
		ConstructionContract_PrevRetainage = new HashMap<String, String>();
		ConstructionContract_TotalRetainage = new HashMap<String, String>();
		ConstructionContract_PrevWorkInPlace = new HashMap<String, String>();
		ConstructionContract_PrevPercentage = new HashMap<String, String>();
		ConstructionContract_Cost = new HashMap<String, String>();
		ConstructionContract_PercentComplete = new HashMap<String, String>();
		ConstructionContract_WorkInPlace = new HashMap<String, String>();
		ConstructionContract_InvoiceAmount = new HashMap<String, String>();
		ConstructionContract_AmountRemaining = new HashMap<String, String>();

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentageValue = common.getValue(RetainagePercentage);

			ConstructionContract_RetainagePercentage.put(DescriptionValue, RetainagePercentageValue);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			ConstructionContract_PercentComplete.put(DescriptionValue, PercentCompleteValue);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlaceValue = common.getValue(WorkInPlace);

			ConstructionContract_WorkInPlace.put(DescriptionValue, WorkInPlaceValue);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountValue = common.getValue(RetainageAmount);

			ConstructionContract_RetainageAmount.put(DescriptionValue, RetainageAmountValue);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			ConstructionContract_PrevRetainage.put(DescriptionValue, PrevRetainagevalue);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			ConstructionContract_TotalRetainage.put(DescriptionValue, TotalRetainagevalue);

			WebElement PrevWorkInPlace = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row + "]"));

			String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);

			ConstructionContract_PrevWorkInPlace.put(DescriptionValue, PrevWorkInPlaceValue);

			WebElement PrevPercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));

			String PrevPercentageValue = common.getValue(PrevPercentage);

			ConstructionContract_PrevPercentage.put(DescriptionValue, PrevPercentageValue);

			WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			String CostsValue = common.getValue(Costs);

			ConstructionContract_Cost.put(DescriptionValue, CostsValue);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			ConstructionContract_InvoiceAmount.put(DescriptionValue, InvoiceAmountValue);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			ConstructionContract_AmountRemaining.put(DescriptionValue, AmountRemainingValue);

			common.scrollIntoView(Description);

			common.clickElement(Description);

			if (row < getNumberofLinesInContractOverview()) {

				common.KeyboardAction("Down");

			}

		}

		logger.info("ConstructionContract_RetainagePercentage: " + ConstructionContract_RetainagePercentage);
		logger.info("ConstructionContract_RetainageAmount: " + ConstructionContract_RetainageAmount);
		logger.info("ConstructionContract_PrevRetainage: " + ConstructionContract_PrevRetainage);
		logger.info("ConstructionContract_TotalRetainage: " + ConstructionContract_TotalRetainage);
		logger.info("ConstructionContract_PrevWorkInPlace: " + ConstructionContract_PrevWorkInPlace);
		logger.info("ConstructionContract_PrevPercentage: " + ConstructionContract_PrevPercentage);
		logger.info("ConstructionContract_Cost: " + ConstructionContract_Cost);
		logger.info("ConstructionContract_PercentComplete: " + ConstructionContract_PercentComplete);
		logger.info("ConstructionContract_WorkInPlace: " + ConstructionContract_WorkInPlace);
		logger.info("ConstructionContract_InvoiceAmount: " + ConstructionContract_InvoiceAmount);
		logger.info("ConstructionContract_AmountRemaining: " + ConstructionContract_AmountRemaining);

	}

	public void checkRetentionToDate(String RetainageAmount, String RetentionToDate, String Description) {

		logger.info("Retention To Date in Contract Applications Expected: "
				+ ConstructionContract_TotalRetainage.get(Description));

		logger.info("Retention To Date in Contract Applications Actual: " + RetentionToDate);

		Assert.assertEquals(RetentionToDate, ConstructionContract_TotalRetainage.get(Description),
				"Retention To Date in Contract Applications is not as expected for Description: " + Description);
	}

	public void getConstructionContractOverviewDataAfterRetainageChange() throws InterruptedException {

		ConstructionContract_RetainagePercentage_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_RetainageAmount_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_PrevRetainage_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_TotalRetainage_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_PrevWorkInPlace_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_PrevPercentage_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_Cost_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_PercentComplete_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_WorkInPlace_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_InvoiceAmount_AfterRetainageChange = new HashMap<String, String>();
		ConstructionContract_AmountRemaining_AfterRetainageChange = new HashMap<String, String>();

		for (int row = 1; row <= getNumberofLinesInContractOverview(); row++) {

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'GridProjLines')])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			WebElement RetainagePercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage %'])[" + row + "]"));

			String RetainagePercentageValue = common.getValue(RetainagePercentage);

			ConstructionContract_RetainagePercentage_AfterRetainageChange.put(DescriptionValue,
					RetainagePercentageValue);

			WebElement PercentComplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + row + "]"));

			String PercentCompleteValue = common.getValue(PercentComplete);

			ConstructionContract_PercentComplete_AfterRetainageChange.put(DescriptionValue, PercentCompleteValue);

			WebElement WorkInPlace = ldriver.findElement(By.xpath("(//*[@aria-label='Work in place'])[" + row + "]"));

			String WorkInPlaceValue = common.getValue(WorkInPlace);

			ConstructionContract_WorkInPlace_AfterRetainageChange.put(DescriptionValue, WorkInPlaceValue);

			WebElement RetainageAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Retainage amount'])[" + row + "]"));

			String RetainageAmountValue = common.getValue(RetainageAmount);

			ConstructionContract_RetainageAmount_AfterRetainageChange.put(DescriptionValue, RetainageAmountValue);

			WebElement PrevRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev retainage'])[" + row + "]"));

			String PrevRetainagevalue = common.getValue(PrevRetainage);

			ConstructionContract_PrevRetainage_AfterRetainageChange.put(DescriptionValue, PrevRetainagevalue);

			WebElement TotalRetainage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Total retainage'])[" + row + "]"));

			String TotalRetainagevalue = common.getValue(TotalRetainage);

			ConstructionContract_TotalRetainage_AfterRetainageChange.put(DescriptionValue, TotalRetainagevalue);

			WebElement PrevWorkInPlace = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. work in place'])[" + row + "]"));

			String PrevWorkInPlaceValue = common.getValue(PrevWorkInPlace);

			ConstructionContract_PrevWorkInPlace_AfterRetainageChange.put(DescriptionValue, PrevWorkInPlaceValue);

			WebElement PrevPercentage = ldriver
					.findElement(By.xpath("(//*[@aria-label='Prev. percentage'])[" + row + "]"));

			String PrevPercentageValue = common.getValue(PrevPercentage);

			ConstructionContract_PrevPercentage_AfterRetainageChange.put(DescriptionValue, PrevPercentageValue);

			WebElement Costs = ldriver.findElement(By.xpath("(//*[@aria-label='Costs'])[" + row + "]"));

			String CostsValue = common.getValue(Costs);

			ConstructionContract_Cost_AfterRetainageChange.put(DescriptionValue, CostsValue);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + row + "]"));

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			ConstructionContract_InvoiceAmount_AfterRetainageChange.put(DescriptionValue, InvoiceAmountValue);

			WebElement AmountRemaining = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amount remaining'])[" + row + "]"));

			String AmountRemainingValue = common.getValue(AmountRemaining);

			ConstructionContract_AmountRemaining_AfterRetainageChange.put(DescriptionValue, AmountRemainingValue);

			common.scrollIntoView(Description);

			common.clickElement(Description);

			if (row < getNumberofLinesInContractOverview()) {

				common.KeyboardAction("Down");

			}
		}

		logger.info("ConstructionContract_RetainagePercentage_AfterRetainageChange: "
				+ ConstructionContract_RetainagePercentage_AfterRetainageChange);
		logger.info("ConstructionContract_RetainageAmount_AfterRetainageChange: "
				+ ConstructionContract_RetainageAmount_AfterRetainageChange);
		logger.info("ConstructionContract_PrevRetainage_AfterRetainageChange: "
				+ ConstructionContract_PrevRetainage_AfterRetainageChange);
		logger.info("ConstructionContract_TotalRetainage_AfterRetainageChange: "
				+ ConstructionContract_TotalRetainage_AfterRetainageChange);
		logger.info("ConstructionContract_PrevWorkInPlace_AfterRetainageChange: "
				+ ConstructionContract_PrevWorkInPlace_AfterRetainageChange);
		logger.info("ConstructionContract_PrevPercentage_AfterRetainageChange: "
				+ ConstructionContract_PrevPercentage_AfterRetainageChange);
		logger.info(
				"ConstructionContract_Cost_AfterRetainageChange: " + ConstructionContract_Cost_AfterRetainageChange);
		logger.info("ConstructionContract_PercentComplete_AfterRetainageChange: "
				+ ConstructionContract_PercentComplete_AfterRetainageChange);
		logger.info("ConstructionContract_WorkInPlace_AfterRetainageChange: "
				+ ConstructionContract_WorkInPlace_AfterRetainageChange);
		logger.info("ConstructionContract_InvoiceAmount_AfterRetainageChange: "
				+ ConstructionContract_InvoiceAmount_AfterRetainageChange);
		logger.info("ConstructionContract_AmountRemaining_AfterRetainageChange: "
				+ ConstructionContract_AmountRemaining_AfterRetainageChange);
	}

	@FindBy(xpath = "(//*[text()='Total']//following::div[@role='columnheader']//child::*[@role='button']//following::div[1])[5]")
	WebElement Totalsalesprice_Contract;

	public String getTotalsalesprice_Contract() throws InterruptedException {

		Thread.sleep(5000);

		String TotalSalesAmount = common.getText(Totalsalesprice_Contract);

		return TotalSalesAmount;
	}

	@FindBy(xpath = "(//*[text()='Total']//following::div[@role='columnheader']//child::*[@role='button']//following::div[1])[4]")
	WebElement Totalcost_Contract;

	public String getTotalcost_Contract() throws InterruptedException {

		Thread.sleep(2000);

		String TotalCostAmount = common.getText(Totalcost_Contract);

		return TotalCostAmount;
	}

	public ArrayList<ArrayList<String>> getDataFromContractOverview() throws InterruptedException {

		clickRefresh();

		DataInContractOverview = new ArrayList<ArrayList<String>>();

		ArrayList<String> Data = new ArrayList<String>();

		for (int line = 1; line <= getLineNumbersInContractOverview(); line++) {

			WebElement Description = ldriver.findElement(By.xpath("(//*[@aria-label='Description'])[" + line + "]"));

			String DescriptionValue = common.getValue(Description);

			Data.add(DescriptionValue);

			WebElement Percentcomplete = ldriver
					.findElement(By.xpath("(//*[@aria-label='Percent complete'])[" + line + "]"));

			String PercentCompleteValue = common.getValue(Percentcomplete);

			Data.add(PercentCompleteValue);

			WebElement InvoiceAmount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Invoice amount'])[" + line + "]"));

			String InvoiceAmountValue = common.getValue(InvoiceAmount);

			Data.add(InvoiceAmountValue);

			DataInContractOverview.add(new ArrayList<String>(Data));

			Data.clear();

			common.scrollIntoView(Description);

			common.clickElement(Description);

			if (line < getNumberofLinesInContractOverview()) {

				common.KeyboardAction("Down");

			}
		}
		logger.info("DataInContractOverview: " + DataInContractOverview);
		return DataInContractOverview;
	}

	// ===================CC Editable non-Editable fields==================

	@FindBy(xpath = "//*[contains(@id,'TabPagePCM_header')]")
	WebElement Projectcostmanagement_SISParameters;

	public void clickProjectcostmanagement_SISParameters(String arg1) throws InterruptedException {

		if (arg1.equals("Project cost management")) {

			common.clickElement(Projectcostmanagement_SISParameters);

		}

	}

	@FindBy(xpath = "//*[text()='Construction contracts']")
	WebElement Constructioncontract_FastTab;

	public void CheckConstructioncontract_FastTabIsEnabled() {

		common.isSectionExpanded(Constructioncontract_FastTab);

	}

	public void checkFieldsEditableInContractOverView(String value) throws InterruptedException {

		String locator = null;

		if (value.equals("Line num")) {

			locator = "(//*[@aria-label='Line num'])";
		}

		if (value.equals("Description")) {

			locator = "(//*[@aria-label='Description'])";
		}

		if (value.equals("Billing basis")) {

			locator = "(//*[@aria-label='Billing basis'])";
		}

		if (value.equals("SV quantity")) {

			locator = "(//*[@aria-label='SV quantity'])";
		}

		if (value.equals("Unit")) {

			locator = "(//*[@aria-label='Unit'])";
		}

		if (value.equals("Unit price")) {

			locator = "(//*[@aria-label='Unit price'])";
		}

		if (value.equals("Scheduled value")) {

			locator = "(//*[@aria-label='Scheduled value'])";
		}

		if (value.equals("Stored materials")) {

			locator = "(//*[@aria-label='Stored materials'])";
		}

		if (value.equals("Qty delivered")) {

			locator = "(//*[@aria-label='Qty delivered'])";
		}

		if (value.equals("Percent complete")) {

			locator = "(//*[@aria-label='Percent complete'])";
		}

		if (value.equals("Work in place")) {

			locator = "(//*[@aria-label='Work in place'])";
		}

		if (value.equals("Amount remaining")) {

			locator = "(//*[@aria-label='Amount remaining'])";
		}

		if (value.equals("Invoice amount")) {

			locator = "(//*[@aria-label='Invoice amount'])";
		}

		if (value.equals("Retainage %")) {

			locator = "(//*[@aria-label='Retainage %'])";
		}

		if (value.equals("Retainage amount")) {

			locator = "(//*[@aria-label='Retainage amount'])";
		}

		if (value.equals("Prev retainage")) {

			locator = "(//*[@aria-label='Prev retainage'])";
		}

		if (value.equals("Total retainage")) {

			locator = "(//*[@aria-label='Total retainage'])";
		}

		if (value.equals("Prev stored materials")) {

			locator = "(//*[@aria-label='Prev. stored materials'])";
		}

		if (value.equals("Prev work in place")) {

			locator = "(//*[@aria-label='Prev. work in place'])";
		}

		if (value.equals("Prev percentage")) {

			locator = "(//*[@aria-label='Prev. percentage'])";
		}

		if (value.equals("Previous qty")) {

			locator = "(//*[@aria-label='Previous qty'])";
		}

		if (value.equals("Remaining qty")) {

			locator = "(//*[@aria-label='Remaining qty'])";
		}

		if (value.equals("Costs")) {

			locator = "(//*[@aria-label='Costs'])";
		}

		for (int i = 1; i <= getNumberofLinesInContractOverview(); i++) {

			WebElement e = ldriver.findElement(By.xpath(locator + "[" + i + "]"));

			if (value.equals("Line num") || value.equals("Description") || value.equals("Billing basis")
					|| value.equals("Stored materials") || value.equals("Unit") || value.equals("Scheduled value")
					|| value.equals("Percent complete") || value.equals("Work in place")
					|| value.equals("Retainage %")) {

				checkFieldIsEditable(value, e);

			} else if (value.equals("SV quantity") || value.equals("Unit price") || value.equals("Qty delivered")
					|| value.equals("Amount remaining") || value.equals("Invoice amount")
					|| value.equals("Retainage amount") || value.equals("Total retainage")
					|| value.equals("Previous qty") || value.equals("Remaining qty") || value.equals("Costs")) {

				checkFieldIsNotEditable(value, e);

			}

			else if (value.equals("Prev retainage") || value.equals("Prev stored materials")
					|| value.equals("Prev work in place") || value.equals("Prev percentage")) {

				if (Allowoverrideconstructioncontract_SISSystemParameterValue.equals("Yes")) {

					checkFieldIsEditable(value, e);

				} else {

					checkFieldIsNotEditable(value, e);

				}

			}

		}
	}

	/*
	 * public void checkFieldIsEditable(String value, WebElement e) throws
	 * InterruptedException {
	 * 
	 * String CurrentValue = common.getValue(e);
	 * 
	 * if (value.equals("Line num") || value.equals("Description") ||
	 * value.equals("Billing basis")) {
	 * 
	 * String ModifiedValue = "12";
	 * 
	 * common.setTextAfterDelete(e, ModifiedValue);
	 * 
	 * String ModifiedValue_Actual = common.getValue(e);
	 * 
	 * Assert.assertEquals(ModifiedValue_Actual, ModifiedValue, value +
	 * " is not editable which is not expected");
	 * 
	 * }
	 * 
	 * else {
	 * 
	 * String ModifiedValue = "12.12";
	 * 
	 * common.setTextAfterDelete(e, ModifiedValue);
	 * 
	 * String ModifiedValue_Actual = common.getValue(e);
	 * 
	 * Assert.assertEquals(ModifiedValue_Actual, ModifiedValue, value +
	 * " is not editable which is not expected");
	 * 
	 * }
	 * 
	 * common.setTextAfterDelete(e, CurrentValue); }
	 * 
	 * public void checkFieldIsNotEditable(String value, WebElement e) throws
	 * InterruptedException {
	 * 
	 * String CurrentValue = common.getValue(e);
	 * 
	 * String ModifiedValue = "12";
	 * 
	 * common.setTextAfterDelete(e, ModifiedValue);
	 * 
	 * String ModifiedValue_Actual = common.getValue(e);
	 * 
	 * Assert.assertEquals(ModifiedValue_Actual, CurrentValue, value +
	 * " is editable which is not expected");
	 * 
	 * }
	 */

	@FindBy(xpath = "(//*[text()='Allow override construction contract']//following::*[@role='switch'])[1]")
	WebElement Allowoverrideconstructioncontract_SISSystemParameter;

	public void setAllowoverrideconstructioncontract_SISSystemParameter(String arg1, String Flag)
			throws InterruptedException {

		if (arg1.equals("Allow override construction contract") && Flag.equals("Yes")) {

			if (Allowoverrideconstructioncontract_SISSystemParameter.getAttribute("aria-checked").equals("true")) {

			} else {

				common.clickElement(Allowoverrideconstructioncontract_SISSystemParameter);

			}

			Allowoverrideconstructioncontract_SISSystemParameterValue = "Yes";

		} else if (Flag.equals("No")) {

			if (Allowoverrideconstructioncontract_SISSystemParameter.getAttribute("aria-checked").equals("false")) {

			} else {

				common.clickElement(Allowoverrideconstructioncontract_SISSystemParameter);

			}

			Allowoverrideconstructioncontract_SISSystemParameterValue = "No";

		}
	}

	// ===========POM===========
	public void checkFieldIsEditable(String value, WebElement e) throws InterruptedException {

		String CurrentValue = common.getValue(e);

		if (value.equals("Line num") || value.equals("Description") || value.equals("Billing basis")) {

			String ModifiedValue = "12";

			common.setTextAfterDelete(e, ModifiedValue);

			String ModifiedValue_Actual = common.getValue(e);

			if (ModifiedValue_Actual.equals(ModifiedValue)) {

				logger.info(value + " is editable as expected");

			} else {

				logger.info(value + " is  not editable which is not expected");

			}

			Assert.assertEquals(ModifiedValue_Actual, ModifiedValue, value + " is not editable which is not expected");

		}

		else {

			String ModifiedValue = "12.12";

			common.setTextAfterDelete(e, ModifiedValue);

			String ModifiedValue_Actual = common.getValue(e);

			if (ModifiedValue_Actual.equals(ModifiedValue)) {

				logger.info(value + " is editable as expected");

			} else {

				logger.info(value + " is not editable which is not expected");

			}

			Assert.assertEquals(ModifiedValue_Actual, ModifiedValue, value + " is not editable which is not expected");

		}

		common.setTextAfterDelete(e, CurrentValue);
	}

	public void checkFieldIsNotEditable(String value, WebElement e) throws InterruptedException {

		String CurrentValue = common.getValue(e);

		String ModifiedValue = "12";

		common.setTextAfterDelete(e, ModifiedValue);

		String ModifiedValue_Actual = common.getValue(e);

		if (ModifiedValue_Actual.equals(CurrentValue)) {

			logger.info(value + " is not editable as expected");

		} else {

			logger.info(value + " is editable which is not expected");

		}

		Assert.assertEquals(ModifiedValue_Actual, CurrentValue, value + " is editable which is not expected");

	}

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'ItemJournalEntry') and text()='Item']")
	WebElement Item_Journals1;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ItemJournalEntry') and text()='Item'])[2]")
	WebElement Item_Journals2;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ItemJournalEntry') and text()='Item'])[3]")
	WebElement Item_Journals3;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ItemJournalEntry') and text()='Item'])[4]")
	WebElement Item_Journals4;

	public void clickItemJournal() throws InterruptedException {

		try {
			common.clickElement(Item_Journals1);

			Thread.sleep(3000);

		} catch (Exception e1) {

			try {
				common.clickElement(Item_Journals2);

				Thread.sleep(3000);

			} catch (Exception e2) {

				try {
					common.clickElement(Item_Journals3);

					Thread.sleep(3000);

				} catch (Exception e3) {

					common.clickElement(Item_Journals4);

					Thread.sleep(3000);
				}
			}

		}

	}

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour']")
	WebElement Hour_Journals1;

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour'][2]")
	WebElement Hour_Journals2;

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour'][3]")
	WebElement Hour_Journals3;

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'HourEntry') and text()='Hour'][4]")
	WebElement Hour_Journals4;

	public void clickHourJournal() throws InterruptedException {

		try {
			common.clickElement(Hour_Journals1);
		} catch (Exception e) {

			try {
				common.clickElement(Hour_Journals2);

			} catch (Exception e2) {
				try {
					common.clickElement(Hour_Journals3);

				} catch (Exception e3) {
					common.clickElement(Hour_Journals4);

				}
			}
		}

	}

	// Expense Journal

	@FindBy(xpath = "//*[text()='Journals']//following::*[contains(@id,'ExpenseEntry') and text()='Expense']")
	WebElement Expense_Journals1;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ExpenseEntry') and text()='Expense'])[2]")
	WebElement Expense_Journals2;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ExpenseEntry') and text()='Expense'])[3]")
	WebElement Expense_Journals3;

	@FindBy(xpath = "(//*[text()='Journals']//following::*[contains(@id,'ExpenseEntry') and text()='Expense'])[4]")
	WebElement Expense_Journals4;

	public void clickExpenseJournal() throws InterruptedException {

		try {
			common.clickElement(Expense_Journals1);

			Thread.sleep(3000);
		} catch (Exception e1) {

			try {
				common.clickElement(Expense_Journals2);

				Thread.sleep(3000);
			} catch (Exception e2) {
				try {
					common.clickElement(Expense_Journals3);

					Thread.sleep(3000);
				} catch (Exception e3) {

					common.clickElement(Expense_Journals4);

					Thread.sleep(3000);
				}
			}
		}
	}

	public void checkFieldsEditableInECAC(String Value) throws InterruptedException {

		String locator = null;

		if (Value.equals("Task code")) {

			locator = "(//*[contains(@id,'TaskCode') and @aria-label='Task code'])";
		}

		if (Value.equals("Description")) {

			locator = "(//*[contains(@id,'GridBudgetLines_Description') and @aria-label='Description'])";
		}

		if (Value.equals("Last activity date")) {

			locator = "(//*[contains(@id,'GridBudgetLines_SISTaskLastActivityDateTime') and @aria-label='Last activity date'])";

		}

		if (Value.equals("Budget category")) {

			locator = "(//*[contains(@id,'BudgetCategoryId') and @aria-label='Budget category'])";

		}

		if (Value.equals("Current budget")) {

			locator = "(//*[contains(@id,'GridBudgetLines_BudgetAmount') and @aria-label='Current budget'])";

		}

		if (Value.equals("Current qty")) {

			locator = "(//*[contains(@id,'GridBudgetLines_CurrentQty') and @aria-label='Current qty'])";

		}

		if (Value.equals("Current unit price")) {

			locator = "(//*[contains(@id,'GridBudgetLines_CurrentUnitPrice') and @aria-label='Current unit price'])";

		}

		if (Value.equals("Current amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_CurrentAmount') and @aria-label='Current amount'])";

		}

		if (Value.equals("Actual qty")) {

			locator = "(//*[contains(@id,'GridBudgetLines_ActualQty') and @aria-label='Actual qty'])";

		}

		if (Value.equals("Actual unit price")) {

			locator = "(//*[contains(@id,'GridBudgetLines_ActualUnitPrice') and @aria-label='Actual unit price'])";

		}

		if (Value.equals("Actual amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_ActualAmount') and @aria-label='Actual amount'])";

		}

		if (Value.equals("Committed cost")) {

			locator = "(//*[contains(@id,'CommittedCost') and @aria-label='Committed cost'])";

		}

		if (Value.equals("Qty to complete")) {

			locator = "(//*[contains(@id,'GridBudgetLines_QtyToComplete') and @aria-label='Qty to complete'])";

		}

		if (Value.equals("Revised qty")) {

			locator = "(//*[contains(@id,'GridBudgetLines_RevisedQty') and @aria-label='Revised qty'])";

		}

		if (Value.equals("Revised rate")) {

			locator = "(//*[contains(@id,'GridBudgetLines_RevisedUnitPrice') and @aria-label='Revised rate'])";

		}
		if (Value.equals("ECAC revised amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_RevisedAmount') and @aria-label='ECAC revised amount'])";

		}
		if (Value.equals("ETC")) {

			locator = "(//*[contains(@id,'GridBudgetLines_ETCAmount') and @aria-label='ETC'])";

		}
		if (Value.equals("ECAC amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_PriorECACAmount') and @aria-label='ECAC amount'])";

		}
		if (Value.equals("ECAC net change")) {

			locator = "(//*[contains(@id,'GridBudgetLines_NetChange') and @aria-label='ECAC net change'])";

		}
		if (Value.equals("Variance")) {

			locator = "(//*[contains(@id,'GridBudgetLines_Variance') and @aria-label='Variance'])";

		}
		if (Value.equals("CTC amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_CTCAmount') and @aria-label='CTC amount'])";

		}
		if (Value.equals("Unspread amount")) {

			locator = "(//*[contains(@id,'GridBudgetLines_UnspreadAmount') and @aria-label='Unspread amount'])";

		}
		if (Value.equals("Workflow status")) {

			locator = "(//*[contains(@id,'GridBudgetLines_WorkflowStatus') and @aria-label='Workflow status'])";

		}

		for (int i = 1; i <= getNumberOfECAClines(); i++) {

			WebElement e = ldriver.findElement(By.xpath(locator + "[" + i + "]"));

			WebElement ActualAmountLocator = ldriver.findElement(By.xpath(
					"(//*[contains(@id,'GridBudgetLines_ActualAmount') and @aria-label='Actual amount'])[" + i + "]"));

			// WebElement taskCodeLocator =
			// ldriver.findElement(By.xpath("(//*[contains(@id,'TaskCode') and
			// @aria-label='Task code'])["+i+"]"));

			if (Value.equals("Task code") || Value.equals("Description") || Value.equals("Last activity date")
					|| Value.equals("Budget category") || Value.equals("Current budget") || Value.equals("Current qty")
					|| Value.equals("Current unit price") || Value.equals("Current amount")
					|| Value.equals("Actual qty") || Value.equals("Actual unit price") || Value.equals("Actual amount")
					|| Value.equals("Committed cost") || Value.equals("ECAC amount") || Value.equals("Variance")
					|| Value.equals("CTC amount") || Value.equals("Unspread amount")
					|| Value.equals("Workflow status")) {

				checkFieldIsNotEditable(Value, e);

			} else if (Value.equals("Revised rate") || Value.equals("ECAC net change")) {

				checkFieldIsEditable(Value, e);

			} else if (Value.equals("Qty to complete") || Value.equals("Revised qty")) {

				WebElement BudgetCategory = ldriver.findElement(By
						.xpath("(//*[contains(@id,'BudgetCategoryId') and @aria-label='Budget category'])[" + i + "]"));

				String BudgetCategoryValue = common.getValue(BudgetCategory);

				if (BudgetCategory_ECACcalctype_Mapping.get(BudgetCategoryValue).equals("Quantity based")) {

					Thread.sleep(3000);

					checkFieldIsEditable(Value, e);

				} else {

					checkFieldIsNotClickable(Value, e);
				}

			} else if (Value.equals("ECAC revised amount")) {

				WebElement BudgetCategory = ldriver.findElement(By
						.xpath("(//*[contains(@id,'BudgetCategoryId') and @aria-label='Budget category'])[" + i + "]"));

				String BudgetCategoryValue = common.getValue(BudgetCategory);

				if (BudgetCategory_ECACcalctype_Mapping.get(BudgetCategoryValue).equals("Amount based")) {

					checkFieldIsEditable(Value, e);

				} else {

					checkFieldIsNotClickable(Value, e);
				}

			} else if (Value.equals("ETC")) {

				checkFieldIsNotClickable(Value, e);

			}

			common.scrollIntoView(ActualAmountLocator);

			Thread.sleep(3000);

			common.clickElement(ActualAmountLocator);

			common.KeyboardAction("Down");

		}
		clickSave();

		clickClose();

		clickRefresh();

		clickEdit();

	}

	public void checkFieldIsNotClickable(String value, WebElement e) throws InterruptedException {

		String CurrentValue = common.getValue(e);

		String ModifiedValue = "12";

		try {

			common.clickElement(e);

			common.setTextAfterDelete(e, ModifiedValue);

			String ModifiedValue_Actual = common.getValue(e);

			Assert.assertEquals(ModifiedValue_Actual, CurrentValue, value + " is editable which is not expected");

			logger.info(value + " is editable which is not expected");

		} catch (Exception e1) {

			logger.info(value + " is not editable as expected");

			String ModifiedValue_Actual = common.getValue(e);

			Assert.assertEquals(ModifiedValue_Actual, CurrentValue, value + " is editable which is not expected");
		}

	}

	// =============Project ready for ECAC====================

	@FindBy(xpath = "//*[contains(@aria-labelledby,'ProjStage_Stage')]")
	WebElement Projectstage_Project;

	@FindBy(xpath = "//*[contains(@name,'SISProjLastActivityDateTime')]")
	WebElement Lastactivitydate_Project;

	@FindBy(xpath = "//*[contains(@name,'SISLastECACDateTime')]")
	WebElement LastECACDate_Project;

	public void getProjectData_Project(String arg1) throws InterruptedException, ParseException {

		if (arg1.equals("Project stage")) {

			ProjectStage_Project = common.getValue(Projectstage_Project);

		} else if (arg1.equals("Last activity date")) {

			DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss a");

			String LastAtivityDate_Project = common.getValue(Lastactivitydate_Project);

			LastActivityDate_Project = dateFormat.format(dateFormat.parse(LastAtivityDate_Project)).replace("am", "AM")
					.replace("pm", "PM");

		} else if (arg1.equals("Last ECAC Date")) {

			LastECACdate_Project = common.getValue(LastECACDate_Project);

		}

	}

	@FindBy(xpath = "//*[@aria-label='Project stage']")
	WebElement Projectstage_ProjectReadyForECAC;

	@FindBy(xpath = "//*[@aria-label='Last ECAC Date']")
	WebElement LastECACDate_ProjectReadyForECAC;

	@FindBy(xpath = "//*[@aria-label='Last activity date']")
	WebElement Lastactivitydate_ProjectReadyForECAC;

	public void checkProjectstage_ProjectReadyForECAC(String arg1) throws InterruptedException {

		if (arg1.equals("Project stage")) {

			String ActualProjectStage = common.getValue(Projectstage_ProjectReadyForECAC);

			Assert.assertEquals(ActualProjectStage, ProjectStage_Project,
					"Project stage is not In Process, which is not as expected");

		}
		if (arg1.equals("Last ECAC Date")) {

			String ActualLastECACDate = common.getValue(LastECACDate_ProjectReadyForECAC);

			Assert.assertEquals(ActualLastECACDate, LastECACdate_Project, "Last ECAC date is not as expected");

		}
		if (arg1.equals("Last activity date")) {

			String ActualLastActivityDate = common.getValue(Lastactivitydate_ProjectReadyForECAC);

			Assert.assertEquals(ActualLastActivityDate, LastActivityDate_Project,
					"Last activity date is not as expected");

		}

	}

	public void checkProjectAvailableInProjReadyForECAC() throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm:ss a");

		Date Lastactivitydate = dateFormat.parse(LastActivityDate_Project);

		Date LastECACdate = dateFormat.parse(LastECACdate_Project);

		if (Lastactivitydate == LastECACdate) {

			Assert.assertEquals(common.isTextDisplayed(ProjectID_ProjReadyForECAC), false,
					"Project ID is displayed which is not expected when Last activity date is equal to Last ECAC date");

		} else if (Lastactivitydate.after(LastECACdate)) {

			Assert.assertEquals(common.isTextDisplayed(ProjectID_ProjReadyForECAC), true,
					"Project ID is not displayed which is not expected when Last activity date is greater than Last ECAC date");
		}
	}

	@FindBy(xpath = "(//*[@aria-label='Project ID'])[2]")
	WebElement ProjectID_ECAC;

	@FindBy(xpath = "(//*[@aria-label='Project ID'])")
	WebElement ProjectID_ProjReadyForECAC;

	@FindBy(xpath = "//*[@aria-label='Budget status']")
	WebElement ECACStatus_ECAC;

	public void ProjectID_ECAC_ECACDisplayed() throws InterruptedException {

		if (common.isTextDisplayed(ProjectID_ECAC) == false) {

			logger.info("ECAC is not displayed as expected");

			Assert.assertTrue(true);

		} else {

			if (!common.getValue(ECACStatus_ECAC).equals("Committed")) {

				logger.info("ECAC status is not committed as expected");

				Assert.assertTrue(true);

			} else {

				Assert.fail("ECAC status is committed which is not expected");
			}
		}

	}
//==============Loss making Project====================

	public String isLossMakingProject() {

		return LossMakingProject_toggle.getAttribute("aria-checked");

	}

	@FindBy(xpath = "//*[text()='Loss making project']//following::*[contains(@id,'SISLossMakingProject_toggle')]")
	WebElement LossMakingProject_toggle;

	public void checkLossMakingProject(String arg1) throws NumberFormatException, InterruptedException {

		if (arg1.equals("Loss making project")) {

			if (formulas.isValue1Greater(ECACcost_ECAC_PFOReport, CurrentCV_PFOReport) == true) {

				Assert.assertEquals(isLossMakingProject(), "true",
						"The project is not a Loss making project which is not expected");

			} else {

				Assert.assertEquals(isLossMakingProject(), "false",
						"The project is a Loss making project which is not expected");

			}
		}
	}

	public void clickItemrequirements() throws InterruptedException {

		common.clickElement(Itemrequirements);
	}

	@FindBy(xpath = "//*[contains(@id,'ProjCategoryId') and @aria-label='Category']")
	WebElement Category_ItemRequirements;

	@FindBy(xpath = "//*[text()='Product dimensions']")
	WebElement ProductDimensions;

	public void setItemRequirements() throws InterruptedException, IOException {

		for (ArrayList<String> ItemRequirement : ItemReqirements) {

			String ItemNumberValue = ItemRequirement.get(0);

			String QuantityValue = ItemRequirement.get(1);

			String TaskCodeValue = ItemRequirement.get(2);

			String CategoryValue = ItemRequirement.get(3);

			String Warehouse_JournalValue = ItemRequirement.get(5);

			PurchaseUnitPriceValue = ItemRequirement.get(6);

			VendorAccount_Name = ItemRequirement.get(7);

			common.setTextAfterDelete(ItemNumber_Journal, ItemNumberValue);

			common.setTextAfterDelete(Quantity_Journal, QuantityValue);

			common.scrollIntoView(Taskcode_Journal);

			common.setTextAfterDelete(Taskcode_Journal, TaskCodeValue);

			common.setTextAfterDelete(Category_ItemRequirements, CategoryValue);

			common.clickElement(ProductDimensions);

			common.setTextAfterDelete(Warehouse_Journal, Warehouse_JournalValue);

			getExpectedPurchaseOrders_LineDetails(TaskCodeValue, CategoryValue, ItemNumberValue, QuantityValue);

			getExpectedItemRequirement_CommittedCost(TaskCodeValue, CategoryValue, QuantityValue);
		}

	}

	public void getExpectedPurchaseOrders_LineDetails(String TaskCodeValue, String CategoryValue,
			String ItemNumberValue, String QuantityValue) throws InterruptedException {

		ExpectedPurchaseOrders_LineDetails = new ArrayList<String>();

		ExpectedPurchaseOrders_LineDetails.add(ProjectIDValue);

		ExpectedPurchaseOrders_LineDetails.add(TaskCodeValue);

		ExpectedPurchaseOrders_LineDetails.add(CategoryValue);

		ExpectedPurchaseOrders_LineDetails.add(ItemNumberValue);

		ExpectedPurchaseOrders_LineDetails.add(formulas.getNumericValueFormatted(QuantityValue));

		ExpectedPurchaseOrders_LineDetails.add(formulas.getNumericValueFormatted(PurchaseUnitPriceValue));

		ExpectedPurchaseOrders_LineDetails.add(formulas.getProduct(QuantityValue, PurchaseUnitPriceValue));

		System.out.println("ExpectedPurchaseOrders_LineDetails" + ExpectedPurchaseOrders_LineDetails);

	}

	public void getExpectedItemRequirement_CommittedCost(String TaskCodeValue, String CategoryValue,
			String QuantityValue) throws InterruptedException {

		ExpectedItemRequirement_CommittedCost = new ArrayList<String>();

		ExpectedItemRequirement_CommittedCost.add("true");

		ExpectedItemRequirement_CommittedCost.add(ProjectIDValue);

		ExpectedItemRequirement_CommittedCost.add(TaskCodeValue);

		ExpectedItemRequirement_CommittedCost.add(CategoryValue);

		ExpectedItemRequirement_CommittedCost.add(formulas.getNumericValueFormatted(QuantityValue));

		ExpectedItemRequirement_CommittedCost.add(formulas.getNumericValueFormatted(PurchaseUnitPriceValue));

		ExpectedItemRequirement_CommittedCost.add(formulas.getProduct(QuantityValue, PurchaseUnitPriceValue));

	}

	public ArrayList<String> getExpectedPurchaseOrders(String arg1) throws InterruptedException {

		ArrayList<String> Data = new ArrayList<String>();

		Data.add(ReferenceNumber_PurchaseOrder);

		Data.add(VendorAccountValue);

		Data.add(VendorAccountValue);

		Data.add(VendorAccount_Name);

		Data.add(ReferenceType_PurchaseOrder);

		Data.add(arg1);

		Data.add(LineStatus_ItemRequirement);

		return Data;

	}

	public ArrayList<String> getExpectedPurchaseOrderLines() throws InterruptedException, IOException {

		ArrayList<String> Data = new ArrayList<String>();

		for (ArrayList<String> ItemRequirement : ItemReqirements) {

			String ItemNumberValue = ItemRequirement.get(0);

			String QuantityValue = ItemRequirement.get(1);

			String TaskCodeValue = ItemRequirement.get(2);

			PurchaseUnitPriceValue = ItemRequirement.get(6);

			Data.add(ItemNumberValue);

			Data.add(ProductName_ItemRequirement);

			Data.add(TaskCodeValue);

			Data.add(formulas.getNumericValueFormatted(QuantityValue));

			Data.add(formulas.getNumericValueFormatted(PurchaseUnitPriceValue));

			Data.add(formulas.getProduct(QuantityValue, PurchaseUnitPriceValue));

		}
		return Data;

	}

	@FindBy(xpath = "//*[@name='ProjectIdentification_ProjId']")
	WebElement ProjectID_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[@name='PurchLine_SISTaskCode']")
	WebElement TaskCode_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'ProjCategoryId')]")
	WebElement ProjCategory_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'ProjectIdentification_ItemId')]")
	WebElement ItemId_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'PurchQty')]")
	WebElement Quantity_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'PurchPrice')]")
	WebElement PurchaseUnitPrice_PurchaseOrderLineDetails;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'LineAmount')]")
	WebElement LineAmount_PurchaseOrderLineDetails;

	public void getPurchaseOrders_Linedetails() throws InterruptedException, IOException {

		Thread.sleep(5000);

		ActualPurchaseOrders_LineDetails = new ArrayList<String>();

		// WebElement ProjectID =
		// ldriver.findElement(By.xpath("//*[@name='ProjectIdentification_ProjId']"));

		String ProjectIDValue = common.getText(ProjectID_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(ProjectIDValue);

		// WebElement TaskCode =
		// ldriver.findElement(By.xpath("//*[@name='PurchLine_SISTaskCode']"));

		String TaskCodeValue = common.getValue(TaskCode_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(TaskCodeValue);

		// WebElement ProjCategory =
		// ldriver.findElement(By.xpath("//*[contains(@aria-labelledby,'ProjCategoryId')]"));

		String ProjCategoryValue = common.getText(ProjCategory_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(ProjCategoryValue);

		// WebElement ItemId =
		// ldriver.findElement(By.xpath("//*[contains(@aria-labelledby,'ProjectIdentification_ItemId')]"));

		String ItemIdValue = common.getText(ItemId_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(ItemIdValue);

		// WebElement Quantity =
		// ldriver.findElement(By.xpath("//*[contains(@aria-labelledby,'PurchQty')]"));

		String QuantityValue = common.getValue(Quantity_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(QuantityValue);

		// WebElement PurchaseUnitPrice =
		// ldriver.findElement(By.xpath("//*[contains(@aria-labelledby,'PurchPrice')]"));

		String PurchaseUnitPriceValue = common.getValue(PurchaseUnitPrice_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(PurchaseUnitPriceValue);

		// WebElement LineAmount =
		// ldriver.findElement(By.xpath("//*[contains(@aria-labelledby,'LineAmount')]"));

		String LineAmountValue = common.getValue(LineAmount_PurchaseOrderLineDetails);

		ActualPurchaseOrders_LineDetails.add(LineAmountValue);

		System.out.println("ActualPurchaseOrders_LineDetails" + ActualPurchaseOrders_LineDetails);

	}

	@FindBy(xpath = "//*[contains(@id,'PurchLine_ItemId') and (@aria-label='Item number')]")
	WebElement ItemId_PurchaseOrderLines;

	@FindBy(xpath = "//*[contains(@id,'ItemName_') and (@aria-label='Product name')]")
	WebElement ProductName_PurchaseOrderLines;

	@FindBy(xpath = "//*[contains(@id,'SIS_TaskCode') and (@aria-label='Task code')]")
	WebElement TaskCode_PurchaseOrderLines;

	@FindBy(xpath = "//*[contains(@id,'PurchQty') and @aria-label='Quantity']")
	WebElement Quantity_PurchaseOrderLines;

	@FindBy(xpath = "//*[@aria-label='Unit price']")
	WebElement PurchaseUnitPrice_PurchaseOrderLines;

	@FindBy(xpath = "//*[@aria-label='Net amount']")
	WebElement LineAmount_PurchaseOrderLines;

	public ArrayList<String> getPurchaseOrder_PurchaseOrderLines() throws InterruptedException, IOException {

		Thread.sleep(5000);

		ArrayList<String> PurchaseOrderLines = new ArrayList<String>();

		// WebElement ItemId =
		// ldriver.findElement(By.xpath("//*[contains(@id,'PurchLine_ItemId') and
		// (@aria-label='Item number')]"));

		String ItemIdValue = common.getValue(ItemId_PurchaseOrderLines);

		PurchaseOrderLines.add(ItemIdValue);

		// WebElement ProductName =
		// ldriver.findElement(By.xpath("//*[contains(@id,'ItemName_') and
		// (@aria-label='Product name')]"));

		String ProductNameValue = common.getValue(ProductName_PurchaseOrderLines);

		PurchaseOrderLines.add(ProductNameValue);

		// WebElement TaskCode =
		// ldriver.findElement(By.xpath("//*[contains(@id,'SIS_TaskCode') and
		// (@aria-label='Task code')]"));

		String TaskCodeValue = common.getValue(TaskCode_PurchaseOrderLines);

		PurchaseOrderLines.add(TaskCodeValue);

		// WebElement Quantity =
		// ldriver.findElement(By.xpath("//*[contains(@id,'PurchQty') and
		// @aria-label='Quantity']"));

		String QuantityValue = common.getValue(Quantity_PurchaseOrderLines);

		PurchaseOrderLines.add(QuantityValue);

		// WebElement PurchaseUnitPrice =
		// ldriver.findElement(By.xpath("//*[@aria-label='Unit price']"));

		String PurchaseUnitPriceValue = common.getValue(PurchaseUnitPrice_PurchaseOrderLines);

		PurchaseOrderLines.add(PurchaseUnitPriceValue);

		// WebElement LineAmount = ldriver.findElement(By.xpath("//*[@aria-label='Net
		// amount']"));

		common.scrollIntoView(LineAmount_PurchaseOrderLines);

		String LineAmountValue = common.getValue(LineAmount_PurchaseOrderLines);

		PurchaseOrderLines.add(LineAmountValue);

		System.out.println("PurchaseOrderLines" + PurchaseOrderLines);

		return PurchaseOrderLines;
	}

	@FindBy(xpath = "//*[@aria-label='Invoice account']")
	WebElement InvoiceAccount_PurchaseOrdersTable;

	@FindBy(xpath = "//*[@aria-label='Vendor name']")
	WebElement VendorName_PurchaseOrdersTable;

	@FindBy(xpath = "//*[@aria-label='Purchase type']")
	WebElement PurchaseType_PurchaseOrdersTable;

	@FindBy(xpath = "//*[@aria-label='Approval status']")
	WebElement ApprovalStatus_PurchaseOrdersTable;

	@FindBy(xpath = "//*[@aria-label='Purchase order status']")
	WebElement PurchaseOrdersStatus_PurchaseOrdersTable;

	public ArrayList<String> getPurchaseOrders_ItemRequirement() throws InterruptedException, IOException {

		Thread.sleep(5000);

		ArrayList<String> data = new ArrayList<String>();

		// WebElement PurchaseOrderID =
		// ldriver.findElement(By.xpath("//*[@aria-label='Purchase order']"));

		String PurcaseOrderIDValue = common.getValue(PurchaseOrders);

		data.add(PurcaseOrderIDValue);

		// WebElement VendorAccount =
		// ldriver.findElement(By.xpath("//*[@aria-label='Vendor account']"));

		String VendorAccountValue = common.getValue(VendorAccount);

		data.add(VendorAccountValue);

		// WebElement InvoiceAccount =
		// ldriver.findElement(By.xpath("//*[@aria-label='Invoice account']"));

		String InvoiceAccountValue = common.getValue(InvoiceAccount_PurchaseOrdersTable);

		data.add(InvoiceAccountValue);

		// WebElement VendorName = ldriver.findElement(By.xpath("//*[@aria-label='Vendor
		// name']"));

		String VendorNameValue = common.getValue(VendorName_PurchaseOrdersTable);

		data.add(VendorNameValue);

		// WebElement PurchaseType =
		// ldriver.findElement(By.xpath("//*[@aria-label='Purchase type']"));

		String PurchaseTypeValue = common.getValue(PurchaseType_PurchaseOrdersTable);

		data.add(PurchaseTypeValue);

		// WebElement ApprovalStatus =
		// ldriver.findElement(By.xpath("//*[@aria-label='Approval status']"));

		common.scrollIntoView(ApprovalStatus_PurchaseOrdersTable);

		String ApprovalStatusValue = common.getValue(ApprovalStatus_PurchaseOrdersTable);

		data.add(ApprovalStatusValue);

		// WebElement PurchaseOrdersStatus =
		// ldriver.findElement(By.xpath("//*[@aria-label='Purchase order status']"));

		common.scrollIntoView(PurchaseOrdersStatus_PurchaseOrdersTable);

		String PurchaseOrdersStatusValue = common.getValue(PurchaseOrdersStatus_PurchaseOrdersTable);

		data.add(PurchaseOrdersStatusValue);

		System.out.println("PurchaseOrders" + data);

		return data;
	}

	public void checkPurchaseOrders_ItemRequirement(String arg1) throws InterruptedException, IOException {

		ArrayList<String> PurchaseOrders_Expected = getExpectedPurchaseOrders(arg1);

		ArrayList<String> PurchaseOrders_Actual = getPurchaseOrders_ItemRequirement();

		logger.info("PurchaseOrders Expected : " + PurchaseOrders_Expected);

		logger.info("PurchaseOrders Actual : " + PurchaseOrders_Actual);

		Assert.assertEquals(PurchaseOrders_Actual, PurchaseOrders_Expected, "PurchaseOrders Data is NOT as expected");

	}

	public void checkPurchaseOrderLines_PurchaseOrder() throws InterruptedException, IOException {

		ArrayList<String> PurchaseOrderLines_Expected = getExpectedPurchaseOrderLines();

		ArrayList<String> PurchaseOrderLines_Actual = getPurchaseOrder_PurchaseOrderLines();

		logger.info("ExpectedPurchaseOrderLines Expected : " + PurchaseOrderLines_Expected);

		logger.info("PurcaseOrder_PurchaseOrderLines Actual : " + PurchaseOrderLines_Actual);

		Assert.assertEquals(PurchaseOrderLines_Actual, PurchaseOrderLines_Expected,
				"PurchaseOrderLines_PurchaseOrder Data is NOT as expected");

	}

	public void checkPurchaseOrders_Linedetails() throws InterruptedException {

		logger.info("ExpectedPurchaseOrders_LineDetails expected: " + ExpectedPurchaseOrders_LineDetails);

		logger.info("ActualPurchaseOrders_LineDetails Actual: " + ActualPurchaseOrders_LineDetails);

		Assert.assertEquals(ActualPurchaseOrders_LineDetails, ExpectedPurchaseOrders_LineDetails,
				"Purchase Orders line details data is not as expected");

	}

	@FindBy(xpath = "//*[text()='Functions']")
	WebElement Functions;

	public void ClickFunctions(String arg1) throws InterruptedException {

		if (arg1.equals("Functions")) {

			common.clickElement(Functions);

		}
	}

	@FindBy(xpath = "//*[text()='Create purchase order']")
	WebElement CreatePO;

	public void ClickCreatePO(String arg1) throws InterruptedException {

		if (arg1.equals("Create purchase order")) {

			common.clickElement(CreatePO);

		}
	}

	@FindBy(xpath = "//*[@aria-label='Vendor account']")
	WebElement VendorAccount;

	public void setVendorAccount_ItemRequirements() throws InterruptedException {

		Thread.sleep(3000);

		// VendoraccountID.clear();

		common.setTextAfterDelete(VendorAccount, VendorAccountValue);
	}

	@FindBy(xpath = "//*[@aria-label='Purchase unit price']")
	WebElement PurchaseUnitPrice;

	public void setPurchaseUnitPrice() throws InterruptedException {

		common.setTextAfterDelete(PurchaseUnitPrice, PurchaseUnitPriceValue);
	}

	@FindBy(xpath = "//*[@aria-label='Include']//following::span")
	WebElement Include_CheckBox;

	public void clickInclude_CheckBox() throws InterruptedException {

		common.clickElement(Include_CheckBox);

		common.KeyboardAction("Tab");
	}

	@FindBy(xpath = "//*[text()='Other']")
	WebElement Other_Tab;

	@FindBy(xpath = "(//*[text()='Project'])[3]")
	WebElement Project_Tab;

	@FindBy(xpath = "//*[text()='General']")
	WebElement General_Tab;

	public void selectItemRequirement_Tab(String arg1) throws InterruptedException {

		if (arg1.equals("Other")) {
			common.clickElement(Other_Tab);
		} else if (arg1.equals("Project")) {
			common.clickElement(Project_Tab);
		} else if (arg1.equals("General")) {
			common.clickElement(General_Tab);

		}
	}

	@FindBy(xpath = "//*[contains(@aria-labelledby,'InventRefId')]")
	WebElement ReferenceNumber;

	@FindBy(xpath = "(//*[contains(@aria-labelledby,'InventRefType')])[1]")
	WebElement ReferenceType;

	public void getReferenceNumberandReferenceType() throws InterruptedException {

		Thread.sleep(5000);

		ReferenceNumber_PurchaseOrder = common.getValue(ReferenceNumber);

		System.out.println("ReferenceNumberValue" + ReferenceNumber_PurchaseOrder);

		Assert.assertNotNull(ReferenceNumber_PurchaseOrder, "ReferenceNumber_PurchaseOrder is null");

		ReferenceType_PurchaseOrder = common.getValue(ReferenceType);

		System.out.println("ReferenceTypeValue" + ReferenceType_PurchaseOrder);

	}

	@FindBy(xpath = "//*[contains(@aria-labelledby,'ItemName')]")
	WebElement ProductName;

	@FindBy(xpath = "(//*[contains(@aria-labelledby,'SalesStatus')])[1]")
	WebElement LineStatus_OpenOrder;

	public void getProductNameandLineStatus() throws InterruptedException {

		Thread.sleep(3000);

		ProductName_ItemRequirement = common.getValue(ProductName);

		LineStatus_ItemRequirement = common.getValue(LineStatus_OpenOrder);

		System.out.println("ProductName_ItemRequirement" + ProductName_ItemRequirement);

		System.out.println("LineStatus_ItemRequirement" + LineStatus_ItemRequirement);

	}

	@FindBy(xpath = "//*[contains(@aria-labelledby,'ProjTransId')]")
	WebElement TransactionID;

	public String getTransactionID_ItemRequirement() throws InterruptedException {

		Thread.sleep(3000);

		TransactionID_ItemRequirement = common.getValue(TransactionID);

		System.out.println("TransactionID_ItemRequirement" + TransactionID_ItemRequirement);

		return TransactionID_ItemRequirement;

	}
//			
//			@FindBy(xpath = "//*[text()='Operation completed']")
//			WebElement ItemRequirementsPostedMessage;
	//
//			public void checkItemRequirementsPostedMessage() throws InterruptedException {
	//
//				// Thread.sleep(2000);
	//
//				Assert.assertTrue(common.isTextDisplayed(ItemRequirementsPostedMessage), "Operation has not been completed");
	//
//			}

	@FindBy(xpath = "//*[text()='Purchase orders']")
	WebElement PurchaseOrder_ItemTasks;

	public void clickItemtasks() throws InterruptedException {

		common.clickElement(Itemtasks);

		common.clickElement(PurchaseOrder_ItemTasks);

	}

	/*
	 * public void clickSection(String arg1, String arg2) throws
	 * InterruptedException {
	 * 
	 * if (arg2.equals("Project cost management")) {
	 * 
	 * clickProjectcostmanagement_PageHeader();
	 * 
	 * if (arg1.equals("New budget")) {
	 * 
	 * clickNewbudget();
	 * 
	 * } if (arg1.equals("ECAC")) { clickECAC(); }
	 * 
	 * if (arg1.equals("Project change order")) { clickProjectchangeorder1(); } //
	 * Added by Carolin if (arg1.equals("Customer change orders")) {
	 * 
	 * clickCustomerchangeorders(); } // Added by Monica if
	 * (arg1.equals("All transactions")) {
	 * 
	 * common.clickElement(Alltransactions); }
	 * 
	 * if (arg1.equals("Budget versions")) {
	 * 
	 * try { common.clickElement(Budgetversions1); }
	 * 
	 * catch (Exception e) { common.clickElement(Budgetversions2); } }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Contracts")) {
	 * 
	 * if (arg1.equals("Construction contract")) {
	 * 
	 * clickConstructioncontract(); }
	 * 
	 * else if (arg1.equals("Subcontracts")) {
	 * 
	 * clickSubcontract();
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Related information")) {
	 * 
	 * if (arg1.equals("Posted transactions")) {
	 * 
	 * try {
	 * 
	 * common.clickElement(Postedtransactions1);
	 * 
	 * } catch (Exception e) {
	 * 
	 * common.clickElement(Postedtransactions2);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * else if (arg1.equals("Item tasks")) {
	 * 
	 * clickItemtasks(); } }
	 * 
	 * if (arg2.equals("Journals")) {
	 * 
	 * clickProjectTab();
	 * 
	 * if (arg1.equals("Hour")) {
	 * 
	 * clickHourJournal(); }
	 * 
	 * if (arg1.equals("Item")) {
	 * 
	 * clickItemJournal(); }
	 * 
	 * if (arg1.equals("Expense")) {
	 * 
	 * clickExpenseJournal(); }
	 * 
	 * }
	 * 
	 * if (arg2.equals("Control")) {
	 * 
	 * if (arg1.equals("Committed Cost")) {
	 * 
	 * try {
	 * 
	 * common.clickElement(Committedcost1);
	 * 
	 * } catch (Exception e) {
	 * 
	 * common.clickElement(Committedcost2);
	 * 
	 * }
	 * 
	 * } }
	 * 
	 * if (arg2.equals("Bill")) {
	 * 
	 * if (arg1.equals("Invoice journals")) {
	 * 
	 * Thread.sleep(5000);
	 * 
	 * clickInvoiceJournal();
	 * 
	 * } } }
	 */

	/*
	 * public void selectSearchOptions(String arg1) throws InterruptedException {
	 * 
	 * if (arg1.equals("ProjectID")) { clickProjectID(); } if
	 * (arg1.equals("Task Description")) { clickJobdescription(); } if
	 * (arg1.equals("Batch Job ID")) { clickBatchjobID(); } if
	 * (arg1.equals("Category Id")) { clickCategoryID(); }
	 * 
	 * // Added by Carolin if (arg1.equals("Change order Id")) {
	 * 
	 * // Thread.sleep(4000); clickChangeOrderID(); }
	 * 
	 * if (arg1.equals("Invoice")) {
	 * 
	 * clickInvoice();
	 * 
	 * }
	 * 
	 * if (arg1.equals("Date")) {
	 * 
	 * setDate_Postedprojecttransactions();
	 * 
	 * }
	 * 
	 * // arthi if (arg1.equals("Purchase order")) {
	 * 
	 * clickPurchaseOrder_Search();
	 * 
	 * }
	 * 
	 * if (arg1.equals("Transaction ID")) {
	 * 
	 * clickTransactionID_Search();
	 * 
	 * }
	 * 
	 * }
	 */

	public void setFilterField(String arg1) throws InterruptedException {

		if (arg1.equals("ProjectID")) {

			logger.info("Project ID: " + ProjectID_Journal);

			setFilterFieldText(ProjectID_Journal);

		}

		if (arg1.equals("Task Description")) {

			setFilterFieldText(TaskDescription_RefreshProjFinData);

		}

		if (arg1.equals("Batch Job ID")) {

			setFilterFieldText(JobID);

		}

		if (arg1.equals("Category Id")) {

			setFilterFieldText(CategoryID);

		}

		/*
		 * // Added by Carolin if (arg1.equals("Change order Id")) {
		 * 
		 * setFilterFieldText(ChangeOrderIdValue); }
		 */

		if (arg1.equals("Invoice")) {

			setFilterFieldText(VendorInvoices.get("1"));

		}

		if (arg1.equals("Current Period")) {

			setFilterFieldText(common.getCurrentMonthEndDate());

		}

		if (arg1.equals("Next Period")) {

			setFilterFieldText(common.getNextMonthEndDate());

		}

		if (arg1.equals("Invoice_CustomerPayment")) {

			setFilterFieldText(InvoiceJournalIDValue);

		}

		if (arg1.equals("Purchase Order ID")) {

			setFilterFieldText(ReferenceNumber_PurchaseOrder);

		}

		if (arg1.equals("Transaction ID")) {

			setFilterFieldText(TransactionID_ItemRequirement);

		}

	}

	@FindBy(xpath = "//*[contains(@class,'isFilterable') and contains(@id,'_PurchId')]")
	WebElement PurchaseOrder_Search;

	public void clickPurchaseOrder_Search() throws InterruptedException {

		Thread.sleep(4000);

		common.clickElement(PurchaseOrder_Search);

	}

	@FindBy(xpath = "(//*[text()='Transaction ID']//parent::div)[1]")
	WebElement TransactionID_Search;

	public void clickTransactionID_Search() throws InterruptedException {

		Thread.sleep(4000);

		common.scrollIntoView(TransactionID_Search);

		common.clickElement(TransactionID_Search);

	}

	@FindBy(xpath = "//*[@aria-label='Purchase order']")
	WebElement PurchaseOrders;

	public void clickPurchaseOrder_ItemRequirement() throws InterruptedException {

		common.clickElement(PurchaseOrders);

	}

	@FindBy(xpath = "//button[normalize-space()='Line details']")
	WebElement LineDetails;

	public void clickLineDetails() throws InterruptedException {

		if (!common.isSectionExpanded(LineDetails)) {

			common.clickElement(LineDetails);

		}

	}

	@FindBy(xpath = "(//*[text()='Project'])[3]")
	WebElement Project_tab;

	public void clickProject_LineDetails() throws InterruptedException {

		Thread.sleep(3000);

		common.clickElement(Project_tab);

	}

	@FindBy(xpath = "//*[contains(@id,'Purchase_button')]")
	WebElement Purchase;

	public void clickPurchase() throws InterruptedException {

		common.clickElement(Purchase);

	}

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement Confirm_Purchase;

	public void clickConfirm_Purchase(String arg1) throws InterruptedException {

		if (arg1.equals("Confirm")) {

			common.clickElement(Confirm_Purchase);

		}
	}
	/*
	 * public void checkCommittedCostTable(String arg1) throws InterruptedException
	 * {
	 * 
	 * if (arg1.equals("SubContract_Revision1")) {
	 * 
	 * ArrayList<ArrayList<String>> CommittedCost_Expected =
	 * SubContractCommittedCost_Expected.get(arg1);
	 * 
	 * ArrayList<ArrayList<String>> CommittedCost_Actual = getCommittedCostTable();
	 * 
	 * logger.info("SubContractCommittedCost Expected : " +
	 * SubContractCommittedCost_Expected);
	 * 
	 * logger.info("CommittedCost Actual : " + CommittedCost_Actual);
	 * 
	 * Assert.assertEquals(CommittedCost_Actual, CommittedCost_Expected,
	 * "Committed Cost Data is NOT as expected");
	 * 
	 * }
	 * 
	 * else if (arg1.equals("Item requirement")) {
	 * 
	 * clickGeneralTab();
	 * 
	 * clickOverview_committedcost();
	 * 
	 * ExpectedItemRequirement_CommittedCost.add(arg1);
	 * 
	 * ExpectedItemRequirement_CommittedCost.add("");
	 * 
	 * ArrayList<ArrayList<String>> CommittedCost_Actual = getCommittedCostTable();
	 * 
	 * logger.info("ExpectedItemRequirement_CommittedCost Expected : " +
	 * ExpectedItemRequirement_CommittedCost);
	 * 
	 * logger.info("CommittedCost Actual : " + CommittedCost_Actual);
	 * 
	 * Assert.assertTrue(CommittedCost_Actual.contains(
	 * ExpectedItemRequirement_CommittedCost),
	 * "ItemRequirement_Committedcost Table values is not as expected");
	 * 
	 * } }
	 */

	@FindBy(xpath = "(//*[text()='Apply'])")
	WebElement Apply1;

	@FindBy(xpath = "(//*[text()='Apply'])[2]")
	WebElement Apply2;

	@FindBy(xpath = "(//*[text()='Apply'])[3]")
	WebElement Apply3;

	@FindBy(xpath = "(//*[text()='Apply'])[4]")
	WebElement Apply4;

	@FindBy(xpath = "(//*[text()='Apply'])[5]")
	WebElement Apply5;

	public void clickApply() throws InterruptedException {

		try {

			common.clickElementJS(Apply1);
		}

		catch (Exception e) {

			try {
				common.clickElementJS(Apply2);
			}

			catch (Exception e1) {

				try {

					common.clickElementJS(Apply3);
				} catch (Exception e2) {
					try {

						common.clickElementJS(Apply4);
					} catch (Exception e3) {
						common.clickElementJS(Apply5);

					}
				}

			}
		}
		Thread.sleep(5000);
	}

	public ArrayList<ArrayList<String>> getCommittedCostTable() throws InterruptedException {

		Thread.sleep(1000);
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<ArrayList<String>> dataSet = new ArrayList<ArrayList<String>>();

		JavascriptExecutor js = (JavascriptExecutor) ldriver;

		js.executeScript("arguments[0].scrollIntoView(true);", ProjectID_CommittedCost);

		logger.info("NumberofLinesInCommittedCost: " + getNumberofLinesInCommittedCost());

		for (int row = 1; row <= getNumberofLinesInCommittedCost(); row++) {

			WebElement Open = ldriver
					.findElement(By.xpath("(//*[@aria-label='Open'])[" + row + "]//child::*[@type='checkbox']"));

			String OpenCheckbox;
			try {
				Open.getAttribute("Checked");
				OpenCheckbox = "true";
			} catch (Exception e) {
				OpenCheckbox = "false";
			}

			System.out.println("OpenCheckbox" + OpenCheckbox);

			WebElement ProjectID = ldriver.findElement(
					By.xpath("(//*[@aria-label='Project ID' and not(contains(@id,'ProjTable'))])[" + row + "]"));

			String ProjectIDValue = common.getValue(ProjectID);

			WebElement Taskcode = ldriver.findElement(By.xpath("(//*[@aria-label='Task code'])[" + row + "]"));

			String TaskcodeValue = common.getValue(Taskcode);

			WebElement Category = ldriver.findElement(By.xpath("(//*[@aria-label='Category'])[" + row + "]"));

			String CategoryValue = common.getValue(Category);

			WebElement Quantity = ldriver.findElement(By.xpath("(//*[@aria-label='Quantity'])[" + row + "]"));

			String QuantityValue = common.getValue(Quantity);

			WebElement CostPrice = ldriver.findElement(By.xpath("(//*[@aria-label='Cost price'])[" + row + "]"));

			String CostPriceValue = common.getValue(CostPrice);

			WebElement Costamount = ldriver.findElement(By.xpath("(//*[@aria-label='Cost amount'])[" + row + "]"));

			String CostamountValue = common.getValue(Costamount);

			WebElement Transactionorigin = ldriver
					.findElement(By.xpath("(//*[@aria-label='Transaction origin'])[" + row + "]"));

			String TransactionoriginValue = common.getValue(Transactionorigin);

			WebElement Vendor = ldriver.findElement(By.xpath("(//*[@aria-label='Vendor'])[" + row + "]"));

			String VendorValue = common.getValue(Vendor);

			data.add(OpenCheckbox);
			data.add(ProjectIDValue);
			data.add(TaskcodeValue);
			data.add(CategoryValue);
			data.add(QuantityValue);
			data.add(CostPriceValue);
			data.add(CostamountValue);
			data.add(TransactionoriginValue);
			data.add(VendorValue);
			dataSet.add(new ArrayList<String>(data));

			data.clear();
		}

		logger.info(dataSet);
		return dataSet;
	}

	@FindBy(xpath = "(//*[text()='Overview'])")
	WebElement Overview1;

	public void clickOverview_committedcost() throws InterruptedException {

		Thread.sleep(5000);

		common.clickElement(Overview1);

	}

	public void getPFOvalue(String arg1) throws InterruptedException {

		if (arg1.equals("Current CV")) {

			CurrentCV_PFOReport = getcurrentCV();

		}

		if (arg1.equals("ECAC Cost_ECAC")) {

			ECACcost_ECAC_PFOReport = getECACcost_ECAC();

		}
	}

	// constructor =============ItemReqirements=rd.getXl_ItemRequirements();

	// arthi Additional Scenario

	@FindBy(xpath = "//*[@class='toggle-box' and contains(@aria-describedby,'CreateItemReqForPO')]//following-sibling::*[@class='toggle-value']")
	WebElement CreateItemRequirement;

	public void CheckCreateItemRequirement() throws InterruptedException {

		Thread.sleep(5000);

		String CreateItemRequirement_value = common.getText(CreateItemRequirement);

		Assert.assertEquals(CreateItemRequirement_value, "No", "CreateItemRequirement Toggle is not as expected");
	}

	@FindBy(xpath = "//*[contains(@class,'appBarTab') and text()='Plan']")
	WebElement Plan;

	public void clickPlanTab() throws InterruptedException {

		common.clickElement(Plan);
	}

	public void clickPageHeader(String arg1) throws InterruptedException {

		if (arg1.equals("Project cost management")) {

			clickProjectcostmanagement_PageHeader();
		}

		if (arg1.equals("Manage")) {

			clickManage();

		}

		if (arg1.equals("Control")) {

			try {

				common.clickElement(Control1);

			} catch (Exception e) {

				common.clickElement(Control2);

			}

		}

		if (arg1.equals("Project")) {

			clickProjectTab();
		}

		if (arg1.equals("Plan")) {

			clickPlanTab();
		}

	}

	// =============Cash position pre-conditions====================

	@FindBy(xpath = "//*[text()='AP']")
	WebElement AP_Tab_Project360;

	public void clickAP_Tab_Project360() throws InterruptedException {

		common.clickElement(AP_Tab_Project360);

	}

	@FindBy(xpath = "//*[@aria-label='Name']")
	List<WebElement> NumberOfRowsIn_AP_Project360;

	public int numberOfRowsIn_AP_Project360() {

		return NumberOfRowsIn_AP_Project360.size();

	}

	public void getSumOfAmountAndAmountToRetainInProject360() throws InterruptedException {

		TotalAmount_AP_Project360 = "0.00";

		TotalAmountToRetain_AP_Project360 = "0.00";

		TotalSettledAmount_AP_Project360 = "0.00";

		Thread.sleep(5000);

		for (int i = 1; i <= numberOfRowsIn_AP_Project360(); i++) {

			WebElement Amount_AP_Project360 = ldriver.findElement(By.xpath("(//*[@aria-label='Amount'])[" + i + "]"));

			// common.scrollIntoView(Amount_AP_Project360);

			Thread.sleep(3000);

			String Amount_AP_Value = common.getValue(Amount_AP_Project360);

			TotalAmount_AP_Project360 = formulas.getSum(TotalAmount_AP_Project360, Amount_AP_Value);

			WebElement AmountToRetain_AP_Project360 = ldriver
					.findElement(By.xpath("(//*[@aria-label='Amt. to retain'])[" + i + "]"));

			// common.scrollIntoView(AmountToRetain_AP_Project360);

			Thread.sleep(3000);

			String AmountToRetain_AP_Value = common.getValue(AmountToRetain_AP_Project360);

			TotalAmountToRetain_AP_Project360 = formulas.getSum(TotalAmountToRetain_AP_Project360,
					AmountToRetain_AP_Value);

			WebElement SettledAmount_AP_Project360 = ldriver
					.findElement(By.xpath("(//*[@aria-label='Settled amount in standard currency'])[" + i + "]"));

			// common.scrollIntoView(AmountToRetain_AP_Project360);

			Thread.sleep(3000);

			String SettledAmount_AP_Value = common.getValue(SettledAmount_AP_Project360);

			TotalSettledAmount_AP_Project360 = formulas.getSum(TotalSettledAmount_AP_Project360,
					SettledAmount_AP_Value);
		}

		logger.info("Total amount in AP tab in Project 360 : " + TotalAmount_AP_Project360);
		System.out.println("Total amount in AP tab in Project 360 : " + TotalAmount_AP_Project360);
		logger.info("Total amount to retain in AP tab in Project 360 : " + TotalAmountToRetain_AP_Project360);
		System.out.println("Total amount to retain in AP tab in Project 360 : " + TotalAmountToRetain_AP_Project360);
		logger.info("Total settled amount in AP tab in Project 360 : " + TotalSettledAmount_AP_Project360);
		System.out.println("Total settled amount in AP tab in Project 360 : " + TotalSettledAmount_AP_Project360);
	}

	public void clickSection(String arg1, String arg2) throws InterruptedException {

		if (arg2.equals("Project cost management")) {

			clickProjectcostmanagement_PageHeader();

			if (arg1.equals("New budget")) {

				clickNewbudget();

			}
			if (arg1.equals("ECAC")) {
				clickECAC();
			}

			if (arg1.equals("Project change order")) {
				clickProjectchangeorder1();
			}
			// Added by Carolin
			if (arg1.equals("Customer change orders")) {

				clickCustomerchangeorders();
			}
			// Added by Monica
			if (arg1.equals("All transactions")) {

				common.clickElement(Alltransactions);
			}

			if (arg1.equals("Budget versions")) {

				try {
					common.clickElement(Budgetversions1);
				}

				catch (Exception e) {
					common.clickElement(Budgetversions2);
				}
			}

		}
		// Added by Monica
		if (arg2.equals("Inquiries and reports")) {

			if (arg1.equals("Project 360")) {

				common.clickElementJS(Project360);
			}

		}

		if (arg2.equals("Contracts")) {

			if (arg1.equals("Construction contract")) {

				clickConstructioncontract();
			}

			else if (arg1.equals("Subcontracts")) {

				clickSubcontract();

			}
		}

		if (arg2.equals("Related information")) {

			if (arg1.equals("Posted transactions")) {

				try {
					common.clickElement(Postedtransactions1);
				} catch (Exception e) {
					common.clickElement(Postedtransactions2);
				}

			}
		}

		if (arg2.equals("Journals")) {

			clickProjectTab();

			if (arg1.equals("Hour")) {

				clickHourJournal();
			}

			if (arg1.equals("Item")) {

				clickItemJournal();
			}

			if (arg1.equals("Expense")) {

				clickExpenseJournal();
			}

		}

		if (arg2.equals("Control")) {

			if (arg1.equals("Committed Cost")) {

				try {
					common.clickElement(Committedcost1);
				} catch (Exception e) {
					common.clickElement(Committedcost2);
				}

			}
		}

		if (arg2.equals("Bill")) {

			if (arg1.equals("Invoice journals")) {

				Thread.sleep(5000);

				clickInvoiceJournal();

			}
		}
	}

	// ================Validate application report===================

	@FindBy(xpath = "//*[text()='Projects ready for ECAC']")
	WebElement ProjectsreadyforECAC;

	@FindBy(xpath = "//*[text()='PFO batch history']")
	WebElement PFObatchhistory_PCMSubModule;

	@FindBy(xpath = "(//*[text()='Revenue recognition'])[3]")
	WebElement Revenuerecognition_PCMSubModule;

	@FindBy(xpath = "//*[text()='Batch jobs']")
	WebElement Batchjobs_SysAdmSubModule;

	@FindBy(xpath = "//*[text()='Project Role']")
	WebElement ProjectRole_PCMSubModule;

	@FindBy(xpath = "//*[text()='Feature management']")
	WebElement Featuremanagement_SysAdmnModule;

	@FindBy(xpath = "//*[text()='Human resources']")
	WebElement Humanresources_Module;

	@FindBy(xpath = "//*[text()='Employees']")
	WebElement Employees_HRmodule;

	@FindBy(xpath = "//*[text()='Organization administration']")
	WebElement Organizationadministration;

	@FindBy(xpath = "//*[text()='Legal entities']")
	WebElement Legalentities_OAsubmodule;

	public void clickModulesAndSubModules(String arg1, String arg2) throws InterruptedException

	{

		clickModules();

		if (arg2.equals("Project cost management")) {

			common.clickElement(Projectcostmanagement);

			Thread.sleep(2000);

			clickExpandall();

			Thread.sleep(2000);

			if (arg1.equals("Project Role")) {

				common.clickElement(ProjectRole_PCMSubModule);

				Thread.sleep(2000);

			}

			if (arg1.equals("All projects")) {

				common.clickElement(Allprojects);

				Thread.sleep(2000);

			}

			if (arg1.equals("Project allocation rules")) {

				common.clickElement(Projectallocationrules_PCMSubModule);

				Thread.sleep(2000);
			}
			// Added by Monica on 6/2/23

			if (arg1.equals("PFO batch history")) {

				common.clickElement(PFObatchhistory_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Revenue recognition")) {

				common.clickElement(Revenuerecognition_PCMSubModule);

				Thread.sleep(1000);
			}
			if (arg1.equals("Project contracts")) {

				common.clickElement(Projectcontracts_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project budgets")) {

				common.clickElement(Projectbudgets_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project change order")) {

				common.clickElement(Projectchangeorder_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("ECAC")) {

				common.clickElement(ECAC_PCMSubModuleProjBudget);

				Thread.sleep(1000);
			}

			if (arg1.equals("Summary ECAC - request")) {

				common.clickElement(SummaryECACrequest_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Set ECAC to actual")) {

				common.clickElement(SetECACtoactual_PCMSubModuleProjBudget);

				Thread.sleep(1000);
			}

			if (arg1.equals("Customer change orders")) {

				common.clickElement(Customerchangeorders_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Construction contracts")) {

				common.clickElement(Constructioncontracts_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Construction applications")) {

				common.clickElement(Constructionapplications_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Subcontracts")) {

				common.clickElement(Subcontracts_PCMSubModuleSubcontracts);

				Thread.sleep(1000);
			}

			if (arg1.equals("All vendors")) {

				common.clickElement(Allvendors_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Loss making project")) {

				common.clickElement(Lossmakingproject_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Loss making audit trail")) {

				common.clickElement(Lossmakingaudittrail_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Revenue recognition audit trail")) {

				common.clickElement(Revenuerecognitionaudittrail_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project allocation rates")) {

				common.clickElement(Projectallocationrates_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Overhead transaction inquiry")) {

				common.clickElement(Overheadtransactioninquiry_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO template excel export")) {

				common.clickElement(PFOtemplateexcelexport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO template excel import")) {

				common.clickElement(PFOtemplateexcelimport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PCA template excel export")) {

				common.clickElement(PCAtemplateexcelexport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PCA template excel import")) {

				common.clickElement(PCAtemplateexcelimport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Refresh project financials data")) {

				common.clickElement(Refreshprojectfinancialsdata_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Refresh PCA data")) {

				common.clickElement(RefreshPCAdata_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project dimension setup table update")) {

				common.clickElement(Projectdimensionsetuptableupdate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Delete project financial data")) {

				common.clickElement(Deleteprojectfinancialdata_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO & PCA data refresh")) {

				common.clickElement(PFOPCAdatarefresh_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Refresh project cost by cost type")) {

				common.clickElement(Refreshprojectcostbycosttype_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PCA batch history")) {

				common.clickElement(PCAbatchhistory_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project budget Import")) {

				common.clickElement(ProjectbudgetImport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Import budget from excel")) {

				common.clickElement(Importbudgetfromexcel_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Approve budgets")) {

				common.clickElement(Approvebudgets_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Commit approved budgets")) {

				common.clickElement(Commitapprovedbudgets_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Verify subcontract compliance")) {

				common.clickElement(Verifysubcontractcompliance_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Release invoices")) {

				common.clickElement(Releaseinvoices_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Create construction contract template")) {

				common.clickElement(Createconstructioncontracttemplate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Import construction contract from excel")) {

				common.clickElement(Importconstructioncontractfromexcel_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Create ECAC import template")) {

				common.clickElement(CreateECACimporttemplate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Import ECAC from excel")) {

				common.clickElement(ImportECACfromexcel_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Approve ECAC")) {

				common.clickElement(ApproveECAC_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Commit approved ECAC")) {

				common.clickElement(CommitapprovedECAC_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Set ECAC to actual")) {

				common.clickElement(SetECACtoactual_PCMSubModuleECAC);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project cost analysis BI data provider")) {

				common.clickElement(ProjectcostanalysisBIdataprovider_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Production performance BI")) {

				common.clickElement(ProductionperformanceBI_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Last labor date update")) {

				common.clickElement(Lastlabordateupdate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Last invoice date update")) {

				common.clickElement(Lastinvoicedateupdate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Time and material percent complete")) {

				common.clickElement(Timeandmaterialpercentcomplete_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Time and material percent complete audit trail")) {

				common.clickElement(Timeandmaterialpercentcompleteaudittrail_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PCA inquiry")) {

				common.clickElement(PCAinquiry_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO Inquiry")) {

				common.clickElement(PFOInquiry_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project summary inquiry")) {

				common.clickElement(Projectsummaryinquiry_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Orphan PFO inquiry")) {

				common.clickElement(OrphanPFOinquiry_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project WIP")) {

				common.clickElement(ProjectWIP_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project summary report")) {

				common.clickElement(Projectsummaryreport_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project cost analysis")) {

				common.clickElement(Projectcostanalysis_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project sales value analysis")) {

				common.clickElement(Projectsalesvalueanalysis_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Revenue recognition preview")) {

				common.clickElement(Revenuerecognitionpreview_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project key performance indicators")) {

				common.clickElement(Projectkeyperformanceindicators_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project ECAC revision history")) {

				common.clickElement(ProjectECACrevisionhistory_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project ECAC margin trend")) {

				common.clickElement(ProjectECACmargintrend_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Customer aging report by project")) {

				common.clickElement(Customeragingreportbyproject_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Vendor aging report by project")) {

				common.clickElement(Vendoragingreportbyproject_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project transaction by contract line")) {

				common.clickElement(Projecttransactionbycontractline_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project actual transactions")) {

				common.clickElement(Projectactualtransactions_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project 360")) {

				common.clickElement(Project360_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Task code by project")) {

				common.clickElement(Taskcodebyproject_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Production performance")) {

				common.clickElement(Productionperformance_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("SOV worksheet")) {

				common.clickElement(SOVworksheet_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Orphan project categories")) {

				common.clickElement(Orphanprojectcategories_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project open invoices")) {

				common.clickElement(Projectopeninvoices_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project customer invoices overdue")) {

				common.clickElement(Projectcustomerinvoicesoverdue_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PCM - Customer account statement")) {

				common.clickElement(PCMCustomeraccountstatement_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("SIS system parameters")) {

				common.clickElement(SISsystemparameters_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project cost management parameters")) {

				common.clickElement(Projectcostmanagementparameters_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project cost management workflow")) {

				common.clickElement(Projectcostmanagementworkflow_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project default dimension setup")) {

				common.clickElement(Projectdefaultdimensionsetup_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO inquiry column setup")) {

				common.clickElement(PFOinquirycolumnsetup_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("PFO inquiry template")) {

				common.clickElement(PFOinquirytemplate_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Budget categories")) {

				common.clickElement(Budgetcategories_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Task codes")) {

				common.clickElement(Taskcodes_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project task - hour sales price")) {

				common.clickElement(Projecttaskhoursalesprice_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Project task templates")) {

				common.clickElement(Projecttasktemplates_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Vendor speciality")) {

				common.clickElement(Vendorspeciality_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Compliance type")) {

				common.clickElement(Compliancetype_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Vendor evaluation criteria")) {

				common.clickElement(Vendorevaluationcriteria_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Last labor project category setup")) {

				common.clickElement(Lastlaborprojectcategorysetup_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Work sites")) {

				common.clickElement(Worksites_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Priority Search")) {

				common.clickElement(PrioritySearch_PCMSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Projects ready for ECAC")) {

				common.clickElement(ProjectsreadyforECAC);

				Thread.sleep(1000);
			}

		}

		if (arg2.equals("Equipment usage")) {

			if (!common.isMenuExpanded(Equipmentusage)) {

				common.clickElement(Equipmentusage);
			}

			Thread.sleep(2000);

			if (arg1.equals("Equipment standard costs")) {

				common.clickElement(Equipmentstandardcosts);

				Thread.sleep(2000);
			}
		}

		if (arg2.equals("Organization administration")) {

			if (!common.isMenuExpanded(Organizationadministration)) {

				common.clickElement(Organizationadministration);
			}

			Thread.sleep(2000);

			if (arg1.equals("Legal entities")) {

				common.clickElement(Legalentities_OAsubmodule);

				Thread.sleep(2000);
			}
		}

		if (arg2.equals("Product information management")) {

			common.clickElement(Productinformationmanagement);

			Thread.sleep(2000);

			if (arg1.equals("Released products")) {

				common.clickElement(Releasedproducts_Products);

				Thread.sleep(2000);
			}
		}

		// Added by Monica on 6/2/23
		if (arg2.equals("System administration")) {

			common.clickElement(Systemadministration);

			Thread.sleep(1000);

			if (arg1.equals("Batch jobs")) {

				common.clickElement(Batchjobs_SysAdmSubModule);

				Thread.sleep(1000);
			}

			if (arg1.equals("Feature management")) {

				common.clickElement(Featuremanagement_SysAdmnModule);

				Thread.sleep(1000);
			}
		}

		if (arg2.equals("Accounts receivable")) {

			common.clickElement(AccountsReceivable);

			Thread.sleep(2000);

			clickExpandall();

			if (arg1.equals("Customer payment journal")) {

				common.clickElement(CustomerPaymentJournal);

				Thread.sleep(3000);
			}
			if (arg1.equals("All customers")) {

				common.clickElement(Allcustomers_ACreceivable);

				Thread.sleep(3000);
			}

		}

		if (arg2.equals("Human resources")) {

			common.clickElement(Humanresources_Module);

			Thread.sleep(2000);

			clickExpandall();

			if (arg1.equals("Employees")) {

				common.clickElement(Employees_HRmodule);

				Thread.sleep(3000);
			}

		}
	}

	@FindBy(xpath = "//*[text()='All customers']")
	WebElement Allcustomers_ACreceivable;

	@FindBy(xpath = "(//*[text()='Feature name'])[4]")
	WebElement Featurename_FilterField;

	@FindBy(xpath = "//*[text()='Role']")
	WebElement Role_FilterField;

	@FindBy(xpath = "( //*[text()='Name'])[2]")
	WebElement Name_EmployeesFilterField;

	public void selectSearchOptions(String arg1) throws InterruptedException {
		if (arg1.equals("ProjectID")) {
			clickProjectID();
		}
		if (arg1.equals("Task Description")) {
			clickJobdescription();
		}
		if (arg1.equals("Batch Job ID")) {
			clickBatchjobID();
		}
		if (arg1.equals("Category Id")) {
			clickCategoryID();
		}

		// Added by Carolin
		if (arg1.equals("Change order Id")) {

			// Thread.sleep(4000);
			clickChangeOrderID();
		}

		if (arg1.equals("Invoice")) {

			clickInvoice();

		}

		if (arg1.equals("Date")) {

			setDate_Postedprojecttransactions();

		}

		if (arg1.equals("Feature name")) {

			common.clickElement(Featurename_FilterField);

			Thread.sleep(3000);

		}

		if (arg1.equals("Role")) {

			common.clickElement(Role_FilterField);

			Thread.sleep(3000);

		}

		if (arg1.equals("Name")) {

			common.clickElement(Name_EmployeesFilterField);

			Thread.sleep(3000);

		}

	}

	@FindBy(xpath = "//*[text()='Project Role']//following::*[text()='New']")
	WebElement New_ProjectRole;

	public void clickNew_ProjectRole() throws InterruptedException {

		common.clickElement(New_ProjectRole);

		Thread.sleep(2000);

	}

	@FindBy(xpath = "//*[@aria-label='Project ID']")
	WebElement ProjectIDLink;

	@FindBy(xpath = "//*[@aria-label='Work site id']")
	WebElement WorksiteIDLink;

	@FindBy(xpath = " //*[@aria-label='Name']")
	WebElement CustomerNameIDLink;

	public void clickLink(String arg1) throws InterruptedException {

		if (arg1.equals("Project ID")) {

			common.clickElement(ProjectIDLink);

		}

		if (arg1.equals("Work site ID")) {

			common.clickElement(WorksiteIDLink);

		}

		if (arg1.equals("Customer Name ID")) {

			common.clickElement(CustomerNameIDLink);

		}
	}

	@FindBy(xpath = "//*[text()='Print application']")
	WebElement Printapplication;

	public void clickPrintapplication() throws InterruptedException {

		common.clickElement(Printapplication);

	}

	// Arthi Vendor and subcontract complaince

	@FindBy(xpath = "//*[(@aria-label='Vendor account')]")
	List<WebElement> NumberOfVendors;

	public int getNumberOfVendorsLines() {

		return NumberOfVendors.size();
	}

	@FindBy(xpath = "(//*[@aria-label='Compliance item' and (@title='Test_Sub')])")
	WebElement Test_Sub_ComplainceItem;

	@FindBy(xpath = "//*[@aria-label='Compliance item' and (@title='Test_Vendor')]")
	WebElement Test_Vendor_ComplainceItem;

	@FindBy(xpath = "//*[@aria-label='Compliance item' and (@title='Test_Vendor2')]")
	WebElement Test_Vendor2_ComplainceItem;

	@FindBy(xpath = "//*[contains(@aria-labelledby,'Description')]")
	WebElement Description_ComplainceItem;

	@FindBy(xpath = "//*[contains(@id,'ComplianceType_input')]")
	WebElement ComplianceType;

	public void getComplianceItem(String arg1) throws InterruptedException {

		Thread.sleep(2000);

		ArrayList<String> data = new ArrayList<String>();

		ArrayList<String> Data_Vendors = new ArrayList<String>();

		HashMap<String, ArrayList<String>> Vendors_Mapping = new HashMap<String, ArrayList<String>>();

		if (arg1.equals("Test_Sub")) {

			common.clickElement(Test_Sub_ComplainceItem);

		}

		else if (arg1.equals("Test_Vendor")) {

			common.clickElement(Test_Vendor_ComplainceItem);

		}

		else if (arg1.equals("Test_Vendor2")) {

			common.clickElement(Test_Vendor2_ComplainceItem);

		}

		Thread.sleep(5000);

		String Description_ComplainceItemValue = common.getValue(Description_ComplainceItem);

		data.add(Description_ComplainceItemValue);

		String ComplianceTypeValue = common.getValue(ComplianceType);

		data.add(ComplianceTypeValue);

		ComplianceItem_Data.put(arg1, data);

		logger.info("ComplianceItem_Data " + ComplianceItem_Data);

		for (int row = 1; row <= getNumberOfVendorsLines(); row++) {

			WebElement Vendoraccount = ldriver
					.findElement(By.xpath("(//*[@aria-label='Vendor account'])[" + row + "]"));

			String VendoraccountValue = common.getValue(Vendoraccount);

			WebElement PolicyNumber = ldriver.findElement(By.xpath("(//*[@aria-label='Policy number'])[" + row + "]"));

			String PolicyNumberValue = common.getValue(PolicyNumber);

			Data_Vendors.add(PolicyNumberValue);

			WebElement Effectivedate = ldriver
					.findElement(By.xpath("(//*[@aria-label='Effective date'])[" + row + "]"));

			String EffectivedateValue = common.getValue(Effectivedate);

			Data_Vendors.add(EffectivedateValue);

			WebElement Expirationdate = ldriver
					.findElement(By.xpath("(//*[@aria-label='Expiration date'])[" + row + "]"));

			String ExpirationdateValue = common.getValue(Expirationdate);

			Data_Vendors.add(ExpirationdateValue);

			WebElement PaymentControl = ldriver
					.findElement(By.xpath("(//*[@aria-label='Payment control'])[" + row + "]"));

			String PaymentControlValue = common.getValue(PaymentControl);

			Data_Vendors.add(PaymentControlValue);

			WebElement AlertType = ldriver.findElement(By.xpath("(//*[@aria-label='Alert type'])[" + row + "]"));

			String AlertTypeValue = common.getValue(AlertType);

			Data_Vendors.add(AlertTypeValue);

			WebElement Status = ldriver.findElement(By.xpath("(//*[@aria-label='Status'])[" + row + "]"));

			String StatusValue = common.getValue(Status);

			if (!StatusValue.equals("Compliant")) {

				common.setTextAfterDelete(Status, "Compliant");

				StatusValue = common.getValue(Status);

			}

			Data_Vendors.add(StatusValue);

			logger.info("Data_Vendors " + Data_Vendors);

			Vendors_Mapping.put(VendoraccountValue, new ArrayList<String>(Data_Vendors));

			Data_Vendors.clear();

		}

		logger.info("Vendors_Mapping : " + Vendors_Mapping);

		ComplianceItem_VendorsMapping.put(arg1, Vendors_Mapping);

		logger.info("ComplianceItem_VendorsMapping : " + ComplianceItem_VendorsMapping);

	}

	@FindBy(xpath = "//*[@aria-label='Compliance item' and contains(@id,'VendorCompliance')]")
	List<WebElement> NumberOfVendorComplianceLines;

	public int getNumberOfVendorComplianceLines() {

		return NumberOfVendorComplianceLines.size();
	}

	public void getVendorComplianceData() throws InterruptedException, ParseException {

		Thread.sleep(2000);

		ArrayList<String> data = new ArrayList<String>();

		for (int row = 1; row <= getNumberOfVendorComplianceLines(); row++) {

			WebElement ComplianceItem = ldriver.findElement(
					By.xpath("(//*[@aria-label='Compliance item' and contains(@id,'VendorCompliance')])[" + row + "]"));

			common.scrollIntoView(ComplianceItem);

			String ComplianceItemValue = common.getValue(ComplianceItem);

			WebElement Description = ldriver.findElement(
					By.xpath("(//*[@aria-label='Description' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String DescriptionValue = common.getValue(Description);

			ArrayList<String> ComplianceItemDatas = ComplianceItem_Data.get(ComplianceItemValue);

			Assert.assertEquals(DescriptionValue, ComplianceItemDatas.get(0), "Description value is not as expected");

			WebElement PolicyNumber = ldriver.findElement(
					By.xpath("(//*[@aria-label='Policy number' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String PolicyNumberValue = common.getValue(PolicyNumber);

			data.add(PolicyNumberValue);

			WebElement EffectiveDate = ldriver.findElement(
					By.xpath("(//*[@aria-label='Effective date' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String EffectiveDateValue = common.getValue(EffectiveDate);

			data.add(EffectiveDateValue);

			WebElement ExpirationDate = ldriver.findElement(
					By.xpath("(//*[@aria-label='Expiration date' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String ExpirationDateValue = common.getValue(ExpirationDate);

			data.add(ExpirationDateValue);

			WebElement PaymentControl = ldriver.findElement(
					By.xpath("(//*[@aria-label='Payment control' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String PaymentControlValue = common.getValue(PaymentControl);

			data.add(PaymentControlValue);

			WebElement AlertType = ldriver.findElement(
					By.xpath("(//*[@aria-label='Alert type' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String AlertTypevalue = common.getValue(AlertType);

			data.add(AlertTypevalue);

			WebElement Status = ldriver.findElement(
					By.xpath("(//*[@aria-label='Status' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String StatusValue = common.getValue(Status);

			data.add(StatusValue);

			HashMap<String, ArrayList<String>> ComplianceItem_Vendors = ComplianceItem_VendorsMapping
					.get(ComplianceItemValue);

			ArrayList<String> VendorsData = ComplianceItem_Vendors.get(VendorAccountValue);

			Assert.assertEquals(data, VendorsData, "Vendor Compliance data is not as expected");

			getExpectedNotificationMessage(ComplianceItemValue, EffectiveDateValue, ExpirationDateValue,
					AlertTypevalue);

			data.clear();

		}
	}

	public void getExpectedNotificationMessage(String ComplianceItemValue, String EffectiveDateValue,
			String ExpirationDateValue, String AlertTypevalue) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

		Date ParsedCutoffdate = dateFormat.parse(common.getCurrentDate());

		Date ParsedExpirationDateValue = dateFormat.parse(ExpirationDateValue);

		if (ParsedExpirationDateValue.before(ParsedCutoffdate)) {

			String Message = "Contract " + SubcontractNumberValue + " - Compliance Item " + ComplianceItemValue
					+ " - Effective Date " + EffectiveDateValue + " - Expiration Date is not within Cutoff date "
					+ ExpirationDateValue + " - Status is Blocked";

			ExpectedNotificationMessage_VendorSubcontractCompliance.add(Message);

			logger.info("ExpectedNotificationMessage_VendorSubcontractCompliance"
					+ ExpectedNotificationMessage_VendorSubcontractCompliance);

		}

	}

	@FindBy(xpath = "//*[@aria-label='Compliance item' and contains(@id,'SubcontractCompliance')]")
	WebElement ComplianceItem;

	@FindBy(xpath = "//*[@aria-label='Description' and contains(@id,'SubcontractCompliance')]")
	WebElement Description_SubcontractCompliance;

	@FindBy(xpath = "//*[@aria-label='Policy number' and contains(@id,'SubcontractCompliance')]")
	WebElement PolicyNumber;

	@FindBy(xpath = "//*[@aria-label='Effective date' and contains(@id,'SubcontractCompliance')]")
	WebElement EffectiveDate;

	@FindBy(xpath = "//*[@aria-label='Expiration date' and contains(@id,'SubcontractCompliance')]")
	WebElement ExpirationDate;

	@FindBy(xpath = "//*[@aria-label='Payment control' and contains(@id,'SubcontractCompliance')]")
	WebElement PaymentControl;

	@FindBy(xpath = "//*[@aria-label='Alert type' and contains(@id,'SubcontractCompliance')]")
	WebElement AlertType;

	@FindBy(xpath = "//*[@aria-label='Status' and contains(@id,'SubcontractCompliance')]")
	WebElement Status_SubcontractCompliance;

	public void setSubcontractCompliance(String arg1) throws InterruptedException, IOException, ParseException {

		ArrayList<ArrayList<String>> SubcontractCompliance_datas = new ArrayList<ArrayList<String>>();

		if (arg1.equals("SubcontractCompliance_Valid")) {

			SubcontractCompliance_datas = SubcontractCompliance_Valid;
		}

		else if (arg1.equals("SubcontractCompliance_Expired")) {

			SubcontractCompliance_datas = SubcontractCompliance_Expired;

		}

		Thread.sleep(2000);

		for (ArrayList<String> SubcontractCompliance_Data : SubcontractCompliance_datas) {

			String ComplianceItemValue = SubcontractCompliance_Data.get(0);

			String Description = SubcontractCompliance_Data.get(1);

			String EffectiveDateValue = SubcontractCompliance_Data.get(3);

			String ExpirationDateValue = SubcontractCompliance_Data.get(4);

			String PaymentControlValue = SubcontractCompliance_Data.get(5);

			String AlertTypeValue = SubcontractCompliance_Data.get(6);

			String StatusValue = SubcontractCompliance_Data.get(7);

			common.setTextAfterDelete(ComplianceItem, ComplianceItemValue);

			common.setTextAfterDelete(PolicyNumber, common.generateRandomNumber(6));

			common.setTextAfterDelete(EffectiveDate, EffectiveDateValue);

			common.setTextAfterDelete(ExpirationDate, ExpirationDateValue);

			common.setTextAfterDelete(PaymentControl, PaymentControlValue);

			common.scrollIntoView(AlertType);

			common.setTextAfterDelete(AlertType, AlertTypeValue);

			common.setTextAfterDelete(Status_SubcontractCompliance, StatusValue);

			clickSave();

			PolicyNumber.sendKeys(Keys.SHIFT, Keys.TAB);

			common.clickElement(Description_SubcontractCompliance);

			Assert.assertEquals(common.getValue(Description_SubcontractCompliance), Description,
					" Description value is not as Expected");

			getExpectedNotificationMessage(ComplianceItemValue, EffectiveDateValue, ExpirationDateValue,
					AlertTypeValue);

		}
	}

	@FindBy(xpath = "//*[text()='Cutoff date']//following::input")
	WebElement CutoffDate;

	public void setCutoffDate() throws InterruptedException {

		String CutoffDateValue = common.getCurrentDate();

		common.setTextAfterDelete(CutoffDate, CutoffDateValue);
	}

	@FindBy(xpath = "//*[text()='Filter']")
	WebElement Filter;

	public void clickFilter() throws InterruptedException {

		common.clickElement(Filter);
	}

	@FindBy(xpath = "(//*[contains(@id,'RangeValue')])[7]")
	WebElement ProjectID_Criteria;

	public void setProjectID_VerifySubcontractCompliance() throws InterruptedException {

		Thread.sleep(5000);

		common.setTextAfterDelete(ProjectID_Criteria, ProjectIDValue);
	}

	@FindBy(xpath = "//*[text()='OK' and contains(@id,'OkButton')]")
	WebElement OK_VerifySubcontractCompliance_Filter;

	public void clickOKButton_Filter() throws InterruptedException {

		common.clickElementJS(OK_VerifySubcontractCompliance_Filter);

	}

	@FindBy(xpath = "//*[text()='OK' and contains(@id,'CommandButton')]")
	WebElement OK_VerifySubcontractCompliance;

	public void clickOKButton() throws InterruptedException {

		common.clickElementJS(OK_VerifySubcontractCompliance);

		logger.info("VerifySubcontractCompliance is completed");

	}

	@FindBy(xpath = "//*[contains(@id,'buttonNotifications')]")
	WebElement NotificationIcon;

	public void clickNotificationIcon() throws InterruptedException {

		common.clickElement(NotificationIcon);

	}

	@FindBy(xpath = "//*[contains(@class,'messageCenter-itemTitle')]")
	List<WebElement> NumberOfMessageCenterLines;

	public int getNumberOfMessageCenterLines() {

		return NumberOfMessageCenterLines.size();
	}

	public void getMessageCenterData() throws InterruptedException {

		Thread.sleep(5000);

		for (int row = 1; row <= getNumberOfMessageCenterLines(); row++) {

			WebElement MessageCenter = ldriver
					.findElement(By.xpath("(//*[contains(@class,'messageCenter-itemTitle')])[" + row + "]"));

			String MessageCenterValue = common.getText(MessageCenter);

			logger.info("Message Center Value" + MessageCenterValue);

			logger.info("ExpectedNotificationMessage_VendorSubcontractCompliance Value"
					+ ExpectedNotificationMessage_VendorSubcontractCompliance);

			Assert.assertTrue(ExpectedNotificationMessage_VendorSubcontractCompliance.contains(MessageCenterValue),
					"Message is not as expected");

		}
	}

	public void checkExpirationDate(String Value) throws ParseException, InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

		Date Today = dateFormat.parse(common.getCurrentDate());

		for (int row = 1; row <= getNumberOfVendorComplianceLines(); row++) {

			WebElement Expirationdate = ldriver
					.findElement(By.xpath("(//*[@aria-label='Expiration date'])[" + row + "]"));

			String ExpirationdateValue = common.getValue(Expirationdate);

			Date parsedExpirationdateValue = dateFormat.parse(ExpirationdateValue);

			if (Value.equals("Expired date")) {

				if (parsedExpirationdateValue.before(Today)) {

					common.clickElement(Expirationdate);

					clickDelete_VendorCompliance();

					clickYes();

				}

			} else if (Value.equals("Valid date")) {

				if (parsedExpirationdateValue.compareTo(Today) >= 0) {

					common.clickElement(Expirationdate);

					clickDelete_VendorCompliance();

					clickYes();
				}
			}
			Thread.sleep(5000);

		}

		logger.info("Vendor Compliance line is Deleted as Expeccted for " + Value);
	}

	@FindBy(xpath = "//*[contains(@id,'VendorCompliance') and text()='Delete']")
	WebElement Delete_VendorCompliance;

	public void clickDelete_VendorCompliance() throws InterruptedException {

		common.clickElement(Delete_VendorCompliance);

	}

	@FindBy(xpath = "//span[normalize-space()='New' and contains(@id,'SubcontractCompliance')]")
	WebElement New_SubcontractCompliance;

	public void clickNew_SubcontractCompliance() throws InterruptedException {

		common.clickElement(New_SubcontractCompliance);

	}

	@FindBy(xpath = "//*[text()='Add line']")
	WebElement AddLine;

	public void clickAddLine() throws InterruptedException {

		common.clickElement(AddLine);

	}

	@FindBy(xpath = "//*[@aria-label='Account code']")
	WebElement AccountCode;

	@FindBy(xpath = "//*[@aria-label='Vendor/Vendor group']")
	WebElement VendorGroup;

	@FindBy(xpath = "//*[@aria-label='Vendor retention terms']")
	WebElement VendorRetentionTerms;

	public void setVendorAgreements() throws InterruptedException, IOException {

		for (ArrayList<String> VendorAgreement : VendorAgreements) {

			String AccountCodeValue = VendorAgreement.get(0);

			String VendorGroupValue = VendorAgreement.get(1);

			VendorAccount_SubcontractComplianceadd2 = VendorAgreement.get(1);

			String VendorRetentionTermsValue = VendorAgreement.get(2);

			common.setTextAfterDelete(AccountCode, AccountCodeValue);

			common.setTextAfterDelete(VendorGroup, VendorGroupValue);

			common.setTextAfterDelete(VendorRetentionTerms, VendorRetentionTermsValue);

		}

	}

	@FindBy(xpath = "(//*[text()='Header'])")
	WebElement Header;

	public void clickHeader() throws InterruptedException {

		common.clickElement(Header);

	}

	@FindBy(xpath = "//*[text()='Clear all']")
	WebElement ClearAll;

	public void clickClearAll() throws InterruptedException {

		try {
			common.clickElement(ClearAll);

		} catch (Exception e) {

		}
	}

	public void getSubcontract(String SubcontractData) throws IOException {

		if (SubcontractData.equals("SubContract_Original")) {

			SubContracts = rd.getXl_SubContract();

		} else if (SubcontractData.equals("SubContract_Revision1")) {

			SubContracts = rd.getXl_SubContract_Revision1();
		} else if (SubcontractData.equals("Subcontract_Compliance")) {

			SubContracts = Subcontract_Compliance;
		} else if (SubcontractData.equals("Subcontract_Compliance_add1")) {

			SubContracts = Subcontract_Compliance_add1;
		} else if (SubcontractData.equals("Subcontract_Compliance_add2")) {

			SubContracts = Subcontract_Compliance_add2;
		}

	}

	@FindBy(xpath = "//*[contains(@aria-labelledby,'SubcontractNumber')]")
	WebElement SubcontractNumber;

	public void getSubcontractNumber() throws InterruptedException {

		Thread.sleep(5000);

		SubcontractNumberValue = common.getValue(SubcontractNumber);

	}

	public void setSubContract(String SubcontractData) throws InterruptedException, IOException {

		getSubcontract(SubcontractData);

		int row = 1;

		SubContract_NetAmount = new HashMap<String, String>();

		for (ArrayList<String> SubContract : SubContracts) {

			String TaskCodeValue = SubContract.get(0);

			String ProjectCategoryValue = SubContract.get(1);

			String ProcurementCategoryValue = SubContract.get(2);

			String QuantityValue = SubContract.get(3);

			String UnitPriceValue = SubContract.get(4);

			clickNewSubConractLine();

			Thread.sleep(3000);

			WebElement SVLine = ldriver.findElement(By.xpath("(//*[@aria-label='SV line#'])[" + row + "]"));

			String SVLineValue = common.getValue(SVLine);

			WebElement Category = ldriver.findElement(By.xpath("//*[@aria-label='Category'][" + row + "]"));

			common.setTextAfterDelete(Category, ProjectCategoryValue);

			WebElement TaskCode = ldriver.findElement(By.xpath("//*[@aria-label='Task code'][" + row + "]"));

			common.setTextAfterDelete(TaskCode, TaskCodeValue);

			WebElement ProcurementCategory = ldriver.findElement(By.xpath(
					"//*[contains(@id,'ProcurementCategory') and @aria-label='Procurement category'][" + row + "]"));

			common.setTextAfterDelete(ProcurementCategory, ProcurementCategoryValue);

			WebElement Quantity = ldriver.findElement(By.xpath("//*[@aria-label='Quantity'][" + row + "]"));

			common.setTextAfterDelete(Quantity, QuantityValue);

			WebElement UnitPrice = ldriver.findElement(By.xpath("//*[@aria-label='Unit price'][" + row + "]"));

			common.setTextAfterDelete(UnitPrice, UnitPriceValue);

			WebElement NetAmount = ldriver.findElement(By.xpath("//*[@aria-label='Net amount'][" + row + "]"));

			String NetAmountValue = common.getValue(NetAmount);

			checkLineAmount(QuantityValue, UnitPriceValue, NetAmountValue, row);

			common.setTextAfterDelete(Category, ProjectCategoryValue);

			// row++;

			setSubcontractNetAmount(TaskCodeValue, ProjectCategoryValue, NetAmountValue);

			getExpectedCommittedCostData(SubcontractData, TaskCodeValue, ProjectCategoryValue, QuantityValue,
					UnitPriceValue, NetAmountValue);

			getExpectedPurchaseOrderData(SubcontractData, SVLineValue, TaskCodeValue, ProjectCategoryValue,
					QuantityValue, UnitPriceValue, NetAmountValue);

		}

		logger.info("SubContract NetAmount: " + SubContract_NetAmount);

		logger.info("Expected SubContract Committed Cost Data: " + SubContractCommittedCost_Expected);

		logger.info("SubContract ExpectedPurchaseOrderData Data: " + PurchaseOrder_Expected);

		Subcontract_SubcontractNumberMapping.put(SubcontractData, SubcontractNumberValue);

		logger.info("Subcontract_SubcontractNumberMapping Data: " + Subcontract_SubcontractNumberMapping);

		clickSave();

	}

	public void selectSubcontract(String Value) throws InterruptedException {

		Thread.sleep(2000);

		String Number = Subcontract_SubcontractNumberMapping.get(Value);

		WebElement SubcontractLine = ldriver
				.findElement(By.xpath("(//*[contains(@id,'SubcontractNumber') and @value='" + Number + "'])"));

		common.clickElement(SubcontractLine);
	}

	public void setVendorAccount(String arg1) throws InterruptedException {

		if (arg1.equals("Subcontract_Compliance_add2")) {

			VendorAccountValue = VendorAccount_SubcontractComplianceadd2;
		} else {

			VendorAccountValue = rd.getXl_VendorAccount();
		}

		common.setText(Vendoraccount, VendorAccountValue);

		common.clickElement(VendoraccountID);

	}

	public void checkCommittedCostTable(String arg1) throws InterruptedException {

		if (arg1.equals("SubContract_Revision1") || arg1.equals("SubContract_Original")
				|| arg1.equals("Subcontract_Compliance") || arg1.equals("Subcontract_Compliance_add1")
				|| arg1.equals("Subcontract_Compliance_add2")) {

			ArrayList<ArrayList<String>> CommittedCost_Expected = SubContractCommittedCost_Expected.get(arg1);

			ArrayList<ArrayList<String>> CommittedCost_Actual = getCommittedCostTable();

			logger.info("SubContractCommittedCost Expected : " + CommittedCost_Expected);

			logger.info("CommittedCost Actual : " + CommittedCost_Actual);

			Assert.assertTrue(CommittedCost_Actual.containsAll(CommittedCost_Expected),
					"Committed Cost Data is NOT as expected");

		}

		else if (arg1.equals("Item requirement")) {

			clickGeneralTab();

			clickOverview_committedcost();

			ExpectedItemRequirement_CommittedCost.add(arg1);

			ExpectedItemRequirement_CommittedCost.add("");

			ArrayList<ArrayList<String>> CommittedCost_Actual = getCommittedCostTable();

			logger.info("ExpectedItemRequirement_CommittedCost Expected : " + ExpectedItemRequirement_CommittedCost);

			logger.info("CommittedCost Actual : " + CommittedCost_Actual);

			Assert.assertTrue(CommittedCost_Actual.contains(ExpectedItemRequirement_CommittedCost),
					"ItemRequirement_Committedcost Table values is not as expected");

		}
	}

	public void getVendorCompliance_Status() throws InterruptedException, ParseException {

		Thread.sleep(2000);

		for (int row = 1; row <= getNumberOfVendorComplianceLines(); row++) {

			WebElement ComplianceItem = ldriver.findElement(
					By.xpath("(//*[@aria-label='Compliance item' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String ComplianceItemValue = common.getValue(ComplianceItem);

			WebElement ExpirationDate = ldriver.findElement(
					By.xpath("(//*[@aria-label='Expiration date' and contains(@id,'VendorCompliance')])[" + row + "]"));

			String ExpirationDateValue = common.getValue(ExpirationDate);

			WebElement Status = ldriver.findElement(
					By.xpath("(//*[@aria-label='Status' and contains(@id,'VendorCompliance')])[" + row + "]"));

			common.scrollIntoView(Status);

			String StatusValue = common.getValue(Status);

			checkStatus_Compliant(ComplianceItemValue, ExpirationDateValue, StatusValue);
		}

	}

	public void getSubcontractCompliance_Status() throws InterruptedException, ParseException {

		String ComlianceItemValue = common.getValue(ComplianceItem);

		String ExpirationDateValue = common.getValue(ExpirationDate);

		String Status_SubcontractComplianceValue = common.getValue(Status_SubcontractCompliance);

		checkStatus_Compliant(ComlianceItemValue, ExpirationDateValue, Status_SubcontractComplianceValue);

	}

	public void checkStatus_Compliant(String ComlianceItemValue, String ExpirationDateValue, String StatusValue)
			throws InterruptedException, ParseException {

		logger.info("StatusValue Actual : " + StatusValue);

		DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

		Date Today = dateFormat.parse(common.getCurrentDate());

		Date ParseExpirationDateValue = dateFormat.parse(ExpirationDateValue);

		if (ParseExpirationDateValue.before(Today)) {

			logger.info("StatusValue Expected : " + "Non-Compliant");

			logger.info("StatusValue Actual : " + StatusValue);

			System.out.println("StatusValue" + StatusValue);

			Assert.assertEquals(StatusValue, "Non-Compliant", "Status is not as expected" + ComlianceItemValue);

		}

		else if (ParseExpirationDateValue.compareTo(Today) >= 0) {

			logger.info("StatusValue Expected : " + "Compliant");

			logger.info("StatusValue Actual : " + StatusValue);

			Assert.assertEquals(StatusValue, "Compliant", "Status is not as expected" + ComlianceItemValue);
		}
	}

}
