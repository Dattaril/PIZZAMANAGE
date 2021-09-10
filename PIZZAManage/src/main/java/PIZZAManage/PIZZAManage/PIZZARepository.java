package PIZZAManage.PIZZAManage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PIZZARepository  extends JpaRepository<PIZZA, String> ,PIZZARepositoryCustom

{

}
