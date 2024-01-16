#Author: Monica Dhanasekaran
#Keywords Summary : Release and Cancel Retainage
@tag
Feature: JournalCreation,Invoicing,RevenueRecognition,RetentionRelease,CancelInvoiceAndRetainage

  @tag1
  Scenario: JournalCreation, Invoicing, RevenueRecognition, RetentionRelease, Cancel Invoice and Retainage
    Given User Login Finance and Operations Application
    Then Wait "100" Seconds
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
    Then Wait "30" Seconds
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 2"
    And User clicks Apply button
    And User clicks on "Hour" in "Journals" section
    And User clicks on New
    And User gets Journal Id
    And User clicks Lines
    Then User enters the Hour journal line data and calculate and validate overhead transaction for "Current Period"
    And User clicks on Close
    And User clicks on "Post"
    And Wait "10" Seconds
    And User clicks "OK"
    And Wait "30" Seconds
    Then User validates the journal line has been posted
    And User clicks close Journal
    And User clicks on "Item" in "Journals" section
    And User clicks on New
    And User selects the name
    And User gets Journal Id
    And User clicks Lines
    Then User enters the Item journal line data and calculate and validate overhead transaction for "Current Period"
    And User clicks on Close
    And User clicks on "Post"
    And Wait "10" Seconds
    And User clicks "OK"
    And Wait "30" Seconds
    Then User validates the journal line has been posted
    And User clicks close Journal
    And User clicks on "Expense" in "Journals" section
    And User clicks on New
    And User gets Expense Journal Id
    And User clicks Lines
    Then User enters the Expense journal line data and calculate and validate overhead transaction for "Current Period"
    And User clicks on Close
    And User clicks on Post in Post dropdown list
    And Wait "30" Seconds
    Then User validates the Expense journal line has been posted
    And User clicks close Journal
    
    #Journal amount
    And User clicks on "Project cost management" in page header
    And User clicks on "All transactions" in "Project cost management" section
    And User clicks Show lines
    And User selects "Only cost transactions"
    And User clicks Ok in All transactions
    
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 2"
    And User clicks Apply button
    
    And User gets total amount of "Current period end date"
    And User gets total amount of "Next period end date"
    And User clicks on Close
    
    
    #Invoicing
    #And User clicks on Expand the navigation pan icon
    #And User clicks on "All projects" sub-module of "Project cost management" module
    #And User clicks on "ProjectID" field
    #And User search the "ProjectID"
    #And User clicks Apply button
    And User clicks on "Manage" in page header
    And User clicks on "Posted transactions" in "Related information" section
    And User gets the "Total sales amount" from Posted transactions
    And User gets the "Total cost amount" from Posted transactions
    And User clicks on Close in Posted transactions
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section
    And User clicks on General tab
    And User clicks on Select transactions
    And User clicks on Search
    And User clicks on Select all
    Then User validates "Total sales price" in contracts
    Then User validates "Total cost" in contracts
    And User clicks on OK
    Then User validates Costs in contract overview
    And User calculates Invoice Amount from Journals
    Then validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage
    And User clicks on Edit
    Then User updates Percent complete in contract from sheet "UpdateContracts1"
    Then validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage    
    And User gets data from Contract overview
    And User gets Construction Contract overview data
    And User clicks on General tab
    And User clicks on Applications/draws
    Then User validates data in Contract applications from Contract overview
    Then User validates Retention to date, Retainage amount and Amount due in Contract applications
    Then User validates Invoice amount, Retainage amount and Amount due totals in Contract applications
    And User clicks on General tab
    And User clicks on Auto Invoice posting
    And User gets Invoice Number
    And User clicks on Close
    And User clicks on Close
    
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
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
    And User clicks on Close
    #Revenue recognition
    #And User clicks on Expand the navigation pan icon
    #And User clicks on Modules
    #And User clicks on "All projects" sub-module of "Project cost management" module
    #And User clicks on "ProjectID" field
    #And User search the "ProjectID"
    #And User clicks Apply button
    And User clicks on Expand the navigation pan icon
    And User clicks on Modules
    And User clicks on "Refresh project financials data" sub-module of "Project cost management" module
    And User sets the fiscal year as current year and end date as "Current Period" end date
    And User sets the task description
    And User clicks on OK
    And User clicks on Expand the navigation pan icon
    And User clicks on Expand All
    And User clicks on "Batch jobs" sub-module of "System administration" module
    And Wait "10" Seconds
    And User clicks on "Task Description" field
    And Wait "5" Seconds
    And User filters the "Task Description"
    And Wait "5" Seconds
    And User clicks Apply button
    And Wait "5" Seconds
    And User gets Job ID
    And User checks the batch job status is "Ended"
    And User clicks on Expand the navigation pan icon
    And User clicks on "PFO batch history" sub-module of "Project cost management" module
    And User clicks on "Batch Job ID" field
    And User filters the "Batch Job ID"
    And User clicks Apply button
    Then User validates the budget is executed
    And User clicks on Expand the navigation pan icon
    And User clicks on "Revenue recognition" sub-module of "Project cost management" module
    And User sets the fiscal year as current year and end date as "Current Period" end date
    And User clicks on OK
    #And Wait "15" Seconds
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 2"
    And User clicks Apply button
    And User gets the line values and selects the record
    And User clicks on "Post"
    And Wait "30" Seconds
    And User checks posting date is current period end date
    And Wait "30" Seconds
    And User clicks on OK
    And User validates the Revenue recognition process job is added to the batch queue
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And Wait "30" Seconds
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 2"
    And User clicks Apply button
    And User selects the "Project ID" Link
    And Wait "60" Seconds
    And User selects the Project Group
    And Wait "30" Seconds
    And User clicks Estimate fast tab
    And User gets sales value data
    And User clicks on Close
    And User clicks on "Manage" in page header
    And User clicks on "Posted transactions" in "Related information" section
    And User clicks on "Category Id" field
    And User filters the "Category Id"
    And User clicks Apply button
    And User clicks on "Date" field
    And User filters the "Current Period"
    And User clicks Apply button
    And User checks the Category ID and Validates Total sales amount and checks Transaction type "Fee"
    And User clicks on Close
    
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
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
    #Release retainage
    And User clicks on Expand the navigation pan icon
    And User clicks on "All projects" sub-module of "Project cost management" module
    And Wait "30" Seconds
    And User clicks on "ProjectID" field
    And User search the ProjectID for "Feature 2"
    And User clicks Apply button
    And User clicks on "Project cost management" in page header
    And User clicks on "Construction contract" in "Contracts" section
    And User clicks on Edit
    And User enters Retainage percentage as "Retainage%_Retainage Change"
    And User clicks on Refresh
    Then User validates construction contract data after Retainage change
    And User clicks on Refresh
    And User gets Construction Contract overview data after Retainage change
    And User clicks on General tab
    And User clicks on Retainage release application
    Then User clicks on Auto release retention amount and validates the retention invoice populated
    Then User validates Invoice amount, Retainage amount and Amount due totals in Contract applications from retainage release data
    Then User validates contract applications data after retainage release
    And User clicks on Close
    And User clicks on Close
    
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
    
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
    #
    Then User validates "AR Balance" value in "PFO Report"
    Then User validates "AR Retention" value in "PFO Report"
    Then User validates "Cash Position" value in "PFO Report"
    Then User validates "Available For Billing" value in "PFO Report"
    And User clicks on Close
    #Cancellation of invoice and retainage
    And User clicks on "Construction contract" in "Contracts" section
    And User clicks on General tab
    And User clicks on Applications/draws
    Then User clicks on Cancel release retention amount and validates the retention reversal populated
    Then User clicks on Cancel invoice amount and validates the invoice populated
    Then User validates Billing status is "Cancelled" in contract applications of Retention reversal line
    Then User validates Invoice amount in contract applications of Retention reversal line
    Then User validates Retainage amount in contract applications of Retention reversal line
    Then User validates Amount due in contract applications of Retention reversal line
    Then User validates Billing status is "Cancelled" in contract applications of Invoice reversal line
    Then User validates Invoice amount in contract applications of Invoice reversal line
    Then User validates Retainage amount in contract applications of Invoice reversal line
    Then User validates Amount due in contract applications of Invoice reversal line
    And User clicks on Close
    And User clicks on Refresh
    Then User validates contract overview data after retainage and invoice cancel
    And User clicks on Close
    
    And User clicks on "Manage" in page header
    And User clicks on "Invoice journals" in "Bill" section
    And User gets total Invoice amount, total Invoice line amount and Customer retained amount from invoice journals
    And User clicks on Close
 
    And User clicks on "Project cost management" in page header
    And User clicks on Project financial overview detail
    And User sets PFO report date as "Current Period"
    And User clicks on OK
    Then Wait "60" Seconds
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
    Then User checks execution completed successfully for "Feature 2"
    Then User checks for the PFO report mismatch fields
    #
    #Loss making project
    And User gets "Current CV" from PFO Report
    And User gets "ECAC Cost_ECAC" from PFO Report
    And User clicks on Close
    And User clicks on "Project" in page header 
    And User Clicks Edit
    Then Wait "10" Seconds
    Then User checks the project is a "Loss making project"