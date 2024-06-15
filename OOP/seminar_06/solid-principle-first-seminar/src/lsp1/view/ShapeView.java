package lsp1.view;

import lsp1.shape.Quadrilateral;
import lsp1.shape.Rectangle;

public class ShapeView {
    private final Quadrilateral quadrilateral;

    public ShapeView(Quadrilateral quadrilateral) {
        this.quadrilateral = quadrilateral;
    }

    public void showArea() {
        System.out.print("Area of quadrilateral equal:");
        System.out.println(quadrilateral.getArea());
    }
}
