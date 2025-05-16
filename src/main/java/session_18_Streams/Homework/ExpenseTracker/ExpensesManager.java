package session_18_Streams.Homework.ExpenseTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpensesManager {
    private final List<Expense> expenses;

    public ExpensesManager() {
        this.expenses = new ArrayList<>();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(LocalDate date, String category, double amount){
        Expense newExpense = new Expense(date, category, amount);
        int index = Collections.binarySearch(expenses, newExpense);

        if (index >= 0){
            expenses.get(index).setAmount(expenses.get(index).getAmount() + amount);
        } else {
            expenses.add(-(index + 1), newExpense);
        }
    }

    public boolean deleteExpense(int index){
        if (index >= 0 && index < expenses.size()){
            expenses.remove(index);
            return true;
        }
        return false;
    }

    public Expense getExpense(int index){
        if (index >= 0 && index < expenses.size()){
            return expenses.get(index);
        }
        return null;
    }

    public void editExpense(Expense expense, LocalDate date, String category, double amount){
        expense.setDate(date);
        expense.setCategory(category);
        expense.setAmount(amount);
    }

    public void displayExpenses(){
        IntStream.range(0, expenses.size())
                .forEach(i -> System.out.println((i + 1) + " - " + expenses.get(i)));
    }

    public String getExpenses(List<Expense> filteredList){
        StringBuilder result = new StringBuilder();

        filteredList.forEach(element -> result.append(element).append(System.lineSeparator()));

        return result.toString();
    }

    public List<Expense> getExpenses(LocalDate startDate, LocalDate endDate){
        return expenses.stream()
                .filter(e -> !e.getDate().isBefore(startDate) && !e.getDate().isAfter(endDate))
                .toList();
    }

    private Map<String, Double> getTotalAmountByCategory(List<Expense> expenseList){
        return expenseList.stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));
    }

    public String getTotalAmountByCategoryString(List<Expense> expenseList){
        StringBuilder result = new StringBuilder();

        getTotalAmountByCategory(expenseList)
                .forEach((category, total) ->
                        result.append(String.format("%s: $%.2f", category, total)).append(System.lineSeparator()));
        return result.toString();
    }

    public double getTotal(List<Expense> expenses){
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
