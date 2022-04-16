package block_structure;

import java.util.Date;

/**
 *
 * @author Mahmoud Emawi
 */
public class BlockStructure {

    private int previousHash;
    private String data;
    private String hash;
    private long timeStamp;
    private int nonce;

    public BlockStructure(String data, int previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
        //this.hash = Arrays.hashCode(new Integer[]{data.hashCode(), previousHash});
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data
        );
        return calculatedhash;
    }

    public String getBlock() {
        return data;
    }

    public void setBlock(String data) {
        this.data = data;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined : " + hash);
    }
}
