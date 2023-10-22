
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Taller4 {

    // Función para generar los nombres de las casas y precios
    static HashMap getCasas(int size) {
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

        // Lista de barrios
        String[] barrios = { "Laureles", "Belen", "Conquistadores", "Calasans", "Floresta" };

        // Inicio los HashMap
        HashMap<String, Integer> ventas = new HashMap<String, Integer>();
        HashMap<String, Integer> casas = getCasas(10);
        HashMap<String,Integer> numeroVentas=new HashMap<String, Integer>();


        for (String barrio : barrios) {
            ventas.put(barrio, 0);
            numeroVentas.put(barrio, 0);
        }

        int userEntry = 0;
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Te doy la bienvenida a Tinder House");
        System.out.println("Esto consiste en hacer match con cada casa que quieras comprar");
        System.out.println("escribe 0 para descartar, 1 para comprar y 2 para terminar el juego");

        // manejo de errores
        try {
            do {
                // Elegir una clave aleatoria
                Set<String> claves = casas.keySet();
                int cantidadClaves = claves.size();
                int indiceAleatorio = new Random().nextInt(cantidadClaves);

                String claveAleatoria = (String) claves.toArray()[indiceAleatorio];

                // Aqui inicia el juego
                int randomBarrio = rnd.nextInt(barrios.length);
                int price = casas.get(claveAleatoria);
                System.out.println("------*-------");
                System.out.println(claveAleatoria);
                System.out.println(barrios[randomBarrio]);
                System.out.println(price + " dólares");
                System.out.println("------*-------");
                userEntry = scanner.nextInt();

                // Se guardan los valores si el usuario ingresa "1"
                if (userEntry == 1) {
                    int actualVenta;
                    int newVenta;
                    actualVenta = ventas.get(barrios[randomBarrio]);

                    // Las ventas de cada barrio se multiplica por el peso respectivo
                    // Laureles (5), Belen(2), Conquistadores(6), Calasans(4), Floresta(3)
                    if (barrios[randomBarrio] == "Laureles") {
                        newVenta = (actualVenta + price) * 5;
                        ventas.replace(barrios[randomBarrio], newVenta);

                        //Contador para saber cuantas ventas realizó
                        int numActual=numeroVentas.get(barrios[randomBarrio]);
                        int numNew=(numActual+1);
                        numeroVentas.replace(barrios[randomBarrio], numNew);

                    } else if (barrios[randomBarrio] == "Belen") {
                        newVenta = (actualVenta + price) * 2;
                        ventas.replace(barrios[randomBarrio], newVenta);

                        //Contador para saber cuantas ventas realizó
                        int numActual=numeroVentas.get(barrios[randomBarrio]);
                        int numNew=(numActual+1);
                        numeroVentas.replace(barrios[randomBarrio], numNew);

                    } else if (barrios[randomBarrio] == "Conquistadores") {
                        newVenta = (actualVenta + price) * 6;
                        ventas.replace(barrios[randomBarrio], newVenta);

                        //Contador para saber cuantas ventas realizó
                        int numActual=numeroVentas.get(barrios[randomBarrio]);
                        int numNew=(numActual+1);
                        numeroVentas.replace(barrios[randomBarrio], numNew);

                    } else if (barrios[randomBarrio] == "Calasans") {
                        newVenta = (actualVenta + price) * 4;
                        ventas.replace(barrios[randomBarrio], newVenta);

                        //Contador para saber cuantas ventas realizó
                        int numActual=numeroVentas.get(barrios[randomBarrio]);
                        int numNew=(numActual+1);
                        numeroVentas.replace(barrios[randomBarrio], numNew);

                    } else {
                        newVenta = (actualVenta + price) * 3;
                        ventas.replace(barrios[randomBarrio], newVenta);

                        //Contador para saber cuantas ventas realizó
                        int numActual=numeroVentas.get(barrios[randomBarrio]);
                        int numNew=(numActual+1);
                        numeroVentas.replace(barrios[randomBarrio], numNew);
                    }
                }
            } while (userEntry != 2);
        } catch (Exception e) {
            System.out.println("se encontró una excepción");
        }

        System.out.println();        

        // Muestra el reporte de las ventas
        System.out.println("Reporte de ventas:");

        for (String barrio : ventas.keySet()) {
            System.out.println(barrio + " vendió " + ventas.get(barrio) + " dólares");
        }

        System.out.println();        

        // Para hallar el barrio que más dinero ganó
        String maxPrice = null;
        int maxValue = Integer.MIN_VALUE;

        for (String key : ventas.keySet()) {
            int value = ventas.get(key);

            if (value > maxValue) {
                maxValue = value;
                maxPrice = key;
            }
        }
        System.out.println("El barrio que más dinero ganó fue " + maxPrice);
      

        // Para hallar el barrio que menos dinero ganó
        String minPrice = null;
        int minValue = Integer.MAX_VALUE;

        for (String key : ventas.keySet()) {
            int value = ventas.get(key);

            if (value < minValue) {
                minValue = value;
                minPrice = key;
            }
        }
        System.out.println("El barrio que menos dinero ganó fue " + minPrice);

        //Para saber cuál fue el barrio que más casas vendió
        String barrioMaxVentas= null;
        int maxVenta = Integer.MIN_VALUE;

        for (String key : numeroVentas.keySet()) {
            int value = ventas.get(key);

            if (value > maxVenta) {
                maxVenta = value;
                barrioMaxVentas = key;
            }
        }
        System.out.println("El barrio que más casas vendió fue " + barrioMaxVentas);

        scanner.close();
    }
}