public class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited TZS " + amount + ". New balance: TZS " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: TZS " + balance);
    }

    public double calculateInterest() {
        return 0;
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    private final double MIN_BALANCE = 10000;

    public SavingsAccount(String accNo, String holder, double balance, double rate) {
        super(accNo, holder, balance);
        this.interestRate = rate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if ((balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        } else {
            System.out.println("Minimum balance must remain 10,000!");
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest applied: TZS " + interest + ". New balance: TZS " + balance);
    }
}
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accNo, String holder, double balance, double overdraftLimit) {
        super(accNo, holder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}
class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int maturityMonths;
    private boolean isMatured = false;

    public FixedDepositAccount(String accNo, String holder, double balance, double rate, int months) {
        super(accNo, holder, balance);
        this.interestRate = rate;
        this.maturityMonths = months;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    public void checkMaturity() {
        isMatured = true;
    }

    @Override
    public void withdraw(double amount) {
        if (!isMatured) {
            System.out.println("Cannot withdraw. Account not matured!");
        } else {
            super.withdraw(amount);
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }
}
class Bank {
    private BankAccount[] accounts;
    private int count = 0;

    public Bank(int size) {
        accounts = new BankAccount[size];
    }

    public void addAccount(BankAccount acc) {
        accounts[count++] = acc;
    }

    public double getTotalDeposits() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += accounts[i].getBalance();
        }
        return sum;
    }

    public double getTotalInterest() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += accounts[i].calculateInterest();
        }
        return sum;
    }

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
            System.out.println("----------------");
        }
    }

    public BankAccount findAccount(String accNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountNumber.equals(accNo))
                return accounts[i];
        }
        return null;
    }
}
class Exercise13_Polymorphism {

    public static void transferMoney(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);
        to.deposit(amount);
    }

    public static void transferMoney(BankAccount from, BankAccount to, double amount, String desc) {
        System.out.println("Transfer: " + desc);
        transferMoney(from, to, amount);
    }

    public static void transferMoney(BankAccount from, String toAcc, double amount, Bank bank) {
        BankAccount to = bank.findAccount(toAcc);
        if (to != null) transferMoney(from, to, amount);
    }

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount("SAV001", "Ali Hassan", 500000, 0.05);
        CurrentAccount current = new CurrentAccount("CUR001", "Fatma Said", 100000, 50000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Omar Juma", 200000, 0.08, 12);

        savings.displayAccountInfo();
        savings.deposit(100000);
        savings.withdraw(50000);
        savings.applyInterest();

        System.out.println("\nCurrent account:");
        current.withdraw(120000);
        System.out.println("Overdrawn? " + current.isOverdrawn());

        System.out.println("\nFixed deposit:");
        fixed.withdraw(50000);
        System.out.println("Maturity amount: " + fixed.getMaturityAmount());

        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);

        System.out.println("\nTotal deposits: " + bank.getTotalDeposits());
        System.out.println("Total interest: " + bank.getTotalInterest());

        transferMoney(savings, current, 50000);
        transferMoney(current, savings, 30000, "Rent payment");
    }
}