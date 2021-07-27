package com.makes.makes.treeDataStructure;

public class Tree {
    private PageNode root;

    public Tree(PageNode root){
        this.root = root;
    }

    public void addRightChild(PageNode parent, PageNode toAdd){
        PageNode child = parent.getRightChild();
        parent.setRightChild(toAdd);
        toAdd.setRightChild(child);
    }

    public void addLeftChild(PageNode parent, PageNode toAdd){
        PageNode child = parent.getLeftChild();
        parent.setLeftChild(toAdd);
        toAdd.setRightChild(child);
    }


}
