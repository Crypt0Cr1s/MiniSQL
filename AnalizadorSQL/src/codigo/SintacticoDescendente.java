/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author cristobal
 */
public class SintacticoDescendente {
    public ArrayList <String> ll = new ArrayList();
    public String l;
    public int posicion =0;
  public void parsear(ArrayList<String> token){
      ll=token;
      l=ll.get(posicion);
      Z();
    }
  public void Z (){
      switch (l){
          case "SELECT":
        //      S();
          case "INSERT":
          //    I();
          case "UPDATE":
            //  U();
          case "DELETE":
              D();
          case "CREATE":
            //  C();
          case "ALTER":
            //  A();
          case "DROP":
            DR();
          case "TRUNCATE":
            T();
          
          default: 
              error();
              
      }
  }
  public void DR(){
      switch (l){
          case "DROP":
              match("DROP");
              DR1();
          
      }
  }
  public void DR1(){
      switch (l){
          case "TABLE":
              match ("TABLE");
              DRT2();
          case "DATABASE":
              match ("DATABASE");
              DRD2();
          case "LOGIN":
              DRL();
          case "INDEX":
              match("INDEX");
              DRI2();
          case "VIEW":
              match("VIEW");
              DRW2();
         
      }
  }
  public void DRT2(){
      switch (l){
          case "IF":
              match("IF");
              match("EXISTS");
              DRT3();
          default:
              DRT3();
      }
  }
  public void DRT3(){
        if (l=="IDENTIFICADOR"){
            OBJECT();
            DRT6();
        }
  }
  public void DRT6(){
      switch (l){
          case "COMMA":
              match ("COMMA");
              DRT3();
          case "PUNTOCOMA":
              match("PUNTOCOMA");
          case "GO":
              match("GO");
          default:
             error();
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
          //error
      }
  }
  public void DRD4(){
      switch (l){
          case "COMMA":
              match ("COMMA");
              DRD3();
          case "PUNTOCOMA":
              match("PUNTOCOMA");
          case "GO":
              match("GO");
          default:
             error();
      }
  }
  public void DRL(){
      if(l == "IDENTIFICADOR"){
          match("IDENTIFICADOR");
          if(l == "PUNTOCOMA"){
              match("PUNTOCOMA");
              //Z();
          }
          if(l == "GO"){
              match("GO");
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
          //error
      }
  }
  public void DRI4(){
      switch (l){
          case "ON":
            match("ON");
            OBJECT();
            DRI6();
          case "PUNTO":
            match("PUNTO");
            match("IDENTIFICADOR");
            DRI5();
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
          
      }
      if (l == "GO"){
          match("GO");
          
      }
      else{
          //
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
        //ERRO
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
          case "PUNTOCOMA":
            match("PUNTOCOMA");
          case "GO":
              match("GO");
          default:
              error();
      }
  }
  public void T(){
      switch (l){
          case "TRUNCATE":
            match("TRUNCATE");
            match("TABLE");
            OBJECT();
            T4();
          
          default:
       
      }

  }
  public void T4(){
      switch (l){
          case "WITH":
            match("WITH");
            match("PARENTESISOP");
            match("PARTITION");
            match("PARENTESISOP");
            T5();
          
          default:
              T8();
      }
  }
  public void T5(){
      if (l=="ENTERO"){
          match("ENTERO");
          T6();
      }
      else{
          //error
      }
  }
  public void T6(){
      if(l=="TO"){
          match("TO");
          match("ENTERO");
          T7();
      }
      else{
          T7();
      }
  }
  public void T7(){
      if(l=="COMMA"){
          match("COMMA");
          T5();
      }
      else{
           match("PARENTESISCLO");
           match("PARENTESISCLO");
           T8();
      }
      
  }
  
  public void T8(){
      switch (l){
          case "PUNTOCOMA":
            match("PUNTOCOMA");
          case "GO":
              match("GO");
          default:
              error();
      }
  }
  public void OBJECT(){
      if(l=="IDENTIFICADOR"){
          match("IDENTIFICADOR");
          OBJ2();
      }
  }
  public void OBJ2(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          OBJ3();
      }
  }
   public void OBJ3(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          
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
          
          default:
              D4();
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
          case "ARROBA":
            match("ARROBA");
            TABLESOURCE();
            D6();
          default:
              //ERROR
      }
   }
   public void D6(){
       if (l == "OUTPUT"){ // COMO ARREGLAR ESTO???
           OUTPUTC();
           match("OUTPUT");
           D7();
       }
       else {
           D7();
       }
   }
   public void D7(){
       if (l == "FROM"){
           match("FROM");
           TABLESOURCE();
           D8();
       }
       else {
           D9();
       }
   }
   public void D8(){
       if (l == "COMMA"){
           match("COMMA");
           TABLESOURCE();
           D8();
       }
       else {
           D9();
       }
   }
   public void D9(){
        if (l == "WHERE"){
           match("WHERE");
           SEARCHC();
           D10();
       }
       else {
           D10();
       }
   }
   public void D10(){
       if (l == "PUNTOCOMA"){
           match("PUNTOCOMA");
           Z();
       }
       else {
           ///ERROR
       }
   }
   public void SEARCHC(){
       SEARCHCWMATCH();
       
   }
   
   public void SEARCHCWMATCH(){
       switch (l){
          case "NOT":
            match("NOT");
            PRED();
            SCWM2();
          case "PARENTESISOP":
            match("PARENTESISOP");
            SEARCHCWMATCH();
            match("PARENTESISCLO");
            SCWM2();
          default:
              PRED();
              SCWM2();
      }
   }
   
   public void SCWM2(){
        switch (l){
          case "AND":
            match("AND");           
            SCWM3();
          case "OR":
            match("OR");
            SCWM3();
          default:
            SCWM5();
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
       if (l == "COMMA"){
           match("COMMA");
           SEARCHCWMATCH();
           
       }
       else {
           ///no entiendo que dice
       }
   }
   public void PRED(){
       switch (l){
          case "STRING":
            match("STRING");           
            NOT1();
            match("LIKE");
            match("STRING");  
          case "CONTAINS":
            match("CONTAINS");
            match("PARENTESISOP");
            FT1();
            match("PUNTO");
            CSC1();
            match("PARENTESISCLO");
          case "FREETEXT":
            match("FREETEXT");
            match("PARENTESISOP");
            FT1();
            match("COMMA");
            match("STRING");
              
          default:
            E();
            PRED1();
            //ERROR
      }
   }
   public void PRED1(){
       switch (l){
          case "IS":
            match("IS");           
            NOT1();
            match("NULL");
          case "COMPARADOR":
            match("COMPARADOR");
            E();
          default:
            NOT1();
            PRED3();
      }
   }
   public void NOT1(){
       if (l == "NOT"){
           match("NOT");
       }
       else{
           
       }
   }
   
   public void FT1(){
      switch (l){
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");           
            
          case "ASTERISCO":
            match("ASTERISCO");
            
          default:
            //ERROR
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
          case "STRING":
            match("STRING");           
            
          case "PARENTESISOP":
            match("PARENTESISOP");
            CSC1();
            match("PARENTESISCLO");
            CSC2();
            
          default:
            //ERROR
      }
   }
   public void CSC2(){
       switch (l){
          case "AND":
            match("AND");           
            CSC3();
          case "OR":
            match("OR");
            CSC1();
          case "Or":
            match("Or");
            CSC1();
          case "And":
            match("And");
            CSC1();
          default:
            //ERROR
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
          case "MENOS":
            match("MENOS");
            H();
            EPRIMA();
          default:
            //NADA
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
          case "DIV":
            match("DIV");
            L();
            HPRIMA();
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
       if (l == "NULL"|l == "INT"|l == "FLOAT"|l == "STRING"){
          CONST();
       }
       if (l == "AVG"|l == "COUNT"|l == "MAX"|l == "MIN"|l == "SUM"){
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
          case "MENOS":
            match("MENOS");
            H2();
            E2PRIMA();
          default:
            //NADA
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
          case "DIV":
            match("DIV");
            L2();
            H2PRIMA();
          default:
            //NADA
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
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");
          case "ARROBA":
            match("ARROBA");
            match("IDENTIFICADOR");
          case "FLOAT":
            match("FLOAT");
          case "ENTERO":
            match("ENTERO");
          default:
            //NADA
      }
   }
   public void CONST(){
       switch (l){
          case "NULL":
            match("NULL");
            
          case "ENTERO":
            match("ENTERO");
          case "FLOAT":
            match("FLOAT");
          case "STRING":
            match("STRING");
          default:
            //ERROR
      }
   }
   
   public void FUNC(){
       switch (l){
          case "AVG":
            match("AVG");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
          case "COUNT":
            match("COUNT");
            match("PARENTESISOP");
            FUNC3();
            match("PARENTESISCLO");
          case "MAX":
            match("MAX");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
          case "MIN":
            match("MIN");
            match("PARENTESISOP");
            FUNC2();
            match("PARENTESISCLO");
          default:
            //ERROR
      }
   }
   public void FUNC2(){
       switch (l){
          case "ALL":
            match("ALL");
          case "DISTINCT":
            match("DISTINCT");
          default:
            FUNC4();
      }
   }
   
   public void FUNC4(){
       switch (l){
          case "IDENTIFICADOR":
            match("IDENTIFICADOR");
            FUNC5();
          case "ENTERO":
            match("ENTERO");
            FUNC5();
          case "FLOAT":
            match("FLOAT");
            FUNC5();
          case "ARROBA":
            match("ARROBA");
            match("IDENTIFICADOR");
            FUNC5();
          default:
            //ERROR
      }
   }
   public void FUNC5(){
        if (l == "MAS"|l == "MENOS"|l == "DIV"|l == "ASTERISCO"|l == "MENOR"|l == "MENORIGUAL"|l == "MAYOR"|l == "MAYORIGUAL"|l == "NOIGUAL"){
          OPERADORES();
       }
   }
   public void OPERADORES(){
       switch (l){
          case "MAS":
            match("MAS");

          case "MENOS":
            match("MENOS");
          case "ASTERISCO":
            match("ASTERISCO");
          case "DIV":
            match("DIV");
          case "MENOR":
            match("MENOR");
          case "MENORIGUAL":
            match("MENORIGUAL");
          case "MAYOR":
            match("MAYOR");
          case "MAYORIGUAL":
            match("MAYORIGUAL");
           case "NOIGUAL":
            match("NOIGUAL");
          default:
            //ERROR
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
      }
   }
   public void UPD2(){
       switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              UPD3();
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
              UPD9();
          default:
      }
   }
   public void UPD3(){
       switch (l){
          case "IGUAL":
              match("IGUAL");
              UPD4();
          case "PUNTO":
              match("PUNTO");
              UPD5();
          default:
      }
   }
   public void UPD4(){
       switch (l){
          case "DEFAULT":
              match("DEFAULT");
              UPD8();
          case "NULL":
              match("NULL");
              UPD8();
          default:
              E();
              UPD8();
      }
   }
    public void UPD5(){
       switch (l){
          case "IDENTIFICADOR":
              match("IDENTIFICADOR");
              UPD6();
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
          default:
              error();
      }
   }
    public void UPD7(){
        switch (l){
          case "Entero":
              match("Entero");
          case "NULL":
              match("NULL");
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
          default:
             error();
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
          case "PARENTESISOP":
              match("PARENTESISOP");
              ARGUMENT();
              match("PARENTESISCLO");
              UPD8();
          default:
             error();
      }
    }
    public void FINALQUERY(){
        if (l == CAMBAR){
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
            SEARCHC();
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
          case "GO":
              match("GO");
              Z();
          default:
             error();
      }
    }
    public void ARGUMENT(){
        if (l == "STRING"){
            match("STRING");
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
          case "ARROBA":
              match("ARROBA");
              match("IDENTIFICADOR");
          default:
             ROWSETF();
             WH();
      }
    }
    public void ROWSETF(){
        switch (l){
          case "OPENROWSET":
              match("OPENROWSET");
              OPROW2();
          case "OPENQUERY":
              match("OPENQUERY");
              OPQUER2();
          default:
             error();
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
        
    }
    
// FUNCIONES DE ANALISIS Y ERRROR ////////////////////////////////////////////////////////////////////////////////////   
  public void match(String t){
      if (l==t){
          posicion = posicion +2;
          l=ll.get(posicion);
      }
      else{
          error();
      }
          
      
  }
  public void error(){
      while (l != ";"){
          posicion = posicion + 2;
          l= ll.get(posicion);
      }
      posicion = posicion + 2;
      l = ll.get(posicion);
      Z();
      
  }
}
