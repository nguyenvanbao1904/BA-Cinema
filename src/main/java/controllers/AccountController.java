/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import hibernateUtils.HibernateUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.Account;
import models.AccountType;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import views.AccountView;

/**
 *
 * @author MSII
 */
public class AccountController {

    private Account model;
    private AccountView view;
    private AccountType type = null;

    public AccountController(Account model, AccountView view) {
        this.model = model;
        this.view = view;
        this.run();
    }

    private void run() {
        int choice;
        do {
            choice = view.displayClientMenuLoginView();
            switch (choice) {
                case 0 -> System.out.print("Bye");
                case 1 -> {
                    Account user = view.getClientLoginInfoView();
                    if (login(user)) {
                        type = AccountType.CLIENT;
                        choice = 0;
                    } else {
                        System.out.println("Tai khoan hoac mat khau chua dung");
                    }
                }
                case 2 -> {
                    Account user = view.getClientSignUpInfoView();
                    if (signUp(user)) {
                        System.out.println("Dang ky tai khoan thanh cong");
                    } else {
                        System.out.println("Thong tin dang ky chua hop le");
                    }
                    
                }
                default ->
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }

    boolean login(Account acc) {
        boolean isLoginOk;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Account> query = builder.createQuery(Account.class);
            Root<Account> root = query.from(Account.class);
            Predicate userNamePredicate = builder.equal(root.get("userName").as(String.class), acc.getUserName());
            Predicate passwordPredicate = builder.equal(root.get("password").as(String.class), acc.getPassword());
            Predicate accountTypePredicate = builder.equal(root.get("accountType").as(AccountType.class), acc.getAccountType());
            query.where(builder.and(userNamePredicate, passwordPredicate, accountTypePredicate));
            try {   
                session.createQuery(query).getSingleResult();
                isLoginOk = true;
            } catch (NoResultException NRE) {
                isLoginOk = false;
            }
        }
        return isLoginOk;
    }
    
    boolean signUp(Account acc){
        try(Session session = HibernateUtils.getFactory().openSession()){
            try{
                session.getTransaction().begin();
                session.persist(acc);
                session.getTransaction().commit();
                return true;
            }catch(ConstraintViolationException e){
                session.getTransaction().rollback();
                return false;
            }
            
        }
    }

    public AccountType getAccountType() {
       return type;
    }
}
