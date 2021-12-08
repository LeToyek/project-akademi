import java.util.Scanner;


public class akademi {
    static Scanner in;
    static String [] nama;
    static String [] nim;
    static String [] matkul;
    static int [][] nilai;
    static int n,k,jumlahMatkul;
    public static void main(String[] args) {
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
                dataMahasiswa();
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
        for (int a = 0; a < k;a++){
            System.out.print(matkul[a]+"\t");
        }
        System.out.println("");
        for (int i = 0; i< n;i++){
            for (int j = 0; j<k;j++){
                System.out.print(nilai[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    static void cetakKHS() {
    }
    static void kelolaNilai() {
    }
    static void mataKuliah() {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Mata Kuliah: ");
        jumlahMatkul = in.nextInt();
        in.nextLine();
        matkul = new String[n];
        System.out.println("Mata Kuliah");
        for (int i = 0; i < matkul.length ; i++){
            System.out.print(i+1+" ");
            matkul[i] = in.nextLine();
        }
        return matkul;
    }
    static String[] dataMahasiswa() {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        n = in.nextInt();
        in.nextLine();
        nama = new String[n];
        nim = new String[n];
        System.out.println("Masukkan Data Mahasiswa");
        for (int i = 0; i < nama.length ; i++){
            System.out.print(i+1+" Nama\t:");
            nama[i] = in.nextLine();
            System.out.print("  NIM\t:");
            nim[i] = in.nextLine();
        }
        return nama;
    }
}
