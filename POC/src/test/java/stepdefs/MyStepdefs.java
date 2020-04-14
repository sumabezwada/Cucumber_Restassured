package stepdefs;

import Base.BaseUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class MyStepdefs extends BaseUtil {

    private BaseUtil base;

    public MyStepdefs(BaseUtil base) {
        this.base = base;
    }

    @Given("^hit the api with post call\"([^\"]*)\"$")
    public void hit_the_api_with_post_call(String url)  {
        System.out.println("printing the url " +url);
    }

    @Given("^I navigate tologin page$")
    public void iNavigateTologinPage() {
          System.out.println("Navigate to login page ");
    }

    @When("^I enter the login credentials$")
    public void iEnterTheLoginCredentials(DataTable table) {
        List<List<String>> data= table.raw();
        System.out.println("username is "+ data.get(1).get(0));
        System.out.println("password is "+ data.get(1).get(1));



    }

    @And("^I click the login button$")
    public void iClickTheLoginButton() {
        System.out.println("Click login button ");
    }

    @Then("^I should see the user form page$")
    public void iShouldSeeTheUserFormPage() {
        System.out.println("Navigated to user form page ");
    }

    @When("^I enter login credentials$")
    public void iEnterLoginCredentials(DataTable table) {

          List<User> users=new ArrayList<User>();
         users=table.asList(User.class);
         for(User user:users)
         {
             System.out.println("User name is " +user.username);
             System.out.println("Password is " +user.password);
         }

    }

    public class User
    {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
