package Controllers;

import Views.LoginView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.MongoClients;
import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import java.util.Map;
import org.apache.camel.component.mongodb.converters.MongoDbBasicConverters;
import org.json.*;

public class LoginController {

    private LoginView loginView;
    Document query;
    BasicDBObject account;
    private AddCardController addCardController;

    //https://mongodb.github.io/mongo-java-driver/4.0/driver/getting-started/quick-start/
    MongoClient mongoClient = MongoClients.create(
            "mongodb+srv://Revengers:Scan2Phone@scan2phone-db-9rmmz.mongodb.net/test?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("Accounts");
    MongoCollection<BasicDBObject> collection = database.getCollection("JSON-Accounts", BasicDBObject.class);

    public LoginController() {
        loginView = new LoginView(this);

        loginView.setVisible(true);
    }

    public void accountSelect(String uName, String password) throws JSONException {

        query = new Document("username", uName)
                .append("password", password);

        //Document doc = collection.find(query);
        //System.out.println("output (JSON) = " + com.mongodb.BasicDBObject.parse(doc.toJson()));
        List results = new ArrayList<BasicDBObject>();
        collection.find(query).into(results);
        if (results.isEmpty()) {
            System.out.println("No record found");
            loginView.failedLogin();

        } else {
            this.account = (BasicDBObject) results.get(0);
            // this.account = fromAnyObjectToDBObject(results.get(0));

            String jsonString = account.toString();

            System.out.println(jsonString);

            beginAddCard();
        }
    }

    public void beginAddCard() {
        loginView.setVisible(false);
        addCardController = new AddCardController(this, query, account);

    }
    
    
    public static DBObject fromAnyObjectToDBObject(Object value){
        BasicDBObject answer;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map m = objectMapper.convertValue(value,Map.class);
            answer = new BasicDBObject(m);
        }catch (  Exception e) {
            System.out.println("Conversion has fallen back to generic Object -> DBObject, but unable to convert type {}. Returning null.");
            return null;
        }
        return answer;
    }
}
