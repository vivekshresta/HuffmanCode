import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Character, Integer> frequency = new HashMap();
        try {
            //Here we try to read data from a file and calculate the frequency of each character.
            //This data is saved in a HashMap (Dictionary in python)

            //File file = new File("/Users/vivekshresta/Downloads/CodeBase/AppliedAlgo/HuffmanCode/huffman/resources/pg60626.txt");
            File file = new File("/Users/vivekshresta/Downloads/CodeBase/AppliedAlgo/HuffmanCode/huffman/resources/1661-0.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                for(int i = 0; i < st.length(); i++) {
                    int asciiValue = st.charAt(i);
                    if(asciiValue > 128 || asciiValue < 32) {
                        continue;
                    }
                    frequency.compute(st.charAt(i), (key, value) -> value == null ? 1 : value + 1);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        HuffmanTree huffmanTree = new HuffmanTree(frequency);
        HuffmanNode hn = huffmanTree.createHuffmanCodes();
        huffmanTree.printTree(hn, "");

        compareSavings(frequency, huffmanTree.getHuffmanCodes());
    }

    private static void compareSavings(Map<Character, Integer> frequency, Map<Character, String> huffmanCodes) {
        System.out.println("Total number of characters: " + frequency.size());
        long standardBitTotal = 0L;
        long huffmanBitTotal = 0L;
        for(Character c : frequency.keySet()) {
            standardBitTotal = standardBitTotal + frequency.get(c)*7;
            huffmanBitTotal = huffmanBitTotal + frequency.get(c)*huffmanCodes.get(c).length();
        }

        System.out.println("Number of bits required without huffman encoding: " + standardBitTotal);
        System.out.println("Number of bits required with huffman encoding: " + huffmanBitTotal);
        System.out.println("Total number of bits saved: " + (standardBitTotal - huffmanBitTotal));
    }
}
