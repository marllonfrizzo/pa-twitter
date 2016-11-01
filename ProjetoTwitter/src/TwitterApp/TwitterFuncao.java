/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author adao-
 */
public class TwitterFuncao {
     int i = 0;
     User user;
     List<User> lista = null;
        public void tweetar(Twitter twitter,String texto) throws TwitterException{
            Status status = twitter.updateStatus(texto);
        
        }
        public List<Status> Timeline(Twitter twitter) {
        List<Status> statuses = null;
         try {
             statuses = twitter.getHomeTimeline();
         } catch (TwitterException ex) {
             Logger.getLogger(TwitterFuncao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return statuses;
        }
        public List<Status> Timeline(Twitter twitter,String twitterID) throws TwitterException  {
                 
          List<Status> statuses = null;  
   
        statuses = twitter.getUserTimeline(twitterID);
        
        return statuses;
        }
        
        public List<User> Seguidores(Twitter twitter) throws TwitterException {
         i=0;
         IDs ids = null;
         user=null;
         lista=new ArrayList<User>();
         
             ids = twitter.getFollowersIDs(twitter.users().toString(), -1);
              for ( long id : ids.getIDs()) {
           
                user = twitter.showUser(ids.getIDs()[i]);
                lista.add(user);
                i++;
       
          
        }
               return lista;
        }
        public List<User> Seguindo(Twitter twitter) throws TwitterException {
         lista=new ArrayList<User>();
            i=0;
          IDs ids = null;
                user=null;
     
             ids = twitter.getFriendsIDs(twitter.users().toString(), -1);
              for ( long id : ids.getIDs()) {
           
                user = twitter.showUser(ids.getIDs()[i]);
                lista.add(user);
               
                i++;
        }
           return lista; 
        }
        public void Seguir(Twitter twitter,String nome) throws TwitterException{

               twitter.createFriendship(nome);      
        }
         public void Deixar(Twitter twitter,String nome) throws TwitterException{

               twitter.destroyFriendship(nome);
        }
}