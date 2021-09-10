package PIZZAManage.PIZZAManage;

import java.util.List;


public interface PIZZARepositoryCustom {
	
	//we are creating one user defined INterface
	
	
		List<PIZZA> findAllByeName(String product);

}
