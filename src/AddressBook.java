import Exceptions.AlreadyExistsException;
import Exceptions.NotFoundexception;

import java.security.PrivilegedAction;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook implements PlannerI {

    private Map<String, Contact> contacts = new TreeMap<>();
    private Set<String> groups = new TreeSet<>();
    private Map<String, Set<String>> contactsByGroup = new TreeMap<>();
    private List<Contact> history = new ArrayList<>();
    private  PlannerI plannerI;

    public AddressBook(){}

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
            throw new AlreadyExistsException("Ya existe un contacto con nombre: " + contact.getName());
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
        if(contactRemoved == null) return  false;
        history.remove(contactRemoved);
        for (Set<String> members : contactsByGroup.values()) {
            members.remove(name);
        }
        return true;
    }

    /**
     * Listar constactos
     * muestra todos los contactos ordenando en orden alfabetico
     * */

   public List<Contact> listContacts(){

       return  new ArrayList<>(contacts.values());
    }

    /**
     * Metodo para listar el historial
     * */

    public List<Contact> listHistory(){
        return  new ArrayList<>(history);
    }

    /**
     * MEtodo para agregar un gruupo
     * @param  nameGroup
     * */

    public String addGroup(String nameGroup){
        if(!groups.add(nameGroup)){
            throw new AlreadyExistsException("El grupo " + nameGroup + "Ya existe");
        }
        contactsByGroup.put(nameGroup, new TreeSet<>());
        return  nameGroup;
    }

    /**
     * Metodo para agregar un nombre de contacto a un grupo
     * @param  contactName
     * @param  groupName
     * */

    public String addContactToGroup(String contactName, String groupName)
    {
        if(!contacts.containsKey(contactName)){
            throw new NotFoundexception("El contacto: " + contactName + " No existe");
        }
        if(!groups.contains(groupName)){
            throw new NotFoundexception("El grupo : " + groupName + " No existe");
        }
        contactsByGroup.get(groupName).add(contactName);
        return  groupName;
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
    public List<Contact> contactsByGroupName(String groupName)
    {
        if(!groups.contains(groupName)){
            throw new NotFoundexception("Al parecer el grupo no existe");
        }
        return  contactsByGroup.get(groupName).stream()
                .map(contacts::get)
                .collect(Collectors.toList());

    }

}
