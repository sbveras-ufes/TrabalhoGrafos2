
package mazin.com10133.trabalho2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static mazin.com10133.trabalho2.Dijkstra.maxInt;


public class Main {
  
    
    public static void main(String[] args) throws Exception
{
    try {
        
var scanner = new Scanner(new File(args[0]));
var va =new int[2];

int x;
for(x=0;x<=1;x++){
    va[x]=scanner.nextInt();
}

    List<No> v = new ArrayList<>();
    int n = va[0]+1;
    int inico = Integer.parseInt(args[1]) ,fim=Integer.parseInt(args[2]) ,prob=Integer.parseInt(args[3]);
    

    for(int i = 0; i < n; i++)
    {
        No a = new No(i);
        v.add(a);
    }
    
    int a,b,c, j=0;
    while(scanner.hasNextInt()){
        if (j==va[1])break;
        
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        v.get(a).add_filho(b,c);
        v.get(b).add_filho(a,c);
        j++;
    } 
            

    for(int i=va[0];i>=(n-prob);i--){
        if(i==inico || i==fim) continue;
        v.get(i).rem_allfilho();
    }
  
    int[] path = new int[v.size()];
    int[] dist = Dijkstra.Dijkstra(v, inico, path);
    if(dist[fim]==maxInt) System.out.printf("JC não poderá realizar essa viagem") ;
    else{

        System.out.printf("Distância para vértice %d desde %d = %d \n",
                           fim,inico,dist[fim]);
    }
    
    } catch (Exception e) {
        System.out.println("Erro! \nUso: Trabalho2.jar (Arquivo com as informações do grafo).txt    (Cidade em que JC está) (Cidade que JC deseja visitar)  (Número de cidades em que JC está proibido de passar)");
    }
}
}

