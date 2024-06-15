package lsp1;

import lsp1.shape.Quadrilateral;
import lsp1.shape.Rectangle;
import lsp1.shape.Square;
import lsp1.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        Quadrilateral quadrilateral = new Square(5);
        Quadrilateral rectangle = new Rectangle(8, 9);

        ShapeView view = new ShapeView(quadrilateral);
        view.showArea();

        ShapeView view2 = new ShapeView(rectangle);
        view2.showArea();
    }
}
