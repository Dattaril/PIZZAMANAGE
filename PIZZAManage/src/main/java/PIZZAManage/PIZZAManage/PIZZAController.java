package PIZZAManage.PIZZAManage;

import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class PIZZAController {
	
	
	AtomicInteger counter=new AtomicInteger();
	
	
	@Autowired
	PIZZARepository repository;
	@Autowired
	PIZZAAddService addService;
	

	
	
	
	
	@GetMapping("/getpizza")
	public List<PIZZA> getPIZZA(@RequestParam (value="productName")String productname)
{
	return repository.findAllByeName(productname);
}
	
//update PIzza
	
	@PutMapping("/updatepizza/{id}")
	public ResponseEntity<PIZZA> updatepizza(@PathVariable(value="id") String id,@RequestBody PIZZA piza)
	{
		PIZZA  updatePIZZA =repository.findById(id).get();
		updatePIZZA.setProduct(piza.getProduct());
		updatePIZZA.setPrice(piza.getPrice());
		repository.save(updatePIZZA);
	
		
		return new ResponseEntity<PIZZA>(updatePIZZA, HttpStatus.OK);
		
		
	}
	
	//delete one record
	
	@DeleteMapping("/deletepizza")
	public ResponseEntity<String> DeletePIZAA(@RequestBody PIZZA piza)
	{
		PIZZA delpiza=repository.findById(piza.getId()).get();
		repository.delete(delpiza);
		return new ResponseEntity<>("PIZZA Record Deleted", HttpStatus.CREATED);
	}
	
	//case2 -Get using path  paramter
	@GetMapping("/getpizza/{id}")
	public ResponseEntity<PIZZA> getpizza(@PathVariable(value="id") String id1)
	{
	PIZZA piza= repository.findById(id1).get();
	return new ResponseEntity<PIZZA>(piza,HttpStatus.OK);
	
	}
	
	@PostMapping("/addpizza")
    public  ResponseEntity<PIZZAAddresponse>  addpizzaImplementation(@RequestBody PIZZA piza)	{
		HttpHeaders headers= new HttpHeaders();
		String id= piza.getProduct()+counter.getAndIncrement();
		PIZZAAddresponse add= new PIZZAAddresponse();
		
		if(!addService.checkPIZZAAlreadyExists(id)) {

		piza.setId(id);
		headers.add("Unique", id);
		repository.save(piza);
		
	//Now to get the response we will ceate beanclass with IDand MSG (Class name AddResponse)
		
		add.setId(id);
		add.setMsg("Success: Product Is Added");
	
		
		return new  ResponseEntity<PIZZAAddresponse>(add,headers,HttpStatus.CREATED);
	
		}
	else {
	
		
		add.setId(id);
		add.setMsg("Product Already Exists");
		return new ResponseEntity<PIZZAAddresponse>(add,HttpStatus.ACCEPTED);
	}
	}
	
	
	

	//to delete all the records
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String>  deleteAllRecord()
	{
		repository.deleteAll();
		return new ResponseEntity<>("All Product Record Deleted ", HttpStatus.CREATED);
	}
}





			
		


	


