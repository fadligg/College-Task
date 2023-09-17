import java.util.Scanner;
//updated on 17-9-2023

class Bokobo_upd1point1 { 
    public static final String warna_RESET = "\u001B[0m";
    public static final String warna_GREEN = "\u001B[32m";
    public static final String warna_BLUE = "\u001B[34m";
    public static final String warna_RED = "\u001B[31m";
    public static void main(String[] args) {
        boolean boko = true;
        while (boko){
            //ini buat tampilan awal
            String border = "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
            String penyambutanSatu = border;
            penyambutanSatu += warna_GREEN +"\nSelamat datang di Todibo (Toko Merchandise Kobo)" +warna_RESET;
            penyambutanSatu += "\n" + border;
            penyambutanSatu += "\nSilakan mau membeli merchandise apa?";
            penyambutanSatu += "\n1. Poster Kobo Kanaeru";
            penyambutanSatu += "\n2. Gantungan kunci Kobo Kanaeru";
            penyambutanSatu += "\n3. Lanyard Kobo Kanaeru";
            penyambutanSatu += "\n4. T-shirt Kobo Kanaeru";
            penyambutanSatu += "\n0. Sudah cukup belanjanya, ehe~~";
            penyambutanSatu += ("\n" + border);
            //ini deklarasi dan mekanismenya
            String kobo1 = "Poster Kobo Kanaeru!";
            String kobo2 = "Gantungan Kunci Kobo Kanaeru!";
            String kobo3 = "Lanyard Kobo Kanaeru!";
            String kobo4 = "T-shirt Kobo Kanaeru!";
            System.out.println(penyambutanSatu);
            Scanner input = new Scanner(System.in);
                int beli = input.nextInt();
            if (beli == 1) {
                System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo1 + warna_RESET);
            }
            if (beli == 2){
                System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo2 + warna_RESET);
            }
             if (beli == 3){
                System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo3 + warna_RESET);
            }
             if (beli == 4){
                System.out.println(border + warna_BLUE + "\nTerima kasih sudah beli " + kobo4 + warna_RESET);
            }
            if (beli == 0){
                System.out.println(border + warna_BLUE + "\nTerima kasih sudah mengunjungi Todibo" + warna_RESET + "\n" + border);
             }
             switch (beli){
                case 1 :
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 0:
                boko = false;
                break;
                default:
                System.out.println(warna_RED + "Coba pilih lagi dengan angka yang tertera yaa" + warna_RESET);
        
             }
           
            
            }
        }
        
     }
            

        




