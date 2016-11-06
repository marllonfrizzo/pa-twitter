/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;
    
import java.io.IOException;
import java.util.Scanner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class Main {

    static Home home;

    public static void main(String[] args) throws IOException, TwitterException {
        //direto
        TwitterConfiguration novo = new TwitterConfiguration();

        Twitter twitter = novo.conexao();
        home = new Home(twitter);
        home.setVisible(true);

        //automatico token
        /*TelaLogin novo;
        novo = new TelaLogin();
        novo.setVisible(true);*/
        
        //JOptionPane.showMessageDialog(null, "Falha ao tentar logar.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}

