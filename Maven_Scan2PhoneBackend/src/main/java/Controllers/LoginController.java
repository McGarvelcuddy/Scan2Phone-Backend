package Controllers;

import Views.LoginView;
import org.json.simple.JSONObject;

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.MongoClients;



public class LoginController {
    private JSONObject account;
    private LoginView loginView;
    
    
    MongoClient mongoClient = MongoClients.create(
        "mongodb+srv://Revengers:Scan2Phone@scan2phone-db-9rmmz.mongodb.net/test?retryWrites=true&w=majority");
    MongoDatabase database = mongoClient.getDatabase("Accounts");
    MongoCollection<org.bson.Document> collection = database.getCollection("JSON-Accounts");

    Block<Document> printBlock = new Block<Document>() {
     @Override
     public void apply(final Document document) {
         System.out.println(document.toJson());
     }
    };
    public LoginController(){
        loginView = new LoginView(this);
        
        loginView.setVisible(true);
    }

    /**
     * 
     * @param uName
     * @param password
     * 
     * https://www.tutorialspoint.com/json/json_java_example.htm
     * 
     */
    public void accountSelect(String uName, String password){
        System.out.println(collection.countDocuments());
        //collection.find().forEach(printBlock);
        //collection.find(new Document()).forEach(printBlock);
        
        
    }
    
    public void beginAddCard(){

    }
    
    
    
}