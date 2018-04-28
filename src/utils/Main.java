package utils;

public class Main {
	public static void main(String[] args) {

		ArbolOperaciones theTree = new ArbolOperaciones(Operacion.SQRT);

		try {
			theTree.insertarDer(new ArbolOperaciones(Operacion.MUL));
			theTree.obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			theTree.obtenerDer().insertarDer(new ArbolOperaciones(Operacion.MUL));
			theTree.obtenerDer().obtenerDer().insertarIzq(new ArbolOperaciones(Operacion.A));
			theTree.obtenerDer().obtenerDer().insertarDer(new ArbolOperaciones(Operacion.A));
//			theTree.obtenerIzq().insertarIzq(new ArbolOperaciones(Operacion.SUMA));
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * theTree.insertarIzq(25, "Vice President");
		 * 
		 * theTree.insertarIzq(15, "Office Manager");
		 * 
		 * theTree.addNode(30, "Secretary");
		 * 
		 * theTree.addNode(75, "Sales Manager");
		 * 
		 * theTree.addNode(85, "Salesman 1");
		 */
		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		System.out.println("\nNode with the key 75");

		System.out.println(theTree.obtenerIzq().obtenerRaiz().getMensaje());

	}
}
