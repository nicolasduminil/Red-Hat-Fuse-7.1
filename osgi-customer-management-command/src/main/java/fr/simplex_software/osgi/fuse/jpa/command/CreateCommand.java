package fr.simplex_software.osgi.fuse.jpa.command;

import org.apache.karaf.shell.api.action.*;
import org.apache.karaf.shell.api.action.lifecycle.*;

import fr.simplex_software.osgi.fuse.jpa.model.*;

@Service
@Command(scope = "customer-management", name = "create", description = "Create a Customer")
public class CreateCommand implements Action
{
  @Reference
  private CustomerManagementService customerManagementService;
  @Argument(index = 0, name = "firstName", description = "Customer first name", required = true, multiValued = false)
  private String firstName;
  @Argument(index = 1, name = "lastName", description = "Customer last name", required = true, multiValued = false)
  private String lastName;
  @Argument(index = 2, name = "street", description = "Customer address (street)", required = true, multiValued = false)
  private String street;
  @Argument(index = 3, name = "city", description = "Customer address (city", required = true, multiValued = false)
  private String city;
  @Argument(index = 4, name = "state", description = "Customer address (state", required = true, multiValued = false)
  private String state;
  @Argument(index = 5, name = "zip", description = "Customer address (zip)", required = true, multiValued = false)
  private String zip;
  @Argument(index = 6, name = "country", description = "Customer address (country)", required = true, multiValued = false)
  private String country;
  
  @Override
  public Object execute() throws Exception
  {
    customerManagementService.createCustomer(new Customer(firstName, lastName, street, city, state, zip, country));
    return null;
  }
}
