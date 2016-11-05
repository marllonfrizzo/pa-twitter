/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;


import java.util.Scanner;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;


public class Configuraautomatico {
          private String consumerKey = "EwcxsvSwWO94YRGpN55Bc01xG" ;
          private  String consumerSecret = "d6kYAfnyhxkoWFNH3SqqxkzZ3D7SURWM0MV5OCKPytJmfFVD10";
                       
          public String conexao(Twitter twitter) throws TwitterException{
              internet acessar = new internet();
              Scanner entrada = new Scanner(System.in);
              String url;
              // Twitter twitter = new TwitterFactory().getInstance();
                 twitter.setOAuthConsumer(consumerKey ,consumerSecret);
                RequestToken requestToken = twitter.getOAuthRequestToken();
                AccessToken accessToken = null;
                System.out.println("Open the following URL and grant access to your account:");
                url = requestToken.getAuthorizationURL();
                System.out.println(url);
              //  novo = new TelaLogin(url);
              //  novo.setVisible(true);
                /*
                System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
                String pin = entrada.nextLine();
                accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                System.out.println(accessToken.getToken());
                System.out.println(accessToken.getTokenSecret());
                
                ConfigurationBuilder cb = new ConfigurationBuilder();

                cb.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken.getToken())
		.setOAuthAccessTokenSecret(accessToken.getTokenSecret());
                
                TwitterFactory factory = new TwitterFactory(cb.build());
		twitter = factory.getInstance();
                
                twitter.setOAuthAccessToken(accessToken);
                    */
                  return url;
       
          }
}
