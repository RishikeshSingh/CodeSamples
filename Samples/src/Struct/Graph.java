package Struct;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    public static void main(String[] args) {
        /*int graph[][] = new int[7][7];
        graph[0][1]=1;
        graph[0][2]=1;
        graph[1][3]=1;
        graph[4][1]=1;
        graph[6][4]=1;
        graph[5][6]=1;
        graph[5][2]=1;
        graph[6][0]=1;*/
        /*int graph[][] = new int[6][6];
        graph[5][0]=1;graph[4][0]=1;graph[5][2]=1;graph[2][3]=1;graph[3][1]=1;graph[4][1]=1;
        //dfs(graph);
        System.out.println();
        //bfs(graph);
        System.out.println(findMotherVertex(graph));
        topologicalSort(graph);*/
        int graph[][] = new int[9][9];
        graph[0][1]=4;graph[0][7]=8;graph[1][2]=8;graph[1][7]=11;graph[7][8]=7;graph[7][6]=1;graph[2][3]=7;graph[2][5]=4;graph[2][8]=2;graph[8][6]=6;graph[6][5]=2;graph[3][4]=9;graph[3][5]=14;graph[5][4]=10;
        primsMinimumSpanningTree(graph);
    }

    static void dfsutil(int[][] graph, int[] visited, int index){
        visited[index]=1;
        for(int i=0; i<graph.length;i++){
            if(graph[index][i]==1 && visited[i]==0){
                dfsutil(graph, visited, i);
            }
        }
    }

    static int findMotherVertex(int[][] graph){
        int len = graph.length;
        int lv=0;
        int visited[] = new int[len];

        for(int i=0; i<len; i++){
            if(visited[i] == 0){
                dfsutil(graph,visited, i);
                lv = i;
            }
        }

        for(int i=0; i<len; i++){
            visited[i] = 0;
        }

        dfsutil(graph, visited, lv);
        boolean flag = true;
        for(int i=0;i<len;i++){
            System.out.print(visited[i]);
            if(visited[i] == 0){
                flag = false;
            }
        }
        if(flag){
            return lv;
        }
        return -1;
    }

    static void topologicalSortUtil(int[][] graph, int[] visited, Stack stack, int v){
        for(int i=0;i<graph.length;i++){
            if(graph[v][i]==1 && visited[i]==0){
                visited[i] = 1;
                topologicalSortUtil(graph, visited, stack, i);
                stack.push(i);
            }
        }
    }

    static void topologicalSort(int[][] graph){
        int visited[] = new int[graph.length];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                visited[i] = 1;
                topologicalSortUtil(graph, visited, stack, i);
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    static void dfs(int[][] graph){
        int visited[] = new int[graph.length];
        dfsutil(graph, visited, 0);
    }

    static void bfs(int[][] graph){
        int len = graph.length;
        int visited[] = new int[len];
        Queue<Integer> queue = new LinkedList();
        visited[0]=1;
        System.out.print(0);
        queue.add(0);
        while(!queue.isEmpty()){
            int vertex = queue.remove();
            for(int i=0;i<len;i++){
                if(graph[vertex][i]==1 && visited[i]==0){
                    System.out.print(i+" ");
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    static int findMinKey(int[][] graph, int[] mstValue, int[] mstIncluded){
        int min = Integer.MAX_VALUE;
        int vertex = -1;
        for(int i=0; i<graph.length;i++){
            if(mstIncluded[i]==0 && min>mstValue[i]){
                min = mstValue[i];
                vertex = i;
            }
        }
        return vertex;
    }

    static void primsMinimumSpanningTree(int[][] graph){
        int len = graph.length;
        int mst[] = new int[len];
        int mstValue[] = new int[len];
        int mstIncluded[] = new int[len];

        for(int i=0;i<len;i++){
            mst[i] = -1;
            mstValue[i] = Integer.MAX_VALUE;
        }

        mstValue[0]=0;

        for(int i=0; i<len;i++){
            int u = findMinKey(graph, mstValue, mstIncluded);
            mstIncluded[u] = 1;

            for(int v=0; v<len; v++){
                if(graph[u][v]>0 && mstIncluded[v]!=1 && graph[u][v]<mstValue[v]){
                    mst[v] = u;
                    mstValue[v] = graph[u][v];
                }
            }
        }

        for(int i=0; i<len; i++){
            System.out.println(i+" "+mst[i]);
        }
    }

}
