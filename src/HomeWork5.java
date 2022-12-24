import java.util.*;

public class HomeWork5 {
    public static void main(String[] args) {
        Task4();
    }

    public static void Task1() {
        HashMap<String, String> telephoneList = new HashMap<>();
        telephoneList.put("Иван", "1231234,124234234");
        telephoneList.put("Иван2", "543543,543543");
        System.out.println(findTphone(telephoneList, "Иван"));
    }

    public static void Task2() {
        List<String> peoples = new ArrayList<>();
        peoples.add("Иван Иванов");
        peoples.add("Иван Иванов");
        peoples.add("Иван Иванов");
        peoples.add("Иван Алексов");
        peoples.add("Александр Иванов");
        peoples.add("Александр Иванов");
        peoples.add("Петр Иванов");
        peoples.add("Павел Алексов");
        HashMap<String, Integer> hash_peoples = new HashMap<>();
        int count = 0;
        for (int i = 0; i < peoples.size(); i++) {
            for (int j = 0; j < peoples.size(); j++) {
                if (peoples.get(i).equals(peoples.get(j))) {
                    count += 1;
                }
            }
            hash_peoples.putIfAbsent(peoples.get(i), count);
            count = 0;


        }
        for (Map.Entry hash_people : hash_peoples.entrySet()) {
            System.out.println(hash_people.getKey() + ": " + hash_people.getValue());
        }

        String tempVar;
        for (int i = 0, mid = peoples.size() >> 1, j = peoples.size() - 1; i < mid; i++, j--) {
            tempVar = peoples.get(i);
            peoples.set(i, peoples.get(j));
            peoples.set(j, tempVar);
        }
        System.out.println(peoples);
    }

    public static String findTphone(HashMap<String, String> telephoneList, String name) {
        if (telephoneList.containsKey(name)) {
            return name + " Телефоны: " + telephoneList.get(name);
        } else {
            return "Не нашлось";
        }
    }

    public static void Task3() {
        int[] arr = {342, 543534, 5345, 123};
        heapsort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static boolean isNoDamage(char[][] mat, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 'Ф') {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 'Ф') {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 'Ф') {
                return false;
            }
        }
        return true;
    }



    private static void Ferses(char[][] tab, int r) {
        if (r == tab.length) {
            for (char[] chars : tab) {
                System.out.println(Arrays.toString(chars));
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < tab.length; i++) {
            if (isNoDamage(tab, r, i)) {
                tab[r][i] = 'Ф';
                Ferses(tab, r + 1);
                tab[r][i] = '–';
            }
        }
    }

    public static void Task4() {
        int N = 8;
        char[][] tab = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(tab[i], '0');
        }
        Ferses(tab, 0);
    }

    public static void heapsort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapsoft(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapsoft(arr, i, 0);
        }
    }

    public static void heapsoft(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapsoft(arr, n, largest);
        }
    }


}
