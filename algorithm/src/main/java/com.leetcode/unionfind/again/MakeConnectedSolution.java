package com.leetcode.unionfind.again;

/**
 * @ClassName MakeConnectedSolution
 * @Description
 * @Author BryantCong
 * @Date 2020/1/21 22:07
 * @Version V1.0
 * * @Description: 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *  * <p>
 *  * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *  * <p>
 *  * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 *  * <p>
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 *  * 输出：1
 *  * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * 交并集
 **/
public class MakeConnectedSolution {
    int[] father;
    int nowNeedConnnect;
    int[] treeSize;
    int find(int p){
        if(father[p]!=p){
            father[p]=find(father[p]);
        }
        return father[p];
    }

    void union(int p,int q){
        int fp=find(p);
        int fq=find(q);
        if(fp!=fq){
            //他们是联通的，需要的链接数减一
            nowNeedConnnect--;
            //其实直接这样是可以的，在代码的正确性来说没有任何的问题，但是效率不是很高
            //所以我们引入一个树的权的计算
           // father[p]=fq;
            if(treeSize[p]<treeSize[q]){
                treeSize[q]+=treeSize[p];
                father[p]=fq;
            }
            else{
                treeSize[p]+=treeSize[q];
                father[q]=fp;
            }
        }
    }
    void initfindUnion(int n){
        father=new int[n];
        treeSize=new int[n];
        for(int i=0;i<n;i++){
            father[i]=i;
            treeSize[i]=1;
        }
        nowNeedConnnect=n-1;
    }

    public int makeConnected(int n, int[][] connections){
        initfindUnion(n);
        int existConnections=0;
        for(int[] connection:connections){
            if(find(connection[0])==find(connection[1])){
                existConnections++;
                continue;
            }
            union(connection[0],connection[1]);
        }
        return -1;
    }
}
