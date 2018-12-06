package fr.simplex_software.osgi.fuse.jpa.command;

import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;
import org.apache.karaf.shell.support.table.*;

import fr.simplex_software.osgi.fuse.jpa.model.*;

@Service
@Command(scope = "customer-management", name = "findAll", description = "List of customers")
public class FindAllCommand implements Action
{
  @Reference
  private CustomerManagementService customerManagementService;

  @Override
  public Object execute() throws Exception
  {
    ShellTable table = new ShellTable();
    table.column("ID");
    table.column("First Name");
    table.column("Last Name");
    table.column("Street");
    table.column("City");
    table.column("State");
    table.column("Zip Code");
    table.column("Country");
    for (Customer customer : customerManagementService.findCustomers())
      table.addRow().addContent(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getStreet(), 
        customer.getCity(), customer.getState(), customer.getZip(), customer.getCountry());
    table.print(System.out);
    return null;
  }
}
