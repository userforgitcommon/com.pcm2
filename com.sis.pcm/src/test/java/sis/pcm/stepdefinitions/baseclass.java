package sis.pcm.stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import sis.pcm.pageobjects.common_pom;
import sis.pcm.pageobjects.pcm_pom;
import sis.pcm.utilities.ReadConfig;

public class baseclass {

	public WebDriver driver;
	public static Logger logger;

	ReadConfig rd = new ReadConfig();
	public String browser = rd.getbrowser();
	public pcm_pom pcm;
	public common_pom common;

	public static SoftAssert sa;

	public static String pcmusername;

	public static String ProjectIDValue;

	public static String ProjectNameValue;

	public static String ProjectContractIDValue;

	public static String ProjectGroupValue;

	public static String FundingTypeValue;

	public static String FundingSourceValue;

	public static String ProjectManagerNameValue;

	public static ArrayList<ArrayList<String>> BudgetLines;

	public static ArrayList<ArrayList<String>> ConstructionContracts;

	public static ArrayList<ArrayList<String>> SubContracts;

	public static ArrayList<ArrayList<String>> UpdateContracts;

	public static ArrayList<ArrayList<String>> DataInContractOverview;

	public static ArrayList<ArrayList<String>> DataInContractApplications;

	public static String RevenueBudgetValue_Expected;

	public static String RevenueBudgetValue_Contract;

	public static String SalesamountValue;

	public static String CostBudgetValue_Expected;

	public static String ProfitmarginValue_Expected;

	public static String RetainageValue;

	public static String ScheduledValue_Total;

	public static String SpecialityValue;

	public static String VendorAccountValue;

	public static String ExpectedSubcontractAmountValue;

	public static String PurchaseOrderValue;

	public static ArrayList<String> BudgetCategories_ExcludedFromRevRec;

	public static ArrayList<String> BudgetCategories_RevenueType;

	public static ArrayList<String> BudgetCategories_ExpenseType;

	public static HashMap<String, ArrayList<String>> BudgetCategory_ProjectCategories_Mapping;

	public static String TotalSalesAmount;

	public static String TotalCostAmount;

	public static String AmountInTransactionCurrency;

	public static HashMap<String, String> InvoiceAmount_HourJournals;

	public static HashMap<String, String> InvoiceAmount_ItemJournals;

	public static HashMap<String, String> InvoiceAmount_ExpenseJournals;

	public static HashMap<String, String> InvoiceAmount_Journals;

	public static String RetainageAmount_Applications = "0.00";

	public static String AmountDue_Applications = "0.00";

	public static String InvoiceAmountTotal_ContractApplications;

	public static String Amount_OverheadTransactions_Total = "0.00";

	public static String Amount_OverheadTransactions_Total_Posted = "0.00";

	public static String Amount_OverheadTransactions_Total_ExcludeFromRevRec = "0.00";

	public static String Amount_OverheadTransactions_Total_Posted_ExcludeFromRevRec = "0.00";

	public static String ARBalance = "0.00";

	public static String ARRetention = "0.00";

	// --------------------Monica--------------------------

	public static String ProjectID_Journal;
	public static ArrayList<ArrayList<String>> HourJournals;
	public String JournalId;
	public static String ItemName;
	public static ArrayList<ArrayList<String>> ItemJournals;
	public static ArrayList<ArrayList<String>> ExpenseJournals;
	public String ExpenseJournalId;
	public static String RuleId;
	public static HashMap<String, ArrayList<String>> ProjectAllocationRates;
	public static HashMap<String, String> DestinatonCategory;
	public static HashMap<String, ArrayList<String>> InventoryData;
	public static String ItemNumber;
	public static HashMap<String, ArrayList<String>> ManageCostsData;
	public static HashMap<String, ArrayList<String>> ExtendedAttributesData;
	public static HashMap<String, ArrayList<String>> EquipmentStandardCosts;
	public static HashMap<String, String> ProjectCategories_FieldService;

	// =======================Excecute revenue recognition using
	// PFO=========================
	public static String FiscalYear_RefreshProjFinData;
	public static String EndDate_RefreshProjFinData;
	public static String TaskDescription_RefreshProjFinData;
	public static String JobID;
	public static HashMap<String, String> RevenueRecognition;
	public static String CategoryID;

	// ===============Added by Monica(21-02-2023)======================

	// ==========Release and cancel retainage amount========================

	public static HashMap<String, String> ConstructionContract_PercentComplete;
	public static HashMap<String, String> ConstructionContract_WorkInPlace;
	public static String RetainagePercentage1_ConstructionContract;
	public static String RetainagePercentage2_ConstructionContract;
	public static HashMap<String, String> ConstructionContract_RetainagePercentage;
	public static HashMap<String, String> ConstructionContract_RetainageAmount;
	public static HashMap<String, String> ConstructionContract_PrevRetainage;
	public static HashMap<String, String> ConstructionContract_TotalRetainage;
	public static HashMap<String, String> ConstructionContract_PrevWorkInPlace;
	public static HashMap<String, String> ConstructionContract_PrevPercentage;
	public static HashMap<String, String> ConstructionContract_Cost;
	public static HashMap<String, String> ConstructionContract_InvoiceAmount;
	public static HashMap<String, String> ConstructionContract_AmountRemaining;

