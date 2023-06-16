package restassured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestAssuredDemo {

    @Test
    public void test1() {

        Response response = RestAssured.get("https://computer-database.gatling.io/computers");
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.prettyPrint());

//
//     RestAssured.baseURI = "http://computer-database.gatling.io/computers";


//            RequestSpecification httpRequest = RestAssured.given();
//
//            // specify the method type (GET) and the parameters if any.
//            //In this case the request does not take any parameters
//            Response response = httpRequest.request(Method.GET, "");
//
//            // Print the status and message body of the response received from the server
//            System.out.println("Status received => " + response.getStatusLine());
//            System.out.println("Response=>" + response.prettyPrint());
//            //System.out.println(response.header("ACE"));


//    //System.out.println(response.getStatusCode());
//            //System.out.println(response.getTime());
//            //System.out.println(response.getBody().asString());
//            RequestSpecification httpRequest = RestAssured.given();
//            httpRequest.request(Method.GET, "ibm");
//
//            System.out.println(response.getStatusLine());
//            System.out.println(response.prettyPrint());
//            //System.out.println(response.getHeader(""));
//
    }
}