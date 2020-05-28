package zrc.principle.openclose;

public class OpenClose02 {
	public static void main(String[] args) {
		GraphEditorPlus graphEditPlus = new GraphEditorPlus();
		graphEditPlus.drawShape(new CirclePlus());
		graphEditPlus.drawShape(new TrianglePlus());
		graphEditPlus.drawShape(new RectanglePlus());
		graphEditPlus.drawShape(new OtherPlus());
	}
}

class GraphEditorPlus {
	public void drawShape(ShapePlus s) {
		s.draw();
	}
}

abstract class ShapePlus {
	public abstract void draw();
}

class RectanglePlus extends ShapePlus {
	@Override
	public void draw() {
		System.out.println("矩形");
	}

}

class CirclePlus extends ShapePlus {

	@Override
	public void draw() {
		System.out.println("圆形");
	}
}

class TrianglePlus extends ShapePlus {

	@Override
	public void draw() {
		System.out.println("三角形");
	}
}

class OtherPlus extends ShapePlus {

	@Override
	public void draw() {
		System.out.println("其他形");
	}
}
