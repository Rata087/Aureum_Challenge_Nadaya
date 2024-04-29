package org.aureum.steps;

import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.aureum.utils.JSONUtils;
import org.aureum.utils.IDGenerator;

import java.io.IOException;
import java.util.*;
import java.io.File;

import static org.hamcrest.Matchers.*;

public class ApiStepDefinitions {

    private RequestSpecification request;
    private Response response;
    private String petID;

    @And("the user accesses the Petstore API")
    public void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        request = RestAssured.given();
    }


    @And("^makes a GET request to get all (.*?) pets$")
    public void getPet(String petStatus) {
        response = request.queryParam("status", petStatus).get("/pet/findByStatus");
    }


    @And("the response status code is {int}")
    public void verifyStatusCode(int StatusCode) {
        response.then().statusCode(StatusCode);
    }


    @And("^the response returns the list of pets with the (.*?) status$")
    public void verifyPetList(String status) {
        response.then().body("status", everyItem(equalTo(status)));
    }


    @And("validates that the amount of pets is greater than {int}")
    public void validateNumberOfPetsGraterThan(int petAmount) {
        response.then().body("size()", greaterThan(petAmount));
    }


    @And("^print the amount of (.*?) pets in the console$")
    public void printTheNumberOfPetStatusPetsInTheConsole(String status) {
        Map<String, Integer> petsByStatus = new HashMap<>();
        petsByStatus.put(status, response.jsonPath().getList("id").size());

        System.out.println("\nThe amount of " + status + " pets is:");
        for (Map.Entry<String, Integer> entry : petsByStatus.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    @And("^adds a new pet called (.*?) in (.*?) status$")
    public void AddAPetWithNameAndStatus(String name, String status) throws IOException {
        File petRequestBody = new File("src/test/resources/body_json/PetRequestBody.json");
        petID = IDGenerator.convertDateTimeToStringID();
        String requestBody = "";

        try {
            requestBody = new String(java.nio.file.Files.readAllBytes(petRequestBody.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
//         Update the "id", "name" and "status" fields in the Request Body
        requestBody = JSONUtils.updateField(requestBody, "id", petID);
        requestBody = JSONUtils.updateField(requestBody, "name", name);
        requestBody = JSONUtils.updateField(requestBody, "status", status);

        response = request.body(requestBody).contentType("application/json").post("/pet");

//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body:");
        System.out.println(response.getBody().asString());
    }


    @And("^deletes a pet by (.*?)$")
    public void deletesAPetByID(String id) {
        response = request.given().delete("/pet/" + id);
//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body:");
        switch (response.statusCode()) {
            case 404:
                System.out.println(response.statusCode() + " : Pet not found");
                break;
            case 400:
                System.out.println(response.statusCode() + " : Invalid ID supplied");
                break;
            default:
                System.out.println(response.getBody().asString());
                break;
        }
    }


    @And("^validates that the (.*?) no longer exists in the pet list$")
    public void validatesThatTheIDNoLongerExistsInThePetList(String id) {
        response = request.given().get("/pet/" + id);
        response.then().statusCode(404);
//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body for deleted pet:");
        System.out.println(response.getBody().asString());
    }


    @And("^updates the (.*?) and (.*?) of a pet by (.*?)$")
    public void updatesAPetByID(String name, String status, String id) throws IOException {
        File petRequestBody = new File("src/test/resources/body_json/PetRequestBody.json");
        String requestBody = "";

        try {
            requestBody = new String(java.nio.file.Files.readAllBytes(petRequestBody.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }

//         Update the "id", "name" and "status" fields in the Request Body
        requestBody = JSONUtils.updateField(requestBody, "id", id);
        requestBody = JSONUtils.updateField(requestBody, "name", name);
        requestBody = JSONUtils.updateField(requestBody, "status", status);

        response = request.body(requestBody).contentType("application/json").put("/pet");

//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body:");
        System.out.println(response.getBody().asString());
    }


    @And("^validates (.*?) and (.*?) are valid for the pet (.*?)$")
    public void validatesNameAndStatusAreValidForThePetID(String name, String status, String id) {
        response = request.given().get("/pet/" + id);
        response.then().assertThat().body("name", equalTo(name));
        response.then().assertThat().body("status", equalTo(status));
    }


    @And("deletes the newly created pet")
    public void deletesTheNewlyCreatedPet() {
        response = request.given().delete("/pet/" + petID);
//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body:");
        switch (response.statusCode()) {
            case 404:
                System.out.println(response.statusCode() + " : Pet not found");
                break;
            case 400:
                System.out.println(response.statusCode() + " : Invalid ID supplied");
                break;
            default:
                System.out.println(response.getBody().asString());
                break;
        }
    }


    @And("verifies that the newly created pet is no longer present in the list of pets")
    public void verifiesThatTheNewlyCreatedPetIsNoLongerPresentInTheListOfPets() {
        response = request.given().get("/pet/" + petID);
        response.then().statusCode(404);
//        Print the Response Body to the console just to display the information
        System.out.println("\nResponse Body for deleted pet:");
        System.out.println(response.getBody().asString());
    }
}
