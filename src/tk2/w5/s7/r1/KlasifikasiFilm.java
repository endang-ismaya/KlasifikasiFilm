package tk2.w5.s7.r1;

import java.util.Calendar;
import java.util.Scanner;

public class KlasifikasiFilm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            try {
                // Asking for a name
                System.out.print("Masukan Nama Anda =  ");
                String name = input.next();

                // Asking for age
                // Make sure user enter the correct year
                int age = GetAge();

                // Print result
                String result = GetClassification(name, age);
                System.out.println(result);

                // Ask to play again?
                System.out.println("\n\nApa anda ingin memasukkan nama lain? [Ya/Tidak]");
                String answer = input.next();

                if (!answer.equalsIgnoreCase("Ya")) {
                    break;
                }
                System.out.println();

            } catch (Exception e) {
                System.out.println("Kesalahan pada input, silahkan coba lagi lain waktu. ");
                break;
            }
        }
    }

    private static int GetAge() {
        // Get Current Year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Scanner input = new Scanner(System.in);
        int age;

        System.out.print("Masukan Tahun Lahir Anda =  ");
        while (true) {
            try {
                int yearOfBirth = input.nextInt();

                age = currentYear - yearOfBirth;
                if (age >= 0)
                    break;

                System.out.println("Tahun kelahiran melebihi tahun saat ini\n");
                System.out.print("Masukan Tahun Lahir Anda =  ");

            } catch (Exception e) {
                System.out.print("Masukan Tahun Lahir Anda =  ");
                input = new Scanner(System.in);
            }
        }

        return age;
    }

    private static String GetClassification(String name, int age) {

        String nickName = GetPrintOutName(name);

        if (age >= 21)
            return nickName + ", Anda berusia " + age + " tahun, dapat menonton film dengan klasifikasi SU, 13+, 17+, dan 21+.";

        if (age >= 17)
            return nickName + ", Anda berusia " + age + " tahun, dapat menonton film dengan klasifikasi SU, 13+, dan 17+.";

        if (age >= 13)
            return nickName + ", Anda berusia " + age + " tahun, dapat menonton film dengan klasifikasi SU dan 13+.";

        return "Adik " + nickName + ", Anda berusia " + age + " tahun, dapat menonton film dengan klasifikasi SU.";

    }

    private static String GetPrintOutName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