	public static HashMap<String, String> ConstructionContract_PercentComplete_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_WorkInPlace_AfterRetainageChange;
	public static String RetainagePercentage1_ConstructionContract_AfterRetainageChange;
	public static String RetainagePercentage2_ConstructionContract_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_RetainagePercentage_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_RetainageAmount_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_PrevRetainage_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_TotalRetainage_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_PrevWorkInPlace_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_PrevPercentage_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_Cost_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_InvoiceAmount_AfterRetainageChange;
	public static HashMap<String, String> ConstructionContract_AmountRemaining_AfterRetainageChange;

	public static String RetentionInvoiceValue;
	public static String InvoiceValue;
	public static HashMap<String, String> PercentComplete_CCapplication;
	public static HashMap<String, String> InvoiceAmount_CCapplication;
	public static HashMap<String, String> RetainagePercentage_CCapplication;
	public static HashMap<String, String> RetentionToDate_CCapplication;
	public static HashMap<String, String> RetainageAmount_CCapplication;
	public static HashMap<String, String> AmountDue_CCapplication;
	public static HashMap<String, String> AmountData_Journals;

	public static HashMap<String, String> BudgetCategory_ECACcalctype_Mapping;
	public static ArrayList<ArrayList<String>> UpdateECACData;
	public static HashMap<String, String> BudgetLines_LineAmount;
	public static HashMap<String, String> Journals_ActualAmount;
	public static HashMap<String, String> SubContract_NetAmount;

	public static String RetainageAmount_Applications_FromRetainageReleaseData;

	public static String AmountDue_Applications_FromRetainageReleaseData;

	public static String InvoiceAmount_Applications_FromRetainageReleaseData;

	public static String RetentionReversalValue;

	public static String GrossMarginValue_Expected;
	public static HashMap<String, String> changeOrderId;
	public static HashMap<String, ArrayList<ArrayList<String>>> TaskSummary_Expected;
	public static HashMap<String, String> ECACNetChangeValue_AfterChanges;

	// ===============Progress subcontract=========================

	public static String VendorInvoiceNumberValue;

	public static String SubcontractPayment_NetAmount;

	public static String SubcontractPayment_InvoiceAmount;

	public static String InvoiceAmountValue = "0.00";

	public static String TotalCostAmount_CommittedCost;

//17th scenario

	public static ArrayList<ArrayList<String>> HourJournals_Period2;

	public static ArrayList<ArrayList<String>> ItemJournals_Period2;

	public static ArrayList<ArrayList<String>> ExpenseJournals_Period2;

	public static String InvoiceAmount_Invoicejournals;

	public static String InvoiceLineAmount_Invoicejournals;

	public static String CustomerRetainedAmount_Invoicejournals;

	public static String RetentionReleaseAmount_Invoicejournals;

	// Added by Carolin

	public static String CustomerChangeOrderNo;
	public static String ChangeOrderIdValue;
	public static String ProjectDescription;
	public static String BillingDefaultBasis_SISParameterTable;
	public static String constructionContractLineNum_CustomerChangeOrderPg;

	// Subcontract Change Order Arthi
	public static ArrayList<String> SubContract_ChangeOrderNumber;
	public static HashMap<String, ArrayList<ArrayList<String>>> SubContractCommittedCost_Expected;
	public static HashMap<String, ArrayList<ArrayList<String>>> PurchaseOrder_Expected;

	public static String ExpectedChangeOrderAmountValue;

	// Recent changes
	public static String ProjectdateValue_Journal;

	public static String PercentCompletePeriod2_Journal;

	public static HashMap<String, String> VendorInvoices;

	// 20th scenario

	public static String Name_SubcontractPaymentRelease;

	public static String OffSetAccountType_SubcontractPaymentRelease;

	public static String OffSetAccount_SubcontractPaymentRelease;

	public static String Debit_SubcontractPayment;

	public static String strDescription;

	// Customer payment
	public static String CustomerPaymentName;
	public static String OffsetAccountType;
	public static String OffsetAccount;
	public static String InvoiceJournalIDValue;
	public static String InvoiceAccountValue;

	// budget
	public static HashMap<String, String> BudgetTotalsData;

	public static ArrayList<ArrayList<String>> UpdateContracts1;

	public static ArrayList<ArrayList<String>> UpdateContracts2;

	public static String InvoiceAmount_Invoicejournals_CurrentPeriod;

	public static String InvoiceLineAmount_Invoicejournals_CurrentPeriod;

