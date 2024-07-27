/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import hibernateUtils.HibernateUtils;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import models.Account;
import models.AccountType;
import org.hibernate.Session;


/**
 *
 * @author MSII
 */
public class Test {
    public static void main(String[] args) {
        Account acc = new Account("user1", "password456", AccountType.CLIENT);
        Session session = HibernateUtils.getFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        Predicate userNamePredicate = builder.equal(root.get("userName").as(String.class), acc.getUserName());
        Predicate passwordPredicate = builder.equal(root.get("password").as(String.class), acc.getPassword());
        Predicate accountTypePredicate = builder.equal(root.get("accountType").as(AccountType.class), acc.getAccountType());
        query.where(builder.and(userNamePredicate, passwordPredicate, accountTypePredicate));
        
        try{
            Account account = session.createQuery(query).getSingleResult();
            System.out.printf("%d - %s -%s", account.getId(), account.getUserName(), account.getPassword());
        }catch(NoResultException NRE){
            System.out.println("Khong khop");
        }
       
        session.close();
        
    }
}
