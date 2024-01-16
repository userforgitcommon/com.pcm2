#Author: Arthi Ganeshan
#Keywords Summary : Subcontract Change Order And Validation
@tag
Feature: SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment

  
		@tag1
		Scenario: SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment
	  Given User Login Finance and Operations Application   
    Then Wait "10" Seconds
    And User checks the Budget categories config data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "Project allocation rules" sub-module
    And User selects the Rule ID "DEMO2" 
    And User gets Project allocation rules data
    And User clicks on Expand the navigation pan icon
    And User clicks on "Released products" sub-module of "Product information management" module
    And User gets Extended Attributes config data, Inventory config data and Field Service config data
    And User clicks on Expand the navigation pan icon    
    And User clicks on "Equipment standard costs" sub-module of "Equipment usage" module
    And User gets the Equipment standard costa data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "All projects" sub-module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 6"
    And User clicks Apply button
    
    #BudgetVersion pre condition
    And User clicks on "Project cost management" in page header
    And User clicks on "Budget versions" in "Project cost management" section
    Then Wait "5" Seconds
    And User gets budget cost amount excluded from RevRec "BudgetLines_Original" and "Current_Period"
    And User clicks on Close
    And User gets budget cost amount excluded from RevRec "BudgetLines_Revision1" and "Current_Period"
    And User clicks on Close
    And User gets budget cost amount excluded from RevRec "BudgetLines_Revision2" and "Next_Period"
    And User clicks on Close
    And User clicks on Close
    
    #PFO precondition ECAC 
    And User clicks on "Project cost management" in page header 
    And User clicks on "ECAC" in "Project cost management" section 
    And User get ECAC Net Change value
    And User clicks on Close 
    
    #subcontract pre condition
    And User clicks on "Subcontracts" in "Contracts" section
    And User Clicks Edit
    Then Wait "5" Seconds
    And User gets Subcontract Total Amount
    And User clicks on Close
    And User clicks on Close
    
    #Subcontract change order 
    And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks New in Change Orders
    Then Wait "5" Seconds
    Then User Gets SubContract Change Order Number
    And User Set SubContract Change Order Date
    And User clicks on Save
    And User click on Lines
    And User enters the Subcontract "SubContract_Revision1" data and validates the Net amount
    And User clicks on Save
    And User "Submit" Subcontract
    Then Wait "10" Seconds
    Then User validates the Subcontract status is "Submitted"
    And User "Approve" Subcontract
    Then Wait "10" Seconds
    Then User validates the Subcontract status is "Approved"
    And User "Commit" Subcontract
    Then Wait "15" Seconds
    Then User validates the Subcontract status is "Commit" 
    And User clicks on Purchase Order
    Then User Validate Subcontract Change Order Added Lines in Purchase Order Table "SubContract_Revision1"
    Then User Validate SubContract Purchase Order Status "Open order"
    Then User Validate Approval Status "Confirmed"
    And User clicks on Close
    And User clicks on Close
    And User clicks on Edit
    Then Wait "5" Seconds
    Then User validates Subcontract amount, Change Order and Subcontract total "SubContract_Revision1"
    And User clicks on Close
    And User clicks on Close
    Then Wait "5" Seconds
    And User clicks on "Control" in page header
    And User Clicks on "Committed cost" in Control Section
    Then Wait "10" Seconds
    Then User Validate Committed Cost Table "SubContract_Revision1"
    And User clicks on Close
    
    And User clicks on "Control" in page header
    And User clicks on "Committed Cost" in "Control" section
    And User gets the sum of Cost amount in Committed cost
    Then Wait "10" Seconds
    And User clicks on Close
   	
    #PFO Validation
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
   #
    Then User validates "Approved CO" value in "PFO Report"    
    #Then User validates "Pending CO" value in "PFO Report"
    Then User validates "CO Budget" value in "PFO Report"
    Then User validates "CO Margin" value in "PFO Report"
    Then User validates "CO Margin %" value in "PFO Report"
    #
    Then User validates "Current CV" value in "PFO Report"
    #
    Then User validates "ECAC Cost" value in "PFO Report"
    #
    Then User validates "ECAC Cost_RevREC" value in "PFO Report"
    #
    Then User validates "CTC" value in "PFO Report"
    Then User validates "CMTD" value in "PFO Report"
    Then User validates "ETC" value in "PFO Report"
    #
    And User clicks on Close
    	
   	#Progress subcontract 	
    And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    Then Wait "5" Seconds
    And User gets Purchase order number
    And User clicks on "New" in Subcontract Payment request
    And User enters Vendor invoice number
    And User clicks Load lines
    And User clicks on Save
    And User clicks on Refresh
    Then User validates line total and invoice amount
    And User clicks on Payment request tab
    And User clicks on "Submit" status
    Then Wait "10" Seconds
    Then User checks the New payment status is "Submitted"
    And User clicks on Payment request tab
    And User clicks on "Approve" status
    Then Wait "10" Seconds
    Then User checks the New payment status is "Approved"
    And User clicks on Payment request tab
    And User clicks on "Commit" status
    And User clicks on Yes
    Then Wait "15" Seconds
    Then User checks the New payment status is "Commit"
    Then User validates the New payment request of Subcontract has been raised
    And User clicks on Close
    And User clicks on Close
    
    #Pre-condiotions for PFO
    #Committed cost data
    And User clicks on "Control" in page header
    And User clicks on "Committed Cost" in "Control" section
    And User checks for any open Committed cost
    And User gets the sum of Cost amount in Committed cost
    And User clicks on Close
    
	  #All transactions data
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks on Refresh
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    And User gets total amount of "Current period end date"
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on "Project 360" in "Inquiries and reports" section
    Then Wait "10" Seconds
    And User clicks on AP tab 
    And User gets Total amount and Total amount to retain
    And User clicks on Close
    
    
    #PFO Validation
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "Total POC %" value in "PFO Report"
    #
    Then User validates "Actual Cost" value in "PFO Report"
    Then User validates "% Complete" value in "PFO Report"
    #
    Then User validates "MTD Cost" value in "PFO Report"
    Then User validates "MTD Margin" value in "PFO Report"
    #
    Then User validates "QTD Cost $" value in "PFO Report"
    Then User validates "QTD Margin $" value in "PFO Report"
    #
    Then User validates "YTD Cost" value in "PFO Report"
    Then User validates "YTD Margin" value in "PFO Report"
    #
    Then User validates "PTD Cost" value in "PFO Report"
    Then User validates "PTD Margin" value in "PFO Report"
    Then User validates "PTD incurred margin" value in "PFO Report"
    #
    Then User validates "CTC" value in "PFO Report"
    Then User validates "CMTD" value in "PFO Report"
    Then User validates "ETC" value in "PFO Report"
    #
    Then User validates "Cash Position" value in "PFO Report"
    Then User validates "Available For Billing" value in "PFO Report"
    #
    Then User validates "Unposted Revenue" value in "PFO Report"
    #
    Then User validates "PTD Earned Revenue" value in "PFO Report"
    Then User validates "PTD Earned Margin" value in "PFO Report"
    Then User validates "PTD Earned Margin %" value in "PFO Report"
    And User clicks on Close
   	 
    #Subcontract payment release
    And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks "List" in Subcontract payment request
    And User gets Vendor invoices
    And User clicks on Expand the navigation pan icon
    And User clicks on "Accounts payable" module
    And User clicks on Expand All
    And User clicks on "Vendor payment journal" sub-module
    And User clicks on New
    And User sets the journal name
    And User click on Save
    And User click on Lines
    And User enters the Vendor Account in Vendor payment journal
    And User click on Save
    And User clicks "Settle transactions" in Vendor payment journal
    And User clicks on "Invoice" field in Vendor payment journal
    And User search the "Invoice"
    And User clicks Apply button    
    And User Select Mark
    And User clicks "OK"
    And User gets the debit value
    And User changes the Off set account type
    And User selects the Off set account
    And User clicks on Save
    And User clicks on "Post"
    And Wait "10" Seconds
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 6"
    And User clicks Apply button 
    
    #Pre-conditions for PFO
    #Progress subcontract invoice amount
    And User clicks on "Project cost management" in page header 
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks on "list" in Subcontract Payment request
    And User gets Invoice Amount in Progress Subcontract
    And User clicks on Close
    And User clicks on Close  

    #PFO Validations    
   And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "Cash Position" value in "PFO Report"
    #
    And User clicks on Close    
   
    #Pre-Condition to get CCO description 
    And User clicks on "Customer change orders" in "Project cost management" section
    And User Clicks Edit
    And User gets Project description in Customer change order screen
    And User clicks on Close
    And User clicks on Close
    
    #Final Invoicing   
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section
    And User gets Construction Contract overview data
    And User clicks on Refresh
    And User clicks on General tab
    And User clicks on Select transactions
    And User clicks on Search
    And User clicks on Select all
    Then Wait "3" Seconds
    And User clicks on OK
    And User calculates Invoice Amount from Journals
    And User clicks on Refresh
    And User gets updated contract data
    And User Clicks Edit
    #Then User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount from sheet "UpdateContracts3"
    Then User updates Percent complete in contract from sheet "UpdateContracts3"
    Then User validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage for FinalInvoice   
		And User clicks on Refresh
    And User gets data from Contract overview
  	And User clicks on Refresh
 	  And User gets Construction Contract overview data
 	  And User clicks on Refresh
    And User gets Construction Contract overview data after Retainage change
    And User clicks on General tab
    And User clicks on Applications/draws
    Then Wait "10" Seconds
    Then User validates data in Contract applications from Contract overview
    Then User validates Retention to date, Retainage amount and Amount due in Contract applications
    Then User validates Invoice amount, Retainage amount and Amount due totals in Contract applications
    Then User validates contract applications data after retainage release
    And User clicks on General tab
    And User clicks on Auto Invoice posting
    And User gets Invoice Number
    And User clicks on Close
    And User clicks on Close
    
    #Pre-Condions for PFO
    #Invoice journals data
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
    
    #PFO Validation
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "ECAC Cost" value in "PFO Report"
    #
    Then User validates "Prog Billing" value in "PFO Report"
    Then User validates "Over Billing" value in "PFO Report"
    Then User validates "Under Billing" value in "PFO Report"
    Then User validates "% Billed" value in "PFO Report"
    #
    Then User validates "AR Balance" value in "PFO Report"
    Then User validates "AR Retention" value in "PFO Report"
    Then User validates "Available For Billing" value in "PFO Report"
    #
    And User clicks on Close
    
    #CustomerPayment
    #precondtion for Customerpayment
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets Invoice Journal ID and Invoice Account
    #customerpayment
    And User clicks on Expand the navigation pan icon
    #And User clicks on "Accounts receivable" module
    #And User clicks on Expand All
    And User clicks on "Customer payment journal" sub-module of "Accounts receivable" module
    And User clicks on New
    And User enters Customer Payment Name
    And User clicks Lines
    And User enters Account number from Invoice Journal, Offset account type and offset account
    And User clicks on Settle transactions
    And User clicks on "Invoice" field
    And User search the "Invoice_CustomerPayment"
    And User clicks Apply button
    And User Select Mark
    And User clicks on OK
    And User gets Credit in CustomerPayment
    And User clicks on Post
    Then User Validates Customer Payments Posted
    
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "All projects" sub-module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 6"
    And User clicks Apply button
    
    #Pre-Condions for PFO
    #Invoice journals data
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
    
    #PFO Validation
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "ECAC Cost" value in "PFO Report"
    #
    Then User validates "Prog Billing" value in "PFO Report"
    Then User validates "Over Billing" value in "PFO Report"
    Then User validates "Under Billing" value in "PFO Report"
    Then User validates "% Billed" value in "PFO Report"
    #
    Then User validates "AR Balance" value in "PFO Report"
    Then User validates "AR Retention" value in "PFO Report"
    Then User validates "Available For Billing" value in "PFO Report"
    #
    Then User checks execution completed successfully for "Feature 6"
    Then User checks for the PFO report mismatch fields