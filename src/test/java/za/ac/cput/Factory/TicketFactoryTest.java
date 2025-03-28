package za.ac.cput.Factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Tickect;
import za.ac.cput.Domain.Tickect;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
class TicketFactoryTest {
private static Tickect myTicket = TicketFactory.CreateTicketFactory("R10", "2020-01-01", "Pending");
public static Tickect myTicket1 = TicketFactory.CreateTicketFactory("R1", "2020-01-01", "Pending");

@Test
@Order(1)
public void createTicket(){
    assertNotNull(myTicket,"You must fill in all the fields correctly");
    System.out.println(myTicket.toString());
}

@Test
public void testCreateTicket_InvalidAmount_ReturnsNull() {
    assertNull(myTicket1, "Ticket should be null if the amount is invalid");
    System.out.println(myTicket1);
}

@Test
public void testCreateTicket_InvalidDate_ReturnsNull() {
    assertNull(myTicket1, "Ticket should be null if the date is invalid");
    System.out.println(myTicket1);

}
}
