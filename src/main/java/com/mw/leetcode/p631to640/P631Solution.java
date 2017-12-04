package com.mw.leetcode.p631to640;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P631Solution
{
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int result = Integer.MAX_VALUE;
        //apply each offer to the needs, and recurse
        for(int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            boolean invalidOffer = false;
            int offerCount = Integer.MAX_VALUE; // number of times offer can be applied
            for(int j = 0; j < needs.size(); j++) { // pre-compute number of times offer can be called
                int remain = needs.get(j) - offer.get(j);
                if(!invalidOffer && remain < 0) invalidOffer = true; // if offer has more items than needs
                if(offer.get(j) > 0)
                offerCount = Math.min(offerCount, needs.get(j)/offer.get(j));
            }
            for(int j = 0; j < needs.size(); j++) { // subtract offer items from needs
                int remain = needs.get(j) - offer.get(j) * offerCount;
                needs.set(j, remain);
            }
            if(!invalidOffer) { //if valid offer, add offer price and recurse remaining needs
                result = Math.min(result, shoppingOffers(price, special, needs) + (offerCount * offer.get(needs.size())));
            }

            for(int j = 0; j < needs.size(); j++) { // reset the needs
                int remain = needs.get(j) + offer.get(j) * offerCount;
                needs.set(j, remain);
            }
        }

        // choose b/w offer and non offer
        int nonOfferPrice = 0;
        for(int i = 0; i < needs.size(); i++) {
            nonOfferPrice += price.get(i) * needs.get(i);
        }
        return Math.min(result, nonOfferPrice);
    }

    public static void main(String[] args)
    {
//        List<Integer> price = Arrays.asList(2, 4);
//        List<List<Integer>> special = new ArrayList<>();
//        special.add(Arrays.asList(3, 0, 5));
//        special.add(Arrays.asList(1, 2, 10));
//        List<Integer> needs = Arrays.asList(3, 2);

        List<Integer> price = Arrays.asList(9, 9);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 1, 1));
        List<Integer> needs = Arrays.asList(2, 2);
        P631Solution solution = new P631Solution();
        int value = solution.shoppingOffers(price, special, needs);
        System.out.println(value);
    }
}
