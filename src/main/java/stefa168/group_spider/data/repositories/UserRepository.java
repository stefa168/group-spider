package stefa168.group_spider.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stefa168.group_spider.data.model.TelegramUser;

public interface UserRepository extends JpaRepository<TelegramUser, Long> {

}