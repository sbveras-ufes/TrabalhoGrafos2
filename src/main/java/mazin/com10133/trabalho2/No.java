/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazin.com10133.trabalho2;

import java.util.ArrayList;
import java.util.List;


public class No {
    int verticeNumber;
    List<VerticeAresta> filhos;
 
    No(int verticeNumber)
    {
        this.verticeNumber = verticeNumber;
        filhos = new ArrayList<>();
    }
 
   
    void add_filho(int vNumber, int vCusto){
        var va= new VerticeAresta(vNumber, vCusto);
        filhos.add(va);
    }
    
     void rem_allfilho()
    {

        filhos.removeAll(filhos);
    }
     
}
 


