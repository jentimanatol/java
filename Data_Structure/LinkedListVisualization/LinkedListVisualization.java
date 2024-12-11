import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LinkedListVisualization extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Create dummy node (invisible circle)
        Circle dummyNode = new Circle(20, Color.TRANSPARENT);
        dummyNode.setCenterX(200);
        dummyNode.setCenterY(100);

        // Create other nodes (visible circles)
        Circle node1 = createNode(1, 100, 200);
        Circle node2 = createNode(2, 200, 200);
        Circle node3 = createNode(3, 300, 200);
        Circle node4 = createNode(4, 400, 200);
        Circle node5 = createNode(5, 500, 200);

        // Connect nodes with lines (with a delay)
        connectNodes(dummyNode, node1, root);
        connectNodesWithDelay(node1, node2, root, 2000); // 2-second delay
        connectNodesWithDelay(node2, node3, root, 2000);
        connectNodesWithDelay(node3, node4, root, 2000);
        connectNodesWithDelay(node4, node5, root, 2000);

        Scene scene = new Scene(root, 700, 300);
        primaryStage.setTitle("Linked List Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle createNode(int value, double x, double y) {
        Circle node = new Circle(20, Color.LIGHTBLUE);
        node.setCenterX(x);
        node.setCenterY(y);
        return node;
    }

    private void connectNodes(Circle from, Circle to, Pane root) {
        Line line = new Line(from.getCenterX(), from.getCenterY(), to.getCenterX(), to.getCenterY());
        root.getChildren().addAll(line, to);
    }

    private void connectNodesWithDelay(Circle from, Circle to, Pane root, int delayMillis) {
        Line line = new Line(from.getCenterX(), from.getCenterY(), to.getCenterX(), to.getCenterY());
        root.getChildren().add(line);

        // Introduce a delay
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        root.getChildren().add(to);
    }
}
