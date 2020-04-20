package Controllers;

import Views.AddCardView;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import java.util.Map;

import org.bson.Document;

public class AddCardController {

    private LoginController logCon;
    private Document query;
    private DBObject account;
    private AddCardView cardView;
    private MongoCollection<BasicDBObject> collection;

    public AddCardController(LoginController logCon, Document query, DBObject account, MongoCollection<BasicDBObject> collection) {
        this.logCon = logCon;
        this.query = query;
        this.account = account;
        this.cardView = new AddCardView(this);
        this.collection = collection;
        cardView.setVisible(true);
    }

    public void addCardJSON(String scan, String type, String number) {
        String cardNumber = recursiveCheck(account.toString(), 1);

        BasicDBObject info = new BasicDBObject();
        info.append("scan", scan).append("type", type).append("cardNumber", number);

        BasicDBObject theCards = new BasicDBObject();
        Map map = account.toMap();
        BasicDBObject mapCards = (BasicDBObject) map.get("cards");
        mapCards.append(cardNumber, info);

        theCards.put("cards", map.get("cards"));

        account.put("cards", mapCards);

        collection.deleteOne(query);
        collection.insertOne((BasicDBObject) account);
    }

    private String recursiveCheck(String cards, Integer times) {
        String checkerNumb = "card" + times.toString();
        if (cards.contains(checkerNumb)) {
            return recursiveCheck(cards, times + 1);
        }
        return checkerNumb;
    }
    
    public void cancel(){
        cardView.setVisible(false);
        logCon.cancel();
    }
}
