package Solicitudes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*; 
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;

public class GenerardorPDF {
    private static final Font FormText = FontFactory.getFont(FontFactory.COURIER, 11, Font.NORMAL);
    
    private final String valeResguardo;
    private final String valeSalAlm;
    private final String valeRecoleccion;
    
    public GenerardorPDF(){
        valeResguardo = new File("").getAbsolutePath()+"/src/Formatos/Vale_Resguardo.jpg";
        valeSalAlm = new File("").getAbsolutePath()+"/src/Formatos/Vale_Salida_Almacen.jpg";
        valeRecoleccion = new File("").getAbsolutePath()+"/src/Formatos/Vale_Recoleccion.jpg";
    }
    
    public boolean generarValeResg(String r, String c, String a, String t, String m, String l, String path, String [][]tabla){
        Image image;
        PdfWriter w;
        try {
            Document document = new Document();
            try {
                w = PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                return false;
            }
            document.open();
            image = Image.getInstance(valeResguardo);  
            image.setAbsolutePosition(0, 0);
            document.add(image);
            absText(r, 92, 604, w);
            absText(c, 92, 589, w);
            absText(a, 92, 574, w);
            absText(t, 348, 604, w);
            absText(m, 348, 589, w);
            absText(l, 348, 574, w);
            Calendar c1 = Calendar.getInstance();//122, 130
            absText(c1.getTime().getDate()+"/"+(c1.getTime().getMonth()+1)+"/"+(c1.getTime().getYear()+1900), 122, 656,w);
            int temp;
            for(int i = 0; i < tabla.length; i++){
                temp = 495-(i*(26));
                absText(tabla[i][0], 18, temp, w);
                absText(tabla[i][1], 93, temp, w);
                if(tabla[i][2] != null){
                    if(tabla[i][2].length() <  32){
                        absText(tabla[i][2],162, temp, w);
                    }else{
                        absText(tabla[i][2].substring(0, 31),162, temp, w);
                        absText(tabla[i][2].substring(31, tabla[i][2].length()),162, temp-15, w);
                    }
                }
                absText(tabla[i][3], 356, temp, w);
                absText(tabla[i][4], 428, temp, w);
                absText(tabla[i][5], 505, temp, w);
            }
            document.close();
        } catch (DocumentException | IOException e) {
            showMessageDialog(null, e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean generarSalidaAlm(String nombre, String path, String [][]tabla){
        Image image;
        PdfWriter w;
        try {
            Document document = new Document();
            try {
                w = PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                return false;
            }
            document.open();
            image = Image.getInstance(valeSalAlm);  
            image.setAbsolutePosition(0, 0);
            document.add(image);
            absText(nombre, 192, 640, w);
            Calendar c1 = Calendar.getInstance();
            absText(c1.getTime().getDate()+"/"+(c1.getTime().getMonth()+1)+"/"+(c1.getTime().getYear()+1900), 355, 660,w);
            int temp;
            for(int i = 0; i < tabla.length; i++){
                temp = 576-(i*(27));
                if(tabla[i][0] != null){
                    if(tabla[i][0].length() <  20){
                        absText(tabla[i][0],29, temp, w);
                    }else{
                        absText(tabla[i][0].substring(0, 19),29, temp, w);
                        absText(tabla[i][0].substring(19, tabla[i][0].length()),29, temp-15, w);
                    }
                }
                if(tabla[i][1] != null){
                    if(tabla[i][1].length() <  19){
                        absText(tabla[i][1], 154, temp, w);
                    }else{
                        absText(tabla[i][1].substring(0, 18), 154, temp, w);
                        absText(tabla[i][1].substring(18, tabla[i][1].length()), 154, temp-15, w);
                    }
                }
                if(tabla[i][2] != null){
                    if(tabla[i][2].length() <  35){
                        absText(tabla[i][2], 284, temp, w);
                    }else{
                        absText(tabla[i][2].substring(0, 35), 284, temp, w);
                        absText(tabla[i][2].substring(35, tabla[i][2].length()), 284, temp-15, w);
                    }
                }
            }
            document.close();
        } catch (DocumentException | IOException e) {
            return false;
        }
        return true;
    }
    
    public boolean generarValeRec(String r, String c, String a, String t, String m, String l, String path, Object [][]tabla){
        Image image;
        PdfWriter w;
        try {
            Document document = new Document();
            try {
                w = PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
            } catch (FileNotFoundException fileNotFoundException) {
                return false;
            }
            document.open();
            image = Image.getInstance(valeRecoleccion);  
            image.setAbsolutePosition(0, 0);
            document.add(image);
            absText(r, 92, 616, w);
            absText(c, 92, 603, w);
            absText(a, 92, 588, w);
            absText(t, 386, 616, w);
            absText(m, 386, 603, w);
            absText(l, 386, 588, w);
            Calendar c1 = Calendar.getInstance();//122, 130
            absText(c1.getTime().getDate()+"/"+(c1.getTime().getMonth()+1)+"/"+(c1.getTime().getYear()+1900), 125, 670,w);
            int temp;
            for(int i = 0; i < tabla.length; i++){
                temp = 507-(i*(26));
                
                absText((tabla[i][0] == null)?"No":((boolean)tabla[i][0])?"Sí":"No", 80, temp, w);
                if(tabla[i][1] != null){
                    if(((String)tabla[i][1]).length() <= 9){
                        absText((String)tabla[i][1], 15, temp, w);
                    }else{
                        absText(((String)tabla[i][1]).substring(0, 9), 15, temp, w);
                        absText(((String)tabla[i][1]).substring(9, ((String)tabla[i][1]).length()), 15, temp-15, w);
                    }
                }
                if(tabla[i][2] != null){
                    if(((String)tabla[i][2]).length() <= 9){
                        absText((String)tabla[i][2], 134, temp, w);
                    }else{
                        absText(((String)tabla[i][2]).substring(0, 9), 134, temp, w);
                        absText(((String)tabla[i][2]).substring(9, ((String)tabla[i][2]).length()), 134, temp-15, w);
                    }
                }
                if(tabla[i][3] != null){
                    if(((String)tabla[i][3]).length() <= 27){
                        absText((String)tabla[i][3], 198, temp, w);
                    }else{
                        absText(((String)tabla[i][3]).substring(0, 27), 198, temp, w);
                        absText(((String)tabla[i][3]).substring(27, ((String)tabla[i][3]).length()), 134, temp-15, w);
                    }
                }
                if(tabla[i][4] != null){
                    if(((String)tabla[i][4]).length() <= 9){
                        absText((String)tabla[i][4], 372, temp, w);
                    }else{
                        absText(((String)tabla[i][4]).substring(0, 9), 372, temp, w);
                        absText(((String)tabla[i][4]).substring(9, ((String)tabla[i][4]).length()), 372, temp-15, w);
                    }
                }
                if(tabla[i][5] != null){
                    if(((String)tabla[i][5]).length() <= 10){
                        absText((String)tabla[i][5], 436, temp, w);
                    }else{
                        absText(((String)tabla[i][5]).substring(0, 10), 436, temp, w);
                        absText(((String)tabla[i][5]).substring(10, ((String)tabla[i][5]).length()), 436, temp-15, w);
                    }
                }
                if(tabla[i][6] != null){
                    if(((String)tabla[i][6]).length() <= 9){
                        absText((String)tabla[i][6], 510, temp, w);
                    }else{
                        absText(((String)tabla[i][6]).substring(0, 9), 510, temp, w);
                        absText(((String)tabla[i][6]).substring(9, ((String)tabla[i][6]).length()), 510, temp-15, w);
                    }
                }
            }
            document.close();
        } catch (DocumentException | IOException e) {
            showMessageDialog(null, e.getMessage());
            return false;
        }
        return true;
    }
    
    private void absText(String text, int x, int y, PdfWriter writer) {
        try {
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            cb.saveState();
            cb.beginText();
            cb.moveText(x, y);
            cb.setFontAndSize(bf, 11);
            cb.showText(text);
            cb.endText();
            cb.restoreState();
    } catch (DocumentException | IOException e) {
      showMessageDialog(null, e.getMessage());
    }
  }

}
