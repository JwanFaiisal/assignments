package org.example.Day21;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class ActivitiesCRUDTest {

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("https://fakerestapi.azurewebsites.net/api/v1")
            .setContentType(ContentType.JSON)
            .build();

    @Test
    public void testCRUDOperations() {

        // Step 1
        Activity newActivity = new Activity(9999, "Learn API Testing", "2025-10-20T00:00:00Z", true);
        Response postResponse = given(spec)
                .body(newActivity)
                .when()
                .post("/Activities");

        assertEquals(200, postResponse.statusCode());
        System.out.println("Created: " + postResponse.as(Activity.class));

        // Step 2
        Response getResponse = given(spec)
                .when()
                .get("/Activities/1");

        assertEquals(200, getResponse.statusCode());
        Activity existingActivity = getResponse.as(Activity.class);
        System.out.println("📖 Read Existing: " + existingActivity.getTitle());

        // Step 3: UPDATE (PUT)
        existingActivity.setTitle("Updated Title Test");
        Response putResponse = given(spec)
                .body(existingActivity)
                .when()
                .put("/Activities/1");

        assertEquals(200, putResponse.statusCode());
        Activity updated = putResponse.as(Activity.class);
        System.out.println("📝 Updated: " + updated.getTitle());

        // Step 4
        Response deleteResponse = given(spec)
                .when()
                .delete("/Activities/1");

        assertEquals(200, deleteResponse.statusCode());
        System.out.println("🗑️ Deleted ID: 1");
    }
}
