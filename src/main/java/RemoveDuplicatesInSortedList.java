public class RemoveDuplicatesInSortedList {
    public static void main(String[] args) {

        //prepare test data
        Node node = prepareTestData();

        //display the linked list
        displayList(node);
        Node withNoDuplicates = removeDuplicates(node);
        System.out.println("\n*** Display after removing duplicates ***");
        displayList(withNoDuplicates);

    }

    public static Node removeDuplicates(Node head) {
        Node nextDistinctNode = null;
        Node currentNode = head;
        if (head != null && head.next != null) {
            nextDistinctNode = currentNode.next;
        }

        while ( nextDistinctNode != null ) {

            if( nextDistinctNode.data == currentNode.data) {
                nextDistinctNode = nextDistinctNode.next;
            }else{
                //check distance between current node next distinct node
                if( currentNode.next == nextDistinctNode) {
                    currentNode = currentNode.next;
                    nextDistinctNode = nextDistinctNode.next;
                }else{
                    //adjust pointers now to remove duplicate
                    currentNode.next = nextDistinctNode;
                }
            }
        }

        if ( currentNode.next != null ) {
            currentNode.next = null;
        }

        return head;
    }
    public static Node prepareTestData(){

        Node head = null;

        Node n1 = new Node();
        n1.data=1;
        Node n2 = new Node();
        n2.data=1;

        Node n3 = new Node();
        n3.data=3;

        Node n4 = new Node();
        n4.data=4;
        Node n5 = new Node();
        n5.data=4;
        Node n6 = new Node();
        n6.data=4;

        Node n7 = new Node();
        n7.data=5;

        Node n8 = new Node();
        n8.data=6;

        Node n9 = new Node();
        n9.data=6;

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=n9;

        head = n1;

        return head;
    }

    public static void displayList(Node head) {

        Node t = head;
        while (t != null) {
            System.out.print(t.data );
            if( t.next !=null ) {
                System.out.print("->");
            }
            t = t.next;

        }
    }
    static class Node {
        int data;
        Node next;
    }
}
