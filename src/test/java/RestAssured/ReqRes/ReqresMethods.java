package RestAssured.ReqRes;


import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class ReqresMethods {

    private static final Logger log = LoggerFactory.getLogger(ReqresMethods.class);
    String id =""  ;
    static {
        baseURI = "https://reqres.in/api";

    }

    @Test(priority = 1)

public void getTest01() {
        Response response = given()
                .accept(ContentType.JSON)
                .headers("x-api-key" ,"reqres-free-v1")
                .when()
                .get("/users")
                .then().extract().response();

        response.prettyPrint();
        response.equals(200);
    }
        @Test (priority = 2)
        public void postTest01() {
        //    JSONObject jsonData = new JSONObject();
            System.out.println("---------------Post----------");
            HashMap <String,String> jsonData = new HashMap <String,String>();
            jsonData.put("name", "Prachi");
            jsonData.put("Job", "Developer");

            Response response
            = given()
                    .accept(ContentType.JSON)
                    .headers("x-api-key" ,"reqres-free-v1")
                    .contentType(ContentType.JSON)
                    .body(jsonData)
                    .when()
                    .post("/users")
                    .then().extract().response();
            response.equals(201);
            response.prettyPrint();
           id =     response.jsonPath().get("id");
            System.out.println("Created User ID: " + id);
        }
//    int id ;
    @Test (priority = 3)
    public void putTest01() {
        System.out.println("---------------Put----------");
        HashMap <String,String> jsonData = new HashMap <String,String>();
        jsonData.put("name", "Prachi");
        jsonData.put("Job", "Senior Developer");
       // Response response =
                 given()
                .accept(ContentType.JSON)
                .headers("x-api-key" ,"reqres-free-v1")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .put("/users/" + id)
                .then().statusCode(200).log().all();

            //    .then().extract().response();
           //     response.;
     //   response.prettyPrint();
    }

    @Test (priority = 4, enabled = false)
    public void getTest02()  {
        System.out.println("---------------GetUpdatedData----------");

        //Response response =
                 given()
                .accept(ContentType.JSON)
                .headers("x-api-key" ,"reqres-free-v1")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then().statusCode(202);
                //extract().response();
                //response.equals(202);
        //response.prettyPrint();
    }

    @Test (priority = 5)
    public void deleteTest02()  {
        System.out.println("---------------Deleted data----------");

                given()
                .accept(ContentType.JSON)
                .headers("x-api-key" ,"reqres-free-v1")
                .contentType(ContentType.JSON)
                .when()
                .delete("/users/" + id)
                .then().log().all().statusCode(204);
    }



}

