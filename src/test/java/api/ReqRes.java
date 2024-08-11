package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ReqRes {
    public static void main(String[] args) {

String url = "https://reqres.in/api/users/7";

        Response response = RestAssured.get(url);
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        String email = response.jsonPath().get("data.email").toString();
        System.out.println(email);

        String first_name = response.jsonPath().get("data.first_name").toString();
        System.out.println(first_name);

        String last_name = response.jsonPath().get("data.last_name").toString();
        System.out.println(last_name);

        String text = response.jsonPath().get("support.text").toString();
        System.out.println(text);

        Assert.assertFalse(email.isEmpty());
        Assert.assertFalse(first_name.isEmpty());
        Assert.assertFalse(last_name.isEmpty());
        Assert.assertFalse(text.isEmpty());

        String emailVal = "michael.lawson@reqres.in";
        String avatar = "https://reqres.in/img/faces/7-image.jpg";

        Assert.assertTrue(emailVal.contains("@reqres.in"));
        Assert.assertTrue(avatar.contains("jpg"));






    }
}
