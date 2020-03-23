package com.example.ds;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author fanchaochao
 * @className Group
 * @description
 * @date 2020-03-13 13:33
 **/
public class Graph {

    private ArrayList<String> vertexList;

    private int[][] edges;

    private int numOfEdges;

    private boolean isSearched[];

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isSearched = new boolean[n];
    }

    /**
     * 添加点
     * @Param: vertex
     **/
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @Param: v1       第一个顶点坐标
     * @Param: v2       第二个顶点坐标
     * @Param: weight   权值
     **/
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 获取结点的个数
     * @return:
     **/
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回索引对应值
     * @Param:
     * @return:
     **/
    public String getValueOfIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1，v2的值
     * @Param:  v1
     * @param:  v2
     * @return:
     **/
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     *  显示edges[][]
     */
    public void showGraph(){
        for (int[] row : edges){
            for (int tmp : row) {
                System.out.print(tmp+"\t");
            }
            System.out.println();
        }
    }

    /**
     *  显示edges[][],带结点
     */
    public void showGraphPro(){
        for (String vertex : vertexList){
            System.out.print("\t"+vertex);
        }
        System.out.println();
        int i = 0;
        for (int[] row : edges){
            System.out.print(getValueOfIndex(i++));
            for (int tmp : row) {
                System.out.print("\t"+tmp);
            }
            System.out.println();
        }
    }

    /**
     * 深度优先搜索
     * @Param:
     * @return:
     **/
    public void depthFirstSearch(int i){
        System.out.print(getValueOfIndex(i)+"->");
        isSearched[i] = true;
        for (int j = 0;j < edges[0].length;j++){
            if (edges[i][j] != 0 && isSearched[j] == false){
                depthFirstSearch(j);
            }
        }
    }

    /**
     * 广度优先搜索
     * @Param:
     * @return:
     **/
    LinkedList<Integer> queue=new LinkedList<>();     //队列，记录结点访问的顺序
    public void bfs(int i){
        queue.addLast(i);//将起始位置索引加入队列中
        while(!queue.isEmpty()){
            bfs_search(queue.getFirst());
            queue.removeFirst();
        }
    }
    public void bfs_search(int i){
        //打印当前结点
        if(isSearched[i]==false){
            System.out.println(getValueOfIndex(i));
            isSearched[i]=true;
        }
        //获取并打印邻接结点
        for(int j=0;j<edges[0].length;j++){
            //如果存在邻接结点且邻接结点未被访问（未曾加到过队列中）
            if(edges[i][j]!=0&&isSearched[j]==false){
                System.out.println(getValueOfIndex(j));
                //通过以下两句易知，只要该结点已经被访问，它就会被加到队列里,注意不要重复添加，防止爆栈
                isSearched[j]=true;
                queue.addLast(j);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.insertVertex("a");
        graph.insertVertex("b");
        graph.insertVertex("c");
        graph.insertEdge(0,1,1);
        graph.insertEdge(1,0,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(2,0,1);

        graph.showGraph();
        graph.showGraphPro();
        graph.depthFirstSearch(0);
        graph.bfs(0);
        graph.bfs_search(0);
    }

}
