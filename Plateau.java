public class Plateau {

    protected char[][] plateau = {  {' ', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' '},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                    {'|', '_', '_', '_', '_', '_', '_', '_', '_', '_', '|'}};

    protected char brique_detruite;
    protected char create_brique;
    protected char rebond;
    protected int deplacement;
    protected int deplacement_balle;
    protected int x;
    protected int vie;

    Balle balle; // association
    Barre barre; // association

    protected char move_barre;

    public Plateau() {
        System.out.println("nothing");
    }

    public Plateau(Barre barre, Balle balle, int deplacement_balle, char brique_detruite, char rebond, char move_barre, char create_brique, int vie) {
        this.create_brique = create_brique;
        this.move_barre = move_barre;
        this.barre = barre;
        this.balle = balle;
        this.deplacement_balle = deplacement_balle;
        this.brique_detruite = brique_detruite;
        this.rebond = rebond;
        this.vie = vie;
    }


    public void build() {

        plateau[1][4] = create_brique;
        plateau[1][5] = create_brique;
        plateau[1][6] = create_brique;
        plateau[2][4] = create_brique;
        plateau[2][5] = create_brique;
        plateau[2][6] = create_brique;
    }

    public void efface_ligne_precedente(int efface,int efface_barre) {
        for (int k = 10; k >= 0; k--) {
            if (plateau[efface][(k)] == '*') {
                plateau[efface][(k)] = ' ';
                if (plateau[efface][0] == ' ') { plateau[efface][0] = '|'; }
                else if (plateau[efface][10] == ' ') { plateau[efface][10] = '|'; }
                else if (plateau[0][k] == ' ') { plateau[0][k] = '_'; }

            }
            else if (plateau[8][k] == '_') {
                efface_barre = barre.position_y;
                if (efface_barre < barre.position_precedente_barre) { barre.Se_Deplacer_A_Droite(8,efface_barre,plateau); }
                else {barre.Se_Deplacer_A_Gauche(8,efface_barre,plateau);}
            }
        }
    }

    public int rebond_balle(int position_x,int position_y,int rebond,int rebond2,Plateau plateau)
    {
        if (plateau.plateau[8][barre.position_y] == '*')
        {
            deplacement = rebond;
        }
        else if (plateau.plateau[8][barre.position_y - 1] == '*')
        {
            deplacement = rebond2;
        }
        /*
        else if (plateau[8][barre.position_y + 1] == '*')
        {
            deplacement = rebond2;
        }*/
        return deplacement;
    }

    public int rejouer(int vie)
    {
        if(plateau[9][1] == '*' || plateau[9][2] == '*' || plateau[9][3] == '*' || plateau[9][4] == '*' || plateau[9][5] == '*' || plateau[9][6] == '*' || plateau[9][7] == '*' || plateau[9][8] == '*' )
        {
            vie -= 1;
            System.out.println("tu as perdue une vie et il te reste " + vie);
        }
        return vie;
    }
}
