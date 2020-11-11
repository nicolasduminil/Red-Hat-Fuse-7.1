# Red-Hat-Fuse-7.1 JPA Example

## Abstract

This example shows how to use JPA with Red Hat Fuse 7.1 on OSGi (Apache Karaf 4.2.1). The entity manager is used in the persistence implementation. It implements a `CustomerManagementService` similar using a database for the storage, with a JPA entity.

This example uses blueprint and declarative service to deal with JPA entity manager.

The "command" bundle uses the `CustomerManagementService`.

## Artifacts

* **osgi-customer-management** the parent POM
* **osgi-customer-management-data** is a bundle providing the `Customer` entity as well as its API `CustomerManagementService'.
* **osgi-customer-management-service** is a bundle providing the `CustomerManagementServiceImpl` class which is the Hibernate implementation of the `CustomerManagementService' API as well as the associated blueprint.
* **osgi-customer-management-command** provides shell command to manipulate the `CustomerManagementService`. It use declarative service to retreive one instance of a `CustomerManagementService`. 
* **osgi-customer-management-feature** provides a Karaf features repository used for the deployment.

## Build

The build uses Apache Maven. Simply use:

```
mvn clean install
```

## Feature and Deployment

On a running Red Hat Fuse on Karaf instance, register the features repository using:

```
karaf@root()> feature:repo-add mvn:fr.simplex-software.osgi.fuse.aries/osgi-customer-management-feature/0.0.1-SNAPSHOT/xml
```

Then, you can install the datasource feature:

```
karaf@root()> feature:install osgi-customer-management-datasource
```

And install the service implementation:

```
karaf@root()> feature:install osgi-customer-management-service``
```

Then, you can install the service command feature (please make sure the previous service is installes as it might take a few seconds to start):

```
karaf@root()> feature:install osgi-customer-management-command
```



## Usage

Once you have installed the feature, you can see new commands available in the Apache Karaf shell.

customer-management:create - command to add a new customer in the customer database. For instance:

```
karaf@root()> customer-management:create Nicolas Duminil "26 Allée des Sapins" "Soisy sous Montmorency" "Val d''Oise" 95230 France
```

customer-management:findAll command to list the current customers:

```
karaf@root()> customer-management:findAll
ID │ First Name │ Last Name │ Street              │ City                   │ State       │ Zip Code │ Country
───┼────────────┼───────────┼─────────────────────┼────────────────────────┼─────────────┼──────────┼────────
1  │ nicolas    │ duminil   │ 26 Allée des Sapins │ Soisy sous Montmorency │ Val d''Oise │ 95230    │ France

```

customer-management:findById - command to get the customer with the given id:

```
karaf@root()> customer-management:findById 1
FirstName            nicolas
LastName             duminil
Street               26 Allée des Sapins
City                 Soisy sous Montmorency
Zip                  95230
Id                   1
State                Val d''Oise
Country              France
```

customer-management:remove - command to remove a customer from the database:

```
karaf@root()> customer-management:removeCustomer 1
```

