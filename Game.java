public class Game {

    public static void main(String[] args)
    {
            int etat = 0;
            etat =machine_etat(0);
            etat = machine_etat(etat);
            machine_etat(etat); // = 2

    }

    static boolean GameWin(char [][] plateau, int state)
    {              // fin du jeu
        if(        plateau[1][4] == ' '
                && plateau[1][5] == ' '
                && plateau[1][6] == ' '
                && plateau[2][4] == ' '
                && plateau[2][5] == ' '
                && plateau[2][6] == ' ')
        {
            System.out.println("You are won ");
            state = 2;
            return true;
        }
        else
        {
            System.out.println("Il te reste des briques a casser");
            if(state == 3)
            {
                System.out.println("Tu n'as plus de vie");
                return true;
            }
            return false;
        }

    }

    static void affiche(char[][] affichage)
    {
        for(int i = 0; i < 10 ; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                // affiche le plateau
                System.out.print(affichage[i][j]);
            }
            System.out.println(" ");
        }
        System.out.flush();
    }

    static int jouer(Plateau plateau) {
        double vitesse = 0.5;
        int efface = 0;
        int deplacement = 3;
        int cmpt = 0;
        int deplace_barre;
        int efface_barre = 0;
        int nbEtat = 0;
        int Etat = 0;

        char[][] affichage =    {{' ', '_', '_', '_', '_', '_', '_', '_', '_', '_', ' '},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                                {'|', '_', '_', '_', '_', '_', '_', '_', '_', '_', '|'}};

        plateau.build(); // place les briques dans le plateau

        while(!GameWin(plateau.plateau, Etat)) {
            if (deplacement == 24)
            {
                System.out.println("dans deplacement 24");
                plateau.plateau[3][10] = '|';
                affiche(plateau.plateau);
                plateau.plateau[2][10] = '*';
                affiche(plateau.plateau);
                plateau.plateau[2][10] = '|';
                plateau.plateau[1][9] = '*';
                affiche(plateau.plateau);
                plateau.plateau[1][9] = ' ';
                plateau.plateau[0][8] = '*';
                affiche(plateau.plateau);
                plateau.plateau[0][8] = ' ';
                plateau.balle.deplacement_a_droit = 7;
                for (int i = 1; i < 3; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre
                    plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;

                    if (plateau.plateau[2][6] == '*') {
                        plateau.plateau[2][6] = ' ';
                        Etat  = 2; }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit--;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 17)
            {
                System.out.println("dans deplacement 17");
                plateau.plateau[3][0] = '|';
                affiche(plateau.plateau);
                plateau.plateau[2][0] = '*';
                affiche(plateau.plateau);
                plateau.plateau[2][0] = '|';
                plateau.plateau[1][1] = '*';
                affiche(plateau.plateau);
                plateau.plateau[1][1] = ' ';
                plateau.plateau[0][2] = '*';
                affiche(plateau.plateau);
                plateau.plateau[0][2] = ' ';
                plateau.balle.deplacement_a_droit = 3;
                for (int i = 1; i < 3; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre
                    plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;

                    if (plateau.plateau[2][4] == '*') {
                        plateau.plateau[2][4] = ' ';
                        Etat  = 2; }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit++;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 23)
            {
                System.out.println("dans deplacement 23");
                //diagonal
                plateau.balle.deplacement_diagonal_droite = 5;
                for (int i = 7; i > 2; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}


                    plateau.plateau[i][plateau.balle.deplacement_diagonal_droite] = plateau.balle.forme_balle;
                    if (plateau.plateau[3][9] == '*')
                        {
                            plateau.plateau[3][9] = plateau.brique_detruite;
                            deplacement = 24;
                        }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_diagonal_droite++;
                    affiche(plateau.plateau);
                }
            }

            if (deplacement == 16)
            {
                System.out.println("dans deplacement 16");
                //diagonal
                plateau.balle.deplacement_diagonal = 4;
                for (int i = 7; i > 2; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    if (plateau.plateau[i][plateau.balle.deplacement_diagonal] != '*') {
                        plateau.plateau[i][plateau.balle.deplacement_diagonal] = plateau.balle.forme_balle;
                        if (plateau.plateau[3][0] == '*')
                        {
                            plateau.plateau[3][0] = plateau.balle.forme_balle;
                            deplacement = 17;
                        }
                    }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_diagonal--;
                    affiche(plateau.plateau);
                }
            }

            if (deplacement == 22) {
                System.out.println("dans deplacement 22");
                for (int i = 2; i < 9; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][4] = plateau.balle.forme_balle;
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    if (plateau.plateau[i][plateau.barre.position_y + 1] == plateau.balle.forme_balle)
                    {
                        deplacement = 23;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }
            }

            if (deplacement == 15) {
                System.out.println("dans deplacement 15");
                for (int i = 2; i < 9; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][6] = plateau.balle.forme_balle;
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    if (plateau.plateau[i][plateau.barre.position_y - 1] == '*')
                    {
                        deplacement = 16;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }
            }
            if (deplacement == 21) {
                System.out.println("dans deplacement 21");
                for (int i = 8; i > 0; i--) {
                    if (efface == i + 1) {
                        plateau.efface_ligne_precedente(efface, efface_barre);
                    }

                    plateau.plateau[i][4] = plateau.balle.forme_balle;
                    deplacement = plateau.rebond_balle(8, plateau.barre.position_y, 4, 5,plateau);
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0, plateau.barre.position_y);
                    if (plateau.plateau[1][4] == '*')
                    {
                        plateau.plateau[1][4] = plateau.brique_detruite;
                        deplacement = 22;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }
            }

            if (deplacement == 14) {
                System.out.println("dans deplacement 14");
                for (int i = 8; i > 0; i--) {
                    if (efface == i + 1) {
                        plateau.efface_ligne_precedente(efface, efface_barre);
                    }

                    plateau.plateau[i][6] = plateau.balle.forme_balle;
                    deplacement = plateau.rebond_balle(8, plateau.barre.position_y, 4, 5,plateau);
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0, plateau.barre.position_y);
                    if (plateau.plateau[1][6] == '*')
                    {
                        plateau.plateau[1][6] = plateau.brique_detruite;
                        deplacement = 15;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }
            }
            if (deplacement == 20) {
                System.out.println("dans deplacement 20");
                for (int i = 3; i < 9; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][4] = plateau.balle.forme_balle;
                    deplacement = plateau.rebond_balle(8,plateau.barre.position_y,4,5,plateau);
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    if (plateau.plateau[i][4] == '*')
                    {
                        deplacement = 21;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }

            }
            if (deplacement == 13) {
                System.out.println("dans deplacement 13");
                for (int i = 3; i < 9; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][6] = plateau.balle.forme_balle;
                    deplacement = plateau.rebond_balle(8,plateau.barre.position_y,4,5,plateau);
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    if (plateau.plateau[i][6] == '*')
                    {
                        deplacement = 14;
                    }
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    GameWin(plateau.plateau, Etat);
                }

            }
            if (deplacement == 19)
            {
                System.out.println("dans deplacement 19");

                for (int i = 8; i > 1; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}
                    plateau.plateau[i][4] = plateau.balle.forme_balle;
                    if (plateau.plateau[2][4] == '*')
                    {
                        plateau.plateau[2][4] = plateau.brique_detruite;
                        deplacement = 20;
                    }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 12)
            {
                System.out.println("dans deplacement 12");

                for (int i = 8; i > 1; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}
                        plateau.plateau[i][6] = plateau.balle.forme_balle;
                        if (plateau.plateau[2][6] == '*')
                        {
                            plateau.plateau[2][6] = plateau.brique_detruite;
                            deplacement = 13;
                        }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 18)
            {
                System.out.println("dans deplacement 18");
                plateau.plateau[2][10] = '|';
                plateau.balle.deplacement_a_gauche = 10;
                for (int i = 2; i < 10; i++) {
                    if (efface == i - 1) {
                        plateau.efface_ligne_precedente(efface, efface_barre);
                    } // efface la position precedente de la balle et de la barre

                    if (i < 9){
                        plateau.plateau[i][plateau.balle.deplacement_a_gauche] = plateau.balle.forme_balle;
                        System.out.println("plateau posy = " + plateau.barre.position_y);
                        if (plateau.barre.position_y < 3 || plateau.barre.position_y > 6) {
                            plateau.plateau[9][3] = '*';
                            System.out.println("barre pas touchee " + plateau.barre.position_y);
                            plateau.rejouer(plateau.vie);
                        }
                    }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    deplacement = plateau.rebond_balle(8,plateau.barre.position_y,19,5,plateau);
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_gauche--;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 11)
            {
                System.out.println("dans deplacement 11");

                plateau.balle.deplacement_a_droit = 0;
                for (int i = 2; i < 10; i++) {
                    if (efface == i - 1) {
                        plateau.efface_ligne_precedente(efface, efface_barre);
                    } // efface la position precedente de la balle et de la barre

                    if (i < 9){
                        plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;
                        System.out.println("plateau posy = " + plateau.barre.position_y);
                        if (plateau.barre.position_y < 6 || plateau.barre.position_y > 8) {
                            plateau.plateau[9][7] = '*';
                            System.out.println("barre pas touchee " + plateau.barre.position_y);
                            plateau.rejouer(plateau.vie);
                        }
                }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    deplacement = plateau.rebond_balle(8,plateau.barre.position_y,12,5,plateau);
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit++;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 1)
            {
                System.out.println("dans deplacement 1");
                plateau.plateau[0][7] = '*';
                affiche(plateau.plateau);
                plateau.plateau[0][7] = '_';
                plateau.balle.deplacement_a_droit = 8;
                for (int i = 1; i < 3; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre
                    plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;

                    if (plateau.plateau[2][9] == '*') {
                        plateau.plateau[2][9] = ' ';
                        deplacement = 18; }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit++;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 10)
            {
                System.out.println("dans deplacement 10");
                plateau.plateau[0][3] = '*';
                affiche(plateau.plateau);
                plateau.plateau[0][3] = plateau.brique_detruite;
                plateau.balle.deplacement_a_droit = 2;
                for (int i = 1; i < 3; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre
                    plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;

                    if (plateau.plateau[2][1] == '*') {
                        plateau.plateau[2][1] = ' ';
                        deplacement = 11; }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit--;
                    plateau.plateau[0][3] = '_';
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 9)
            {
                System.out.println("dans deplacement 9");
                //diagonal
                for (int i = 4; i > 0; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre

                    plateau.plateau[i][plateau.balle.deplacement_a_droit] = plateau.balle.forme_balle;
                    if (plateau.plateau[1][4] == '*')
                        {
                            plateau.plateau[1][4] = plateau.brique_detruite;
                            deplacement = 10;
                        }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_a_droit++;
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 8)
            {
                System.out.println("dans deplacement 8");
                //diagonal
                for (int i = 4; i > 0; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la position precedente de la balle et de la barre

                    plateau.plateau[i][plateau.balle.deplacement_diagonal_gauche] = plateau.balle.deplacement(i,plateau.balle.deplacement_diagonal_gauche,'*');
                    if (plateau.plateau[1][6] == '*')
                    {
                        plateau.plateau[1][6] = plateau.brique_detruite;
                        deplacement = 1;
                    }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_diagonal_gauche--;
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 6)
            {
                System.out.println("dans deplacement 6");
                //diagonal
                for (int i = 7; i > 3; i--) {

                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);} // efface la ligne precedente

                        plateau.plateau[i][plateau.balle.deplacement_diagonal_droite] = plateau.balle.forme_balle;
                        if (plateau.plateau[4][9] == '*')
                        {

                            plateau.plateau[4][9] = plateau.balle.forme_balle;
                            deplacement = 8;
                        }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_diagonal_droite++;
                    affiche(plateau.plateau);
                }
            }
            if (deplacement == 5)
            {
                System.out.println("dans deplacement 5");
                //diagonal
                for (int i = 7; i > 3; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    if (plateau.plateau[i][plateau.balle.deplacement_diagonal] != '*') {
                        plateau.plateau[i][plateau.balle.deplacement_diagonal] = plateau.balle.forme_balle;
                        if (plateau.plateau[4][1] == '*')
                        {
                            plateau.plateau[4][1] = plateau.brique_detruite;
                            deplacement = 9;
                        }
                    }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    plateau.balle.deplacement_diagonal--;
                    affiche(plateau.plateau);
                }
            }

            if (deplacement == 4) {
                System.out.println("dans deplacement 4");
                for (int i = 3; i < 9; i++) {
                    if (efface == i - 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    if (plateau.plateau[i][5] != '*') {
                        plateau.plateau[i][5] = plateau.balle.forme_balle;
                        if (plateau.plateau[8][plateau.barre.position_y] == '*')
                        {
                            plateau.plateau[8][plateau.barre.position_y] = plateau.brique_detruite;
                            deplacement = 7;
                        }

                        else if (plateau.plateau[8][plateau.barre.position_y-1] == '*')
                        {
                            deplacement = 5;
                        }

                        else if (plateau.plateau[8][plateau.barre.position_y+1] == '*')
                        {
                            deplacement = 6;
                        }
                    }
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);
                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                }
            }

            if(deplacement == 3) //DEBUT DU JEU
            {
            System.out.println("dans deplacement 3");
            for (int i = 5; i < 10; i++) {
                if (efface == i - 1) {
                    plateau.efface_ligne_precedente(efface, efface_barre);
                }
                plateau.barre.position_precedente_barre = plateau.barre.position_y;
                plateau.barre.position_y = plateau.barre.deplacement_barre(0, plateau.barre.position_y);
                plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2]; // extremite droite
                plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1]; // milieu de la barre
                plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0]; // extremite gauche

                if (i < 9){
                    plateau.plateau[i][5] = plateau.balle.deplacement(i, 5, '*');

                        if (i == 8) {
                            // si la balle ne touche pas la barre on perd une vie
                            if (plateau.barre.position_y < 4 || plateau.barre.position_y > 6)
                            {
                                plateau.plateau[8][5] = plateau.brique_detruite;
                                plateau.plateau[9][5] = plateau.balle.deplacement(i, 5, '*');
                                System.out.println("barre pas touchee " + plateau.barre.position_y);
                                plateau.vie = plateau.rejouer(plateau.vie);
                                if(plateau.vie == 0){Etat = 3;}

                            }
                        }
                    }

                if (plateau.plateau[8][plateau.barre.position_y] == '*') // si la balle rebondit au milieu deplacement vers le nord (haut)
                {
                    deplacement = 2;
                }
                else if (plateau.plateau[8][plateau.barre.position_y - 1] == '*') // si la balle rebondit vers l'extremite gauche direction nord ouest
                {
                    deplacement = 5;
                }
                else if (plateau.plateau[8][plateau.barre.position_y + 1] == '*') // si la balle rebondit vers l'extremite gauche direction nord ouest
                {
                    deplacement = 6;
                }
                //
                efface = i; // efface la ligne precedente
                affiche(plateau.plateau); // affiche le plateau
            }
            }

            if (deplacement == 2) {
                System.out.println("dans deplacement 2");
                for (int i = 8; i > 2; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][5] = plateau.balle.forme_balle;
                    deplacement = plateau.rebond_balle(8,plateau.barre.position_y,4,5,plateau);
                    if(i == 3){plateau.plateau[2][5] = plateau.brique_detruite;}
                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    plateau.plateau[3][5] = ' ';
                }
            }

            if (deplacement == 7) {
                System.out.println("deplacement 7");
                for (int i = 8; i > 0; i--) {
                    if (efface == i + 1) {plateau.efface_ligne_precedente(efface,efface_barre);}

                    plateau.plateau[i][5] = plateau.balle.forme_balle;
                    if (plateau.plateau[1][5] == '*')
                    {
                        plateau.plateau[1][5] = plateau.brique_detruite;
                        deplacement = 4;
                    }

                    else if (plateau.plateau[8][plateau.barre.position_y - 1] == '*')
                    {
                        deplacement = 5;
                    }

                    plateau.barre.position_precedente_barre = plateau.barre.position_y;
                    plateau.barre.position_y = plateau.barre.deplacement_barre(0,plateau.barre.position_y);

                    plateau.plateau[8][plateau.barre.position_y + 1] = plateau.barre.forme_barre[2];
                    plateau.plateau[8][plateau.barre.position_y] = plateau.barre.forme_barre[1];
                    plateau.plateau[8][plateau.barre.position_y - 1] = plateau.barre.forme_barre[0];
                    efface = i;
                    affiche(plateau.plateau);
                    System.out.flush();
                }
            }
            nbEtat++;
        }

        affiche(plateau.plateau);

        return Etat;
    }

    static int machine_etat(int state)
    {
        char [][] plateau = new char[10][11];
        Balle balle = new Balle('*',5,5,plateau);
        Barre barre = new Barre(5);
        Plateau environnement = new Plateau(barre, balle,1,' ', '|','z','0',3);

        switch(state)
        {
            case 0:
               System.out.println("COMMENCER");
               System.out.println("POUR SE DEPLACER A GAUCHE SAISIR 1");
               System.out.println("POUR SE DEPLACER A DROITE SAISIR 2");
               System.out.println("POUR NE PAS BOUGER SAISIR 3");
               System.out.println("VOUS AVEZ 3 VIES");
               state = 1;
            break;

            case 1:
                state = jouer(environnement);

            break;

            case 2:
                System.out.println("Jeu fini");
                break;
        }
        return  state;
    }
}
