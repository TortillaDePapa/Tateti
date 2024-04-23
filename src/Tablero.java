import java.util.Arrays;
import java.util.Objects;

public class Tablero {

    private static final String [][] tablero = new String[3][3];
    public Tablero(){
        for (int i = 0; i <tablero.length ; i++) {
            Arrays.fill(tablero[i], "-");
        }
    }
    public static void tableroMostrar(){
        System.out.println("Tablero:");
        for (int i = 0; i <tablero.length ; i++) {
            for (int j = 0; j <tablero[i].length ; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
    public static void tableroMod(String ju,byte fila,byte columna){

        tablero[fila][columna]= String.valueOf(ju);


        System.out.println("Tablero:");
        for (int i = 0; i <tablero.length ; i++) {
            for (int j = 0; j <tablero[i].length ; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean empate(){
        for (int i = 0; i <tablero.length ; i++) {
            //verificar filas
            if (tablero[i][0]!= "-" && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] ){
                return false;
            }else if(tablero[0][i]!= "-" && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]){
                return false;
            }
        }
        // Verificar diagonales
        if (tablero[0][0] != "-" && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return false; // No hay empate, hay un ganador en la diagonal principal
        }else if (tablero[0][2] != "-" && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return false; // No hay empatye, hay un ganador en la diagonal secundaria
        }
        return true; // Hay empate
    }

    public static boolean encontrarGanador(int fila, int columna){
        for (int i = 0; i <tablero.length; i++) {
            //verificar filas
            if (tablero[i][0]!= "-" && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] ){
                return true;
            }else if(tablero[0][i]!= "-" && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]){
                return true;
            }
        }
        // Verificar diagonales
        if (tablero[0][0] != "-" && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true; // Hay un ganador en la diagonal principal
        }else if (tablero[0][2] != "-" && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true; // Hay un ganador en la diagonal secundaria
        }
        return false; // No hay ganador todavía
    }

    public static boolean espacioLibre(int fila, int columna){
        if(tablero[fila][columna]=="-"){
            return true;
        }else{
            return false;
        }

    }
}
