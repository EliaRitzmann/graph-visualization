package ch.eliaritzmann.graph_visualization;

import ch.eliaritzmann.graph_visualization.controller.Controller;
import ch.eliaritzmann.graph_visualization.model.Map;
import ch.eliaritzmann.graph_visualization.view.Canvas;
import ch.eliaritzmann.graph_visualization.view.Window;

/**
 * This Class contains the main method.
 *
 *
 * @author  Elia Ritzmann
 * @version 1.0
 * @since   14.6.2022
 */
public class Starter {
    public static void main(String[] args) {
        Map map = new Map();
        Canvas canvas = new Canvas();
        map.addObserver(canvas);

        Controller controller = new Controller(map);
        Window window = new Window(controller, canvas);

        System.out.println("Anleitung:");
        System.out.println("Linke Maustaste: Hinzufügen/auswählen von Knoten");
        System.out.println("DELETE-Taste: Löschen von ausgewählten Knoten");
        System.out.println("ENTER-Taste: Erstellen einer neuen Relation");

        controller.run();
    }
}
