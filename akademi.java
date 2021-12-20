import java.util.Scanner;

public class akademi {
    static Scanner in;
    static String [] nama;
    static String [] nim;
    static String [] matkul;
    static int [][] nilai;
    static double [] nilaiPerMatkul ;
    static int jumlahMhs = 0,jumlahMatkul = 0;
    public static void main(String[] args) {
      System.out.println("==============================");
      System.out.printf("%24s\n", "Penilaian Akademik");
      System.out.println("==============================");
        in = new Scanner(System.in);
        int pilihan = 0;
        while (pilihan != 7){
            System.out.println("\nSilahkan pilih menu :" 
            + "\n1. Data Mahasiswa"
            + "\n2. Mata kuliah"
            + "\n3. Input dan kelola nilai"
            + "\n4. Cetak KHS/Rapor Nilai"
            + "\n5. Nilai per mata kuliah"
            + "\n6. Peringkat Mahasiswa"
            + "\n7. Keluar");
            pilihan = in.nextInt();
            in.nextLine();
            switch(pilihan){
                case 1:
                showMenuDataMahasiswa();
                break;
                case 2:
                showMenuMataKuliah();
                break;
                case 3:
                kelolaNilai();
                break;
                case 4:
                cetakKHS();
                break;
                case 5:
                showNilaiPerMatkul();
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
        if (jumlahMhs !=0 && jumlahMatkul != 0 && nilai != null){
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
                for (int j = 1; j< (jumlahMhs-i); j++){
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
            System.out.println("------------Daftar Peringkat Mahasiswa------------");
            System.out.printf("%-10s| %-15s | %-10s | %-5s |\n","Peringkat","Nama","NIM","Nilai");
            System.out.println("--------------------------------------------------");
            for (int i = 0; i<jumlahMhs;i++){
                System.out.printf("%-10s| %-15s | %-10s | %-5.2f |\n",i+1, nama[i], nim[i], ipk[i]);
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Apakah anda ingin menampilkan mahasiswa yang tidak lulus ? (y/n)");
            String lulus = in.nextLine();
            if (lulus.equalsIgnoreCase("y")) {
              System.out.print("Masukkan nilai minimal untuk lulus\nNilai minimal : ");
              double nilaiMinimal = in.nextDouble();
              System.out.println("Berikut adalah daftar mahasiswa yang tidak lulus");
              System.out.println("-------------------------------------------");
              System.out.printf("%-3s| %-15s | %-10s | %-5s |\n","No ","Nama","NIM","Nilai");
              System.out.println("-------------------------------------------");
              for (int i = 0; i < ipk.length; i++) {
                  if (ipk[i] < nilaiMinimal) {
                    System.out.printf("%-3s| %-15s | %-10s | %-5.2f |\n",ipk.length-i, nama[i], nim[i], ipk[i]);
                  }
              }
              System.out.println("-------------------------------------------");
            }
        }else if (jumlahMatkul == 0){
            System.out.println("tidak ada matkul dalam daftar"
            +"\nharap input matkul terlebih dahulu");
        }else if (jumlahMhs == 0) {
            System.out.println("tidak ada mahasiswa dalam daftar"
                    + "\nharap input mahasiswa terlebih dahulu");
        }else{
            System.out.println("nilai belum diinput"+ "\nharap input nilai terlebih dahulu");
        }
    }
    static void showNilaiPerMatkul() {
        if (jumlahMhs !=0 && jumlahMatkul != 0 && nilai != null){
            nilaiPerMatkul = new double[jumlahMatkul];
            double tampungNilaiPerMatkul = 0;
            double avgTampungNilai = 0;  
            for(int i = 0; i < jumlahMatkul; i++){
                for(int j = 0; j< jumlahMhs;j++){
                    tampungNilaiPerMatkul += nilai[j][i];
                }
                avgTampungNilai = tampungNilaiPerMatkul/jumlahMhs;
                nilaiPerMatkul [i] = avgTampungNilai;
                tampungNilaiPerMatkul = 0;
            }
            System.out.println("------------Nilai Per Matkul------------");
            System.out.printf("%-30s | %-5s |\n","Mata Kuliah","Nilai");
            System.out.println("----------------------------------------");
            for (int i = 0; i<jumlahMatkul;i++){
                System.out.printf("%-30s | %-5.2f |\n",matkul[i],nilaiPerMatkul[i]);
            }
            System.out.println("----------------------------------------");
        }else if (jumlahMatkul == 0){
            System.out.println("tidak ada matkul dalam daftar"
                    +"\nharap input matkul terlebih dahulu");
        }else if (jumlahMhs == 0) {
            System.out.println("tidak ada mahasiswa dalam daftar"
                    + "\nharap input matkul terlebih dahulu");
        }else{
            System.out.println("nilai belum diinput"+ "\nharap input nilai terlebih dahulu");
        }
    }
    static void cetakKHS() {
      if(nilai != null && jumlahMatkul != 0 && jumlahMhs != 0 ){
        int pilihan = 0;
      in = new Scanner(System.in);
      

      while(pilihan != 3){
        System.out.println("");
        System.out.print("1.CETAK KHS \n2.CETAK KHS NIM \n3.Kembali ");
        System.out.print("\nMasukkan Nomor : ");
        pilihan = in.nextInt();
        in.nextLine();
        switch(pilihan){
          case 1:
          tampilNilai();
          break;
          case 2:
          tampilNim();
          break;
        }
      }
      }else if (jumlahMatkul == 0){
        System.out.println("tidak ada matkul dalam daftar"
        +"\nharap input matkul terlebih dahulu");
      }else if (jumlahMhs == 0) {
        System.out.println("tidak ada mahasiswa dalam daftar"
                + "\nharap input mahasiswa terlebih dahulu");
      }else{
        System.out.println("nilai belum diinput"+ "\nharap input nilai terlebih dahulu");
      }
    }
    static void tampilNilai(){
      additionalLine();
      System.out.printf("%-3s| %-15s | %-10s | ","No","Nama","NIM");
      for (int i = 0; i < matkul.length; i++) {
        System.out.printf("%.3s | ", matkul[i]);
      }
      System.out.println("");
      additionalLine();
      
      
      for(int i = 0; i < nama.length; i++){
        System.out.printf("%-3d| %-15s | %-10s | ",(i+1), nama[i], nim[i]);
        for(int j = 0; j < matkul.length; j++){
          System.out.printf("%-3d | ", nilai[i][j]);
        }
        System.out.println("");
      }
      additionalLine();
    }
    static void tampilNim(){
      System.out.print("Masukkan NIM : ");
      String inputNIM = in.nextLine();
      int a = 0;
      boolean status = false;
      for(int i = 0; i < nim.length; i++){
        if(inputNIM.equals(nim[i])){
          status = true;
          a = i;
        }
      }

      if(status == true){
        System.out.printf("Nama : %s\n", nama[a]);
        System.out.printf("NIM : %s\n", nim[a]);
        for(int i = 0; i < matkul.length; i++){
          System.out.printf("Nilai Matkul %s = %d\n", matkul[i], nilai[a][i]);
        }
      } else {
        System.out.println("NIM Tidak Ditemukan");
      }
    }
    static void kelolaNilai() {
      if(jumlahMhs != 0 && jumlahMhs != 0){
        if(nilai == null){
          nilai = new int [jumlahMhs][jumlahMatkul];
          kelolaNilai();
        }
        else{
          int pilihan = 0;
          in = new Scanner(System.in);
          while(pilihan != 3){
            System.out.println("");
            System.out.print("1.Input Nilai \n2.Edit Nilai \n3.Kembali ");
            System.out.print("\nMasukkan Nomor : ");
            pilihan = in.nextInt();
            in.nextLine();
            switch(pilihan){
              case 1:
              inputNilai();
              break;
              case 2:
              editNilai();
              break;
            }
          } 
        }

        
      }else if (jumlahMatkul == 0){
        System.out.println("tidak ada matkul dalam daftar"
        +"\nharap input matkul terlebih dahulu");
      }else{
        System.out.println("tidak ada mahasiswa dalam daftar"
                + "\nharap input mahasiswa terlebih dahulu");
      }
      
    }
    static void inputNilai(){
      for(int j = 0; j < nama.length; j++){
        System.out.printf("Nama : %s \nNIM : %s \n", nama[j], nim[j]);
        for(int n = 0; n < matkul.length; n++){
          System.out.printf("Masukkan nilai %s : ", matkul[n]);
          nilai[j][n] = in.nextInt();
          in.nextLine();
        }
          System.out.println("");
        }
    }
    static void editNilai(){
      int inputMatkul, j=0;
      String inputNim;
      boolean status = false;
      System.out.print("Masukkan NIM : ");
      inputNim = in.nextLine();

      for(int i = 0; i < nim.length; i++){
        if(inputNim.equals(nim[i])){
            status = true;
            j = i;
        }
      }

      if(status == true){
        System.out.println("DAFTAR MATKUL");
        for(int i = 0; i < matkul.length; i++){
            System.out.printf("%d. %s\n", i+1, matkul[i]);
        }
        System.out.print("Pilih Matkul : ");
        inputMatkul = in.nextInt();

        int h = inputMatkul - 1;
        System.out.printf("Masukkan Nilai Matkul %s :", matkul[h]);
        nilai[j][h] = in.nextInt();
        in.nextLine();
      } else {
        System.out.println("NIM Tidak Ditemukan");
      }
    }

    static void showMenuMataKuliah() {
        int choice = 0;
        while(choice != 3){
            System.out.println("\nSilahkan pilih menu"
            +"\n1. input mata kuliah"
            +"\n2. tampilkan mata kuliah"
            +"\n3. kembali");
            choice = in.nextInt();
            in.nextLine();
            switch (choice){
                case 1:
                inputMatkul();
                break;
                case 2:
                showMatkul();
                break;
                case 3:
                break;
                default:
                System.out.println("pilihan anda tidak ada dalam daftar menu");
                break;
            }
        }
    }
    private static void showMatkul() {
        if (jumlahMatkul != 0){
            System.out.printf("No | %-30s|\n","Daftar Matkul");
            System.out.println("------------------------------------");
            for(int i = 0; i<jumlahMatkul;i++){
                System.out.printf((i+1)+"  | %-30s|\n",matkul[i]);
            }
        }else{
            System.out.println("tidak ada mata kuliah dalam daftar");
        }
    }
    private static void inputMatkul() {
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
    static void showMenuDataMahasiswa() {
        int choice = 0;
        while(choice != 3){
            System.out.println("\nSilahkan pilih menu"
            +"\n1. input data mahasiswa"
            +"\n2. tampilkan data mahasiswa"
            +"\n3. kembali");
            choice = in.nextInt();
            in.nextLine();
            switch (choice){
                case 1:
                inputDataMahasiswa();
                break;
                case 2:
                showDataMahasiswa();
                break;
                case 3:
                break;
                default:
                System.out.println("pilihan anda tidak ada dalam daftar menu");
                break;
            }
        }
    }
    private static void showDataMahasiswa() {
        if(jumlahMhs != 0){
            System.out.println("------Data Nama Mahasiswa------");
            System.out.println("===============================");
            System.out.printf("No | %-15s| NIM \n","Nama");
            System.out.println("-------------------------------");
            for(int i = 0; i<jumlahMhs;i++){
                System.out.printf(i+1 + "  | %-15s| %s\n",nama[i],nim[i]);
            }
        }else{
            System.out.println("tidak ada mahasiswa dalam daftar");
        }
    }
    private static void inputDataMahasiswa() {
        // boolean nimSama = false;
        // boolean namaSama = false;
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        jumlahMhs = in.nextInt();
        in.nextLine();
        nama = new String[jumlahMhs];
        nim = new String[jumlahMhs];
        System.out.println("Masukkan Data Mahasiswa");
        for (int i = 0; i < jumlahMhs ; i++){
            System.out.print(i+1+" Nama\t:");
            nama[i] = in.nextLine();
            System.out.print("  NIM\t:");
            nim[i] = in.nextLine();
            //supposed to check apakah ada data yang sama atau tidak
        }
    }
    static void additionalLine(){
      System.out.print("-----------------------------------");
      for (int i = 0; i < matkul.length; i++) {
        System.out.print("------");
      }
      System.out.println("");
    }
}
