/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;


import java.util.List;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author adao-
 */
public class TwitterFuncao {
        public void tweetar(Twitter twitter,String texto) throws TwitterException{
            Status status = twitter.updateStatus(texto);
        
        }
        public List<Status> Timeline(Twitter twitter) throws TwitterException{
        List<Status> statuses = twitter.getHomeTimeline();
       
         return statuses;
        }
        public void Timeline(Twitter twitter,String twitterID) throws TwitterException{
                  
          List<Status> statuses = twitter.getUserTimeline(twitterID);  
            for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" + status.getText());
            }
        }
   
}
