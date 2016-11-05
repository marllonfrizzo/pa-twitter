/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;


import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterConfiguration {
          private String consumerKey = "EwcxsvSwWO94YRGpN55Bc01xG" ;
          private  String consumerSecret = "d6kYAfnyhxkoWFNH3SqqxkzZ3D7SURWM0MV5OCKPytJmfFVD10";
          private String accessToken = "2169123428-3A3pt3L9tzSvokpcjzAepDZSCNjSK9UH0rHQKvT";
          private  String accessSecret = "UDhiprNLffVD0b3jiHyOUEeKW3YkHlFD9eLFLi8aUR23o";

          public Twitter conexao(){
             
           ConfigurationBuilder cb = new ConfigurationBuilder();

                cb.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessSecret);
                
                TwitterFactory factory = new TwitterFactory(cb.build());
		Twitter twitter = factory.getInstance();
                AccessToken accestoken = new AccessToken(accessToken, accessSecret);
                twitter.setOAuthAccessToken(accestoken);
         return twitter;
          }
}
