package stepdefs;

public class Payload {


    public static String createstation(String name)
    {
     String payload=   "{\n" +
                "    \"external_id\": \"SF_TEST00\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"latitude\": 37.76,\n" +
                "    \"longitude\": -122.43,\n" +
                "    \"altitude\": 150\n" +
                "}";
     return payload;
    }

    public static String updateStation() {
        String payload="{\n" +
                "    \"external_id\": \"SF_TEST00\",\n" +
                "    \"name\": \"San Francimgiiiiiggmmsvvco Test Station\",\n" +
                "    \"latitude\": 37.76,\n" +
                "    \"longitude\": -122.43,\n" +
                "    \"altitude\": 150\n" +
                "}";

        return payload;
    }

    public static String addbookpayload(String isbn) {


     String payload   ="{\n" +
                "\n" +
                "\"name\":\"Learn Aprrrpkkdffium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\"2855d27\",\n" +
                "\"author\":\"Jffffodhnkk foe\"\n" +
                "}\n" +
                " \n";

     return payload;
    }
    public static String addbook()

    {
        String body_req="{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bczgjd\",\n" +
                "\"aisle\":\"22578\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n" +
                " ";
        return body_req;
    }

    public static String createstaticstation() {

        String body_static="{\n" +
                "    \"external_id\": \"SF_TEST00\",\n" +
                "    \"name\": \"station1\",\n" +
                "    \"latitude\": 37.76,\n" +
                "    \"longitude\": -122.43,\n" +
                "    \"altitude\": 150\n" +
                "}";
        return body_static;
    }
}
