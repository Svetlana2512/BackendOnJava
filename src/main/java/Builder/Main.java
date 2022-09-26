package Builder;

import Lesson4.ApiSearchResult;
import Lesson4.ApiUserConnectRequest;
import Lesson4.ApiUserConnectResult;
import Lesson4.SpoonaccularService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;


public class Main {

//    public static void main(String[] args) {
//
//        User user = User.builder()
//                .setName("Ivan")
//                .setSurname("Ivanov")
//                .setAddress("Address")
//                .setEmail("123@ya.ru")
//                .build();
//
//        RequestSpecification requestSpecification =
//                new RequestSpecBuilder()
//                        .build();
//    }

    public static void main(String[] args) throws IOException {

        SpoonaccularService spoonaccularService = new SpoonaccularService();
        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
        System.out.println(recipes);

        ApiUserConnectResult connectResult = spoonaccularService.connect(new ApiUserConnectRequest());
        System.out.println(connectResult);

}
}
