package IES.lab2_4;

public class Movies {

    private final long id;
    private final String content;

    public Movies(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
