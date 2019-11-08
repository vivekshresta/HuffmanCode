import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private PriorityQueue<HuffmanNode> priorityQueue;
    private Map<Character, String> huffmanCodes;

    public HuffmanTree(Map<Character, Integer> aFrequency) {
        huffmanCodes = new HashMap<>();
        priorityQueue = new PriorityQueue<>(aFrequency.size(), new HuffmanComparator());

        for(Character c : aFrequency.keySet()) {
            priorityQueue.add(new HuffmanNode(c, aFrequency.get(c), null, null));
        }
    }

    public HuffmanNode createHuffmanCodes() {
        HuffmanNode root = null;

        // Here we extract two minimum value from the heap each time until its size reduces to 1. Extract until all the nodes are extracted.
        //At the end, we just have one tree remaining in the queue with all the connections
        while (priorityQueue.size() > 1) {
            HuffmanNode first = priorityQueue.poll();
            HuffmanNode second = priorityQueue.poll();

            Character c = null;
            HuffmanNode newNode = new HuffmanNode(c, first.getFrequency() + second.getFrequency(), first, second);

            root = newNode;

            // Again add this node to the priority-queue.
            priorityQueue.add(newNode);
        }
        return root;
    }

    public void printTree(HuffmanNode root, String s)
    {
        if(root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            huffmanCodes.put(root.getCharacter(), s);
            System.out.println(root.getCharacter() + " : " + s);
            return;
        }

        printTree(root.getLeft(), s + "0");
        printTree(root.getRight(), s + "1");
    }

    public Map<Character, String> getHuffmanCodes() {
        return huffmanCodes;
    }
}

class HuffmanComparator implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}
