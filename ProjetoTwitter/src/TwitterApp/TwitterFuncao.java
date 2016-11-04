/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;


import static TwitterApp.Home.conexao;
import java.awt.MediaTracker;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resources;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.SuggestedUsersResources;

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
        
        public List<Status> HomeTimeline(Twitter twitter) {
        List<Status> statuses = null;
         try {
             statuses = twitter.getHomeTimeline();
         } catch (TwitterException ex) {
             Logger.getLogger(TwitterFuncao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return statuses;
        }
        public List<Status> Timeline(Twitter twitter,User user)  {
                 
          List<Status> statuses = null;  
   
         try {
             statuses = twitter.getUserTimeline(user.getId());
         } catch (TwitterException ex) {
              JOptionPane.showMessageDialog(null, "  :Não encontrado ");
         }
        
        System.out.println(statuses.size());
        
        return statuses;
        }
        
        public List<User> Seguidores(Twitter twitter,User usuario) throws TwitterException {
         i=0;
         IDs ids = null;
         user=null;
         lista=new ArrayList<User>();
         
             ids = twitter.getFollowersIDs(usuario.getId(), -1);
              for ( long id : ids.getIDs()) {
           
                user = twitter.showUser(ids.getIDs()[i]);
                lista.add(user);
                i++;
       
          
        }
               return lista;
        }
        public List<User> Seguindo(Twitter twitter,User usuario) throws TwitterException {
         lista=new ArrayList<User>();
            i=0;
          IDs ids = null;
           user=null;
     
             ids = twitter.getFriendsIDs(usuario.getId(), -1);
             
              for ( long id : ids.getIDs()) {
           
                user = twitter.showUser(ids.getIDs()[i]);
                lista.add(user);
               
                i++;
        }
           return lista; 
        }
        public void Seguir(Twitter twitter,String nome) throws TwitterException {

         twitter.createFriendship(nome);      
        }
          public void imagem(Twitter twitter,File file,String mensagem) throws TwitterException{
            
         
             StatusUpdate status = new StatusUpdate(mensagem);
            status.setMedia(file); // set the image to be uploaded here.
             twitter.updateStatus(status);       
        }
         public void Deixar(Twitter twitter,String nome) throws TwitterException{

               twitter.destroyFriendship(nome);
        }
        public File escolherArquivos(){
         File file = null;
        String arquivos  = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Escolha o(s) arquivo(s)...");
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setApproveButtonText("OK");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        int resultado = fc.showOpenDialog(fc);
        if (resultado == JFileChooser.CANCEL_OPTION){
            System.exit(1);
        }
        arquivos=fc.getSelectedFile().getAbsolutePath();
        file=new File(arquivos);
        //arquivos = fc.getSelectedFiles();
        return file;
    }
   
       
}