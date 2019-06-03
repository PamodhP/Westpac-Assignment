package tests;

import org.json.JSONObject;

public class TestData_Scenarios {

    /**
     * This class providers the data need for each scenarios
     *
     * @return
     */

    public static String US1_Scenario1() {
        String expectedMessage = "If you are earning a salary or wage, select ‘Employed’. Your employer contributions will be automatically calculated at a rate of 3% of your before-tax salary or wages. You can also select ‘Self-employed’ or ‘Not employed’ and then enter below (in the Voluntary contributions field), the amount and frequency of any contributions that you wish to make.";
        return expectedMessage;
    }

    public static JSONObject US2_Scenario1() {
        JSONObject scenario = new JSONObject();
        scenario.put("Age", "25");
        scenario.put("EmployeeStatus", "employed");
        scenario.put("Salary", "72000");
        scenario.put("KiwiSaveContribution", "8");
        scenario.put("PIRRate", "17.5");
        scenario.put("RiskProfile", "high");
        scenario.put("ExpectedResult", "558973");
        return scenario;
    }

    public static JSONObject US2_Scenario2() {
        JSONObject scenario = new JSONObject();
        scenario.put("Age", "41");
        scenario.put("EmployeeStatus", "self-employed");
        scenario.put("PIRRate", "10.5");
        scenario.put("KiwiSavaerBalance", "90000");
        scenario.put("VoluntaryContributions", "90");
        scenario.put("Frequency", "month");
        scenario.put("RiskProfile", "medium");
        scenario.put("SavingsGoal", "290000");
        scenario.put("ExpectedResult", "205624");
        return scenario;
    }

    public static JSONObject US2_Scenario3() {
        JSONObject scenario = new JSONObject();
        scenario.put("Age", "55");
        scenario.put("EmployeeStatus", "not-employed");
        scenario.put("PIRRate", "10.5");
        scenario.put("KiwiSavaerBalance", "140000");
        scenario.put("VoluntaryContributions", "10");
        scenario.put("Frequency", "year");
        scenario.put("RiskProfile", "medium");
        scenario.put("SavingsGoal", "200000");
        scenario.put("ExpectedResult", "176557");
        return scenario;
    }


}
