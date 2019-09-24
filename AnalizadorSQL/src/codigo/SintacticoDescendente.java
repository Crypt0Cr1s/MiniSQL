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
            //  D();
          case "CREATE":
            //  C();
          case "ALTER":
            //  A();
          case "DROP":
            DR();
          case "TRUNCATE":
            T();
          
          default: 
              
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
              match("LOGIN");
              match("INDENTIFICADOR");
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
        if (l=="OBJECT"){
            match("OBJECT");
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
          case "EPSILON":
             
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
          case "EPSILON":
             
      }
  }
  public void DRI2(){
      if (l=="IF"){
          match("IF");
          match("EXISTS");
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
            match("OBJECT");
            DRI6();
          case "PUNTO":
            match("PUNTO");
            match("IDENTIFICADOR");
            DRI5();
      }
      
  }
  public void DRI5(){
      if(l=="PUNTO"){
          match("PUNTO");
          match("IDENTIFICADOR");
          DRI6();
      }
      else{
          DRI6();
      }
  }
  public void DRI6(){
      if (l=="COMMA"){
          match("COMMA");
          DRI3();
      }
      else{
          //
      }
          
  }
  public void DRW2(){
    if (l=="IF"){
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
          default:
       
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
      if(l=="PUNTOCOMA"){
          match("PUNTOCOMA");
          
      }
      else{
           
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
  public void match(String t){
      if (l==t){
          posicion = posicion +1;
          l=ll.get(posicion);
      }
      
          
      
  }
}
