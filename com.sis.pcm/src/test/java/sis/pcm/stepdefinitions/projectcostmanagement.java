package sis.pcm.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import sis.pcm.pageobjects.common_pom;
import sis.pcm.pageobjects.pcm_pom;

public class projectcostmanagement extends baseclass {

	public WebDriver driver;
	public static Logger logger;

	@Before
	public void loginsteps() throws InterruptedException {

		sa = new SoftAssert();

		logger = Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", browser);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			// Take Screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Store in Report
			scenario.embed(screenshot, "image/png"); // stick it in the report
		}
		// driver.close();
		// driver.quit();
	}

	// ================================================Common
	// Snippets==========================================================//
	@Then("^Wait \"([^\"]*)\" Seconds$")
	public void wait_Seconds(String arg) throws Throwable {

		common.WaitTime(arg);
	}

	// ================================================PCM Related
	// Snippets=====================================================//
	@Given("^User Login Finance and Operations Application$")
	public void user_Login_Finance_and_Operations_Application() throws Throwable {

		common = new common_pom(driver);
		pcm = new pcm_pom(driver);
		String pcmurl = rd.getXL_PCM_Url();

		driver.get(pcmurl);
		Thread.sleep(20000);

		common.PCM_Login();
	}
	// ================================================Ram Coding
	// Snippets========================================================//

	@Given("^User clicks on \"([^\"]*)\" module$")
	public void user_clicks_on_module(String arg1) throws Throwable {

		pcm.selectModule(arg1);
	}

	@Given("^User clicks on Expand All$")
	public void user_clicks_on_Expand_All() throws Throwable {

		pcm.clickExpandall();

	}

	@Given("^User clicks on \"([^\"]*)\" sub-module$")
	public void user_clicks_on_sub_module(String arg1) throws Throwable {

		pcm.selectSubModule(arg1);

	}

	@Then("^User clicks on \"([^\"]*)\" in page header$")
	public void user_clicks_on_in_page_header(String arg1) throws Throwable {

		pcm.clickPageHeader(arg1);

	}

	@Then("^User clicks on \"([^\"]*)\" in \"([^\"]*)\" section$")
	public void user_clicks_on_in_section(String arg1, String arg2) throws Throwable {

		pcm.clickSection(arg1, arg2);
	}

	@Given("^User clicks on Expand the navigation pan link$")
	public void user_clicks_on_Expand_the_navigation_pan_link() throws Throwable {

		pcm.clickExpandthenavigationpane();

	}

	@Given("^User clicks on Expand the navigation pan icon$")
	public void user_clicks_on_Expand_the_navigation_pan_icon() throws Throwable {

		pcm.clickExpandthenavigationpane();

	}

	@Given("^User clicks on Modules$")
	public void user_clicks_on_Modules() throws Throwable {

		pcm.clickModules();

	}

	@Given("^User clicks on Project cost management link$")
	public void user_clicks_on_Project_cost_management_link() throws Throwable {

		pcm.clickProjectcostmanagement();
	}

	@Given("^User clicks on Projects link$")
	public void user_clicks_on_Projects_link() throws Throwable {

		pcm.clickProjects();
	}

	@Given("^User clicks on All Projects link$")
	public void user_clicks_on_All_Projects_link() throws Throwable {

		pcm.clickAllprojects();

	}

	@Given("^User clicks on New$")
	public void user_clicks_on_New() throws Throwable {

		pcm.clickNew();

	}

	@Given("^User clicks on New under Construction contract$")
	public void User_clicks_on_New_under_Constructioncontract() throws Throwable {

		pcm.clickNewConstructionConractLine();

	}

	@Given("^User selects Project type as \"([^\"]*)\"$")
	public void user_selects_Project_type_as(String projectType) throws Throwable {

		pcm.selectProjecttype(projectType);

	}

	@Given("^User enters Project ID$")
	public void user_enters_Project_ID() throws Throwable {

		pcm.setProjectID();
	}

	@Given("^User enters Project name$")
	public void user_enters_Project_name() throws Throwable {

		pcm.setProjectName();

	}

	@Given("^User enters Project group$")
	public void user_enters_Project_group() throws Throwable {

		pcm.setProjectGroup();

		// pcm.selectProjectGroupValue();

	}

	@Given("^User clicks on New Project contract$")
	public void user_clicks_on_New_Project_contract() throws Throwable {

		pcm.clickProjectcontractNew();

	}

	@Given("^User enters Project contract name$")
	public void user_enters_Project_contract_name() throws Throwable {

		pcm.setName();

	}

	@Given("^User selects Funding type$")
	public void user_selects_Funding_type() throws Throwable {

		pcm.setFundingtype();

	}

	@Given("^User selects Funding source$")
	public void user_selects_Funding_source() throws Throwable {

		pcm.setFundingsource();

	}

	@Given("^User clicks on OK$")
	public void user_clicks_on_OK() throws Throwable {

		pcm.clickOK();

	}

	@Given("^User gets Project contract ID$")
	public void user_gets_Project_contract_ID() throws Throwable {

		pcm.getProjectcontractID();

	}

	@Given("^User selects Project manager$")
	public void user_selects_Project_manager() throws Throwable {

		pcm.setProjectManager();

	}

	@Given("^User clicks on Create project$")
	public void user_clicks_on_Create_project() throws Throwable {

		pcm.clickCreateproject();

	}

	@Then("^User checks the Project stage is \"([^\"]*)\"$")
	public void user_checks_the_Project_stage_is(String arg1) throws Throwable {

		pcm.checkProjectStage(arg1);

	}

	@Then("^User clicks on the Project stage menu and move to In Process stage$")
	public void user_clicks_on_the_Project_stage_menu_and_move_to_In_Process_stage() throws Throwable {

		pcm.clickProjectTab();

		pcm.clickProjectstage_menu();

		pcm.clickInprocess();

		pcm.clickOK_UpdateProjectStatus();

	}

	@Then("^User clicks on Project cost management page header$")
	public void user_clicks_on_Project_cost_management_page_header() throws Throwable {

		pcm.clickProjectcostmanagement_PageHeader();

	}

	@Then("^User clicks on New budget$")
	public void user_clicks_on_New_budget() throws Throwable {

		pcm.clickNewbudget();

	}

	@Then("^User clicks on Budget lines$")
	public void user_clicks_on_Budget_lines() throws Throwable {

		pcm.clickBudgetlines();

	}

	@Then("^User clicks on New Budget lines$")
	public void user_clicks_on_New_Budget_lines() throws Throwable {

		pcm.clickNew_Budgetlines();

	}

