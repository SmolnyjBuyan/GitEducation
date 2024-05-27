package contacts;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contact {

    private String name;

    private List<Long> phonenumbers = new ArrayList<>();

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Long> getPhonenumbers() {
        return phonenumbers;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        name = name.toLowerCase();
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        return true;
    }
}
