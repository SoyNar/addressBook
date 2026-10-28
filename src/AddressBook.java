import Exceptions.AlreadyExistsException;
import Exceptions.NotFoundexception;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private Map<String, Contact> contacts = new TreeMap<>();
    private Set<String> groups = new TreeSet<>();
    private Map<String, Set<String>> contactsByGroup = new TreeMap<>();
    private List<Contact> history = new ArrayList<>();
    private  final PlannerI plannerI;


    public AddressBook(PlannerI plannerI)
    {
        this.plannerI = plannerI;

    }

    /**
     * Metodo para agregar contacto
     * @param contact contacto a agregar
     *
     * */
    public  Contact  addContact(Contact contact){
        if(contacts.containsKey(contact.getName())){
            throw new AlreadyExistsException("El contacto ya existe");
        }
        contacts.put(contact.getName(),contact);
        history.add(contact);
        return  contact;
    }

    public Contact find(String name)
    {
        return  contacts.get(name);

    }

    /**
     * Metodo para eliminar un contacto
     * @param name
     * @return $boolean
     * */
    public boolean delete(String name){
        Contact contactRemoved = contacts.remove(name);
        if(contactRemoved == null){
            System.out.println("Contacto no encontrado");
            return  false;
        }
        history.remove(contactRemoved);
        System.out.println("Contacto eliminado" + contactRemoved);
        return true;
    }

    /**
     * Listar constactos
     * muestra todos los contactos ordenando en orden alfabetico
     * */

    List<Contact> listContacts(){
       return  new ArrayList<>(contacts.values());
    }

    /**
     * Metodo para listar el historial
     * */

    List<Contact> listHistory(){
        return  new ArrayList<>(history);
    }

    /**
     * MEtodo para agregar un gruupo
     * @param  nameGroup
     * */

    void addGroup(String nameGroup){
        if(!groups.add(nameGroup)){
            throw new AlreadyExistsException("El grupo " + nameGroup + "Ya exist3e");
        }
        contactsByGroup.put(nameGroup, new TreeSet<>());
    }

    /**
     * Metodo para agregar un nombre de contacto a un grupo
     * @param  contactName
     * @param  groupName
     * */

    public void addContactToGroup(String contactName, String groupName)
    {
        if(!contacts.containsKey(contactName)){
            throw new NotFoundexception("El contacto no exist3e" + contactName);
        }
        if(!groups.contains(groupName)){
            throw new NotFoundexception("El grupo no existe");
        }
        contactsByGroup.get(groupName).add(contactName);

    }

    /**
     * Listar grupos en orden alfabetico
     * */
    public List<String> listGroups(){
        return  new ArrayList<>(groups);
    }

    /**
     * Mostrar contactos por nombre de grupo
     * @param groupName
     * */
    List<Contact> contactsByGroupName(String groupName)
    {
        List<Contact> result = new ArrayList<>();
        if(!groups.contains(groupName)){
            throw new NotFoundexception("Al parecer el grupo no existe");
        }
        return  contactsByGroup.get(groupName).stream()
                .map(contacts::get)
                .collect(Collectors.toList());

    }






}
