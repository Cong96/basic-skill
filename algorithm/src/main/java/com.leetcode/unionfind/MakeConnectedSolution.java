package com.leetcode.unionfind;

/**
 * @Author: BryantCong
 * @Date: 2020/1/19 14:32
 * @Description: 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * <p>
 * 在计算机科学中，并查集是一种树型的数据结构，用于处理一些不交集（Disjoint Sets）的合并及查询问题。有一个联合-查找算法（union-find algorithm）定义了两个用于此数据结构的操作：
 * <p>
 * Find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
 * Union：将两个子集合并成同一个集合。
 * 由于支持这两种操作，一个不相交集也常被称为联合-查找数据结构（union-find data structure）或合并-查找集合（merge-find set）。其他的重要方法，MakeSet，用于创建单元素集合。有了这些方法，许多经典的划分问题可以被解决。
 * <p>
 * 为了更加精确的定义这些方法，需要定义如何表示集合。一种常用的策略是为每个集合选定一个固定的元素，称为代表，以表示整个集合。接着，Find(x) 返回x所属集合的代表，而Union使用两个集合的代表作为参数。
 * <p>
 * https://blog.csdn.net/liujian20150808/article/details/50848646
 */
public class MakeConnectedSolution {

    int[] father;
    int[] treeSize;
    private int nowNeedConnnect;

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        MakeConnectedSolution makeConnectedSolution = new MakeConnectedSolution();
        int n = makeConnectedSolution.makeConnected(4, connections);
        System.out.println(n);
    }

    //
//    public int find(int p) {
//        if (p != father[p]) {
//            //找到最上面的掌门
//            p = find(father[p]);
//        }
//        return p;
//    }
    //路径压缩 细品
    public int find(int p) {
        if (p != father[p]) {
            father[p] = find(father[p]);
        }
        return father[p];
    }


    //每次把小树合并到大树里面，加快后续的 find 和 union 两个操作。 这是一个优化操作，没有treeSize这个数组也是可以完成的，但是性能能问题
    public void union(int p, int q) {

        int fp = find(p);
        int fq = find(q);
        if (fp != fq) {
            //合并，代表两个点联通起来了，需要合并的点就少了一个
            nowNeedConnnect--;
            //合并一下，那么合并的依旧？
            if (treeSize[fp] < treeSize[fq]) {
                father[fp] = fq;
                treeSize[fq] += treeSize[fp];
            } else {
                father[fq] = fp;
                treeSize[fp] += treeSize[fq];
            }
        }
    }

    //初始化联合查找数据结构
    public void initUnionFind(int n) {
        father = new int[n];
        treeSize = new int[n];
        nowNeedConnnect = n - 1;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            treeSize[i] = 1;
        }
    }
    /**
    *
     *
     * 0-1   1
     *
     * 0-2  1
     *
     * 1-2
    * */
    public int makeConnected(int n, int[][] connections) {
        initUnionFind(n);
        int exitedConnect = 0;
        for (int[] c : connections) {
            //如果线的两头已经联通，那么这条线是多余的
            if (find(c[0]) == find(c[1])) {
                exitedConnect++;
                continue;
            }
            union(c[0], c[1]);

        }
        // 所需要的线缆数量
        int cnt2 = nowNeedConnnect;
        if (exitedConnect < cnt2) {
            return -1;
        }
        return cnt2;

    }
}
