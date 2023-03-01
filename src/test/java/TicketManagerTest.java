import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void ticketTest(){
        Repository repo =new Repository();
        TicketManager manager =new TicketManager(repo);

        Ticket ticket1 =new Ticket(1,100,"MSK","SPB",12);
        Ticket ticket2 =new Ticket(2,500,"MSK","SPB",13);
        Ticket ticket3 =new Ticket(3,300,"MSK","SPB",11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("MSK","SPB");
        Ticket[] expected = {ticket1,ticket3,ticket2};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void ticketTest2(){
        Repository repo =new Repository();
        TicketManager manager =new TicketManager(repo);
        Ticket ticket1 =new Ticket(2,500,"MSK","UFA",13);
        Ticket ticket2 =new Ticket(2,500,"MSK","SPB",13);
        Ticket ticket3 =new Ticket(3,300,"MSK","SPB",11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll(" MSK","UFA");
        Ticket[] expected = {ticket1};




        Assertions.assertArrayEquals(expected, actual);
    }
}