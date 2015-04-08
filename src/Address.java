/**
 * Created by student on 08.04.2015.
 */
public class Address {
    private String Name;
    private String NumbPhone;
    private String Etc;

    public String getEtc() {
        return Etc;
    }

    public String getNumbPhone() {
        return NumbPhone;
    }

    public String getName() {
        return Name;
    }

    public Address(String name, String numbPhone, String etc) {
        Name = name;
        NumbPhone = numbPhone;
        Etc = etc;
    }

    @Override
    public String toString() {
        return "Name = " + Name + ", Phone = " + NumbPhone + ", Etc = " + Etc;
    }
}
