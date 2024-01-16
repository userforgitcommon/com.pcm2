#Author: mdhanasekaran@sisn.com
#Keywords Summary : PFO Validation
@tag
Feature: ProjectCreationAndAdditionofBudget,ContractAndCCEditableAndNon-EditableFields

  @tag1
  Scenario: Project Creation and Addition of Budget,Contract, CC Editable and Non-Editable Fields
    Given User Login Finance and Operations Application
    Then Wait "120" Seconds
    And User checks the Budget categories config data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project Management and Accounting" module
    And User clicks on Expand All
    And User clicks on "Project management and accounting parameters" sub-module
    And User checks Purchase order and Vendor invoice config data
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "SIS system parameters" sub-module
    And User clicks on "Project cost management" in SIS Parameters
    And User sets "Allow override construction contract" as "Yes"
    And User clicks on Expand the navigation pan icon
    
    And User clicks on Modules
    And User clicks on "All projects" sub-module
    
    #Project creation
    And User clicks on New
    And User selects Project type as "Fixed-price"
    And User enters Project ID
    And User enters Project name
    And User enters Project group
    And User clicks on New Project contract
    And User enters Project contract name
    And User selects Funding type
    And User selects Funding source
    And User clicks on OK
    And User gets Project contract ID
    And User selects Project manager
    And User clicks on Create project
    And User clicks on "Project" in page header
    Then Wait "60" Seconds
    Then User checks the Project stage is "Created"
    And User clicks on the Project stage menu and move to In Process stage
    Then User checks the Project stage is "In process"
    And User clicks on "Project cost management" in page header
    And User clicks on "New budget" in "Project cost management" section
    And User clicks on Budget lines
    And User clicks on New Budget lines
    And User enters the budget lines data "BudgetLines_Original" and validates the Line amount
    And User clicks on Save
    Then User checks the Budget status is "Draft"
    And User clicks on Totals
    Then User validates Revenue Budget, Cost Budget and Profit margin "BudgetLines_Original"
    And User "Submit" project budget
    Then User checks the Budget status is "Submitted"
    And User "Approve" project budget
    Then User checks the Budget status is "Approved"
    And User "Commit" project budget
    Then User checks the Budget status is "Committed"
    And User clicks on Close
    
    #BudgetVersion
    And User clicks on "Project cost management" in page header
    And User clicks on "Budget versions" in "Project cost management" section
    Then Wait "10" Seconds
    And User gets budget cost amount excluded from RevRec "BudgetLines_Original" and "Current_Period"
    And User clicks on Close
    And User clicks on Close
    
    #CC Creation
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section
    And User clicks on Yes
    And User clicks on Edit
    And User selects the Contract status as "Approved"
    And User enters Retainage percentage as "Retainage%_Construction contract"
    And User clicks on Overview
    And User clicks on New under Construction contract
    And User enters Construction contract data
    And User clicks on Save
    And User clicks on Refresh
    Then User validates Revenue budget and Scheduled value
    
     # CC Fields are editable
    #And User checks the "Line num" are editable
    #And User checks the "Description" are editable
    #And User checks the "Billing basis" are editable
    #And User checks the "SV quantity" are not editable
    #And User checks the "Unit" are editable
    #And User checks the "Unit price" are not editable
    #And User checks the "Scheduled value" are editable
    #And User checks the "Stored materials" are editable
    #And User checks the "Qty delivered" are not editable
    #And User checks the "Percent complete" are editable
    #And User checks the "Work in place" are editable
    #And User checks the "Amount remaining" are not editable
    #And User checks the "Invoice amount" are not editable
    #And User checks the "Retainage %" are editable
    #And User checks the "Retainage amount" are not editable
    #And User checks the "Prev retainage" are editable
    #And User checks the "Total retainage" are not editable
    #And User checks the "Prev stored materials" are editable
    #And User checks the "Prev work in place" are editable
    #And User checks the "Prev percentage" are editable
    #And User checks the "Previous qty" are not editable
    #And User checks the "Remaining qty" are not editable
    #And User checks the "Costs" are not editable
    #
    #CC fields are not editable
    #And User clicks on Expand the navigation pan icon
    #And User clicks on "SIS system parameters" sub-module
    #And User clicks on "Project cost management" in SIS Parameters
    #And User sets "Allow override construction contract" as "No"
    #And User clicks on Expand the navigation pan icon
    #And User clicks on "All projects" sub-module
    #And User clicks on "ProjectID" field
    #And Wait "10" Seconds
    #And User search the ProjectID
    #And User clicks Apply button
    #And User clicks on "Project cost management" in page header
    #And User clicks on "Construction contract" in "Contracts" section
    #And User clicks on Edit
    #And User checks the "Line num" are editable
    #And User checks the "Description" are editable
    #And User checks the "Billing basis" are editable
    #And User checks the "SV quantity" are not editable
    #And User checks the "Unit" are editable
    #And User checks the "Unit price" are not editable
    #And User checks the "Scheduled value" are editable
    #And User checks the "Stored materials" are editable
    #And User checks the "Qty delivered" are not editable
    #And User checks the "Percent complete" are editable
    #And User checks the "Work in place" are editable
    #And User checks the "Amount remaining" are not editable
    #And User checks the "Invoice amount" are not editable
    #And User checks the "Retainage %" are editable
    #And User checks the "Retainage amount" are not editable
    #And User checks the "Prev retainage" are not editable
    #And User checks the "Total retainage" are not editable
    #And User checks the "Prev stored materials" are not editable
    #And User checks the "Prev work in place" are not editable
    #And User checks the "Prev percentage" are not editable
    #And User checks the "Previous qty" are not editable
    #And User checks the "Remaining qty" are not editable
    #And User checks the "Costs" are not editable
        #And User clicks on Close
    #
   #
   #Map task codes to CC
    #And User clicks on "Construction contract" in "Contracts" section
    #And User clicks on Edit
    And User clicks on Map task codes
    And User clicks on Show non-billable tasks
    And User selects task codes
    And User clicks on Save
    And User clicks on Close
    
    #Subcontract creation
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks on New under Subcontract
    Then User validates the Subcontract status is "Draft"
    And User selects the Speciality
    And User selects the Vendor account
    And User click on Yes
    And User clicks on Save
    And User click on Lines
    And User enters the Subcontract data and validates the Net amount
    And User clicks on Save
    Then User validates Subcontract amount and Subcontract total
    And User "Submit" Subcontract
    Then User validates the Subcontract status is "Submitted"
    And User "Approve" Subcontract
    Then User validates the Subcontract status is "Approved"
    And User "Commit" Subcontract
    Then User validates the Subcontract status is "Commit"
    Then User validates Purchase order has been created
    And User clicks on Close
    And User clicks on Close
   
    And User clicks on "Control" in page header
    And User clicks on "Committed Cost" in "Control" section
    And User gets the sum of Cost amount in Committed cost
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "Orig Contract Value" value in "PFO Report"
    Then User validates "Orig Cost Budget" value in "PFO Report"
    Then User validates "Orig GM" value in "PFO Report"
    Then User validates "Orig GM %" value in "PFO Report"
    #
    Then User validates "Current CV" value in "PFO Report"
    Then User validates "Current CO Budget" value in "PFO Report"
    Then User validates "Current Gross Margin" value in "PFO Report"
    Then User validates "Current GM %" value in "PFO Report"
    #
    Then User validates "ECAC Cost" value in "PFO Report"
    Then User validates "ECAC Gross Margin" value in "PFO Report"
    Then User validates "ECAC GM %" value in "PFO Report"
    #
    Then User validates "ECAC Cost_RevREC" value in "PFO Report"
    #
    Then User validates "CTC" value in "PFO Report"
    Then User validates "CMTD" value in "PFO Report"
    Then User validates "ETC" value in "PFO Report"
    #
    Then User validates "Backlog Revenue" value in "PFO Report"
    Then User validates "Backlog Cost" value in "PFO Report"
    Then User validates "Backlog Margin" value in "PFO Report"
    Then User validates "Backlog Billing" value in "PFO Report"
    Then User checks execution completed successfully for "Feature 1"
    Then User checks for the PFO report mismatch fields