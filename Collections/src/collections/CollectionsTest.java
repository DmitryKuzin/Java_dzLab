package collections;

import orders.Customer;
import orders.Good;
import orders.Order;

import java.util.*;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:09:34
 */
public class CollectionsTest {

    public static void main(String[] args) {
//        testLists();

//        testSets();

//        testMaps();

        testCompare();
    }


    private static void testLists() {
        System.out.println("***ArrayList creation***");
        List list = new ArrayList();
        list.add("Some Object");
        list.add(new Date());
        list.add(1);
        System.out.println(list.size());
        for (Object o : list) {
            String s = o.toString();
            System.out.println(s);
        }

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(4L, "Order 4"));
        orderList.add(new Order(3L, "Order 3"));
        orderList.add(new Order(1L, "Order 1"));
        orderList.add(new Order(2L, "Order 2"));
        orderList.add(new Order(5L, "Order 5"));

        System.out.println("***Orders list***");
        for (Order order : orderList) {
            System.out.println(order.getId() + " " + order.getName());
        }

        System.out.println("***ArrayList contains method***");
        boolean contains = orderList.contains(new Order(1L, "Order 7"));
        System.out.println(contains);

        System.out.println("***ArrayList indexOf method***");
        int index = orderList.indexOf(new Order(1L, "Order 1"));
        System.out.println(index);

        System.out.println("***ArrayList remove method***");
        orderList.remove(new Order(1L, "Order 1"));
        for (Order order : orderList) {
            System.out.println(order.getId() + " " + order.getName());
        }
    }

    private static void testSets() {
        System.out.println("***HashSet creation***");
        Set<Order> orderSet = new HashSet<>();
        orderSet.add(new Order(4L, "Order 4"));
        orderSet.add(new Order(3L, "Order 3"));
        orderSet.add(new Order(1L, "Order 1"));
        orderSet.add(new Order(2L, "Order 2"));
        orderSet.add(new Order(5L, "Order 7"));
        orderSet.add(new Order(5L, "Order 5"));
        orderSet.add(new Order(5L, "Order 7"));

        for (Order order : orderSet) {
            System.out.println(order.getId() + " " + order.getName());
        }

        System.out.println("***LinkedHashSet creation***");
        Set<Order> orderLinkedHashSet = new LinkedHashSet<>();
        orderLinkedHashSet.add(new Order(4L, "Order 4"));
        orderLinkedHashSet.add(new Order(3L, "Order 3"));
        orderLinkedHashSet.add(new Order(1L, "Order 1"));
        orderLinkedHashSet.add(new Order(2L, "Order 2"));
        orderLinkedHashSet.add(new Order(5L, "Order 5"));
        orderLinkedHashSet.add(new Order(5L, "Order 5"));
        orderLinkedHashSet.add(new Order(5L, "Order 5"));

        for (Order order : orderLinkedHashSet) {
            System.out.println(order.getId() + " " + order.getName());
        }
    }

    private static void testMaps() {
        System.out.println("***HashMap creation***");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Some key 1", "Some value 1");
        hashMap.put("Some key 2", "Some value 2");
        hashMap.put("Some key 3", "Some value 3");
        hashMap.put("Some key 3", "Some value 45");

        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            String value = hashMap.get(key);
            System.out.println(key + " " + value);
        }

        System.out.println("***HashMap creation***");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Some key 1", "Some value 1");
        linkedHashMap.put("Some key 2", "Some value 2");
        linkedHashMap.put("Some key 3", "Some value 3");
        linkedHashMap.put("Some key 3", "Some value 3");

        Set<String> linkedKeys = linkedHashMap.keySet();
        for (String key : linkedKeys) {
            String value = linkedHashMap.get(key);
            System.out.println(key + " " + value);
        }
    }

    private static void testCompare() {
        System.out.println("***TreeSet***");
        Set<Customer> customers = new TreeSet<>();
        customers.add(new Customer(10L, "Customer 10", null, null));
        customers.add(new Customer(20L, "Customer 20", null, null));
        customers.add(new Customer(1L, "Customer 1", null, null));
        customers.add(new Customer(5L, "Customer 5", null, null));

        for (Customer customer : customers) {
            System.out.println(customer.getId());
        }

        System.out.println("***TreeMap***");
        Map<Integer, String> map = new TreeMap<>();
        map.put(10, "October");
        map.put(5, "May");
        map.put(1, "January");
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            String value = map.get(key);
            System.out.println(value);
        }

        System.out.println("***List***");
        List<Good> goods = new ArrayList<>();
        goods.add(new Good(1L, "Name1", 200L));
        goods.add(new Good(2L, "Name2", 500L));
        goods.add(new Good(3L, "Name3", 100L));

        Collections.sort(goods, new Comparator<Good>() {

            public int compare(Good o1, Good o2) {
                if(o1.getPrice()==o2.getPrice()){
                    return o1.getName().compareTo(o2.getName());
                }else{
                    return (int) ((int)o1.getPrice()-o2.getPrice());
                }
            }
        });

        Collections.reverse(goods);

        for (Good good : goods) {
            System.out.println(good.getName());
        }
    }
}
