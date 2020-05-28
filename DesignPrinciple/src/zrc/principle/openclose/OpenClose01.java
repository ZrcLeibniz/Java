package zrc.principle.openclose;

public class OpenClose01 {
	public static void main(String[] args) {
		GraphicEditor graphicEditor = new  GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
	}
}

class GraphicEditor{
	public void drawShape(Shape s) {
		if(s.m_type == 1) {
			drawRectangle(s);
		}else if(s.m_type == 2){
			drawCircle(s);
		}else if(s.m_type == 3) {
			drawTriangle(s);
		}
	}
	
	private void drawRectangle(Shape r) {
		System.out.println("����");
	}
	
	private void drawCircle(Shape r) {
		System.out.println("Բ��");
	}
	
	private void drawTriangle(Shape r) {
		System.out.println("������");
	}
}

class Shape{
	int m_type;
}

class Rectangle extends Shape {
	Rectangle(){
		super.m_type = 1;
	}
}

class Circle extends Shape {
	Circle(){
		super.m_type = 2;
	}
}

class Triangle extends Shape{
	Triangle(){
		super.m_type = 3;
	}
}