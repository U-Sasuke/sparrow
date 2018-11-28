package priv.yq.sparrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.yq.sparrow.entity.User;

/**
 * Created by yaoqing on 2018/11/28.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByPhone(String phone);

}
