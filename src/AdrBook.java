/**
 * Created by student on 08.04.2015.
 */
public class AdrBook {
    public void add(Address AddAddress) {
        book[count] = AddAddress;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; ++i) {
            System.out.println(book[i]);
        }

    }
    public void findName(String NameSearch) {
        for (int i = 0; i < count; ++i) {
            if (book[i].getName().startsWith(NameSearch)){
                System.out.println(book[i]);
            }
        }
    }

    private Address[] book = new Address[100];
    private int count = 0;
}
