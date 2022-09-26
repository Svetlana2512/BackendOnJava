package Lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class addItemToShoppingList {
    @Test
    void A_postaddItemToShoppingList() {
        given()
                .when()
                .post("https://api.spoonacular.com/mealplanner/dsky/shopping-list/items")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void B_getItemToShoppingList() {
        given()
                .when()
                .post("https://api.spoonacular.com/mealplanner/dsky/shopping-list")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void C_deleteItemToShoppingList() {
        given()
                .when()
                .post("https://api.spoonacular.com/mealplanner/{username}/shopping-list/items/{id}")
                .then()
                .spec(responseSpecification);
    }
}

