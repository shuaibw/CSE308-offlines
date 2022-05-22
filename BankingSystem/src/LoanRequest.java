class LoanRequest{
    Account account;
    double requestedLoan;

    public LoanRequest(Account account, double requestedLoan) {
        this.account = account;
        this.requestedLoan = requestedLoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanRequest that = (LoanRequest) o;

        return account.equals(that.account);
    }

    @Override
    public int hashCode() {
        return account.hashCode();
    }
}