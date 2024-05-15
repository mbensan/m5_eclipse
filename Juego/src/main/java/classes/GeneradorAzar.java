package classes;

public class GeneradorAzar {
  //								 10       15
  static public int generarInt (int min, int max) {
	int resultado = (int) Math.floor(Math.random() * (max - min + 1)) + min;
	return resultado;
  }
  
  static public int generarOros (String lugar) {
	if (lugar.equals("granja")) {
	  return generarInt(10, 20);
	}
	else if (lugar.equals("cueva")) {
	  return generarInt(5, 10);
	}
	else if (lugar.equals("casa")) {
	  return generarInt(2, 5);
	}
	else if (lugar.equals("casino")) {
	  return generarInt(-50, 50);
	}
	else {
	  return 0;
	}
  }
	
}
