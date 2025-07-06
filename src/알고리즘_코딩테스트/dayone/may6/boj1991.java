package 알고리즘_코딩테스트.dayone.may6;

import java.io.*;
import java.util.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }


}
class BinaryTree{
    private TreeNode root;

    public BinaryTree(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(int data){
        //root = insertNode(root, data);
    }
    /*private TreeNode insertNode(TreeNode current, int data){

    }*/
}


public class boj1991 {
    static int n;
    static public void main(String[] args) throws  Exception{
        input();
    }
    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(bf.readLine());
        //for(int i = 0 ; i < )
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
