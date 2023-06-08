package StepDefinitions;

import Pages.PackagesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

import static Pages.PackagesPage.driver;


public class MyStepdefs  {



 public MyStepdefs() {

 }


    @Given("^User navigates to base URL$")
    public void userNavigatesToBaseURL() {
        //TestBase.initialization( );
       PackagesPage.initialization();


    }

    @When("^User clicks on current country$")
    public void userClicksOnCurrentCountry() throws InterruptedException {
       PackagesPage.clickCurrentCountry();


    }
   @And("^User selects (.*)$")
   public void userSelects(String code) throws InterruptedException {
     System.out.println( code );
    PackagesPage.selectCountryByCode(code);

   }


    @Then("^User should see three plans listed in the page$")
    public void userShouldSeeThreePlansListedInThePage() throws InterruptedException{
     PackagesPage.verifyLitePackageExists();
     PackagesPage.verifyClassicPackageExists();
     PackagesPage.verifyPremiumPackageExists();
    }

    @Then("^User should see a currency of (.*) and price of lite plan (.*)$")
    public void userShouldSeeACurrencyOfCurrencyAndPriceOfLitePlanPrice(String currency , double price) throws InterruptedException {
    String actualCurrency = PackagesPage.getCurrentCurrency();
    double actualPrice = PackagesPage.getLitePricing();
   Assert.assertEquals(actualPrice,price);
    Assert.assertTrue(actualCurrency.contains(currency));
    //Assert.assertTrue(actualPrice.contains(currency));

    }

    @And("^User should see a currency of (.*) and price of classic plan (.*)$")
    public void userShouldSeeACurrencyOfCurrencyAndPriceOfClassicPlanPrice(String currency ,double price) throws InterruptedException{
        String actualCurrency = PackagesPage.getCurrentCurrency();
        double actualPrice = PackagesPage.getClassicPricing();
        Assert.assertEquals(actualPrice,price);
        Assert.assertTrue(actualCurrency.contains(currency));
 }

    @And("^User should see a currency of (.*) and price of premium plan (.*)$")
    public void userShouldSeeACurrencyOfCurrencyAndPriceOfPremiumPlanPrice(String currency , double price) throws InterruptedException{
        String actualCurrency = PackagesPage.getCurrentCurrency();
        double actualPrice = PackagesPage.getPremiumPricing();
        Assert.assertEquals(actualPrice,price);
        Assert.assertTrue(actualCurrency.contains(currency));
    }


    @And("Screenshot is taken")
    public void screenshotIsTaken() throws IOException {
     PackagesPage.takeScreenshot( driver , "Screenshot");

    }

    @And("Screenshot is taken of every {}")
    public void screenshotIsTakenOfEvery(String country) throws IOException {
        PackagesPage.takeScreenshot( driver , "Screenshot"+country);
    }

    @And("Close Browser")
    public void closeBrowser() {
     PackagesPage.CloseBrowser();

    }
}

