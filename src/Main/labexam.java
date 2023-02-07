//Anik Lal Dey 
//ID 2020-1-60-228
// code 1
package Main;
import java.util.*;
import java.lang.*;
public class labexam{
public static int newdist;

       public static void dijkstra(int[][] dijkstra){
       int v=dijkstra.length;
       boolean visited[]=new boolean[v];
       int distance[]=new int[v];
       distance[0]=0;
       for(int i=1;i<v;i++){
       distance[i]=Integer.MAX_VALUE;
       }
       for(int i=0;i<v-1;i++){
       int minvertex=findminvertex(distance,visited);
       visited[minvertex]=true;
       for(int j=0;j<v;j++){
       if(dijkstra[minvertex][j]!=0 && 
       !visited[j] && distance[minvertex]!=Integer.MAX_VALUE)
       {
       newdist=distance[minvertex]+dijkstra[minvertex][j];
       if(newdist<distance[j]){
       distance[j]=newdist;
       }
       }
       }
       }
       for(int i=0;i<v;i++){
       System.out.println(i+" "+distance[i]);
       }
       }
       
       public static int findminvertex(int[] distance ,boolean[] visited){
       int minvertex=-1;
       for(int i=0;i<distance.length;i++){
       if(!visited[i] &&(minvertex==-1 || distance[i]<distance[minvertex])){
       minvertex=i;
       }
       }
       return minvertex;
       }
   public static void main(String args[]){
   Scanner inp=new Scanner(System.in);
   int v=inp.nextInt();
   int e=inp.nextInt();
   int adjmat[][]=new int[v][v];
   for(int i=0;i<e;i++){
   int v1=inp.nextInt();
   int v2=inp.nextInt();
   int weight=inp.nextInt();
   adjmat[v1][v2]=weight;
   adjmat[v2][v1]=weight;
   }
   System.out.println("====SHORTEST PATH COST====");
   dijkstra(adjmat);
   }
}
