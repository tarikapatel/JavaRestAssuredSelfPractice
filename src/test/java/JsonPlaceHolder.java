import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {
//    Test endpoint https://jsonplaceholder.typicode.com/todos/29
//    verify that it returns status code 200
//    verify that title is "title": "laborum aut in quam"
//    verify that completed is false using  "completed": false

    @Test
    public void verify_getPosts_byIdId(){

        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("todos")
                .when()
                .get("29" );
        //verify that it returns status code 200
        System.out.println(response.statusCode());
        Assert.assertEquals(200, response.statusCode());

        // System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();

        //verify that title is "title": "laborum aut in quam"
        System.out.println(responseJson.getString("title"));
        Assert.assertEquals("laborum aut in quam", responseJson.getString("title"));

        //verify that completed is false using  "completed": false
        System.out.println(responseJson.getString("completed"));
        Assert.assertEquals("false", responseJson.getString("completed"));

    }

//   Homework 2: - Test api endpoint https://jsonplaceholder.typicode.com/users/5
//    verify that status code is success
//    verify that name": "Chelsey Dietrich"
//    verify that "street": "Skiles Walks"
//    verify that lat": "-31.8129"
//    verify that "catchPhrase": "User-centric fault-tolerant solution"

    @Test
    public void verify_getPosts_byIdTwo(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("users")
                .when()
                .get("5" );
        //verify that status code is success
        Assert.assertEquals(200, response.statusCode());

       // System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();
        // verify that "id" : 5
        Assert.assertEquals(5, responseJson.getInt("id"));

        //verify that "name": "Chelsey Dietrich"
        System.out.println(responseJson.getString("name"));
        Assert.assertEquals("Chelsey Dietrich", responseJson.getString("name"));

        //verify that "street": "Skiles Walks"
        System.out.println(responseJson.getString("address.street"));
        Assert.assertEquals("Skiles Walks",responseJson.getString("address.street"));

        //verify that lat": "-31.8129"
        System.out.println(responseJson.getString("address.geo.lat"));
        Assert.assertEquals("-31.8129",responseJson.getString("address.geo.lat"));

        //verify that "catchPhrase": "User-centric fault-tolerant solution"
        System.out.println(responseJson.getString("company.catchPhrase"));
        Assert.assertEquals("User-centric fault-tolerant solution",responseJson.getString("company.catchPhrase"));
    }

//    Homework 3 - Test api endpoint https://jsonplaceholder.typicode.com/posts/15
//    verify title using value  "userId": 2
//    verify userid using value "title": "eveniet quod temporibus"
    @Test
    public void verify_getPosts_byId(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .basePath("posts")
                .when()
                .get("15" );
      //  Assert.assertEquals(200, response.statusCode());

        System.out.println(response.body().asString());
        JsonPath responseJson = response.getBody().jsonPath();

        //verify title using value  "userId": 2
        System.out.println(responseJson.getInt("userId"));
        Assert.assertEquals(2, responseJson.getInt("userId"));

        //verify userid using value "title": "eveniet quod temporibus"
        System.out.println(responseJson.getString("title"));
        Assert.assertEquals("eveniet quod temporibus", responseJson.getString("title"));

    }


}
