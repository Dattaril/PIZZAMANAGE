package PIZZAManage.PIZZAManage;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class PIZZAManageApplicationTests
{
 
 AtomicInteger counter=new AtomicInteger();
 
 
 @Autowired
 PIZZAController con;
 
 @MockBean
 PIZZAAddService EMService;
 
 
 @MockBean
 PIZZARepository repository;
 
 
 void contextLoads() 
 {
  
 
  
 }

 
 //@Test
 //public void TS001()
 //{
  //JUNIT Code - Sample
 // GetAndSet GS=new GetAndSet();
 // GS.setColor("RED");
  //assertEquals("RED", GS.getColor());
 //}
 
 
 
// public void AddPizza()
 //{
  
  //This is WITHOUT MOCKITO
 // ResponseEntity response=con.addpizzaImplementation(EMSDataPayload());
 // System.out.println(response.getStatusCode());
 // assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  //
 //}
 
 
 @Test
 public void AddPIZZAwithMockito()
 {
  
  //This is WITH MOCKITO
  when(EMService.checkPIZZAAlreadyExists(PIZZADataPayload().getProduct()+counter.getAndIncrement())).thenReturn(false);
  //when(EMService.checkEMPAlreadyExist(EMSDataPayload().geteNAME()+counter.getAndIncrement())).thenReturn(true);
  
  ResponseEntity response=con.addpizzaImplementation(PIZZADataPayload());
  System.out.println(response.getStatusCode());
  assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  
  PIZZAAddresponse ad=(PIZZAAddresponse) response.getBody();
  assertEquals("Success: Product Is Added", ad.getMsg());
  //assertEquals("Employee Already Exists", ad.getMsg());
  
  
 }
 
 
 
 
 
 public PIZZA PIZZADataPayload()
 {
  PIZZA piza=new PIZZA();
  piza.setProduct("Mexical Delight");
  piza.setPrice("650");
  return piza;
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
  
 
 
 

}
