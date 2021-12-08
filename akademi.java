import java.util.Scanner;


public class akademi {
    static Scanner in;
    static String [] nama;
    static String [] nim;
    static String [] matkul;
    static int [][] nilai;
    static int jumlahMhs,jumlahMatkul;
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
        double []ipk = new double[jumlahMhs];
        double temp = 0;
        String tempNim = "";
        String tempNama = "";
        double tampungNilai = 0;
        double tampungNilaiAVG = 0;
        for (int i = 0;i <jumlahMhs;i++){
            for (int j = 0;j<jumlahMatkul;j++){
                tampungNilai += nilai[i][j];
            }
            tampungNilaiAVG = tampungNilai/jumlahMatkul;
            ipk[i] = tampungNilaiAVG;
            tampungNilai = 0;
        }
        for (int i = 0; i<jumlahMhs;i++){
            for (int j = 1; j< (jumlahMatkul-i); j++){
                if (ipk[j-1] < ipk[j]){
                    temp = ipk[j-1];
                    ipk[j-1] = ipk[j];
                    ipk[j] = temp;
                    tempNama = nama[j-1];
                    nama[j-1] = nama[j];
                    nama[j] = tempNama;
                    tempNim = nim[j-1];
                    nim[j-1] = nim[j];
                    nim[j] = tempNim;
                }
            }
        }
        System.out.println("Daftar peringkat mahasiswa\t:");
        for (int i = 0; i<jumlahMhs;i++){
            System.out.println("No" + "Nama" + "\t" + "NIM" + "\t" + "Nilai");
            System.out.println(i+1 + " "+ nama[i] + "\t" + nim[i] + "\t" + ipk[i]);
        }
    }
    static void nilaiPerMatkul() {
        
    }
    static void cetakKHS() {
    }
    static void kelolaNilai() {
    }
    static void mataKuliah() {
        System.out.print("Masukkan Jumlah Mata Kuliah: ");
        jumlahMatkul = in.nextInt();
        in.nextLine();
        matkul = new String[jumlahMatkul];
        System.out.println("Nama Mata Kuliah");
        for (int i = 0; i < jumlahMatkul; i++){
            System.out.print(i+1+" ");
            matkul[i] = in.nextLine();
        }
    }
    static void dataMahasiswa() {
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        jumlahMhs = in.nextInt();
        in.nextLine();
        nama = new String[jumlahMhs];
        nim = new String[jumlahMhs];
        System.out.println("Masukkan Data Mahasiswa");
        for (int i = 0; i < nama.length ; i++){
            System.out.print(i+1+" Nama\t:");
            nama[i] = in.nextLine();
            System.out.print("  NIM\t:");
            nim[i] = in.nextLine();
        }
    }
}
