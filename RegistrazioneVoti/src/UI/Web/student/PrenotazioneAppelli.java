/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Web.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import registrazionevoti.dataContainer.carriera.Carriera;
import registrazionevoti.dataContainer.corsi.Appello;
import registrazionevoti.dataContainer.corsi.Corso;

/**
 *
 * @author cl410671
 */
public class PrenotazioneAppelli {
    private String htmlString="",tableStr;
    public PrenotazioneAppelli(Carriera libretto) throws IOException{
        this.getTemplate();
        for(Corso c:libretto.getCorsi()){
            String nome= c.getNome();
            for(Appello a:c.getAppelli()){
                tableStr += app2html(nome,a.getDescrizione(),a.getData().toGMTString());
            }
        }
    }
    private static String app2html(String corso,String descrizione,String data){
        String tmp="<tr>";
        tmp +="<td>"+corso+"</td>";
        tmp +="<td>"+descrizione+"</td>";
        tmp +="<td>"+data+"</td>";
        return tmp+="</tr>";
    }
    public String toHtml(){
        htmlString.replace("$righe_appelli$", tableStr);
        return htmlString;
    }
    private void getTemplate() throws FileNotFoundException, IOException{
        File htmlTemplateFile = new File("HtmlTemplate/prenotazioneAppelli.html");
        FileReader fr = new FileReader(htmlTemplateFile);
        BufferedReader br = new BufferedReader(fr); 
        while(br.ready()){
            htmlString += br.readLine();
        }
    }
}
