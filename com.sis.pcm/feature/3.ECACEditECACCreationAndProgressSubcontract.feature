#Author: mdhanasekaran@sisn.com
#Keywords Summary : ECAC Editable Fields, ECAC Creation and Progress Subcontract
@tag
Feature: ECAC Editable Fields, ECAC Creation and Progress Subcontract.feature

  @tag1
  Scenario: ECAC Editable Fields, ECAC Creation and Progress Subcontract
    Given User Login Finance and Operations Application
    And User checks the Budget categories config data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    
    #Project ready for ECAC
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 3"
    And User clicks Apply button
    And User clicks on "Project cost management" in page header
    And User clicks on "ECAC" in "Project cost management" section
    And User checks whether any ECAC committed 
    And User clicks on Close 
        
    And User clicks on "Project" in page header 
    And User Clicks Edit
    Then Wait "10" Seconds
    And User gets "Project stage" from project
    And User gets "Last ECAC Date" from project
    And User gets "Last activity date" from project
    
    And User clicks on Expand the navigation pan icon
    And User clicks on "Projects ready for ECAC" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 3"
    And User clicks Apply button
    And User checks "Project stage" in Project ready for ECAC 
    And User checks "Last ECAC Date" in Project ready for ECAC     
    And User checks "Last activity date" in Project ready for ECAC 
    
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 3"
    And User clicks Apply button
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    And User gets total amount of "Current period end date"
    And User clicks on Close
    
    #subcontract
    And User clicks on "Subcontracts" in "Contracts" section
    And User Clicks Edit
    Then Wait "5" Seconds
    And User gets Subcontract Total Amount
    And User clicks on Close
    And User clicks on Close
    #BudgetVersion
    And User clicks on "Project cost management" in page header
    And User clicks on "Budget versions" in "Project cost management" section
    Then Wait "10" Seconds
    And User gets budget cost amount excluded from RevRec "BudgetLines_Original" and "Current_Period"
    And User clicks on Close
    And User clicks on Close
    #ecac
    And User clicks on "Project cost management" in page header
    And User clicks on "ECAC" in "Project cost management" section
    #And User clicks on ECAC Table
    And User Click new ECAC
    And User Enter Description As ProjectID
    And User sets end date as current period end date
    And User Click OK
    And User Clicks Edit
    
    #ECAC Editable fileds
    #And User checks the "Task code" field is editable
    #And User checks the "Description" field is editable
    #And User checks the "Last activity date" field is editable
    #And User checks the "Budget category" field is editable
    #And User checks the "Current budget" field is editable
    #And User checks the "Current qty" field is editable
    #And User checks the "Current unit price" field is editable
    #And User checks the "Current amount" field is editable
    #And User checks the "Actual qty" field is editable
    #And User checks the "Actual unit price" field is editable
    #And User checks the "Actual amount" field is editable
    #And User checks the "Committed cost" field is editable
    #And User checks the "Qty to complete" field is editable
    #And User checks the "Revised qty" field is editable
    #And User checks the "Revised rate" field is editable
    #And User checks the "ECAC revised amount" field is editable
    #And User checks the "ETC" field is editable
    #And User checks the "ECAC amount" field is editable
    #And User checks the "ECAC net change" field is editable
    #And User checks the "Variance" field is editable
    #And User checks the "CTC amount" field is editable
    #And User checks the "Unspread amount" field is editable
    #And User checks the "Workflow status" field is editable
    
    #ECAC
	  Then User validate Actual Amount, Committed Cost, ECAC Amount, ETC and CTC Amount
    Then User Change Quantity and Amount Based Category, Validate Changed Fields
    And User clicks on ECAC Table
    And User Clicks "Submit" In ECAC Table
    Then User Validates Budget Status "Submitted"
    And User clicks on ECAC Table
    And User Clicks "Approve" In ECAC Table
    Then User Validates Budget Status "Approved"
    And User clicks on ECAC Table
    And User Clicks "Commit" In ECAC Table
    Then User Validates Budget Status "Committed"
    And User clicks on Close
    And User clicks on Close
    And User clicks on "Project cost management" in page header 
    And User clicks on "ECAC" in "Project cost management" section 
    And User get ECAC Net Change value
    And User clicks on Close

# Project ready for ECAC
    And User clicks on "Project" in page header 
    And User Clicks Edit
    Then Wait "10" Seconds
    And User gets "Project stage" from project
    And User gets "Last ECAC Date" from project
    And User gets "Last activity date" from project
    And User clicks on Expand the navigation pan icon
    And User clicks on "Projects ready for ECAC" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 3"
    And User clicks Apply button
    And User checks the project is available in Project ready for ECAC screen
    And User clicks on Close
   
    #Subcontract
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 3"
    And User clicks Apply button
    And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    Then Wait "5" Seconds
    And User gets Purchase order number
    And User clicks on New in Subcontract Payment request
    And User enters Vendor invoice number
    And User clicks Load lines
    Then Wait "10" Seconds
    And User clicks on Save
    And User clicks on Refresh
    Then User validates line total and invoice amount
    And User clicks on Payment request tab
    And User clicks on "Submit" status
    Then User checks the New payment status is "Submitted"
    And User clicks on Payment request tab
    And User clicks on "Approve" status
    Then User checks the New payment status is "Approved"
    And User clicks on Payment request tab
    And User clicks on "Commit" status
    And User clicks on Yes
    Then Wait "30" Seconds
    Then User checks the New payment status is "Commit"
    Then User validates the New payment request of Subcontract has been raised
    And User clicks on Close
    And User clicks on Close
    And User clicks on "Control" in page header
    And User clicks on "Committed Cost" in "Control" section
    And User checks for any open Committed cost
    And User gets the sum of Cost amount in Committed cost
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
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
    
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "ECAC Cost" value in "PFO Report"
    Then User validates "Total POC %" value in "PFO Report"	
    Then User validates "ECAC Gross Margin" value in "PFO Report"
    Then User validates "ECAC GM %" value in "PFO Report"
    #
    Then User validates "ECAC Cost_RevREC" value in "PFO Report"
    Then User validates "Actual Cost" value in "PFO Report"
    Then User validates "% Complete" value in "PFO Report"
    #
    Then User validates "Margin Variance $" value in "PFO Report"
    Then User validates "Margin Variance %" value in "PFO Report"
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
    Then User validates "Backlog Revenue" value in "PFO Report"
    Then User validates "Backlog Cost" value in "PFO Report"
    Then User validates "Backlog Margin" value in "PFO Report"
    Then User validates "Backlog Billing" value in "PFO Report"
    #
    Then User validates "Unposted Revenue" value in "PFO Report"
    #
    Then User validates "PTD Earned Revenue" value in "PFO Report"
    Then User validates "PTD Earned Margin" value in "PFO Report"
    Then User validates "PTD Earned Margin %" value in "PFO Report" 
    Then User checks execution completed successfully for "Feature 3"
    Then User checks for the PFO report mismatch fields
    