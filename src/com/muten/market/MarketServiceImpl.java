package com.muten.market;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarketServiceImpl implements MarketService {

    private static Member loginMember = null;
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Member> memberList = new ArrayList<>();
    private static final Queue<String> q = new LinkedList<>();
    private static final Set<String> set = new HashSet<>();

    private static final String regex = "^[a-z]{1}[a-z0-9]{3,11}$";

    @Override
    public void init() {
        System.out.println("***** MUTEN Market *****");
        if (loginMember == null) {
            System.out.flush();
            System.out.print("[1] Sign In\n[2] Login\n[0] EXIT\n>> ");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    signIn();
                    break;
                case "2":
                    login();
                    break;
                case "0":
                    System.exit(0);
            }
        } else {
            System.out.flush();
            System.out.print("[1] My Info\n[2] Add Cart List\n[3] Show Cart List\n[4] Logout\n>> ");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    myInfo();
                    break;
                case "2":
                    addCart();
                    break;
                case "3":
                    cartList();
                    break;
                case "4":
                    loginMember = null;
                    break;
            }
        }
    }

    @Override
    public void signIn() {
        System.out.print("userName: ");
        String name = sc.nextLine();
        String id = name + "@gmail.com";
        if (findById(id) != null) {
            System.out.println("이미 존재하는 아이디입니다.");
            signIn();
        } else if (!matches(regex, name)) {
            System.out.println("아이디는 4~12자 사이의 영문으로 시작하는 영문과 숫자의 조합이어야 합니다.");
            signIn();
        } else {
            System.out.println("사용 가능한 아이디입니다.");
            System.out.print("Password: ");
            String pwd = sc.nextLine();
            String nid = name + "@gmail.com";
            Member member = new Member(nid, pwd);
            memberList.add(member);
            System.out.println(member.getMemberId() + "(" + member.getUserName() + ")가 생성되었습니다.");
        }
    }

    @Override
    public void login() {
        System.out.print("userName: ");
        String id = sc.next();
        System.out.print("password: ");
        String pwd = sc.next();
        String loginId = id + "@gmail.com";

        if (findById(loginId) == null) {
            System.out.println("존재하지 않는 아이디입니다.");
        } else {
            if (findById(loginId).getPassword().equals(pwd)) {
                loginMember = findById(loginId);
                System.out.println(loginMember + "님, 환영합니다.");
            } else {
                System.out.println("비밀번호를 확인해주세요.");
            }
        }
    }

    @Override
    public void logout() {
        loginMember = null;
        set.clear();
    }

    @Override
    public void addCart() {
        System.out.print("Shopping List >> ");
        String shopList = sc.next();
//        q.offer(shopList);
        set.add(shopList);
    }

    @Override
    public void cartList() {
        if (set.size() == 0) {
            System.out.println("카트가 비었습니다.");
        } else {
            System.out.println(set);
        }
//        for (int i = 0; i < q.size(); i++) {
//            System.out.println(q.peek());
//        }
//        while(!q.isEmpty()) {
//        }
    }

    @Override
    public void myInfo() {
        System.out.println(loginMember.toString());
    }

    @Override
    public boolean matches(String regex, CharSequence input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

    @Override
    public Member findById(String id) {
        for (Member i : memberList) {
            if (i.getUserName().equals(id)) {
                return i;
            }
        }
        return null;
    }
}
