package PIZZAManage.PIZZAManage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class PIZZARepositoryImpl implements PIZZARepositoryCustom {
	
	@Autowired
	PIZZARepository repository;

	@Override
	public List<PIZZA> findAllByeName(String product) {
		
		List<PIZZA> prod= new ArrayList<PIZZA>();
		List<PIZZA> pizza= repository.findAll();
		
		for (PIZZA Items: pizza)
			if(Items.getProduct().equalsIgnoreCase(product))
					{
				prod.add(Items);
					}
		
		return prod;
	}

}
