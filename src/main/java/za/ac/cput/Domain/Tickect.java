package za.ac.cput.Domain;

public class Tickect {
    private String TicketID;
    private String Amount;
    private String IssueDate;
    private String Status;

    public Tickect() {
    }
    private Tickect(TicketBuilder builder) {
        this.TicketID = builder.TicketID;
        this.Amount = builder.Amount;
        this.IssueDate = builder.IssueDate;
        this.Status = builder.Status;

    }
    public String getTicketID() {
        return TicketID;
    }

    public String getAmount() {
        return Amount;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public String getStatus() {
        return Status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "TicketID='" + TicketID + '\'' +
                ", Amount=" + Amount +
                ", IssueDate='" + IssueDate + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
    public static class TicketBuilder {
        private String TicketID;
        private String Amount;
        private String IssueDate;
        private String Status;

        public TicketBuilder  setTicketID(String ticketID) {
            TicketID = ticketID;
            return this;
        }

        public TicketBuilder setAmount(String amount) {
            Amount = amount;
            return this;
        }

        public TicketBuilder setIssueDate(String issueDate) {
            IssueDate = issueDate;
            return this;
        }

        public TicketBuilder setStatus(String status) {
            Status = status;
            return this;
        }
        public TicketBuilder copy(Tickect ticket) {
            this.TicketID = ticket.TicketID;
            this.Amount =ticket.Amount;
            this.IssueDate = ticket.IssueDate;
            this.Status = ticket.Status;
            return this;
        }

        public Tickect build() {
            return new Tickect(this);
        }
    }
}
