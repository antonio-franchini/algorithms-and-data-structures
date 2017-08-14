public class StringUtility {
    public boolean contains(String container, String contenee){
        int[] foundCount = new int[contenee.length()];
        int matches = 0;
        for(int i = 0; i < container.length(); i++){
            for(int j = 0; j < contenee.length(); j++){
                if(container.charAt(i) == contenee.charAt(j)){
                    foundCount[j]++;
                }
            }
        }

        for(int i = 0; i< foundCount.length; i++){
            if(foundCount[i] > 0){
                matches++;
            }
        }

        return (matches >= contenee.length());
    }
}
