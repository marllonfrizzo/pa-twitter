/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import twitter4j.IDs;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 *
 * @author adao-
 */
public class Home extends javax.swing.JFrame {
    int i = 0;
    int controle=0;
    User usuarioconexao;
    static Twitter conexao;
    static Home home;
    URL urlImg;
    List <User> lista ;
    File arquivo = null;
 
    TwitterFuncao tweetar = new  TwitterFuncao();
    
    /**
     * Creates new form Home
     */
    public Home(Twitter twitter) throws TwitterException  {
        initComponents();
        conexao = twitter;
   
        PreencherTime();
       
        Nome();
        imagem(usuarioconexao);
<<<<<<< HEAD
     
=======
>>>>>>> origin/master
    }
    
    public void imagem(User user) {
        String ima = user.getBiggerProfileImageURL();
        // inicializa a imagem URL dentro de um objeto ImageIcon
        URL urlImg = null;
        try {
            urlImg = new URL(ima);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon imgIcon = new ImageIcon(urlImg);
        // faz o preload da imagem
        while (imgIcon.getImageLoadStatus() == MediaTracker.LOADING);

        // injeta o icone no label
        Jimagem.setIcon(imgIcon);
    }
    
    public void PreencherTime() {
        List<Status> statuses = null;
        statuses = tweetar.HomeTimeline(conexao);
        for (int i = 0; i < statuses.size(); i++) {
            Status status = statuses.get(i);
            Jtimeline.append(status.getUser().getName() + " : " + status.getText() + "\n");
        }
    }
    
    public void Nome() throws TwitterException {
        usuarioconexao = conexao.showUser(conexao.getScreenName());
        Jseguindo.setText("<html>Seguindo<br>" + usuarioconexao.getFriendsCount());
        Jseguidores.setText("<html>Seguidores<br>" + usuarioconexao.getFollowersCount());
        Jtweets.setText("<html>Tweets<br>" + usuarioconexao.getStatusesCount());
        Jnome.setText(usuarioconexao.getName());
        Jnome2.setText(usuarioconexao.getScreenName());
    }
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Jnome = new javax.swing.JLabel();
        Jtweets = new javax.swing.JButton();
        Jseguindo = new javax.swing.JButton();
        Jseguidores = new javax.swing.JButton();
        Jnome2 = new javax.swing.JLabel();
        Jimagem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jstatus = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtimeline = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jcarregafoto = new javax.swing.JLabel();
        jTimeline = new javax.swing.JButton();
        jTextUsuario = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Twitter for Java");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Jnome.setText("Nome");

        Jtweets.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Jtweets.setText("Tweets");
        Jtweets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtweetsActionPerformed(evt);
            }
        });

        Jseguindo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Jseguindo.setText("Seguindo");
        Jseguindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JseguindoActionPerformed(evt);
            }
        });

        Jseguidores.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Jseguidores.setText("Seguidor");
        Jseguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JseguidoresActionPerformed(evt);
            }
        });

        Jnome2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Jnome2.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jtweets, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Jseguindo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(Jseguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Jimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jnome2)
                            .addComponent(Jnome, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jnome, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Jnome2))
                    .addComponent(Jimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jtweets)
                    .addComponent(Jseguindo)
                    .addComponent(Jseguidores))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Jstatus.setColumns(20);
        Jstatus.setRows(5);
        jScrollPane1.setViewportView(Jstatus);

        jButton1.setText("Tweetar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jtimeline.setEditable(false);
        Jtimeline.setColumns(20);
        Jtimeline.setRows(5);
        jScrollPane2.setViewportView(Jtimeline);

        jButton4.setText("Foto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jcarregafoto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jTimeline.setText("Timeline");
        jTimeline.setEnabled(false);
        jTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTimeline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jcarregafoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcarregafoto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jTimeline)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        getAccessibleContext().setAccessibleName("Twitter for Java");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     if(controle==0){
  
         try {
             tweetar.tweetar(conexao, Jstatus.getText());
         } catch (TwitterException ex) {
             Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
         }
           JOptionPane.showMessageDialog(null, Jstatus.getText()+"  :Tweetado com sucesso ");
        
        Jtimeline.setText(" ");
        PreencherTime();
         try {
             Nome();
         } catch (TwitterException ex) {
             Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     }else{
   
         try {
             tweetar.imagem(conexao, arquivo, Jstatus.getText());
             JOptionPane.showMessageDialog(null, Jstatus.getText()+"  :Tweetado com sucesso ");
         } catch (TwitterException ex) {
             Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
         }
         jcarregafoto.setText(" ");
        controle=0;     
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JseguindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JseguindoActionPerformed
<<<<<<< HEAD
       
=======
>>>>>>> origin/master
        try {
            lista = tweetar.Seguindo(conexao, usuarioconexao);
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
<<<<<<< HEAD
             Jtimeline.setText(" " );
        for (i = 0; i < 5; i++) {
          User  user = lista.get(i);
              Jtimeline.append(user.getScreenName()+"\n");
=======
        //      jTextseguindo.setText(" " );
        for (i = 0; i < lista.size(); i++) {
            usuarioconexao = lista.get(i);
            //    jTextseguindo.append(user.getScreenName()+"\n");
>>>>>>> origin/master
        }
    }//GEN-LAST:event_JseguindoActionPerformed

    private void JseguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JseguidoresActionPerformed
       lista=null;
        try {
             lista=tweetar.Seguidores(conexao,usuarioconexao);
         } catch (TwitterException ex) {
             Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
         }
           Jtimeline.setText(" " );
        for(i=0;i<5;i++){
          User  user =lista.get(i);
        Jtimeline.append(user.getScreenName()+"\n");
        }
    }//GEN-LAST:event_JseguidoresActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        arquivo =tweetar.escolherArquivos();
        jcarregafoto.setText("Foto Carregada");
        controle=1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String nome = jTextUsuario.getText();
        User user = null;
        try {
            user = conexao.showUser(nome);
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TelaUsuario jc = new TelaUsuario(null, true);
        try {
            jc.PreencherTime(user);
            jc.Nome1(user);
            jc.imagem(user);
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jc.setVisible(true);
        
        try {
            Nome();
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void JtweetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtweetsActionPerformed
        Jtimeline.setText(" ");
        List<Status> statuses = null;
        statuses = tweetar.Timeline(conexao, usuarioconexao);
        for (int i = 0; i < statuses.size(); i++) {
            Status status = statuses.get(i);
            Jtimeline.append(status.getUser().getName() + " : " + status.getText() + "\n");
        }
        jTimeline.setEnabled(true);
    }//GEN-LAST:event_JtweetsActionPerformed

    private void jTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimelineActionPerformed
     PreencherTime();
     jTimeline.setEnabled(false);
    }//GEN-LAST:event_jTimelineActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    home  = new Home(conexao);
                } catch (TwitterException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
               home.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jimagem;
    private javax.swing.JLabel Jnome;
    private javax.swing.JLabel Jnome2;
    private javax.swing.JButton Jseguidores;
    private javax.swing.JButton Jseguindo;
    private javax.swing.JTextArea Jstatus;
    private javax.swing.JTextArea Jtimeline;
    private javax.swing.JButton Jtweets;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JButton jTimeline;
    private javax.swing.JLabel jcarregafoto;
    // End of variables declaration//GEN-END:variables
}
