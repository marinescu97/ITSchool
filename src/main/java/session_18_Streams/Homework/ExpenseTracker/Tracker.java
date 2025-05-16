package session_18_Streams.Homework.ExpenseTracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Tracker {
    private static final ExpensesManager manager = new ExpensesManager();
    private static final Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static final String menu = """
                                    \n===Expense Tracker Menu===
                                    1 - Add expense
                                    2 - Delete expense
                                    3 - Edit expense
                                    4 - View all expenses
                                    5 - View total expenses for a given time period
                                    0 - Exit
                                    
                                    """;

    public static void main(String[] args) {
        do {
            displayMenu();
        } while (choice != 0);
    }

    public static void displayMenu(){
        System.out.println(menu);
        choice = Validator
                .getChoice(scanner, "Choose an option: ")
                .validate();
        scanner.nextLine();

        handleChoice();
    }

    private static void handleChoice(){
        switch (choice){
            case 1 -> addExpense();
            case 2 -> deleteExpense();
            case 3 -> editExpense();
            case 4 -> displayExpenses();
            case 5 -> displayPeriodExpenses();
            case 0 -> System.out.println("Goodbye");
            default -> {
                System.out.println("Invalid option. Try again.");
                displayMenu();
            }
        }
    }

    private static void addExpense(){
        LocalDate date = Validator.getDate(scanner, "Date (YYYY-MM-DD): ", false).validate();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        double amount = Validator.getAmount(scanner, "Amount: ", false).validate();

        manager.addExpense(date, category, amount);
        System.out.println("Expense added successfully!");
    }

    private static void displayExpenses(){
        if (manager.getExpenses().isEmpty()){
            System.out.println("\nThe list is empty.");
        } else {
            System.out.println("\n===All expenses===");
            manager.displayExpenses();
        }
    }

    private static void deleteExpense(){
        int index = Validator.getChoice(scanner, "Enter index (0 - to go back): ").validate();

        if (index == 0){
            displayMenu();
        } else {
            handleDelete(index);
        }
    }

    private static void handleDelete(int index){
        if (manager.deleteExpense(index-1)){
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("The expense with id " + index + " doesn't exist.");
            handleChoice();
        }
    }

    private static void editExpense(){
        int index = Validator.getChoice(scanner, "Enter index (0 - to go back): ").validate();

        if (index == 0){
            displayMenu();
        } else {
            handleEdit(index);
        }
    }

    private static void handleEdit(int index){
        Expense expense = manager.getExpense(index-1);

        if (expense == null){
            System.out.println("The expense with index " + index + " doesn't exist.");
            handleChoice();
        } else {
            scanner.nextLine();
            LocalDate newDate = Validator
                    .getDate(scanner, String.format("New date (ENTER -> %s): ", expense.getDate()), true)
                    .validate();
            if (newDate == null) {
                newDate = expense.getDate();
            }

            System.out.printf("New category (ENTER -> %s): ", expense.getCategory());
            String category = scanner.nextLine();
            String newCategory = category.isEmpty() ? expense.getCategory() : category;

            double newAmount = Validator
                    .getAmount(scanner, String.format("New amount (ENTER -> %.2f): ", expense.getAmount()), true)
                    .validate();
            if (newAmount == -1) {
                newAmount = expense.getAmount();
            }

            manager.editExpense(expense, newDate, newCategory, newAmount);
        }
    }

    private static void displayPeriodExpenses(){
        LocalDate startDate = Validator
                .getDate(scanner, "Enter the start date: ", false)
                .validate();
        LocalDate endDate = Validator
                .getDate(scanner, "Enter the end date: ", false)
                .validate();

        List<Expense> result = manager.getExpenses(startDate, endDate);

        if (result.isEmpty()){
            System.out.println("No expenses found in this period.");
        } else {
            String report = String.format("""
                    
                    Expenses between %s and %s:
                    %s
                    %s
                    Total: $%.2f
                    """, startDate, endDate, manager.getExpenses(result), manager.getTotalAmountByCategoryString(result), manager.getTotal(result));
            System.out.println(report);

            char yesOrNo = Validator
                    .getYesOrNo(scanner, "Would you like to export this report to a file? (Y/N): ")
                    .validate();

            if (yesOrNo == 'y'){
                saveReport(report);
            } else {
                displayMenu();
            }
        }
    }

    private static void saveReport(String report){
        String filePath = Validator
                .getFilePath(scanner, "Please enter the path of the file (including the filename with .txt extension): ")
                .validate();

        saveToFile(filePath, report);
    }

    private static void saveToFile(String filePath, String content){
        try {
            Path path = Paths.get(filePath);
            Files.write(path, List.of(content));
            System.out.println("File saved successfully to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }
    }
}
