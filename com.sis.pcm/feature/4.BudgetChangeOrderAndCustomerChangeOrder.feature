#Author: Arthi Ganeshan
#Keywords Summary : Create Budget Change Order(Within Current And Next Period) And Validation
@tag
Feature: BudgetChangeOrderAndCustomerChangeOrder

  
		@tag1
		Scenario: Create Budget Change Order(Within Current and Next Period) and Customer Change Order
		Given User Login Finance and Operations Application
		And User checks the Budget categories config data
		And User gets the Default billing basis from SIS parameters
    Then Wait "3" Seconds
    
		And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    Then Wait "5" Seconds
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 4"
    And User clicks Apply button
    
    #PFO precondition TD ECAC
    And User clicks on "Project cost management" in page header 
    And User clicks on "ECAC" in "Project cost management" section 
    And User get ECAC Net Change value
    And User clicks on Close
    
    #Revision1    
    And User clicks on "Project cost management" in page header
    And User clicks on "Project change order" in "Project cost management" section
    And User clicks on New
    And User clicks on Save
    And user clicks on Budgets
    And User clicks on New budget
    And User clicks on Save
    And User Set Committed Period as "Current Period"
    Then User Validates Committed Period as "Current Period"
    And User Get Change Order ID for "BudgetLines_Revision1"
    And User clicks on New Budget lines
    And User enters the budget lines data "BudgetLines_Revision1" and validates the Line amount
    And User clicks on Save
    Then Wait "5" Seconds
		Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Revision1"
		Then User Validate Budget type as "Change order"
    And User clicks on Save
    And User "Submit" project budget
    Then User checks the Budget status is "Submitted"
    And User "Approve" project budget
    Then User checks the Budget status is "Approved"
    And User "Commit" project budget
    Then User checks the Budget status is "Committed"
    And User clicks on Close
    And User clicks on Refresh
    Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Revision1"
    Then User Validates Gross Margin "BudgetLines_Revision1"
    And User clicks on Close
    Then Wait "3" Seconds
    
    #revisions 2
    And User clicks on New
    And User clicks on Save
    And user clicks on Budgets
    And User clicks on New budget
    And User clicks on Save
    And User Set Committed Period as "Next Period"
    Then User Validates Committed Period as "Next Period"
    And User clicks on New Budget lines
    And User enters the budget lines data "BudgetLines_Revision2" and validates the Line amount
    And User clicks on Save
    Then Wait "5" Seconds
    Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Revision2"
    And User Get Change Order ID for "BudgetLines_Revision2"
    Then User Validate Budget type as "Change order"
    And User clicks on Save
    And User "Submit" project budget
    Then User checks the Budget status is "Submitted"
    And User "Approve" project budget
    Then User checks the Budget status is "Approved"
    And User "Commit" project budget
    Then User checks the Budget status is "Committed"
    Then User Validates Project Change Order is Created
    And User clicks on Close
    And User clicks on Refresh
    Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Revision2"
    Then User Validates Gross Margin "BudgetLines_Revision2"
    And User clicks on Refresh    
    And User clicks on Close
    And User clicks on Close
    
    #BudgetVersion
    And User clicks on "Project cost management" in page header
    And User clicks on "Budget versions" in "Project cost management" section
    Then Wait "5" Seconds
    And User gets budget cost amount excluded from RevRec "BudgetLines_Original" and "Current_Period"
    And User clicks on Close
    And User gets budget cost amount excluded from RevRec "BudgetLines_Revision1" and "Current_Period"
    And User clicks on Close
    And User clicks on Close
    
    #JournalsAmount
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 4"
    And User clicks Apply button
    
    And User gets total amount of "Current period end date"
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "Pending CO" value in "PFO Report"
    Then User validates "CO Budget" value in "PFO Report"
    Then User validates "CO Margin" value in "PFO Report"
    Then User validates "CO Margin %" value in "PFO Report"
    #
    Then User validates "Current CV" value in "PFO Report"
    Then User validates "Current CO Budget" value in "PFO Report"
    Then User validates "Current Gross Margin" value in "PFO Report"
    Then User validates "Current GM %" value in "PFO Report"
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
    Then User validates "PTD Margin" value in "PFO Report"
    Then User validates "PTD incurred margin" value in "PFO Report"
    #
    Then User validates "Backlog Revenue" value in "PFO Report"
    Then User validates "Backlog Cost" value in "PFO Report"
    Then User validates "Backlog Margin" value in "PFO Report"
    Then User validates "Backlog Billing" value in "PFO Report"
    #
    Then User validates "MTD Earned Revenue" value in "PFO Report"
    Then User validates "MTD Earned Margin" value in "PFO Report"
    Then User validates "MTD Earned Margin %" value in "PFO Report"
    Then User validates "Unposted Revenue" value in "PFO Report"
    #
    Then User validates "PTD Earned Revenue" value in "PFO Report"
    Then User validates "PTD Earned Margin" value in "PFO Report"
    Then User validates "PTD Earned Margin %" value in "PFO Report"
    And User clicks on Close
    
    #Customer Change Order
    
    #To create Customer change order
    And User clicks on "Project cost management" in page header
    Then Wait "3" Seconds
    And User clicks on "Customer change orders" in "Project cost management" section
    And User clicks on "General" in page header
    And User clicks on New
    And User enters Customer change order no as "010"
    And User enters Change order approved date
    Then User validates Approve date
    And User gets the project description
    Then User validates the Customer change order Status is "Pending"
    And User clicks "Project change orders" fast tab
    And User clicks Select
    And User gets "BudgetLines_Revision1" change order id
    And User clicks on "Change order Id" field
    And User search the "Change order Id"
    And User clicks Apply button
    And User clicks on OK
    And User clicks "Task summary" fast tab
    And User gets budget lines data for "BudgetLines_Revision1"
    Then User validates task summary details for "BudgetLines_Revision1"
    And User clicks "Overview" fast tab
    Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Revision1"
    Then User Validates Gross Margin
    And User changes the Customer change order status to "Approved-customer"
    And User click on Save
    And User clicks Add to Construction Contract
    And User clicks on OK
    And User gets the constuction contract line number
    And User clicks on Close
    And User clicks on Close
    And User clicks on "Construction contract" in "Contracts" section
    Then User validates the newly added line in Construction contract
    And User clicks on Close
    Then User checks execution completed successfully for "Feature 4"
    Then User checks for the PFO report mismatch fields
    