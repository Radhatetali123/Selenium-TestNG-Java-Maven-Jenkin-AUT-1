import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

    public class SearchComRestAssured {

        @Test
        public void test1() throws IOException {

            Response response = RestAssured.get("https://computer-database.gatling.io/computers");
            System.out.println(response.getStatusCode());
            System.out.println(response.getTime());
            System.out.println(response.getBody().asString());
            System.out.println(response.getStatusLine());
            System.out.println(response.prettyPrint());
        }
    }
