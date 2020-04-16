package Controllers;

import Views.LoginView;



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
import org.json.*;



public class LoginController {
    private LoginView loginView;
    Document query;
    JSONObject account;
    private AddCardController addCardController;
    
    
    //https://mongodb.github.io/mongo-java-driver/4.0/driver/getting-started/quick-start/
    
    
    
    MongoClient mongoClient = MongoClients.create(
        "mongodb+srv://Revengers:Scan2Phone@scan2phone-db-9rmmz.mongodb.net/test?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("Accounts");
    MongoCollection<org.bson.Document> collection = database.getCollection("JSON-Accounts");

    
    public LoginController(){
        loginView = new LoginView(this);
        
        loginView.setVisible(true);
    }

    public void accountSelect(String uName, String password){
        
        query = new Document("username", uName)
            .append("password", password);
        
        //Document doc = collection.find(query);
        
        //System.out.println("output (JSON) = " + com.mongodb.BasicDBObject.parse(doc.toJson()));
        List results = new ArrayList<>();
        collection.find(query).into(results);
        System.out.println(results);
        System.out.println(results.get(0).getClass());
        
        Document doc = (Document) results.get(0);
        
        System.out.println(doc.toJson().getClass());
        
        System.out.println("output (JSON) = " + com.mongodb.BasicDBObject.parse(doc.toJson()));
        
        String jsonString = doc.toJson();
        try{
            account = new JSONObject(jsonString);
            
            String scan1 = account.getJSONObject("cards").getJSONObject("card1").getString("scan");
            
            System.out.println(scan1);
            
        }catch(JSONException je){
            System.out.println(je + " Whoops, The credentials don't appear to exist.");
        }
        
        Boolean correctLogin = true; //TESTING PURPOSES
        if(correctLogin){
            beginAddCard();
            
        }
    }
    
    public void beginAddCard(){
        loginView.setVisible(false);
        addCardController = new AddCardController(this, query, account);
        
    }
    
    
    
}