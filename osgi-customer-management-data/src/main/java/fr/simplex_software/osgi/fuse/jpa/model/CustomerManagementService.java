package fr.simplex_software.osgi.fuse.jpa.model;

import java.math.*;
import java.util.*;

public interface CustomerManagementService
{
  public Customer createCustomer (Customer customer);
  public void removeCustomer (Customer customer);
  public void removeCustomerById (BigInteger id);
  public Customer findCustomer (BigInteger customerId);
  public List<Customer> findCustomers();
  public void updateCustomer (Customer customer);
}
