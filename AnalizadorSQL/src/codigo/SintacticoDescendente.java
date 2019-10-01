/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.System;

/**
 *
 * @author cristobal
 */
public class SintacticoDescendente {
    public ArrayList <String> ll = new ArrayList();
     public ArrayList <String> errores = new ArrayList();
    public String l;
    public int posicion =0;
     String resultado2 = "";
  public void parsear(ArrayList<String> token){
      ll=token;
      l=ll.get(posicion);
      Z();
      terminado();
    }
  public void Z (){
      switch (l){
          case "SELECT":
              SELECT1(); //YA REVISADO
             break;
          case "INSERT":
              INSERT(); //YA REVISADO
              break;
          case "UPDATE":
              U(); //YA REVISADO
              break;
          case "DELETE":
              D();//YA REVISADO
              break;
          case "CREATE":
              C();
              break;
          case "ALTER":
              A();
              break;
          case "DROP":
            DR(); //YA REVISADO
            break;
          case "TRUNCATE":
            T(); //YA REVISADO
            break;
          
          default: 
              error();
              break;
              
      }
  }
  public void DR(){
      switch (l){
          case "DROP":
              match("DROP");
              DR1();
              break;
          
      }
  }
  public void DR1(){
      switch (l){
          case "TABLE":
              match ("TABLE");
              DRT2();
              break;
          case "DATABASE":
              match ("DATABASE");
              DRD2();
              break;
          case "LOGIN":
              match("LOGIN");
              DRL();
              break;
          case "INDEX":
              match("INDEX");
              DRI2();
              break;
          case "VIEW":
              match("VIEW");
              DRW2();
              break;
          default:
              error();
         
      }
  }
  public void DRT2(){
      switch (l){
          case "IF":
              match("IF");
              match("EXISTS");
              DRT3();
              break;
          default:
              DRT3();
              break;
      }
  }
  public void DRT3(){
        if (l=="IDENTIFICADOR"){
            OBJECT();
            DRT6();
        }
        else{
            error();
        }
  }
  public void DRT6(){
      switch (l){
          case "COMMA":
              match ("COMMA");
              DRT3();
              break;
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
          case "GO":
              match("GO");
              Z();
              break;
          default:
             error();
             break;
      }
  }
  public void DRD2(){
      if (l=="IF"){
          match("IF");
          match("EXISTS");
          DRD3();
      }
      else{
          DRD3();
      }
  }
  public void DRD3(){
      if (l=="IDENTIFICADOR"){
          match("IDENTIFICADOR");
          DRD4();
      }
      else{
          error();
      }
  }
  public void DRD4(){
      switch (l){
          case "COMMA":
              match ("COMMA");
              DRD3();
              break;
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
          case "GO":
              match("GO");
              Z();
              break;
          default:
             error();
             break;
      }
  }
  public void DRL(){
      if(l == "IDENTIFICADOR"){
          match("IDENTIFICADOR");
          if(l == "PUNTOCOMA"){
              match("PUNTOCOMA");
              Z();
          }
          if(l == "GO"){
              match("GO");
              Z();
          }
          else {
              error();
          }
      }
      else{
          error();
      }
  }
  public void DRI2(){
      if (l=="IF"){
          match("IF");
          match("EXISTS");
          DRI3();
      }
      else{
          DRI3();
      }
  }
  public void DRI3(){
      if (l=="IDENTIFICADOR"){
          match("IDENTIFICADOR");
          DRI4();
          
      }
      else{
          error();
      }
  }
  public void DRI4(){
      switch (l){
          case "ON":
            match("ON");
            OBJECT();
            DRI6();
            break;
          case "PUNTO":
            match("PUNTO");
            match("IDENTIFICADOR");
            DRI5();
            break;
          default:
              error();
              break;
      }
      
  }
  public void DRI5(){
      if(l == "PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          DRI6();
      }
      else{
          DRI6();
      }
  }
  public void DRI6(){
      if (l == "COMMA"){
          match("COMMA");
          DRI3();
      }
      if (l == "PUNTOCOMA"){
          match("PUNTOCOMA");
          Z();
          
      }
      if (l == "GO"){
          match("GO");
          Z();
          
      }
      else{
          error();
      }
          
  }
  public void DRW2(){
    if (l == "IF"){
        match("IF");
        match("EXIST");
        DRW3();
        
    }
    else{
        DRW3();
    }
}
  public void DRW3(){
    if(l=="IDENTIFICADOR"){
        match("IDENTIFICADOR");
        DRW4();
    }
    else{
        error();
    }
}
  public void DRW4(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          DRW5();
      }
      else{
          DRW5();
      }
  }
  public void DRW5(){
      switch (l){
          case "COMMA":
            match("COMMA");
            DRI3();
            break;
          case "PUNTOCOMA":
            match("PUNTOCOMA");
            Z();
            break;
          case "GO":
              match("GO");
              Z();
              break;
          default:
              error();
              break;
      }
  }
  public void T(){
      switch (l){
          case "TRUNCATE":
            match("TRUNCATE");
            match("TABLE");
            OBJECT();
            T8();
            break;
          
          default:
              error();
      }

  }
  
  
  public void T8(){
      switch (l){
          case "PUNTOCOMA":
            match("PUNTOCOMA");
            Z();
            break;
          case "GO":
            match("GO");
            Z();
            break;

          default:
              error();
              break;
      }
  }
  public void OBJECT(){
      if(l=="IDENTIFICADOR"){
          match("IDENTIFICADOR");
          OBJ2();
      }
      else{
          error();
      }
      
  }
  public void OBJ2(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          OBJ3();
      }
      else{
          OBJ3();
      }
  }
   public void OBJ3(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          
      }
      else{
          //VACIO
      }
  }
   public void D(){
       if(l == "DELETE"){
           match("DELETE");
           D2();
       }
   }
   public void D2(){
       switch (l){
          case "TOP":
            match("TOP");
            match("PARENTESISOP");
            SEXP();
            match("PARENTESISCLO");
            D3();
            break;
          default:
              D4();
              break;
      }
   }
   public void D3(){
       if (l == "PERCENT"){
           match("PERCENT");
           D4();
       }
       else {
           D4();
       }
   }
   public void D4(){
       if (l == "FROM"){
           match("FROM");
           D5();
       }
       else {
           D5();
       }
   }
   public void D5(){
       switch (l){
          case "IDENTIFICADOR":
            OBJECT();
            D6();
            break;
          case "ARROBA":
            match("ARROBA");
            TABLESOURCE();
            D6();
            break;
          default:
              error();
              break;
      }
   }
   public void D6(){
       if (l == "OUTPUT"){ 
           OUTPUTC();
           D7();
       }
       else {
           D7();
       }
   }
   public void D7(){
       if (l == "FROM"){ 
           match("FROM");
           OBJECT();
           EXTRA();
           D8();
       }
       else {
           DJOIN();
           D9();
       }
   }
   public void EXTRA(){
       if (l == "AS"){ 
           match("AS");
           match("IDENTIFICADOR");
       }
       else {
          //VACIO
       }
   }
   public void D8(){
       if (l == "COMMA"){ 
           match("COMMA");
           OBJECT();
           EXTRA();
           D8();
       }
       else {
           DJOIN();
           D9();
       }
   }
   
   public void DJOIN(){
       JOINTB();
   }
   public void D9(){
        if (l == "WHERE"){
           match("WHERE");
           SEARCHCWMATCH();
           D10();
       }
       else {
           D10();
       }
   }
   public void D10(){
       switch (l){
          case "PUNTOCOMA":
            match("PUNTOCOMA");
            Z();
            break;
          case "GO":
            match("GO");
            Z();
            break;

          default:
              error();
              break;
      }
   }
   
   
   public void SEARCHCWMATCH(){
       switch (l){
          case "NOT":
            match("NOT");
            PRED();
            SCWM2();
            break;
            
            
          case "PARENTESISOP":
            match("PARENTESISOP");
            SEARCHCWMATCH();
            match("PARENTESISCLO");
            SCWM2();
            break;
          default:
              PRED();
              SCWM2();
              break;
      }
   }
   
   public void SCWM2(){
        switch (l){
          case "AND":
            match("AND");           
            SCWM3();
            break;
          case "OR":
            match("OR");
            SCWM3();
            break;
          default:
            
            break;
      }
   }
   public void SCWM3(){
       if (l == "NOT"){
           match("NOT");
           SCWM4();
       }
       else {
           SCWM4();
       }
   }
   public void SCWM4(){
       if (l == "PARENTESISOP"){
           match("PARENTESISOP");
           SEARCHCWMATCH();
           match("PARENTESISCLO");
           SCWM5();
       }
       else {
           PRED();
           SCWM5();
       }
   }
   
   public void SCWM5(){
       SCWM2();
   }
   public void PRED(){
       switch (l){
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");           
            NOT1();
            if (l == "NULL"){
                match("NULL");

                return;
            }
            if (l == "LIKE"){
                match("LIKE");
                match("CADENA");
                return;
            }
            if(l == "IGUAL"){
                match("IGUAL");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      
                      break;
                    case "CADENA":
                    match("CADENA");
                      
                      break;
                    default:

                      break;
                    }
                return;
                
            }
            if(l == "MAYOR"){
                match("MAYOR");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      
                      break;
                    default:

                      break;
                    }
                return;
            }
            if(l == "BETWEEN"){
                match("BETWEEN");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      match("AND");
                      match("ENTERO");
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      match("AND");
                      match("FLOAT");
                      break;
                    default:

                      break;
                    }
                return;
            }
            
            if(l == "MENOR"){
                match("MENOR");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      
                      break;
                    default:

                      break;
                    }
                return;
            }
            if(l == "MAYORIGUAL"){
                match("MAYORIGUAL");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      
                      break;
                    default:

                      break;
                    }
                return;
            }
            if(l == "MENORIGUAL"){
                match("MENORIGUAL");
                switch (l){
                    case "ENTERO":
                      match("ENTERO");           
                      
                      break;
                    case "FLOAT":
                      match("FLOAT");
                      
                      break;
                    default:

                      break;
                    }
                return;
            }
            
            break;
          case "CONTAINS":
            match("CONTAINS");
            match("PARENTESISOP");
            FT1();
            match("COMMA");
            CSC1();
            match("PARENTESISCLO");
            break;
          case "FREETEXT":
            match("FREETEXT");
            match("PARENTESISOP");
            FT1();
            match("COMMA");
            match("CADENA");
            break;  
          
          default:
            E();
            PRED1();
            break;
      }
   }
   public void PRED1(){
       if (l == "IS"){
           match("IS");           
            NOT1();
            match("NULL");
            return;
       }
       if (l == "MENOR"|l=="MENORIGUAL"|l=="MAYOR"|l=="MAYORIGUAL"|l=="NOIGUAL"|l=="IGUALIGUAL"){
          COMPARADORES();
          E();
       }
       else{
           NOT1();
            PRED3();
       }
   }
   public void NOT1(){
       if (l == "IS"){
           match("IS");
           match("NOT");
           return;
       }
       if (l == "NOT"){
           match("NOT");
           return;
       }
       else{
           //VACIO
       }
   }
   public void COMPARADORES(){
       switch (l){
          case "MENOR":
            match("MENOR");           
            break;
          case "MENORIGUAL":
            match("MENORIGUAL");
            break;
          case "MAYORIGUAL":
            match("MAYORIGUAL");
            break;  
          case "MAYOR":
            match("MAYOR");
            break;  
          case "NOIGUAL":
            match("NOIGUAL");
            break;  
          case "IGUALIGUAL":
            match("IGUALIGUAL");
            break;  
          default:
           error();
            break;
      }
   }
   
   public void FT1(){
      switch (l){
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");           
            break;
          case "ASTERISCO":
            match("ASTERISCO");
            break;
          default:
            error();
      }
   }
   public void PRED3(){
       if (l == "IN"){
           match("IN");
           match("PARENTESISOP");
           E();
           PRED2();
           match("PARENTESISCLO");
       }
       else{
           E();
           match("BETWEEN");
           E();
       }
   }
   public void PRED2(){
       if (l == "COMMA"){
           match("COMMA");
           E();
           PRED2();
       }
       else{
           
       }
   }
   public void CSC1(){
       switch (l){
          case "CADENA":
            match("CADENA");           
            break;
          case "PARENTESISOP":
            match("PARENTESISOP");
            CSC1();
            match("PARENTESISCLO");
            CSC2();
            break;
          default:
            error();
      }
   }
   public void CSC2(){
       switch (l){
          case "AND":
            match("AND");           
            CSC3();
            break;
          case "OR":
            match("OR");
            CSC1();
            break;
          case "Or":
            match("Or");
            CSC1();
            break;
          case "And":
            match("And");
            CSC1();
          default:
            error();
      }
   }
   public void CSC3(){
       if (l == "NOT"){
           match("NOT");
           CSC1();
       }
       else{
           CSC1();
       }
   }
   public void E(){
       H();
       EPRIMA();
   }
   public void EPRIMA(){
       switch (l){
          case "MAS":
            match("MAS");           
            H();
            EPRIMA();
            break;
          case "MENOS":
            match("MENOS");
            H();
            EPRIMA();
            break;
          default:
            //NADA
            break;
      }
   }
   public void H(){
       L();
       HPRIMA();
   }
   public void HPRIMA(){
       switch (l){
          case "ASTERISCO":
            match("ASTERISCO");           
            L();
            HPRIMA();
            break;
          case "DIV":
            match("DIV");
            L();
            HPRIMA();
            break;
          default:
            //NADA
      }
   }
   public void L(){
       G();  
       
   }
   public void G(){
       if (l == "PARENTESISOP"){
           match("PARENTESISOP");
           E();
           match("PARENTESISCLO");
       }
       else{
           EXPI();
       }
       
   }
   public void EXPI(){
       if (l == "IDENTIFICADOR"){
           match("IDENTIFICADOR");
       }
       if (l == "ARROBA"){
           match("ARROBA");
           match("IDENTIFICADOR");
       }
       if (l == "NULL"||l == "ENTERO"||l == "FLOAT"||l == "CADENA"){
          CONST();
       }
       if (l == "AVG"||l == "COUNT"||l == "MAX"||l == "MIN"||l == "SUM"){
          FUNC();
       }
       else{
           //ERROR
       }
   }
   public void E2(){
       H2();
       E2PRIMA();
   }
   
   public void E2PRIMA(){
       switch (l){
          case "MAS":
            match("MAS");           
            H2();
            E2PRIMA();
            break;
          case "MENOS":
            match("MENOS");
            H2();
            E2PRIMA();
            break;
          default:
            //NADA
              break;
      }
   }
   public void H2(){
       L2();
       H2PRIMA();
   }
   
   public void H2PRIMA(){
       switch (l){
          case "ASTERISCO":
            match("ASTERISCO");           
            L2();
            H2PRIMA();
            break;
          case "DIV":
            match("DIV");
            L2();
            H2PRIMA();
            break;
          default:
            //NADA
              break;
      }
   }
   
   public void L2(){
       G2();  
       
   }
   public void G2(){
      switch (l){
          case "PARENTESISOP":
            match("PARENTESISOP");
            E2();
            match("PARENTESISCLO");
            break;
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");
            break;
          case "ARROBA":
            match("ARROBA");
            match("IDENTIFICADOR");
            break;
          case "FLOAT":
            match("FLOAT");
            break;
          case "ENTERO":
            match("ENTERO");
            break;
          default:
            //NADA
              break;
      }
   }
   public void CONST(){
       switch (l){
          case "NULL":
            match("NULL");
            break;
          case "ENTERO":
            match("ENTERO");
            break;
          case "FLOAT":
            match("FLOAT");
            break;
          case "CADENA":
            match("CADENA");
            break;
          default:
            //ERROR
              break;
      }
   }
   
   public void FUNC(){
       switch (l){
          case "AVG":
            match("AVG");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
            break;
          case "COUNT":
            match("COUNT");
            match("PARENTESISOP");
            FUNC3();
            match("PARENTESISCLO");
            break;
          case "MAX":
            match("MAX");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
            break;
          case "MIN":
            match("MIN");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
            break;
          default:
            //ERROR
              break;
      }
   }
   public void FUNC2(){
       switch (l){
          case "ALL":
            match("ALL");
            break;
          case "DISTINCT":
            match("DISTINCT");
            break;
          default:
            FUNC4();
            break;
      }
   }
   
   public void FUNC4(){
       switch (l){
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");
            FUNC5();
            break;
          case "ENTERO":
            match("ENTERO");
            FUNC5();
            break;
          case "FLOAT":
            match("FLOAT");
            FUNC5();
            break;
          case "ARROBA":
            match("ARROBA");
            match("IDENTIFICADOR");
            FUNC5();
            break;
          default:
            error();
              break;
      }
   }
   public void FUNC5(){
        if (l == "MAS"||l == "MENOS"||l == "DIV"||l == "ASTERISCO"||l == "MENOR"||l == "MENORIGUAL"||l == "MAYOR"||l == "MAYORIGUAL"||l == "NOIGUAL"){
          OPERADORES();
       }
        else{
            error();
        }
   }
   public void OPERADORES(){
       switch (l){
          case "MAS":
            match("MAS");
            break;
          case "MENOS":
            match("MENOS");
            break;
          case "ASTERISCO":
            match("ASTERISCO");
            break;
          case "DIV":
            match("DIV");
            break;
          case "MENOR":
            match("MENOR");
            break;
          case "MENORIGUAL":
            match("MENORIGUAL");
            break;
          case "MAYOR":
            match("MAYOR");
            break;
          case "MAYORIGUAL":
            match("MAYORIGUAL");
            break;
           case "NOIGUAL":
            match("NOIGUAL");
            break;
          default:
            error();
            break;
       }
   }
   public void FUNC3(){
       if (l == "ASTERISCO"){
           match("ASTERISCO");
       }
       else{
           E2();
       }
   }
   public void U(){
       switch (l){
          case "UPDATE":
              match("UPDATE");
              DEFOBJETO();
              match("SET");
              UPD2();
              if(l == "PUNTOCOMA"){
                match("PUNTOCOMA");
                Z();  
              }
              if(l == "GO"){
                match("GO");
                Z();
              }
              else{
                  error();
              }
              
              break;
      }
   }
   public void UPD2(){
       switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              UPD3();
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              UPD9();
              break;
          default:
              error();
              break;
      }
   }
   public void UPD3(){
       switch (l){
          case "IGUAL":
              match("IGUAL");
              UPD4();
              break;
          case "PUNTO":
              match("PUNTO");
              UPD5();
              break;
          default:
      }
   }
   public void UPD4(){
       switch (l){
          case "DEFAULT":
              match("DEFAULT");
              UPD8();
              break;
          case "NULL":
              match("NULL");
              UPD8();
              break;
          default:
              E();
              UPDN();
              UPD8();
              break;
      }
   }
    public void UPD5(){
       switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              
              UPD6();
              break;
          case "WRITE":
              match("WRITE");
              match("PARENTESISOP");
              E();
              match("COMMA");
              UPD7();
              match("COMMA");
              UPD7();
              match("PARENTESISCLO");
              UPD8();
              break;
          default:
              error();
              break;
      }
   }
    public void UPDN(){
        if ( l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
            UPDN2();
        }
        else{
            //VACIO
        }
    }
    public void UPDN2(){
        if ( l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
        }
        else{
            //VACIO
        }
    }
    public void UPD7(){
        switch (l){
          case "Entero":
              match("Entero");
              break;
          case "NULL":
              match("NULL");
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              break;
          default:
             error();
             break;
      }
    }
    public void UPD9(){
        if (l == "IGUAL"){
            match("IGUAL");
            UPD10();
        }
        else{
            error();
        }
            
    }
    public void UPD10(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            match("IGUAL");
            E();
            UPD8();
        }
        else{
            E();
            UPD8();
        }
    }
    public void UPD8(){
         if (l == "COMMA"){
            match("COMMA");
            UPD2();
        }
        else{
            FINALQUERY();
        }
    }
    public void UPD6(){
        switch (l){
          case "IGUAL":
              match("IGUAL");
              E();
              UPD8();
              break;
          case "PARENTESISOP":
              match("PARENTESISOP");
              ARGUMENT();
              match("PARENTESISCLO");
              UPD8();
              break;
          default:
             error();
             break;
      }
    }
    public void FINALQUERY(){
        if (l == "OUTPUT"){
            OUTPUTC();
            FQ2();
        }
        else{
            FQ2();
        }
    }
    public void FQ2(){
        if (l == "FROM"){
            match("FROM");
            TABLESOURCE();
            FQ3();
        }
        else{
            FQ3();
        }
    }
    public void FQ3(){
        if (l == "WHERE"){
            match("WHERE");
            SEARCHCWMATCH();
            FQ4();
        }
        else{
            FQ4();
        }
    }
    public void FQ4(){
        switch (l){
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
          case "GO":
              match("GO");
              Z();
              break;
          default:
             error();
             break;
      }
    }
    public void ARGUMENT(){
        if (l == "CADENA"){
            match("CADENA");
            ARGUMENT2();
        }
        else{
            E();
            ARGUMENT2();
        }
    }
    
    public void ARGUMENT2(){
         if (l == "COMMA"){
            match("COMMA");
            ARGUMENT();
        }
        else{
            //NADA
        }
    }
    public void DEFOBJETO(){
        if (l == "TOP"){
            match("TOP");
            match("PARENTESISOP");
            SEXP();
            match("PARENTESISCLO");
            DEFOBJETO1();
        }
        else{
            DEFOBJETO2();
        }
    }
    public void DEFOBJETO1(){
        if (l == "PERCENT"){
            match("PERCENT");
            DEFOBJETO2();
        }
        else{
            DEFOBJETO2();
        }
    }
    public void DEFOBJETO2(){
        switch (l){
          case "IDENTIFICADOR":
              OBJECT();
              WH();
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
          default:
             ROWSETF();
             WH();
             break;
      }
    }
    public void ROWSETF(){
        switch (l){
          case "OPENROWSET":
              match("OPENROWSET");
              OPROW2();
              break;
          case "OPENQUERY":
              match("OPENQUERY");
              OPQUER2();
              break;
          default:
             error();
             break;
      }
    }
    public void WH(){
        if (l == "WITH"){
            match("WITH");
            match("PARENTESISOP");
            TABLEHINT();
            match("PARENTESISCLO");
        }
        else{
            
        }
    }
    public void TABLEHINT(){
        switch (l){
          case "INDEX":
              match("INDEX");
              TH2();
              break;
          case "HOLDLOCK":
              match("HOLDLOCK");
              break;
          default:
             error();
             break;
      }
    }
    public void TH2(){
        switch (l){
          case "IGUAL":
              match("IGUAL");
              TH3();
              TH4();
              break;
          case "PARENTESISOP":
              match("PARENTESISOP");
              TH3();
              match("PARENTESISCLO");
              break;
          default:
             error();
             break;
      }
    }
    public void TH3(){
        switch (l){
          case "ENTERO":
              match("ENTERO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          case "NULL":
              match("NULL");
              break;
          default:
             error();
             break;
      }
    }
    public void TH4(){
        if(l == "COMMA"){
            match("COMMA");
            TH5();
        }
        else{
            
        }
    }
    public void TH5(){
        switch (l){
          case "ENTERO":
              match("ENTERO");
              TH4();
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              TH4();
              break;
          case "NULL":
              match("NULL");
              TH4();
              break;
          default:
             error();
             break;
      }
    }
    public void OPROW2(){
        if (l == "PARENTESISOP"){
            match("PARENTESISOP");
            match("CADENA");
            match("COMMA");
            OPROW3();
        }
        else{
            error();
        }
    }
    public void OPROW3(){
        if (l == "CADENA"){
            match("CADENA");
            OPROW4();
        }
        else{
            error();
        }
    }
    public void OPROW4(){
        if (l == "PUNTOCOMA"){
            match("PUNTOCOMA");
            match("CADENA");
            match("PUNTOCOMA");
            match("CADENA");
            OPROW5();
        }
        else{
            OPROW5();
        }
    }
    public void OPROW5(){
        if (l == "COMMA"){
            match("COMMA");
            OPROW6();
        }
        else{
            error();
        }
    }
    public void OPROW6(){
        
        
        if (l == "CADENA"){
            match("CADENA");
            match("PARENTESISCLO");
        }
        else{
            OBJECT();
            match("PARENTESISCLO");
        }
    }
    public void OPQUER2(){
        if (l == "PARENTESISOP"){
            match("PARANTESISOP");
            match("IDENTIFICADOR");
            match("COMMA");
            match("CADENA");
            match("PARENTESISCLO");
        }
        else{
            error();
        }
    }
    public void SEXP(){
        SEXP3();
        SEXP2();
    }
    public void SEXP2(){
        switch (l){
          case "MAS":
              match("MAS");
              SEXP3();
              SEXP2();
              break;
          case "MENOS":
              match("MENOS");
              SEXP3();
              SEXP2();
              break;
          default:
             //VACIO 
              break;
      }
    }
    public void SEXP3(){
        SEXP5();
        SEXP4();
    }
    public void SEXP4(){
        switch (l){
          case "ASTERISCO":
              match("ASTERISCO");
              SEXP5();
              SEXP4();
              break;
          case "DIV":
              match("DIV");
              SEXP5();
              SEXP4();
              break;
          default:
             //VACIO
              break;
      }
    }
    public void SEXP5(){
        switch (l){
          case "PARENTESISOP":
              match("PARENTESISOP");
              SEXP();
              match("PARENTESISCLO");
              break;
          case "ENTERO":
              match("ENTERO");
              break;
          case "FLOAT":
              match("FLOAT");
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              break;
              
          default:
             AGG_FN();
             break;
      }
    }
    public void AGG_FN(){
        switch (l){
          case "AVG":
              match("AVG");
              match("PARENTESISOP");
              SEL_AVG();
              match("PARENTESISCLO");
              break;
          case "COUNT":
              match("COUNT");
              match("PARENTESISOP");
              SEL_COUNT();
              match("PARENTESISCLO");
              break;
          case "MAX":
              match("MAX");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
          case "MIN":
              match("MIN");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
           case "SUM":
              match("SUM");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
          default:
             error();
             break;
      }
    }
    
    public void AGG_FN2(){
        switch (l){
          case "AVG":
              match("AVG");
              match("PARENTESISOP");
              SEL_AVG();
              match("PARENTESISCLO");
              break;
          case "COUNT":
              match("COUNT");
              match("PARENTESISOP");
              SEL_COUNT();
              match("PARENTESISCLO");
              break;
          case "MAX":
              match("MAX");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
          case "MIN":
              match("MIN");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
           case "SUM":
              match("SUM");
              match("PARENTESISOP");
              SEL_AGR();
              match("PARENTESISCLO");
              break;
          default:
             //VACIO
             break;
      }
    }
    public void SEL_AVG(){
        SEL_AVG1();
        SEL_AVG2();
    }
    public void  SEL_AVG1(){
        switch (l){
          case "ALL":
              match("ALL");
              break;
          case "DISTINCT":
              match("DISTINCT"); 
              break;
          default:
             //vacio
      }
    }
    public void SEL_AVG2(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            SEL_AVG3();
        }
        else{
            SEXP();
        }
    }
    public void SEL_AVG3(){
        if (l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
        }
        else{
            //VACIO
        }
    }
    
    public void SEL_COUNT(){
        SEL_COUNT1();
        SEL_COUNT2();
    }
    public void SEL_COUNT1(){
        switch (l){
          case "ALL":
              match("ALL");
              break;
          case "DISTINCT":
              match("DISTINCT");  
              break;
          default:
             //vacio
              break;
      }
    }
    public void SEL_COUNT2(){
        switch (l){
          case "ASTERISCO":
              match("ASTERISCO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");     
              SEL_COUNT3();
              break;
          default:
             SEXP();
             break;
      }
    }
    public void SEL_COUNT3(){
        if (l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
        }
        else{
            //VACIO
        }
    }
    public void SEL_AGR(){
        SEL_AGR1();
        SEL_AGR2();
    }
    public void SEL_AGR1(){
        switch (l){
          case "ALL":
              match("ALL");
              break;
          case "DISTINCT":
              match("DISTINCT");  
              break;
          default:
             //vacio
        }
    }
    public void SEL_AGR2(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            SEL_AGR3();
        }
        else{
            SEXP();
        }
    }
    
     public void SEL_AGR3(){
        if (l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
        }
        else{
            //VACIO
        }
    }
     
    public void DML(){
        DML2();
        DML3();
    }
    public void DML2(){
        if (l == "PARENTESISOP"||l == "ENTERO"||l == "FLOAT"||l == "ARROBA"||l == "AVG"||l == "COUNT"||l == "MAX"||l == "MIN"||l == "SUM"){
            SEXP();
        }
        else{
            COLNAME();
        }
    }
    public void DML3(){
        if (l == "AS"){
            match("AS");
            match("IDENTIFICADOR");
            DML4();
        }
        else{
            
        }
    }
    public void DML4(){
        if (l == "COMMA"){
            match("COMMA");
            DML();
        }
        else{
            
        }
    }
    public void COLNAME(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            match("PUNTO");
            COLNAME1();
        }
        else{
            error();
        }
    }
    public void COLNAME1(){
       switch (l){
          case "ASTERISCO":
              match("ASTERISCO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          default:
             error();
             break;
        }
    }
    public void OUTPUTC(){
        if (l == "OUTPUT"){
            match("OUTPUT");
            DML();
            OUTPUTC2();
        }
        else{
            //vacio
        }
    }
    public void OUTPUTC2(){
        if (l == "INTO"){
            match("INTO");
            OUTPUTC3();
        }
        else{
            //vacio
        }
    }
    public void OUTPUTC3(){
        switch (l){
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              OUTPUTC4();
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR"); 
              OUTPUTC4();
              break;
          default:
             error();
             break;
        }
    }
    public void OUTPUTC4(){
        if (l == "PARENTESISOP"){
            COLST();
        }
        else{
            //vacio
        }
    }
    public void COLST(){
        if (l == "PARENTESISOP"){
            match("PARENTESISOP");
            COLST1();
        }
        else{
            error();
        }
    }
    public void COLST1(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            COLST2();
        }
        else{
            error();
        }
    }
    public void COLST2(){
       switch (l){
          case "COMMA":
              match("COMMA");
              COLST1();
              break;
          case "PARENTESISCLO":
              match("PARENTESISCLO"); 
              break;
          default:
             error();
             break;
        }
    }
    
    public void INSERT(){
        if (l == "INSERT"){
            match("INSERT");
            INSERT1();
        }
        else{
            error();
        }
    }
    public void INSERT1(){
        if (l == "TOP"){
            match("TOP");
            match("PARENTESISOP");
            SEXP();
            match("PARENTESISCLO");
            INSERT2();
        }
        else{
            INSERT3();
        }
    }
    public void INSERT2(){
        if(l == "PERCENT"){
            match("PERCENT");
            INSERT3();
        }
        else{
            INSERT3();
        }
    }
    public void INSERT3(){
        if(l == "INTO"){
            match("INTO");
            INSERT4();
        }
        else{
            INSERT5();
        }
    }
    public void INSERT4(){
        OBJECT();
        INSERT5();
    }
    public void INSERT5(){
        if(l == "PARENTESISOP"){
            COLST();
            INSERT6();
        }
        else{
            INSERT6();
        }
    }
    public void INSERT6(){
        if(l == "OUTPUT"){
            OUTPUTC();
            INSERT7();
        }
        else{
            INSERT7();
        }
    }
     public void INSERT7(){
         switch (l){
          case "VALUES":
              match("VALUES");
              match("PARENTESISOP");
              INSERT8();
              break;
          case "DEFAULT":
              match("DEFAULT"); 
              match("VALUES");
              INSERT9();
              break;
          default:
             SELECT1();
             INSERT9();
             break;
        }
       
    }
     public void INSERT8(){
        INSERT10();
        INSERT11();
    }
     public void INSERT10(){
         switch (l){
          case "DEFAULT":
              match("DEFAULT");
              break;
          case "NULL":
              match("NULL"); 
              break;
          default:
             EXPRESSION();
             break;
        }
       
    }
     public void INSERT11(){
         switch (l){
          case "COMMA":
              match("COMMA");
              INSERT8();
              break;
          case "PARENTESISCLO":
              match("PARENTESISCLO"); 
              INSERT12();
              break;
          default:
             error();
             break;
        }
       
    }
     public void INSERT12(){
        if(l == "COMMA"){
            match("COMMA");
            match("PARENTESISOP");
            INSERT8();
        }
        else{
            INSERT9();
        }
    }
    public void INSERT9(){
         switch (l){
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
          case "GO":
              match("GO"); 
              Z();
              break;
          default:
             error();
             break;
        }
       
    }
    public void SELIST(){
        SELIST1();
        SELIST7();
    }
    public void SELIST1(){
        switch (l){
          case "ASTERISCO":
              match("ASTERISCO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR"); 
              SELIST2();
              break;
          default:
             EXPRESSION();
             SELIST8();
             break;
        }
    }
    public void SELIST2(){
        switch (l){
          case "PUNTO":
              match("PUNTO");
              SELIST3();
              break;
          case "IGUAL":
              match("IGUAL"); 
              SELIST6();
              break;
          default:
             SELIST8();
              break;
        }
    }
    public void SELIST8(){
        switch (l){
          case "AS":
              match("AS");
              match("IDENTIFICADOR"); 
              break;
          default:
             //VACIO
             break;
        }
    }
    public void SELIST3(){
        switch (l){
          case "ASTERISCO":
              match("ASTERISCO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR"); 
              SELIST5();
              break;
          default:
             error();
             break;
        }
    }
    public void SELIST5(){
        switch (l){
          case "AS":
              match("AS");
              match("IDENTIFICADOR");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR"); 
              break;
          default:
             //VACIO
              break;
        }
    }
    public void SELIST6(){
        E();
    }
    public void SELIST7(){
        
        if (l == "COMMA"){
            match("COMMA");
            SELIST();
        }
        else{
            //VACIO
        }
    }
    /*
    public void CONV(){
        switch (l){
          case "CAST":
              match("CAST");
              match("PARENTESISOP");
              CONV1();
              break;
          case "CONVERT":
              match("CONVERT"); 
              match("PARENTESISOP");
              CONV2();
              break;
          default:
             //VACIO
              break;
        }
    }
    public void CONV1(){
        if(l == expresion){
            EXPRESSION();
            match("AS"); 
            DATA_TYPE();
            CONV3();
            match("PARENTESISCLO"); 
        }
        else{
            error();
        }
    }
    public void CONV2(){
        DATA_TYPE();
        CONV3();
        CONV4();
    }
    public void CONV3(){
        if(l == "PARENTESISOP"){
            match("PARENTESISOP");
            match("ENTERO");
            match("PARENTESISCLO"); 
        }
        else{
            //VACIO
        }
    }
    public void CONV4(){
        EXPRESSION();
        CONV5();
    }
    public void CONV5(){
        switch (l){
          case "COMMA":
              match("COMMA");
              SEXP();
              break;
          case "PARENTESISCLO":
              match("PARENTESISCLO"); 
              break;
          default:
             error();
             break;
        }
    }
    public void DT_FN(){
        switch (l){
          case "CURRENT_TIMESTAMP":
              match("CURRENT_TIMESTAMP");
              break;
          case "DAY":
              match("DAY");
              match("PARENTESISOP");
              DT_FN1();
              match("PARENTESISCLO"); 
              break;
          case "MONTH":
              match("MONTH");
              match("PARENTESISOP");
              DT_FN1();
              match("PARENTESISCLO"); 
              break;
          case "YEAR":
              match("YEAR");
              match("PARENTESISOP");
              DT_FN1();
              match("PARENTESISCLO"); 
              break;
          case "SET":
              match("SET");
              match("LANGUAGE");
              DT_FN2();
              break;
          default:
             error();
             break;
        }
    }    
    public void DT_FN1(){
        switch (l){
          case "CADENA":
              match("CADENA");
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              break;
          default:
             error();
        }
    }
    public void DT_FN2(){
        switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              break;
          default:
             error();
        }
    }
    public void STR_FN(){
        switch (l){
          case "LOWER":
              match("LOWER");
              match("PARENTESISOP");
              STR_FN1();
              match("PARENTESISCLO");
              break;
          case "TRANSLATE":
              match("TRANSLATE");
              match("PARENTESISOP");
              STR_FN1();
              match("COMMA");
              STR_FN1();
              match("COMMA");
              STR_FN1();
              match("PARENTESISCLO");
              break;
          case "UPPER":
              match("UPPER");
              match("PARENTESISOP");
              STR_FN1();
              match("PARENTESISCLO");
              break;
          case "CHAR":
              match("CHAR");
              match("PARENTESISOP");
              SEXP();
              match("PARENTESISCLO"); 
              break;
          case "LEFT":
              match("LEFT");
              match("PARENTESISOP");
              STR_FN1();
              match("COMMA");
              SEXP();
              match("PARENTESISCLO");
              break;
          case "TRIM":
              match("TRIM");
              match("PARENTESISOP");
              STR_FN2();
              STR_FN1();
              match("PARENTESISCLO");
              break;
          case "NCHAR":
              match("NCHAR");
              match("PARENTESISOP");
              SEXP();
              match("PARENTESISCLO");
              break;
           case "RIGHT":
              match("RIGHT");
              match("PARENTESISOP");
              STR_FN1();
              match("COMMA");
              SEXP();
              match("PARENTESISCLO");
              break;
            case "SPACE":
              match("SPACE");
              match("PARENTESISOP");
              SEXP();
              match("PARENTESISCLO");
              break;
            case "SUBCADENA":
              match("SUBCADENA");
              match("PARENTESISOP");
              STR_FN1();
              match("COMMA");
              SEXP();
              match("COMMA");
              SEXP();
              match("PARENTESISCLO"); 
              break;
          default:
             error();
             break;
        }
    }
    public void STR_FN1(){
        switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              break;
          case "CADENA":
              match("CADENA");
              break;
          default:
             error();
             break;
        }
    }
    public void STR_FN2(){
        if(l == "ARROBA"|l == "CADENA"|l == "IDENTIFICADOR"){
            STR_FN1();
            match("FROM");
        }
        else{
            error();
        }
    }
    public void OTH_FN(){
        switch (l){
          case "NEXT":
              match("NEXT");
              match("VALUE");
              match("FOR");
              match("IDENTIFICADOR");
              OTH_FN1();
              break;
          case "SYSTEM_USER":
              match("SYTEM_USER");
              break;
          case "SESSION_USER":
              match("SESSION_USER");
              break;
          case "NULLIF":
              match("NULLIF");
              match("PARENTESISOP");
              EXPRESSION();
              match("COMMA");
              EXPRESSION();
              match("PARENTESISCLO");
              break;
          default:
             error();
             break;
        }
    }
    public void OTH_FN1(){
        if(l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
            OTH_FN2();
            
        }
        else{
            OTH_FN2();
        }
    }
    public void OTH_FN2(){
        if(l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
            OTH_FN3();
            
        }
        else{
            OTH_FN3();
        }
    }
    public void OTH_FN3(){
        if(l == "OVER"){
            match("OVER");
            match("ORDER");
            match("BY");
            ORDER();
            
        }
        else{
            error();
        }
    }
    public void CASEW(){
        if (l == "CASE"){
            match("CASE");
            CASEW1();
        }
        else{
            error();
        }
    }
    public void CASEW1(){
        if (l == "CASE"){
            match("CASE");
            CASEW1();
        }
        else{
            error();
        }
    }*/
    
    public void EXPRESSION(){
        if(l == "CADENA"){
            match("CADENA");
            return;
            
        }
        if(l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");    
            EXPRESSION1();
            return;
           
        }
        if(l == "PARENTESISOP"){
            match("PARENTESISOP");  
            EXPRESSION();
            match("PARENTESISCLO");
            return;
        }
        if(l == "MAS"||l == "MENOS"){
            EXPRESSION2();
            return;
            
        }
        if(l == "PARENTESISOP"||l == "ENTERO"||l == "FLOAT"||l == "ARROBA"||l == "AVG"||l == "COUNT"||l == "MAX"||l == "MIN"||l == "SUM"){
            SEXP();
            return;
            
        }
        else{
            error();
        }
    }
    
    public void EXPRESSION1(){
        if (l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
        }
        else{
            //vacio
        }
    }
    public void EXPRESSION2(){
        switch (l){
          case "MAS":
              match("MAS");
              break;
          case "MENOS":
              match("MENOS");
              break;
          default:
             error();
             break;
        }
    }
    
    public void EXPRESSION4(){
        BIN_OPR();
        EXPRESSION();
    }
    public void BIN_OPR(){
        if (l == "MAS"||l == "MENOS"||l == "ASTERISCO"||l == "DIV"||l == "PORCENTAJE"){
            AR_OPR();
        }
        if (l == "IGUAL"){
            ASIG_OPR();
        }
        if (l == "MENOR"||l == "MENORIGUAL"||l == "MAYOR"||l == "MAYORIGUAL"||l == "NOIGUAL"){
            COMPARE_OPR();
        }
        if (l == "ALL"||l == "AND"||l == "ANY"||l == "BETWEEN"||l == "EXISTS"||l == "IN"||l == "LIKE"||l == "NOT"||l == "OR"||l == "SOME"){
            LOGIC_OPR();
        }
    }
    public void AR_OPR(){
        switch (l){
          case "MAS":
              match("MAS");
              break;
          case "MENOS":
              match("MENOS");
              break;
          case "ASTERISCO":
              match("ASTERISCO");
              break;
          case "DIV":
              match("DIV");
              break;
          case "PORCENTAJE":
              match("PORCENTAJE");
              break;
          default:
             error();
             break;
        }
    }
    public void ASIG_OPR(){
        if(l == "IGUAL"){
            match("IGUAL");
        }
        else{
            error();
        }
    }
    
    public void COMPARE_OPR(){
        switch (l){
          case "MENOR":
              match("MENOR");
              break;
          case "MENORIGUAL":
              match("MENORIGUAL");
              break;
          case "MAYOR":
              match("MAYOR");
              break;
          case "MAYORIGUAL":
              match("MAYORIGUAL");
              break;
          case "NOIGUAL":
              match("NOIGUAL");
              break;
          default:
             error();
             break;
        }
    }
    public void LOGIC_OPR(){
        switch (l){
          case "ALL":
              match("ALL");
              break;
          case "AND":
              match("AND");
              break;
          case "ANY":
              match("ANY");
              break;
          case "BETWEEN":
              match("BETWEEN");
              break;
          case "EXISTS":
              match("EXISTS");
              break;
          case "IN":
              match("IN");
              break;
          case "LIKE":
              match("LIKE");
              break;
          case "NOT":
              match("NOT");
              break;
          case "OR":
              match("OR");
              break;
          case "SOME":
              match("SOME");
              break;
          default:
             error();
             break;
        }
    }
   
    public void SELECT1(){
        if (l == "SELECT"){
            match("SELECT");
            SELECT2();
            if (l == "PUNTOCOMA"){
                match("PUNTOCOMA");
                Z();
            }
            if(l == "GO"){
                match("GO");
                Z();
            }
            else{
                error();
            }
            
        }
        else{
            error();
        }
    }
    public void SELECT2(){
        SELECT3();
        SELECT4();
    }
    public void SELECT3(){
        switch (l){
          case "ALL":
              match("ALL");
              break;
          case "DISTINCT":
              match("DISTINCT");
              break;

          default:
             //VACIO
             break;
        }
    }
    public void SELECT4(){
        if (l == "TOP"){
            match("TOP");
            SELECT5();
        }
        else{
            SELECT7();
        }
    }
    public void SELECT5(){
        if (l == "PARENTESISOP"){
            match("PARENTESISOP");
            SEXP();
            match("PARENTESISCLO");
            SELECT6();
        }
        else{
            error();
        }
    }
    public void SELECT6(){
        if (l == "PERCENT"){
            match("PERCENT");
            SELECT7();

        }
        else{
             SELECT7();
        }
    }
    public void SELECT7(){
        SELIST();
        SELECT8();
    }
    
    public void SELECT8(){
        if (l == "INTO"){
            match("INTO");
            SELECT9();

        }
        else{
             SELECT11();
        }
    }
    public void SELECT9(){
        if (l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            SELECT10();

        }
        else{
             error();
        }
    }
    public void SELECT10(){
        if (l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
            

        }
        else{
             SELECT11();
        }
    }
    public void SELECT11(){
        if (l == "FROM"){
            match("FROM");
            TABLESOURCE();
            SELECT17();
            

        }
        else{
             SELECT12();
        }
    }
    public void SELECT12(){
        if (l == "WHERE"){
            match("WHERE");
            SEARCHCWMATCH();
            SELECT13();
            

        }
        else{
             SELECT13();
        }
    }
    public void SELECT13(){
        if (l == "GROUP"){
            match("GROUP");
            match("BY");
            E();
            SELECT14();
            

        }
        else{
             SELECT14();
        }
    }
    public void SELECT14(){
        if (l == "HAVING"){
            match("HAVING");
            AGG_FN2();
            SEARCHCWMATCH();
            SELECT15();
            

        }
        else{
             SELECT15();
        }
    }
    public void SELECT15(){
        if (l == "ORDER"){
            match("ORDER");
            match("BY");
            ORDER();
            

        }
        else{
             //VACIO
        }
    }
    public void SELECT17(){
        if (l == "COMMA"){
            match("COMMA");
            TABLESOURCE();
            SELECT17();
            
            

        }
        else{
            SELECT12();
        }
    }
   public void TABLESOURCE(){
      if (l == "ARROBA"){
          match("ARROBA");
          match("IDENTIFICADOR");
          TABLESOURCE1();
          return;
      }
      if (l == "OPENQUERY"| l == "OPENDATASOURCE"){
          ROWSET();
          TABLESOURCE1();
          return;
      }
      if (l == "IDENTIFICADOR"){
        TB_VNAME();
        TABLESOURCE1();
        TABLESOURCE2();
        return;
      }
      else{
        //JOINTB();
      }
       
       
   }
   public void JOINTB(){
       if (l == "PARENTESISOP"){
           match("PARENTESISOP");
           match("JOIN");
           match("PARENTESISCLO");
       }
    
       else{
           TABLESOURCE();
           JOINTB1(); 
           return;
       }
   }
   
   public void JOINTB1(){
       if (l == "CROSS"){
           match("CROSS");
           match("COMMA");
           match("JOIN");
           JOINTB4();
           return;
       }
       if (l=="INNER"||l == "LEFT"||l == "RIGHT"||l == "FULL"){
           JOIN_TYPE();
           JOINTB3();
           return;
       }
       else{
           //VACIO
       }
   }
   public void JOINTB2(){
       if (l == "CROSS"){
           match("CROSS");
           match("COMMA");
           match("JOIN");
           JOINTB4();
           return;
       }
       if (l=="INNER"||l == "LEFT"||l == "RIGHT"||l == "FULL"){
           JOIN_TYPE();
           JOINTB3();
           return;
       }
       else{
           error();
       }
   }
   public void JOINTB3(){
       TABLESOURCE();
       match("ON");
       SEARCHCWMATCH();
       JOINTB4();
   }
   
   public void JOINTB4(){
       if(l=="INNER"||l == "LEFT"||l == "RIGHT"||l == "FULL"||l == "CROSS"){
           JOINTB2();
           return;
       }
       else{
           //VACIO
       }
   }
   
   public void  TB_VNAME(){
       match("IDENTIFICADOR");
       TB_VNAME1();
   }
   public void TB_VNAME1(){
       if (l == "PUNTO"){
           match("PUNTO");
           match("IDENTIFICADOR");
       }
       else{
           //VACIO
       }
   }
   public void ROWSET(){
       switch (l){
          case "OPENDATASOURCE":
              match("OPENDATSOURCE");
              match("PARENTESISOP");
              match("CADENA");
              match("COMMA");
              match("CADENA");
              match("PARENTESISCLO");
              break;
          case "OPENQUERY":
               match("OPENQUERY");
              match("PARENTESISOP");
              match("IDENTIFICADOR");
              match("COMMA");
              match("CADENA");
              match("PARENTESISCLO");
              break;
          default:
             error();
             break;
        }
   }
   public void TABLESOURCE1(){
      switch (l){
          case "AS":
              match("AS");
              match("IDENTIFICADOR");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          default:
             //VACIO
             break;
        }
   }
   public void TABLESOURCE2(){
       if (l == "CROSS"){
           SAM_CL();
           

        }
       else{
           //VACIO
       }
 
   }
   public void SAM_CL(){
       match("TABLESAMBLE");
       match("PARENTESISOP");
       SAM_CL1();
       match("PARENTESISCLO");
   }
   public void SAM_CL1(){
       SEXP();
       SAM_CL2();
   }
   public void SAM_CL2(){
       switch (l){
          case "PERCENT":
              match("PERCENT");
              break;
          case "ROWS":
              match("ROWS");
              break;
          default:
             //VACIO
             break;
        }
   }
   public void ORDER(){
       EXPRESSION();
       ORDER1();
   }
   
   public void ORDER1(){
      if (l == "COMMA"){
          match("COMMA");
          ORDER();
      }
      else{
          ORDER2();
      }
   }
   public void ORDER2(){
      if (l == "COLLATE"){
          match("COLLATE");
          ORDER3();
      }
      else{
          ORDER4();
      }
   }
   public void ORDER3(){
      if (l == "IDENTIFICADOR"){
          match("IDENTIFICADOR");
          ORDER4();
      }
      else{
          error();
      }
   }
   public void ORDER4(){
        switch (l){
          case "ASC":
              match("ASC");
              break;
          case "DESC":
              match("DESC");
              break;

          default:
             //VACIO
             break;
        }
    }
   public void JOIN_TYPE(){
       JOIN_TYPE1();
       match("JOIN");
   }
   public void JOIN_TYPE1(){
      if (l == "INNER"){
          match("INNER");
      }
      if (l == "LEFT"||l == "RIGHT"||l == "FULL"){
         JOIN_TYPE2();
      }
      else{
          //VACIO
      }
   }
    public void JOIN_TYPE2(){
        switch (l){
          case "LEFT":
              match("LEFT");
              JOIN_TYPE3();
              break;
          case "RIGHT":
              match("RIGHT");
              JOIN_TYPE3();
              break;
          case "FULL":
              match("FULL");
              JOIN_TYPE3();
              break;

          default:
             //VACIO
             break;
        }
    }
    public void JOIN_TYPE3(){
      if (l == "OUTER"){
          match("OUTER");
      }
    
      else{
          //VACIO
      }
   }
    public void A(){
        match("ALTER");
        A1();
        switch (l){
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
          case "GO":
              match("GO");
              Z();
              break;

          default:
             error();
             break;
        }
    }
    public void A1(){
        switch (l){
          case "VIEW":
              match("VIEW");
              ALTERV();
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              ALTERU();
              break;
          case "DATABASE":
              match("DATABASE");
              ALTERD();
              break;
          case "TABLE":
              match("TABLE");
              ALTERT();
              break;
              //FALTA INDEX
          default:
             error();
             break;
        }
    }
    public void ALTERV(){
        match("VIEW");
        ALTERV1();
        ALTERV3();
        match("AS");
        SELECT1();
        ALTERV5();
    }
    public void ALTERV1(){
        match("IDENTIFICADOR");
        ALTERV2();
    }
    public void ALTERV2(){
        if( l == "PUNTO"){
            match("PUNTO");
        match("IDENTIFICADOR");
        }
        else{
            //vacio
        }
 
    }
    public void ALTERV3(){
        if( l == "PARENTESISOP"){
            match("PARENTESISOP");
            match("IDENTIFICADOR");
            ALTERV4();
        }
        else{
            //vacio
        }
 
    }
    public void ALTERV4(){
        
        switch (l){
          case "COMMA":
              match("COMMA");
              match("IDENTIFICADOR");
              ALTERV4();
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              match("PARENTESISCLO");
              break;
          default:
             error();
             break;
        }

    }
    public void ALTERV5(){
        if(l == "WITH"){
            match("WITH");
            match("CHECK");
            match("OPTION");
        }
        else{
            //vacio
        }
    }
    public void ALTERU(){
        if(l == "IDENTIFIADOR"){
            match("IDENTIFICADOR");
        }
        else{
            error();
        }
    }
    public void ALTERD(){
        match("DATABASE");
        ALTERD1();
 
    }
    public void ALTERD1(){
        switch (l){
          case "CURRENT":
              match("CURRENT");
              ALTERD2();
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              ALTERD2();
              break;
          default:
             error();
             break;
        }
 
    }
    public void ALTERD2(){
        if(l == "COLLATE"){
            match("COLLATE");
            match("IDENTIFICADOR");
        }
        else{
            error();
        }
    }
    public void ALTERT(){
        match("TABLE");
        OBJECT();
        ALTER1();
    }
    public void ALTER1(){
        switch (l){
          case "ALTER":
              match("ALTER");
              match("COLUMN");
              match("IDENTIFICADOR");
              ALTERT1();
              break;
          case "ADD":
              match("ADD");
              ALTERT8();
              break;
          case "DROP":
              match("DROP");
              ALTERT10();
              break;
          default:
             error();
             break;
        }
    }
    public void ALTERT1(){
        if(l == "IDENTIFICADOR"){
            match("IDENTIFICADOR");
            ALTERT2();
        }
        else{
            ALTERT6();
        }
    }
    public void ALTERT2(){
        if(l == "PUNTO"){
            match("PUNTO");
            match("IDENTIFICADOR");
            ALTERT3();
        }
        else{
            ALTERT3();
        }
    }
    public void ALTERT3(){
        if(l == "PARENTESISOP"){
            match("PARENTESISOP");
            match("ENTERO");
            ENT();
            match("PARENTESISCLO");
            ALTERT4();
        }
        else{
            ALTERT4();
        }
    }
    public void ENT(){
        if(l == "COMMA"){
            match("COMMA");
            match("ENTERO");
        }
        else{
            //VACIO
        }
    }
    public void ALTERT4(){
        if(l == "COLLATE"){
            match("COLLATE");
            match("IDENTIFICADOR");
            ALTERT5();
        }
        else{
            ALTERT5();
        }
    }
    public void ALTERT5(){
       switch (l){
          case "NULL":
              match("NULL");
              break;
          case "NOT":
              match("NOT");
              match("NULL");
              break;
          default:
             //VACIO
             break;
        }
    }
    public void ALTERT6(){
       switch (l){
          case "ADD":
              match("ADD");
              ALTERT7();
              break;
          case "DROP":
              match("DROP");
              ALTERT7();
              break;
          default:
             error();
             break;
        }
    }
    public void ALTERT7(){
       switch (l){
          case "NOT":
              match("NOT");
              match("FOR");
              match("REPLICATION");
              break;
          case "ROWGUIDCOL":
              match("ROWGUIDCOL");
              break;
          default:
             error();
             break;
        }
    }
    public void ALTERT8(){
       
      if (l == "INNER"){
          COLDEF();
          ALTERT9();
      }
      if (l == "LEFT"||l == "RIGHT"||l == "FULL"){
         CCD();
         ALTERT9();
      }
      if (l == "LEFT"||l == "RIGHT"||l == "FULL"){
         TABLECON();
         ALTERT9();
      }
      else{
          error();
      }
    }
    public void ALTERT9(){
        if (l == "COMMA"){
          match("COMMA");
          ALTERT8();
      }
        else{
         //VACIO   
        }
    }
    public void ALTERT10(){
        if( l == "COLUMN"){
            match("COLUMN");
            ALTERT12();
            match("IDENTIFICADOR");
            ALTERT13();
        }
        else{
            ALTERT11();
            ALTERT12();
            match("IDENTIFICADOR");
            ALTERT13();
        }
    }
    public void ALTERT11(){
        if( l == "CONSTRAINT"){
            match("CONSTRAINT");
        }
        else{
            //VACIO
        }
    }
    public void ALTERT12(){
        if( l == "IF"){
            match("IF");
            match("EXISTS");
        }
        else{
            //VACIO
        }
    }
     public void ALTERT13(){
        if( l == "COMMA"){
            match("COMMA");
            match("IDENTIFICADOR");
            ALTERT13();
        }
        else{
            //VACIO
        }
    }
     public void COLDEF(){
         DATATYPE();
         COLDEF2();
     }
     public void COLDEF2(){
         if (l == "COLLATE"){
             match("COLLATE");
             match("IDENTIFICADOR");
             COLDEF3();
         }
         else{
             COLDEF3();
         }
     }
      public void COLDEF3(){
         if (l == "CONSTRAINT"){
             match("CONSTRAINT");
             match("IDENTIFICADOR");
             COLDEF4();
         }
         else{
             COLDEF4();
         }
     }
      public void COLDEF4(){
         if (l == "DEFAULT"){
             match("DEFAULT");
             CONST();
             COLDEF5();
         }
         else{
             COLDEF5();
         }
     }
      public void COLDEF5(){
         if (l == "IDENTITY"){
             match("IDENTITY");
             COLDEF6();
         }
         else{
             COLDEF7();
         }
     }
      public void COLDEF6(){
         if (l == "PARENTESISOP"){
             match("PARENTESISOP");
             SEED();
             match("COMMA");
             SEED();
             match("PARENTESISCLO");
             COLDEF7();
         }
         else{
             COLDEF7();
         }
     }
       public void COLDEF7(){
         if (l == "NOT"){
             match("NOT");
             
             COLDEF8();
         }
         else{
             COLDEF9();
         }
     }
       
       public void COLDEF8(){
          switch (l){
          case "FOR":
              match("FOR");
              match("REPLICATION");
              COLDEF9();
              break;
          case "NULL":
              match("NULL");
              COLDEF10();
              break;
          default:
             error();
             break;
        }
     }
       public void COLDEF9(){
          switch (l){
          case "NOT":
              match("NOT");
              match("NULL");
              COLDEF10();
              break;
          case "NULL":
              match("NULL");
              COLDEF10();
              break;
          default:
             COLDEF10();
             break;
        }
     }
       public void COLDEF10(){
         if (l == "ROWGUIDCOL"){
             match("ROWGUIDCOL");
             
             COLDEF11();
         }
         else{
             COLDEF11();
         }
     }
      
       public void COLDEF11(){
         if (l == "CONSTRAINT"){
             COLUMNCONSTRAINT();
             COLDEF13();
             COLDEF12();
         }
         else{
             COLDEF12();
         }
     }
       public void COLDEF12(){
         if (l == "INDEX"){
             COL_IND();
         }
         else{
             //VACIO
         }
     }
       public void COLDEF13(){
         if (l == "COMMA"){
             match("COMMA");
             COLUMNCONSTRAINT();
             COLDEF13();
             COLDEF12();
         }
         else{
             //VACIO
         }
     }
       public void SEED(){
           switch (l){
          case "ENTERO":
              match("ENTERO");

              break;
          case "NUMERALDOBLE":
              match("NUMERALDOBLE");
              break;
          default:
             error();
             break;
        }
    }
       public void COLUMNCONSTRAINT(){
            if (l == "CONSTRAINT"){
             match("CONSTRAINT");
             match("IDENTIFICADOR");
             COLUMNC2();
         }
         else{
             COLUMNC2();
         }
       }
      public void COLUMNC2(){
          switch (l){
          case "PRIMARY":
              match("PRIMARY");
              match("KEY");
              COLUMNC3();
              break;
          case "UNIQUE":
              match("UNIQUE");
              COLUMNC3();
              break;
          case "FOREIGN":
              match("FOREIGN");
              COLUMNC5();
              break;
          case "REFERENCES":
              match("REFERENCES");
              COLUMNC5();
              break;
           case "CHECK":
              match("CHECK");
              COLUMNC16();
              break;
          default:
             error();
             break;
        }
      }
      public void COLUMNC3(){
          switch (l){
          case "CLUSTERED":
              match("CLUSTERED");
              COLUMNC4();
              break;
          case "NONCLUSTERED":
              match("NONCLUSTERED");
              COLUMNC4();
              break;
          default:
             COLUMNC4();
             break;
        }
      }
      public void COLUMNC4(){
          switch (l){
          case "ON":
              match("ON");
              match("IDENTIFICADOR");
              match("PARENTESISOP");
              match("IDENTIFICADOR");
              match("PARENTESISCLO");
              break;
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              break;
          default:
             //VACIO
             break;
        }
      }
      public void COLUMNC5(){
          if (l == "FOREIGN"){
             match("FOREIGN");
             match("KEY");
             COLUMNC6();
         }
         else{
             COLUMNC6();
         }
      }
      public void COLUMNC6(){
          match("REFERENCES");
          match("IDENTIFICADOR");
          COLUMNC7();
      }
      public void COLUMNC7(){
          if (l == "PUNTO"){
             match("PUNTO");
             match("IDENTIFICADOR");
             COLUMNC8();
         }
         else{
             COLUMNC8();
         }
      }
      public void COLUMNC8(){
          if (l == "PARENTESISOP"){
             match("PARENTESISOP");
             match("IDENTIFICADOR");
             COLUMNC10();
             match("PARENTESISCLO");
             COLUMNC9();
             
         }
         else{
             COLUMNC9();
         }
      }
      public void COLUMNC10(){
          if (l == "COMMA"){
             match("COMMA");
             match("IDENTIFICADOR");
             COLUMNC10();
             
         }
         else{
             //VACIO
         }
      }
      public void COLUMNC9(){
          if (l == "ON"){
             match("ON");
             COLUMNC11();
             
         }
         else{
             COLUMNC15();
         }
      }
      public void COLUMNC11(){
          switch (l){
          case "DELETE":
              match("DELETE");
              COLUMNC12();
              COLUMNC14();
              break;
          case "UPDATE":
              match("UPDATE");
              COLUMNC12();
              COLUMNC14();
              break;
          default:
            error();
             break;
        }
      }
      public void COLUMNC12(){
          switch (l){
          case "NO":
              match("NO");
              match("ACTION");
              break;
          case "CASCADED":
              match("CASCADED");
              break;
           case "SET":
              match("SET");
              COLUMNC13();
              break;
          default:
            error();
             break;
        }
      }
      public void COLUMNC13(){
          switch (l){
          case "NULL":
              match("NULL");

              break;
          case "DEFAULT":
              match("DEFAULT");
              break;
          default:
            error();
             break;
        }
      }
      public void COLUMNC14(){
          if (l == "ON"){
             match("ON");
             match("UPDATE");
             COLUMNC12();
             COLUMNC15();
             
         }
         else{
             COLUMNC15();
         }
      }
      public void COLUMNC15(){
          if (l == "NOT"){
             match("NOT");
             match("FOR");
             match("REPLICATION");
             
         }
         else{
             //VACIO
         }
      }
      public void COLUMNC16(){
          if (l == "CHECK"){
             match("CHECK");
             COLUMNC15();
             match("PARENTESISOP");
             EXPRESSION();
             match("PARENTESISCLO");
             
         }
         else{
             //VACIO
         }
      }
      public void COL_IND(){
          if (l == "INDEX"){
             match("INDEX");
             match("IDENTIFICADOR");
             COL_IND1();
             COL_IND2();
             
         }
         else{
             error();
         }
      }
      public void COL_IND1(){
          switch (l){
          case "CLUSTERED":
              match("CLUSTERED");
              break;
          case "NONCLUSTERED":
              match("NONCLUSTERED");
              break;
          default:
            //VACIOS
             break;
        }
      }
      public void COL_IND2(){
          COLUMNC4();
      }
      public void CCD(){
          match("AS");
          match("IDENTIFICADOR");
          COLUMNC2();
      }
      public void TABLECON(){
          if (l == "CONSTRAINT"){
             match("CONSTRAINT");
             match("IDENTIFICADOR");
             TABLECON1();
             
         }
         else{
             TABLECON1();
         }
      }
      public void TABLECON1(){
          switch (l){
          case "PRIMARY":
              match("PRIMARY");
              match("KEY");
              TABLECON2();
              TABLECON3();
              break;
          case "UNIQUE":
              match("UNIQUE");
              TABLECON2();
              TABLECON3();
              break;
          case "FOREIGN":
              match("FOREIGN");
              match("KEY");
              match("PARENTESISOP");
              match("IDENTIFICADOR");
              TABLECON7();
              match("PARENTESISCLO");
              COLUMNC6();
              break;
           case "CHECK":
              match("CHECK");
              COLUMNC16();
              break;
          default:
             error();
             break;
        }
      }
      public void TABLECON2(){
          switch (l){
          case "CLUSTERED":
              match("CLUSTERED");
              break;
          case "NONCLUSTERED":
              match("NONCLUSTERED");
              break;
          default:
            //VACIOS
             break;
        }
      }
      public void TABLECON3(){
          if (l == "PARENTESISOP"){
             match("PARENTESISOP");
             TABLECON1();
             match("PARENTESISCLO");
             COLUMNC4();
             
         }
         else{
             error();
         }
      }
      public void TABLECON8(){
          if (l == "IDENTIFICADOR"){
             match("IDENTIFICADOR");
             TABLECON4();
             
         }
         else{
             error();
         }
      }
      public void TABLECON4(){
          switch (l){
          case "ASC":
              match("ASC");
              TABLECON6();
              break;
          case "DESC":
              match("DESC");
              TABLECON6();
              break;
          default:
            TABLECON6();
             break;
        }
      }
      public void TABLECON6(){
          if (l == "COMMA"){
             match("COMMA");
             TABLECON8();
             
         }
         else{
             //VACIO
         }
      }
      public void TABLECON7(){
          if (l == "COMMA"){
             match("COMMA");
             match("IDENTIFICADOR");
             TABLECON7();
             
         }
         else{
             //VACIO
         }
      }
      public void DATATYPE(){
          if (l == "IDENTIFICADOR"){
             match("IDENTIFICADOR");
             DATATYPE2();
             
         }
         else{
             DATATYPE3();
         }
      }
      public void DATATYPE2(){
          if (l == "PUNTO"){
             match("PUNTO");
             match("IDENTIFICADOR");
             
         }
         else{
            error();
         }
      }
      public void DATATYPE3(){
           switch (l){
          case "BIT":
              match("BIT");
              DATATYPE4();
              break;
          case "INT":
              match("INT");
              DATATYPE4();
               break;
          case "INTEGER":
              match("INTEGER");
              DATATYPE4();
              break;
          case "FLOAT":
              match("FLOAT");
              DATATYPE4();
          case "VARCHAR":
              match("VARCHAR");
              DATATYPE4();
           case "DATE":
              match("DATE");
              DATATYPE4();
           case "REAL":
              match("REAL");
              DATATYPE4();
           case "DECIMAL":
              match("DECIMAL");
              DATATYPE4();
            case "NUMERIC":
              match("NUMERIC");
              DATATYPE4();
            case "SMALLINT":
              match("SMALLINT");
              DATATYPE4();
             case "TIME":
              match("TIME");
              DATATYPE4();
            case "CHAR":
              match("CHAR");
              DATATYPE4();
            case "NCHAR":
              match("NCHAR");
              DATATYPE4();
          default:
            TABLECON6();
             break;
        }
      }
       public void DATATYPE4(){
          if (l == "PARENTESISOP"){
             match("PARENTESISOP");
             match("ENTERO");
             DATATYPE5();
         }
         else{
            //VACIO
         }
      }
       public void DATATYPE5(){
          if (l == "COMMA"){
             match("COMMA");
             match("ENTERO");
             match("PARENTESISCLO");
             
         }
         else{
           match("PARENTESISCLO");
         }
      }
       public void TBIN(){
           match("INDEX");
           match("INDENTIFICADOR");
           TABLECON2();
           match("PARENTESISOP");
           TABLECON8();
           match("PARENTESISCLO");
           COLUMNC4();
       }
       public void C(){
           match("CREATE");
           CREATEP();
           FINSENTENCIA();
       }
       public void CREATEP(){
           switch (l){
          case "TABLE":
              match("TABLE");
              CREATET1();
              break;
           case "USER":
              match("USER");
              CREATEU1();
              break;
            case "VIEW":
              match("VIEW");
              CREATEV1();
              break;
            case "DATABASE":
              match("DATABASE");
              CREATED1();
              break;
            case "UNIQUE":
              PREINDEXU();
              PREINDEXC();
              match("INDEX");
              CREATEI1();
              break;
          default:
            error();
             break;
        }
       }
       public void CREATEI1(){
           match("IDENTIFICADOR");
           match("ON");
           OBJECT();
           match("PARENTESISOP");
           TABLECON8();
           match("PARENTESISCLO");
           CREATEI2();
       }
       public void CREATEI2(){
           if (l == "INCLUDE"){
             match("INCLUDE");
             match("PARENTESISOP");
             match("IDENTIFICADOR");
             TABLECON7();
             match("PARENTESISCLO");

             
         }
         else{
           //VACIO
         }
       }
       public void PREINDEXU(){
           if (l == "UNIQUE"){
             match("UNIQUE");

             
         }
         else{
           //VACIO
         }
       }
       public void PREINDEXC(){
           switch (l){
          case "CLUSTERED":
              match("CLUSTERED");

              break;
          case "NONCLUSTERED":
              match("NONCLUSTERED");

              break;
          default:
            //VACIO
             break;
           }
       }
       public void CREATEU1(){
           if (l == "IDENTIFICADOR"){
             match("IDENTIFICADOR");

             
         }
         else{
           error();
         }
       }
       public void CREATEV1(){
           if (l == "PUNTO"){
               match("PUNTO");
             match("IDENTIFICADOR");
             CREATEV3();
             
         }
         else{
           CREATEV3();
         }
       }
       public void CREATEV3(){
           if (l == "PARENTESISOP"){
               match("PARENTESISOP");
             match("IDENTIFICADOR");
             TABLECON7();
             match("PAENTESISCLO");
             
             
         }
         else{
           //vacio
         }
       }
       public void CREATET1(){
          OBJECT();
          match("PARENTESISOP");
          CREATET2();
          match("PARENTESISCLO");
          CREATET5();
      }
       public void CREATET2(){
           switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              CREATET4();
              COLUMNC4();
              break;
           case "CONSTRAINT":
              TABLECON();
              CREATET3();
              COLUMNC4();
              break;
          default:
            TBIN();
            COLUMNC4();
             break;
        }
       }
       public void CREATET3(){
          if (l == "COMMA"){
             match("COMMA");
             TABLECON();
             CREATET3();
             
         }
         else{
           //VACIO
         }
      }
       public void CREATET4(){
          if (l == "AS"){
             CCD();
             
         }
         else{
           COLDEF();
         }
      }
       public void CREATET5(){
            if (l == "COMMA"){
                match("COMMA");
                CREATET2();
             
         }
         else{
           //VACIO
         }
       }
       public void CREATED1(){
           match("IDENTIFICADOR");
           CREATED2();
       }
       public void CREATED2(){
           match("COLLATE");
           match("IDENTIFICADOR");
       }
       public void FINSENTENCIA(){
            switch (l){
          case "PUNTOCOMA":
              match("PUNTOCOMA");
              Z();
              break;
           case "GO":
               match("GO");
               Z();
              break;
          default:
            error();
             break;
        }
       }
   
    
