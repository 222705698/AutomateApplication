package za.ac.cput.Factory;

import za.ac.cput.Domain.Tickect;
import za.ac.cput.Domain.Tickect;
import za.ac.cput.Util.Helper;

public class TicketFactory {
    public static Tickect CreateTicketFactory(String Amount, String IssueDate, String Status) {
        String ticketID = Helper.gernerateId(); // Fix typo

//        // Validate Amount (check if it's numeric and positive)
//        if (Amount == null || Amount.isEmpty()) {
//            return null;
//        }
//
//        boolean isNumeric = Amount.chars().allMatch(Character::isDigit);
//        if (!isNumeric || Double.parseDouble(Amount) <= 0) {
//            return null;
//        }
//
//        // Validate IssueDate and Status
//        if (IssueDate == null || IssueDate.isEmpty() || Status == null || Status.isEmpty()) {
//            return null;
//        }

        return new Tickect.TicketBuilder()
                .setTicketID(ticketID)
                .setAmount(Amount)
                .setIssueDate(IssueDate)
                .setStatus(Status)
                .build();
    }

}
