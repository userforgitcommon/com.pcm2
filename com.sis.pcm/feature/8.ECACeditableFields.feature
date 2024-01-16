#Author: mdhanasekaran@sisn.com
#Keywords Summary : ECAC Editable Fields
@tag
Feature: ECAC Editable Fields.feature

  @tag1
  Scenario: ECAC Editable Fields
    Given User Login Finance and Operations Application
    And User checks the Budget categories config data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    
    #Project ready for ECAC
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 8"
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
    And User search the ProjectID for "Feature 8"
    And User clicks Apply button
    And User checks "Project stage" in Project ready for ECAC 
    And User checks "Last ECAC Date" in Project ready for ECAC     
    And User checks "Last activity date" in Project ready for ECAC 
    
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 8"
    And User clicks Apply button
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 8"
    And User clicks Apply button
    
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
    And User checks the "Task code" field is editable
    And User checks the "Description" field is editable
    And User checks the "Last activity date" field is editable
    And User checks the "Budget category" field is editable
    And User checks the "Current budget" field is editable
    And User checks the "Current qty" field is editable
    And User checks the "Current unit price" field is editable
    And User checks the "Current amount" field is editable
    And User checks the "Actual qty" field is editable
    And User checks the "Actual unit price" field is editable
    And User checks the "Actual amount" field is editable
    And User checks the "Committed cost" field is editable
    And User checks the "Qty to complete" field is editable
    And User checks the "Revised qty" field is editable
    And User checks the "Revised rate" field is editable
    And User checks the "ECAC revised amount" field is editable
    And User checks the "ETC" field is editable
    And User checks the "ECAC amount" field is editable
    And User checks the "ECAC net change" field is editable
    And User checks the "Variance" field is editable
    And User checks the "CTC amount" field is editable
    And User checks the "Unspread amount" field is editable
    And User checks the "Workflow status" field is editable