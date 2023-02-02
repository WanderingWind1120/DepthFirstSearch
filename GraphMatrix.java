package org.example;

import java.util.ArrayList;

public class GraphMatrix {
    ArrayList<Node> NodeList;
    int[][] EdgeMatrix;
    public GraphMatrix(int size){
        NodeList = new ArrayList<>();
        EdgeMatrix = new int[size][size];
    }
    public void addNode(Node node){
        NodeList.add(node);
    }
    public void addEdge(int src, int dst){
        EdgeMatrix[src][dst] = 1;
    }
    public boolean checkEdge (int src, int dst){
        if (EdgeMatrix[src][dst] == 1){
            return true;
        }
        return false;
    }
    public void print(){
        System.out.print("  ");
        for (Node node: NodeList){
            System.out.print(node.data + " ");
        }
        for (int i = 0; i<= EdgeMatrix.length-1; i++){
            System.out.println(NodeList.get(i).data + " ");
            for (int j = 0; j<= EdgeMatrix[i].length -1; j++){
                System.out.println(EdgeMatrix[i][j]);
            }
            System.out.println();
        }
    }
    /*
    Bản chất của của cái Algorithm áp dụng lên graph này hiểu một cách đơn giản là
    pick một điểm khởi đẩu bất kì (cụ thể ở đây chúng ta pass in index của của phần tử đó trong NodeList) vào
    xong tìm xem từ điểm đó có thể đi được tới các điểm nào
    Cái THUẬT TOÁN này hiểu một cách hình học là search theo đường thẳng/ chiều sâu
    Từ điêm khởi đẩu nếu tôi gặp bất kì điểm nào khi loop theo thứ tự các node trong NodeList thì dừng tại đó luôn
    rồi từ cái điểm hiện tại đi tiếp đến bao h không thể đi thêm được nữa
    rồi mới quay về loop tiếp xoay quanh điểm khởi đầu xem có đi dc tới thêm điểm nào nữa không ( các điểm có thể
    đến được lúc này sẽ loại trừ các điểm đã visit được từ con đường thông qua điểm gặp đầu tiên rồi
    áp dụng tương tự 
     */
    public void depthFirstSearch (int src){
        boolean [] visited = new boolean[EdgeMatrix.length];
        dfshelper(src, visited);

    }
    public void dfshelper (int src, boolean[] visited){
        if (visited[src] == true){
            return;
        }
        else{
            visited[src] = true;
            System.out.println(NodeList.get(src).data + " = Visited");
        }
        for (int i = 0; i <= EdgeMatrix[src].length-1; i++){
            if (EdgeMatrix[src][i] == 1){
                dfshelper(i,visited);
            }
        }
    }
}
