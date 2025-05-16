package session_18_Streams.Homework.ExpenseTracker;

import java.time.LocalDate;

public class Expense implements Comparable<Expense> {
    private LocalDate date;
    private String category;
    private double amount;

    public Expense(LocalDate date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | $" + amount;
    }

    @Override
    public int compareTo(Expense o) {
        int dateComparison = this.date.compareTo(o.date);
        if (dateComparison != 0) {
            return dateComparison;
        }

        return this.category.compareTo(o.category);
    }
}
