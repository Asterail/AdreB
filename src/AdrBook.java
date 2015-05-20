import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public void change(int changeIndex, Address AddAddress){
        book[changeIndex] = AddAddress;
    }

    public Address getIndex(int Index){
        return book[Index];
    }

    public void save(String fileName) throws IOException {
        Path file = Paths.get(fileName);
        ArrayList<String> lines = new ArrayList<String>();
        for (int i = 0; i < count; ++i) {
            Address address = book[i];
            lines.add(address.getName());
            lines.add(address.getNumbPhone());
            lines.add(address.getEtc());
        }
        Files.write(file, lines, Charset.forName("UTF-8"));
    }

    public void load(String fileName) throws IOException {
        Path file = Paths.get(fileName);
        List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));
        for (int i = 0; i < lines.size(); i += 3) {
            String name = lines.get(i);
            String phone = lines.get(i + 1);
            String etc = lines.get(i + 2);
            this.add(new Address(name, phone, etc));
        }
    }

    private Address[] book = new Address[100];
    private int count = 0;
}
