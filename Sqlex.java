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

/**
 *
 * @author brak
 */
public class Sqlex {

    static String path = "/home/brak/NetBeansProjects/sqlex/src/sqlex/Lexer.flex";

    public static void generarLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }

    public static void main(String[] args) {
        //generarLexer(path);
        probar();
        
    }

    public static void probar() {
        String url = "/home/brak/NetBeansProjects/sqlex/src/sqlex/entrada.sql";
        try {
            Reader lector = new BufferedReader(new FileReader(url));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            while (true) {
                try {
                    Token token = lexer.yylex();
                    if (token == null) {
                        resultado += "FIN";
                        System.out.println(resultado);
                        return;
                    }
                    switch (token) {
                        case ERROR:
                            resultado += "Simbolo no definido" + "\n";
                            break;
                        case select:
                        case from:
                        case where:
                            resultado += "PC : " + token + " " + lexer.lexeme + "\n";
                            break;
                        case id:
                            resultado += "ID : " + token + "\n";
                        default:
                            resultado += "Token: " + token + "\n";
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(jflex.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.print("error 02");
                }
            }
        } catch (IOException e) {
            //Logger.getLogger(jflex.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("error 01");
        }

    }
   
}
