//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] numeros = {"STU-2024-001", "STU-2024-002", "STU-2024-003"};
        String[] noms = {"yasmine zoubi", "basma alyahyaoui", "rim tazi"};
        int[] ages = {21, 21, 23};
        String[] emails = {"yasminezoubi1@gmail.com", "basmaelyahyaoui2@gmail.com", "rim3@gmail.com"};
        String[] promotions = {"3A", "4A", "7A"};
        System.out.println("===LISTE DES ÉTUDIANTS ===\n");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("etudiant" + (i + 1) + ":");
            System.out.println("numero:" + numeros[i]);
            System.out.println("nom complet :" + noms[i]);
            System.out.println("age:" + ages[i]);
            System.out.println("email;" + emails[i]);
            System.out.println("promotion:" + promotions[i]);
        }
        double[][] notes = {
                {15, 12, 11, 13, 16},
                {20, 19, 18, 17, 16},
                {11, 12, 13, 14, 15},
        };

        String[] matieres = {"analyse", "algerbe", "algorithme", "java", "bigdata"};
        System.out.println("bullettin des 3 etudiaants");
        for (int i = 0; i < 3; i++) {
            System.out.println("bullettin de :" + noms[i]);
            double somme = 0;
            for (int j = 0; j < notes[i].length; j++) {
                somme = somme + notes[i][j];
                System.out.println(matieres[j] + ":" + notes[i][j] + "/20");
            }
            double moyenne = somme / notes[i].length;
            System.out.println("moyenne:" + moyenne);
            if (moyenne >= 10) {
                System.out.println("decision:Admis");
            } else {
                System.out.println("decision:No Admis");
            }
            String mention;
            if (moyenne >= 16) {
                System.out.println(mention = "tres bien");
            } else if (moyenne >= 14) {
                System.out.printf(mention = "bien");
            } else if (moyenne >= 12) {
                System.out.printf(mention = "Assez bien");
            } else if (moyenne >= 10) {
                System.out.printf(mention = "passable");
            } else {
                System.out.printf(mention = "Ajournement");
            }
        }
        for (int i = 0; i < noms.length; i++) {
            afficherInfosEtudiant(numeros[i], noms[i], ages[i], emails[i], promotions[i]);
            afficherBulletin(noms[i], matieres, notes[i]);
            double moy = calculerMoyenne(notes[i]);
            System.out.println("Moyenne:" + moy + "/20");
            boolean admis = estAdmis(moy);
            System.out.println("Admis:" + admis);
            String ment = obtenirMention(moy);
            System.out.println("Mention:" + ment);
        }
        System.out.println("Statisque de la promo:");
        System.out.println("Nombre d etudiants:"+noms.length);
        System.out.println("Moyenne de la prom:"+calculerMoyenneProme(notes)+"/20");
        System.out.println("Note maximale:"+trouverMeilleureNote(notes)+"/20");
        System.out.println("Note minimale:"+trouverPireNote(notes)+"/20");
        System.out.println("Etudiants admis:"+compterAdmis( notes)+" ("+calculerTauxReussite(notes)+"%)");
        repartitionMentions( notes);
    }

    public static double calculerMoyenne(double[] notes) {
        double somme=0;
        for(int i=0;i<notes.length;i++){
            somme=somme+notes[i];
        }
        double moyenne=somme / notes.length;
        return moyenne;}

    public static String obtenirMention(double moyenne) {
        String mention;
        if (moyenne >= 10){
            System.out.println("Decision: Admis");
        }
        else {
            System.out.println("Decision: Non Admis");
        }
        System.out.println("Mention:");
        if(moyenne >= 16){
            System.out.println(mention=" Tres bien");
        }
        else if(moyenne >= 14) {
            System.out.println(mention=" Bien");
        }
        else if(moyenne >= 12) {
            System.out.println(mention=" Assez Bien");
        }
        else if(moyenne >= 10) {
            System.out.println(mention="Passable");
        }
        else{
            System.out.println(mention=" Ajournement");
        }
        return mention; }
    public static boolean estAdmis(double moyenne) {
        return moyenne >= 10; }
    public static void afficherBulletin(String nom, String[] matieres, double[] notes) {
        System.out.println("Bulletin de:"+nom);
        for (int j = 0; j <notes.length; j++) {
            System.out.println(matieres[j]+":"+notes[j]+"/20");

        }
    }
    public static void afficherInfosEtudiant(String numero, String nom, int age, String email, String promo) {
        System.out.println("Numero:"+numero);
        System.out.println("Nom:"+nom);
        System.out.println("Age :"+age);
        System.out.println("Email:"+email);
        System.out.println("Promo :"+promo);
    }
    public static double calculerMoyenneProme(double[][] notes) {
        double somme=0;
        int t=0;
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                somme=somme + notes[i][j];
                t=t+1;
            }
        }
        return somme /t;
    }
    public static double trouverMeilleureNote(double[][] notes){
        double temp=notes[0][0];
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                if (notes[i][j]>temp){
                    temp=notes[i][j];
                }
            }
        }
        return temp;
    }
    public static double trouverPireNote(double[][] notes){
        double temp=notes[0][0];
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                if (notes[i][j]<temp){
                    temp=notes[i][j];
                }
            }
        }
        return temp;
    }
    public static int compterAdmis(double[][] notes) {
        int c = 0;
        for (int i = 0; i < notes.length; i++) {
            double somme = 0;
            for (int j = 0; j < notes[i].length; j++) {
                somme = somme + notes[i][j];
            }
            double moyenne = somme / notes[i].length;
            if (moyenne >= 10) {
                c=c+1;
            }
        }
        return c;
    }
    public static double calculerTauxReussite(double[][] notes){
        int totalEtudiants = notes.length;
        if (totalEtudiants == 0) return 0;
        int admis = compterAdmis(notes);
        return (double) admis / totalEtudiants * 100;
    }
    public static void  repartitionMentions(double[][] notes){
        int t=0;
        int b=0;
        int a=0;
        int p=0;
        int o=0;
        for (int i = 0; i < notes.length; i++) {
            double somme = 0;
            for (int j = 0; j < notes[i].length; j++) {
                somme=somme+ notes[i][j];
            }
            double moyenne = somme / notes[i].length;

            if(moyenne >= 16){
                t=t+1;
            }
            else if( moyenne>= 14) {
                b=b+1;
            }
            else if(moyenne>= 12) {
                a=a+1;
            }
            else if(moyenne >= 10) {
                p=p+1;
            }
            else{
                o=o+1;
            }

        }
        System.out.println("Tres bien:"+t);
        System.out.println("Bien:"+b);
        System.out.println("Assez bien:"+p);
        System.out.println("Passable:"+a);
        System.out.println("Ajournement:"+o);

    }
}







