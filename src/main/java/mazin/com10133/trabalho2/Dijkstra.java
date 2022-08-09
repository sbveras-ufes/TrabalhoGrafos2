package mazin.com10133.trabalho2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Dijkstra {
    static final int maxInt=2147483647;
    
    public static int[] Dijkstra(List<No> g,int s, int[] path)
{
     
    
    int[] dist = new int[g.size()];
 

    boolean[] visitado = new boolean[g.size()];
    for(int i = 0; i < g.size(); i++)
    {
        visitado[i] = false;
        path[i] = -1;
        dist[i] = maxInt;
    }
    dist[s] = 0;
    path[s] = -1;
    int atual = s;
 
   
    Set<Integer> sett = new HashSet<>();
    while (true)
    {
         

        visitado[atual] = true;
        for(int i = 0;
                i < g.get(atual).filhos.size();
                i++)
        {
            int v = g.get(atual).filhos.get(i).vertice;
             
            if (visitado[v])
                continue;
 
           
            sett.add(v);
            int alt = dist[atual]+g.get(atual).filhos.get(i).custo;
 
           
            if (alt < dist[v])
            {
                dist[v] = alt;
                path[v] = atual;
            }
        }
        sett.remove(atual);
         
        if (sett.isEmpty())
            break;
 
       
        int minDist = maxInt;
        int index = 0;
 
        
        for(int a : sett)
        {
            if (dist[a] < minDist)
            {
                minDist = dist[a];
                index = a;
            }
        }
        atual = index;
    }
    return dist;
 }
} 

