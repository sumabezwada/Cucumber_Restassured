package stepdefs;


import AdvancedComplexpostobjects.Information;
import PostObjects.Info;
import PostObjects.Posts;
import PostObjects._Post;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class Execution_Tests {
@Test
public void postMethodDynamicCreateStation()
{
    RestAssured.baseURI="http://api.openweathermap.org";

    Response response=  given().log().all().header("Content-Type","application/json").queryParam("appid","59f9976a07d3a1217d26a43b5dbea6b5")
     .body(Payload.createstation("stationyyy"))
            .when()
           .post("/data/3.0/stations").then().assertThat().statusCode(201).extract().response();
    JsonPath jsonPath = new JsonPath(response.getBody().asString());
    String ID = jsonPath.getString("ID");
    System.out.println("ID is "+ID);
}

    @Test
    public void postMethodstaticCreateStation()
    {
        RestAssured.baseURI="http://api.openweathermap.org";

        Response response=  given().log().all().header("Content-Type","application/json").queryParam("appid","59f9976a07d3a1217d26a43b5dbea6b5")
                .body(Payload.createstaticstation())
                .when()
                .post("/data/3.0/stations").then().assertThat().statusCode(201).extract().response();
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        String ID = jsonPath.getString("ID");
        System.out.println("ID is "+ID);
    }

    @Test
    public void getStationById()
    {
        RestAssured.baseURI="http://api.openweathermap.org";
       String resp=given().log().all().header("Content-Type","application/json").queryParam("appid","59f9976a07d3a1217d26a43b5dbea6b5")
               .when().get("/data/3.0/stations/5e94735dcca8ce0001f1aad1") .then().statusCode(200).extract().response().asString();
        JsonPath jsonPath = new JsonPath(resp);
        String external_id = jsonPath.getString("external_id");
        String name = jsonPath.getString("name");
        System.out.println("Name is "+name);
        System.out.println("External id  is "+external_id);
    }
    @Test
    public void stationupdate()
    {
        RestAssured.baseURI="http://api.openweathermap.org";
        Response resp=given().log().all().header("Content-Type","application/json").queryParam("appid","59f9976a07d3a1217d26a43b5dbea6b5")
         .body(Payload.updateStation()) .when().put("/data/3.0/stations/5e9471f1cca8ce0001f1aad0") .then().statusCode(200).extract().response();
        JsonPath jsonPath = new JsonPath(resp.getBody().asString());
        String ID = jsonPath.getString("ID");
        System.out.println("ID is "+ID);
    }

    @Test
    public void deletesatation()
    {
        RestAssured.baseURI="http://api.openweathermap.org";
        Response resp=given().log().all().header("Content-Type","application/json").queryParam("appid","59f9976a07d3a1217d26a43b5dbea6b5")
        .body(Payload.updateStation()).when().delete("/data/3.0/stations/5e81a48ccca8ce0001f1a9b5").then().assertThat().statusCode(204).extract().response();
    }

    @Test
    public void complexjson()
    {
        //Display circuit id from al occurances
    RestAssured.baseURI="http://ergast.com/";
    String resp= given().log().all().header("Content-Type","application/json").when().get("api/f1/2017/circuits.json").then().statusCode(200).extract().response().asString();
    JsonPath js= new JsonPath(resp);
    int count=js.getInt("MRData.CircuitTable.Circuits.size()");
    System.out.println("count is "+count);
    for(int i = 0; i<count; i++)
    {
       String title=js.getString("MRData.CircuitTable.Circuits["+i+"].circuitId");
       if(title.equals("albert_park"))
       {
           String circuit=js.getString("MRData.CircuitTable.Circuits["+i+"].circuitName");
           System.out.println("Circuit name  is " +circuit);
           break;
       }

    }
    }

    @Test
    public void Addbook()
    {
        RestAssured.baseURI="http://216.10.245.166";
       String resp= given().log().all().header("Content-Type","application/json").body("Payload.addbook()").when().post("/Library/Addbook.php").then().statusCode(200).extract().response().asString();
       JsonPath js = new JsonPath(resp);
       String id=js.getString("ID");
    }
    @Test
    public void postobjects()
    {
        Posts posts= new Posts();
        posts.setId("4");
        posts.setTitle("title of the book1");
        posts.setAuthor("fourth author");
     String resp=   given().header("Content-Type","application/json").body(posts).when().post("http://localhost:3000/posts").then().statusCode(201).extract().response().asString();
     System.out.println("resposne is " +resp);
    }

    @Test
    public void complexpostobjects()
    {
        Info info= new Info();
        info.setEmail("suma.bez@gmail.com");
        info.setPhone("3456789056");
        info.setAddress("this is the updated address");
        _Post post=new _Post();
        post.setId("7");
        post.setAuthor("auhtor ");
        post.setTitle("this is the updated title ");
        post.setinfo(info);
       String response= given().header("Content-Type","application/json").body(post).when().post("http://localhost:3000/posts").then().extract().response().asString();
        System.out.println("response is " +response);
    }

    @Test
    public void advancedcomplexobjects_arrays()
    {
        Information info= new Information();
        info.setEmail("suma.bez@gmail.com");
        info.setPhone("3456789056");
        info.setAddress("this is the updated address");

        Information info1= new Information();
        info1.setEmail("latha@gmail.com");
        info1.setPhone("3456789056");
        info1.setAddress("this is the updated address");

        Information info2= new Information();
        info1.setEmail("abc@gmail.com");
        info1.setPhone("34567ff89056");
        info1.setAddress("this is the updated addresses");


        AdvancedComplexpostobjects._Post post = new AdvancedComplexpostobjects._Post();
        post.setId("11");
        post.setAuthor("author ");
        post.setTitle("This s seventh title ");
        post.setInfo(new Information[]{info,info1,info2});
        String response= given().header("Content-Type","application/json").body(post).when().post("http://localhost:3000/posts").then().extract().response().asString();
        System.out.println("response is " +response);

    }

    @Test
    public void advancedJsonPath()
    {
 //https://github.com/json-path/JsonPath
 //http://jsonviewer.stack.hu/
    }
}
