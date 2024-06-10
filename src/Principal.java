import com.google.gson.Gson;

import java.io.IOException;
import java.util.Currency;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        CosumoAPI consulta = new CosumoAPI();
        valoresDeCambio monedas = consulta.obtenerTiposDeCambio();
        int opcion = 0;

        System.out.println("**********************************************");
        String menu = """
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                """;

        System.out.println("Escriba la opción a convertir");
        Scanner teclado = new Scanner(System.in);
        while (opcion != 7) {
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Opcion no valida");
                teclado.next();
            }

            try {
                switch (opcion){
                    case 1:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir = teclado.nextDouble();
                        Double tasaArs = monedas.conversion_rates().get("ARS");
                        Double cambio = montoConvertir * tasaArs;
                        System.out.println("la cantidad de: " + montoConvertir + " USD " + " es equivalente a: " + cambio + " ARS");
                        System.out.println("Si desea convertir otra cantidad digite 1 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 2:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir2 = teclado.nextDouble();
                        Double tasaArs2 = monedas.conversion_rates().get("ARS");
                        Double cambio2 = montoConvertir2 / tasaArs2;
                        System.out.println("La cantidad de: " + montoConvertir2 + " ARS " + " es equivalente a: " + cambio2 + " USD");
                        System.out.println("Si desea convertir otra cantidad digite 2 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 3:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir3 = teclado.nextDouble();
                        Double tasaBrl = monedas.conversion_rates().get("BRL");
                        Double cambio3 = montoConvertir3 * tasaBrl;
                        System.out.println("La cantida de: " + montoConvertir3 + " USD " + " es equivalente a: " + cambio3 + " BRL");
                        System.out.println("Si desea convertir otra cantidad digite 3 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 4:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir4 = teclado.nextDouble();
                        Double tasaBrl2 = monedas.conversion_rates().get("BRL");
                        Double cambio4 = montoConvertir4 / tasaBrl2;
                        System.out.println("La cantidad de: " + montoConvertir4 + " BRL " + " es equivalente a: " + cambio4 + " USD");
                        System.out.println("Si desea convertir otra cantidad digite 4 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 5:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir5 = teclado.nextDouble();
                        Double tasaCop = monedas.conversion_rates().get("COP");
                        Double cambio5 = montoConvertir5 * tasaCop;
                        System.out.println("La cantidad de: " + montoConvertir5 + " USD " + " es equivalente a: " + cambio5 + " USD");
                        System.out.println("Si desea convertir otra cantidad digite 5 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 6:
                        System.out.println("Digite el monto a convertir");
                        Double montoConvertir6 = teclado.nextDouble();
                        Double tasaCop2 = monedas.conversion_rates().get("COP");
                        Double cambio6 = montoConvertir6 / tasaCop2;
                        System.out.println("La cantidad de: " + montoConvertir6 + " COP " + "es equivalente a: " + cambio6 + " COP");
                        System.out.println("Si desea convertir otra cantidad digite 6 o digite 7 para salir.");
                        opcion = teclado.nextInt();
                        break;
                    case 7:
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Ingrese una opcion valida");
                teclado.next();
            }

        if (opcion == 7){
            System.out.println("Finalizando programa. Gracias por usar el conversor.");
        }

        }

    }
}