//	@Then("^User enters the budget lines data and validates the Line amount$")
//	public void user_enters_the_budget_lines_data_and_validates_the_Line_samount() throws Throwable {
//
//		pcm.setBudgetLines();
//	}

	@Then("^User clicks on Totals$")
	public void user_clicks_on_Totals() throws Throwable {

		pcm.clickTotals();
	}

	/*
	 * @Then("^User validates Revenue Budget, Cost Budget and Profit margin$")
	 * public void user_validates_Revenue_Budget_Cost_Budget_and_Profit_margin()
	 * throws Throwable {
	 * 
	 * pcm.checkRevenueBudget();
	 * 
	 * pcm.checkCostBudget();
	 * 
	 * pcm.checkProfitMargin();
	 * 
	 * }
	 */

	@Then("^User clicks on Save$")
	public void user_clicks_on_Save() throws Throwable {

		pcm.clickSave();

	}

	@Then("^User checks the Budget status is \"([^\"]*)\"$")
	public void user_checks_the_Budget_status_is(String arg1) throws Throwable {

		pcm.checkBudgetStatus(arg1);
	}

	@Then("^User clicks on Submit$")
	public void user_clicks_on_Submit() throws Throwable {

		pcm.clickSubmit();
	}

	@Then("^User clicks on Approve$")
	public void user_clicks_on_Approve() throws Throwable {

		pcm.clickApprove();
	}

	@Then("^User clicks on Commit$")
	public void user_clicks_on_Commit() throws Throwable {

		pcm.clickCommit();

	}

	@Then("^User \"([^\"]*)\" project budget$")
	public void user_project_budget(String arg1) throws Throwable {

		pcm.clickProjectbudget();

		pcm.clickProjectBudgetStatus(arg1);

	}

	@Then("^User \"([^\"]*)\" Subcontract$")
	public void user_Subcontract(String arg1) throws Throwable {

		pcm.clickSubContractStatus(arg1);

	}

	@Then("^User clicks on Close$")
	public void user_clicks_on_Close() throws Throwable {

		pcm.clickClose();

	}

	@Then("^User selects the Contract status as \"([^\"]*)\"$")
	public void user_selects_the_Contract_status_as(String arg1) throws Throwable {

		pcm.clickContractstatus();

		pcm.setContractstatus(arg1);

	}

	/*
	 * @Then("^User enters Retainage%$") public void user_enters_Retainage() throws
	 * Throwable {
	 * 
	 * pcm.setRetainage();
	 * 
	 * }
	 */

	@Then("^User clicks on Yes$")
	public void user_clicks_on_Yes() throws Throwable {

		pcm.clickYes();
	}

	@Then("^User clicks on Overview$")
	public void user_clicks_on_Overview() throws Throwable {

		pcm.clickOverview();

	}

	@Then("^User clicks on Edit$")
	public void user_clicks_on_Edit() throws Throwable {

		pcm.clickEdit();
	}

	@Then("^User enters Construction contract data$")
	public void user_enters_Construction_contract_data() throws Throwable {

		pcm.setConstructionContract();

	}

	@Then("^User clicks on Refresh$")
	public void user_clicks_on_Refresh() throws Throwable {

		pcm.clickRefresh();

	}

	@Then("^User validates Revenue budget and Scheduled value$")
	public void user_validates_Revenue_budget_and_Scheduled_value() throws Throwable {

		pcm.checkRevenueBudgetInConstructionContract();

		pcm.checkScheduledValueInConstructionContract();

	}

	@Then("^User clicks on Map task codes$")
	public void user_clicks_on_Map_task_codes() throws Throwable {

		pcm.clickMapTaskCodes();
	}

	@Then("^User clicks on Show non-billable tasks$")
	public void user_clicks_on_Show_non_billable_tasks() throws Throwable {

		pcm.clickShownonbillabletasks();

	}

	@Then("^User selects task codes$")
	public void user_selects_task_codes() throws Throwable {

		pcm.selectTaskCodeForContracts();

		pcm.clickMoveRight();

	}

	@Then("^User click on Save$")
	public void user_click_on_Save() throws Throwable {

		pcm.clickSave();

	}

	@Then("^User click on Save in Contracts$")
	public void user_click_on_Save_in_Contracts() throws Throwable {
		pcm.clickSave_Contract();

	}

	@Then("^User clicks on New under Subcontract$")
	public void user_clicks_on_New_under_Subcontract() throws Throwable {

		pcm.clickNew_Subcontract();
	}

	@Then("^User validates the Subcontract status is \"([^\"]*)\"$")
	public void user_validates_the_Subcontract_status_is(String arg1) throws Throwable {

		pcm.checkSubContractStatus(arg1);
	}

	@Then("^User selects the Speciality$")
	public void user_selects_the_Speciality() throws Throwable {

		pcm.setSpeciality();
	}

	@Then("^User selects the Vendor account$")
	public void user_selects_the_Vendor_account() throws Throwable {

		pcm.setVendorAccount();
	}

	@Then("^User click on Yes$")
	public void user_click_on_Yes() throws Throwable {

		pcm.clickYes();
	}

	@Then("^User click on Lines$")
	public void user_click_on_Lines() throws Throwable {

		pcm.clickLines();
	}

	@Then("^User enters the Subcontract data and validates the Net amount$")
	public void user_enters_the_Subcontract_data_and_validates_the_Net_amount() throws Throwable {

		pcm.setSubContract();
	}

	@Then("^User validates Subcontract amount and Subcontract total$")
	public void user_validates_Subcontract_amount_and_Subcontract_total() throws Throwable {

		pcm.checkSubContractAmount();

		pcm.checkSubContractTotal();

	}

	@Then("^User validates Purchase order has been created$")
	public void user_validates_Purchase_order_has_been_created() throws Throwable {

		pcm.checkPurchaseorderCreated();
	}

	@Then("^User clicks on Project financial overview detail$")
	public void user_clicks_on_Project_financial_overview_detail() throws Throwable {

		pcm.clickProjectFinancialOverviewDetail();

	}

	@Then("^User clicks on Close in Subcontract$")
	public void user_clicks_on_Close_in_Subcontract() throws Throwable {

		pcm.clickClose();

	}

	@Then("^User validates \"([^\"]*)\" data in \"([^\"]*)\"$")
	public void user_validates_data_in(String arg1, String arg2) throws Throwable {

		pcm.switchToProjectFinancialOverviewDetailReport();

		pcm.checkPFOReportData(arg1, arg2);

		common.switchToDefaultContent();

	}

	@Given("^User checks the Budget categories config data$")
	public void user_checks_the_Budget_categories_config_data() throws Throwable {

		pcm.clickExpandthenavigationpane();

		pcm.clickModules();

		pcm.clickProjectcostmanagement();

		pcm.clickExpandall();

		pcm.clickBudgetcategories();

		pcm.getBudgetCategoriesData();
	}

	@Given("^User gets the \"([^\"]*)\" from Posted transactions$")
	public void user_gets_the_from_Posted_transactions(String arg1) throws Throwable {

		pcm.getTotalFromPostedTransactions(arg1);

	}

	@Given("^User clicks on General tab$")
	public void user_clicks_on_General_tab() throws Throwable {

		pcm.clickGeneral();

	}

	@Given("^User clicks on Select transactions$")
	public void user_clicks_on_Select_transactions() throws Throwable {

		pcm.clickSelecttransactions();
	}

	@Given("^User clicks on Search$")
	public void user_clicks_on_Search() throws Throwable {

		pcm.clickSearch();
	}

	@Given("^User clicks on Select all$")
	public void user_clicks_on_Select_all() throws Throwable {

		pcm.clickSelectall();
	}

	@Then("^User validates \"([^\"]*)\" in contracts$")
	public void user_validates_in_contracts(String arg1) throws Throwable {

		pcm.checkTotalInContracts(arg1);

	}

	@Then("^User clicks on Close in Posted transactions$")
	public void user_clicks_on_Close_in_Posted_transactions() throws Throwable {

		pcm.clickClose_ProjectTransactions();

		Thread.sleep(3000);

	}

	@Then("^User validates Costs in contract overview$")
	public void user_validates_Costs_in_contract_overview() throws Throwable {

		Thread.sleep(5000);

		pcm.checkTotalCostInContractOverview();
	}

	@Then("^validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage$")
	public void validates_Work_in_place_Amount_remaining_and_Invoice_amount_Retainage_Amount_and_Total_Retainage()
			throws Throwable {

		pcm.checkContractCalculations_test();
	}

	/*
	 * @Then("^User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount$"
	 * ) public void
	 * user_updates_Percent_complete_in_contract_and_validates_Work_in_place_Amount_remaining_and_Invoice_amount
	 * () throws Throwable {
	 * 
	 * pcm.setUpdatedContractAndValidateCalculations(); }
	 */

	@Then("^User gets data from Contract overview$")
	public void user_gets_data_from_Contract_overview() throws Throwable {

		pcm.getDataFromContractOverview();

	}

	@Then("^User clicks on Applications/draws$")
	public void user_clicks_on_Applications_draws() throws Throwable {

		pcm.clickApplicationsdraws();
	}

	@Then("^User validates data in Contract applications from Contract overview$")
	public void user_validates_data_in_Contract_applications_from_Contract_overview() throws Throwable {

		pcm.getDataFromContractApplications();

		pcm.checkContractApplicationsData();
	}

	@Then("^User calculates Invoice Amount from Journals$")
	public void user_calculates_Invoice_Amount_from_Journals() throws Throwable {

		pcm.getInvoiceAmountFromJournals();
	}

	@Then("^User validates Retention to date, Retainage amount and Amount due in Contract applications$")
	public void user_validates_Retention_to_date_Retainage_amount_and_Amount_due_in_Contract_applications()
			throws Throwable {

		pcm.checkContractApplicationCalculations();

	}

	@Then("^User validates Invoice amount, Retainage amount and Amount due totals in Contract applications$")
	public void user_validates_Invoice_amount_Retainage_amount_and_Amount_due_totals_in_Contract_applications()
			throws Throwable {

		pcm.checkInvoiceAmountTotalInContractApplications();

		pcm.checkRetainageAmountTotalInContractApplications();

		pcm.checkAmountDueTotalInContractApplications();

	}

	@Then("^User clicks on Auto Invoice posting$")
	public void user_clicks_on_Auto_Invoice_posting() throws Throwable {

		pcm.clickAutoInvoiceposting();
	}

	// ================================================Sadhana Coding
	// Snippets====================================================//
	// ================================================Monica Coding
	// Snippets=====================================================//

	@Given("^User selects the Rule ID \"([^\"]*)\"$")
	public void user_selects_the_Rule_ID(String arg1) throws Throwable {

		pcm.clickRuleID(arg1);
	}

	@Given("^User clicks on \"([^\"]*)\" sub-module of \"([^\"]*)\" module$")
	public void user_clicks_on_sub_module_of_module(String arg1, String arg2) throws Throwable {

		pcm.clickModulesAndSubModules(arg1, arg2);
	}

	@Given("^User gets Project allocation rules data$")
	public void user_gets_Project_allocation_rules_data() throws Throwable {

		pcm.clickRate();

		Thread.sleep(5000);

		pcm.getProjectAllocationRates();

		pcm.getDestinatonCategory();
	}

	@Given("^User gets Extended Attributes config data, Inventory config data and Field Service config data$")
	public void user_gets_Extended_Attributes_config_data_Inventory_config_data_and_Field_Service_config_data()
			throws Throwable {

		pcm.getExtendedAttributesDataProjectCategoryInventoryData();
	}

	@Given("^User gets the Equipment standard cost data$")
	public void user_gets_the_Equipment_standard_cost_data() throws Throwable {

		pcm.getEquipmentStandardCosts();
	}

	@Given("^User clicks on \"([^\"]*)\" field$")
	public void user_clicks_on_field(String arg1) throws Throwable {

		pcm.selectSearchOptions(arg1);
	}

	@Then("^User search the \"([^\"]*)\"$")
	public void user_search_the(String arg1) throws Throwable {

		pcm.setFilterField(arg1);
	}

	@Given("^User clicks Apply button$")
	public void user_clicks_Apply_button() throws Throwable {

		pcm.clickApply();
	}

	@Given("^User clicks New button in journal$")
	public void user_clicks_New_button_in_journal() throws Throwable {

		pcm.clickNewButton();
	}

	@Given("^User gets Journal Id$")
	public void user_gets_Journal_Id() throws Throwable {

		pcm.getJournalID_Journal();
	}

	@Given("^User clicks Lines$")
	public void user_clicks_Lines() throws Throwable {

		pcm.clickLines_Journals();
	}

	/*
	 * @Then("^User enters the Hour journal line data and calculate and validate overhead transaction$"
	 * ) public void
	 * user_enters_the_Hour_journal_line_data_and_calculate_and_validate_overhead_transaction
	 * () throws Throwable {
	 * 
	 * pcm.setHourJournalAndOverheadTransactionsValidation(String Period); }
	 */

	@Then("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {

		pcm.selectPost_Journals(arg1);
	}

	@Then("^User clicks \"([^\"]*)\"$")
	public void user_clicks(String arg1) throws Throwable {

		pcm.clickOK_Journals();
	}

	@Then("^User validates the journal line has been posted$")
	public void user_validates_the_journal_line_has_been_posted() throws Throwable {

		pcm.checkJournalPostedMessage(JournalId);
	}

	@Then("^User clicks close Journal$")
	public void user_clicks_close_Journal() throws Throwable {

		pcm.clickCloseJournal();
	}

	@Then("^User selects the name$")
	public void user_selects_the_name() throws Throwable {

		pcm.setItemName();
	}

	/*
	 * @Then("^User enters the Item journal line data and calculate and validate overhead transaction$"
	 * ) public void
	 * user_enters_the_Item_journal_line_data_and_calculate_and_validate_overhead_transaction
	 * () throws Throwable {
	 * 
	 * pcm.setItemJournalAndOverheadTransactionsValidation(); }
	 */

	@Then("^User gets Expense Journal Id$")
	public void user_gets_Expense_Journal_Id() throws Throwable {

		pcm.getJournalID_ExpenseJournal();
	}

	/*
	 * @Then("^User enters the Expense journal line data and calculate and validate overhead transaction$"
	 * ) public void
	 * user_enters_the_Expense_journal_line_data_and_calculate_and_validate_overhead_transaction
	 * () throws Throwable {
	 * 
	 * pcm.setExpenseJournalAndOverheadTransactionsValidation(); }
	 */

	@Then("^User clicks on Post in Post dropdown list$")
	public void user_clicks_on_Post_in_Post_dropdown_list() throws Throwable {

		pcm.clickPost_Journal();

		pcm.clickPost_ExpenseJournal();
	}

	@Then("^User validates the Expense journal line has been posted$")
	public void user_validates_the_Expense_journal_line_has_been_posted() throws Throwable {

		pcm.checkExpenseJournalPostedMessage();

	}

	@Given("^User clicks on modules Icon$")
	public void user_clicks_on_modules_Icon() throws Throwable {

		pcm.clickModulesIcon();
	}

	// =====================Execute revenue recognition using PFO
	// =====================

	@Given("^User sets the fiscal year as current year and end date as current period end date$")
	public void user_sets_the_fiscal_year_as_current_year_and_end_date_as_current_period_end_date() throws Throwable {

		pcm.setFiscalyear(FiscalYear_RefreshProjFinData);

		pcm.setEndDate(EndDate_RefreshProjFinData);

	}

	@Given("^User sets the task description$")
	public void user_sets_the_task_description() throws Throwable {

		pcm.setTaskDescription();
	}

	@Given("^User gets Job ID$")
	public void user_gets_Job_ID() throws Throwable {

		pcm.getJobID_Batchjob(TaskDescription_RefreshProjFinData);
	}

	@Given("^User checks the batch job status is \"([^\"]*)\"$")
	public void user_checks_the_batch_job_status_is(String arg1) throws Throwable {

		pcm.checkStatus_BatchJob_Ended(TaskDescription_RefreshProjFinData, arg1);
	}

	@Then("^User validates the budget is executed$")
	public void user_validates_the_budget_is_executed() throws Throwable {

		pcm.checkBatchJobId(JobID);

	}

	@Given("^User gets the line values and selects the record$")
	public void user_gets_the_line_values_and_selects_the_record() throws Throwable {

		pcm.getRevenueRecognition();
		pcm.clickEdit();
		Thread.sleep(3000);
		pcm.selectLine();
	}

	@Given("^User checks posting date is current period end date$")
	public void user_checks_posting_date_is_current_period_end_date() throws Throwable {

		pcm.checkPostingDate();
	}

	@Given("^User validates the Revenue recognition process job is added to the batch queue$")
	public void user_validates_the_Revenue_recognition_process_job_is_added_to_the_batch_queue() throws Throwable {

		pcm.validateProcessJobIsAddedToTheBatchQueue();

	}

	@Given("^User selects the Project ID$")
	public void user_selects_the_Project_ID() throws Throwable {

		// common.KeyboardAction("Enter");

		pcm.clickProjectIDLink();

		Thread.sleep(10000);
	}

	@Given("^User selects the Project Group$")
	public void user_selects_the_Project_Group() throws Throwable {

		pcm.selectProjectgroup_Projects();
	}

	@Given("^User clicks Estimate fast tab$")
	public void user_clicks_Estimate_fast_tab() throws Throwable {

		pcm.clickEstimate();
	}

	@Given("^User gets sales value data$")
	public void user_gets_sales_value_data() throws Throwable {

		pcm.getCategoryId();
	}

	@Given("^User checks the Category ID and Validates Total sales amount and checks Transaction type \"([^\"]*)\"$")
	public void user_checks_the_Category_ID_and_Validates_Total_sales_amount_and_checks_Transaction_type(String arg1)
			throws Throwable {

		pcm.validateCategoryID_PostedTransactions();

		pcm.validateTotalsalesamount_PostedTransactions();

		pcm.validateTransactiontype_PostedTransactions(arg1);
	}

	@Given("^User filters the \"([^\"]*)\"$")
	public void user_filters_the(String arg1) throws Throwable {

		pcm.setFilterField(arg1);

	}

	// =========Changd by Monica1
	/*
	 * @Then("^User enters Retainage%$") public void user_enters_Retainage() throws
	 * Throwable
	 * 
	 * { pcm.setRetainage(RetainageValue);
	 * 
	 * }
	 */

	/*
	 * // ===============Added by Monica(01-03-2023)======================
	 * 
	 * @Then("^User gets Invoice Number$") public void user_gets_Invoice_Number()
	 * throws Throwable {
	 * 
	 * pcm.getInvoiceNumber(); } // ==========Release and cancel retainage
	 * amount========================
	 * 
	 * @Then("^User gets Construction Contract overview data$") public void
	 * user_gets_Construction_Contract_overview_data() throws Throwable {
	 * 
	 * pcm.getConstructionContractOverviewData(); }
	 * 
	 * @Given("^User changes Retainage percentage$") public void
	 * user_changes_Retainage_percentage() throws Throwable {
	 * 
	 * pcm.clickEdit(); pcm.setRetainage(RetainagePercentage1_ConstructionContract);
	 * pcm.clickYes(); }
	 * 
	 * @Then("^User validates construction contract data after Retainage change$")
	 * public void
	 * user_validates_construction_contract_data_after_Retainage_change() throws
	 * Throwable {
	 * 
	 * pcm.checkContractOverviewCalcAfterRetainageUpdate();
	 * 
	 * }
	 * 
	 * @Then("^User clicks on Retainage release application$") public void
	 * user_clicks_on_Retainage_release_application() throws Throwable {
	 * 
	 * pcm.clickRetainagereleaseapplication();
	 * 
	 * }
	 * 
	 * @Then("^User clicks on Auto release retention amount and validates the retention invoice populated$"
	 * ) public void
	 * user_clicks_on_Auto_release_retention_amount_and_validates_the_retention_invoice_populated
	 * () throws Throwable {
	 * 
	 * pcm.checkRetentionInvoiceGenerated(); }
	 * 
	 * @Then("^User validates contract applications data after retainage release$")
	 * public void
	 * user_validates_contract_applications_data_after_retainage_release() throws
	 * Throwable {
	 * 
	 * pcm.checkContractApplicationCalcAfterRetainageUpdate(); }
	 * 
	 * @Then("^User clicks on Cancel release retention amount and validates the retention reversal populated$"
	 * ) public void
	 * user_clicks_on_Cancel_release_retention_amount_and_validates_the_retention_reversal_populated
	 * () throws Throwable {
	 * 
	 * pcm.checkRetentionReversalGenerated(); pcm.checkInvoiceReversalGenerated(); }
	 * 
	 * @Then("^User validates contract applications data after retainage cancel$")
	 * public void
	 * user_validates_contract_applications_data_after_retainage_cancel() throws
	 * Throwable {
	 * 
	 * }
	 */
