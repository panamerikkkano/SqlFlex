/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sqlex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author brak
 */
public class Sqlex {

    static String path = "/home/brak/NetBeansProjects/sqlex/src/sqlex/Lexer.flex";

    public static void main(String[] args) {
      
       //generarLexer(path);
       probar();

    }

    public static void generarLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }

    public static void probar() {
        String url = "/home/brak/NetBeansProjects/sqlex/src/sqlex/entrada.sql";
        try {
            Reader lector = new BufferedReader(new FileReader(url));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                try {
                    Token token = lexer.yylex(); //Logger.getLogger(jflex.class.getName()).log(Level.SEVERE, null, ex);
                    if (token == null) {
                        resultado += "FIN";
                        System.out.println(resultado);
                        return;
                    }
                    switch (token) {
                        case ERROR:
                            resultado += "Simbolo no definido" + "\n";
                            break;
                        case PC:
                        case ID:
                        case NUM:
                            resultado += token + ": " + lexer.lexeme + "\n";
                            break;
                        default:
                            resultado += "Token: " + token + "\n";
                    }
                } catch (IOException e) {
                    Logger.getLogger(Sqlex.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(Sqlex.class.getName()).log(Level.SEVERE, null, e);

        }

    }

}
