package com.example.labb2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<E extends Comparable<E>> implements Iterable<E>{
protected TreeNode<E> root;
protected int size=0;


    public  BST(){

    }
    public int getSize(){
        return size;
    }

    public void remove(E s) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (s.compareTo(current.data) < 0) {
                parent = current;
                current = current.left;
            } else if (s.compareTo(current.data) > 0) {
                parent = current;
                current = parent.right;
            } else {
                break;
            }


        }
        if(current.left == null) {
            if(parent == null) {
                root = current.right;
            } else {
                if (s.compareTo(parent.data) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        else {
            TreeNode<E> parentOfRight = current;
            TreeNode<E> rightMost = current.left;
            while(rightMost.right != null) {
                parentOfRight = rightMost;
                rightMost = rightMost.right;
            }
            current.data = rightMost.data;
            if(parentOfRight.right == rightMost) {
                parentOfRight.right = rightMost.left;
            } else {
                parentOfRight.left = rightMost.left;
            }
        }
        size--;
    }

    public void add(E e) {
        //rekursiv förel8
        TreeNode<E> nyNod = new TreeNode<>(e);
        nyNod.right = null;
        nyNod.left = null;

        if (root == null) {
            root = nyNod;
        } else {
            root.addNode(nyNod);
        }
        this.size++;

    }






    public boolean find(E e) {
        return find(e, root) != null;
    }

    public TreeNode<E>  find(E e, TreeNode<E> s){
        if (s == null) {
            return null;
            //ifall s returneras, har vi hittat E i lövet s
        } else if (s.data.equals(e)) {
            return s;
      /* kollar  ifall noden som kommer ifrån rekursionen är mindre än input E(som vi ska hitta)
         compareTO är mindre än 0, isåfall letar vi till höger, annars vänster*/
        } else if (s.data.compareTo(e) < 0) {
            return find(e, s.right);

        } else {
            return find(e, s.left);
        }
    }





    public E Min() {
        return Min(root);
    }

    private E Min(TreeNode<E> root) throws NoSuchElementException {

        E min = root.data;
        //loopa tills du hitta det löv längst till vänster (min)
        while (root != null) {
            min = root.data;
            root = root.left;
        }
        return min;
    }

    public E Max() {
        return Max(root);
    }


    private E Max(TreeNode<E> root) throws NoSuchElementException {


        E max = root.data;
        //loopa tills du hitta det löv längst till höger (max)
        while (root != null) {
            max = root.data;
            root = root.right;
        }
        return max;
    }

    private class InorderIterator implements Iterator<E> {
        private final ArrayList<E> list = new ArrayList<>();
        private int current =0;

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            E data = list.get(current);
            current++;
            return data;
        }

        public InorderIterator(){
            inorder();
        }

        //förel8
        private void inorder() {
            inorder(root);
        }
        private void inorder(TreeNode root) {
            if(root == null) {
                return;
            } else {
                inorder(root.left);
                list.add((E) root.data);
                inorder(root.right);
            }
        }


    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }


    public class TreeNode<E extends Comparable<E>>  {

        protected E data;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            this.data=e;
        }

        //föreläsn 8
        protected void addNode(TreeNode<E> t){
            //vänster ifall mindre
            if (t.data.compareTo(data) < 0) {
                if (left == null) {
                    left = t;
                } else {
                    left.addNode(t);
                }
                //höger ifall större
            } else if (t.data.compareTo(data) > 0) {
                if (right == null) {
                    right = t;
                } else {
                    right.addNode(t);
                }
            }
        }


    }
}
