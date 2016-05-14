package firecamp.cells;


import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class TextCell<T> extends HBox {

        public T Model;

        public T getModel() {
            return Model;
        }
        Label textLabel = new Label();

        public TextCell(T model, String text) {
            
            Model = model;
            textLabel = new Label(text);
            textLabel.setTextFill(Color.web("#000000"));
            try {
                this.getChildren().addAll(textLabel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
