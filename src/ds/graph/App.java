package ds.graph;

public class App {
    public static void main(String[] args) {
        Graph busNetwork = new Graph(5, "directional");

        busNetwork.addVertex("Eagle's Bridge");
        busNetwork.addVertex("Pliska");
        busNetwork.addVertex("NDK");
        busNetwork.addVertex("Serdika");
        busNetwork.addVertex("Bulgaria Mall");

        busNetwork.addEdge("Pliska", "Eagle's Bridge");
        busNetwork.addEdge("Eagle's Bridge", "NDK");
        busNetwork.addEdge("Eagle's Bridge", "Serdika");
        busNetwork.addEdge("NDK", "Bulgaria Mall");
        busNetwork.addEdge("Bulgaria Mall", "Serdika");
        busNetwork.addEdge("Serdika", "Pliska");
        busNetwork.addEdge("Serdika", "NDK");
        busNetwork.addEdge("Bulgaria Mall", "Pliska");

        busNetwork.render();
    }
}
