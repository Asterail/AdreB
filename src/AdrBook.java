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
            System.out.println((i+1)+". "+book[i]);
        }

    }
    public int[] findName(String NameSearch) {
        int resultCount = 0;
        for (int i = 0; i < count; ++i) {
            if (book[i].getName().startsWith(NameSearch)) {
                resultCount++;
            }
        }
        int searchElement = 0;
        int[] result = new int[resultCount];
        for (int i = 0; i < count; ++i) {
            if (book[i].getName().startsWith(NameSearch)) {
                result[searchElement] = i;
                searchElement++;
            }
        }
        return result;
    }
    public void delete(int deleteIndex) {
        for (int i = deleteIndex+1; i < count; ++i){
            book[i-1]=book[i];
        }
        book[count-1]=null;
        count--;
    }
    public Address getIndex(int Index){
        return book[Index];
    }

    private Address[] book = new Address[100];
    private int count = 0;
}
