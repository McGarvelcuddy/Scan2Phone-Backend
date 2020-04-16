package Controllers;

import Views.AddCardView;

import org.bson.Document;
import org.json.JSONObject;

public class AddCardController {
    private LoginController logCon;
    private Document query;
    private JSONObject account;
    private AddCardView cardView;
    
    public AddCardController(LoginController logCon, Document query, JSONObject account){
        this.logCon = logCon;
        this.query = query;
        this.account = account;
        this.cardView = new AddCardView(this);
        cardView.setVisible(true);
    }
}