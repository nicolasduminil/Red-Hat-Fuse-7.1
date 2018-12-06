package fr.simplex_software.osgi.fuse.jpa.command;

import java.util.*;

import org.apache.karaf.shell.api.action.lifecycle.*;
import org.apache.karaf.shell.api.console.*;
import org.apache.karaf.shell.support.completers.*;

import fr.simplex_software.osgi.fuse.jpa.model.*;

@Service
public class CustomerIdCompleter implements Completer
{
  @Reference
  private CustomerManagementService customerManagementService;

  @Override
  public int complete(Session session, CommandLine commandLine, List<String> candidates)
  {
    StringsCompleter delegate = new StringsCompleter();
    for (Customer customer : customerManagementService.findCustomers())
      delegate.getStrings().add(String.valueOf(customer.getId()));
    return delegate.complete(session, commandLine, candidates);
  }
}
