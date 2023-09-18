import java.util.Scanner;
//updated on 17-9-2023

class Bokobo_upd1point2 { 
    public static final String warna_RESET = "\u001B[0m";
    public static final String warna_GREEN = "\u001B[32m";
    public static final String warna_BLUE = "\u001B[34m";
    public static final String warna_RED = "\u001B[31m";
    public static void main(String[] args) {
        boolean bokoJalan = true;
        int merchandise1 = 0;
        int merchandise2 = 0;
        int merchandise3 = 0;
        int merchandise4 = 0;
        int keuntungan = 0;

        while (bokoJalan){
            //ini buat tampilan awal
            String border = "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
            String penyambutanSatu = border;
            penyambutanSatu += warna_GREEN +"\nSelamat datang di Todibo (Toko Merchandise Kobo)" +warna_RESET;
            penyambutanSatu += "\n" + border;
            penyambutanSatu += "\nSilakan mau membeli merchandise apa?";
            penyambutanSatu += "\n1. Poster Kobo Kanaeru ($10) - " +  merchandise1 + " barang terjual";
            penyambutanSatu += "\n2. Gantungan kunci Kobo Kanaeru ($5) - " +  merchandise2 + " barang terjual";
            penyambutanSatu += "\n3. Lanyard Kobo Kanaeru ($8) - " +  merchandise3 + " barang terjual" ;
            penyambutanSatu += "\n4. T-shirt Kobo Kanaeru ($20) - " +  merchandise4 + " barang terjual";
            penyambutanSatu += "\n0. Sudah cukup belanjanya, ehe~~";
             penyambutanSatu += "\n\nTotal keuntungan Todibo $" + keuntungan;
            penyambutanSatu += ("\n" + border);
            //ini deklarasi dan mekanismenya
            String kobo1 = "Poster Kobo Kanaeru!";
            String kobo2 = "Gantungan Kunci Kobo Kanaeru!";
            String kobo3 = "Lanyard Kobo Kanaeru!";
            String kobo4 = "T-shirt Kobo Kanaeru!";
            System.out.println(penyambutanSatu);

            Scanner inputPembeli = new Scanner(System.in);
                int nomorMerchandise = inputPembeli.nextInt();
                int qMerchandise;

            if (nomorMerchandise == 1 || nomorMerchandise == 2 || nomorMerchandise == 3 || nomorMerchandise == 4 || nomorMerchandise == 0) {
                System.out.println("Merchandise no. " + nomorMerchandise + " \nMau checkout berapa?");
                qMerchandise = inputPembeli.nextInt();
                System.out.println("Merchandise no. " + nomorMerchandise + "sudah dicheckout " + qMerchandise + "pc(s)" );
                
             switch (nomorMerchandise){
                case 1:
                    merchandise1 += qMerchandise;
                    keuntungan += (qMerchandise*10);
                    System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo1 + warna_RESET);
                break;
                case 2:
                    merchandise2 += qMerchandise;
                    keuntungan += (qMerchandise*5);
                    System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo2 + warna_RESET);
                break;
                case 3:
                    merchandise1 += qMerchandise;
                    keuntungan += (qMerchandise*8);
                    System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo3 + warna_RESET);
                break;
                case 4:
                    merchandise1 += qMerchandise;
                    keuntungan += (qMerchandise*20);
                    System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo4 + warna_RESET);
                break;
                case 0:
                bokoJalan = false;
                break;
                default:
                System.out.println(warna_RED + "Coba pilih lagi dengan angka yang tertera yaa" + warna_RESET);
                }
        
             }
           
            
            }
        }
        
     }
            

        



