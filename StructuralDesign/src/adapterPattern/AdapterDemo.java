package adapterPattern;

public class AdapterDemo {
    public static void main(String[] args) {
        AbstractSpaceSummer ss1 = new SpaceSummer();
        int sum = ss1.computeSpaceSum("src/adapter/spacein.txt");
        System.out.println(sum);
        AbstractSpaceSummer ss2 = new TildeAdapter(new TildeSummer());
        sum = ss2.computeSpaceSum("src/adapter/tildein.txt");
        System.out.println(sum);
    }
}