//***********************Arthi******************************//

	@Given("^User clicks on ECAC Table$")
	public void user_clicks_on_ECAC_Table() throws Throwable {
		pcm.clickECACTable();
	}

	@Given("^User Click new ECAC$")
	public void user_Click_new_ECAC() throws Throwable {
		pcm.clickNewECAC();
	}

	@Given("^User Enter Description As ProjectID$")
	public void user_Enter_Description_As_ProjectID() throws Throwable {
		pcm.clickDescriptionTextBox();
	}

	@Given("^User sets end date as current period end date$")
	public void user_sets_end_date_as_current_period_end_date() throws Throwable {
		pcm.setPeriodEndDate();
	}

	@Given("^User Click OK$")
	public void user_Click_OK() throws Throwable {
		pcm.clickOK_Journals();
	}

	@Given("^User Clicks Edit$")
	public void user_Clicks_Edit() throws Throwable {
		pcm.clickEdit();
	}

	@Then("^User Valdiate Actual Amount$")
	public void user_Valdiate_Actual_Cost() throws Throwable {

	}

	@Then("^User Validate Committed Cost$")
	public void user_Validate_Committed_Cost() throws Throwable {

	}

	@Then("^User Validate ECAC Amount$")
	public void user_Validate_ECAC_cost() throws Throwable {

	}

	@Then("^User validate ETC and CTC Amount$")
	public void user_validate_ETC_and_CTC() throws Throwable {
		pcm.checkECACTableData();
	}

	@Then("^User Change Quantity Based Category-Revised Qty$")
	public void user_Change_Quantity_Based_Category_Revised_Qty() throws Throwable {
		pcm.setECACData();
	}

	@Then("^User Validate Changed Fields ECAC Revised Amount and ECAC Net Change$")
	public void user_Validate_Changed_Fields_ECAC_Revised_Amount_and_ECAC_Net_Change() throws Throwable {

	}

	@Then("^User Change Amount Based Category-ECAC Net Change$")
	public void user_Change_Amount_Based_Category_ECAC_Net_Change() throws Throwable {

	}

	@Then("^User Validate Changed Fields-ECAC Revised Amount$")
	public void user_Validate_Changed_Fields_ECAC_Revised_Amount() throws Throwable {

	}

	@Then("^User Clicks \"([^\"]*)\" In ECAC Table$")
	public void user_Clicks_In_ECAC_Table(String arg1) throws Throwable {
		pcm.clickProjectBudgetStatus(arg1);
	}

	@Then("^User Validates Budget Status \"([^\"]*)\"$")
	public void user_Validates_Budget_Status(String arg1) throws Throwable {
		pcm.checkBudgetStatus(arg1);
	}

	// ===============Added by Monica(01-03-2023)======================
	@Then("^User gets Invoice Number$")
	public void user_gets_Invoice_Number() throws Throwable {

		pcm.getInvoiceNumber();
	}
	// ==========Release and cancel retainage amount========================

	@Then("^User gets Construction Contract overview data$")
	public void user_gets_Construction_Contract_overview_data() throws Throwable {

		pcm.getConstructionContractOverviewData();
	}

	@Then("^User gets Construction Contract overview data after Retainage change$")
	public void user_gets_Construction_Contract_overview_data_after_Retainage_change() throws Throwable {

		pcm.getConstructionContractOverviewDataAfterRetainageChange();

	}

	/*
	 * @Given("^User changes Retainage percentage$") public void
	 * user_changes_Retainage_percentage() throws Throwable {
	 * 
	 * pcm.clickEdit(); pcm.setRetainage(RetainagePercentage1_ConstructionContract);
	 * pcm.clickYes();
	 * 
	 * }
	 */

	@Then("^User validates construction contract data after Retainage change$")
	public void user_validates_construction_contract_data_after_Retainage_change() throws Throwable {

		pcm.checkContractOverviewCalcAfterRetainageUpdate();

	}

	@Then("^User clicks on Retainage release application$")
	public void user_clicks_on_Retainage_release_application() throws Throwable {

		pcm.clickRetainagereleaseapplication();

	}

	@Then("^User clicks on Auto release retention amount and validates the retention invoice populated$")
	public void user_clicks_on_Auto_release_retention_amount_and_validates_the_retention_invoice_populated()
			throws Throwable {

		pcm.checkRetentionInvoiceGenerated();
	}

	@Then("^User validates contract applications data after retainage release$")
	public void user_validates_contract_applications_data_after_retainage_release() throws Throwable {

		pcm.checkContractApplicationCalcAfterRetainageUpdate();
	}

	@Then("^User validates Invoice amount, Retainage amount and Amount due totals in Contract applications from retainage release data$")
	public void user_validates_Invoice_amount_Retainage_amount_and_Amount_due_totals_in_Contract_applications_from_retainage_release_data()
			throws Throwable {

		pcm.checkInvoiceAmountTotalInContractApplications_AfterRetainageRelease();

		pcm.checkRetainageAmountTotalInContractApplications_AfterRetainageRelease();

		pcm.checkAmountDueTotalInContractApplications_AfterRetainageRelease();
	}

	@Then("^User clicks on Cancel release retention amount and validates the retention reversal populated$")
	public void user_clicks_on_Cancel_release_retention_amount_and_validates_the_retention_reversal_populated()
			throws Throwable {

		pcm.checkRetentionReversalGenerated();
	}

	@Then("^User clicks on Cancel invoice amount and validates the invoice populated$")
	public void user_clicks_on_Cancel_invoice_amount_and_validates_the_invoice_populated() throws Throwable {

		pcm.checkInvoiceReversalGenerated();
	}

	@Then("^User validates Billing status is \"([^\"]*)\" in contract applications of Retention reversal line$")
	public void user_validates_Billing_status_is_in_contract_applications_of_Retention_reversal_line(String arg1)
			throws Throwable {

		pcm.checkRetentionReversalStatus(arg1);
	}

	@Then("^User validates Invoice amount in contract applications of Retention reversal line$")
	public void user_validates_Invoice_amount_in_contract_applications_of_Retention_reversal_line() throws Throwable {

		pcm.checkRetentionReversalInvoiceAmount();
	}

	@Then("^User validates Retainage amount in contract applications of Retention reversal line$")
	public void user_validates_Retainage_amount_in_contract_applications_of_Retention_reversal_line() throws Throwable {

		pcm.checkRetentionReversalRetainageAmount();
	}

	@Then("^User validates Amount due in contract applications of Retention reversal line$")
	public void user_validates_Amount_due_in_contract_applications_of_Retention_reversal_line() throws Throwable {

		pcm.checkRetentionReversalAmountDue();
	}

	@Then("^User validates Billing status is \"([^\"]*)\" in contract applications of Invoice reversal line$")
	public void user_validates_Billing_status_is_in_contract_applications_of_Invoice_reversal_line(String arg1)
			throws Throwable {

		pcm.checkInvoiceReversalStatus(arg1);
	}

	@Then("^User validates Invoice amount in contract applications of Invoice reversal line$")
	public void user_validates_Invoice_amount_in_contract_applications_of_Invoice_reversal_line() throws Throwable {

		pcm.checkInvoiceReversalInvoiceAmount();
	}

	@Then("^User validates Retainage amount in contract applications of Invoice reversal line$")
	public void user_validates_Retainage_amount_in_contract_applications_of_Invoice_reversal_line() throws Throwable {

		pcm.checkInvoiceReversalRetainageAmount();
	}

	@Then("^User validates Amount due in contract applications of Invoice reversal line$")
	public void user_validates_Amount_due_in_contract_applications_of_Invoice_reversal_line() throws Throwable {

		pcm.checkInvoiceReversalAmountDue();
	}

	@Then("^User validates contract overview data after retainage and invoice cancel$")
	public void user_validates_contract_overview_data_after_retainage_and_invoice_cancel() throws Throwable {

		pcm.checkContractOverviewCalcAfterRetainageAndInvoiceCancel();
	}

	// Arthi

	@Then("^User clicks on \"([^\"]*)\" in \"([^\"]*)\" Section in Project change order$")
	public void user_clicks_on_in_Section_in_Project_change_order(String arg1, String arg2) throws Throwable {
		pcm.clickNewButton();
	}

	@Then("^user clicks on Budgets$")
	public void user_clicks_on_Budgets() throws Throwable {
		pcm.clickBudgets();
	}

	@Then("^User Set Committed Period as \"([^\"]*)\"$")
	public void user_Set_Committed_Period_as(String arg1) throws Throwable {
		pcm.setCommittedPeriod(arg1);
	}

	@Then("^User Validates Committed Period as \"([^\"]*)\"$")
	public void user_Validates_Committed_Period_as(String arg1) throws Throwable {
		pcm.checkCommittedPeriod(arg1);
	}

	@Then("^User Validate Budget type as \"([^\"]*)\"$")
	public void user_Validate_Budget_type_as(String arg1) throws Throwable {
		pcm.checkBudgetType(arg1);
	}

	@Then("^User Validates Project Change Order is Created$")
	public void user_Validates_Project_Change_Order_is_Created() throws Throwable {
		pcm.checkBudgetChangeOrderPostedMessage();
	}

	@Then("^User Get Change Order ID for \"([^\"]*)\"$")
	public void user_Get_Change_Order_ID(String arg) throws Throwable {
		pcm.getChangeOrderID(arg);
	}

	@Then("^User enters the budget lines data \"([^\"]*)\" and validates the Line amount$")
	public void user_enters_the_budget_lines_data_and_validates_the_Line_amount(String arg1) throws Throwable {
		pcm.setBudgetLines(arg1);
	}

	@Then("^User Validates Gross Margin$")
	public void user_Validates_Gross_Margin() throws Throwable {
		pcm.checkGrossMargin();
	}

	@Then("^User validate Actual Amount, Committed Cost, ECAC Amount, ETC and CTC Amount$")
	public void user_validate_Actual_Amount_Committed_Cost_ECAC_Amount_ETC_and_CTC_Amount() throws Throwable {
		pcm.checkECACTableData();
	}

	@Then("^User Change Quantity and Amount Based Category, Validate Changed Fields$")
	public void user_Change_Quantity_and_Amount_Based_Category_Validate_Changed_Fields() throws Throwable {
		pcm.setECACData();
	}

	// =============Changed by Monica during progress subcontract coding==========

	/*
	 * @Then("^User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals$"
	 * ) public void
	 * user_gets_total_Invoice_amount_total_Invoice_line_amount_and_Customer_retained_amount_from_invoice_journals
	 * () throws Throwable {
	 * 
	 * pcm.getSumOfInvoiceAmountAndInvoiceLineAmount(); }
	 */
	// ===============Progress subcontract=========================

	@Then("^User clicks on New in Subcontract Payment request$")
	public void user_clicks_on_New_in_Subcontract_Payment_request() throws Throwable {

		pcm.clickNewSubcontractPayment();
	}

	@Then("^User enters Vendor invoice number$")
	public void user_enters_Vendor_invoice_number() throws Throwable {

		pcm.setVendorinvoicenumber();
	}

	@Then("^User clicks Load lines$")
	public void user_clicks_Load_lines() throws Throwable {

		pcm.clickLoadlines();
	}

	@Then("^User validates line total and invoice amount$")
	public void user_validates_line_total_and_invoice_amount() throws Throwable {

		pcm.checkLineTotal();

		pcm.checkInvoiceAmount();
	}

	@Then("^User clicks on Payment request tab$")
	public void user_clicks_on_Payment_request_tab() throws Throwable {

		pcm.clickPaymentrequest();
	}

	@Then("^User clicks on \"([^\"]*)\" status$")
	public void user_clicks_on_status(String arg1) throws Throwable {

		pcm.clickStatus(arg1);

	}

	@Then("^User checks the New payment status is \"([^\"]*)\"$")
	public void user_checks_the_New_payment_status_is(String arg1) throws Throwable {

		pcm.checkSubcontractPaymentRequeststatus(arg1);
	}

	@Then("^User validates the New payment request of Subcontract has been raised$")
	public void user_validates_the_New_payment_request_of_Subcontract_has_been_raised() throws Throwable {

		pcm.checkSubcontractPaymentRequestMessage();
	}

	@Then("^User checks for any open Committed cost$")
	public void user_checks_for_any_open_Committed_cost() throws Throwable {

		pcm.checkCommittedCostLinesDisplayed();
	}

	// Subcontract creation_to get cost amount

	@Then("^User gets the sum of Cost amount in Committed cost$")
	public void user_gets_the_sum_of_Cost_amount_in_Committed_cost() throws Throwable {

		pcm.getSumOfTotalCostAmount();
	}

	@Given("^User checks Purchase order and Vendor invoice config data$")
	public void user_checks_Purchase_order_and_Vendor_invoice_config_data() throws Throwable {

		Thread.sleep(3000);

		pcm.clickCostcontrol_PMA();

		pcm.checkCostcommitments_FasttabIsExpanded();

		pcm.checkCommittedCostData_PMAParameter();
	}

	@Then("^User clicks on Project Budget tab$")
	public void user_clicks_on_Project_Budget_tab() throws Throwable {

		pcm.clickProjectbudget();
	}

	// Create customer change order and add to construction contract
	// Added by Carolin

	@Then("^User enters Customer change order no as \"([^\"]*)\"$")
	public void user_enters_Customer_change_order_no_as(String arg1) throws Throwable {

		pcm.setCustomerchangeorderno(arg1);
		// pcm.getCustomerchangeorderno();
	}

	@Given("^User enters Change order approved date$")
	public void user_enters_Change_order_approved_date() throws Throwable {

		pcm.setOverview_ChangeOrderCustApprovedDate();
	}

	@Then("^User validates Approve date$")
	public void user_validates_Approve_date() throws Throwable {

		pcm.validateApproveDate();
	}

	@Then("^User gets the project description$")
	public void user_gets_the_project_description() throws Throwable {

		pcm.getProjectDescription();
	}

	@Then("^User validates the Customer change order Status is \"([^\"]*)\"$")
	public void user_validates_the_Customer_change_order_Status_is(String arg1) throws Throwable {

		pcm.checkChangeOrderStatus(arg1);
	}

	@Then("^User clicks \"([^\"]*)\" fast tab$")
	public void user_clicks_fast_tab(String arg1) throws Throwable {

		pcm.clickFastTab(arg1);
	}

	@Then("^User clicks Select$")
	public void user_clicks_Select() throws Throwable {

		pcm.clickSelect();
	}

	@Then("^User gets \"([^\"]*)\" change order id$")
	public void user_gets_change_order_id(String arg1) throws Throwable {

		pcm.getChangeOrderIdFromBudegetRevisions(arg1);
	}

	@Then("^User changes the Customer change order status to \"([^\"]*)\"$")
	public void user_changes_the_Customer_change_order_status_to(String arg1) throws Throwable {

		pcm.setChangeOrderStatus(arg1);
	}

	@Then("^User clicks Add to Construction Contract$")
	public void user_clicks_Add_to_Construction_Contract() throws Throwable {

		pcm.clickAddtoConstructioncontract();
	}

	@Then("^User validates task summary details for \"([^\"]*)\"$")
	public void user_validates_task_summary_details_for(String arg1) throws Throwable {

		pcm.checkTaskSummary_CustomerChangeOrder(arg1);
	}

	@Then("^User gets the constuction contract line number$")
	public void user_gets_the_constuction_contract_line_number() throws Throwable {

		pcm.getConstrctionContractLineNo();
	}

	@Then("^User validates the newly added line in Construction contract$")
	public void user_validates_the_newly_added_line_in_Construction_contract() throws Throwable {

		pcm.checkNewlyAddedChangeOrderInConstructionContract();
	}

	@Then("^User gets the Default billing basis from SIS parameters$")
	public void user_gets_the_Default_billing_basis_from_SIS_parameters() throws Throwable {

		pcm.getDefaultBillingBasis();
	}

	@Then("^User gets budget lines data for \"([^\"]*)\"$")
	public void user_gets_budget_lines_data_for(String arg1) throws Throwable {

		pcm.getBudgetLines(arg1);
	}

	// arthi

	@Then("^User enters the Subcontract \"([^\"]*)\" data and validates the Net amount$")
	public void user_enters_the_Subcontract_data_and_validates_the_Net_amount(String arg1) throws Throwable {
		pcm.setSubContract(arg1);
	}

	@Then("^User Set SubContract Change Order Date$")
	public void user_Set_SubContract_Change_Order_Date() throws Throwable {
		pcm.setChangeOrderDate();
	}

	@Then("^User clicks New in Change Orders$")
	public void user_clicks_New_in_Change_Orders() throws Throwable {
		pcm.clickNew_SubChangeOrder();
	}

	@Then("^User Gets SubContract Change Order Number$")
	public void user_Gets_Change_Order_Number() throws Throwable {
		pcm.getSubContractChangeOrderNo();
	}

	@Then("^User clicks on Purchase Order$")
	public void user_clicks_on_Purchase_Order() throws Throwable {
		pcm.clickPurchaseOrder();
	}

	@Then("^User Validate Subcontract Change Order Added Lines in Purchase Order Table \"([^\"]*)\"$")
	public void user_Validate_Subcontract_Change_Order_Added_Lines_in_Purchase_Order_Table(String arg1)
			throws Throwable {
		pcm.checkPurchaseOrderLines(arg1);
	}

	@Then("^User Validate SubContract Purchase Order Status \"([^\"]*)\"$")
	public void user_Validate_SubContract_Purchase_Order_Status(String arg1) throws Throwable {
		pcm.checkPurchaseOrderStatus(arg1);
	}

	@Then("^User Validate Approval Status \"([^\"]*)\"$")
	public void user_Validate_Approval_Status(String arg1) throws Throwable {
		pcm.checkApprovalStatus(arg1);
	}

	@Then("^User Clicks on \"([^\"]*)\" in Control Section$")
	public void user_Clicks_on_in_Control_Section(String arg1) throws Throwable {
		pcm.clickControlSection(arg1);
	}

	@Then("^User Validate Committed Cost Table \"([^\"]*)\"$")
	public void user_Validate_Committed_Cost_Table(String arg1) throws Throwable {
		pcm.checkCommittedCostTable(arg1);

	}

	@Then("^User validates Subcontract amount, Change Order and Subcontract total \"([^\"]*)\"$")
	public void user_validates_Subcontract_amount_Change_Order_and_Subcontract_total(String arg1) throws Throwable {
		pcm.checkSubContractAmount(arg1);

		pcm.checkChangeOrderAmount(arg1);

		pcm.checkSubContractTotal();

	}

	@Then("^User clicks on OK in alert$")
	public void user_clicks_on_OK_in_alert() throws Throwable {

		pcm.clickCloseAlert();
	}

	// Recent changes
	@Then("^User enters the Hour journal line data and calculate and validate overhead transaction for \"([^\"]*)\"$")
	public void user_enters_the_Hour_journal_line_data_and_calculate_and_validate_overhead_transaction_for(String arg1)
			throws Throwable {

		pcm.setHourJournalAndOverheadTransactionsValidation(arg1);

	}

	@Then("^User enters the Item journal line data and calculate and validate overhead transaction for \"([^\"]*)\"$")
	public void user_enters_the_Item_journal_line_data_and_calculate_and_validate_overhead_transaction_for(String arg1)
			throws Throwable {

		pcm.setItemJournalAndOverheadTransactionsValidation(arg1);
	}

	@Then("^User enters the Expense journal line data and calculate and validate overhead transaction for \"([^\"]*)\"$")
	public void user_enters_the_Expense_journal_line_data_and_calculate_and_validate_overhead_transaction_for(
			String arg1) throws Throwable {

		pcm.setExpenseJournalAndOverheadTransactionsValidation(arg1);
	}

	@Then("^User sets data as \"([^\"]*)\" in Application Date, From Date and To Date$")
	public void user_sets_data_as_in_Application_Date_From_Date_and_To_Date(String arg1) throws Throwable {

		pcm.setApplicationDateFromDateToDate(arg1);
	}

	// ======Subcontract payment release===================

	@Given("^User gets Vendor invoices$")
	public void user_gets_Vendor_invoices() throws Throwable {

		pcm.getListOfVendorInvoice();
	}

	@Given("^User sets the journal name$")
	public void user_sets_the_journal_name() throws Throwable {

		pcm.SetName_VendorPaymentJournal();
	}

	@Given("^User enters the Vendor Account in Vendor payment journal$")
	public void user_enters_the_Vendor_Account_in_Vendor_payment_journal() throws Throwable {

		pcm.SetAccount_VendorPaymentJournal();
	}

	@Given("^User clicks \"([^\"]*)\" in Vendor payment journal$")
	public void user_clicks_in_Vendor_payment_journal(String arg1) throws Throwable {

		pcm.ClickSettletransactions(arg1);
	}

	@Given("^User clicks on \"([^\"]*)\" field in Vendor payment journal$")
	public void user_clicks_on_field_in_Vendor_payment_journal(String arg1) throws Throwable {

		pcm.clickInvoice_VendorPaymentJournal(arg1);
	}

	@Given("^User selects the line$")
	public void user_selects_the_line() throws Throwable {

	}

	@Given("^User changes the Off set account type$")
	public void user_changes_the_Off_set_account_type() throws Throwable {

		pcm.setOffsetaccounttype();
	}

	@Given("^User selects the Off set account$")
	public void user_selects_the_Off_set_account() throws Throwable {

		pcm.setOffsetaccount();

	}

	@Then("^User sets the fiscal year as current year and end date as \"([^\"]*)\" end date$")
	public void user_sets_the_fiscal_year_as_current_year_and_end_date_as_end_date(String arg1) throws Throwable {

		pcm.setFiscalyear(FiscalYear_RefreshProjFinData);

		pcm.setEndDate(arg1);

	}

	@Given("^User clicks \"([^\"]*)\" in Subcontract payment request$")
	public void user_clicks_in_Subcontract_pament_request(String arg1) throws Throwable {

		pcm.Buttons_SubcontractPaymentRequest(arg1);

	}

	@Given("^User gets the debit value$")
	public void user_gets_the_debit_value() throws Throwable {

		pcm.getDebitValue();
	}

	@Then("^User gets updated contract data$")
	public void user_gets_updated_contract_data() throws Throwable {

		pcm.AddDataInUpdatedContracts();
	}

	@Then("^User enters Retainage percentage as \"([^\"]*)\"$")
	public void user_enter_Retainage_percentage_as(String arg1) throws Throwable {

		// pcm.clickEdit();

		pcm.setRetainage(arg1);

		pcm.clickYes();

	}

	@Given("^User sets the End date as \"([^\"]*)\" end date in PFO batch history$")
	public void user_sets_the_End_date_as_end_date_in_PFO_batch_history(String arg1) throws Throwable {

		pcm.setEnddate_PFObatchHistory(arg1);
	}

	/*
	 * @Then("^User checks the Category ID and Validates Total sales amount and checks Transaction type \"([^\"]*)\" and date as \"([^\"]*)\"$"
	 * ) public void
	 * user_checks_the_Category_ID_and_Validates_Total_sales_amount_and_checks_Transaction_type_and_date_as(
	 * String arg1, String arg2) throws Throwable {
	 * 
	 * pcm.setDate_Postedprojecttransactions();
	 * 
	 * pcm.setFilterFieldText(arg2);
	 * 
	 * pcm.clickApply();
	 * 
	 * pcm.validateCategoryID_PostedTransactions();
	 * 
	 * pcm.validateTransactiontype_PostedTransactions(arg1);
	 * 
	 * pcm.validateTotalsalesamount_PostedTransactions(); }
	 */
	@Then("^User gets application number$")
	public void user_gets_application_number() throws Throwable {

	}

	// customer payment
	@Given("^User gets Invoice Journal ID and Invoice Account$")
	public void user_gets_Invoice_Journal_ID() throws Throwable {
		pcm.getInvoiceData();
	}

	@Given("^User enters Customer Payment Name$")
	public void user_enters_Customer_Payment_Name() throws Throwable {
		pcm.setCustomerPaymentName();
	}

	@Given("^User enters Account number from Invoice Journal, Offset account type and offset account$")
	public void user_enters_Account_number_from_Invoice_Journal_Offset_account_type_and_offset_account()
			throws Throwable {
		pcm.setCustomerPayments();
	}

	@Given("^User clicks on Settle transactions$")
	public void user_clicks_on_Settle_transactions() throws Throwable {
		pcm.clickSettleTransaction();
	}

	@Given("^User Select Mark$")
	public void user_Select_Mark() throws Throwable {
		pcm.clickMark_CheckBox();
	}

	@Given("^User gets Credit in CustomerPayment$")
	public void user_gets_Credit_in_CustomerPayment() throws Throwable {
		pcm.getCredit_CustomerPayment();
	}

	@Given("^User clicks on Post$")
	public void user_clicks_on_Post() throws Throwable {
		pcm.clickPost_Journal();
	}

	@Then("^User Validates Customer Payments Posted$")
	public void user_Validates_Customer_Payments_Posted() throws Throwable {
		pcm.checkCustomerPaymentsPostedMessage();
	}

	@Then("^User validates Revenue Budget, Cost Budget and Profit margin \"([^\"]*)\"$")
	public void user_validates_Revenue_Budget_Cost_Budget_and_Profit_margin(String arg1) throws Throwable {

		pcm.checkRevenueBudget(arg1);

		pcm.checkCostBudget(arg1);

		pcm.checkProfitMargin(arg1);

	}

	@Then("^User Validates Gross Margin \"([^\"]*)\"$")
	public void user_Validates_Gross_Margin(String arg1) throws Throwable {
		pcm.checkGrossMargin(arg1);
	}

	@Then("^User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals")
	public void user_gets_total_Invoice_amount_total_Invoice_line_amount_and_Customer_retained_amount_from_invoice_journals()
			throws Throwable {

		pcm.getSumOfInvoiceAmountAndInvoiceLineAmount();

	}

	@Then("^User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount from sheet \"([^\"]*)\"$")
	public void user_updates_Percent_complete_in_contract_and_validates_Work_in_place_Amount_remaining_and_Invoice_amount_from_sheet(
			String arg1) throws Throwable {

		pcm.setUpdatedContractAndValidateCalculations(arg1);
	}

	@Given("^User search the ProjectID for \"([^\"]*)\"$")
	public void user_search_the_ProjectID_for(String arg1) throws Throwable {

		pcm.setProjectID(arg1);
	}

	@Given("^User search the JournalProjectID for \"([^\"]*)\"$")
	public void user_search_the_JournalProjectID_for(String arg1) throws Throwable {

		pcm.setJournalProjectID(arg1);
	}

	@Given("^User clicks Show lines$")
	public void user_clicks_Show_lines() throws Throwable {

		pcm.clickShowlines();
	}

	@Given("^User selects \"([^\"]*)\"$")
	public void user_selects(String arg1) throws Throwable {

		pcm.clickOnlycosttransactions(arg1);
	}

	@Given("^User clicks Ok in All transactions$")
	public void user_clicks_Ok_in_All_transactions() throws Throwable {

		pcm.clickOk_AllTransactions();
	}

	@Given("^User clicks edit in budget versions$")
	public void user_clicks_edit_in_budget_versions() throws Throwable {

		pcm.clickEdit_BudgetVersions();
	}

	@Given("^User gets budget cost amount excluded from RevRec$")
	public void user_gets_budget_cost_amount_excluded_from_RevRec() throws Throwable {

		pcm.getCostBudget_ExcludeFromRevRec();
	}

	@Given("^User gets total amount$")
	public void user_gets_total_amount() throws Throwable {

		pcm.getTotalAmount_ExcludeRevRec_AllTransactions();
	}

	@Given("^User gets Cost budget$")
	public void user_gets_Cost_budget() throws Throwable {

		pcm.getCostBudget();
	}

	@Then("^User get ECAC Net Change value$")
	public void user_get_ECAC_Net_Change_value() throws Throwable {
		pcm.getECACNetChange_ECAC();
	}

	@Then("^User gets Purchase order number$")
	public void user_gets_Purchase_order_number() throws Throwable {

		pcm.getPurchaseorder_Subcontract();

	}

	@Given("^User gets Subcontract Total Amount$")
	public void user_gets_Subcontract_Total_Amount() throws Throwable {
		pcm.getSubContract();
	}

	@Then("^User validates \"([^\"]*)\" value in \"([^\"]*)\"$")
	public void user_validates_value_in(String arg1, String arg2) throws Throwable {

		pcm.switchToProjectFinancialOverviewDetailReport();

		pcm.checkPFOReportValues(arg1, arg2);

		common.switchToDefaultContent();
	}

	@Then("^User checks execution completed successfully for \"([^\"]*)\"$")
	public void user_checks_execution_completed_successfully_for(String arg1) throws Throwable {

		pcm.checkExecutionCompletedSuccessfully(arg1);

	}

	@Given("^User gets budget cost amount excluded from RevRec \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_gets_budget_cost_amount_excluded_from_RevRec_and(String arg1, String arg2) throws Throwable {

		pcm.getCostBudget_ExcludeFromRevRec(arg1, arg2);
	}

	@Then("^User checks for the PFO report mismatch fields$")
	public void user_checks_for_the_PFO_report_mismatch_fields() throws Throwable {

		pcm.checkPFOReportMismatches();
	}

	@Then("^User get Actual cost, PTD Earned Revenue and PTD Earned Margin$")
	public void user_get_Actual_cost_PTD_Earned_Revenue_and_PTD_Earned_Margin() throws Throwable {

		pcm.switchToProjectFinancialOverviewDetailReport();

		PTDEarnedRevenueValueExisting = pcm.getptdEarnedRevenue();

		logger.info("PTDEarnedRevenueValueExisting: " + PTDEarnedRevenueValueExisting);

		PTDEarnedMarginValueExisting = pcm.getptdEarnedMargin();

		logger.info("PTDEarnedMarginValueExisting: " + PTDEarnedMarginValueExisting);

		ActualCostValueExisting = pcm.getActualCost();

		logger.info("ActualCostValueExisting: " + ActualCostValueExisting);

		common.switchToDefaultContent();

	}

	@Then("^User gets Revenue budget in Customer change order$")
	public void user_gets_Revenue_budget_in_Customer_change_order() throws Throwable {

		pcm.getRevenueBudget_Customerchangeorder();
	}

	@Then("^User clicks on \"([^\"]*)\" in Subcontract Payment request$")
	public void user_clicks_on_in_Subcontract_Payment_request(String arg1) throws Throwable {

		pcm.clickNewSubcontractPayment(arg1);
	}

	@Then("^User gets Invoice Amount in Progress Subcontract$")
	public void user_gets_Invoice_Amount_in_Progress_Subcontract() throws Throwable {
		pcm.getInvoiceAmount_ProgressSubcontract();

	}

	@Then("^User gets total amount of \"([^\"]*)\"$")
	public void user_gets_total_amount_of(String arg1) throws Throwable {

		pcm.getTotalAmount_ExcludeRevRec_AllTransactions(arg1);
	}

	@Then("^User gets Project description in Customer change order screen$")
	public void user_gets_Project_description_in_Customer_change_order_screen() throws Throwable {

		pcm.getDescription_CCO();

	}

	@Then("^User validates Subcontract amount \"([^\"]*)\"$")
	public void user_validates_Subcontract_amount(String arg1) throws Throwable {
		pcm.checkSubContractAmount(arg1);
	}

	@Then("^User validates Subcontract_ChangeOrder \"([^\"]*)\"$")
	public void user_validates_Subcontract_ChangeOrder(String arg1) throws Throwable {
		pcm.checkChangeOrderAmount(arg1);
	}

	@Then("^User validates Subcontract total$")
	public void user_validates_Subcontract_total() throws Throwable {
		pcm.checkSubContractTotal();
	}

	@Then("^User Validates Costs$")
	public void user_Validates_Costs() throws Throwable {
		pcm.checkContractCalculations_costs();

	}

	@Then("^User sets PFO report date as \"([^\"]*)\"$")
	public void user_sets_PFO_report_date_as(String arg1) throws Throwable {

		pcm.setDate(arg1);
	}

	@Then("^User validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage for FinalInvoice$")
	public void validates_Work_in_place_Amount_remaining_Invoice_amount_Retainage_Amount_and_Total_Retainage_for_FinalInvoice()
			throws Throwable {
		pcm.checkContractCalculations_FinalInvoice();
	}

	@Then("^User search the ProjectID$")
	public void user_search_the_ProjectID() throws Throwable {

		pcm.EnterProjectID();

	}

	// =================CC Editable and non-Editable fields======================

	@Then("^User clicks on \"([^\"]*)\" in SIS Parameters$")
	public void user_clicks_on_in_SIS_Parameters(String arg1) throws Throwable {

		pcm.clickProjectcostmanagement_SISParameters(arg1);
	}

	@Then("^User sets \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_sets_as(String arg1, String arg2) throws Throwable {

		pcm.CheckConstructioncontract_FastTabIsEnabled();

		pcm.setAllowoverrideconstructioncontract_SISSystemParameter(arg1, arg2);
	}

	@Then("^User checks the \"([^\"]*)\" are editable$")
	public void user_checks_the_are_editable(String arg1) throws Throwable {

		pcm.checkFieldsEditableInContractOverView(arg1);
	}

	@Then("^User checks the \"([^\"]*)\" are not editable$")
	public void user_checks_the_are_not_editable(String arg1) throws Throwable {

		pcm.checkFieldsEditableInContractOverView(arg1);
	}

	@Then("^User checks the \"([^\"]*)\" field is editable$")
	public void user_checks_the_field_is_editable(String arg1) throws Throwable {

		pcm.checkFieldsEditableInECAC(arg1);
	}

	@Then("^User updates Percent complete in contract from sheet \"([^\"]*)\"$")
	public void user_updates_Percent_complete_in_contract_from_sheet(String arg1) throws Throwable {

		pcm.setUpdatedContract(arg1);
	}

	@Then("^validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage after percent complete update$")
	public void validates_Work_in_place_Amount_remaining_Invoice_amount_Retainage_Amount_and_Total_Retainage_after_percent_complete_update()
			throws Throwable {

		pcm.checkContractCalculations_AfterRetainageUpdate();

	}

	@Given("^User checks whether any ECAC committed$")
	public void user_checks_whether_any_ECAC_committed() throws Throwable {

		pcm.ProjectID_ECAC_ECACDisplayed();
	}

	@Given("^User gets \"([^\"]*)\" from project$")
	public void user_gets_from_project(String arg1) throws Throwable {

		pcm.getProjectData_Project(arg1);
	}

	@Given("^User checks \"([^\"]*)\" in Project ready for ECAC$")
	public void user_checks_in_Project_ready_for_ECAC(String arg1) throws Throwable {

		pcm.checkProjectstage_ProjectReadyForECAC(arg1);
	}

	@Then("^User checks the project is available in Project ready for ECAC screen$")
	public void user_checks_the_project_is_available_in_Project_ready_for_ECAC_screen() throws Throwable {

		pcm.checkProjectAvailableInProjReadyForECAC();
	}

