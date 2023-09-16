import java.util.Scanner;
//updated on 17-9-2023

class Bokobo_upd1 { 
    
    public static void main(String[] args) {
        boolean boko = true;
        while (boko){
            //ini buat tampilan awal
            String border = "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";
            String penyambutanSatu = border;
            penyambutanSatu += "\nSelamat datang di Todibo (Toko Merchandise Kobo)";
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
                System.out.println(border + "\nTerima kasih sudah beli " + kobo1);
            }
            if (beli == 2){
                System.out.println(border + "\nTerima kasih sudah beli " + kobo2);
            }
             if (beli == 3){
                System.out.println(border + "\nTerima kasih sudah beli " + kobo3);
            }
             if (beli == 4){
                System.out.println(border + "\nTerima kasih sudah beli " + kobo4);
            }
            if (beli == 0){
                System.out.println(border + "\nTerima kasih sudah mengunjungi Todibo" + "\n" + border);
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
                System.out.println("Coba pilih lagi dengan angka yang tertera");
        
             }
           
            
            }
        }
        
     }
            

        




