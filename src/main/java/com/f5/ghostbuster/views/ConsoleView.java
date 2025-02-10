package com.f5.ghostbuster.views;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.f5.ghostbuster.models.Ghost;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        int option = -1;
        boolean valid = false;

        while (!valid) {
            try {
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

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    valid = true; 
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.next(); 
                }
            } catch (Exception e) {
                System.out.println("Error al leer la entrada. Inténtalo nuevamente.");
                scanner.next(); 
            }
        }
        return option;
    }

    public Ghost createGhost() {
        scanner.nextLine();
        System.out.print("Ingresa el nombre del fantasma:");
        String name = scanner.nextLine();

        Ghost.Class ghostClass = getGhostClass();
        scanner.nextLine();
        Ghost.DangerLevel dangerLevel = getDangerLevel();
        scanner.nextLine();

        System.out.print("Habilidad especial:");
        String ability = scanner.nextLine();

        return new Ghost(name, ghostClass, dangerLevel, ability);
    }

    public int getGhostId() {
        System.out.print("Ingrese el ID del fantasma: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
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

    public Ghost.Class getGhostClass() {

        System.out.println("Selecciona la clase del fantasma:");
        for (Ghost.Class c : Ghost.Class.values()) {
            System.out.println((c.ordinal() + 1) + ". " + c);
        }

        int ghostClassInput = scanner.nextInt();
        while (!validateGhostClass(ghostClassInput)) {
            System.out.println("Selecciona una clase de la lista:");
            ghostClassInput = scanner.nextInt();
        }

        return Ghost.Class.values()[ghostClassInput - 1];
    }

    public Ghost.DangerLevel getDangerLevel() {

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

    public LocalDate getLocalDate() {
        System.out.println("Ingresa una fecha para ver los fantsmas capturados ese día (AAAA-MM-DD):");
        String date = scanner.nextLine();
        while (!validateDate(date)) {
            System.out.println("La fecha ingresada no es válida. Por favor, usa el formato AAAA-MM-DD.");
            date = scanner.nextLine();
        }
        return LocalDate.parse(date);
    }

    private boolean validateGhostClass(int input) {
        if (input > Ghost.Class.values().length || input <= 0) {
            return false;
        }
        return true;
    }

    private boolean validateDangerLevel(int input) {
        if (input > Ghost.DangerLevel.values().length || input <= 0) {
            return false;
        }
        return true;
    }

    private boolean validateDate(String input) {
        try {
            LocalDate.parse(input);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
