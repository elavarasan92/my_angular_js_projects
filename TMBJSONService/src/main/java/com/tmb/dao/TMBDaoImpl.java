package com.tmb.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmb.model.AccountDetails;
import com.tmb.model.AccountSummary;
import com.tmb.model.BankDetails;
import com.tmb.model.Book;
import com.tmb.model.FromAccountsList;
import com.tmb.model.PayeeAccountDetails;
import com.tmb.model.User;
import com.tmb.pojo.FundTransferInput;
import com.tmb.pojo.IFSCCodeSearch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class TMBDaoImpl implements TMBDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addBook(Book book) throws Exception{
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public Book getBookById(long id) throws Exception{
        session = sessionFactory.openSession();;
        Book book = (Book) session.load(Book.class, new Long(id));
        tx = session.getTransaction();
        tx = session.beginTransaction();
        tx.commit();
        return book;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Book> getBookList() throws Exception{
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Book> bookList = session.createCriteria(Book.class).list();
        tx.commit();
        session.close();
        return bookList;
    }

    public boolean deleteBook(long id) throws Exception {
        session = sessionFactory.openSession();
        Object book = session.load(Book.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(book);
        tx.commit();
        return false;
    }
    public boolean addUser(User user)throws Exception
    {
    	 session = sessionFactory.openSession();
         tx = session.beginTransaction();
         session.save(user);
         tx.commit();
         session.close();
         return false;
    	
    }

	@Override
	public User getUserDetails(String userid, String password) {
		  session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("userid", userid));
		cr.add(Restrictions.eq("password", password));
		//cr.add(Restrictions.eq("primaryDeviceId", primaryDeviceBean.getPrimarydeviceId()));
		User user = (User)cr.uniqueResult();
		 tx = session.getTransaction();
	        tx = session.beginTransaction();
	        tx.commit();
	        System.out.println(user);
		return user;
	}
	
	public AccountSummary getAccountSummary(String name) {
	
		  session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(AccountSummary.class);
		cr.add(Restrictions.eq("accountHolderName", name));
//		cr.add(Restrictions.eq("password", password));
		//cr.add(Restrictions.eq("primaryDeviceId", primaryDeviceBean.getPrimarydeviceId()));
		AccountSummary accountSummary = (AccountSummary)cr.uniqueResult();
		 tx = session.getTransaction();
	        tx = session.beginTransaction();
	        tx.commit();
	        System.out.println(accountSummary);
		return accountSummary;
	
	}

	@Override
	public boolean createAccount(AccountDetails accountDetails) throws Exception {
		 session = sessionFactory.openSession();
         tx = session.beginTransaction();
         session.save(accountDetails);
         tx.commit();
         session.close();
		return false;
	}

	@Override
	public  List<FromAccountsList> getFromAccountsList(String userid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AccountDetails.class).add(Restrictions.eq("userid",userid));
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("accountHolderName"));
		projectionList.add(Projections.property("accountNumber"));
		projectionList.add(Projections.property("balance"));
		
		criteria.setProjection(projectionList);
		
		List list = criteria.list();
		System.out.println("#######################################"+list);
		Iterator iterator = list.iterator();
		List<FromAccountsList> fromAccountsList = new ArrayList<FromAccountsList>();
		while(iterator.hasNext())
		{
			Object object[] = (Object[])iterator.next();
			FromAccountsList fromAccount = new FromAccountsList();
			fromAccount.setAccountHolderName((String) object[0]);
			fromAccount.setAccountNumber((String) object[1]);
			fromAccount.setBalance((BigDecimal) object[2]);
			fromAccountsList.add(fromAccount);
			
		}
		tx.commit();
		session.close();
		return fromAccountsList;
	}

	@Override
	public boolean addPayee(PayeeAccountDetails payeeAccountDetails)
			throws Exception {
		 session = sessionFactory.openSession();
         tx = session.beginTransaction();
         session.save(payeeAccountDetails);
         tx.commit();
         session.close();
		return false;
	}

	@Override
	public List<BankDetails> getIFSCCode(IFSCCodeSearch iFSCCodeSearch) {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(BankDetails.class);
		if(iFSCCodeSearch.getBankName()!=null)
		{
			criteria.add(Restrictions.like("bankName",iFSCCodeSearch.getBankName(), MatchMode.ANYWHERE));
		}
		if(iFSCCodeSearch.getiFSCCode()!=null)
		{

			if(iFSCCodeSearch.getiFSCCode().length()==11)
			{
				System.out.println("inside length 11 ##############################################");
				criteria.add(Restrictions.eq("iFSCCode",iFSCCodeSearch.getiFSCCode()));
			}
			else if(iFSCCodeSearch.getiFSCCode().length()>0&&iFSCCodeSearch.getiFSCCode().length()<11)
			{
				System.out.println("inside length >0 <11 ##############################################");
				
					criteria.add(Restrictions.like("iFSCCode", iFSCCodeSearch.getiFSCCode(), MatchMode.ANYWHERE));	
				
			}
		}
		if(iFSCCodeSearch.getCity()!=null)
		{
			criteria.add(Restrictions.like("city",iFSCCodeSearch.getCity(), MatchMode.ANYWHERE));
		}
		
		List list = criteria.list();
		System.out.println("#######################################"+list);

		tx.commit();
		session.close();
	
		return list;
		
	}

	@Override
	public List<AccountDetails> getUserAccountDetailsList(String userid) {
		

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AccountDetails.class).add(Restrictions.eq("userid",userid));
		
	
		
		List<AccountDetails> userAccountDetailslist = criteria.list();
		//System.out.println("#######################################"+userAccountDetailslist);
		
		tx.commit();
		session.close();
		return userAccountDetailslist;
	
	}

	@Override
	public boolean transferMoney(FundTransferInput fundTransferInput)
			throws Exception {
		
		
		session = sessionFactory.openSession();
        tx = session.beginTransaction();
        
        String hql = "UPDATE AccountDetails set balance = :balance "  + 
                "WHERE accountNumber = :accountNumber";
       
   Query query = session.createQuery(hql);
   query.setParameter("balance", fundTransferInput.getAvailableAmount().subtract(fundTransferInput.getTransferAmount()));
   query.setParameter("accountNumber", fundTransferInput.getFromAccountNumber());
   int result = query.executeUpdate();
   
//   String hql2 = "from AccountDetails where category.name = 'Computer'";
//   Query query2 = session.createQuery(hql2);
//   query2.uniqueResult();
//   System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Rows affected: " + result);
   
        tx.commit();
        session.close();
		return false;
	}

//	public List<Book> getBookList() throws Exception{
//        session = sessionFactory.openSession();
//        tx = session.beginTransaction();
//        List<Book> bookList = session.createCriteria(Book.class).list();
//        tx.commit();
//        session.close();
//        return bookList;
//    }
//	@Override
//	public User retriveUserData(String userid, String password) {
//		User user = new User();
//		if(userid.equals(user)&&)
//		
//		return null;
//	}
}
