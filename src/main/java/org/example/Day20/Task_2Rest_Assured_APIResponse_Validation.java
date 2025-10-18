package org.example.Day20;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class Task_2Rest_Assured_APIResponse_Validation {
    public static void main(String[] args) {
        String baseUrl = "https://fakerestapi.azurewebsites.net/api/v1/Users";

        Response response = RestAssured.get(baseUrl);

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Headers:");
        System.out.println(response.getHeaders());
        System.out.println("\nResponse Body:");
        response.prettyPrint();

        response.then().statusCode(200);
        response.then().assertThat().header("Content-Type", containsString("application/json"));
        response.then().assertThat().header("Server", containsString("Kestrel"));
        response.then().assertThat().header("Transfer-Encoding", equalTo("chunked"));

        System.out.println("\nAll API response validations passed successfully!");
    }
}
