/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Caronte
 */
public class RegistrazioneVoti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File htmlTemplateFile = new File("HtmlTemplate/prenotazioneAppelli.html");
        FileReader fr = new FileReader(htmlTemplateFile);
        BufferedReader br = new BufferedReader(fr); 
        while(br.ready()){
            System.out.println(br.readLine());
        }
    }
    
}
