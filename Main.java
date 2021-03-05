import java.util.*;

public class Main {
    static ArrayList<Integer> pozitiiPlayer = new ArrayList<Integer>();
    static ArrayList<Integer> pozitiiCpu = new ArrayList<Integer>();
    public static void main (String[] args){
        char[][] joc = {{' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '},
                        {'-', '+', '-', '+', '-'},
                        {' ', '|', ' ', '|', ' '}};

        Xsi0(joc);
        while(true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Introduceti pozitia (1 - 9)");
            int pozPlayer = scan.nextInt();
            while(pozitiiPlayer.contains(pozPlayer) || pozitiiCpu.contains(pozPlayer)){
                System.out.println("Pozitia este luata!");
                pozPlayer = scan.nextInt();
            }
            System.out.println(pozPlayer);
            Pozitie(joc, pozPlayer, "player");
            Random aleator = new Random();
            int pozCpu = aleator.nextInt(9) + 1;
            while(pozitiiPlayer.contains(pozCpu) || pozitiiCpu.contains(pozCpu)){
                pozCpu = aleator.nextInt(9) + 1;
            }
            Pozitie(joc, pozCpu, "cpu");
            castigator();

        }
    }

    public static void Xsi0(char[][] joc){
        for(char[] row: joc){
            for(char c : row){
                System.out.print(c);
            }
            System.out.print("\n");
        }

    }
    public static void Pozitie(char[][] joc, int pozitie, String User ){
        char simbol = 'X';

        if(User.equals("player")){
            simbol = 'X';
            pozitiiPlayer.add(pozitie);
        }else if (User.equals("cpu")){
            simbol = '0';
            pozitiiCpu.add(pozitie);
        }

        switch(pozitie){
            case 1:
                joc[0][0] = simbol;
                break;
            case 2:
                joc[0][2] = simbol;
                break;
            case 3:
                joc[0][4] = simbol;
                break;
            case 4:
                joc[2][0] = simbol;
                break;
            case 5:
                joc[2][2] = simbol;
                break;
            case 6:
                joc[2][4] = simbol;
                break;
            case 7:
                joc[4][0] = simbol;
                break;
            case 8:
                joc[4][2] = simbol;
                break;
            case 9:
                joc[4][4] = simbol;
                break;
            default:
                System.out.println("Pozitie invalida!");
                break;
        }
        Xsi0(joc);
        System.out.println();
        System.out.println();
    }
    public static void castigator(){
        List rand1 = Arrays.asList(1, 2, 3);
        List rand2 = Arrays.asList(4, 5, 6);
        List rand3 = Arrays.asList(7, 8, 9);
        List coloana1 = Arrays.asList(1, 4, 7);
        List coloana2 = Arrays.asList(2, 5, 8);
        List coloana3 = Arrays.asList(3, 6, 9);
        List diagonala1 = Arrays.asList(1, 5, 9);
        List diagonala2 = Arrays.asList(3, 5, 7);

        List<List> conditii = new ArrayList<List>();
        conditii.add(rand1);
        conditii.add(rand2);
        conditii.add(rand3);
        conditii.add(coloana1);
        conditii.add(coloana2);
        conditii.add(coloana3);
        conditii.add(diagonala1);
        conditii.add(diagonala2);

        for(List l:conditii){
            if(pozitiiPlayer.containsAll(l)){
                System.out.println("FELICITARI, AI CASTIGAT!");
                System.exit(0);
            }else if(pozitiiCpu.contains(l)){
                System.out.println("COMPUTER-UL A CASTIGAT!");
                System.exit(0);
            }else if(pozitiiPlayer.size() + pozitiiCpu.size() == 9){
                System.out.println("EGALITATE!");
                System.exit(0);
            }
        }
    }
}
