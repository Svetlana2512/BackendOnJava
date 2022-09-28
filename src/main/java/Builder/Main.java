package Builder;

import Lesson4.ApiSearchResult;
import Lesson4.ApiUserConnectRequest;
import Lesson4.ApiUserConnectResult;
import Lesson4.SpoonaccularService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


//public class Main {

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

//    public static void main(String[] args) throws IOException {
//
//        SpoonaccularService spoonaccularService = new SpoonaccularService();
//        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
//        System.out.println(recipes);
//
//        ApiUserConnectResult connectResult = spoonaccularService.connect(new ApiUserConnectRequest());
//        System.out.println(connectResult);
//
//}
//}
public class Main {
    public static void main(String[] args) throws IOException {

//        SpoonaccularService spoonaccularService = new SpoonaccularService();
//        ApiSearchResult recipes = spoonaccularService.findRecipes("Bread", 3);
//        System.out.println(recipes);
//
//        ApiUserConnectResult connectResult = spoonaccularService.connect(new ApiUserConnectRequest());
//        System.out.println(connectResult);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("myBatisConfig.xml"));

        try (SqlSession session = sessionFactory.openSession()) {
            ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
            CategoriesMapper categoriesMapper = session.getMapper(CategoriesMapper.class);
            Products product = productsMapper.selectByPrimaryKey(444L);
            System.out.println(product);
            Categories category = categoriesMapper.selectByPrimaryKey(product.getCategoryId());
            System.out.println(category);

        }

    }
}