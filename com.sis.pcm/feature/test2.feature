#Author: Arthi Ganeshan
#Keywords Summary : Subcontract Change Order And Validation
@tag
Feature: SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment

  
		@tag1
		Scenario: SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment
	  Given User Login Finance and Operations Application
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
    And User gets the Equipment standard cost data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "All projects" sub-module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 6"
    And User clicks Apply button
  
    
	  #All transactions data
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks on Refresh
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 6"
    And User clicks Apply button
    
    And User gets total amount of "Current period end date"
    And User clicks on Close
    
    #Final Invoicing   
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section

    And User calculates Invoice Amount from Journals
    Then validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage
    And User clicks on Refresh
    And User gets updated contract data
    And User Clicks Edit
    #Then User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount from sheet "UpdateContracts3"
    Then User updates Percent complete in contract from sheet "UpdateContracts3"
    Then validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage after percent complete update   
		