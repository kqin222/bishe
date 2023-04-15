package djj.domain;

public class Request {
    String description;
    String checked;

    public Request(String description, String checked) {
        this.description = description;
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Request{" +
                "description='" + description + '\'' +
                ", checked='" + checked + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
