package Solicitudes;


import static javax.swing.JOptionPane.showMessageDialog;


public class Validador {
    public static boolean ValText(String text, boolean lM, boolean lm, boolean carEsp, 
                               boolean num, char ... carAcp){
        char temp;
        boolean auxCarEsp;
        for(int i = 0; i < text.length(); i++){
            temp = text.charAt(i);
            auxCarEsp = false;
            //Rango de Letras mayusculas
            if(65 <= temp && temp <= 90 && lM){
                continue;
            }
            //Rango de Letras minusculas
            if(97 <= temp && temp <= 122 && lm){
                continue;
            }
            //Rango de caracteres especiales permitidos
            if(carAcp != null){
                for(char j:carAcp){
                    if(temp == j){
                        auxCarEsp = true;
                        break;
                    }
                }
                if(auxCarEsp){
                    continue;
                }
            }
            //Rango de numero
            if(58 <= temp && temp <= 57 && num){
                continue;
            }
        if(carEsp){
            continue;
        }
            return false;
        }
        return true;
    }
    
}
