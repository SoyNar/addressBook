import java.util.List;

public interface PlannerI {

    Contact add(Contact contact);
    Contact find(String name);
    boolean delete(String name);
    List<Contact> all();
    List<Contact> getHistory();
    void addGroup(String groupName);
    void addContactToGroup(String contactName, String groupName);
    List<String> getSortedGroups();
    List<Contact> getContactsByGroup(String groupName);

}
