/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterApp;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author adao-
 */
public class internet {
    
    public void acessa(String url){
      Desktop desktop = null;
        if (!Desktop.isDesktopSupported())
        throw new IllegalStateException("Não foi possivel acessar o desktop");
        desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.BROWSE))
        throw new IllegalStateException("Não foi possivel acessar o navegador");
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se comunicar com o Navegador!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        try {
            desktop.browse(uri);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se comunicar com o Navegador!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
}
