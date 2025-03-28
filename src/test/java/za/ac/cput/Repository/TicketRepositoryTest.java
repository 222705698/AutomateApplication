package za.ac.cput.Repository;


import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Tickect;
import za.ac.cput.Factory.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TicketRepositoryTest {
    private static ITicketRepository ticketRepository;
    private static Tickect myTicket;
    private static Tickect myTicket1;

    @BeforeEach
    void setUp() {
        ticketRepository = TicketRepository.getRepository();

        myTicket = TicketFactory.CreateTicketFactory("1000", "2020-01-01", "Pending");
        myTicket1 = TicketFactory.CreateTicketFactory("", "2020-01-01", "Pending");

        if (myTicket != null && ticketRepository.read(myTicket.getTicketID()) == null) {
            ticketRepository.create(myTicket);
        }
    }

    @Test
    @Order(1)
    public void createTicket() {
        assertNotNull(myTicket, "Ticket creation failed: fields may be incorrect");
        assertNotNull(ticketRepository.read(myTicket.getTicketID()), "Ticket must be added to the repository");
        System.out.println(myTicket);
    }

    @Test
    @Order(2)
    public void read() {
        Tickect readTicket = ticketRepository.read(myTicket.getTicketID());
        assertNotNull(readTicket);
        assertEquals(myTicket.getTicketID(), readTicket.getTicketID());
        System.out.println("Fetched Ticket: " + readTicket);
    }

    @Test
    @Order(3)
    public void update() {
        Tickect existingTicket = ticketRepository.read(myTicket.getTicketID());
        assertNotNull(existingTicket, "Ticket should exist before updating");

        Tickect updatedTicket = new Tickect.TicketBuilder()
                .setTicketID(existingTicket.getTicketID())
                .setAmount("2000") // Update amount
                .setIssueDate(existingTicket.getIssueDate())
                .setStatus("Approved") // Update status
                .build();

        ticketRepository.update(updatedTicket);
        Tickect fetchedUpdatedTicket = ticketRepository.read(updatedTicket.getTicketID());

        assertNotNull(fetchedUpdatedTicket, "Updated ticket should exist");
        assertEquals("2000", fetchedUpdatedTicket.getAmount(), "Amount should be updated");
        assertEquals("Approved", fetchedUpdatedTicket.getStatus(), "Status should be updated");

        System.out.println("Updated Ticket: " + updatedTicket);
    }

    @Test
    @Disabled
    @Order(4)
    public void delete() {
        Tickect ticketToDelete = ticketRepository.read(myTicket.getTicketID());
        assertNotNull(ticketToDelete, "Ticket should exist before deletion");

        boolean deleted = ticketRepository.delete(myTicket.getTicketID());
        assertTrue(deleted, "Ticket should be deleted successfully");

        Tickect deletedTicket = ticketRepository.read(myTicket.getTicketID());
        assertNull(deletedTicket, "Deleted ticket should no longer exist in the repository");

        System.out.println("Deleted Ticket ID: " + myTicket.getTicketID());
    }

}

