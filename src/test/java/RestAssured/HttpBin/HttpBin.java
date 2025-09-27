package RestAssured.HttpBin;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class HttpBin {
    HashMap<String, String> data = new HashMap<>();

    // Set base URI once for all requests (static)
    static {
        RestAssured.baseURI = "https://httpbin.org";
    }

    @Test(priority = 0)
    public void getWeatherDetails() {
        given().
                when().
                get("/get").
                then().
                assertThat().statusCode(200).
                body("url", equalTo("https://httpbin.org/get"));
    }

    @Test(priority = 1, dependsOnMethods = {"getWeatherDetails"})
    public void postWeatherDetails() {
        // Define request data inline
    //    HashMap<String, String> data = new HashMap<>();
        data.put("name", "test");
        data.put("city", "leader");

        given().
                basePath("/post").
                contentType("application/json").
                body(data).
                when().
                post().
                then().
                assertThat().statusCode(200).
               body("json.name", equalTo("test")).
                body("json.city", equalTo("leader"));
    }

    @Test(priority = 3)
    public void Delete() {
        //data.put("name", "test1");

        given().
                basePath("/delete").
                contentType("application/json").
             //   body(data).
                when().
                delete().
                then().
                assertThat().statusCode(200);
    }
}


