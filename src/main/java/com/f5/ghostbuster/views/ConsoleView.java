package com.f5.ghostbuster.views;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


import com.f5.ghostbuster.models.Ghost;

public class ConsoleView {
private Scanner scanner = new Scanner(System.in);
    public int showMenu() {
        System.out.println("============================================");
        System.out.println("¡Bienvenido a la Base Ghostbusters Asturias!");
        System.out.println("Captura y gestiona tus fantasmas atrapados y protege la región");
        System.out.println("============================================");
        System.out.println("1. Capturar un nuevo fantasma");
        System.out.println("2. Ver lista de fantasmas capturados");
        System.out.println("3. Liberar un fantasma");
        System.out.println("4. Filtrar fantasmas por clase");
        System.out.println("5. Filtrar fantasmas por fecha");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }
    
    public Ghost createGhost() {

        scanner.nextLine();
        System.out.print("Ingresa el name del fantasma:");
        String name = scanner.nextLine();

        Ghost.Class ghostClass = getGhostClass();
        Ghost.DangerLevel dangerLevel = getDangerLevel();

        System.out.print("Habilidad especial:");
        String ability = scanner.nextLine();

        return new Ghost(name, ghostClass, dangerLevel, ability);
    }

    public int getGhostId() {
        System.out.print("Ingrese el ID del fantasma: ");
        return scanner.nextInt();
    }

    public void showAllGhosts(List<Ghost> ghosts) {
        System.out.println("\nLista de Fantasmas Capturados:");
        System.out.println("ID   Nombre                           Clase           Peligro    Fecha");
        System.out.println("----------------------------------------------------------------------------");
        ghosts.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public Ghost.Class getGhostClass(){

        System.out.println("Selecciona la clase del fantasma:");
        for (Ghost.Class c : Ghost.Class.values()) {
            System.out.println((c.ordinal() + 1) + ". " + c); 
        }

        int ghostClassInput = scanner.nextInt();
        while (!validateGhostClass(ghostClassInput)) {
            System.out.println("Selecciona una clase de la lista:");
            ghostClassInput = scanner.nextInt();
        }

        return Ghost.Class.values()[ghostClassInput];
    }

    public Ghost.DangerLevel getDangerLevel(){

        System.out.println("Selecciona el nivel de peligro:");
        for (Ghost.DangerLevel dangerLevel : Ghost.DangerLevel.values()) {
            System.out.println((dangerLevel.ordinal() + 1) + ". " + dangerLevel);
        }

        int dangerLevelInput = scanner.nextInt();
        while (!validateDangerLevel(dangerLevelInput)) {
            System.out.println("Selecciona el nivel de peligrosidad de la lista:");
            dangerLevelInput = scanner.nextInt();
        }

        return Ghost.DangerLevel.values()[dangerLevelInput - 1];
    }

    public LocalDate getLocalDate(){
        System.out.println("Ingresa una fecha para ver los fantsmas capturados ese día (AAAA-MM-DD):");
        return LocalDate.parse(scanner.nextLine());

    }

    private boolean validateGhostClass(int input) {
        if((input - 1) > Ghost.Class.values().length) {
            return false;
        }
        
        return true;

    }
    private boolean validateDangerLevel(int input) {
        if((input - 1) > Ghost.DangerLevel.values().length) {
            return false;
        }
        
        return true;

    }

}



