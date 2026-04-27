package pattern;

public class Product {
    private String header;
    private String body;
    private String footer;

    public void setHeader(String header) { this.header = header; }
    public void setBody(String body) { this.body = body; }
    public void setFooter(String footer) { this.footer = footer; }

    public String toString() { return header + " | " + body + " | " + footer; }
}
