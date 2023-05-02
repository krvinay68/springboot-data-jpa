# springboot-data-jpa
https://docs.spring.io/spring-boot/docs/1.1.6.RELEASE/reference/html/common-application-properties.html
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

JPA TOPICS
------------
Any of These interface we have to extends to use of SPRING DATA RESPOSITOYRY 
1.JpaRepository interface
2.PagingAndSortingRepository interface 
3.Simple CRUD(CREATE,READ,UPDATE,DELETE) OPERATION using predifned methods
4.GENERATORS nothing but id generators
                  
    1.@GeneratedValue(strategy = GenerationType.AUTO)
	2.@GeneratedValue(strategy = GenerationType.IDENTITY)
	3.@GeneratedValue(strategy = GenerationType.SEQUENCE)
	4.@GeneratedValue(strategy = GenerationType.TABLE)  
	      @TableGenerator(name = "emp_genertor",table = "e_pkgenerator",pkColumnName = "pk_name",valueColumnName = "gen_val",allocationSize = 100)
	
	 //for generic or custom generator we have to implements "IdentifierGenerator" inteface 
    5.@GenericGenerator(name = "emp_generator", strategy = "CustomGenerator")
      @GeneratedValue(generator ="emp_generator" )	
				  
       
4.FINDER METHODS nothing but custom method to filter the based on our requirement
     (like,between,in, greater than,find by name etc..)
	 
5.JPQL (JAVA PERSISTENCE QUERY LANGUAGE
       syntax:-@Query("from ItemEntity")
	           //name query parameters
	           @Query("from ItemEntity where itemName=:itemName") 
			   
6.NATIVE SQL QUERY
         Syntax:-@Query(value="select * from Item", nativeQuery = true)
		        @Query(value="select * from Item where itemPrice=:itemPrice", nativeQuery = true)

7.INHERITANCE (SINGLE_TALBE, TABLE_PER_CLASS,JOINED)
	1.@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
             @DiscriminatorColumn(name = "acctype", discriminatorType = DiscriminatorType.STRING)
	2.@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//no need of @DiscriminatorColumn
    3.@Inheritance(strategy = InheritanceType.JOINED)//no need of @DiscriminatorColumn
      @PrimaryKeyJoinColumn(name="Id") we have to use with JOINED  
	  
8.COMPONENT MAPPING nothing but has a relationship
    @Embedded
	@Embeddable

9.RELATIONSHIP IN HIBERNATE OR JPA AND CASCAIDNG(persist,merge,remove,refresh,detach,all)
      1.ONE TO ONE -->@OneToOne(mappedBy = "person") parent class or table
	                  @OneToOne(cascade = CascadeType.ALL) child class or table
	                  @JoinColumn(name = "person_id")
	  
      2.ONE TO MANY-->@OneToMany(mappedBy = "target table", cascade = CascadeType.ALL,fetch = FetchType.EAGER))
	    ->if want early loading use fetch = FetchType.EAGER
        ->if want to enable lazy loading then in the method which we are performing read opereation marked as  
		   @Transactional
		   
      3.MANY TO ONE-->@JoinColumn(name="customer_id")--forein key column name
      
	  4.MANY TO MANY -->	
	     @ManyToMany(cascade = CascadeType.ALL)
	     @JoinTable(name = "programmers_projects", joinColumns = @JoinColumn(name= "programmer_id", referencedColumnName = "id"), inverseJoinColumns =@JoinColumn(name="project_id",referencedColumnName = "id") )
		 @ManyToMany(mappedBy = "project")
		 
10.TRANSACTION MANAGEMENT:-
     Transaction App--->TransactionalManager/Transaction Co-ordinator---->Resource Manager---->DB
     	 use @Transactional
		 
11.SAVE AND RETRIVE FILES:-
      only we have to do Mark the entiry field as @Lob 	

12.CALLING STORED PROCEDURES:-just mark the method what we will create inside JpaRepository
  
        @Query(value="CALL storedprocedurename", nativeQuery=true)
		
		//for parameterized stored procedures
		@Query(value="CALL storedprocedurename (:price_in)", nativeQuery=true)
		
13.COMPOSITE KEY:-COMPOSITE KEY NOTHIG BUT TWO CLOUMN WE CAN USE AS PRIMARY KEY  
     we have to use
      @IdClass
      @Embeddable
      @EmbeddedId

14.MONGO DB: 
    use mydb ---> if mydb is present then it will switch to mydb other it will create and then switch	
    show collections
    db.product.insert({"name":"red","price":2000})
    db.product.find()
    db.product.find().pretty()
    db.product.drop()---it will drop the table	

FOR  java entity class we have to use 
    @Document istead of @Entity
This  interface we have to extends to use of SPRING MONGO DATA RESPOSITOYRY 
"MongoRepository"	  

15.MULTIPLE DATA BASE
     CONFIGURE PROPERTIES IN APPLICATION.PROPERTIES FILES
     DATA SOURCE
     ENTITYMANAGERFACTROY
     TRANSACTIONMANAGER	 
	 

16.CACHING
    Level1 cache is "Session" 
	       to enable we have to use @Transactional
		   to remove the object from level1 the use evict();
		   
		   @Autowired
		   EntityManager entityManager;
		   Session session= entityManager.unwrap(Session.class)
		   respository.findById(1l);
		   respository.findById(1l);
		   session.evict();
		   respository.findById(1l);
		   
		   
Level2 "SessionFactory" -object will be cached and will be shared accrros multiple hibernate session.
	        
level2 provides:- ehcache(most popular), swaram cache, jboss Tree cache,OS cache,Tangosol Cache

steps for Eh-cache
Steps:-
     Add maven dependency
	 enable cache for the application--in application.properties
	 create ehcache.xml
	 make entities cacheable
	 Test or execute

Stratigy:-	 
READ_ONLY
NONSTRICT_READ_WRITE
READ_WRITE
TRANSACTIONAL	      
	
