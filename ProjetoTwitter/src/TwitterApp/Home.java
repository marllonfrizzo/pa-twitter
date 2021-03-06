package TwitterApp;

import java.awt.MediaTracker;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import twitter4j.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

public class Home extends javax.swing.JFrame {

    int i = 0;
    int controle = 0;
    User usuarioconexao;
    static Twitter conexao;
    static Home home;
    URL urlImg;
    List<User> lista;
    File arquivo = null;
    
    private Trend trend[];
    private Date trendAt;

    TwitterFuncao tweetar = new TwitterFuncao();

    /**
     * Creates new form Home
     */
    public Home(Twitter twitter) throws TwitterException {
        initComponents();
        conexao = twitter;
        PreencherTime();
        Nome();
        imagem(usuarioconexao);
        jButtonDetalhar.setEnabled(false);
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

        Jtimeline.setText("");
        statuses = tweetar.HomeTimeline(conexao);
        for (int i = 0; i < statuses.size(); i++) {
            Status status = statuses.get(i);
            Jtimeline.append(status.getUser().getName() + ": " + status.getText() + "\n\n");
        }
        Jtimeline.setCaretPosition(0);
    }

    public void Nome() throws TwitterException {
        usuarioconexao = conexao.showUser(conexao.getScreenName());
        Jseguindo.setText("<html>Seguindo<br>" + usuarioconexao.getFriendsCount());
        Jseguidores.setText("<html>Seguidores<br>" + usuarioconexao.getFollowersCount());
        Jtweets.setText("<html>Tweets<br>" + usuarioconexao.getStatusesCount());
        Jnome.setText(usuarioconexao.getName());
        Jnome2.setText("@" + usuarioconexao.getScreenName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTimeline = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jstatus = new javax.swing.JTextArea();
        jButtonTweetar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtimeline = new javax.swing.JTextArea();
        jButtonFoto = new javax.swing.JButton();
        jcarregafoto = new javax.swing.JLabel();
        jTimeline = new javax.swing.JButton();
        jPanelPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jPanelPerfil = new javax.swing.JPanel();
        Jnome = new javax.swing.JLabel();
        Jtweets = new javax.swing.JButton();
        Jseguindo = new javax.swing.JButton();
        Jseguidores = new javax.swing.JButton();
        Jnome2 = new javax.swing.JLabel();
        Jimagem = new javax.swing.JLabel();
        jPanelTrendings = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaTrendings = new javax.swing.JTextArea();
        jButtonTrendings = new javax.swing.JButton();
        jButtonDetalhar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Twitter for Java");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanelTimeline.setBorder(javax.swing.BorderFactory.createTitledBorder("Timeline"));

        Jstatus.setColumns(20);
        Jstatus.setLineWrap(true);
        Jstatus.setRows(5);
        jScrollPane1.setViewportView(Jstatus);

        jButtonTweetar.setText("Tweetar");
        jButtonTweetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTweetarActionPerformed(evt);
            }
        });

        Jtimeline.setEditable(false);
        Jtimeline.setColumns(20);
        Jtimeline.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        Jtimeline.setLineWrap(true);
        Jtimeline.setRows(5);
        jScrollPane2.setViewportView(Jtimeline);

        jButtonFoto.setText("Foto");
        jButtonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFotoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelTimelineLayout = new javax.swing.GroupLayout(jPanelTimeline);
        jPanelTimeline.setLayout(jPanelTimelineLayout);
        jPanelTimelineLayout.setHorizontalGroup(
            jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimelineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTimelineLayout.createSequentialGroup()
                        .addComponent(jTimeline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jcarregafoto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTweetar)))
                .addContainerGap())
        );
        jPanelTimelineLayout.setVerticalGroup(
            jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimelineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonTweetar)
                        .addGroup(jPanelTimelineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFoto)
                            .addComponent(jTimeline)))
                    .addComponent(jcarregafoto, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanelPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jLabel1.setText("Pesquisar Usuários:");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPesquisaLayout = new javax.swing.GroupLayout(jPanelPesquisa);
        jPanelPesquisa.setLayout(jPanelPesquisaLayout);
        jPanelPesquisaLayout.setHorizontalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPesquisar)
                .addContainerGap())
        );
        jPanelPesquisaLayout.setVerticalGroup(
            jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanelPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Meu Perfil"));

        Jnome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Jnome.setText("Nome");

        Jtweets.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Jtweets.setText("Tweets");
        Jtweets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtweetsActionPerformed(evt);
            }
        });

        Jseguindo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Jseguindo.setText("Seguindo");
        Jseguindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JseguindoActionPerformed(evt);
            }
        });

        Jseguidores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Jseguidores.setText("Seguidor");
        Jseguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JseguidoresActionPerformed(evt);
            }
        });

        Jnome2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Jnome2.setText("@usuario");

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Jtweets, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jseguindo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jseguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPerfilLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Jimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jnome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        jPanelPerfilLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Jseguidores, Jseguindo, Jtweets});

        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Jnome)
                        .addGap(4, 4, 4)
                        .addComponent(Jnome2))
                    .addComponent(Jimagem, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jtweets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jseguindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jseguidores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jPanelTrendings.setBorder(javax.swing.BorderFactory.createTitledBorder("Trendings"));

        jTextAreaTrendings.setEditable(false);
        jTextAreaTrendings.setColumns(20);
        jTextAreaTrendings.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextAreaTrendings.setRows(5);
        jTextAreaTrendings.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setViewportView(jTextAreaTrendings);

        jButtonTrendings.setText("Trendings");
        jButtonTrendings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrendingsActionPerformed(evt);
            }
        });

        jButtonDetalhar.setText("Detalhar");
        jButtonDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTrendingsLayout = new javax.swing.GroupLayout(jPanelTrendings);
        jPanelTrendings.setLayout(jPanelTrendingsLayout);
        jPanelTrendingsLayout.setHorizontalGroup(
            jPanelTrendingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrendingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTrendingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanelTrendingsLayout.createSequentialGroup()
                        .addComponent(jButtonTrendings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDetalhar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelTrendingsLayout.setVerticalGroup(
            jPanelTrendingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTrendingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTrendingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTrendings)
                    .addComponent(jButtonDetalhar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTrendings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelTrendings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        String nome = jTextUsuario.getText();

        /* Valida se o usuário digitou alguma coisa no campo pesquisar */
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite um usuário para pesquisar!");
        } else {
            User user = null;
            try {
                user = conexao.showUser(nome);
                try {
                    TelaUsuario jc = new TelaUsuario(null, true);
                    jc.PreencherTime(user);
                    jc.Nome1(user);
                    jc.imagem(user);
                    jc.setVisible(true);
                    Nome();
                } catch (TwitterException ex) {
                    JOptionPane.showMessageDialog(null, "Falha em preencher os dados!");
                }
            } catch (TwitterException ex) {
                JOptionPane.showMessageDialog(null, "Usuário Inexistente!");
            }
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimelineActionPerformed
        PreencherTime();
        jTimeline.setEnabled(false);
    }//GEN-LAST:event_jTimelineActionPerformed

    private void jButtonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFotoActionPerformed
        arquivo = tweetar.escolherArquivos();
        if (arquivo != null) {
            jcarregafoto.setText("Foto Carregada");
            controle = 1;
        } else {
            jcarregafoto.setText("");
            controle = 0;
        }
    }//GEN-LAST:event_jButtonFotoActionPerformed

    private void jButtonTweetarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTweetarActionPerformed
        if (controle == 0) {
            try {
                /* Valida se o usuário digitou algo no campo para twettar */
                if (Jstatus.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite alguma coisa para poder Tweetar!");
                } else {
                    tweetar.tweetar(conexao, Jstatus.getText());
                    JOptionPane.showMessageDialog(null, "Tweetado com sucesso!");
                    Jstatus.setText("");
                }
            } catch (TwitterException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Tweetar!");
                //Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                tweetar.imagem(conexao, arquivo, Jstatus.getText());
                JOptionPane.showMessageDialog(null, "Foto tweetada com sucesso!");
            } catch (TwitterException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tweetar a foto!");
                //Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            jcarregafoto.setText("");
            controle = 0;
        }

        Jtimeline.setText("");
        PreencherTime();
        try {
            Nome();
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTweetarActionPerformed

    private void jButtonTrendingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrendingsActionPerformed
        try {
            jButtonDetalhar.setEnabled(true);
            Integer woeid = 0;
            String retorno = JOptionPane.showInputDialog("Informe o valor do WOEID da localidade\nDeixe vazio para usar o Brasil"
                    + " ou use 1 para Global");

            if (retorno == null) {
                jButtonDetalhar.setEnabled(false);
            } else {
                if (retorno.isEmpty()) {
                    woeid = 23424768;
                } else {
                    woeid = Integer.valueOf(retorno);
                }

                Trends trends = conexao.getPlaceTrends(woeid);
                trend = trends.getTrends();
                trendAt = trends.getTrendAt();
                Location local = trends.getLocation();

                jTextAreaTrendings.setText("Assuntos do Momento: " + local.getName() + "\n\n");
                jTextAreaTrendings.setCaretPosition(0);

                SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy, HH:mm");

                for (int j = 0; j < 10; j++) {
                    jTextAreaTrendings.append(j+1+". "+dt.format(trendAt) + ": " + trend[j].getName() + "\n");
                }
            }
        } catch (TwitterException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao captar os Trends!");
        }
    }//GEN-LAST:event_jButtonTrendingsActionPerformed

    private void JseguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JseguidoresActionPerformed
        lista = null;
        try {
            lista = tweetar.Seguidores(conexao, usuarioconexao);
            Jtimeline.setText("Últimos 5 Seguidores de " + usuarioconexao.getScreenName() + "\n\n");
            for (i = 0; i < 5; i++) {
                User user = lista.get(i);
                Jtimeline.append(user.getScreenName() + "\n");
            }
            jTimeline.setEnabled(true);
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JseguidoresActionPerformed

    private void JseguindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JseguindoActionPerformed
        try {
            lista = tweetar.Seguindo(conexao, usuarioconexao);
            Jtimeline.setText("Últimos 5 usuários seguidos\n\n");
            for (i = 0; i < 5; i++) {
                User user = lista.get(i);
                Jtimeline.append(user.getScreenName() + "\n");
            }
            jTimeline.setEnabled(true);
        } catch (TwitterException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JseguindoActionPerformed

    private void JtweetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtweetsActionPerformed
        Jtimeline.setText("");
        List<Status> statuses = null;
        try {
            statuses = tweetar.Timeline(conexao, usuarioconexao);
        } catch (TwitterException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir a Timeline!");
        }
        for (int i = 0; i < statuses.size(); i++) {
            Status status = statuses.get(i);
            Jtimeline.append(status.getUser().getName() + " : " + status.getText() + "\n");
        }
        Jtimeline.setCaretPosition(0);
        jTimeline.setEnabled(true);
    }//GEN-LAST:event_JtweetsActionPerformed

    private void jButtonDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalharActionPerformed
        String retorno = JOptionPane.showInputDialog("Informe a posição do TT");
        if (retorno == null) {
            // Não faça nada
        } else if (retorno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite algo!");
            jButtonDetalhar.doClick();
        } else {
            jTimeline.setEnabled(true);
            try {
                Jtimeline.setText("");
                Query query = new Query(trend[Integer.parseInt(retorno) - 1].getQuery());
                QueryResult result = conexao.search(query);

                for (Status status : result.getTweets()) {
                    Jtimeline.append(status.getUser().getScreenName() + ": " + status.getText() + "\n\n");
                }
                Jtimeline.setCaretPosition(0);
            } catch (TwitterException ex) {
                JOptionPane.showMessageDialog(null, "Deu ruim!");
            }
        }
    }//GEN-LAST:event_jButtonDetalharActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Twitter for Java\n"
                + "Programação de Aplicativos - UTFPR-CM, 2016\nAdão Ribeiro, Marllon Frizzo, Ramon Fanti");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
                    home = new Home(conexao);
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
    private javax.swing.JButton jButtonDetalhar;
    private javax.swing.JButton jButtonFoto;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonTrendings;
    private javax.swing.JButton jButtonTweetar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JPanel jPanelPesquisa;
    private javax.swing.JPanel jPanelTimeline;
    private javax.swing.JPanel jPanelTrendings;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaTrendings;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JButton jTimeline;
    private javax.swing.JLabel jcarregafoto;
    // End of variables declaration//GEN-END:variables
}
