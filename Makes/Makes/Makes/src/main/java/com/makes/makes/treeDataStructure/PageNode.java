package com.makes.makes.treeDataStructure;

import com.makes.makes.systemObjects.Page;

public class PageNode {
    private Page page;
    private PageNode rightChild = null;
    private PageNode leftChild = null;
    private PageNode Parent;


    public PageNode(Page page, PageNode parent){
        setPage(page);
        setParent(parent);
    }

    public PageNode(Page page, PageNode parent, PageNode rightChild){
        setPage(page);
        setParent(parent);
        setRightChild(rightChild);
    }

    public PageNode(Page page, PageNode parent, PageNode rightChild, PageNode leftChild){
        setPage(page);
        setParent(parent);
        setRightChild(rightChild);
        setLeftChild(leftChild);
    }

    public void setLeftChild(PageNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setParent(PageNode parent) {
        Parent = parent;
    }

    public void setRightChild(PageNode rightChild) {
        this.rightChild = rightChild;
    }

    public Page getPage() {
        return page;
    }

    public PageNode getLeftChild() {
        return leftChild;
    }

    public PageNode getRightChild() {
        return rightChild;
    }

    public PageNode getParent() {
        return Parent;
    }
}
