#Author: Arthi
#Keywords Summary : ProjectCreationAndAdditionofBudget,cc,VendorandSubcontractCompliance
@tag
Feature: ProjectCreationAndAdditionofBudget,cc,VendorandSubcontractCompliance

  @tag1
  Scenario: ProjectCreationAndAdditionofBudget,CC,VendorandSubcontractCompliance
    Given User Login Finance and Operations Application
    Then Wait "100" Seconds
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
   
   #Map task codes to CC
    And User clicks on Map task codes
    And User clicks on Show non-billable tasks
    And User selects task codes
    And User clicks on Save
    And User clicks on Close
    
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Compliance type" sub-module of "Project cost management" module
    And User clicks on Edit
    And User gets "Test_Sub" data and update Complaince status
    And User gets "Test_Vendor" data and update Complaince status
    And User gets "Test_Vendor2" data and update Complaince status
    And User clicks on Save
    
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Project cost management" module
    And User clicks on Expand All
    And User clicks on "All projects" sub-module
    And User clicks on "ProjectID" field
    And User search the ProjectID
    And User clicks Apply button
    
		#precondition Vendor agreements
		And User clicks on "Project" in page header
		And User clicks on Edit
		Then Wait "5" Seconds
		And User clicks "Vendor agreements" fast tab
		And User clicks on Add line
		And user Enters Vendor agreements data
		And User clicks on Save
		And User clicks on Close
    #Subcontract Compliance######
    And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks on New under Subcontract
    Then User validates the Subcontract status is "Draft"
    And User selects the Speciality
    And User selects the Vendor account for "Subcontract_Compliance"
    And User click on Yes
    And User clicks on Save
    And User gets Subcontract Number
    #Vendor and Subcontract compliance
    And User clicks "Vendor compliance" fast tab
    And User clicks Load lines
    Then User Validates Vendor Compliance lines
    And User deletes "Expired date" Vendor line
    And User clicks "Subcontract compliance" fast tab
    And User clicks on New Subcontract Compliance
    And User enters "SubcontractCompliance_Valid" data
    And User click on Lines
    And User enters the Subcontract "Subcontract_Compliance" data and validates the Net amount
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
    #Subcontract Compliance Add1########
    And User clicks on New under Subcontract
    Then User validates the Subcontract status is "Draft"
    And User selects the Speciality
    And User selects the Vendor account for "Subcontract_Compliance_add1"
    And User click on Yes
    And User clicks on Save
    And User gets Subcontract Number
    #Vendor and Subcontract compliance
    And User clicks "Vendor compliance" fast tab
    And User clicks Load lines
    Then User Validates Vendor Compliance lines
    And User deletes "Valid date" Vendor line
    And User clicks "Subcontract compliance" fast tab
    And User clicks on New Subcontract Compliance
    And User enters "SubcontractCompliance_Valid" data
    And User click on Lines
    And User enters the Subcontract "Subcontract_Compliance_add1" data and validates the Net amount
    And User clicks on Save
    Then User validates Subcontract amount and Subcontract total
    And User clicks on Close
    #Subcontract Compliance Add2########
    And User clicks on New under Subcontract
    Then User validates the Subcontract status is "Draft"
    And User selects the Speciality
  	And User selects the Vendor account for "Subcontract_Compliance_add2"
    And User click on Yes
    And User clicks on Save
    And User gets Subcontract Number
    #Vendor and Subcontract compliance
    And User clicks "Vendor compliance" fast tab
    And User clicks Load lines
    Then User Validates Vendor Compliance lines
    #And User deletes "Expired date" Vendor line
    And User clicks "Subcontract compliance" fast tab
    And User clicks on New Subcontract Compliance
    And User enters "SubcontractCompliance_Expired" data
    And User click on Lines
    And User enters the Subcontract "Subcontract_Compliance_add2" data and validates the Net amount
    And User clicks on Save
    Then User validates Subcontract amount and Subcontract total
    And User clicks on Close
    #notification
    And User Clicks on Notification Icon
    And User Clicks on Clear all
    And User Clicks on Notification Icon
    Then Wait "5" Seconds
    #Verify subcontract compliance Batch job
    And User clicks on Expand the navigation pan icon
		And User clicks on "Verify subcontract compliance" sub-module of "Project cost management" module
		And User enters CutOff date
		And User clicks "Records to include" fast tab
		Then User Clicks on Filter
		And User Enter Project ID for Verify subcontract compliance
		And User clicks on OK in Verify subcontract compliance Filter
		Then Wait "10" Seconds
		And User clicks on OK in Verify subcontract compliance
		#notification
		And User Clicks on Notification Icon
		And User Gets Notification messages and Validate
		And User Clicks on Notification Icon
		Then Wait "5" Seconds
		And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID
    And User clicks Apply button
		#Compliant Status
		And User clicks on "Project cost management" in page header
    And User clicks on "Subcontracts" in "Contracts" section
    And User selects "Subcontract_Compliance" in Subcontract
    And User clicks on Edit
    And User click on Header
    And User Validates Vendor Compliance Status after Verify Subcontract Compliance
    And User Validates Subcontract Compliance Status after Verify Subcontract Compliance
    And User clicks on Close
    #add1
    And User selects "Subcontract_Compliance_add1" in Subcontract
    And User clicks on Edit
    And User click on Header
   And User Validates Vendor Compliance Status after Verify Subcontract Compliance
    And User Validates Subcontract Compliance Status after Verify Subcontract Compliance
    And User click on Lines
    And User "Submit" Subcontract
    And User click on Yes
    Then Wait "10" Seconds
    Then User validates the Subcontract status is "Submitted"
    And User "Approve" Subcontract
    Then User validates the Subcontract status is "Approved"
    And User "Commit" Subcontract
    Then User validates the Subcontract status is "Commit"
    Then User validates Purchase order has been created
    And User clicks on Close
    #add2
    And User selects "Subcontract_Compliance_add2" in Subcontract
    And User clicks on Edit
    And User click on Header
    And User Validates Vendor Compliance Status after Verify Subcontract Compliance
    And User Validates Subcontract Compliance Status after Verify Subcontract Compliance
    And User click on Lines
    And User "Submit" Subcontract
    #And User click on Yes
    Then Wait "5" Seconds
    Then User validates the Subcontract status is "Submitted"
    And User "Approve" Subcontract
    Then User validates the Subcontract status is "Approved"
    And User "Commit" Subcontract
    Then User validates the Subcontract status is "Commit"
    Then User validates Purchase order has been created
    And User clicks on Close
    And User clicks on Close
    #committed cost
    Then Wait "5" Seconds
    And User clicks on "Control" in page header
    And User Clicks on "Committed cost" in Control Section
    Then User Validate Committed Cost Table "Subcontract_Compliance"
    And User clicks on Refresh
    
    Then User Validate Committed Cost Table "Subcontract_Compliance_add1"
    And User clicks on Refresh
    Then User Validate Committed Cost Table "Subcontract_Compliance_add2"
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