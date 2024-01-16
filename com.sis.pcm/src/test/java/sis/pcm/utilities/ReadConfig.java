package sis.pcm.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import sis.pcm.stepdefinitions.baseclass;

public class ReadConfig {

	Properties prop = new Properties();

	public ReadConfig() {

		try {
			FileInputStream source = new FileInputStream(
					System.getProperty("user.dir") + "/configuration/config.properties");
			prop.load(source);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getbrowser() {
		String browserpath = prop.getProperty("chromepath");
		return browserpath;
	}

	// Excel Data Sheet
	public String XLsetup = "./excel/PCM_TestData.xlsx";
	// Excel Tabs
	public String setup = "setup";

	public String ProjectCreation = "ProjectCreation";

	public String BudgetLines = "BudgetLines";

	public String ConstructionContract = "ConstructionContract";

	public String UpdateContract = "UpdateContract";

	// Added by Monica
	public String Journals = "Journals";

	public String HourJournal = "HourJournal";

	public String ItemJournal = "ItemJournal";

	public String ExpenseJournal = "ExpenseJournal";

	public String RevenueRecognition = "RevenueRecognition";

	public String ReleaseAndCancelRetainage = "ReleaseAndCancelRetainage";

	public String ECAC = "ECAC";

	public String BudgetLines_Revision1 = "BudgetLines_Revision1";

	public String BudgetLines_Revision2 = "BudgetLines_Revision2";

	public String HourJournalPeriod2 = "HourJournalPeriod2";

	public String ItemJournalPeriod2 = "ItemJournalPeriod2";

	public String ExpenseJournalPeriod2 = "ExpenseJournalPeriod2";

	// arthi
	public String SubContract = "SubContract_Original";

	public String SubContract_Revision1 = "SubContract_Revision1";

	public String CustomerPayment = "CustomerPayment";

	public String UpdateContract1 = "UpdateContract1";

	public String UpdateContract2 = "UpdateContract2";

	public String ProjectID = "ProjectID";

	public String JournalsData = "JournalsData";

	public String ItemRequirements = "ItemRequirements";

	public String Subcontract_Compliance = "Subcontract_Compliance";

	public String Subcontract_Compliance_add1 = "Subcontract_Compliance_add1";

	public String Subcontract_Compliance_add2 = "Subcontract_Compliance_add2";

	public String SubcontractCompliance_Valid = "SubcontractCompliance_Valid";

	public String SubcontractCompliance_Expired = "SubcontractCompliance_Expired";

	public String VendorAgreements = "VendorAgreements";

	// -----------------------------------PCM Log
	// in--------------------------------------------------------------//
	public String getXL_PCM_Url() {
		String XL_PCM_Url = null;
		try {
			XL_PCM_Url = XLUtils.getCellData(XLsetup, setup, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_PCM_Url;
	}

	public String getXL_PCM_Username() {
		String XL_PCM_Username = null;
		try {
			XL_PCM_Username = XLUtils.getCellData(XLsetup, setup, 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_PCM_Username;
	}

	public String getXl_PCM_Password() {
		String XL_PCM_Password = null;
		try {
			XL_PCM_Password = XLUtils.getCellData(XLsetup, setup, 1, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_PCM_Password;
	}

	public String getXl_ProjectGroup() {
		String XL_ProjectGroup = null;
		try {
			XL_ProjectGroup = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_ProjectGroup;
	}

	public String getXl_Fundingtype() {
		String XL_Fundingtype = null;
		try {
			XL_Fundingtype = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Fundingtype;
	}

	public String getXl_Fundingsource() {
		String XL_Fundingsource = null;
		try {
			XL_Fundingsource = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Fundingsource;
	}

	public String getXl_Projectmanagername() {
		String XL_Projectmanagername = null;
		try {
			XL_Projectmanagername = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Projectmanagername;
	}

	/*
	 * public String getXl_Retainage() { String XL_Retainage = null; try {
	 * XL_Retainage = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 4); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return XL_Retainage; }
	 * 
	 * public String getXl_Speciality() { String XL_Speciality = null; try {
	 * XL_Speciality = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 5); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return XL_Speciality; }
	 * 
	 * public String getXl_VendorAccount() { String XL_VendorAccount = null; try {
	 * XL_VendorAccount = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 6); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return XL_VendorAccount; }
	 */

	public ArrayList<ArrayList<String>> getXl_Data(String SheetName) throws IOException {

		int xlrowcount = XLUtils.getRowCount(XLsetup, SheetName);

		int xlcellcount = XLUtils.getCellCount(XLsetup, SheetName, 0);

		ArrayList<String> Data = new ArrayList<String>();

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();

		for (int row = 1; row <= xlrowcount; row++) {

			for (int column = 0; column < xlcellcount; column++) {

				String value = XLUtils.getCellData(XLsetup, SheetName, row, column).trim();

				Data.add(value);
			}

			DataSet.add(new ArrayList<String>(Data));

			Data.clear();

		}

		return DataSet;

	}

	public ArrayList<ArrayList<String>> getXl_Bugdgetlines() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(BudgetLines);

		System.out.println("Budget Lines Data:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_ContructionContract() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ConstructionContract);

		System.out.println("Construction Contract Data:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_SubContract() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(SubContract);

		System.out.println("Sub contract Data:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_UpdateContract() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(UpdateContract);

		System.out.println("Updated contract Data:" + XlData);

		return XlData;

	}

	// ------------------Monica--------------------

	public String getXlProjectID_Journal() {
		String XlProjectID_Journal = null;
		try {
			XlProjectID_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlProjectID_Journal;
	}

	public ArrayList<ArrayList<String>> getXl_HourJournals() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(HourJournal);

		System.out.println("Hour Journal Data:" + XlData);

		return XlData;

	}

	// Item Journal
	public String getXlItemName_Journal() {
		String XlItemName_Journal = null;
		try {
			XlItemName_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlItemName_Journal;
	}

	public ArrayList<ArrayList<String>> getXl_ItemJournals() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ItemJournal);

		System.out.println("Item Journal Data:" + XlData);

		return XlData;
	}

//Expense Journal

	public ArrayList<ArrayList<String>> getXl_ExpenseJournals() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ExpenseJournal);

		System.out.println("Expense Journal Data:" + XlData);

		return XlData;

	}

	// Ruel ID
	public String getXlRuleID_Journal() {
		String XlRuleID_Journal = null;
		try {
			XlRuleID_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlRuleID_Journal;
	}

	// ====================== Execute Revenue recognition using
	// PFO==============================
	public String getXlFiscalYear_RefreshProjFinancialData() {
		String XlFiscalYear_RefreshProjFinancialData = null;
		try {
			XlFiscalYear_RefreshProjFinancialData = XLUtils.getCellData(XLsetup, RevenueRecognition, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlFiscalYear_RefreshProjFinancialData;
	}

	public String getXlEndDate_RefreshProjFinancialData() {
		String XlEndDate_RefreshProjFinancialData = null;
		try {
			XlEndDate_RefreshProjFinancialData = XLUtils.getCellData(XLsetup, RevenueRecognition, 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlEndDate_RefreshProjFinancialData;
	}

	/*
	 * public String getXlRetainagePercentage1_ConstructionContract() {
	 * 
	 * String XlRetainagePercentage1_ConstructionContract = null; try {
	 * XlRetainagePercentage1_ConstructionContract = XLUtils.getCellData(XLsetup,
	 * ReleaseAndCancelRetainage, 1, 0); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return
	 * XlRetainagePercentage1_ConstructionContract; }
	 * 
	 * public String getXlRetainagePercentage2_ConstructionContract() {
	 * 
	 * String XlRetainagePercentage2_ConstructionContract = null; try {
	 * XlRetainagePercentage2_ConstructionContract = XLUtils.getCellData(XLsetup,
	 * ReleaseAndCancelRetainage, 1, 1); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return
	 * XlRetainagePercentage2_ConstructionContract; }
	 */

	public ArrayList<ArrayList<String>> getXl_ECAC() throws IOException {

		int xlrowcount = XLUtils.getRowCount(XLsetup, ECAC);

		int xlcellcount = XLUtils.getCellCount(XLsetup, ECAC, 0);

		System.out.println("xlrowcount:" + xlrowcount);

		System.out.println("xlcellcount:" + xlcellcount);

		ArrayList<String> Data = new ArrayList<String>();

		ArrayList<ArrayList<String>> DataSet = new ArrayList<ArrayList<String>>();

		for (int row = 1; row <= xlrowcount; row++) {

			for (int column = 0; column < xlcellcount; column++) {

				String value = XLUtils.getCellData(XLsetup, ECAC, row, column).trim();

				Data.add(value);
			}

			DataSet.add(new ArrayList<String>(Data));

			Data.clear();

		}

		System.out.println("ECAC:" + DataSet);

		return DataSet;

	}

	public ArrayList<ArrayList<String>> getXl_Bugdgetlines_Revision1() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(BudgetLines_Revision1);

		System.out.println("Budget Lines Data 1:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_Bugdgetlines_Revision2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(BudgetLines_Revision2);

		System.out.println("Budget Lines Data 2:" + XlData);

		return XlData;

	}

	// 17th Scenario
	/*
	 * public ArrayList<ArrayList<String>> getXl_HourJournalsForPeriod2() throws
	 * IOException {
	 * 
	 * ArrayList<ArrayList<String>> XlData = getXl_Data(HourJournalPeriod2);
	 * 
	 * System.out.println("Hour Journal Data:" + XlData);
	 * 
	 * return XlData;
	 * 
	 * }
	 * 
	 * public ArrayList<ArrayList<String>> getXl_ItemJournalsForPeriod2() throws
	 * IOException {
	 * 
	 * ArrayList<ArrayList<String>> XlData = getXl_Data(ItemJournalPeriod2);
	 * 
	 * System.out.println("Item Journal Data:" + XlData);
	 * 
	 * return XlData; }
	 * 
	 * public ArrayList<ArrayList<String>> getXl_ExpenseJournalsForPeriod2() throws
	 * IOException {
	 * 
	 * ArrayList<ArrayList<String>> XlData = getXl_Data(ExpenseJournalPeriod2);
	 * 
	 * System.out.println("Expense Journal Data:" + XlData);
	 * 
	 * return XlData;
	 * 
	 * }
	 */

	public ArrayList<ArrayList<String>> getXl_SubContract_Revision1() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(SubContract_Revision1);

		System.out.println("Sub contract Data Revision1 :" + XlData);

		return XlData;

	}

	// Recent changes
	public ArrayList<ArrayList<String>> getXl_HourJournalsForPeriod2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(HourJournalPeriod2);

		System.out.println("Hour Journal Data:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_ItemJournalsForPeriod2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ItemJournalPeriod2);

		System.out.println("Item Journal Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_ExpenseJournalsForPeriod2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ExpenseJournalPeriod2);

		System.out.println("Expense Journal Data:" + XlData);

		return XlData;

	}

	// ===========

	public String getXlPercentCompletePeriod2_Journal() {
		String XlPercentCompletePeriod2_Journal = null;
		try {
			XlPercentCompletePeriod2_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlPercentCompletePeriod2_Journal;
	}

	public String getXlName_SubcontractPaymentRelease_Journal() {
		String XlName_SubcontractPaymentRelease_Journal = null;
		try {
			XlName_SubcontractPaymentRelease_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlName_SubcontractPaymentRelease_Journal;
	}

	public String getXlOffSetAccountType_SubcontractPaymentRelease_Journal() {
		String XlOffSetAccountType_SubcontractPaymentRelease_Journal = null;
		try {
			XlOffSetAccountType_SubcontractPaymentRelease_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlOffSetAccountType_SubcontractPaymentRelease_Journal;
	}

	public String getXlOffSetAccount_SubcontractPaymentRelease_Journal() {
		String XlOffSetAccount_SubcontractPaymentRelease_Journal = null;
		try {
			XlOffSetAccount_SubcontractPaymentRelease_Journal = XLUtils.getCellData(XLsetup, Journals, 1, 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlOffSetAccount_SubcontractPaymentRelease_Journal;
	}

	public String getXlRetainagePercentage1_ConstructionContract() {

		String XlRetainagePercentage1_ConstructionContract = null;
		try {
			XlRetainagePercentage1_ConstructionContract = XLUtils.getCellData(XLsetup, Journals, 1, 6);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlRetainagePercentage1_ConstructionContract;
	}

	public String getXlRetainagePercentage2_ConstructionContract() {

		String XlRetainagePercentage2_ConstructionContract = null;
		try {
			XlRetainagePercentage2_ConstructionContract = XLUtils.getCellData(XLsetup, Journals, 1, 7);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XlRetainagePercentage2_ConstructionContract;
	}

	public String getXl_Retainage() {
		String XL_Retainage = null;
		try {
			XL_Retainage = XLUtils.getCellData(XLsetup, Journals, 1, 8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Retainage;
	}

	public String getXl_Speciality() {
		String XL_Speciality = null;
		try {
			XL_Speciality = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Speciality;
	}

	public String getXl_VendorAccount() {
		String XL_VendorAccount = null;
		try {
			XL_VendorAccount = XLUtils.getCellData(XLsetup, ProjectCreation, 1, 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_VendorAccount;
	}

	public String getXl_CustomerPaymentName() {
		String XL_Name = null;
		try {
			XL_Name = XLUtils.getCellData(XLsetup, CustomerPayment, 1, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_Name;
	}

	public String getXl_OffsetAccountType() {
		String XL_OffsetAccountType = null;
		try {
			XL_OffsetAccountType = XLUtils.getCellData(XLsetup, CustomerPayment, 1, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_OffsetAccountType;
	}

	public String getXl_OffsetAccount() {
		String XL_OffsetAccount = null;
		try {
			XL_OffsetAccount = XLUtils.getCellData(XLsetup, CustomerPayment, 1, 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XL_OffsetAccount;
	}

	public ArrayList<ArrayList<String>> getXl_UpdateContract1() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(UpdateContract1);

		System.out.println("Updated contract1 Data:" + XlData);

		return XlData;

	}

	public ArrayList<ArrayList<String>> getXl_UpdateContract2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(UpdateContract2);

		System.out.println("Updated contract2 Data:" + XlData);

		return XlData;

	}

	public HashMap<String, String> getProjectID_TestData() throws IOException {

		int xlrowcount = XLUtils.getRowCount(XLsetup, ProjectID);

		HashMap<String, String> ProjectID_TestData = new HashMap<String, String>();

		for (int row = 1; row <= xlrowcount; row++) {

			String value1 = XLUtils.getCellData(XLsetup, ProjectID, row, 0).trim();

			String value2 = XLUtils.getCellData(XLsetup, ProjectID, row, 1).trim();

			ProjectID_TestData.put(value1, value2);
		}

		return ProjectID_TestData;
	}

	public HashMap<String, String> getJournal_TestData() throws IOException {
//For Journals Test Data
		int xlrowcount = XLUtils.getRowCount(XLsetup, JournalsData);
		HashMap<String, String> ProjectID_TestData = new HashMap<String, String>();

		for (int row = 1; row <= xlrowcount; row++) {

			String value1 = XLUtils.getCellData(XLsetup, JournalsData, row, 0).trim();
			String value2 = XLUtils.getCellData(XLsetup, JournalsData, row, 1).trim();

			ProjectID_TestData.put(value1, value2);
		}
		return ProjectID_TestData;
	}

	public String getXl_PercentComplete3() {
		String Xl_PercentComplete3 = null;
		try {
			Xl_PercentComplete3 = XLUtils.getCellData(XLsetup, Journals, 1, 9);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Xl_PercentComplete3;
	}

	public ArrayList<ArrayList<String>> getXl_ItemRequirements() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(ItemRequirements);

		System.out.println("Item Requirement Data:" + XlData);

		return XlData;
	}

	// vendor

	public ArrayList<ArrayList<String>> getXl_Subcontract_Compliance() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(Subcontract_Compliance);

		System.out.println("Subcontract_Compliance Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_Subcontract_Compliance_add1() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(Subcontract_Compliance_add1);

		System.out.println("Subcontract_Compliance additional 1 Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_Subcontract_Compliance_add2() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(Subcontract_Compliance_add2);

		System.out.println("Subcontract_Compliance additional 2 Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_SubcontractCompliance_Valid() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(SubcontractCompliance_Valid);

		System.out.println("SubcontractCompliance_Valid date Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_SubcontractCompliance_Expired() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(SubcontractCompliance_Expired);

		System.out.println("SubcontractCompliance_Expired Date Data:" + XlData);

		return XlData;
	}

	public ArrayList<ArrayList<String>> getXl_VendorAgreements() throws IOException {

		ArrayList<ArrayList<String>> XlData = getXl_Data(VendorAgreements);

		System.out.println("VendorAgreements Data:" + XlData);

		return XlData;
	}
}