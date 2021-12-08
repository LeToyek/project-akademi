import java.util.Scanner;


public class akademi {
    static Scanner in;
    static String [] namaMahasiswa;
    static String [] matkul;
    static int [][] nilai;
    static int n,k;
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
    }
    static String[] dataMahasiswa() {
        System.out.println("Masukkan banyaknya siswa");
        n = in.nextInt();
        in.nextLine();
        namaMahasiswa = new String[n];
        System.out.println("Masukkan nama mahasiswa");
        for (int i = 0; i< namaMahasiswa.length;i++){
            System.out.print(i+1+" ");
            namaMahasiswa[i] = in.nextLine();
        }
        return namaMahasiswa;
    }
}
