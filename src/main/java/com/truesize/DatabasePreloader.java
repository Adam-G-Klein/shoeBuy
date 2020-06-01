package com.truesize;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabasePreloader implements CommandLineRunner {
    
    @Autowired
    private AllShoeRepository allShoeRepository;
    @Autowired
    private AllUserRepository allUserRepository;

    // @Autowired
    // public DatabasePreloader(AllShoeRepository allShoeRepository, AllUserRepository allUserRepository){
    //     this.allShoeRepository = allShoeRepository;
    //     this.allUserRepository = allUserRepository;
    // }

    @Override
    public void run(String... strings) throws Exception{
        this.allUserRepository.save(new UserProfile("testemail@test.com", "password"));
        this.allUserRepository.save(new UserProfile("testemail2@test.com", "totallysecurepassword"));

        addTestGroup4();
        addTestGroup5();
        addHtmlData();
    }

    private void addTestGroup1(){
        //---Test Group 1: 2 nodes directly connected---
        ShoeNode testNode = new ShoeNode("KD8", "Nike", "m");
        ShoeNode testNode2 = new ShoeNode("KD9", "Nike", "m");
        testNode.addEdge(testNode2, 10.0, 12.0);
        this.allShoeRepository.save(testNode);
        this.allShoeRepository.save(testNode2);
    }

    private void addTestGroup2(){
        //---Test Group 2: 3 nodes, no cycles---
        ShoeNode t1a = new ShoeNode("T1A", "Adidas", "f", "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg");
        ShoeNode t2a = new ShoeNode("T2A", "Adidas", "f");
        ShoeNode t3a = new ShoeNode("T3A", "Adidas", "f");
        ShoeNode t4a = new ShoeNode("T4A", "Adidas", "f");

        t1a.addEdge(t2a, 10, 11);
        t1a.addEdge(t4a, 10, 11.5);

        t2a.addEdge(t3a, 12.5, 11);

        this.allShoeRepository.save(t1a);
        this.allShoeRepository.save(t2a);
        this.allShoeRepository.save(t3a);
        this.allShoeRepository.save(t4a);
    }

    private void addTestGroup3(){
        //---Test Group 3: 7 nodes, several cycles, size differences may not be consistent bc for test purposes---
        ShoeNode t1b = new ShoeNode("T1b", "Adidas", "f");
        ShoeNode t2b = new ShoeNode("T2b", "Adidas", "f");
        ShoeNode t3b = new ShoeNode("T3b", "Adidas", "f");
        ShoeNode t4b = new ShoeNode("T4b", "Adidas", "f");
        ShoeNode t5b = new ShoeNode("T5b", "Adidas", "f");
        ShoeNode t6b = new ShoeNode("T6b", "Adidas", "f");
        ShoeNode t7b = new ShoeNode("T7b", "Adidas", "f");

        t1b.addEdge(t2b, 10, 11);
        t1b.addEdge(t3b, 10, 10);
        t1b.addEdge(t4b, 11, 11.5);

        t2b.addEdge(t6b, 8.5, 9);

        t3b.addEdge(t5b, 12, 13);
        t3b.addEdge(t4b, 13, 19);

        t5b.addEdge(t7b, 12.5, 13);
        //t5b.addEdge(t1b, 0.5, false);

        t6b.addEdge(t5b, 10, 9.5);

        this.allShoeRepository.save(t1b);
        this.allShoeRepository.save(t2b);
        this.allShoeRepository.save(t3b);
        this.allShoeRepository.save(t4b);
        this.allShoeRepository.save(t5b);
        this.allShoeRepository.save(t6b);
        this.allShoeRepository.save(t7b);
    }
    private void addTestGroup4(){
        //---Test Group 4: testing edge changes when add multiple shoe nodes that increase edge's multiplicity---
        ShoeNode t1c = new ShoeNode("T1c", "Adidas", "f");
        ShoeNode t2c = new ShoeNode("T2c", "Adidas", "f");
        ShoeNode t3c = new ShoeNode("T3c", "Adidas", "f");
        
        t1c.addEdge(t2c, 10.0, 9.0);
        t1c.addEdge(t2c, 10.0, 9.5);

        t2c.addEdge(t3c, 9.0, 8.5);
        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }

    private void addTestGroup5(){
        ShoeNode t1c = new ShoeNode("KD9", "Nike", "u");
        ShoeNode t2c = new ShoeNode("KD3000", "Nike", "u");
        ShoeNode t3c = new ShoeNode("HotDog", "Nike", "u");

        this.allShoeRepository.save(t1c);
        this.allShoeRepository.save(t2c);
        this.allShoeRepository.save(t3c);
    }

    private void addHtmlData(){
        this.allShoeRepository.save(new ShoeNode("Air Zoom Pegasus 36", "Nike", "m", "https://m.media-amazon.com/images/I/71rsqtFGsbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Experience Run 9", "Nike", "m", "https://m.media-amazon.com/images/I/613Y8MbQ71L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Revolution 5", "Nike", "m", "https://m.media-amazon.com/images/I/716u178Oa4L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Monarch IV", "Nike", "m", "https://m.media-amazon.com/images/I/71FqsPmQebL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Pegasus 37", "Nike", "m", "https://m.media-amazon.com/images/I/81pwXw+UylL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Downshifter 10", "Nike", "m", "https://m.media-amazon.com/images/I/71-FgsRhl0L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Shox NZ EU", "Nike", "m", "https://m.media-amazon.com/images/I/816Ye2ay0uL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tanjun", "Nike", "m", "https://m.media-amazon.com/images/I/91FtCL8+3NL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Experience Run 9 SE", "Nike", "m", "https://m.media-amazon.com/images/I/71oUuIs3LvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Zoom Winflo 7", "Nike", "m", "https://m.media-amazon.com/images/I/81QZHFCp3bL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Run All Day 2", "Nike", "m", "https://m.media-amazon.com/images/I/71zR0X0mhYL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Run", "Nike", "m", "https://m.media-amazon.com/images/I/71NU7tKkJHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Precision IV NBK", "Nike", "m", "https://m.media-amazon.com/images/I/71qCUJKJkoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Precision IV", "Nike", "m", "https://m.media-amazon.com/images/I/81Lsgw-Mi9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Vintage", "Nike", "m", "https://m.media-amazon.com/images/I/71hJbAwIL8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Varsity Compete TR 3", "Nike", "m", "https://m.media-amazon.com/images/I/71dVvP00GDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("FlyEase Precision III", "Nike", "m", "https://m.media-amazon.com/images/I/71xT7fUh5sL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Lebron Witness IV", "Nike", "m", "https://m.media-amazon.com/images/I/71xywjiZ9JL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Terra Kiger 6", "Nike", "m", "https://m.media-amazon.com/images/I/71+jClAcWCL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Fusion", "Nike", "m", "https://m.media-amazon.com/images/I/71lQ-JMFhhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Free RN 5.0 2020", "Nike", "m", "https://m.media-amazon.com/images/I/71gExdp-xZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Motion 2", "Nike", "m", "https://m.media-amazon.com/images/I/71L2CRVUwsL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("NikeCourt Air Max Vapor Wing MS", "Nike", "m", "https://m.media-amazon.com/images/I/61e5-gEAJhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vapor Ultrafly 2 Keystone", "Nike", "m", "https://m.media-amazon.com/images/I/71FJUQRDCTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flyease Revolution 5", "Nike", "m", "https://m.media-amazon.com/images/I/71-LjSbVB8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Wildhorse 6", "Nike", "m", "https://m.media-amazon.com/images/I/71t+n4VSK2L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Structure 22", "Nike", "m", "https://m.media-amazon.com/images/I/71rBx9sWBSL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Kyrie Flytrap III", "Nike", "m", "https://m.media-amazon.com/images/I/71SmiDy0FnL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Royale AC", "Nike", "m", "https://m.media-amazon.com/images/I/71zvgJasKEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Method Trainer 2", "Nike", "m", "https://m.media-amazon.com/images/I/81+kDsBwaLL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Zoom Gravity", "Nike", "m", "https://m.media-amazon.com/images/I/713LbPdrEYL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Air Zoom Zero HC", "Nike", "m", "https://m.media-amazon.com/images/I/71Jz2GxezYL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("FlyEase Air Zoom Pegasus 35", "Nike", "m", "https://m.media-amazon.com/images/I/816q9wWjJjL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tiempo Legend 8 Club FG/MG", "Nike", "m", "https://m.media-amazon.com/images/I/71y9qDghoxL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Menace Varsity 2", "Nike", "m", "https://m.media-amazon.com/images/I/71FRIDr1P4L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Experience RN 9", "Nike", "m", "https://m.media-amazon.com/images/I/715LnTVj+dL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Fusion", "Nike", "m", "https://m.media-amazon.com/images/I/71S7ZCVV6OL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Superfly 7 Academy MDS FG/MG", "Nike", "m", "https://m.media-amazon.com/images/I/81665GPwjmL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Menace Pro 2 Mid", "Nike", "m", "https://m.media-amazon.com/images/I/71ubJIjPoBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Ride", "Nike", "m", "https://m.media-amazon.com/images/I/71CyPUcbLaL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Lite 2", "Nike", "m", "https://m.media-amazon.com/images/I/71LuoY54pML._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Joyride Dual Run", "Nike", "m", "https://m.media-amazon.com/images/I/71oka98d0QL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom VSN 2 Club DF IC", "Nike", "m", "https://m.media-amazon.com/images/I/81bcUmNIENL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Explore Strada", "Nike", "m", "https://m.media-amazon.com/images/I/71-zq1HwgpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Force Savage Shark 2", "Nike", "m", "https://m.media-amazon.com/images/I/61m2AKpVrfL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom VSN 2 Club DF TF", "Nike", "m", "https://m.media-amazon.com/images/I/819ikulxvUL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("NikeCourt Air Zoom Vapor Cage 4", "Nike", "m", "https://m.media-amazon.com/images/I/71EiirG5LaL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Downshifter 10 SE", "Nike", "m", "https://m.media-amazon.com/images/I/71eYV7ADi2L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Vapor X", "Nike", "m", "https://m.media-amazon.com/images/I/717XBO6I8+L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Pegasus 36", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81aIBxbhkfL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Motion 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71I-xG8MLgL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Vision Lo", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71d5TJ9++ZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Revolution 5", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71wOYfWdQBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Metcon Sport", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/7124RgycmdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Run", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71F-0bkplsL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Lebron Witness IV", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81PLMOGDPlL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Roshe One", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81i7GhzSCrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Ride", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71rssNitrbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache 7 Pro Turf Lax", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71Z9XfIXCQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Free RN 5.0", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71ZXuZspsnL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Vapor X", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71zfTZFiXPL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("React Infinity Run FK", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71wanUsBMOL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Cortez Leather", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81GF6Iex4mL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Todos", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71QVVZd+o1L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("NikeCourt Air Max Vapor Wing MS", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71BUG-QVCGL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Vision Mid", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/61JCZ9Zo3HL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("LD Victory", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/6161ORB1JWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Quest 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71SFRU2WXLL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Wildcard", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/711Y6fd733L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Alpha Savage", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71CLYpUXCIL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Alpha Trainer 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71d91-GDt-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend React 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/714ZcQj1EGL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Lite 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71qtr6likHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Fusion", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/712Uu6DsI3L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache Elite 2 Turf", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71SbOJr5r4L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Retaliation TR", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71UgnIgRDcL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Fly.By Mid NBK", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71pJv9CJDLL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Control 4", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71qhLPoEeSL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Terra Kiger 5", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71qjC1HwjsL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache Varsity Turf", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/61BxMqOb5WL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Downshifter 9", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81-KzRVPaJL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom Venom Club TF", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71Va9B4wSDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Varsity Compete TR 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71BkPJSd2CL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Force Air Trout 6 Pro", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71VhN3eDDmL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Force Trout 6 Pro MCS", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/7106gJPeJHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache Elite 2 Mid CS", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71S93DeBcoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Impact", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81J78rqNJWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Fly.By Mid", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71mb-EFgTvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flyease Revolution 5", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/711dRaZKOZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Run All Day 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71B14S7iw7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Contact 3", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71zXv0YCCEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Prestige", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/61CY8-11jQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Force Savage Shark 2", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/710xKx4MYpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Vomero 14", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71PpeukffTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Odyssey React 2 Shield", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71n7d0LMYxL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tanjun", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81u6r-aAxTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Quest 2 SE", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81uRbyWm0NL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("FlyEase Air Zoom Pegasus 36", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/81WG8n8l76L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache Varsity Low", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/61wkbRH7iQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Menace 2 Shark", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71S+IngR4iL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vapor 13 Pro TF", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71Td75gNpIL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flight Legacy", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/61DoECQHCwL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Alpha Huarache Elite 2 Mid", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71g+tb6UNZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend Trainer", "Nike", "m", "https://zycada-amzn.zappos.com/images/I/71+hFbZbGvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Mercurial Vapor 13 Academy FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71UyjoqiFVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Ride", "Nike", "f", "https://m.media-amazon.com/images/I/71LCqsf4qiL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Free RN 5.0", "Nike", "f", "https://m.media-amazon.com/images/I/71Mm8bCm1pL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("NikeCourt Air Max Vapor Wing MS", "Nike", "f", "https://m.media-amazon.com/images/I/71zcWWn2RjL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Superfly 7 Club FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71oJ3FHntrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom VSN 2 Academy DF FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71vWICKvqkL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Pegasus 36 Trail", "Nike", "f", "https://m.media-amazon.com/images/I/712afBHYWsL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Classic Cortez Leather", "Nike", "f", "https://m.media-amazon.com/images/I/61ZD0i7tR5L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("NikeCourt Air Zoom Vapor Cage 4", "Nike", "f", "https://m.media-amazon.com/images/I/71wFtIUpM-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Downshifter 10", "Nike", "f", "https://m.media-amazon.com/images/I/71U8YBCqjzL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Superfly 7 Academy FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71sOC-LU77L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Hyperdiamond 3 Keystone", "Nike", "f", "https://m.media-amazon.com/images/I/618j2jXfGOL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Run All Day 2", "Nike", "f", "https://m.media-amazon.com/images/I/81gWiIXobQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend Essential", "Nike", "f", "https://m.media-amazon.com/images/I/71ZBKijY-cL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Bella TR 3", "Nike", "f", "https://m.media-amazon.com/images/I/81liEyJhLyL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Quest 2", "Nike", "f", "https://m.media-amazon.com/images/I/71+BUOybD-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Oketo", "Nike", "f", "https://m.media-amazon.com/images/I/71cmvBQzQoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend 8 Academy TF", "Nike", "f", "https://m.media-amazon.com/images/I/71AUcnyvmJL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Free Metcon 2", "Nike", "f", "https://m.media-amazon.com/images/I/71l5I6fuVnL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vapor 13 Club FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71OqL7OoYrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Prestige", "Nike", "f", "https://m.media-amazon.com/images/I/71BBqQ2soBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Air Zoom Zero HC", "Nike", "f", "https://m.media-amazon.com/images/I/71llb9WSKdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Downshifter 9", "Nike", "f", "https://m.media-amazon.com/images/I/815N8ChbxxL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tiempo Legend 8 Club FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/71be9dJtiwL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Lite 2", "Nike", "f", "https://m.media-amazon.com/images/I/71yPQE78WXL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Roshe One", "Nike", "f", "https://m.media-amazon.com/images/I/81J81YOQ39L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Vomero 14", "Nike", "f", "https://m.media-amazon.com/images/I/71T6tWcmr7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tiempo Legend 8 Pro FG", "Nike", "f", "https://m.media-amazon.com/images/I/71+l0yQCElL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Structure 22", "Nike", "f", "https://m.media-amazon.com/images/I/71tvPgADMlL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Vision Mid", "Nike", "f", "https://m.media-amazon.com/images/I/71lSugdI97L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Heights", "Nike", "f", "https://m.media-amazon.com/images/I/71t5D2cPAwL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Zoom Vapor X", "Nike", "f", "https://m.media-amazon.com/images/I/71E9ABbymHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("React Hyperset", "Nike", "f", "https://m.media-amazon.com/images/I/71HLZW4JMyL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom Venom Club FG", "Nike", "f", "https://m.media-amazon.com/images/I/71zMDufCuTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Revolution 5", "Nike", "f", "https://m.media-amazon.com/images/I/71i4BEPr8nL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend React 2", "Nike", "f", "https://m.media-amazon.com/images/I/71FP+wiGyOL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Suplerfly 7 Pro FG", "Nike", "f", "https://m.media-amazon.com/images/I/711mxzqksaL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("FlyEase Air Precision II", "Nike", "f", "https://m.media-amazon.com/images/I/71Uov6p6cuL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Lunar Hyperdiamond 3 Pro", "Nike", "f", "https://m.media-amazon.com/images/I/71rRqv8Pv2L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Superfly 7 Academy TF", "Nike", "f", "https://m.media-amazon.com/images/I/71K+3yAqcDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Acalme", "Nike", "f", "https://m.media-amazon.com/images/I/712ZJtsprtL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Court Vision Low", "Nike", "f", "https://m.media-amazon.com/images/I/61hnp8czYKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend 8 Academy FG/MG", "Nike", "f", "https://m.media-amazon.com/images/I/61ptXdQ2seL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Tanjun", "Nike", "f", "https://m.media-amazon.com/images/I/71+n08kbogL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom Venom Club TF", "Nike", "f", "https://m.media-amazon.com/images/I/71Va9B4wSDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Phantom VSN 2 Academy DF TF", "Nike", "f", "https://m.media-amazon.com/images/I/71mvBvystKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Renew Run", "Nike", "f", "https://m.media-amazon.com/images/I/71rz4HveG9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Air Max Excee", "Nike", "f", "https://m.media-amazon.com/images/I/71-cajIgshL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Free RN 5.0 Shield", "Nike", "f", "https://m.media-amazon.com/images/I/71G+pfugniL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sideline IV", "Nike", "f", "https://m.media-amazon.com/images/I/71LvrTTwigL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flex Experience Run 9", "Nike", "f", "https://m.media-amazon.com/images/I/71G6QDowUUL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend 8 Pro TF", "Nike", "f", "https://m.media-amazon.com/images/I/71+jOtLEXDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Odyssey React 2 Shield", "Nike", "f", "https://m.media-amazon.com/images/I/71PrOLBZlRL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Legend React 2 Shield", "Nike", "f", "https://m.media-amazon.com/images/I/71haAuu34oL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Zoom HyperAce 2", "Nike", "f", "https://m.media-amazon.com/images/I/71U6E1JcQNL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Flare 2 HC", "Nike", "f", "https://m.media-amazon.com/images/I/71bwxJBBm6L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Premier II FG", "Nike", "f", "https://m.media-amazon.com/images/I/711zkh6Ne2L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("FlyEase Air Zoom Pegasus 36", "Nike", "f", "https://m.media-amazon.com/images/I/71sc3KnPaZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vapor 13 Pro TF", "Nike", "f", "https://m.media-amazon.com/images/I/71Td75gNpIL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Quest 2", "Nike", "f", "https://m.media-amazon.com/images/I/81iNmLyG6yL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Todos", "Nike", "f", "https://m.media-amazon.com/images/I/71cT1lwjfEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("React Hyperset", "Nike", "f", "https://m.media-amazon.com/images/I/71HkVWhL1-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Samba® Classic", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71937OFgeHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("GameCourt", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71UAt1ynIkL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Run The Game", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71CgLLGdmlL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Harden Stepback", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71m5I9evvEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Powerlift 4", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81hJv18sQBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SoleCourt", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61oHskwSp-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Adizero Ubersonic 3", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71W8FsOXu5L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("CourtJam Bounce", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71WkMUdYo9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa Mundial", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71D1gzYgU5L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Runfalcon", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71gWyeuvQ0L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Pro Model 2G", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71lsElghNeL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.4 Tf", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61U-6qnEQbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.4 Fxg", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61f5wOotmvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Own The Game", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71FjQr33AcL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Mundial Goal", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/813klMTqBgL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.4 In Sala", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71PmaKPCGbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Mundial Team", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81Fm2NjatrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Stycon", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81iSg0P+QvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Nemeziz 19.4 FxG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71mKlsjkpWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Afterburner 6 MD", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71p-pCevK7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("X 19.3 IN", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81I6c-WeKgL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.4 FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71J1u3sCYBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Nemeziz 19.4 IN", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71fKe170iDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.3 Fg", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71EDvNRY4tL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Icon V Bounce TPU", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71hKczPrqxL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Stycon Clay", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71pzizbpwDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.3 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71vday7cbFL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.4 IN", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71zlOIpPBVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SoleMatch Bounce", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71EMUVP47AL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 19.4 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71JhKH1KzCL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Speed Turf", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71DcMZUh1aL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Nemeziz 19.3 IN", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/715TxsFDjKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Goletto VII FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/717fJvTPOGL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.3 FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/717O34qXU7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.3 IN Sala", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71jCKQ67JhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Stycon M", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81+KvN2149L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.3 In", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71KH2nyBSqL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("X 19.2 FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71fn+SpyPrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Stabil Bounce", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81ip5UK4ncL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("X 19.4 IN", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61hWM-Um-DL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SoleMatch Bounce Clay", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81EzYxVMLML._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.2 Fg", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61mAuPUeQZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("X 19.4 FxG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71YzrIpmIvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 19.2 FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71U9708zIRL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Power Perfect III", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71bkVmoQ0OL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Nemeziz 19.3 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81ZVpGmCk3L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 20.3 Tf", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/61HM+BThhKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Icon V Turf", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81o4UoCrHbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 19.3 FG", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71Dg97Fw6LL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Predator 19.3 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71IqmzXFrxL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Afterburner 6", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71tBEW9zPnL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Copa 20.4 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71mMWb79xyL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Nemeziz 19.4 TF", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71pemmruX5L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Adizero Ubersonic 3 Clay", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/81nrEMLB-DL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("World Cup", "adidas", "m", "https://zycada-amzn.zappos.com/images/I/71vJGUMxILL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era Platform", "Vans", "m", "https://m.media-amazon.com/images/I/71TYM8zChAL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™", "Vans", "m", "https://m.media-amazon.com/images/I/71yX2m7ZRkL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Rowan Pro", "Vans", "m", "https://m.media-amazon.com/images/I/719a1xpiFAL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Kyle Walker Pro", "Vans", "m", "https://m.media-amazon.com/images/I/71edAT2RDQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush SK8-Hi", "Vans", "m", "https://m.media-amazon.com/images/I/713Ja3gfsrL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Rapidweld", "Vans", "m", "https://m.media-amazon.com/images/I/71bqeh2SvEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi Platform 2.0", "Vans", "m", "https://m.media-amazon.com/images/I/81IPyQPqypL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Style 36", "Vans", "m", "https://m.media-amazon.com/images/I/71Q2MhVw9zL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era 59", "Vans", "m", "https://m.media-amazon.com/images/I/71nTwASY8OL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Comfycush Old Skool", "Vans", "m", "https://m.media-amazon.com/images/I/717eC7-Jn3L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Half Cab™ Core Classics", "Vans", "m", "https://m.media-amazon.com/images/I/81M7PN2OsYL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Pro 2", "Vans", "m", "https://m.media-amazon.com/images/I/71XKv-ZqmyL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™", "Vans", "m", "https://m.media-amazon.com/images/I/71LTfnFXjdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™", "Vans", "m", "https://m.media-amazon.com/images/I/71VFhiAyduL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Berle Pro", "Vans", "m", "https://m.media-amazon.com/images/I/71tfZh3j4VL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Ferguson Pro", "Vans", "m", "https://m.media-amazon.com/images/I/71lGyXTFFgL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era Pro", "Vans", "m", "https://m.media-amazon.com/images/I/71Wba1Tnm6L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi Reissue", "Vans", "m", "https://m.media-amazon.com/images/I/71jvzMeXr6L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Authentic", "Vans", "m", "https://m.media-amazon.com/images/I/71oUYmvrmfL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Authentic SF", "Vans", "m", "https://m.media-amazon.com/images/I/71jQuSw8O7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic SF", "Vans", "m", "https://m.media-amazon.com/images/I/71hFo3enapL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Paradoxxx", "Vans", "m", "https://m.media-amazon.com/images/I/71IHsOykPJL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sport", "Vans", "m", "https://m.media-amazon.com/images/I/71HOFvTnQRL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™ Pro", "Vans", "m", "https://m.media-amazon.com/images/I/717Vfa5KibL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™", "Vans", "m", "https://m.media-amazon.com/images/I/71z5uGxBrAL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi 138 Decon SF", "Vans", "m", "https://m.media-amazon.com/images/I/71CjSHWtOZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Hi DL MTE", "Vans", "m", "https://m.media-amazon.com/images/I/710QEy2AGWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi 46 MTE DX", "Vans", "m", "https://m.media-amazon.com/images/I/71cuUgrwVfL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Zushi SF", "Vans", "m", "https://m.media-amazon.com/images/I/71uxRtSfNBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Style 36 Decon SF", "Vans", "m", "https://m.media-amazon.com/images/I/71JPtbWYw8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Bold Ni", "Vans", "m", "https://m.media-amazon.com/images/I/71-F5v4QicL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Era", "Vans", "m", "https://m.media-amazon.com/images/I/71GpKyEwAmL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi MTE", "Vans", "m", "https://m.media-amazon.com/images/I/71z86MPYV9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers Authentic™ UC", "Vans", "m", "https://m.media-amazon.com/images/I/71a6WYEDphL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™ TC", "Vans", "m", "https://m.media-amazon.com/images/I/71GCjW28oUL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Destruct SF", "Vans", "m", "https://m.media-amazon.com/images/I/71vALz+At9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi™ Tapered", "Vans", "m", "https://m.media-amazon.com/images/I/81B4YFKximL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vans x National Geographic Collab Shoes", "Vans", "m", "https://m.media-amazon.com/images/I/81J3ccXaYpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vans Sport", "Vans", "m", "https://m.media-amazon.com/images/I/71lgpu8+7hL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi Boot MTE 2.0 DX", "Vans", "m", "https://m.media-amazon.com/images/I/71dZW+GU-tL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi MTE 2.0 DX", "Vans", "m", "https://m.media-amazon.com/images/I/71KITA7sU6L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/61KTWfx9uoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81wYmk9m0EL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81w1BKwqwfL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81A9UAv9LoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era 59", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81FRhs55ZiL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81hRpYZ9CVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool Platform", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71EToQSFcBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/8149uzjPhbL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi Platform 2.0", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81WGuFMCRuL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Rapidweld", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81r0j2m0QmL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71t1mBK5F8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic Platform 2.0", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81glAZFyqQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™ Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81mw2uGk0PL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81EuKRbrTLL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange™ EXO", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/718TVrKDzaL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Comfycush Old Skool", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/713FMHqcM9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chukka Low", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81jydZV0eZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Ultrarange™ 3D", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/7129I21aCML._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71rxgzl45xL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™ Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71MUipk+c7L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Ferguson Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71zTl+7Fm-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Era", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71pozb5oITL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Rowan Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71YegDbwOpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi™ Pro BMX", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71AGvSzmx8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers Authentic™ UC", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/718Govjuh-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Kyle Walker Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81JPhJt-EkL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Gilbert Crockett Pro 2", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71TJZ1ZAWoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi™ Tapered", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71-qlmi7HtL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers Old Skool™ UC", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/61yzDcotlHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush SK8-Hi", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/61lFSbBknJL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi Slim™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81xA1sAmMVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Rowan Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/815g+igYGpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Pro 2", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71qwWPoCvHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Era", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71BDH+yA4NL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era 59", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/8161JH9FKiL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81OGepgd-qL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Kyle Walker Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71BcDmEoxjL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi™ Tapered", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71n58bdOgYL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71ShDBzmkhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™ Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81U6uPmlu9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81QddVD3VVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chukka Low", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/717-TXBmBHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81r7Y7e8fhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71VMDsNxYuL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush SK8-Hi", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/714oEDUsFKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic SF", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71rL7K8BszL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Authentic", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/711ud4NGH4L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sport", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81gMZ13De6L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Comfycush Old Skool", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71++bnjBGTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers SK8-Hi™ Reissue UC", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71vfDeja4lL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Rapidweld", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71-ZvcJrgtL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Gilbert Crockett Pro 2", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/717gKNKbviL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Ultrarange™ 3D", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71I8AZz2fPL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Style 36", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71ep66CnTdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Ave Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71PSOd3M+DL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™ Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71PG5iYVifL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vans x Autism Awareness Sneaker Collection", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71Xuq-7jIKL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange™ EXO", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71FGoCeBOmL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi Platform 2.0", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71IDeFLFBDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Half Cab™ Core Classics", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81KR0Ap8UhL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Zushi SF", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71GQHpXlHuL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool Pro", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71Jm6yvH5-L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™ TC", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/71zS+ZCdMsL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi 138 Decon SF", "Vans", "f", "https://zycada-amzn.zappos.com/images/I/81mKw1EGjqL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers Old Skool™ UC", "Vans", "f", "https://m.media-amazon.com/images/I/711xp-PvDpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic™", "Vans", "f", "https://m.media-amazon.com/images/I/81pVbGzmvWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi Boot MTE 2.0 DX", "Vans", "f", "https://m.media-amazon.com/images/I/71QXputC3tL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Bold Ni", "Vans", "f", "https://m.media-amazon.com/images/I/71M6U-497VL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era 59", "Vans", "f", "https://m.media-amazon.com/images/I/71Rj2BV-XSL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vans x National Geographic Collab Shoes", "Vans", "f", "https://m.media-amazon.com/images/I/71fgIJPXiIL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UA Authentic", "Vans", "f", "https://m.media-amazon.com/images/I/81-tKrRJhlL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Hi MTE 2.0 DX", "Vans", "f", "https://m.media-amazon.com/images/I/71ZQhJkdAjL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™ V", "Vans", "f", "https://m.media-amazon.com/images/I/81GRN922SQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™ Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71dzryreYSL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi™", "Vans", "f", "https://m.media-amazon.com/images/I/61iQVSvqbEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Vans Sport", "Vans", "f", "https://m.media-amazon.com/images/I/51EakX3E0pL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Classic Slip-On™", "Vans", "f", "https://m.media-amazon.com/images/I/81m7thkVLML._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Classic Slip-On™ Core Classics", "Vans", "f", "https://m.media-amazon.com/images/I/81GR33M9kQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Classic Slip-On Platform", "Vans", "f", "https://m.media-amazon.com/images/I/71Is6q2rY8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Mule SF", "Vans", "f", "https://m.media-amazon.com/images/I/71A3EhnP7jL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Slip-On SF", "Vans", "f", "https://m.media-amazon.com/images/I/71MN36BvCBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Slip-On SF", "Vans", "f", "https://m.media-amazon.com/images/I/71cNQAw+IXL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Slip-On Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71wVsvT3YEL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era SF", "Vans", "f", "https://m.media-amazon.com/images/I/71evRJYmheL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange™ EXO AC", "Vans", "f", "https://m.media-amazon.com/images/I/71U2TduUoXL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Slip-On ESP SF", "Vans", "f", "https://m.media-amazon.com/images/I/71HhXcoeb9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Slip-On EXP Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71cCl1eLBvL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Classic Slip-On", "Vans", "f", "https://m.media-amazon.com/images/I/61sEJFrvuoL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Made For The Makers Classic Slip-On™ UC", "Vans", "f", "https://m.media-amazon.com/images/I/712MCa4XZAL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Slip-On Platform ESP SF", "Vans", "f", "https://m.media-amazon.com/images/I/71e06f-Z0kL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool™", "Vans", "f", "https://m.media-amazon.com/images/I/81YuEMpgA+L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chukka Low", "Vans", "f", "https://m.media-amazon.com/images/I/91NyIAmpLWL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic Platform 2.0", "Vans", "f", "https://m.media-amazon.com/images/I/61wDTm0XZ9L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71CulI-OcDL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Ave Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71-Zr94YsBL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Rapidweld", "Vans", "f", "https://m.media-amazon.com/images/I/71fhBrhA3QL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Old Skool Platform", "Vans", "f", "https://m.media-amazon.com/images/I/71efJbnpOOL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("TNT Advanced Prototype", "Vans", "f", "https://m.media-amazon.com/images/I/71l9BURiSZL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Style 36 Decon SF", "Vans", "f", "https://m.media-amazon.com/images/I/71auAT-RtVL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era™", "Vans", "f", "https://m.media-amazon.com/images/I/714eNx5-BdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Era Platform", "Vans", "f", "https://m.media-amazon.com/images/I/81f7TNJO3DL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange™ EXO", "Vans", "f", "https://m.media-amazon.com/images/I/71u-8m5gvCL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("ComfyCush Authentic SF", "Vans", "f", "https://m.media-amazon.com/images/I/61sWeyEQhRL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Half Cab® Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71L+Yj2nf1L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Kyle Walker Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71M9SyMEMtL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Style 36", "Vans", "f", "https://m.media-amazon.com/images/I/71gBSHDlgTL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi 138 Decon SF", "Vans", "f", "https://m.media-amazon.com/images/I/81ffGRqIdwL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Authentic SF", "Vans", "f", "https://m.media-amazon.com/images/I/71uLJEKOYNL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Ultrarange™ 3D", "Vans", "f", "https://m.media-amazon.com/images/I/717cJxwdwcL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("UltraRange Hi DL MTE", "Vans", "f", "https://m.media-amazon.com/images/I/712EBZgYVHL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Pro 2", "Vans", "f", "https://m.media-amazon.com/images/I/71q-+3PBO8L._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sport", "Vans", "f", "https://m.media-amazon.com/images/I/61sBm4GgtpL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("SK8-Hi Platform 2.0", "Vans", "f", "https://m.media-amazon.com/images/I/81OPpBEwxdL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Sk8-Mid Pro", "Vans", "f", "https://m.media-amazon.com/images/I/81CM6i2klQL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Chima Ferguson Pro", "Vans", "f", "https://m.media-amazon.com/images/I/71V-h7T36bL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Gilbert Crockett Pro 2", "Vans", "f", "https://m.media-amazon.com/images/I/71j3IlvQVnL._AC_SX510_.jpg"));
        this.allShoeRepository.save(new ShoeNode("Paradoxxx", "Vans", "f", "https://m.media-amazon.com/images/I/713CTQ-heTL._AC_SX510_.jpg"));

    }

}
