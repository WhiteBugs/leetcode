package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class AllPathsFromSourcetoTarget {
    //797. All Paths From Source to Target
    //https://leetcode.com/problems/all-paths-from-source-to-target/description/
    //回溯法

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        list.add(0);//add the first node '0'；添加第一个节点
        List<List<Integer>> answer = new ArrayList<>();
        dfs(graph, graph.length-1, graph[0], list, answer);
        return answer;
    }

    private void dfs(int[][] graph , int flag, int [] nodes, List<Integer> list, List<List<Integer>> answer){
        if(nodes.length==0)
            return;

        for(int i=0; i<nodes.length; i++){
            list.add(nodes[i]);
            if(nodes[i] == flag){
                List<Integer> clone = new ArrayList<>();
                clone.addAll(list);
                answer.add(clone);
                list.remove(list.size()-1);
                continue;
            }
            dfs(graph, flag, graph[nodes[i]], list, answer);
            list.remove(list.size()-1);
        }
    }
}
