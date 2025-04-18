package org.group.dcost.repo;


import org.group.dcost.entity.UserSubscribe;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSubscribeRepository extends MongoRepository<UserSubscribe, String> {
    Optional<UserSubscribe> findByDigitalPaymentId(
            String digitalPaymentId);
    Optional<UserSubscribe> findByCurrentDateAndDigitalPaymentId(
            String currentDate,String
            digitalPaymentId);
   @Cacheable(value = "userSubscribe",key="#userId")
   Page<UserSubscribe> findAllByUserId(String userId, Pageable pageable);

}


