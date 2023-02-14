import java.util.LinkedList;

public class ImportedLinkedList {
    public static void main(String args[]) {
        LinkedList travelBucketList = new LinkedList();

        // Add items
        travelBucketList.add("Santorini, Greece");
        travelBucketList.addFirst("Barcelona, Spain");
        travelBucketList.addLast("Tokyo, Japan");
        travelBucketList.add(2, "Galapagos Islands, Ecuador");
        System.out.println(travelBucketList);

        // Access
        // System.out.println(travelBucketList.get(2));
        // System.out.println(travelBucketList.getFirst());
        // System.out.println(travelBucketList.contains("Barcelona, Spain"));

        // Remove items
        // travelBucketList.removeFirst();
        // travelBucketList.removeLast();
        // System.out.println(travelBucketList);

        // travelBucketList.remove("Santorini, Greece");
        // travelBucketList.remove(0);
        // System.out.println(travelBucketList);
    }
}
