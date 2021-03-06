import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class ManagerTest {
  Repository repo = new Repository();
  Manager manager = new Manager(repo);
  Ticket tic1 = new Ticket(1, 20_000, "VNK", "DMD", 100);
  Ticket tic2 = new Ticket(2, 22_000, "VNK", "DMD", 80);
  Ticket tic3 = new Ticket(3, 12_000, "VNK", "TYF", 40);
  Ticket tic4 = new Ticket(4, 8_000, "VNK", "DMD", 60);
  Ticket tic5 = new Ticket(5, 25_000, "VNK", "TYF", 50);
  
  @Test
  public void shouldSortTicketsByPrice() {
    manager.save(tic1);
    manager.save(tic2);
    manager.save(tic3);
    manager.save(tic4);
    manager.save(tic5);
  
    Arrays.sort(manager.getTickets());
    Ticket[] actual = manager.getTickets();
    Ticket[] expected = {tic4, tic3, tic1, tic2, tic5};
    
    Assertions.assertArrayEquals(expected, actual);
    
  }
  
  @Test
  public void shouldFindSortedTicketsForAirports() {
    manager.save(tic1);
    manager.save(tic2);
    manager.save(tic3);
    manager.save(tic4);
    manager.save(tic5);
    
    Ticket[] actual = manager.findAll("VNK", "DMD");
    Ticket[] expected = {tic4, tic1, tic2};
    
    Assertions.assertArrayEquals(expected, actual);
    
  }
  
  @Test
  public void shouldRemoveTicketById() {
    manager.save(tic1);
    manager.save(tic2);
    manager.save(tic3);
    manager.save(tic4);
    manager.save(tic5);
    
    manager.removeById(4);
    
    Ticket[] actual = manager.getTickets();
    Ticket[] expected = {tic1, tic2, tic3, tic5};
    
    Assertions.assertArrayEquals(expected, actual);
    
  }
  
  @Test
  public void shouldAddNewTicketIntoRepo() {
    manager.save(tic2);
    Ticket[] actual = manager.getTickets();
    Ticket[] expected = {tic2};
    
    Assertions.assertArrayEquals(expected, actual);
    
  }
}