//=================Loss making project=================
	@Then("^User checks the project is a \"([^\"]*)\"$")
	public void user_checks_the_project_is_a(String arg1) throws Throwable {

		pcm.checkLossMakingProject(arg1);
	}

	@Then("^User gets \"([^\"]*)\" from PFO Report$")
	public void user_gets_from_PFO_Report(String arg1) throws Throwable {

		pcm.switchToProjectFinancialOverviewDetailReport();

		pcm.getPFOvalue(arg1);

		common.switchToDefaultContent();
	}

	@Then("^User validates CreateItemRequirement is No$")
	public void user_validates_CreateItemRequirement_is_No() throws Throwable {
		pcm.CheckCreateItemRequirement();
	}

	@Then("^User clicks on \"([^\"]*)\" section$")
	public void user_clicks_on_section(String arg1) throws Throwable {
		pcm.clickItemrequirements();
	}

	@Then("^User enters Item Requirement data$")
	public void user_enters_Item_Requirement_data() throws Throwable {
		pcm.setItemRequirements();
	}

	@Then("^User clicks on \"([^\"]*)\" in Manage Section$")
	public void user_clicks_on_in_Manage_Section(String arg1) throws Throwable {
		pcm.ClickFunctions(arg1);
	}

	@Then("^User clicks on \"([^\"]*)\" in Functions$")
	public void user_clicks_on_in_Functions(String arg1) throws Throwable {
		pcm.ClickCreatePO(arg1);
	}

	@Then("^User enters Vendor Account for Item Requirements$")
	public void user_enters_Vendor_Account_for_Item_Requirements() throws Throwable {
		pcm.setVendorAccount_ItemRequirements();
	}

	@Then("^User enters Purchase Unit Price$")
	public void user_enters_Purchase_Unit_Price() throws Throwable {
		pcm.setPurchaseUnitPrice();
	}

	@Then("^User clicks on Include$")
	public void user_clicks_on_Include() throws Throwable {
		pcm.clickInclude_CheckBox();
	}

	@Then("^User gets Purchase Order Number and Reference Type$")
	public void user_gets_Purchase_Order_Number_and_Reference_Type() throws Throwable {
		pcm.getReferenceNumberandReferenceType();
	}

	@Then("^User clicks on Purchase Order ID$")
	public void user_clicks_on_Purchase_Order_ID() throws Throwable {
		pcm.clickPurchaseOrder_ItemRequirement();
	}

	@Then("^User Validates PurchaseOrderLines in Purchase order$")
	public void user_Validates_PurchaseOrderLines_in_Purchase_order() throws Throwable {
		pcm.checkPurchaseOrderLines_PurchaseOrder();
	}

	@Then("^User clicks on LineDetails Section$")
	public void user_clicks_on_LineDetails_Section() throws Throwable {
		pcm.clickLineDetails();
	}

	@Then("^User clicks on Project tab in LineDetails Section$")
	public void user_clicks_on_Project_tab_in_LineDetails_Section() throws Throwable {
		pcm.clickProject_LineDetails();
	}

	@Then("^User gets LineDetails of Purchase order$")
	public void user_gets_LineDetails_of_Purchase_order() throws Throwable {
		pcm.getPurchaseOrders_Linedetails();

	}

	@Then("^User Validates LineDetails-Item number,Product name,Task code,Quantity,Unit price,Net amount of Purchase order$")
	public void user_Validates_LineDetails_Item_number_Product_name_Task_code_Quantity_Unit_price_Net_amount_of_Purchase_order()
			throws Throwable {
		pcm.checkPurchaseOrders_Linedetails();
	}

	@Then("^User clicks on Purchase tab$")
	public void user_clicks_on_Purchase_tab() throws Throwable {
		pcm.clickPurchase();
	}

	@Then("^User clicks \"([^\"]*)\" in Action Section$")
	public void user_clicks_in_Action_Section(String arg1) throws Throwable {
		pcm.clickConfirm_Purchase(arg1);
	}

	@Given("^User clicks on \"([^\"]*)\" tab in Item Requirement$")
	public void user_clicks_on_tab_in_Item_Requirement(String arg1) throws Throwable {
		pcm.selectItemRequirement_Tab(arg1);
	}

	@Then("^User gets Tranasction ID$")
	public void user_gets_Tranasction_ID() throws Throwable {
		pcm.getTransactionID_ItemRequirement();
	}

	@Then("^User gets Product Name and Purchase Order Status of Item Requirement$")
	public void user_gets_Product_Name_and_Purchase_Order_Status_of_Item_Requirement() throws Throwable {
		pcm.getProductNameandLineStatus();
	}

	@Then("^User Validates Purchase Order, Vendor Account, Invoice Account, Vendor Name, Purchase Type, Approval Status, Purchase Order Status as \"([^\"]*)\" in Purchase Orders Table$")
	public void user_Validates_Purchase_Order_Vendor_Account_Invoice_Account_Vendor_Name_Purchase_Type_Approval_Status_Purchase_Order_Status_as_in_Purchase_Orders_Table(
			String arg1) throws Throwable {
		pcm.checkPurchaseOrders_ItemRequirement(arg1);
	}
	
	//============Cash position Pre-condition==============
	
			@Then("^User clicks on AP tab$")
			public void user_clicks_on_AP_tab() throws Throwable {
			  
				pcm.clickAP_Tab_Project360();
			}

			@Then("^User gets Total amount and Total amount to retain$")
			public void user_gets_Total_amount_and_Total_amount_to_retain() throws Throwable {
			
				pcm.getSumOfAmountAndAmountToRetainInProject360();
			}

			//Step def:
			//===================Validate application report===================
				
				@Then("^User selects the \"([^\"]*)\" Link$")
				public void user_selects_the_Link(String arg1) throws Throwable {
					// common.KeyboardAction("Enter");

					pcm.clickLink(arg1);

					Thread.sleep(10000);
				}
				
				//vendors	
				@Then("^User gets \"([^\"]*)\" data and update Complaince status$")
				public void user_gets_data_and_update_Complaince_status(String arg1) throws Throwable {
				    pcm.getComplianceItem(arg1);
				}
				@Then("^User Validates Vendor Compliance lines$")
				public void user_Validates_Vendor_Compliance_lines() throws Throwable {
				    pcm.getVendorComplianceData();
				}

				@Then("^User enters \"([^\"]*)\" data$")
				public void user_enters_data(String arg1) throws Throwable {
				   pcm.setSubcontractCompliance(arg1);
				}
				
				@Then("^User enters CutOff date$")
				public void user_enters_CutOff_date() throws Throwable {
				   pcm.setCutoffDate();
				}
				
				@Then("^User Clicks on Filter$")
				public void user_Clicks_on_Filter() throws Throwable {
				    pcm.clickFilter();
				}

				@Then("^User Enter Project ID for Verify subcontract compliance$")
				public void user_Enter_Project_ID_for_Verify_subcontract_compliance() throws Throwable {
				    pcm.setProjectID_VerifySubcontractCompliance();
				}
				
				@Then("^User clicks on OK in Verify subcontract compliance$")
				public void user_clicks_on_OK_in_Verify_subcontract_compliance() throws Throwable {
				    pcm.clickOKButton();
				}
				@Then("^User Clicks on Notification Icon$")
				public void user_Clicks_on_Notification_Icon() throws Throwable {
				    pcm.clickNotificationIcon();
				}

				@Then("^User Gets Notification messages and Validate$")
				public void user_Gets_Notification_messages_and_Validate() throws Throwable {
				    pcm.getMessageCenterData();
				}
				
				@Then("^User clicks on Add line$")
				public void user_clicks_on_Add_line() throws Throwable {
				    pcm.clickAddLine();
				}

				@Then("^user Enters Vendor agreements data$")
				public void user_Enters_Vendor_agreements_data() throws Throwable {
				    pcm.setVendorAgreements();
				}

				@Then("^User deletes \"([^\"]*)\" Vendor line$")
				public void user_deletes_Vendor_line(String arg1) throws Throwable {
				    pcm.checkExpirationDate(arg1);
				}

				@Then("^User clicks on New Subcontract Compliance$")
				public void user_clicks_on_New_Subcontract_Compliance() throws Throwable {
				    pcm.clickNew_SubcontractCompliance();
				}

				@Then("^User click on Header$")
				public void user_click_on_Header() throws Throwable {
				    pcm.clickHeader();
				}

				@Then("^User Clicks on Clear all$")
				public void user_Clicks_on_Clear_all() throws Throwable {
				    pcm.clickClearAll();
				}

				@Then("^User clicks on OK in Verify subcontract compliance Filter$")
				public void user_clicks_on_OK_in_Verify_subcontract_compliance_Filter() throws Throwable {
				    pcm.clickOKButton_Filter();
				}
				
				@Then("^User gets Subcontract Number$")
				public void user_gets_Subcontract_Number() throws Throwable {
				    pcm.getSubcontractNumber();
				}

				@Then("^User selects \"([^\"]*)\" in Subcontract$")
				public void user_selects_in_Subcontract(String arg1) throws Throwable {
				   pcm.selectSubcontract(arg1);
				}

				@Then("^User selects the Vendor account for \"([^\"]*)\"$")
				public void user_selects_the_Vendor_account_for(String arg1) throws Throwable {
				    pcm.setVendorAccount(arg1);
				}
				
				@Then("^User Validates Vendor Compliance Status after Verify Subcontract Compliance$")
				public void user_Validates_Vendor_Compliance_Status_after_Verify_Subcontract_Compliance() throws Throwable {
				    pcm.getVendorCompliance_Status();
				}

				@Then("^User Validates Subcontract Compliance Status after Verify Subcontract Compliance$")
				public void user_Validates_Subcontract_Compliance_Status_after_Verify_Subcontract_Compliance() throws Throwable {
				    pcm.getSubcontractCompliance_Status();
				}

}