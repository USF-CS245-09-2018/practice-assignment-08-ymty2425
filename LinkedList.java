public class LinkedList implements List {

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData() {
            this.data=data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next=next;
        }
    }

    Node head;
    int size;

    public LinkedList() {
        head=null;
        size=0;
    }

    @Override
    public void add(Object obj) {
        Node current=head;
        Node newNode=new Node(obj);
        if (head==null) {
            head=newNode;
            size++;
            return;
        }

        while(current.getNext()!=null) {
            current=current.getNext();
        }
        current.setNext(newNode);
        size++;
    }

    @Override
    public void add(int pos, Object obj) {
        Node newNode=new Node(obj);
        if(pos==0) {
            newNode.setNext(head);
            head=newNode;
            size++;
        } else {
            Node current=head;
            Node prev=null;
            for(int i=0;i<pos;i++) {
                prev=current;
                current=current.getNext();
            }
            newNode.setNext(current);
            prev.setNext(newNode);
            size++;
        }
    }

    @Override
    public Object get(int pos) {
        Node node = head;
        for (int i = 0; i < pos; i++) {
            node=node.getNext();
        }
        return node.getData();
    }

    @Override
    public Object remove(int pos) {
        Node current = head;
        if(current != null) {
            for(int i = 0; i < pos; i++) {
                current = current.getNext();
            }
            Object ret_data = current.getData();
            current = current.getNext();
            size--;
            return ret_data;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        Node current = this.head;
        String s="";
        while (current!=null) {
            s=s+current.getData().toString()+"->";
            current=current.getNext();
        }
        return s;
    }

    // public static void main(String[] args) {
    //     LinkedList list=new LinkedList();
    //     list.add("aaa");
    //     list.add("bbb");
    //     list.add("ccc");
    //     list.add(2,"ddd");
        
    //     System.out.println(list).get(1);
    //     System.out.println(list.remove(1));
    //     System.out.println(list.get(1));
    //     System.out.println(list);
    // }
}