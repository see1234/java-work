import java.util.*;

public class HomeWork6 {
    public static void main(String[] args) {
        HashMap<Integer, NoteBook> notebooks = new HashMap<Integer, NoteBook>();
        HomeWork6 hm6 = new HomeWork6();
        hm6.loadNoteBooks(notebooks);
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:" +
                "\n1. Размер диска\n2. Размер оперативной памяти\n3. Операционная система\n4. Цвет");
        System.out.println("5. Вывести предпочтенные тебе ноутбуки");
        System.out.println("6. сброс параметров");
        HashMap<String, String> param = new HashMap<String, String>();
        while(scan.hasNext()) {
            String input = scan.next();
            switch (input) {
                case "5":
                    int size = 0;
                    for (Map.Entry notebook : notebooks.entrySet()) {

                        NoteBook nb = (NoteBook) notebook.getValue();
                        if(param.containsKey("color") && !nb.getColor().equals(param.get("color"))) {
                            break;
                        }
                        else if(param.containsKey("oc") && !nb.getOc().equals(param.get("oc"))) {
                            break;
                        }
                        else if(param.containsKey("ram") && !String.valueOf(((int)nb.getRam())).equals(param.get("ram"))) {
                            break;
                        }
                        else if(param.containsKey("size_disk") &&!String.valueOf(nb.getTotal_volume_solid_state_drives()).equals(param.get("size_disk"))) {
                            break;
                        }
                        size+=1;
                        int id = ((int) notebook.getKey()) + 1;
                        System.out.println(id + ": " + nb.getName());
                    }
                    if(size == 0) {
                        System.out.println("ноутбуков таких нет");
                    }
                    break;
                case "1":
                    System.out.print("Введите размер диска (число) в гбайтах:");
                    int mb = scan.nextInt();
                    param.put("size_disk", String.valueOf(mb));
                    break;
                case "2":
                    System.out.print("Размер оперативной памяти (число) в гбайтах:");
                    int megabyte = scan.nextInt() * 1024;
                    param.put("ram", String.valueOf(megabyte));
                    break;
                case "3":
                    System.out.print("Операционная система:");
                    String oc = scan.next();
                    param.put("oc", oc);
                    break;
                case "4":
                    System.out.print("Цвет:");
                    String color = scan.next();
                    param.put("color", color);
                    break;
                case "6":
                    System.out.println("Вы сбросили все");
                    param.clear();
                    break;
                default:
                    System.out.println("Введите цифру, соответствующую необходимому критерию:" +
                        "\n1. Размер диска\n2. Размер оперативной памяти\n3. Операционная система\n4. Цвет");
                    System.out.println("5. вывести предпочтенные тебе ноутбуки");
                    System.out.println("6. сброс параметров");
            }

        }

    }
    public void loadNoteBooks(HashMap<Integer, NoteBook> notebooks) {
        NoteBook nb1 = new NoteBook("HD (1366x768), TN+film, Qualcomm Snapdragon 7c Gen 1, ядра: 8 х 2.4 ГГц, RAM 4 ГБ, eMMC 128 ГБ, Qualcomm Adreno 618 , Windows 11 Home Single Language", notebooks);
        nb1.setGame(false);
        nb1.setColor("Черный");
        nb1.setInch((float) 14.1);
        nb1.setRam(4, "gb");
        nb1.setGraphics_card("нет");
        nb1.setOc("не поставлена");
        nb1.setProcess("Qualcomm Snapdragon 7c Gen 1 8 x 2.4 GHz");
        nb1.setTotal_volume_solid_state_drives(256);
        NoteBook nb2 = new NoteBook("Full HD (1920x1080), IPS, AMD Ryzen 7 4800H, ядра: 8 х 2.9 ГГц, RAM 8 ГБ, SSD 512 ГБ, GeForce RTX 3050 для ноутбуков 4 ГБ, без ОС", notebooks);
        nb2.setGame(true);
        nb2.setColor("Черный");
        nb2.setInch((float) 17.3);
        nb2.setRam(4, "gb");
        nb2.setGraphics_card("GeForce RTX 3050 для ноутбуков");
        nb2.setOc("не поставлена");
        nb2.setProcess("AMD Ryzen 7 4800H 8 x 2.9 GHz");
        nb2.setTotal_volume_solid_state_drives(512);
        NoteBook nb3 = new NoteBook("Full HD (123123231423x324234234), IPS, AMD Ryzen 81123 4800000H, ядра: 8 х 400.5 ГГц, RAM 8 ГБ, SSD 512 ГБ, GeForce RTX 4090 для ноутбуков 4 ГБ, без ОС", notebooks);
        nb3.setGame(true);
        nb3.setColor("Черный");
        nb3.setInch((float) 234.3);
        nb3.setRam(4, "gb");
        nb3.setGraphics_card("GeForce RTX 4090 для ноутбуков");
        nb3.setOc("не поставлена");
        nb3.setProcess("AMD Ryzen 81123 4800000H 8 x 400.5 GHz");
        nb3.setTotal_volume_solid_state_drives(512);
    }
}
