import java.util.*;

public class Teatro{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // para ingresar datos: variable = sc.next[TipoDeDato]();
    int opcion, i, j, contFil = 0, contCol = 0;
    double plateaCentral, plateaLateral;
    char Butacas[][] = new char[5][22]; // puede que no se utilize
    double Precio[] = new double[22];
    char Estado[][] = new char[5][22]; // D => disponible, R => reservado, O => ocupado, P => pasillo.
    int ColNumero[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}; // nombre de la columna
    int FilNumero[] = {0,1,2,3,4}; // nombre de la fila

    System.out.print("Ingrese el precio de la platea central: ");
    plateaCentral = sc.nextInt();
    plateaLateral = plateaCentral * 0.85; // para restar el 15%
    System.out.println("****************************************************");
    System.out.println("");

    for (i = 0; i <= 4; i++) {
      for (j = 0; j <= 21; j++) {
        if(j == 5 || j == 16){ // es un pasillo?
          Estado[i][j] = ' ';
          if(j == 0){
            Precio[j] = 0;
          }
        } else if (j >= 6 && j <= 15) { // es parte de la plateaCentral?
          Estado[i][j] = 'D';

          if(i == 0){
            Precio[j] = plateaCentral;
          }
        } else { // entonces es parte de la plateaLateral
          Estado[i][j] = 'D';
          if(i == 0){
            Precio[j] = plateaLateral;
          }
        }
      } // end for j
    } // end for i

    do {
        System.out.println("*****BINVENIDOS AL TEATRO*****");
        System.out.println("");
        System.out.println("******************************");
        System.out.println("1. MOSTRAR BUTACAS");
        System.out.println("");
        System.out.println("2. REGISTRAR RESERVACION");
        System.out.println("");
        System.out.println("3. REGISTRAR VENTA DE BUTACAS");
        System.out.println("");
        System.out.println("4. ANULAR VENTAS DE BUTACAS");
        System.out.println("");
        System.out.println("5. MOSTRAR RESUMEN DE BUTACAS");
        System.out.println("");
        System.out.println("6. SALIR");
        System.out.println("******************************");
        System.out.println("");
        System.out.print("DIGITE UNA OPCION: ");

        opcion = sc.nextInt();
        System.out.println("");

        switch(opcion){
          case 1: // MOSTRAR BUTACAS
            for (i=0; i<=21; i++) {
              System.out.print("\t" + ColNumero[i]);
            }
            System.out.println("");
            for (i = 0; i <= 4; i++) {
              for (j = 0; j <= 21; j++){
                if(j == 0){
                  System.out.print(FilNumero[i] + "\t");
                }
                System.out.print(Estado[i][j] + "\t");
              }
              System.out.println();
            }
            break;
          case 2: // REGISTRAR RESERVACION
            break;
          case 3: // REGISTRAR VENTA DE BUTACAS
            int n,f,as,tarjeta;
            boolean valid = false;
            char disp = 'D';
            double subtotal = 0, pagaCon = 0,cambio = 0;

            System.out.println("Registro de venta de butacas");
            System.out.println();

              System.out.print("Ingrese el numero de asientos consecutivos: ");
              n = sc.nextInt();

              System.out.print("Ingrese el numero de fila: ");
              f = sc.nextInt();
              System.out.println("**************************************************");

              if(f >= 0 || f <= 4){
                do {
                  System.out.print("Ingrese el numero de la columna correspondiente: ");
                  as = sc.nextInt();

                  if(as == 5 || as == 16 || as < 0 || as > 21){
                    System.out.println("Elija una opcion valida");
                  } else {
                    valid = true;
                  }
                } while(!valid);


                for(i = as; i < (as + n); i++){
                  if (Estado[f][i] == 'D'){
                    // System.out.println("Bien");
                  } else {
                    valid = false;
                  }
                }

                if(valid){
                  subtotal = Precio[as] * n;
                  System.out.println("**************************************************");
                  System.out.println("El total es: c" + subtotal);
                  System.out.println("[1] Pago en efectivo");
                  System.out.println("[2] Tarjeta de debito");
                  System.out.println("[3] Tarjeta de credito");

                  do{
                    System.out.print("Seleccione el metodo de pago: ");
                    opcion = sc.nextInt();

                    switch(opcion){
                      case 1:
                        System.out.print("Paga con: c");
                        pagaCon = sc.nextDouble();
                        if(pagaCon > subtotal){
                          cambio = pagaCon - subtotal;
                          System.out.println("Cambio: c" + cambio);
                        }
                        break;
                      case 2:
                        System.out.print("Ingrese el numero de la tarjeta: ");
                        tarjeta = sc.nextInt();
                        break;
                      case 3:
                        System.out.print("Ingrese el numero de la tarjeta: ");
                        tarjeta = sc.nextInt();
                        break;
                      default:
                        System.out.println("Error");
                    }
                  } while(!valid);

                  System.out.println("**************************************************");

                  for(i = as; i < (as + n); i++){
                    Estado[f][i] = 'O';
                  }

                } else {
                  System.out.println("La venta no se puede realizar.");
                }

              } else {
                System.out.println("El numero de filas no es valido. Vuelva a intentar");
              }


              valid = false;


            break;
          case 4: // ANULAR VENTAS DE BUTACAS
            break;
          case 5: // MOSTRAR RESUMEN DE BUTACAS
            break;
          case 6: // SALIR
            break;
          default: // MANEJO DE ERRORES

        } // end switch
        System.out.println("");
    }while(opcion != 6); // end do while

    System.out.println("");
    System.out.println("MUCHAS GRACIAS POR VISITAR EL TEATRO!");
  }
}
