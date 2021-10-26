package Lab1;

public class Execute {
    private static final String url = "https://www.nbp.pl/kursy/xml/lasta.xml";
    private static final Exchange convert = new Exchange();
    private static final XMLParser parseInit = new XMLParser();
    public static void main(String[] args) {
        try {
            parseInit.XMLParse(url);
            convert.input();
            convert.exchange();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
