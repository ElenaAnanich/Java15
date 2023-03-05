import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void ticketTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 100, "MSK", "SPB", 12);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 13);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("MSK", "SPB");
        Ticket[] expected = {ticket1, ticket3, ticket2};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void ticketTest2() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(2, 500, "MSK", "UFA", 13);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 13);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("MSK", "UFA");
        Ticket[] expected = {ticket1};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTest3() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(2, 500, "MSK", "UFA", 13);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 13);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 11);
        Ticket ticket4 = new Ticket(2, 200, "MSK", "UFA", 13);
        Ticket ticket5 = new Ticket(2, 900, "MSK", "UFA", 13);
        Ticket ticket6 = new Ticket(2, 400, "MSK", "UFA", 13);
        Ticket ticket7 = new Ticket(2, 700, "MSK", "UFA", 13);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("MSK", "UFA");
        Ticket[] expected = {ticket4, ticket6, ticket1, ticket7, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTest4() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(2, 500, "MSK", "UFA", 13);
        Ticket ticket2 = new Ticket(2, 500, "MSK", "SPB", 13);
        Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB", 11);
        Ticket ticket4 = new Ticket(2, 200, "MSK", "UFA", 13);
        Ticket ticket5 = new Ticket(2, 900, "MSK", "UFA", 13);
        Ticket ticket6 = new Ticket(2, 400, "MSK", "UFA", 13);
        Ticket ticket7 = new Ticket(2, 700, "MSK", "UFA", 13);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll("MSK", "MSK");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}