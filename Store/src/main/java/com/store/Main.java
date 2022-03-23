package com.store;

import com.store.exception.ApplicantNotQualifiedException;
import com.store.exception.OutOfStockException;
import com.store.exception.StaffNotAuthorizedException;
import com.store.model.*;
import com.store.operations.*;
import com.store.enums.Qualification;
import com.store.enums.Role;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws ApplicantNotQualifiedException, OutOfStockException, StaffNotAuthorizedException, IOException {
        Company company = new Company("U-Mac Ventures","C-Line Ariara intl Market");
        Application application = new ApplicationImpl();
        AdminOperationImpl adminOperationImpl = new AdminOperationImpl();
        HireApplicant hireApplicant = new HireApplicantImpl();
        Applicant sunny = new Applicant("Sunday","Ogolo", "Sunny@gmail.com", "0703879289", Qualification.BSC, Role.CASHIER);
        Staff manager = new Staff("Francis", "Mark", "frmac@gail.com", "090737478", Role.MANAGER);
        Staff cashier = new Staff("Shola", "Ebube","sholle@gmail.com","0907468376",Role.CASHIER);
        CustomerOperationImpl customerOperation = new CustomerOperationImpl();
        CashierOperation cashierOperation = new CashierOperationImpl();


        Customer customer1 = new Customer("Den", "Pet", "denpet@gmail.com", "09072838264", Role.CUSTOMER);
        Customer customer2 = new Customer("Deni", "Pete", "denpet@gmail.com", "09072838264", Role.CUSTOMER);
        Customer customer3 = new Customer("Denis", "Peter", "denpet@gmail.com", "09072838264", Role.CUSTOMER);
        Customer customer4 = new Customer("Denisy", "Peters", "denpet@gmail.com", "09072838264", Role.CUSTOMER);
        Customer customer5 = new Customer("De", "Peres", "denpet@gmail.com", "09072838264", Role.CUSTOMER);

        adminOperationImpl.restock(manager, company);

        customerOperation.addProductToCart(customer1,"Nike",47,company);
        customerOperation.addProductToCart(customer2,"Burberry",10, company);
        customerOperation.addProductToCart(customer5,"Rebook",5,company);
        customerOperation.addProductToCart(customer3,"Rebook",8,company);
        customerOperation.addProductToCart(customer4,"Burberry",9,company); // c3 - rebook - 8, c4 - rebook 15, c1 - burberry 20,

        customerOperation.fundWallet(customer1, 500000);
        customerOperation.fundWallet(customer2, 400000);
        customerOperation.fundWallet(customer3, 350000);
        customerOperation.fundWallet(customer4, 200000);
        customerOperation.fundWallet(customer5, 1000000);



        Callable<String> callable1 = cashierOperation.sellToCustomer(company, cashier, customer1);
        Callable<String> callable2 = cashierOperation.sellToCustomer(company, cashier, customer2);
        Callable<String> callable3 = cashierOperation.sellToCustomer(company, cashier, customer3);
        Callable<String> callable4 = cashierOperation.sellToCustomer(company, cashier, customer4);
        Callable<String> callable5 = cashierOperation.sellToCustomer(company, cashier, customer5);

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(callable1);
        callableSet.add(callable2);
        callableSet.add(callable3);
        callableSet.add(callable4);
        callableSet.add(callable5);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            List<Future<String>> futures = executor.invokeAll(callableSet);
            for(Future<String> future : futures){
                System.out.println(future.get());
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }

//        System.out.println(cashierOperation.sellToCustomer(company, cashier, customer1));
//        System.out.println(customer1.getWallet().getBalance());
//        System.out.println(Arrays.toString(company.getProductList()));
//        System.out.println(Arrays.toString(company.getProductList()));
//        application.apply(sunny, company);
//        System.out.println(company.getApplicants());
//        hireApplicant.hire(sunny, manager, company);
//        company.getStaff().add(manager);
//        System.out.println(company.getApplicants());
//        System.out.println(company.getStaff());
        System.out.println(Arrays.toString(company.getProductList()));
//        System.out.println(company.getProductList().length);
//        cashierOperation.sellToCustomer(company, cashier);
    }



}
