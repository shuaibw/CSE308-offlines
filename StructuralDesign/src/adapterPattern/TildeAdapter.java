package adapterPattern;

public class TildeAdapter implements AbstractSpaceSummer{
    private TildeSummer ts;

    public TildeAdapter(TildeSummer ts) {
        this.ts = ts;
    }

    @Override
    public int computeSpaceSum(String file) {
        return ts.computeTildeSum(file);
    }
}
