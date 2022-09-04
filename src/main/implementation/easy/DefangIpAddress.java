package main.implementation.easy;

public class DefangIpAddress {
    public static void main(String[] args) {
        DefangIpAddress defangIpAddress = new DefangIpAddress();
        String result = defangIpAddress.defangIPaddr("1.1.1.1");
        System.out.println("======="+ result);
    }

    public String defangIPaddr(String address) {
        String result = "";
        for(int i=0; i < address.length(); i++){
            if(address.charAt(i) == '.'){
                result += "[.]";
            } else {
                result += String.valueOf(address.charAt(i));
            }
        }
        return result;
    }
}
