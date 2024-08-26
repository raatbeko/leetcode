package leetcode.medium;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("twbiqwtafgjbtolwprpdnymaatlbuacrmzzwhkpvuwdtyfjsbsqxrlxxtqkjlpkvpxmlajdmnyepsmczmmfdtjfbyybotpoebilayqzvqztqgddpcgpelwmriwmoeeilpetbxoyktizwcqeeivzgxacuotnlzutdowiudwuqnghjgoeyojikjhlmcsrctvnahnoapmkcrqmwixpbtirkasbyajenknuccojooxfwdeflmxoueasvuovcayisflogtpxtbvcxfmydjupwihnxlpuxxcclbhvutvvshcaikuedhyuksbwwjsnssizoedjkbybwndxpkwcdxaexagazztuiuxphxcedqstahmevkwlayktrubjypzpaiwexkwbxcrqhkpqevhxbyipkmlqmmmogrnexsztsbkvebjgybrolttvnidnntpgvsawgaobycfaaviljsvyuaanguhohsepbthgjyqkicyaxkytshqmtxhilcjxdpcbmvnpippdrpggyohwyswuydyrhczlxyyzregpvxyfwpzvmjuukswcgpenygmnfwdlryobeginxwqjhxtmbpnccwdaylhvtkgjpeyydkxcqarkwvrmwbxeetmhyoudfuuwxcviabkqyhrvxbjmqcqgjjepmalyppymatylhdrazxytixtwwqqqlrcusxyxzymrnryyernrxbgrphsioxrxhmxwzsytmhnosnrpwtphaunprdtbpwapgjjqcnykgspjsxslxztfsuflijbeebwyyowjzpsbjcdabxmxhtweppffglvhfloprfavduzbgkw"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1 || isPalindrome(s)) {
            return s;
        }

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i);
            for (int i1 = s1.length(); i1 > 0; i1--) {
                String sub = s1.substring(0, i1);
                if (isPalindrome(sub)) {
                    if (sub.length() > longest.length())
                        longest = sub;
                }
            }
        }
        return longest.length() != 0 ? longest : "";
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
