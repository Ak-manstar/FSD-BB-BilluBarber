//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories
//class MongoVonfig extends AbstractMongoClientConfiguration {
//
//    @Override
//    protected String getDatabaseName() {
//        return "e-store";
//    }
//
////    @Override
////    public MongoClient mongo() throws Exception {
////        return new MongoClient();
////    }
//
//    public MongoClient mongoClient() {
//        return this.createMongoClient(this.mongoClientSettings());
//    }
//
//    @Override
//    protected String getMappingBasePackage() {
//        return "com.oreilly.springdata.mongodb"
//    }
//}