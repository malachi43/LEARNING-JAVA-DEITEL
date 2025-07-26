package com.malachi.datastructures;

class ListNode<T>{
    T data;
    ListNode<T> nextNode;

    ListNode(T object){
       this(object, null);
    }

    ListNode(T object, ListNode<T> node){
        data = object;
        nextNode = node;
    }

    T getData(){
        return data;
    }

    ListNode<T> getNext(){
        return nextNode;
    }

    public String toString(){
        String value = nextNode.data != null ? nextNode.data.toString() : "null";

        return "{ \"data\": " + data + ", \"nextNode\": { \"data\": " +  value + " }}";
    }
}

public class List<T> {
    private String name; //this is the name that will be used in identifying the list when printing the list content.
    ListNode<T> firstnode;
    ListNode<T> lastnode;

    public List(){
        name = "list";
    }

    public List(String name){
        this.name = name;
        firstnode = lastnode = null;
    }

    public boolean isEmpty(){
        return firstnode == null;
    }

    public void insertAtFront(T insertItem){
        if(isEmpty()){
            firstnode =  lastnode = new ListNode<>(insertItem); //firstnode and lastnode refer to the same object.
        }else{
            firstnode = new ListNode<>(insertItem, firstnode);
        }
    }

    public void insertAtBack(T insertItem){
        if(isEmpty()){
            firstnode = lastnode = new ListNode<>(insertItem); //firtnode and lastnode refer to the same object.
        }else{
            lastnode = lastnode.nextNode = new ListNode<>(insertItem);
        }
    }

    public T removeFromFront() throws EmptyListException{
        if(isEmpty()) throw new EmptyListException(name);

        T removedItem = firstnode.data; //retrieve the data to be removed.

        //this checks if there is only one element in the list.
        if(firstnode == lastnode) {
            firstnode = lastnode = null; //firstnode and lastnode are set to null since the element data has been retrieved. At this point the list is empty.
        }else{
            firstnode = firstnode.nextNode;
        }
       return removedItem;
    }

    public T removeFromBack() throws EmptyListException{
        if(isEmpty())throw new EmptyListException(name);
        
        T removedItem = lastnode.data;

        //this checks if there is only one element in the list. (in this case both firstnode and lastnode point to the same object)
        if(firstnode == lastnode){
            firstnode = lastnode =  null;
        }else{
            ListNode<T> currentNode = firstnode;
        
            while(currentNode.nextNode != lastnode){
              currentNode = currentNode.nextNode;
            }
    
            lastnode = currentNode;
            currentNode.nextNode = null;
        }

        return removedItem;
    }

    public void print(){
        if(isEmpty()){
            System.out.printf("The list: %s is empty%n",name);
            return;
        }
        
        ListNode<T> currentNode = firstnode;
        System.out.printf("This %s is: ", name);
        StringBuilder result = new StringBuilder();

        while(currentNode != null){
            result.append(currentNode.data).append(" -> ");
            currentNode = currentNode.nextNode;
        }
        result.append("null");
        System.out.println(result);
    }
}
