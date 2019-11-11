
// doraditi da se tezina prikaze u tabeli

package javaSwing_memoryGame2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ApplicationMain extends Component {

    public int a;
    private int addon;

    public ApplicationMain(int a) {
        this.a = a;
    }
    // u slucaju pogodka prima dodatni atribut
    public ApplicationMain(int a, int addon) {
        this.a = a;
        this.addon = addon;
    }
    
        public void paint(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(10));
            if (addon==1) {
                g2.setColor(Color.red);
            }
            g2.translate(25, 25);
            switch (a) {
                case 1: g2.drawOval(0, 0, 75, 75); break;
                case 2: g2.fillOval(0, 0, 75, 75); break;
                case 3: g2.drawRect(0, 0, 75, 75); break;
                case 4: g2.fillRect(0, 0, 75, 75); break;
                case 5: g2.drawRect(0, 0, 100, 50); break;
                case 6: g2.fillRect(0, 0, 100, 50); break;
                case 7: g2.drawOval(0, 0, 100, 50); break;
                case 8: g2.fillOval(0, 0, 100, 50); break;
            }
    }
    
    // metoda za pravljenje random liste parova brojeva
    public static ArrayList napravi() {
        Random r = new Random();
        ArrayList<Integer> lista = new ArrayList<>();
        while(lista.size()!=16){
            // generise brojeve od 1 do 8
            int x = r.nextInt(8)+1;
            // proverava da li postoje vec 2 istance istog broja ako postoje
            // preskace dodavanje i sa continue se vraca u petlju
            if (Collections.frequency(lista, x) == 2){
                continue;
            } else {
                lista.add(x);
            }
        }
        return lista;
    }

    // metoda koja iscrtava polja
    public static ArrayList prikazi(ArrayList lista, LinkedList listaPogodaka)
            throws InterruptedException{
        // trik koji listu od 1 do 16 preracunava u listu od 0 do 15
        // trebalo bi da bude posebna metoda
        LinkedList konvertovanaLista = new LinkedList();
        int a, b;
        for (int i=0; i<listaPogodaka.size(); i++) {
            a = (int) listaPogodaka.get(i);
            b = a-1;
            konvertovanaLista.add(b);
        }
        // generise JFrame arraylistu od 16 elemenata
        ArrayList<JFrame> al = new ArrayList<>();
        for (int i=0; i<16; i++) {
            al.add(new JFrame());
        }
        // iscrtavanje polja
        for (int i=0; i<16; i++) {
            String title = format("%d", i+1);
            al.get(i).setTitle(title);
            al.get(i).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            al.get(i).setSize(170, 170);
            switch (i) {
                case (0): al.get(i).setLocation(20, 20); break;
                case (1): al.get(i).setLocation(190,20); break;
                case (2): al.get(i).setLocation(360,20); break;
                case (3): al.get(i).setLocation(530,20); break;
                case (4): al.get(i).setLocation(20,190); break;
                case (5): al.get(i).setLocation(190,190); break;
                case (6): al.get(i).setLocation(360,190); break;
                case (7): al.get(i).setLocation(530,190); break;
                case (8): al.get(i).setLocation(20,360); break;
                case (9): al.get(i).setLocation(190,360); break;
                case (10): al.get(i).setLocation(360,360); break;
                case (11): al.get(i).setLocation(530,360); break;
                case (12): al.get(i).setLocation(20,530); break;
                case (13): al.get(i).setLocation(190,530); break;
                case (14): al.get(i).setLocation(360,530); break;
                case (15): al.get(i).setLocation(530,530); break;
            }
            ApplicationMain framea = null;
            int addon = 1;
            // ako lista podataka konvertovana u indekse sadrzi polje koje se 
            // trenutno iscrtava obelezi ga bojom ako ne iscrtaj ga obicno
            if (konvertovanaLista.contains(i)) {
                al.get(i).getContentPane().setBackground(Color.yellow);
                framea = new ApplicationMain((int) lista.get(i), addon);
            } else {
                framea = new ApplicationMain((int) lista.get(i));
            }
            al.get(i).add(framea);
            al.get(i).setAlwaysOnTop(true); 
            al.get(i).toFront();
            al.get(i).requestFocus();
            al.get(i).setVisible(true);
            Thread.sleep(20);
        }
        return al;
    }
    
    // metoda koja zatvara sva polja kada vreme istekne
    public static void zatvori(ArrayList<JFrame> al)
            throws InterruptedException{
        for(int i=0; i<16; i++) {
            Thread.sleep(20);
            al.get(i).dispose();
        }
    }
    
    // metoda koja prima listu od 16 generisanih brojeva od 1-8 i vrsi proveru
    public static LinkedList<Integer> rezultat(ArrayList lista) {
        Scanner scInt = new Scanner(System.in);
        int a = 0;
        // lista koje ce sadrzati sve pogodke
        LinkedList<Integer> pogodci = new LinkedList<>();
        for(int i=0; i<8; i++){
            System.out.println("izaberi prvi broj");
            int x = scInt.nextInt();
            if (x==999){break;}
            if ((x<1) || (x>16)){
                System.out.println("omasio si brojeve");
            }
            System.out.println("izaberi drugi broj");
            int y = scInt.nextInt();
            if (y==999){break;}
            if ((y<1) || (y>16)){
                System.out.println("omasio si brojeve");
            }
            try {
            // provera vrednosti, provera indexa, provera vec postojecih
            // clanova liste pogodci
            if (Objects.equals(lista.get(x-1), lista.get(y-1)) && x!=y &&
                    !pogodci.contains(x) && !pogodci.contains(y)){
                // counter za pogodke
                a++;
                // dodavanje pogodjenih brojeva u listu pogodaka
                pogodci.add(x);
                pogodci.add(y);
            } else if (x==y) {
                System.out.println("ne mozes uneti isti broj");
            } else if (pogodci.contains(x) && (pogodci.contains(y))) {
                System.out.println("ovaj pogodak si vec imao");
            } 
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ubacio si broj koji nije dozvoljen");
            }
        }
        // dodavanje countera u listu (ovo je nepotrebno)
        pogodci.add(a);
        return pogodci;
    }
    
    // metoda koja izbacuje random poruku
    public static void poruka(int brojPogodaka, int tezina){
        int terminus = 0;
        switch (tezina) {
            case 1: terminus = 1; break;
            case 2: terminus = 3; break;
            case 3: terminus = 5; break;
        }
        if(brojPogodaka<terminus){
            Random r = new Random();
            int i = r.nextInt(5)+1;
            switch(i){
                case 1: System.out.println("postovani postali ste svetski"
                        + " sampion, al zamalo"); break;
                case 2: System.out.println("skoro.. skoro"); break;
                case 3: System.out.println("za konjski nokat"); break;
                case 4: System.out.println("iii!!!!... autogol"); break;
                case 5: System.out.println("auh.. stativa"); break;
        }
        } else {
            System.out.println("hero has managed to save himself from prison..");
        }
    }
    
    // metoda koja ucitava listu rezultata pre pocetka
    public static HashMap<String, Integer> uvod(){
        HashMap<String, Integer> citanjeRezultata = null;
        try {
            FileInputStream fis = new FileInputStream("rezultati.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            citanjeRezultata = (HashMap<String, Integer>) decoder.readObject();
            decoder.close();
        } catch (FileNotFoundException e) {
        }
        return citanjeRezultata;
    }
    
    // metoda za cuvanje podataka
    public static void ispis(HashMap<String, Integer> upisRezultata) 
            throws FileNotFoundException{
        FileOutputStream fos = new FileOutputStream("rezultati.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(upisRezultata);
        encoder.close();
    }
    
    // metoda za prikazivanje rezultata tabelarno
    public static void tabela(HashMap<String, Integer> upisRezultata){
        JFrame frame = new JFrame();
        frame.setTitle("ALL TIME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 680);
        frame.setLocation(700, 20);
        JTable table = new JTable(upisRezultata.size(),2);
        table.setFont(new Font("Serif", Font.BOLD, 20));
        int row = 0;
        for(Map.Entry<String,Integer> entry: upisRezultata.entrySet()){
            table.setValueAt(entry.getKey(),row,0);
            table.setValueAt(entry.getValue(),row,1);
            row++;
        }
        frame.add(table);
        frame.setAlwaysOnTop(true); 
        frame.toFront();
        frame.requestFocus();
        frame.setVisible(true);
    }
    
    // metoda koja ispisuje counter
    public static JFrame counter(){
        JFrame frame = new JFrame();
        frame.setTitle("brze!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 680);
        frame.setLocation(700, 20);
        frame.setAlwaysOnTop(true); 
        frame.toFront();
        frame.requestFocus();
        frame.setVisible(true);
        return frame;
    }
    
    public static JFrame intro(){
        JFrame frame1 = new JFrame();
        frame1.setTitle("story beginning..");
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setSize(980, 680);
        frame1.setLocation(20, 20);
        frame1.setVisible(true);
        frame1.setAlwaysOnTop(true); 
        frame1.toFront();
        frame1.requestFocus();
        return frame1;
    }
    
    public static void main(String[] args) 
            throws InterruptedException, IOException {
        int olderthan13 = JOptionPane.showConfirmDialog(null, "Are you older\nthan 13", "Application start confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (JOptionPane.NO_OPTION == olderthan13) {
            JOptionPane.showMessageDialog(null, "Sorry, you are not going in.\nGrow up, then come back", "Sorry", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JFrame frame1 = intro();
        String sstring1 = "<html>Embark on a journey full of conspiracies,<br>trickery and secrets where you can never tell<br>a friend from foe.<br>" +
"Along the way, you will encounter diverse allies<br>who will fight alongside you.</html>";
        JLabel label1 = new JLabel(sstring1);
        label1.setFont(new Font("Serif", Font.ITALIC,50));
        frame1.add(label1);
        frame1.setVisible(true);
        Thread.sleep(5000);
        // ucitava spoljasnji fajl sa rezultatima
        HashMap<String, Integer> citanjeRezultata = uvod();
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        System.out.println("unesite vase cenjeno ime");
        System.out.println("moje ime je: ");
        String ime = scString.nextLine();
        System.out.println("izaberite tezinu: 1-easy, 2-moderate, 3-expert");
        int tezina = scInt.nextInt();
        Thread.sleep(2000);
        String sstring2 = null;
        switch (tezina) {
            case 1:
                sstring2 = 
                "<html>chapter 1<br>use your cunning to free youself"
                + " from the prison<br>1 or more matches will grant you"
                + " prize<br>only your speed can bring you freedom</html>";
                break;
            case 2:
                sstring2 = 
                "<html>chapter 1<br>use your cunning to free youself"
                + " from the prison<br>3 or more matches will grant you"
                + " prize<br>only your speed can bring you freedom</html>";
                break;
            case 3:
                sstring2 = 
                "<html>chapter 1<br>use your cunning to free youself"
                + " from the prison<br>5 or more matches will grant you"
                + " prize<br>only your speed can bring you freedom</html>";
                break;
        }
        label1.setText(sstring2);
        Thread.sleep(6000);
        System.out.format("zapocnite sa igrom cenjeni gospodine %s "
                + "imate 7 sekundi vremena\nmozete zavrsiti igru u bilo kom"
                + " trenutku koriscenjem koda 999\n", ime);
        Thread.sleep(5000);
        LinkedList listaPogodaka  = new LinkedList();
        // generise slucajnu listu polja
        ArrayList lista = napravi();
        // varaj
//        System.out.println("lista resenja" + lista);
        // gasi intro
        frame1.setVisible(false);
        // iscrtavanje polja
        ArrayList al = prikazi(lista, listaPogodaka);
        // frejm za counter
        JFrame frame2 = counter();
        JLabel label2 = new JLabel("7");
        label2.setFont(new Font("Courier", Font.BOLD,510));
        frame2.add(label2);
        frame2.setVisible(true);
        // odbrojavanje
        for(int i=6; i>=0; i--){
            Thread.sleep(1000);
            String text = Integer.toString(i);
            label2.setText(text);
            frame2.setVisible(true); 
        }
        // zatvaranje polja
        frame2.dispose();
        zatvori(al);
        System.out.println("mnogo nam je zao ali vreme vam je isteklo :)");
        System.out.println("mozete poceti sa unosom, puno srece zelimo");
        // rezultat vraca listu pogodaka
        listaPogodaka = rezultat(lista);
        // izvudi mi broj pogodaka sa kraja liste
        int brojPogodaka = (int) listaPogodaka.pollLast();
        System.out.println("cela lista " + lista);
        System.out.println("ukupno pogodaka " + brojPogodaka);
        System.out.println("lista pogodaka " + listaPogodaka);
        Thread.sleep(3000);
        // isrctavanje polja ovaj put sa korekcijom boje za pogodke
        prikazi(lista, listaPogodaka);
        System.out.format("postovani %s vas finalni "
                + "rezultat je %d pogodaka\n", ime, brojPogodaka);
        HashMap<String, Integer> upisRezultata = new HashMap<>();
        // u slucaju prvog startovanja programa citanjeRezultata ce biti null i 
        // u ispis ce ici upisRezultata, inace citanje rezultata nije null i 
        // upisRezultata postaje citanjeRezultata
        if(citanjeRezultata!=null){
            upisRezultata=citanjeRezultata;
        }
        upisRezultata.put(ime, brojPogodaka);
        // pisanje rezultata u fajl
        ispis(upisRezultata);
        // dodaj tabelu na kraju
        tabela(upisRezultata);
        System.out.println("");
        // pozovi poruku
        poruka(brojPogodaka, tezina);
        int terminus = 0;
        switch (tezina){
            case 1: terminus = 1; break;
            case 2: terminus = 3; break;
            case 3: terminus = 5; break;
        }
        if(brojPogodaka>=terminus){
            Thread.sleep(4000);
            frame1.setVisible(true);
            String sstring3 = "<html>our hero has managed to escape from the"
                    + " prison<br>and is on route to magic castle<br>where his"
                    + " nemesis had taken the princess</html>";
            label1.setText(sstring3);
            Thread.sleep(10000);
            String sstring4 = "<html>soon chapter 2..</html>";
            label1.setText(sstring4);
            Thread.sleep(2000);
            frame1.dispose();
        }
    }
}
