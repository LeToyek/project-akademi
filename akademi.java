import java.util.Scanner;


public class akademi {
    static Scanner in;
    static int [] arr;
    static int n;
    public static void main(String[] args) {
        arr = new int[n];
        in = new Scanner(System.in);
        int pilihan = 0;
        while (pilihan != 7){
            System.out.println("Silahkan pilih menu :" 
            + "\n1. Data Mahasiswa"
            + "\n2. Mata kuliah"
            + "\n3. Input dan kelola nilai"
            + "\n4. Cetak KHS/Rapor Nilai"
            + "\n5. Nilai per mata kuliah"
            + "\n6. Peringkat Mahasiswa"
            + "\n7. Keluar");
            pilihan = in.nextInt();
            switch(pilihan){
                case 1:
                break;
                case 2:
                mataKuliah();
                break;
                case 3:
                kelolaNilai();
                break;
                case 4:
                cetakKHS();
                break;
                case 5:
                nilaiPerMatkul();
                break;
                case 6:
                peringkatMhs();
                break;
                case 7:
                break;
                default:
                System.out.println(
                    "pilihan anda tidak terdapat dalam menu"
                );

            }
        }
    }
    static void peringkatMhs() {
    }
    static void nilaiPerMatkul() {
    }
    static void cetakKHS() {
    }
    static void kelolaNilai() {
    }
    static void mataKuliah() {
    }
    static void dataMahasiswa() {
    }
}
