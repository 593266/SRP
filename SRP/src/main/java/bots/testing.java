package bots;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import java.util.*;

public class testing {

    public static void main(String[] args) {
        List<String> airportsFlyr = new ArrayList<>();
        airportsFlyr.add("OSL"); //Oslo
        airportsFlyr.add("BGO"); //Bergen
        airportsFlyr.add("BOO"); //Bodø
        airportsFlyr.add("EVE"); //Harstad Narvik
        airportsFlyr.add("KSU"); //Kristiansund
        airportsFlyr.add("SVG"); //Stavanger
        airportsFlyr.add("TOS"); //Tromsø
        airportsFlyr.add("TRD"); //Trondheim

        System.out.println(Arrays.toString(airportsFlyr.toArray()));
        List<String> connections = new ArrayList<>();

        for (String avgang : airportsFlyr) {
            for (String ankomst : airportsFlyr) {

                connections.add(avgang + "-" + ankomst);
            }
        }
        System.out.println(Arrays.toString(connections.toArray()));

        //TODO Sjekk hvilken som er raskere etter å ha skalert
        //TODO LAG DATABASE
        HashMap<String,Integer> specificDepartures = new HashMap<>();
        specificDepartures.put("12:00", 1000);
        specificDepartures.put("13:00", 800);
        Table<String, String, HashMap<String,Integer>> allFlights = HashBasedTable.create();
        allFlights.put("OSL-BGO", "2022-07-01", specificDepartures);
        System.out.println(allFlights);

        Map<ImmutableList<String>, HashMap<String,Integer>> listKeyMap = Maps.newHashMap();
        listKeyMap.put(ImmutableList.of("OSL-BGO", "2022-07-01"), specificDepartures);
        System.out.println(listKeyMap);

    }
}
