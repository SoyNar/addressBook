import Exceptions.AlreadyExistsException;
import Exceptions.NotFoundexception;

import java.util.List;

public class MainMenu {

   private static  final String MENU = """
                
                
                === AGENDA DE CONTACTOS ===
                1. Agregar contacto
                2. Buscar contacto
                3. Eliminar contacto
                4. Listar contactos (orden alfabetico)
                5. Listar historial (orden de insercion)6. Agregar grupo
                6. Agregar  grupo
                7. Agregar contacto a grupo
                8. Listar grupos
                9. Mostrar contactos por grupo
                10. Salir
                ===================
                """;
    private  final PlannerI plannerI;
    private  final  Console console;

    public MainMenu(PlannerI plannerI,
                    Console console){
        this.plannerI = plannerI;
        this.console = console;
    }
    /**
     * Metodo que ejecuta el menú
     * */
    public void run(){
        boolean active = true;

        while (active){
            System.out.println(MENU);
            int option = console.readNumber("");

            try {

                switch (option) {
                    case 1 -> addContacts();
                    case 2 -> find();
                    case 3 -> delete();
                    case 4 -> list();
                    case 5 -> listHistory();
                    case 6 -> addGroup();
                    case 7 -> addContactGroup();
                    case 8 -> listGroups();
                    case 9 -> showContactByGroup();
                    case 10 -> {
                        active = false;
                        System.out.println("Saliendo de la agenda...");
                    }
                    default -> System.out.println("Opcion invalida");
                }
            }catch (NotFoundexception | AlreadyExistsException e){
                System.out.println("Error " + e.getMessage());
            }catch (Exception e){
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }


    }
   /**
    * Metodo para agregar contactos
    * */
    private void  addContacts()
    {
        System.out.println("===================AGREGAR UN CONTACTO ===============");

        String name = console.readText("Nombre: ");
        String phone = console.readText("Telefono: ");
        String  email = console.readText("Correo: ");
        Contact c = new Contact.Builder().name(name).phone(phone).email(email).build();
        Contact createdC = plannerI.addContact(c);
        System.out.println("Contacto agregado: " + createdC.getName());

    }

    /**
     * MEtodo para encontrar contactos
     * */
    private void find(){
        System.out.println("===================BUSCAR UN CONTACTO ===============");

        String name = console.readText("Nombre de contacto: ");
        Contact found = plannerI.find(name);
       if (found == null){
           System.out.println("No se encontro el contacto: " + name);
       }else {
           System.out.println(found);

       }

    }
/**
 * Eliminar
 * */
    private void delete(){
        System.out.println("===================ELIMINAR UN CONTACTO ===============");
        String name = console.readText("Escribe el nombre: ");
        if(plannerI.delete(name)){
            System.out.println("Contacto eliminado: " + name);
        }else {
            System.out.println("Contacto no encontrado: " + name);
        }
    }
/**
 * Listar contactos orden alfabetico
 * */
    private void list(){
        System.out.println("===================LISTAR UN CONTACTOS ===============");

        System.out.println("--- Lista de contactos (ORDEN ALFABETICO)");
        plannerI.listContacts().stream().forEach(System.out::println);
    }
/**
 * Historial de inserción
 * */
    private void listHistory(){
        System.out.println("------Historial (Orden de inserción)");
        plannerI.listHistory().stream().forEach(System.out::println);
    }
/**
 * Metodo para agregar un grupo nuevo
 * */
    private void addGroup(){
        System.out.println("===================AGREGAR  UN GRUPO ===============");

        String name = console.readText("Esccribe nombre de grupo: ");
        String group = plannerI.addGroup(name);
        System.out.println("Grupo '" + name + "' creado");
    }
/**
 * MEtodo para agregar contacto a un grupo
 * */
    private void addContactGroup()
    {
        System.out.println("===================AGREGAR UN CONTACTO A UN GRUPO ===============");
        String nameGroup = console.readText("Escribe nombre de grupo: ");
        String nameContact = console.readText("Escribe nombre de contacto");
        String group = plannerI.addContactToGroup(nameContact,nameGroup);
        System.out.println("Contacto agregado al grupo '" + group + "'");

    }
    /**
     * Metodo para listar todos los grupos
     * */
    private void listGroups(){
        System.out.println("--- GRUPOS ---");
        plannerI.listGroups().forEach(g -> System.out.println("- " + g));
    }
    /**
     * MEtodo para mostrar los contactos de un grupo
     * */
    private  void showContactByGroup()
    {
        System.out.println("===================MOSTRAT UN CONTACTOS DE UN GRUPO ===============");

        String nameGroup = console.readText("Escriba el nombre del grupo porfa");
        List<Contact> members = plannerI.contactsByGroupName(nameGroup);
        if (members.isEmpty()) {
            System.out.println("El grupo '" + nameGroup + "' no tiene contactos");
            return;
        }
        System.out.println("Nombre del grupo" + nameGroup);
       members.forEach(c -> System.out.println("- " + c));

    }



}
