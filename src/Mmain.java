/**
 * Created by student on 08.04.2015.
 */
import java.util.Scanner;
public class Mmain {
    public static void main(String[] args) {
        AdrBook Book1= new AdrBook();
        while(true){
            System.out.println("Адресная книга. Выберите команду:\n" +
                    "1.Добавление записи (дополнительно запрашивается имя, телефон и e-mail)\n" +
                    "2.Поиск записей (дополнительно запрашиватеся имя для поиска)\n" +
                    "3.Вывод всех записей\n" +
                    "4.Удаление записи (дополнительно запрашивается индекс записи для удаления)\n" +
                    "5.Изменение записи (дополнительно запрашивается индекс изменяемой записи, новые имя, телефон и e-mail)\n" +
                    "6.Выход из программы");
            Scanner in = new Scanner(System.in);
            int task = in.nextInt();
            switch (task){
                case 1:
                    System.out.println("Введите имя: ");
                    String n1 = in.next();
                    System.out.println("Введите номер: ");
                    String n2 = in.next();
                    System.out.println("Введите дополнительную информацию: ");
                    String n3 = in.next();
                    Book1.add(new Address(n1,n2,n3));
                    break;
                case 2:
                    System.out.println("Введите искомое имя целиком или частично: ");
                    String search = in.next();
                    int[] found=Book1.findName(search);
                    if (found.length == 0){
                        System.out.println("Не найдено подходящих записей.");
                }
                    for (int i = 0; i < found.length; ++i) {
                        System.out.println((found[i]+1)+". "+Book1.getIndex(found[i]));
                    }
                    break;
                case 3:
                    Book1.print();
                    break;
                case 4:
                    System.out.println("Введите номер удаляемой записи: ");
                    int del = in.nextInt();
                    Book1.delete(del-1);
                    System.out.println("Запись №"+del+" удалена.");
                    break;
                case 6:
                    return;

            }
        }
        //Book1.add(new Address("A","123","etc"));
        //Book1.add(new Address("B","321","cte"));
        //Book1.print();
        //Book1.findName("A");
    }
}
