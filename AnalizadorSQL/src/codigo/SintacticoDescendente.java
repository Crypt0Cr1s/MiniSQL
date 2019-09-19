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
            posicion= posicion +1;
            l=ll.get(posicion);
            DR();
          case "TRUNCATE":
            //  T();
          
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
  public void match(String t){
      if (l==t){
          posicion = posicion +1;
          
      }
      else{
          
      }
          
      
  }
}
