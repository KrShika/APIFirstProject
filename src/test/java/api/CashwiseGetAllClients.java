package api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.Config;

import java.util.HashMap;
import java.util.Properties;

public class CashwiseGetAllClients {


    Response response;
    @Given("the user hits the API with endpoint {string}")
    public void the_user_hits_the_api_with_endpoint(String endpoint) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("size", 20);
        params.put("page", 1);
        response = RestAssured.
                given().
                auth().
                oauth2(Config.getProperty("cashwiseToken")).
                params(params).
                get((Config.getProperty("baseCashwiseUrl") + endpoint));
    }
    @Then("the user validates that status code is {int}")
    public void the_user_validates_that_status_code_is(Integer statusCode) {

        Assert.assertTrue(response.getStatusCode() == statusCode);
    }
    @Then("the user verifies if all client ids are not empty")
    public void the_user_verifies_if_all_client_ids_are_not_empty() {
        response.jsonPath().get("responses.client_id").toString();

    }





}
