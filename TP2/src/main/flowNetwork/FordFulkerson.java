package flowNetwork;

public class FordFulkerson {

    private FlowNetwork network;

    public FordFulkerson(FlowNetwork network) {
        this.network = network;
        this.solve();
    }

    private void solve() {

    }

    public FlowNetwork getNetwork() {
        return this.network;
    }

}
