package org.group.dcost.seeder;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.group.dcost.entity.MstDigitalPayment;
import org.group.dcost.entity.UserSubscribe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);

        if(!mongoTemplate.collectionExists("mst_digital_payment")) {
            mongoTemplate.dropCollection("user_subscribe");
            MstDigitalPayment document1 = new MstDigitalPayment(
                    new ObjectId().toHexString(),
                    "4a9364ae-099a-4153-8495-bdf8ba5c5054",
                            "dana"

            );
            MstDigitalPayment document2 = new MstDigitalPayment(
                    new ObjectId().toHexString(),
                    "c3e72789-906a-4b93-9874-afd3b129d900",
                    "gopay"

            );
            MstDigitalPayment document3 = new MstDigitalPayment(
                    new ObjectId().toHexString(),
                    "81b8e597-340c-4e54-ac32-7099e2e6654e",
                    "shopee"

            );
            mongoTemplate.insert(Arrays.asList(document1, document2,document3),"mst_digital_payment");
        }

        if(!mongoTemplate.collectionExists("user_subscribe")) {
            mongoTemplate.dropCollection("user_subscribe");
            UserSubscribe document1 = new UserSubscribe(
                    new ObjectId().toHexString(),
                    "49b7a371-a487-4fdb-b0d2-4ceb58656f1c",
                    "ecb6cd26-cc21-4c7d-aecd-e1cae2d99d62",
                    "dana",
                    10000,
                    1000000,
                    12000000,
                    formattedDate,
                    true,
                    "",
                    "",
                    ""
            );
            UserSubscribe document2 = new UserSubscribe(
                    new ObjectId().toHexString(),
                    "49b7a371-a487-4fdb-b0d2-4ceb58656f1c",
                    "1095eb1c-8611-49e5-a582-054c8037aaae",
                    "gopay",
                    10000,
                    1000000,
                    12000000,
                    formattedDate,
                    true,
                    "",
                    "",
                    ""
            );
            UserSubscribe document3 = new UserSubscribe(
                    new ObjectId().toHexString(),
                    "49b7a371-a487-4fdb-b0d2-4ceb58656f1c",
                    "63279f87-a860-40d1-ad1d-2b298958b84b",
                    "shopee",
                    10000,
                    1000000,
                    12000000,
                    formattedDate,
                    true,
                    "",
                    "",
                    ""
            );
            mongoTemplate.insert(Arrays.asList(document1, document2,document3),"user_subscribe");
        }
    }
}