// FUNCIONES DE ANALISIS Y ERRROR ////////////////////////////////////////////////////////////////////////////////////   
  public void match(String t){
      if ((l == t)&& (posicion < ll.size()-2)){
          
          posicion = posicion +2;
          l=ll.get(posicion);
          return;
      }
      if ((l == t) && posicion == ll.size()-2){
          terminado();
      }
      else{
          error();
      }
          
      
  }
  public void error(){
      resultado2 += l + " Error Sintantico " + " En Linea: " + ll.get(posicion+1) + "\n" ;
      while ((l != "PUNTOCOMA" && l != "GO") && (posicion < ll.size()-2)){
          posicion = posicion + 2;
          l= ll.get(posicion);
      }
      if(((l != "PUNTOCOMA") && (l != "GO")) && (posicion == ll.size()-2)){
           resultado2 +=  "Error Sintantico falto PUNTOCOMA o GO " + " En Linea: " + ll.get(posicion+1) + "\n" ;
      }
      if(posicion != ll.size()-2){
         posicion = posicion + 2;
      l = ll.get(posicion);
      Z(); 
      }
      else{
          terminado();
          
      }
      
      
  }
  public void terminado() {
      if( l != "PUNTOCOMA" && l != "GO" ){
           resultado2 += "Error Sintantico falto PUNTOCOMA o GO " + " En Linea: " + ll.get(posicion+1) + "\n" ;
      }
      resultado2 += "Fin";
      
        FileWriter w = null;
        try {
            w = new FileWriter("Salida2.out");
        } catch (IOException ex) {
            Logger.getLogger(SintacticoDescendente.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (BufferedWriter bw = new BufferedWriter(w)) {
            PrintWriter wr = new PrintWriter(bw);
            
            wr.write(resultado2);
            wr.close();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(SintacticoDescendente.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.exit(0); 
  }
}
