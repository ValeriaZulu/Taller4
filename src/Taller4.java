import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Taller4 {

    static HashMap Casas(int size) {
        HashMap<String, Integer> casas = new HashMap<String, Integer>();
        Random random = new Random();
        int rndmPrice = 0;
       
        String[] prefijos = { "La", "El", "Un" };
        String[] mid = { "cabaña", "mansión", "castillo", "torre" };
        String[] suf = { "de la montaña", "del principe", "de marmol", "del bosque", "de la playa", "de la laguna" };

        for (int i = 0; i < size; i++) {
            int randPref = random.nextInt(prefijos.length);
            int randMid = random.nextInt(mid.length);
            int randSuf = random.nextInt(suf.length);
            String nombre = prefijos[randPref] + " " + mid[randMid] + " " + suf[randSuf];
            rndmPrice = random.nextInt(1000000);

            casas.put(nombre, rndmPrice);

        }
        return casas;
    }

    public static void main(String[] args) {

        String[] barrios = {"Laureles","Belen","Conquistadores","Calasans","Floresta"};
        
        HashMap<String, Integer> ventas = new HashMap<String, Integer>();
        HashMap<String, Integer> casas = Casas(10);

        for (String barrio : barrios) {
            ventas.put(barrio, 0);
        }

    int userEntry=0;
    Random rnd = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Te doy la bienvenida a Tinder House");
    System.out.println("Esto consiste en hacer match con cada casa que quieras comprar");
    System.out.println("escribe 0 para descartar, 1 para comprar y 2 para terminar el juego");

    do {
            // Elegir una clave aleatoria
            Set<String> claves = casas.keySet();
            int cantidadClaves = claves.size();
            int indiceAleatorio = new Random().nextInt(cantidadClaves);

            String claveAleatoria = (String) claves.toArray()[indiceAleatorio];
            // Aqui va el juego

            int randomBarrio = rnd.nextInt(barrios.length);
            int price = casas.get(claveAleatoria);
            System.out.println("------*-------");
            System.out.println(claveAleatoria);
            System.out.println(barrios[randomBarrio]);
            System.out.println(price + " dólares");
            System.out.println("------*-------");
            userEntry = scanner.nextInt();

            if (userEntry==1) {
                int actualVenta = ventas.get(barrios[randomBarrio]);
                int newVenta = actualVenta + price;
                ventas.replace(barrios[randomBarrio], newVenta);
            }

        } while (userEntry != 2);

        System.out.println("Reporte de ventas:");

        for (String barrio : ventas.keySet()) {
            System.out.println(barrio + " vendió " + ventas.get(barrio));
  }
}

}