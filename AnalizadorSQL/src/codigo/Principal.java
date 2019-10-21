/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author cristobal
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        
        String ruta2 = "/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/Lexer.flex";
        String[] rutaS = {"-parser", "Sintax", "/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/Sintax.cup"};
        generarLexer( ruta2, rutaS);
    }

    public static void generarLexer( String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/sym.java"),
                Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/sym.java"));

        Path rutaSym2 = Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/Sintax.java");
        if (Files.exists(rutaSym2)) {
            Files.delete(rutaSym2);
        }
        Files.move(
                Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/Sintax.java"),
                Paths.get("/home/cristobal/Documentos/MiniSQL/AnalizadorSQL/src/codigo/Sintax.java"));
       
    }

}
