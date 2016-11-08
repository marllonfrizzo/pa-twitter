package TwitterApp;

import java.io.IOException;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Main {

    static Home home;

    public static void main(String[] args) throws IOException, TwitterException {
        //direto
        
        /*TwitterConfiguration novo = new TwitterConfiguration();
        Twitter twitter = novo.conexao();
        home = new Home(twitter);
        home.setVisible(true);*/

        //automatico token
        
        TelaLogin novo;
        novo = new TelaLogin();
        novo.setVisible(true);
    }
}

