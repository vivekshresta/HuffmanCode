public class HuffmanNode {
    HuffmanNode left;
    HuffmanNode right;
    Integer frequency;
    String c;

    public HuffmanNode(String c, Integer aFrequency, HuffmanNode aLeft, HuffmanNode aRight) {
        this.c = c;
        frequency = aFrequency;
        left = aLeft;
        right = aRight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public String getValue() {
        return c;
    }
}
