package com.f5.ghostbuster.views;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.dto.GhostDTO;

public class ConsoleView {
    private GhostBusterController controller;
    private Scanner scanner;

    public ConsoleView(GhostBusterController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int showMenu() {
        int option = -1;
        boolean valid = false;

        while (!valid) {
            try {
                showMessage("============================================");
                showMessage("¡Bienvenido a la Base Ghostbusters Asturias!");
                showMessage("Captura y gestiona tus fantasmas atrapados y protege la región");
                showMessage("============================================");
                showMessage("1. Capturar un nuevo fantasma");
                showMessage("2. Ver lista de fantasmas capturados");
                showMessage("3. Liberar un fantasma");
                showMessage("4. Filtrar fantasmas por clase");
                showMessage("5. Filtrar fantasmas por fecha");
                showMessage("6. Salir");
                System.out.print("Selecciona una opción: ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    valid = true; 
                } else {
                    showMessage("Entrada inválida. Por favor, ingresa un número.");
                    scanner.next(); 
                }
            } catch (Exception e) {
                showMessage("Error al leer la entrada. Inténtalo nuevamente.");
                scanner.next(); 
            }
        }
        return option;
    }

    public void captureGhost() {
        scanner.nextLine();
        System.out.print("Ingresa el nombre del fantasma:");
        String name = scanner.nextLine();

        String ghostClass = selectGhostClass();
        String dangerLevel = selectDangerLevel();
    
        System.out.print("Habilidad especial:");
        String ability = scanner.nextLine();

        GhostDTO ghostDTO = new GhostDTO(name, ghostClass, dangerLevel, ability);
        if (controller.captureGhost(ghostDTO)) {
            showMessage("Fantasma capturado correctamente");
        }else {
            showMessage("No se ha podido capturar el fantasma");
        }
    }

    public void getAllGhost() {
        List<GhostDTO> ghosts = controller.getAllGhosts();
        if(ghosts.isEmpty()) {
            showMessage("No hay fantasmas capturados.");
        }else {

            showMessage("\nLista de Fantasmas Capturados:");
            showMessage("ID   Nombre                           Clase           Peligro    Fecha");
            showMessage("----------------------------------------------------------------------------");
            ghosts.forEach(System.out::println);
            showMessage("----------------------------------------------------------------------------");
        }
    }

    public void freeGhost() {
        showMessage("Ingrese el ID del fantasma: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        while(id<=0){
            showMessage("Id inválido, ingrese un nuevo id: ");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        
        if(controller.freeGhost(id)) {
            showMessage("Fantasma borrado correctamente");
        }else {
            showMessage("No se encontró fantasma con ese ID");
        }
    }

    public void filterGhostByClass(){
        String ghostClass = selectGhostClass();
        List<GhostDTO> ghosts = controller.filterGhostsByClass(ghostClass);
        if(ghosts.isEmpty()) {
            showMessage("No hay fantasmas capturados de esa clase.");
        }else {
            showMessage("\nFantasamas filtrados por" + ghostClass + ":");
            showMessage("ID   Nombre                           Clase           Peligro    Fecha");
            showMessage("----------------------------------------------------------------------------");
            ghosts.forEach(System.out::println);
            showMessage("----------------------------------------------------------------------------");
        }
    }
    public void filterGhostsByDate(){
        LocalDate date = getLocalDate();
        List<GhostDTO> ghosts = controller.filterGhostsByDate(date);
        if(ghosts.isEmpty()) {
            showMessage("No hay fantasmas capturados en esa fecha.");
        }else {
            showMessage("\nFantasamas filtrados por fecha - " + date + ":");
            showMessage("ID   Nombre                           Clase           Peligro    Fecha");
            showMessage("----------------------------------------------------------------------------");
            ghosts.forEach(System.out::println);
            showMessage("----------------------------------------------------------------------------");
        }
    }

    private String selectGhostClass() {
        List<String> ghostClasses = controller.getGhostClasses();
        
        showMessage("Selecciona la clase del fantasma:");
        for (int i = 0; i < ghostClasses.size(); i++) {
            showMessage((i + 1) + ". " + ghostClasses.get(i));
        }
    
        int choice = scanner.nextInt();
        scanner.nextLine(); 
    
        while (choice < 1 || choice > ghostClasses.size()) {
            showMessage("Opción inválida. Selecciona un número de la lista:");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
    
        return ghostClasses.get(choice - 1); 
    }

    private String selectDangerLevel() {
        List<String> ghostDangerLevel = controller.getDangerLevels();
        
        showMessage("Selecciona el nivel de peligro del fantasma:");
        for (int i = 0; i < ghostDangerLevel.size(); i++) {
            showMessage((i + 1) + ". " + ghostDangerLevel.get(i));
        }
    
        int choice = scanner.nextInt();
        scanner.nextLine(); 
    
        while (choice < 1 || choice > ghostDangerLevel.size()) {
            showMessage("Opción inválida. Selecciona un número de la lista:");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        return ghostDangerLevel.get(choice - 1); 
    }

    private LocalDate getLocalDate() {
        showMessage("Ingresa una fecha para ver los fantsmas capturados ese día (AAAA-MM-DD):");
        String date = scanner.nextLine();
        while (!validateDate(date)) {
            showMessage("La fecha ingresada no es válida. Por favor, usa el formato AAAA-MM-DD.");
            date = scanner.nextLine();
        }
        return LocalDate.parse(date);
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
