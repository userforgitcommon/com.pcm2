#Author: Monica Dhanasekaran
#Keywords Summary : Execute Revenue Recognition Using PFO
@tag
Feature: JournalCreation,Invoicing,RevenueRecognitionForNextPeriod

  @tag1
  Scenario:  JournalCreation, Invoicing, RevenueRecognition For Next Period
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
    And User gets the Equipment standard cost data
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 5"
    And User clicks Apply button   
    #pre-condition to get Project To Date-> PTD Earned Revenue & PTD earned margin
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    And User get Actual cost, PTD Earned Revenue and PTD Earned Margin
    And User clicks on Close
    
    #Pre-Condition to get CCO description 
    And User clicks on "Customer change orders" in "Project cost management" section
    And User Clicks Edit
    And User gets Project description in Customer change order screen
    And User clicks on Close
    And User clicks on Close
    
    #Journal creation for next period
    And User clicks on "Hour" in "Journals" section
    And User clicks on New
    And User gets Journal Id 
    And User clicks Lines
    Then User enters the Hour journal line data and calculate and validate overhead transaction for "Next Period"
    And User clicks on Close
    And User clicks on "Post"
    And User clicks "OK"
    Then User validates the journal line has been posted
    And User clicks close Journal
    And User clicks on "Item" in "Journals" section
    And User clicks on New
    And User selects the name
    And User gets Journal Id 
    And User clicks Lines
    Then User enters the Item journal line data and calculate and validate overhead transaction for "Next Period"
    And User clicks on Close
    And User clicks on "Post"
    And User clicks "OK"
    Then User validates the journal line has been posted
    And User clicks close Journal
    And User clicks on "Expense" in "Journals" section
    And User clicks on New 
    And User gets Expense Journal Id 
    And User clicks Lines
    Then User enters the Expense journal line data and calculate and validate overhead transaction for "Next Period"
    And User clicks on Close
    And User clicks on Post in Post dropdown list
    Then User validates the Expense journal line has been posted
    And User clicks close Journal
    And User clicks on "Manage" in page header
    And User clicks on "Posted transactions" in "Related information" section
    And User gets the "Total sales amount" from Posted transactions
    And User gets the "Total cost amount" from Posted transactions
    And User clicks on Close in Posted transactions
    
    #Journal amount
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 5"
    And User clicks Apply button
    
    And User gets total amount of "Current period end date"
    And User clicks on Close
    
    #Invoicing the next period
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section
    And User clicks on Edit
    And User enters Retainage percentage as "Retainage%_Next period"
    #And User clicks on Yes
    And User clicks on Refresh
    And User gets updated contract data
    And User calculates Invoice Amount from Journals
    #Then User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount from sheet "UpdateContracts2"
    Then User updates Percent complete in contract from sheet "UpdateContracts2"
    Then validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage after percent complete update     
    And User gets data from Contract overview
    And User clicks on General tab
    And User clicks on Applications/draws
    And User sets data as "Next Period" in Application Date, From Date and To Date
    
    And User clicks on General tab
    And User clicks on Auto Invoice posting
    And User clicks on Close
    And User clicks on Close
    
    #Pre-conditions
    And User clicks on "Customer change orders" in "Project cost management" section
    And User gets Revenue budget in Customer change order
    And User clicks on Close
    
     #BudgetVersion
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
   
    #Journal amount
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 5"
    And User clicks Apply button
    
    And User gets total amount of "Current period end date"
    And User gets total amount of "Next period end date"
    And User clicks on Close
    #Invoice journals_Invoice amount, Cust retained amt
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
    #PFO precondition TD ECAC
    And User clicks on "Project cost management" in page header 
    And User clicks on "ECAC" in "Project cost management" section 
    And User get ECAC Net Change value
    And User clicks on Close 
    #Progress Subcontract Invoice journals
    And User clicks on "Subcontracts" in "Contracts" section
    And User clicks on "list" in Subcontract Payment request
    And User gets Invoice Amount in Progress Subcontract
    And User clicks on Close
    And User clicks on Close  
    
    And User clicks on "Project cost management" in page header
    And User clicks on "Project 360" in "Inquiries and reports" section
    Then Wait "10" Seconds
    And User clicks on AP tab 
    And User gets Total amount and Total amount to retain
    And User clicks on Close
        
    And User clicks on Project cost management page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Next Period"
    And User clicks on OK
    Then Wait "60" Seconds
    
     #
    Then User validates "Approved CO" value in "PFO Report"
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
    Then User validates "MTD Cost" value in "PFO Report"
    Then User validates "MTD Margin" value in "PFO Report"
    #
    Then User validates "Margin Variance $" value in "PFO Report"
    Then User validates "Margin Variance %" value in "PFO Report"
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
    Then User validates "Prog Billing" value in "PFO Report"
    Then User validates "Over Billing" value in "PFO Report"
    Then User validates "Under Billing" value in "PFO Report"
    Then User validates "% Billed" value in "PFO Report"
    #
    Then User validates "AR Balance" value in "PFO Report"
    Then User validates "AR Retention" value in "PFO Report"
    Then User validates "Cash Position" value in "PFO Report"
    Then User validates "Available For Billing" value in "PFO Report"
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
    
    #RevREC    
    And User clicks on Expand the navigation pan icon
    And User clicks on "Refresh project financials data" sub-module of "Project cost management" module
    And User sets the fiscal year as current year and end date as "Next Period" end date
    And User sets the task description
    And User clicks on OK
    And User clicks on Expand the navigation pan icon
    And User clicks on "Batch jobs" sub-module of "System administration" module
    And User clicks on "Task Description" field
    And User filters the "Task Description"
    And User clicks Apply button
    And User gets Job ID
    And User checks the batch job status is "Ended"
    And User clicks on Expand the navigation pan icon
    And User clicks on "PFO batch history" sub-module of "Project cost management" module
    And User sets the End date as "Next Period" end date in PFO batch history
    And User clicks on "Batch Job ID" field
    And User filters the "Batch Job ID"
    And User clicks Apply button
    Then User validates the budget is executed
    And User clicks on Expand the navigation pan icon
    And User clicks on "Revenue recognition" sub-module of "Project cost management" module
    And User sets the fiscal year as current year and end date as "Next Period" end date
    And User clicks on OK
    #And Wait "15" Seconds
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 5"
    And User clicks Apply button
    And User gets the line values and selects the record
    And User clicks on "Post"
    #And User checks posting date is "current period" end date
    And User clicks on OK
    And User validates the Revenue recognition process job is added to the batch queue
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 5"
    And User clicks Apply button
    And User selects the "Project ID" Link
    And Wait "30" Seconds
    And User selects the Project Group
    And User clicks Estimate fast tab
    And User gets sales value data
    And User clicks on Close
    And User clicks on "Manage" in page header
    And User clicks on "Posted transactions" in "Related information" section
    And User clicks on "Category Id" field
    And User filters the "Category Id"
    And User clicks Apply button
    And User clicks on "Date" field
    And User filters the "Next Period"
    And User clicks Apply button
    And User checks the Category ID and Validates Total sales amount and checks Transaction type "Fee"

    And User clicks on Close
    And User clicks on Project cost management page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Next Period"
    And User clicks on OK
    Then Wait "60" Seconds
     #
    Then User validates "MTD Revenue" value in "PFO Report"
    Then User validates "MTD Margin" value in "PFO Report"
    #
    Then User validates "QTD Rev $" value in "PFO Report"
    Then User validates "QTD Margin $" value in "PFO Report"
    #
    Then User validates "YTD Revenue" value in "PFO Report"
    Then User validates "YTD Margin" value in "PFO Report"
    #
    Then User validates "PTD Revenue" value in "PFO Report"
    Then User validates "PTD Margin" value in "PFO Report"
    Then User validates "PTD incurred margin" value in "PFO Report"
    #
    Then User validates "Over Billing" value in "PFO Report"
    Then User validates "Under Billing" value in "PFO Report"
    #
    Then User validates "Backlog Revenue" value in "PFO Report"
    Then User validates "Backlog Cost" value in "PFO Report"
    Then User validates "Backlog Margin" value in "PFO Report"
    Then User validates "Backlog Billing" value in "PFO Report"
    Then User validates "Unposted Revenue" value in "PFO Report"
    Then User checks execution completed successfully for "Feature 5"
    Then User checks for the PFO report mismatch fields