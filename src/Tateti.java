import java.util.Arrays;
import java.util.Scanner;

public class Tateti implements jugador {

    public Tateti(){
    }
    static Tablero t = new Tablero();
    public static void jugar(){
        Tablero.tableroMostrar();
        boolean gano = false;
        boolean empate = false;
        byte turnos = 0;
        String jGuardado = "";
        boolean error = false;
        while (!gano || !empate){
            String [] jugadores = new String[2];
            jugadores[0] = j1;
            jugadores[1]= j2;
            byte eleccion = 5, eleccion1=5;
            try {
                for (int i = 0; i <jugadores.length ; i++) {
                    Scanner sc = new Scanner(System.in);
                        if (error){
                            System.out.print("jugador "+jGuardado +", ingresa fila(0-2): ");
                            eleccion = sc.nextByte();
                            System.out.println();
                            System.out.print("jugador "+jGuardado+", ingresa columna(0-2): ");
                            eleccion1 = sc.nextByte();
                            System.out.println();
                            if (espacioLibre(eleccion,eleccion1)){
                                error = false;
                                mostrarTableroMod(jGuardado,eleccion,eleccion1);
                                turnos++;
                                System.out.println(turnos);
                                gano = Tablero.encontrarGanador(eleccion,eleccion1);
                                if (gano){
                                    empate = true;
                                    System.out.println("El ganador fue:" +jGuardado);
                                    break;
                                }
                                if (turnos==9){
                                    if(hayEmpate()){
                                        gano = true;
                                        System.out.println("Hay empate.");
                                        empate = hayEmpate();
                                        break;
                                    }
                                }
                                if (jGuardado == "x"){
                                    i++;
                                }else if (jGuardado == "o"){
                                    i--;
                                }
                            }else {
                                System.out.println("Espacio ya ocupado, elija otro");
                                error = true;
                            }


                        }else {
                            jGuardado = jugadores[i];
                            System.out.print("jugador "+jugadores[i] +", ingresa fila(0-2): ");
                            eleccion = sc.nextByte();
                            System.out.println();
                            System.out.print("jugador "+jugadores[i]+", ingresa columna(0-2): ");

                            eleccion1 = sc.nextByte();
                            System.out.println();
                            if (espacioLibre(eleccion,eleccion1)){
                                mostrarTableroMod(jugadores[i],eleccion,eleccion1);
                                turnos++;
                                System.out.println(turnos);
                                gano = Tablero.encontrarGanador(eleccion,eleccion1);
                                if (gano){
                                    empate = true;
                                    System.out.println("El ganador fue:" +jugadores[i]);
                                    break;
                                }
                                if (turnos==9){
                                    if(hayEmpate()){
                                        gano =true;
                                        System.out.println("Hay empate.");
                                        empate = hayEmpate();
                                        break;
                                    }
                                }
                            }else {
                                System.out.println("Espacio ya ocupado, elija otro");
                                error=true;
                            }
                        }

                    }

                }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("numero no valido, elija un numero entre 0 y 2.");
                error = true;
            }
        }




    }


    public static void mostrarTableroMod(String jugador,byte eleccionFila, byte eleccionColumna){
        Tablero.tableroMod(jugador,eleccionFila,eleccionColumna);
    }

    public static boolean hayEmpate(){
        return Tablero.empate();
    }

    public static boolean espacioLibre(int fila, int columna){
        return Tablero.espacioLibre(fila, columna);
    }


}
