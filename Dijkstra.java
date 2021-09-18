//dijkstra is used to find minimum distance in a path
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	static final int V = 4;
	int minDistance(int dist[], Boolean sptSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
	void printSolution(int dist[],int s)
	{
		for (int i = 0; i < V; i++)
		if(i!=s)
			System.out.print(dist[i]+" ");
	}
	void dijkstra(int graph[][], int src)
	{
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printSolution(dist,src);
	}
	public static void main(String[] args)
	{
	    Scanner sc= new Scanner(System.in);
	    int n=sc.nextInt();
	    int m=sc.nextInt();
	    int s=sc.nextInt();
	    int a,b,c;
	    int graph[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	    for(int j=0;j<m;j++)
	    {
	     a=sc.nextInt();
	     b=sc.nextInt();
	     c=sc.nextInt();
	     graph[a-1][b-1]=c;
	     graph[b-1][a-1]=c;
	    }
	    for(int i=0;i<n;i++)
	    {
	        for(int j=0;j<n;j++)
	        {
	           System.out.println(graph[i][j]);
	        }
	    }
	/*	int graph[][] = new int[][] { { 1,24,3,22 },
									{ 24,0,0,0 },
									{ 3,0,0,12},
									{ 22,0,12,0},
									 };*/
		Main t = new Main();
		t.dijkstra(graph, s-1);
	}
}
/*output:
4 4
1
1 2 24
1 3 3
1 4 22
3 4 12
op:24 3 15*/
