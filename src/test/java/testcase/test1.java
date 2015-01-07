package testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.duzon.ssh.mapper.TbCustMapper;
import com.duzon.ssh.model.TbCust;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
public class test1 {
	
	//private Logger logger = LogManager.getLogger(getClass());  //Logger.getLogger(getClass());
	//protected Log logger = LogFactory.getLog(this.getClass());
	private Logger logger = LogManager.getLogger(this.getClass());
	
	
	@Autowired
	private TbCustMapper tbCustMapper;
	
	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		
		
		
		
	}

	@Test
	public void test() {
		
		TbCust tbCust = tbCustMapper.selectByPrimaryKey("0000001");
		logger.trace("중간 trace");
		logger.debug("중간 debug");
		logger.info("중간 info");
		logger.warn("중간 warn");
		logger.error("중간 error");
		
		
	}

}
