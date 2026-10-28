import java.util.List;

public interface PlannerI {

    Contact addContact(Contact contact);
    Contact find(String name);
    boolean delete(String name);
    List<Contact> listContacts();
    List<Contact> listHistory();
    String addGroup(String groupName);
    String addContactToGroup(String contactName, String groupName);
    List<String> listGroups();
    List<Contact> contactsByGroupName(String groupName);

}
