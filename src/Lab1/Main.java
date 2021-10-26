package Lab1;

public class Main {
    private static final String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
    private static final Exchange convert = new Exchange();

    public static void main(String[] args) {
        try {
            XMLParser.XMLParse(url);
            convert.input();
            convert.exchange();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