	public static String CustomerRetainedAmount_Invoicejournals_CurrentPeriod;

	public static String RetentionReleaseAmount_Invoicejournals_CurrentPeriod;

	public static String InvoiceAmount_Invoicejournals_NextPeriod;

	public static String InvoiceLineAmount_Invoicejournals_NextPeriod;

	public static String CustomerRetainedAmount_Invoicejournals_NextPeriod;

	public static String RetentionReleaseAmount_Invoicejournals_NextPeriod;

	// Test Data

	public static HashMap<String, String> ProjectID_TestData;

	public static HashMap<String, String> JournalProjectID_TestData;

	public static ArrayList<ArrayList<String>> AllTransactions;
	public static String CostBudget_BudgetVersions;
	public static HashMap<String, String> Budgetdata;

	// public static String BudgetAmount_ExcludedFromRevRec;

	public static String LineAmount_Total_ExcludeFromRevRec = "0.00";

	public static String CostBudget_ExcludeRevRec;

	public static String ECACNetChangeValueTotal = "0.00";

	// Arthi ECAC Table
	// baseclass
	public static HashMap<String, String> JournalsAmount_AllTransactions;

	public static HashMap<String, String> BudgetVersions_LineAmount;

	public static HashMap<String, String> SubContractNetAmount;

	// public static HashMap<String, String> BudgetLineAmount_RevRecTotal;

	public static HashMap<String, String> BudgetAmount_ExcludeRevRec;

	public static HashMap<String, String> Budget_RevenueBudget;

	public static HashMap<String, String> Budget_CostBudget;

	public static String BudgetLineAmount_ExcludedFromRevRec;

	public String RevenueBudget_CustomerCO;

	public static String ECACNetChangeValue;

	public static HashMap<String, String> BudgetLineAmount_RevRecTotal;

	public static String InvoiceAmountTotal = "0.00";

	// public static String ActualCostValue;

	public static String strDescription_CCO;

	public static ArrayList<ArrayList<String>> UpdateContracts3;

	public static String PercentComplete3;

	public static String Amount_OverheadTransactions_Total_CurrentPeriod;

	public static String Amount_OverheadTransactions_Total_NextPeriod;

	public static String Amount_OverheadTransactions_Total_ExcludeFromRevRec_CurrentPeriod;

	public static String Amount_OverheadTransactions_Total_ExcludeFromRevRec_NextPeriod;

	public static String PTDEarnedRevenueValueExisting = "0.00";

	public static String PTDEarnedMarginValueExisting = "0.00";

	public static String ActualCostValueExisting = "0.00";

	public static String PFOPeriod;

	// ===================CC Editable and Non-Editable fields===============

	public static String Allowoverrideconstructioncontract_SISSystemParameterValue;

	public static String CreditValue = "0.00";

	// ============Project ready for ECAC==================

	public static String ProjectStage_Project;

	public static String LastActivityDate_Project;

	public static String LastECACdate_Project;
	// ===============Loss making project================

	public static String CurrentCV_PFOReport;
	public static String ECACcost_ECAC_PFOReport;

	public static ArrayList<ArrayList<String>> ItemReqirements;

	public static String PurchaseUnitPriceValue;

	public static String ReferenceNumber_PurchaseOrder;

	public ArrayList<String> ActualPurchaseOrders_LineDetails;

	public ArrayList<String> ExpectedPurchaseOrders_LineDetails;

	public static String ProductName_ItemRequirement;

	public static String TransactionID_ItemRequirement;

	public static String VendorAccount_Name;

	public ArrayList<String> ExpectedItemRequirement_CommittedCost;

	public ArrayList<String> ExpectedPurchaseOrders;

	public static String LineStatus_ItemRequirement;

	public static String ReferenceType_PurchaseOrder;


	public static HashMap<String, ArrayList<String>> ComplianceItem_Data;

	public static HashMap<String, HashMap<String, ArrayList<String>>> ComplianceItem_VendorsMapping;

	public static ArrayList<ArrayList<String>> Subcontract_Compliance;

	public static ArrayList<ArrayList<String>> Subcontract_Compliance_add1;

	public static ArrayList<ArrayList<String>> Subcontract_Compliance_add2;

	public static ArrayList<ArrayList<String>> SubcontractCompliance_Valid;

	public static ArrayList<ArrayList<String>> SubcontractCompliance_Expired;

	public static ArrayList<ArrayList<String>> VendorAgreements;

	public static HashMap<String, String> Subcontract_SubcontractNumberMapping;

	public static String SubcontractNumberValue;

	public static String VendorAccount_SubcontractComplianceadd2;

	public static ArrayList<String> ExpectedNotificationMessage_VendorSubcontractCompliance;
	
	public static String TotalAmount_AP_Project360;
	
	public static String TotalSettledAmount_AP_Project360;

    public static String TotalAmountToRetain_AP_Project360;

}