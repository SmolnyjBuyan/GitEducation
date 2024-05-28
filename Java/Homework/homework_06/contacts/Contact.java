package contacts;

import java.util.Objects;

public class Contact {

    private String firstname;
    private String lastname;


    public Contact(String firstname, String lastname) {
        String formatFirstname = firstname.toLowerCase().trim();
        formatFirstname = formatFirstname.substring(0, 1).toUpperCase() + formatFirstname.substring(1);
        String formatLastname = lastname.toLowerCase().trim();
        formatLastname = formatLastname.substring(0, 1).toUpperCase() + formatLastname.substring(1);

        this.firstname = formatFirstname;
        this.lastname = formatLastname;
    }       

    
    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    @Override
    public String toString() {
        return lastname + " " + firstname;
    }

    @Override
    public int hashCode() {
        return this.firstname.charAt(0) + this.lastname.charAt(0);
    }
    // @Override
    // public int hashCode() {
    //     String name = (this.toString()).toLowerCase();
    //     return Objects.hashCode(name);
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (firstname == null && lastname == null) {
            if (other.firstname == null && other.lastname == null)
                return false;
        } else if (!firstname.equals(other.firstname) || !lastname.equals(other.lastname))
            return false;

        return true;
    }
}
