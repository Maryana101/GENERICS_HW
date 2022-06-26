import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;

import java.util.Comparator;


public class ManagerTest {
  Repository repo = new Repository();
  Manager manager = new Manager(repo);
  Ticket tic1 = new Ticket(1, 20_000, "VNK", "DMD", 100);
  Ticket tic2 = new Ticket(2, 22_000, "VNK", "DMD", 80);
  Ticket tic3 = new Ticket(3, 12_000, "VNK", "TYF", 40);
  Ticket tic4 = new Ticket(4, 8_000, "VNK", "DMD", 60);
  Ticket tic5 = new Ticket(5, 25_000, "VNK", "TYF", 50);
  
  
  @Test
  public void shouldAddNewTicketInEmptyRepo() {
    manager.save(tic1);
    Ticket[] expected = {tic1};
    Ticket[] actual = repo.findAll();
    assertArrayEquals(expected, actual);
    
  }
  
  @Test
  public void shouldSortTicketsByDurationFlight() {
    Ticket[] tickets = new Ticket[0];
    manager.save(tic1);
    manager.save(tic2);
    manager.save(tic3);
    manager.save(tic4);
    manager.save(tic5);
    
    Comparator comparator = new TicketByPriceAscComparator();
    
    Ticket[] actual = manager.findAll("VNK", "DMD", comparator);
    Ticket[] expected = {tic4, tic2, tic1};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldFindAllTicketsInRepo() {
    manager.save(tic3);
    manager.save(tic1);
    manager.save(tic2);
    Ticket[] actual = repo.findAll();
    Ticket[] expected = {tic3, tic1, tic2};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldRemoveTicketById() {
    manager.save(tic3);
    manager.save(tic1);
    manager.save(tic2);
    manager.removeById(1);
    
    Ticket[] expected = {tic3, tic2};
    Ticket[] actual = repo.findAll();
    
    assertArrayEquals(expected, actual);
  }
  
  
}

