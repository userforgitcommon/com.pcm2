package sis.pcm.utilities;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Formulas {

	/*
	 * DecimalFormat DecimalFormatTwoDecimals;
	 * 
	 * DecimalFormat DecimalFormatSixDecimals;
	 * 
	 * public Formulas() {
	 * 
	 * DecimalFormatTwoDecimals = new DecimalFormat("0.00");
	 * 
	 * DecimalFormatTwoDecimals.setGroupingUsed(true);
	 * 
	 * DecimalFormatTwoDecimals.setGroupingSize(3);
	 * 
	 * DecimalFormatSixDecimals = new DecimalFormat("0.000000");
	 * 
	 * DecimalFormatSixDecimals.setGroupingUsed(true);
	 * 
	 * DecimalFormatSixDecimals.setGroupingSize(3); }
	 */

	public String formatTwoDecimals(Double value) {

		String RoundedValue = String.format("%.2f", value);

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		String FormattedRoundedValue = df.format(Double.parseDouble(RoundedValue));

		return FormattedRoundedValue;
	}

	public String formatSixDecimals(Double value) {

		// String RoundedValue = String.format("%.7f", value);

		DecimalFormat df = new DecimalFormat("0.000000");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		df.setRoundingMode(RoundingMode.DOWN);

		String FormattedRoundedValue = df.format((value));

		return FormattedRoundedValue;
	}

	public String getExpectedRevenueBudget(ArrayList<ArrayList<String>> BudgetLines,
			ArrayList<String> BudgetCategories_RevenueType) throws InterruptedException {

		Double RevenueBudget = 0.00;

		for (ArrayList<String> BudgetLine : BudgetLines) {

			String BudgetCategory = BudgetLine.get(2);

			if (BudgetCategories_RevenueType.contains(BudgetCategory)) {

				String Quantity = BudgetLine.get(3);

				String UnitPrice = BudgetLine.get(5);

				Double LineAmount = Double.parseDouble(Quantity) * Double.parseDouble(UnitPrice);

				RevenueBudget = RevenueBudget + LineAmount;

			}

		}

		String RevenueBudgetValue = formatTwoDecimals(RevenueBudget);

		return RevenueBudgetValue;

	}

	public String getExpectedCostBudget(ArrayList<ArrayList<String>> BudgetLines,
			ArrayList<String> BudgetCategories_ExpenseType) throws InterruptedException {

		Double CostBudget = 0.00;

		for (ArrayList<String> BudgetLine : BudgetLines) {

			String BudgetCategory = BudgetLine.get(2);

			if (BudgetCategories_ExpenseType.contains(BudgetCategory)) {

				String Quantity = BudgetLine.get(3);

				String UnitPrice = BudgetLine.get(5);

				Double LineAmount = Double.parseDouble(Quantity) * Double.parseDouble(UnitPrice);

				CostBudget = CostBudget + LineAmount;

			}

		}

		String CostBudgetValue = formatTwoDecimals(CostBudget);

		return CostBudgetValue;

	}

	public String getExpectedProfitMargin(String RevenueBudget, String CostBudget) {

		RevenueBudget = RevenueBudget.replace(",", "");

		CostBudget = CostBudget.replace(",", "");

		Double ProfitMargin = 0.00;

		if (Double.parseDouble(CostBudget) != 0) {

			ProfitMargin = 100 - (Double.parseDouble(CostBudget) / Double.parseDouble(RevenueBudget)) * 100;

		}

		else {

			ProfitMargin = 100.00;

		}

		String ProfitMarginValue = formatTwoDecimals(ProfitMargin);

		return ProfitMarginValue;

	}

	public String getExpectedLineAmount(String Quantity, String UnitPrice) throws InterruptedException {

		Double LineAmountExpected = Double.parseDouble(Quantity) * Double.parseDouble(UnitPrice);

		String LineAmountExpectedValue = formatTwoDecimals(LineAmountExpected);

		return LineAmountExpectedValue;

	}

	public String getExpectedTotalScheduledValue(ArrayList<ArrayList<String>> ConstructionContracts)
			throws InterruptedException {

		Double ScheduledValueTotal = 0.00;

		for (ArrayList<String> ConstructionContract : ConstructionContracts) {

			Double ScheduledValue = Double.parseDouble(ConstructionContract.get(1));

			ScheduledValueTotal = ScheduledValueTotal + ScheduledValue;

		}

		String ScheduledValue = formatTwoDecimals(ScheduledValueTotal);

		return ScheduledValue;

	}

	public String getExpectedSubContractAmount(ArrayList<ArrayList<String>> SubContracts) throws InterruptedException {

		Double SubContractAmountValue = 0.00;

		for (ArrayList<String> SubContract : SubContracts) {

			Double SubContractAmount = Double
					.parseDouble(getProduct(SubContract.get(3), SubContract.get(4)).replace(",", ""));

			SubContractAmountValue = SubContractAmountValue + SubContractAmount;

		}

		String SubContractAmount = formatTwoDecimals(SubContractAmountValue);

		return SubContractAmount;

	}

	public String getDifference(String value1, String value2) throws InterruptedException {

		value1 = value1.replace(",", "");

		value2 = value2.replace(",", "");

		Double Result = Double.parseDouble(value1) - Double.parseDouble(value2);

		String ResultValue = formatTwoDecimals(Result);

		return ResultValue;

	}

	public String getSum(String value1, String value2) throws InterruptedException {

		value1 = value1.replace(",", "");

		value2 = value2.replace(",", "");

		Double Result = Double.parseDouble(value1) + Double.parseDouble(value2);

		String ResultValue = formatTwoDecimals(Result);

		return ResultValue;

	}

	public String getSum(String value1, String value2, String value3) throws InterruptedException {

		value1 = value1.replace(",", "");

		value2 = value2.replace(",", "");

		value3 = value3.replace(",", "");

		Double Result = Double.parseDouble(value1) + Double.parseDouble(value2) + Double.parseDouble(value3);

		String ResultValue = formatTwoDecimals(Result);

		return ResultValue;

	}

	public String getSumOfList(ArrayList<String> values) throws InterruptedException {

		Double Result = 0.00;

		for (String Value : values) {

			Value = Value.replace(",", "");

			Result = Double.parseDouble(Value) + Result;

		}

		String ResultValue = formatTwoDecimals(Result);

		return ResultValue;

	}

	public String getProduct(String value1, String value2) throws InterruptedException {

		value1 = value1.replace(",", "");

		value2 = value2.replace(",", "");

		Double Result = Double.parseDouble(value1) * Double.parseDouble(value2);

		String ResultValue = formatTwoDecimals(Result);

		return ResultValue;

	}

	public String getGMPercentage(String value1, String value2) {

		value1 = value1.replace(",", "");

		value2 = value2.replace(",", "");

		Double GMPercentage = 0.00;

		if (Double.parseDouble(value1) != 0) {

			GMPercentage = ((Double.parseDouble(value1) - Double.parseDouble(value2))) / (Double.parseDouble(value1))
					* 100;

		}

		else {

			GMPercentage = 0.00;

		}

		String ECACGMPercentageValue = formatTwoDecimals(GMPercentage);

		return ECACGMPercentageValue;

	}

	public String getECACcost_RevREC(ArrayList<ArrayList<String>> BudgetLines,
			ArrayList<String> BudgetCategoriesExcludedFromRevRec, String ECACNetChangeValue) {

		Double ECACcost_RevREC = 0.00;

		ECACNetChangeValue = ECACNetChangeValue.replace(",", "");

		for (ArrayList<String> BudgetLine : BudgetLines) {

			String BudgetCategory = BudgetLine.get(2);

			if (!BudgetCategory.equals("Revenue") && !BudgetCategoriesExcludedFromRevRec.contains(BudgetCategory)) {

				String Quantity = BudgetLine.get(3);

				String UnitPrice = BudgetLine.get(5);

				Double LineAmount = Double.parseDouble(Quantity) * Double.parseDouble(UnitPrice);

				ECACcost_RevREC = ECACcost_RevREC + LineAmount + Double.parseDouble(ECACNetChangeValue);

			}

		}

		String ECACcost_RevRECValue = formatTwoDecimals(ECACcost_RevREC);

		return ECACcost_RevRECValue;
	}

	public String getPercentageComplete(String ActualCost, String ECACCost) throws InterruptedException {

		ECACCost = ECACCost.replace(",", "");

		ActualCost = ActualCost.replace(",", "");

		Double PercentageComplete = (Double.parseDouble(ActualCost) / Double.parseDouble(ECACCost)) * 100;

		String PercentageCompleteValue = formatSixDecimals(PercentageComplete);

		return PercentageCompleteValue;

	}

	public String getPercentComplete(String ActualCost, String ECACCost) throws InterruptedException {

		ECACCost = ECACCost.replace(",", "");

		ActualCost = ActualCost.replace(",", "");

		Double PercentageComplete = (Double.parseDouble(ActualCost) / Double.parseDouble(ECACCost)) * 100;

		String PercentageCompleteValue = formatTwoDecimals(PercentageComplete);

		return PercentageCompleteValue;

	}

	public String getPTDEarnedMarginPercentage(String ActualCost, String ECACCost) throws InterruptedException {

		ECACCost = ECACCost.replace(",", "");

		ActualCost = ActualCost.replace(",", "");

		Double PercentageComplete = (Double.parseDouble(ActualCost) / Double.parseDouble(ECACCost)) * 100;

		String PercentageCompleteValue = formatTwoDecimals(PercentageComplete);

		return PercentageCompleteValue;

	}

	public String getPercentageBilled(String ActualCost, String ECACCost) throws InterruptedException {

		ECACCost = ECACCost.replace(",", "");

		ActualCost = ActualCost.replace(",", "");

		Double PercentageComplete = (Double.parseDouble(ActualCost) / Double.parseDouble(ECACCost)) * 100;

		String PercentageCompleteValue = formatTwoDecimals(PercentageComplete);

		return PercentageCompleteValue;

	}

	public String getWorkInPlace(String ScheduledValue, String PercentComplete) throws InterruptedException {

		ScheduledValue = ScheduledValue.replace(",", "");

		PercentComplete = PercentComplete.replace(",", "");

		Double WorkInPlace = (Double.parseDouble(ScheduledValue) * Double.parseDouble(PercentComplete)) / 100;

		String WorkInPlaceValue = formatTwoDecimals(WorkInPlace);

		return WorkInPlaceValue;

	}

	public String getAmountRemaining(String ScheduledValue, String WorkInPlace) throws InterruptedException {

		ScheduledValue = ScheduledValue.replace(",", "");

		WorkInPlace = WorkInPlace.replace(",", "");

		Double AmountRemaining = (Double.parseDouble(ScheduledValue) - Double.parseDouble(WorkInPlace));

		String AmountRemainingValue = formatTwoDecimals(AmountRemaining);

		return AmountRemainingValue;

	}

	public String getInvoiceAmount(String ScheduledValue, String PercentComplete) throws InterruptedException {

		ScheduledValue = ScheduledValue.replace(",", "");

		PercentComplete = PercentComplete.replace(",", "");

		Double InvoiceAmount = (Double.parseDouble(ScheduledValue) * Double.parseDouble(PercentComplete)) / 100;

		String InvoiceAmountValue = formatTwoDecimals(InvoiceAmount);

		// String InvoiceAmountValue = String.format("%.2f", InvoiceAmount);

		return InvoiceAmountValue;

	}

	public String getPTDEarnedMargin(String OrigContractValue, String PercentComplete, String ECACGMPercentage)
			throws InterruptedException {

		OrigContractValue = OrigContractValue.replace(",", "");

		PercentComplete = PercentComplete.replace(",", "");

		ECACGMPercentage = ECACGMPercentage.replace(",", "");

		Double PTDEarnedMargin = (Double.parseDouble(OrigContractValue) * Double.parseDouble(PercentComplete)
				* Double.parseDouble(ECACGMPercentage)) / 10000;

		String PTDEarnedMarginValue = formatTwoDecimals(PTDEarnedMargin);

		return PTDEarnedMarginValue;

	}

	public String getRetainageAmount(String InvoiceAmount, String RetainagePercent) throws InterruptedException {

		InvoiceAmount = InvoiceAmount.replace(",", "");

		RetainagePercent = RetainagePercent.replace(",", "");

		Double RetainageAmount = (Double.parseDouble(InvoiceAmount) * Double.parseDouble(RetainagePercent)) / 100;

		String RetainageAmountValue = formatTwoDecimals(RetainageAmount);

		return RetainageAmountValue;

	}

	public boolean isValue1Greater(String Value1, String Value2) throws InterruptedException {

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		if (Double.parseDouble(Value1) > Double.parseDouble(Value2)) {

			return true;
		}

		else {

			return false;

		}

	}

	public boolean isValue1GreaterOrEqual(String Value1, String Value2) throws InterruptedException {

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		if (Double.parseDouble(Value1) >= Double.parseDouble(Value2)) {

			return true;
		}

		else {

			return false;

		}

	}

	public String getAvailableForBilling(String CurrentCV, String TotalPOC, String ProgBilling)
			throws InterruptedException {

		CurrentCV = CurrentCV.replace(",", "");

		TotalPOC = TotalPOC.replace(",", "");

		ProgBilling = ProgBilling.replace(",", "");

		Double AvailableForBilling = ((Double.parseDouble(CurrentCV) * Double.parseDouble(TotalPOC)) / 100)
				- Double.parseDouble(ProgBilling);

		String AvailableForBillingValue = formatTwoDecimals(AvailableForBilling);

		return AvailableForBillingValue;

	}

	public String getUnpostedRevenue(String CurrentCV, String PercentageComplete, String PTDRevenue)
			throws InterruptedException {

		CurrentCV = CurrentCV.replace(",", "");

		PercentageComplete = PercentageComplete.replace(",", "");

		PTDRevenue = PTDRevenue.replace(",", "");

		Double AvailableForBilling = (Double.parseDouble(CurrentCV) * (Double.parseDouble(PercentageComplete) / 100))
				- Double.parseDouble(PTDRevenue);

		// Double AvailableForBilling = (Double.parseDouble(CurrentCV) *
		// Double.parseDouble(PercentageComplete)) /(100 -
		// Double.parseDouble(PTDRevenue));

		String AvailableForBillingValue = formatTwoDecimals(AvailableForBilling);

		return AvailableForBillingValue;

	}

	public String getNumericValueFormatted(String Value) {

		Value = formatTwoDecimals(Double.parseDouble(Value));

		return Value;

	}

	// ------------------Monica-----------------------

	public String getProdOfTwoValuesDivTen(String Value1, String Value2) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		Double Answer = (Double.parseDouble(Value1) * Double.parseDouble(Value2)) / 10;

		String Value = df.format(Answer);

		return Value;

	}

	public String getProdOfTwoValuesDivHundred(String Value1, String Value2) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		Double Answer = (Double.parseDouble(Value1) * Double.parseDouble(Value2)) / 100;

		String Value = df.format(Answer);

		return Value;

	}

	public String getSubtractionOfTwoValues(String Value1, String Value2) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		Double RemainingValue = (Double.parseDouble(Value1) - Double.parseDouble(Value2));

		String Answer = df.format(RemainingValue);

		return Answer;

	}

	public String getDivision(String Value1, String Value2) throws InterruptedException {

		DecimalFormat df = new DecimalFormat("0.00");

		df.setGroupingUsed(true);

		df.setGroupingSize(3);

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		Double Answer = (Double.parseDouble(Value1) / Double.parseDouble(Value2));

		String Value = df.format(Answer);

		return Value;

	}

	public String getExpectedCOMarginPercentage(String Value1, String Value2, String Value3)
			throws InterruptedException {

		Value1 = Value1.replace(",", "");

		Value2 = Value2.replace(",", "");

		Value3 = Value3.replace(",", "");

		String COMarginPercentageExpectedValue;

		/*
		 * if (Value1.equals("0.00")) {
		 * 
		 * COMarginPercentageExpectedValue = "0.00"; }
		 * 
		 * else {
		 */

		Double Answer1 = Double.parseDouble(Value1) + Double.parseDouble(Value2) - Double.parseDouble(Value3);

		Double Answer2 = Double.parseDouble(Value1) + Double.parseDouble(Value2);

		Double COMarginPercentage = (Answer1 / Answer2) * 100;

		COMarginPercentageExpectedValue = formatTwoDecimals(COMarginPercentage);

		// }

		return COMarginPercentageExpectedValue;

	}

	public String getActualCost(String AmountCurrentPeriod, String AmountExcludeRevRecCurrentPeriod,
			String AmountNextPeriod, String AmountExcludeRevRecNexPeriod) throws InterruptedException {

		AmountCurrentPeriod = AmountCurrentPeriod.replace(",", "");

		AmountExcludeRevRecCurrentPeriod = AmountExcludeRevRecCurrentPeriod.replace(",", "");

		AmountNextPeriod = AmountNextPeriod.replace(",", "");

		AmountExcludeRevRecNexPeriod = AmountExcludeRevRecNexPeriod.replace(",", "");

		// InvoiceAmount = InvoiceAmount.replace(",", "");

		Double ActualCost = Double.parseDouble(AmountCurrentPeriod)
				- Double.parseDouble(AmountExcludeRevRecCurrentPeriod) + Double.parseDouble(AmountNextPeriod)
				- Double.parseDouble(AmountExcludeRevRecNexPeriod);

		String ActualCostExpectedValue = formatTwoDecimals(ActualCost);

		return ActualCostExpectedValue;

	}

	public String getYTDCost(String AmountCurrentPeriod, String AmountNextPeriod, String InvoiceAmount)
			throws InterruptedException {

		AmountCurrentPeriod = AmountCurrentPeriod.replace(",", "");

		AmountNextPeriod = AmountNextPeriod.replace(",", "");

		InvoiceAmount = InvoiceAmount.replace(",", "");

		Double YTDCost = Double.parseDouble(AmountCurrentPeriod) + Double.parseDouble(AmountNextPeriod)
				+ Double.parseDouble(InvoiceAmount);

		String YTDCostExpectedValue = formatTwoDecimals(YTDCost);

		return YTDCostExpectedValue;

	}

	public String getMarginVariancePercentage(String CurrentCV, String ECACCost, String CurrentCOBudget)
			throws InterruptedException {

		CurrentCV = CurrentCV.replace(",", "");

		ECACCost = ECACCost.replace(",", "");

		CurrentCOBudget = CurrentCOBudget.replace(",", "");

		Double MarginVariancePercentage = ((Double.parseDouble(CurrentCV)
				- Double.parseDouble(ECACCost) / Double.parseDouble(CurrentCV)) * 100)
				- ((Double.parseDouble(CurrentCV) - Double.parseDouble(CurrentCOBudget) / Double.parseDouble(CurrentCV))
						* 100);

		String MarginVariancePercentageValue = formatTwoDecimals(MarginVariancePercentage);

		return MarginVariancePercentageValue;

	}

}
