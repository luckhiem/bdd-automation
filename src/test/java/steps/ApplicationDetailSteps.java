package steps;

import core.driver.DriverManager;
import core.page.application.ApplicationDetailPage;
import core.utils.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static core.actions.WaitActions.staticWait;
import static core.constants.Message.SUBMIT_SUCCESS_MESSAGE;
import static core.constants.Message.WARNING_MESSAGE;

public class ApplicationDetailSteps {
    WebDriver driver = DriverManager.getDriver();
    ApplicationDetailPage applicationDetailPage = new ApplicationDetailPage(driver);
    ScenarioContext context = ScenarioContext.currentContext();

    @And("I select menu {string} in application detail")
    public void iSelectMenuInApplicationDetail(String menu) {
        applicationDetailPage.selectMenu(menu);
    }

    @And("I answer the questions in eligibility question:")
    public void iAnswerTheQuestionsInEligibilityQuestion(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            Map<String, String> filteredMap = columns.entrySet()
                    .stream().filter(x -> "No".equalsIgnoreCase(x.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            context.set("filterNoAnswer").with(filteredMap);

            applicationDetailPage.getEligibilitySection()
                    .selectRegisteredCheck(columns.get("register check"))
                    .selectTurnOverCheck(columns.get("turnover check"))
                    .selectGlobalHQCheck(columns.get("global hq check"))
                    .selectTargetMarket(columns.get("target market check"))
                    .selectStartedProjectCheck(columns.get("started project check"));
        }
    }

    @And("I see the warning not meet the eligibility criteria with No answer")
    public void iSeeTheWarningNotMeetTheEligibilityCriteriaWithNoAnswer() {
        Map<String, String> options = context.get("filterNoAnswer", Map.class);
        String warningMessageText = applicationDetailPage.getEligibilitySection().getWarningMessageText();
        Assert.assertEquals(warningMessageText, WARNING_MESSAGE);
        Assert.assertEquals(options.size(), applicationDetailPage.getEligibilitySection().getNumberWarningMessage());
    }


    @And("I input the main contact detail with value:")
    public void iInputTheMainContactDetailWithValue(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        context.set("contactDetail").with(rows.get(0));
        for (Map<String, String> columns : rows) {
            applicationDetailPage.getContactDetailSection()
                    .inputName(columns.get("Name"))
                    .inputJobTitle(columns.get("Job Title"))
                    .inputPhoneNumber(columns.get("Contact No"))
                    .inputEmail(columns.get("Email"));
        }
    }

    @And("I click on same as registered address in Company Profile")
    public void iClickOnSameAsRegisteredAddressInCompanyProfile() throws InterruptedException {
        applicationDetailPage.getContactDetailSection().checkOnSameMallingAddress();
    }

    @And("I click on  as main contact person")
    public void iClickOnAsMainContactPerson() {
        applicationDetailPage.getContactDetailSection().checkOnSameMainContact();
    }

    @Then("I should see main contact loaded correctly")
    public void iShouldSeeMainContactLoadedCorrectly() {
        Map<String, String> contacts = context.get("contactDetail", Map.class);
        String offerContactName = applicationDetailPage.getContactDetailSection().getOfferNameValue();
        String offerJobTitle = applicationDetailPage.getContactDetailSection().getOfferDesignationValue();
        String offerEmail = applicationDetailPage.getContactDetailSection().getOfferEmailValue();
        Assert.assertEquals(offerContactName, contacts.get("Name"));
        Assert.assertEquals(offerJobTitle, contacts.get("Job Title"));
        Assert.assertEquals(offerEmail, contacts.get("Email"));
    }

    @And("I select activity {string} in proposal")
    public void iSelectActivityInProposal(String value) {
        applicationDetailPage.getProposalSection().selectActivity(value);
    }

    @And("I input the proposal information with:")
    public void iInputTheProposalInformationWith(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        context.set("proposalDetail").with(rows.get(0));
        for (Map<String, String> columns : rows) {
            applicationDetailPage.getProposalSection()
                    .inputProjectTitle(columns.get("Project Title"))
                    .inputStartDate(columns.get("Start Date"))
                    .inputEndDate(columns.get("End Date"))
                    .inputProjectDescription(columns.get("Project Description"));
        }
    }

    @And("I select market {string} in proposal")
    public void iSelectMarketInProposal(String value) {
        applicationDetailPage.getProposalSection().selectMarket(value);
    }

    @And("I input project FY date {string} in business impact")
    public void iInputProjectFYDateInBusinessImpact(String value) {
        applicationDetailPage.getBusinessImpactSection().inputFYEndDate(value);
    }

    @And("I input overseas sale {string} and {string} and {string} and {string} in business impact")
    public void iInputOverseasSaleAndAndAndInBusinessImpact(String arg0, String arg1, String arg2, String arg3) {
        applicationDetailPage.getBusinessImpactSection().inputOverseaSale(arg0, arg1, arg2, arg3);
    }

    @And("I input overseas investment {string} and {string} and {string} and {string} in business impact")
    public void iInputOverseasInvestmentAndAndAndInBusinessImpact(String arg0, String arg1, String arg2, String arg3) {
        applicationDetailPage.getBusinessImpactSection().inputOverseaInvestment(arg0, arg1, arg2, arg3);
    }

    @And("I input rationale for projections {string} in business impact")
    public void iInputRationaleForProjectionsInBusinessImpact(String arg0) {
        applicationDetailPage.getBusinessImpactSection().inputProjectImpactReasonable(arg0);
    }

    @And("I input non tangible benefits {string} in business impact")
    public void iInputNonTangibleBenefitsInBusinessImpact(String arg0) {
        applicationDetailPage.getBusinessImpactSection().inputProjectImpactBenefitInput(arg0);
    }

    @And("I upload supporting document in cost section")
    public void iUploadSupportingDocumentInCostSection() throws InterruptedException {
        File FILE = new File("src/main/resources/vendor.xlsx");
        applicationDetailPage.getCostSection().addSupportingDocument(FILE.getAbsolutePath());
    }

    @And("I add new item in third party vendor")
    public void iAddNewItemInThirdPartyVendor() {
        applicationDetailPage.getCostSection()
                .clickOnThirdPartyVendor()
                .clickOnAddItemCostVendor();
    }

    @And("I select the vendor registered check {string} in cost section")
    public void iSelectTheVendorRegisteredCheckInCostSection(String arg0) {
        applicationDetailPage.getCostSection().selectVendorRegistered(arg0);
    }

    @And("I input the vendor name {string} in cost section")
    public void iInputTheVendorNameInCostSection(String arg0) {
        applicationDetailPage.getCostSection().inputVendorName(arg0);
    }

    @And("I input vendor amount billing {string} in cost section")
    public void iInputVendorAmountBillingInCostSection(String arg0) {
        applicationDetailPage.getCostSection().inputVendorAmountBilling(arg0);
    }

    @And("I select the project first time expand {string} in proposal")
    public void iSelectTheProjectFirstTimeExpandInProposal(String arg0) {
        applicationDetailPage.getProposalSection().selectFirstTimeExpand(arg0);
    }

    @And("I answer the questions in Declare & Review section:")
    public void iAnswerTheQuestionsInDeclareReviewSection(DataTable table) throws InterruptedException {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            applicationDetailPage.getDeclareAndReviewSection()
                    .selectCriminalLiabilityCheck(columns.get("Criminal Liability"))
                    .selectCivilProceedingCheck(columns.get("Civil Proceeding"))
                    .selectInsolvencyProceedingCheck(columns.get("Insolvency Proceeding"))
                    .selectIncentivesCheck(columns.get("Incentives"))
                    .selectOtherIncentivesCheck(columns.get("Other Incentives"))
                    .selectCommenceCheck(columns.get("Commence"))
                    .selectRelatedPartyCheck(columns.get("Related Party"))
                    .selectDebarmentCheck(columns.get("Debarment"))
                    .selectCovidSafeCheck(columns.get("Covid Safe"))
                    .selectCovidSafeQuesCheck(columns.get("Covid Safe Ques"));
        }
    }

    @And("I check on acknowledges and consents to the above")
    public void iCheckOnAcknowledgesAndConsentsToTheAbove() {
        applicationDetailPage.getDeclareAndReviewSection().checkOnAcknowledgeCheck();
    }

    @And("I check on info truthfulness in company profile section")
    public void iCheckOnInfoTruthfulnessInCompanyProfileSection() {
        applicationDetailPage.getCompanyProfileSection().checkOnInfoTruthfulness();
    }

    @Then("I should see the form submit successfully")
    public void iShouldSeeTheFormSubmitSuccessfully() {
        String message = applicationDetailPage.getCompanyProfileSection().getSubmitSuccessMessage();
        Assert.assertEquals(message, SUBMIT_SUCCESS_MESSAGE);
    }
}
