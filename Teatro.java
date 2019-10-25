import java.util.*;

public class Teatro{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // para ingresar datos: variable = sc.next[TipoDeDato]();
    int opcion, i, j, contFil = 0, contCol = 0;
    double plateaCentral, plateaLateral;
    char Butacas[][] = new char[5][22]; // puede que no se utilize
    double Precio[] = new double[22];
    char Estado[][] = new char[5][22]; // D => disponible, R => reservado, O => ocupado, P => pasillo.
    int ColNumero[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,16,17,18,19,20,21}; // nombre de la columna
    int FilNumero[] = {0,1,2,3,4}; // nombre de la fila

    System.out.print("Ingrese el precio de la platea central: ");
    plateaCentral = sc.nextInt();
    plateaLateral = plateaCentral * 0.85; // para restar el 15%
    System.out.println("");

    for (i = 0; i <= 4; i++) {
      for (j = 0; j <= 21; j++) {
        if(j == 5 || j == 16){ // es un pasillo?
          Estado[i][j] = 'P';
          if(j == 0){
            Precio[j] = 0;
          }
        } else if (j >= 6 || j <= 15) { // es parte de la plateaCentral?
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
