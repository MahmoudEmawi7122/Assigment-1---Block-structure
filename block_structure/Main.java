package block_structure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahmoud Emawi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<BlockStructure> blockChainList = new ArrayList<>();
        BlockStructure b = new BlockStructure("Hello world!", 0);
        blockChainList.add(b);
        BlockStructure b2 = new BlockStructure("Hello i", blockChainList.get(blockChainList.size() - 1).hashCode());
        blockChainList.add(b2);

        for (BlockStructure l : blockChainList) {
            System.out.println(l);
        }
    }
}
