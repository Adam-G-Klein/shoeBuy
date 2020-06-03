package com.truesize;

import com.truesize.shoegraph.AllShoeRepository;
import com.truesize.shoegraph.ShoeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabasePreloader implements CommandLineRunner {

    private static final String ADIDAS = "ADIDAS";
    private static final String F = "f";

    @Autowired
    private AllShoeRepository allShoeRepository;
    @Autowired
    private AllUserRepository allUserRepository;

    private List<String> htmlData = new ArrayList<>();

    @Override
    public void run(String... strings) throws Exception{
        this.allUserRepository.save(new UserProfile("testemail@test.com", "password"));
        this.allUserRepository.save(new UserProfile("testemail2@test.com", "totallysecurepassword"));

        addTestGroup1();
        addTestGroup2();
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
        ShoeNode t1a = new ShoeNode("T1A", ADIDAS, F, "https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/zc5x1xceepbszkhwprvn/joyride-run-flyknit-mens-running-shoe-PjmR5M.jpg");
        ShoeNode t2a = new ShoeNode("T2A", ADIDAS, F);
        ShoeNode t3a = new ShoeNode("T3A", ADIDAS, F);
        ShoeNode t4a = new ShoeNode("T4A", ADIDAS, F);

        t1a.addEdge(t2a, 10, 11);
        t1a.addEdge(t4a, 10, 11.5);

        t2a.addEdge(t3a, 12.5, 11);

        this.allShoeRepository.save(t1a);
        this.allShoeRepository.save(t2a);
        this.allShoeRepository.save(t3a);
        this.allShoeRepository.save(t4a);
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

        htmlData.add("Air Zoom Pegasus 36,Nike,m,https://m.media-amazon.com/images/I/71rsqtFGsbL._AC_SX510_.jpg");
        htmlData.add("Flex Experience Run 9,Nike,m,https://m.media-amazon.com/images/I/613Y8MbQ71L._AC_SX510_.jpg");
        htmlData.add("Revolution 5,Nike,m,https://m.media-amazon.com/images/I/716u178Oa4L._AC_SX510_.jpg");
        htmlData.add("Air Monarch IV,Nike,m,https://m.media-amazon.com/images/I/71FqsPmQebL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 37,Nike,m,https://m.media-amazon.com/images/I/81pwXw+UylL._AC_SX510_.jpg");
        htmlData.add("Downshifter 10,Nike,m,https://m.media-amazon.com/images/I/71-FgsRhl0L._AC_SX510_.jpg");
        htmlData.add("Shox NZ EU,Nike,m,https://m.media-amazon.com/images/I/816Ye2ay0uL._AC_SX510_.jpg");
        htmlData.add("Tanjun,Nike,m,https://m.media-amazon.com/images/I/91FtCL8+3NL._AC_SX510_.jpg");
        htmlData.add("Flex Experience Run 9 SE,Nike,m,https://m.media-amazon.com/images/I/71oUuIs3LvL._AC_SX510_.jpg");
        htmlData.add("Zoom Winflo 7,Nike,m,https://m.media-amazon.com/images/I/81QZHFCp3bL._AC_SX510_.jpg");
        htmlData.add("Run All Day 2,Nike,m,https://m.media-amazon.com/images/I/71zR0X0mhYL._AC_SX510_.jpg");
        htmlData.add("Renew Run,Nike,m,https://m.media-amazon.com/images/I/71NU7tKkJHL._AC_SX510_.jpg");
        htmlData.add("Precision IV NBK,Nike,m,https://m.media-amazon.com/images/I/71qCUJKJkoL._AC_SX510_.jpg");
        htmlData.add("Precision IV,Nike,m,https://m.media-amazon.com/images/I/81Lsgw-Mi9L._AC_SX510_.jpg");
        htmlData.add("Court Vintage,Nike,m,https://m.media-amazon.com/images/I/71hJbAwIL8L._AC_SX510_.jpg");
        htmlData.add("Lebron Witness IV,Nike,m,https://m.media-amazon.com/images/I/71xywjiZ9JL._AC_SX510_.jpg");
        htmlData.add("FlyEase Precision III,Nike,m,https://m.media-amazon.com/images/I/71xT7fUh5sL._AC_SX510_.jpg");
        htmlData.add("Varsity Compete TR 3,Nike,m,https://m.media-amazon.com/images/I/71dVvP00GDL._AC_SX510_.jpg");
        htmlData.add("Renew Fusion,Nike,m,https://m.media-amazon.com/images/I/71lQ-JMFhhL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Terra Kiger 6,Nike,m,https://m.media-amazon.com/images/I/71+jClAcWCL._AC_SX510_.jpg");
        htmlData.add("Free RN 5.0 2020,Nike,m,https://m.media-amazon.com/images/I/71Lhcnw9oBL._AC_SX510_.jpg");
        htmlData.add("Air Max Motion 2,Nike,m,https://m.media-amazon.com/images/I/71L2CRVUwsL._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Max Vapor Wing MS,Nike,m,https://m.media-amazon.com/images/I/61e5-gEAJhL._AC_SX510_.jpg");
        htmlData.add("Flyease Revolution 5,Nike,m,https://m.media-amazon.com/images/I/71-LjSbVB8L._AC_SX510_.jpg");
        htmlData.add("Vapor Ultrafly 2 Keystone,Nike,m,https://m.media-amazon.com/images/I/71FJUQRDCTL._AC_SX510_.jpg");
        htmlData.add("Wildhorse 6,Nike,m,https://m.media-amazon.com/images/I/71t+n4VSK2L._AC_SX510_.jpg");
        htmlData.add("Kyrie Flytrap III,Nike,m,https://m.media-amazon.com/images/I/71SmiDy0FnL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Structure 22,Nike,m,https://m.media-amazon.com/images/I/71rBx9sWBSL._AC_SX510_.jpg");
        htmlData.add("Court Royale AC,Nike,m,https://m.media-amazon.com/images/I/71zvgJasKEL._AC_SX510_.jpg");
        htmlData.add("Zoom Gravity,Nike,m,https://m.media-amazon.com/images/I/713LbPdrEYL._AC_SX510_.jpg");
        htmlData.add("Court Air Zoom Zero HC,Nike,m,https://m.media-amazon.com/images/I/71Jz2GxezYL._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Zoom Pegasus 35,Nike,m,https://m.media-amazon.com/images/I/816q9wWjJjL._AC_SX510_.jpg");
        htmlData.add("Method Trainer 2,Nike,m,https://m.media-amazon.com/images/I/81+kDsBwaLL._AC_SX510_.jpg");
        htmlData.add("Tiempo Legend 8 Club FG/MG,Nike,m,https://m.media-amazon.com/images/I/71y9qDghoxL._AC_SX510_.jpg");
        htmlData.add("Alpha Menace Varsity 2,Nike,m,https://m.media-amazon.com/images/I/71FRIDr1P4L._AC_SX510_.jpg");
        htmlData.add("Flex Experience RN 9,Nike,m,https://m.media-amazon.com/images/I/715LnTVj+dL._AC_SX510_.jpg");
        htmlData.add("Air Max Fusion,Nike,m,https://m.media-amazon.com/images/I/71S7ZCVV6OL._AC_SX510_.jpg");
        htmlData.add("Superfly 7 Academy MDS FG/MG,Nike,m,https://m.media-amazon.com/images/I/81665GPwjmL._AC_SX510_.jpg");
        htmlData.add("Renew Ride,Nike,m,https://m.media-amazon.com/images/I/71tpjhbQoML._AC_SX510_.jpg");
        htmlData.add("Alpha Menace Pro 2 Mid,Nike,m,https://m.media-amazon.com/images/I/71ubJIjPoBL._AC_SX510_.jpg");
        htmlData.add("Joyride Dual Run,Nike,m,https://m.media-amazon.com/images/I/71oka98d0QL._AC_SX510_.jpg");
        htmlData.add("Force Savage Shark 2,Nike,m,https://m.media-amazon.com/images/I/61m2AKpVrfL._AC_SX510_.jpg");
        htmlData.add("Court Lite 2,Nike,m,https://m.media-amazon.com/images/I/71LuoY54pML._AC_SX510_.jpg");
        htmlData.add("Explore Strada,Nike,m,https://m.media-amazon.com/images/I/71-zq1HwgpL._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Zoom Vapor Cage 4,Nike,m,https://m.media-amazon.com/images/I/71EiirG5LaL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF IC,Nike,m,https://m.media-amazon.com/images/I/81bcUmNIENL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF TF,Nike,m,https://m.media-amazon.com/images/I/819ikulxvUL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF FG/MG,Nike,m,https://m.media-amazon.com/images/I/71FBugTDkIL._AC_SX510_.jpg");
        htmlData.add("Mercurial Vapor 13 Academy FG/MG,Nike,m,https://m.media-amazon.com/images/I/71UyjoqiFVL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 36,Nike,m,https://m.media-amazon.com/images/I/81aIBxbhkfL._AC_SX510_.jpg");
        htmlData.add("Air Max Motion 2,Nike,m,https://m.media-amazon.com/images/I/71I-xG8MLgL._AC_SX510_.jpg");
        htmlData.add("Court Vision Lo,Nike,m,https://m.media-amazon.com/images/I/71d5TJ9++ZL._AC_SX510_.jpg");
        htmlData.add("Revolution 5,Nike,m,https://m.media-amazon.com/images/I/71wOYfWdQBL._AC_SX510_.jpg");
        htmlData.add("Metcon Sport,Nike,m,https://m.media-amazon.com/images/I/7124RgycmdL._AC_SX510_.jpg");
        htmlData.add("Renew Run,Nike,m,https://m.media-amazon.com/images/I/71F-0bkplsL._AC_SX510_.jpg");
        htmlData.add("Lebron Witness IV,Nike,m,https://m.media-amazon.com/images/I/81PLMOGDPlL._AC_SX510_.jpg");
        htmlData.add("Roshe One,Nike,m,https://m.media-amazon.com/images/I/81i7GhzSCrL._AC_SX510_.jpg");
        htmlData.add("Renew Ride,Nike,m,https://m.media-amazon.com/images/I/71rssNitrbL._AC_SX510_.jpg");
        htmlData.add("React Infinity Run FK,Nike,m,https://m.media-amazon.com/images/I/71wanUsBMOL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vapor X,Nike,m,https://m.media-amazon.com/images/I/71zfTZFiXPL._AC_SX510_.jpg");
        htmlData.add("Free RN 5.0,Nike,m,https://m.media-amazon.com/images/I/71ZXuZspsnL._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache 7 Pro Turf Lax,Nike,m,https://m.media-amazon.com/images/I/71Z9XfIXCQL._AC_SX510_.jpg");
        htmlData.add("Cortez Leather,Nike,m,https://m.media-amazon.com/images/I/81GF6Iex4mL._AC_SX510_.jpg");
        htmlData.add("Todos,Nike,m,https://m.media-amazon.com/images/I/71QVVZd+o1L._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Max Vapor Wing MS,Nike,m,https://m.media-amazon.com/images/I/71BUG-QVCGL._AC_SX510_.jpg");
        htmlData.add("Court Vision Mid,Nike,m,https://m.media-amazon.com/images/I/61JCZ9Zo3HL._AC_SX510_.jpg");
        htmlData.add("LD Victory,Nike,m,https://m.media-amazon.com/images/I/6161ORB1JWL._AC_SX510_.jpg");
        htmlData.add("Quest 2,Nike,m,https://m.media-amazon.com/images/I/71SFRU2WXLL._AC_SX510_.jpg");
        htmlData.add("Air Max Wildcard,Nike,m,https://m.media-amazon.com/images/I/711Y6fd733L._AC_SX510_.jpg");
        htmlData.add("Air Max Alpha Savage,Nike,m,https://m.media-amazon.com/images/I/71CLYpUXCIL._AC_SX510_.jpg");
        htmlData.add("Air Max Alpha Trainer 2,Nike,m,https://m.media-amazon.com/images/I/71d91-GDt-L._AC_SX510_.jpg");
        htmlData.add("Legend React 2,Nike,m,https://m.media-amazon.com/images/I/714ZcQj1EGL._AC_SX510_.jpg");
        htmlData.add("Court Lite 2,Nike,m,https://m.media-amazon.com/images/I/71qtr6likHL._AC_SX510_.jpg");
        htmlData.add("Renew Fusion,Nike,m,https://m.media-amazon.com/images/I/712Uu6DsI3L._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache Elite 2 Turf,Nike,m,https://m.media-amazon.com/images/I/71SbOJr5r4L._AC_SX510_.jpg");
        htmlData.add("Renew Retaliation TR,Nike,m,https://m.media-amazon.com/images/I/71UgnIgRDcL._AC_SX510_.jpg");
        htmlData.add("Fly.By Mid NBK,Nike,m,https://m.media-amazon.com/images/I/71pJv9CJDLL._AC_SX510_.jpg");
        htmlData.add("Flex Control 4,Nike,m,https://m.media-amazon.com/images/I/71qhLPoEeSL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Terra Kiger 5,Nike,m,https://m.media-amazon.com/images/I/71qjC1HwjsL._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache Varsity Turf,Nike,m,https://m.media-amazon.com/images/I/61BxMqOb5WL._AC_SX510_.jpg");
        htmlData.add("Varsity Compete TR 2,Nike,m,https://m.media-amazon.com/images/I/71BkPJSd2CL._AC_SX510_.jpg");
        htmlData.add("Run All Day 2,Nike,m,https://m.media-amazon.com/images/I/71B14S7iw7L._AC_SX510_.jpg");
        htmlData.add("Downshifter 9,Nike,m,https://m.media-amazon.com/images/I/717GZ3gveTL._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache Elite 2 Mid CS,Nike,m,https://m.media-amazon.com/images/I/71S93DeBcoL._AC_SX510_.jpg");
        htmlData.add("Fly.By Mid,Nike,m,https://m.media-amazon.com/images/I/71mb-EFgTvL._AC_SX510_.jpg");
        htmlData.add("Air Max Impact,Nike,m,https://m.media-amazon.com/images/I/81J78rqNJWL._AC_SX510_.jpg");
        htmlData.add("Force Air Trout 6 Pro,Nike,m,https://m.media-amazon.com/images/I/71VhN3eDDmL._AC_SX510_.jpg");
        htmlData.add("Force Trout 6 Pro MCS,Nike,m,https://m.media-amazon.com/images/I/7106gJPeJHL._AC_SX510_.jpg");
        htmlData.add("Phantom Venom Club TF,Nike,m,https://m.media-amazon.com/images/I/71Va9B4wSDL._AC_SX510_.jpg");
        htmlData.add("Flyease Revolution 5,Nike,m,https://m.media-amazon.com/images/I/711dRaZKOZL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Prestige,Nike,m,https://m.media-amazon.com/images/I/61CY8-11jQL._AC_SX510_.jpg");
        htmlData.add("Tanjun,Nike,m,https://m.media-amazon.com/images/I/81u6r-aAxTL._AC_SX510_.jpg");
        htmlData.add("Flex Contact 3,Nike,m,https://m.media-amazon.com/images/I/71zXv0YCCEL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vomero 14,Nike,m,https://m.media-amazon.com/images/I/71PpeukffTL._AC_SX510_.jpg");
        htmlData.add("Force Savage Shark 2,Nike,m,https://m.media-amazon.com/images/I/710xKx4MYpL._AC_SX510_.jpg");
        htmlData.add("Odyssey React 2 Shield,Nike,m,https://m.media-amazon.com/images/I/71n7d0LMYxL._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Zoom Pegasus 36,Nike,m,https://m.media-amazon.com/images/I/81WG8n8l76L._AC_SX510_.jpg");
        htmlData.add("Quest 2 SE,Nike,m,https://m.media-amazon.com/images/I/81uRbyWm0NL._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache Varsity Low,Nike,m,https://m.media-amazon.com/images/I/61wkbRH7iQL._AC_SX510_.jpg");
        htmlData.add("Alpha Huarache Elite 2 Mid,Nike,m,https://m.media-amazon.com/images/I/71g+tb6UNZL._AC_SX510_.jpg");
        htmlData.add("Alpha Menace 2 Shark,Nike,m,https://m.media-amazon.com/images/I/71S+IngR4iL._AC_SX510_.jpg");
        htmlData.add("Legend Trainer,Nike,m,https://m.media-amazon.com/images/I/71+hFbZbGvL._AC_SX510_.jpg");
        htmlData.add("Vapor 13 Pro TF,Nike,m,https://m.media-amazon.com/images/I/71Td75gNpIL._AC_SX510_.jpg");
        htmlData.add("Classic Cortez Leather,Nike,f,https://zycada-amzn.zappos.com/images/I/61i0E2NcvxL._AC_SX510_.jpg");
        htmlData.add("Air Max Bella TR 3 AMP,Nike,f,https://zycada-amzn.zappos.com/images/I/7178nKnL8QL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 36,Nike,f,https://zycada-amzn.zappos.com/images/I/712wF07w-ML._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 37,Nike,f,https://zycada-amzn.zappos.com/images/I/71su1uFuMbL._AC_SX510_.jpg");
        htmlData.add("Court Royale AC,Nike,f,https://zycada-amzn.zappos.com/images/I/71jFFpoYA9L._AC_SX510_.jpg");
        htmlData.add("Tanjun,Nike,f,https://zycada-amzn.zappos.com/images/I/91M7X1MRzZL._AC_SX510_.jpg");
        htmlData.add("Flex Experience Run 9,Nike,f,https://zycada-amzn.zappos.com/images/I/71BBc-s-1NL._AC_SX510_.jpg");
        htmlData.add("Revolution 5,Nike,f,https://zycada-amzn.zappos.com/images/I/715DN7unuwL._AC_SX510_.jpg");
        htmlData.add("Court Royale AC Canvas,Nike,f,https://zycada-amzn.zappos.com/images/I/61pa3WMSf+L._AC_SX510_.jpg");
        htmlData.add("Court Vision Low,Nike,f,https://zycada-amzn.zappos.com/images/I/71fp1IkO41L._AC_SX510_.jpg");
        htmlData.add("Zoom Winflo 7,Nike,f,https://zycada-amzn.zappos.com/images/I/71mkBUIpdaL._AC_SX510_.jpg");
        htmlData.add("Court Lite 2,Nike,f,https://zycada-amzn.zappos.com/images/I/71xHWramr8L._AC_SX510_.jpg");
        htmlData.add("Run All Day 2,Nike,f,https://zycada-amzn.zappos.com/images/I/71d-b5pFaaL._AC_SX510_.jpg");
        htmlData.add("Renew Run,Nike,f,https://zycada-amzn.zappos.com/images/I/710tzJmaGvL._AC_SX510_.jpg");
        htmlData.add("Precision IV NBK,Nike,f,https://zycada-amzn.zappos.com/images/I/71qCUJKJkoL._AC_SX510_.jpg");
        htmlData.add("Air Max Bella TR 3,Nike,f,https://zycada-amzn.zappos.com/images/I/71To0M-JySL._AC_SX510_.jpg");
        htmlData.add("Precision IV,Nike,f,https://zycada-amzn.zappos.com/images/I/81Lsgw-Mi9L._AC_SX510_.jpg");
        htmlData.add("Run All Day 2 SE,Nike,f,https://zycada-amzn.zappos.com/images/I/81xHlflSbeL._AC_SX510_.jpg");
        htmlData.add("Flex Experience RN 8,Nike,f,https://zycada-amzn.zappos.com/images/I/71kj0LXAarL._AC_SX510_.jpg");
        htmlData.add("Renew Ride,Nike,f,https://zycada-amzn.zappos.com/images/I/71jZia5jCUL._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Zoom Pegasus 36,Nike,f,https://zycada-amzn.zappos.com/images/I/715ECOn9AbL._AC_SX510_.jpg");
        htmlData.add("Downshifter 10,Nike,f,https://zycada-amzn.zappos.com/images/I/71xBFi+hKPL._AC_SX510_.jpg");
        htmlData.add("Joyride Dual Run,Nike,f,https://zycada-amzn.zappos.com/images/I/71m8Qyz1AlL._AC_SX510_.jpg");
        htmlData.add("Flex TR 9,Nike,f,https://zycada-amzn.zappos.com/images/I/71yK-zGmFTL._AC_SX510_.jpg");
        htmlData.add("Zoom HyperAce 2,Nike,f,https://zycada-amzn.zappos.com/images/I/71-OoYheu-L._AC_SX510_.jpg");
        htmlData.add("React Infinity Run FK,Nike,f,https://zycada-amzn.zappos.com/images/I/71fOb5bY6JL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vomero 14,Nike,f,https://zycada-amzn.zappos.com/images/I/81xENpzSv9L._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Zoom Pegasus 35,Nike,f,https://zycada-amzn.zappos.com/images/I/81ArjCcZ3VL._AC_SX510_.jpg");
        htmlData.add("Free RN 5.0 2020,Nike,f,https://zycada-amzn.zappos.com/images/I/act71T8BwoRg1L._AC_SX510_.jpg");
        htmlData.add("Air Zoom Prestige,Nike,f,https://zycada-amzn.zappos.com/images/I/71dvtz28UZL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 36 Shield,Nike,f,https://zycada-amzn.zappos.com/images/I/71oy+1tThgL._AC_SX510_.jpg");
        htmlData.add("Tiempo Legend 8 Club FG/MG,Nike,f,https://zycada-amzn.zappos.com/images/I/71y9qDghoxL._AC_SX510_.jpg");
        htmlData.add("Hyperdiamond 3 Keystone,Nike,f,https://zycada-amzn.zappos.com/images/I/71yqFuSzdhL._AC_SX510_.jpg");
        htmlData.add("Air Heights,Nike,f,https://zycada-amzn.zappos.com/images/I/810we-2zrIL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vapor X,Nike,f,https://zycada-amzn.zappos.com/images/I/71mvcMn2+OL._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Max Vapor Wing MS,Nike,f,https://zycada-amzn.zappos.com/images/I/615KNquhe0L._AC_SX510_.jpg");
        htmlData.add("Flare 2 HC,Nike,f,https://zycada-amzn.zappos.com/images/I/718iYtd4utL._AC_SX510_.jpg");
        htmlData.add("Court Vision Mid,Nike,f,https://zycada-amzn.zappos.com/images/I/71hJM8H5LUL._AC_SX510_.jpg");
        htmlData.add("Wildhorse 6,Nike,f,https://zycada-amzn.zappos.com/images/I/71Vk8XKMSuL._AC_SX510_.jpg");
        htmlData.add("Air Max Bella TR 2,Nike,f,https://zycada-amzn.zappos.com/images/I/71EHIx3aWZL._AC_SX510_.jpg");
        htmlData.add("Superfly 7 Academy MDS FG/MG,Nike,f,https://zycada-amzn.zappos.com/images/I/81665GPwjmL._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Zoom Vapor Cage 4,Nike,f,https://zycada-amzn.zappos.com/images/I/71ZaU7jAFwL._AC_SX510_.jpg");
        htmlData.add("Flex 2019 RN,Nike,f,https://zycada-amzn.zappos.com/images/I/71D1jd8Bk-L._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF IC,Nike,f,https://zycada-amzn.zappos.com/images/I/81bcUmNIENL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF TF,Nike,f,https://zycada-amzn.zappos.com/images/I/819ikulxvUL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Terra Kiger 6,Nike,f,https://zycada-amzn.zappos.com/images/I/71hb73HAWLL._AC_SX510_.jpg");
        htmlData.add("Court Vintage,Nike,f,https://zycada-amzn.zappos.com/images/I/613fVZZ528L._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Club DF FG/MG,Nike,f,https://zycada-amzn.zappos.com/images/I/71FBugTDkIL._AC_SX510_.jpg");
        htmlData.add("Flex Contact 3,Nike,f,https://zycada-amzn.zappos.com/images/I/714b67om0fL._AC_SX510_.jpg");
        htmlData.add("Mercurial Vapor 13 Academy FG/MG,Nike,f,https://zycada-amzn.zappos.com/images/I/71UyjoqiFVL._AC_SX510_.jpg");
        htmlData.add("Zoom Gravity,Nike,f,https://zycada-amzn.zappos.com/images/I/81uA2igvMfL._AC_SX510_.jpg");
        htmlData.add("Flex Experience Run 9,Nike,f,https://m.media-amazon.com/images/I/71ZvJdhzXOL._AC_SX510_.jpg");
        htmlData.add("Free RN 5.0,Nike,f,https://m.media-amazon.com/images/I/71Mm8bCm1pL._AC_SX510_.jpg");
        htmlData.add("Renew Ride,Nike,f,https://m.media-amazon.com/images/I/71LCqsf4qiL._AC_SX510_.jpg");
        htmlData.add("Superfly 7 Club FG/MG,Nike,f,https://m.media-amazon.com/images/I/71oJ3FHntrL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Pegasus 36 Trail,Nike,f,https://m.media-amazon.com/images/I/712afBHYWsL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Academy DF FG/MG,Nike,f,https://m.media-amazon.com/images/I/71vWICKvqkL._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Max Vapor Wing MS,Nike,f,https://m.media-amazon.com/images/I/71zcWWn2RjL._AC_SX510_.jpg");
        htmlData.add("Classic Cortez Leather,Nike,f,https://m.media-amazon.com/images/I/61ZD0i7tR5L._AC_SX510_.jpg");
        htmlData.add("NikeCourt Air Zoom Vapor Cage 4,Nike,f,https://m.media-amazon.com/images/I/71wFtIUpM-L._AC_SX510_.jpg");
        htmlData.add("Downshifter 10,Nike,f,https://m.media-amazon.com/images/I/71U8YBCqjzL._AC_SX510_.jpg");
        htmlData.add("Legend Essential,Nike,f,https://m.media-amazon.com/images/I/71ZBKijY-cL._AC_SX510_.jpg");
        htmlData.add("Superfly 7 Academy FG/MG,Nike,f,https://m.media-amazon.com/images/I/71sOC-LU77L._AC_SX510_.jpg");
        htmlData.add("Hyperdiamond 3 Keystone,Nike,f,https://m.media-amazon.com/images/I/618j2jXfGOL._AC_SX510_.jpg");
        htmlData.add("Run All Day 2,Nike,f,https://m.media-amazon.com/images/I/81gWiIXobQL._AC_SX510_.jpg");
        htmlData.add("Quest 2,Nike,f,https://m.media-amazon.com/images/I/71+BUOybD-L._AC_SX510_.jpg");
        htmlData.add("Air Max Bella TR 3,Nike,f,https://m.media-amazon.com/images/I/81liEyJhLyL._AC_SX510_.jpg");
        htmlData.add("Air Max Oketo,Nike,f,https://m.media-amazon.com/images/I/71cmvBQzQoL._AC_SX510_.jpg");
        htmlData.add("Free Metcon 2,Nike,f,https://m.media-amazon.com/images/I/71l5I6fuVnL._AC_SX510_.jpg");
        htmlData.add("Vapor 13 Club FG/MG,Nike,f,https://m.media-amazon.com/images/I/71UmHxTae1L._AC_SX510_.jpg");
        htmlData.add("Legend 8 Academy TF,Nike,f,https://m.media-amazon.com/images/I/71AUcnyvmJL._AC_SX510_.jpg");
        htmlData.add("Court Air Zoom Zero HC,Nike,f,https://m.media-amazon.com/images/I/71llb9WSKdL._AC_SX510_.jpg");
        htmlData.add("Roshe One,Nike,f,https://m.media-amazon.com/images/I/81J81YOQ39L._AC_SX510_.jpg");
        htmlData.add("Tiempo Legend 8 Club FG/MG,Nike,f,https://m.media-amazon.com/images/I/71be9dJtiwL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Prestige,Nike,f,https://m.media-amazon.com/images/I/71BBqQ2soBL._AC_SX510_.jpg");
        htmlData.add("Court Lite 2,Nike,f,https://m.media-amazon.com/images/I/71yPQE78WXL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vomero 14,Nike,f,https://m.media-amazon.com/images/I/71T6tWcmr7L._AC_SX510_.jpg");
        htmlData.add("Downshifter 9,Nike,f,https://m.media-amazon.com/images/I/815N8ChbxxL._AC_SX510_.jpg");
        htmlData.add("Air Heights,Nike,f,https://m.media-amazon.com/images/I/71t5D2cPAwL._AC_SX510_.jpg");
        htmlData.add("Court Vision Mid,Nike,f,https://m.media-amazon.com/images/I/71lSugdI97L._AC_SX510_.jpg");
        htmlData.add("Tiempo Legend 8 Pro FG,Nike,f,https://m.media-amazon.com/images/I/71+l0yQCElL._AC_SX510_.jpg");
        htmlData.add("React Hyperset,Nike,f,https://m.media-amazon.com/images/I/71HLZW4JMyL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Vapor X,Nike,f,https://m.media-amazon.com/images/I/71E9ABbymHL._AC_SX510_.jpg");
        htmlData.add("Air Zoom Structure 22,Nike,f,https://m.media-amazon.com/images/I/71tvPgADMlL._AC_SX510_.jpg");
        htmlData.add("Phantom Venom Club FG,Nike,f,https://m.media-amazon.com/images/I/71zMDufCuTL._AC_SX510_.jpg");
        htmlData.add("Revolution 5,Nike,f,https://m.media-amazon.com/images/I/71i4BEPr8nL._AC_SX510_.jpg");
        htmlData.add("Suplerfly 7 Pro FG,Nike,f,https://m.media-amazon.com/images/I/711mxzqksaL._AC_SX510_.jpg");
        htmlData.add("Legend React 2,Nike,f,https://m.media-amazon.com/images/I/71FP+wiGyOL._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Precision II,Nike,f,https://m.media-amazon.com/images/I/71Uov6p6cuL._AC_SX510_.jpg");
        htmlData.add("Lunar Hyperdiamond 3 Pro,Nike,f,https://m.media-amazon.com/images/I/71rRqv8Pv2L._AC_SX510_.jpg");
        htmlData.add("Superfly 7 Academy TF,Nike,f,https://m.media-amazon.com/images/I/71K+3yAqcDL._AC_SX510_.jpg");
        htmlData.add("Acalme,Nike,f,https://m.media-amazon.com/images/I/712ZJtsprtL._AC_SX510_.jpg");
        htmlData.add("Court Vision Low,Nike,f,https://m.media-amazon.com/images/I/61hnp8czYKL._AC_SX510_.jpg");
        htmlData.add("Legend 8 Academy FG/MG,Nike,f,https://m.media-amazon.com/images/I/61ptXdQ2seL._AC_SX510_.jpg");
        htmlData.add("Renew Run,Nike,f,https://m.media-amazon.com/images/I/71rz4HveG9L._AC_SX510_.jpg");
        htmlData.add("Air Max Excee,Nike,f,https://m.media-amazon.com/images/I/71-cajIgshL._AC_SX510_.jpg");
        htmlData.add("Phantom VSN 2 Academy DF TF,Nike,f,https://m.media-amazon.com/images/I/71mvBvystKL._AC_SX510_.jpg");
        htmlData.add("Free RN 5.0 Shield,Nike,f,https://m.media-amazon.com/images/I/71G+pfugniL._AC_SX510_.jpg");
        htmlData.add("Tanjun,Nike,f,https://m.media-amazon.com/images/I/81vuhKgWvhL._AC_SX510_.jpg");
        htmlData.add("Sideline IV,Nike,f,https://m.media-amazon.com/images/I/71LvrTTwigL._AC_SX510_.jpg");
        htmlData.add("Legend 8 Pro TF,Nike,f,https://m.media-amazon.com/images/I/71+jOtLEXDL._AC_SX510_.jpg");
        htmlData.add("Phantom Venom Club TF,Nike,f,https://m.media-amazon.com/images/I/71Va9B4wSDL._AC_SX510_.jpg");
        htmlData.add("Odyssey React 2 Shield,Nike,f,https://m.media-amazon.com/images/I/71PrOLBZlRL._AC_SX510_.jpg");
        htmlData.add("Flare 2 HC,Nike,f,https://m.media-amazon.com/images/I/71bwxJBBm6L._AC_SX510_.jpg");
        htmlData.add("Zoom HyperAce 2,Nike,f,https://m.media-amazon.com/images/I/71U6E1JcQNL._AC_SX510_.jpg");
        htmlData.add("Premier II FG,Nike,f,https://m.media-amazon.com/images/I/711zkh6Ne2L._AC_SX510_.jpg");
        htmlData.add("FlyEase Air Zoom Pegasus 36,Nike,f,https://m.media-amazon.com/images/I/71sc3KnPaZL._AC_SX510_.jpg");
        htmlData.add("Legend React 2 Shield,Nike,f,https://m.media-amazon.com/images/I/71haAuu34oL._AC_SX510_.jpg");
        htmlData.add("Samba® Classic,adidas,m,https://zycada-amzn.zappos.com/images/I/71937OFgeHL._AC_SX510_.jpg");
        htmlData.add("GameCourt,adidas,m,https://zycada-amzn.zappos.com/images/I/71UAt1ynIkL._AC_SX510_.jpg");
        htmlData.add("Run The Game,adidas,m,https://zycada-amzn.zappos.com/images/I/71CgLLGdmlL._AC_SX510_.jpg");
        htmlData.add("Harden Stepback,adidas,m,https://zycada-amzn.zappos.com/images/I/71m5I9evvEL._AC_SX510_.jpg");
        htmlData.add("Powerlift 4,adidas,m,https://zycada-amzn.zappos.com/images/I/81hJv18sQBL._AC_SX510_.jpg");
        htmlData.add("SoleCourt,adidas,m,https://zycada-amzn.zappos.com/images/I/61oHskwSp-L._AC_SX510_.jpg");
        htmlData.add("CourtJam Bounce,adidas,m,https://zycada-amzn.zappos.com/images/I/71WkMUdYo9L._AC_SX510_.jpg");
        htmlData.add("Adizero Ubersonic 3,adidas,m,https://zycada-amzn.zappos.com/images/I/71W8FsOXu5L._AC_SX510_.jpg");
        htmlData.add("Copa Mundial,adidas,m,https://zycada-amzn.zappos.com/images/I/71D1gzYgU5L._AC_SX510_.jpg");
        htmlData.add("Runfalcon,adidas,m,https://zycada-amzn.zappos.com/images/I/71gWyeuvQ0L._AC_SX510_.jpg");
        htmlData.add("Predator 20.4 Tf,adidas,m,https://zycada-amzn.zappos.com/images/I/61U-6qnEQbL._AC_SX510_.jpg");
        htmlData.add("Pro Model 2G,adidas,m,https://zycada-amzn.zappos.com/images/I/71lsElghNeL._AC_SX510_.jpg");
        htmlData.add("Predator 20.4 Fxg,adidas,m,https://zycada-amzn.zappos.com/images/I/61f5wOotmvL._AC_SX510_.jpg");
        htmlData.add("Own The Game,adidas,m,https://zycada-amzn.zappos.com/images/I/71FjQr33AcL._AC_SX510_.jpg");
        htmlData.add("Mundial Goal,adidas,m,https://zycada-amzn.zappos.com/images/I/813klMTqBgL._AC_SX510_.jpg");
        htmlData.add("Predator 20.4 In Sala,adidas,m,https://zycada-amzn.zappos.com/images/I/71PmaKPCGbL._AC_SX510_.jpg");
        htmlData.add("Mundial Team,adidas,m,https://zycada-amzn.zappos.com/images/I/81Fm2NjatrL._AC_SX510_.jpg");
        htmlData.add("Stycon,adidas,m,https://zycada-amzn.zappos.com/images/I/81iSg0P+QvL._AC_SX510_.jpg");
        htmlData.add("Nemeziz 19.4 FxG,adidas,m,https://zycada-amzn.zappos.com/images/I/71mKlsjkpWL._AC_SX510_.jpg");
        htmlData.add("Afterburner 6 MD,adidas,m,https://zycada-amzn.zappos.com/images/I/71p-pCevK7L._AC_SX510_.jpg");
        htmlData.add("Predator 20.3 Fg,adidas,m,https://zycada-amzn.zappos.com/images/I/71EDvNRY4tL._AC_SX510_.jpg");
        htmlData.add("Nemeziz 19.4 IN,adidas,m,https://zycada-amzn.zappos.com/images/I/71fKe170iDL._AC_SX510_.jpg");
        htmlData.add("Copa 20.4 FG,adidas,m,https://zycada-amzn.zappos.com/images/I/71J1u3sCYBL._AC_SX510_.jpg");
        htmlData.add("Icon V Bounce TPU,adidas,m,https://zycada-amzn.zappos.com/images/I/71hKczPrqxL._AC_SX510_.jpg");
        htmlData.add("X 19.3 IN,adidas,m,https://zycada-amzn.zappos.com/images/I/81I6c-WeKgL._AC_SX510_.jpg");
        htmlData.add("Copa 20.4 IN,adidas,m,https://zycada-amzn.zappos.com/images/I/71zlOIpPBVL._AC_SX510_.jpg");
        htmlData.add("Speed Turf,adidas,m,https://zycada-amzn.zappos.com/images/I/71DcMZUh1aL._AC_SX510_.jpg");
        htmlData.add("Stycon Clay,adidas,m,https://zycada-amzn.zappos.com/images/I/71pzizbpwDL._AC_SX510_.jpg");
        htmlData.add("Copa 20.3 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71vday7cbFL._AC_SX510_.jpg");
        htmlData.add("Predator 19.4 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71JhKH1KzCL._AC_SX510_.jpg");
        htmlData.add("SoleMatch Bounce,adidas,m,https://zycada-amzn.zappos.com/images/I/71EMUVP47AL._AC_SX510_.jpg");
        htmlData.add("Goletto VII FG,adidas,m,https://zycada-amzn.zappos.com/images/I/717fJvTPOGL._AC_SX510_.jpg");
        htmlData.add("Nemeziz 19.3 IN,adidas,m,https://zycada-amzn.zappos.com/images/I/715TxsFDjKL._AC_SX510_.jpg");
        htmlData.add("Copa 20.3 IN Sala,adidas,m,https://zycada-amzn.zappos.com/images/I/71jCKQ67JhL._AC_SX510_.jpg");
        htmlData.add("Copa 20.3 FG,adidas,m,https://zycada-amzn.zappos.com/images/I/717O34qXU7L._AC_SX510_.jpg");
        htmlData.add("Predator 20.3 In,adidas,m,https://zycada-amzn.zappos.com/images/I/71KH2nyBSqL._AC_SX510_.jpg");
        htmlData.add("Stycon M,adidas,m,https://zycada-amzn.zappos.com/images/I/81+KvN2149L._AC_SX510_.jpg");
        htmlData.add("X 19.2 FG,adidas,m,https://zycada-amzn.zappos.com/images/I/71fn+SpyPrL._AC_SX510_.jpg");
        htmlData.add("Stabil Bounce,adidas,m,https://zycada-amzn.zappos.com/images/I/81ip5UK4ncL._AC_SX510_.jpg");
        htmlData.add("Predator 20.2 Fg,adidas,m,https://zycada-amzn.zappos.com/images/I/61mAuPUeQZL._AC_SX510_.jpg");
        htmlData.add("X 19.4 IN,adidas,m,https://zycada-amzn.zappos.com/images/I/61hWM-Um-DL._AC_SX510_.jpg");
        htmlData.add("X 19.4 FxG,adidas,m,https://zycada-amzn.zappos.com/images/I/71YzrIpmIvL._AC_SX510_.jpg");
        htmlData.add("Predator 19.2 FG,adidas,m,https://zycada-amzn.zappos.com/images/I/71U9708zIRL._AC_SX510_.jpg");
        htmlData.add("SoleMatch Bounce Clay,adidas,m,https://zycada-amzn.zappos.com/images/I/81EzYxVMLML._AC_SX510_.jpg");
        htmlData.add("Power Perfect III,adidas,m,https://zycada-amzn.zappos.com/images/I/71bkVmoQ0OL._AC_SX510_.jpg");
        htmlData.add("Predator 20.3 Tf,adidas,m,https://zycada-amzn.zappos.com/images/I/61HM+BThhKL._AC_SX510_.jpg");
        htmlData.add("Nemeziz 19.3 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/81ZVpGmCk3L._AC_SX510_.jpg");
        htmlData.add("Icon V Turf,adidas,m,https://zycada-amzn.zappos.com/images/I/81o4UoCrHbL._AC_SX510_.jpg");
        htmlData.add("Predator 19.3 FG,adidas,m,https://zycada-amzn.zappos.com/images/I/71Dg97Fw6LL._AC_SX510_.jpg");
        htmlData.add("Predator 19.3 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71IqmzXFrxL._AC_SX510_.jpg");
        htmlData.add("Afterburner 6,adidas,m,https://zycada-amzn.zappos.com/images/I/71tBEW9zPnL._AC_SX510_.jpg");
        htmlData.add("Copa 20.4 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71mMWb79xyL._AC_SX510_.jpg");
        htmlData.add("Nemeziz 19.4 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71pemmruX5L._AC_SX510_.jpg");
        htmlData.add("World Cup,adidas,m,https://zycada-amzn.zappos.com/images/I/71vJGUMxILL._AC_SX510_.jpg");
        htmlData.add("X 19.4 TF,adidas,m,https://zycada-amzn.zappos.com/images/I/71hjLFIyXdL._AC_SX510_.jpg");
        htmlData.add("Classic Slip-On™ Core Classics,Vans,m,https://m.media-amazon.com/images/I/71UxXJaKfHL._AC_SX510_.jpg");
        htmlData.add("Classic Slip-On™,Vans,m,https://m.media-amazon.com/images/I/812IaGl6tQL._AC_SX510_.jpg");
        htmlData.add("Classic Slip-On Platform,Vans,m,https://m.media-amazon.com/images/I/61GOMaVwQNL._AC_SX510_.jpg");
        htmlData.add("ComfyCush Slip-On,Vans,m,https://m.media-amazon.com/images/I/71CBjQCx2uL._AC_SX510_.jpg");
        htmlData.add("Slip-On Pro,Vans,m,https://m.media-amazon.com/images/I/716stsEaXAL._AC_SX510_.jpg");
        htmlData.add("Made For The Makers Classic Slip-On™ UC,Vans,m,https://m.media-amazon.com/images/I/71THtANOoAL._AC_SX510_.jpg");
        htmlData.add("Slip-On SF,Vans,m,https://m.media-amazon.com/images/I/71VOhHFqB7L._AC_SX510_.jpg");
        htmlData.add("Mule SF,Vans,m,https://m.media-amazon.com/images/I/71cY4W-dqeL._AC_SX510_.jpg");
        htmlData.add("UltraRange Gore,Vans,m,https://m.media-amazon.com/images/I/81SBadMlSjL._AC_SX510_.jpg");
        htmlData.add("Slip-On Platform ESP SF,Vans,m,https://m.media-amazon.com/images/I/81+8o568myL._AC_SX510_.jpg");
        htmlData.add("Authentic Knotted,Vans,m,https://m.media-amazon.com/images/I/71xJ7CMC0HL._AC_SX510_.jpg");
        htmlData.add("Slip-On Platform SF,Vans,m,https://m.media-amazon.com/images/I/7195UQj818L._AC_SX510_.jpg");
        htmlData.add("Era SF,Vans,m,https://m.media-amazon.com/images/I/71XgziQEsTL._AC_SX510_.jpg");
        htmlData.add("Vans x Autism Awareness Sneaker Collection,Vans,m,https://m.media-amazon.com/images/I/71-wttvkggL._AC_SX510_.jpg");
        htmlData.add("Slip-On EXP Pro,Vans,m,https://m.media-amazon.com/images/I/71CKrn-+YsL._AC_SX510_.jpg");
        htmlData.add("Vans x Breast Cancer Awareness Collab Sneaker Collection,Vans,m,https://m.media-amazon.com/images/I/71tXjef1sZL._AC_SX510_.jpg");
        htmlData.add("UltraRange 3D Chelsea Mid MTE,Vans,m,https://m.media-amazon.com/images/I/71tYkUDo06L._AC_SX510_.jpg");
        htmlData.add("UA Classic Slip-On,Vans,m,https://m.media-amazon.com/images/I/61UB3D0gWXL._AC_SX510_.jpg");
        htmlData.add("Old Skool™ Core Classics,Vans,m,https://m.media-amazon.com/images/I/71EVHA3Xz7L._AC_SX510_.jpg");
        htmlData.add("Authentic™ Core Classics,Vans,m,https://m.media-amazon.com/images/I/714yn5+oXGL._AC_SX510_.jpg");
        htmlData.add("Era™ Core Classics,Vans,m,https://m.media-amazon.com/images/I/71b8Cc6XRfL._AC_SX510_.jpg");
        htmlData.add("Old Skool™,Vans,m,https://m.media-amazon.com/images/I/81mSba9UEsL._AC_SX510_.jpg");
        htmlData.add("UltraRange™ EXO,Vans,f,https://zycada-amzn.zappos.com/images/I/71rTsrpcViL._AC_SX510_.jpg");
        htmlData.add("ComfyCush Era,Vans,f,https://zycada-amzn.zappos.com/images/I/71BDH+yA4NL._AC_SX510_.jpg");
        htmlData.add("Chima Pro 2,Vans,f,https://zycada-amzn.zappos.com/images/I/71qwWPoCvHL._AC_SX510_.jpg");
        htmlData.add("Rowan Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/815g+igYGpL._AC_SX510_.jpg");
        htmlData.add("Era 59,Vans,f,https://zycada-amzn.zappos.com/images/I/8161JH9FKiL._AC_SX510_.jpg");
        htmlData.add("Sk8-Hi™ Tapered,Vans,f,https://zycada-amzn.zappos.com/images/I/71n58bdOgYL._AC_SX510_.jpg");
        htmlData.add("Kyle Walker Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/71BcDmEoxjL._AC_SX510_.jpg");
        htmlData.add("Old Skool™,Vans,f,https://zycada-amzn.zappos.com/images/I/71ShDBzmkhL._AC_SX510_.jpg");
        htmlData.add("SK8-Hi™,Vans,f,https://zycada-amzn.zappos.com/images/I/81QddVD3VVL._AC_SX510_.jpg");
        htmlData.add("SK8-Hi™ Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/81U6uPmlu9L._AC_SX510_.jpg");
        htmlData.add("Authentic™,Vans,f,https://zycada-amzn.zappos.com/images/I/612pBcomgbL._AC_SX510_.jpg");
        htmlData.add("Chukka Low,Vans,f,https://zycada-amzn.zappos.com/images/I/717-TXBmBHL._AC_SX510_.jpg");
        htmlData.add("ComfyCush SK8-Hi,Vans,f,https://zycada-amzn.zappos.com/images/I/714oEDUsFKL._AC_SX510_.jpg");
        htmlData.add("ComfyCush Authentic,Vans,f,https://zycada-amzn.zappos.com/images/I/71YI936-+lL._AC_SX510_.jpg");
        htmlData.add("Authentic SF,Vans,f,https://zycada-amzn.zappos.com/images/I/71rL7K8BszL._AC_SX510_.jpg");
        htmlData.add("Era™,Vans,f,https://zycada-amzn.zappos.com/images/I/71VMDsNxYuL._AC_SX510_.jpg");
        htmlData.add("Sport,Vans,f,https://zycada-amzn.zappos.com/images/I/81gMZ13De6L._AC_SX510_.jpg");
        htmlData.add("Comfycush Old Skool,Vans,f,https://zycada-amzn.zappos.com/images/I/71++bnjBGTL._AC_SX510_.jpg");
        htmlData.add("Made For The Makers SK8-Hi™ Reissue UC,Vans,f,https://zycada-amzn.zappos.com/images/I/71vfDeja4lL._AC_SX510_.jpg");
        htmlData.add("Gilbert Crockett Pro 2,Vans,f,https://zycada-amzn.zappos.com/images/I/71GfHauZEUL._AC_SX510_.jpg");
        htmlData.add("Style 36,Vans,f,https://zycada-amzn.zappos.com/images/I/71ep66CnTdL._AC_SX510_.jpg");
        htmlData.add("UltraRange Rapidweld,Vans,f,https://zycada-amzn.zappos.com/images/I/71-ZvcJrgtL._AC_SX510_.jpg");
        htmlData.add("Ultrarange™ 3D,Vans,f,https://zycada-amzn.zappos.com/images/I/71I8AZz2fPL._AC_SX510_.jpg");
        htmlData.add("Ave Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/71PSOd3M+DL._AC_SX510_.jpg");
        htmlData.add("Authentic™ Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/71PG5iYVifL._AC_SX510_.jpg");
        htmlData.add("Vans x Autism Awareness Sneaker Collection,Vans,f,https://zycada-amzn.zappos.com/images/I/71Xuq-7jIKL._AC_SX510_.jpg");
        htmlData.add("SK8-Hi Platform 2.0,Vans,f,https://zycada-amzn.zappos.com/images/I/71IDeFLFBDL._AC_SX510_.jpg");
        htmlData.add("Old Skool Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/71Jm6yvH5-L._AC_SX510_.jpg");
        htmlData.add("Half Cab™ Core Classics,Vans,f,https://zycada-amzn.zappos.com/images/I/81KR0Ap8UhL._AC_SX510_.jpg");
        htmlData.add("Era Pro,Vans,f,https://zycada-amzn.zappos.com/images/I/71Tn5X-77SL._AC_SX510_.jpg");
        htmlData.add("Era™ TC,Vans,f,https://zycada-amzn.zappos.com/images/I/71zS+ZCdMsL._AC_SX510_.jpg");
        htmlData.add("SK8-Hi 138 Decon SF,Vans,f,https://zycada-amzn.zappos.com/images/I/81mKw1EGjqL._AC_SX510_.jpg");
        htmlData.add("ComfyCush Zushi SF,Vans,f,https://zycada-amzn.zappos.com/images/I/71GQHpXlHuL._AC_SX510_.jpg'htmlData.add(");

        for (String d : htmlData){
            String[] tokens = d.split(",");

            this.allShoeRepository.save(new ShoeNode(tokens[0], tokens[1], tokens[2], tokens[3]));

        }
    }

}
