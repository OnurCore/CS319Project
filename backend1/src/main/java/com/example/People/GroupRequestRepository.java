import org.springframework.data.jpa.repository.JpaRepository;
import com.example.People.*;
import java.util.List;
interface GroupRequestRepository extends JpaRepository<GroupRequest, Long>{
	List<GroupRequest> findByGroupOrderByDate(Group group);
	List<GroupRequest> findByStudentOrderByDate(People student);
}