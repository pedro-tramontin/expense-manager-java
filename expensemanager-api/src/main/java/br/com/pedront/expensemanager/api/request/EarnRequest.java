package br.com.pedront.expensemanager.api.request;

public class EarnRequest {

    private String user;

    private String category;

    private String period;

    private String datetime;

    private String originalDescription;

    private String userDescription;

    private String value;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getOriginalDescription() {
        return originalDescription;
    }

    public void setOriginalDescription(String originalDescription) {
        this.originalDescription = originalDescription;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EarnRequest{" +
            "user='" + user + '\'' +
            ", category='" + category + '\'' +
            ", period='" + period + '\'' +
            ", datetime='" + datetime + '\'' +
            ", originalDescription='" + originalDescription + '\'' +
            ", userDescription='" + userDescription + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
