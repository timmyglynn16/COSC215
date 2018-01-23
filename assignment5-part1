// output should read:
// java TwoKey
// 5
// 7
// (Bob,7)(Joe,3)(Sam,2)(Wilma,5)
// (1,2)(2,3)(3,5)(4,7)
// (Bob,7)(Joe,13)(Pebbles,5)(Sam,17)
// (1,17)(2,13)(3,5)(5,7)

public class TwoKeyMain {
	
    public static void main(String[] args) {
        TwoKeyMethods<String, Integer, Integer> db = new TwoKeyMethods();
        db.add("Sam", 1, 2);
        db.add("Joe", 2, 3);
        db.add("Wilma", 3, 5);
        db.add("Bob", 4, 7);
        System.out.println(db.find1("Wilma"));
        System.out.println(db.find2(4));
        System.out.println(db.list1());
        System.out.println(db.list2());
        db.modify1("Sam", 11);
        db.modify1("Joe", 13);
        db.modify2(1, 17);
        db.change1("Bob", 5);
        db.change2(3, "Pebbles");
        System.out.println(db.list1());
        System.out.println(db.list2());
}

}
