package ch.eliaritzmann.graph_visualization;

import ch.eliaritzmann.graph_visualization.controller.Controller;
import ch.eliaritzmann.graph_visualization.model.Map;
import ch.eliaritzmann.graph_visualization.view.Canvas;
import ch.eliaritzmann.graph_visualization.view.Window;

public class Starter {
    public static void main(String[] args) {
        Map map = new Map();
        Canvas canvas = new Canvas();
        map.addObserver(canvas);

        Controller controller = new Controller(map);
        Window window = new Window(controller, canvas);

        controller.run();
    }
}
