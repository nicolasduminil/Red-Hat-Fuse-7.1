package fr.simplex_software.osgi.fuse.jpa.service;

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import javax.transaction.*;
import javax.transaction.Transactional.*;

import fr.simplex_software.osgi.fuse.jpa.model.*;

@Transactional
public class CustomerManagementServiceImpl implements CustomerManagementService
{
  @PersistenceContext(unitName = "customers")
  private EntityManager em;


  @Override
  public Customer createCustomer(Customer customer)
  {
    em.persist(customer);
    em.flush();
    return customer;
  }

  @Override
  public void removeCustomer(Customer customer)
  {
    em.remove(customer);
  }

  @Transactional(TxType.SUPPORTS)
  @Override
  public Customer findCustomer(BigInteger customerId)
  {
    return em.find(Customer.class, customerId);
  }

  @Transactional(TxType.SUPPORTS)
  @Override
  public List<Customer> findCustomers()
  {
    CriteriaQuery<Customer> query = em.getCriteriaBuilder().createQuery(Customer.class);
    return em.createQuery(query.select(query.from(Customer.class))).getResultList();
  }

  @Override
  public void updateCustomer(Customer customer)
  {
    em.persist(customer);
  }

  @Override
  public void removeCustomerById(BigInteger id)
  {
    em.remove(em.find(Customer.class, id));
  }
}
