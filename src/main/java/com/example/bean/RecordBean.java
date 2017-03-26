package com.example.bean;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

/**
 * 
 * @author vaquar.khan@gmail.com
 *
 */
@Region("record")
public class RecordBean implements Serializable
{


		private static final long serialVersionUID = 3209342518270638000L;

		@Id
		 String recordId;

		private String recordString;

		@PersistenceConstructor
		public RecordBean(String recordId, String recordString)
		{
				this.recordId = recordId;
				this.recordString = recordString;
		}

		public String getRecordId()
		{
				return recordId;
		}

		public void setRecordId(String recordId)
		{
				this.recordId = recordId;
		}

		public String getRecordString()
		{
				return recordString;
		}

		public void setRecordString(String recordString)
		{
				this.recordString = recordString;
		}

		@Override
		public String toString()
		{
				return "RecordBean [Record Id=" + recordId + ", Record String=" + recordString + "]";
		}

}
