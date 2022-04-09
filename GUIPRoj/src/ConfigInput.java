import java.io.IOException;

public class ConfigInput {

    private String input;

    {
        try {
            input = FileUtils.configRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int betumeret;
    private static String betutipus;


    public ConfigInput() {
        String[] temp=input.split(";");
        this.betumeret = Integer.parseInt(temp[0]);
        this.betutipus = temp[1];
    }

    public static int getBetumeret() {
        return betumeret;
    }

    public static String getBetutipus() {
        return betutipus;
    }
}
