

package com.example.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bean.RecordBean;

/**
 * 
 * @author Vaquar.khan@gmail.com
 *
 */
@Repository
@Qualifier ("gemfireCache")
public interface RecordRepository extends CrudRepository<RecordBean, Integer> {

	RecordBean findByRecordId(String recordId);
	
@Query("SELECT * FROM /record")  
  Collection<RecordBean> myFindAll();

	
}