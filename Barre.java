import java.util.Scanner;

public class Barre {

    protected char [] forme_barre = {'_','_','_'};
    protected  int position_x;
    protected int position_y;
    protected int efface_barre;
    protected int position_precedente_barre;
    Balle rebond_balle;
    Plateau affichage;

    public Barre(int position_y) {
        this.position_y = position_y;
        }



    public static int deplacement_barre( int deplace_barre,int position_y) {


                Scanner scanner = new Scanner( System.in );

                deplace_barre = scanner.nextInt();
                if(deplace_barre == 1)
                {
                    position_y--;
                    System.out.println("deplacement droit");
                }

                else if(deplace_barre == 2)                {
                    position_y++;
                    System.out.println("deplacement gauche");
                }

                else
                {
                    position_y = position_y;
                    System.out.println("fixe");
                }

            return position_y;

    }
    public Barre(Balle rebond_balle) {this.rebond_balle = rebond_balle;}



    public static void Se_Deplacer_A_Droite(int position_x, int efface_barre, char [][] affichage)
    {
        efface_barre++;
        affichage[position_x][efface_barre] = ' ';
        efface_barre++;
        affichage[position_x][efface_barre] = ' ';
        efface_barre++;
        affichage[position_x][efface_barre] = ' ';
    }

    public static void Se_Deplacer_A_Gauche(int position_x, int efface_barre, char [][] affichage)
    {
        efface_barre--;
        affichage[position_x][efface_barre] = ' ';
        efface_barre--;
        affichage[position_x][efface_barre] = ' ';
        efface_barre--;
        affichage[position_x][efface_barre] = ' ';
    }
}

