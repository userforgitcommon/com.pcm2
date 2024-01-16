$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./feature/test2.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Arthi Ganeshan"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Subcontract Change Order And Validation"
    }
  ],
  "line": 4,
  "name": "SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment",
  "description": "",
  "id": "subcontractchangeorder,progresssubcontract,subcontractpaymentrelease,finalinvoicing,customerpayment",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 4394170200,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "SubcontractChangeOrder,ProgressSubcontract,SubcontractPaymentRelease,FinalInvoicing,CustomerPayment",
  "description": "",
  "id": "subcontractchangeorder,progresssubcontract,subcontractpaymentrelease,finalinvoicing,customerpayment;subcontractchangeorder,progresssubcontract,subcontractpaymentrelease,finalinvoicing,customerpayment",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User Login Finance and Operations Application",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "User checks the Budget categories config data",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User clicks on Expand the navigation pan icon",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User clicks on Modules",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "User clicks on \"Project cost management\" module",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User clicks on Expand All",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User clicks on \"Project allocation rules\" sub-module",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User selects the Rule ID \"DEMO2\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User gets Project allocation rules data",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User clicks on Expand the navigation pan icon",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User clicks on \"Released products\" sub-module of \"Product information management\" module",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User gets Extended Attributes config data, Inventory config data and Field Service config data",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User clicks on Expand the navigation pan icon",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "User clicks on \"Equipment standard costs\" sub-module of \"Equipment usage\" module",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "User gets the Equipment standard cost data",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "User clicks on Expand the navigation pan icon",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "User clicks on Modules",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "User clicks on \"Project cost management\" module",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User clicks on Expand All",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User clicks on \"All projects\" sub-module",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User clicks on \"ProjectID\" field",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "User search the ProjectID for \"Feature 6\"",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "User clicks Apply button",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 34,
      "value": "#All transactions data"
    }
  ],
  "line": 35,
  "name": "User clicks on \"Project cost management\" in page header",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "User clicks on \"All transactions\" in \"Project cost management\" section",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User clicks on Refresh",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "User clicks Show lines",
  "keyword": "And "
});
formatter.step({
  "line": 39,
  "name": "User selects \"Only cost transactions\"",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "User clicks Ok in All transactions",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "User clicks on \"ProjectID\" field",
  "keyword": "And "
});
formatter.step({
  "line": 43,
  "name": "User search the ProjectID for \"Feature 6\"",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "User clicks Apply button",
  "keyword": "And "
});
formatter.step({
  "line": 46,
  "name": "User gets total amount of \"Current period end date\"",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "User clicks on Close",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 49,
      "value": "#Final Invoicing"
    }
  ],
  "line": 50,
  "name": "User clicks on \"Project cost management\" in page header",
  "keyword": "And "
});
formatter.step({
  "line": 51,
  "name": "User clicks on \"Construction contract\" in \"Contracts\" section",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "User calculates Invoice Amount from Journals",
  "keyword": "And "
});
formatter.step({
  "line": 54,
  "name": "validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage",
  "keyword": "Then "
});
formatter.step({
  "line": 55,
  "name": "User clicks on Refresh",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "User gets updated contract data",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "User Clicks Edit",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 58,
      "value": "#Then User updates Percent complete in contract and validates Work in place, Amount remaining and Invoice amount from sheet \"UpdateContracts3\""
    }
  ],
  "line": 59,
  "name": "User updates Percent complete in contract from sheet \"UpdateContracts3\"",
  "keyword": "Then "
});
formatter.step({
  "line": 60,
  "name": "validates Work in place, Amount remaining, Invoice amount, Retainage Amount and Total Retainage after percent complete update",
  "keyword": "Then "
});
formatter.match({
  "location": "projectcostmanagement.user_Login_Finance_and_Operations_Application()"
});
