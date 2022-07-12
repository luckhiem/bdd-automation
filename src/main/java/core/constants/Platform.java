package core.constants;

public interface Platform {
    String BROWSER = System.getProperty("browser") == null
            ? "CHROME"
            : System.getProperty("CHROME");
}
