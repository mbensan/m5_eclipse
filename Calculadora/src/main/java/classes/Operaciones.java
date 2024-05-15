package classes;

public class Operaciones  {

  static public float suma(float x, float y) {
    return x + y;
  }

  static public float resta(float x, float y) {
    return x - y;
  }

  static public float mult(float x, float y) {
    return x * y;
  }

  static public float div(float x, float y) {
    return x / y;
  }
  
  static public float operar (float uno, String op, float dos) {
	  if (op.equals("+")) {
		  return suma(uno, dos);
	  }
	  else if (op.equals("-")) {
		  return resta(uno, dos);
	  }
	  else if (op.equals("x")) {
		  return mult(uno, dos);
	  }
	  else {
		  return div(uno, dos);
	  }
  }
}