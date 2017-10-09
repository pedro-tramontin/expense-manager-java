package br.com.pedront.expensemanager.core.entity;

import org.springframework.data.annotation.Id;

public class ExpenseEntity {

    @Id
    private String id;

    private String user;

    private String category;

    private String period;

    private String datetime;

    private String originalDescription;

    private String userDescription;

    private String value;

    public ExpenseEntity() {
    }

    public ExpenseEntity(String user, String category, String period, String datetime,
            String originalDescription, String userDescription, String value) {
        this.user = user;
        this.category = category;
        this.period = period;
        this.datetime = datetime;
        this.originalDescription = originalDescription;
        this.userDescription = userDescription;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "ExpenseEntity{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", category='" + category + '\'' +
                ", period='" + period + '\'' +
                ", datetime='" + datetime + '\'' +
                ", originalDescription='" + originalDescription + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
