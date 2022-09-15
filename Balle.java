public class Balle {
    protected char forme_balle ;
    protected int posisiton_x = 0;
    protected int position_y = 0;
    protected char [][]coordonnees;
    protected int deplacement_diagonal = 4;
    protected int deplacement_diagonal_droite = 6;
    protected int deplacement_a_droit = 1;
    protected int deplacement_diagonal_gauche = 9;
    protected int deplacement_a_gauche = 9;

    public Balle(char forme_balle,int position_x,int position_y, char [][] affichage) {
        this.forme_balle = forme_balle;
        this.position_y = position_y;
        this.posisiton_x = position_x;
        coordonnees = new char [11][10];
        this.coordonnees = affichage;
    }

    public char deplacement(int position_x,int position_y,char forme_balle )
    {
        coordonnees[position_x][position_y] = forme_balle;
        return coordonnees[position_x][position_y];
    }
}
