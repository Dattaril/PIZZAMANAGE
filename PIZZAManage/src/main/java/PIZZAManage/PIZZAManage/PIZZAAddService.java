package PIZZAManage.PIZZAManage;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PIZZAAddService {
	
	 @Autowired
	 PIZZARepository repository;
	 
	 public boolean checkPIZZAAlreadyExists(String id)
	 {
	  Optional<PIZZA> piza = repository.findById(id);
	  
	  if (piza.isPresent())
	  {
	   return true;
	  }
	  else
	  {
	   return false;
	  }
	 }

}
