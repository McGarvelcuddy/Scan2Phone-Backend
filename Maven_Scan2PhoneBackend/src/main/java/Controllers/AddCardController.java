package Controllers;

import Views.AddCardView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddCardController {
    private LoginController logCon;
    private Document query;
    private DBObject account;
    private AddCardView cardView;
    
    public AddCardController(LoginController logCon, Document query, DBObject account){
        this.logCon = logCon;
        this.query = query;
        this.account = account;
        this.cardView = new AddCardView(this);
        cardView.setVisible(true);
    }
    
    public void addCardJSON(String scan, String type, String number){
        
        String cardNumber = recursiveCheck(account.toString(), 1);
        
        BasicDBObject info = new BasicDBObject();
        info.append("scan", scan).append("type", type).append("cardNumber", number);
        
        BasicDBObject theCards = new BasicDBObject();
        
        Map map = account.toMap();
        
        BasicDBObject mapCards = (BasicDBObject) map.get("cards");
        mapCards.append(cardNumber, info);
        System.out.println(mapCards);
        
        theCards.put("cards" , map.get("cards"));
        
        account.put("cards", mapCards);
        System.out.println(account.toString());
        
    }
    
    private String recursiveCheck(String cards, Integer times){
        String checkerNumb = "card" + times.toString();
        if (cards.indexOf(checkerNumb.toString()) != -1){
            return recursiveCheck(cards, times+1);
        }
        return checkerNumb;
    }
}