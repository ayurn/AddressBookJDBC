import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class RestAssuredJsonTest {

        public Response getContactsList(){
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 3000;
            Response response = RestAssured.get("/contacts");
            return response;
        }

        @Test
        public void onCallingList_ReturnContactsList(){
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 3000;
            Response response = getContactsList();
            System.out.println("AT FIRST: " + response.asString());
            response.then().body("FirstName", Matchers.hasItem("Mark"));

        }
}
