package fr.simplex_software.osgi.fuse.jpa.command;

import java.math.*;

import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import fr.simplex_software.osgi.fuse.jpa.model.*;

@Service
@Command(scope = "customer-management", name = "removeCustomer", description = "Remove a customer")
public class RemoveCustomerCommand implements Action
{
  @Reference
  private CustomerManagementService customerManagementService;
  @Argument(index = 0, name = "id", description = "Id of customer to retreive", required = true, multiValued = false)
  @Completion(CustomerIdCompleter.class)
  private BigInteger customerId;

  @Override
  public Object execute() throws Exception
  {
    customerManagementService.removeCustomerById(customerId);
    return null;
  }
}
