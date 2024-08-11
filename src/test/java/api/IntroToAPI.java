package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class IntroToAPI {
    public static void main(String[] args) {

        String baseUri = "https://backend.cashwise.us";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjUxNDc4MjYsImlhdCI6MTcyMjU1NTgyNiwidXNlcm5hbWUiOiJBZG1pbkBnbWFpbC5jb20ifQ.Qjk-cxySLgtkIouh8S4n4y5Z9QXzV_4yIxi2VcNe1iTjI9rPADrsKJ4lp7qkVZN9ePuf3ZM3uCPhHoa3-x7pDQ";

        RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .when()
                .get("/api/myaccount/sellers/all")
                .then()
                .statusCode(200);


                 RestAssured
                .given()
                .auth()
                .oauth2(token)
                .baseUri(baseUri)
                .and()
                .queryParams("isArchived", false)
                .queryParams("page", 1)
                .queryParams("size", 2)
                .when()
                .get("/api/myaccount/sellers")
                .then()
                .statusCode(200);


        // another way


        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 2);
        Response response = RestAssured.given().auth().oauth2(token).
                params(params).get(baseUri + "/api/myaccount/sellers");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());



        String sellerId = response.jsonPath().get("responses.seller_id[0]").toString();
        System.out.println(sellerId);

        Response response1 = RestAssured.given().auth().oauth2(token).
                get(baseUri + "/api/myaccount/sellers/" + sellerId);
        System.out.println(response1.prettyPrint());

        String actualSellerId = response1.jsonPath().get("seller_id").toString();
        Assert.assertEquals(sellerId, actualSellerId);







//
    }









    }

