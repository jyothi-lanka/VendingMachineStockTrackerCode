package com.project.lanka.code3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProvider {

    public static List<Product> productList = new ArrayList<>();
    public static Map<String, Product> productMap = new HashMap<>();
//    public static String selectview="gridview";

    public static void setProductData(String viewtype){
          if(viewtype.equalsIgnoreCase("gridview"))
          {
              productList.clear();
              productMap.clear();
              addProduct("sodalist", "Soft Drinks", "Coca-Cola is the most popular and biggest-selling soft drink in history, as well as one of the most recognizable brands in the world. Created in 1886 in Atlanta, Georgia, by Dr. John S. Pemberton, Coca-Cola was first offered as a fountain beverage at Jacob's Pharmacy by mixing Coca-Cola  syrup with carbonated water. Coca-Cola was patented in 1887, registered as a trademark in 1893 and by 1895 it was being sold in every state and territory in the United States. Coca-Cola is the most popular and biggest-selling soft drink in history, as well as one of the most recognizable brands in the world. Created in 1886 in Atlanta, Georgia, by Dr. John S. Pemberton, Coca-Cola was first offered as a fountain beverage at Jacob's Pharmacy by mixing Coca-Cola  syrup with carbonated water. Coca-Cola was patented in 1887, registered as a trademark in 1893 and by 1895 it was being sold in every state and territory in the United States.  ", 2.00);
              addProduct("chipslist","Chips", "Lay's is the brand name for a number of potato chip varieties as well as the name of the company that founded the chip brand in 1932. Lay's has been owned by PepsiCo since 1965. Other brands in the Frito-Lay group include Fritos, Doritos, Ruffles, Cheetos, Rold Gold pretzels, Munchos, Funyuns, and Sun Chips. ",1.00);
              addProduct("candylist","Chocolates", "Snickers is a brand name candy bar made by the American company Mars, Incorporated. Consisting of nougat topped with caramel and peanuts, enrobed in milk chocolate, Snickers has annual global sales of $2 billion. ",0.50);
              addProduct("drinkslist","Energy Drinks", "Minute Maid is a product line of beverages, usually associated with lemonade or orange juice, but now extends to soft drinks of many kinds, including Hi-C. Minute Maid is sold under Cappy brand in Central Europe and under Fruitopia in Norway ",1.50);
              addProduct("cocowater","Coco Water", "Coconut water ", 3.00);
              addProduct("brownie","Brownies", "brownie ", 4.00);
              addProduct("icetea","Iced Tea", "nestle tea ", 3.00);
              addProduct("cookies","Cookies", "cookies ", 4.00);

          }
          else if(viewtype.equalsIgnoreCase("sodalist")) {
              productList.clear();
              productMap.clear();
            addProduct("coke8", "Coca-Cola(8 Count, 12 Fl Oz Each)", "Pack of eight, 12 FL OZ per Plastic Bottle; Coca-Cola\n" +
                    "Coca-Cola is the most popular and biggest-selling soft drink in history, as well as the best-known brand in the world.\n" +
                    "Best served chilled at 37 degrees; 34mg caffeine per bottle\n" +
                    "Perfect size for drinking with meals, on the go, or any time\n" +
                    "Created in 1886 in Atlanta, Georgia, by Dr. John S. Pemberton, Coca-Cola was first offered as a fountain beverage at Jacob's Pharmacy by mixing Coca-Cola syrup with carbonated water.\n ", 4.18);
            addProduct("sprite24", "Sprite(6 Count, 12 Fl Oz Each)", "Pack of six, 12 FL OZ per plastic bottle\n" +
                    "Lemon-lime soda, 100% natural flavors\n" +
                    "Clean, crisp, fresh tasting and no caffeine\n" +
                    "Perfect size for drinking with meals, on the go, or any time\n" +
                    "What's in a Sprite,Its perfectly clear. Natural flavors and no caffeine", 4.69);
//            addProduct("dasani", "smartwater, 6 ct, 1L Bottle", "Pack of six, 1L per bottle of vapor distilled water with electrolytes added for taste\n" +
//                    "Pure and crisp like from a cloud\n" +
//                    "Perfect size for on-the-go hydration\n" +
//                    "smartwater is the first premium water in the country! ", 6.92);
              addProduct("water12","Dasani Water(8 Count, 12 Fl Oz Each) ","Pack of eight, 12 FL OZ per bottle\n" +
                      "Purified water enhanced with minerals for a pure, fresh taste.\n" +
                      "PlantBottle packaging is up to 30% made from plants\n" +
                      "100% recyclable plastic bottle\n" +
                      "DASANI has been designed to be a great tasting water. It is filtered by reverse osmosis to remove impurities, then enhanced with a special blend of minerals for the pure, crisp, fresh taste that's delightfully DASANI.",2.98);
              addProduct("dietcoke6", "Diet Coke(6 Count, 16 Fl Oz Each)", "Diet Coke 6 Pack deposit included 6 pk -16 oz. Diet Coke, is a sugar-free soft drink produced and distributed by The Coca-Cola Company. Unveiled on July 8, 1982 and introduced in the United States on August 9, it is the first new brand since 1886 to use the Coca-Cola trademark. ", 5.00);

          }
          else if(viewtype.equalsIgnoreCase("chipslist")) {
              productList.clear();
              productMap.clear();
              addProduct("lays", "Lays Potato Chips,1.125-Ounce Bags(Pack of 64) ", "Lay's is the brand name for a number of potato chip varieties as well as the name of the company that founded the chip brand in 1932. Lay's has been owned by PepsiCo since 1965. Other brands in the Frito-Lay group include Fritos, Doritos, Ruffles, Cheetos, Rold Gold pretzels, Munchos, Funyuns, and Sun Chips. ", 10.00);
              addProduct("bakedlays", "Lays Baked Potato Crisps, 1.125-Ounce Bags (Pack of 64)", "Frito-lays line of oven baked chips are baked and not fried to give you the great taste you’ve come to love with frito-lays snacks. On top of that, oven baked snacks offer less fat than regular potato chips and cheese flavored snacks. ", 12.50);
              addProduct("bluedoritos", "Doritos Tortilla Chips, Cool Ranch, 1.1-Ounce Bags (Pack of 64)", "Tortilla chips flavored with the cool taste of ranch\n" +
                      "Packaged in a convenient take-home bag\n" +
                      "No gluten ingredients\n" +
                      "11 Ounce Bag of Chips", 10.50);
              addProduct("reddoritos", "Doritos Tortilla Chips, Nacho Cheese, 1.75-Ounce Bags (Pack of 64) ", "Pack of 64, 1.75-ounce large single-serving bags (total of 112 ounces)\n" +
                      "Doritos tortilla chips with classic nacho-cheese flavor\n" +
                      "Made of whole corn; flavorings feature real cheddar cheese\n" +
                      "Crunchy straight from the bag or after scooping up dip or salsa\n" +
                      "Ships in Certified Frustration-Free Packaging ", 11.50);


          } else if (viewtype.equalsIgnoreCase("candylist")) {
              productList.clear();
              productMap.clear();
              addProduct("mars", "Mars 2 Oz(Pack of 44)", "Mars (also Mars bar) is a British chocolate bar. It was first manufactured in 1932 in Slough, Berkshire in the United Kingdom and was advertised to the trade as being made with \"couverture\" chocolate.  ", 2.00);
              addProduct("milkyway", "Milkyway 1.5 Oz(Pack of 24)", "Milkyway: Created in 1923 and designed to capture the taste of malted milk shakes, MILKY WAY® was named after a famed malted milk drink of the day, not the Milky Way galaxy. ", 1.00);
              addProduct("mnm", "MnM 1.5 Oz(Pack of 24)", "M&M'S® have been one of the most famous candy treats in the world since 1941. The snack-sized pieces of chocolate in a colorful candy shell are instantly recognizable all over the globe. M&M'S® are available in Milk Chocolate, Peanut, Dark Chocolate, Dark Chocolate Peanut, Almond, Peanut Butter, Pretzel and Coconut. ", 20.50);
              addProduct("reeses", "Reeses 1.5 Oz(Pack of 24)", "Reese's Peanut Butter Cups are a milk chocolate cup confection made of chocolate-coated peanut butter marketed by The Hershey Company that pioneered the way to the generic peanut butter cup. ", 19.50);
              addProduct("butterfinger", " Butterfinger 1.5 Oz(Pack of 24)", "Butterfinger is a candy bar created in 1923 in Chicago, Illinois by Otto Schnering, which currently is manufactured by Nestlé. The bar consists of a flaky, crisp, peanut butter-flavored center covered with caramel compound chocolate and toffee. ", 16.50);
              addProduct("snickers", "Snickers 2 Oz(Pack of 24)", "The world's best-selling candy bar. Crammed with peanuts, caramel and nougat then coated with milk chocolate, SNICKERS® quickly became one of the planet's favorite treats after its introduction in 1930. ", 11.50);

          }
          else if(viewtype.equalsIgnoreCase("drinkslist")) {
              productList.clear();
              productMap.clear();
              addProduct("fullthrottle", "Fullthrottle 500ml tin(Pack of 10)", "Full Throttle is the hardest working energy drink on the block. Feel the energy at work with Full Throttle. Full Throttle is an energy drink brand produced by Monster Energy. It debuted in late 2004 in the United States and Canada under its former owner The Coca-Cola Company.  ", 22.00);
              addProduct("redbull", "Redbull 500ml tin(Pack of 12)", "Red Bull is an energy drink sold by Austrian company Red Bull GmbH, created in 1987. In terms of market share, Red Bull is the highest-selling energy drink in the world, with 5.387 billion cans sold in 2013. Red Bull contains caffeine, taurine, B vitamins (B3, B5, B6, B12), sucrose, and glucose. ", 14.00);
              addProduct("rockstar", "Rockstar 500ml tin(Pack of 8)", "Rockstar (branded ROCKST★R) is an Energy Drink created in 2001. it claimed were \"scientifically formulated to speed the recovery time of those who lead active and exhausting lifestyles—from athletes to rock stars. ", 20.50);
              addProduct("monster", "Monster 500ml tin(Pack of 14)", "Monster Energy is an energy drink introduced by Hansen Natural Corp. (HANS) in April 2002. The caffeine content of most Monster Energy drinks is approximately 10 mg/oz (33.81 mg/100ml), or 160 mg for a 16 oz can. ", 31.50);
          }
    }
    private static void addProduct(String itemId, String name,
                                   String description, double price) {
        Product item = new Product(itemId, name, description, price);
        productList.add(item);
        productMap.put(itemId, item);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(product.getName());
        }
        return list;
    }

    public static List<Product> getFilteredList(String searchString) {

        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductId().contains(searchString)) {
                filteredList.add(product);
            }
        }

        return filteredList;

    }

}
