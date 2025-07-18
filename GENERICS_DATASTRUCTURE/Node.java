

public class Node<T>{
    private T data;
    private Node<T> nextNode;

    public Node(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return nextNode;
    }

    public void setNext(Node<T> node){
        nextNode = node;
    }

    public T getData(){
        return data;
    }
    
    public void setData(T data){
        this.data = data;
    }

    public String toString(){
        String result = "";
        Node<T> currentNode = getNext();
        while(currentNode != null){
            result += currentNode.getData() + " --> ";
            currentNode = null;
        }

        return result;
    }

    public static void main(String[] args) {
        Node<Integer> nodeToAdd = new Node<Integer>(12);
        nodeToAdd.setNext(new Node<Integer>(4));

        System.out.println(nodeToAdd.toString());
    }

}